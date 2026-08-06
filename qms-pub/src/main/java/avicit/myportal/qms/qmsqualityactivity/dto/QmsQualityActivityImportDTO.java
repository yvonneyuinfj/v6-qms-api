package avicit.myportal.qms.qmsqualityactivity.dto;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.ExcelProperty;
import avicit.platform6.core.validate.DateTimeStr;
import javax.validation.constraints.*;
import lombok.Data;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 15:52
* @类说明：质量活动台账表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualityActivityImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 活动编号;自动生成，QC/BZ/GG年份号-3位流水号
    */
    @ExcelProperty("活动编号;自动生成，QC/BZ/GG年份号-3位流水号")
    @Size(max = 50, message = "活动编号;自动生成，QC/BZ/GG年份号-3位流水号长度不能超过50个字符")
    private String activityCode;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目
    */
    @ExcelProperty("活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目")
    @Size(max = 50, message = "活动类型;数据字典：QC小组、质量信得过班组、质量攻关项目长度不能超过50个字符")
    private String activityType;
    /**
    * 课题/班组/项目名称
    */
    @ExcelProperty("课题/班组/项目名称")
    @Size(max = 256, message = "课题/班组/项目名称长度不能超过256个字符")
    private String activityName;
    /**
    * 成员ID
    */
    @ExcelProperty("成员ID")
    @Size(max = 3200, message = "成员ID长度不能超过3200个字符")
    private String membebrId;
    /**
    * 成员CODE
    */
    @ExcelProperty("成员CODE")
    @Size(max = 256, message = "成员CODE长度不能超过256个字符")
    private String memberCode;
    /**
    * 成员
    */
    @ExcelProperty("成员")
    @Size(max = 512, message = "成员长度不能超过512个字符")
    private String memberName;
    /**
    * 人数
    */

    @ExcelProperty("人数")
    @Digits(integer = 4, fraction = 0, message = "人数格式不正确")
    private String memberCount;
    /**
    * 小组名称;QC小组使用
    */
    @ExcelProperty("小组名称;QC小组使用")
    @Size(max = 256, message = "小组名称;QC小组使用长度不能超过256个字符")
    private String groupName;
    /**
    * 活动结束时间;月度进展生成截止依据
    */

    @ExcelProperty("活动结束时间;月度进展生成截止依据")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【活动结束时间;月度进展生成截止依据】格式错误，正确格式为：yyyy/MM/dd")
    private String deadline;
    /**
    * 申请人ID
    */
    @ExcelProperty("申请人ID")
    @Size(max = 64, message = "申请人ID长度不能超过64个字符")
    private String applyStaffId;
    /**
    * 申请人CODE
    */
    @ExcelProperty("申请人CODE")
    @Size(max = 10, message = "申请人CODE长度不能超过10个字符")
    private String applyStaffCode;
    /**
    * 申请人姓名
    */
    @ExcelProperty("申请人姓名")
    @Size(max = 50, message = "申请人姓名长度不能超过50个字符")
    private String applyStaffName;
    /**
    * 申请部门ID
    */
    @ExcelProperty("申请部门ID")
    @Size(max = 64, message = "申请部门ID长度不能超过64个字符")
    private String applyDeptId;
    /**
    * 申请部门CODE
    */
    @ExcelProperty("申请部门CODE")
    @Size(max = 10, message = "申请部门CODE长度不能超过10个字符")
    private String applyDeptCode;
    /**
    * 申请部门
    */
    @ExcelProperty("申请部门")
    @Size(max = 128, message = "申请部门长度不能超过128个字符")
    private String applyDeptName;
    /**
    * 申请时间
    */

    @ExcelProperty("申请时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【申请时间】格式错误，正确格式为：yyyy/MM/dd")
    private String applyTime;
    /**
    * 组长/负责人ID
    */
    @ExcelProperty("组长/负责人ID")
    @Size(max = 64, message = "组长/负责人ID长度不能超过64个字符")
    private String leaderStaffId;
    /**
    * 组长/负责人CODE
    */
    @ExcelProperty("组长/负责人CODE")
    @Size(max = 10, message = "组长/负责人CODE长度不能超过10个字符")
    private String leaderStaffCode;
    /**
    * 组长/负责人
    */
    @ExcelProperty("组长/负责人")
    @Size(max = 50, message = "组长/负责人长度不能超过50个字符")
    private String leaderStaffName;
    /**
    * 涉及型号/项目
    */
    @ExcelProperty("涉及型号/项目")
    @Size(max = 1000, message = "涉及型号/项目长度不能超过1000个字符")
    private String modelProject;
    /**
    * 课题类型;QC小组：问题解决型/创新型
    */
    @ExcelProperty("课题类型;QC小组：问题解决型/创新型")
    @Size(max = 50, message = "课题类型;QC小组：问题解决型/创新型长度不能超过50个字符")
    private String topicType;
    /**
    * 课题来源;QC小组：指令型课题、指导型课题、自选课题
    */
    @ExcelProperty("课题来源;QC小组：指令型课题、指导型课题、自选课题")
    @Size(max = 50, message = "课题来源;QC小组：指令型课题、指导型课题、自选课题长度不能超过50个字符")
    private String topicSource;
    /**
    * 选题理由;QC小组填写
    */
    @ExcelProperty("选题理由;QC小组填写")
    @Size(max = 1000, message = "选题理由;QC小组填写长度不能超过1000个字符")
    private String selectionReason;
    /**
    * 活动目标
    */
    @ExcelProperty("活动目标")
    @Size(max = 1000, message = "活动目标长度不能超过1000个字符")
    private String activityGoal;
    /**
    * 攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他
    */
    @ExcelProperty("攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他")
    @Size(max = 50, message = "攻关类别;质量信得过班组：体系运行类/体系改进类/攻坚型号类/故障攻关类/其他长度不能超过50个字符")
    private String projectCategory;
    /**
    * 项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他
    */
    @ExcelProperty("项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他")
    @Size(max = 50, message = "项目来源;质量信得过班组：自定项目/集团要求/所内要求/其他长度不能超过50个字符")
    private String projectSource;
    /**
    * 班组基本情况;质量信得过班组
    */
    @ExcelProperty("班组基本情况;质量信得过班组")
    @Size(max = 2000, message = "班组基本情况;质量信得过班组长度不能超过2000个字符")
    private String teamBasicInfo;
    /**
    * 识别需求;质量信得过班组
    */
    @ExcelProperty("识别需求;质量信得过班组")
    @Size(max = 2000, message = "识别需求;质量信得过班组长度不能超过2000个字符")
    private String requirmentIdentification;
    /**
    * 明确目标;质量信得过班组
    */
    @ExcelProperty("明确目标;质量信得过班组")
    @Size(max = 2000, message = "明确目标;质量信得过班组长度不能超过2000个字符")
    private String objectiveDefinition;
    /**
    * 有效实施;质量信得过班组
    */
    @ExcelProperty("有效实施;质量信得过班组")
    @Size(max = 2000, message = "有效实施;质量信得过班组长度不能超过2000个字符")
    private String effectiveImplementation;
    /**
    * 成效检查;质量信得过班组
    */
    @ExcelProperty("成效检查;质量信得过班组")
    @Size(max = 2000, message = "成效检查;质量信得过班组长度不能超过2000个字符")
    private String effectCheck;
    /**
    * 攻关项目简介;攻关项目
    */
    @ExcelProperty("攻关项目简介;攻关项目")
    @Size(max = 2000, message = "攻关项目简介;攻关项目长度不能超过2000个字符")
    private String projectIntro;
    /**
    * 攻关目标;攻关项目
    */
    @ExcelProperty("攻关目标;攻关项目")
    @Size(max = 2000, message = "攻关目标;攻关项目长度不能超过2000个字符")
    private String projectGoal;
    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    private String status;
    /**
    * 流程实例ID
    */
    @ExcelProperty("流程实例ID")
    @Size(max = 64, message = "流程实例ID长度不能超过64个字符")
    private String processInstanceId;
    /**
    * 流程状态
    */
    @ExcelProperty("流程状态")
    @Size(max = 10, message = "流程状态长度不能超过10个字符")
    private String processStatus;
    @ExcelProperty("密级")
    private String secretLevelName;
    /**
    * 是否已删除
    */
    @ExcelProperty("是否已删除")
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    private String ynDeleted;
    /**
    * 备注
    */
    @ExcelProperty("备注")
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    private String remark;
    /**
    * 排序
    */

    @ExcelProperty("排序")
    @Digits(integer = 16, fraction = 0, message = "排序格式不正确")
    private String orderBy;
    /**
    * 扩展字段_01
    */
    @Size(max = 512, message = "扩展字段_01长度不能超过512个字符")
    private String attribute01;
    /**
    * 扩展字段_02
    */
    @Size(max = 512, message = "扩展字段_02长度不能超过512个字符")
    private String attribute02;
    /**
    * 扩展字段_03
    */
    @Size(max = 512, message = "扩展字段_03长度不能超过512个字符")
    private String attribute03;
    /**
    * 扩展字段_04
    */
    @Size(max = 512, message = "扩展字段_04长度不能超过512个字符")
    private String attribute04;
    /**
    * 扩展字段_05
    */
    @Size(max = 512, message = "扩展字段_05长度不能超过512个字符")
    private String attribute05;
    /**
    * 扩展字段_06
    */
    @Size(max = 512, message = "扩展字段_06长度不能超过512个字符")
    private String attribute06;
    /**
    * 扩展字段_07
    */
    @Size(max = 512, message = "扩展字段_07长度不能超过512个字符")
    private String attribute07;
    /**
    * 扩展字段_08
    */
    @Size(max = 512, message = "扩展字段_08长度不能超过512个字符")
    private String attribute08;
    /**
    * 扩展字段_09
    */
    @Size(max = 512, message = "扩展字段_09长度不能超过512个字符")
    private String attribute09;
    /**
    * 扩展字段_10
    */
    @Size(max = 512, message = "扩展字段_10长度不能超过512个字符")
    private String attribute10;

    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
