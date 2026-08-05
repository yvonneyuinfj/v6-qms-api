package avicit.myportal.qms.qmsmrimprovement.dto;

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
* @创建时间： 2026-08-03 19:45
* @类说明：管评改进项台账导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsMrImprovementImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 年度
    */
    @ExcelProperty("年度")
    @Size(max = 4, message = "年度长度不能超过4个字符")
    private String forYear;
    /**
    * 编号
    */
    @ExcelProperty("编号")
    @Size(max = 64, message = "编号长度不能超过64个字符")
    private String improvementCode;
    /**
    * 材料名称
    */
    @ExcelProperty("材料名称")
    @Size(max = 256, message = "材料名称长度不能超过256个字符")
    private String improvementName;
    /**
    * 改进要求要求
    */
    @ExcelProperty("改进要求要求")
    @Size(max = 512, message = "改进要求要求长度不能超过512个字符")
    private String improvementContent;
    /**
    * 改进项类型;课题、建议
    */
    @ExcelProperty("改进项类型;课题、建议")
    @Size(max = 10, message = "改进项类型;课题、建议长度不能超过10个字符")
    private String improvementType;
    /**
    * 改进类别;战略级转型和变革、战术级改进和优化
    */
    @ExcelProperty("改进类别;战略级转型和变革、战术级改进和优化")
    @Size(max = 64, message = "改进类别;战略级转型和变革、战术级改进和优化长度不能超过64个字符")
    private String category;
    /**
    * 提出人ID
    */
    @ExcelProperty("提出人ID")
    @Size(max = 64, message = "提出人ID长度不能超过64个字符")
    private String proposerId;
    /**
    * 提出人CODE
    */
    @ExcelProperty("提出人CODE")
    @Size(max = 50, message = "提出人CODE长度不能超过50个字符")
    private String proposerCode;
    /**
    * 提出人
    */
    @ExcelProperty("提出人")
    @Size(max = 50, message = "提出人长度不能超过50个字符")
    private String proposerName;
    /**
    * 主管所领导ID
    */
    @ExcelProperty("主管所领导ID")
    @Size(max = 64, message = "主管所领导ID长度不能超过64个字符")
    private String responsibleSleaderId;
    /**
    * 主管所领导CODE
    */
    @ExcelProperty("主管所领导CODE")
    @Size(max = 50, message = "主管所领导CODE长度不能超过50个字符")
    private String responsibleSleaderCode;
    /**
    * 主管所领导
    */
    @ExcelProperty("主管所领导")
    @Size(max = 50, message = "主管所领导长度不能超过50个字符")
    private String responsibleSleaderName;
    /**
    * 主责部门ID
    */
    @ExcelProperty("主责部门ID")
    @Size(max = 64, message = "主责部门ID长度不能超过64个字符")
    private String responsibleDeptId;
    /**
    * 主责部门CODE
    */
    @ExcelProperty("主责部门CODE")
    @Size(max = 50, message = "主责部门CODE长度不能超过50个字符")
    private String responsibleDeptCode;
    /**
    * 主责部门
    */
    @ExcelProperty("主责部门")
    @Size(max = 50, message = "主责部门长度不能超过50个字符")
    private String responsibleDeptName;
    /**
    * 责任领导ID
    */
    @ExcelProperty("责任领导ID")
    @Size(max = 64, message = "责任领导ID长度不能超过64个字符")
    private String responsibleDeptLeaderId;
    /**
    * 责任领导CODE
    */
    @ExcelProperty("责任领导CODE")
    @Size(max = 50, message = "责任领导CODE长度不能超过50个字符")
    private String responsibleDeptLeaderCode;
    /**
    * 责任领导
    */
    @ExcelProperty("责任领导")
    @Size(max = 50, message = "责任领导长度不能超过50个字符")
    private String responsibleDeptLeaderName;
    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    private String responsibleUserId;
    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 50, message = "责任人CODE长度不能超过50个字符")
    private String responsibleUserCode;
    /**
    * 责任人
    */
    @ExcelProperty("责任人")
    @Size(max = 50, message = "责任人长度不能超过50个字符")
    private String responsibleUserName;
    /**
    * 参与部门ID
    */
    @ExcelProperty("参与部门ID")
    @Size(max = 1000, message = "参与部门ID长度不能超过1000个字符")
    private String participatingDeptId;
    /**
    * 参与部门CODE
    */
    @ExcelProperty("参与部门CODE")
    @Size(max = 500, message = "参与部门CODE长度不能超过500个字符")
    private String participatingDeptCode;
    /**
    * 参与部门
    */
    @ExcelProperty("参与部门")
    @Size(max = 1000, message = "参与部门长度不能超过1000个字符")
    private String participatingDeptName;
    /**
    * 产生原因分析;或与目标差距分析
    */
    @ExcelProperty("产生原因分析;或与目标差距分析")
    @Size(max = 500, message = "产生原因分析;或与目标差距分析长度不能超过500个字符")
    private String causeAnalysis;
    /**
    * 开始时间
    */

    @ExcelProperty("开始时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【开始时间】格式错误，正确格式为：yyyy/MM/dd")
    private String startTime;
    /**
    * 截止时间
    */

    @ExcelProperty("截止时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【截止时间】格式错误，正确格式为：yyyy/MM/dd")
    private String deadline;
    /**
    * 预期改进效果
    */
    @ExcelProperty("预期改进效果")
    @Size(max = 500, message = "预期改进效果长度不能超过500个字符")
    private String expectedResult;
    /**
    * 公共行动项ID
    */
    @ExcelProperty("公共行动项ID")
    @Size(max = 64, message = "公共行动项ID长度不能超过64个字符")
    private String actionId;
    /**
    * 总体进度
    */

    @ExcelProperty("总体进度")
    @Digits(integer = 3, fraction = 0, message = "总体进度格式不正确")
    private String progress;
    /**
    * 风险状态
    */
    @ExcelProperty("风险状态")
    @Size(max = 10, message = "风险状态长度不能超过10个字符")
    private String riskStatus;
    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    private String status;
    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    private String expectedDeliverable;
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
