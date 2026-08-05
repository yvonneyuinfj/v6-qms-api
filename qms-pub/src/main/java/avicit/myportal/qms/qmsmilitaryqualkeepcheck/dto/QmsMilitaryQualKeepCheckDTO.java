package avicit.myportal.qms.qmsmilitaryqualkeepcheck.dto;

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
* @创建时间： 2026-08-05 18:09
* @类说明：资格保持自查表DTO
* @修改记录：
*/
@ApiModel(value = "QmsMilitaryQualKeepCheckDTO", description = "资格保持自查表")
@PojoRemark(table="QMS_MILITARY_QUAL_KEEP_CHECK", object="QmsMilitaryQualKeepCheckDTO", name="资格保持自查表")
@ExcelIgnoreUnannotated
public class QmsMilitaryQualKeepCheckDTO extends BeanDTO{
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
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;
    /**
    * 开始时间
    */
    @ExcelProperty("开始时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "开始时间", name = "startTime")
    @FieldRemark(column="START_TIME", field="startTime", name="开始时间")
    private java.util.Date startTime;

    /**
    * 开始时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeBegin;

    /**
    * 开始时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date startTimeEnd;
    /**
    * 结束时间
    */
    @ExcelProperty("结束时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "结束时间", name = "endTime")
    @FieldRemark(column="END_TIME", field="endTime", name="结束时间")
    private java.util.Date endTime;

    /**
    * 结束时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date endTimeBegin;

    /**
    * 结束时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date endTimeEnd;

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
    * 自查内容编码
    */
    @ExcelProperty("自查内容编码")
    @Size(max = 64, message = "自查内容编码长度不能超过64个字符")
    @ApiModelProperty(value = "自查内容编码", name = "itemCode")
    @FieldRemark(column="ITEM_CODE", field="itemCode", name="自查内容编码")
    private java.lang.String itemCode;

    /**
    * 自查内容
    */
    @ExcelProperty("自查内容")
    @Size(max = 256, message = "自查内容长度不能超过256个字符")
    @ApiModelProperty(value = "自查内容", name = "checkContent")
    @FieldRemark(column="CHECK_CONTENT", field="checkContent", name="自查内容")
    private java.lang.String checkContent;

    /**
    * 自查结论;正常/异常
    */
    @ExcelProperty("自查结论;正常/异常")
    @Size(max = 10, message = "自查结论;正常/异常长度不能超过10个字符")
    @ApiModelProperty(value = "自查结论;正常/异常", name = "checkConclusion")
    @FieldRemark(column="CHECK_CONCLUSION", field="checkConclusion", name="自查结论;正常/异常")
    private java.lang.String checkConclusion;

    /**
    * 事项说明;结论为“异常”时必填
    */
    @ExcelProperty("事项说明;结论为“异常”时必填")
    @Size(max = 2000, message = "事项说明;结论为“异常”时必填长度不能超过2000个字符")
    @ApiModelProperty(value = "事项说明;结论为“异常”时必填", name = "matterDesc")
    @FieldRemark(column="MATTER_DESC", field="matterDesc", name="事项说明;结论为“异常”时必填")
    private java.lang.String matterDesc;

    /**
    * 自查周期CODE
    */
    @ExcelProperty("自查周期CODE")
    @Size(max = 50, message = "自查周期CODE长度不能超过50个字符")
    @ApiModelProperty(value = "自查周期CODE", name = "periodCode")
    @FieldRemark(column="PERIOD_CODE", field="periodCode", name="自查周期CODE")
    private java.lang.String periodCode;

    /**
    * 显示序号
    */
    @ExcelProperty("显示序号")
    @Size(max = 20, message = "显示序号长度不能超过20个字符")
    @ApiModelProperty(value = "显示序号", name = "itemNo")
    @FieldRemark(column="ITEM_NO", field="itemNo", name="显示序号")
    private java.lang.String itemNo;

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

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.util.Date getStartTime(){
        return startTime;
    }

    public void setStartTime(java.util.Date startTime){
        this.startTime = startTime;
        super.handleNullValue();
    }

    public java.util.Date getStartTimeBegin(){
        return startTimeBegin;
    }

    public void setStartTimeBegin(java.util.Date startTimeBegin){
        this.startTimeBegin = startTimeBegin;
    }

    public java.util.Date getStartTimeEnd(){
        return startTimeEnd;
    }

    public void setStartTimeEnd(java.util.Date startTimeEnd){
        this.startTimeEnd = startTimeEnd;
    }

    public java.util.Date getEndTime(){
        return endTime;
    }

    public void setEndTime(java.util.Date endTime){
        this.endTime = endTime;
        super.handleNullValue();
    }

    public java.util.Date getEndTimeBegin(){
        return endTimeBegin;
    }

    public void setEndTimeBegin(java.util.Date endTimeBegin){
        this.endTimeBegin = endTimeBegin;
    }

    public java.util.Date getEndTimeEnd(){
        return endTimeEnd;
    }

    public void setEndTimeEnd(java.util.Date endTimeEnd){
        this.endTimeEnd = endTimeEnd;
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

    public java.lang.String getItemCode(){
        return itemCode;
    }

    public void setItemCode(java.lang.String itemCode){
        this.itemCode = itemCode;
    }

    public java.lang.String getCheckContent(){
        return checkContent;
    }

    public void setCheckContent(java.lang.String checkContent){
        this.checkContent = checkContent;
    }

    public java.lang.String getCheckConclusion(){
        return checkConclusion;
    }

    public void setCheckConclusion(java.lang.String checkConclusion){
        this.checkConclusion = checkConclusion;
    }

    public java.lang.String getMatterDesc(){
        return matterDesc;
    }

    public void setMatterDesc(java.lang.String matterDesc){
        this.matterDesc = matterDesc;
    }

    public java.lang.String getPeriodCode(){
        return periodCode;
    }

    public void setPeriodCode(java.lang.String periodCode){
        this.periodCode = periodCode;
    }

    public java.lang.String getItemNo(){
        return itemNo;
    }

    public void setItemNo(java.lang.String itemNo){
        this.itemNo = itemNo;
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
            return "资格保持自查表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "资格保持自查表";
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
