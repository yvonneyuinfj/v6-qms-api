package avicit.myportal.qms.qmsauditplan.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BaseTreeDTO;
import avicit.platform6.core.properties.PlatformConstant;
import avicit.platform6.commons.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:28
* @类说明：年度内审计划及执行主表Dto
* @修改记录：
*/
@ApiModel(value = "QmsAuditPlanDTO", description = "年度内审计划及执行主表")
@PojoRemark(table="QMS_AUDIT_PLAN", object="QmsAuditPlanDTO", name="年度内审计划及执行主表")
public class QmsAuditPlanDTO extends BaseTreeDTO {
    private static final long serialVersionUID = 1L;

    private List<QmsAuditPlanDTO> children;

    /**
    * ID
    */
    @Id
    @Size(max = 64, message = "ID长度不能超过64个字符")
    @ApiModelProperty(value = "ID", name = "id")
    @FieldRemark(column="ID", field="id", name="ID")
    private java.lang.String id;

    /**
    * 审核计划计划编号
    */
    @Size(max = 50, message = "审核计划计划编号长度不能超过50个字符")
    @ApiModelProperty(value = "审核计划计划编号", name = "planCode")
    @FieldRemark(column="PLAN_CODE", field="planCode", name="审核计划计划编号")
    private java.lang.String planCode;

    /**
    * 审核活动名称
    */
    @NotBlank(message = "审核活动名称不能为空")
    @Size(max = 128, message = "审核活动名称长度不能超过128个字符")
    @ApiModelProperty(value = "审核活动名称", name = "planName")
    @FieldRemark(column="PLAN_NAME", field="planName", name="审核活动名称")
    private java.lang.String planName;

    /**
    * 年度
    */
    @Size(max = 10, message = "年度长度不能超过10个字符")
    @ApiModelProperty(value = "年度", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="年度")
    private java.lang.String forYear;

    /**
    * 责任部门ID
    */
    @Size(max = 2000, message = "责任部门ID长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门ID", name = "auditType")
    @FieldRemark(column="AUDIT_TYPE", field="auditType", name="责任部门ID")
    private java.lang.String auditType;

    /**
    * 责任部门编号
    */
    @Size(max = 512, message = "责任部门编号长度不能超过512个字符")
    @ApiModelProperty(value = "责任部门编号", name = "auditName")
    @FieldRemark(column="AUDIT_NAME", field="auditName", name="责任部门编号")
    private java.lang.String auditName;

    /**
    * 责任部门
    */
    @Size(max = 2000, message = "责任部门长度不能超过2000个字符")
    @ApiModelProperty(value = "责任部门", name = "auditMonth")
    @FieldRemark(column="AUDIT_MONTH", field="auditMonth", name="责任部门")
    private java.lang.String auditMonth;

    /**
    * 受审部门ID
    */
    @Size(max = 64, message = "受审部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "受审部门ID", name = "auditeeDeptId")
    @FieldRemark(column="AUDITEE_DEPT_ID", field="auditeeDeptId", name="受审部门ID")
    private java.lang.String auditeeDeptId;

    /**
    * 受审部门CODE
    */
    @Size(max = 10, message = "受审部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "受审部门CODE", name = "auditeeDeptCode")
    @FieldRemark(column="AUDITEE_DEPT_CODE", field="auditeeDeptCode", name="受审部门CODE")
    private java.lang.String auditeeDeptCode;

    /**
    * 受审部门
    */
    @Size(max = 50, message = "受审部门长度不能超过50个字符")
    @ApiModelProperty(value = "受审部门", name = "auditeeDeptName")
    @FieldRemark(column="AUDITEE_DEPT_NAME", field="auditeeDeptName", name="受审部门")
    private java.lang.String auditeeDeptName;

    /**
    * 审核依据
    */
    @Size(max = 512, message = "审核依据长度不能超过512个字符")
    @ApiModelProperty(value = "审核依据", name = "auditBasis")
    @FieldRemark(column="AUDIT_BASIS", field="auditBasis", name="审核依据")
    private java.lang.String auditBasis;

    /**
    * 审核条款
    */
    @Size(max = 512, message = "审核条款长度不能超过512个字符")
    @ApiModelProperty(value = "审核条款", name = "auditClause")
    @FieldRemark(column="AUDIT_CLAUSE", field="auditClause", name="审核条款")
    private java.lang.String auditClause;

    /**
    * 型号/项目
    */
    @Size(max = 512, message = "型号/项目长度不能超过512个字符")
    @ApiModelProperty(value = "型号/项目", name = "modelProject")
    @FieldRemark(column="MODEL_PROJECT", field="modelProject", name="型号/项目")
    private java.lang.String modelProject;

    /**
    * 审核范围
    */
    @Size(max = 512, message = "审核范围长度不能超过512个字符")
    @ApiModelProperty(value = "审核范围", name = "auditScope")
    @FieldRemark(column="AUDIT_SCOPE", field="auditScope", name="审核范围")
    private java.lang.String auditScope;

    /**
    * 审核员ID
    */
    @Size(max = 512, message = "审核员ID长度不能超过512个字符")
    @ApiModelProperty(value = "审核员ID", name = "auditorId")
    @FieldRemark(column="AUDITOR_ID", field="auditorId", name="审核员ID")
    private java.lang.String auditorId;

    /**
    * 审核员CODE
    */
    @Size(max = 200, message = "审核员CODE长度不能超过200个字符")
    @ApiModelProperty(value = "审核员CODE", name = "auditorCode")
    @FieldRemark(column="AUDITOR_CODE", field="auditorCode", name="审核员CODE")
    private java.lang.String auditorCode;

    /**
    * 审核员
    */
    @Size(max = 200, message = "审核员长度不能超过200个字符")
    @ApiModelProperty(value = "审核员", name = "auditorName")
    @FieldRemark(column="AUDITOR_NAME", field="auditorName", name="审核员")
    private java.lang.String auditorName;

    /**
    * 计划状态
    */
    @Size(max = 10, message = "计划状态长度不能超过10个字符")
    @ApiModelProperty(value = "计划状态", name = "planStatus")
    @FieldRemark(column="PLAN_STATUS", field="planStatus", name="计划状态")
    private java.lang.String planStatus;

    /**
    * 计划来源
    */
    @Size(max = 128, message = "计划来源长度不能超过128个字符")
    @ApiModelProperty(value = "计划来源", name = "planSource")
    @FieldRemark(column="PLAN_SOURCE", field="planSource", name="计划来源")
    private java.lang.String planSource;

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
    @NotBlank(message = "密级不能为空")
    @ApiModelProperty(value = "密级", name = "secretLevel")
    @FieldRemark(column="SECRET_LEVEL", field="secretLevel", name="密级", dataType="lookup", lookupType="PLATFORM_FILE_SECRET_LEVEL")
    private java.lang.String secretLevel;
    private java.lang.String secretLevelName;


    /**
    * 是否已删除
    */
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private java.lang.String ynDeleted;

    /**
    * 备注
    */
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private java.lang.String remark;
/**
* 排序
*/
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
    @LogField
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private java.lang.String parentId;

    /**
    * 父节点ID显示字段
    */
    private java.lang.String parentPlanName;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getPlanCode(){
        return planCode;
    }

    public void setPlanCode(java.lang.String planCode){
        this.planCode = planCode;
    }

    public java.lang.String getPlanName(){
        return planName;
    }

    public void setPlanName(java.lang.String planName){
        this.planName = planName;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getAuditType(){
        return auditType;
    }

    public void setAuditType(java.lang.String auditType){
        this.auditType = auditType;
    }

    public java.lang.String getAuditName(){
        return auditName;
    }

    public void setAuditName(java.lang.String auditName){
        this.auditName = auditName;
    }

    public java.lang.String getAuditMonth(){
        return auditMonth;
    }

    public void setAuditMonth(java.lang.String auditMonth){
        this.auditMonth = auditMonth;
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

    public java.lang.String getAuditClause(){
        return auditClause;
    }

    public void setAuditClause(java.lang.String auditClause){
        this.auditClause = auditClause;
    }

    public java.lang.String getModelProject(){
        return modelProject;
    }

    public void setModelProject(java.lang.String modelProject){
        this.modelProject = modelProject;
    }

    public java.lang.String getAuditScope(){
        return auditScope;
    }

    public void setAuditScope(java.lang.String auditScope){
        this.auditScope = auditScope;
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

    public java.lang.String getPlanStatus(){
        return planStatus;
    }

    public void setPlanStatus(java.lang.String planStatus){
        this.planStatus = planStatus;
    }

    public java.lang.String getPlanSource(){
        return planSource;
    }

    public void setPlanSource(java.lang.String planSource){
        this.planSource = planSource;
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

    public java.lang.String getParentPlanName(){
        return parentPlanName;
    }

    public void setParentPlanName(java.lang.String parentPlanName){
        this.parentPlanName = parentPlanName;
    }

    public List<QmsAuditPlanDTO> getChildren() {
        if(children == null && "N".equals(this.treeLeaf)){
          return new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<QmsAuditPlanDTO> children) {
        this.children = children;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
             return "年度内审计划及执行主表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "年度内审计划及执行主表";
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