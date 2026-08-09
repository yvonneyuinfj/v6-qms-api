package avicit.myportal.qms.qmsmrinputitem.dto;

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
* @创建时间： 2026-08-03 19:43
* @类说明：管评输入材料分工台账DTO
* @修改记录：
*/
@ApiModel(value = "QmsMrInputItemDTO", description = "管评输入材料分工台账")
@PojoRemark(table="QMS_MR_INPUT_ITEM", object="QmsMrInputItemDTO", name="管评输入材料分工台账")
@ExcelIgnoreUnannotated
public class QmsMrInputItemDTO extends BeanDTO{
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
    * 年度
    */
    @ExcelProperty("年度")
    @Size(max = 4, message = "年度长度不能超过4个字符")
    @ApiModelProperty(value = "年度", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="年度")
    private java.lang.String forYear;

    /**
    * 编号
    */
    @ExcelProperty("编号")
    @Size(max = 64, message = "编号长度不能超过64个字符")
    @ApiModelProperty(value = "编号", name = "sequenceCode")
    @FieldRemark(column="SEQUENCE_CODE", field="sequenceCode", name="编号")
    private java.lang.String sequenceCode;

    /**
    * 材料名称
    */
    @ExcelProperty("材料名称")
    @Size(max = 256, message = "材料名称长度不能超过256个字符")
    @ApiModelProperty(value = "材料名称", name = "materalName")
    @FieldRemark(column="MATERAL_NAME", field="materalName", name="材料名称")
    private java.lang.String materalName;

    /**
    * 主要要求
    */
    @ExcelProperty("主要要求")
    @Size(max = 512, message = "主要要求长度不能超过512个字符")
    @ApiModelProperty(value = "主要要求", name = "mainRequirement")
    @FieldRemark(column="MAIN_REQUIREMENT", field="mainRequirement", name="主要要求")
    private java.lang.String mainRequirement;

    /**
    * 主责部门ID
    */
    @ExcelProperty("主责部门ID")
    @Size(max = 64, message = "主责部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "主责部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="主责部门ID")
    private java.lang.String responsibleDeptId;

    /**
    * 主责部门CODE
    */
    @ExcelProperty("主责部门CODE")
    @Size(max = 50, message = "主责部门CODE长度不能超过50个字符")
    @ApiModelProperty(value = "主责部门CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="主责部门CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 主责部门
    */
    @ExcelProperty("主责部门")
    @Size(max = 50, message = "主责部门长度不能超过50个字符")
    @ApiModelProperty(value = "主责部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="主责部门")
    private java.lang.String responsibleDeptName;

    /**
    * 责任领导ID
    */
    @ExcelProperty("责任领导ID")
    @Size(max = 64, message = "责任领导ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任领导ID", name = "responsibleDeptLeaderId")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_ID", field="responsibleDeptLeaderId", name="责任领导ID")
    private java.lang.String responsibleDeptLeaderId;

    /**
    * 责任领导CODE
    */
    @ExcelProperty("责任领导CODE")
    @Size(max = 50, message = "责任领导CODE长度不能超过50个字符")
    @ApiModelProperty(value = "责任领导CODE", name = "responsibleDeptLeaderCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_CODE", field="responsibleDeptLeaderCode", name="责任领导CODE")
    private java.lang.String responsibleDeptLeaderCode;

    /**
    * 责任领导
    */
    @ExcelProperty("责任领导")
    @Size(max = 50, message = "责任领导长度不能超过50个字符")
    @ApiModelProperty(value = "责任领导", name = "responsibleDeptLeaderName")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_NAME", field="responsibleDeptLeaderName", name="责任领导")
    private java.lang.String responsibleDeptLeaderName;

    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任人ID", name = "responsibleUserId")
    @FieldRemark(column="RESPONSIBLE_USER_ID", field="responsibleUserId", name="责任人ID")
    private java.lang.String responsibleUserId;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 50, message = "责任人CODE长度不能超过50个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleUserCode")
    @FieldRemark(column="RESPONSIBLE_USER_CODE", field="responsibleUserCode", name="责任人CODE")
    private java.lang.String responsibleUserCode;

    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 50, message = "责任人长度不能超过50个字符")
    @ApiModelProperty(value = "责任人", name = "responsibleUserName")
    @FieldRemark(column="RESPONSIBLE_USER_NAME", field="responsibleUserName", name="责任人")
    private java.lang.String responsibleUserName;
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
    * 截止时间
    */
    @ExcelProperty("截止时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "截止时间", name = "deadline")
    @FieldRemark(column="DEADLINE", field="deadline", name="截止时间")
    private java.util.Date deadline;

    /**
    * 截止时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineBegin;

    /**
    * 截止时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineEnd;

    /**
    * 交付物要求
    */
    @ExcelProperty("交付物要求")
    @Size(max = 512, message = "交付物要求长度不能超过512个字符")
    @ApiModelProperty(value = "交付物要求", name = "deliverableRequirement")
    @FieldRemark(column="DELIVERABLE_REQUIREMENT", field="deliverableRequirement", name="交付物要求")
    private java.lang.String deliverableRequirement;

    /**
    * 材料来源类型;常规材料、上年度改进项等
    */
    @ExcelProperty("材料来源类型;常规材料、上年度改进项等")
    @Size(max = 128, message = "材料来源类型;常规材料、上年度改进项等长度不能超过128个字符")
    @ApiModelProperty(value = "材料来源类型;常规材料、上年度改进项等", name = "sourceType")
    @FieldRemark(column="SOURCE_TYPE", field="sourceType", name="材料来源类型;常规材料、上年度改进项等")
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
    * 是否逾期
    */
    @ExcelProperty("是否逾期")
    @Size(max = 4, message = "是否逾期长度不能超过4个字符")
    @ApiModelProperty(value = "是否逾期", name = "ynOverdue")
    @FieldRemark(column="YN_OVERDUE", field="ynOverdue", name="是否逾期")
    private java.lang.String ynOverdue;

    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
    private java.lang.String status;

    /**
    * 交付物提交状态
    */
    @ExcelProperty("交付物提交状态")
    @Size(max = 10, message = "交付物提交状态长度不能超过10个字符")
    @ApiModelProperty(value = "交付物提交状态", name = "feedbackStatus")
    @FieldRemark(column="FEEDBACK_STATUS", field="feedbackStatus", name="交付物提交状态")
    private java.lang.String feedbackStatus;

    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    @ApiModelProperty(value = "交付物", name = "expectedDeliverable")
    @FieldRemark(column="EXPECTED_DELIVERABLE", field="expectedDeliverable", name="交付物")
    private java.lang.String expectedDeliverable;

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

    public java.lang.String getSequenceCode(){
        return sequenceCode;
    }

    public void setSequenceCode(java.lang.String sequenceCode){
        this.sequenceCode = sequenceCode;
    }

    public java.lang.String getMateralName(){
        return materalName;
    }

    public void setMateralName(java.lang.String materalName){
        this.materalName = materalName;
    }

    public java.lang.String getMainRequirement(){
        return mainRequirement;
    }

    public void setMainRequirement(java.lang.String mainRequirement){
        this.mainRequirement = mainRequirement;
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

    public java.lang.String getResponsibleDeptLeaderId(){
        return responsibleDeptLeaderId;
    }

    public void setResponsibleDeptLeaderId(java.lang.String responsibleDeptLeaderId){
        this.responsibleDeptLeaderId = responsibleDeptLeaderId;
    }

    public java.lang.String getResponsibleDeptLeaderCode(){
        return responsibleDeptLeaderCode;
    }

    public void setResponsibleDeptLeaderCode(java.lang.String responsibleDeptLeaderCode){
        this.responsibleDeptLeaderCode = responsibleDeptLeaderCode;
    }

    public java.lang.String getResponsibleDeptLeaderName(){
        return responsibleDeptLeaderName;
    }

    public void setResponsibleDeptLeaderName(java.lang.String responsibleDeptLeaderName){
        this.responsibleDeptLeaderName = responsibleDeptLeaderName;
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

    public java.lang.String getDeliverableRequirement(){
        return deliverableRequirement;
    }

    public void setDeliverableRequirement(java.lang.String deliverableRequirement){
        this.deliverableRequirement = deliverableRequirement;
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

    public java.lang.String getYnOverdue(){
        return ynOverdue;
    }

    public void setYnOverdue(java.lang.String ynOverdue){
        this.ynOverdue = ynOverdue;
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

    public java.lang.String getExpectedDeliverable(){
        return expectedDeliverable;
    }

    public void setExpectedDeliverable(java.lang.String expectedDeliverable){
        this.expectedDeliverable = expectedDeliverable;
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

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "管评输入材料分工台账";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "管评输入材料分工台账";
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
