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
* @创建时间： 2026-08-20 14:10
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
    private String id;
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
    private String feedbackContent;
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
    private String feedbackUserId;

    /**
    * 反馈人CODE
    */
    @ExcelProperty("反馈人CODE")
    @Size(max = 10, message = "反馈人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "反馈人CODE", name = "feedbackUserCode")
    @FieldRemark(column="FEEDBACK_USER_CODE", field="feedbackUserCode", name="反馈人CODE")
    private String feedbackUserCode;

    /**
    * 反馈人
    */
    @ExcelProperty("反馈人")
    @Size(max = 50, message = "反馈人长度不能超过50个字符")
    @ApiModelProperty(value = "反馈人", name = "feedbackUserName")
    @FieldRemark(column="FEEDBACK_USER_NAME", field="feedbackUserName", name="反馈人")
    private String feedbackUserName;
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
    private String ynFinish;

    /**
    * 存在问题
    */
    @ExcelProperty("存在问题")
    @Size(max = 1000, message = "存在问题长度不能超过1000个字符")
    @ApiModelProperty(value = "存在问题", name = "problemDesc")
    @FieldRemark(column="PROBLEM_DESC", field="problemDesc", name="存在问题")
    private String problemDesc;

    /**
    * 下一步措施
    */
    @ExcelProperty("下一步措施")
    @Size(max = 1000, message = "下一步措施长度不能超过1000个字符")
    @ApiModelProperty(value = "下一步措施", name = "nextMeasure")
    @FieldRemark(column="NEXT_MEASURE", field="nextMeasure", name="下一步措施")
    private String nextMeasure;

    /**
    * 是否存在风险
    */
    @ExcelProperty("是否存在风险")
    @Size(max = 2, message = "是否存在风险长度不能超过2个字符")
    @ApiModelProperty(value = "是否存在风险", name = "ynRisk")
    @FieldRemark(column="YN_RISK", field="ynRisk", name="是否存在风险")
    private String ynRisk;

    /**
    * 风险说明
    */
    @ExcelProperty("风险说明")
    @Size(max = 1000, message = "风险说明长度不能超过1000个字符")
    @ApiModelProperty(value = "风险说明", name = "riskDesc")
    @FieldRemark(column="RISK_DESC", field="riskDesc", name="风险说明")
    private String riskDesc;

    /**
    * 审批状态
    */
    @ExcelProperty("审批状态")
    @Size(max = 10, message = "审批状态长度不能超过10个字符")
    @ApiModelProperty(value = "审批状态", name = "approvalStatus")
    @FieldRemark(column="APPROVAL_STATUS", field="approvalStatus", name="审批状态")
    private String approvalStatus;

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
    private String secretLevel;
    @ExcelProperty("密级")
    private String secretLevelName;

    /**
    * 是否已删除
    */
    @ExcelProperty("是否已删除")
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private String ynDeleted;

    /**
    * 备注
    */
    @ExcelProperty("备注")
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private String remark;
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
    private String attribute01;

    /**
    * 扩展字段_02
    */
    @Size(max = 512, message = "扩展字段_02长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_02", name = "attribute02")
    @FieldRemark(column="ATTRIBUTE_02", field="attribute02", name="扩展字段_02")
    private String attribute02;

    /**
    * 扩展字段_03
    */
    @Size(max = 512, message = "扩展字段_03长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_03", name = "attribute03")
    @FieldRemark(column="ATTRIBUTE_03", field="attribute03", name="扩展字段_03")
    private String attribute03;

    /**
    * 扩展字段_04
    */
    @Size(max = 512, message = "扩展字段_04长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_04", name = "attribute04")
    @FieldRemark(column="ATTRIBUTE_04", field="attribute04", name="扩展字段_04")
    private String attribute04;

    /**
    * 扩展字段_05
    */
    @Size(max = 512, message = "扩展字段_05长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_05", name = "attribute05")
    @FieldRemark(column="ATTRIBUTE_05", field="attribute05", name="扩展字段_05")
    private String attribute05;

    /**
    * 扩展字段_06
    */
    @Size(max = 512, message = "扩展字段_06长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_06", name = "attribute06")
    @FieldRemark(column="ATTRIBUTE_06", field="attribute06", name="扩展字段_06")
    private String attribute06;

    /**
    * 扩展字段_07
    */
    @Size(max = 512, message = "扩展字段_07长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_07", name = "attribute07")
    @FieldRemark(column="ATTRIBUTE_07", field="attribute07", name="扩展字段_07")
    private String attribute07;

    /**
    * 扩展字段_08
    */
    @Size(max = 512, message = "扩展字段_08长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_08", name = "attribute08")
    @FieldRemark(column="ATTRIBUTE_08", field="attribute08", name="扩展字段_08")
    private String attribute08;

    /**
    * 扩展字段_09
    */
    @Size(max = 512, message = "扩展字段_09长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_09", name = "attribute09")
    @FieldRemark(column="ATTRIBUTE_09", field="attribute09", name="扩展字段_09")
    private String attribute09;

    /**
    * 扩展字段_10
    */
    @Size(max = 512, message = "扩展字段_10长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_10", name = "attribute10")
    @FieldRemark(column="ATTRIBUTE_10", field="attribute10", name="扩展字段_10")
    private String attribute10;

    /**
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private String parentId;

    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    @ApiModelProperty(value = "全路径", name = "treePath")
    @FieldRemark(column="TREE_PATH", field="treePath", name="全路径")
    private String treePath;
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
    // @NotNull(message = "本级排序不能为空")
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
    private String treeSorts;

    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    @ApiModelProperty(value = "是否叶子节点", name = "treeLeaf")
    @FieldRemark(column="TREE_LEAF", field="treeLeaf", name="是否叶子节点")
    private String treeLeaf;

    /**
    * 实施计划ID
    */
    @Size(max = 64, message = "实施计划ID长度不能超过64个字符")
    @ApiModelProperty(value = "实施计划ID", name = "sourceId")
    @FieldRemark(column="SOURCE_ID", field="sourceId", name="实施计划ID")
    private String sourceId;

    /**
    * 实施计划名称
    */
    @ExcelProperty("实施计划名称")
    @Size(max = 256, message = "实施计划名称长度不能超过256个字符")
    @ApiModelProperty(value = "实施计划名称", name = "sourceName")
    @FieldRemark(column="SOURCE_NAME", field="sourceName", name="实施计划名称")
    private String sourceName;

    /**
    * 来源类型
    */
    @ExcelProperty("来源类型")
    @Size(max = 256, message = "来源类型长度不能超过256个字符")
    @ApiModelProperty(value = "来源类型", name = "sourceType")
    @FieldRemark(column="SOURCE_TYPE", field="sourceType", name="来源类型")
    private String sourceType;

    /**
    * 来源表
    */
    @ExcelProperty("来源表")
    @Size(max = 128, message = "来源表长度不能超过128个字符")
    @ApiModelProperty(value = "来源表", name = "sourceTable")
    @FieldRemark(column="SOURCE_TABLE", field="sourceTable", name="来源表")
    private String sourceTable;
    /**
     * 子表操作类型：insert-新增(可省略), update-更新, delete-删除
     */
    private String operationType_;

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

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public String getFeedbackContent(){
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent){
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

    public String getFeedbackUserId(){
        return feedbackUserId;
    }

    public void setFeedbackUserId(String feedbackUserId){
        this.feedbackUserId = feedbackUserId;
    }

    public String getFeedbackUserCode(){
        return feedbackUserCode;
    }

    public void setFeedbackUserCode(String feedbackUserCode){
        this.feedbackUserCode = feedbackUserCode;
    }

    public String getFeedbackUserName(){
        return feedbackUserName;
    }

    public void setFeedbackUserName(String feedbackUserName){
        this.feedbackUserName = feedbackUserName;
    }

    public java.math.BigDecimal getProgress(){
        return progress;
    }

    public void setProgress(java.math.BigDecimal progress){
        this.progress = progress;
        super.handleNullValue();
    }

    public String getYnFinish(){
        return ynFinish;
    }

    public void setYnFinish(String ynFinish){
        this.ynFinish = ynFinish;
    }

    public String getProblemDesc(){
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc){
        this.problemDesc = problemDesc;
    }

    public String getNextMeasure(){
        return nextMeasure;
    }

    public void setNextMeasure(String nextMeasure){
        this.nextMeasure = nextMeasure;
    }

    public String getYnRisk(){
        return ynRisk;
    }

    public void setYnRisk(String ynRisk){
        this.ynRisk = ynRisk;
    }

    public String getRiskDesc(){
        return riskDesc;
    }

    public void setRiskDesc(String riskDesc){
        this.riskDesc = riskDesc;
    }

    public String getApprovalStatus(){
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus){
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
    public String getSecretLevel(){
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel){
        this.secretLevel = secretLevel;
    }

    public String getSecretLevelName(){
        return secretLevelName;
    }

    public void setSecretLevelName(String secretLevelName){
        this.secretLevelName = secretLevelName;
    }

    public String getYnDeleted(){
        return ynDeleted;
    }

    public void setYnDeleted(String ynDeleted){
        this.ynDeleted = ynDeleted;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public java.math.BigDecimal getOrderBy(){
        return orderBy;
    }

    public void setOrderBy(java.math.BigDecimal orderBy){
        this.orderBy = orderBy;
        super.handleNullValue();
    }

    public String getAttribute01(){
        return attribute01;
    }

    public void setAttribute01(String attribute01){
        this.attribute01 = attribute01;
    }

    public String getAttribute02(){
        return attribute02;
    }

    public void setAttribute02(String attribute02){
        this.attribute02 = attribute02;
    }

    public String getAttribute03(){
        return attribute03;
    }

    public void setAttribute03(String attribute03){
        this.attribute03 = attribute03;
    }

    public String getAttribute04(){
        return attribute04;
    }

    public void setAttribute04(String attribute04){
        this.attribute04 = attribute04;
    }

    public String getAttribute05(){
        return attribute05;
    }

    public void setAttribute05(String attribute05){
        this.attribute05 = attribute05;
    }

    public String getAttribute06(){
        return attribute06;
    }

    public void setAttribute06(String attribute06){
        this.attribute06 = attribute06;
    }

    public String getAttribute07(){
        return attribute07;
    }

    public void setAttribute07(String attribute07){
        this.attribute07 = attribute07;
    }

    public String getAttribute08(){
        return attribute08;
    }

    public void setAttribute08(String attribute08){
        this.attribute08 = attribute08;
    }

    public String getAttribute09(){
        return attribute09;
    }

    public void setAttribute09(String attribute09){
        this.attribute09 = attribute09;
    }

    public String getAttribute10(){
        return attribute10;
    }

    public void setAttribute10(String attribute10){
        this.attribute10 = attribute10;
    }

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getTreePath(){
        return treePath;
    }

    public void setTreePath(String treePath){
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

    public String getTreeSorts(){
        return treeSorts;
    }

    public void setTreeSorts(String treeSorts){
        this.treeSorts = treeSorts;
    }

    public String getTreeLeaf(){
        return treeLeaf;
    }

    public void setTreeLeaf(String treeLeaf){
        this.treeLeaf = treeLeaf;
    }

    public String getSourceId(){
        return sourceId;
    }

    public void setSourceId(String sourceId){
        this.sourceId = sourceId;
    }

    public String getSourceName(){
        return sourceName;
    }

    public void setSourceName(String sourceName){
        this.sourceName = sourceName;
    }

    public String getSourceType(){
        return sourceType;
    }

    public void setSourceType(String sourceType){
        this.sourceType = sourceType;
    }

    public String getSourceTable(){
        return sourceTable;
    }

    public void setSourceTable(String sourceTable){
        this.sourceTable = sourceTable;
    }

    public String getOperationType_() {
        return operationType_;
    }

    public void setOperationType_(String operationType_) {
        this.operationType_ = operationType_;
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
