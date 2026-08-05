package avicit.myportal.qms.qmstop10problem.dto;

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
* @创建时间： 2026-08-05 18:11
* @类说明：TOP10问题台账DTO
* @修改记录：
*/
@ApiModel(value = "QmsTop10ProblemDTO", description = "TOP10问题台账")
@PojoRemark(table="QMS_TOP10_PROBLEM", object="QmsTop10ProblemDTO", name="TOP10问题台账")
@ExcelIgnoreUnannotated
public class QmsTop10ProblemDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * ID
    */
    @Id
    @Size(max = 64, message = "ID长度不能超过64个字符")
    @ApiModelProperty(value = "ID", name = "id")
    @FieldRemark(column="ID", field="id", name="ID")
    private java.lang.String id;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 编号;2025-TOP-001
    */
    @ExcelProperty("编号;2025-TOP-001")
    @Size(max = 50, message = "编号;2025-TOP-001长度不能超过50个字符")
    @ApiModelProperty(value = "编号;2025-TOP-001", name = "topCode")
    @FieldRemark(column="TOP_CODE", field="topCode", name="编号;2025-TOP-001")
    private java.lang.String topCode;

    /**
    * 问题名称
    */
    @ExcelProperty("问题名称")
    @Size(max = 256, message = "问题名称长度不能超过256个字符")
    @ApiModelProperty(value = "问题名称", name = "problemName")
    @FieldRemark(column="PROBLEM_NAME", field="problemName", name="问题名称")
    private java.lang.String problemName;

    /**
    * 主管副总师ID
    */
    @ExcelProperty("主管副总师ID")
    @Size(max = 64, message = "主管副总师ID长度不能超过64个字符")
    @ApiModelProperty(value = "主管副总师ID", name = "deputyChiefUserId")
    @FieldRemark(column="DEPUTY_CHIEF_USER_ID", field="deputyChiefUserId", name="主管副总师ID")
    private java.lang.String deputyChiefUserId;

    /**
    * 主管副总师CODE
    */
    @ExcelProperty("主管副总师CODE")
    @Size(max = 10, message = "主管副总师CODE长度不能超过10个字符")
    @ApiModelProperty(value = "主管副总师CODE", name = "deputyChiefUserCode")
    @FieldRemark(column="DEPUTY_CHIEF_USER_CODE", field="deputyChiefUserCode", name="主管副总师CODE")
    private java.lang.String deputyChiefUserCode;

    /**
    * 主管副总师
    */
    @ExcelProperty("主管副总师")
    @Size(max = 128, message = "主管副总师长度不能超过128个字符")
    @ApiModelProperty(value = "主管副总师", name = "deputyChiefUserName")
    @FieldRemark(column="DEPUTY_CHIEF_USER_NAME", field="deputyChiefUserName", name="主管副总师")
    private java.lang.String deputyChiefUserName;

    /**
    * 主管部门ID
    */
    @ExcelProperty("主管部门ID")
    @Size(max = 64, message = "主管部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "主管部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="主管部门ID")
    private java.lang.String responsibleDeptId;

    /**
    * 主管部门CODE
    */
    @ExcelProperty("主管部门CODE")
    @Size(max = 10, message = "主管部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "主管部门CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="主管部门CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 主管部门
    */
    @ExcelProperty("主管部门")
    @Size(max = 128, message = "主管部门长度不能超过128个字符")
    @ApiModelProperty(value = "主管部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="主管部门")
    private java.lang.String responsibleDeptName;

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
    * 归零节点
    */
    @ExcelProperty("归零节点")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "归零节点", name = "planCloseTime")
    @FieldRemark(column="PLAN_CLOSE_TIME", field="planCloseTime", name="归零节点")
    private java.util.Date planCloseTime;

    /**
    * 归零节点起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date planCloseTimeBegin;

    /**
    * 归零节点止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date planCloseTimeEnd;

    /**
    * 用户;空军/海军/其他
    */
    @ExcelProperty("用户;空军/海军/其他")
    @Size(max = 10, message = "用户;空军/海军/其他长度不能超过10个字符")
    @ApiModelProperty(value = "用户;空军/海军/其他", name = "userType")
    @FieldRemark(column="USER_TYPE", field="userType", name="用户;空军/海军/其他")
    private java.lang.String userType;

    /**
    * 阶段;科研/批产
    */
    @ExcelProperty("阶段;科研/批产")
    @Size(max = 10, message = "阶段;科研/批产长度不能超过10个字符")
    @ApiModelProperty(value = "阶段;科研/批产", name = "problemStage")
    @FieldRemark(column="PROBLEM_STAGE", field="problemStage", name="阶段;科研/批产")
    private java.lang.String problemStage;

    /**
    * 级别;集团/所级
    */
    @ExcelProperty("级别;集团/所级")
    @Size(max = 10, message = "级别;集团/所级长度不能超过10个字符")
    @ApiModelProperty(value = "级别;集团/所级", name = "problemLevel")
    @FieldRemark(column="PROBLEM_LEVEL", field="problemLevel", name="级别;集团/所级")
    private java.lang.String problemLevel;

    /**
    * 计划完成情况;以分数或进度条形式展现
    */
    @ExcelProperty("计划完成情况;以分数或进度条形式展现")
    @Size(max = 10, message = "计划完成情况;以分数或进度条形式展现长度不能超过10个字符")
    @ApiModelProperty(value = "计划完成情况;以分数或进度条形式展现", name = "planCompletionRate")
    @FieldRemark(column="PLAN_COMPLETION_RATE", field="planCompletionRate", name="计划完成情况;以分数或进度条形式展现")
    private java.lang.String planCompletionRate;

    /**
    * 周反馈情况;分数或进度条形式展现
    */
    @ExcelProperty("周反馈情况;分数或进度条形式展现")
    @Size(max = 10, message = "周反馈情况;分数或进度条形式展现长度不能超过10个字符")
    @ApiModelProperty(value = "周反馈情况;分数或进度条形式展现", name = "weeklyFeedbackRate")
    @FieldRemark(column="WEEKLY_FEEDBACK_RATE", field="weeklyFeedbackRate", name="周反馈情况;分数或进度条形式展现")
    private java.lang.String weeklyFeedbackRate;

    /**
    * 销号状态;攻关中/已销号
    */
    @ExcelProperty("销号状态;攻关中/已销号")
    @Size(max = 10, message = "销号状态;攻关中/已销号长度不能超过10个字符")
    @ApiModelProperty(value = "销号状态;攻关中/已销号", name = "status")
    @FieldRemark(column="STATUS", field="status", name="销号状态;攻关中/已销号")
    private java.lang.String status;
    /**
    * 销号时间
    */
    @ExcelProperty("销号时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "销号时间", name = "closeTime")
    @FieldRemark(column="CLOSE_TIME", field="closeTime", name="销号时间")
    private java.util.Date closeTime;

    /**
    * 销号时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date closeTimeBegin;

    /**
    * 销号时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date closeTimeEnd;

    /**
    * 质量问题编号;非必填，质量问题系统内的编号
    */
    @ExcelProperty("质量问题编号;非必填，质量问题系统内的编号")
    @Size(max = 50, message = "质量问题编号;非必填，质量问题系统内的编号长度不能超过50个字符")
    @ApiModelProperty(value = "质量问题编号;非必填，质量问题系统内的编号", name = "qualityProblemCode")
    @FieldRemark(column="QUALITY_PROBLEM_CODE", field="qualityProblemCode", name="质量问题编号;非必填，质量问题系统内的编号")
    private java.lang.String qualityProblemCode;

    /**
    * 问题描述
    */
    @ExcelProperty("问题描述")
    @Size(max = 2000, message = "问题描述长度不能超过2000个字符")
    @ApiModelProperty(value = "问题描述", name = "problemDesc")
    @FieldRemark(column="PROBLEM_DESC", field="problemDesc", name="问题描述")
    private java.lang.String problemDesc;

    /**
    * 当前工作进展
    */
    @ExcelProperty("当前工作进展")
    @Size(max = 2000, message = "当前工作进展长度不能超过2000个字符")
    @ApiModelProperty(value = "当前工作进展", name = "currentProgress")
    @FieldRemark(column="CURRENT_PROGRESS", field="currentProgress", name="当前工作进展")
    private java.lang.String currentProgress;
    /**
    * 周反馈开始时间
    */
    @ExcelProperty("周反馈开始时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "周反馈开始时间", name = "weeklyFeedbackStartTime")
    @FieldRemark(column="WEEKLY_FEEDBACK_START_TIME", field="weeklyFeedbackStartTime", name="周反馈开始时间")
    private java.util.Date weeklyFeedbackStartTime;

    /**
    * 周反馈开始时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date weeklyFeedbackStartTimeBegin;

    /**
    * 周反馈开始时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date weeklyFeedbackStartTimeEnd;

    /**
    * 质量主管ID
    */
    @ExcelProperty("质量主管ID")
    @Size(max = 64, message = "质量主管ID长度不能超过64个字符")
    @ApiModelProperty(value = "质量主管ID", name = "qualitySupervisorId")
    @FieldRemark(column="QUALITY_SUPERVISOR_ID", field="qualitySupervisorId", name="质量主管ID")
    private java.lang.String qualitySupervisorId;

    /**
    * 质量主管CODE
    */
    @ExcelProperty("质量主管CODE")
    @Size(max = 10, message = "质量主管CODE长度不能超过10个字符")
    @ApiModelProperty(value = "质量主管CODE", name = "qualitySupervisorCode")
    @FieldRemark(column="QUALITY_SUPERVISOR_CODE", field="qualitySupervisorCode", name="质量主管CODE")
    private java.lang.String qualitySupervisorCode;

    /**
    * 质量主管
    */
    @ExcelProperty("质量主管")
    @Size(max = 50, message = "质量主管长度不能超过50个字符")
    @ApiModelProperty(value = "质量主管", name = "qualitySupervisorName")
    @FieldRemark(column="QUALITY_SUPERVISOR_NAME", field="qualitySupervisorName", name="质量主管")
    private java.lang.String qualitySupervisorName;

    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 128, message = "型号长度不能超过128个字符")
    @ApiModelProperty(value = "型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号")
    private java.lang.String model;

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

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getTopCode(){
        return topCode;
    }

    public void setTopCode(java.lang.String topCode){
        this.topCode = topCode;
    }

    public java.lang.String getProblemName(){
        return problemName;
    }

    public void setProblemName(java.lang.String problemName){
        this.problemName = problemName;
    }

    public java.lang.String getDeputyChiefUserId(){
        return deputyChiefUserId;
    }

    public void setDeputyChiefUserId(java.lang.String deputyChiefUserId){
        this.deputyChiefUserId = deputyChiefUserId;
    }

    public java.lang.String getDeputyChiefUserCode(){
        return deputyChiefUserCode;
    }

    public void setDeputyChiefUserCode(java.lang.String deputyChiefUserCode){
        this.deputyChiefUserCode = deputyChiefUserCode;
    }

    public java.lang.String getDeputyChiefUserName(){
        return deputyChiefUserName;
    }

    public void setDeputyChiefUserName(java.lang.String deputyChiefUserName){
        this.deputyChiefUserName = deputyChiefUserName;
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

    public java.util.Date getPlanCloseTime(){
        return planCloseTime;
    }

    public void setPlanCloseTime(java.util.Date planCloseTime){
        this.planCloseTime = planCloseTime;
        super.handleNullValue();
    }

    public java.util.Date getPlanCloseTimeBegin(){
        return planCloseTimeBegin;
    }

    public void setPlanCloseTimeBegin(java.util.Date planCloseTimeBegin){
        this.planCloseTimeBegin = planCloseTimeBegin;
    }

    public java.util.Date getPlanCloseTimeEnd(){
        return planCloseTimeEnd;
    }

    public void setPlanCloseTimeEnd(java.util.Date planCloseTimeEnd){
        this.planCloseTimeEnd = planCloseTimeEnd;
    }

    public java.lang.String getUserType(){
        return userType;
    }

    public void setUserType(java.lang.String userType){
        this.userType = userType;
    }

    public java.lang.String getProblemStage(){
        return problemStage;
    }

    public void setProblemStage(java.lang.String problemStage){
        this.problemStage = problemStage;
    }

    public java.lang.String getProblemLevel(){
        return problemLevel;
    }

    public void setProblemLevel(java.lang.String problemLevel){
        this.problemLevel = problemLevel;
    }

    public java.lang.String getPlanCompletionRate(){
        return planCompletionRate;
    }

    public void setPlanCompletionRate(java.lang.String planCompletionRate){
        this.planCompletionRate = planCompletionRate;
    }

    public java.lang.String getWeeklyFeedbackRate(){
        return weeklyFeedbackRate;
    }

    public void setWeeklyFeedbackRate(java.lang.String weeklyFeedbackRate){
        this.weeklyFeedbackRate = weeklyFeedbackRate;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
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

    public java.lang.String getQualityProblemCode(){
        return qualityProblemCode;
    }

    public void setQualityProblemCode(java.lang.String qualityProblemCode){
        this.qualityProblemCode = qualityProblemCode;
    }

    public java.lang.String getProblemDesc(){
        return problemDesc;
    }

    public void setProblemDesc(java.lang.String problemDesc){
        this.problemDesc = problemDesc;
    }

    public java.lang.String getCurrentProgress(){
        return currentProgress;
    }

    public void setCurrentProgress(java.lang.String currentProgress){
        this.currentProgress = currentProgress;
    }

    public java.util.Date getWeeklyFeedbackStartTime(){
        return weeklyFeedbackStartTime;
    }

    public void setWeeklyFeedbackStartTime(java.util.Date weeklyFeedbackStartTime){
        this.weeklyFeedbackStartTime = weeklyFeedbackStartTime;
        super.handleNullValue();
    }

    public java.util.Date getWeeklyFeedbackStartTimeBegin(){
        return weeklyFeedbackStartTimeBegin;
    }

    public void setWeeklyFeedbackStartTimeBegin(java.util.Date weeklyFeedbackStartTimeBegin){
        this.weeklyFeedbackStartTimeBegin = weeklyFeedbackStartTimeBegin;
    }

    public java.util.Date getWeeklyFeedbackStartTimeEnd(){
        return weeklyFeedbackStartTimeEnd;
    }

    public void setWeeklyFeedbackStartTimeEnd(java.util.Date weeklyFeedbackStartTimeEnd){
        this.weeklyFeedbackStartTimeEnd = weeklyFeedbackStartTimeEnd;
    }

    public java.lang.String getQualitySupervisorId(){
        return qualitySupervisorId;
    }

    public void setQualitySupervisorId(java.lang.String qualitySupervisorId){
        this.qualitySupervisorId = qualitySupervisorId;
    }

    public java.lang.String getQualitySupervisorCode(){
        return qualitySupervisorCode;
    }

    public void setQualitySupervisorCode(java.lang.String qualitySupervisorCode){
        this.qualitySupervisorCode = qualitySupervisorCode;
    }

    public java.lang.String getQualitySupervisorName(){
        return qualitySupervisorName;
    }

    public void setQualitySupervisorName(java.lang.String qualitySupervisorName){
        this.qualitySupervisorName = qualitySupervisorName;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
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
            return "TOP10问题台账";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "TOP10问题台账";
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
