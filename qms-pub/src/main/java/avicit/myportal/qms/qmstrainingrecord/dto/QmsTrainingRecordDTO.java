package avicit.myportal.qms.qmstrainingrecord.dto;

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
* @创建时间： 2026-08-04 15:01
* @类说明：质量培训台账表DTO
* @修改记录：
*/
@ApiModel(value = "QmsTrainingRecordDTO", description = "质量培训台账表")
@PojoRemark(table="QMS_TRAINING_RECORD", object="QmsTrainingRecordDTO", name="质量培训台账表")
@ExcelIgnoreUnannotated
public class QmsTrainingRecordDTO extends BeanDTO{
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
    * 培训编号
    */
    @ExcelProperty("培训编号")
    @Size(max = 64, message = "培训编号长度不能超过64个字符")
    @ApiModelProperty(value = "培训编号", name = "trainingNumber")
    @FieldRemark(column="TRAINING_NUMBER", field="trainingNumber", name="培训编号")
    private java.lang.String trainingNumber;

    /**
    * 培训题目
    */
    @ExcelProperty("培训题目")
    @Size(max = 128, message = "培训题目长度不能超过128个字符")
    @ApiModelProperty(value = "培训题目", name = "trainingTitle")
    @FieldRemark(column="TRAINING_TITLE", field="trainingTitle", name="培训题目")
    private java.lang.String trainingTitle;
    /**
    * 培训日期
    */
    @ExcelProperty("培训日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "培训日期", name = "trainingDate")
    @FieldRemark(column="TRAINING_DATE", field="trainingDate", name="培训日期")
    private java.util.Date trainingDate;

    /**
    * 培训日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date trainingDateBegin;

    /**
    * 培训日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date trainingDateEnd;

    /**
    * 培训地点类型
    */
    @ExcelProperty("培训地点类型")
    @Size(max = 64, message = "培训地点类型长度不能超过64个字符")
    @ApiModelProperty(value = "培训地点类型", name = "trainingPositionType")
    @FieldRemark(column="TRAINING_POSITION_TYPE", field="trainingPositionType", name="培训地点类型")
    private java.lang.String trainingPositionType;

    /**
    * 培训地点
    */
    @ExcelProperty("培训地点")
    @Size(max = 64, message = "培训地点长度不能超过64个字符")
    @ApiModelProperty(value = "培训地点", name = "trainingPosition")
    @FieldRemark(column="TRAINING_POSITION", field="trainingPosition", name="培训地点")
    private java.lang.String trainingPosition;

    /**
    * 培训教师ID
    */
    @ExcelProperty("培训教师ID")
    @Size(max = 64, message = "培训教师ID长度不能超过64个字符")
    @ApiModelProperty(value = "培训教师ID", name = "trainingId")
    @FieldRemark(column="TRAINING_ID", field="trainingId", name="培训教师ID")
    private java.lang.String trainingId;

    /**
    * 培训教师职工号
    */
    @ExcelProperty("培训教师职工号")
    @Size(max = 64, message = "培训教师职工号长度不能超过64个字符")
    @ApiModelProperty(value = "培训教师职工号", name = "trainingTeacherCode")
    @FieldRemark(column="TRAINING_TEACHER_CODE", field="trainingTeacherCode", name="培训教师职工号")
    private java.lang.String trainingTeacherCode;

    /**
    * 培训教师
    */
    @ExcelProperty("培训教师")
    @Size(max = 128, message = "培训教师长度不能超过128个字符")
    @ApiModelProperty(value = "培训教师", name = "trainingTeacher")
    @FieldRemark(column="TRAINING_TEACHER", field="trainingTeacher", name="培训教师")
    private java.lang.String trainingTeacher;

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

    public java.lang.String getTrainingNumber(){
        return trainingNumber;
    }

    public void setTrainingNumber(java.lang.String trainingNumber){
        this.trainingNumber = trainingNumber;
    }

    public java.lang.String getTrainingTitle(){
        return trainingTitle;
    }

    public void setTrainingTitle(java.lang.String trainingTitle){
        this.trainingTitle = trainingTitle;
    }

    public java.util.Date getTrainingDate(){
        return trainingDate;
    }

    public void setTrainingDate(java.util.Date trainingDate){
        this.trainingDate = trainingDate;
        super.handleNullValue();
    }

    public java.util.Date getTrainingDateBegin(){
        return trainingDateBegin;
    }

    public void setTrainingDateBegin(java.util.Date trainingDateBegin){
        this.trainingDateBegin = trainingDateBegin;
    }

    public java.util.Date getTrainingDateEnd(){
        return trainingDateEnd;
    }

    public void setTrainingDateEnd(java.util.Date trainingDateEnd){
        this.trainingDateEnd = trainingDateEnd;
    }

    public java.lang.String getTrainingPositionType(){
        return trainingPositionType;
    }

    public void setTrainingPositionType(java.lang.String trainingPositionType){
        this.trainingPositionType = trainingPositionType;
    }

    public java.lang.String getTrainingPosition(){
        return trainingPosition;
    }

    public void setTrainingPosition(java.lang.String trainingPosition){
        this.trainingPosition = trainingPosition;
    }

    public java.lang.String getTrainingId(){
        return trainingId;
    }

    public void setTrainingId(java.lang.String trainingId){
        this.trainingId = trainingId;
    }

    public java.lang.String getTrainingTeacherCode(){
        return trainingTeacherCode;
    }

    public void setTrainingTeacherCode(java.lang.String trainingTeacherCode){
        this.trainingTeacherCode = trainingTeacherCode;
    }

    public java.lang.String getTrainingTeacher(){
        return trainingTeacher;
    }

    public void setTrainingTeacher(java.lang.String trainingTeacher){
        this.trainingTeacher = trainingTeacher;
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
            return "质量培训台账表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量培训台账表";
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
