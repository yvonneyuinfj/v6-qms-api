package avicit.myportal.qms.qmsmilitaryqualification.dto;

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
* @创建时间： 2026-08-05 18:06
* @类说明：军工资质基本信息导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsMilitaryQualificationImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 归组ID;同一资质不同版本保持一致
    */
    @ExcelProperty("归组ID;同一资质不同版本保持一致")
    @Size(max = 64, message = "归组ID;同一资质不同版本保持一致长度不能超过64个字符")
    private String qualificationGroupId;
    /**
    * 类型CODE;字典
    */
    @ExcelProperty("类型CODE;字典")
    @Size(max = 50, message = "类型CODE;字典长度不能超过50个字符")
    private String qualificationTypeCode;
    /**
    * 类型;资质类型名称
    */
    @ExcelProperty("类型;资质类型名称")
    @Size(max = 128, message = "类型;资质类型名称长度不能超过128个字符")
    private String qualificationTypeName;
    /**
    * 证书编号
    */
    @ExcelProperty("证书编号")
    @Size(max = 128, message = "证书编号长度不能超过128个字符")
    private String certificationCode;
    /**
    * 资质范围
    */
    @ExcelProperty("资质范围")
    @Size(max = 2000, message = "资质范围长度不能超过2000个字符")
    private String qualificationScope;
    /**
    * 生效日期
    */

    @ExcelProperty("生效日期")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【生效日期】格式错误，正确格式为：yyyy/MM/dd")
    private String effectiveTime;
    /**
    * 失效日期
    */

    @ExcelProperty("失效日期")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【失效日期】格式错误，正确格式为：yyyy/MM/dd")
    private String expiryTime;
    /**
    * 颁发机构
    */
    @ExcelProperty("颁发机构")
    @Size(max = 256, message = "颁发机构长度不能超过256个字符")
    private String issuingAgency;
    /**
    * 证书版本号
    */
    @ExcelProperty("证书版本号")
    @Size(max = 128, message = "证书版本号长度不能超过128个字符")
    private String certVersionNo;
    /**
    * 上一版本ID
    */
    @ExcelProperty("上一版本ID")
    @Size(max = 64, message = "上一版本ID长度不能超过64个字符")
    private String previousVersionId;
    /**
    * 是否当前版本
    */
    @ExcelProperty("是否当前版本")
    @Size(max = 2, message = "是否当前版本长度不能超过2个字符")
    private String ynCurrent;
    /**
    * 版本变更类型;字典：初始、换证、增项、变更、补发等
    */
    @ExcelProperty("版本变更类型;字典：初始、换证、增项、变更、补发等")
    @Size(max = 50, message = "版本变更类型;字典：初始、换证、增项、变更、补发等长度不能超过50个字符")
    private String changeType;
    /**
    * 变更内容;说明本版本变化
    */
    @ExcelProperty("变更内容;说明本版本变化")
    @Size(max = 2000, message = "变更内容;说明本版本变化长度不能超过2000个字符")
    private String changeContent;
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
    * 责任部门ID
    */
    @ExcelProperty("责任部门ID")
    @Size(max = 64, message = "责任部门ID长度不能超过64个字符")
    private String responsibleDeptId;
    /**
    * 责任部门CODE
    */
    @ExcelProperty("责任部门CODE")
    @Size(max = 10, message = "责任部门CODE长度不能超过10个字符")
    private String responsibleDeptCode;
    /**
    * 责任部门
    */
    @ExcelProperty("责任部门")
    @Size(max = 128, message = "责任部门长度不能超过128个字符")
    private String responsibleDeptName;
    /**
    * 附件ID
    */
    @ExcelProperty("附件ID")
    @Size(max = 256, message = "附件ID长度不能超过256个字符")
    private String fileId;
    /**
    * 证书状态
    */
    @ExcelProperty("证书状态")
    @Size(max = 10, message = "证书状态长度不能超过10个字符")
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
