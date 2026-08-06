package avicit.myportal.qms.qmsauditplan.service;

import avicit.myportal.qms.qmsauditplan.dao.QmsAuditPlanDAO;
import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanDTO;
import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanImportDTO;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.commons.utils.*;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.Map2Bo;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.core.exception.BusinessException;
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
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 18:41
* @类说明：年度内审计划及执行主表Service
* @修改记录：
*/
@Service
public class QmsAuditPlanService {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditPlanService.class);

	@Autowired
	private QmsAuditPlanDAO qmsAuditPlanDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsAuditPlanDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsAuditPlanDTO> searchQmsAuditPlanByPage(QueryReqBean<QmsAuditPlanDTO> queryReqBean) {
		QueryRespBean<QmsAuditPlanDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditPlanDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditPlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditPlanDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsAuditPlanDTO> result = qmsAuditPlanDAO.searchQmsAuditPlanByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
		valueConvert(result.getResult());
		queryRespBean.setResult(result);
		return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditPlanDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditPlanDTO> searchQmsAuditPlan(QueryReqBean<QmsAuditPlanDTO> queryReqBean) {
		QueryRespBean<QmsAuditPlanDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditPlanDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditPlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditPlanDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsAuditPlanDTO> dataList = qmsAuditPlanDAO.searchQmsAuditPlan(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
		valueConvert(dataList);
		return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditPlanDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditPlanDTO> searchQmsAuditPlanForExportExcel(QueryReqBean<QmsAuditPlanDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditPlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditPlanDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		List<QmsAuditPlanDTO> result=qmsAuditPlanDAO.searchQmsAuditPlanForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsAuditPlanDTO
	*/
	@Transactional(readOnly = true)
	public QmsAuditPlanDTO queryQmsAuditPlanByPrimaryKey(String id) {
		QmsAuditPlanDTO qmsAuditPlanDTO = qmsAuditPlanDAO.findQmsAuditPlanById(id);
		//记录日志
		if (qmsAuditPlanDTO != null) {
            valueConvert(Arrays.asList(qmsAuditPlanDTO));
			SysLogUtil.log4Query(qmsAuditPlanDTO);
		}
		return qmsAuditPlanDTO;
	}

	/**
	* 新增对象
	*
	* @param qmsAuditPlanDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsAuditPlan(QmsAuditPlanDTO qmsAuditPlanDTO) {
		qmsAuditPlanDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsAuditPlanDTO, OpType.insert);
		qmsAuditPlanDAO.insertQmsAuditPlan(qmsAuditPlanDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsAuditPlanDTO);
		return qmsAuditPlanDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsAuditPlanList(List<QmsAuditPlanDTO> dtoList) {
		for (QmsAuditPlanDTO qmsAuditPlanDTO : dtoList) {
			qmsAuditPlanDTO.setId(ComUtil.getId());
			PojoUtil.setSysProperties(qmsAuditPlanDTO, OpType.insert);
		}
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsAuditPlanDAO.insertQmsAuditPlanList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
		return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsAuditPlanDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditPlan(QmsAuditPlanDTO qmsAuditPlanDTO) {
        return updateDto(qmsAuditPlanDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsAuditPlanDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditPlanSensitive(QmsAuditPlanDTO qmsAuditPlanDTO) {
        return updateDto(qmsAuditPlanDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsAuditPlanList(List<QmsAuditPlanDTO> dtoList) {
		List<QmsAuditPlanDTO> updateList = new ArrayList<>();
        List<QmsAuditPlanDTO> oldList = new ArrayList<>();
		for (QmsAuditPlanDTO dto : dtoList) {
            QmsAuditPlanDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsAuditPlanDTO updateDto = (QmsAuditPlanDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
			updateList.add(updateDto);
            oldList.add(old);
		}
		ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsAuditPlanDAO.updateQmsAuditPlanList(subList);
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
	public int deleteQmsAuditPlanById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsAuditPlanDTO qmsAuditPlanDTO = findById(id);
		if (qmsAuditPlanDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsAuditPlanDTO);
		//删除业务数据
		int count = qmsAuditPlanDAO.deleteQmsAuditPlanById(id);
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
	public int deleteQmsAuditPlanByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsAuditPlanById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsAuditPlanDTO
	*/
	private QmsAuditPlanDTO findById(String id) {
		return qmsAuditPlanDAO.findQmsAuditPlanById(id);
	}
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsAuditPlanDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsAuditPlanDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsAuditPlanDTO updateDto = (QmsAuditPlanDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsAuditPlanDAO.updateQmsAuditPlanAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsAuditPlanDAO.updateQmsAuditPlanSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }
    /**
	 * 批量导入
	 * @return
	 */
	@Transactional
	public ExcelImportResult importData(List<Map<String, String>> dataList, String formData) {
		List<QmsAuditPlanDTO> qmsAuditPlanSuccessList = new ArrayList<QmsAuditPlanDTO>();
		List<QmsAuditPlanImportDTO> qmsAuditPlanErrList = new ArrayList<QmsAuditPlanImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsAuditPlanDTO dto = new QmsAuditPlanDTO();
					Map2Bo.map2Pojo(data,dto);
					qmsAuditPlanSuccessList.add(dto);
				} else {
					QmsAuditPlanImportDTO dtoImp = new QmsAuditPlanImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsAuditPlanErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsAuditPlanSuccessList, convertResultData);
			this.insertQmsAuditPlanList(qmsAuditPlanSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsAuditPlanSuccessList,qmsAuditPlanErrList,QmsAuditPlanImportDTO.class,formDataMap);
		return excelImport;
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

	/**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsAuditPlanDTOList
     */
    private void revValueConvert(List<QmsAuditPlanDTO> qmsAuditPlanDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsAuditPlanDTO qmsAuditPlan : qmsAuditPlanDTOList) {
            qmsAuditPlan.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditPlan.getSecretLevelName()));
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码提前组装数据
     *
     * @param dataList
     */
    private  Map<String, Map<String, String>> assembleData(List<Map<String, String>> dataList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (Map<String, String> data : dataList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", data.get("secretLevelName"));
        }
		return  convertColumnClient.convertCodeToId(convertFormData);
    }
}

