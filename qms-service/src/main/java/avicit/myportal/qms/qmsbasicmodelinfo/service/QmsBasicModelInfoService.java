package avicit.myportal.qms.qmsbasicmodelinfo.service;

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
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsbasicmodelinfo.dao.QmsBasicModelInfoDAO;
import avicit.myportal.qms.qmsbasicmodelinfo.dto.QmsBasicModelInfoDTO;
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
* @创建时间： 2026-08-03 19:25
* @类说明：QMS_BASIC_MODEL_INFOService
* @修改记录：
*/
@Service
public class QmsBasicModelInfoService {

	private static final Logger logger = LoggerFactory.getLogger(QmsBasicModelInfoService.class);

	@Autowired
	private QmsBasicModelInfoDAO qmsBasicModelInfoDAO;

	@Autowired
	private BpmOperateClient bpmOperateClient;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	*
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsBasicModelInfoDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsBasicModelInfoDTO> searchQmsBasicModelInfoByPage(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
		QueryRespBean<QmsBasicModelInfoDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsBasicModelInfoDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsBasicModelInfoDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsBasicModelInfoDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsBasicModelInfoDTO> result = qmsBasicModelInfoDAO.searchQmsBasicModelInfoByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询，不分页
	*
	* @param queryReqBean 查询条件
	* @return List<QmsBasicModelInfoDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfo(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
		QueryRespBean<QmsBasicModelInfoDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsBasicModelInfoDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsBasicModelInfoDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsBasicModelInfoDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsBasicModelInfoDTO> dataList = qmsBasicModelInfoDAO.searchQmsBasicModelInfo(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsBasicModelInfoDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfoForExportExcel(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        queryReqBean.getSearchParams().setCurrUserId(ThreadContextHelper.getUserId());
        List<QmsBasicModelInfoDTO> result=qmsBasicModelInfoDAO.searchQmsBasicModelInfoForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsBasicModelInfoDTO
	*/
	@Transactional(readOnly = true)
	public QmsBasicModelInfoDTO queryQmsBasicModelInfoByPrimaryKey(String id) {
		QmsBasicModelInfoDTO qmsBasicModelInfoDTO = qmsBasicModelInfoDAO.findQmsBasicModelInfoById(id);
		//记录日志
		if (qmsBasicModelInfoDTO != null) {
            valueConvert(Arrays.asList(qmsBasicModelInfoDTO));
			SysLogUtil.log4Query(qmsBasicModelInfoDTO);
		}
		return qmsBasicModelInfoDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsBasicModelInfoDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsBasicModelInfo(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
		if (StringUtils.isEmpty(qmsBasicModelInfoDTO.getId())) {
			qmsBasicModelInfoDTO.setId(ComUtil.getId());
		}
		PojoUtil.setSysProperties(qmsBasicModelInfoDTO, OpType.insert);
		qmsBasicModelInfoDAO.insertQmsBasicModelInfo(qmsBasicModelInfoDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsBasicModelInfoDTO);
		return qmsBasicModelInfoDTO.getId();

	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsBasicModelInfoList(List<QmsBasicModelInfoDTO> dtoList) {
		for (QmsBasicModelInfoDTO qmsBasicModelInfoDTO : dtoList) {
            qmsBasicModelInfoDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsBasicModelInfoDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsBasicModelInfoDAO.insertQmsBasicModelInfoList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsBasicModelInfoDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsBasicModelInfo(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
		return updateDto(qmsBasicModelInfoDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsBasicModelInfoDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsBasicModelInfoSensitive(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
		return updateDto(qmsBasicModelInfoDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsBasicModelInfoList(List<QmsBasicModelInfoDTO> dtoList) {
		List<QmsBasicModelInfoDTO> updateList = new ArrayList<>();
        List<QmsBasicModelInfoDTO> oldList = new ArrayList<>();
        for (QmsBasicModelInfoDTO dto : dtoList) {
            QmsBasicModelInfoDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsBasicModelInfoDTO updateDto = (QmsBasicModelInfoDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsBasicModelInfoDAO.updateQmsBasicModelInfoList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
	}

	/**
	* 内部方法，获取修改的qmsBasicModelInfo对象
	*
	* @param qmsBasicModelInfoDTO
	* @return
	*/
	private QmsBasicModelInfoDTO getUpdateDto(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
		QmsBasicModelInfoDTO oldDTO = findById(qmsBasicModelInfoDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsBasicModelInfoDTO, oldDTO);
		PojoUtil.setSysProperties(qmsBasicModelInfoDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsBasicModelInfoDTO, false);
		return oldDTO;
	}

	/**
	* 按主键单条删除
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteQmsBasicModelInfoById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsBasicModelInfoDTO qmsBasicModelInfoDTO = findById(id);
		if (qmsBasicModelInfoDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsBasicModelInfoDTO);
		//删除业务数据
		int count = qmsBasicModelInfoDAO.deleteQmsBasicModelInfoById(id);
		//删除关联流程实例
		bpmOperateClient.deleteProcessInstanceByFormId(id);
		return count;
	}

	/**
	* 批量删除数据
	*
	* @param ids 逗号分隔的id串
	* @return int
	*/
	@Transactional
	public int deleteQmsBasicModelInfoByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			//删除业务数据
			deleteQmsBasicModelInfoById(id);
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
	public int deleteDataQmsBasicModelInfoById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		try {
			//记录日志
			QmsBasicModelInfoDTO qmsBasicModelInfoDTO = findById(id);
			if (qmsBasicModelInfoDTO == null) {
				throw new BusinessException("删除失败！对象不存在");
			}
			SysLogUtil.log4Delete(qmsBasicModelInfoDTO);
			//删除业务数据
			int count = qmsBasicModelInfoDAO.deleteQmsBasicModelInfoById(id);
			return count;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}

	/**
	* 保存表单并启动流程
	*
	* @param qmsBasicModelInfoDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsBasicModelInfoAndStartProcess(QmsBasicModelInfoDTO qmsBasicModelInfoDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsBasicModelInfo(qmsBasicModelInfoDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsBasicModelInfoDTO);
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
	* @return QmsBasicModelInfoDTO
	*/
	private QmsBasicModelInfoDTO findById(String id) {
		return qmsBasicModelInfoDAO.findQmsBasicModelInfoById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsBasicModelInfoDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsBasicModelInfoDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsBasicModelInfoDTO updateDto = (QmsBasicModelInfoDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsBasicModelInfoDAO.updateQmsBasicModelInfoAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsBasicModelInfoDAO.updateQmsBasicModelInfoSensitive(dto);
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
     * @param qmsBasicModelInfoDTOList
     */
    private void valueConvert(List<QmsBasicModelInfoDTO> qmsBasicModelInfoDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsBasicModelInfoDTO qmsBasicModelInfo : qmsBasicModelInfoDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsBasicModelInfo.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsBasicModelInfoDTO qmsBasicModelInfo : qmsBasicModelInfoDTOList) {
                qmsBasicModelInfo.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsBasicModelInfo.getSecretLevel()));
                //流程的编码转换成名称
                qmsBasicModelInfo.setBpmState(qmsBasicModelInfo.getBusinessstate_());
			    qmsBasicModelInfo.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsBasicModelInfo.getBusinessstate_()));
            }
        }
    }
}

