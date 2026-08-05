package avicit.myportal.qms.qmsqualityproblemfeedback.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BeanDTO;
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

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:12
* @类说明：归零反哺表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityProblemFeedbackDTO", description = "归零反哺表")
@PojoRemark(table="QMS_QUALITY_PROBLEM_FEEDBACK", object="QmsQualityProblemFeedbackDTO", name="归零反哺表")
@ExcelIgnoreUnannotated
public class QmsQualityProblemFeedbackDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 主键
    */
    @Id
    @Size(max = 64, message = "主键长度不能超过64个字符")
    @ApiModelProperty(value = "主键", name = "id")
    @FieldRemark(column="ID", field="id", name="主键")
    private java.lang.String id;

    /**
    * 反哺编号
    */
    @ExcelProperty("反哺编号")
    @Size(max = 128, message = "反哺编号长度不能超过128个字符")
    @ApiModelProperty(value = "反哺编号", name = "feedbackCode")
    @FieldRemark(column="FEEDBACK_CODE", field="feedbackCode", name="反哺编号")
    private java.lang.String feedbackCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 来源问题ID
    */
    @ExcelProperty("来源问题ID")
    @Size(max = 64, message = "来源问题ID长度不能超过64个字符")
    @ApiModelProperty(value = "来源问题ID", name = "sourceProblemId")
    @FieldRemark(column="SOURCE_PROBLEM_ID", field="sourceProblemId", name="来源问题ID")
    private java.lang.String sourceProblemId;
    /**
    * 来源更新时间
    */
    @ExcelProperty("来源更新时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "来源更新时间", name = "sourceUpdateTime")
    @FieldRemark(column="SOURCE_UPDATE_TIME", field="sourceUpdateTime", name="来源更新时间")
    private java.util.Date sourceUpdateTime;

    /**
    * 来源更新时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date sourceUpdateTimeBegin;

    /**
    * 来源更新时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date sourceUpdateTimeEnd;
    /**
    * 最近同步时间
    */
    @ExcelProperty("最近同步时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "最近同步时间", name = "syncTime")
    @FieldRemark(column="SYNC_TIME", field="syncTime", name="最近同步时间")
    private java.util.Date syncTime;

    /**
    * 最近同步时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date syncTimeBegin;

    /**
    * 最近同步时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date syncTimeEnd;

    /**
    * 来源系统CODE
    */
    @ExcelProperty("来源系统CODE")
    @Size(max = 50, message = "来源系统CODE长度不能超过50个字符")
    @ApiModelProperty(value = "来源系统CODE", name = "sourceSystemCode")
    @FieldRemark(column="SOURCE_SYSTEM_CODE", field="sourceSystemCode", name="来源系统CODE")
    private java.lang.String sourceSystemCode;

    /**
    * 质量问题编号
    */
    @ExcelProperty("质量问题编号")
    @Size(max = 50, message = "质量问题编号长度不能超过50个字符")
    @ApiModelProperty(value = "质量问题编号", name = "problemCode")
    @FieldRemark(column="PROBLEM_CODE", field="problemCode", name="质量问题编号")
    private java.lang.String problemCode;

    /**
    * 来源问题状态
    */
    @ExcelProperty("来源问题状态")
    @Size(max = 10, message = "来源问题状态长度不能超过10个字符")
    @ApiModelProperty(value = "来源问题状态", name = "sourceStatus")
    @FieldRemark(column="SOURCE_STATUS", field="sourceStatus", name="来源问题状态")
    private java.lang.String sourceStatus;

    /**
    * 问题名称
    */
    @ExcelProperty("问题名称")
    @Size(max = 128, message = "问题名称长度不能超过128个字符")
    @ApiModelProperty(value = "问题名称", name = "problemName")
    @FieldRemark(column="PROBLEM_NAME", field="problemName", name="问题名称")
    private java.lang.String problemName;

    /**
    * 问题类型
    */
    @ExcelProperty("问题类型")
    @Size(max = 50, message = "问题类型长度不能超过50个字符")
    @ApiModelProperty(value = "问题类型", name = "problemType")
    @FieldRemark(column="PROBLEM_TYPE", field="problemType", name="问题类型")
    private java.lang.String problemType;

    /**
    * 问题分类
    */
    @ExcelProperty("问题分类")
    @Size(max = 50, message = "问题分类长度不能超过50个字符")
    @ApiModelProperty(value = "问题分类", name = "problemCategory")
    @FieldRemark(column="PROBLEM_CATEGORY", field="problemCategory", name="问题分类")
    private java.lang.String problemCategory;

    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 128, message = "型号长度不能超过128个字符")
    @ApiModelProperty(value = "型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号")
    private java.lang.String model;
    /**
    * 发生时间
    */
    @ExcelProperty("发生时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "发生时间", name = "occurrenceTime")
    @FieldRemark(column="OCCURRENCE_TIME", field="occurrenceTime", name="发生时间")
    private java.util.Date occurrenceTime;

    /**
    * 发生时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date occurrenceTimeBegin;

    /**
    * 发生时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date occurrenceTimeEnd;
    /**
    * 归零时间
    */
    @ExcelProperty("归零时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "归零时间", name = "closeTime")
    @FieldRemark(column="CLOSE_TIME", field="closeTime", name="归零时间")
    private java.util.Date closeTime;

    /**
    * 归零时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date closeTimeBegin;

    /**
    * 归零时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date closeTimeEnd;

    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任人ID", name = "responsibleStaffId")
    @FieldRemark(column="RESPONSIBLE_STAFF_ID", field="responsibleStaffId", name="责任人ID")
    private java.lang.String responsibleStaffId;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 10, message = "责任人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleStaffCode")
    @FieldRemark(column="RESPONSIBLE_STAFF_CODE", field="responsibleStaffCode", name="责任人CODE")
    private java.lang.String responsibleStaffCode;

    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 50, message = "责任人长度不能超过50个字符")
    @ApiModelProperty(value = "责任人", name = "responsibleStaffName")
    @FieldRemark(column="RESPONSIBLE_STAFF_NAME", field="responsibleStaffName", name="责任人")
    private java.lang.String responsibleStaffName;

    /**
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 64, message = "责任部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任部门ID")
    private java.lang.String responsibleDeptId;

    /**
    * 责任部门CODE
    */
    @ExcelProperty("责任部门CODE")
    @Size(max = 10, message = "责任部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "责任部门CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任部门CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 128, message = "责任部门长度不能超过128个字符")
    @ApiModelProperty(value = "责任部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任部门")
    private java.lang.String responsibleDeptName;

    /**
    * 归零报告ID
    */
    @ExcelProperty("归零报告ID")
    @Size(max = 64, message = "归零报告ID长度不能超过64个字符")
    @ApiModelProperty(value = "归零报告ID", name = "closeReportId")
    @FieldRemark(column="CLOSE_REPORT_ID", field="closeReportId", name="归零报告ID")
    private java.lang.String closeReportId;

    /**
    * 归零报告编号
    */
    @ExcelProperty("归零报告编号")
    @Size(max = 50, message = "归零报告编号长度不能超过50个字符")
    @ApiModelProperty(value = "归零报告编号", name = "closeReportCode")
    @FieldRemark(column="CLOSE_REPORT_CODE", field="closeReportCode", name="归零报告编号")
    private java.lang.String closeReportCode;

    /**
    * 归零报告名称
    */
    @ExcelProperty("归零报告名称")
    @Size(max = 128, message = "归零报告名称长度不能超过128个字符")
    @ApiModelProperty(value = "归零报告名称", name = "closeReportName")
    @FieldRemark(column="CLOSE_REPORT_NAME", field="closeReportName", name="归零报告名称")
    private java.lang.String closeReportName;

    /**
    * 问题原因和机理
    */
    @ExcelProperty("问题原因和机理")
    @Size(max = 2000, message = "问题原因和机理长度不能超过2000个字符")
    @ApiModelProperty(value = "问题原因和机理", name = "causeMechanism")
    @FieldRemark(column="CAUSE_MECHANISM", field="causeMechanism", name="问题原因和机理")
    private java.lang.String causeMechanism;

    /**
    * 改进措施
    */
    @ExcelProperty("改进措施")
    @Size(max = 2000, message = "改进措施长度不能超过2000个字符")
    @ApiModelProperty(value = "改进措施", name = "improvementMeasure")
    @FieldRemark(column="IMPROVEMENT_MEASURE", field="improvementMeasure", name="改进措施")
    private java.lang.String improvementMeasure;

    /**
    * 反哺维度
    */
    @ExcelProperty("反哺维度")
    @Size(max = 256, message = "反哺维度长度不能超过256个字符")
    @ApiModelProperty(value = "反哺维度", name = "feedbackDimension")
    @FieldRemark(column="FEEDBACK_DIMENSION", field="feedbackDimension", name="反哺维度")
    private java.lang.String feedbackDimension;

    /**
    * 是否启用反哺
    */
    @ExcelProperty("是否启用反哺")
    @Size(max = 2, message = "是否启用反哺长度不能超过2个字符")
    @ApiModelProperty(value = "是否启用反哺", name = "ynStartFeedback")
    @FieldRemark(column="YN_START_FEEDBACK", field="ynStartFeedback", name="是否启用反哺")
    private java.lang.String ynStartFeedback;

    /**
    * 反哺意见说明
    */
    @ExcelProperty("反哺意见说明")
    @Size(max = 2000, message = "反哺意见说明长度不能超过2000个字符")
    @ApiModelProperty(value = "反哺意见说明", name = "feedbackDesc")
    @FieldRemark(column="FEEDBACK_DESC", field="feedbackDesc", name="反哺意见说明")
    private java.lang.String feedbackDesc;

    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
    private java.lang.String status;

    /**
    * 流程实例ID
    */
    @ExcelProperty("流程实例ID")
    @Size(max = 64, message = "流程实例ID长度不能超过64个字符")
    @ApiModelProperty(value = "流程实例ID", name = "processInstanceId")
    @FieldRemark(column="PROCESS_INSTANCE_ID", field="processInstanceId", name="流程实例ID")
    private java.lang.String processInstanceId;

    /**
    * 流程状态
    */
    @ExcelProperty("流程状态")
    @Size(max = 10, message = "流程状态长度不能超过10个字符")
    @ApiModelProperty(value = "流程状态", name = "processStatus")
    @FieldRemark(column="PROCESS_STATUS", field="processStatus", name="流程状态")
    private java.lang.String processStatus;
    /**
    * 提交时间
    */
    @ExcelProperty("提交时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "提交时间", name = "submitTime")
    @FieldRemark(column="SUBMIT_TIME", field="submitTime", name="提交时间")
    private java.util.Date submitTime;

    /**
    * 提交时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date submitTimeBegin;

    /**
    * 提交时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date submitTimeEnd;
    /**
    * 完成时间
    */
    @ExcelProperty("完成时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "完成时间", name = "completeTime")
    @FieldRemark(column="COMPLETE_TIME", field="completeTime", name="完成时间")
    private java.util.Date completeTime;

    /**
    * 完成时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeBegin;

    /**
    * 完成时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeEnd;

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
    private java.lang.String secretLevel;
    @ExcelProperty("密级")
    private java.lang.String secretLevelName;

    /**
    * 是否已删除
    */
    @ExcelProperty("是否已删除")
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private java.lang.String ynDeleted;

    /**
    * 备注
    */
    @ExcelProperty("备注")
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private java.lang.String remark;
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
    private String dbid_; // 流程实例ID
    @ExcelProperty("流程当前步骤")
    private String activityalias_; // 节点中文名称
    private String activityname_; // 当前节点id
    @ExcelProperty("流程状态")
    private String businessstate_; // 流程当前状态
    private String currUserId; // 当前登录人ID
    private String bpmType;
    private String bpmState;
    @ExcelProperty("当前处理人")
    private String assigneenames_;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getFeedbackCode(){
        return feedbackCode;
    }

    public void setFeedbackCode(java.lang.String feedbackCode){
        this.feedbackCode = feedbackCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getSourceProblemId(){
        return sourceProblemId;
    }

    public void setSourceProblemId(java.lang.String sourceProblemId){
        this.sourceProblemId = sourceProblemId;
    }

    public java.util.Date getSourceUpdateTime(){
        return sourceUpdateTime;
    }

    public void setSourceUpdateTime(java.util.Date sourceUpdateTime){
        this.sourceUpdateTime = sourceUpdateTime;
        super.handleNullValue();
    }

    public java.util.Date getSourceUpdateTimeBegin(){
        return sourceUpdateTimeBegin;
    }

    public void setSourceUpdateTimeBegin(java.util.Date sourceUpdateTimeBegin){
        this.sourceUpdateTimeBegin = sourceUpdateTimeBegin;
    }

    public java.util.Date getSourceUpdateTimeEnd(){
        return sourceUpdateTimeEnd;
    }

    public void setSourceUpdateTimeEnd(java.util.Date sourceUpdateTimeEnd){
        this.sourceUpdateTimeEnd = sourceUpdateTimeEnd;
    }

    public java.util.Date getSyncTime(){
        return syncTime;
    }

    public void setSyncTime(java.util.Date syncTime){
        this.syncTime = syncTime;
        super.handleNullValue();
    }

    public java.util.Date getSyncTimeBegin(){
        return syncTimeBegin;
    }

    public void setSyncTimeBegin(java.util.Date syncTimeBegin){
        this.syncTimeBegin = syncTimeBegin;
    }

    public java.util.Date getSyncTimeEnd(){
        return syncTimeEnd;
    }

    public void setSyncTimeEnd(java.util.Date syncTimeEnd){
        this.syncTimeEnd = syncTimeEnd;
    }

    public java.lang.String getSourceSystemCode(){
        return sourceSystemCode;
    }

    public void setSourceSystemCode(java.lang.String sourceSystemCode){
        this.sourceSystemCode = sourceSystemCode;
    }

    public java.lang.String getProblemCode(){
        return problemCode;
    }

    public void setProblemCode(java.lang.String problemCode){
        this.problemCode = problemCode;
    }

    public java.lang.String getSourceStatus(){
        return sourceStatus;
    }

    public void setSourceStatus(java.lang.String sourceStatus){
        this.sourceStatus = sourceStatus;
    }

    public java.lang.String getProblemName(){
        return problemName;
    }

    public void setProblemName(java.lang.String problemName){
        this.problemName = problemName;
    }

    public java.lang.String getProblemType(){
        return problemType;
    }

    public void setProblemType(java.lang.String problemType){
        this.problemType = problemType;
    }

    public java.lang.String getProblemCategory(){
        return problemCategory;
    }

    public void setProblemCategory(java.lang.String problemCategory){
        this.problemCategory = problemCategory;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.util.Date getOccurrenceTime(){
        return occurrenceTime;
    }

    public void setOccurrenceTime(java.util.Date occurrenceTime){
        this.occurrenceTime = occurrenceTime;
        super.handleNullValue();
    }

    public java.util.Date getOccurrenceTimeBegin(){
        return occurrenceTimeBegin;
    }

    public void setOccurrenceTimeBegin(java.util.Date occurrenceTimeBegin){
        this.occurrenceTimeBegin = occurrenceTimeBegin;
    }

    public java.util.Date getOccurrenceTimeEnd(){
        return occurrenceTimeEnd;
    }

    public void setOccurrenceTimeEnd(java.util.Date occurrenceTimeEnd){
        this.occurrenceTimeEnd = occurrenceTimeEnd;
    }

    public java.util.Date getCloseTime(){
        return closeTime;
    }

    public void setCloseTime(java.util.Date closeTime){
        this.closeTime = closeTime;
        super.handleNullValue();
    }

    public java.util.Date getCloseTimeBegin(){
        return closeTimeBegin;
    }

    public void setCloseTimeBegin(java.util.Date closeTimeBegin){
        this.closeTimeBegin = closeTimeBegin;
    }

    public java.util.Date getCloseTimeEnd(){
        return closeTimeEnd;
    }

    public void setCloseTimeEnd(java.util.Date closeTimeEnd){
        this.closeTimeEnd = closeTimeEnd;
    }

    public java.lang.String getResponsibleStaffId(){
        return responsibleStaffId;
    }

    public void setResponsibleStaffId(java.lang.String responsibleStaffId){
        this.responsibleStaffId = responsibleStaffId;
    }

    public java.lang.String getResponsibleStaffCode(){
        return responsibleStaffCode;
    }

    public void setResponsibleStaffCode(java.lang.String responsibleStaffCode){
        this.responsibleStaffCode = responsibleStaffCode;
    }

    public java.lang.String getResponsibleStaffName(){
        return responsibleStaffName;
    }

    public void setResponsibleStaffName(java.lang.String responsibleStaffName){
        this.responsibleStaffName = responsibleStaffName;
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

    public java.lang.String getCloseReportId(){
        return closeReportId;
    }

    public void setCloseReportId(java.lang.String closeReportId){
        this.closeReportId = closeReportId;
    }

    public java.lang.String getCloseReportCode(){
        return closeReportCode;
    }

    public void setCloseReportCode(java.lang.String closeReportCode){
        this.closeReportCode = closeReportCode;
    }

    public java.lang.String getCloseReportName(){
        return closeReportName;
    }

    public void setCloseReportName(java.lang.String closeReportName){
        this.closeReportName = closeReportName;
    }

    public java.lang.String getCauseMechanism(){
        return causeMechanism;
    }

    public void setCauseMechanism(java.lang.String causeMechanism){
        this.causeMechanism = causeMechanism;
    }

    public java.lang.String getImprovementMeasure(){
        return improvementMeasure;
    }

    public void setImprovementMeasure(java.lang.String improvementMeasure){
        this.improvementMeasure = improvementMeasure;
    }

    public java.lang.String getFeedbackDimension(){
        return feedbackDimension;
    }

    public void setFeedbackDimension(java.lang.String feedbackDimension){
        this.feedbackDimension = feedbackDimension;
    }

    public java.lang.String getYnStartFeedback(){
        return ynStartFeedback;
    }

    public void setYnStartFeedback(java.lang.String ynStartFeedback){
        this.ynStartFeedback = ynStartFeedback;
    }

    public java.lang.String getFeedbackDesc(){
        return feedbackDesc;
    }

    public void setFeedbackDesc(java.lang.String feedbackDesc){
        this.feedbackDesc = feedbackDesc;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getProcessInstanceId(){
        return processInstanceId;
    }

    public void setProcessInstanceId(java.lang.String processInstanceId){
        this.processInstanceId = processInstanceId;
    }

    public java.lang.String getProcessStatus(){
        return processStatus;
    }

    public void setProcessStatus(java.lang.String processStatus){
        this.processStatus = processStatus;
    }

    public java.util.Date getSubmitTime(){
        return submitTime;
    }

    public void setSubmitTime(java.util.Date submitTime){
        this.submitTime = submitTime;
        super.handleNullValue();
    }

    public java.util.Date getSubmitTimeBegin(){
        return submitTimeBegin;
    }

    public void setSubmitTimeBegin(java.util.Date submitTimeBegin){
        this.submitTimeBegin = submitTimeBegin;
    }

    public java.util.Date getSubmitTimeEnd(){
        return submitTimeEnd;
    }

    public void setSubmitTimeEnd(java.util.Date submitTimeEnd){
        this.submitTimeEnd = submitTimeEnd;
    }

    public java.util.Date getCompleteTime(){
        return completeTime;
    }

    public void setCompleteTime(java.util.Date completeTime){
        this.completeTime = completeTime;
        super.handleNullValue();
    }

    public java.util.Date getCompleteTimeBegin(){
        return completeTimeBegin;
    }

    public void setCompleteTimeBegin(java.util.Date completeTimeBegin){
        this.completeTimeBegin = completeTimeBegin;
    }

    public java.util.Date getCompleteTimeEnd(){
        return completeTimeEnd;
    }

    public void setCompleteTimeEnd(java.util.Date completeTimeEnd){
        this.completeTimeEnd = completeTimeEnd;
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

    public String getDbid_() {
        return dbid_;
    }

    public void setDbid_(String dbid_) {
        this.dbid_ = dbid_;
    }

    public String getActivityalias_() {
        return activityalias_;
    }

    public void setActivityalias_(String activityalias_) {
        this.activityalias_ = activityalias_;
    }

    public String getActivityname_() {
        return activityname_;
    }

    public void setActivityname_(String activityname_) {
        this.activityname_ = activityname_;
    }

    public String getBusinessstate_() {
        return businessstate_;
    }

    public void setBusinessstate_(String businessstate_) {
        this.businessstate_ = businessstate_;
    }

    public String getCurrUserId() {
        return currUserId;
    }

    public void setCurrUserId(String currUserId) {
        this.currUserId = currUserId;
    }

    public String getBpmType() {
        return bpmType;
    }

    public void setBpmType(String bpmType) {
        this.bpmType = bpmType;
    }

    public String getBpmState() {
        return bpmState;
    }

    public void setBpmState(String bpmState) {
        this.bpmState = bpmState;
    }
    public String getAssigneenames_() {
        return assigneenames_;
    }

    public void setAssigneenames_(String assigneenames_) {
        this.assigneenames_ = assigneenames_;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "归零反哺表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "归零反哺表";
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
