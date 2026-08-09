package avicit.myportal.qms.qmsbasicmodelinfo.dto;

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
* @创建时间： 2026-08-08 17:12
* @类说明：QMS_BASIC_MODEL_INFO导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsBasicModelInfoImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 200, message = "型号长度不能超过200个字符")
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
    /**
    * 总师单位
    */
    @ExcelProperty("总师单位")
    @Size(max = 200, message = "总师单位长度不能超过200个字符")
    private String managerDept;
    /**
    * 总承单位
    */
    @ExcelProperty("总承单位")
    @Size(max = 200, message = "总承单位长度不能超过200个字符")
    private String productDept;
    /**
    * 军代表ID
    */
    @ExcelProperty("军代表ID")
    @Size(max = 2000, message = "军代表ID长度不能超过2000个字符")
    private String milRepId;
    /**
    * 军代表CODE
    */
    @ExcelProperty("军代表CODE")
    @Size(max = 500, message = "军代表CODE长度不能超过500个字符")
    private String milRepCode;
    /**
    * 军代表
    */
    @ExcelProperty("军代表")
    @Size(max = 1000, message = "军代表长度不能超过1000个字符")
    private String milRepName;
    /**
    * 副总师ID
    */
    @ExcelProperty("副总师ID")
    @Size(max = 2000, message = "副总师ID长度不能超过2000个字符")
    private String deputyChiefDesignerId;
    /**
    * 副总师CODE
    */
    @ExcelProperty("副总师CODE")
    @Size(max = 500, message = "副总师CODE长度不能超过500个字符")
    private String deputyChiefDesignerCode;
    /**
    * 副总师
    */
    @ExcelProperty("副总师")
    @Size(max = 1000, message = "副总师长度不能超过1000个字符")
    private String deputyChiefDesignerName;
    /**
    * 科研部主管ID
    */
    @ExcelProperty("科研部主管ID")
    @Size(max = 2000, message = "科研部主管ID长度不能超过2000个字符")
    private String rdManagerId;
    /**
    * 科研部主管CODE
    */
    @ExcelProperty("科研部主管CODE")
    @Size(max = 500, message = "科研部主管CODE长度不能超过500个字符")
    private String rdManagerCode;
    /**
    * 科研部主管
    */
    @ExcelProperty("科研部主管")
    @Size(max = 1000, message = "科研部主管长度不能超过1000个字符")
    private String rdManagerName;
    /**
    * 质量部主管ID
    */
    @ExcelProperty("质量部主管ID")
    @Size(max = 2000, message = "质量部主管ID长度不能超过2000个字符")
    private String qaManagerId;
    /**
    * 质量部主管CODE
    */
    @ExcelProperty("质量部主管CODE")
    @Size(max = 500, message = "质量部主管CODE长度不能超过500个字符")
    private String qaManagerCode;
    /**
    * 质量部主管
    */
    @ExcelProperty("质量部主管")
    @Size(max = 1000, message = "质量部主管长度不能超过1000个字符")
    private String qaManagerName;

    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
