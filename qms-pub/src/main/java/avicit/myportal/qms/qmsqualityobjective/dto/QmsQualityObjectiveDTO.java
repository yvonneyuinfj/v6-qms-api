package avicit.myportal.qms.qmsqualityobjective.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BaseTreeDTO;
import avicit.platform6.core.properties.PlatformConstant;
import avicit.platform6.commons.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-04 15:10
* @类说明：质量目标台账表Dto
* @修改记录：
*/
@ApiModel(value = "QmsQualityObjectiveDTO", description = "质量目标台账表")
@PojoRemark(table="QMS_QUALITY_OBJECTIVE", object="QmsQualityObjectiveDTO", name="质量目标台账表")
public class QmsQualityObjectiveDTO extends BaseTreeDTO {
    private static final long serialVersionUID = 1L;

    private List<QmsQualityObjectiveDTO> children;

    /**
    * 目标ID
    */
    @Id
    @Size(max = 64, message = "目标ID长度不能超过64个字符")
    @ApiModelProperty(value = "目标ID", name = "id")
    @FieldRemark(column="ID", field="id", name="目标ID")
    private java.lang.String id;

    @ApiModelProperty(value = "目标来源", name = "objectiveSource")
    @FieldRemark(column="OBJECTIVE_SOURCE", field="objectiveSource", name="目标来源")
    private java.lang.String objectiveSource;

    /**
    * 目标编码
    */
    @Size(max = 50, message = "目标编码长度不能超过50个字符")
    @ApiModelProperty(value = "目标编码", name = "objectiveCode")
    @FieldRemark(column="OBJECTIVE_CODE", field="objectiveCode", name="目标编码")
    private java.lang.String objectiveCode;

    /**
    * 目标名称
    */
    @NotBlank(message = "目标名称不能为空")
    @Size(max = 256, message = "目标名称长度不能超过256个字符")
    @ApiModelProperty(value = "目标名称", name = "objectiveName")
    @FieldRemark(column="OBJECTIVE_NAME", field="objectiveName", name="目标名称")
    private java.lang.String objectiveName;


    /**
    * 目标内容
    */
    @Size(max = 512, message = "目标内容长度不能超过512个字符")
    @ApiModelProperty(value = "目标内容", name = "objectiveContent")
    @FieldRemark(column="OBJECTIVE_CONTENT", field="objectiveContent", name="目标内容")
    private java.lang.String objectiveContent;

    /**
    * 目标层级;1所级5部门级
    */
    @Size(max = 10, message = "目标层级;1所级5部门级长度不能超过10个字符")
    @ApiModelProperty(value = "目标层级;1所级5部门级", name = "objectiveLevel")
    @FieldRemark(column="OBJECTIVE_LEVEL", field="objectiveLevel", name="目标层级;1所级5部门级")
    private java.lang.String objectiveLevel;
    private java.lang.String objectiveLevelName;

    /**
    * 责任部门ID
    */
    @Size(max = 2000, message = "责任部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任部门ID")
    private java.lang.String responsibleDeptId;
    private java.lang.String responsibleDeptIdAlias;

    /**
    * 责任部门编号
    */
    @Size(max = 512, message = "责任部门编号长度不能超过512个字符")
    @ApiModelProperty(value = "责任部门编号", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任部门编号")
    private java.lang.String responsibleDeptCode;

    /**
    * 责任部门
    */
    @Size(max = 2000, message = "责任部门长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任部门")
    private java.lang.String responsibleDeptName;

    /**
    * 统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新
    */
    @Size(max = 20, message = "统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新长度不能超过20个字符")
    @ApiModelProperty(value = "统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新", name = "dataStatCycle")
    @FieldRemark(column="DATA_STAT_CYCLE", field="dataStatCycle", name="统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新")
    private java.lang.String dataStatCycle;
    private java.lang.String dataStatCycleName;

    /**
    * 指标类型;QUANT定量；QUAL:定性
    */
    @Size(max = 20, message = "指标类型;QUANT定量；QUAL:定性长度不能超过20个字符")
    @ApiModelProperty(value = "指标类型;QUANT定量；QUAL:定性", name = "indicatorType")
    @FieldRemark(column="INDICATOR_TYPE", field="indicatorType", name="指标类型;QUANT定量；QUAL:定性")
    private java.lang.String indicatorType;
    private java.lang.String indicatorTypeName;

    /**
    * 开始日期
    */
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
    * 目标状态
    */
    @Size(max = 20, message = "目标状态长度不能超过20个字符")
    @ApiModelProperty(value = "目标状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="目标状态")
    private java.lang.String status;
    private java.lang.String statusName;

    /**
    * 目标值
    */
    @Size(max = 100, message = "目标值长度不能超过100个字符")
    @ApiModelProperty(value = "目标值", name = "targetValue")
    @FieldRemark(column="TARGET_VALUE", field="targetValue", name="目标值")
    private java.lang.String targetValue;

    /**
    * 目标单位;百分比，次，项，天等
    */
    @Size(max = 50, message = "目标单位;百分比，次，项，天等长度不能超过50个字符")
    @ApiModelProperty(value = "目标单位;百分比，次，项，天等", name = "targetUnit")
    @FieldRemark(column="TARGET_UNIT", field="targetUnit", name="目标单位;百分比，次，项，天等")
    private java.lang.String targetUnit;

    /**
    * 卓越值
    */
    @Size(max = 100, message = "卓越值长度不能超过100个字符")
    @ApiModelProperty(value = "卓越值", name = "excellentValue")
    @FieldRemark(column="EXCELLENT_VALUE", field="excellentValue", name="卓越值")
    private java.lang.String excellentValue;

    /**
    * 基准值
    */
    @Size(max = 100, message = "基准值长度不能超过100个字符")
    @ApiModelProperty(value = "基准值", name = "baselineValue")
    @FieldRemark(column="BASELINE_VALUE", field="baselineValue", name="基准值")
    private java.lang.String baselineValue;

    /**
    * 实际完成值
    */
    @Size(max = 100, message = "实际完成值长度不能超过100个字符")
    @ApiModelProperty(value = "实际完成值", name = "actualValue")
    @FieldRemark(column="ACTUAL_VALUE", field="actualValue", name="实际完成值")
    private java.lang.String actualValue;
/**
* 完成率
*/
    @Digits(integer = 5, fraction = 2, message = "完成率格式不正确")
    @ApiModelProperty(value = "完成率", name = "completionRate")
    @FieldRemark(column="COMPLETION_RATE", field="completionRate", name="完成率")
    private java.math.BigDecimal completionRate;

    /**
    * 完成结论;已完成，基本完成，未完成等
    */
    @Size(max = 50, message = "完成结论;已完成，基本完成，未完成等长度不能超过50个字符")
    @ApiModelProperty(value = "完成结论;已完成，基本完成，未完成等", name = "completionResult")
    @FieldRemark(column="COMPLETION_RESULT", field="completionResult", name="完成结论;已完成，基本完成，未完成等")
    private java.lang.String completionResult;

    /**
    * 完成判定标准;如何判定完成
    */
    @Size(max = 2000, message = "完成判定标准;如何判定完成长度不能超过2000个字符")
    @ApiModelProperty(value = "完成判定标准;如何判定完成", name = "judgementStandard")
    @FieldRemark(column="JUDGEMENT_STANDARD", field="judgementStandard", name="完成判定标准;如何判定完成")
    private java.lang.String judgementStandard;

    /**
    * 风险状态;正常、预警、逾期、风险
    */
    @Size(max = 20, message = "风险状态;正常、预警、逾期、风险长度不能超过20个字符")
    @ApiModelProperty(value = "风险状态;正常、预警、逾期、风险", name = "riskStatus")
    @FieldRemark(column="RISK_STATUS", field="riskStatus", name="风险状态;正常、预警、逾期、风险")
    private java.lang.String riskStatus;

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
    @NotBlank(message = "密级不能为空")
    @ApiModelProperty(value = "密级", name = "secretLevel")
    @FieldRemark(column="SECRET_LEVEL", field="secretLevel", name="密级", dataType="lookup", lookupType="PLATFORM_FILE_SECRET_LEVEL")
    private java.lang.String secretLevel;
    private java.lang.String secretLevelName;


    /**
    * 是否已删除
    */
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private java.lang.String ynDeleted;

    /**
    * 备注
    */
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private java.lang.String remark;
/**
* 排序
*/
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
    private java.lang.String attribute01;

    /**
    * 扩展字段_02
    */
    @Size(max = 512, message = "扩展字段_02长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_02", name = "attribute02")
    @FieldRemark(column="ATTRIBUTE_02", field="attribute02", name="扩展字段_02")
    private java.lang.String attribute02;

    /**
    * 扩展字段_03
    */
    @Size(max = 512, message = "扩展字段_03长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_03", name = "attribute03")
    @FieldRemark(column="ATTRIBUTE_03", field="attribute03", name="扩展字段_03")
    private java.lang.String attribute03;

    /**
    * 扩展字段_04
    */
    @Size(max = 512, message = "扩展字段_04长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_04", name = "attribute04")
    @FieldRemark(column="ATTRIBUTE_04", field="attribute04", name="扩展字段_04")
    private java.lang.String attribute04;

    /**
    * 扩展字段_05
    */
    @Size(max = 512, message = "扩展字段_05长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_05", name = "attribute05")
    @FieldRemark(column="ATTRIBUTE_05", field="attribute05", name="扩展字段_05")
    private java.lang.String attribute05;

    /**
    * 扩展字段_06
    */
    @Size(max = 512, message = "扩展字段_06长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_06", name = "attribute06")
    @FieldRemark(column="ATTRIBUTE_06", field="attribute06", name="扩展字段_06")
    private java.lang.String attribute06;

    /**
    * 扩展字段_07
    */
    @Size(max = 512, message = "扩展字段_07长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_07", name = "attribute07")
    @FieldRemark(column="ATTRIBUTE_07", field="attribute07", name="扩展字段_07")
    private java.lang.String attribute07;

    /**
    * 扩展字段_08
    */
    @Size(max = 512, message = "扩展字段_08长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_08", name = "attribute08")
    @FieldRemark(column="ATTRIBUTE_08", field="attribute08", name="扩展字段_08")
    private java.lang.String attribute08;

    /**
    * 扩展字段_09
    */
    @Size(max = 512, message = "扩展字段_09长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_09", name = "attribute09")
    @FieldRemark(column="ATTRIBUTE_09", field="attribute09", name="扩展字段_09")
    private java.lang.String attribute09;

    /**
    * 扩展字段_10
    */
    @Size(max = 512, message = "扩展字段_10长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_10", name = "attribute10")
    @FieldRemark(column="ATTRIBUTE_10", field="attribute10", name="扩展字段_10")
    private java.lang.String attribute10;

    /**
    * 父节点ID
    */
    @LogField
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private java.lang.String parentId;

    /**
    * 父节点ID显示字段
    */
    private java.lang.String parentObjectiveName;

    /**
    * 所属年度
    */
    @Size(max = 10, message = "所属年度长度不能超过10个字符")
    @ApiModelProperty(value = "所属年度", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年度")
    private java.lang.String forYear;

    /**
    * 建议承接部门IDS;所级目标字段
    */
    @Size(max = 2000, message = "建议承接部门IDS;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "建议承接部门IDS;所级目标字段", name = "suggestAcceptDeptId")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_ID", field="suggestAcceptDeptId", name="建议承接部门IDS;所级目标字段")
    private java.lang.String suggestAcceptDeptId;

    /**
    * 建议承接部门CODS;所级目标字段
    */
    @Size(max = 512, message = "建议承接部门CODS;所级目标字段长度不能超过512个字符")
    @ApiModelProperty(value = "建议承接部门CODS;所级目标字段", name = "suggestAcceptDeptCode")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_CODE", field="suggestAcceptDeptCode", name="建议承接部门CODS;所级目标字段")
    private java.lang.String suggestAcceptDeptCode;

    /**
    * 建议承接部门;所级目标字段
    */
    @Size(max = 2000, message = "建议承接部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "建议承接部门;所级目标字段", name = "suggestAcceptDeptName")
    @FieldRemark(column="SUGGEST_ACCEPT_DEPT_NAME", field="suggestAcceptDeptName", name="建议承接部门;所级目标字段")
    private java.lang.String suggestAcceptDeptName;

    /**
    * 截止日期
    */
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
    * 流程状态
    */
    @Size(max = 20, message = "流程状态长度不能超过20个字符")
    @ApiModelProperty(value = "流程状态", name = "processStatus")
    @FieldRemark(column="PROCESS_STATUS", field="processStatus", name="流程状态")
    private java.lang.String processStatus;

    /**
    * 最近反馈时间;系统反写
    */
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
    @Size(max = 2000, message = "已承接部门ID;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已承接部门ID;所级目标字段", name = "acceptedDeptId")
    @FieldRemark(column="ACCEPTED_DEPT_ID", field="acceptedDeptId", name="已承接部门ID;所级目标字段")
    private java.lang.String acceptedDeptId;

    /**
    * 已承接部门;所级目标字段
    */
    @Size(max = 2000, message = "已承接部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已承接部门;所级目标字段", name = "acceptedDeptName")
    @FieldRemark(column="ACCEPTED_DEPT_NAME", field="acceptedDeptName", name="已承接部门;所级目标字段")
    private java.lang.String acceptedDeptName;
/**
* 已承接部门数量;所级目标字段
*/
    @Digits(integer = 3, fraction = 0, message = "已承接部门数量;所级目标字段格式不正确")
    @ApiModelProperty(value = "已承接部门数量;所级目标字段", name = "acceptedDeptCount")
    @FieldRemark(column="ACCEPTED_DEPT_COUNT", field="acceptedDeptCount", name="已承接部门数量;所级目标字段")
    private java.math.BigDecimal acceptedDeptCount;

    /**
    * 已完成部门ID;所级目标字段
    */
    @Size(max = 2000, message = "已完成部门ID;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已完成部门ID;所级目标字段", name = "completedDeptId")
    @FieldRemark(column="COMPLETED_DEPT_ID", field="completedDeptId", name="已完成部门ID;所级目标字段")
    private java.lang.String completedDeptId;

    /**
    * 已完成部门;所级目标字段
    */
    @Size(max = 2000, message = "已完成部门;所级目标字段长度不能超过2000个字符")
    @ApiModelProperty(value = "已完成部门;所级目标字段", name = "completedDeptName")
    @FieldRemark(column="COMPLETED_DEPT_NAME", field="completedDeptName", name="已完成部门;所级目标字段")
    private java.lang.String completedDeptName;
/**
* 已完成部门数;所级目标字段
*/
    @Digits(integer = 3, fraction = 0, message = "已完成部门数;所级目标字段格式不正确")
    @ApiModelProperty(value = "已完成部门数;所级目标字段", name = "completedDeptCount")
    @FieldRemark(column="COMPLETED_DEPT_COUNT", field="completedDeptCount", name="已完成部门数;所级目标字段")
    private java.math.BigDecimal completedDeptCount;

    /**
    * 部门质控员ID;部门级目标字段
    */
    @Size(max = 64, message = "部门质控员ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "部门质控员ID;部门级目标字段", name = "qcUserId")
    @FieldRemark(column="QC_USER_ID", field="qcUserId", name="部门质控员ID;部门级目标字段")
    private java.lang.String qcUserId;

    /**
    * 部门质控员CODE;部门级目标字段
    */
    @Size(max = 10, message = "部门质控员CODE;部门级目标字段长度不能超过10个字符")
    @ApiModelProperty(value = "部门质控员CODE;部门级目标字段", name = "qcUserCode")
    @FieldRemark(column="QC_USER_CODE", field="qcUserCode", name="部门质控员CODE;部门级目标字段")
    private java.lang.String qcUserCode;

    /**
    * 部门质控员;部门级目标字段
    */
    @Size(max = 50, message = "部门质控员;部门级目标字段长度不能超过50个字符")
    @ApiModelProperty(value = "部门质控员;部门级目标字段", name = "qcUserName")
    @FieldRemark(column="QC_USER_NAME", field="qcUserName", name="部门质控员;部门级目标字段")
    private java.lang.String qcUserName;

    /**
    * 责任领导ID;部门级目标字段
    */
    @Size(max = 64, message = "责任领导ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "责任领导ID;部门级目标字段", name = "responsibleLeaderId")
    @FieldRemark(column="RESPONSIBLE_LEADER_ID", field="responsibleLeaderId", name="责任领导ID;部门级目标字段")
    private java.lang.String responsibleLeaderId;

    /**
    * 责任领导CODE;部门级目标字段
    */
    @Size(max = 50, message = "责任领导CODE;部门级目标字段长度不能超过50个字符")
    @ApiModelProperty(value = "责任领导CODE;部门级目标字段", name = "responsibleLeaderCode")
    @FieldRemark(column="RESPONSIBLE_LEADER_CODE", field="responsibleLeaderCode", name="责任领导CODE;部门级目标字段")
    private java.lang.String responsibleLeaderCode;

    /**
    * 责任领导;部门级目标字段
    */
    @Size(max = 128, message = "责任领导;部门级目标字段长度不能超过128个字符")
    @ApiModelProperty(value = "责任领导;部门级目标字段", name = "responsibleLeaderName")
    @FieldRemark(column="RESPONSIBLE_LEADER_NAME", field="responsibleLeaderName", name="责任领导;部门级目标字段")
    private java.lang.String responsibleLeaderName;

    /**
    * 审批流程实例ID;部门级目标字段
    */
    @Size(max = 64, message = "审批流程实例ID;部门级目标字段长度不能超过64个字符")
    @ApiModelProperty(value = "审批流程实例ID;部门级目标字段", name = "processInstId")
    @FieldRemark(column="PROCESS_INST_ID", field="processInstId", name="审批流程实例ID;部门级目标字段")
    private java.lang.String processInstId;

    /**
    * 审批通过时间;部门级目标字段
    */
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
    @Digits(integer = 4, fraction = 0, message = "计划总数;部门级目标字段格式不正确")
    @ApiModelProperty(value = "计划总数;部门级目标字段", name = "planCount")
    @FieldRemark(column="PLAN_COUNT", field="planCount", name="计划总数;部门级目标字段")
    private java.math.BigDecimal planCount;
/**
* 已完成计划数;部门级目标字段
*/
    @Digits(integer = 4, fraction = 0, message = "已完成计划数;部门级目标字段格式不正确")
    @ApiModelProperty(value = "已完成计划数;部门级目标字段", name = "completedPlanCount")
    @FieldRemark(column="COMPLETED_PLAN_COUNT", field="completedPlanCount", name="已完成计划数;部门级目标字段")
    private java.math.BigDecimal completedPlanCount;

    /**
    * 交付物
    */
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    @ApiModelProperty(value = "交付物", name = "expectedDeliverable")
    @FieldRemark(column="EXPECTED_DELIVERABLE", field="expectedDeliverable", name="交付物")
    private java.lang.String expectedDeliverable;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getObjectiveSource() {
        return objectiveSource;
    }

    public void setObjectiveSource(java.lang.String objectiveSource) {
        this.objectiveSource = objectiveSource;
    }

    public java.lang.String getObjectiveCode(){
        return objectiveCode;
    }

    public void setObjectiveCode(java.lang.String objectiveCode){
        this.objectiveCode = objectiveCode;
    }

    public java.lang.String getObjectiveName(){
        return objectiveName;
    }

    public void setObjectiveName(java.lang.String objectiveName){
        this.objectiveName = objectiveName;
    }

    public java.lang.String getObjectiveContent(){
        return objectiveContent;
    }

    public void setObjectiveContent(java.lang.String objectiveContent){
        this.objectiveContent = objectiveContent;
    }

    public java.lang.String getObjectiveLevel(){
        return objectiveLevel;
    }

    public void setObjectiveLevel(java.lang.String objectiveLevel){
        this.objectiveLevel = objectiveLevel;
    }

    public java.lang.String getResponsibleDeptId(){
        return responsibleDeptId;
    }

    public void setResponsibleDeptId(java.lang.String responsibleDeptId){
        this.responsibleDeptId = responsibleDeptId;
    }

    public java.lang.String getResponsibleDeptCode(){
        return responsibleDeptCode;
    }

    public void setResponsibleDeptCode(java.lang.String responsibleDeptCode){
        this.responsibleDeptCode = responsibleDeptCode;
    }

    public java.lang.String getResponsibleDeptName(){
        return responsibleDeptName;
    }

    public void setResponsibleDeptName(java.lang.String responsibleDeptName){
        this.responsibleDeptName = responsibleDeptName;
    }

    public java.lang.String getDataStatCycle(){
        return dataStatCycle;
    }

    public void setDataStatCycle(java.lang.String dataStatCycle){
        this.dataStatCycle = dataStatCycle;
    }

    public java.lang.String getIndicatorType(){
        return indicatorType;
    }

    public void setIndicatorType(java.lang.String indicatorType){
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

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getTargetValue(){
        return targetValue;
    }

    public void setTargetValue(java.lang.String targetValue){
        this.targetValue = targetValue;
    }

    public java.lang.String getTargetUnit(){
        return targetUnit;
    }

    public void setTargetUnit(java.lang.String targetUnit){
        this.targetUnit = targetUnit;
    }

    public java.lang.String getExcellentValue(){
        return excellentValue;
    }

    public void setExcellentValue(java.lang.String excellentValue){
        this.excellentValue = excellentValue;
    }

    public java.lang.String getBaselineValue(){
        return baselineValue;
    }

    public void setBaselineValue(java.lang.String baselineValue){
        this.baselineValue = baselineValue;
    }

    public java.lang.String getActualValue(){
        return actualValue;
    }

    public void setActualValue(java.lang.String actualValue){
        this.actualValue = actualValue;
    }

    public java.math.BigDecimal getCompletionRate(){
        return completionRate;
    }

    public void setCompletionRate(java.math.BigDecimal completionRate){
        this.completionRate = completionRate;
        super.handleNullValue();
    }

    public java.lang.String getCompletionResult(){
        return completionResult;
    }

    public void setCompletionResult(java.lang.String completionResult){
        this.completionResult = completionResult;
    }

    public java.lang.String getJudgementStandard(){
        return judgementStandard;
    }

    public void setJudgementStandard(java.lang.String judgementStandard){
        this.judgementStandard = judgementStandard;
    }

    public java.lang.String getRiskStatus(){
        return riskStatus;
    }

    public void setRiskStatus(java.lang.String riskStatus){
        this.riskStatus = riskStatus;
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

    public java.lang.String getSecretLevel(){
        return secretLevel;
    }

    public void setSecretLevel(java.lang.String secretLevel){
        this.secretLevel = secretLevel;
    }

    public java.lang.String getSecretLevelName(){
        return secretLevelName;
    }

    public void setSecretLevelName(java.lang.String secretLevelName){
        this.secretLevelName = secretLevelName;
    }

    public java.lang.String getYnDeleted(){
        return ynDeleted;
    }

    public void setYnDeleted(java.lang.String ynDeleted){
        this.ynDeleted = ynDeleted;
    }

    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }

    public java.math.BigDecimal getOrderBy(){
        return orderBy;
    }

    public void setOrderBy(java.math.BigDecimal orderBy){
        this.orderBy = orderBy;
        super.handleNullValue();
    }

    public java.lang.String getAttribute01(){
        return attribute01;
    }

    public void setAttribute01(java.lang.String attribute01){
        this.attribute01 = attribute01;
    }

    public java.lang.String getAttribute02(){
        return attribute02;
    }

    public void setAttribute02(java.lang.String attribute02){
        this.attribute02 = attribute02;
    }

    public java.lang.String getAttribute03(){
        return attribute03;
    }

    public void setAttribute03(java.lang.String attribute03){
        this.attribute03 = attribute03;
    }

    public java.lang.String getAttribute04(){
        return attribute04;
    }

    public void setAttribute04(java.lang.String attribute04){
        this.attribute04 = attribute04;
    }

    public java.lang.String getAttribute05(){
        return attribute05;
    }

    public void setAttribute05(java.lang.String attribute05){
        this.attribute05 = attribute05;
    }

    public java.lang.String getAttribute06(){
        return attribute06;
    }

    public void setAttribute06(java.lang.String attribute06){
        this.attribute06 = attribute06;
    }

    public java.lang.String getAttribute07(){
        return attribute07;
    }

    public void setAttribute07(java.lang.String attribute07){
        this.attribute07 = attribute07;
    }

    public java.lang.String getAttribute08(){
        return attribute08;
    }

    public void setAttribute08(java.lang.String attribute08){
        this.attribute08 = attribute08;
    }

    public java.lang.String getAttribute09(){
        return attribute09;
    }

    public void setAttribute09(java.lang.String attribute09){
        this.attribute09 = attribute09;
    }

    public java.lang.String getAttribute10(){
        return attribute10;
    }

    public void setAttribute10(java.lang.String attribute10){
        this.attribute10 = attribute10;
    }

    public java.lang.String getParentId(){
        return parentId;
    }

    public void setParentId(java.lang.String parentId){
        this.parentId = parentId;
    }

    public java.lang.String getParentObjectiveName(){
        return parentObjectiveName;
    }

    public void setParentObjectiveName(java.lang.String parentObjectiveName){
        this.parentObjectiveName = parentObjectiveName;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getSuggestAcceptDeptId(){
        return suggestAcceptDeptId;
    }

    public void setSuggestAcceptDeptId(java.lang.String suggestAcceptDeptId){
        this.suggestAcceptDeptId = suggestAcceptDeptId;
    }

    public java.lang.String getSuggestAcceptDeptCode(){
        return suggestAcceptDeptCode;
    }

    public void setSuggestAcceptDeptCode(java.lang.String suggestAcceptDeptCode){
        this.suggestAcceptDeptCode = suggestAcceptDeptCode;
    }

    public java.lang.String getSuggestAcceptDeptName(){
        return suggestAcceptDeptName;
    }

    public void setSuggestAcceptDeptName(java.lang.String suggestAcceptDeptName){
        this.suggestAcceptDeptName = suggestAcceptDeptName;
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

    public java.lang.String getProcessStatus(){
        return processStatus;
    }

    public void setProcessStatus(java.lang.String processStatus){
        this.processStatus = processStatus;
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

    public java.lang.String getAcceptedDeptId(){
        return acceptedDeptId;
    }

    public void setAcceptedDeptId(java.lang.String acceptedDeptId){
        this.acceptedDeptId = acceptedDeptId;
    }

    public java.lang.String getAcceptedDeptName(){
        return acceptedDeptName;
    }

    public void setAcceptedDeptName(java.lang.String acceptedDeptName){
        this.acceptedDeptName = acceptedDeptName;
    }

    public java.math.BigDecimal getAcceptedDeptCount(){
        return acceptedDeptCount;
    }

    public void setAcceptedDeptCount(java.math.BigDecimal acceptedDeptCount){
        this.acceptedDeptCount = acceptedDeptCount;
        super.handleNullValue();
    }

    public java.lang.String getCompletedDeptId(){
        return completedDeptId;
    }

    public void setCompletedDeptId(java.lang.String completedDeptId){
        this.completedDeptId = completedDeptId;
    }

    public java.lang.String getCompletedDeptName(){
        return completedDeptName;
    }

    public void setCompletedDeptName(java.lang.String completedDeptName){
        this.completedDeptName = completedDeptName;
    }

    public java.math.BigDecimal getCompletedDeptCount(){
        return completedDeptCount;
    }

    public void setCompletedDeptCount(java.math.BigDecimal completedDeptCount){
        this.completedDeptCount = completedDeptCount;
        super.handleNullValue();
    }

    public java.lang.String getQcUserId(){
        return qcUserId;
    }

    public void setQcUserId(java.lang.String qcUserId){
        this.qcUserId = qcUserId;
    }

    public java.lang.String getQcUserCode(){
        return qcUserCode;
    }

    public void setQcUserCode(java.lang.String qcUserCode){
        this.qcUserCode = qcUserCode;
    }

    public java.lang.String getQcUserName(){
        return qcUserName;
    }

    public void setQcUserName(java.lang.String qcUserName){
        this.qcUserName = qcUserName;
    }

    public java.lang.String getResponsibleLeaderId(){
        return responsibleLeaderId;
    }

    public void setResponsibleLeaderId(java.lang.String responsibleLeaderId){
        this.responsibleLeaderId = responsibleLeaderId;
    }

    public java.lang.String getResponsibleLeaderCode(){
        return responsibleLeaderCode;
    }

    public void setResponsibleLeaderCode(java.lang.String responsibleLeaderCode){
        this.responsibleLeaderCode = responsibleLeaderCode;
    }

    public java.lang.String getResponsibleLeaderName(){
        return responsibleLeaderName;
    }

    public void setResponsibleLeaderName(java.lang.String responsibleLeaderName){
        this.responsibleLeaderName = responsibleLeaderName;
    }

    public java.lang.String getProcessInstId(){
        return processInstId;
    }

    public void setProcessInstId(java.lang.String processInstId){
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

    public java.lang.String getExpectedDeliverable(){
        return expectedDeliverable;
    }

    public void setExpectedDeliverable(java.lang.String expectedDeliverable){
        this.expectedDeliverable = expectedDeliverable;
    }

    public String getObjectiveLevelName() {
        return objectiveLevelName;
    }

    public void setObjectiveLevelName(String objectiveLevelName) {
        this.objectiveLevelName = objectiveLevelName;
    }

    public String getResponsibleDeptIdAlias() {
        return responsibleDeptIdAlias;
    }

    public void setResponsibleDeptIdAlias(String responsibleDeptIdAlias) {
        this.responsibleDeptIdAlias = responsibleDeptIdAlias;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<QmsQualityObjectiveDTO> getChildren() {
        if(children == null && "N".equals(this.treeLeaf)){
          return new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<QmsQualityObjectiveDTO> children) {
        this.children = children;
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