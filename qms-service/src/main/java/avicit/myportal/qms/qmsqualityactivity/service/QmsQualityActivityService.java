package avicit.myportal.qms.qmsqualityactivity.service;

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
import avicit.myportal.qms.qmsqualityactivity.dao.QmsQualityActivityDAO;
import avicit.myportal.qms.qmsqualityactivity.dto.QmsQualityActivityDTO;
import avicit.myportal.qms.qmsqualityactivity.dto.QmsQualityActivityImportDTO;
import avicit.myportal.qms.qmsqualityactivityprogress.dto.QmsQualityActivityProgressDTO;
import avicit.myportal.qms.qmsqualityactivityprogress.service.QmsQualityActivityProgressService;
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
* @创建时间： 2026-08-06 15:52
* @类说明：质量活动台账表Service
* @修改记录：
*/
@Service
public class QmsQualityActivityService {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityActivityService.class);

	@Autowired
	private QmsQualityActivityDAO qmsQualityActivityDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private QmsQualityActivityProgressService qmsQualityActivityProgressService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsQualityActivityDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsQualityActivityDTO> searchQmsQualityActivityByPage(QueryReqBean<QmsQualityActivityDTO> queryReqBean) {
		QueryRespBean<QmsQualityActivityDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityActivityDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityActivityDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityActivityDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityActivityDTO> result = qmsQualityActivityDAO.searchQmsQualityActivityByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityActivityDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityActivityDTO> searchQmsQualityActivity(QueryReqBean<QmsQualityActivityDTO> queryReqBean) {
		QueryRespBean<QmsQualityActivityDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityActivityDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityActivityDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityActivityDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        QmsQualityActivityDTO searchParams = queryReqBean.getSearchParams();
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsQualityActivityDTO> dataList = qmsQualityActivityDAO.searchQmsQualityActivity(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsQualityActivityDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsQualityActivityDTO> searchQmsQualityActivityForExportExcel(QueryReqBean<QmsQualityActivityDTO> queryReqBean) {
		if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityActivityDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityActivityDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualityActivityDTO> result=qmsQualityActivityDAO.searchQmsQualityActivityForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsQualityActivityDTO
	*/
	@Transactional(readOnly = true)
	public QmsQualityActivityDTO queryQmsQualityActivityByPrimaryKey(String id) {
		QmsQualityActivityDTO qmsQualityActivityDTO = qmsQualityActivityDAO.findQmsQualityActivityById(id);
		//记录日志
		if (qmsQualityActivityDTO != null) {
            valueConvert(Arrays.asList(qmsQualityActivityDTO));
			SysLogUtil.log4Query(qmsQualityActivityDTO);
		}
		return qmsQualityActivityDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsQualityActivityDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsQualityActivity(QmsQualityActivityDTO qmsQualityActivityDTO) {
		qmsQualityActivityDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsQualityActivityDTO, OpType.insert);
		qmsQualityActivityDAO.insertQmsQualityActivity(qmsQualityActivityDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsQualityActivityDTO);
		return qmsQualityActivityDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsQualityActivityList(List<QmsQualityActivityDTO> dtoList) {
		for (QmsQualityActivityDTO qmsQualityActivityDTO : dtoList) {
            qmsQualityActivityDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityActivityDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityActivityDAO.insertQmsQualityActivityList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsQualityActivityDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityActivity(QmsQualityActivityDTO qmsQualityActivityDTO) {
        return updateDto(qmsQualityActivityDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsQualityActivityDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsQualityActivitySensitive(QmsQualityActivityDTO qmsQualityActivityDTO) {
        return updateDto(qmsQualityActivityDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsQualityActivityDTO
	* @return
	*/
	private QmsQualityActivityDTO getUpdateMainDto(QmsQualityActivityDTO qmsQualityActivityDTO) {
		QmsQualityActivityDTO oldDTO = findById(qmsQualityActivityDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsQualityActivityDTO, oldDTO);
		PojoUtil.setSysProperties(qmsQualityActivityDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsQualityActivityDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsQualityActivityList(List<QmsQualityActivityDTO> dtoList) {
		List<QmsQualityActivityDTO> updateList = new ArrayList<>();
        List<QmsQualityActivityDTO> oldList = new ArrayList<>();
        for (QmsQualityActivityDTO dto : dtoList) {
            QmsQualityActivityDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityActivityDTO updateDto = (QmsQualityActivityDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityActivityDAO.updateQmsQualityActivityList(subList);
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
	public int deleteQmsQualityActivityById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsQualityActivityDTO qmsQualityActivityDTO = findById(id);
		if (qmsQualityActivityDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsQualityActivityDTO);
		//删除子表
		for (QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO : qmsQualityActivityProgressService.queryQmsQualityActivityProgressByPid(qmsQualityActivityDTO.getId())) {
			qmsQualityActivityProgressService.deleteQmsQualityActivityProgress(qmsQualityActivityProgressDTO);
		}
		//删除业务数据
		int count = qmsQualityActivityDAO.deleteQmsQualityActivityById(id);
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
	public int deleteQmsQualityActivityByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsQualityActivityById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsQualityActivityDTO
	*/
	private QmsQualityActivityDTO findById(String id) {
		return qmsQualityActivityDAO.findQmsQualityActivityById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityActivityDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityActivityDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityActivityDTO updateDto = (QmsQualityActivityDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityActivityDAO.updateQmsQualityActivityAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityActivityDAO.updateQmsQualityActivitySensitive(dto);
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
   		List<QmsQualityActivityDTO> qmsQualityActivitySuccessList = new ArrayList<QmsQualityActivityDTO>();
   		List<QmsQualityActivityImportDTO> qmsQualityActivityErrList = new ArrayList<QmsQualityActivityImportDTO>();
   		Map<String, Object> formDataMap = new HashMap<String,Object>();
   		if(StringUtils.isNotEmpty(formData)){
   			formDataMap = JsonUtil.parseJSON2Map(formData);
   		}
   		if(!CollectionUtils.isEmpty(dataList)){
           Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        for (Map<String, String> data:dataList) {
            if(StringUtils.isEmpty(data.get("errorInfo"))){
                //业务校验
                QmsQualityActivityDTO dto = new QmsQualityActivityDTO();
                Map2Bo.map2Pojo(data,dto);
                qmsQualityActivitySuccessList.add(dto);
            } else {
                QmsQualityActivityImportDTO dtoImp = new QmsQualityActivityImportDTO();
                Map2Bo.map2Pojo(data,dtoImp);
                qmsQualityActivityErrList.add(dtoImp);
            }
        }
           this.revValueConvert(qmsQualityActivitySuccessList, convertResultData);
        this.insertQmsQualityActivityList(qmsQualityActivitySuccessList);
    }
   		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualityActivitySuccessList,qmsQualityActivityErrList,QmsQualityActivityImportDTO.class,formDataMap);
   		return excelImport;
   	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityActivityDTOList
     */
    private void valueConvert(List<QmsQualityActivityDTO> qmsQualityActivityDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityActivityDTO qmsQualityActivity : qmsQualityActivityDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityActivity.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityActivityDTO qmsQualityActivity : qmsQualityActivityDTOList) {
                qmsQualityActivity.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityActivity.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityActivityDTOList
     */
    private void revValueConvert(List<QmsQualityActivityDTO> qmsQualityActivityDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsQualityActivityDTO qmsQualityActivity : qmsQualityActivityDTOList) {
            qmsQualityActivity.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityActivity.getSecretLevelName()));
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

