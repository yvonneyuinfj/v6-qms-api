package avicit.myportal.qms.qmsauditplan.service;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.exception.DaoException;
import avicit.platform6.core.domain.VueNode;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.commons.utils.ComUtil;
import avicit.platform6.commons.utils.PojoUtil;
import avicit.platform6.commons.utils.BusinessUtil;
import org.apache.commons.lang3.StringUtils;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.platform6.api.system.OssClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import avicit.myportal.qms.qmsauditplan.dao.QmsAuditPlanDAO;
import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanDTO;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:28
 * @类说明：年度内审计划及执行主表Service
 * @修改记录：
 */
@Service
public class QmsAuditPlanService {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditPlanService.class);

	@Autowired
	private QmsAuditPlanDAO qmsAuditPlanDAO;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private OssClient ossClient;

	private static final int ID_LIMIT = 500;

	/**
	 * 按照父id查询数据
	 * @param parentId    父节点ID
	 * @param level       树等级
	 * @param orgIdentity 组织id
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> getQmsAuditPlanTreeGridByParentId(String parentId, int level, String orgIdentity) {
        List<QmsAuditPlanDTO> dtoList = new ArrayList<>();
        if(!"-1".equals(parentId)){
            dtoList = qmsAuditPlanDAO.findChildrenQmsAuditPlanById(parentId, orgIdentity);
            valueConvertTreeNodes(dtoList);
        }else{
            dtoList = getQmsAuditPlanTreeGridByTreeLevel(level, orgIdentity);
            if(dtoList.size() == 0){
                QmsAuditPlanDTO rootNode = insertRoot();
                dtoList.add(rootNode);
            }
        }
        return dtoList;
	}

    /**
     * 树层级查询
     * @param level       树等级
     * @param orgIdentity 组织id
     * @return List<QmsAuditPlanDTO>
     */
    private List<QmsAuditPlanDTO> getQmsAuditPlanTreeGridByTreeLevel(int level, String orgIdentity) {
        //treeGrid存在多个根节点，所以默认不展示parentId是-1的根，查询层级默认加1
        level += 1;
        List<QmsAuditPlanDTO> allNodes = qmsAuditPlanDAO.findQmsAuditPlanTreeGridByTreeLevel(level, orgIdentity);
        return createTreeGridData(allNodes);
    }

    /**
     * 按照父id查询数据
     * @param parentId    父节点ID
     * @param level       树等级
     * @param orgIdentity 组织id
     * @return List<VueNode>
     */
    public List<VueNode> getQmsAuditPlanByParentIdForTreeSelect(String parentId, int level, String orgIdentity) {
        List<QmsAuditPlanDTO> dtoList = getQmsAuditPlanTreeGridByParentId(parentId,level, orgIdentity);
        List<VueNode> vueNodeList = transToTreeNodeData(dtoList);
        return vueNodeList;
    }

	/**
	 * 展开至指定节点
	 * @param id 主键id
	 * @param orgIdentity 组织id
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> expandTreeToNode(String id, String orgIdentity) {
		List<QmsAuditPlanDTO> tree = new ArrayList<>();
		QmsAuditPlanDTO dto = qmsAuditPlanDAO.findQmsAuditPlanById(id);
		Long level = dto.getTreeLevel();
		String[] ids = dto.getTreePath().split("/");
		if (ids != null && ids.length > 0) {
			QmsAuditPlanDTO rootNode = qmsAuditPlanDAO.findQmsAuditPlanById(ids[0]);
			QmsAuditPlanDTO parentNode = rootNode;
			for (int i = 0; i < level; i++) {
				List<QmsAuditPlanDTO> childNodes = qmsAuditPlanDAO.findChildrenQmsAuditPlanById(ids[i], orgIdentity);
				parentNode.setChildren(childNodes);
				valueConvert(Arrays.asList(parentNode));
				for (QmsAuditPlanDTO node: childNodes) {
					valueConvert(Arrays.asList(node));
				}
				if (i < level - 1) {
					for (QmsAuditPlanDTO node: childNodes) {
						if (node.getId().equals(ids[i + 1])) {
							parentNode = node;
							break;
						}
					}
				}
			}
			tree.add(rootNode);
		}
		return tree;
	}

	/**
	 * 查询数据
	 * @param queryReqBean  查询条件
	 * @param orgIdentity   组织id
	 * @return List<QmsAuditPlanDTO>
	 */
	@Transactional(readOnly = true)
	public List<QmsAuditPlanDTO> searchQmsAuditPlanTreeGrid(QueryReqBean<QmsAuditPlanDTO> queryReqBean, String orgIdentity) {
		List<QmsAuditPlanDTO> tree = new ArrayList<>();
		QmsAuditPlanDTO queryParams = queryReqBean.getSearchParams();
        String keywords = queryReqBean.getKeyWord();
		queryParams.setOrgIdentity(orgIdentity);
		List<QmsAuditPlanDTO> searchNodes = qmsAuditPlanDAO.searchQmsAuditPlan(queryParams, keywords, orgIdentity);
		if (!CollectionUtils.isEmpty(searchNodes)){
			Set<String> treeIdSet = reDuplicationByTreePath(searchNodes);
			int i = 0;
			//考虑mybatis foreach的限制，所以定义参数格式为list内还是list
			List<List<String>> idsList = new ArrayList<List<String>>();
			List<String> idList = new ArrayList<String>();
			for (String treeId : treeIdSet) {
				//当id个数超出限制后，则新new一个list来存放
				if(i % ID_LIMIT == 0 && i > 0){
					idsList.add(idList);
					idList = new ArrayList<String>();
				}
				idList.add(treeId);
				i++;
			}
			idsList.add(idList);
			List<QmsAuditPlanDTO> allNodes = qmsAuditPlanDAO.searchQmsAuditPlanByIds(idsList);
			tree = createTreeGridData(allNodes);
            valueConvertTreeNodes(tree);
		}
		return tree;
	}

    /**
     * 查询树节点
     * @param text    查询条件
     * @param orgIdentity 组织id
     * @return List<ZTreeNode>
     */
    @Transactional(readOnly = true)
    public List<VueNode> searchQmsAuditPlan(String text, String orgIdentity) {
        List<VueNode> tree = new ArrayList<>();
        QmsAuditPlanDTO queryParams = new QmsAuditPlanDTO();
        queryParams.setPlanName(text);
        queryParams.setOrgIdentity(orgIdentity);
        List<QmsAuditPlanDTO> searchNodes = qmsAuditPlanDAO.searchQmsAuditPlan(queryParams, "", orgIdentity);
        if (!CollectionUtils.isEmpty(searchNodes)){
            Set<String> treeIdSet = reDuplicationByTreePath(searchNodes);
            int i = 0;
            //考虑mybatis foreach的限制，所以定义参数格式为list内还是list
            List<List<String>> idsList = new ArrayList<List<String>>();
            List<String> idList = new ArrayList<String>();
            for (String treeId : treeIdSet) {
                //当id个数超出限制后，则新new一个list来存放
                if(i % ID_LIMIT == 0 && i > 0){
                    idsList.add(idList);
                    idList = new ArrayList<String>();
                }
                idList.add(treeId);
                i++;
            }
            idsList.add(idList);
            List<QmsAuditPlanDTO> allNodes = qmsAuditPlanDAO.searchQmsAuditPlanByIds(idsList);
            tree = createTreeData(allNodes);
        }
        return tree;
    }

    /**
     *  组建树形结构
     * @param entityNodes 节点集合
     * @return List<VueNode>
     */
    private List<VueNode> createTreeData(List<QmsAuditPlanDTO> entityNodes) {
        List<VueNode> list = transToTreeNodeData(entityNodes);
        List<VueNode> tree = new ArrayList<>();
        for (VueNode vueNode : list) {
            //找到根节点
            if ("-1".equals(vueNode.getParentId())) {
                tree.add(vueNode);
            }
            List<VueNode> children = new ArrayList<>();
            //再次遍历list，找到子节点
            for (VueNode node : list) {
                if (vueNode.getId().equals(node.getParentId())) {
                    children.add(node);
                }
            }
            if(!children.isEmpty()){
                vueNode.setChildren(children);
            }
        }
        return tree;
    }

    /**
     * 初始化根节点
     * @return
     */
    private QmsAuditPlanDTO insertRoot() {
        QmsAuditPlanDTO tree = new QmsAuditPlanDTO();
        tree.setParentId("-1");
        tree.setOrgIdentity(ThreadContextHelper.getOrgId());
        tree.setPlanName("根节点");
        tree.setSecretLevel("1");
        tree.setTreePath("-1");
        tree.setTreeSort(1L);
        insertQmsAuditPlanTree(tree);
        valueConvert(Arrays.asList(tree));
        return tree;
    }

	/**
	 *  组建TreeGrid数据结构
	 * @param list 节点集合
	 * @return List<QmsAuditPlanDTO>
	 */
	private List<QmsAuditPlanDTO> createTreeGridData(List<QmsAuditPlanDTO> list) {
		List<QmsAuditPlanDTO> tree = new ArrayList<>();
		for (QmsAuditPlanDTO dto : list) {
			valueConvert(Arrays.asList(dto));
			//找到根节点
			if ("-1".equals(dto.getParentId())) {
				tree.add(dto);
			}
			List<QmsAuditPlanDTO> children = new ArrayList<>();
			//再次遍历list，找到子节点
			for (QmsAuditPlanDTO childrenDto : list) {
				if (childrenDto.getParentId().equals(dto.getId())) {
					children.add(childrenDto);
				}
			}
			if(!children.isEmpty()){
                dto.setChildren(children);
            }
		}
		return tree;
	}

    /**
     *  将实体类集合转化成VueNode格式
     * @param entityNodes  实体类节点集合
     * @return List<VueNode>
     */
    private List<VueNode> transToTreeNodeData(List<QmsAuditPlanDTO> entityNodes) {
        List<VueNode> vueNodes = new ArrayList<>();
        for (QmsAuditPlanDTO entityNode : entityNodes) {
            VueNode vueNode = transToTreeNodeData(entityNode);
            vueNodes.add(vueNode);
        }
        return vueNodes;
    }

    /**
     *  将实体类转化成VueNode格式
     * @param entityNode  实体类节点集合
     * @return List<VueNode>
     */
    private VueNode transToTreeNodeData(QmsAuditPlanDTO entityNode) {
        VueNode vueNode = new VueNode();
        vueNode.setId(entityNode.getId());
        vueNode.setKey(entityNode.getId());
        vueNode.setTitle(entityNode.getPlanName() == null ? "" : entityNode.getPlanName());
        vueNode.setSelectable(true);
        vueNode.setDisabled(false);
        vueNode.setDisableCheckbox(false);
        vueNode.setParentId(entityNode.getParentId());
        HashMap<String,Object> attr = new HashMap<>();
        attr.put("treeLeaf", entityNode.getTreeLeaf());
        attr.put("treeLevel", entityNode.getTreeLevel());
        attr.put("treePath", entityNode.getTreePath());
        vueNode.setAttributes(attr);
        if ("Y".equals(entityNode.getTreeLeaf())){
            vueNode.setIsLeaf(true);
        } else{
            vueNode.setIsLeaf(false);
        }
        return vueNode;
    }


    /**
     * 根据treePath去重
     * @param entityNodes entityNodes
     */
    private Set<String> reDuplicationByTreePath(List<QmsAuditPlanDTO> entityNodes) {
        Set<String> treeIdSet = new HashSet<String>();
        for (QmsAuditPlanDTO dto : entityNodes) {
            String treePath = dto.getTreePath();
            treeIdSet.addAll(Arrays.asList(treePath.split("/")));
        }
        return treeIdSet;
    }

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return QmsAuditPlanDTO
	 */
	@Transactional(readOnly = true)
	public QmsAuditPlanDTO getQmsAuditPlanDtoById(String id) {
		try {
			QmsAuditPlanDTO dto = qmsAuditPlanDAO.findQmsAuditPlanById(id);
			//记录日志
			if (dto != null) {
				SysLogUtil.log4Query(dto);
				valueConvert(Arrays.asList(dto));
			}
			return dto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("通过主键查询单条记录失败");
		}
	}

    /**
     *	获取新的treeSort值：在最当前层最大值上递增10
     * @param parentId
     * @return
     */
    public Long getNewTreeSortByParentId(String parentId) {
        try {
            Long maxTreeSort = qmsAuditPlanDAO.findMaxTreeSortByParentId(parentId);
            return maxTreeSort == null ? 10L : maxTreeSort + 10L;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("获取新的treeSort值失败");
        }
    }
    /**
     * 新增数据
     * @param dto 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsAuditPlanTree(QmsAuditPlanDTO dto) {
        try {
            String id = ComUtil.getId();
            dto.setId(id);
            PojoUtil.setSysProperties(dto, OpType.insert);
            // 自动计算其他相关属性值
            setTreeProperties(dto, null, OpType.insert);
			qmsAuditPlanDAO.insertQmsAuditPlan(dto);
            //记录日志
            SysLogUtil.log4Insert(dto);
			valueConvert(Arrays.asList(dto));
            return id;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("新增数据失败");
        }
    }

	/**
	 * 更新数据
	 * @param dto 更新对象
	 * @return int
	 */
	@Transactional
	public boolean updateQmsAuditPlanTree(QmsAuditPlanDTO dto) {
		boolean flag = false;
		List<QmsAuditPlanDTO> updateChildrenList = null;
		QmsAuditPlanDTO old = qmsAuditPlanDAO.findQmsAuditPlanById(dto.getId());
		if (isMoveToSelfChildNode(dto,old)){
			throw new BusinessException("不允许将节点移动到自身或者子节点下");
		}
		String oldParentId = old.getParentId();
		String orgIdentity = old.getOrgIdentity();
		if (isUpdateTreeProperties(dto, old)) {
			setTreeProperties(dto, old, OpType.update);
			updateChildrenList = updateChildrenTreeProperties(dto, old);
			flag = true;
		}
		int ret = qmsAuditPlanDAO.updateQmsAuditPlanAll(getUpdateDto(dto));
		if (ret == 0) {
			throw new DaoException("数据失效，请重新更新");
		}
		if (!CollectionUtils.isEmpty(updateChildrenList)) {
		    qmsAuditPlanDAO.updateQmsAuditPlanList(updateChildrenList);
		}
		// 新的父节点变更为非叶子节点
		if (!StringUtils.equals("-1", dto.getParentId())) {
			QmsAuditPlanDTO parentDTO = qmsAuditPlanDAO.findQmsAuditPlanById(dto.getParentId());
			parentDTO.setTreeLeaf("N");
			qmsAuditPlanDAO.updateQmsAuditPlanAll(parentDTO);
		}
		// 判断原节点是否还有子节点，否则改为叶子节点
		List<QmsAuditPlanDTO> childrenList = qmsAuditPlanDAO.findChildrenQmsAuditPlanById(oldParentId, orgIdentity);
		if (CollectionUtils.isEmpty(childrenList)) {
			QmsAuditPlanDTO oldParentDTO = qmsAuditPlanDAO.findQmsAuditPlanById(oldParentId);
			oldParentDTO.setTreeLeaf("Y");
			qmsAuditPlanDAO.updateQmsAuditPlanAll(oldParentDTO);
		}
		return flag;
	}

	/**
	 * 判断是是否移动节点到自身或者子节点下
	 * @param dto 更新对象
	 * @param old 源对象
	 * @return boolean
	 */
	private boolean isMoveToSelfChildNode(QmsAuditPlanDTO dto, QmsAuditPlanDTO old) {
		if (!dto.getParentId().equals(old.getParentId())){
			//判断是否移动到自身下面
			if (dto.getParentId().equals(old.getId())){
				return true;
			}
			//判断是否移动到子节点下
			List<QmsAuditPlanDTO> children = qmsAuditPlanDAO.findQmsAuditPlanByTreePath(old.getTreePath());
			for (QmsAuditPlanDTO child : children) {
				if (child.getId().equals(dto.getParentId())){
					return true;
				}
			}
		}
		return false;
	}

    /**
     * 内部方法，获取修改的dto对象
     * @param dto
     * @return
     */
    private QmsAuditPlanDTO getUpdateDto(QmsAuditPlanDTO dto) {
		QmsAuditPlanDTO oldDTO = findById(dto.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        //记录日志
        SysLogUtil.log4Update(dto, oldDTO);
        PojoUtil.setSysProperties(dto, OpType.update);
        if (StringUtils.isEmpty(dto.getTreePath())) {
            dto.setTreePath(oldDTO.getTreePath());
        }
        if (dto.getTreeLevel() == null) {
            dto.setTreeLevel(oldDTO.getTreeLevel());
        }
        if (StringUtils.isEmpty(dto.getTreeLeaf())) {
            dto.setTreeLeaf(oldDTO.getTreeLeaf());
        }
        if (StringUtils.isEmpty(dto.getTreeSorts())) {
            dto.setTreeSorts(oldDTO.getTreeSorts());
        }
        PojoUtil.copyProperties(oldDTO, dto, false);
        return oldDTO;
    }

    /**
     * 根据主键删除数据
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsAuditPlanTreeById(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new Exception("删除失败！传入的参数主键为null");
        }
        try {
            // 记录日志
			QmsAuditPlanDTO dto = qmsAuditPlanDAO.findQmsAuditPlanById(id);
            if (dto == null){
                throw new BusinessException("当前选中节点已被删除！");
            }
            if (!dto.getTreeLeaf().equals("Y")){
                throw new BusinessException("当前选中节点含有子节点，请先删除子节点！");
            }
            SysLogUtil.log4Delete(dto);
            int count = qmsAuditPlanDAO.deleteQmsAuditPlanById(id);
            setTreeProperties(dto, null, OpType.delete);
            //删除附件
			ossClient.deleteAttachByFormId(id);
            return count;
        } catch (Exception e) {
            logger.error("deleteQmsAuditPlanById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 日志专用，内部方法，不再记录日志
     * @param id 主键id
     * @return QmsAuditPlanDTO
     */
    private QmsAuditPlanDTO findById(String id) {
        return qmsAuditPlanDAO.findQmsAuditPlanById(id);
    }

    /**
     * 自动计算树形结构其他属性值
     * @param dto 修改后的对象
     * @param old 原对象（更新方法使用）
     * @return
     */
    private void setTreeProperties(QmsAuditPlanDTO dto, QmsAuditPlanDTO old, OpType opType) {
        // 获取其父级节点
        QmsAuditPlanDTO parentDTO = findParentQmsAuditPlanTreeById(dto.getParentId());
        // 非初始化根节点情况
        if (parentDTO != null) {
            // 判断操作类型
            switch (opType) {
                case insert: // 新增
                    // 设置当前树路经
                    dto.setTreePath(parentDTO.getTreePath() + "/" + dto.getId());
                    // 设置当前树全路径排序
                    Long treeSort = dto.getTreeSort();
                    String treeSorts = String.format("%06d", treeSort);
                    dto.setTreeSorts(parentDTO.getTreeSorts() + "/" + treeSorts);
                    // 设置当前是否为叶子节点，新增全部为叶子节点
                    dto.setTreeLeaf("Y");
                    // 设置当前节点级别
                    dto.setTreeLevel(parentDTO.getTreeLevel() + 1);
                    // 判断当前父节点是否为叶子节点，如果是，则更改为非叶子节点
                    if ("Y".equals(parentDTO.getTreeLeaf())) {
                        parentDTO.setTreeLeaf("N");
                        qmsAuditPlanDAO.updateQmsAuditPlanAll(parentDTO);
                    }
                    break;
                case update: // 修改
                    // 主要针对于排序字段的修改
                    if (isUpdateTreeProperties(dto, old)) { // 排序字段被修改，则更改整体排序字段
                        // 当前新的本级排序字段
                        String currentTreeSorts = String.format("%06d", dto.getTreeSort());
                        // 当前新的总体排序字段
                        String newTreeSorts = parentDTO.getTreeSorts() + "/" + currentTreeSorts;
                        // 赋值
                        dto.setTreeSorts(newTreeSorts);
                        // 重新生成当前节点tree_path路径
                        String currentTreePath = parentDTO.getTreePath() + "/" + dto.getId();
                        Long currentTreeLevel = parentDTO.getTreeLevel() + 1;
                        // 赋值
                        dto.setTreePath(currentTreePath);
                        dto.setTreeLevel(currentTreeLevel);
                    }
                    break;
                case delete: // 删除
                    // 判断当前父节点下还是否有子节点，如果没有，则需要把父节点置为叶子节点
                    List<QmsAuditPlanDTO> childrenList = findChildrenQmsAuditPlanById(dto.getParentId(), dto.getOrgIdentity());
                    if (CollectionUtils.isEmpty(childrenList)) {
                        parentDTO.setTreeLeaf("Y");
                        qmsAuditPlanDAO.updateQmsAuditPlanAll(parentDTO);
                    }
                    break;
                default:
                    break;
            }
        } else { // 初始化树根节点
            dto.setTreePath(dto.getId());
            // 设置当前树全路径排序
            Long treeSort = dto.getTreeSort();
            String treeSorts = String.format("%06d", treeSort);
            dto.setTreeSorts(treeSorts);
            //设置当前是否为叶子节点，新增全部为叶子节点
            if (opType == OpType.insert) {
                dto.setTreeLeaf("Y");
            }
            // 设置当前节点级别.
            dto.setTreeLevel(1L);
        }
    }

    /**
     * 查询父节点信息
     * @param parentId 父ID
     * @return TestTreeTableGenDTO
     * @throws DaoException
     */
    public QmsAuditPlanDTO findParentQmsAuditPlanTreeById(String parentId) {
        try {
            QmsAuditPlanDTO dto = qmsAuditPlanDAO.findQmsAuditPlanById(parentId);
            // 记录日志
            if (dto != null) {
                SysLogUtil.log4Query(dto);
            }
            return dto;
        } catch (Exception e) {
            logger.error("findParentQmsAuditPlanTreeById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    private boolean isUpdateTreeProperties(QmsAuditPlanDTO dto, QmsAuditPlanDTO old) {
        boolean flag = false;
        if (!old.getTreeSort().equals(dto.getTreeSort()) || !old.getParentId().equals(dto.getParentId())) {
            flag = true;
        }
        return flag;
    }

    private List<QmsAuditPlanDTO> findChildrenQmsAuditPlanById(String id, String orgIdentity) {
        try {
            return qmsAuditPlanDAO.findChildrenQmsAuditPlanById(id, orgIdentity);
        } catch (Exception e) {
            logger.error("findChildrenQmsAuditPlanById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 更新下属所有节点的tree_path或者是tree_sorts
     * @param parent
     * @param oldParent
     * @return
     */
    private List<QmsAuditPlanDTO> updateChildrenTreeProperties(QmsAuditPlanDTO parent, QmsAuditPlanDTO oldParent) {
        // 原来的排序字段和树路径字段
        String oldTreeSorts = oldParent.getTreeSorts();
        String oldTreePath = oldParent.getTreePath();
        // 现在的排序字段
        String currentTreeSorts = parent.getTreeSorts();
        String currentTreePath = parent.getTreePath();
        // 查找当前节点下的所有子节点
        List<QmsAuditPlanDTO> list = qmsAuditPlanDAO.findQmsAuditPlanByTreePath(oldTreePath);
        for (QmsAuditPlanDTO dto : list) {
            dto.setTreePath(dto.getTreePath().replace(oldTreePath, currentTreePath));
            dto.setTreeSorts(dto.getTreeSorts().substring(0, oldTreeSorts.length()).replace(oldTreeSorts, currentTreeSorts)
                + dto.getTreeSorts().substring(oldTreeSorts.length()));
            dto.setTreeLevel(Long.valueOf(dto.getTreePath().split("/").length));
        }
        return list;
    }

    private List<QmsAuditPlanDTO> getTreeNodes(List<QmsAuditPlanDTO> tree) {
        List<QmsAuditPlanDTO> treeNodes = new ArrayList<>();
        treeNodes.addAll(tree);
        for (QmsAuditPlanDTO dto : tree) {
            if (!CollectionUtils.isEmpty(dto.getChildren())) {
                treeNodes.addAll(getTreeNodes(dto.getChildren()));
            }
        }
        return treeNodes;
    }
    private void valueConvertTreeNodes(List<QmsAuditPlanDTO> tree) {
        List<QmsAuditPlanDTO> treeNodes = getTreeNodes(tree);
        valueConvert(treeNodes);
    }
	/**
	 * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
	 *
	 * @param qmsAuditPlanDTOList
	 */
	private void valueConvert(List<QmsAuditPlanDTO> qmsAuditPlanDTOList) {
		//循环组装请求数据
		Map<String, Set<String>> convertFormData = new HashMap<>();
		for (QmsAuditPlanDTO qmsAuditPlan : qmsAuditPlanDTOList) {
			BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditPlan.getSecretLevel());
		}
		if (convertFormData.size() > 0) {
			//获取请求结果
			Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
			//循环设置Alias或Name的值
			for (QmsAuditPlanDTO qmsAuditPlan : qmsAuditPlanDTOList) {
				qmsAuditPlan.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditPlan.getSecretLevel()));
			}
		}
	}
}
