package avicit.myportal.qms.qmscommonactionfeedback.dto;

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
* @类说明：通用执行反馈表DTO
* @修改记录：
*/
@ApiModel(value = "QmsCommonActionFeedbackDTO", description = "通用执行反馈表")
@PojoRemark(table="QMS_COMMON_ACTION_FEEDBACK", object="QmsCommonActionFeedbackDTO", name="通用执行反馈表")
@ExcelIgnoreUnannotated
public class QmsCommonActionFeedbackDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 反馈ID
    */
    @Id
    @Size(max = 64, message = "反馈ID长度不能超过64个字符")
    @ApiModelProperty(value = "反馈ID", name = "id")
    @FieldRemark(column="ID", field="id", name="反馈ID")
    private java.lang.String id;

    /**
    * 实施计划ID
    */
    @Size(max = 64, message = "实施计划ID长度不能超过64个字符")
    @ApiModelProperty(value = "实施计划ID", name = "planId")
    @FieldRemark(column="PLAN_ID", field="planId", name="实施计划ID")
    private java.lang.String planId;

    /**
    * 实施计划名称
    */
    @ExcelProperty("实施计划名称")
    @Size(max = 256, message = "实施计划名称长度不能超过256个字符")
    @ApiModelProperty(value = "实施计划名称", name = "planName")
    @FieldRemark(column="PLAN_NAME", field="planName", name="实施计划名称")
    private java.lang.String planName;
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
    * 完成情况说明
    */
    @ExcelProperty("完成情况说明")
    @Size(max = 1000, message = "完成情况说明长度不能超过1000个字符")
    @ApiModelProperty(value = "完成情况说明", name = "feedbackContent")
    @FieldRemark(column="FEEDBACK_CONTENT", field="feedbackContent", name="完成情况说明")
    private java.lang.String feedbackContent;
    /**
    * 反馈时间
    */
    @ExcelProperty("反馈时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "反馈时间", name = "feedbackTime")
    @FieldRemark(column="FEEDBACK_TIME", field="feedbackTime", name="反馈时间")
    private java.util.Date feedbackTime;

    /**
    * 反馈时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date feedbackTimeBegin;

    /**
    * 反馈时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date feedbackTimeEnd;

    /**
    * 反馈人ID
    */
    @ExcelProperty("反馈人ID")
    @Size(max = 64, message = "反馈人ID长度不能超过64个字符")
    @ApiModelProperty(value = "反馈人ID", name = "feedbackUserId")
    @FieldRemark(column="FEEDBACK_USER_ID", field="feedbackUserId", name="反馈人ID")
    private java.lang.String feedbackUserId;

    /**
    * 反馈人CODE
    */
    @ExcelProperty("反馈人CODE")
    @Size(max = 10, message = "反馈人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "反馈人CODE", name = "feedbackUserCode")
    @FieldRemark(column="FEEDBACK_USER_CODE", field="feedbackUserCode", name="反馈人CODE")
    private java.lang.String feedbackUserCode;

    /**
    * 反馈人
    */
    @ExcelProperty("反馈人")
    @Size(max = 50, message = "反馈人长度不能超过50个字符")
    @ApiModelProperty(value = "反馈人", name = "feedbackUserName")
    @FieldRemark(column="FEEDBACK_USER_NAME", field="feedbackUserName", name="反馈人")
    private java.lang.String feedbackUserName;
    /**
    * 本次进度
    */
    @ExcelProperty("本次进度")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 2, fraction = 0, message = "本次进度格式不正确")
    @ApiModelProperty(value = "本次进度", name = "progress")
    @FieldRemark(column="PROGRESS", field="progress", name="本次进度")
    private java.math.BigDecimal progress;

    /**
    * 是否完成
    */
    @ExcelProperty("是否完成")
    @Size(max = 2, message = "是否完成长度不能超过2个字符")
    @ApiModelProperty(value = "是否完成", name = "ynFinish")
    @FieldRemark(column="YN_FINISH", field="ynFinish", name="是否完成")
    private java.lang.String ynFinish;

    /**
    * 存在问题
    */
    @ExcelProperty("存在问题")
    @Size(max = 1000, message = "存在问题长度不能超过1000个字符")
    @ApiModelProperty(value = "存在问题", name = "problemDesc")
    @FieldRemark(column="PROBLEM_DESC", field="problemDesc", name="存在问题")
    private java.lang.String problemDesc;

    /**
    * 下一步措施
    */
    @ExcelProperty("下一步措施")
    @Size(max = 1000, message = "下一步措施长度不能超过1000个字符")
    @ApiModelProperty(value = "下一步措施", name = "nextMeasure")
    @FieldRemark(column="NEXT_MEASURE", field="nextMeasure", name="下一步措施")
    private java.lang.String nextMeasure;

    /**
    * 是否存在风险
    */
    @ExcelProperty("是否存在风险")
    @Size(max = 2, message = "是否存在风险长度不能超过2个字符")
    @ApiModelProperty(value = "是否存在风险", name = "ynResk")
    @FieldRemark(column="YN_RESK", field="ynResk", name="是否存在风险")
    private java.lang.String ynResk;

    /**
    * 风险说明
    */
    @ExcelProperty("风险说明")
    @Size(max = 1000, message = "风险说明长度不能超过1000个字符")
    @ApiModelProperty(value = "风险说明", name = "riskDesc")
    @FieldRemark(column="RISK_DESC", field="riskDesc", name="风险说明")
    private java.lang.String riskDesc;

    /**
    * 审批状态
    */
    @ExcelProperty("审批状态")
    @Size(max = 10, message = "审批状态长度不能超过10个字符")
    @ApiModelProperty(value = "审批状态", name = "approvalStatus")
    @FieldRemark(column="APPROVAL_STATUS", field="approvalStatus", name="审批状态")
    private java.lang.String approvalStatus;

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

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getPlanId(){
        return planId;
    }

    public void setPlanId(java.lang.String planId){
        this.planId = planId;
    }

    public java.lang.String getPlanName(){
        return planName;
    }

    public void setPlanName(java.lang.String planName){
        this.planName = planName;
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

    public java.lang.String getFeedbackContent(){
        return feedbackContent;
    }

    public void setFeedbackContent(java.lang.String feedbackContent){
        this.feedbackContent = feedbackContent;
    }

    public java.util.Date getFeedbackTime(){
        return feedbackTime;
    }

    public void setFeedbackTime(java.util.Date feedbackTime){
        this.feedbackTime = feedbackTime;
        super.handleNullValue();
    }

    public java.util.Date getFeedbackTimeBegin(){
        return feedbackTimeBegin;
    }

    public void setFeedbackTimeBegin(java.util.Date feedbackTimeBegin){
        this.feedbackTimeBegin = feedbackTimeBegin;
    }

    public java.util.Date getFeedbackTimeEnd(){
        return feedbackTimeEnd;
    }

    public void setFeedbackTimeEnd(java.util.Date feedbackTimeEnd){
        this.feedbackTimeEnd = feedbackTimeEnd;
    }

    public java.lang.String getFeedbackUserId(){
        return feedbackUserId;
    }

    public void setFeedbackUserId(java.lang.String feedbackUserId){
        this.feedbackUserId = feedbackUserId;
    }

    public java.lang.String getFeedbackUserCode(){
        return feedbackUserCode;
    }

    public void setFeedbackUserCode(java.lang.String feedbackUserCode){
        this.feedbackUserCode = feedbackUserCode;
    }

    public java.lang.String getFeedbackUserName(){
        return feedbackUserName;
    }

    public void setFeedbackUserName(java.lang.String feedbackUserName){
        this.feedbackUserName = feedbackUserName;
    }

    public java.math.BigDecimal getProgress(){
        return progress;
    }

    public void setProgress(java.math.BigDecimal progress){
        this.progress = progress;
        super.handleNullValue();
    }

    public java.lang.String getYnFinish(){
        return ynFinish;
    }

    public void setYnFinish(java.lang.String ynFinish){
        this.ynFinish = ynFinish;
    }

    public java.lang.String getProblemDesc(){
        return problemDesc;
    }

    public void setProblemDesc(java.lang.String problemDesc){
        this.problemDesc = problemDesc;
    }

    public java.lang.String getNextMeasure(){
        return nextMeasure;
    }

    public void setNextMeasure(java.lang.String nextMeasure){
        this.nextMeasure = nextMeasure;
    }

    public java.lang.String getYnResk(){
        return ynResk;
    }

    public void setYnResk(java.lang.String ynResk){
        this.ynResk = ynResk;
    }

    public java.lang.String getRiskDesc(){
        return riskDesc;
    }

    public void setRiskDesc(java.lang.String riskDesc){
        this.riskDesc = riskDesc;
    }

    public java.lang.String getApprovalStatus(){
        return approvalStatus;
    }

    public void setApprovalStatus(java.lang.String approvalStatus){
        this.approvalStatus = approvalStatus;
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
            return "通用执行反馈表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "通用执行反馈表";
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
