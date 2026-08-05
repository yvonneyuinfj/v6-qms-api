package avicit.myportal.qms.qmsqualityinspection.service;

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
import avicit.myportal.qms.qmsqualityinspection.dao.QmsQualityInspectionDAO;
import avicit.myportal.qms.qmsqualityinspection.dto.QmsQualityInspectionDTO;
import avicit.myportal.qms.qmsqualityinspection.dto.QmsQualityInspectionImportDTO;
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemDTO;
import avicit.myportal.qms.qmscheckproblem.service.QmsCheckProblemService;
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
* @创建时间： 2026-08-05 18:15
* @类说明：质量检查表Service
* @修改记录：
*/
@Service
public class QmsQualityInspectionService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityInspectionService.class);

	@Autowired
	private QmsQualityInspectionDAO qmsQualityInspectionDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private QmsCheckProblemService qmsCheckProblemService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualityInspectionDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualityInspectionDTO> searchQmsQualityInspectionByPage(QueryReqBean<QmsQualityInspectionDTO> queryReqBean) {
		QueryRespBean<QmsQualityInspectionDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityInspectionDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityInspectionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityInspectionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityInspectionDTO> result = qmsQualityInspectionDAO.searchQmsQualityInspectionByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityInspectionDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityInspectionDTO> searchQmsQualityInspection(QueryReqBean<QmsQualityInspectionDTO> queryReqBean) {
		QueryRespBean<QmsQualityInspectionDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityInspectionDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityInspectionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityInspectionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        QmsQualityInspectionDTO searchParams = queryReqBean.getSearchParams();
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsQualityInspectionDTO> dataList = qmsQualityInspectionDAO.searchQmsQualityInspection(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityInspectionDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityInspectionDTO> searchQmsQualityInspectionForExportExcel(QueryReqBean<QmsQualityInspectionDTO> queryReqBean) {
		if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityInspectionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityInspectionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualityInspectionDTO> result=qmsQualityInspectionDAO.searchQmsQualityInspectionForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualityInspectionDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualityInspectionDTO queryQmsQualityInspectionByPrimaryKey(String id) {
		QmsQualityInspectionDTO qmsQualityInspectionDTO = qmsQualityInspectionDAO.findQmsQualityInspectionById(id);
		//记录日志
		if (qmsQualityInspectionDTO != null) {
            valueConvert(Arrays.asList(qmsQualityInspectionDTO));
			SysLogUtil.log4Query(qmsQualityInspectionDTO);
		}
		return qmsQualityInspectionDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualityInspectionDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualityInspection(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
		qmsQualityInspectionDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsQualityInspectionDTO, OpType.insert);
		qmsQualityInspectionDAO.insertQmsQualityInspection(qmsQualityInspectionDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualityInspectionDTO);
		return qmsQualityInspectionDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsQualityInspectionList(List<QmsQualityInspectionDTO> dtoList) {
		for (QmsQualityInspectionDTO qmsQualityInspectionDTO : dtoList) {
            qmsQualityInspectionDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityInspectionDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityInspectionDAO.insertQmsQualityInspectionList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualityInspectionDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityInspection(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
        return updateDto(qmsQualityInspectionDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualityInspectionDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityInspectionSensitive(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
        return updateDto(qmsQualityInspectionDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualityInspectionDTO
	* @return
	*/
	private QmsQualityInspectionDTO getUpdateMainDto(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
		QmsQualityInspectionDTO oldDTO = findById(qmsQualityInspectionDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualityInspectionDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualityInspectionDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualityInspectionDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualityInspectionList(List<QmsQualityInspectionDTO> dtoList) {
		List<QmsQualityInspectionDTO> updateList = new ArrayList<>();
        List<QmsQualityInspectionDTO> oldList = new ArrayList<>();
        for (QmsQualityInspectionDTO dto : dtoList) {
            QmsQualityInspectionDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityInspectionDTO updateDto = (QmsQualityInspectionDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityInspectionDAO.updateQmsQualityInspectionList(subList);
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
	public int deleteQmsQualityInspectionById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualityInspectionDTO qmsQualityInspectionDTO = findById(id);
		if (qmsQualityInspectionDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualityInspectionDTO);
		//删除子表
		for (QmsCheckProblemDTO qmsCheckProblemDTO : qmsCheckProblemService.queryQmsCheckProblemByPid(qmsQualityInspectionDTO.getId())) {
			qmsCheckProblemService.deleteQmsCheckProblem(qmsCheckProblemDTO);
		}
		//删除业务数据
		int count = qmsQualityInspectionDAO.deleteQmsQualityInspectionById(id);
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
	public int deleteQmsQualityInspectionByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualityInspectionById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualityInspectionDTO
	*/
	private QmsQualityInspectionDTO findById(String id) {
		return qmsQualityInspectionDAO.findQmsQualityInspectionById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityInspectionDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityInspectionDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityInspectionDTO updateDto = (QmsQualityInspectionDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityInspectionDAO.updateQmsQualityInspectionAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityInspectionDAO.updateQmsQualityInspectionSensitive(dto);
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
   		List<QmsQualityInspectionDTO> qmsQualityInspectionSuccessList = new ArrayList<QmsQualityInspectionDTO>();
   		List<QmsQualityInspectionImportDTO> qmsQualityInspectionErrList = new ArrayList<QmsQualityInspectionImportDTO>();
   		Map<String, Object> formDataMap = new HashMap<String,Object>();
   		if(StringUtils.isNotEmpty(formData)){
   			formDataMap = JsonUtil.parseJSON2Map(formData);
   		}
   		if(!CollectionUtils.isEmpty(dataList)){
           Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        for (Map<String, String> data:dataList) {
            if(StringUtils.isEmpty(data.get("errorInfo"))){
                //业务校验
                QmsQualityInspectionDTO dto = new QmsQualityInspectionDTO();
                Map2Bo.map2Pojo(data,dto);
                qmsQualityInspectionSuccessList.add(dto);
            } else {
                QmsQualityInspectionImportDTO dtoImp = new QmsQualityInspectionImportDTO();
                Map2Bo.map2Pojo(data,dtoImp);
                qmsQualityInspectionErrList.add(dtoImp);
            }
        }
           this.revValueConvert(qmsQualityInspectionSuccessList, convertResultData);
        this.insertQmsQualityInspectionList(qmsQualityInspectionSuccessList);
    }
   		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualityInspectionSuccessList,qmsQualityInspectionErrList,QmsQualityInspectionImportDTO.class,formDataMap);
   		return excelImport;
   	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityInspectionDTOList
     */
    private void valueConvert(List<QmsQualityInspectionDTO> qmsQualityInspectionDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityInspectionDTO qmsQualityInspection : qmsQualityInspectionDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityInspection.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityInspectionDTO qmsQualityInspection : qmsQualityInspectionDTOList) {
                qmsQualityInspection.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityInspection.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityInspectionDTOList
     */
    private void revValueConvert(List<QmsQualityInspectionDTO> qmsQualityInspectionDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsQualityInspectionDTO qmsQualityInspection : qmsQualityInspectionDTOList) {
            qmsQualityInspection.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityInspection.getSecretLevelName()));
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

