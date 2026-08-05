package avicit.myportal.qms.qmsmilitaryqualkeepcheck.service;

import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.exception.UtilsException;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.commons.utils.ComUtil;
import avicit.platform6.commons.utils.JsonUtil;
import avicit.platform6.commons.utils.PojoUtil;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.commons.utils.BusinessUtil;
import avicit.platform6.commons.utils.JsonHelper;
import avicit.platform6.api.bpm.BpmOperateClient;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartBean;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsmilitaryqualkeepcheck.dao.QmsMilitaryQualKeepCheckDAO;
import avicit.myportal.qms.qmsmilitaryqualkeepcheck.dto.QmsMilitaryQualKeepCheckDTO;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.stream.Collectors;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:09
* @类说明：资格保持自查表Service
* @修改记录：
*/
@Service
public class QmsMilitaryQualKeepCheckService {

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualKeepCheckService.class);

	@Autowired
	private QmsMilitaryQualKeepCheckDAO qmsMilitaryQualKeepCheckDAO;

	@Autowired
	private BpmOperateClient bpmOperateClient;

	@Autowired
	private OssClient ossClient;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	*
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsMilitaryQualKeepCheckDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheckByPage(QueryReqBean<QmsMilitaryQualKeepCheckDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualKeepCheckDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualKeepCheckDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualKeepCheckDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualKeepCheckDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsMilitaryQualKeepCheckDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsMilitaryQualKeepCheckDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsMilitaryQualKeepCheckDTO> result = qmsMilitaryQualKeepCheckDAO.searchQmsMilitaryQualKeepCheckByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询，不分页
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualKeepCheckDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheck(QueryReqBean<QmsMilitaryQualKeepCheckDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualKeepCheckDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualKeepCheckDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualKeepCheckDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualKeepCheckDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsMilitaryQualKeepCheckDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsMilitaryQualKeepCheckDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsMilitaryQualKeepCheckDTO> dataList = qmsMilitaryQualKeepCheckDAO.searchQmsMilitaryQualKeepCheck(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualKeepCheckDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheckForExportExcel(QueryReqBean<QmsMilitaryQualKeepCheckDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualKeepCheckDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualKeepCheckDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        queryReqBean.getSearchParams().setCurrUserId(ThreadContextHelper.getUserId());
        List<QmsMilitaryQualKeepCheckDTO> result=qmsMilitaryQualKeepCheckDAO.searchQmsMilitaryQualKeepCheckForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsMilitaryQualKeepCheckDTO
	*/
	@Transactional(readOnly = true)
	public QmsMilitaryQualKeepCheckDTO queryQmsMilitaryQualKeepCheckByPrimaryKey(String id) {
		QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO = qmsMilitaryQualKeepCheckDAO.findQmsMilitaryQualKeepCheckById(id);
		//记录日志
		if (qmsMilitaryQualKeepCheckDTO != null) {
            valueConvert(Arrays.asList(qmsMilitaryQualKeepCheckDTO));
			SysLogUtil.log4Query(qmsMilitaryQualKeepCheckDTO);
		}
		return qmsMilitaryQualKeepCheckDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsMilitaryQualKeepCheckDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsMilitaryQualKeepCheck(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO) {
		if (StringUtils.isEmpty(qmsMilitaryQualKeepCheckDTO.getId())) {
			qmsMilitaryQualKeepCheckDTO.setId(ComUtil.getId());
		}
		PojoUtil.setSysProperties(qmsMilitaryQualKeepCheckDTO, OpType.insert);
		qmsMilitaryQualKeepCheckDAO.insertQmsMilitaryQualKeepCheck(qmsMilitaryQualKeepCheckDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsMilitaryQualKeepCheckDTO);
		return qmsMilitaryQualKeepCheckDTO.getId();

	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsMilitaryQualKeepCheckList(List<QmsMilitaryQualKeepCheckDTO> dtoList) {
		for (QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO : dtoList) {
            qmsMilitaryQualKeepCheckDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsMilitaryQualKeepCheckDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsMilitaryQualKeepCheckDAO.insertQmsMilitaryQualKeepCheckList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsMilitaryQualKeepCheckDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualKeepCheck(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO) {
		return updateDto(qmsMilitaryQualKeepCheckDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsMilitaryQualKeepCheckDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualKeepCheckSensitive(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO) {
		return updateDto(qmsMilitaryQualKeepCheckDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualKeepCheckList(List<QmsMilitaryQualKeepCheckDTO> dtoList) {
		List<QmsMilitaryQualKeepCheckDTO> updateList = new ArrayList<>();
        List<QmsMilitaryQualKeepCheckDTO> oldList = new ArrayList<>();
        for (QmsMilitaryQualKeepCheckDTO dto : dtoList) {
            QmsMilitaryQualKeepCheckDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsMilitaryQualKeepCheckDTO updateDto = (QmsMilitaryQualKeepCheckDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsMilitaryQualKeepCheckDAO.updateQmsMilitaryQualKeepCheckList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
	}

	/**
	* 内部方法，获取修改的qmsMilitaryQualKeepCheck对象
	*
	* @param qmsMilitaryQualKeepCheckDTO
	* @return
	*/
	private QmsMilitaryQualKeepCheckDTO getUpdateDto(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO) {
		QmsMilitaryQualKeepCheckDTO oldDTO = findById(qmsMilitaryQualKeepCheckDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsMilitaryQualKeepCheckDTO, oldDTO);
		PojoUtil.setSysProperties(qmsMilitaryQualKeepCheckDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsMilitaryQualKeepCheckDTO, false);
		return oldDTO;
	}

	/**
	* 按主键单条删除
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteQmsMilitaryQualKeepCheckById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO = findById(id);
		if (qmsMilitaryQualKeepCheckDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsMilitaryQualKeepCheckDTO);
		//删除业务数据
		int count = qmsMilitaryQualKeepCheckDAO.deleteQmsMilitaryQualKeepCheckById(id);
		//删除关联流程实例
		bpmOperateClient.deleteProcessInstanceByFormId(id);
		//删除附件
		ossClient.deleteAttachByFormId(id);
		return count;
	}

	/**
	* 批量删除数据
	*
	* @param ids 逗号分隔的id串
	* @return int
	*/
	@Transactional
	public int deleteQmsMilitaryQualKeepCheckByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			//删除业务数据
			deleteQmsMilitaryQualKeepCheckById(id);
			result++;
		}
		return result;
	}

	/**
	* 流程服务回调方法（按主表主键单条删除业务数据）
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteDataQmsMilitaryQualKeepCheckById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		try {
			//记录日志
			QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO = findById(id);
			if (qmsMilitaryQualKeepCheckDTO == null) {
				throw new BusinessException("删除失败！对象不存在");
			}
			SysLogUtil.log4Delete(qmsMilitaryQualKeepCheckDTO);
			//删除业务数据
			int count = qmsMilitaryQualKeepCheckDAO.deleteQmsMilitaryQualKeepCheckById(id);
			//删除附件
			ossClient.deleteAttachByFormId(id);
			return count;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}

	/**
	* 保存表单并启动流程
	*
	* @param qmsMilitaryQualKeepCheckDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsMilitaryQualKeepCheckAndStartProcess(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsMilitaryQualKeepCheck(qmsMilitaryQualKeepCheckDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsMilitaryQualKeepCheckDTO);
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
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsMilitaryQualKeepCheckDTO
	*/
	private QmsMilitaryQualKeepCheckDTO findById(String id) {
		return qmsMilitaryQualKeepCheckDAO.findQmsMilitaryQualKeepCheckById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsMilitaryQualKeepCheckDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsMilitaryQualKeepCheckDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsMilitaryQualKeepCheckDTO updateDto = (QmsMilitaryQualKeepCheckDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsMilitaryQualKeepCheckDAO.updateQmsMilitaryQualKeepCheckAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsMilitaryQualKeepCheckDAO.updateQmsMilitaryQualKeepCheckSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
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
     * @param qmsMilitaryQualKeepCheckDTOList
     */
    private void valueConvert(List<QmsMilitaryQualKeepCheckDTO> qmsMilitaryQualKeepCheckDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheck : qmsMilitaryQualKeepCheckDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualKeepCheck.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheck : qmsMilitaryQualKeepCheckDTOList) {
                qmsMilitaryQualKeepCheck.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualKeepCheck.getSecretLevel()));
                //流程的编码转换成名称
                qmsMilitaryQualKeepCheck.setBpmState(qmsMilitaryQualKeepCheck.getBusinessstate_());
			    qmsMilitaryQualKeepCheck.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsMilitaryQualKeepCheck.getBusinessstate_()));
            }
        }
    }
}

