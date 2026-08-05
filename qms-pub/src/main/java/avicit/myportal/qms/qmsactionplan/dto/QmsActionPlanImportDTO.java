package avicit.myportal.qms.qmsactionplan.dto;

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
* @创建时间： 2026-08-04 15:12
* @类说明：通用实施计划表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsActionPlanImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 行动项ID
    */
    @ExcelProperty("行动项ID")
    @Size(max = 64, message = "行动项ID长度不能超过64个字符")
    private String actionId;
    /**
    * 行动项标题
    */
    @ExcelProperty("行动项标题")
    @Size(max = 256, message = "行动项标题长度不能超过256个字符")
    private String actionName;
    /**
    * 来源类型
    */
    @ExcelProperty("来源类型")
    @Size(max = 128, message = "来源类型长度不能超过128个字符")
    private String sourceType;
    /**
    * 来源ID
    */
    @ExcelProperty("来源ID")
    @Size(max = 64, message = "来源ID长度不能超过64个字符")
    private String sourceId;
    /**
    * 计划编号
    */
    @ExcelProperty("计划编号")
    @Size(max = 50, message = "计划编号长度不能超过50个字符")
    private String planCode;
    /**
    * 计划名称
    */
    @ExcelProperty("计划名称")
    @Size(max = 256, message = "计划名称长度不能超过256个字符")
    private String planName;
    /**
    * 计划内容
    */
    @ExcelProperty("计划内容")
    @Size(max = 512, message = "计划内容长度不能超过512个字符")
    private String planContent;
    /**
    * 计划类型
    */
    @ExcelProperty("计划类型")
    @Size(max = 128, message = "计划类型长度不能超过128个字符")
    private String planType;
    /**
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 2000, message = "责任部门ID长度不能超过2000个字符")
    private String responsibleDeptId;
    /**
    * 责任部门CODE
    */
    @ExcelProperty("责任部门CODE")
    @Size(max = 512, message = "责任部门CODE长度不能超过512个字符")
    private String responsibleDeptCode;
    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 2000, message = "责任部门长度不能超过2000个字符")
    private String responsibleDeptName;
    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 2000, message = "责任人ID长度不能超过2000个字符")
    private String responsibleUserId;
    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 512, message = "责任人CODE长度不能超过512个字符")
    private String responsibleUserCode;
    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 1000, message = "责任人长度不能超过1000个字符")
    private String responsibleUserName;
    /**
    * 协同部门ID
    */
    @ExcelProperty("协同部门ID")
    @Size(max = 2000, message = "协同部门ID长度不能超过2000个字符")
    private String assistDeptId;
    /**
    * 协同部门CODE
    */
    @ExcelProperty("协同部门CODE")
    @Size(max = 512, message = "协同部门CODE长度不能超过512个字符")
    private String assistDeptCode;
    /**
    * 协同部门
    */
    @ExcelProperty("协同部门")
    @Size(max = 2000, message = "协同部门长度不能超过2000个字符")
    private String assistDeptName;
    /**
    * 开始时间
    */

    @ExcelProperty("开始时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【开始时间】格式错误，正确格式为：yyyy/MM/dd")
    private String startTime;
    /**
    * 结束时间
    */

    @ExcelProperty("结束时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【结束时间】格式错误，正确格式为：yyyy/MM/dd")
    private String endTime;
    /**
    * 实际完成时间
    */

    @ExcelProperty("实际完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【实际完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String actualFinishTime;
    /**
    * 反馈周期
    */
    @ExcelProperty("反馈周期")
    @Size(max = 20, message = "反馈周期长度不能超过20个字符")
    private String feedbackCycle;
    /**
    * 计划状态
    */
    @ExcelProperty("计划状态")
    @Size(max = 20, message = "计划状态长度不能超过20个字符")
    private String status;
    /**
    * 反馈状态
    */
    @ExcelProperty("反馈状态")
    @Size(max = 20, message = "反馈状态长度不能超过20个字符")
    private String feedbackStatus;
    /**
    * 当前进度
    */

    @ExcelProperty("当前进度")
    @Digits(integer = 2, fraction = 0, message = "当前进度格式不正确")
    private String progress;
    /**
    * 是否逾期
    */
    @ExcelProperty("是否逾期")
    @Size(max = 2, message = "是否逾期长度不能超过2个字符")
    private String ynOverdue;
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
    /**
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    private String parentId;
    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    private String treePath;
    /**
    * 节点层级
    */

    @Digits(integer = 16, fraction = 0, message = "节点层级格式不正确")
    private String treeLevel;
    /**
    * 本级排序
    */

    @NotNull(message = "本级排序不能为空")
    @Digits(integer = 16, fraction = 0, message = "本级排序格式不正确")
    private String treeSort;
    /**
    * 全级排序
    */
    @Size(max = 1000, message = "全级排序长度不能超过1000个字符")
    private String treeSorts;
    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    private String treeLeaf;
    /**
    * 计划要求
    */
    @ExcelProperty("计划要求")
    @Size(max = 128, message = "计划要求长度不能超过128个字符")
    private String expectedDeliverable;
    /**
    * PLAN_REQUIREMENT
    */
    @ExcelProperty("PLAN_REQUIREMENT")
    @Size(max = 512, message = "PLAN_REQUIREMENT长度不能超过512个字符")
    private String planRequirement;

    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
