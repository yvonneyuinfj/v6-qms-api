package avicit.myportal.qms.qmsqualitycultureplan.dto;

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
* @创建时间： 2026-08-06 15:53
* @类说明：文化活动计划表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityCulturePlanDTO", description = "文化活动计划表")
@PojoRemark(table="QMS_QUALITY_CULTURE_PLAN", object="QmsQualityCulturePlanDTO", name="文化活动计划表")
@ExcelIgnoreUnannotated
public class QmsQualityCulturePlanDTO extends BeanDTO{
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
    * 文化ID
    */
    @Size(max = 64, message = "文化ID长度不能超过64个字符")
    @ApiModelProperty(value = "文化ID", name = "cultureId")
    @FieldRemark(column="CULTURE_ID", field="cultureId", name="文化ID")
    private java.lang.String cultureId;

    /**
    * 计划编号
    */
    @ExcelProperty("计划编号")
    @Size(max = 50, message = "计划编号长度不能超过50个字符")
    @ApiModelProperty(value = "计划编号", name = "planCode")
    @FieldRemark(column="PLAN_CODE", field="planCode", name="计划编号")
    private java.lang.String planCode;

    /**
    * 主要工作事项
    */
    @ExcelProperty("主要工作事项")
    @Size(max = 512, message = "主要工作事项长度不能超过512个字符")
    @ApiModelProperty(value = "主要工作事项", name = "workItem")
    @FieldRemark(column="WORK_ITEM", field="workItem", name="主要工作事项")
    private java.lang.String workItem;

    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    @ApiModelProperty(value = "交付物", name = "deliverable")
    @FieldRemark(column="DELIVERABLE", field="deliverable", name="交付物")
    private java.lang.String deliverable;

    /**
    * 组织部门ID
    */
    @ExcelProperty("组织部门ID")
    @Size(max = 64, message = "组织部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "组织部门ID", name = "organizingDeptId")
    @FieldRemark(column="ORGANIZING_DEPT_ID", field="organizingDeptId", name="组织部门ID")
    private java.lang.String organizingDeptId;

    /**
    * 组织部门CODE
    */
    @ExcelProperty("组织部门CODE")
    @Size(max = 10, message = "组织部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "组织部门CODE", name = "organizingDeptCode")
    @FieldRemark(column="ORGANIZING_DEPT_CODE", field="organizingDeptCode", name="组织部门CODE")
    private java.lang.String organizingDeptCode;

    /**
    * 组织部门
    */
    @ExcelProperty("组织部门")
    @Size(max = 64, message = "组织部门长度不能超过64个字符")
    @ApiModelProperty(value = "组织部门", name = "organizingDeptName")
    @FieldRemark(column="ORGANIZING_DEPT_NAME", field="organizingDeptName", name="组织部门")
    private java.lang.String organizingDeptName;

    /**
    * 组织人ID
    */
    @ExcelProperty("组织人ID")
    @Size(max = 64, message = "组织人ID长度不能超过64个字符")
    @ApiModelProperty(value = "组织人ID", name = "organizerStaffId")
    @FieldRemark(column="ORGANIZER_STAFF_ID", field="organizerStaffId", name="组织人ID")
    private java.lang.String organizerStaffId;

    /**
    * 组织人CODE
    */
    @ExcelProperty("组织人CODE")
    @Size(max = 10, message = "组织人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "组织人CODE", name = "organizerStaffCode")
    @FieldRemark(column="ORGANIZER_STAFF_CODE", field="organizerStaffCode", name="组织人CODE")
    private java.lang.String organizerStaffCode;

    /**
    * 组织人
    */
    @ExcelProperty("组织人")
    @Size(max = 20, message = "组织人长度不能超过20个字符")
    @ApiModelProperty(value = "组织人", name = "organizerStaffName")
    @FieldRemark(column="ORGANIZER_STAFF_NAME", field="organizerStaffName", name="组织人")
    private java.lang.String organizerStaffName;

    /**
    * 实施部门ID
    */
    @ExcelProperty("实施部门ID")
    @Size(max = 2000, message = "实施部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "实施部门ID", name = "implementDeptId")
    @FieldRemark(column="IMPLEMENT_DEPT_ID", field="implementDeptId", name="实施部门ID")
    private java.lang.String implementDeptId;

    /**
    * 实施部门CODE
    */
    @ExcelProperty("实施部门CODE")
    @Size(max = 1000, message = "实施部门CODE长度不能超过1000个字符")
    @ApiModelProperty(value = "实施部门CODE", name = "implementDeptCode")
    @FieldRemark(column="IMPLEMENT_DEPT_CODE", field="implementDeptCode", name="实施部门CODE")
    private java.lang.String implementDeptCode;

    /**
    * 实施部门
    */
    @ExcelProperty("实施部门")
    @Size(max = 2000, message = "实施部门长度不能超过2000个字符")
    @ApiModelProperty(value = "实施部门", name = "implementDeptName")
    @FieldRemark(column="IMPLEMENT_DEPT_NAME", field="implementDeptName", name="实施部门")
    private java.lang.String implementDeptName;
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
    @ApiModelProperty(value = "结束时间", name = "deadline")
    @FieldRemark(column="DEADLINE", field="deadline", name="结束时间")
    private java.util.Date deadline;

    /**
    * 结束时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineBegin;

    /**
    * 结束时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineEnd;
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

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getCultureId(){
        return cultureId;
    }

    public void setCultureId(java.lang.String cultureId){
        this.cultureId = cultureId;
    }

    public java.lang.String getPlanCode(){
        return planCode;
    }

    public void setPlanCode(java.lang.String planCode){
        this.planCode = planCode;
    }

    public java.lang.String getWorkItem(){
        return workItem;
    }

    public void setWorkItem(java.lang.String workItem){
        this.workItem = workItem;
    }

    public java.lang.String getDeliverable(){
        return deliverable;
    }

    public void setDeliverable(java.lang.String deliverable){
        this.deliverable = deliverable;
    }

    public java.lang.String getOrganizingDeptId(){
        return organizingDeptId;
    }

    public void setOrganizingDeptId(java.lang.String organizingDeptId){
        this.organizingDeptId = organizingDeptId;
    }

    public java.lang.String getOrganizingDeptCode(){
        return organizingDeptCode;
    }

    public void setOrganizingDeptCode(java.lang.String organizingDeptCode){
        this.organizingDeptCode = organizingDeptCode;
    }

    public java.lang.String getOrganizingDeptName(){
        return organizingDeptName;
    }

    public void setOrganizingDeptName(java.lang.String organizingDeptName){
        this.organizingDeptName = organizingDeptName;
    }

    public java.lang.String getOrganizerStaffId(){
        return organizerStaffId;
    }

    public void setOrganizerStaffId(java.lang.String organizerStaffId){
        this.organizerStaffId = organizerStaffId;
    }

    public java.lang.String getOrganizerStaffCode(){
        return organizerStaffCode;
    }

    public void setOrganizerStaffCode(java.lang.String organizerStaffCode){
        this.organizerStaffCode = organizerStaffCode;
    }

    public java.lang.String getOrganizerStaffName(){
        return organizerStaffName;
    }

    public void setOrganizerStaffName(java.lang.String organizerStaffName){
        this.organizerStaffName = organizerStaffName;
    }

    public java.lang.String getImplementDeptId(){
        return implementDeptId;
    }

    public void setImplementDeptId(java.lang.String implementDeptId){
        this.implementDeptId = implementDeptId;
    }

    public java.lang.String getImplementDeptCode(){
        return implementDeptCode;
    }

    public void setImplementDeptCode(java.lang.String implementDeptCode){
        this.implementDeptCode = implementDeptCode;
    }

    public java.lang.String getImplementDeptName(){
        return implementDeptName;
    }

    public void setImplementDeptName(java.lang.String implementDeptName){
        this.implementDeptName = implementDeptName;
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

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "文化活动计划表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "文化活动计划表";
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
