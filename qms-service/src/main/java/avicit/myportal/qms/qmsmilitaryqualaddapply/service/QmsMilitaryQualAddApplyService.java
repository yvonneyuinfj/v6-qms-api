package avicit.myportal.qms.qmsmilitaryqualaddapply.service;

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
import avicit.myportal.qms.qmsmilitaryqualaddapply.dao.QmsMilitaryQualAddApplyDAO;
import avicit.myportal.qms.qmsmilitaryqualaddapply.dto.QmsMilitaryQualAddApplyDTO;
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
* @创建时间： 2026-08-05 18:07
* @类说明：军工资质增项申请Service
* @修改记录：
*/
@Service
public class QmsMilitaryQualAddApplyService {

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualAddApplyService.class);

	@Autowired
	private QmsMilitaryQualAddApplyDAO qmsMilitaryQualAddApplyDAO;

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
	* @return QueryRespBean<QmsMilitaryQualAddApplyDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApplyByPage(QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualAddApplyDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualAddApplyDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualAddApplyDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualAddApplyDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsMilitaryQualAddApplyDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsMilitaryQualAddApplyDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsMilitaryQualAddApplyDTO> result = qmsMilitaryQualAddApplyDAO.searchQmsMilitaryQualAddApplyByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询，不分页
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualAddApplyDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApply(QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualAddApplyDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualAddApplyDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualAddApplyDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualAddApplyDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsMilitaryQualAddApplyDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsMilitaryQualAddApplyDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsMilitaryQualAddApplyDTO> dataList = qmsMilitaryQualAddApplyDAO.searchQmsMilitaryQualAddApply(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualAddApplyDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApplyForExportExcel(QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualAddApplyDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualAddApplyDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        queryReqBean.getSearchParams().setCurrUserId(ThreadContextHelper.getUserId());
        List<QmsMilitaryQualAddApplyDTO> result=qmsMilitaryQualAddApplyDAO.searchQmsMilitaryQualAddApplyForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsMilitaryQualAddApplyDTO
	*/
	@Transactional(readOnly = true)
	public QmsMilitaryQualAddApplyDTO queryQmsMilitaryQualAddApplyByPrimaryKey(String id) {
		QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO = qmsMilitaryQualAddApplyDAO.findQmsMilitaryQualAddApplyById(id);
		//记录日志
		if (qmsMilitaryQualAddApplyDTO != null) {
            valueConvert(Arrays.asList(qmsMilitaryQualAddApplyDTO));
			SysLogUtil.log4Query(qmsMilitaryQualAddApplyDTO);
		}
		return qmsMilitaryQualAddApplyDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsMilitaryQualAddApplyDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsMilitaryQualAddApply(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO) {
		if (StringUtils.isEmpty(qmsMilitaryQualAddApplyDTO.getId())) {
			qmsMilitaryQualAddApplyDTO.setId(ComUtil.getId());
		}
		PojoUtil.setSysProperties(qmsMilitaryQualAddApplyDTO, OpType.insert);
		qmsMilitaryQualAddApplyDAO.insertQmsMilitaryQualAddApply(qmsMilitaryQualAddApplyDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsMilitaryQualAddApplyDTO);
		return qmsMilitaryQualAddApplyDTO.getId();

	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsMilitaryQualAddApplyList(List<QmsMilitaryQualAddApplyDTO> dtoList) {
		for (QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO : dtoList) {
            qmsMilitaryQualAddApplyDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsMilitaryQualAddApplyDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsMilitaryQualAddApplyDAO.insertQmsMilitaryQualAddApplyList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsMilitaryQualAddApplyDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualAddApply(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO) {
		return updateDto(qmsMilitaryQualAddApplyDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsMilitaryQualAddApplyDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualAddApplySensitive(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO) {
		return updateDto(qmsMilitaryQualAddApplyDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualAddApplyList(List<QmsMilitaryQualAddApplyDTO> dtoList) {
		List<QmsMilitaryQualAddApplyDTO> updateList = new ArrayList<>();
        List<QmsMilitaryQualAddApplyDTO> oldList = new ArrayList<>();
        for (QmsMilitaryQualAddApplyDTO dto : dtoList) {
            QmsMilitaryQualAddApplyDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsMilitaryQualAddApplyDTO updateDto = (QmsMilitaryQualAddApplyDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsMilitaryQualAddApplyDAO.updateQmsMilitaryQualAddApplyList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
	}

	/**
	* 内部方法，获取修改的qmsMilitaryQualAddApply对象
	*
	* @param qmsMilitaryQualAddApplyDTO
	* @return
	*/
	private QmsMilitaryQualAddApplyDTO getUpdateDto(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO) {
		QmsMilitaryQualAddApplyDTO oldDTO = findById(qmsMilitaryQualAddApplyDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsMilitaryQualAddApplyDTO, oldDTO);
		PojoUtil.setSysProperties(qmsMilitaryQualAddApplyDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsMilitaryQualAddApplyDTO, false);
		return oldDTO;
	}

	/**
	* 按主键单条删除
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteQmsMilitaryQualAddApplyById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO = findById(id);
		if (qmsMilitaryQualAddApplyDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsMilitaryQualAddApplyDTO);
		//删除业务数据
		int count = qmsMilitaryQualAddApplyDAO.deleteQmsMilitaryQualAddApplyById(id);
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
	public int deleteQmsMilitaryQualAddApplyByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			//删除业务数据
			deleteQmsMilitaryQualAddApplyById(id);
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
	public int deleteDataQmsMilitaryQualAddApplyById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		try {
			//记录日志
			QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO = findById(id);
			if (qmsMilitaryQualAddApplyDTO == null) {
				throw new BusinessException("删除失败！对象不存在");
			}
			SysLogUtil.log4Delete(qmsMilitaryQualAddApplyDTO);
			//删除业务数据
			int count = qmsMilitaryQualAddApplyDAO.deleteQmsMilitaryQualAddApplyById(id);
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
	* @param qmsMilitaryQualAddApplyDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsMilitaryQualAddApplyAndStartProcess(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsMilitaryQualAddApply(qmsMilitaryQualAddApplyDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsMilitaryQualAddApplyDTO);
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
	* @return QmsMilitaryQualAddApplyDTO
	*/
	private QmsMilitaryQualAddApplyDTO findById(String id) {
		return qmsMilitaryQualAddApplyDAO.findQmsMilitaryQualAddApplyById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsMilitaryQualAddApplyDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsMilitaryQualAddApplyDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsMilitaryQualAddApplyDTO updateDto = (QmsMilitaryQualAddApplyDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsMilitaryQualAddApplyDAO.updateQmsMilitaryQualAddApplyAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsMilitaryQualAddApplyDAO.updateQmsMilitaryQualAddApplySensitive(dto);
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
     * @param qmsMilitaryQualAddApplyDTOList
     */
    private void valueConvert(List<QmsMilitaryQualAddApplyDTO> qmsMilitaryQualAddApplyDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply : qmsMilitaryQualAddApplyDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualAddApply.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply : qmsMilitaryQualAddApplyDTOList) {
                qmsMilitaryQualAddApply.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualAddApply.getSecretLevel()));
                //流程的编码转换成名称
                qmsMilitaryQualAddApply.setBpmState(qmsMilitaryQualAddApply.getBusinessstate_());
			    qmsMilitaryQualAddApply.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsMilitaryQualAddApply.getBusinessstate_()));
            }
        }
    }
}

