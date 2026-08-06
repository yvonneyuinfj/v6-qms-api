package avicit.myportal.qms.qmsqualityreward.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BeanDTO;
import avicit.myportal.qms.qmsqualityrewardcontributeor.dto.QmsQualityRewardContributeorDTO;
import avicit.platform6.core.domain.ValidationList;
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
* @类说明：质量奖励申请表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityRewardDTO", description = "质量奖励申请表")
@PojoRemark(table="QMS_QUALITY_REWARD", object="QmsQualityRewardDTO", name="质量奖励申请表")
@ExcelIgnoreUnannotated
public class QmsQualityRewardDTO extends BeanDTO{
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
    * 项目名称
    */
    @ExcelProperty("项目名称")
    @Size(max = 256, message = "项目名称长度不能超过256个字符")
    @ApiModelProperty(value = "项目名称", name = "awardProjectName")
    @FieldRemark(column="AWARD_PROJECT_NAME", field="awardProjectName", name="项目名称")
    private java.lang.String awardProjectName;

    /**
    * 涉及型号
    */
    @ExcelProperty("涉及型号")
    @Size(max = 256, message = "涉及型号长度不能超过256个字符")
    @ApiModelProperty(value = "涉及型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="涉及型号")
    private java.lang.String model;
    /**
    * 参与人员数量
    */
    @ExcelProperty("参与人员数量")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 0, message = "参与人员数量格式不正确")
    @ApiModelProperty(value = "参与人员数量", name = "participantCount")
    @FieldRemark(column="PARTICIPANT_COUNT", field="participantCount", name="参与人员数量")
    private java.math.BigDecimal participantCount;

    /**
    * 经济效益预估
    */
    @ExcelProperty("经济效益预估")
    @Size(max = 512, message = "经济效益预估长度不能超过512个字符")
    @ApiModelProperty(value = "经济效益预估", name = "economicBenefitEstimate")
    @FieldRemark(column="ECONOMIC_BENEFIT_ESTIMATE", field="economicBenefitEstimate", name="经济效益预估")
    private java.lang.String economicBenefitEstimate;

    /**
    * 奖励类型;部门、个人，可多选
    */
    @ExcelProperty("奖励类型;部门、个人，可多选")
    @Size(max = 50, message = "奖励类型;部门、个人，可多选长度不能超过50个字符")
    @ApiModelProperty(value = "奖励类型;部门、个人，可多选", name = "awardType")
    @FieldRemark(column="AWARD_TYPE", field="awardType", name="奖励类型;部门、个人，可多选")
    private java.lang.String awardType;

    /**
    * 申报/推荐事由;说明事迹具体情况和每个奖励人员的作用和贡献.（限定不超过500字）事迹应包括时间、型号和产品名称、地点、人员和所在单位、事迹内容、取得的效果（如避免较大经济损失、指标改善明显，通过发现问题形成改进完善了体系标准得以推广应用等）。
    */
    @ExcelProperty("申报/推荐事由;说明事迹具体情况和每个奖励人员的作用和贡献.（限定不超过500字）事迹应包括时间、型号和产品名称、地点、人员和所在单位、事迹内容、取得的效果（如避免较大经济损失、指标改善明显，通过发现问题形成改进完善了体系标准得以推广应用等）。")
    @Size(max = 2000, message = "申报/推荐事由;说明事迹具体情况和每个奖励人员的作用和贡献.（限定不超过500字）事迹应包括时间、型号和产品名称、地点、人员和所在单位、事迹内容、取得的效果（如避免较大经济损失、指标改善明显，通过发现问题形成改进完善了体系标准得以推广应用等）。长度不能超过2000个字符")
    @ApiModelProperty(value = "申报/推荐事由;说明事迹具体情况和每个奖励人员的作用和贡献.（限定不超过500字）事迹应包括时间、型号和产品名称、地点、人员和所在单位、事迹内容、取得的效果（如避免较大经济损失、指标改善明显，通过发现问题形成改进完善了体系标准得以推广应用等）。", name = "applyReason")
    @FieldRemark(column="APPLY_REASON", field="applyReason", name="申报/推荐事由;说明事迹具体情况和每个奖励人员的作用和贡献.（限定不超过500字）事迹应包括时间、型号和产品名称、地点、人员和所在单位、事迹内容、取得的效果（如避免较大经济损失、指标改善明显，通过发现问题形成改进完善了体系标准得以推广应用等）。")
    private java.lang.String applyReason;

    /**
    * 引用条款
    */
    @ExcelProperty("引用条款")
    @Size(max = 256, message = "引用条款长度不能超过256个字符")
    @ApiModelProperty(value = "引用条款", name = "mainClauseName")
    @FieldRemark(column="MAIN_CLAUSE_NAME", field="mainClauseName", name="引用条款")
    private java.lang.String mainClauseName;

    /**
    * 一级条款CODE
    */
    @ExcelProperty("一级条款CODE")
    @Size(max = 50, message = "一级条款CODE长度不能超过50个字符")
    @ApiModelProperty(value = "一级条款CODE", name = "clauseLevel1Code")
    @FieldRemark(column="CLAUSE_LEVEL1_CODE", field="clauseLevel1Code", name="一级条款CODE")
    private java.lang.String clauseLevel1Code;

    /**
    * 二级条款CODE
    */
    @ExcelProperty("二级条款CODE")
    @Size(max = 50, message = "二级条款CODE长度不能超过50个字符")
    @ApiModelProperty(value = "二级条款CODE", name = "clauseLevel2Code")
    @FieldRemark(column="CLAUSE_LEVEL2_CODE", field="clauseLevel2Code", name="二级条款CODE")
    private java.lang.String clauseLevel2Code;

    /**
    * 活动前效果
    */
    @ExcelProperty("活动前效果")
    @Size(max = 2000, message = "活动前效果长度不能超过2000个字符")
    @ApiModelProperty(value = "活动前效果", name = "beforeEffectDesc")
    @FieldRemark(column="BEFORE_EFFECT_DESC", field="beforeEffectDesc", name="活动前效果")
    private java.lang.String beforeEffectDesc;

    /**
    * 活动后效果
    */
    @ExcelProperty("活动后效果")
    @Size(max = 2000, message = "活动后效果长度不能超过2000个字符")
    @ApiModelProperty(value = "活动后效果", name = "afterEffectDesc")
    @FieldRemark(column="AFTER_EFFECT_DESC", field="afterEffectDesc", name="活动后效果")
    private java.lang.String afterEffectDesc;

    /**
    * 质量事迹简介;不超过400字
    */
    @ExcelProperty("质量事迹简介;不超过400字")
    @Size(max = 2000, message = "质量事迹简介;不超过400字长度不能超过2000个字符")
    @ApiModelProperty(value = "质量事迹简介;不超过400字", name = "qualityDeedDesc")
    @FieldRemark(column="QUALITY_DEED_DESC", field="qualityDeedDesc", name="质量事迹简介;不超过400字")
    private java.lang.String qualityDeedDesc;

    /**
    * 运用的先进质量工具或方法
    */
    @ExcelProperty("运用的先进质量工具或方法")
    @Size(max = 2000, message = "运用的先进质量工具或方法长度不能超过2000个字符")
    @ApiModelProperty(value = "运用的先进质量工具或方法", name = "advancedToolMethod")
    @FieldRemark(column="ADVANCED_TOOL_METHOD", field="advancedToolMethod", name="运用的先进质量工具或方法")
    private java.lang.String advancedToolMethod;

    /**
    * 优化的流程体系文件名称
    */
    @ExcelProperty("优化的流程体系文件名称")
    @Size(max = 2000, message = "优化的流程体系文件名称长度不能超过2000个字符")
    @ApiModelProperty(value = "优化的流程体系文件名称", name = "optimizedSystemFileName")
    @FieldRemark(column="OPTIMIZED_SYSTEM_FILE_NAME", field="optimizedSystemFileName", name="优化的流程体系文件名称")
    private java.lang.String optimizedSystemFileName;

    /**
    * 优化的流程体系文件编号
    */
    @ExcelProperty("优化的流程体系文件编号")
    @Size(max = 2000, message = "优化的流程体系文件编号长度不能超过2000个字符")
    @ApiModelProperty(value = "优化的流程体系文件编号", name = "optimizedSystemFileNameNo")
    @FieldRemark(column="OPTIMIZED_SYSTEM_FILE_NAME_NO", field="optimizedSystemFileNameNo", name="优化的流程体系文件编号")
    private java.lang.String optimizedSystemFileNameNo;

    /**
    * 奖励编号
    */
    @ExcelProperty("奖励编号")
    @Size(max = 50, message = "奖励编号长度不能超过50个字符")
    @ApiModelProperty(value = "奖励编号", name = "rewardCode")
    @FieldRemark(column="REWARD_CODE", field="rewardCode", name="奖励编号")
    private java.lang.String rewardCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 申报人ID
    */
    @ExcelProperty("申报人ID")
    @Size(max = 64, message = "申报人ID长度不能超过64个字符")
    @ApiModelProperty(value = "申报人ID", name = "applyStaffId")
    @FieldRemark(column="APPLY_STAFF_ID", field="applyStaffId", name="申报人ID")
    private java.lang.String applyStaffId;

    /**
    * 申报人CODE
    */
    @ExcelProperty("申报人CODE")
    @Size(max = 10, message = "申报人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申报人CODE", name = "applyStaffCode")
    @FieldRemark(column="APPLY_STAFF_CODE", field="applyStaffCode", name="申报人CODE")
    private java.lang.String applyStaffCode;

    /**
    * 申报人
    */
    @ExcelProperty("申报人")
    @Size(max = 50, message = "申报人长度不能超过50个字符")
    @ApiModelProperty(value = "申报人", name = "applyStaffName")
    @FieldRemark(column="APPLY_STAFF_NAME", field="applyStaffName", name="申报人")
    private java.lang.String applyStaffName;

    /**
    * 申报单位ID
    */
    @ExcelProperty("申报单位ID")
    @Size(max = 64, message = "申报单位ID长度不能超过64个字符")
    @ApiModelProperty(value = "申报单位ID", name = "applyDeptId")
    @FieldRemark(column="APPLY_DEPT_ID", field="applyDeptId", name="申报单位ID")
    private java.lang.String applyDeptId;

    /**
    * 申报单位CODE
    */
    @ExcelProperty("申报单位CODE")
    @Size(max = 10, message = "申报单位CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申报单位CODE", name = "applyDeptCode")
    @FieldRemark(column="APPLY_DEPT_CODE", field="applyDeptCode", name="申报单位CODE")
    private java.lang.String applyDeptCode;

    /**
    * 申报单位
    */
    @ExcelProperty("申报单位")
    @Size(max = 128, message = "申报单位长度不能超过128个字符")
    @ApiModelProperty(value = "申报单位", name = "applyDeptName")
    @FieldRemark(column="APPLY_DEPT_NAME", field="applyDeptName", name="申报单位")
    private java.lang.String applyDeptName;
    /**
    * 申报时间
    */
    @ExcelProperty("申报时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "申报时间", name = "applyTime")
    @FieldRemark(column="APPLY_TIME", field="applyTime", name="申报时间")
    private java.util.Date applyTime;

    /**
    * 申报时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date applyTimeBegin;

    /**
    * 申报时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date applyTimeEnd;

    /**
    * 质量信息上报确认;YA
    */
    @ExcelProperty("质量信息上报确认")
    @Size(max = 10, message = "质量信息上报确认长度不能超过10个字符")
    @ApiModelProperty(value = "质量信息上报确认", name = "qualityInfoReportResult")
    @FieldRemark(column="QUALITY_INFO_REPORT_RESULT", field="qualityInfoReportResult", name="质量信息上报确认;YA")
    private java.lang.String qualityInfoReportResult;

    /**
    * 按期归零或关闭确认;YA
    */
    @ExcelProperty("按期归零或关闭确认;YA")
    @Size(max = 10, message = "按期归零或关闭确认;YA长度不能超过10个字符")
    @ApiModelProperty(value = "按期归零或关闭确认;YA", name = "zeroCloseResult")
    @FieldRemark(column="ZERO_CLOSE_RESULT", field="zeroCloseResult", name="按期归零或关闭确认;YA")
    private java.lang.String zeroCloseResult;

    /**
    * 体系符合性确认;YA
    */
    @ExcelProperty("体系符合性确认;YA")
    @Size(max = 10, message = "体系符合性确认;YA长度不能超过10个字符")
    @ApiModelProperty(value = "体系符合性确认;YA", name = "qmsComplianceResult")
    @FieldRemark(column="QMS_COMPLIANCE_RESULT", field="qmsComplianceResult", name="体系符合性确认;YA")
    private java.lang.String qmsComplianceResult;

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
     * 子表对象集合
     */
    private ValidationList<QmsQualityRewardContributeorDTO> qmsQualityRewardContributeorList;
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

    public java.lang.String getAwardProjectName(){
        return awardProjectName;
    }

    public void setAwardProjectName(java.lang.String awardProjectName){
        this.awardProjectName = awardProjectName;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.math.BigDecimal getParticipantCount(){
        return participantCount;
    }

    public void setParticipantCount(java.math.BigDecimal participantCount){
        this.participantCount = participantCount;
        super.handleNullValue();
    }

    public java.lang.String getEconomicBenefitEstimate(){
        return economicBenefitEstimate;
    }

    public void setEconomicBenefitEstimate(java.lang.String economicBenefitEstimate){
        this.economicBenefitEstimate = economicBenefitEstimate;
    }

    public java.lang.String getAwardType(){
        return awardType;
    }

    public void setAwardType(java.lang.String awardType){
        this.awardType = awardType;
    }

    public java.lang.String getApplyReason(){
        return applyReason;
    }

    public void setApplyReason(java.lang.String applyReason){
        this.applyReason = applyReason;
    }

    public java.lang.String getMainClauseName(){
        return mainClauseName;
    }

    public void setMainClauseName(java.lang.String mainClauseName){
        this.mainClauseName = mainClauseName;
    }

    public java.lang.String getClauseLevel1Code(){
        return clauseLevel1Code;
    }

    public void setClauseLevel1Code(java.lang.String clauseLevel1Code){
        this.clauseLevel1Code = clauseLevel1Code;
    }

    public java.lang.String getClauseLevel2Code(){
        return clauseLevel2Code;
    }

    public void setClauseLevel2Code(java.lang.String clauseLevel2Code){
        this.clauseLevel2Code = clauseLevel2Code;
    }

    public java.lang.String getBeforeEffectDesc(){
        return beforeEffectDesc;
    }

    public void setBeforeEffectDesc(java.lang.String beforeEffectDesc){
        this.beforeEffectDesc = beforeEffectDesc;
    }

    public java.lang.String getAfterEffectDesc(){
        return afterEffectDesc;
    }

    public void setAfterEffectDesc(java.lang.String afterEffectDesc){
        this.afterEffectDesc = afterEffectDesc;
    }

    public java.lang.String getQualityDeedDesc(){
        return qualityDeedDesc;
    }

    public void setQualityDeedDesc(java.lang.String qualityDeedDesc){
        this.qualityDeedDesc = qualityDeedDesc;
    }

    public java.lang.String getAdvancedToolMethod(){
        return advancedToolMethod;
    }

    public void setAdvancedToolMethod(java.lang.String advancedToolMethod){
        this.advancedToolMethod = advancedToolMethod;
    }

    public java.lang.String getOptimizedSystemFileName(){
        return optimizedSystemFileName;
    }

    public void setOptimizedSystemFileName(java.lang.String optimizedSystemFileName){
        this.optimizedSystemFileName = optimizedSystemFileName;
    }

    public java.lang.String getOptimizedSystemFileNameNo(){
        return optimizedSystemFileNameNo;
    }

    public void setOptimizedSystemFileNameNo(java.lang.String optimizedSystemFileNameNo){
        this.optimizedSystemFileNameNo = optimizedSystemFileNameNo;
    }

    public java.lang.String getRewardCode(){
        return rewardCode;
    }

    public void setRewardCode(java.lang.String rewardCode){
        this.rewardCode = rewardCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getApplyStaffId(){
        return applyStaffId;
    }

    public void setApplyStaffId(java.lang.String applyStaffId){
        this.applyStaffId = applyStaffId;
    }

    public java.lang.String getApplyStaffCode(){
        return applyStaffCode;
    }

    public void setApplyStaffCode(java.lang.String applyStaffCode){
        this.applyStaffCode = applyStaffCode;
    }

    public java.lang.String getApplyStaffName(){
        return applyStaffName;
    }

    public void setApplyStaffName(java.lang.String applyStaffName){
        this.applyStaffName = applyStaffName;
    }

    public java.lang.String getApplyDeptId(){
        return applyDeptId;
    }

    public void setApplyDeptId(java.lang.String applyDeptId){
        this.applyDeptId = applyDeptId;
    }

    public java.lang.String getApplyDeptCode(){
        return applyDeptCode;
    }

    public void setApplyDeptCode(java.lang.String applyDeptCode){
        this.applyDeptCode = applyDeptCode;
    }

    public java.lang.String getApplyDeptName(){
        return applyDeptName;
    }

    public void setApplyDeptName(java.lang.String applyDeptName){
        this.applyDeptName = applyDeptName;
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

    public java.lang.String getQualityInfoReportResult(){
        return qualityInfoReportResult;
    }

    public void setQualityInfoReportResult(java.lang.String qualityInfoReportResult){
        this.qualityInfoReportResult = qualityInfoReportResult;
    }

    public java.lang.String getZeroCloseResult(){
        return zeroCloseResult;
    }

    public void setZeroCloseResult(java.lang.String zeroCloseResult){
        this.zeroCloseResult = zeroCloseResult;
    }

    public java.lang.String getQmsComplianceResult(){
        return qmsComplianceResult;
    }

    public void setQmsComplianceResult(java.lang.String qmsComplianceResult){
        this.qmsComplianceResult = qmsComplianceResult;
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

    public ValidationList<QmsQualityRewardContributeorDTO> getQmsQualityRewardContributeorList() {
        return qmsQualityRewardContributeorList;
    }

    public void setQmsQualityRewardContributeorList(ValidationList<QmsQualityRewardContributeorDTO> qmsQualityRewardContributeorList) {
        this.qmsQualityRewardContributeorList = qmsQualityRewardContributeorList;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "质量奖励申请表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量奖励申请表";
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
