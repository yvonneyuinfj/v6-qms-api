package avicit.myportal.qms.qmsproblemrectification.dto;

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
* @创建时间： 2026-08-05 18:14
* @类说明：问题整改表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsProblemRectificationImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 问题ID
    */
    @Size(max = 64, message = "问题ID长度不能超过64个字符")
    private String checkProblemId;
    /**
    * 整改编号
    */
    @ExcelProperty("整改编号")
    @Size(max = 50, message = "整改编号长度不能超过50个字符")
    private String rectificationCode;
    /**
    * 所属年份;年度查询
    */
    @ExcelProperty("所属年份;年度查询")
    @Size(max = 10, message = "所属年份;年度查询长度不能超过10个字符")
    private String forYear;
    /**
    * 纠正类型;10纠正；20纠正计划
    */
    @ExcelProperty("纠正类型;10纠正；20纠正计划")
    @Size(max = 10, message = "纠正类型;10纠正；20纠正计划长度不能超过10个字符")
    private String correctionType;
    /**
    * 纠正或纠正计划;责任人填写
    */
    @ExcelProperty("纠正或纠正计划;责任人填写")
    @Size(max = 2000, message = "纠正或纠正计划;责任人填写长度不能超过2000个字符")
    private String correctionContent;
    /**
    * 原因分析;责任人填写
    */
    @ExcelProperty("原因分析;责任人填写")
    @Size(max = 2000, message = "原因分析;责任人填写长度不能超过2000个字符")
    private String causeAnalysis;
    /**
    * 纠正措施类型;10纠正措施；20纠正措施计划
    */
    @ExcelProperty("纠正措施类型;10纠正措施；20纠正措施计划")
    @Size(max = 10, message = "纠正措施类型;10纠正措施；20纠正措施计划长度不能超过10个字符")
    private String correctiveActionType;
    /**
    * 纠正措施或计划;责任人填写
    */
    @ExcelProperty("纠正措施或计划;责任人填写")
    @Size(max = 2000, message = "纠正措施或计划;责任人填写长度不能超过2000个字符")
    private String correctiveAction;
    /**
    * 举一反三情况;责任人填写
    */
    @ExcelProperty("举一反三情况;责任人填写")
    @Size(max = 2000, message = "举一反三情况;责任人填写长度不能超过2000个字符")
    private String horizontalCheck;
    /**
    * 整改完成情况;整改完成结果和效果说明
    */
    @ExcelProperty("整改完成情况;整改完成结果和效果说明")
    @Size(max = 2000, message = "整改完成情况;整改完成结果和效果说明长度不能超过2000个字符")
    private String rectificationResult;
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
    * 整改完成时间
    */

    @ExcelProperty("整改完成时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【整改完成时间】格式错误，正确格式为：yyyy/MM/dd")
    private String completeTime;
    /**
    * 提交时间
    */

    @ExcelProperty("提交时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【提交时间】格式错误，正确格式为：yyyy/MM/dd")
    private String submitTime;
    /**
    * 来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告
    */
    @ExcelProperty("来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告")
    @Size(max = 50, message = "来源类型;字典：质量问题、内部审核（不符合项）、质量监督（问题）、资质管理（不符合项或问题项）、管理评审、不合格品（不合格审理）、举手报告长度不能超过50个字符")
    private String sourceType;
    /**
    * 来源业务ID;来源问题主键
    */
    @ExcelProperty("来源业务ID;来源问题主键")
    @Size(max = 64, message = "来源业务ID;来源问题主键长度不能超过64个字符")
    private String sourceId;
    /**
    * 来源问题编号;来源业务问题编号
    */
    @ExcelProperty("来源问题编号;来源业务问题编号")
    @Size(max = 50, message = "来源问题编号;来源业务问题编号长度不能超过50个字符")
    private String sourceCode;
    /**
    * 来源问题名称;用于列表展示
    */
    @ExcelProperty("来源问题名称;用于列表展示")
    @Size(max = 128, message = "来源问题名称;用于列表展示长度不能超过128个字符")
    private String sourceName;
    /**
    * 问题描述;从来源业务复制
    */
    @ExcelProperty("问题描述;从来源业务复制")
    @Size(max = 512, message = "问题描述;从来源业务复制长度不能超过512个字符")
    private String problemDesc;
    /**
    * 问题分类;字典
    */
    @ExcelProperty("问题分类;字典")
    @Size(max = 10, message = "问题分类;字典长度不能超过10个字符")
    private String problemCategory;
    /**
    * 整改要求;问题提出部门填写
    */
    @ExcelProperty("整改要求;问题提出部门填写")
    @Size(max = 512, message = "整改要求;问题提出部门填写长度不能超过512个字符")
    private String rectificationRequirement;
    /**
    * 问题发现时间
    */

    @ExcelProperty("问题发现时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【问题发现时间】格式错误，正确格式为：yyyy/MM/dd")
    private String foundTime;
    /**
    * 整改单位ID
    */
    @ExcelProperty("整改单位ID")
    @Size(max = 64, message = "整改单位ID长度不能超过64个字符")
    private String rectificationDeptId;
    /**
    * 整改单位CODE
    */
    @ExcelProperty("整改单位CODE")
    @Size(max = 10, message = "整改单位CODE长度不能超过10个字符")
    private String rectificationDeptCode;
    /**
    * 整改单位
    */
    @ExcelProperty("整改单位")
    @Size(max = 128, message = "整改单位长度不能超过128个字符")
    private String rectificationDeptName;
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
    * 整改期限
    */

    @ExcelProperty("整改期限")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【整改期限】格式错误，正确格式为：yyyy/MM/dd")
    private String rectificationDeadline;
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
