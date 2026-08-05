package avicit.myportal.qms.qmsqualityinspection.dto;

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
* @创建时间： 2026-08-05 18:15
* @类说明：质量检查表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityInspectionDTO", description = "质量检查表")
@PojoRemark(table="QMS_QUALITY_INSPECTION", object="QmsQualityInspectionDTO", name="质量检查表")
@ExcelIgnoreUnannotated
public class QmsQualityInspectionDTO extends BeanDTO{
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
    * 检查编号;检查编号+3位数流水号
    */
    @ExcelProperty("检查编号;检查编号+3位数流水号")
    @Size(max = 50, message = "检查编号;检查编号+3位数流水号长度不能超过50个字符")
    @ApiModelProperty(value = "检查编号;检查编号+3位数流水号", name = "inspectionCode")
    @FieldRemark(column="INSPECTION_CODE", field="inspectionCode", name="检查编号;检查编号+3位数流水号")
    private java.lang.String inspectionCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 检查名称;对XXX的专项检查
    */
    @ExcelProperty("检查名称;对XXX的专项检查")
    @Size(max = 256, message = "检查名称;对XXX的专项检查长度不能超过256个字符")
    @ApiModelProperty(value = "检查名称;对XXX的专项检查", name = "inspectName")
    @FieldRemark(column="INSPECT_NAME", field="inspectName", name="检查名称;对XXX的专项检查")
    private java.lang.String inspectName;

    /**
    * 被检查单位ID;检查单位名称/代号
    */
    @ExcelProperty("被检查单位ID;检查单位名称/代号")
    @Size(max = 64, message = "被检查单位ID;检查单位名称/代号长度不能超过64个字符")
    @ApiModelProperty(value = "被检查单位ID;检查单位名称/代号", name = "inspectedDeptId")
    @FieldRemark(column="INSPECTED_DEPT_ID", field="inspectedDeptId", name="被检查单位ID;检查单位名称/代号")
    private java.lang.String inspectedDeptId;

    /**
    * 被检查单位CODE
    */
    @ExcelProperty("被检查单位CODE")
    @Size(max = 10, message = "被检查单位CODE长度不能超过10个字符")
    @ApiModelProperty(value = "被检查单位CODE", name = "inspectedDeptCode")
    @FieldRemark(column="INSPECTED_DEPT_CODE", field="inspectedDeptCode", name="被检查单位CODE")
    private java.lang.String inspectedDeptCode;

    /**
    * 被检查单位
    */
    @ExcelProperty("被检查单位")
    @Size(max = 128, message = "被检查单位长度不能超过128个字符")
    @ApiModelProperty(value = "被检查单位", name = "inspectedDeptName")
    @FieldRemark(column="INSPECTED_DEPT_NAME", field="inspectedDeptName", name="被检查单位")
    private java.lang.String inspectedDeptName;

    /**
    * 涉及型号;多选，逗号分隔
    */
    @ExcelProperty("涉及型号;多选，逗号分隔")
    @Size(max = 1000, message = "涉及型号;多选，逗号分隔长度不能超过1000个字符")
    @ApiModelProperty(value = "涉及型号;多选，逗号分隔", name = "model")
    @FieldRemark(column="MODEL", field="model", name="涉及型号;多选，逗号分隔")
    private java.lang.String model;
    /**
    * 检查时间
    */
    @ExcelProperty("检查时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "检查时间", name = "inspectionTime")
    @FieldRemark(column="INSPECTION_TIME", field="inspectionTime", name="检查时间")
    private java.util.Date inspectionTime;

    /**
    * 检查时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date inspectionTimeBegin;

    /**
    * 检查时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date inspectionTimeEnd;
    /**
    * 检查投入
    */
    @ExcelProperty("检查投入")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 2, message = "检查投入格式不正确")
    @ApiModelProperty(value = "检查投入", name = "inspectionWorkload")
    @FieldRemark(column="INSPECTION_WORKLOAD", field="inspectionWorkload", name="检查投入")
    private java.math.BigDecimal inspectionWorkload;

    /**
    * 检查组长ID
    */
    @ExcelProperty("检查组长ID")
    @Size(max = 64, message = "检查组长ID长度不能超过64个字符")
    @ApiModelProperty(value = "检查组长ID", name = "leaderStaffId")
    @FieldRemark(column="LEADER_STAFF_ID", field="leaderStaffId", name="检查组长ID")
    private java.lang.String leaderStaffId;

    /**
    * 检查组长CODE
    */
    @ExcelProperty("检查组长CODE")
    @Size(max = 10, message = "检查组长CODE长度不能超过10个字符")
    @ApiModelProperty(value = "检查组长CODE", name = "leaderStaffCode")
    @FieldRemark(column="LEADER_STAFF_CODE", field="leaderStaffCode", name="检查组长CODE")
    private java.lang.String leaderStaffCode;

    /**
    * 检查组长
    */
    @ExcelProperty("检查组长")
    @Size(max = 50, message = "检查组长长度不能超过50个字符")
    @ApiModelProperty(value = "检查组长", name = "leaderStaffName")
    @FieldRemark(column="LEADER_STAFF_NAME", field="leaderStaffName", name="检查组长")
    private java.lang.String leaderStaffName;

    /**
    * 检查组成员ID
    */
    @ExcelProperty("检查组成员ID")
    @Size(max = 512, message = "检查组成员ID长度不能超过512个字符")
    @ApiModelProperty(value = "检查组成员ID", name = "memberStaffId")
    @FieldRemark(column="MEMBER_STAFF_ID", field="memberStaffId", name="检查组成员ID")
    private java.lang.String memberStaffId;

    /**
    * 检查组成员CODE
    */
    @ExcelProperty("检查组成员CODE")
    @Size(max = 50, message = "检查组成员CODE长度不能超过50个字符")
    @ApiModelProperty(value = "检查组成员CODE", name = "memberStaffCode")
    @FieldRemark(column="MEMBER_STAFF_CODE", field="memberStaffCode", name="检查组成员CODE")
    private java.lang.String memberStaffCode;

    /**
    * 检查组成员
    */
    @ExcelProperty("检查组成员")
    @Size(max = 128, message = "检查组成员长度不能超过128个字符")
    @ApiModelProperty(value = "检查组成员", name = "memberStaffName")
    @FieldRemark(column="MEMBER_STAFF_NAME", field="memberStaffName", name="检查组成员")
    private java.lang.String memberStaffName;
    /**
    * 问题数
    */
    @ExcelProperty("问题数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 2, message = "问题数格式不正确")
    @ApiModelProperty(value = "问题数", name = "problemCount")
    @FieldRemark(column="PROBLEM_COUNT", field="problemCount", name="问题数")
    private java.math.BigDecimal problemCount;
    /**
    * 完成整改数
    */
    @ExcelProperty("完成整改数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 2, message = "完成整改数格式不正确")
    @ApiModelProperty(value = "完成整改数", name = "completeCount")
    @FieldRemark(column="COMPLETE_COUNT", field="completeCount", name="完成整改数")
    private java.math.BigDecimal completeCount;
    /**
    * 完成时间
    */
    @ExcelProperty("完成时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "完成时间", name = "completeTime")
    @FieldRemark(column="COMPLETE_TIME", field="completeTime", name="完成时间")
    private java.util.Date completeTime;

    /**
    * 完成时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeBegin;

    /**
    * 完成时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date completeTimeEnd;

    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
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

    public java.lang.String getInspectionCode(){
        return inspectionCode;
    }

    public void setInspectionCode(java.lang.String inspectionCode){
        this.inspectionCode = inspectionCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getInspectName(){
        return inspectName;
    }

    public void setInspectName(java.lang.String inspectName){
        this.inspectName = inspectName;
    }

    public java.lang.String getInspectedDeptId(){
        return inspectedDeptId;
    }

    public void setInspectedDeptId(java.lang.String inspectedDeptId){
        this.inspectedDeptId = inspectedDeptId;
    }

    public java.lang.String getInspectedDeptCode(){
        return inspectedDeptCode;
    }

    public void setInspectedDeptCode(java.lang.String inspectedDeptCode){
        this.inspectedDeptCode = inspectedDeptCode;
    }

    public java.lang.String getInspectedDeptName(){
        return inspectedDeptName;
    }

    public void setInspectedDeptName(java.lang.String inspectedDeptName){
        this.inspectedDeptName = inspectedDeptName;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.util.Date getInspectionTime(){
        return inspectionTime;
    }

    public void setInspectionTime(java.util.Date inspectionTime){
        this.inspectionTime = inspectionTime;
        super.handleNullValue();
    }

    public java.util.Date getInspectionTimeBegin(){
        return inspectionTimeBegin;
    }

    public void setInspectionTimeBegin(java.util.Date inspectionTimeBegin){
        this.inspectionTimeBegin = inspectionTimeBegin;
    }

    public java.util.Date getInspectionTimeEnd(){
        return inspectionTimeEnd;
    }

    public void setInspectionTimeEnd(java.util.Date inspectionTimeEnd){
        this.inspectionTimeEnd = inspectionTimeEnd;
    }

    public java.math.BigDecimal getInspectionWorkload(){
        return inspectionWorkload;
    }

    public void setInspectionWorkload(java.math.BigDecimal inspectionWorkload){
        this.inspectionWorkload = inspectionWorkload;
        super.handleNullValue();
    }

    public java.lang.String getLeaderStaffId(){
        return leaderStaffId;
    }

    public void setLeaderStaffId(java.lang.String leaderStaffId){
        this.leaderStaffId = leaderStaffId;
    }

    public java.lang.String getLeaderStaffCode(){
        return leaderStaffCode;
    }

    public void setLeaderStaffCode(java.lang.String leaderStaffCode){
        this.leaderStaffCode = leaderStaffCode;
    }

    public java.lang.String getLeaderStaffName(){
        return leaderStaffName;
    }

    public void setLeaderStaffName(java.lang.String leaderStaffName){
        this.leaderStaffName = leaderStaffName;
    }

    public java.lang.String getMemberStaffId(){
        return memberStaffId;
    }

    public void setMemberStaffId(java.lang.String memberStaffId){
        this.memberStaffId = memberStaffId;
    }

    public java.lang.String getMemberStaffCode(){
        return memberStaffCode;
    }

    public void setMemberStaffCode(java.lang.String memberStaffCode){
        this.memberStaffCode = memberStaffCode;
    }

    public java.lang.String getMemberStaffName(){
        return memberStaffName;
    }

    public void setMemberStaffName(java.lang.String memberStaffName){
        this.memberStaffName = memberStaffName;
    }

    public java.math.BigDecimal getProblemCount(){
        return problemCount;
    }

    public void setProblemCount(java.math.BigDecimal problemCount){
        this.problemCount = problemCount;
        super.handleNullValue();
    }

    public java.math.BigDecimal getCompleteCount(){
        return completeCount;
    }

    public void setCompleteCount(java.math.BigDecimal completeCount){
        this.completeCount = completeCount;
        super.handleNullValue();
    }

    public java.util.Date getCompleteTime(){
        return completeTime;
    }

    public void setCompleteTime(java.util.Date completeTime){
        this.completeTime = completeTime;
        super.handleNullValue();
    }

    public java.util.Date getCompleteTimeBegin(){
        return completeTimeBegin;
    }

    public void setCompleteTimeBegin(java.util.Date completeTimeBegin){
        this.completeTimeBegin = completeTimeBegin;
    }

    public java.util.Date getCompleteTimeEnd(){
        return completeTimeEnd;
    }

    public void setCompleteTimeEnd(java.util.Date completeTimeEnd){
        this.completeTimeEnd = completeTimeEnd;
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
            return "质量检查表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量检查表";
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
