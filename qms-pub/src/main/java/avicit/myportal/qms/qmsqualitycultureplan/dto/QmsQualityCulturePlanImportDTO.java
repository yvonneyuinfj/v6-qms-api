package avicit.myportal.qms.qmsqualitycultureplan.dto;

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
* @创建时间： 2026-08-06 15:53
* @类说明：文化活动计划表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualityCulturePlanImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 文化ID
    */
    @Size(max = 64, message = "文化ID长度不能超过64个字符")
    private String cultureId;
    /**
    * 计划编号
    */
    @ExcelProperty("计划编号")
    @Size(max = 50, message = "计划编号长度不能超过50个字符")
    private String planCode;
    /**
    * 主要工作事项
    */
    @ExcelProperty("主要工作事项")
    @Size(max = 512, message = "主要工作事项长度不能超过512个字符")
    private String workItem;
    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    private String deliverable;
    /**
    * 组织部门ID
    */
    @ExcelProperty("组织部门ID")
    @Size(max = 64, message = "组织部门ID长度不能超过64个字符")
    private String organizingDeptId;
    /**
    * 组织部门CODE
    */
    @ExcelProperty("组织部门CODE")
    @Size(max = 10, message = "组织部门CODE长度不能超过10个字符")
    private String organizingDeptCode;
    /**
    * 组织部门
    */
    @ExcelProperty("组织部门")
    @Size(max = 64, message = "组织部门长度不能超过64个字符")
    private String organizingDeptName;
    /**
    * 组织人ID
    */
    @ExcelProperty("组织人ID")
    @Size(max = 64, message = "组织人ID长度不能超过64个字符")
    private String organizerStaffId;
    /**
    * 组织人CODE
    */
    @ExcelProperty("组织人CODE")
    @Size(max = 10, message = "组织人CODE长度不能超过10个字符")
    private String organizerStaffCode;
    /**
    * 组织人
    */
    @ExcelProperty("组织人")
    @Size(max = 20, message = "组织人长度不能超过20个字符")
    private String organizerStaffName;
    /**
    * 实施部门ID
    */
    @ExcelProperty("实施部门ID")
    @Size(max = 2000, message = "实施部门ID长度不能超过2000个字符")
    private String implementDeptId;
    /**
    * 实施部门CODE
    */
    @ExcelProperty("实施部门CODE")
    @Size(max = 1000, message = "实施部门CODE长度不能超过1000个字符")
    private String implementDeptCode;
    /**
    * 实施部门
    */
    @ExcelProperty("实施部门")
    @Size(max = 2000, message = "实施部门长度不能超过2000个字符")
    private String implementDeptName;
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
    private String deadline;
    /**
    * 完成时间
    */

    @ExcelProperty("完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String completeTime;
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
