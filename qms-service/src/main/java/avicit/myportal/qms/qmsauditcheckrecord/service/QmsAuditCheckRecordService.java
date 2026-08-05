package avicit.myportal.qms.qmsauditcheckrecord.service;

import avicit.myportal.qms.qmsauditcheckrecord.dao.QmsAuditCheckRecordDAO;
import avicit.myportal.qms.qmsauditcheckrecord.dto.QmsAuditCheckRecordDTO;
import avicit.myportal.qms.qmsauditcheckdetail.dto.QmsAuditCheckDetailDTO;
import avicit.myportal.qms.qmsauditcheckdetail.service.QmsAuditCheckDetailService;
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
* @创建时间： 2026-08-03 19:32
* @类说明：审核记录表Service
* @修改记录：
*/
@Service
public class QmsAuditCheckRecordService {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditCheckRecordService.class);

	@Autowired
	private QmsAuditCheckRecordDAO qmsAuditCheckRecordDAO;

	@Autowired
	private OssClient ossClient;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private BpmOperateClient bpmOperateClient;

	@Autowired
	private QmsAuditCheckDetailService qmsAuditCheckDetailService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsAuditCheckRecordDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecordByPage(QueryReqBean<QmsAuditCheckRecordDTO> queryReqBean) {
		QueryRespBean<QmsAuditCheckRecordDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditCheckRecordDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditCheckRecordDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditCheckRecordDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsAuditCheckRecordDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsAuditCheckRecordDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsAuditCheckRecordDTO> result = qmsAuditCheckRecordDAO.searchQmsAuditCheckRecordByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditCheckRecordDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecord(QueryReqBean<QmsAuditCheckRecordDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditCheckRecordDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditCheckRecordDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditCheckRecordDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsAuditCheckRecordDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsAuditCheckRecordDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();
        List<QmsAuditCheckRecordDTO> dataList = qmsAuditCheckRecordDAO.searchQmsAuditCheckRecord(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
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
	* @return List<QmsAuditCheckRecordDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecordForExportExcel(QueryReqBean<QmsAuditCheckRecordDTO> queryReqBean, String orgIdentity, List<String> wordSecret, String orderBy) {
		return qmsAuditCheckRecordDAO.searchQmsAuditCheckRecordForExportExcel(queryReqBean.getSearchParams(), orgIdentity, wordSecret, orderBy, queryReqBean.getKeyWord());
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsAuditCheckRecordDTO
	*/
	@Transactional(readOnly = true)
	public QmsAuditCheckRecordDTO queryQmsAuditCheckRecordByPrimaryKey(String id) {
		QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO = qmsAuditCheckRecordDAO.findQmsAuditCheckRecordById(id);
		//记录日志
		if (qmsAuditCheckRecordDTO != null) {
            valueConvert(Arrays.asList(qmsAuditCheckRecordDTO));
			SysLogUtil.log4Query(qmsAuditCheckRecordDTO);
		}
		return qmsAuditCheckRecordDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsAuditCheckRecordDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsAuditCheckRecord(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO) {
        if (StringUtils.isEmpty(qmsAuditCheckRecordDTO.getId())) {
            qmsAuditCheckRecordDTO.setId(ComUtil.getId());
        }
		PojoUtil.setSysProperties(qmsAuditCheckRecordDTO, OpType.insert);
		qmsAuditCheckRecordDAO.insertQmsAuditCheckRecord(qmsAuditCheckRecordDTO);
        // 新增或修改子表对象集合
        insertOrUpdateQmsAuditCheckDetail(qmsAuditCheckRecordDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsAuditCheckRecordDTO);
		return qmsAuditCheckRecordDTO.getId();
	}

	/**
	* 保存表单并启动流程
	*
	* @param qmsAuditCheckRecordDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsAuditCheckRecordAndStartProcess(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsAuditCheckRecord(qmsAuditCheckRecordDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsAuditCheckRecordDTO);
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
	public int insertQmsAuditCheckRecordList(List<QmsAuditCheckRecordDTO> dtoList) {
		for (QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO : dtoList) {
            qmsAuditCheckRecordDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsAuditCheckRecordDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsAuditCheckRecordDAO.insertQmsAuditCheckRecordList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsAuditCheckRecordDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditCheckRecord(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO) {
        return updateDto(qmsAuditCheckRecordDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsAuditCheckRecordDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditCheckRecordSensitive(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO) {
        return updateDto(qmsAuditCheckRecordDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsAuditCheckRecordDTO
	* @return
	*/
	private QmsAuditCheckRecordDTO getUpdateMainDto(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO) {
		QmsAuditCheckRecordDTO oldDTO = findById(qmsAuditCheckRecordDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsAuditCheckRecordDTO, oldDTO);
		PojoUtil.setSysProperties(qmsAuditCheckRecordDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsAuditCheckRecordDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsAuditCheckRecordList(List<QmsAuditCheckRecordDTO> dtoList) {
		List<QmsAuditCheckRecordDTO> updateList = new ArrayList<>();
        List<QmsAuditCheckRecordDTO> oldList = new ArrayList<>();
        for (QmsAuditCheckRecordDTO dto : dtoList) {
            QmsAuditCheckRecordDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsAuditCheckRecordDTO updateDto = (QmsAuditCheckRecordDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsAuditCheckRecordDAO.updateQmsAuditCheckRecordList(subList);
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
	public int deleteQmsAuditCheckRecordById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO = findById(id);
		if (qmsAuditCheckRecordDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsAuditCheckRecordDTO);
		//删除子表
		for (QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO : qmsAuditCheckDetailService.queryQmsAuditCheckDetailByPid(qmsAuditCheckRecordDTO.getId())) {
			qmsAuditCheckDetailService.deleteQmsAuditCheckDetail(qmsAuditCheckDetailDTO);
		}
		//删除业务数据
		int count = qmsAuditCheckRecordDAO.deleteQmsAuditCheckRecordById(id);
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
	public int deleteQmsAuditCheckRecordByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsAuditCheckRecordById(id);
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
    public int deleteDataQmsAuditCheckRecordById(String id){
 		if (StringUtils.isEmpty(id)) {
 			throw new BusinessException("删除失败！传入的参数主键为null");
 		}
 		//记录日志
 		QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO = findById(id);
 		if (qmsAuditCheckRecordDTO == null) {
 			throw new BusinessException("删除失败！对象不存在");
 		}
 		SysLogUtil.log4Delete(qmsAuditCheckRecordDTO);
		//删除子表
		for (QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO : qmsAuditCheckDetailService.queryQmsAuditCheckDetailByPid(qmsAuditCheckRecordDTO.getId())) {
			qmsAuditCheckDetailService.deleteQmsAuditCheckDetail(qmsAuditCheckDetailDTO);
		}
 		//删除业务数据
 		int count = qmsAuditCheckRecordDAO.deleteQmsAuditCheckRecordById(id);
 		//删除附件
 		ossClient.deleteAttachByFormId(id);
 		return count;
    }

    /**
     * 新增或修改子表对象集合
     * @param qmsAuditCheckRecordDTO 新增对象
     */
    private void insertOrUpdateQmsAuditCheckDetail(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO) {
        ValidationList<QmsAuditCheckDetailDTO> qmsAuditCheckDetailList = qmsAuditCheckRecordDTO.getQmsAuditCheckDetailList();
        if(!CollectionUtils.isEmpty(qmsAuditCheckDetailList)) {
            for(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO : qmsAuditCheckDetailList){
                if(StringUtils.equals(OpType.delete.toString(), qmsAuditCheckDetailDTO.getOperationType_())) {
                    qmsAuditCheckDetailService.deleteQmsAuditCheckDetailById(qmsAuditCheckDetailDTO.getId());
                } else if(StringUtils.equals(OpType.update.toString(), qmsAuditCheckDetailDTO.getOperationType_())) {
                    qmsAuditCheckDetailService.updateQmsAuditCheckDetailSensitive(qmsAuditCheckDetailDTO);
                } else {
                    qmsAuditCheckDetailDTO.setRecordId(qmsAuditCheckRecordDTO.getId());
                    qmsAuditCheckDetailDTO.setOrgIdentity(qmsAuditCheckRecordDTO.getOrgIdentity());
                    qmsAuditCheckDetailService.insertQmsAuditCheckDetail(qmsAuditCheckDetailDTO);
                }
            }
        }
    }

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsAuditCheckRecordDTO
	*/
	private QmsAuditCheckRecordDTO findById(String id) {
		return qmsAuditCheckRecordDAO.findQmsAuditCheckRecordById(id);
	}

	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsAuditCheckRecordDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsAuditCheckRecordDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsAuditCheckRecordDTO updateDto = (QmsAuditCheckRecordDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsAuditCheckRecordDAO.updateQmsAuditCheckRecordAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsAuditCheckRecordDAO.updateQmsAuditCheckRecordSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        // 新增或修改子表对象集合
        insertOrUpdateQmsAuditCheckDetail(dto);
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
     * @param qmsAuditCheckRecordDTOList
     */
    private void valueConvert(List<QmsAuditCheckRecordDTO> qmsAuditCheckRecordDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsAuditCheckRecordDTO qmsAuditCheckRecord : qmsAuditCheckRecordDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditCheckRecord.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsAuditCheckRecordDTO qmsAuditCheckRecord : qmsAuditCheckRecordDTOList) {
                qmsAuditCheckRecord.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditCheckRecord.getSecretLevel()));
                //流程的编码转换成名称
                qmsAuditCheckRecord.setBpmState(qmsAuditCheckRecord.getBusinessstate_());
			    qmsAuditCheckRecord.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsAuditCheckRecord.getBusinessstate_()));
            }
        }
    }
}

