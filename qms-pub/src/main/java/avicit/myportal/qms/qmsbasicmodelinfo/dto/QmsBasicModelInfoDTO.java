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
* @创建时间： 2026-08-03 19:25
* @类说明：QMS_BASIC_MODEL_INFODTO
* @修改记录：
*/
@ApiModel(value = "QmsBasicModelInfoDTO", description = "QMS_BASIC_MODEL_INFO")
@PojoRemark(table="QMS_BASIC_MODEL_INFO", object="QmsBasicModelInfoDTO", name="QMS_BASIC_MODEL_INFO")
@ExcelIgnoreUnannotated
public class QmsBasicModelInfoDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * 主键
    */
    @Id
    @Size(max = 50, message = "主键长度不能超过50个字符")
    @ApiModelProperty(value = "主键", name = "id")
    @FieldRemark(column="ID", field="id", name="主键")
    private java.lang.String id;

    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 200, message = "型号长度不能超过200个字符")
    @ApiModelProperty(value = "型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号")
    private java.lang.String model;

    /**
    * 总师单位
    */
    @ExcelProperty("总师单位")
    @Size(max = 200, message = "总师单位长度不能超过200个字符")
    @ApiModelProperty(value = "总师单位", name = "managerdept")
    @FieldRemark(column="MANAGERDEPT", field="managerdept", name="总师单位")
    private java.lang.String managerdept;

    /**
    * 总承单位
    */
    @ExcelProperty("总承单位")
    @Size(max = 200, message = "总承单位长度不能超过200个字符")
    @ApiModelProperty(value = "总承单位", name = "productdept")
    @FieldRemark(column="PRODUCTDEPT", field="productdept", name="总承单位")
    private java.lang.String productdept;

    /**
    * 军代表
    */
    @ExcelProperty("军代表")
    @Size(max = 200, message = "军代表长度不能超过200个字符")
    @ApiModelProperty(value = "军代表", name = "armyRepresentative")
    @FieldRemark(column="ARMY_REPRESENTATIVE", field="armyRepresentative", name="军代表")
    private java.lang.String armyRepresentative;

    /**
    * 副总师
    */
    @ExcelProperty("副总师")
    @Size(max = 1000, message = "副总师长度不能超过1000个字符")
    @ApiModelProperty(value = "副总师", name = "zlbFzs")
    @FieldRemark(column="ZLB_FZS", field="zlbFzs", name="副总师")
    private java.lang.String zlbFzs;

    /**
    * 科研部主管ID
    */
    @ExcelProperty("科研部主管ID")
    @Size(max = 2000, message = "科研部主管ID长度不能超过2000个字符")
    @ApiModelProperty(value = "科研部主管ID", name = "kybMasterId")
    @FieldRemark(column="KYB_MASTER_ID", field="kybMasterId", name="科研部主管ID")
    private java.lang.String kybMasterId;

    /**
    * 科研部主管CODE
    */
    @ExcelProperty("科研部主管CODE")
    @Size(max = 1000, message = "科研部主管CODE长度不能超过1000个字符")
    @ApiModelProperty(value = "科研部主管CODE", name = "kybMasterCode")
    @FieldRemark(column="KYB_MASTER_CODE", field="kybMasterCode", name="科研部主管CODE")
    private java.lang.String kybMasterCode;

    /**
    * 科研部主管
    */
    @ExcelProperty("科研部主管")
    @Size(max = 2000, message = "科研部主管长度不能超过2000个字符")
    @ApiModelProperty(value = "科研部主管", name = "kybMasterName")
    @FieldRemark(column="KYB_MASTER_NAME", field="kybMasterName", name="科研部主管")
    private java.lang.String kybMasterName;

    /**
    * 质量部主管ID
    */
    @ExcelProperty("质量部主管ID")
    @Size(max = 500, message = "质量部主管ID长度不能超过500个字符")
    @ApiModelProperty(value = "质量部主管ID", name = "zlbMasterId")
    @FieldRemark(column="ZLB_MASTER_ID", field="zlbMasterId", name="质量部主管ID")
    private java.lang.String zlbMasterId;

    /**
    * 质量部主管CODE
    */
    @ExcelProperty("质量部主管CODE")
    @Size(max = 200, message = "质量部主管CODE长度不能超过200个字符")
    @ApiModelProperty(value = "质量部主管CODE", name = "zlbMasterCode")
    @FieldRemark(column="ZLB_MASTER_CODE", field="zlbMasterCode", name="质量部主管CODE")
    private java.lang.String zlbMasterCode;

    /**
    * 质量部主管
    */
    @ExcelProperty("质量部主管")
    @Size(max = 500, message = "质量部主管长度不能超过500个字符")
    @ApiModelProperty(value = "质量部主管", name = "zlbMasterName")
    @FieldRemark(column="ZLB_MASTER_NAME", field="zlbMasterName", name="质量部主管")
    private java.lang.String zlbMasterName;

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

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.lang.String getManagerdept(){
        return managerdept;
    }

    public void setManagerdept(java.lang.String managerdept){
        this.managerdept = managerdept;
    }

    public java.lang.String getProductdept(){
        return productdept;
    }

    public void setProductdept(java.lang.String productdept){
        this.productdept = productdept;
    }

    public java.lang.String getArmyRepresentative(){
        return armyRepresentative;
    }

    public void setArmyRepresentative(java.lang.String armyRepresentative){
        this.armyRepresentative = armyRepresentative;
    }

    public java.lang.String getZlbFzs(){
        return zlbFzs;
    }

    public void setZlbFzs(java.lang.String zlbFzs){
        this.zlbFzs = zlbFzs;
    }

    public java.lang.String getKybMasterId(){
        return kybMasterId;
    }

    public void setKybMasterId(java.lang.String kybMasterId){
        this.kybMasterId = kybMasterId;
    }

    public java.lang.String getKybMasterCode(){
        return kybMasterCode;
    }

    public void setKybMasterCode(java.lang.String kybMasterCode){
        this.kybMasterCode = kybMasterCode;
    }

    public java.lang.String getKybMasterName(){
        return kybMasterName;
    }

    public void setKybMasterName(java.lang.String kybMasterName){
        this.kybMasterName = kybMasterName;
    }

    public java.lang.String getZlbMasterId(){
        return zlbMasterId;
    }

    public void setZlbMasterId(java.lang.String zlbMasterId){
        this.zlbMasterId = zlbMasterId;
    }

    public java.lang.String getZlbMasterCode(){
        return zlbMasterCode;
    }

    public void setZlbMasterCode(java.lang.String zlbMasterCode){
        this.zlbMasterCode = zlbMasterCode;
    }

    public java.lang.String getZlbMasterName(){
        return zlbMasterName;
    }

    public void setZlbMasterName(java.lang.String zlbMasterName){
        this.zlbMasterName = zlbMasterName;
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
