package avicit.myportal.qms.qmsqualitycultureplan.service;

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
import avicit.myportal.qms.qmsqualitycultureplan.dao.QmsQualityCulturePlanDAO;
import avicit.myportal.qms.qmsqualitycultureplan.dto.QmsQualityCulturePlanDTO;
import avicit.myportal.qms.qmsqualitycultureplan.dto.QmsQualityCulturePlanImportDTO;
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
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsQualityCulturePlanService  {

	 private static final Logger logger = LoggerFactory.getLogger(QmsQualityCulturePlanService.class);

    @Autowired
    private QmsQualityCulturePlanDAO qmsQualityCulturePlanDAO;


    @Autowired
    private ConvertColumnClient convertColumnClient;
    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsQualityCulturePlanDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsQualityCulturePlanDTO> searchQmsQualityCulturePlanByPage(QueryReqBean<QmsQualityCulturePlanDTO> queryReqBean) {
        QueryRespBean<QmsQualityCulturePlanDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityCulturePlanDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityCulturePlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityCulturePlanDTO>() {
            });
            searchKeyWordParam.setCultureId(queryReqBean.getSearchParams().getCultureId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getCultureId())) {
            queryReqBean.getSearchParams().setCultureId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityCulturePlanDTO> result = qmsQualityCulturePlanDAO.searchQmsQualityCulturePlanByPage(queryReqBean.getSearchParams(),  wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @return List<QmsQualityCulturePlanDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityCulturePlanDTO> searchQmsQualityCulturePlanForExportExcel(QueryReqBean<QmsQualityCulturePlanDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityCulturePlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityCulturePlanDTO>() {
            });
            searchKeyWordParam.setCultureId(queryReqBean.getSearchParams().getCultureId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualityCulturePlanDTO> result=qmsQualityCulturePlanDAO.searchQmsQualityCulturePlanForExportExcel(queryReqBean.getSearchParams(),  new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsQualityCulturePlanDTO
     */
    @Transactional(readOnly = true)
    public QmsQualityCulturePlanDTO queryQmsQualityCulturePlanByPrimaryKey(String id) {
        QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO = qmsQualityCulturePlanDAO.findQmsQualityCulturePlanById(id);
        //记录日志
        if (qmsQualityCulturePlanDTO != null) {
            valueConvert(Arrays.asList(qmsQualityCulturePlanDTO));
            SysLogUtil.log4Query(qmsQualityCulturePlanDTO);
        }
        return qmsQualityCulturePlanDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsQualityCulturePlanDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityCulturePlanDTO> queryQmsQualityCulturePlanByPid(String pid) {
        List<QmsQualityCulturePlanDTO> dtoList = qmsQualityCulturePlanDAO.findQmsQualityCulturePlanByPid(pid);
        return dtoList;
    }
    /**
     * 新增对象
     *
     * @param qmsQualityCulturePlanDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsQualityCulturePlan(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO) {
        qmsQualityCulturePlanDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsQualityCulturePlanDTO, OpType.insert);
        qmsQualityCulturePlanDAO.insertQmsQualityCulturePlan(qmsQualityCulturePlanDTO);
        //记录日志
        SysLogUtil.log4Insert(qmsQualityCulturePlanDTO);
        return qmsQualityCulturePlanDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsQualityCulturePlanList(List<QmsQualityCulturePlanDTO> dtoList) {
        for (QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO : dtoList) {
            qmsQualityCulturePlanDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityCulturePlanDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityCulturePlanDAO.insertQmsQualityCulturePlanList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsQualityCulturePlanDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityCulturePlan(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO) {
        return updateDto(qmsQualityCulturePlanDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsQualityCulturePlanDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityCulturePlanSensitive(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO) {
        return updateDto(qmsQualityCulturePlanDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsQualityCulturePlanList(List<QmsQualityCulturePlanDTO> dtoList) {
        List<QmsQualityCulturePlanDTO> updateList = new ArrayList<>();
        List<QmsQualityCulturePlanDTO> oldList = new ArrayList<>();
        for (QmsQualityCulturePlanDTO dto : dtoList) {
            QmsQualityCulturePlanDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityCulturePlanDTO updateDto = (QmsQualityCulturePlanDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityCulturePlanDAO.updateQmsQualityCulturePlanList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsQualityCulturePlanDTO
     * @return
     */
    private QmsQualityCulturePlanDTO getUpdateSubDto(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO) {
        QmsQualityCulturePlanDTO oldDTO = findById(qmsQualityCulturePlanDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getCultureId();
        //记录日志
        SysLogUtil.log4Update(qmsQualityCulturePlanDTO, oldDTO);
        PojoUtil.setSysProperties(qmsQualityCulturePlanDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsQualityCulturePlanDTO, false);
        oldDTO.setCultureId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsQualityCulturePlanById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        //记录日志
        QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO = findById(id);
        if (qmsQualityCulturePlanDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityCulturePlanDTO);
        //删除业务数据
        int count = qmsQualityCulturePlanDAO.deleteQmsQualityCulturePlanById(id);
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsQualityCulturePlanDTO 对象条件
     * @return int
     */
    public int deleteQmsQualityCulturePlan(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO) {
        //记录日志
        if (qmsQualityCulturePlanDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityCulturePlanDTO);
        return qmsQualityCulturePlanDAO.deleteQmsQualityCulturePlanById(qmsQualityCulturePlanDTO.getId());
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsQualityCulturePlanByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsQualityCulturePlanById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsQualityCulturePlanDTO
     */
    private QmsQualityCulturePlanDTO findById(String id) {
        return qmsQualityCulturePlanDAO.findQmsQualityCulturePlanById(id);
    }
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityCulturePlanDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityCulturePlanDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityCulturePlanDTO updateDto = (QmsQualityCulturePlanDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityCulturePlanDAO.updateQmsQualityCulturePlanAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityCulturePlanDAO.updateQmsQualityCulturePlanSensitive(dto);
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
		List<QmsQualityCulturePlanDTO> qmsQualityCulturePlanSuccessList = new ArrayList<QmsQualityCulturePlanDTO>();
		List<QmsQualityCulturePlanImportDTO> qmsQualityCulturePlanErrList = new ArrayList<QmsQualityCulturePlanImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsQualityCulturePlanDTO dto = new QmsQualityCulturePlanDTO();
					Map2Bo.map2Pojo(data,dto);
					dto.setCultureId(formDataMap.get("cultureId").toString());
					qmsQualityCulturePlanSuccessList.add(dto);
				} else {
					QmsQualityCulturePlanImportDTO dtoImp = new QmsQualityCulturePlanImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsQualityCulturePlanErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsQualityCulturePlanSuccessList, convertResultData);
			this.insertQmsQualityCulturePlanList(qmsQualityCulturePlanSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualityCulturePlanSuccessList,qmsQualityCulturePlanErrList,QmsQualityCulturePlanImportDTO.class,formDataMap);
		return excelImport;
	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityCulturePlanDTOList
     */
    private void valueConvert(List<QmsQualityCulturePlanDTO> qmsQualityCulturePlanDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityCulturePlanDTO qmsQualityCulturePlan : qmsQualityCulturePlanDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulturePlan.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityCulturePlanDTO qmsQualityCulturePlan : qmsQualityCulturePlanDTOList) {
                qmsQualityCulturePlan.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulturePlan.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityCulturePlanDTOList
     */
    private void revValueConvert(List<QmsQualityCulturePlanDTO> qmsQualityCulturePlanDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsQualityCulturePlanDTO qmsQualityCulturePlan : qmsQualityCulturePlanDTOList) {
            qmsQualityCulturePlan.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityCulturePlan.getSecretLevelName()));
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

