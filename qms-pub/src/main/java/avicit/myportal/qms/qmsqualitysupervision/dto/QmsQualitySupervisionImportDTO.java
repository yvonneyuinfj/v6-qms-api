package avicit.myportal.qms.qmsqualitysupervision.dto;

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
* @创建时间： 2026-08-05 18:17
* @类说明：质量监督表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsQualitySupervisionImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 监督CODE
    */
    @ExcelProperty("监督CODE")
    @Size(max = 50, message = "监督CODE长度不能超过50个字符")
    private String supervisionCode;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 监督时间;质量部手动选择
    */

    @ExcelProperty("监督时间;质量部手动选择")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【监督时间;质量部手动选择】格式错误，正确格式为：yyyy/MM/dd")
    private String supervisionTime;
    /**
    * 被监督单位ID
    */
    @ExcelProperty("被监督单位ID")
    @Size(max = 64, message = "被监督单位ID长度不能超过64个字符")
    private String supervisedDeptId;
    /**
    * 被监督单位CODE
    */
    @ExcelProperty("被监督单位CODE")
    @Size(max = 10, message = "被监督单位CODE长度不能超过10个字符")
    private String supervisedDeptCode;
    /**
    * 被监督单位
    */
    @ExcelProperty("被监督单位")
    @Size(max = 128, message = "被监督单位长度不能超过128个字符")
    private String supervisedDeptName;
    /**
    * 检查员ID;多人，逗号分隔
    */
    @ExcelProperty("检查员ID;多人，逗号分隔")
    @Size(max = 512, message = "检查员ID;多人，逗号分隔长度不能超过512个字符")
    private String inspectorStaffId;
    /**
    * 检查员CODE
    */
    @ExcelProperty("检查员CODE")
    @Size(max = 50, message = "检查员CODE长度不能超过50个字符")
    private String inspectorStaffCode;
    /**
    * 检查员
    */
    @ExcelProperty("检查员")
    @Size(max = 128, message = "检查员长度不能超过128个字符")
    private String inspectorStaffName;
    /**
    * 问题数量;质量部手写
    */

    @ExcelProperty("问题数量;质量部手写")
    @Digits(integer = 10, fraction = 0, message = "问题数量;质量部手写格式不正确")
    private String problemCount;
    /**
    * 完成时间;全部问题完成时填写
    */

    @ExcelProperty("完成时间;全部问题完成时填写")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【完成时间;全部问题完成时填写】格式错误，正确格式为：yyyy/MM/dd")
    private String completionTime;
    /**
    * 监督状态;业务状态
    */
    @ExcelProperty("监督状态;业务状态")
    @Size(max = 10, message = "监督状态;业务状态长度不能超过10个字符")
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
