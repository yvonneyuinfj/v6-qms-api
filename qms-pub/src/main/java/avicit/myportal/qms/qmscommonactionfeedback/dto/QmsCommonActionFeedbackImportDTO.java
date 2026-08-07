package avicit.myportal.qms.qmscommonactionfeedback.dto;

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
* @创建时间： 2026-08-04 15:12
* @类说明：通用执行反馈表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsCommonActionFeedbackImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 实施计划ID
    */
    @Size(max = 64, message = "实施计划ID长度不能超过64个字符")
    private String planId;
    /**
    * 实施计划名称
    */
    @ExcelProperty("实施计划名称")
    @Size(max = 256, message = "实施计划名称长度不能超过256个字符")
    private String planName;
    /**
    * 实际完成时间
    */

    @ExcelProperty("实际完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【实际完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String actualFinishTime;
    /**
    * 完成情况说明
    */
    @ExcelProperty("完成情况说明")
    @Size(max = 1000, message = "完成情况说明长度不能超过1000个字符")
    private String feedbackContent;
    /**
    * 反馈时间
    */

    @ExcelProperty("反馈时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【反馈时间】格式错误，正确格式为：yyyy/MM/dd")
    private String feedbackTime;
    /**
    * 反馈人ID
    */
    @ExcelProperty("反馈人ID")
    @Size(max = 64, message = "反馈人ID长度不能超过64个字符")
    private String feedbackUserId;
    /**
    * 反馈人CODE
    */
    @ExcelProperty("反馈人CODE")
    @Size(max = 10, message = "反馈人CODE长度不能超过10个字符")
    private String feedbackUserCode;
    /**
    * 反馈人
    */
    @ExcelProperty("反馈人")
    @Size(max = 50, message = "反馈人长度不能超过50个字符")
    private String feedbackUserName;
    /**
    * 本次进度
    */

    @ExcelProperty("本次进度")
    @Digits(integer = 2, fraction = 0, message = "本次进度格式不正确")
    private String progress;
    /**
    * 是否完成
    */
    @ExcelProperty("是否完成")
    @Size(max = 2, message = "是否完成长度不能超过2个字符")
    private String ynFinish;
    /**
    * 存在问题
    */
    @ExcelProperty("存在问题")
    @Size(max = 1000, message = "存在问题长度不能超过1000个字符")
    private String problemDesc;
    /**
    * 下一步措施
    */
    @ExcelProperty("下一步措施")
    @Size(max = 1000, message = "下一步措施长度不能超过1000个字符")
    private String nextMeasure;
    /**
    * 是否存在风险
    */
    @ExcelProperty("是否存在风险")
    @Size(max = 2, message = "是否存在风险长度不能超过2个字符")
    private String ynRisk;
    /**
    * 风险说明
    */
    @ExcelProperty("风险说明")
    @Size(max = 1000, message = "风险说明长度不能超过1000个字符")
    private String riskDesc;
    /**
    * 审批状态
    */
    @ExcelProperty("审批状态")
    @Size(max = 10, message = "审批状态长度不能超过10个字符")
    private String approvalStatus;
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
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    private String parentId;
    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    private String treePath;
    /**
    * 节点层级
    */

    @Digits(integer = 16, fraction = 0, message = "节点层级格式不正确")
    private String treeLevel;
    /**
    * 本级排序
    */

    @NotNull(message = "本级排序不能为空")
    @Digits(integer = 16, fraction = 0, message = "本级排序格式不正确")
    private String treeSort;
    /**
    * 全级排序
    */
    @Size(max = 1000, message = "全级排序长度不能超过1000个字符")
    private String treeSorts;
    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    private String treeLeaf;

    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
