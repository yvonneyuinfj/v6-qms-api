package avicit.myportal.qms.qmsqualityculture.dto;

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
* @类说明：质量文化导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualityCultureImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 文化编号
    */
    @ExcelProperty("文化编号")
    @Size(max = 50, message = "文化编号长度不能超过50个字符")
    private String cultureCode;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 活动类型;QUALITY_WEEK质量周、QUALITY_MONTH质量月
    */
    @ExcelProperty("活动类型;QUALITY_WEEK质量周、QUALITY_MONTH质量月")
    @Size(max = 50, message = "活动类型;QUALITY_WEEK质量周、QUALITY_MONTH质量月长度不能超过50个字符")
    private String activityType;
    /**
    * 活动主题
    */
    @ExcelProperty("活动主题")
    @Size(max = 128, message = "活动主题长度不能超过128个字符")
    private String activityTheme;
    /**
    * 活动开始时间
    */

    @ExcelProperty("活动开始时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【活动开始时间】格式错误，正确格式为：yyyy/MM/dd")
    private String startTime;
    /**
    * 活动结束时间
    */

    @ExcelProperty("活动结束时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【活动结束时间】格式错误，正确格式为：yyyy/MM/dd")
    private String endTime;
    /**
    * 发布时间
    */

    @ExcelProperty("发布时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【发布时间】格式错误，正确格式为：yyyy/MM/dd")
    private String publishTime;
    /**
    * 完成时间
    */

    @ExcelProperty("完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String completeTime;
    /**
    * 状态
    */
    @ExcelProperty("状态")
    @Size(max = 10, message = "状态长度不能超过10个字符")
    private String status;
    /**
    * 活动来源
    */
    @ExcelProperty("活动来源")
    @Size(max = 50, message = "活动来源长度不能超过50个字符")
    private String activitySource;
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
