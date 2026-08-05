package avicit.myportal.qms.qmsproblemrectification.dto;

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
* @创建时间： 2026-08-05 18:14
* @类说明：问题整改表DTO
* @修改记录：
*/
@ApiModel(value = "QmsProblemRectificationDTO", description = "问题整改表")
@PojoRemark(table="QMS_PROBLEM_RECTIFICATION", object="QmsProblemRectificationDTO", name="问题整改表")
@ExcelIgnoreUnannotated
public class QmsProblemRectificationDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * ID;主键
    */
    @Id
    @Size(max = 64, message = "ID;主键长度不能超过64个字符")
    @ApiModelProperty(value = "ID;主键", name = "id")
    @FieldRemark(column="ID", field="id", name="ID;主键")
    private java.lang.String id;

    /**
    * 问题ID
    */
    @Size(max = 64, message = "问题ID长度不能超过64个字符")
    @ApiModelProperty(value = "问题ID", name = "checkProblemId")
    @FieldRemark(column="CHECK_PROBLEM_ID", field="checkProblemId", name="问题ID")
    private java.lang.String checkProblemId;

    /**
    * 整改编号
    */
    @ExcelProperty("整改编号")
    @Size(max = 50, message = "整改编号长度不能超过50个字符")
    @ApiModelProperty(value = "整改编号", name = "rectificationCode")
    @FieldRemark(column="RECTIFICATION_CODE", field="rectificationCode", name="整改编号")
    private java.lang.String rectificationCode;

    /**
    * 所属年份;年度查询
    */
    @ExcelProperty("所属年份;年度查询")
    @Size(max = 10, message = "所属年份;年度查询长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份;年度查询", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份;年度查询")
    private java.lang.String forYear;

    /**
    * 纠正类型;10纠正；20纠正计划
    */
    @ExcelProperty("纠正类型;10纠正；20纠正计划")
    @Size(max = 10, message = "纠正类型;10纠正；20纠正计划长度不能超过10个字符")
    @ApiModelProperty(value = "纠正类型;10纠正；20纠正计划", name = "correctionType")
    @FieldRemark(column="CORRECTION_TYPE", field="correctionType", name="纠正类型;10纠正；20纠正计划")
    private java.lang.String correctionType;

    /**
    * 纠正或纠正计划;责任人填写
    */
    @ExcelProperty("纠正或纠正计划;责任人填写")
    @Size(max = 2000, message = "纠正或纠正计划;责任人填写长度不能超过2000个字符")
    @ApiModelProperty(value = "纠正或纠正计划;责任人填写", name = "correctionContent")
    @FieldRemark(column="CORRECTION_CONTENT", field="correctionContent", name="纠正或纠正计划;责任人填写")
    private java.lang.String correctionContent;

    /**
    * 原因分析;责任人填写
    */
    @ExcelProperty("原因分析;责任人填写")
    @Size(max = 2000, message = "原因分析;责任人填写长度不能超过2000个字符")
    @ApiModelProperty(value = "原因分析;责任人填写", name = "causeAnalysis")
    @FieldRemark(column="CAUSE_ANALYSIS", field="causeAnalysis", name="原因分析;责任人填写")
    private java.lang.String causeAnalysis;

    /**
    * 纠正措施类型;10纠正措施；20纠正措施计划
    */
    @ExcelProperty("纠正措施类型;10纠正措施；20纠正措施计划")
    @Size(max = 10, message = "纠正措施类型;10纠正措施；20纠正措施计划长度不能超过10个字符")
    @ApiModelProperty(value = "纠正措施类型;10纠正措施；20纠正措施计划", name = "correctiveActionType")
    @FieldRemark(column="CORRECTIVE_ACTION_TYPE", field="correctiveActionType", name="纠正措施类型;10纠正措施；20纠正措施计划")
    private java.lang.String correctiveActionType;

    /**
    * 纠正措施或计划;责任人填写
    */
    @ExcelProperty("纠正措施或计划;责任人填写")
    @Size(max = 2000, message = "纠正措施或计划;责任人填写长度不能超过2000个字符")
    @ApiModelProperty(value = "纠正措施或计划;责任人填写", name = "correctiveAction")
    @FieldRemark(column="CORRECTIVE_ACTION", field="correctiveAction", name="纠正措施或计划;责任人填写")
    private java.lang.String correctiveAction;

    /**
    * 举一反三情况;责任人填写
    */
    @ExcelProperty("举一反三情况;责任人填写")
    @Size(max = 2000, message = "举一反三情况;责任人填写长度不能超过2000个字符")
    @ApiModelProperty(value = "举一反三情况;责任人填写", name = "horizontalCheck")
    @FieldRemark(column="HORIZONTAL_CHECK", field="horizontalCheck", name="举一反三情况;责任人填写")
    private java.lang.String horizontalCheck;

    /**
    * 整改完成情况;整改完成结果和效果说明
    */
    @ExcelProperty("整改完成情况;整改完成结果和效果说明")
    @Size(max = 2000, message = "整改完成情况;整改完成结果和效果说明长度不能超过2000个字符")
    @ApiModelProperty(value = "整改完成情况;整改完成结果和效果说明", name = "rectificationResult")
    @FieldRemark(column="RECTIFICATION_RESULT", field="rectificationResult", name="整改完成情况;整改完成结果和效果说明")
    private java.lang.String rectificationResult;

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
    * 整改完成时间
    */
    @ExcelProperty("整改完成时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "整改完成时间", name = "completeTime")
    @FieldRemark(column="COMPLETE_TIME", field="completeTime", name="整改完成时间")
    private java.util.Date completeTime;

    /**
    * 整改完成时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeBegin;

    /**
    * 整改完成时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeEnd;
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
    * 来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告
    */
    @ExcelProperty("来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告")
    @Size(max = 50, message = "来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告长度不能超过50个字符")
    @ApiModelProperty(value = "来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告", name = "sourceType")
    @FieldRemark(column="SOURCE_TYPE", field="sourceType", name="来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告")
    private java.lang.String sourceType;

    /**
    * 来源业务ID;来源问题主键
    */
    @ExcelProperty("来源业务ID;来源问题主键")
    @Size(max = 64, message = "来源业务ID;来源问题主键长度不能超过64个字符")
    @ApiModelProperty(value = "来源业务ID;来源问题主键", name = "sourceId")
    @FieldRemark(column="SOURCE_ID", field="sourceId", name="来源业务ID;来源问题主键")
    private java.lang.String sourceId;

    /**
    * 来源问题编号;来源业务问题编号
    */
    @ExcelProperty("来源问题编号;来源业务问题编号")
    @Size(max = 50, message = "来源问题编号;来源业务问题编号长度不能超过50个字符")
    @ApiModelProperty(value = "来源问题编号;来源业务问题编号", name = "sourceCode")
    @FieldRemark(column="SOURCE_CODE", field="sourceCode", name="来源问题编号;来源业务问题编号")
    private java.lang.String sourceCode;

    /**
    * 来源问题名称;用于列表展示
    */
    @ExcelProperty("来源问题名称;用于列表展示")
    @Size(max = 128, message = "来源问题名称;用于列表展示长度不能超过128个字符")
    @ApiModelProperty(value = "来源问题名称;用于列表展示", name = "sourceName")
    @FieldRemark(column="SOURCE_NAME", field="sourceName", name="来源问题名称;用于列表展示")
    private java.lang.String sourceName;

    /**
    * 问题描述;从来源业务复制
    */
    @ExcelProperty("问题描述;从来源业务复制")
    @Size(max = 512, message = "问题描述;从来源业务复制长度不能超过512个字符")
    @ApiModelProperty(value = "问题描述;从来源业务复制", name = "problemDesc")
    @FieldRemark(column="PROBLEM_DESC", field="problemDesc", name="问题描述;从来源业务复制")
    private java.lang.String problemDesc;

    /**
    * 问题分类;字典
    */
    @ExcelProperty("问题分类;字典")
    @Size(max = 10, message = "问题分类;字典长度不能超过10个字符")
    @ApiModelProperty(value = "问题分类;字典", name = "problemCategory")
    @FieldRemark(column="PROBLEM_CATEGORY", field="problemCategory", name="问题分类;字典")
    private java.lang.String problemCategory;

    /**
    * 整改要求;问题提出部门填写
    */
    @ExcelProperty("整改要求;问题提出部门填写")
    @Size(max = 512, message = "整改要求;问题提出部门填写长度不能超过512个字符")
    @ApiModelProperty(value = "整改要求;问题提出部门填写", name = "rectificationRequirement")
    @FieldRemark(column="RECTIFICATION_REQUIREMENT", field="rectificationRequirement", name="整改要求;问题提出部门填写")
    private java.lang.String rectificationRequirement;
    /**
    * 问题发现时间
    */
    @ExcelProperty("问题发现时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "问题发现时间", name = "foundTime")
    @FieldRemark(column="FOUND_TIME", field="foundTime", name="问题发现时间")
    private java.util.Date foundTime;

    /**
    * 问题发现时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date foundTimeBegin;

    /**
    * 问题发现时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date foundTimeEnd;

    /**
    * 整改单位ID
    */
    @ExcelProperty("整改单位ID")
    @Size(max = 64, message = "整改单位ID长度不能超过64个字符")
    @ApiModelProperty(value = "整改单位ID", name = "rectificationDeptId")
    @FieldRemark(column="RECTIFICATION_DEPT_ID", field="rectificationDeptId", name="整改单位ID")
    private java.lang.String rectificationDeptId;

    /**
    * 整改单位CODE
    */
    @ExcelProperty("整改单位CODE")
    @Size(max = 10, message = "整改单位CODE长度不能超过10个字符")
    @ApiModelProperty(value = "整改单位CODE", name = "rectificationDeptCode")
    @FieldRemark(column="RECTIFICATION_DEPT_CODE", field="rectificationDeptCode", name="整改单位CODE")
    private java.lang.String rectificationDeptCode;

    /**
    * 整改单位
    */
    @ExcelProperty("整改单位")
    @Size(max = 128, message = "整改单位长度不能超过128个字符")
    @ApiModelProperty(value = "整改单位", name = "rectificationDeptName")
    @FieldRemark(column="RECTIFICATION_DEPT_NAME", field="rectificationDeptName", name="整改单位")
    private java.lang.String rectificationDeptName;

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
    * 整改期限
    */
    @ExcelProperty("整改期限")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "整改期限", name = "rectificationDeadline")
    @FieldRemark(column="RECTIFICATION_DEADLINE", field="rectificationDeadline", name="整改期限")
    private java.util.Date rectificationDeadline;

    /**
    * 整改期限起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date rectificationDeadlineBegin;

    /**
    * 整改期限止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date rectificationDeadlineEnd;

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

    public java.lang.String getCheckProblemId(){
        return checkProblemId;
    }

    public void setCheckProblemId(java.lang.String checkProblemId){
        this.checkProblemId = checkProblemId;
    }

    public java.lang.String getRectificationCode(){
        return rectificationCode;
    }

    public void setRectificationCode(java.lang.String rectificationCode){
        this.rectificationCode = rectificationCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getCorrectionType(){
        return correctionType;
    }

    public void setCorrectionType(java.lang.String correctionType){
        this.correctionType = correctionType;
    }

    public java.lang.String getCorrectionContent(){
        return correctionContent;
    }

    public void setCorrectionContent(java.lang.String correctionContent){
        this.correctionContent = correctionContent;
    }

    public java.lang.String getCauseAnalysis(){
        return causeAnalysis;
    }

    public void setCauseAnalysis(java.lang.String causeAnalysis){
        this.causeAnalysis = causeAnalysis;
    }

    public java.lang.String getCorrectiveActionType(){
        return correctiveActionType;
    }

    public void setCorrectiveActionType(java.lang.String correctiveActionType){
        this.correctiveActionType = correctiveActionType;
    }

    public java.lang.String getCorrectiveAction(){
        return correctiveAction;
    }

    public void setCorrectiveAction(java.lang.String correctiveAction){
        this.correctiveAction = correctiveAction;
    }

    public java.lang.String getHorizontalCheck(){
        return horizontalCheck;
    }

    public void setHorizontalCheck(java.lang.String horizontalCheck){
        this.horizontalCheck = horizontalCheck;
    }

    public java.lang.String getRectificationResult(){
        return rectificationResult;
    }

    public void setRectificationResult(java.lang.String rectificationResult){
        this.rectificationResult = rectificationResult;
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

    public java.lang.String getSourceCode(){
        return sourceCode;
    }

    public void setSourceCode(java.lang.String sourceCode){
        this.sourceCode = sourceCode;
    }

    public java.lang.String getSourceName(){
        return sourceName;
    }

    public void setSourceName(java.lang.String sourceName){
        this.sourceName = sourceName;
    }

    public java.lang.String getProblemDesc(){
        return problemDesc;
    }

    public void setProblemDesc(java.lang.String problemDesc){
        this.problemDesc = problemDesc;
    }

    public java.lang.String getProblemCategory(){
        return problemCategory;
    }

    public void setProblemCategory(java.lang.String problemCategory){
        this.problemCategory = problemCategory;
    }

    public java.lang.String getRectificationRequirement(){
        return rectificationRequirement;
    }

    public void setRectificationRequirement(java.lang.String rectificationRequirement){
        this.rectificationRequirement = rectificationRequirement;
    }

    public java.util.Date getFoundTime(){
        return foundTime;
    }

    public void setFoundTime(java.util.Date foundTime){
        this.foundTime = foundTime;
        super.handleNullValue();
    }

    public java.util.Date getFoundTimeBegin(){
        return foundTimeBegin;
    }

    public void setFoundTimeBegin(java.util.Date foundTimeBegin){
        this.foundTimeBegin = foundTimeBegin;
    }

    public java.util.Date getFoundTimeEnd(){
        return foundTimeEnd;
    }

    public void setFoundTimeEnd(java.util.Date foundTimeEnd){
        this.foundTimeEnd = foundTimeEnd;
    }

    public java.lang.String getRectificationDeptId(){
        return rectificationDeptId;
    }

    public void setRectificationDeptId(java.lang.String rectificationDeptId){
        this.rectificationDeptId = rectificationDeptId;
    }

    public java.lang.String getRectificationDeptCode(){
        return rectificationDeptCode;
    }

    public void setRectificationDeptCode(java.lang.String rectificationDeptCode){
        this.rectificationDeptCode = rectificationDeptCode;
    }

    public java.lang.String getRectificationDeptName(){
        return rectificationDeptName;
    }

    public void setRectificationDeptName(java.lang.String rectificationDeptName){
        this.rectificationDeptName = rectificationDeptName;
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

    public java.util.Date getRectificationDeadline(){
        return rectificationDeadline;
    }

    public void setRectificationDeadline(java.util.Date rectificationDeadline){
        this.rectificationDeadline = rectificationDeadline;
        super.handleNullValue();
    }

    public java.util.Date getRectificationDeadlineBegin(){
        return rectificationDeadlineBegin;
    }

    public void setRectificationDeadlineBegin(java.util.Date rectificationDeadlineBegin){
        this.rectificationDeadlineBegin = rectificationDeadlineBegin;
    }

    public java.util.Date getRectificationDeadlineEnd(){
        return rectificationDeadlineEnd;
    }

    public void setRectificationDeadlineEnd(java.util.Date rectificationDeadlineEnd){
        this.rectificationDeadlineEnd = rectificationDeadlineEnd;
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
            return "问题整改表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "问题整改表";
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
