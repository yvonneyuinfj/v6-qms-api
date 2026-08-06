package avicit.myportal.qms.qmsqualityactivityprogress.dto;

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
* @类说明：活动过程反馈表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualityActivityProgressImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 月份
    */
    @ExcelProperty("月份")
    @Size(max = 10, message = "月份长度不能超过10个字符")
    private String forMonth;
    /**
    * 工作进展
    */
    @ExcelProperty("工作进展")
    @Size(max = 2000, message = "工作进展长度不能超过2000个字符")
    private String workProgress;
    /**
    * 反馈人ID
    */
    @ExcelProperty("反馈人ID")
    @Size(max = 64, message = "反馈人ID长度不能超过64个字符")
    private String feedbackStaffId;
    /**
    * 反馈人CODE
    */
    @ExcelProperty("反馈人CODE")
    @Size(max = 10, message = "反馈人CODE长度不能超过10个字符")
    private String feedbackStaffCode;
    /**
    * 反馈人
    */
    @ExcelProperty("反馈人")
    @Size(max = 20, message = "反馈人长度不能超过20个字符")
    private String feedbackStaffName;
    /**
    * 反馈时间
    */

    @ExcelProperty("反馈时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【反馈时间】格式错误，正确格式为：yyyy/MM/dd")
    private String feedbackTime;
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
    /**
    * 进展编号
    */
    @ExcelProperty("进展编号")
    @Size(max = 50, message = "进展编号长度不能超过50个字符")
    private String progressNo;
    /**
    * 活动ID
    */
    @Size(max = 50, message = "活动ID长度不能超过50个字符")
    private String activityId;
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
