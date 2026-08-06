package avicit.myportal.qms.qmsqualityreward.service;

import avicit.myportal.qms.qmsqualityreward.dao.QmsQualityRewardDAO;
import avicit.myportal.qms.qmsqualityreward.dto.QmsQualityRewardDTO;
import avicit.myportal.qms.qmsqualityrewardcontributeor.dto.QmsQualityRewardContributeorDTO;
import avicit.myportal.qms.qmsqualityrewardcontributeor.service.QmsQualityRewardContributeorService;
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
* @创建时间： 2026-08-06 17:03
* @类说明：质量奖励申请表Service
* @修改记录：
*/
@Service
public class QmsQualityRewardService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityRewardService.class);

	@Autowired
	private QmsQualityRewardDAO qmsQualityRewardDAO;

	@Autowired
	private OssClient ossClient;

	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private BpmOperateClient bpmOperateClient;

	@Autowired
	private QmsQualityRewardContributeorService qmsQualityRewardContributeorService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualityRewardDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualityRewardDTO> searchQmsQualityRewardByPage(QueryReqBean<QmsQualityRewardDTO> queryReqBean) {
		QueryRespBean<QmsQualityRewardDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityRewardDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityRewardDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityRewardDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsQualityRewardDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsQualityRewardDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityRewardDTO> result = qmsQualityRewardDAO.searchQmsQualityRewardByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityRewardDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityRewardDTO> searchQmsQualityReward(QueryReqBean<QmsQualityRewardDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityRewardDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityRewardDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityRewardDTO>() {
            });
            searchKeyWordParam.setBpmState(queryReqBean.getSearchParams().getBpmState());
            searchKeyWordParam.setBpmType(queryReqBean.getSearchParams().getBpmType());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        //设置流程查询条件
        QmsQualityRewardDTO searchParams = queryReqBean.getSearchParams();
        if (searchParams == null) {
            searchParams = new QmsQualityRewardDTO();
        }
        searchParams.setCurrUserId(ThreadContextHelper.getUserId());
        if (StringUtils.isEmpty(searchParams.getBpmType())) {
            searchParams.setBpmType("my");
        }
        queryReqBean.setSearchParams(searchParams);
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();
        List<QmsQualityRewardDTO> dataList = qmsQualityRewardDAO.searchQmsQualityReward(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
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
	* @return List<QmsQualityRewardDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityRewardDTO> searchQmsQualityRewardForExportExcel(QueryReqBean<QmsQualityRewardDTO> queryReqBean, String orgIdentity, List<String> wordSecret, String orderBy) {
		return qmsQualityRewardDAO.searchQmsQualityRewardForExportExcel(queryReqBean.getSearchParams(), orgIdentity, wordSecret, orderBy, queryReqBean.getKeyWord());
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualityRewardDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualityRewardDTO queryQmsQualityRewardByPrimaryKey(String id) {
		QmsQualityRewardDTO qmsQualityRewardDTO = qmsQualityRewardDAO.findQmsQualityRewardById(id);
		//记录日志
		if (qmsQualityRewardDTO != null) {
            valueConvert(Arrays.asList(qmsQualityRewardDTO));
			SysLogUtil.log4Query(qmsQualityRewardDTO);
		}
		return qmsQualityRewardDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualityRewardDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualityReward(QmsQualityRewardDTO qmsQualityRewardDTO) {
        if (StringUtils.isEmpty(qmsQualityRewardDTO.getId())) {
            qmsQualityRewardDTO.setId(ComUtil.getId());
        }
		PojoUtil.setSysProperties(qmsQualityRewardDTO, OpType.insert);
		qmsQualityRewardDAO.insertQmsQualityReward(qmsQualityRewardDTO);
        // 新增或修改子表对象集合
        insertOrUpdateQmsQualityRewardContributeor(qmsQualityRewardDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualityRewardDTO);
		return qmsQualityRewardDTO.getId();
	}

	/**
	* 保存表单并启动流程
	*
	* @param qmsQualityRewardDTO 表单对象
	* @param parameter                 启动流程所需要的参数
	* @return StartResultBean
	*/
	@Transactional
	public StartResultBean insertQmsQualityRewardAndStartProcess(QmsQualityRewardDTO qmsQualityRewardDTO, Map<String, String> parameter) {
		Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
		String processDefId = parameter.get("processDefId");
		String formCode = parameter.get("formCode");
		String jsonString = parameter.get("jsonString");
		String userId = parameter.get("userId");
		String deptId = parameter.get("deptId");
		Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
		//业务操作
		this.insertQmsQualityReward(qmsQualityRewardDTO);
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
			pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsQualityRewardDTO);
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
	public int insertQmsQualityRewardList(List<QmsQualityRewardDTO> dtoList) {
		for (QmsQualityRewardDTO qmsQualityRewardDTO : dtoList) {
            qmsQualityRewardDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityRewardDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityRewardDAO.insertQmsQualityRewardList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualityRewardDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityReward(QmsQualityRewardDTO qmsQualityRewardDTO) {
        return updateDto(qmsQualityRewardDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualityRewardDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityRewardSensitive(QmsQualityRewardDTO qmsQualityRewardDTO) {
        return updateDto(qmsQualityRewardDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualityRewardDTO
	* @return
	*/
	private QmsQualityRewardDTO getUpdateMainDto(QmsQualityRewardDTO qmsQualityRewardDTO) {
		QmsQualityRewardDTO oldDTO = findById(qmsQualityRewardDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualityRewardDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualityRewardDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualityRewardDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualityRewardList(List<QmsQualityRewardDTO> dtoList) {
		List<QmsQualityRewardDTO> updateList = new ArrayList<>();
        List<QmsQualityRewardDTO> oldList = new ArrayList<>();
        for (QmsQualityRewardDTO dto : dtoList) {
            QmsQualityRewardDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityRewardDTO updateDto = (QmsQualityRewardDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityRewardDAO.updateQmsQualityRewardList(subList);
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
	public int deleteQmsQualityRewardById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualityRewardDTO qmsQualityRewardDTO = findById(id);
		if (qmsQualityRewardDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualityRewardDTO);
		//删除子表
		for (QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO : qmsQualityRewardContributeorService.queryQmsQualityRewardContributeorByPid(qmsQualityRewardDTO.getId())) {
			qmsQualityRewardContributeorService.deleteQmsQualityRewardContributeor(qmsQualityRewardContributeorDTO);
		}
		//删除业务数据
		int count = qmsQualityRewardDAO.deleteQmsQualityRewardById(id);
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
	public int deleteQmsQualityRewardByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualityRewardById(id);
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
    public int deleteDataQmsQualityRewardById(String id){
 		if (StringUtils.isEmpty(id)) {
 			throw new BusinessException("删除失败！传入的参数主键为null");
 		}
 		//记录日志
 		QmsQualityRewardDTO qmsQualityRewardDTO = findById(id);
 		if (qmsQualityRewardDTO == null) {
 			throw new BusinessException("删除失败！对象不存在");
 		}
 		SysLogUtil.log4Delete(qmsQualityRewardDTO);
		//删除子表
		for (QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO : qmsQualityRewardContributeorService.queryQmsQualityRewardContributeorByPid(qmsQualityRewardDTO.getId())) {
			qmsQualityRewardContributeorService.deleteQmsQualityRewardContributeor(qmsQualityRewardContributeorDTO);
		}
 		//删除业务数据
 		int count = qmsQualityRewardDAO.deleteQmsQualityRewardById(id);
 		//删除附件
 		ossClient.deleteAttachByFormId(id);
 		return count;
    }

    /**
     * 新增或修改子表对象集合
     * @param qmsQualityRewardDTO 新增对象
     */
    private void insertOrUpdateQmsQualityRewardContributeor(QmsQualityRewardDTO qmsQualityRewardDTO) {
        ValidationList<QmsQualityRewardContributeorDTO> qmsQualityRewardContributeorList = qmsQualityRewardDTO.getQmsQualityRewardContributeorList();
        if(!CollectionUtils.isEmpty(qmsQualityRewardContributeorList)) {
            for(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO : qmsQualityRewardContributeorList){
                if(StringUtils.equals(OpType.delete.toString(), qmsQualityRewardContributeorDTO.getOperationType_())) {
                    qmsQualityRewardContributeorService.deleteQmsQualityRewardContributeorById(qmsQualityRewardContributeorDTO.getId());
                } else if(StringUtils.equals(OpType.update.toString(), qmsQualityRewardContributeorDTO.getOperationType_())) {
                    qmsQualityRewardContributeorService.updateQmsQualityRewardContributeorSensitive(qmsQualityRewardContributeorDTO);
                } else {
                    qmsQualityRewardContributeorDTO.setRewardId(qmsQualityRewardDTO.getId());
                    qmsQualityRewardContributeorDTO.setOrgIdentity(qmsQualityRewardDTO.getOrgIdentity());
                    qmsQualityRewardContributeorService.insertQmsQualityRewardContributeor(qmsQualityRewardContributeorDTO);
                }
            }
        }
    }

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualityRewardDTO
	*/
	private QmsQualityRewardDTO findById(String id) {
		return qmsQualityRewardDAO.findQmsQualityRewardById(id);
	}

	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityRewardDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityRewardDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityRewardDTO updateDto = (QmsQualityRewardDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityRewardDAO.updateQmsQualityRewardAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityRewardDAO.updateQmsQualityRewardSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        // 新增或修改子表对象集合
        insertOrUpdateQmsQualityRewardContributeor(dto);
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
     * @param qmsQualityRewardDTOList
     */
    private void valueConvert(List<QmsQualityRewardDTO> qmsQualityRewardDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityRewardDTO qmsQualityReward : qmsQualityRewardDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityReward.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityRewardDTO qmsQualityReward : qmsQualityRewardDTOList) {
                qmsQualityReward.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityReward.getSecretLevel()));
                //流程的编码转换成名称
                qmsQualityReward.setBpmState(qmsQualityReward.getBusinessstate_());
			    qmsQualityReward.setBusinessstate_(BusinessUtil.processStateCode2StateName(qmsQualityReward.getBusinessstate_()));
            }
        }
    }
}

