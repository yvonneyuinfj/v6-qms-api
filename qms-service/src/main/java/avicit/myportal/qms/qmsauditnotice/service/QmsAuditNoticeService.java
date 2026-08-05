package avicit.myportal.qms.qmsauditnotice.service;

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
import avicit.myportal.qms.qmsauditnotice.dao.QmsAuditNoticeDAO;
import avicit.myportal.qms.qmsauditnotice.dto.QmsAuditNoticeDTO;
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
* @创建时间： 2026-08-03 19:30
* @类说明：内审通知单Service
* @修改记录：
*/
@Service
public class QmsAuditNoticeService {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditNoticeService.class);

	@Autowired
	private QmsAuditNoticeDAO qmsAuditNoticeDAO;

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
	* @return QueryRespBean<QmsAuditNoticeDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsAuditNoticeDTO> searchQmsAuditNoticeByPage(QueryReqBean<QmsAuditNoticeDTO> queryReqBean) {
		QueryRespBean<QmsAuditNoticeDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditNoticeDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNoticeDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNoticeDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsAuditNoticeDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsAuditNoticeDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsAuditNoticeDTO> result = qmsAuditNoticeDAO.searchQmsAuditNoticeByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询，不分页
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditNoticeDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditNoticeDTO> searchQmsAuditNotice(QueryReqBean<QmsAuditNoticeDTO> queryReqBean) {
		QueryRespBean<QmsAuditNoticeDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditNoticeDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNoticeDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNoticeDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsAuditNoticeDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsAuditNoticeDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsAuditNoticeDTO> dataList = qmsAuditNoticeDAO.searchQmsAuditNotice(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditNoticeDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditNoticeDTO> searchQmsAuditNoticeForExportExcel(QueryReqBean<QmsAuditNoticeDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNoticeDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNoticeDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        queryReqBean.getSearchParams().setCurrUserId(ThreadContextHelper.getUserId());
        List<QmsAuditNoticeDTO> result=qmsAuditNoticeDAO.searchQmsAuditNoticeForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsAuditNoticeDTO
	*/
	@Transactional(readOnly = true)
	public QmsAuditNoticeDTO queryQmsAuditNoticeByPrimaryKey(String id) {
		QmsAuditNoticeDTO qmsAuditNoticeDTO = qmsAuditNoticeDAO.findQmsAuditNoticeById(id);
		//记录日志
		if (qmsAuditNoticeDTO != null) {
            valueConvert(Arrays.asList(qmsAuditNoticeDTO));
			SysLogUtil.log4Query(qmsAuditNoticeDTO);
		}
		return qmsAuditNoticeDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsAuditNoticeDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsAuditNotice(QmsAuditNoticeDTO qmsAuditNoticeDTO) {
		if (StringUtils.isEmpty(qmsAuditNoticeDTO.getId())) {
			qmsAuditNoticeDTO.setId(ComUtil.getId());
		}
		PojoUtil.setSysProperties(qmsAuditNoticeDTO, OpType.insert);
		qmsAuditNoticeDAO.insertQmsAuditNotice(qmsAuditNoticeDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsAuditNoticeDTO);
		return qmsAuditNoticeDTO.getId();

	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsAuditNoticeList(List<QmsAuditNoticeDTO> dtoList) {
		for (QmsAuditNoticeDTO qmsAuditNoticeDTO : dtoList) {
            qmsAuditNoticeDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsAuditNoticeDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsAuditNoticeDAO.insertQmsAuditNoticeList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsAuditNoticeDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNotice(QmsAuditNoticeDTO qmsAuditNoticeDTO) {
		return updateDto(qmsAuditNoticeDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsAuditNoticeDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNoticeSensitive(QmsAuditNoticeDTO qmsAuditNoticeDTO) {
		return updateDto(qmsAuditNoticeDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNoticeList(List<QmsAuditNoticeDTO> dtoList) {
		List<QmsAuditNoticeDTO> updateList = new ArrayList<>();
        List<QmsAuditNoticeDTO> oldList = new ArrayList<>();
        for (QmsAuditNoticeDTO dto : dtoList) {
            QmsAuditNoticeDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsAuditNoticeDTO updateDto = (QmsAuditNoticeDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsAuditNoticeDAO.updateQmsAuditNoticeList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
	}

	/**
	* 内部方法，获取修改的qmsAuditNotice对象
	*
	* @param qmsAuditNoticeDTO
	* @return
	*/
	private QmsAuditNoticeDTO getUpdateDto(QmsAuditNoticeDTO qmsAuditNoticeDTO) {
		QmsAuditNoticeDTO oldDTO = findById(qmsAuditNoticeDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsAuditNoticeDTO, oldDTO);
		PojoUtil.setSysProperties(qmsAuditNoticeDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsAuditNoticeDTO, false);
		return oldDTO;
	}

	/**
	* 按主键单条删除
	*
	* @param id 主键id
	* @return int
	*/
	@Transactional
	public int deleteQmsAuditNoticeById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsAuditNoticeDTO qmsAuditNoticeDTO = findById(id);
		if (qmsAuditNoticeDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsAuditNoticeDTO);
		//删除业务数据
		int count = qmsAuditNoticeDAO.deleteQmsAuditNoticeById(id);
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
	public int deleteQmsAuditNoticeByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			//删除业务数据
			deleteQmsAuditNoticeById(id);
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
	public int deleteDataQmsAuditNoticeById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		try {
			//记录日志
			QmsAuditNoticeDTO qmsAuditNoticeDTO = findById(id);
			if (qmsAuditNoticeDTO == null) {
				throw new BusinessException("删除失败！对象不存在");
			}
			SysLogUtil.log4Delete(qmsAuditNoticeDTO);
			//删除业务数据
			int count = qmsAuditNoticeDAO.deleteQmsAuditNoticeById(id);
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
	* @param qmsAuditNoticeDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsAuditNoticeAndStartProcess(QmsAuditNoticeDTO qmsAuditNoticeDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsAuditNotice(qmsAuditNoticeDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsAuditNoticeDTO);
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
	* @return QmsAuditNoticeDTO
	*/
	private QmsAuditNoticeDTO findById(String id) {
		return qmsAuditNoticeDAO.findQmsAuditNoticeById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsAuditNoticeDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsAuditNoticeDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsAuditNoticeDTO updateDto = (QmsAuditNoticeDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsAuditNoticeDAO.updateQmsAuditNoticeAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsAuditNoticeDAO.updateQmsAuditNoticeSensitive(dto);
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
     * @param qmsAuditNoticeDTOList
     */
    private void valueConvert(List<QmsAuditNoticeDTO> qmsAuditNoticeDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsAuditNoticeDTO qmsAuditNotice : qmsAuditNoticeDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditNotice.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsAuditNoticeDTO qmsAuditNotice : qmsAuditNoticeDTOList) {
                qmsAuditNotice.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditNotice.getSecretLevel()));
                //流程的编码转换成名称
                qmsAuditNotice.setBpmState(qmsAuditNotice.getBusinessstate_());
			    qmsAuditNotice.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsAuditNotice.getBusinessstate_()));
            }
        }
    }
}

