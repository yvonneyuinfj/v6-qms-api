package avicit.myportal.qms.qmsqualityactivity.dto;

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
* @创建时间： 2026-08-06 15:52
* @类说明：质量活动台账表DTO
* @修改记录：
*/
@ApiModel(value = "QmsQualityActivityDTO", description = "质量活动台账表")
@PojoRemark(table="QMS_QUALITY_ACTIVITY", object="QmsQualityActivityDTO", name="质量活动台账表")
@ExcelIgnoreUnannotated
public class QmsQualityActivityDTO extends BeanDTO{
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
    * 活动编号;自动生成，QC/BZ/GG年份号-3位流水号
    */
    @ExcelProperty("活动编号;自动生成，QC/BZ/GG年份号-3位流水号")
    @Size(max = 50, message = "活动编号;自动生成，QC/BZ/GG年份号-3位流水号长度不能超过50个字符")
    @ApiModelProperty(value = "活动编号;自动生成，QC/BZ/GG年份号-3位流水号", name = "activityCode")
    @FieldRemark(column="ACTIVITY_CODE", field="activityCode", name="活动编号;自动生成，QC/BZ/GG年份号-3位流水号")
    private java.lang.String activityCode;

    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    @ApiModelProperty(value = "所属年份", name = "forYear")
    @FieldRemark(column="FOR_YEAR", field="forYear", name="所属年份")
    private java.lang.String forYear;

    /**
    * 活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目
    */
    @ExcelProperty("活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目")
    @Size(max = 50, message = "活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目长度不能超过50个字符")
    @ApiModelProperty(value = "活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目", name = "activityType")
    @FieldRemark(column="ACTIVITY_TYPE", field="activityType", name="活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目")
    private java.lang.String activityType;

    /**
    * 课题/班组/项目名称
    */
    @ExcelProperty("课题/班组/项目名称")
    @Size(max = 256, message = "课题/班组/项目名称长度不能超过256个字符")
    @ApiModelProperty(value = "课题/班组/项目名称", name = "activityName")
    @FieldRemark(column="ACTIVITY_NAME", field="activityName", name="课题/班组/项目名称")
    private java.lang.String activityName;

    /**
    * 成员ID
    */
    @ExcelProperty("成员ID")
    @Size(max = 3200, message = "成员ID长度不能超过3200个字符")
    @ApiModelProperty(value = "成员ID", name = "membebrId")
    @FieldRemark(column="MEMBEBR_ID", field="membebrId", name="成员ID")
    private java.lang.String membebrId;

    /**
    * 成员CODE
    */
    @ExcelProperty("成员CODE")
    @Size(max = 256, message = "成员CODE长度不能超过256个字符")
    @ApiModelProperty(value = "成员CODE", name = "memberCode")
    @FieldRemark(column="MEMBER_CODE", field="memberCode", name="成员CODE")
    private java.lang.String memberCode;

    /**
    * 成员
    */
    @ExcelProperty("成员")
    @Size(max = 512, message = "成员长度不能超过512个字符")
    @ApiModelProperty(value = "成员", name = "memberName")
    @FieldRemark(column="MEMBER_NAME", field="memberName", name="成员")
    private java.lang.String memberName;
    /**
    * 人数
    */
    @ExcelProperty("人数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 4, fraction = 0, message = "人数格式不正确")
    @ApiModelProperty(value = "人数", name = "memberCount")
    @FieldRemark(column="MEMBER_COUNT", field="memberCount", name="人数")
    private java.math.BigDecimal memberCount;

    /**
    * 小组名称;QC小组使用
    */
    @ExcelProperty("小组名称;QC小组使用")
    @Size(max = 256, message = "小组名称;QC小组使用长度不能超过256个字符")
    @ApiModelProperty(value = "小组名称;QC小组使用", name = "groupName")
    @FieldRemark(column="GROUP_NAME", field="groupName", name="小组名称;QC小组使用")
    private java.lang.String groupName;
    /**
    * 活动结束时间;月度进展生成截止依据
    */
    @ExcelProperty("活动结束时间;月度进展生成截止依据")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "活动结束时间;月度进展生成截止依据", name = "deadline")
    @FieldRemark(column="DEADLINE", field="deadline", name="活动结束时间;月度进展生成截止依据")
    private java.util.Date deadline;

    /**
    * 活动结束时间;月度进展生成截止依据起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineBegin;

    /**
    * 活动结束时间;月度进展生成截止依据止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date deadlineEnd;

    /**
    * 申请人ID
    */
    @ExcelProperty("申请人ID")
    @Size(max = 64, message = "申请人ID长度不能超过64个字符")
    @ApiModelProperty(value = "申请人ID", name = "applyStaffId")
    @FieldRemark(column="APPLY_STAFF_ID", field="applyStaffId", name="申请人ID")
    private java.lang.String applyStaffId;

    /**
    * 申请人CODE
    */
    @ExcelProperty("申请人CODE")
    @Size(max = 10, message = "申请人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申请人CODE", name = "applyStaffCode")
    @FieldRemark(column="APPLY_STAFF_CODE", field="applyStaffCode", name="申请人CODE")
    private java.lang.String applyStaffCode;

    /**
    * 申请人姓名
    */
    @ExcelProperty("申请人姓名")
    @Size(max = 50, message = "申请人姓名长度不能超过50个字符")
    @ApiModelProperty(value = "申请人姓名", name = "applyStaffName")
    @FieldRemark(column="APPLY_STAFF_NAME", field="applyStaffName", name="申请人姓名")
    private java.lang.String applyStaffName;

    /**
    * 申请部门ID
    */
    @ExcelProperty("申请部门ID")
    @Size(max = 64, message = "申请部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "申请部门ID", name = "applyDeptId")
    @FieldRemark(column="APPLY_DEPT_ID", field="applyDeptId", name="申请部门ID")
    private java.lang.String applyDeptId;

    /**
    * 申请部门CODE
    */
    @ExcelProperty("申请部门CODE")
    @Size(max = 10, message = "申请部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "申请部门CODE", name = "applyDeptCode")
    @FieldRemark(column="APPLY_DEPT_CODE", field="applyDeptCode", name="申请部门CODE")
    private java.lang.String applyDeptCode;

    /**
    * 申请部门
    */
    @ExcelProperty("申请部门")
    @Size(max = 128, message = "申请部门长度不能超过128个字符")
    @ApiModelProperty(value = "申请部门", name = "applyDeptName")
    @FieldRemark(column="APPLY_DEPT_NAME", field="applyDeptName", name="申请部门")
    private java.lang.String applyDeptName;
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
    * 组长/负责人ID
    */
    @ExcelProperty("组长/负责人ID")
    @Size(max = 64, message = "组长/负责人ID长度不能超过64个字符")
    @ApiModelProperty(value = "组长/负责人ID", name = "leaderStaffId")
    @FieldRemark(column="LEADER_STAFF_ID", field="leaderStaffId", name="组长/负责人ID")
    private java.lang.String leaderStaffId;

    /**
    * 组长/负责人CODE
    */
    @ExcelProperty("组长/负责人CODE")
    @Size(max = 10, message = "组长/负责人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "组长/负责人CODE", name = "leaderStaffCode")
    @FieldRemark(column="LEADER_STAFF_CODE", field="leaderStaffCode", name="组长/负责人CODE")
    private java.lang.String leaderStaffCode;

    /**
    * 组长/负责人
    */
    @ExcelProperty("组长/负责人")
    @Size(max = 50, message = "组长/负责人长度不能超过50个字符")
    @ApiModelProperty(value = "组长/负责人", name = "leaderStaffName")
    @FieldRemark(column="LEADER_STAFF_NAME", field="leaderStaffName", name="组长/负责人")
    private java.lang.String leaderStaffName;

    /**
    * 涉及型号/项目
    */
    @ExcelProperty("涉及型号/项目")
    @Size(max = 1000, message = "涉及型号/项目长度不能超过1000个字符")
    @ApiModelProperty(value = "涉及型号/项目", name = "modelProject")
    @FieldRemark(column="MODEL_PROJECT", field="modelProject", name="涉及型号/项目")
    private java.lang.String modelProject;

    /**
    * 课题类型;QC小组：问题解决型/创新型
    */
    @ExcelProperty("课题类型;QC小组：问题解决型/创新型")
    @Size(max = 50, message = "课题类型;QC小组：问题解决型/创新型长度不能超过50个字符")
    @ApiModelProperty(value = "课题类型;QC小组：问题解决型/创新型", name = "topicType")
    @FieldRemark(column="TOPIC_TYPE", field="topicType", name="课题类型;QC小组：问题解决型/创新型")
    private java.lang.String topicType;

    /**
    * 课题来源;QC小组：指令型课题、指导型课题、自选课题
    */
    @ExcelProperty("课题来源;QC小组：指令型课题、指导型课题、自选课题")
    @Size(max = 50, message = "课题来源;QC小组：指令型课题、指导型课题、自选课题长度不能超过50个字符")
    @ApiModelProperty(value = "课题来源;QC小组：指令型课题、指导型课题、自选课题", name = "topicSource")
    @FieldRemark(column="TOPIC_SOURCE", field="topicSource", name="课题来源;QC小组：指令型课题、指导型课题、自选课题")
    private java.lang.String topicSource;

    /**
    * 选题理由;QC小组填写
    */
    @ExcelProperty("选题理由;QC小组填写")
    @Size(max = 1000, message = "选题理由;QC小组填写长度不能超过1000个字符")
    @ApiModelProperty(value = "选题理由;QC小组填写", name = "selectionReason")
    @FieldRemark(column="SELECTION_REASON", field="selectionReason", name="选题理由;QC小组填写")
    private java.lang.String selectionReason;

    /**
    * 活动目标
    */
    @ExcelProperty("活动目标")
    @Size(max = 1000, message = "活动目标长度不能超过1000个字符")
    @ApiModelProperty(value = "活动目标", name = "activityGoal")
    @FieldRemark(column="ACTIVITY_GOAL", field="activityGoal", name="活动目标")
    private java.lang.String activityGoal;

    /**
    * 攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他
    */
    @ExcelProperty("攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他")
    @Size(max = 50, message = "攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他长度不能超过50个字符")
    @ApiModelProperty(value = "攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他", name = "projectCategory")
    @FieldRemark(column="PROJECT_CATEGORY", field="projectCategory", name="攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他")
    private java.lang.String projectCategory;

    /**
    * 项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他
    */
    @ExcelProperty("项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他")
    @Size(max = 50, message = "项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他长度不能超过50个字符")
    @ApiModelProperty(value = "项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他", name = "projectSource")
    @FieldRemark(column="PROJECT_SOURCE", field="projectSource", name="项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他")
    private java.lang.String projectSource;

    /**
    * 班组基本情况;质量信得过班组
    */
    @ExcelProperty("班组基本情况;质量信得过班组")
    @Size(max = 2000, message = "班组基本情况;质量信得过班组长度不能超过2000个字符")
    @ApiModelProperty(value = "班组基本情况;质量信得过班组", name = "teamBasicInfo")
    @FieldRemark(column="TEAM_BASIC_INFO", field="teamBasicInfo", name="班组基本情况;质量信得过班组")
    private java.lang.String teamBasicInfo;

    /**
    * 识别需求;质量信得过班组
    */
    @ExcelProperty("识别需求;质量信得过班组")
    @Size(max = 2000, message = "识别需求;质量信得过班组长度不能超过2000个字符")
    @ApiModelProperty(value = "识别需求;质量信得过班组", name = "requirmentIdentification")
    @FieldRemark(column="REQUIRMENT_IDENTIFICATION", field="requirmentIdentification", name="识别需求;质量信得过班组")
    private java.lang.String requirmentIdentification;

    /**
    * 明确目标;质量信得过班组
    */
    @ExcelProperty("明确目标;质量信得过班组")
    @Size(max = 2000, message = "明确目标;质量信得过班组长度不能超过2000个字符")
    @ApiModelProperty(value = "明确目标;质量信得过班组", name = "objectiveDefinition")
    @FieldRemark(column="OBJECTIVE_DEFINITION", field="objectiveDefinition", name="明确目标;质量信得过班组")
    private java.lang.String objectiveDefinition;

    /**
    * 有效实施;质量信得过班组
    */
    @ExcelProperty("有效实施;质量信得过班组")
    @Size(max = 2000, message = "有效实施;质量信得过班组长度不能超过2000个字符")
    @ApiModelProperty(value = "有效实施;质量信得过班组", name = "effectiveImplementation")
    @FieldRemark(column="EFFECTIVE_IMPLEMENTATION", field="effectiveImplementation", name="有效实施;质量信得过班组")
    private java.lang.String effectiveImplementation;

    /**
    * 成效检查;质量信得过班组
    */
    @ExcelProperty("成效检查;质量信得过班组")
    @Size(max = 2000, message = "成效检查;质量信得过班组长度不能超过2000个字符")
    @ApiModelProperty(value = "成效检查;质量信得过班组", name = "effectCheck")
    @FieldRemark(column="EFFECT_CHECK", field="effectCheck", name="成效检查;质量信得过班组")
    private java.lang.String effectCheck;

    /**
    * 攻关项目简介;攻关项目
    */
    @ExcelProperty("攻关项目简介;攻关项目")
    @Size(max = 2000, message = "攻关项目简介;攻关项目长度不能超过2000个字符")
    @ApiModelProperty(value = "攻关项目简介;攻关项目", name = "projectIntro")
    @FieldRemark(column="PROJECT_INTRO", field="projectIntro", name="攻关项目简介;攻关项目")
    private java.lang.String projectIntro;

    /**
    * 攻关目标;攻关项目
    */
    @ExcelProperty("攻关目标;攻关项目")
    @Size(max = 2000, message = "攻关目标;攻关项目长度不能超过2000个字符")
    @ApiModelProperty(value = "攻关目标;攻关项目", name = "projectGoal")
    @FieldRemark(column="PROJECT_GOAL", field="projectGoal", name="攻关目标;攻关项目")
    private java.lang.String projectGoal;

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

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getActivityCode(){
        return activityCode;
    }

    public void setActivityCode(java.lang.String activityCode){
        this.activityCode = activityCode;
    }

    public java.lang.String getForYear(){
        return forYear;
    }

    public void setForYear(java.lang.String forYear){
        this.forYear = forYear;
    }

    public java.lang.String getActivityType(){
        return activityType;
    }

    public void setActivityType(java.lang.String activityType){
        this.activityType = activityType;
    }

    public java.lang.String getActivityName(){
        return activityName;
    }

    public void setActivityName(java.lang.String activityName){
        this.activityName = activityName;
    }

    public java.lang.String getMembebrId(){
        return membebrId;
    }

    public void setMembebrId(java.lang.String membebrId){
        this.membebrId = membebrId;
    }

    public java.lang.String getMemberCode(){
        return memberCode;
    }

    public void setMemberCode(java.lang.String memberCode){
        this.memberCode = memberCode;
    }

    public java.lang.String getMemberName(){
        return memberName;
    }

    public void setMemberName(java.lang.String memberName){
        this.memberName = memberName;
    }

    public java.math.BigDecimal getMemberCount(){
        return memberCount;
    }

    public void setMemberCount(java.math.BigDecimal memberCount){
        this.memberCount = memberCount;
        super.handleNullValue();
    }

    public java.lang.String getGroupName(){
        return groupName;
    }

    public void setGroupName(java.lang.String groupName){
        this.groupName = groupName;
    }

    public java.util.Date getDeadline(){
        return deadline;
    }

    public void setDeadline(java.util.Date deadline){
        this.deadline = deadline;
        super.handleNullValue();
    }

    public java.util.Date getDeadlineBegin(){
        return deadlineBegin;
    }

    public void setDeadlineBegin(java.util.Date deadlineBegin){
        this.deadlineBegin = deadlineBegin;
    }

    public java.util.Date getDeadlineEnd(){
        return deadlineEnd;
    }

    public void setDeadlineEnd(java.util.Date deadlineEnd){
        this.deadlineEnd = deadlineEnd;
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

    public java.lang.String getModelProject(){
        return modelProject;
    }

    public void setModelProject(java.lang.String modelProject){
        this.modelProject = modelProject;
    }

    public java.lang.String getTopicType(){
        return topicType;
    }

    public void setTopicType(java.lang.String topicType){
        this.topicType = topicType;
    }

    public java.lang.String getTopicSource(){
        return topicSource;
    }

    public void setTopicSource(java.lang.String topicSource){
        this.topicSource = topicSource;
    }

    public java.lang.String getSelectionReason(){
        return selectionReason;
    }

    public void setSelectionReason(java.lang.String selectionReason){
        this.selectionReason = selectionReason;
    }

    public java.lang.String getActivityGoal(){
        return activityGoal;
    }

    public void setActivityGoal(java.lang.String activityGoal){
        this.activityGoal = activityGoal;
    }

    public java.lang.String getProjectCategory(){
        return projectCategory;
    }

    public void setProjectCategory(java.lang.String projectCategory){
        this.projectCategory = projectCategory;
    }

    public java.lang.String getProjectSource(){
        return projectSource;
    }

    public void setProjectSource(java.lang.String projectSource){
        this.projectSource = projectSource;
    }

    public java.lang.String getTeamBasicInfo(){
        return teamBasicInfo;
    }

    public void setTeamBasicInfo(java.lang.String teamBasicInfo){
        this.teamBasicInfo = teamBasicInfo;
    }

    public java.lang.String getRequirmentIdentification(){
        return requirmentIdentification;
    }

    public void setRequirmentIdentification(java.lang.String requirmentIdentification){
        this.requirmentIdentification = requirmentIdentification;
    }

    public java.lang.String getObjectiveDefinition(){
        return objectiveDefinition;
    }

    public void setObjectiveDefinition(java.lang.String objectiveDefinition){
        this.objectiveDefinition = objectiveDefinition;
    }

    public java.lang.String getEffectiveImplementation(){
        return effectiveImplementation;
    }

    public void setEffectiveImplementation(java.lang.String effectiveImplementation){
        this.effectiveImplementation = effectiveImplementation;
    }

    public java.lang.String getEffectCheck(){
        return effectCheck;
    }

    public void setEffectCheck(java.lang.String effectCheck){
        this.effectCheck = effectCheck;
    }

    public java.lang.String getProjectIntro(){
        return projectIntro;
    }

    public void setProjectIntro(java.lang.String projectIntro){
        this.projectIntro = projectIntro;
    }

    public java.lang.String getProjectGoal(){
        return projectGoal;
    }

    public void setProjectGoal(java.lang.String projectGoal){
        this.projectGoal = projectGoal;
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

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "质量活动台账表";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "质量活动台账表";
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
