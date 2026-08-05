package avicit.myportal.qms.qmsqualityproblemdelay.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BeanDTO;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dto.QmsQualityProblemDelayMilestoneDTO;
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

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:05
* @类说明：质量问题延期DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityProblemDelayDTO", description = "质量问题延期")
@PojoRemark(table="QMS_QUALITY_PROBLEM_DELAY", object="QmsQualityProblemDelayDTO", name="质量问题延期")
@ExcelIgnoreUnannotated
public class QmsQualityProblemDelayDTO extends BeanDTO{
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
    * 延期编号
    */
    @ExcelProperty("延期编号")
    @Size(max = 128, message = "延期编号长度不能超过128个字符")
    @ApiModelProperty(value = "延期编号", name = "delayCode")
    @FieldRemark(column="DELAY_CODE", field="delayCode", name="延期编号")
    private java.lang.String delayCode;

    /**
    * 质量问题ID
    */
    @ExcelProperty("质量问题ID")
    @Size(max = 64, message = "质量问题ID长度不能超过64个字符")
    @ApiModelProperty(value = "质量问题ID", name = "problemId")
    @FieldRemark(column="PROBLEM_ID", field="problemId", name="质量问题ID")
    private java.lang.String problemId;

    /**
    * 质量问题反馈单的编号
    */
    @ExcelProperty("质量问题反馈单的编号")
    @Size(max = 128, message = "质量问题反馈单的编号长度不能超过128个字符")
    @ApiModelProperty(value = "质量问题反馈单的编号", name = "problemCode")
    @FieldRemark(column="PROBLEM_CODE", field="problemCode", name="质量问题反馈单的编号")
    private java.lang.String problemCode;

    /**
    * 质量问题反馈单标题;系统自动，同步质量问题反馈单的标题
    */
    @ExcelProperty("质量问题反馈单标题;系统自动，同步质量问题反馈单的标题")
    @Size(max = 128, message = "质量问题反馈单标题;系统自动，同步质量问题反馈单的标题长度不能超过128个字符")
    @ApiModelProperty(value = "质量问题反馈单标题;系统自动，同步质量问题反馈单的标题", name = "problemTitle")
    @FieldRemark(column="PROBLEM_TITLE", field="problemTitle", name="质量问题反馈单标题;系统自动，同步质量问题反馈单的标题")
    private java.lang.String problemTitle;

    /**
    * 质量延期申请单标题;系统自动，关于xxx的延期申请
    */
    @ExcelProperty("质量延期申请单标题;系统自动，关于xxx的延期申请")
    @Size(max = 128, message = "质量延期申请单标题;系统自动，关于xxx的延期申请长度不能超过128个字符")
    @ApiModelProperty(value = "质量延期申请单标题;系统自动，关于xxx的延期申请", name = "delayTitle")
    @FieldRemark(column="DELAY_TITLE", field="delayTitle", name="质量延期申请单标题;系统自动，关于xxx的延期申请")
    private java.lang.String delayTitle;
    /**
    * 延期次数
    */
    @ExcelProperty("延期次数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 10, fraction = 0, message = "延期次数格式不正确")
    @ApiModelProperty(value = "延期次数", name = "delayTimes")
    @FieldRemark(column="DELAY_TIMES", field="delayTimes", name="延期次数")
    private java.math.BigDecimal delayTimes;
    /**
    * 原关闭时间
    */
    @ExcelProperty("原关闭时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "原关闭时间", name = "originalCloseTime")
    @FieldRemark(column="ORIGINAL_CLOSE_TIME", field="originalCloseTime", name="原关闭时间")
    private java.util.Date originalCloseTime;

    /**
    * 原关闭时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date originalCloseTimeBegin;

    /**
    * 原关闭时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date originalCloseTimeEnd;
    /**
    * 申请关闭时间
    */
    @ExcelProperty("申请关闭时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "申请关闭时间", name = "newCloseTime")
    @FieldRemark(column="NEW_CLOSE_TIME", field="newCloseTime", name="申请关闭时间")
    private java.util.Date newCloseTime;

    /**
    * 申请关闭时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date newCloseTimeBegin;

    /**
    * 申请关闭时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date newCloseTimeEnd;

    /**
    * 延期原因;数据字典：原因复杂、新件加工周期长、严正周期长（多选）
    */
    @ExcelProperty("延期原因;数据字典：原因复杂、新件加工周期长、严正周期长（多选）")
    @Size(max = 512, message = "延期原因;数据字典：原因复杂、新件加工周期长、严正周期长（多选）长度不能超过512个字符")
    @ApiModelProperty(value = "延期原因;数据字典：原因复杂、新件加工周期长、严正周期长（多选）", name = "delayReason")
    @FieldRemark(column="DELAY_REASON", field="delayReason", name="延期原因;数据字典：原因复杂、新件加工周期长、严正周期长（多选）")
    private java.lang.String delayReason;

    /**
    * 问题概述;系统自动，同步质量问题反馈单的问题概述
    */
    @ExcelProperty("问题概述;系统自动，同步质量问题反馈单的问题概述")
    @Size(max = 1024, message = "问题概述;系统自动，同步质量问题反馈单的问题概述长度不能超过1024个字符")
    @ApiModelProperty(value = "问题概述;系统自动，同步质量问题反馈单的问题概述", name = "problemSummary")
    @FieldRemark(column="PROBLEM_SUMMARY", field="problemSummary", name="问题概述;系统自动，同步质量问题反馈单的问题概述")
    private java.lang.String problemSummary;

    /**
    * 当前工作进展
    */
    @ExcelProperty("当前工作进展")
    @Size(max = 1024, message = "当前工作进展长度不能超过1024个字符")
    @ApiModelProperty(value = "当前工作进展", name = "currentProgress")
    @FieldRemark(column="CURRENT_PROGRESS", field="currentProgress", name="当前工作进展")
    private java.lang.String currentProgress;

    /**
    * 应急措施
    */
    @ExcelProperty("应急措施")
    @Size(max = 1024, message = "应急措施长度不能超过1024个字符")
    @ApiModelProperty(value = "应急措施", name = "emergencyMeasure")
    @FieldRemark(column="EMERGENCY_MEASURE", field="emergencyMeasure", name="应急措施")
    private java.lang.String emergencyMeasure;

    /**
    * 延期原因详细说明
    */
    @ExcelProperty("延期原因详细说明")
    @Size(max = 2000, message = "延期原因详细说明长度不能超过2000个字符")
    @ApiModelProperty(value = "延期原因详细说明", name = "delayReasonDetail")
    @FieldRemark(column="DELAY_REASON_DETAIL", field="delayReasonDetail", name="延期原因详细说明")
    private java.lang.String delayReasonDetail;

    /**
    * 科研平台任务编号
    */
    @ExcelProperty("科研平台任务编号")
    @Size(max = 128, message = "科研平台任务编号长度不能超过128个字符")
    @ApiModelProperty(value = "科研平台任务编号", name = "ppmPlanCode")
    @FieldRemark(column="PPM_PLAN_CODE", field="ppmPlanCode", name="科研平台任务编号")
    private java.lang.String ppmPlanCode;

    /**
    * 型号;系统自动，同步质量问题反馈单的型号
    */
    @ExcelProperty("型号;系统自动，同步质量问题反馈单的型号")
    @Size(max = 128, message = "型号;系统自动，同步质量问题反馈单的型号长度不能超过128个字符")
    @ApiModelProperty(value = "型号;系统自动，同步质量问题反馈单的型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号;系统自动，同步质量问题反馈单的型号")
    private java.lang.String model;

    /**
    * 申请人ID
    */
    @ExcelProperty("申请人ID")
    @Size(max = 64, message = "申请人ID长度不能超过64个字符")
    @ApiModelProperty(value = "申请人ID", name = "applicantStaffId")
    @FieldRemark(column="APPLICANT_STAFF_ID", field="applicantStaffId", name="申请人ID")
    private java.lang.String applicantStaffId;

    /**
    * 申请人CODE
    */
    @ExcelProperty("申请人CODE")
    @Size(max = 10, message = "申请人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申请人CODE", name = "applicantStaffCode")
    @FieldRemark(column="APPLICANT_STAFF_CODE", field="applicantStaffCode", name="申请人CODE")
    private java.lang.String applicantStaffCode;

    /**
    * 申请人姓名
    */
    @ExcelProperty("申请人姓名")
    @Size(max = 50, message = "申请人姓名长度不能超过50个字符")
    @ApiModelProperty(value = "申请人姓名", name = "applicantStaffName")
    @FieldRemark(column="APPLICANT_STAFF_NAME", field="applicantStaffName", name="申请人姓名")
    private java.lang.String applicantStaffName;

    /**
    * 申请部门ID
    */
    @ExcelProperty("申请部门ID")
    @Size(max = 64, message = "申请部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "申请部门ID", name = "applicantDeptId")
    @FieldRemark(column="APPLICANT_DEPT_ID", field="applicantDeptId", name="申请部门ID")
    private java.lang.String applicantDeptId;

    /**
    * 申请部门CODE
    */
    @ExcelProperty("申请部门CODE")
    @Size(max = 10, message = "申请部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申请部门CODE", name = "applicantDeptCode")
    @FieldRemark(column="APPLICANT_DEPT_CODE", field="applicantDeptCode", name="申请部门CODE")
    private java.lang.String applicantDeptCode;

    /**
    * 申请部门
    */
    @ExcelProperty("申请部门")
    @Size(max = 128, message = "申请部门长度不能超过128个字符")
    @ApiModelProperty(value = "申请部门", name = "applicantDeptName")
    @FieldRemark(column="APPLICANT_DEPT_NAME", field="applicantDeptName", name="申请部门")
    private java.lang.String applicantDeptName;
    /**
    * 申请时间
    */
    @ExcelProperty("申请时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "申请时间", name = "applyTime")
    @FieldRemark(column="APPLY_TIME", field="applyTime", name="申请时间")
    private java.util.Date applyTime;

    /**
    * 申请时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date applyTimeBegin;

    /**
    * 申请时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date applyTimeEnd;

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
    * 所属年度;方便查询
    */
    @ExcelProperty("所属年度;方便查询")
    @Size(max = 10, message = "所属年度;方便查询长度不能超过10个字符")
    @ApiModelProperty(value = "所属年度;方便查询", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年度;方便查询")
    private java.lang.String forYear;

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
     * 子表对象集合
     */
    private ValidationList<QmsQualityProblemDelayMilestoneDTO> qmsQualityProblemDelayMilestoneList;
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

    public java.lang.String getDelayCode(){
        return delayCode;
    }

    public void setDelayCode(java.lang.String delayCode){
        this.delayCode = delayCode;
    }

    public java.lang.String getProblemId(){
        return problemId;
    }

    public void setProblemId(java.lang.String problemId){
        this.problemId = problemId;
    }

    public java.lang.String getProblemCode(){
        return problemCode;
    }

    public void setProblemCode(java.lang.String problemCode){
        this.problemCode = problemCode;
    }

    public java.lang.String getProblemTitle(){
        return problemTitle;
    }

    public void setProblemTitle(java.lang.String problemTitle){
        this.problemTitle = problemTitle;
    }

    public java.lang.String getDelayTitle(){
        return delayTitle;
    }

    public void setDelayTitle(java.lang.String delayTitle){
        this.delayTitle = delayTitle;
    }

    public java.math.BigDecimal getDelayTimes(){
        return delayTimes;
    }

    public void setDelayTimes(java.math.BigDecimal delayTimes){
        this.delayTimes = delayTimes;
        super.handleNullValue();
    }

    public java.util.Date getOriginalCloseTime(){
        return originalCloseTime;
    }

    public void setOriginalCloseTime(java.util.Date originalCloseTime){
        this.originalCloseTime = originalCloseTime;
        super.handleNullValue();
    }

    public java.util.Date getOriginalCloseTimeBegin(){
        return originalCloseTimeBegin;
    }

    public void setOriginalCloseTimeBegin(java.util.Date originalCloseTimeBegin){
        this.originalCloseTimeBegin = originalCloseTimeBegin;
    }

    public java.util.Date getOriginalCloseTimeEnd(){
        return originalCloseTimeEnd;
    }

    public void setOriginalCloseTimeEnd(java.util.Date originalCloseTimeEnd){
        this.originalCloseTimeEnd = originalCloseTimeEnd;
    }

    public java.util.Date getNewCloseTime(){
        return newCloseTime;
    }

    public void setNewCloseTime(java.util.Date newCloseTime){
        this.newCloseTime = newCloseTime;
        super.handleNullValue();
    }

    public java.util.Date getNewCloseTimeBegin(){
        return newCloseTimeBegin;
    }

    public void setNewCloseTimeBegin(java.util.Date newCloseTimeBegin){
        this.newCloseTimeBegin = newCloseTimeBegin;
    }

    public java.util.Date getNewCloseTimeEnd(){
        return newCloseTimeEnd;
    }

    public void setNewCloseTimeEnd(java.util.Date newCloseTimeEnd){
        this.newCloseTimeEnd = newCloseTimeEnd;
    }

    public java.lang.String getDelayReason(){
        return delayReason;
    }

    public void setDelayReason(java.lang.String delayReason){
        this.delayReason = delayReason;
    }

    public java.lang.String getProblemSummary(){
        return problemSummary;
    }

    public void setProblemSummary(java.lang.String problemSummary){
        this.problemSummary = problemSummary;
    }

    public java.lang.String getCurrentProgress(){
        return currentProgress;
    }

    public void setCurrentProgress(java.lang.String currentProgress){
        this.currentProgress = currentProgress;
    }

    public java.lang.String getEmergencyMeasure(){
        return emergencyMeasure;
    }

    public void setEmergencyMeasure(java.lang.String emergencyMeasure){
        this.emergencyMeasure = emergencyMeasure;
    }

    public java.lang.String getDelayReasonDetail(){
        return delayReasonDetail;
    }

    public void setDelayReasonDetail(java.lang.String delayReasonDetail){
        this.delayReasonDetail = delayReasonDetail;
    }

    public java.lang.String getPpmPlanCode(){
        return ppmPlanCode;
    }

    public void setPpmPlanCode(java.lang.String ppmPlanCode){
        this.ppmPlanCode = ppmPlanCode;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.lang.String getApplicantStaffId(){
        return applicantStaffId;
    }

    public void setApplicantStaffId(java.lang.String applicantStaffId){
        this.applicantStaffId = applicantStaffId;
    }

    public java.lang.String getApplicantStaffCode(){
        return applicantStaffCode;
    }

    public void setApplicantStaffCode(java.lang.String applicantStaffCode){
        this.applicantStaffCode = applicantStaffCode;
    }

    public java.lang.String getApplicantStaffName(){
        return applicantStaffName;
    }

    public void setApplicantStaffName(java.lang.String applicantStaffName){
        this.applicantStaffName = applicantStaffName;
    }

    public java.lang.String getApplicantDeptId(){
        return applicantDeptId;
    }

    public void setApplicantDeptId(java.lang.String applicantDeptId){
        this.applicantDeptId = applicantDeptId;
    }

    public java.lang.String getApplicantDeptCode(){
        return applicantDeptCode;
    }

    public void setApplicantDeptCode(java.lang.String applicantDeptCode){
        this.applicantDeptCode = applicantDeptCode;
    }

    public java.lang.String getApplicantDeptName(){
        return applicantDeptName;
    }

    public void setApplicantDeptName(java.lang.String applicantDeptName){
        this.applicantDeptName = applicantDeptName;
    }

    public java.util.Date getApplyTime(){
        return applyTime;
    }

    public void setApplyTime(java.util.Date applyTime){
        this.applyTime = applyTime;
        super.handleNullValue();
    }

    public java.util.Date getApplyTimeBegin(){
        return applyTimeBegin;
    }

    public void setApplyTimeBegin(java.util.Date applyTimeBegin){
        this.applyTimeBegin = applyTimeBegin;
    }

    public java.util.Date getApplyTimeEnd(){
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(java.util.Date applyTimeEnd){
        this.applyTimeEnd = applyTimeEnd;
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

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
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

    public ValidationList<QmsQualityProblemDelayMilestoneDTO> getQmsQualityProblemDelayMilestoneList() {
        return qmsQualityProblemDelayMilestoneList;
    }

    public void setQmsQualityProblemDelayMilestoneList(ValidationList<QmsQualityProblemDelayMilestoneDTO> qmsQualityProblemDelayMilestoneList) {
        this.qmsQualityProblemDelayMilestoneList = qmsQualityProblemDelayMilestoneList;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "质量问题延期";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量问题延期";
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
