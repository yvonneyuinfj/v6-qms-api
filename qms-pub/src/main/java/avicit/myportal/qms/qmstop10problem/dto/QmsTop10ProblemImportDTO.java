package avicit.myportal.qms.qmstop10problem.dto;

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
* @创建时间： 2026-08-05 18:11
* @类说明：TOP10问题台账导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsTop10ProblemImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 编号;2025-TOP-001
    */
    @ExcelProperty("编号;2025-TOP-001")
    @Size(max = 50, message = "编号;2025-TOP-001长度不能超过50个字符")
    private String topCode;
    /**
    * 问题名称
    */
    @ExcelProperty("问题名称")
    @Size(max = 256, message = "问题名称长度不能超过256个字符")
    private String problemName;
    /**
    * 主管副总师ID
    */
    @ExcelProperty("主管副总师ID")
    @Size(max = 64, message = "主管副总师ID长度不能超过64个字符")
    private String deputyChiefUserId;
    /**
    * 主管副总师CODE
    */
    @ExcelProperty("主管副总师CODE")
    @Size(max = 10, message = "主管副总师CODE长度不能超过10个字符")
    private String deputyChiefUserCode;
    /**
    * 主管副总师
    */
    @ExcelProperty("主管副总师")
    @Size(max = 128, message = "主管副总师长度不能超过128个字符")
    private String deputyChiefUserName;
    /**
    * 主管部门ID
    */
    @ExcelProperty("主管部门ID")
    @Size(max = 64, message = "主管部门ID长度不能超过64个字符")
    private String responsibleDeptId;
    /**
    * 主管部门CODE
    */
    @ExcelProperty("主管部门CODE")
    @Size(max = 10, message = "主管部门CODE长度不能超过10个字符")
    private String responsibleDeptCode;
    /**
    * 主管部门
    */
    @ExcelProperty("主管部门")
    @Size(max = 128, message = "主管部门长度不能超过128个字符")
    private String responsibleDeptName;
    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    private String responsibleStaffId;
    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 10, message = "责任人CODE长度不能超过10个字符")
    private String responsibleStaffCode;
    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 50, message = "责任人长度不能超过50个字符")
    private String responsibleStaffName;
    /**
    * 归零节点
    */

    @ExcelProperty("归零节点")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【归零节点】格式错误，正确格式为：yyyy/MM/dd")
    private String planCloseTime;
    /**
    * 用户;空军/海军/其他
    */
    @ExcelProperty("用户;空军/海军/其他")
    @Size(max = 10, message = "用户;空军/海军/其他长度不能超过10个字符")
    private String userType;
    /**
    * 阶段;科研/批产
    */
    @ExcelProperty("阶段;科研/批产")
    @Size(max = 10, message = "阶段;科研/批产长度不能超过10个字符")
    private String problemStage;
    /**
    * 级别;集团/所级
    */
    @ExcelProperty("级别;集团/所级")
    @Size(max = 10, message = "级别;集团/所级长度不能超过10个字符")
    private String problemLevel;
    /**
    * 计划完成情况;以分数或进度条形式展现
    */
    @ExcelProperty("计划完成情况;以分数或进度条形式展现")
    @Size(max = 10, message = "计划完成情况;以分数或进度条形式展现长度不能超过10个字符")
    private String planCompletionRate;
    /**
    * 周反馈情况;分数或进度条形式展现
    */
    @ExcelProperty("周反馈情况;分数或进度条形式展现")
    @Size(max = 10, message = "周反馈情况;分数或进度条形式展现长度不能超过10个字符")
    private String weeklyFeedbackRate;
    /**
    * 销号状态;攻关中/已销号
    */
    @ExcelProperty("销号状态;攻关中/已销号")
    @Size(max = 10, message = "销号状态;攻关中/已销号长度不能超过10个字符")
    private String status;
    /**
    * 销号时间
    */

    @ExcelProperty("销号时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【销号时间】格式错误，正确格式为：yyyy/MM/dd")
    private String closeTime;
    /**
    * 质量问题编号;非必填，质量问题系统内的编号
    */
    @ExcelProperty("质量问题编号;非必填，质量问题系统内的编号")
    @Size(max = 50, message = "质量问题编号;非必填，质量问题系统内的编号长度不能超过50个字符")
    private String qualityProblemCode;
    /**
    * 问题描述
    */
    @ExcelProperty("问题描述")
    @Size(max = 2000, message = "问题描述长度不能超过2000个字符")
    private String problemDesc;
    /**
    * 当前工作进展
    */
    @ExcelProperty("当前工作进展")
    @Size(max = 2000, message = "当前工作进展长度不能超过2000个字符")
    private String currentProgress;
    /**
    * 周反馈开始时间
    */

    @ExcelProperty("周反馈开始时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【周反馈开始时间】格式错误，正确格式为：yyyy/MM/dd")
    private String weeklyFeedbackStartTime;
    /**
    * 质量主管ID
    */
    @ExcelProperty("质量主管ID")
    @Size(max = 64, message = "质量主管ID长度不能超过64个字符")
    private String qualitySupervisorId;
    /**
    * 质量主管CODE
    */
    @ExcelProperty("质量主管CODE")
    @Size(max = 10, message = "质量主管CODE长度不能超过10个字符")
    private String qualitySupervisorCode;
    /**
    * 质量主管
    */
    @ExcelProperty("质量主管")
    @Size(max = 50, message = "质量主管长度不能超过50个字符")
    private String qualitySupervisorName;
    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 128, message = "型号长度不能超过128个字符")
    private String model;
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
