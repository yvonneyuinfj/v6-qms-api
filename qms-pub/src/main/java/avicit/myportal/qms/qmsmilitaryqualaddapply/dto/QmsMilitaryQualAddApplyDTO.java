package avicit.myportal.qms.qmsmilitaryqualaddapply.dto;

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
* @创建时间： 2026-08-05 18:07
* @类说明：军工资质增项申请DTO
* @修改记录：
*/
@ApiModel(value = "QmsMilitaryQualAddApplyDTO", description = "军工资质增项申请")
@PojoRemark(table="QMS_MILITARY_QUAL_ADD_APPLY", object="QmsMilitaryQualAddApplyDTO", name="军工资质增项申请")
@ExcelIgnoreUnannotated
public class QmsMilitaryQualAddApplyDTO extends BeanDTO{
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
    * 申请编号
    */
    @ExcelProperty("申请编号")
    @Size(max = 50, message = "申请编号长度不能超过50个字符")
    @ApiModelProperty(value = "申请编号", name = "applyCode")
    @FieldRemark(column="APPLY_CODE", field="applyCode", name="申请编号")
    private java.lang.String applyCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 资质归组ID
    */
    @ExcelProperty("资质归组ID")
    @Size(max = 64, message = "资质归组ID长度不能超过64个字符")
    @ApiModelProperty(value = "资质归组ID", name = "qualificationGroupId")
    @FieldRemark(column="QUALIFICATION_GROUP_ID", field="qualificationGroupId", name="资质归组ID")
    private java.lang.String qualificationGroupId;

    /**
    * 资质类型CODE
    */
    @ExcelProperty("资质类型CODE")
    @Size(max = 50, message = "资质类型CODE长度不能超过50个字符")
    @ApiModelProperty(value = "资质类型CODE", name = "qualificationTypeCode")
    @FieldRemark(column="QUALIFICATION_TYPE_CODE", field="qualificationTypeCode", name="资质类型CODE")
    private java.lang.String qualificationTypeCode;

    /**
    * 资质类型名称
    */
    @ExcelProperty("资质类型名称")
    @Size(max = 128, message = "资质类型名称长度不能超过128个字符")
    @ApiModelProperty(value = "资质类型名称", name = "qualificationTypeName")
    @FieldRemark(column="QUALIFICATION_TYPE_NAME", field="qualificationTypeName", name="资质类型名称")
    private java.lang.String qualificationTypeName;

    /**
    * 产品名称
    */
    @ExcelProperty("产品名称")
    @Size(max = 512, message = "产品名称长度不能超过512个字符")
    @ApiModelProperty(value = "产品名称", name = "productName")
    @FieldRemark(column="PRODUCT_NAME", field="productName", name="产品名称")
    private java.lang.String productName;

    /**
    * 紧急度
    */
    @ExcelProperty("紧急度")
    @Size(max = 50, message = "紧急度长度不能超过50个字符")
    @ApiModelProperty(value = "紧急度", name = "ugencyLevel")
    @FieldRemark(column="UGENCY_LEVEL", field="ugencyLevel", name="紧急度")
    private java.lang.String ugencyLevel;

    /**
    * 能力情况
    */
    @ExcelProperty("能力情况")
    @Size(max = 512, message = "能力情况长度不能超过512个字符")
    @ApiModelProperty(value = "能力情况", name = "capabilityDesc")
    @FieldRemark(column="CAPABILITY_DESC", field="capabilityDesc", name="能力情况")
    private java.lang.String capabilityDesc;

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

    public java.lang.String getApplyCode(){
        return applyCode;
    }

    public void setApplyCode(java.lang.String applyCode){
        this.applyCode = applyCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getQualificationGroupId(){
        return qualificationGroupId;
    }

    public void setQualificationGroupId(java.lang.String qualificationGroupId){
        this.qualificationGroupId = qualificationGroupId;
    }

    public java.lang.String getQualificationTypeCode(){
        return qualificationTypeCode;
    }

    public void setQualificationTypeCode(java.lang.String qualificationTypeCode){
        this.qualificationTypeCode = qualificationTypeCode;
    }

    public java.lang.String getQualificationTypeName(){
        return qualificationTypeName;
    }

    public void setQualificationTypeName(java.lang.String qualificationTypeName){
        this.qualificationTypeName = qualificationTypeName;
    }

    public java.lang.String getProductName(){
        return productName;
    }

    public void setProductName(java.lang.String productName){
        this.productName = productName;
    }

    public java.lang.String getUgencyLevel(){
        return ugencyLevel;
    }

    public void setUgencyLevel(java.lang.String ugencyLevel){
        this.ugencyLevel = ugencyLevel;
    }

    public java.lang.String getCapabilityDesc(){
        return capabilityDesc;
    }

    public void setCapabilityDesc(java.lang.String capabilityDesc){
        this.capabilityDesc = capabilityDesc;
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

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "军工资质增项申请";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "军工资质增项申请";
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
