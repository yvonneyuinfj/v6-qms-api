package avicit.myportal.qms.qmsqualityobjective.service;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.exception.DaoException;
import avicit.platform6.core.domain.VueNode;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.commons.utils.ComUtil;
import avicit.platform6.commons.utils.PojoUtil;
import avicit.platform6.commons.utils.BusinessUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.OssClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import avicit.myportal.qms.qmsqualityobjective.dao.QmsQualityObjectiveDAO;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveDTO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:10
 * @类说明：质量目标台账表Service
 * @修改记录：
 */
@Service
public class QmsQualityObjectiveService {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityObjectiveService.class);

    @Autowired
    private QmsQualityObjectiveDAO qmsQualityObjectiveDAO;

    @Autowired
    private ConvertColumnClient convertColumnClient;

    @Autowired
    private OssClient ossClient;

    private static final int ID_LIMIT = 500;

    /**
     * 按照父id查询数据
     *
     * @param parentId    父节点ID
     * @param level       树等级
     * @param orgIdentity 组织id
     * @return List<QmsQualityObjectiveDTO>
     */
    public List<QmsQualityObjectiveDTO> getQmsQualityObjectiveTreeGridByParentId(String parentId, int level, String orgIdentity) {
        List<QmsQualityObjectiveDTO> dtoList = new ArrayList<>();
        if (!"-1".equals(parentId)) {
            dtoList = qmsQualityObjectiveDAO.findChildrenQmsQualityObjectiveById(parentId, orgIdentity);
            valueConvertTreeNodes(dtoList);
        } else {
            dtoList = getQmsQualityObjectiveTreeGridByTreeLevel(level, orgIdentity);
            if (dtoList.size() == 0) {
                QmsQualityObjectiveDTO rootNode = insertRoot();
                dtoList.add(rootNode);
            }
        }
        return dtoList;
    }

    /**
     * 树层级查询
     *
     * @param level       树等级
     * @param orgIdentity 组织id
     * @return List<QmsQualityObjectiveDTO>
     */
    private List<QmsQualityObjectiveDTO> getQmsQualityObjectiveTreeGridByTreeLevel(int level, String orgIdentity) {
        // treeGrid存在多个根节点，所以默认不展示parentId是-1的根，查询层级默认加1
        level += 1;
        List<QmsQualityObjectiveDTO> allNodes = qmsQualityObjectiveDAO.findQmsQualityObjectiveTreeGridByTreeLevel(level, orgIdentity);
        return createTreeGridData(allNodes);
    }

    /**
     * 按照父id查询数据
     *
     * @param parentId    父节点ID
     * @param level       树等级
     * @param orgIdentity 组织id
     * @return List<VueNode>
     */
    public List<VueNode> getQmsQualityObjectiveByParentIdForTreeSelect(String parentId, int level, String orgIdentity) {
        List<QmsQualityObjectiveDTO> dtoList = getQmsQualityObjectiveTreeGridByParentId(parentId, level, orgIdentity);
        List<VueNode> vueNodeList = transToTreeNodeData(dtoList);
        return vueNodeList;
    }

    /**
     * 展开至指定节点
     *
     * @param id          主键id
     * @param orgIdentity 组织id
     * @return List<QmsQualityObjectiveDTO>
     */
    public List<QmsQualityObjectiveDTO> expandTreeToNode(String id, String orgIdentity) {
        List<QmsQualityObjectiveDTO> tree = new ArrayList<>();
        QmsQualityObjectiveDTO dto = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
        Long level = dto.getTreeLevel();
        String[] ids = dto.getTreePath().split("/");
        if (ids != null && ids.length > 0) {
            QmsQualityObjectiveDTO rootNode = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(ids[0]);
            QmsQualityObjectiveDTO parentNode = rootNode;
            for (int i = 0; i < level; i++) {
                List<QmsQualityObjectiveDTO> childNodes = qmsQualityObjectiveDAO.findChildrenQmsQualityObjectiveById(ids[i], orgIdentity);
                parentNode.setChildren(childNodes);
                valueConvert(Arrays.asList(parentNode));
                for (QmsQualityObjectiveDTO node : childNodes) {
                    valueConvert(Arrays.asList(node));
                }
                if (i < level - 1) {
                    for (QmsQualityObjectiveDTO node : childNodes) {
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
     *
     * @param queryReqBean 查询条件
     * @param orgIdentity  组织id
     * @return List<QmsQualityObjectiveDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityObjectiveDTO> searchQmsQualityObjectiveTreeGrid(QueryReqBean<QmsQualityObjectiveDTO> queryReqBean, String orgIdentity) {
        List<QmsQualityObjectiveDTO> tree = new ArrayList<>();
        QmsQualityObjectiveDTO queryParams = queryReqBean.getSearchParams();
        String keywords = queryReqBean.getKeyWord();
        queryParams.setOrgIdentity(orgIdentity);
        List<QmsQualityObjectiveDTO> searchNodes = qmsQualityObjectiveDAO.searchQmsQualityObjective(queryParams, keywords, orgIdentity);
        if (!CollectionUtils.isEmpty(searchNodes)) {
            Set<String> treeIdSet = reDuplicationByTreePath(searchNodes);
            int i = 0;
            // 考虑mybatis foreach的限制，所以定义参数格式为list内还是list
            List<List<String>> idsList = new ArrayList<List<String>>();
            List<String> idList = new ArrayList<String>();
            for (String treeId : treeIdSet) {
                // 当id个数超出限制后，则新new一个list来存放
                if (i % ID_LIMIT == 0 && i > 0) {
                    idsList.add(idList);
                    idList = new ArrayList<String>();
                }
                idList.add(treeId);
                i++;
            }
            idsList.add(idList);
            List<QmsQualityObjectiveDTO> allNodes = qmsQualityObjectiveDAO.searchQmsQualityObjectiveByIds(idsList);
            tree = createTreeGridData(allNodes);
            valueConvertTreeNodes(tree);
        }
        return tree;
    }

    /**
     * 查询树节点
     *
     * @param text        查询条件
     * @param orgIdentity 组织id
     * @return List<ZTreeNode>
     */
    @Transactional(readOnly = true)
    public List<VueNode> searchQmsQualityObjective(String text, String orgIdentity) {
        List<VueNode> tree = new ArrayList<>();
        QmsQualityObjectiveDTO queryParams = new QmsQualityObjectiveDTO();
        queryParams.setObjectiveName(text);
        queryParams.setOrgIdentity(orgIdentity);
        List<QmsQualityObjectiveDTO> searchNodes = qmsQualityObjectiveDAO.searchQmsQualityObjective(queryParams, "", orgIdentity);
        if (!CollectionUtils.isEmpty(searchNodes)) {
            Set<String> treeIdSet = reDuplicationByTreePath(searchNodes);
            int i = 0;
            // 考虑mybatis foreach的限制，所以定义参数格式为list内还是list
            List<List<String>> idsList = new ArrayList<List<String>>();
            List<String> idList = new ArrayList<String>();
            for (String treeId : treeIdSet) {
                // 当id个数超出限制后，则新new一个list来存放
                if (i % ID_LIMIT == 0 && i > 0) {
                    idsList.add(idList);
                    idList = new ArrayList<String>();
                }
                idList.add(treeId);
                i++;
            }
            idsList.add(idList);
            List<QmsQualityObjectiveDTO> allNodes = qmsQualityObjectiveDAO.searchQmsQualityObjectiveByIds(idsList);
            tree = createTreeData(allNodes);
        }
        return tree;
    }


    /**
     * 组建树形结构
     *
     * @param entityNodes 节点集合
     * @return List<VueNode>
     */
    private List<VueNode> createTreeData(List<QmsQualityObjectiveDTO> entityNodes) {
        List<VueNode> list = transToTreeNodeData(entityNodes);
        List<VueNode> tree = new ArrayList<>();
        for (VueNode vueNode : list) {
            // 找到根节点
            if ("-1".equals(vueNode.getParentId())) {
                tree.add(vueNode);
            }
            List<VueNode> children = new ArrayList<>();
            // 再次遍历list，找到子节点
            for (VueNode node : list) {
                if (vueNode.getId().equals(node.getParentId())) {
                    children.add(node);
                }
            }
            if (!children.isEmpty()) {
                vueNode.setChildren(children);
            }
        }
        return tree;
    }

    /**
     * 初始化根节点
     *
     * @return
     */
    private QmsQualityObjectiveDTO insertRoot() {
        QmsQualityObjectiveDTO tree = new QmsQualityObjectiveDTO();
        tree.setParentId("-1");
        tree.setOrgIdentity(ThreadContextHelper.getOrgId());
        tree.setObjectiveName("根节点");
        tree.setSecretLevel("1");
        tree.setTreePath("-1");
        tree.setTreeSort(1L);
        insertQmsQualityObjectiveTree(tree);
        valueConvert(Arrays.asList(tree));
        return tree;
    }

    /**
     * 组建TreeGrid数据结构
     *
     * @param list 节点集合
     * @return List<QmsQualityObjectiveDTO>
     */
    private List<QmsQualityObjectiveDTO> createTreeGridData(List<QmsQualityObjectiveDTO> list) {
        // List<QmsQualityObjectiveDTO> tree = new ArrayList<>();
        // for (QmsQualityObjectiveDTO dto : list) {
        // 	valueConvert(Arrays.asList(dto));
        // 	//找到根节点
        // 	if ("-1".equals(dto.getParentId())) {
        // 		tree.add(dto);
        // 	}
        // 	List<QmsQualityObjectiveDTO> children = new ArrayList<>();
        // 	//再次遍历list，找到子节点
        // 	for (QmsQualityObjectiveDTO childrenDto : list) {
        // 		if (childrenDto.getParentId().equals(dto.getId())) {
        // 			children.add(childrenDto);
        // 		}
        // 	}
        // 	if(!children.isEmpty()){
        //         dto.setChildren(children);
        //     }
        // }
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        // 当前结果中所有节点ID
        Set<String> idSet = list.stream().map(QmsQualityObjectiveDTO::getId).filter(Objects::nonNull).collect(Collectors.toSet());
        // 按 parentId 对节点分组，避免双重循环
        Map<String, List<QmsQualityObjectiveDTO>> childrenMap = list.stream().filter(dto -> dto.getParentId() != null).collect(Collectors.groupingBy(QmsQualityObjectiveDTO::getParentId));

        List<QmsQualityObjectiveDTO> tree = new ArrayList<>();

        for (QmsQualityObjectiveDTO dto : list) {
            valueConvert(Collections.singletonList(dto));

            List<QmsQualityObjectiveDTO> children = childrenMap.get(dto.getId());
            if (children != null && !children.isEmpty()) {
                dto.setChildren(children);
            }

            String parentId = dto.getParentId();

            if ("-1".equals(parentId) || parentId == null || !idSet.contains(parentId)) {
                tree.add(dto);
            }
        }
        return tree;
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsQualityObjectiveList(List<QmsQualityObjectiveDTO> dtoList) {
        for (QmsQualityObjectiveDTO qmsQualityObjectiveDTO : dtoList) {
            qmsQualityObjectiveDTO.setId(ComUtil.getId());

            setTreeProperties(qmsQualityObjectiveDTO, null, OpType.insert);
            PojoUtil.setSysProperties(qmsQualityObjectiveDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityObjectiveDAO.insertQmsQualityObjectiveList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 将实体类集合转化成VueNode格式
     *
     * @param entityNodes 实体类节点集合
     * @return List<VueNode>
     */
    private List<VueNode> transToTreeNodeData(List<QmsQualityObjectiveDTO> entityNodes) {
        List<VueNode> vueNodes = new ArrayList<>();
        for (QmsQualityObjectiveDTO entityNode : entityNodes) {
            VueNode vueNode = transToTreeNodeData(entityNode);
            vueNodes.add(vueNode);
        }
        return vueNodes;
    }

    /**
     * 将实体类转化成VueNode格式
     *
     * @param entityNode 实体类节点集合
     * @return List<VueNode>
     */
    private VueNode transToTreeNodeData(QmsQualityObjectiveDTO entityNode) {
        VueNode vueNode = new VueNode();
        vueNode.setId(entityNode.getId());
        vueNode.setKey(entityNode.getId());
        vueNode.setTitle(entityNode.getObjectiveName() == null ? "" : entityNode.getObjectiveName());
        vueNode.setSelectable(true);
        vueNode.setDisabled(false);
        vueNode.setDisableCheckbox(false);
        vueNode.setParentId(entityNode.getParentId());
        HashMap<String, Object> attr = new HashMap<>();
        attr.put("treeLeaf", entityNode.getTreeLeaf());
        attr.put("treeLevel", entityNode.getTreeLevel());
        attr.put("treePath", entityNode.getTreePath());
        vueNode.setAttributes(attr);
        if ("Y".equals(entityNode.getTreeLeaf())) {
            vueNode.setIsLeaf(true);
        } else {
            vueNode.setIsLeaf(false);
        }
        return vueNode;
    }


    /**
     * 根据treePath去重
     *
     * @param entityNodes entityNodes
     */
    private Set<String> reDuplicationByTreePath(List<QmsQualityObjectiveDTO> entityNodes) {
        Set<String> treeIdSet = new HashSet<String>();
        for (QmsQualityObjectiveDTO dto : entityNodes) {
            String treePath = dto.getTreePath();
            treeIdSet.addAll(Arrays.asList(treePath.split("/")));
        }
        return treeIdSet;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsQualityObjectiveDTO
     */
    @Transactional(readOnly = true)
    public QmsQualityObjectiveDTO getQmsQualityObjectiveDtoById(String id) {
        try {
            QmsQualityObjectiveDTO dto = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
            // 记录日志
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

    @Transactional(readOnly = true)
    public QmsQualityObjectiveDTO getQmsQualityObjectiveDtoByParentId(String parentId) {
        try {
            QmsQualityObjectiveDTO dto = qmsQualityObjectiveDAO.findQmsQualityObjectiveByParentId(parentId);
            // 记录日志
            if (dto != null) {
                SysLogUtil.log4Query(dto);
                valueConvert(Arrays.asList(dto));
            }
            return dto;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("通过parentId查询单条记录失败");
        }
    }

    /**
     * 获取新的treeSort值：在最当前层最大值上递增10
     *
     * @param parentId
     * @return
     */
    public Long getNewTreeSortByParentId(String parentId) {
        try {
            Long maxTreeSort = qmsQualityObjectiveDAO.findMaxTreeSortByParentId(parentId);
            return maxTreeSort == null ? 10L : maxTreeSort + 10L;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("获取新的treeSort值失败");
        }
    }

    /**
     * 新增数据
     *
     * @param dto 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsQualityObjectiveTree(QmsQualityObjectiveDTO dto) {
        try {
            String id = ComUtil.getId();
            dto.setId(id);
            PojoUtil.setSysProperties(dto, OpType.insert);
            // 自动计算其他相关属性值
            setTreeProperties(dto, null, OpType.insert);
            qmsQualityObjectiveDAO.insertQmsQualityObjective(dto);
            // 记录日志
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
     *
     * @param dto 更新对象
     * @return int
     */
    @Transactional
    public boolean updateQmsQualityObjectiveTree(QmsQualityObjectiveDTO dto) {
        boolean flag = false;
        List<QmsQualityObjectiveDTO> updateChildrenList = null;
        QmsQualityObjectiveDTO old = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(dto.getId());
        if (isMoveToSelfChildNode(dto, old)) {
            throw new BusinessException("不允许将节点移动到自身或者子节点下");
        }
        String oldParentId = old.getParentId();
        String orgIdentity = old.getOrgIdentity();
        if (isUpdateTreeProperties(dto, old)) {
            setTreeProperties(dto, old, OpType.update);
            updateChildrenList = updateChildrenTreeProperties(dto, old);
            flag = true;
        }
        int ret = qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(getUpdateDto(dto));
        if (ret == 0) {
            throw new DaoException("数据失效，请重新更新");
        }
        if (!CollectionUtils.isEmpty(updateChildrenList)) {
            qmsQualityObjectiveDAO.updateQmsQualityObjectiveList(updateChildrenList);
        }
        // 新的父节点变更为非叶子节点
        if (!StringUtils.equals("-1", dto.getParentId())) {
            QmsQualityObjectiveDTO parentDTO = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(dto.getParentId());
            parentDTO.setTreeLeaf("N");
            qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(parentDTO);
        }
        // 判断原节点是否还有子节点，否则改为叶子节点
        List<QmsQualityObjectiveDTO> childrenList = qmsQualityObjectiveDAO.findChildrenQmsQualityObjectiveById(oldParentId, orgIdentity);
        if (CollectionUtils.isEmpty(childrenList)) {
            QmsQualityObjectiveDTO oldParentDTO = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(oldParentId);
            oldParentDTO.setTreeLeaf("Y");
            qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(oldParentDTO);
        }
        return flag;
    }

    /**
     * 批量导入
     * @return
     */
    @Transactional
    public ExcelImportResult importData(List<Map<String, String>> dataList, String formData) {
        // List<QmsMrInputItemDTO> qmsMrInputItemSuccessList = new ArrayList<QmsMrInputItemDTO>();
        // List<QmsMrInputItemImportDTO> qmsMrInputItemErrList = new ArrayList<QmsMrInputItemImportDTO>();
        // Map<String, Object> formDataMap = new HashMap<String,Object>();
        // if(avicit.platform6.commons.utils.StringUtils.isNotEmpty(formData)){
        //     formDataMap = JsonUtil.parseJSON2Map(formData);
        // }
        // if(!CollectionUtils.isEmpty(dataList)){
        //     Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        //     for (Map<String, String> data:dataList) {
        //         if(avicit.platform6.commons.utils.StringUtils.isEmpty(data.get("errorInfo"))){
        //             //业务校验
        //             QmsMrInputItemDTO dto = new QmsMrInputItemDTO();
        //             Map2Bo.map2Pojo(data,dto);
        //             qmsMrInputItemSuccessList.add(dto);
        //         } else {
        //             QmsMrInputItemImportDTO dtoImp = new QmsMrInputItemImportDTO();
        //             Map2Bo.map2Pojo(data,dtoImp);
        //             qmsMrInputItemErrList.add(dtoImp);
        //         }
        //     }
        //     this.revValueConvert(qmsMrInputItemSuccessList, convertResultData);
        //     this.ins(qmsMrInputItemSuccessList);
        // }
        // ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsMrInputItemSuccessList,qmsMrInputItemErrList,QmsMrInputItemImportDTO.class,formDataMap);
        return null;
    }

    /**
     * 判断是是否移动节点到自身或者子节点下
     *
     * @param dto 更新对象
     * @param old 源对象
     * @return boolean
     */
    private boolean isMoveToSelfChildNode(QmsQualityObjectiveDTO dto, QmsQualityObjectiveDTO old) {
        if (!dto.getParentId().equals(old.getParentId())) {
            // 判断是否移动到自身下面
            if (dto.getParentId().equals(old.getId())) {
                return true;
            }
            // 判断是否移动到子节点下
            List<QmsQualityObjectiveDTO> children = qmsQualityObjectiveDAO.findQmsQualityObjectiveByTreePath(old.getTreePath());
            for (QmsQualityObjectiveDTO child : children) {
                if (child.getId().equals(dto.getParentId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param dto
     * @return
     */
    private QmsQualityObjectiveDTO getUpdateDto(QmsQualityObjectiveDTO dto) {
        QmsQualityObjectiveDTO oldDTO = findById(dto.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        // 记录日志
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
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsQualityObjectiveTreeById(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new Exception("删除失败！传入的参数主键为null");
        }
        try {
            // 记录日志
            QmsQualityObjectiveDTO dto = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
            if (dto == null) {
                throw new BusinessException("当前选中节点已被删除！");
            }
            if (!dto.getTreeLeaf().equals("Y")) {
                throw new BusinessException("当前选中节点含有子节点，请先删除子节点！");
            }
            SysLogUtil.log4Delete(dto);
            int count = qmsQualityObjectiveDAO.deleteQmsQualityObjectiveById(id);
            setTreeProperties(dto, null, OpType.delete);
            // 删除附件
            ossClient.deleteAttachByFormId(id);
            return count;
        } catch (Exception e) {
            logger.error("deleteQmsQualityObjectiveById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return QmsQualityObjectiveDTO
     */
    private QmsQualityObjectiveDTO findById(String id) {
        return qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
    }

    /**
     * 自动计算树形结构其他属性值
     *
     * @param dto 修改后的对象
     * @param old 原对象（更新方法使用）
     * @return
     */
    private void setTreeProperties(QmsQualityObjectiveDTO dto, QmsQualityObjectiveDTO old, OpType opType) {
        // 获取其父级节点
        QmsQualityObjectiveDTO parentDTO = findParentQmsQualityObjectiveTreeById(dto.getParentId());
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
                        qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(parentDTO);
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
                    List<QmsQualityObjectiveDTO> childrenList = findChildrenQmsQualityObjectiveById(dto.getParentId(), dto.getOrgIdentity());
                    if (CollectionUtils.isEmpty(childrenList)) {
                        parentDTO.setTreeLeaf("Y");
                        qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(parentDTO);
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
            // 设置当前是否为叶子节点，新增全部为叶子节点
            if (opType == OpType.insert) {
                dto.setTreeLeaf("Y");
            }
            // 设置当前节点级别.
            dto.setTreeLevel(1L);
        }
    }

    /**
     * 查询父节点信息
     *
     * @param parentId 父ID
     * @return TestTreeTableGenDTO
     * @throws DaoException
     */
    public QmsQualityObjectiveDTO findParentQmsQualityObjectiveTreeById(String parentId) {
        try {
            QmsQualityObjectiveDTO dto = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(parentId);
            // 记录日志
            if (dto != null) {
                SysLogUtil.log4Query(dto);
            }
            return dto;
        } catch (Exception e) {
            logger.error("findParentQmsQualityObjectiveTreeById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    private boolean isUpdateTreeProperties(QmsQualityObjectiveDTO dto, QmsQualityObjectiveDTO old) {
        boolean flag = false;
        if (!old.getTreeSort().equals(dto.getTreeSort()) || !old.getParentId().equals(dto.getParentId())) {
            flag = true;
        }
        return flag;
    }

    private List<QmsQualityObjectiveDTO> findChildrenQmsQualityObjectiveById(String id, String orgIdentity) {
        try {
            return qmsQualityObjectiveDAO.findChildrenQmsQualityObjectiveById(id, orgIdentity);
        } catch (Exception e) {
            logger.error("findChildrenQmsQualityObjectiveById出错：", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 更新下属所有节点的tree_path或者是tree_sorts
     *
     * @param parent
     * @param oldParent
     * @return
     */
    private List<QmsQualityObjectiveDTO> updateChildrenTreeProperties(QmsQualityObjectiveDTO parent, QmsQualityObjectiveDTO oldParent) {
        // 原来的排序字段和树路径字段
        String oldTreeSorts = oldParent.getTreeSorts();
        String oldTreePath = oldParent.getTreePath();
        // 现在的排序字段
        String currentTreeSorts = parent.getTreeSorts();
        String currentTreePath = parent.getTreePath();
        // 查找当前节点下的所有子节点
        List<QmsQualityObjectiveDTO> list = qmsQualityObjectiveDAO.findQmsQualityObjectiveByTreePath(oldTreePath);
        for (QmsQualityObjectiveDTO dto : list) {
            dto.setTreePath(dto.getTreePath().replace(oldTreePath, currentTreePath));
            dto.setTreeSorts(dto.getTreeSorts().substring(0, oldTreeSorts.length()).replace(oldTreeSorts, currentTreeSorts)
                    + dto.getTreeSorts().substring(oldTreeSorts.length()));
            dto.setTreeLevel(Long.valueOf(dto.getTreePath().split("/").length));
        }
        return list;
    }

    private List<QmsQualityObjectiveDTO> getTreeNodes(List<QmsQualityObjectiveDTO> tree) {
        List<QmsQualityObjectiveDTO> treeNodes = new ArrayList<>();
        treeNodes.addAll(tree);
        for (QmsQualityObjectiveDTO dto : tree) {
            if (!CollectionUtils.isEmpty(dto.getChildren())) {
                treeNodes.addAll(getTreeNodes(dto.getChildren()));
            }
        }
        return treeNodes;
    }

    private void valueConvertTreeNodes(List<QmsQualityObjectiveDTO> tree) {
        List<QmsQualityObjectiveDTO> treeNodes = getTreeNodes(tree);
        valueConvert(treeNodes);
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码提前组装数据
     *
     * @param dataList
     */
    private Map<String, Map<String, String>> assembleData(List<Map<String, String>> dataList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (Map<String, String> data : dataList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", data.get("secretLevelName"));
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECT_DATA_STAT_CYCLE", data.get("dataStatCycleName"));
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECTIVE_LEVEL", data.get("objectiveLevelName"));
        }
        return convertColumnClient.convertCodeToId(convertFormData);
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityObjectiveDTOList
     */
    private void revValueConvert(List<QmsQualityObjectiveDTO> qmsQualityObjectiveDTOList, Map<String, Map<String, String>> convertResultData) {
        for (QmsQualityObjectiveDTO qmsQualityObjectiveDTO : qmsQualityObjectiveDTOList) {
            qmsQualityObjectiveDTO.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjectiveDTO.getSecretLevelName()));
            qmsQualityObjectiveDTO.setDataStatCycle(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjectiveDTO.getDataStatCycleName()));
            qmsQualityObjectiveDTO.setObjectiveLevel(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjectiveDTO.getObjectiveLevelName()));
        }
    }

    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityObjectiveDTOList
     */
    private void valueConvert(List<QmsQualityObjectiveDTO> qmsQualityObjectiveDTOList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityObjectiveDTO qmsQualityObjective : qmsQualityObjectiveDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjective.getSecretLevel());
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjective.getDataStatCycle());
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECTIVE_LEVEL", qmsQualityObjective.getObjectiveLevel());
        }
        if (convertFormData.size() > 0) {
            // 获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            // 循环设置Alias或Name的值
            for (QmsQualityObjectiveDTO qmsQualityObjective : qmsQualityObjectiveDTOList) {
                qmsQualityObjective.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjective.getSecretLevel()));
                qmsQualityObjective.setDataStatCycleName(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjective.getDataStatCycle()));
                qmsQualityObjective.setObjectiveLevelName(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECTIVE_LEVEL", qmsQualityObjective.getObjectiveLevel()));
            }
        }
    }
}
