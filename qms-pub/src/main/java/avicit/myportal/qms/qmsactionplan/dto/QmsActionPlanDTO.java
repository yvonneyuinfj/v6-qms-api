package avicit.myportal.qms.qmsactionplan.dto;

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
* @创建时间： 2026-08-04 15:12
* @类说明：通用实施计划表DTO
* @修改记录：
*/
@ApiModel(value = "QmsActionPlanDTO", description = "通用实施计划表")
@PojoRemark(table="QMS_ACTION_PLAN", object="QmsActionPlanDTO", name="通用实施计划表")
@ExcelIgnoreUnannotated
public class QmsActionPlanDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 计划ID
    */
    @Id
    @Size(max = 64, message = "计划ID长度不能超过64个字符")
    @ApiModelProperty(value = "计划ID", name = "id")
    @FieldRemark(column="ID", field="id", name="计划ID")
    private java.lang.String id;

    /**
    * 行动项ID
    */
    @ExcelProperty("行动项ID")
    @Size(max = 64, message = "行动项ID长度不能超过64个字符")
    @ApiModelProperty(value = "行动项ID", name = "actionId")
    @FieldRemark(column="ACTION_ID", field="actionId", name="行动项ID")
    private java.lang.String actionId;

    /**
    * 行动项标题
    */
    @ExcelProperty("行动项标题")
    @Size(max = 256, message = "行动项标题长度不能超过256个字符")
    @ApiModelProperty(value = "行动项标题", name = "actionName")
    @FieldRemark(column="ACTION_NAME", field="actionName", name="行动项标题")
    private java.lang.String actionName;

    /**
    * 来源类型
    */
    @ExcelProperty("来源类型")
    @Size(max = 128, message = "来源类型长度不能超过128个字符")
    @ApiModelProperty(value = "来源类型", name = "sourceType")
    @FieldRemark(column="SOURCE_TYPE", field="sourceType", name="来源类型")
    private java.lang.String sourceType;

    /**
    * 来源ID
    */
    @ExcelProperty("来源ID")
    @Size(max = 64, message = "来源ID长度不能超过64个字符")
    @ApiModelProperty(value = "来源ID", name = "sourceId")
    @FieldRemark(column="SOURCE_ID", field="sourceId", name="来源ID")
    private java.lang.String sourceId;

    /**
    * 计划编号
    */
    @ExcelProperty("计划编号")
    @Size(max = 50, message = "计划编号长度不能超过50个字符")
    @ApiModelProperty(value = "计划编号", name = "planCode")
    @FieldRemark(column="PLAN_CODE", field="planCode", name="计划编号")
    private java.lang.String planCode;

    /**
    * 计划名称
    */
    @ExcelProperty("计划名称")
    @Size(max = 256, message = "计划名称长度不能超过256个字符")
    @ApiModelProperty(value = "计划名称", name = "planName")
    @FieldRemark(column="PLAN_NAME", field="planName", name="计划名称")
    private java.lang.String planName;

    /**
    * 计划内容
    */
    @ExcelProperty("计划内容")
    @Size(max = 512, message = "计划内容长度不能超过512个字符")
    @ApiModelProperty(value = "计划内容", name = "planContent")
    @FieldRemark(column="PLAN_CONTENT", field="planContent", name="计划内容")
    private java.lang.String planContent;

    /**
    * 计划类型
    */
    @ExcelProperty("计划类型")
    @Size(max = 128, message = "计划类型长度不能超过128个字符")
    @ApiModelProperty(value = "计划类型", name = "planType")
    @FieldRemark(column="PLAN_TYPE", field="planType", name="计划类型")
    private java.lang.String planType;

    /**
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 2000, message = "责任部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任部门ID")
    private java.lang.String responsibleDeptId;

    /**
    * 责任部门CODE
    */
    @ExcelProperty("责任部门CODE")
    @Size(max = 512, message = "责任部门CODE长度不能超过512个字符")
    @ApiModelProperty(value = "责任部门CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任部门CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 2000, message = "责任部门长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任部门")
    private java.lang.String responsibleDeptName;

    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 2000, message = "责任人ID长度不能超过2000个字符")
    @ApiModelProperty(value = "责任人ID", name = "responsibleUserId")
    @FieldRemark(column="RESPONSIBLE_USER_ID", field="responsibleUserId", name="责任人ID")
    private java.lang.String responsibleUserId;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 512, message = "责任人CODE长度不能超过512个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleUserCode")
    @FieldRemark(column="RESPONSIBLE_USER_CODE", field="responsibleUserCode", name="责任人CODE")
    private java.lang.String responsibleUserCode;

    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 1000, message = "责任人长度不能超过1000个字符")
    @ApiModelProperty(value = "责任人", name = "responsibleUserName")
    @FieldRemark(column="RESPONSIBLE_USER_NAME", field="responsibleUserName", name="责任人")
    private java.lang.String responsibleUserName;

    /**
    * 协同部门ID
    */
    @ExcelProperty("协同部门ID")
    @Size(max = 2000, message = "协同部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "协同部门ID", name = "assistDeptId")
    @FieldRemark(column="ASSIST_DEPT_ID", field="assistDeptId", name="协同部门ID")
    private java.lang.String assistDeptId;

    /**
    * 协同部门CODE
    */
    @ExcelProperty("协同部门CODE")
    @Size(max = 512, message = "协同部门CODE长度不能超过512个字符")
    @ApiModelProperty(value = "协同部门CODE", name = "assistDeptCode")
    @FieldRemark(column="ASSIST_DEPT_CODE", field="assistDeptCode", name="协同部门CODE")
    private java.lang.String assistDeptCode;

    /**
    * 协同部门
    */
    @ExcelProperty("协同部门")
    @Size(max = 2000, message = "协同部门长度不能超过2000个字符")
    @ApiModelProperty(value = "协同部门", name = "assistDeptName")
    @FieldRemark(column="ASSIST_DEPT_NAME", field="assistDeptName", name="协同部门")
    private java.lang.String assistDeptName;
    /**
    * 开始时间
    */
    @ExcelProperty("开始时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "开始时间", name = "startTime")
    @FieldRemark(column="START_TIME", field="startTime", name="开始时间")
    private java.util.Date startTime;

    /**
    * 开始时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeBegin;

    /**
    * 开始时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeEnd;
    /**
    * 结束时间
    */
    @ExcelProperty("结束时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "结束时间", name = "endTime")
    @FieldRemark(column="END_TIME", field="endTime", name="结束时间")
    private java.util.Date endTime;

    /**
    * 结束时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date endTimeBegin;

    /**
    * 结束时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date endTimeEnd;
    /**
    * 实际完成时间
    */
    @ExcelProperty("实际完成时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "实际完成时间", name = "actualFinishTime")
    @FieldRemark(column="ACTUAL_FINISH_TIME", field="actualFinishTime", name="实际完成时间")
    private java.util.Date actualFinishTime;

    /**
    * 实际完成时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date actualFinishTimeBegin;

    /**
    * 实际完成时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date actualFinishTimeEnd;

    /**
    * 反馈周期
    */
    @ExcelProperty("反馈周期")
    @Size(max = 20, message = "反馈周期长度不能超过20个字符")
    @ApiModelProperty(value = "反馈周期", name = "feedbackCycle")
    @FieldRemark(column="FEEDBACK_CYCLE", field="feedbackCycle", name="反馈周期")
    private java.lang.String feedbackCycle;

    /**
    * 计划状态
    */
    @ExcelProperty("计划状态")
    @Size(max = 20, message = "计划状态长度不能超过20个字符")
    @ApiModelProperty(value = "计划状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="计划状态")
    private java.lang.String status;

    /**
    * 反馈状态
    */
    @ExcelProperty("反馈状态")
    @Size(max = 20, message = "反馈状态长度不能超过20个字符")
    @ApiModelProperty(value = "反馈状态", name = "feedbackStatus")
    @FieldRemark(column="FEEDBACK_STATUS", field="feedbackStatus", name="反馈状态")
    private java.lang.String feedbackStatus;
    /**
    * 当前进度
    */
    @ExcelProperty("当前进度")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 2, fraction = 0, message = "当前进度格式不正确")
    @ApiModelProperty(value = "当前进度", name = "progress")
    @FieldRemark(column="PROGRESS", field="progress", name="当前进度")
    private java.math.BigDecimal progress;

    /**
    * 是否逾期
    */
    @ExcelProperty("是否逾期")
    @Size(max = 2, message = "是否逾期长度不能超过2个字符")
    @ApiModelProperty(value = "是否逾期", name = "ynOverdue")
    @FieldRemark(column="YN_OVERDUE", field="ynOverdue", name="是否逾期")
    private java.lang.String ynOverdue;

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

    /**
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private java.lang.String parentId;

    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    @ApiModelProperty(value = "全路径", name = "treePath")
    @FieldRemark(column="TREE_PATH", field="treePath", name="全路径")
    private java.lang.String treePath;
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
    private java.lang.String treeSorts;

    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    @ApiModelProperty(value = "是否叶子节点", name = "treeLeaf")
    @FieldRemark(column="TREE_LEAF", field="treeLeaf", name="是否叶子节点")
    private java.lang.String treeLeaf;

    /**
    * 计划要求
    */
    @ExcelProperty("计划要求")
    @Size(max = 128, message = "计划要求长度不能超过128个字符")
    @ApiModelProperty(value = "计划要求", name = "expectedDeliverable")
    @FieldRemark(column="EXPECTED_DELIVERABLE", field="expectedDeliverable", name="计划要求")
    private java.lang.String expectedDeliverable;

    /**
    * PLAN_REQUIREMENT
    */
    @ExcelProperty("PLAN_REQUIREMENT")
    @Size(max = 512, message = "PLAN_REQUIREMENT长度不能超过512个字符")
    @ApiModelProperty(value = "PLAN_REQUIREMENT", name = "planRequirement")
    @FieldRemark(column="PLAN_REQUIREMENT", field="planRequirement", name="PLAN_REQUIREMENT")
    private java.lang.String planRequirement;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getActionId(){
        return actionId;
    }

    public void setActionId(java.lang.String actionId){
        this.actionId = actionId;
    }

    public java.lang.String getActionName(){
        return actionName;
    }

    public void setActionName(java.lang.String actionName){
        this.actionName = actionName;
    }

    public java.lang.String getSourceType(){
        return sourceType;
    }

    public void setSourceType(java.lang.String sourceType){
        this.sourceType = sourceType;
    }

    public java.lang.String getSourceId(){
        return sourceId;
    }

    public void setSourceId(java.lang.String sourceId){
        this.sourceId = sourceId;
    }

    public java.lang.String getPlanCode(){
        return planCode;
    }

    public void setPlanCode(java.lang.String planCode){
        this.planCode = planCode;
    }

    public java.lang.String getPlanName(){
        return planName;
    }

    public void setPlanName(java.lang.String planName){
        this.planName = planName;
    }

    public java.lang.String getPlanContent(){
        return planContent;
    }

    public void setPlanContent(java.lang.String planContent){
        this.planContent = planContent;
    }

    public java.lang.String getPlanType(){
        return planType;
    }

    public void setPlanType(java.lang.String planType){
        this.planType = planType;
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

    public java.lang.String getResponsibleUserId(){
        return responsibleUserId;
    }

    public void setResponsibleUserId(java.lang.String responsibleUserId){
        this.responsibleUserId = responsibleUserId;
    }

    public java.lang.String getResponsibleUserCode(){
        return responsibleUserCode;
    }

    public void setResponsibleUserCode(java.lang.String responsibleUserCode){
        this.responsibleUserCode = responsibleUserCode;
    }

    public java.lang.String getResponsibleUserName(){
        return responsibleUserName;
    }

    public void setResponsibleUserName(java.lang.String responsibleUserName){
        this.responsibleUserName = responsibleUserName;
    }

    public java.lang.String getAssistDeptId(){
        return assistDeptId;
    }

    public void setAssistDeptId(java.lang.String assistDeptId){
        this.assistDeptId = assistDeptId;
    }

    public java.lang.String getAssistDeptCode(){
        return assistDeptCode;
    }

    public void setAssistDeptCode(java.lang.String assistDeptCode){
        this.assistDeptCode = assistDeptCode;
    }

    public java.lang.String getAssistDeptName(){
        return assistDeptName;
    }

    public void setAssistDeptName(java.lang.String assistDeptName){
        this.assistDeptName = assistDeptName;
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

    public java.util.Date getEndTime(){
        return endTime;
    }

    public void setEndTime(java.util.Date endTime){
        this.endTime = endTime;
        super.handleNullValue();
    }

    public java.util.Date getEndTimeBegin(){
        return endTimeBegin;
    }

    public void setEndTimeBegin(java.util.Date endTimeBegin){
        this.endTimeBegin = endTimeBegin;
    }

    public java.util.Date getEndTimeEnd(){
        return endTimeEnd;
    }

    public void setEndTimeEnd(java.util.Date endTimeEnd){
        this.endTimeEnd = endTimeEnd;
    }

    public java.util.Date getActualFinishTime(){
        return actualFinishTime;
    }

    public void setActualFinishTime(java.util.Date actualFinishTime){
        this.actualFinishTime = actualFinishTime;
        super.handleNullValue();
    }

    public java.util.Date getActualFinishTimeBegin(){
        return actualFinishTimeBegin;
    }

    public void setActualFinishTimeBegin(java.util.Date actualFinishTimeBegin){
        this.actualFinishTimeBegin = actualFinishTimeBegin;
    }

    public java.util.Date getActualFinishTimeEnd(){
        return actualFinishTimeEnd;
    }

    public void setActualFinishTimeEnd(java.util.Date actualFinishTimeEnd){
        this.actualFinishTimeEnd = actualFinishTimeEnd;
    }

    public java.lang.String getFeedbackCycle(){
        return feedbackCycle;
    }

    public void setFeedbackCycle(java.lang.String feedbackCycle){
        this.feedbackCycle = feedbackCycle;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getFeedbackStatus(){
        return feedbackStatus;
    }

    public void setFeedbackStatus(java.lang.String feedbackStatus){
        this.feedbackStatus = feedbackStatus;
    }

    public java.math.BigDecimal getProgress(){
        return progress;
    }

    public void setProgress(java.math.BigDecimal progress){
        this.progress = progress;
        super.handleNullValue();
    }

    public java.lang.String getYnOverdue(){
        return ynOverdue;
    }

    public void setYnOverdue(java.lang.String ynOverdue){
        this.ynOverdue = ynOverdue;
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

    public java.lang.String getTreePath(){
        return treePath;
    }

    public void setTreePath(java.lang.String treePath){
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

    public java.lang.String getTreeSorts(){
        return treeSorts;
    }

    public void setTreeSorts(java.lang.String treeSorts){
        this.treeSorts = treeSorts;
    }

    public java.lang.String getTreeLeaf(){
        return treeLeaf;
    }

    public void setTreeLeaf(java.lang.String treeLeaf){
        this.treeLeaf = treeLeaf;
    }

    public java.lang.String getExpectedDeliverable(){
        return expectedDeliverable;
    }

    public void setExpectedDeliverable(java.lang.String expectedDeliverable){
        this.expectedDeliverable = expectedDeliverable;
    }

    public java.lang.String getPlanRequirement(){
        return planRequirement;
    }

    public void setPlanRequirement(java.lang.String planRequirement){
        this.planRequirement = planRequirement;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "通用实施计划表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "通用实施计划表";
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
