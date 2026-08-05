package avicit.myportal.qms.qmsqualityproblemdelay.service;

import avicit.myportal.qms.qmsqualityproblemdelay.dao.QmsQualityProblemDelayDAO;
import avicit.myportal.qms.qmsqualityproblemdelay.dto.QmsQualityProblemDelayDTO;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dto.QmsQualityProblemDelayMilestoneDTO;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.service.QmsQualityProblemDelayMilestoneService;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.api.bpm.BpmOperateClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartBean;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.commons.utils.*;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.exception.UtilsException;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.Page;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:05
* @类说明：质量问题延期Service
* @修改记录：
*/
@Service
public class QmsQualityProblemDelayService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityProblemDelayService.class);

	@Autowired
	private QmsQualityProblemDelayDAO qmsQualityProblemDelayDAO;

	@Autowired
	private OssClient ossClient;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private BpmOperateClient bpmOperateClient;

	@Autowired
	private QmsQualityProblemDelayMilestoneService qmsQualityProblemDelayMilestoneService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualityProblemDelayDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelayByPage(QueryReqBean<QmsQualityProblemDelayDTO> queryReqBean) {
		QueryRespBean<QmsQualityProblemDelayDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityProblemDelayDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityProblemDelayDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityProblemDelayDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsQualityProblemDelayDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsQualityProblemDelayDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityProblemDelayDTO> result = qmsQualityProblemDelayDAO.searchQmsQualityProblemDelayByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityProblemDelayDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelay(QueryReqBean<QmsQualityProblemDelayDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityProblemDelayDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityProblemDelayDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityProblemDelayDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsQualityProblemDelayDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsQualityProblemDelayDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();
        List<QmsQualityProblemDelayDTO> dataList = qmsQualityProblemDelayDAO.searchQmsQualityProblemDelay(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @param orgIdentity  组织id
	* @param wordSecret   文档密级
	* @param orderBy      排序
	* @return List<QmsQualityProblemDelayDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelayForExportExcel(QueryReqBean<QmsQualityProblemDelayDTO> queryReqBean, String orgIdentity, List<String> wordSecret, String orderBy) {
		return qmsQualityProblemDelayDAO.searchQmsQualityProblemDelayForExportExcel(queryReqBean.getSearchParams(), orgIdentity, wordSecret, orderBy, queryReqBean.getKeyWord());
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualityProblemDelayDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualityProblemDelayDTO queryQmsQualityProblemDelayByPrimaryKey(String id) {
		QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO = qmsQualityProblemDelayDAO.findQmsQualityProblemDelayById(id);
		//记录日志
		if (qmsQualityProblemDelayDTO != null) {
            valueConvert(Arrays.asList(qmsQualityProblemDelayDTO));
			SysLogUtil.log4Query(qmsQualityProblemDelayDTO);
		}
		return qmsQualityProblemDelayDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualityProblemDelayDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualityProblemDelay(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO) {
        if (StringUtils.isEmpty(qmsQualityProblemDelayDTO.getId())) {
            qmsQualityProblemDelayDTO.setId(ComUtil.getId());
        }
		PojoUtil.setSysProperties(qmsQualityProblemDelayDTO, OpType.insert);
		qmsQualityProblemDelayDAO.insertQmsQualityProblemDelay(qmsQualityProblemDelayDTO);
        // 新增或修改子表对象集合
        insertOrUpdateQmsQualityProblemDelayMilestone(qmsQualityProblemDelayDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualityProblemDelayDTO);
		return qmsQualityProblemDelayDTO.getId();
	}

	/**
	* 保存表单并启动流程
	*
	* @param qmsQualityProblemDelayDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsQualityProblemDelayAndStartProcess(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsQualityProblemDelay(qmsQualityProblemDelayDTO);
		//变量集合
		Map<String, Object> variables = new HashMap<>();
		//web表单传递过来(除表单对象外)的变量，可以为空
		if (jsonString != null && !"".equals(jsonString)) {
			Map<String, Object> extVariables = JsonUtil.parseJSON2Map(jsonString);
			variables.putAll(extVariables);
		}
		//把表单对象转换成map,传递给流程变量
		Map<String, Object> pojoMap = null;
		try {
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsQualityProblemDelayDTO);
		} catch (Exception e) {
			throw new UtilsException("PojoUtil.toMap转换失败", e);
		}
		variables.putAll(pojoMap);
		// 构造启动流程的对象
        StartBean startBean = new StartBean();
        startBean.setProcessDefinitionId(processDefId);
        startBean.setFormCode(formCode);
        startBean.setStartUserId(userId);
        startBean.setStartDeptId(deptId);
        startBean.setVariables(variables);
        StartResultBean startResultBean = bpmOperateClient.startProcessInstance(startBean);//启动流程
        // 返回流程启动的结果
        return startResultBean;
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsQualityProblemDelayList(List<QmsQualityProblemDelayDTO> dtoList) {
		for (QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO : dtoList) {
            qmsQualityProblemDelayDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityProblemDelayDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityProblemDelayDAO.insertQmsQualityProblemDelayList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualityProblemDelayDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityProblemDelay(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO) {
        return updateDto(qmsQualityProblemDelayDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualityProblemDelayDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityProblemDelaySensitive(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO) {
        return updateDto(qmsQualityProblemDelayDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualityProblemDelayDTO
	* @return
	*/
	private QmsQualityProblemDelayDTO getUpdateMainDto(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO) {
		QmsQualityProblemDelayDTO oldDTO = findById(qmsQualityProblemDelayDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualityProblemDelayDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualityProblemDelayDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualityProblemDelayDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualityProblemDelayList(List<QmsQualityProblemDelayDTO> dtoList) {
		List<QmsQualityProblemDelayDTO> updateList = new ArrayList<>();
        List<QmsQualityProblemDelayDTO> oldList = new ArrayList<>();
        for (QmsQualityProblemDelayDTO dto : dtoList) {
            QmsQualityProblemDelayDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityProblemDelayDTO updateDto = (QmsQualityProblemDelayDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityProblemDelayDAO.updateQmsQualityProblemDelayList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
	}

	/**
	* 按主键单条删除
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteQmsQualityProblemDelayById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO = findById(id);
		if (qmsQualityProblemDelayDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualityProblemDelayDTO);
		//删除子表
		for (QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO : qmsQualityProblemDelayMilestoneService.queryQmsQualityProblemDelayMilestoneByPid(qmsQualityProblemDelayDTO.getId())) {
			qmsQualityProblemDelayMilestoneService.deleteQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTO);
		}
		//删除业务数据
		int count = qmsQualityProblemDelayDAO.deleteQmsQualityProblemDelayById(id);
        //删除关联流程实例
        bpmOperateClient.deleteProcessInstanceByFormId(id);
		//删除附件
		ossClient.deleteAttachByFormId(id);
		return count;
	}

	/**
	 * 批量删除数据
	 *
	 * @param ids id的数组
	 * @return int
	 */
	@Transactional
	public int deleteQmsQualityProblemDelayByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualityProblemDelayById(id);
			result++;
		}
		return result;
	}

    /**
    * 流程服务回调方法（按主表主键单条删除业务数据）
    * @param id 主键id
    * @return int
    */
    @Transactional
    public int deleteDataQmsQualityProblemDelayById(String id){
 		if (StringUtils.isEmpty(id)) {
 			throw new BusinessException("删除失败！传入的参数主键为null");
 		}
 		//记录日志
 		QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO = findById(id);
 		if (qmsQualityProblemDelayDTO == null) {
 			throw new BusinessException("删除失败！对象不存在");
 		}
 		SysLogUtil.log4Delete(qmsQualityProblemDelayDTO);
		//删除子表
		for (QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO : qmsQualityProblemDelayMilestoneService.queryQmsQualityProblemDelayMilestoneByPid(qmsQualityProblemDelayDTO.getId())) {
			qmsQualityProblemDelayMilestoneService.deleteQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTO);
		}
 		//删除业务数据
 		int count = qmsQualityProblemDelayDAO.deleteQmsQualityProblemDelayById(id);
 		//删除附件
 		ossClient.deleteAttachByFormId(id);
 		return count;
    }

    /**
     * 新增或修改子表对象集合
     * @param qmsQualityProblemDelayDTO 新增对象
     */
    private void insertOrUpdateQmsQualityProblemDelayMilestone(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO) {
        ValidationList<QmsQualityProblemDelayMilestoneDTO> qmsQualityProblemDelayMilestoneList = qmsQualityProblemDelayDTO.getQmsQualityProblemDelayMilestoneList();
        if(!CollectionUtils.isEmpty(qmsQualityProblemDelayMilestoneList)) {
            for(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO : qmsQualityProblemDelayMilestoneList){
                if(StringUtils.equals(OpType.delete.toString(), qmsQualityProblemDelayMilestoneDTO.getOperationType_())) {
                    qmsQualityProblemDelayMilestoneService.deleteQmsQualityProblemDelayMilestoneById(qmsQualityProblemDelayMilestoneDTO.getId());
                } else if(StringUtils.equals(OpType.update.toString(), qmsQualityProblemDelayMilestoneDTO.getOperationType_())) {
                    qmsQualityProblemDelayMilestoneService.updateQmsQualityProblemDelayMilestoneSensitive(qmsQualityProblemDelayMilestoneDTO);
                } else {
                    qmsQualityProblemDelayMilestoneDTO.setDelayId(qmsQualityProblemDelayDTO.getId());
                    qmsQualityProblemDelayMilestoneDTO.setOrgIdentity(qmsQualityProblemDelayDTO.getOrgIdentity());
                    qmsQualityProblemDelayMilestoneService.insertQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTO);
                }
            }
        }
    }

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualityProblemDelayDTO
	*/
	private QmsQualityProblemDelayDTO findById(String id) {
		return qmsQualityProblemDelayDAO.findQmsQualityProblemDelayById(id);
	}

	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityProblemDelayDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityProblemDelayDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityProblemDelayDTO updateDto = (QmsQualityProblemDelayDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityProblemDelayDAO.updateQmsQualityProblemDelayAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityProblemDelayDAO.updateQmsQualityProblemDelaySensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        // 新增或修改子表对象集合
        insertOrUpdateQmsQualityProblemDelayMilestone(dto);
        try{
            //更新流程变量
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.putAll((Map<String, Object>) PojoUtil.toMap(updateDto));
            bpmOperateClient.setVariablesByFormId(dto.getId(),variables);
        } catch (Exception e) {
            throw new UtilsException("流程变量更新失败", e);
        }
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }

    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityProblemDelayDTOList
     */
    private void valueConvert(List<QmsQualityProblemDelayDTO> qmsQualityProblemDelayDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityProblemDelayDTO qmsQualityProblemDelay : qmsQualityProblemDelayDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityProblemDelay.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityProblemDelayDTO qmsQualityProblemDelay : qmsQualityProblemDelayDTOList) {
                qmsQualityProblemDelay.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityProblemDelay.getSecretLevel()));
                //流程的编码转换成名称
                qmsQualityProblemDelay.setBpmState(qmsQualityProblemDelay.getBusinessstate_());
			    qmsQualityProblemDelay.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsQualityProblemDelay.getBusinessstate_()));
            }
        }
    }
}

