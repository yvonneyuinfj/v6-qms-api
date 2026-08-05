package avicit.myportal.qms.qmsqualitysupervision.service;

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
import avicit.myportal.qms.qmsqualitysupervision.dao.QmsQualitySupervisionDAO;
import avicit.myportal.qms.qmsqualitysupervision.dto.QmsQualitySupervisionDTO;
import avicit.myportal.qms.qmsqualitysupervision.dto.QmsQualitySupervisionImportDTO;
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
* @创建时间： 2026-08-05 18:17
* @类说明：质量监督表Service
* @修改记录：
*/
@Service
public class QmsQualitySupervisionService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualitySupervisionService.class);

	@Autowired
	private QmsQualitySupervisionDAO qmsQualitySupervisionDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private QmsCheckProblemService qmsCheckProblemService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualitySupervisionDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualitySupervisionDTO> searchQmsQualitySupervisionByPage(QueryReqBean<QmsQualitySupervisionDTO> queryReqBean) {
		QueryRespBean<QmsQualitySupervisionDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualitySupervisionDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualitySupervisionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualitySupervisionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualitySupervisionDTO> result = qmsQualitySupervisionDAO.searchQmsQualitySupervisionByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualitySupervisionDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualitySupervisionDTO> searchQmsQualitySupervision(QueryReqBean<QmsQualitySupervisionDTO> queryReqBean) {
		QueryRespBean<QmsQualitySupervisionDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualitySupervisionDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualitySupervisionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualitySupervisionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        QmsQualitySupervisionDTO searchParams = queryReqBean.getSearchParams();
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsQualitySupervisionDTO> dataList = qmsQualitySupervisionDAO.searchQmsQualitySupervision(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualitySupervisionDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualitySupervisionDTO> searchQmsQualitySupervisionForExportExcel(QueryReqBean<QmsQualitySupervisionDTO> queryReqBean) {
		if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualitySupervisionDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualitySupervisionDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualitySupervisionDTO> result=qmsQualitySupervisionDAO.searchQmsQualitySupervisionForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualitySupervisionDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualitySupervisionDTO queryQmsQualitySupervisionByPrimaryKey(String id) {
		QmsQualitySupervisionDTO qmsQualitySupervisionDTO = qmsQualitySupervisionDAO.findQmsQualitySupervisionById(id);
		//记录日志
		if (qmsQualitySupervisionDTO != null) {
            valueConvert(Arrays.asList(qmsQualitySupervisionDTO));
			SysLogUtil.log4Query(qmsQualitySupervisionDTO);
		}
		return qmsQualitySupervisionDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualitySupervisionDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualitySupervision(QmsQualitySupervisionDTO qmsQualitySupervisionDTO) {
		qmsQualitySupervisionDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsQualitySupervisionDTO, OpType.insert);
		qmsQualitySupervisionDAO.insertQmsQualitySupervision(qmsQualitySupervisionDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualitySupervisionDTO);
		return qmsQualitySupervisionDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsQualitySupervisionList(List<QmsQualitySupervisionDTO> dtoList) {
		for (QmsQualitySupervisionDTO qmsQualitySupervisionDTO : dtoList) {
            qmsQualitySupervisionDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualitySupervisionDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualitySupervisionDAO.insertQmsQualitySupervisionList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualitySupervisionDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualitySupervision(QmsQualitySupervisionDTO qmsQualitySupervisionDTO) {
        return updateDto(qmsQualitySupervisionDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualitySupervisionDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualitySupervisionSensitive(QmsQualitySupervisionDTO qmsQualitySupervisionDTO) {
        return updateDto(qmsQualitySupervisionDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualitySupervisionDTO
	* @return
	*/
	private QmsQualitySupervisionDTO getUpdateMainDto(QmsQualitySupervisionDTO qmsQualitySupervisionDTO) {
		QmsQualitySupervisionDTO oldDTO = findById(qmsQualitySupervisionDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualitySupervisionDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualitySupervisionDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualitySupervisionDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualitySupervisionList(List<QmsQualitySupervisionDTO> dtoList) {
		List<QmsQualitySupervisionDTO> updateList = new ArrayList<>();
        List<QmsQualitySupervisionDTO> oldList = new ArrayList<>();
        for (QmsQualitySupervisionDTO dto : dtoList) {
            QmsQualitySupervisionDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualitySupervisionDTO updateDto = (QmsQualitySupervisionDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualitySupervisionDAO.updateQmsQualitySupervisionList(subList);
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
	public int deleteQmsQualitySupervisionById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualitySupervisionDTO qmsQualitySupervisionDTO = findById(id);
		if (qmsQualitySupervisionDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualitySupervisionDTO);
		//删除子表
		for (QmsCheckProblemDTO qmsCheckProblemDTO : qmsCheckProblemService.queryQmsCheckProblemByPid(qmsQualitySupervisionDTO.getId())) {
			qmsCheckProblemService.deleteQmsCheckProblem(qmsCheckProblemDTO);
		}
		//删除业务数据
		int count = qmsQualitySupervisionDAO.deleteQmsQualitySupervisionById(id);
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
	public int deleteQmsQualitySupervisionByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualitySupervisionById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualitySupervisionDTO
	*/
	private QmsQualitySupervisionDTO findById(String id) {
		return qmsQualitySupervisionDAO.findQmsQualitySupervisionById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualitySupervisionDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualitySupervisionDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualitySupervisionDTO updateDto = (QmsQualitySupervisionDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualitySupervisionDAO.updateQmsQualitySupervisionAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualitySupervisionDAO.updateQmsQualitySupervisionSensitive(dto);
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
   		List<QmsQualitySupervisionDTO> qmsQualitySupervisionSuccessList = new ArrayList<QmsQualitySupervisionDTO>();
   		List<QmsQualitySupervisionImportDTO> qmsQualitySupervisionErrList = new ArrayList<QmsQualitySupervisionImportDTO>();
   		Map<String, Object> formDataMap = new HashMap<String,Object>();
   		if(StringUtils.isNotEmpty(formData)){
   			formDataMap = JsonUtil.parseJSON2Map(formData);
   		}
   		if(!CollectionUtils.isEmpty(dataList)){
           Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        for (Map<String, String> data:dataList) {
            if(StringUtils.isEmpty(data.get("errorInfo"))){
                //业务校验
                QmsQualitySupervisionDTO dto = new QmsQualitySupervisionDTO();
                Map2Bo.map2Pojo(data,dto);
                qmsQualitySupervisionSuccessList.add(dto);
            } else {
                QmsQualitySupervisionImportDTO dtoImp = new QmsQualitySupervisionImportDTO();
                Map2Bo.map2Pojo(data,dtoImp);
                qmsQualitySupervisionErrList.add(dtoImp);
            }
        }
           this.revValueConvert(qmsQualitySupervisionSuccessList, convertResultData);
        this.insertQmsQualitySupervisionList(qmsQualitySupervisionSuccessList);
    }
   		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualitySupervisionSuccessList,qmsQualitySupervisionErrList,QmsQualitySupervisionImportDTO.class,formDataMap);
   		return excelImport;
   	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualitySupervisionDTOList
     */
    private void valueConvert(List<QmsQualitySupervisionDTO> qmsQualitySupervisionDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualitySupervisionDTO qmsQualitySupervision : qmsQualitySupervisionDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualitySupervision.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualitySupervisionDTO qmsQualitySupervision : qmsQualitySupervisionDTOList) {
                qmsQualitySupervision.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualitySupervision.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualitySupervisionDTOList
     */
    private void revValueConvert(List<QmsQualitySupervisionDTO> qmsQualitySupervisionDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsQualitySupervisionDTO qmsQualitySupervision : qmsQualitySupervisionDTOList) {
            qmsQualitySupervision.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualitySupervision.getSecretLevelName()));
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

