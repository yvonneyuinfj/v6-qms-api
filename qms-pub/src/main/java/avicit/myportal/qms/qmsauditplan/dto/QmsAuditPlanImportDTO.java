package avicit.myportal.qms.qmsauditplan.dto;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.annotation.ExcelProperty;
import avicit.platform6.core.validate.DateTimeStr;
import javax.validation.constraints.*;

import com.alibaba.excel.enums.BooleanEnum;
import lombok.Data;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 18:41
* @类说明：年度内审计划及执行主表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
@ContentRowHeight(20)
@ContentFontStyle(fontName = "华文中宋")
@HeadRowHeight(value = 40)
@HeadFontStyle(fontName = "华文中宋", bold = BooleanEnum.FALSE)
@HeadStyle(fillForegroundColor = 41)
public class QmsAuditPlanImportDTO{
private static final long serialVersionUID = 1L;

    /**
    * 受审部门
    */
    @ExcelProperty("受审核部门")
    @Size(max = 50, message = "受审核部门长度不能超过50个字符")
    private String auditeeDeptName;

    /**
    * 审核条款
    */
    @ExcelProperty("审核条款")
    @Size(max = 512, message = "审核条款长度不能超过512个字符")
    private String auditClause;

    /**
    * 型号/项目
    */
    @ExcelProperty("型号/项目")
    @Size(max = 512, message = "型号/项目长度不能超过512个字符")
    private String modelProject;

    /**
    * 审核员
    */
    @ExcelProperty("审核员")
    @Size(max = 200, message = "审核员长度不能超过200个字符")
    private String auditorName;

    /**
     * 审核时间
     */

    @ExcelProperty("审核时间\n正确格式为：yyyy/MM/dd")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【审核时间】格式错误，正确格式为：yyyy/MM/dd")
    private String auditTime;

    /**
     * 年度
     */
    @ExcelProperty("年度")
    @Size(max = 10, message = "年度长度不能超过10个字符")
    private String forYear;

    /**
     * 排序
     */
    @ExcelProperty("排序")
    private int orderBy;


    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
