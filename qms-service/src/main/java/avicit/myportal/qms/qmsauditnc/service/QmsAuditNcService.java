package avicit.myportal.qms.qmsauditnc.service;

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
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsauditnc.dao.QmsAuditNcDAO;
import avicit.myportal.qms.qmsauditnc.dto.QmsAuditNcDTO;
import avicit.myportal.qms.qmsauditnc.dto.QmsAuditNcImportDTO;
import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationDTO;
import avicit.myportal.qms.qmsproblemrectification.service.QmsProblemRectificationService;
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
* @创建时间： 2026-08-28 16:14
* @类说明：不符合项表Service
* @修改记录：
*/
@Service
public class QmsAuditNcService {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditNcService.class);

	@Autowired
	private QmsAuditNcDAO qmsAuditNcDAO;



	@Autowired
	private ConvertColumnClient convertColumnClient;

	@Autowired
	private QmsProblemRectificationService qmsProblemRectificationService;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsAuditNcDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsAuditNcDTO> searchQmsAuditNcByPage(QueryReqBean<QmsAuditNcDTO> queryReqBean) {
		QueryRespBean<QmsAuditNcDTO> queryRespBean = new QueryRespBean<>();
		if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditNcDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNcDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNcDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsAuditNcDTO> result = qmsAuditNcDAO.searchQmsAuditNcByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditNcDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditNcDTO> searchQmsAuditNc(QueryReqBean<QmsAuditNcDTO> queryReqBean) {
		QueryRespBean<QmsAuditNcDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditNcDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNcDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNcDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        QmsAuditNcDTO searchParams = queryReqBean.getSearchParams();
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsAuditNcDTO> dataList = qmsAuditNcDAO.searchQmsAuditNc(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsAuditNcDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsAuditNcDTO> searchQmsAuditNcForExportExcel(QueryReqBean<QmsAuditNcDTO> queryReqBean) {
		if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditNcDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditNcDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsAuditNcDTO> result=qmsAuditNcDAO.searchQmsAuditNcForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsAuditNcDTO
	*/
	@Transactional(readOnly = true)
	public QmsAuditNcDTO queryQmsAuditNcByPrimaryKey(String id) {
		QmsAuditNcDTO qmsAuditNcDTO = qmsAuditNcDAO.findQmsAuditNcById(id);
		//记录日志
		if (qmsAuditNcDTO != null) {
            valueConvert(Arrays.asList(qmsAuditNcDTO));
			SysLogUtil.log4Query(qmsAuditNcDTO);
		}
		return qmsAuditNcDTO;
	}
	/**
	* 新增对象
	*
	* @param qmsAuditNcDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsAuditNc(QmsAuditNcDTO qmsAuditNcDTO) {
		qmsAuditNcDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsAuditNcDTO, OpType.insert);
		qmsAuditNcDAO.insertQmsAuditNc(qmsAuditNcDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsAuditNcDTO);
		return qmsAuditNcDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsAuditNcList(List<QmsAuditNcDTO> dtoList) {
		for (QmsAuditNcDTO qmsAuditNcDTO : dtoList) {
            qmsAuditNcDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsAuditNcDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsAuditNcDAO.insertQmsAuditNcList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsAuditNcDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNc(QmsAuditNcDTO qmsAuditNcDTO) {
        return updateDto(qmsAuditNcDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsAuditNcDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNcSensitive(QmsAuditNcDTO qmsAuditNcDTO) {
        return updateDto(qmsAuditNcDTO, false);
	}

	/**
	* 内部方法，获取修改的dto对象
	*
	* @param qmsAuditNcDTO
	* @return
	*/
	private QmsAuditNcDTO getUpdateMainDto(QmsAuditNcDTO qmsAuditNcDTO) {
		QmsAuditNcDTO oldDTO = findById(qmsAuditNcDTO.getId());
		if (oldDTO == null) {
			throw new BusinessException("数据不存在");
		}
		//记录日志
		SysLogUtil.log4Update(qmsAuditNcDTO, oldDTO);
		PojoUtil.setSysProperties(qmsAuditNcDTO, OpType.update);
		PojoUtil.copyProperties(oldDTO, qmsAuditNcDTO, false);
		return oldDTO;
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsAuditNcList(List<QmsAuditNcDTO> dtoList) {
		List<QmsAuditNcDTO> updateList = new ArrayList<>();
        List<QmsAuditNcDTO> oldList = new ArrayList<>();
        for (QmsAuditNcDTO dto : dtoList) {
            QmsAuditNcDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsAuditNcDTO updateDto = (QmsAuditNcDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsAuditNcDAO.updateQmsAuditNcList(subList);
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
	public int deleteQmsAuditNcById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsAuditNcDTO qmsAuditNcDTO = findById(id);
		if (qmsAuditNcDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsAuditNcDTO);
		//删除子表
		for (QmsProblemRectificationDTO qmsProblemRectificationDTO : qmsProblemRectificationService.queryQmsProblemRectificationByPid(qmsAuditNcDTO.getId())) {
			qmsProblemRectificationService.deleteQmsProblemRectification(qmsProblemRectificationDTO);
		}
		//删除业务数据
		int count = qmsAuditNcDAO.deleteQmsAuditNcById(id);
		return count;
	}

	/**
	 * 批量删除数据
	 *
	 * @param ids id的数组
	 * @return int
	 */
	@Transactional
	public int deleteQmsAuditNcByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsAuditNcById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsAuditNcDTO
	*/
	private QmsAuditNcDTO findById(String id) {
		return qmsAuditNcDAO.findQmsAuditNcById(id);
	}
	/**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsAuditNcDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsAuditNcDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsAuditNcDTO updateDto = (QmsAuditNcDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsAuditNcDAO.updateQmsAuditNcAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsAuditNcDAO.updateQmsAuditNcSensitive(dto);
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
   		List<QmsAuditNcDTO> qmsAuditNcSuccessList = new ArrayList<QmsAuditNcDTO>();
   		List<QmsAuditNcImportDTO> qmsAuditNcErrList = new ArrayList<QmsAuditNcImportDTO>();
   		Map<String, Object> formDataMap = new HashMap<String,Object>();
   		if(StringUtils.isNotEmpty(formData)){
   			formDataMap = JsonUtil.parseJSON2Map(formData);
   		}
   		if(!CollectionUtils.isEmpty(dataList)){
           Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
        for (Map<String, String> data:dataList) {
            if(StringUtils.isEmpty(data.get("errorInfo"))){
                //业务校验
                QmsAuditNcDTO dto = new QmsAuditNcDTO();
                Map2Bo.map2Pojo(data,dto);
                qmsAuditNcSuccessList.add(dto);
            } else {
                QmsAuditNcImportDTO dtoImp = new QmsAuditNcImportDTO();
                Map2Bo.map2Pojo(data,dtoImp);
                qmsAuditNcErrList.add(dtoImp);
            }
        }
           this.revValueConvert(qmsAuditNcSuccessList, convertResultData);
        this.insertQmsAuditNcList(qmsAuditNcSuccessList);
    }
   		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsAuditNcSuccessList,qmsAuditNcErrList,QmsAuditNcImportDTO.class,formDataMap);
   		return excelImport;
   	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsAuditNcDTOList
     */
    private void valueConvert(List<QmsAuditNcDTO> qmsAuditNcDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsAuditNcDTO qmsAuditNc : qmsAuditNcDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditNc.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsAuditNcDTO qmsAuditNc : qmsAuditNcDTOList) {
                qmsAuditNc.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditNc.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsAuditNcDTOList
     */
    private void revValueConvert(List<QmsAuditNcDTO> qmsAuditNcDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsAuditNcDTO qmsAuditNc : qmsAuditNcDTOList) {
            qmsAuditNc.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditNc.getSecretLevelName()));
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

