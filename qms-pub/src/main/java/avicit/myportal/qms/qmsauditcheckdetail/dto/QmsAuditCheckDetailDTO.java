package avicit.myportal.qms.qmsauditcheckdetail.dto;

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
* @创建时间： 2026-08-03 19:32
* @类说明：审核检查明细表DTO
* @修改记录：
*/
@ApiModel(value = "QmsAuditCheckDetailDTO", description = "审核检查明细表")
@PojoRemark(table="QMS_AUDIT_CHECK_DETAIL", object="QmsAuditCheckDetailDTO", name="审核检查明细表")
@ExcelIgnoreUnannotated
public class QmsAuditCheckDetailDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 检查明细ID
    */
    @Id
    @Size(max = 64, message = "检查明细ID长度不能超过64个字符")
    @ApiModelProperty(value = "检查明细ID", name = "id")
    @FieldRemark(column="ID", field="id", name="检查明细ID")
    private java.lang.String id;

    /**
    * 审核记录ID
    */
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
    * 序号;系统生成
    */
    @ExcelProperty("序号;系统生成")
    @Size(max = 50, message = "序号;系统生成长度不能超过50个字符")
    @ApiModelProperty(value = "序号;系统生成", name = "sequenceCode")
    @FieldRemark(column="SEQUENCE_CODE", field="sequenceCode", name="序号;系统生成")
    private java.lang.String sequenceCode;

    /**
    * 条款号
    */
    @ExcelProperty("条款号")
    @Size(max = 512, message = "条款号长度不能超过512个字符")
    @ApiModelProperty(value = "条款号", name = "clauseNo")
    @FieldRemark(column="CLAUSE_NO", field="clauseNo", name="条款号")
    private java.lang.String clauseNo;

    /**
    * 条款内容
    */
    @ExcelProperty("条款内容")
    @Size(max = 512, message = "条款内容长度不能超过512个字符")
    @ApiModelProperty(value = "条款内容", name = "clauseContent")
    @FieldRemark(column="CLAUSE_CONTENT", field="clauseContent", name="条款内容")
    private java.lang.String clauseContent;

    /**
    * 审核员ID
    */
    @ExcelProperty("审核员ID")
    @Size(max = 512, message = "审核员ID长度不能超过512个字符")
    @ApiModelProperty(value = "审核员ID", name = "auditorId")
    @FieldRemark(column="AUDITOR_ID", field="auditorId", name="审核员ID")
    private java.lang.String auditorId;

    /**
    * 审核员CODE
    */
    @ExcelProperty("审核员CODE")
    @Size(max = 200, message = "审核员CODE长度不能超过200个字符")
    @ApiModelProperty(value = "审核员CODE", name = "auditorCode")
    @FieldRemark(column="AUDITOR_CODE", field="auditorCode", name="审核员CODE")
    private java.lang.String auditorCode;

    /**
    * 审核员
    */
    @ExcelProperty("审核员")
    @Size(max = 200, message = "审核员长度不能超过200个字符")
    @ApiModelProperty(value = "审核员", name = "auditorName")
    @FieldRemark(column="AUDITOR_NAME", field="auditorName", name="审核员")
    private java.lang.String auditorName;

    /**
    * 检查内容
    */
    @ExcelProperty("检查内容")
    @Size(max = 512, message = "检查内容长度不能超过512个字符")
    @ApiModelProperty(value = "检查内容", name = "checkContent")
    @FieldRemark(column="CHECK_CONTENT", field="checkContent", name="检查内容")
    private java.lang.String checkContent;

    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 512, message = "型号长度不能超过512个字符")
    @ApiModelProperty(value = "型号", name = "checkModel")
    @FieldRemark(column="CHECK_MODEL", field="checkModel", name="型号")
    private java.lang.String checkModel;

    /**
    * 检查记录
    */
    @ExcelProperty("检查记录")
    @Size(max = 512, message = "检查记录长度不能超过512个字符")
    @ApiModelProperty(value = "检查记录", name = "checkRecord")
    @FieldRemark(column="CHECK_RECORD", field="checkRecord", name="检查记录")
    private java.lang.String checkRecord;

    /**
    * 符合情况;符合：无建议;符合：有建议;不符合;（三选一）
    */
    @ExcelProperty("符合情况;符合：无建议;符合：有建议;不符合;（三选一）")
    @Size(max = 10, message = "符合情况;符合：无建议;符合：有建议;不符合;（三选一）长度不能超过10个字符")
    @ApiModelProperty(value = "符合情况;符合：无建议;符合：有建议;不符合;（三选一）", name = "conformityResult")
    @FieldRemark(column="CONFORMITY_RESULT", field="conformityResult", name="符合情况;符合：无建议;符合：有建议;不符合;（三选一）")
    private java.lang.String conformityResult;

    /**
    * 建议内容;符合：有建议时必填
    */
    @ExcelProperty("建议内容;符合：有建议时必填")
    @Size(max = 512, message = "建议内容;符合：有建议时必填长度不能超过512个字符")
    @ApiModelProperty(value = "建议内容;符合：有建议时必填", name = "adviceContent")
    @FieldRemark(column="ADVICE_CONTENT", field="adviceContent", name="建议内容;符合：有建议时必填")
    private java.lang.String adviceContent;

    /**
    * 明细状态;草稿、有效、已生成不符合项
    */
    @ExcelProperty("明细状态;草稿、有效、已生成不符合项")
    @Size(max = 10, message = "明细状态;草稿、有效、已生成不符合项长度不能超过10个字符")
    @ApiModelProperty(value = "明细状态;草稿、有效、已生成不符合项", name = "status")
    @FieldRemark(column="STATUS", field="status", name="明细状态;草稿、有效、已生成不符合项")
    private java.lang.String status;

    /**
    * 是否不符合
    */
    @ExcelProperty("是否不符合")
    @Size(max = 2, message = "是否不符合长度不能超过2个字符")
    @ApiModelProperty(value = "是否不符合", name = "ynNc")
    @FieldRemark(column="YN_NC", field="ynNc", name="是否不符合")
    private java.lang.String ynNc;

    /**
    * 不符合ID
    */
    @ExcelProperty("不符合ID")
    @Size(max = 64, message = "不符合ID长度不能超过64个字符")
    @ApiModelProperty(value = "不符合ID", name = "ncId")
    @FieldRemark(column="NC_ID", field="ncId", name="不符合ID")
    private java.lang.String ncId;

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
     * 子表操作类型：insert-新增(可省略), update-更新, delete-删除
     */
    private String operationType_;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
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

    public java.lang.String getSequenceCode(){
        return sequenceCode;
    }

    public void setSequenceCode(java.lang.String sequenceCode){
        this.sequenceCode = sequenceCode;
    }

    public java.lang.String getClauseNo(){
        return clauseNo;
    }

    public void setClauseNo(java.lang.String clauseNo){
        this.clauseNo = clauseNo;
    }

    public java.lang.String getClauseContent(){
        return clauseContent;
    }

    public void setClauseContent(java.lang.String clauseContent){
        this.clauseContent = clauseContent;
    }

    public java.lang.String getAuditorId(){
        return auditorId;
    }

    public void setAuditorId(java.lang.String auditorId){
        this.auditorId = auditorId;
    }

    public java.lang.String getAuditorCode(){
        return auditorCode;
    }

    public void setAuditorCode(java.lang.String auditorCode){
        this.auditorCode = auditorCode;
    }

    public java.lang.String getAuditorName(){
        return auditorName;
    }

    public void setAuditorName(java.lang.String auditorName){
        this.auditorName = auditorName;
    }

    public java.lang.String getCheckContent(){
        return checkContent;
    }

    public void setCheckContent(java.lang.String checkContent){
        this.checkContent = checkContent;
    }

    public java.lang.String getCheckModel(){
        return checkModel;
    }

    public void setCheckModel(java.lang.String checkModel){
        this.checkModel = checkModel;
    }

    public java.lang.String getCheckRecord(){
        return checkRecord;
    }

    public void setCheckRecord(java.lang.String checkRecord){
        this.checkRecord = checkRecord;
    }

    public java.lang.String getConformityResult(){
        return conformityResult;
    }

    public void setConformityResult(java.lang.String conformityResult){
        this.conformityResult = conformityResult;
    }

    public java.lang.String getAdviceContent(){
        return adviceContent;
    }

    public void setAdviceContent(java.lang.String adviceContent){
        this.adviceContent = adviceContent;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getYnNc(){
        return ynNc;
    }

    public void setYnNc(java.lang.String ynNc){
        this.ynNc = ynNc;
    }

    public java.lang.String getNcId(){
        return ncId;
    }

    public void setNcId(java.lang.String ncId){
        this.ncId = ncId;
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

    public String getOperationType_() {
        return operationType_;
    }

    public void setOperationType_(String operationType_) {
        this.operationType_ = operationType_;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "审核检查明细表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "审核检查明细表";
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
