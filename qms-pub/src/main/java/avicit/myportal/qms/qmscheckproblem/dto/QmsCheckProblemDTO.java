package avicit.myportal.qms.qmscheckproblem.dto;

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
* @创建时间： 2026-08-05 18:17
* @类说明：检查问题表DTO
* @修改记录：
*/
@ApiModel(value = "QmsCheckProblemDTO", description = "检查问题表")
@PojoRemark(table="QMS_CHECK_PROBLEM", object="QmsCheckProblemDTO", name="检查问题表")
@ExcelIgnoreUnannotated
public class QmsCheckProblemDTO extends BeanDTO{
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
    * 问题编号
    */
    @ExcelProperty("问题编号")
    @Size(max = 50, message = "问题编号长度不能超过50个字符")
    @ApiModelProperty(value = "问题编号", name = "problemCode")
    @FieldRemark(column="PROBLEM_CODE", field="problemCode", name="问题编号")
    private java.lang.String problemCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 问题描述
    */
    @ExcelProperty("问题描述")
    @Size(max = 256, message = "问题描述长度不能超过256个字符")
    @ApiModelProperty(value = "问题描述", name = "problemDesc")
    @FieldRemark(column="PROBLEM_DESC", field="problemDesc", name="问题描述")
    private java.lang.String problemDesc;

    /**
    * 问题分类
    */
    @ExcelProperty("问题分类")
    @Size(max = 50, message = "问题分类长度不能超过50个字符")
    @ApiModelProperty(value = "问题分类", name = "problemCategory")
    @FieldRemark(column="PROBLEM_CATEGORY", field="problemCategory", name="问题分类")
    private java.lang.String problemCategory;

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
    @Size(max = 50, message = "整改单位长度不能超过50个字符")
    @ApiModelProperty(value = "整改单位", name = "rectificationDeptName")
    @FieldRemark(column="RECTIFICATION_DEPT_NAME", field="rectificationDeptName", name="整改单位")
    private java.lang.String rectificationDeptName;

    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任人ID", name = "responsibleUserIds")
    @FieldRemark(column="RESPONSIBLE_USER_IDS", field="responsibleUserIds", name="责任人ID")
    private java.lang.String responsibleUserIds;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 10, message = "责任人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleUserCodes")
    @FieldRemark(column="RESPONSIBLE_USER_CODES", field="responsibleUserCodes", name="责任人CODE")
    private java.lang.String responsibleUserCodes;

    /**
    * 责任人姓名
    */
    @ExcelProperty("责任人姓名")
    @Size(max = 50, message = "责任人姓名长度不能超过50个字符")
    @ApiModelProperty(value = "责任人姓名", name = "responsibleUserNames")
    @FieldRemark(column="RESPONSIBLE_USER_NAMES", field="responsibleUserNames", name="责任人姓名")
    private java.lang.String responsibleUserNames;
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
    * 问题状态
    */
    @ExcelProperty("问题状态")
    @Size(max = 30, message = "问题状态长度不能超过30个字符")
    @ApiModelProperty(value = "问题状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="问题状态")
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
    * 整改提交时间
    */
    @ExcelProperty("整改提交时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "整改提交时间", name = "submitTime")
    @FieldRemark(column="SUBMIT_TIME", field="submitTime", name="整改提交时间")
    private java.util.Date submitTime;

    /**
    * 整改提交时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date submitTimeBegin;

    /**
    * 整改提交时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date submitTimeEnd;

    /**
    * 来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK
    */
    @ExcelProperty("来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK")
    @Size(max = 50, message = "来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK长度不能超过50个字符")
    @ApiModelProperty(value = "来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK", name = "sourceType")
    @FieldRemark(column="SOURCE_TYPE", field="sourceType", name="来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK")
    private java.lang.String sourceType;

    /**
    * 来源业务ID;关联监督、检查、审核活动
    */
    @Size(max = 64, message = "来源业务ID;关联监督、检查、审核活动长度不能超过64个字符")
    @ApiModelProperty(value = "来源业务ID;关联监督、检查、审核活动", name = "sourceId")
    @FieldRemark(column="SOURCE_ID", field="sourceId", name="来源业务ID;关联监督、检查、审核活动")
    private java.lang.String sourceId;

    /**
    * 来源业务编号;检查编号、监督编号等
    */
    @ExcelProperty("来源业务编号;检查编号、监督编号等")
    @Size(max = 50, message = "来源业务编号;检查编号、监督编号等长度不能超过50个字符")
    @ApiModelProperty(value = "来源业务编号;检查编号、监督编号等", name = "sourceCode")
    @FieldRemark(column="SOURCE_CODE", field="sourceCode", name="来源业务编号;检查编号、监督编号等")
    private java.lang.String sourceCode;

    /**
    * 来源业务名称;检查名称、审核名称等
    */
    @ExcelProperty("来源业务名称;检查名称、审核名称等")
    @Size(max = 256, message = "来源业务名称;检查名称、审核名称等长度不能超过256个字符")
    @ApiModelProperty(value = "来源业务名称;检查名称、审核名称等", name = "sourceName")
    @FieldRemark(column="SOURCE_NAME", field="sourceName", name="来源业务名称;检查名称、审核名称等")
    private java.lang.String sourceName;

    /**
    * 问题等级
    */
    @ExcelProperty("问题等级")
    @Size(max = 50, message = "问题等级长度不能超过50个字符")
    @ApiModelProperty(value = "问题等级", name = "problemLevel")
    @FieldRemark(column="PROBLEM_LEVEL", field="problemLevel", name="问题等级")
    private java.lang.String problemLevel;

    /**
    * 依据条款
    */
    @ExcelProperty("依据条款")
    @Size(max = 1024, message = "依据条款长度不能超过1024个字符")
    @ApiModelProperty(value = "依据条款", name = "baisisClause")
    @FieldRemark(column="BAISIS_CLAUSE", field="baisisClause", name="依据条款")
    private java.lang.String baisisClause;
    /**
    * 发现时间
    */
    @ExcelProperty("发现时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "发现时间", name = "foundTime")
    @FieldRemark(column="FOUND_TIME", field="foundTime", name="发现时间")
    private java.util.Date foundTime;

    /**
    * 发现时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date foundTimeBegin;

    /**
    * 发现时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date foundTimeEnd;

    /**
    * 涉及型号
    */
    @ExcelProperty("涉及型号")
    @Size(max = 256, message = "涉及型号长度不能超过256个字符")
    @ApiModelProperty(value = "涉及型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="涉及型号")
    private java.lang.String model;

    /**
    * 发现人ID
    */
    @ExcelProperty("发现人ID")
    @Size(max = 64, message = "发现人ID长度不能超过64个字符")
    @ApiModelProperty(value = "发现人ID", name = "discovererStaffId")
    @FieldRemark(column="DISCOVERER_STAFF_ID", field="discovererStaffId", name="发现人ID")
    private java.lang.String discovererStaffId;

    /**
    * 发现人CODE
    */
    @ExcelProperty("发现人CODE")
    @Size(max = 10, message = "发现人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "发现人CODE", name = "discovererStaffCode")
    @FieldRemark(column="DISCOVERER_STAFF_CODE", field="discovererStaffCode", name="发现人CODE")
    private java.lang.String discovererStaffCode;

    /**
    * 发现人
    */
    @ExcelProperty("发现人")
    @Size(max = 50, message = "发现人长度不能超过50个字符")
    @ApiModelProperty(value = "发现人", name = "discovererStaffName")
    @FieldRemark(column="DISCOVERER_STAFF_NAME", field="discovererStaffName", name="发现人")
    private java.lang.String discovererStaffName;

    /**
    * 是否需要整改
    */
    @ExcelProperty("是否需要整改")
    @Size(max = 2, message = "是否需要整改长度不能超过2个字符")
    @ApiModelProperty(value = "是否需要整改", name = "ynRectification")
    @FieldRemark(column="YN_RECTIFICATION", field="ynRectification", name="是否需要整改")
    private java.lang.String ynRectification;

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

    public java.lang.String getProblemCode(){
        return problemCode;
    }

    public void setProblemCode(java.lang.String problemCode){
        this.problemCode = problemCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
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

    public java.lang.String getResponsibleUserIds(){
        return responsibleUserIds;
    }

    public void setResponsibleUserIds(java.lang.String responsibleUserIds){
        this.responsibleUserIds = responsibleUserIds;
    }

    public java.lang.String getResponsibleUserCodes(){
        return responsibleUserCodes;
    }

    public void setResponsibleUserCodes(java.lang.String responsibleUserCodes){
        this.responsibleUserCodes = responsibleUserCodes;
    }

    public java.lang.String getResponsibleUserNames(){
        return responsibleUserNames;
    }

    public void setResponsibleUserNames(java.lang.String responsibleUserNames){
        this.responsibleUserNames = responsibleUserNames;
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

    public java.lang.String getProblemLevel(){
        return problemLevel;
    }

    public void setProblemLevel(java.lang.String problemLevel){
        this.problemLevel = problemLevel;
    }

    public java.lang.String getBaisisClause(){
        return baisisClause;
    }

    public void setBaisisClause(java.lang.String baisisClause){
        this.baisisClause = baisisClause;
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

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.lang.String getDiscovererStaffId(){
        return discovererStaffId;
    }

    public void setDiscovererStaffId(java.lang.String discovererStaffId){
        this.discovererStaffId = discovererStaffId;
    }

    public java.lang.String getDiscovererStaffCode(){
        return discovererStaffCode;
    }

    public void setDiscovererStaffCode(java.lang.String discovererStaffCode){
        this.discovererStaffCode = discovererStaffCode;
    }

    public java.lang.String getDiscovererStaffName(){
        return discovererStaffName;
    }

    public void setDiscovererStaffName(java.lang.String discovererStaffName){
        this.discovererStaffName = discovererStaffName;
    }

    public java.lang.String getYnRectification(){
        return ynRectification;
    }

    public void setYnRectification(java.lang.String ynRectification){
        this.ynRectification = ynRectification;
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
            return "检查问题表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "检查问题表";
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
