package avicit.myportal.qms.qmsqualityobjective.dto;

import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.domain.BaseTreeDTO;
import avicit.platform6.core.properties.PlatformConstant;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.BooleanEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ExcelIgnoreUnannotated
@Data
@ContentRowHeight(20)
@ContentFontStyle(fontName = "华文中宋")
@HeadRowHeight(value = 40)
@HeadFontStyle(fontName = "华文中宋", bold = BooleanEnum.FALSE)
@HeadStyle(fillForegroundColor = 41)
public class QmsQualityObjectiveImportDTO{

    private static final long serialVersionUID = 1L;

    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 父节点ID显示字段
     */
    // @ExcelProperty("上级节点")
    private String parentTypeName;
    /**
     * ID
     */
    private String id;
    /**
     * 树节点排序号（本级）
     */

    @ExcelProperty("排序")
    @ColumnWidth(value = 8)
    @Digits(integer = 16, fraction = 0, message = "排序")
    private String treeSort;

    /**
    * 目标名称
    */
    @ExcelProperty("考核指标")
    private String objectiveName;

    /**
    * 目标内容
    */
    @ExcelProperty("指标说明")
    private String objectiveContent;

    /**
    * 目标层级;1所级5部门级
    */
    @ExcelProperty("目标层级\n所级、部门级")
    private String objectiveLevelName;


    /**
    * 统计部门
    */
    @ExcelProperty("统计部门")
    private String responsibleDeptName;

    /**
    * 统计周期;MONTH月度，QUARTER季度，HALFYEAR半年，YEAR年度，REALTIME根据系统数据动态更新
    */
    @ExcelProperty("统计周期\n月度、季度、半年")
    private String dataStatCycleName;



    /**
    * 密级
    */
    @ExcelProperty("密级")
    private String secretLevelName;


    /**
    * 所属年度
    */
    @ExcelProperty("所属年度\n例如：2026")
    private String forYear;


    /**
    * 建议承接部门
    */
    @ExcelProperty("建议承接部门")
    private String suggestAcceptDeptName;



    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}