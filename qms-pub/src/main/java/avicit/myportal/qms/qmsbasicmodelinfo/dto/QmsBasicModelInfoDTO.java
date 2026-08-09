package avicit.myportal.qms.qmsbasicmodelinfo.dto;

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
* @创建时间： 2026-08-08 17:12
* @类说明：QMS_BASIC_MODEL_INFODTO
* @修改记录：
*/
@ApiModel(value = "QmsBasicModelInfoDTO", description = "QMS_BASIC_MODEL_INFO")
@PojoRemark(table="QMS_BASIC_MODEL_INFO", object="QmsBasicModelInfoDTO", name="QMS_BASIC_MODEL_INFO")
@ExcelIgnoreUnannotated
public class QmsBasicModelInfoDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 200, message = "型号长度不能超过200个字符")
    @ApiModelProperty(value = "型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号")
    private String model;

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
    * 主键
    */
    @Id
    @Size(max = 64, message = "主键长度不能超过64个字符")
    @ApiModelProperty(value = "主键", name = "id")
    @FieldRemark(column="ID", field="id", name="主键")
    private String id;

    /**
    * 总师单位
    */
    @ExcelProperty("总师单位")
    @Size(max = 200, message = "总师单位长度不能超过200个字符")
    @ApiModelProperty(value = "总师单位", name = "managerDept")
    @FieldRemark(column="MANAGER_DEPT", field="managerDept", name="总师单位")
    private String managerDept;

    /**
    * 总承单位
    */
    @ExcelProperty("总承单位")
    @Size(max = 200, message = "总承单位长度不能超过200个字符")
    @ApiModelProperty(value = "总承单位", name = "productDept")
    @FieldRemark(column="PRODUCT_DEPT", field="productDept", name="总承单位")
    private String productDept;

    /**
    * 军代表ID
    */
    @ExcelProperty("军代表ID")
    @Size(max = 2000, message = "军代表ID长度不能超过2000个字符")
    @ApiModelProperty(value = "军代表ID", name = "milRepId")
    @FieldRemark(column="MIL_REP_ID", field="milRepId", name="军代表ID")
    private String milRepId;

    /**
    * 军代表CODE
    */
    @ExcelProperty("军代表CODE")
    @Size(max = 500, message = "军代表CODE长度不能超过500个字符")
    @ApiModelProperty(value = "军代表CODE", name = "milRepCode")
    @FieldRemark(column="MIL_REP_CODE", field="milRepCode", name="军代表CODE")
    private String milRepCode;

    /**
    * 军代表
    */
    @ExcelProperty("军代表")
    @Size(max = 1000, message = "军代表长度不能超过1000个字符")
    @ApiModelProperty(value = "军代表", name = "milRepName")
    @FieldRemark(column="MIL_REP_NAME", field="milRepName", name="军代表")
    private String milRepName;

    /**
    * 副总师ID
    */
    @ExcelProperty("副总师ID")
    @Size(max = 2000, message = "副总师ID长度不能超过2000个字符")
    @ApiModelProperty(value = "副总师ID", name = "deputyChiefDesignerId")
    @FieldRemark(column="DEPUTY_CHIEF_DESIGNER_ID", field="deputyChiefDesignerId", name="副总师ID")
    private String deputyChiefDesignerId;

    /**
    * 副总师CODE
    */
    @ExcelProperty("副总师CODE")
    @Size(max = 500, message = "副总师CODE长度不能超过500个字符")
    @ApiModelProperty(value = "副总师CODE", name = "deputyChiefDesignerCode")
    @FieldRemark(column="DEPUTY_CHIEF_DESIGNER_CODE", field="deputyChiefDesignerCode", name="副总师CODE")
    private String deputyChiefDesignerCode;

    /**
    * 副总师
    */
    @ExcelProperty("副总师")
    @Size(max = 1000, message = "副总师长度不能超过1000个字符")
    @ApiModelProperty(value = "副总师", name = "deputyChiefDesignerName")
    @FieldRemark(column="DEPUTY_CHIEF_DESIGNER_NAME", field="deputyChiefDesignerName", name="副总师")
    private String deputyChiefDesignerName;

    /**
    * 科研部主管ID
    */
    @ExcelProperty("科研部主管ID")
    @Size(max = 2000, message = "科研部主管ID长度不能超过2000个字符")
    @ApiModelProperty(value = "科研部主管ID", name = "rdManagerId")
    @FieldRemark(column="RD_MANAGER_ID", field="rdManagerId", name="科研部主管ID")
    private String rdManagerId;

    /**
    * 科研部主管CODE
    */
    @ExcelProperty("科研部主管CODE")
    @Size(max = 500, message = "科研部主管CODE长度不能超过500个字符")
    @ApiModelProperty(value = "科研部主管CODE", name = "rdManagerCode")
    @FieldRemark(column="RD_MANAGER_CODE", field="rdManagerCode", name="科研部主管CODE")
    private String rdManagerCode;

    /**
    * 科研部主管
    */
    @ExcelProperty("科研部主管")
    @Size(max = 1000, message = "科研部主管长度不能超过1000个字符")
    @ApiModelProperty(value = "科研部主管", name = "rdManagerName")
    @FieldRemark(column="RD_MANAGER_NAME", field="rdManagerName", name="科研部主管")
    private String rdManagerName;

    /**
    * 质量部主管ID
    */
    @ExcelProperty("质量部主管ID")
    @Size(max = 2000, message = "质量部主管ID长度不能超过2000个字符")
    @ApiModelProperty(value = "质量部主管ID", name = "qaManagerId")
    @FieldRemark(column="QA_MANAGER_ID", field="qaManagerId", name="质量部主管ID")
    private String qaManagerId;

    /**
    * 质量部主管CODE
    */
    @ExcelProperty("质量部主管CODE")
    @Size(max = 500, message = "质量部主管CODE长度不能超过500个字符")
    @ApiModelProperty(value = "质量部主管CODE", name = "qaManagerCode")
    @FieldRemark(column="QA_MANAGER_CODE", field="qaManagerCode", name="质量部主管CODE")
    private String qaManagerCode;

    /**
    * 质量部主管
    */
    @ExcelProperty("质量部主管")
    @Size(max = 1000, message = "质量部主管长度不能超过1000个字符")
    @ApiModelProperty(value = "质量部主管", name = "qaManagerName")
    @FieldRemark(column="QA_MANAGER_NAME", field="qaManagerName", name="质量部主管")
    private String qaManagerName;

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
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

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getManagerDept(){
        return managerDept;
    }

    public void setManagerDept(String managerDept){
        this.managerDept = managerDept;
    }

    public String getProductDept(){
        return productDept;
    }

    public void setProductDept(String productDept){
        this.productDept = productDept;
    }

    public String getMilRepId(){
        return milRepId;
    }

    public void setMilRepId(String milRepId){
        this.milRepId = milRepId;
    }

    public String getMilRepCode(){
        return milRepCode;
    }

    public void setMilRepCode(String milRepCode){
        this.milRepCode = milRepCode;
    }

    public String getMilRepName(){
        return milRepName;
    }

    public void setMilRepName(String milRepName){
        this.milRepName = milRepName;
    }

    public String getDeputyChiefDesignerId(){
        return deputyChiefDesignerId;
    }

    public void setDeputyChiefDesignerId(String deputyChiefDesignerId){
        this.deputyChiefDesignerId = deputyChiefDesignerId;
    }

    public String getDeputyChiefDesignerCode(){
        return deputyChiefDesignerCode;
    }

    public void setDeputyChiefDesignerCode(String deputyChiefDesignerCode){
        this.deputyChiefDesignerCode = deputyChiefDesignerCode;
    }

    public String getDeputyChiefDesignerName(){
        return deputyChiefDesignerName;
    }

    public void setDeputyChiefDesignerName(String deputyChiefDesignerName){
        this.deputyChiefDesignerName = deputyChiefDesignerName;
    }

    public String getRdManagerId(){
        return rdManagerId;
    }

    public void setRdManagerId(String rdManagerId){
        this.rdManagerId = rdManagerId;
    }

    public String getRdManagerCode(){
        return rdManagerCode;
    }

    public void setRdManagerCode(String rdManagerCode){
        this.rdManagerCode = rdManagerCode;
    }

    public String getRdManagerName(){
        return rdManagerName;
    }

    public void setRdManagerName(String rdManagerName){
        this.rdManagerName = rdManagerName;
    }

    public String getQaManagerId(){
        return qaManagerId;
    }

    public void setQaManagerId(String qaManagerId){
        this.qaManagerId = qaManagerId;
    }

    public String getQaManagerCode(){
        return qaManagerCode;
    }

    public void setQaManagerCode(String qaManagerCode){
        this.qaManagerCode = qaManagerCode;
    }

    public String getQaManagerName(){
        return qaManagerName;
    }

    public void setQaManagerName(String qaManagerName){
        this.qaManagerName = qaManagerName;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "QMS_BASIC_MODEL_INFO";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "QMS_BASIC_MODEL_INFO";
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
