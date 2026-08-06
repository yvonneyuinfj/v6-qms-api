package avicit.myportal.qms.qmsqualityculture.service;

import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.Map2Bo;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.commons.utils.*;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsqualityculture.dao.QmsQualityCultureDAO;
import avicit.myportal.qms.qmsqualityculture.dto.QmsQualityCultureDTO;
import avicit.myportal.qms.qmsqualityculture.dto.QmsQualityCultureImportDTO;
import avicit.myportal.qms.qmsqualitycultureplan.dto.QmsQualityCulturePlanDTO;
import avicit.myportal.qms.qmsqualitycultureplan.service.QmsQualityCulturePlanService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
* @创建时间： 2026-08-06 15:53
* @类说明：质量文化Service
* @修改记录：
*/
@Service
public class QmsQualityCultureService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityCultureService.class);

	@Autowired
	private QmsQualityCultureDAO qmsQualityCultureDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private QmsQualityCulturePlanService qmsQualityCulturePlanService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualityCultureDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualityCultureDTO> searchQmsQualityCultureByPage(QueryReqBean<QmsQualityCultureDTO> queryReqBean) {
		QueryRespBean<QmsQualityCultureDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityCultureDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityCultureDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityCultureDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityCultureDTO> result = qmsQualityCultureDAO.searchQmsQualityCultureByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityCultureDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityCultureDTO> searchQmsQualityCulture(QueryReqBean<QmsQualityCultureDTO> queryReqBean) {
		QueryRespBean<QmsQualityCultureDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityCultureDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityCultureDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityCultureDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        QmsQualityCultureDTO searchParams = queryReqBean.getSearchParams();
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsQualityCultureDTO> dataList = qmsQualityCultureDAO.searchQmsQualityCulture(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityCultureDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityCultureDTO> searchQmsQualityCultureForExportExcel(QueryReqBean<QmsQualityCultureDTO> queryReqBean) {
		if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityCultureDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityCultureDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualityCultureDTO> result=qmsQualityCultureDAO.searchQmsQualityCultureForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualityCultureDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualityCultureDTO queryQmsQualityCultureByPrimaryKey(String id) {
		QmsQualityCultureDTO qmsQualityCultureDTO = qmsQualityCultureDAO.findQmsQualityCultureById(id);
		//记录日志
		if (qmsQualityCultureDTO != null) {
            valueConvert(Arrays.asList(qmsQualityCultureDTO));
			SysLogUtil.log4Query(qmsQualityCultureDTO);
		}
		return qmsQualityCultureDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualityCultureDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualityCulture(QmsQualityCultureDTO qmsQualityCultureDTO) {
		qmsQualityCultureDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsQualityCultureDTO, OpType.insert);
		qmsQualityCultureDAO.insertQmsQualityCulture(qmsQualityCultureDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualityCultureDTO);
		return qmsQualityCultureDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsQualityCultureList(List<QmsQualityCultureDTO> dtoList) {
		for (QmsQualityCultureDTO qmsQualityCultureDTO : dtoList) {
            qmsQualityCultureDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityCultureDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityCultureDAO.insertQmsQualityCultureList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualityCultureDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityCulture(QmsQualityCultureDTO qmsQualityCultureDTO) {
        return updateDto(qmsQualityCultureDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualityCultureDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityCultureSensitive(QmsQualityCultureDTO qmsQualityCultureDTO) {
        return updateDto(qmsQualityCultureDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualityCultureDTO
	* @return
	*/
	private QmsQualityCultureDTO getUpdateMainDto(QmsQualityCultureDTO qmsQualityCultureDTO) {
		QmsQualityCultureDTO oldDTO = findById(qmsQualityCultureDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualityCultureDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualityCultureDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualityCultureDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualityCultureList(List<QmsQualityCultureDTO> dtoList) {
		List<QmsQualityCultureDTO> updateList = new ArrayList<>();
        List<QmsQualityCultureDTO> oldList = new ArrayList<>();
        for (QmsQualityCultureDTO dto : dtoList) {
            QmsQualityCultureDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityCultureDTO updateDto = (QmsQualityCultureDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityCultureDAO.updateQmsQualityCultureList(subList);
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
	public int deleteQmsQualityCultureById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualityCultureDTO qmsQualityCultureDTO = findById(id);
		if (qmsQualityCultureDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualityCultureDTO);
		//删除子表
		for (QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO : qmsQualityCulturePlanService.queryQmsQualityCulturePlanByPid(qmsQualityCultureDTO.getId())) {
			qmsQualityCulturePlanService.deleteQmsQualityCulturePlan(qmsQualityCulturePlanDTO);
		}
		//删除业务数据
		int count = qmsQualityCultureDAO.deleteQmsQualityCultureById(id);
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
	public int deleteQmsQualityCultureByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualityCultureById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualityCultureDTO
	*/
	private QmsQualityCultureDTO findById(String id) {
		return qmsQualityCultureDAO.findQmsQualityCultureById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityCultureDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityCultureDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityCultureDTO updateDto = (QmsQualityCultureDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityCultureDAO.updateQmsQualityCultureAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityCultureDAO.updateQmsQualityCultureSensitive(dto);
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
   		List<QmsQualityCultureDTO> qmsQualityCultureSuccessList = new ArrayList<QmsQualityCultureDTO>();
   		List<QmsQualityCultureImportDTO> qmsQualityCultureErrList = new ArrayList<QmsQualityCultureImportDTO>();
   		Map<String, Object> formDataMap = new HashMap<String,Object>();
   		if(StringUtils.isNotEmpty(formData)){
   			formDataMap = JsonUtil.parseJSON2Map(formData);
   		}
   		if(!CollectionUtils.isEmpty(dataList)){
           Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        for (Map<String, String> data:dataList) {
            if(StringUtils.isEmpty(data.get("errorInfo"))){
                //业务校验
                QmsQualityCultureDTO dto = new QmsQualityCultureDTO();
                Map2Bo.map2Pojo(data,dto);
                qmsQualityCultureSuccessList.add(dto);
            } else {
                QmsQualityCultureImportDTO dtoImp = new QmsQualityCultureImportDTO();
                Map2Bo.map2Pojo(data,dtoImp);
                qmsQualityCultureErrList.add(dtoImp);
            }
        }
           this.revValueConvert(qmsQualityCultureSuccessList, convertResultData);
        this.insertQmsQualityCultureList(qmsQualityCultureSuccessList);
    }
   		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualityCultureSuccessList,qmsQualityCultureErrList,QmsQualityCultureImportDTO.class,formDataMap);
   		return excelImport;
   	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityCultureDTOList
     */
    private void valueConvert(List<QmsQualityCultureDTO> qmsQualityCultureDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityCultureDTO qmsQualityCulture : qmsQualityCultureDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulture.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityCultureDTO qmsQualityCulture : qmsQualityCultureDTOList) {
                qmsQualityCulture.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulture.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityCultureDTOList
     */
    private void revValueConvert(List<QmsQualityCultureDTO> qmsQualityCultureDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsQualityCultureDTO qmsQualityCulture : qmsQualityCultureDTOList) {
            qmsQualityCulture.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulture.getSecretLevelName()));
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

