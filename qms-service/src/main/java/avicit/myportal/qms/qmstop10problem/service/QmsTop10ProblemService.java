package avicit.myportal.qms.qmstop10problem.service;

import avicit.myportal.qms.qmstop10problem.dao.QmsTop10ProblemDAO;
import avicit.myportal.qms.qmstop10problem.dto.QmsTop10ProblemDTO;
import avicit.myportal.qms.qmstop10problem.dto.QmsTop10ProblemImportDTO;
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
* @创建时间： 2026-08-05 18:11
* @类说明：TOP10问题台账Service
* @修改记录：
*/
@Service
public class QmsTop10ProblemService {

	private static final Logger logger = LoggerFactory.getLogger(QmsTop10ProblemService.class);

	@Autowired
	private QmsTop10ProblemDAO qmsTop10ProblemDAO;

	@Autowired
	private OssClient ossClient;


	@Autowired
	private ConvertColumnClient convertColumnClient;

	/**
	* 按条件分页查询
	* @param queryReqBean 查询条件
	* @return QueryRespBean<QmsTop10ProblemDTO>
	*/
	@Transactional(readOnly = true)
	public QueryRespBean<QmsTop10ProblemDTO> searchQmsTop10ProblemByPage(QueryReqBean<QmsTop10ProblemDTO> queryReqBean) {
		QueryRespBean<QmsTop10ProblemDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsTop10ProblemDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsTop10ProblemDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsTop10ProblemDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsTop10ProblemDTO> result = qmsTop10ProblemDAO.searchQmsTop10ProblemByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
		valueConvert(result.getResult());
		queryRespBean.setResult(result);
		return queryRespBean;
	}

	/**
	* 按条件查询
	*
	* @param queryReqBean 查询条件
	* @return List<QmsTop10ProblemDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsTop10ProblemDTO> searchQmsTop10Problem(QueryReqBean<QmsTop10ProblemDTO> queryReqBean) {
		QueryRespBean<QmsTop10ProblemDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsTop10ProblemDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsTop10ProblemDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsTop10ProblemDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		//文档密级
		List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsTop10ProblemDTO> dataList = qmsTop10ProblemDAO.searchQmsTop10Problem(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
		valueConvert(dataList);
		return dataList;
	}

	/**
	* 按条件导出
	*
	* @param queryReqBean 查询条件
	* @return List<QmsTop10ProblemDTO>
	*/
	@Transactional(readOnly = true)
	public List<QmsTop10ProblemDTO> searchQmsTop10ProblemForExportExcel(QueryReqBean<QmsTop10ProblemDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsTop10ProblemDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsTop10ProblemDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
		List<QmsTop10ProblemDTO> result=qmsTop10ProblemDAO.searchQmsTop10ProblemForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId() , ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
	}

	/**
	* 通过主键查询单条记录
	*
	* @param id 主键id
	* @return QmsTop10ProblemDTO
	*/
	@Transactional(readOnly = true)
	public QmsTop10ProblemDTO queryQmsTop10ProblemByPrimaryKey(String id) {
		QmsTop10ProblemDTO qmsTop10ProblemDTO = qmsTop10ProblemDAO.findQmsTop10ProblemById(id);
		//记录日志
		if (qmsTop10ProblemDTO != null) {
            valueConvert(Arrays.asList(qmsTop10ProblemDTO));
			SysLogUtil.log4Query(qmsTop10ProblemDTO);
		}
		return qmsTop10ProblemDTO;
	}

	/**
	* 新增对象
	*
	* @param qmsTop10ProblemDTO 保存对象
	* @return String
	*/
	@Transactional
	public String insertQmsTop10Problem(QmsTop10ProblemDTO qmsTop10ProblemDTO) {
		qmsTop10ProblemDTO.setId(ComUtil.getId());
		PojoUtil.setSysProperties(qmsTop10ProblemDTO, OpType.insert);
		qmsTop10ProblemDAO.insertQmsTop10Problem(qmsTop10ProblemDTO);
		//记录日志
		SysLogUtil.log4Insert(qmsTop10ProblemDTO);
		return qmsTop10ProblemDTO.getId();
	}

	/**
	* 批量新增对象
	*
	* @param dtoList 保存对象集合
	* @return int
	*/
	@Transactional
	public int insertQmsTop10ProblemList(List<QmsTop10ProblemDTO> dtoList) {
		for (QmsTop10ProblemDTO qmsTop10ProblemDTO : dtoList) {
			qmsTop10ProblemDTO.setId(ComUtil.getId());
			PojoUtil.setSysProperties(qmsTop10ProblemDTO, OpType.insert);
		}
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsTop10ProblemDAO.insertQmsTop10ProblemList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
		return dtoList.size();
	}

	/**
	* 修改对象全部字段
	*
	* @param qmsTop10ProblemDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsTop10Problem(QmsTop10ProblemDTO qmsTop10ProblemDTO) {
        return updateDto(qmsTop10ProblemDTO, true);
	}

	/**
	* 修改对象部分字段
	*
	* @param qmsTop10ProblemDTO 修改对象
	* @return int
	*/
	@Transactional
	public int updateQmsTop10ProblemSensitive(QmsTop10ProblemDTO qmsTop10ProblemDTO) {
        return updateDto(qmsTop10ProblemDTO, false);
	}

	/**
	* 批量更新对象
	*
	* @param dtoList 修改对象集合
	* @return int
	*/
	@Transactional
	public int updateQmsTop10ProblemList(List<QmsTop10ProblemDTO> dtoList) {
		List<QmsTop10ProblemDTO> updateList = new ArrayList<>();
        List<QmsTop10ProblemDTO> oldList = new ArrayList<>();
		for (QmsTop10ProblemDTO dto : dtoList) {
            QmsTop10ProblemDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsTop10ProblemDTO updateDto = (QmsTop10ProblemDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
			updateList.add(updateDto);
            oldList.add(old);
		}
		ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsTop10ProblemDAO.updateQmsTop10ProblemList(subList);
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
	public int deleteQmsTop10ProblemById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new BusinessException("删除失败！传入的参数主键为null");
		}
		//记录日志
		QmsTop10ProblemDTO qmsTop10ProblemDTO = findById(id);
		if (qmsTop10ProblemDTO == null) {
			throw new BusinessException("删除失败！对象不存在");
		}
		SysLogUtil.log4Delete(qmsTop10ProblemDTO);
		//删除业务数据
		int count = qmsTop10ProblemDAO.deleteQmsTop10ProblemById(id);
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
	public int deleteQmsTop10ProblemByIds(String[] ids) {
		int result = 0;
		for (String id : ids) {
			deleteQmsTop10ProblemById(id);
			result++;
		}
		return result;
	}

	/**
	* 日志专用，内部方法，不再记录日志
	*
	* @param id 主键id
	* @return QmsTop10ProblemDTO
	*/
	private QmsTop10ProblemDTO findById(String id) {
		return qmsTop10ProblemDAO.findQmsTop10ProblemById(id);
	}
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsTop10ProblemDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsTop10ProblemDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsTop10ProblemDTO updateDto = (QmsTop10ProblemDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsTop10ProblemDAO.updateQmsTop10ProblemAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsTop10ProblemDAO.updateQmsTop10ProblemSensitive(dto);
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
		List<QmsTop10ProblemDTO> qmsTop10ProblemSuccessList = new ArrayList<QmsTop10ProblemDTO>();
		List<QmsTop10ProblemImportDTO> qmsTop10ProblemErrList = new ArrayList<QmsTop10ProblemImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsTop10ProblemDTO dto = new QmsTop10ProblemDTO();
					Map2Bo.map2Pojo(data,dto);
					qmsTop10ProblemSuccessList.add(dto);
				} else {
					QmsTop10ProblemImportDTO dtoImp = new QmsTop10ProblemImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsTop10ProblemErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsTop10ProblemSuccessList, convertResultData);
			this.insertQmsTop10ProblemList(qmsTop10ProblemSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsTop10ProblemSuccessList,qmsTop10ProblemErrList,QmsTop10ProblemImportDTO.class,formDataMap);
		return excelImport;
	}
	/**
	 * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
	 *
	 * @param qmsTop10ProblemDTOList
	 */
	private void valueConvert(List<QmsTop10ProblemDTO> qmsTop10ProblemDTOList) {
		//循环组装请求数据
		Map<String, Set<String>> convertFormData = new HashMap<>();
		for (QmsTop10ProblemDTO qmsTop10Problem : qmsTop10ProblemDTOList) {
			BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsTop10Problem.getSecretLevel());
		}
		if (convertFormData.size() > 0) {
			//获取请求结果
			Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
			//循环设置Alias或Name的值
			for (QmsTop10ProblemDTO qmsTop10Problem : qmsTop10ProblemDTOList) {
				qmsTop10Problem.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsTop10Problem.getSecretLevel()));
			}
		}
	}

	/**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsTop10ProblemDTOList
     */
    private void revValueConvert(List<QmsTop10ProblemDTO> qmsTop10ProblemDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsTop10ProblemDTO qmsTop10Problem : qmsTop10ProblemDTOList) {
            qmsTop10Problem.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsTop10Problem.getSecretLevelName()));
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

