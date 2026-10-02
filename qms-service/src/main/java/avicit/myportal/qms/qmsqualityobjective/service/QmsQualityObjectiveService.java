package avicit.myportal.qms.qmsqualityobjective.service;

import avicit.myportal.qms.qmscommonactionfeedback.dto.QmsCommonActionFeedbackDTO;
import avicit.myportal.qms.qmscommonactionfeedback.service.QmsCommonActionFeedbackService;
import avicit.myportal.qms.qmsqualityobjective.dao.QmsQualityObjectiveDAO;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveDTO;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveImportDTO;
import avicit.platform6.api.bpm.BpmOperateClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartBean;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.commons.utils.*;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.Map2Bo;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.exception.UtilsException;
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
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 20:42
 * @类说明：质量目标台账表Service
 * @修改记录：
 */
@Service
public class QmsQualityObjectiveService {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityObjectiveService.class);

    @Autowired
    private QmsQualityObjectiveDAO qmsQualityObjectiveDAO;

    @Autowired
    private OssClient ossClient;

    @Autowired
    private ConvertColumnClient convertColumnClient;

    @Autowired
    private BpmOperateClient bpmOperateClient;

    @Autowired
    private QmsCommonActionFeedbackService qmsCommonActionFeedbackService;

    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsQualityObjectiveDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsQualityObjectiveDTO> searchQmsQualityObjectiveByPage(QueryReqBean<QmsQualityObjectiveDTO> queryReqBean) {
        QueryRespBean<QmsQualityObjectiveDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityObjectiveDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityObjectiveDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityObjectiveDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        // 文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityObjectiveDTO> result = qmsQualityObjectiveDAO.searchQmsQualityObjectiveByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件查询
     *
     * @param queryReqBean 查询条件
     * @return List<QmsQualityObjectiveDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityObjectiveDTO> searchQmsQualityObjective(QueryReqBean<QmsQualityObjectiveDTO> queryReqBean) {
        QueryRespBean<QmsQualityObjectiveDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityObjectiveDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityObjectiveDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityObjectiveDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        // 文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();
        List<QmsQualityObjectiveDTO> dataList = qmsQualityObjectiveDAO.searchQmsQualityObjective(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @return List<QmsQualityObjectiveDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityObjectiveDTO> searchQmsQualityObjectiveForExportExcel(QueryReqBean<QmsQualityObjectiveDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityObjectiveDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityObjectiveDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsQualityObjectiveDTO> result = qmsQualityObjectiveDAO.searchQmsQualityObjectiveForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId(), ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsQualityObjectiveDTO
     */
    @Transactional(readOnly = true)
    public QmsQualityObjectiveDTO queryQmsQualityObjectiveByPrimaryKey(String id) {
        QmsQualityObjectiveDTO qmsQualityObjectiveDTO = qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
        // 记录日志
        if (qmsQualityObjectiveDTO != null) {
            valueConvert(Arrays.asList(qmsQualityObjectiveDTO));
            SysLogUtil.log4Query(qmsQualityObjectiveDTO);
        }
        return qmsQualityObjectiveDTO;
    }

    /**
     * 新增对象
     *
     * @param qmsQualityObjectiveDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsQualityObjective(QmsQualityObjectiveDTO qmsQualityObjectiveDTO) {
        if (StringUtils.isEmpty(qmsQualityObjectiveDTO.getId())) {
            qmsQualityObjectiveDTO.setId(ComUtil.getId());
        }
        PojoUtil.setSysProperties(qmsQualityObjectiveDTO, OpType.insert);
        qmsQualityObjectiveDAO.insertQmsQualityObjective(qmsQualityObjectiveDTO);
        // 新增或修改子表对象集合
        insertOrUpdateQmsCommonActionFeedback(qmsQualityObjectiveDTO);
        // 记录日志
        SysLogUtil.log4Insert(qmsQualityObjectiveDTO);
        return qmsQualityObjectiveDTO.getId();
    }

    /**
     * 保存表单并启动流程
     *
     * @param qmsQualityObjectiveDTO 表单对象
     * @param parameter              启动流程所需要的参数
     * @return StartResultBean
     */
    @Transactional
    public StartResultBean insertQmsQualityObjectiveAndStartProcess(QmsQualityObjectiveDTO qmsQualityObjectiveDTO, Map<String, String> parameter) {
        Assert.notNull(parameter, "启动流程失败，请传递流程启动参数！");
        String processDefId = parameter.get("processDefId");
        String formCode = parameter.get("formCode");
        String jsonString = parameter.get("jsonString");
        String userId = parameter.get("userId");
        String deptId = parameter.get("deptId");
        Assert.hasText(processDefId, "启动流程失败，请传递流程启动参数！");
        // 业务操作
        this.insertQmsQualityObjective(qmsQualityObjectiveDTO);
        // 变量集合
        Map<String, Object> variables = new HashMap<>();
        // web表单传递过来(除表单对象外)的变量，可以为空
        if (jsonString != null && !"".equals(jsonString)) {
            Map<String, Object> extVariables = JsonUtil.parseJSON2Map(jsonString);
            variables.putAll(extVariables);
        }
        // 把表单对象转换成map,传递给流程变量
        Map<String, Object> pojoMap = null;
        try {
            pojoMap = (Map<String, Object>) PojoUtil.toMap(qmsQualityObjectiveDTO);
        } catch (Exception e) {
            throw new UtilsException("PojoUtil.toMap转换失败", e);
        }
        variables.putAll(pojoMap);
        // 构造启动流程的对象
        StartBean startBean = new StartBean();
        startBean.setProcessDefinitionId(processDefId);
        startBean.setFormCode(formCode);
        startBean.setStartUserId(userId);
        startBean.setStartDeptId(deptId);
        startBean.setVariables(variables);
        StartResultBean startResultBean = bpmOperateClient.startProcessInstance(startBean);// 启动流程
        // 返回流程启动的结果
        return startResultBean;
    }


    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsQualityObjectiveList(List<QmsQualityObjectiveDTO> dtoList) {
        for (QmsQualityObjectiveDTO qmsQualityObjectiveDTO : dtoList) {
            qmsQualityObjectiveDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityObjectiveDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityObjectiveDAO.insertQmsQualityObjectiveList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsQualityObjectiveDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityObjective(QmsQualityObjectiveDTO qmsQualityObjectiveDTO) {
        return updateDto(qmsQualityObjectiveDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsQualityObjectiveDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityObjectiveSensitive(QmsQualityObjectiveDTO qmsQualityObjectiveDTO) {
        return updateDto(qmsQualityObjectiveDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsQualityObjectiveList(List<QmsQualityObjectiveDTO> dtoList) {
        List<QmsQualityObjectiveDTO> updateList = new ArrayList<>();
        List<QmsQualityObjectiveDTO> oldList = new ArrayList<>();
        for (QmsQualityObjectiveDTO dto : dtoList) {
            QmsQualityObjectiveDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityObjectiveDTO updateDto = (QmsQualityObjectiveDTO) old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityObjectiveDAO.updateQmsQualityObjectiveList(subList);
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
    public int deleteQmsQualityObjectiveById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        // 记录日志
        QmsQualityObjectiveDTO qmsQualityObjectiveDTO = findById(id);
        if (qmsQualityObjectiveDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityObjectiveDTO);
        // 删除子表
        for (QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO : qmsCommonActionFeedbackService.queryQmsCommonActionFeedbackByPid(qmsQualityObjectiveDTO.getId())) {
            qmsCommonActionFeedbackService.deleteQmsCommonActionFeedbackById(qmsCommonActionFeedbackDTO.getId());
        }
        // 删除业务数据
        int count = qmsQualityObjectiveDAO.deleteQmsQualityObjectiveById(id);
        // 删除关联流程实例
        bpmOperateClient.deleteProcessInstanceByFormId(id);
        // 删除附件
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
    public int deleteQmsQualityObjectiveByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsQualityObjectiveById(id);
            result++;
        }
        return result;
    }

    /**
     * 流程服务回调方法（按主表主键单条删除业务数据）
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteDataQmsQualityObjectiveById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        // 记录日志
        QmsQualityObjectiveDTO qmsQualityObjectiveDTO = findById(id);
        if (qmsQualityObjectiveDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityObjectiveDTO);
        // 删除子表
        for (QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO : qmsCommonActionFeedbackService.queryQmsCommonActionFeedbackByPid(qmsQualityObjectiveDTO.getId())) {
            qmsCommonActionFeedbackService.deleteQmsCommonActionFeedbackById(qmsCommonActionFeedbackDTO.getId());
        }
        // 删除业务数据
        int count = qmsQualityObjectiveDAO.deleteQmsQualityObjectiveById(id);
        // 删除附件
        ossClient.deleteAttachByFormId(id);
        return count;
    }

    /**
     * 新增或修改子表对象集合
     *
     * @param qmsQualityObjectiveDTO 新增对象
     */
    private void insertOrUpdateQmsCommonActionFeedback(QmsQualityObjectiveDTO qmsQualityObjectiveDTO) {
        ValidationList<QmsCommonActionFeedbackDTO> qmsCommonActionFeedbackList = qmsQualityObjectiveDTO.getQmsCommonActionFeedbackDTOList();
        if (!CollectionUtils.isEmpty(qmsCommonActionFeedbackList)) {
            for (QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO : qmsCommonActionFeedbackList) {
                if (StringUtils.equals(OpType.delete.toString(), qmsCommonActionFeedbackDTO.getOperationType_())) {
                    qmsCommonActionFeedbackService.deleteQmsCommonActionFeedbackById(qmsCommonActionFeedbackDTO.getId());
                } else if (StringUtils.equals(OpType.update.toString(), qmsCommonActionFeedbackDTO.getOperationType_())) {
                    qmsCommonActionFeedbackService.updateQmsCommonActionFeedbackSensitive(qmsCommonActionFeedbackDTO);
                } else {
                    qmsCommonActionFeedbackDTO.setSourceId(qmsQualityObjectiveDTO.getId());
                    qmsCommonActionFeedbackDTO.setOrgIdentity(qmsQualityObjectiveDTO.getOrgIdentity());
                    qmsCommonActionFeedbackService.insertQmsCommonActionFeedback(qmsCommonActionFeedbackDTO);
                }
            }
        }
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsQualityObjectiveDTO
     * @return
     */
    private QmsQualityObjectiveDTO getUpdateMainDto(QmsQualityObjectiveDTO qmsQualityObjectiveDTO) {
        QmsQualityObjectiveDTO oldDTO = findById(qmsQualityObjectiveDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        // 记录日志
        SysLogUtil.log4Update(qmsQualityObjectiveDTO, oldDTO);
        PojoUtil.setSysProperties(qmsQualityObjectiveDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsQualityObjectiveDTO, false);
        return oldDTO;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return QmsQualityObjectiveDTO
     */
    private QmsQualityObjectiveDTO findById(String id) {
        return qmsQualityObjectiveDAO.findQmsQualityObjectiveById(id);
    }

    /**
     * 内部方法，
     *
     * @param dto             修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityObjectiveDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityObjectiveDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityObjectiveDTO updateDto = (QmsQualityObjectiveDTO) old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityObjectiveDAO.updateQmsQualityObjectiveAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityObjectiveDAO.updateQmsQualityObjectiveSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        try {
            // 更新流程变量
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.putAll((Map<String, Object>) PojoUtil.toMap(updateDto));
            bpmOperateClient.setVariablesByFormId(dto.getId(), variables);
        } catch (Exception e) {
            throw new UtilsException("流程变量更新失败", e);
        }
        // 新增或修改子表对象集合
        insertOrUpdateQmsCommonActionFeedback(dto);
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }

    /**
     * 批量导入
     *
     * @return
     */
    @Transactional
    public ExcelImportResult importData(List<Map<String, String>> dataList, String formData) {
        List<QmsQualityObjectiveDTO> qmsQualityObjectiveSuccessList = new ArrayList<QmsQualityObjectiveDTO>();
        List<QmsQualityObjectiveImportDTO> qmsQualityObjectiveErrList = new ArrayList<QmsQualityObjectiveImportDTO>();
        Map<String, Object> formDataMap = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(formData)) {
            formDataMap = JsonUtil.parseJSON2Map(formData);
        }
        if (!CollectionUtils.isEmpty(dataList)) {
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
            for (Map<String, String> data : dataList) {
                if (StringUtils.isEmpty(data.get("errorInfo"))) {
                    // 业务校验
                    QmsQualityObjectiveDTO dto = new QmsQualityObjectiveDTO();
                    Map2Bo.map2Pojo(data, dto);
                    qmsQualityObjectiveSuccessList.add(dto);
                } else {
                    QmsQualityObjectiveImportDTO dtoImp = new QmsQualityObjectiveImportDTO();
                    Map2Bo.map2Pojo(data, dtoImp);
                    qmsQualityObjectiveErrList.add(dtoImp);
                }
            }
            this.revValueConvert(qmsQualityObjectiveSuccessList, convertResultData);
            this.insertQmsQualityObjectiveList(qmsQualityObjectiveSuccessList);
        }
        ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsQualityObjectiveSuccessList, qmsQualityObjectiveErrList, QmsQualityObjectiveImportDTO.class, formDataMap);
        return excelImport;
    }

    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityObjectiveDTOList
     */
    private void valueConvert(List<QmsQualityObjectiveDTO> qmsQualityObjectiveDTOList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityObjectiveDTO qmsQualityObjective : qmsQualityObjectiveDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjective.getSecretLevel());
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjective.getDataStatCycle());
            BusinessUtil.createConvertSet(convertFormData, "QMS_OBJECTIVE_LEVEL", qmsQualityObjective.getObjectiveLevel());
            BusinessUtil.createConvertSet(convertFormData, "QMS_INDICATOR_TYPE", qmsQualityObjective.getIndicatorType());
        }
        if (convertFormData.size() > 0) {
            // 获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            // 循环设置Alias或Name的值
            for (QmsQualityObjectiveDTO qmsQualityObjective : qmsQualityObjectiveDTOList) {
                qmsQualityObjective.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjective.getSecretLevel()));
                qmsQualityObjective.setDataStatCycleName(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjective.getDataStatCycle()));
                qmsQualityObjective.setObjectiveLevelName(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECTIVE_LEVEL", qmsQualityObjective.getObjectiveLevel()));
                qmsQualityObjective.setIndicatorTypeName(BusinessUtil.convertFormat(convertResultData, "QMS_INDICATOR_TYPE", qmsQualityObjective.getIndicatorType()));
            }
        }
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsQualityObjectiveDTOList
     */
    private void revValueConvert(List<QmsQualityObjectiveDTO> qmsQualityObjectiveDTOList, Map<String, Map<String, String>> convertResultData) {
        // 循环设置Alias或Name的值
        for (QmsQualityObjectiveDTO qmsQualityObjective : qmsQualityObjectiveDTOList) {
            qmsQualityObjective.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityObjective.getSecretLevelName()));
            qmsQualityObjective.setDataStatCycle(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECT_DATA_STAT_CYCLE", qmsQualityObjective.getDataStatCycleName()));
            qmsQualityObjective.setObjectiveLevel(BusinessUtil.convertFormat(convertResultData, "QMS_OBJECTIVE_LEVEL", qmsQualityObjective.getObjectiveLevelName()));
            qmsQualityObjective.setIndicatorType(BusinessUtil.convertFormat(convertResultData, "QMS_INDICATOR_TYPE", qmsQualityObjective.getIndicatorTypeName()));
        }
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码提前组装数据
     *
     * @param dataList
     */
    private Map<String, Map<String, String>> assembleData(List<Map<String, String>> dataList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (Map<String, String> data : dataList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", data.get("secretLevelName"));
            BusinessUtil.createConvertSet(convertFormData, " QMS_OBJECT_DATA_STAT_CYCLE", data.get("dataStatCycleName"));
            BusinessUtil.createConvertSet(convertFormData, " QMS_OBJECTIVE_LEVEL", data.get("objectiveLevelName"));
            BusinessUtil.createConvertSet(convertFormData, " QMS_INDICATOR_TYPE", data.get("indicatorTypeName"));
        }
        return convertColumnClient.convertCodeToId(convertFormData);
    }
}