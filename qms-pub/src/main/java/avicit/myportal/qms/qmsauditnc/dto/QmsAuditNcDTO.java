package avicit.myportal.qms.qmsauditnc.dto;

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
* @创建时间： 2026-08-28 16:14
* @类说明：不符合项表DTO
* @修改记录：
*/
@ApiModel(value = "QmsAuditNcDTO", description = "不符合项表")
@PojoRemark(table="QMS_AUDIT_NC", object="QmsAuditNcDTO", name="不符合项表")
@ExcelIgnoreUnannotated
public class QmsAuditNcDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 不符合项ID
    */
    @Id
    @Size(max = 64, message = "不符合项ID长度不能超过64个字符")
    @ApiModelProperty(value = "不符合项ID", name = "id")
    @FieldRemark(column="ID", field="id", name="不符合项ID")
    private java.lang.String id;

    /**
    * 不符合项编号
    */
    @ExcelProperty("不符合项编号")
    @Size(max = 50, message = "不符合项编号长度不能超过50个字符")
    @ApiModelProperty(value = "不符合项编号", name = "ncCode")
    @FieldRemark(column="NC_CODE", field="ncCode", name="不符合项编号")
    private java.lang.String ncCode;

    /**
    * 审核记录ID
    */
    @ExcelProperty("审核记录ID")
    @Size(max = 64, message = "审核记录ID长度不能超过64个字符")
    @ApiModelProperty(value = "审核记录ID", name = "recordId")
    @FieldRemark(column="RECORD_ID", field="recordId", name="审核记录ID")
    private java.lang.String recordId;

    /**
    * 审核计划ID;关联年度计划
    */
    @ExcelProperty("审核计划ID;关联年度计划")
    @Size(max = 64, message = "审核计划ID;关联年度计划长度不能超过64个字符")
    @ApiModelProperty(value = "审核计划ID;关联年度计划", name = "planId")
    @FieldRemark(column="PLAN_ID", field="planId", name="审核计划ID;关联年度计划")
    private java.lang.String planId;

    /**
    * 审核通知单ID;关联已批准通知单
    */
    @ExcelProperty("审核通知单ID;关联已批准通知单")
    @Size(max = 64, message = "审核通知单ID;关联已批准通知单长度不能超过64个字符")
    @ApiModelProperty(value = "审核通知单ID;关联已批准通知单", name = "noticeId")
    @FieldRemark(column="NOTICE_ID", field="noticeId", name="审核通知单ID;关联已批准通知单")
    private java.lang.String noticeId;

    /**
    * 检查明细ID
    */
    @ExcelProperty("检查明细ID")
    @Size(max = 64, message = "检查明细ID长度不能超过64个字符")
    @ApiModelProperty(value = "检查明细ID", name = "detailId")
    @FieldRemark(column="DETAIL_ID", field="detailId", name="检查明细ID")
    private java.lang.String detailId;

    /**
    * 受审部门ID;通知单带入
    */
    @ExcelProperty("受审部门ID;通知单带入")
    @Size(max = 64, message = "受审部门ID;通知单带入长度不能超过64个字符")
    @ApiModelProperty(value = "受审部门ID;通知单带入", name = "auditeeDeptId")
    @FieldRemark(column="AUDITEE_DEPT_ID", field="auditeeDeptId", name="受审部门ID;通知单带入")
    private java.lang.String auditeeDeptId;

    /**
    * 受审部门CODE;通知单带入
    */
    @ExcelProperty("受审部门CODE;通知单带入")
    @Size(max = 10, message = "受审部门CODE;通知单带入长度不能超过10个字符")
    @ApiModelProperty(value = "受审部门CODE;通知单带入", name = "auditeeDeptCode")
    @FieldRemark(column="AUDITEE_DEPT_CODE", field="auditeeDeptCode", name="受审部门CODE;通知单带入")
    private java.lang.String auditeeDeptCode;

    /**
    * 受审部门;通知单带入
    */
    @ExcelProperty("受审部门;通知单带入")
    @Size(max = 50, message = "受审部门;通知单带入长度不能超过50个字符")
    @ApiModelProperty(value = "受审部门;通知单带入", name = "auditeeDeptName")
    @FieldRemark(column="AUDITEE_DEPT_NAME", field="auditeeDeptName", name="受审部门;通知单带入")
    private java.lang.String auditeeDeptName;

    /**
    * 审核依据的标准和文件;主审填写
    */
    @ExcelProperty("审核依据的标准和文件;主审填写")
    @Size(max = 512, message = "审核依据的标准和文件;主审填写长度不能超过512个字符")
    @ApiModelProperty(value = "审核依据的标准和文件;主审填写", name = "auditBasis")
    @FieldRemark(column="AUDIT_BASIS", field="auditBasis", name="审核依据的标准和文件;主审填写")
    private java.lang.String auditBasis;
    /**
    * 审核时间;通知单带入
    */
    @ExcelProperty("审核时间;通知单带入")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "审核时间;通知单带入", name = "auditTime")
    @FieldRemark(column="AUDIT_TIME", field="auditTime", name="审核时间;通知单带入")
    private java.util.Date auditTime;

    /**
    * 审核时间;通知单带入起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date auditTimeBegin;

    /**
    * 审核时间;通知单带入止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date auditTimeEnd;

    /**
    * 受审方人员ID;通知单带入
    */
    @ExcelProperty("受审方人员ID;通知单带入")
    @Size(max = 512, message = "受审方人员ID;通知单带入长度不能超过512个字符")
    @ApiModelProperty(value = "受审方人员ID;通知单带入", name = "auditeeUserId")
    @FieldRemark(column="AUDITEE_USER_ID", field="auditeeUserId", name="受审方人员ID;通知单带入")
    private java.lang.String auditeeUserId;

    /**
    * 受审方人员CODE;通知单带入
    */
    @ExcelProperty("受审方人员CODE;通知单带入")
    @Size(max = 200, message = "受审方人员CODE;通知单带入长度不能超过200个字符")
    @ApiModelProperty(value = "受审方人员CODE;通知单带入", name = "auditeeUserCode")
    @FieldRemark(column="AUDITEE_USER_CODE", field="auditeeUserCode", name="受审方人员CODE;通知单带入")
    private java.lang.String auditeeUserCode;

    /**
    * 受审方人员;通知单带入
    */
    @ExcelProperty("受审方人员;通知单带入")
    @Size(max = 200, message = "受审方人员;通知单带入长度不能超过200个字符")
    @ApiModelProperty(value = "受审方人员;通知单带入", name = "auditeeUserName")
    @FieldRemark(column="AUDITEE_USER_NAME", field="auditeeUserName", name="受审方人员;通知单带入")
    private java.lang.String auditeeUserName;

    /**
    * 不符合程度;一般、严重
    */
    @ExcelProperty("不符合程度;一般、严重")
    @Size(max = 4, message = "不符合程度;一般、严重长度不能超过4个字符")
    @ApiModelProperty(value = "不符合程度;一般、严重", name = "ncLevel")
    @FieldRemark(column="NC_LEVEL", field="ncLevel", name="不符合程度;一般、严重")
    private java.lang.String ncLevel;

    /**
    * 不符合标准条款号
    */
    @ExcelProperty("不符合标准条款号")
    @Size(max = 50, message = "不符合标准条款号长度不能超过50个字符")
    @ApiModelProperty(value = "不符合标准条款号", name = "standardClauseNo")
    @FieldRemark(column="STANDARD_CLAUSE_NO", field="standardClauseNo", name="不符合标准条款号")
    private java.lang.String standardClauseNo;

    /**
    * 不符合项实施描述
    */
    @ExcelProperty("不符合项实施描述")
    @Size(max = 2000, message = "不符合项实施描述长度不能超过2000个字符")
    @ApiModelProperty(value = "不符合项实施描述", name = "ncFactDesc")
    @FieldRemark(column="NC_FACT_DESC", field="ncFactDesc", name="不符合项实施描述")
    private java.lang.String ncFactDesc;

    /**
    * 整改处理人ID
    */
    @ExcelProperty("整改处理人ID")
    @Size(max = 500, message = "整改处理人ID长度不能超过500个字符")
    @ApiModelProperty(value = "整改处理人ID", name = "rectifyHandlerId")
    @FieldRemark(column="RECTIFY_HANDLER_ID", field="rectifyHandlerId", name="整改处理人ID")
    private java.lang.String rectifyHandlerId;

    /**
    * 整改处理人CODE
    */
    @ExcelProperty("整改处理人CODE")
    @Size(max = 256, message = "整改处理人CODE长度不能超过256个字符")
    @ApiModelProperty(value = "整改处理人CODE", name = "rectifyHandlerCode")
    @FieldRemark(column="RECTIFY_HANDLER_CODE", field="rectifyHandlerCode", name="整改处理人CODE")
    private java.lang.String rectifyHandlerCode;

    /**
    * 整改处理人
    */
    @ExcelProperty("整改处理人")
    @Size(max = 256, message = "整改处理人长度不能超过256个字符")
    @ApiModelProperty(value = "整改处理人", name = "rectifyHandlerName")
    @FieldRemark(column="RECTIFY_HANDLER_NAME", field="rectifyHandlerName", name="整改处理人")
    private java.lang.String rectifyHandlerName;

    /**
    * 行动项ID
    */
    @ExcelProperty("行动项ID")
    @Size(max = 64, message = "行动项ID长度不能超过64个字符")
    @ApiModelProperty(value = "行动项ID", name = "actionId")
    @FieldRemark(column="ACTION_ID", field="actionId", name="行动项ID")
    private java.lang.String actionId;

    /**
    * 业务状态;草稿、审批中、整改中、已关闭等
    */
    @ExcelProperty("业务状态;草稿、审批中、整改中、已关闭等")
    @Size(max = 10, message = "业务状态;草稿、审批中、整改中、已关闭等长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态;草稿、审批中、整改中、已关闭等", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态;草稿、审批中、整改中、已关闭等")
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
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    @ApiModelProperty(value = "交付物", name = "expectedDeliverable")
    @FieldRemark(column="EXPECTED_DELIVERABLE", field="expectedDeliverable", name="交付物")
    private java.lang.String expectedDeliverable;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getNcCode(){
        return ncCode;
    }

    public void setNcCode(java.lang.String ncCode){
        this.ncCode = ncCode;
    }

    public java.lang.String getRecordId(){
        return recordId;
    }

    public void setRecordId(java.lang.String recordId){
        this.recordId = recordId;
    }

    public java.lang.String getPlanId(){
        return planId;
    }

    public void setPlanId(java.lang.String planId){
        this.planId = planId;
    }

    public java.lang.String getNoticeId(){
        return noticeId;
    }

    public void setNoticeId(java.lang.String noticeId){
        this.noticeId = noticeId;
    }

    public java.lang.String getDetailId(){
        return detailId;
    }

    public void setDetailId(java.lang.String detailId){
        this.detailId = detailId;
    }

    public java.lang.String getAuditeeDeptId(){
        return auditeeDeptId;
    }

    public void setAuditeeDeptId(java.lang.String auditeeDeptId){
        this.auditeeDeptId = auditeeDeptId;
    }

    public java.lang.String getAuditeeDeptCode(){
        return auditeeDeptCode;
    }

    public void setAuditeeDeptCode(java.lang.String auditeeDeptCode){
        this.auditeeDeptCode = auditeeDeptCode;
    }

    public java.lang.String getAuditeeDeptName(){
        return auditeeDeptName;
    }

    public void setAuditeeDeptName(java.lang.String auditeeDeptName){
        this.auditeeDeptName = auditeeDeptName;
    }

    public java.lang.String getAuditBasis(){
        return auditBasis;
    }

    public void setAuditBasis(java.lang.String auditBasis){
        this.auditBasis = auditBasis;
    }

    public java.util.Date getAuditTime(){
        return auditTime;
    }

    public void setAuditTime(java.util.Date auditTime){
        this.auditTime = auditTime;
        super.handleNullValue();
    }

    public java.util.Date getAuditTimeBegin(){
        return auditTimeBegin;
    }

    public void setAuditTimeBegin(java.util.Date auditTimeBegin){
        this.auditTimeBegin = auditTimeBegin;
    }

    public java.util.Date getAuditTimeEnd(){
        return auditTimeEnd;
    }

    public void setAuditTimeEnd(java.util.Date auditTimeEnd){
        this.auditTimeEnd = auditTimeEnd;
    }

    public java.lang.String getAuditeeUserId(){
        return auditeeUserId;
    }

    public void setAuditeeUserId(java.lang.String auditeeUserId){
        this.auditeeUserId = auditeeUserId;
    }

    public java.lang.String getAuditeeUserCode(){
        return auditeeUserCode;
    }

    public void setAuditeeUserCode(java.lang.String auditeeUserCode){
        this.auditeeUserCode = auditeeUserCode;
    }

    public java.lang.String getAuditeeUserName(){
        return auditeeUserName;
    }

    public void setAuditeeUserName(java.lang.String auditeeUserName){
        this.auditeeUserName = auditeeUserName;
    }

    public java.lang.String getNcLevel(){
        return ncLevel;
    }

    public void setNcLevel(java.lang.String ncLevel){
        this.ncLevel = ncLevel;
    }

    public java.lang.String getStandardClauseNo(){
        return standardClauseNo;
    }

    public void setStandardClauseNo(java.lang.String standardClauseNo){
        this.standardClauseNo = standardClauseNo;
    }

    public java.lang.String getNcFactDesc(){
        return ncFactDesc;
    }

    public void setNcFactDesc(java.lang.String ncFactDesc){
        this.ncFactDesc = ncFactDesc;
    }

    public java.lang.String getRectifyHandlerId(){
        return rectifyHandlerId;
    }

    public void setRectifyHandlerId(java.lang.String rectifyHandlerId){
        this.rectifyHandlerId = rectifyHandlerId;
    }

    public java.lang.String getRectifyHandlerCode(){
        return rectifyHandlerCode;
    }

    public void setRectifyHandlerCode(java.lang.String rectifyHandlerCode){
        this.rectifyHandlerCode = rectifyHandlerCode;
    }

    public java.lang.String getRectifyHandlerName(){
        return rectifyHandlerName;
    }

    public void setRectifyHandlerName(java.lang.String rectifyHandlerName){
        this.rectifyHandlerName = rectifyHandlerName;
    }

    public java.lang.String getActionId(){
        return actionId;
    }

    public void setActionId(java.lang.String actionId){
        this.actionId = actionId;
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

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "不符合项表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "不符合项表";
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
