package avicit.myportal.qms.qmsqualityinspection.dto;

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
* @创建时间： 2026-08-05 18:15
* @类说明：质量检查表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualityInspectionImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 检查编号;检查编号+3位数流水号
    */
    @ExcelProperty("检查编号;检查编号+3位数流水号")
    @Size(max = 50, message = "检查编号;检查编号+3位数流水号长度不能超过50个字符")
    private String inspectionCode;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 检查名称;对XXX的专项检查
    */
    @ExcelProperty("检查名称;对XXX的专项检查")
    @Size(max = 256, message = "检查名称;对XXX的专项检查长度不能超过256个字符")
    private String inspectName;
    /**
    * 被检查单位ID;检查单位名称/代号
    */
    @ExcelProperty("被检查单位ID;检查单位名称/代号")
    @Size(max = 64, message = "被检查单位ID;检查单位名称/代号长度不能超过64个字符")
    private String inspectedDeptId;
    /**
    * 被检查单位CODE
    */
    @ExcelProperty("被检查单位CODE")
    @Size(max = 10, message = "被检查单位CODE长度不能超过10个字符")
    private String inspectedDeptCode;
    /**
    * 被检查单位
    */
    @ExcelProperty("被检查单位")
    @Size(max = 128, message = "被检查单位长度不能超过128个字符")
    private String inspectedDeptName;
    /**
    * 涉及型号;多选，逗号分隔
    */
    @ExcelProperty("涉及型号;多选，逗号分隔")
    @Size(max = 1000, message = "涉及型号;多选，逗号分隔长度不能超过1000个字符")
    private String model;
    /**
    * 检查时间
    */

    @ExcelProperty("检查时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【检查时间】格式错误，正确格式为：yyyy/MM/dd")
    private String inspectionTime;
    /**
    * 检查投入
    */

    @ExcelProperty("检查投入")
    @Digits(integer = 16, fraction = 2, message = "检查投入格式不正确")
    private String inspectionWorkload;
    /**
    * 检查组长ID
    */
    @ExcelProperty("检查组长ID")
    @Size(max = 64, message = "检查组长ID长度不能超过64个字符")
    private String leaderStaffId;
    /**
    * 检查组长CODE
    */
    @ExcelProperty("检查组长CODE")
    @Size(max = 10, message = "检查组长CODE长度不能超过10个字符")
    private String leaderStaffCode;
    /**
    * 检查组长
    */
    @ExcelProperty("检查组长")
    @Size(max = 50, message = "检查组长长度不能超过50个字符")
    private String leaderStaffName;
    /**
    * 检查组成员ID
    */
    @ExcelProperty("检查组成员ID")
    @Size(max = 512, message = "检查组成员ID长度不能超过512个字符")
    private String memberStaffId;
    /**
    * 检查组成员CODE
    */
    @ExcelProperty("检查组成员CODE")
    @Size(max = 50, message = "检查组成员CODE长度不能超过50个字符")
    private String memberStaffCode;
    /**
    * 检查组成员
    */
    @ExcelProperty("检查组成员")
    @Size(max = 128, message = "检查组成员长度不能超过128个字符")
    private String memberStaffName;
    /**
    * 问题数
    */

    @ExcelProperty("问题数")
    @Digits(integer = 16, fraction = 2, message = "问题数格式不正确")
    private String problemCount;
    /**
    * 完成整改数
    */

    @ExcelProperty("完成整改数")
    @Digits(integer = 16, fraction = 2, message = "完成整改数格式不正确")
    private String completeCount;
    /**
    * 完成时间
    */

    @ExcelProperty("完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String completeTime;
    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    private String status;
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
