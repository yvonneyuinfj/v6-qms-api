package avicit.myportal.qms.qmsmrimprovement.service;

import avicit.myportal.qms.qmsmrimprovement.dao.QmsMrImprovementDAO;
import avicit.myportal.qms.qmsmrimprovement.dto.QmsMrImprovementDTO;
import avicit.myportal.qms.qmsmrimprovement.dto.QmsMrImprovementImportDTO;
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
* @创建时间： 2026-08-03 19:45
* @类说明：管评改进项台账Service
* @修改记录：
*/
@Service
public class QmsMrImprovementService {

	private static final Logger logger = LoggerFactory.getLogger(QmsMrImprovementService.class);

	@Autowired
	private QmsMrImprovementDAO qmsMrImprovementDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsMrImprovementDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsMrImprovementDTO> searchQmsMrImprovementByPage(QueryReqBean<QmsMrImprovementDTO> queryReqBean) {
		QueryRespBean<QmsMrImprovementDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMrImprovementDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMrImprovementDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMrImprovementDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsMrImprovementDTO> result = qmsMrImprovementDAO.searchQmsMrImprovementByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
		valueConvert(result.getResult());
		queryRespBean.setResult(result);
		return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMrImprovementDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMrImprovementDTO> searchQmsMrImprovement(QueryReqBean<QmsMrImprovementDTO> queryReqBean) {
		QueryRespBean<QmsMrImprovementDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsMrImprovementDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMrImprovementDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMrImprovementDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsMrImprovementDTO> dataList = qmsMrImprovementDAO.searchQmsMrImprovement(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
		valueConvert(dataList);
		return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsMrImprovementDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsMrImprovementDTO> searchQmsMrImprovementForExportExcel(QueryReqBean<QmsMrImprovementDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsMrImprovementDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsMrImprovementDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		List<QmsMrImprovementDTO> result=qmsMrImprovementDAO.searchQmsMrImprovementForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsMrImprovementDTO
	*/
	@Transactional(readOnly = true)
	public QmsMrImprovementDTO queryQmsMrImprovementByPrimaryKey(String id) {
		QmsMrImprovementDTO qmsMrImprovementDTO = qmsMrImprovementDAO.findQmsMrImprovementById(id);
		//记录日志
		if (qmsMrImprovementDTO != null) {
            valueConvert(Arrays.asList(qmsMrImprovementDTO));
			SysLogUtil.log4Query(qmsMrImprovementDTO);
		}
		return qmsMrImprovementDTO;
	}

	/**
	* 新增对象
	*
	* @param qmsMrImprovementDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsMrImprovement(QmsMrImprovementDTO qmsMrImprovementDTO) {
		qmsMrImprovementDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsMrImprovementDTO, OpType.insert);
		qmsMrImprovementDAO.insertQmsMrImprovement(qmsMrImprovementDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsMrImprovementDTO);
		return qmsMrImprovementDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsMrImprovementList(List<QmsMrImprovementDTO> dtoList) {
		for (QmsMrImprovementDTO qmsMrImprovementDTO : dtoList) {
			qmsMrImprovementDTO.setId(ComUtil.getId());
			PojoUtil.setSysProperties(qmsMrImprovementDTO, OpType.insert);
		}
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsMrImprovementDAO.insertQmsMrImprovementList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
		return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsMrImprovementDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMrImprovement(QmsMrImprovementDTO qmsMrImprovementDTO) {
        return updateDto(qmsMrImprovementDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsMrImprovementDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsMrImprovementSensitive(QmsMrImprovementDTO qmsMrImprovementDTO) {
        return updateDto(qmsMrImprovementDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsMrImprovementList(List<QmsMrImprovementDTO> dtoList) {
		List<QmsMrImprovementDTO> updateList = new ArrayList<>();
        List<QmsMrImprovementDTO> oldList = new ArrayList<>();
		for (QmsMrImprovementDTO dto : dtoList) {
            QmsMrImprovementDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsMrImprovementDTO updateDto = (QmsMrImprovementDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
			updateList.add(updateDto);
            oldList.add(old);
		}
		ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsMrImprovementDAO.updateQmsMrImprovementList(subList);
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
	public int deleteQmsMrImprovementById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsMrImprovementDTO qmsMrImprovementDTO = findById(id);
		if (qmsMrImprovementDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsMrImprovementDTO);
		//删除业务数据
		int count = qmsMrImprovementDAO.deleteQmsMrImprovementById(id);
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
	public int deleteQmsMrImprovementByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsMrImprovementById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsMrImprovementDTO
	*/
	private QmsMrImprovementDTO findById(String id) {
		return qmsMrImprovementDAO.findQmsMrImprovementById(id);
	}
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsMrImprovementDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsMrImprovementDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsMrImprovementDTO updateDto = (QmsMrImprovementDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsMrImprovementDAO.updateQmsMrImprovementAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsMrImprovementDAO.updateQmsMrImprovementSensitive(dto);
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
		List<QmsMrImprovementDTO> qmsMrImprovementSuccessList = new ArrayList<QmsMrImprovementDTO>();
		List<QmsMrImprovementImportDTO> qmsMrImprovementErrList = new ArrayList<QmsMrImprovementImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsMrImprovementDTO dto = new QmsMrImprovementDTO();
					Map2Bo.map2Pojo(data,dto);
					qmsMrImprovementSuccessList.add(dto);
				} else {
					QmsMrImprovementImportDTO dtoImp = new QmsMrImprovementImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsMrImprovementErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsMrImprovementSuccessList, convertResultData);
			this.insertQmsMrImprovementList(qmsMrImprovementSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsMrImprovementSuccessList,qmsMrImprovementErrList,QmsMrImprovementImportDTO.class,formDataMap);
		return excelImport;
	}
	/**
	 * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
	 *
	 * @param qmsMrImprovementDTOList
	 */
	private void valueConvert(List<QmsMrImprovementDTO> qmsMrImprovementDTOList) {
		//循环组装请求数据
		Map<String, Set<String>> convertFormData = new HashMap<>();
		for (QmsMrImprovementDTO qmsMrImprovement : qmsMrImprovementDTOList) {
			BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsMrImprovement.getSecretLevel());
		}
		if (convertFormData.size() > 0) {
			//获取请求结果
			Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
			//循环设置Alias或Name的值
			for (QmsMrImprovementDTO qmsMrImprovement : qmsMrImprovementDTOList) {
				qmsMrImprovement.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMrImprovement.getSecretLevel()));
			}
		}
	}

	/**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsMrImprovementDTOList
     */
    private void revValueConvert(List<QmsMrImprovementDTO> qmsMrImprovementDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsMrImprovementDTO qmsMrImprovement : qmsMrImprovementDTOList) {
            qmsMrImprovement.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsMrImprovement.getSecretLevelName()));
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

