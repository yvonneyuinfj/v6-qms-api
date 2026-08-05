package avicit.myportal.qms.qmsmilitaryqualification.dto;

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
* @创建时间： 2026-08-05 18:06
* @类说明：军工资质基本信息DTO
* @修改记录：
*/
@ApiModel(value = "QmsMilitaryQualificationDTO", description = "军工资质基本信息")
@PojoRemark(table="QMS_MILITARY_QUALIFICATION", object="QmsMilitaryQualificationDTO", name="军工资质基本信息")
@ExcelIgnoreUnannotated
public class QmsMilitaryQualificationDTO extends BeanDTO{
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
    * 归组ID;同一资质不同版本保持一致
    */
    @ExcelProperty("归组ID;同一资质不同版本保持一致")
    @Size(max = 64, message = "归组ID;同一资质不同版本保持一致长度不能超过64个字符")
    @ApiModelProperty(value = "归组ID;同一资质不同版本保持一致", name = "qualificationGroupId")
    @FieldRemark(column="QUALIFICATION_GROUP_ID", field="qualificationGroupId", name="归组ID;同一资质不同版本保持一致")
    private java.lang.String qualificationGroupId;

    /**
    * 类型CODE;字典
    */
    @ExcelProperty("类型CODE;字典")
    @Size(max = 50, message = "类型CODE;字典长度不能超过50个字符")
    @ApiModelProperty(value = "类型CODE;字典", name = "qualificationTypeCode")
    @FieldRemark(column="QUALIFICATION_TYPE_CODE", field="qualificationTypeCode", name="类型CODE;字典")
    private java.lang.String qualificationTypeCode;

    /**
    * 类型;资质类型名称
    */
    @ExcelProperty("类型;资质类型名称")
    @Size(max = 128, message = "类型;资质类型名称长度不能超过128个字符")
    @ApiModelProperty(value = "类型;资质类型名称", name = "qualificationTypeName")
    @FieldRemark(column="QUALIFICATION_TYPE_NAME", field="qualificationTypeName", name="类型;资质类型名称")
    private java.lang.String qualificationTypeName;

    /**
    * 证书编号
    */
    @ExcelProperty("证书编号")
    @Size(max = 128, message = "证书编号长度不能超过128个字符")
    @ApiModelProperty(value = "证书编号", name = "certificationCode")
    @FieldRemark(column="CERTIFICATION_CODE", field="certificationCode", name="证书编号")
    private java.lang.String certificationCode;

    /**
    * 资质范围
    */
    @ExcelProperty("资质范围")
    @Size(max = 2000, message = "资质范围长度不能超过2000个字符")
    @ApiModelProperty(value = "资质范围", name = "qualificationScope")
    @FieldRemark(column="QUALIFICATION_SCOPE", field="qualificationScope", name="资质范围")
    private java.lang.String qualificationScope;
    /**
    * 生效日期
    */
    @ExcelProperty("生效日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "生效日期", name = "effectiveTime")
    @FieldRemark(column="EFFECTIVE_TIME", field="effectiveTime", name="生效日期")
    private java.util.Date effectiveTime;

    /**
    * 生效日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date effectiveTimeBegin;

    /**
    * 生效日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date effectiveTimeEnd;
    /**
    * 失效日期
    */
    @ExcelProperty("失效日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "失效日期", name = "expiryTime")
    @FieldRemark(column="EXPIRY_TIME", field="expiryTime", name="失效日期")
    private java.util.Date expiryTime;

    /**
    * 失效日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date expiryTimeBegin;

    /**
    * 失效日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date expiryTimeEnd;

    /**
    * 颁发机构
    */
    @ExcelProperty("颁发机构")
    @Size(max = 256, message = "颁发机构长度不能超过256个字符")
    @ApiModelProperty(value = "颁发机构", name = "issuingAgency")
    @FieldRemark(column="ISSUING_AGENCY", field="issuingAgency", name="颁发机构")
    private java.lang.String issuingAgency;

    /**
    * 证书版本号
    */
    @ExcelProperty("证书版本号")
    @Size(max = 128, message = "证书版本号长度不能超过128个字符")
    @ApiModelProperty(value = "证书版本号", name = "certVersionNo")
    @FieldRemark(column="CERT_VERSION_NO", field="certVersionNo", name="证书版本号")
    private java.lang.String certVersionNo;

    /**
    * 上一版本ID
    */
    @ExcelProperty("上一版本ID")
    @Size(max = 64, message = "上一版本ID长度不能超过64个字符")
    @ApiModelProperty(value = "上一版本ID", name = "previousVersionId")
    @FieldRemark(column="PREVIOUS_VERSION_ID", field="previousVersionId", name="上一版本ID")
    private java.lang.String previousVersionId;

    /**
    * 是否当前版本
    */
    @ExcelProperty("是否当前版本")
    @Size(max = 2, message = "是否当前版本长度不能超过2个字符")
    @ApiModelProperty(value = "是否当前版本", name = "ynCurrent")
    @FieldRemark(column="YN_CURRENT", field="ynCurrent", name="是否当前版本")
    private java.lang.String ynCurrent;

    /**
    * 版本变更类型;字典：初始、换证、增项、变更、补发等
    */
    @ExcelProperty("版本变更类型;字典：初始、换证、增项、变更、补发等")
    @Size(max = 50, message = "版本变更类型;字典：初始、换证、增项、变更、补发等长度不能超过50个字符")
    @ApiModelProperty(value = "版本变更类型;字典：初始、换证、增项、变更、补发等", name = "changeType")
    @FieldRemark(column="CHANGE_TYPE", field="changeType", name="版本变更类型;字典：初始、换证、增项、变更、补发等")
    private java.lang.String changeType;

    /**
    * 变更内容;说明本版本变化
    */
    @ExcelProperty("变更内容;说明本版本变化")
    @Size(max = 2000, message = "变更内容;说明本版本变化长度不能超过2000个字符")
    @ApiModelProperty(value = "变更内容;说明本版本变化", name = "changeContent")
    @FieldRemark(column="CHANGE_CONTENT", field="changeContent", name="变更内容;说明本版本变化")
    private java.lang.String changeContent;

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
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 64, message = "责任部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "责任部门ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任部门ID")
    private java.lang.String responsibleDeptId;

    /**
    * 责任部门CODE
    */
    @ExcelProperty("责任部门CODE")
    @Size(max = 10, message = "责任部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "责任部门CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任部门CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 128, message = "责任部门长度不能超过128个字符")
    @ApiModelProperty(value = "责任部门", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任部门")
    private java.lang.String responsibleDeptName;

    /**
    * 附件ID
    */
    @ExcelProperty("附件ID")
    @Size(max = 256, message = "附件ID长度不能超过256个字符")
    @ApiModelProperty(value = "附件ID", name = "fileId")
    @FieldRemark(column="FILE_ID", field="fileId", name="附件ID")
    private java.lang.String fileId;

    /**
    * 证书状态
    */
    @ExcelProperty("证书状态")
    @Size(max = 10, message = "证书状态长度不能超过10个字符")
    @ApiModelProperty(value = "证书状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="证书状态")
    private java.lang.String status;

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

    public java.lang.String getCertificationCode(){
        return certificationCode;
    }

    public void setCertificationCode(java.lang.String certificationCode){
        this.certificationCode = certificationCode;
    }

    public java.lang.String getQualificationScope(){
        return qualificationScope;
    }

    public void setQualificationScope(java.lang.String qualificationScope){
        this.qualificationScope = qualificationScope;
    }

    public java.util.Date getEffectiveTime(){
        return effectiveTime;
    }

    public void setEffectiveTime(java.util.Date effectiveTime){
        this.effectiveTime = effectiveTime;
        super.handleNullValue();
    }

    public java.util.Date getEffectiveTimeBegin(){
        return effectiveTimeBegin;
    }

    public void setEffectiveTimeBegin(java.util.Date effectiveTimeBegin){
        this.effectiveTimeBegin = effectiveTimeBegin;
    }

    public java.util.Date getEffectiveTimeEnd(){
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(java.util.Date effectiveTimeEnd){
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public java.util.Date getExpiryTime(){
        return expiryTime;
    }

    public void setExpiryTime(java.util.Date expiryTime){
        this.expiryTime = expiryTime;
        super.handleNullValue();
    }

    public java.util.Date getExpiryTimeBegin(){
        return expiryTimeBegin;
    }

    public void setExpiryTimeBegin(java.util.Date expiryTimeBegin){
        this.expiryTimeBegin = expiryTimeBegin;
    }

    public java.util.Date getExpiryTimeEnd(){
        return expiryTimeEnd;
    }

    public void setExpiryTimeEnd(java.util.Date expiryTimeEnd){
        this.expiryTimeEnd = expiryTimeEnd;
    }

    public java.lang.String getIssuingAgency(){
        return issuingAgency;
    }

    public void setIssuingAgency(java.lang.String issuingAgency){
        this.issuingAgency = issuingAgency;
    }

    public java.lang.String getCertVersionNo(){
        return certVersionNo;
    }

    public void setCertVersionNo(java.lang.String certVersionNo){
        this.certVersionNo = certVersionNo;
    }

    public java.lang.String getPreviousVersionId(){
        return previousVersionId;
    }

    public void setPreviousVersionId(java.lang.String previousVersionId){
        this.previousVersionId = previousVersionId;
    }

    public java.lang.String getYnCurrent(){
        return ynCurrent;
    }

    public void setYnCurrent(java.lang.String ynCurrent){
        this.ynCurrent = ynCurrent;
    }

    public java.lang.String getChangeType(){
        return changeType;
    }

    public void setChangeType(java.lang.String changeType){
        this.changeType = changeType;
    }

    public java.lang.String getChangeContent(){
        return changeContent;
    }

    public void setChangeContent(java.lang.String changeContent){
        this.changeContent = changeContent;
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

    public java.lang.String getFileId(){
        return fileId;
    }

    public void setFileId(java.lang.String fileId){
        this.fileId = fileId;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
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
            return "军工资质基本信息";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "军工资质基本信息";
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
