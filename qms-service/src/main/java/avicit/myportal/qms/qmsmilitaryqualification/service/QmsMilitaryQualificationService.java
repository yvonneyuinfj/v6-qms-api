package avicit.myportal.qms.qmsmilitaryqualification.service;

import avicit.myportal.qms.qmsmilitaryqualification.dao.QmsMilitaryQualificationDAO;
import avicit.myportal.qms.qmsmilitaryqualification.dto.QmsMilitaryQualificationDTO;
import avicit.myportal.qms.qmsmilitaryqualification.dto.QmsMilitaryQualificationImportDTO;
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
* @创建时间： 2026-08-05 18:06
* @类说明：军工资质基本信息Service
* @修改记录：
*/
@Service
public class QmsMilitaryQualificationService {

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualificationService.class);

	@Autowired
	private QmsMilitaryQualificationDAO qmsMilitaryQualificationDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsMilitaryQualificationDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsMilitaryQualificationDTO> searchQmsMilitaryQualificationByPage(QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualificationDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualificationDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualificationDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualificationDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsMilitaryQualificationDTO> result = qmsMilitaryQualificationDAO.searchQmsMilitaryQualificationByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
		valueConvert(result.getResult());
		queryRespBean.setResult(result);
		return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualificationDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualificationDTO> searchQmsMilitaryQualification(QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean) {
		QueryRespBean<QmsMilitaryQualificationDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMilitaryQualificationDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualificationDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualificationDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsMilitaryQualificationDTO> dataList = qmsMilitaryQualificationDAO.searchQmsMilitaryQualification(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
		valueConvert(dataList);
		return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMilitaryQualificationDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMilitaryQualificationDTO> searchQmsMilitaryQualificationForExportExcel(QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMilitaryQualificationDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMilitaryQualificationDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		List<QmsMilitaryQualificationDTO> result=qmsMilitaryQualificationDAO.searchQmsMilitaryQualificationForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsMilitaryQualificationDTO
	*/
	@Transactional(readOnly = true)
	public QmsMilitaryQualificationDTO queryQmsMilitaryQualificationByPrimaryKey(String id) {
		QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO = qmsMilitaryQualificationDAO.findQmsMilitaryQualificationById(id);
		//记录日志
		if (qmsMilitaryQualificationDTO != null) {
            valueConvert(Arrays.asList(qmsMilitaryQualificationDTO));
			SysLogUtil.log4Query(qmsMilitaryQualificationDTO);
		}
		return qmsMilitaryQualificationDTO;
	}

	/**
	* 新增对象
	*
	* @param qmsMilitaryQualificationDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsMilitaryQualification(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO) {
		qmsMilitaryQualificationDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsMilitaryQualificationDTO, OpType.insert);
		qmsMilitaryQualificationDAO.insertQmsMilitaryQualification(qmsMilitaryQualificationDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsMilitaryQualificationDTO);
		return qmsMilitaryQualificationDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsMilitaryQualificationList(List<QmsMilitaryQualificationDTO> dtoList) {
		for (QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO : dtoList) {
			qmsMilitaryQualificationDTO.setId(ComUtil.getId());
			PojoUtil.setSysProperties(qmsMilitaryQualificationDTO, OpType.insert);
		}
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsMilitaryQualificationDAO.insertQmsMilitaryQualificationList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
		return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsMilitaryQualificationDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualification(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO) {
        return updateDto(qmsMilitaryQualificationDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsMilitaryQualificationDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualificationSensitive(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO) {
        return updateDto(qmsMilitaryQualificationDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsMilitaryQualificationList(List<QmsMilitaryQualificationDTO> dtoList) {
		List<QmsMilitaryQualificationDTO> updateList = new ArrayList<>();
        List<QmsMilitaryQualificationDTO> oldList = new ArrayList<>();
		for (QmsMilitaryQualificationDTO dto : dtoList) {
            QmsMilitaryQualificationDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsMilitaryQualificationDTO updateDto = (QmsMilitaryQualificationDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
			updateList.add(updateDto);
            oldList.add(old);
		}
		ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsMilitaryQualificationDAO.updateQmsMilitaryQualificationList(subList);
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
	public int deleteQmsMilitaryQualificationById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO = findById(id);
		if (qmsMilitaryQualificationDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsMilitaryQualificationDTO);
		//删除业务数据
		int count = qmsMilitaryQualificationDAO.deleteQmsMilitaryQualificationById(id);
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
	public int deleteQmsMilitaryQualificationByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsMilitaryQualificationById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsMilitaryQualificationDTO
	*/
	private QmsMilitaryQualificationDTO findById(String id) {
		return qmsMilitaryQualificationDAO.findQmsMilitaryQualificationById(id);
	}
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsMilitaryQualificationDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsMilitaryQualificationDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsMilitaryQualificationDTO updateDto = (QmsMilitaryQualificationDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsMilitaryQualificationDAO.updateQmsMilitaryQualificationAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsMilitaryQualificationDAO.updateQmsMilitaryQualificationSensitive(dto);
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
		List<QmsMilitaryQualificationDTO> qmsMilitaryQualificationSuccessList = new ArrayList<QmsMilitaryQualificationDTO>();
		List<QmsMilitaryQualificationImportDTO> qmsMilitaryQualificationErrList = new ArrayList<QmsMilitaryQualificationImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsMilitaryQualificationDTO dto = new QmsMilitaryQualificationDTO();
					Map2Bo.map2Pojo(data,dto);
					qmsMilitaryQualificationSuccessList.add(dto);
				} else {
					QmsMilitaryQualificationImportDTO dtoImp = new QmsMilitaryQualificationImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsMilitaryQualificationErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsMilitaryQualificationSuccessList, convertResultData);
			this.insertQmsMilitaryQualificationList(qmsMilitaryQualificationSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsMilitaryQualificationSuccessList,qmsMilitaryQualificationErrList,QmsMilitaryQualificationImportDTO.class,formDataMap);
		return excelImport;
	}
	/**
	 * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
	 *
	 * @param qmsMilitaryQualificationDTOList
	 */
	private void valueConvert(List<QmsMilitaryQualificationDTO> qmsMilitaryQualificationDTOList) {
		//循环组装请求数据
		Map<String, Set<String>> convertFormData = new HashMap<>();
		for (QmsMilitaryQualificationDTO qmsMilitaryQualification : qmsMilitaryQualificationDTOList) {
			BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualification.getSecretLevel());
		}
		if (convertFormData.size() > 0) {
			//获取请求结果
			Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
			//循环设置Alias或Name的值
			for (QmsMilitaryQualificationDTO qmsMilitaryQualification : qmsMilitaryQualificationDTOList) {
				qmsMilitaryQualification.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualification.getSecretLevel()));
			}
		}
	}

	/**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsMilitaryQualificationDTOList
     */
    private void revValueConvert(List<QmsMilitaryQualificationDTO> qmsMilitaryQualificationDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsMilitaryQualificationDTO qmsMilitaryQualification : qmsMilitaryQualificationDTOList) {
            qmsMilitaryQualification.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMilitaryQualification.getSecretLevelName()));
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

