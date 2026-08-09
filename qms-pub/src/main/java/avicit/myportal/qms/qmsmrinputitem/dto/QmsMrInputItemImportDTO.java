package avicit.myportal.qms.qmsmrinputitem.dto;

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
* @创建时间： 2026-08-03 19:43
* @类说明：管评输入材料分工台账导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsMrInputItemImportDTO{
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
    private String sequenceCode;
    /**
    * 材料名称
    */
    @ExcelProperty("材料名称")
    @Size(max = 256, message = "材料名称长度不能超过256个字符")
    private String materalName;
    /**
    * 主要要求
    */
    @ExcelProperty("主要要求")
    @Size(max = 512, message = "主要要求长度不能超过512个字符")
    private String mainRequirement;
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
    * 交付物要求
    */
    @ExcelProperty("交付物要求")
    @Size(max = 512, message = "交付物要求长度不能超过512个字符")
    private String deliverableRequirement;
    /**
    * 材料来源类型;常规材料、上年度改进项等
    */
    @ExcelProperty("材料来源类型;常规材料、上年度改进项等")
    @Size(max = 128, message = "材料来源类型;常规材料、上年度改进项等长度不能超过128个字符")
    private String sourceType;
    /**
    * 来源ID
    */
    @ExcelProperty("来源ID")
    @Size(max = 64, message = "来源ID长度不能超过64个字符")
    private String sourceId;
    /**
    * 是否逾期
    */
    @ExcelProperty("是否逾期")
    @Size(max = 4, message = "是否逾期长度不能超过4个字符")
    private String ynOverdue;
    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    private String status;
    /**
    * 交付物提交状态
    */
    @ExcelProperty("交付物提交状态")
    @Size(max = 10, message = "交付物提交状态长度不能超过10个字符")
    private String feedbackStatus;
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
