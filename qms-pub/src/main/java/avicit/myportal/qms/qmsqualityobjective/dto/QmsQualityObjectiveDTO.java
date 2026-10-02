package avicit.myportal.qms.qmsqualityobjective.dto;

import avicit.myportal.qms.qmscommonactionfeedback.dto.QmsCommonActionFeedbackDTO;
import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BeanDTO;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.properties.PlatformConstant;
import avicit.platform6.commons.utils.StringUtils;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.*;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-20 19:54
* @类说明：质量目标台账表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityObjectiveDTO", description = "质量目标台账表")
@PojoRemark(table="QMS_QUALITY_OBJECTIVE", object="QmsQualityObjectiveDTO", name="质量目标台账表")
@ExcelIgnoreUnannotated
public class QmsQualityObjectiveDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;

    private ValidationList<QmsCommonActionFeedbackDTO> qmsCommonActionFeedbackDTOList;

    public ValidationList<QmsCommonActionFeedbackDTO> getQmsCommonActionFeedbackDTOList() {
        return qmsCommonActionFeedbackDTOList;
    }

    public void setQmsCommonActionFeedbackDTOList(ValidationList<QmsCommonActionFeedbackDTO> qmsCommonActionFeedbackDTOList) {
        this.qmsCommonActionFeedbackDTOList = qmsCommonActionFeedbackDTOList;
    }

    /**
    * 目标ID
    */
    @Id
    @Size(max = 64, message = "目标ID长度不能超过64个字符")
    @ApiModelProperty(value = "目标ID", name = "id")
    @FieldRemark(column="ID", field="id", name="目标ID")
    private String id;

    /**
    * 目标编码
    */
    @ExcelProperty("目标编码")
    @Size(max = 50, message = "目标编码长度不能超过50个字符")
    @ApiModelProperty(value = "目标编码", name = "objectiveCode")
    @FieldRemark(column="OBJECTIVE_CODE", field="objectiveCode", name="目标编码")
    private String objectiveCode;

    /**
    * 目标名称
    */
    @ExcelProperty("目标名称")
    @Size(max = 256, message = "目标名称长度不能超过256个字符")
    @ApiModelProperty(value = "目标名称", name = "objectiveName")
    @FieldRemark(column="OBJECTIVE_NAME", field="objectiveName", name="目标名称")
    private String objectiveName;

    /**
    * 目标内容
    */
    @ExcelProperty("目标内容")
    @Size(max = 512, message = "目标内容长度不能超过512个字符")
    @ApiModelProperty(value = "目标内容", name = "objectiveContent")
    @FieldRemark(column="OBJECTIVE_CONTENT", field="objectiveContent", name="目标内容")
    private String objectiveContent;

    /**
    * 目标层级;INST所级DEPT部门级
    */
    @ExcelProperty("目标层级;INST所级DEPT部门级")
    @Size(max = 10, message = "目标层级;INST所级DEPT部门级长度不能超过10个字符")
    @ApiModelProperty(value = "目标层级;INST所级DEPT部门级", name = "objectiveLevel")
    @FieldRemark(column="OBJECTIVE_LEVEL", field="objectiveLevel", name="目标层级;INST所级DEPT部门级")
    private String objectiveLevel;
    private String objectiveLevelName;

    /**
    * 所属年度
    */
    @ExcelProperty("所属年度")
    @Size(max = 10, message = "所属年度长度不能超过10个字符")
    @ApiModelProperty(value = "所属年度", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年度")
    private String forYear;

    /**
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 2000, message = "责任部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任部门ID")
    private String responsibleDeptId;

    /**
    * 责任部门编号
    */
    @ExcelProperty("责任部门编号")
    @Size(max = 512, message = "责任部门编号长度不能超过512个字符")
    @ApiModelProperty(value = "责任部门编号", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任部门编号")
    private String responsibleDeptCode;

    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 2000, message = "责任部门长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任部门")
    private String responsibleDeptName;

    /**
    * 建议承接部门IDS;所级目标字段
    */
    @ExcelProperty("建议承接部门IDS;所级目标字段")
    @Size(max = 2000, message = "建议承接部门IDS;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "建议承接部门IDS;所级目标字段", name = "suggestAcceptDeptId")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_ID", field="suggestAcceptDeptId", name="建议承接部门IDS;所级目标字段")
    private String suggestAcceptDeptId;

    /**
    * 建议承接部门CODS;所级目标字段
    */
    @ExcelProperty("建议承接部门CODS;所级目标字段")
    @Size(max = 512, message = "建议承接部门CODS;所级目标字段长度不能超过512个字符")
    @ApiModelProperty(value = "建议承接部门CODS;所级目标字段", name = "suggestAcceptDeptCode")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_CODE", field="suggestAcceptDeptCode", name="建议承接部门CODS;所级目标字段")
    private String suggestAcceptDeptCode;

    /**
    * 建议承接部门;所级目标字段
    */
    @ExcelProperty("建议承接部门;所级目标字段")
    @Size(max = 2000, message = "建议承接部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "建议承接部门;所级目标字段", name = "suggestAcceptDeptName")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_NAME", field="suggestAcceptDeptName", name="建议承接部门;所级目标字段")
    private String suggestAcceptDeptName;

    /**
    * 统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新
    */
    @ExcelProperty("统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新")
    @Size(max = 20, message = "统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新长度不能超过20个字符")
    @ApiModelProperty(value = "统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新", name = "dataStatCycle")
    @FieldRemark(column="DATA_STAT_CYCLE", field="dataStatCycle", name="统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新")
    private String dataStatCycle;
    private String dataStatCycleName;

    /**
    * 指标类型;QUANT定量；QUAL:定性
    */
    @ExcelProperty("指标类型;QUANT定量；QUAL:定性")
    @Size(max = 20, message = "指标类型;QUANT定量；QUAL:定性长度不能超过20个字符")
    @ApiModelProperty(value = "指标类型;QUANT定量；QUAL:定性", name = "indicatorType")
    @FieldRemark(column="INDICATOR_TYPE", field="indicatorType", name="指标类型;QUANT定量；QUAL:定性")
    private String indicatorType;
    private String indicatorTypeName;
    /**
    * 开始日期
    */
    @ExcelProperty("开始日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "开始日期", name = "startTime")
    @FieldRemark(column="START_TIME", field="startTime", name="开始日期")
    private java.util.Date startTime;

    /**
    * 开始日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeBegin;

    /**
    * 开始日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeEnd;
    /**
    * 截止日期
    */
    @ExcelProperty("截止日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "截止日期", name = "deadline")
    @FieldRemark(column="DEADLINE", field="deadline", name="截止日期")
    private java.util.Date deadline;

    /**
    * 截止日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineBegin;

    /**
    * 截止日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineEnd;

    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 20, message = "业务状态长度不能超过20个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
    private String status;

    /**
    * 流程状态
    */
    @ExcelProperty("流程状态")
    @Size(max = 20, message = "流程状态长度不能超过20个字符")
    @ApiModelProperty(value = "流程状态", name = "processStatus")
    @FieldRemark(column="PROCESS_STATUS", field="processStatus", name="流程状态")
    private String processStatus;

    /**
    * 目标值
    */
    @ExcelProperty("目标值")
    @Size(max = 100, message = "目标值长度不能超过100个字符")
    @ApiModelProperty(value = "目标值", name = "targetValue")
    @FieldRemark(column="TARGET_VALUE", field="targetValue", name="目标值")
    private String targetValue;

    /**
    * 目标单位;百分比，次，项，天等
    */
    @ExcelProperty("目标单位;百分比，次，项，天等")
    @Size(max = 50, message = "目标单位;百分比，次，项，天等长度不能超过50个字符")
    @ApiModelProperty(value = "目标单位;百分比，次，项，天等", name = "targetUnit")
    @FieldRemark(column="TARGET_UNIT", field="targetUnit", name="目标单位;百分比，次，项，天等")
    private String targetUnit;
    /**
    * 完成率
    */
    @ExcelProperty("完成率")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 5, fraction = 2, message = "完成率格式不正确")
    @ApiModelProperty(value = "完成率", name = "completionRate")
    @FieldRemark(column="COMPLETION_RATE", field="completionRate", name="完成率")
    private java.math.BigDecimal completionRate;

    /**
    * 卓越值
    */
    @ExcelProperty("卓越值")
    @Size(max = 100, message = "卓越值长度不能超过100个字符")
    @ApiModelProperty(value = "卓越值", name = "excellentValue")
    @FieldRemark(column="EXCELLENT_VALUE", field="excellentValue", name="卓越值")
    private String excellentValue;

    /**
    * 基准值
    */
    @ExcelProperty("基准值")
    @Size(max = 100, message = "基准值长度不能超过100个字符")
    @ApiModelProperty(value = "基准值", name = "baselineValue")
    @FieldRemark(column="BASELINE_VALUE", field="baselineValue", name="基准值")
    private String baselineValue;

    /**
    * 实际完成值
    */
    @ExcelProperty("实际完成值")
    @Size(max = 100, message = "实际完成值长度不能超过100个字符")
    @ApiModelProperty(value = "实际完成值", name = "actualValue")
    @FieldRemark(column="ACTUAL_VALUE", field="actualValue", name="实际完成值")
    private String actualValue;

    /**
    * 完成结论;已完成，基本完成，未完成等
    */
    @ExcelProperty("完成结论;已完成，基本完成，未完成等")
    @Size(max = 50, message = "完成结论;已完成，基本完成，未完成等长度不能超过50个字符")
    @ApiModelProperty(value = "完成结论;已完成，基本完成，未完成等", name = "completionResult")
    @FieldRemark(column="COMPLETION_RESULT", field="completionResult", name="完成结论;已完成，基本完成，未完成等")
    private String completionResult;

    /**
    * 完成判定标准;如何判定完成
    */
    @ExcelProperty("完成判定标准;如何判定完成")
    @Size(max = 2000, message = "完成判定标准;如何判定完成长度不能超过2000个字符")
    @ApiModelProperty(value = "完成判定标准;如何判定完成", name = "judgementStandard")
    @FieldRemark(column="JUDGEMENT_STANDARD", field="judgementStandard", name="完成判定标准;如何判定完成")
    private String judgementStandard;

    /**
    * 风险状态;正常、预警、逾期、风险
    */
    @ExcelProperty("风险状态;正常、预警、逾期、风险")
    @Size(max = 20, message = "风险状态;正常、预警、逾期、风险长度不能超过20个字符")
    @ApiModelProperty(value = "风险状态;正常、预警、逾期、风险", name = "riskStatus")
    @FieldRemark(column="RISK_STATUS", field="riskStatus", name="风险状态;正常、预警、逾期、风险")
    private String riskStatus;
    /**
    * 最近反馈时间;系统反写
    */
    @ExcelProperty("最近反馈时间;系统反写")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "最近反馈时间;系统反写", name = "latestFeedbackTime")
    @FieldRemark(column="LATEST_FEEDBACK_TIME", field="latestFeedbackTime", name="最近反馈时间;系统反写")
    private java.util.Date latestFeedbackTime;

    /**
    * 最近反馈时间;系统反写起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date latestFeedbackTimeBegin;

    /**
    * 最近反馈时间;系统反写止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date latestFeedbackTimeEnd;
    /**
    * 发布时间;所级目标字段
    */
    @ExcelProperty("发布时间;所级目标字段")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "发布时间;所级目标字段", name = "publishTime")
    @FieldRemark(column="PUBLISH_TIME", field="publishTime", name="发布时间;所级目标字段")
    private java.util.Date publishTime;

    /**
    * 发布时间;所级目标字段起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date publishTimeBegin;

    /**
    * 发布时间;所级目标字段止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date publishTimeEnd;

    /**
    * 已承接部门ID;所级目标字段
    */
    @ExcelProperty("已承接部门ID;所级目标字段")
    @Size(max = 2000, message = "已承接部门ID;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已承接部门ID;所级目标字段", name = "acceptedDeptId")
    @FieldRemark(column="ACCEPTED_DEPT_ID", field="acceptedDeptId", name="已承接部门ID;所级目标字段")
    private String acceptedDeptId;

    /**
    * 已承接部门;所级目标字段
    */
    @ExcelProperty("已承接部门;所级目标字段")
    @Size(max = 2000, message = "已承接部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已承接部门;所级目标字段", name = "acceptedDeptName")
    @FieldRemark(column="ACCEPTED_DEPT_NAME", field="acceptedDeptName", name="已承接部门;所级目标字段")
    private String acceptedDeptName;
    /**
    * 已承接部门数量;所级目标字段
    */
    @ExcelProperty("已承接部门数量;所级目标字段")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 3, fraction = 0, message = "已承接部门数量;所级目标字段格式不正确")
    @ApiModelProperty(value = "已承接部门数量;所级目标字段", name = "acceptedDeptCount")
    @FieldRemark(column="ACCEPTED_DEPT_COUNT", field="acceptedDeptCount", name="已承接部门数量;所级目标字段")
    private java.math.BigDecimal acceptedDeptCount;

    /**
    * 已完成部门ID;所级目标字段
    */
    @ExcelProperty("已完成部门ID;所级目标字段")
    @Size(max = 2000, message = "已完成部门ID;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已完成部门ID;所级目标字段", name = "completedDeptId")
    @FieldRemark(column="COMPLETED_DEPT_ID", field="completedDeptId", name="已完成部门ID;所级目标字段")
    private String completedDeptId;

    /**
    * 已完成部门;所级目标字段
    */
    @ExcelProperty("已完成部门;所级目标字段")
    @Size(max = 2000, message = "已完成部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已完成部门;所级目标字段", name = "completedDeptName")
    @FieldRemark(column="COMPLETED_DEPT_NAME", field="completedDeptName", name="已完成部门;所级目标字段")
    private String completedDeptName;
    /**
    * 已完成部门数;所级目标字段
    */
    @ExcelProperty("已完成部门数;所级目标字段")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 3, fraction = 0, message = "已完成部门数;所级目标字段格式不正确")
    @ApiModelProperty(value = "已完成部门数;所级目标字段", name = "completedDeptCount")
    @FieldRemark(column="COMPLETED_DEPT_COUNT", field="completedDeptCount", name="已完成部门数;所级目标字段")
    private java.math.BigDecimal completedDeptCount;

    /**
    * 部门质控员ID;部门级目标字段
    */
    @ExcelProperty("部门质控员ID;部门级目标字段")
    @Size(max = 64, message = "部门质控员ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "部门质控员ID;部门级目标字段", name = "qcUserId")
    @FieldRemark(column="QC_USER_ID", field="qcUserId", name="部门质控员ID;部门级目标字段")
    private String qcUserId;

    /**
    * 部门质控员CODE;部门级目标字段
    */
    @ExcelProperty("部门质控员CODE;部门级目标字段")
    @Size(max = 10, message = "部门质控员CODE;部门级目标字段长度不能超过10个字符")
    @ApiModelProperty(value = "部门质控员CODE;部门级目标字段", name = "qcUserCode")
    @FieldRemark(column="QC_USER_CODE", field="qcUserCode", name="部门质控员CODE;部门级目标字段")
    private String qcUserCode;

    /**
    * 部门质控员;部门级目标字段
    */
    @ExcelProperty("部门质控员;部门级目标字段")
    @Size(max = 50, message = "部门质控员;部门级目标字段长度不能超过50个字符")
    @ApiModelProperty(value = "部门质控员;部门级目标字段", name = "qcUserName")
    @FieldRemark(column="QC_USER_NAME", field="qcUserName", name="部门质控员;部门级目标字段")
    private String qcUserName;

    /**
    * 责任领导ID;部门级目标字段
    */
    @ExcelProperty("责任领导ID;部门级目标字段")
    @Size(max = 64, message = "责任领导ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "责任领导ID;部门级目标字段", name = "responsibleLeaderId")
    @FieldRemark(column="RESPONSIBLE_LEADER_ID", field="responsibleLeaderId", name="责任领导ID;部门级目标字段")
    private String responsibleLeaderId;

    /**
    * 责任领导CODE;部门级目标字段
    */
    @ExcelProperty("责任领导CODE;部门级目标字段")
    @Size(max = 50, message = "责任领导CODE;部门级目标字段长度不能超过50个字符")
    @ApiModelProperty(value = "责任领导CODE;部门级目标字段", name = "responsibleLeaderCode")
    @FieldRemark(column="RESPONSIBLE_LEADER_CODE", field="responsibleLeaderCode", name="责任领导CODE;部门级目标字段")
    private String responsibleLeaderCode;

    /**
    * 责任领导;部门级目标字段
    */
    @ExcelProperty("责任领导;部门级目标字段")
    @Size(max = 128, message = "责任领导;部门级目标字段长度不能超过128个字符")
    @ApiModelProperty(value = "责任领导;部门级目标字段", name = "responsibleLeaderName")
    @FieldRemark(column="RESPONSIBLE_LEADER_NAME", field="responsibleLeaderName", name="责任领导;部门级目标字段")
    private String responsibleLeaderName;

    /**
    * 审批流程实例ID;部门级目标字段
    */
    @ExcelProperty("审批流程实例ID;部门级目标字段")
    @Size(max = 64, message = "审批流程实例ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "审批流程实例ID;部门级目标字段", name = "processInstId")
    @FieldRemark(column="PROCESS_INST_ID", field="processInstId", name="审批流程实例ID;部门级目标字段")
    private String processInstId;
    /**
    * 审批通过时间;部门级目标字段
    */
    @ExcelProperty("审批通过时间;部门级目标字段")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "审批通过时间;部门级目标字段", name = "approvalTime")
    @FieldRemark(column="APPROVAL_TIME", field="approvalTime", name="审批通过时间;部门级目标字段")
    private java.util.Date approvalTime;

    /**
    * 审批通过时间;部门级目标字段起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date approvalTimeBegin;

    /**
    * 审批通过时间;部门级目标字段止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date approvalTimeEnd;
    /**
    * 计划总数;部门级目标字段
    */
    @ExcelProperty("计划总数;部门级目标字段")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 4, fraction = 0, message = "计划总数;部门级目标字段格式不正确")
    @ApiModelProperty(value = "计划总数;部门级目标字段", name = "planCount")
    @FieldRemark(column="PLAN_COUNT", field="planCount", name="计划总数;部门级目标字段")
    private java.math.BigDecimal planCount;
    /**
    * 已完成计划数;部门级目标字段
    */
    @ExcelProperty("已完成计划数;部门级目标字段")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 4, fraction = 0, message = "已完成计划数;部门级目标字段格式不正确")
    @ApiModelProperty(value = "已完成计划数;部门级目标字段", name = "completedPlanCount")
    @FieldRemark(column="COMPLETED_PLAN_COUNT", field="completedPlanCount", name="已完成计划数;部门级目标字段")
    private java.math.BigDecimal completedPlanCount;

    /**
    * 创建时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date creationDateBegin;

    /**
    * 创建时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date creationDateEnd;

    /**
    * 最后修改时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date lastUpdateDateBegin;

    /**
    * 最后修改时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date lastUpdateDateEnd;

    /**
    * 密级
    */
    @FieldRemark(column="SECRET_LEVEL", field="secretLevel", name="密级", dataType="lookup", lookupType="PLATFORM_FILE_SECRET_LEVEL")
    private String secretLevel;
    @ExcelProperty("密级")
    private String secretLevelName;

    /**
    * 是否已删除
    */
    @ExcelProperty("是否已删除")
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private String ynDeleted;

    /**
    * 备注
    */
    @ExcelProperty("备注")
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private String remark;
    /**
    * 排序
    */
    @ExcelProperty("排序")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 0, message = "排序格式不正确")
    @ApiModelProperty(value = "排序", name = "orderBy")
    @FieldRemark(column="ORDER_BY", field="orderBy", name="排序")
    private java.math.BigDecimal orderBy;

    /**
    * 扩展字段_01
    */
    @Size(max = 512, message = "扩展字段_01长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_01", name = "attribute01")
    @FieldRemark(column="ATTRIBUTE_01", field="attribute01", name="扩展字段_01")
    private String attribute01;

    /**
    * 扩展字段_02
    */
    @Size(max = 512, message = "扩展字段_02长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_02", name = "attribute02")
    @FieldRemark(column="ATTRIBUTE_02", field="attribute02", name="扩展字段_02")
    private String attribute02;

    /**
    * 扩展字段_03
    */
    @Size(max = 512, message = "扩展字段_03长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_03", name = "attribute03")
    @FieldRemark(column="ATTRIBUTE_03", field="attribute03", name="扩展字段_03")
    private String attribute03;

    /**
    * 扩展字段_04
    */
    @Size(max = 512, message = "扩展字段_04长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_04", name = "attribute04")
    @FieldRemark(column="ATTRIBUTE_04", field="attribute04", name="扩展字段_04")
    private String attribute04;

    /**
    * 扩展字段_05
    */
    @Size(max = 512, message = "扩展字段_05长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_05", name = "attribute05")
    @FieldRemark(column="ATTRIBUTE_05", field="attribute05", name="扩展字段_05")
    private String attribute05;

    /**
    * 扩展字段_06
    */
    @Size(max = 512, message = "扩展字段_06长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_06", name = "attribute06")
    @FieldRemark(column="ATTRIBUTE_06", field="attribute06", name="扩展字段_06")
    private String attribute06;

    /**
    * 扩展字段_07
    */
    @Size(max = 512, message = "扩展字段_07长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_07", name = "attribute07")
    @FieldRemark(column="ATTRIBUTE_07", field="attribute07", name="扩展字段_07")
    private String attribute07;

    /**
    * 扩展字段_08
    */
    @Size(max = 512, message = "扩展字段_08长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_08", name = "attribute08")
    @FieldRemark(column="ATTRIBUTE_08", field="attribute08", name="扩展字段_08")
    private String attribute08;

    /**
    * 扩展字段_09
    */
    @Size(max = 512, message = "扩展字段_09长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_09", name = "attribute09")
    @FieldRemark(column="ATTRIBUTE_09", field="attribute09", name="扩展字段_09")
    private String attribute09;

    /**
    * 扩展字段_10
    */
    @Size(max = 512, message = "扩展字段_10长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_10", name = "attribute10")
    @FieldRemark(column="ATTRIBUTE_10", field="attribute10", name="扩展字段_10")
    private String attribute10;

    /**
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private String parentId;

    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    @ApiModelProperty(value = "全路径", name = "treePath")
    @FieldRemark(column="TREE_PATH", field="treePath", name="全路径")
    private String treePath;
    /**
    * 节点层级
    */
    @Digits(integer = 16, fraction = 0, message = "节点层级格式不正确")
    @ApiModelProperty(value = "节点层级", name = "treeLevel")
    @FieldRemark(column="TREE_LEVEL", field="treeLevel", name="节点层级")
    private java.math.BigDecimal treeLevel;
    /**
    * 本级排序
    */
    @NotNull(message = "本级排序不能为空")
    @Digits(integer = 16, fraction = 0, message = "本级排序格式不正确")
    @ApiModelProperty(value = "本级排序", name = "treeSort")
    @FieldRemark(column="TREE_SORT", field="treeSort", name="本级排序")
    private java.math.BigDecimal treeSort;

    /**
    * 全级排序
    */
    @Size(max = 1000, message = "全级排序长度不能超过1000个字符")
    @ApiModelProperty(value = "全级排序", name = "treeSorts")
    @FieldRemark(column="TREE_SORTS", field="treeSorts", name="全级排序")
    private String treeSorts;

    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    @ApiModelProperty(value = "是否叶子节点", name = "treeLeaf")
    @FieldRemark(column="TREE_LEAF", field="treeLeaf", name="是否叶子节点")
    private String treeLeaf;

    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    @ApiModelProperty(value = "交付物", name = "expectedDeliverable")
    @FieldRemark(column="EXPECTED_DELIVERABLE", field="expectedDeliverable", name="交付物")
    private String expectedDeliverable;

    /**
    * 目标来源
    */
    @ExcelProperty("目标来源")
    @Size(max = 50, message = "目标来源长度不能超过50个字符")
    @ApiModelProperty(value = "目标来源", name = "objectiveSource")
    @FieldRemark(column="OBJECTIVE_SOURCE", field="objectiveSource", name="目标来源")
    private String objectiveSource;

    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 64, message = "责任人长度不能超过64个字符")
    @ApiModelProperty(value = "责任人", name = "responsibleStaffId")
    @FieldRemark(column="RESPONSIBLE_STAFF_ID", field="responsibleStaffId", name="责任人")
    private String responsibleStaffId;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 10, message = "责任人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleStaffCode")
    @FieldRemark(column="RESPONSIBLE_STAFF_CODE", field="responsibleStaffCode", name="责任人CODE")
    private String responsibleStaffCode;

    /**
    * 责任人姓名
    */
    @ExcelProperty("责任人姓名")
    @Size(max = 50, message = "责任人姓名长度不能超过50个字符")
    @ApiModelProperty(value = "责任人姓名", name = "responsibleStaffName")
    @FieldRemark(column="RESPONSIBLE_STAFF_NAME", field="responsibleStaffName", name="责任人姓名")
    private String responsibleStaffName;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getObjectiveCode(){
        return objectiveCode;
    }

    public void setObjectiveCode(String objectiveCode){
        this.objectiveCode = objectiveCode;
    }

    public String getObjectiveName(){
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName){
        this.objectiveName = objectiveName;
    }

    public String getObjectiveContent(){
        return objectiveContent;
    }

    public void setObjectiveContent(String objectiveContent){
        this.objectiveContent = objectiveContent;
    }

    public String getObjectiveLevel(){
        return objectiveLevel;
    }

    public void setObjectiveLevel(String objectiveLevel){
        this.objectiveLevel = objectiveLevel;
    }

    public String getForYear(){
        return forYear;
    }

    public void setForYear(String forYear){
        this.forYear = forYear;
    }

    public String getResponsibleDeptId(){
        return responsibleDeptId;
    }

    public void setResponsibleDeptId(String responsibleDeptId){
        this.responsibleDeptId = responsibleDeptId;
    }

    public String getResponsibleDeptCode(){
        return responsibleDeptCode;
    }

    public void setResponsibleDeptCode(String responsibleDeptCode){
        this.responsibleDeptCode = responsibleDeptCode;
    }

    public String getResponsibleDeptName(){
        return responsibleDeptName;
    }

    public void setResponsibleDeptName(String responsibleDeptName){
        this.responsibleDeptName = responsibleDeptName;
    }

    public String getSuggestAcceptDeptId(){
        return suggestAcceptDeptId;
    }

    public void setSuggestAcceptDeptId(String suggestAcceptDeptId){
        this.suggestAcceptDeptId = suggestAcceptDeptId;
    }

    public String getSuggestAcceptDeptCode(){
        return suggestAcceptDeptCode;
    }

    public void setSuggestAcceptDeptCode(String suggestAcceptDeptCode){
        this.suggestAcceptDeptCode = suggestAcceptDeptCode;
    }

    public String getSuggestAcceptDeptName(){
        return suggestAcceptDeptName;
    }

    public void setSuggestAcceptDeptName(String suggestAcceptDeptName){
        this.suggestAcceptDeptName = suggestAcceptDeptName;
    }

    public String getDataStatCycle(){
        return dataStatCycle;
    }

    public void setDataStatCycle(String dataStatCycle){
        this.dataStatCycle = dataStatCycle;
    }

    public String getIndicatorType(){
        return indicatorType;
    }

    public void setIndicatorType(String indicatorType){
        this.indicatorType = indicatorType;
    }

    public java.util.Date getStartTime(){
        return startTime;
    }

    public void setStartTime(java.util.Date startTime){
        this.startTime = startTime;
        super.handleNullValue();
    }

    public java.util.Date getStartTimeBegin(){
        return startTimeBegin;
    }

    public void setStartTimeBegin(java.util.Date startTimeBegin){
        this.startTimeBegin = startTimeBegin;
    }

    public java.util.Date getStartTimeEnd(){
        return startTimeEnd;
    }

    public void setStartTimeEnd(java.util.Date startTimeEnd){
        this.startTimeEnd = startTimeEnd;
    }

    public java.util.Date getDeadline(){
        return deadline;
    }

    public void setDeadline(java.util.Date deadline){
        this.deadline = deadline;
        super.handleNullValue();
    }

    public java.util.Date getDeadlineBegin(){
        return deadlineBegin;
    }

    public void setDeadlineBegin(java.util.Date deadlineBegin){
        this.deadlineBegin = deadlineBegin;
    }

    public java.util.Date getDeadlineEnd(){
        return deadlineEnd;
    }

    public void setDeadlineEnd(java.util.Date deadlineEnd){
        this.deadlineEnd = deadlineEnd;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getProcessStatus(){
        return processStatus;
    }

    public void setProcessStatus(String processStatus){
        this.processStatus = processStatus;
    }

    public String getTargetValue(){
        return targetValue;
    }

    public void setTargetValue(String targetValue){
        this.targetValue = targetValue;
    }

    public String getTargetUnit(){
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit){
        this.targetUnit = targetUnit;
    }

    public java.math.BigDecimal getCompletionRate(){
        return completionRate;
    }

    public void setCompletionRate(java.math.BigDecimal completionRate){
        this.completionRate = completionRate;
        super.handleNullValue();
    }

    public String getExcellentValue(){
        return excellentValue;
    }

    public void setExcellentValue(String excellentValue){
        this.excellentValue = excellentValue;
    }

    public String getBaselineValue(){
        return baselineValue;
    }

    public void setBaselineValue(String baselineValue){
        this.baselineValue = baselineValue;
    }

    public String getActualValue(){
        return actualValue;
    }

    public void setActualValue(String actualValue){
        this.actualValue = actualValue;
    }

    public String getCompletionResult(){
        return completionResult;
    }

    public void setCompletionResult(String completionResult){
        this.completionResult = completionResult;
    }

    public String getJudgementStandard(){
        return judgementStandard;
    }

    public void setJudgementStandard(String judgementStandard){
        this.judgementStandard = judgementStandard;
    }

    public String getRiskStatus(){
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus){
        this.riskStatus = riskStatus;
    }

    public java.util.Date getLatestFeedbackTime(){
        return latestFeedbackTime;
    }

    public void setLatestFeedbackTime(java.util.Date latestFeedbackTime){
        this.latestFeedbackTime = latestFeedbackTime;
        super.handleNullValue();
    }

    public java.util.Date getLatestFeedbackTimeBegin(){
        return latestFeedbackTimeBegin;
    }

    public void setLatestFeedbackTimeBegin(java.util.Date latestFeedbackTimeBegin){
        this.latestFeedbackTimeBegin = latestFeedbackTimeBegin;
    }

    public java.util.Date getLatestFeedbackTimeEnd(){
        return latestFeedbackTimeEnd;
    }

    public void setLatestFeedbackTimeEnd(java.util.Date latestFeedbackTimeEnd){
        this.latestFeedbackTimeEnd = latestFeedbackTimeEnd;
    }

    public java.util.Date getPublishTime(){
        return publishTime;
    }

    public void setPublishTime(java.util.Date publishTime){
        this.publishTime = publishTime;
        super.handleNullValue();
    }

    public java.util.Date getPublishTimeBegin(){
        return publishTimeBegin;
    }

    public void setPublishTimeBegin(java.util.Date publishTimeBegin){
        this.publishTimeBegin = publishTimeBegin;
    }

    public java.util.Date getPublishTimeEnd(){
        return publishTimeEnd;
    }

    public void setPublishTimeEnd(java.util.Date publishTimeEnd){
        this.publishTimeEnd = publishTimeEnd;
    }

    public String getAcceptedDeptId(){
        return acceptedDeptId;
    }

    public void setAcceptedDeptId(String acceptedDeptId){
        this.acceptedDeptId = acceptedDeptId;
    }

    public String getAcceptedDeptName(){
        return acceptedDeptName;
    }

    public void setAcceptedDeptName(String acceptedDeptName){
        this.acceptedDeptName = acceptedDeptName;
    }

    public java.math.BigDecimal getAcceptedDeptCount(){
        return acceptedDeptCount;
    }

    public void setAcceptedDeptCount(java.math.BigDecimal acceptedDeptCount){
        this.acceptedDeptCount = acceptedDeptCount;
        super.handleNullValue();
    }

    public String getCompletedDeptId(){
        return completedDeptId;
    }

    public void setCompletedDeptId(String completedDeptId){
        this.completedDeptId = completedDeptId;
    }

    public String getCompletedDeptName(){
        return completedDeptName;
    }

    public void setCompletedDeptName(String completedDeptName){
        this.completedDeptName = completedDeptName;
    }

    public java.math.BigDecimal getCompletedDeptCount(){
        return completedDeptCount;
    }

    public void setCompletedDeptCount(java.math.BigDecimal completedDeptCount){
        this.completedDeptCount = completedDeptCount;
        super.handleNullValue();
    }

    public String getQcUserId(){
        return qcUserId;
    }

    public void setQcUserId(String qcUserId){
        this.qcUserId = qcUserId;
    }

    public String getQcUserCode(){
        return qcUserCode;
    }

    public void setQcUserCode(String qcUserCode){
        this.qcUserCode = qcUserCode;
    }

    public String getQcUserName(){
        return qcUserName;
    }

    public void setQcUserName(String qcUserName){
        this.qcUserName = qcUserName;
    }

    public String getResponsibleLeaderId(){
        return responsibleLeaderId;
    }

    public void setResponsibleLeaderId(String responsibleLeaderId){
        this.responsibleLeaderId = responsibleLeaderId;
    }

    public String getResponsibleLeaderCode(){
        return responsibleLeaderCode;
    }

    public void setResponsibleLeaderCode(String responsibleLeaderCode){
        this.responsibleLeaderCode = responsibleLeaderCode;
    }

    public String getResponsibleLeaderName(){
        return responsibleLeaderName;
    }

    public void setResponsibleLeaderName(String responsibleLeaderName){
        this.responsibleLeaderName = responsibleLeaderName;
    }

    public String getProcessInstId(){
        return processInstId;
    }

    public void setProcessInstId(String processInstId){
        this.processInstId = processInstId;
    }

    public java.util.Date getApprovalTime(){
        return approvalTime;
    }

    public void setApprovalTime(java.util.Date approvalTime){
        this.approvalTime = approvalTime;
        super.handleNullValue();
    }

    public java.util.Date getApprovalTimeBegin(){
        return approvalTimeBegin;
    }

    public void setApprovalTimeBegin(java.util.Date approvalTimeBegin){
        this.approvalTimeBegin = approvalTimeBegin;
    }

    public java.util.Date getApprovalTimeEnd(){
        return approvalTimeEnd;
    }

    public void setApprovalTimeEnd(java.util.Date approvalTimeEnd){
        this.approvalTimeEnd = approvalTimeEnd;
    }

    public java.math.BigDecimal getPlanCount(){
        return planCount;
    }

    public void setPlanCount(java.math.BigDecimal planCount){
        this.planCount = planCount;
        super.handleNullValue();
    }

    public java.math.BigDecimal getCompletedPlanCount(){
        return completedPlanCount;
    }

    public void setCompletedPlanCount(java.math.BigDecimal completedPlanCount){
        this.completedPlanCount = completedPlanCount;
        super.handleNullValue();
    }

    public java.util.Date getCreationDateBegin(){
        return creationDateBegin;
    }

    public void setCreationDateBegin(java.util.Date creationDateBegin){
        this.creationDateBegin = creationDateBegin;
    }

    public java.util.Date getCreationDateEnd(){
        return creationDateEnd;
    }

    public void setCreationDateEnd(java.util.Date creationDateEnd){
        this.creationDateEnd = creationDateEnd;
    }

    public java.util.Date getLastUpdateDateBegin(){
        return lastUpdateDateBegin;
    }

    public void setLastUpdateDateBegin(java.util.Date lastUpdateDateBegin){
        this.lastUpdateDateBegin = lastUpdateDateBegin;
    }

    public java.util.Date getLastUpdateDateEnd(){
        return lastUpdateDateEnd;
    }

    public void setLastUpdateDateEnd(java.util.Date lastUpdateDateEnd){
        this.lastUpdateDateEnd = lastUpdateDateEnd;
    }
    public String getSecretLevel(){
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel){
        this.secretLevel = secretLevel;
    }

    public String getSecretLevelName(){
        return secretLevelName;
    }

    public void setSecretLevelName(String secretLevelName){
        this.secretLevelName = secretLevelName;
    }

    public String getYnDeleted(){
        return ynDeleted;
    }

    public void setYnDeleted(String ynDeleted){
        this.ynDeleted = ynDeleted;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public java.math.BigDecimal getOrderBy(){
        return orderBy;
    }

    public void setOrderBy(java.math.BigDecimal orderBy){
        this.orderBy = orderBy;
        super.handleNullValue();
    }

    public String getAttribute01(){
        return attribute01;
    }

    public void setAttribute01(String attribute01){
        this.attribute01 = attribute01;
    }

    public String getAttribute02(){
        return attribute02;
    }

    public void setAttribute02(String attribute02){
        this.attribute02 = attribute02;
    }

    public String getAttribute03(){
        return attribute03;
    }

    public void setAttribute03(String attribute03){
        this.attribute03 = attribute03;
    }

    public String getAttribute04(){
        return attribute04;
    }

    public void setAttribute04(String attribute04){
        this.attribute04 = attribute04;
    }

    public String getAttribute05(){
        return attribute05;
    }

    public void setAttribute05(String attribute05){
        this.attribute05 = attribute05;
    }

    public String getAttribute06(){
        return attribute06;
    }

    public void setAttribute06(String attribute06){
        this.attribute06 = attribute06;
    }

    public String getAttribute07(){
        return attribute07;
    }

    public void setAttribute07(String attribute07){
        this.attribute07 = attribute07;
    }

    public String getAttribute08(){
        return attribute08;
    }

    public void setAttribute08(String attribute08){
        this.attribute08 = attribute08;
    }

    public String getAttribute09(){
        return attribute09;
    }

    public void setAttribute09(String attribute09){
        this.attribute09 = attribute09;
    }

    public String getAttribute10(){
        return attribute10;
    }

    public void setAttribute10(String attribute10){
        this.attribute10 = attribute10;
    }

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getTreePath(){
        return treePath;
    }

    public void setTreePath(String treePath){
        this.treePath = treePath;
    }

    public java.math.BigDecimal getTreeLevel(){
        return treeLevel;
    }

    public void setTreeLevel(java.math.BigDecimal treeLevel){
        this.treeLevel = treeLevel;
        super.handleNullValue();
    }

    public java.math.BigDecimal getTreeSort(){
        return treeSort;
    }

    public void setTreeSort(java.math.BigDecimal treeSort){
        this.treeSort = treeSort;
        super.handleNullValue();
    }

    public String getTreeSorts(){
        return treeSorts;
    }

    public void setTreeSorts(String treeSorts){
        this.treeSorts = treeSorts;
    }

    public String getTreeLeaf(){
        return treeLeaf;
    }

    public void setTreeLeaf(String treeLeaf){
        this.treeLeaf = treeLeaf;
    }

    public String getExpectedDeliverable(){
        return expectedDeliverable;
    }

    public void setExpectedDeliverable(String expectedDeliverable){
        this.expectedDeliverable = expectedDeliverable;
    }

    public String getObjectiveSource(){
        return objectiveSource;
    }

    public void setObjectiveSource(String objectiveSource){
        this.objectiveSource = objectiveSource;
    }

    public String getResponsibleStaffId(){
        return responsibleStaffId;
    }

    public void setResponsibleStaffId(String responsibleStaffId){
        this.responsibleStaffId = responsibleStaffId;
    }

    public String getResponsibleStaffCode(){
        return responsibleStaffCode;
    }

    public void setResponsibleStaffCode(String responsibleStaffCode){
        this.responsibleStaffCode = responsibleStaffCode;
    }

    public String getResponsibleStaffName(){
        return responsibleStaffName;
    }

    public void setResponsibleStaffName(String responsibleStaffName){
        this.responsibleStaffName = responsibleStaffName;
    }

    public String getObjectiveLevelName() {
        return objectiveLevelName;
    }

    public void setObjectiveLevelName(String objectiveLevelName) {
        this.objectiveLevelName = objectiveLevelName;
    }

    public String getDataStatCycleName() {
        return dataStatCycleName;
    }

    public void setDataStatCycleName(String dataStatCycleName) {
        this.dataStatCycleName = dataStatCycleName;
    }

    public String getIndicatorTypeName() {
        return indicatorTypeName;
    }

    public void setIndicatorTypeName(String indicatorTypeName) {
        this.indicatorTypeName = indicatorTypeName;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "质量目标台账表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量目标台账表";
        } else {
            return super.logTitle;
        }
    }

    @Override
    public PlatformConstant.LogType getLogType() {
        if (super.logType == null) {
            return PlatformConstant.LogType.module_operate;
        } else {
            return super.logType;
        }
    }
}
