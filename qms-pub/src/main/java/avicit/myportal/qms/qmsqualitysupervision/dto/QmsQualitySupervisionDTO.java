package avicit.myportal.qms.qmsqualitysupervision.dto;

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
* @创建时间： 2026-08-05 18:17
* @类说明：质量监督表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualitySupervisionDTO", description = "质量监督表")
@PojoRemark(table="QMS_QUALITY_SUPERVISION", object="QmsQualitySupervisionDTO", name="质量监督表")
@ExcelIgnoreUnannotated
public class QmsQualitySupervisionDTO extends BeanDTO{
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
    * 监督CODE
    */
    @ExcelProperty("监督CODE")
    @Size(max = 50, message = "监督CODE长度不能超过50个字符")
    @ApiModelProperty(value = "监督CODE", name = "supervisionCode")
    @FieldRemark(column="SUPERVISION_CODE", field="supervisionCode", name="监督CODE")
    private java.lang.String supervisionCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;
    /**
    * 监督时间;质量部手动选择
    */
    @ExcelProperty("监督时间;质量部手动选择")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "监督时间;质量部手动选择", name = "supervisionTime")
    @FieldRemark(column="SUPERVISION_TIME", field="supervisionTime", name="监督时间;质量部手动选择")
    private java.util.Date supervisionTime;

    /**
    * 监督时间;质量部手动选择起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date supervisionTimeBegin;

    /**
    * 监督时间;质量部手动选择止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date supervisionTimeEnd;

    /**
    * 被监督单位ID
    */
    @ExcelProperty("被监督单位ID")
    @Size(max = 64, message = "被监督单位ID长度不能超过64个字符")
    @ApiModelProperty(value = "被监督单位ID", name = "supervisedDeptId")
    @FieldRemark(column="SUPERVISED_DEPT_ID", field="supervisedDeptId", name="被监督单位ID")
    private java.lang.String supervisedDeptId;

    /**
    * 被监督单位CODE
    */
    @ExcelProperty("被监督单位CODE")
    @Size(max = 10, message = "被监督单位CODE长度不能超过10个字符")
    @ApiModelProperty(value = "被监督单位CODE", name = "supervisedDeptCode")
    @FieldRemark(column="SUPERVISED_DEPT_CODE", field="supervisedDeptCode", name="被监督单位CODE")
    private java.lang.String supervisedDeptCode;

    /**
    * 被监督单位
    */
    @ExcelProperty("被监督单位")
    @Size(max = 128, message = "被监督单位长度不能超过128个字符")
    @ApiModelProperty(value = "被监督单位", name = "supervisedDeptName")
    @FieldRemark(column="SUPERVISED_DEPT_NAME", field="supervisedDeptName", name="被监督单位")
    private java.lang.String supervisedDeptName;

    /**
    * 检查员ID;多人，逗号分隔
    */
    @ExcelProperty("检查员ID;多人，逗号分隔")
    @Size(max = 512, message = "检查员ID;多人，逗号分隔长度不能超过512个字符")
    @ApiModelProperty(value = "检查员ID;多人，逗号分隔", name = "inspectorStaffId")
    @FieldRemark(column="INSPECTOR_STAFF_ID", field="inspectorStaffId", name="检查员ID;多人，逗号分隔")
    private java.lang.String inspectorStaffId;

    /**
    * 检查员CODE
    */
    @ExcelProperty("检查员CODE")
    @Size(max = 50, message = "检查员CODE长度不能超过50个字符")
    @ApiModelProperty(value = "检查员CODE", name = "inspectorStaffCode")
    @FieldRemark(column="INSPECTOR_STAFF_CODE", field="inspectorStaffCode", name="检查员CODE")
    private java.lang.String inspectorStaffCode;

    /**
    * 检查员
    */
    @ExcelProperty("检查员")
    @Size(max = 128, message = "检查员长度不能超过128个字符")
    @ApiModelProperty(value = "检查员", name = "inspectorStaffName")
    @FieldRemark(column="INSPECTOR_STAFF_NAME", field="inspectorStaffName", name="检查员")
    private java.lang.String inspectorStaffName;
    /**
    * 问题数量;质量部手写
    */
    @ExcelProperty("问题数量;质量部手写")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 10, fraction = 0, message = "问题数量;质量部手写格式不正确")
    @ApiModelProperty(value = "问题数量;质量部手写", name = "problemCount")
    @FieldRemark(column="PROBLEM_COUNT", field="problemCount", name="问题数量;质量部手写")
    private java.math.BigDecimal problemCount;
    /**
    * 完成时间;全部问题完成时填写
    */
    @ExcelProperty("完成时间;全部问题完成时填写")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "完成时间;全部问题完成时填写", name = "completionTime")
    @FieldRemark(column="COMPLETION_TIME", field="completionTime", name="完成时间;全部问题完成时填写")
    private java.util.Date completionTime;

    /**
    * 完成时间;全部问题完成时填写起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completionTimeBegin;

    /**
    * 完成时间;全部问题完成时填写止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completionTimeEnd;

    /**
    * 监督状态;业务状态
    */
    @ExcelProperty("监督状态;业务状态")
    @Size(max = 10, message = "监督状态;业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "监督状态;业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="监督状态;业务状态")
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

    public java.lang.String getSupervisionCode(){
        return supervisionCode;
    }

    public void setSupervisionCode(java.lang.String supervisionCode){
        this.supervisionCode = supervisionCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.util.Date getSupervisionTime(){
        return supervisionTime;
    }

    public void setSupervisionTime(java.util.Date supervisionTime){
        this.supervisionTime = supervisionTime;
        super.handleNullValue();
    }

    public java.util.Date getSupervisionTimeBegin(){
        return supervisionTimeBegin;
    }

    public void setSupervisionTimeBegin(java.util.Date supervisionTimeBegin){
        this.supervisionTimeBegin = supervisionTimeBegin;
    }

    public java.util.Date getSupervisionTimeEnd(){
        return supervisionTimeEnd;
    }

    public void setSupervisionTimeEnd(java.util.Date supervisionTimeEnd){
        this.supervisionTimeEnd = supervisionTimeEnd;
    }

    public java.lang.String getSupervisedDeptId(){
        return supervisedDeptId;
    }

    public void setSupervisedDeptId(java.lang.String supervisedDeptId){
        this.supervisedDeptId = supervisedDeptId;
    }

    public java.lang.String getSupervisedDeptCode(){
        return supervisedDeptCode;
    }

    public void setSupervisedDeptCode(java.lang.String supervisedDeptCode){
        this.supervisedDeptCode = supervisedDeptCode;
    }

    public java.lang.String getSupervisedDeptName(){
        return supervisedDeptName;
    }

    public void setSupervisedDeptName(java.lang.String supervisedDeptName){
        this.supervisedDeptName = supervisedDeptName;
    }

    public java.lang.String getInspectorStaffId(){
        return inspectorStaffId;
    }

    public void setInspectorStaffId(java.lang.String inspectorStaffId){
        this.inspectorStaffId = inspectorStaffId;
    }

    public java.lang.String getInspectorStaffCode(){
        return inspectorStaffCode;
    }

    public void setInspectorStaffCode(java.lang.String inspectorStaffCode){
        this.inspectorStaffCode = inspectorStaffCode;
    }

    public java.lang.String getInspectorStaffName(){
        return inspectorStaffName;
    }

    public void setInspectorStaffName(java.lang.String inspectorStaffName){
        this.inspectorStaffName = inspectorStaffName;
    }

    public java.math.BigDecimal getProblemCount(){
        return problemCount;
    }

    public void setProblemCount(java.math.BigDecimal problemCount){
        this.problemCount = problemCount;
        super.handleNullValue();
    }

    public java.util.Date getCompletionTime(){
        return completionTime;
    }

    public void setCompletionTime(java.util.Date completionTime){
        this.completionTime = completionTime;
        super.handleNullValue();
    }

    public java.util.Date getCompletionTimeBegin(){
        return completionTimeBegin;
    }

    public void setCompletionTimeBegin(java.util.Date completionTimeBegin){
        this.completionTimeBegin = completionTimeBegin;
    }

    public java.util.Date getCompletionTimeEnd(){
        return completionTimeEnd;
    }

    public void setCompletionTimeEnd(java.util.Date completionTimeEnd){
        this.completionTimeEnd = completionTimeEnd;
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
            return "质量监督表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量监督表";
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
