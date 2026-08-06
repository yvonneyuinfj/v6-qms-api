package avicit.myportal.qms.qmsqualityrewardcontributeor.dto;

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
* @创建时间： 2026-08-06 17:03
* @类说明：参与人员贡献表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityRewardContributeorDTO", description = "参与人员贡献表")
@PojoRemark(table="QMS_QUALITY_REWARD_CONTRIBUTEOR", object="QmsQualityRewardContributeorDTO", name="参与人员贡献表")
@ExcelIgnoreUnannotated
public class QmsQualityRewardContributeorDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 主键
    */
    @Id
    @Size(max = 64, message = "主键长度不能超过64个字符")
    @ApiModelProperty(value = "主键", name = "id")
    @FieldRemark(column="ID", field="id", name="主键")
    private java.lang.String id;

    /**
    * 质量奖励ID
    */
    @Size(max = 64, message = "质量奖励ID长度不能超过64个字符")
    @ApiModelProperty(value = "质量奖励ID", name = "rewardId")
    @FieldRemark(column="REWARD_ID", field="rewardId", name="质量奖励ID")
    private java.lang.String rewardId;

    /**
    * 部门ID
    */
    @ExcelProperty("部门ID")
    @Size(max = 64, message = "部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "部门ID", name = "deptId")
    @FieldRemark(column="DEPT_ID", field="deptId", name="部门ID")
    private java.lang.String deptId;

    /**
    * 部门CODE
    */
    @ExcelProperty("部门CODE")
    @Size(max = 10, message = "部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "部门CODE", name = "deptCode")
    @FieldRemark(column="DEPT_CODE", field="deptCode", name="部门CODE")
    private java.lang.String deptCode;

    /**
    * 部门
    */
    @ExcelProperty("部门")
    @Size(max = 10, message = "部门长度不能超过10个字符")
    @ApiModelProperty(value = "部门", name = "deptName")
    @FieldRemark(column="DEPT_NAME", field="deptName", name="部门")
    private java.lang.String deptName;

    /**
    * 人员ID
    */
    @ExcelProperty("人员ID")
    @Size(max = 64, message = "人员ID长度不能超过64个字符")
    @ApiModelProperty(value = "人员ID", name = "staffId")
    @FieldRemark(column="STAFF_ID", field="staffId", name="人员ID")
    private java.lang.String staffId;

    /**
    * 人员CODE
    */
    @ExcelProperty("人员CODE")
    @Size(max = 10, message = "人员CODE长度不能超过10个字符")
    @ApiModelProperty(value = "人员CODE", name = "staffCode")
    @FieldRemark(column="STAFF_CODE", field="staffCode", name="人员CODE")
    private java.lang.String staffCode;

    /**
    * 人员ID
    */
    @ExcelProperty("人员ID")
    @Size(max = 20, message = "人员ID长度不能超过20个字符")
    @ApiModelProperty(value = "人员ID", name = "staffName")
    @FieldRemark(column="STAFF_NAME", field="staffName", name="人员ID")
    private java.lang.String staffName;
    /**
    * 贡献度
    */
    @ExcelProperty("贡献度")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 5, fraction = 2, message = "贡献度格式不正确")
    @ApiModelProperty(value = "贡献度", name = "contributionRate")
    @FieldRemark(column="CONTRIBUTION_RATE", field="contributionRate", name="贡献度")
    private java.math.BigDecimal contributionRate;

    /**
    * 关键贡献描述
    */
    @ExcelProperty("关键贡献描述")
    @Size(max = 2000, message = "关键贡献描述长度不能超过2000个字符")
    @ApiModelProperty(value = "关键贡献描述", name = "keyContributionDesc")
    @FieldRemark(column="KEY_CONTRIBUTION_DESC", field="keyContributionDesc", name="关键贡献描述")
    private java.lang.String keyContributionDesc;
    /**
    * 奖励金额
    */
    @ExcelProperty("奖励金额")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 18, fraction = 2, message = "奖励金额格式不正确")
    @ApiModelProperty(value = "奖励金额", name = "rewardAmount")
    @FieldRemark(column="REWARD_AMOUNT", field="rewardAmount", name="奖励金额")
    private java.math.BigDecimal rewardAmount;

    /**
    * 奖金明细类型
    */
    @ExcelProperty("奖金明细类型")
    @Size(max = 20, message = "奖金明细类型长度不能超过20个字符")
    @ApiModelProperty(value = "奖金明细类型", name = "bonusType")
    @FieldRemark(column="BONUS_TYPE", field="bonusType", name="奖金明细类型")
    private java.lang.String bonusType;

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
     * 子表操作类型：insert-新增(可省略), update-更新, delete-删除
     */
    private String operationType_;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getRewardId(){
        return rewardId;
    }

    public void setRewardId(java.lang.String rewardId){
        this.rewardId = rewardId;
    }

    public java.lang.String getDeptId(){
        return deptId;
    }

    public void setDeptId(java.lang.String deptId){
        this.deptId = deptId;
    }

    public java.lang.String getDeptCode(){
        return deptCode;
    }

    public void setDeptCode(java.lang.String deptCode){
        this.deptCode = deptCode;
    }

    public java.lang.String getDeptName(){
        return deptName;
    }

    public void setDeptName(java.lang.String deptName){
        this.deptName = deptName;
    }

    public java.lang.String getStaffId(){
        return staffId;
    }

    public void setStaffId(java.lang.String staffId){
        this.staffId = staffId;
    }

    public java.lang.String getStaffCode(){
        return staffCode;
    }

    public void setStaffCode(java.lang.String staffCode){
        this.staffCode = staffCode;
    }

    public java.lang.String getStaffName(){
        return staffName;
    }

    public void setStaffName(java.lang.String staffName){
        this.staffName = staffName;
    }

    public java.math.BigDecimal getContributionRate(){
        return contributionRate;
    }

    public void setContributionRate(java.math.BigDecimal contributionRate){
        this.contributionRate = contributionRate;
        super.handleNullValue();
    }

    public java.lang.String getKeyContributionDesc(){
        return keyContributionDesc;
    }

    public void setKeyContributionDesc(java.lang.String keyContributionDesc){
        this.keyContributionDesc = keyContributionDesc;
    }

    public java.math.BigDecimal getRewardAmount(){
        return rewardAmount;
    }

    public void setRewardAmount(java.math.BigDecimal rewardAmount){
        this.rewardAmount = rewardAmount;
        super.handleNullValue();
    }

    public java.lang.String getBonusType(){
        return bonusType;
    }

    public void setBonusType(java.lang.String bonusType){
        this.bonusType = bonusType;
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

    public String getOperationType_() {
        return operationType_;
    }

    public void setOperationType_(String operationType_) {
        this.operationType_ = operationType_;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "参与人员贡献表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "参与人员贡献表";
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
