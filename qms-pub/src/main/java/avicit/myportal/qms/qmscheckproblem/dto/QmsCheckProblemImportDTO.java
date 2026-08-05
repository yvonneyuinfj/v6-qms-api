package avicit.myportal.qms.qmscheckproblem.dto;

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
* @类说明：检查问题表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsCheckProblemImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 问题编号
    */
    @ExcelProperty("问题编号")
    @Size(max = 50, message = "问题编号长度不能超过50个字符")
    private String problemCode;
    /**
    * 所属年份
    */
    @ExcelProperty("所属年份")
    @Size(max = 10, message = "所属年份长度不能超过10个字符")
    private String forYear;
    /**
    * 问题描述
    */
    @ExcelProperty("问题描述")
    @Size(max = 256, message = "问题描述长度不能超过256个字符")
    private String problemDesc;
    /**
    * 问题分类
    */
    @ExcelProperty("问题分类")
    @Size(max = 50, message = "问题分类长度不能超过50个字符")
    private String problemCategory;
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
    @Size(max = 50, message = "整改单位长度不能超过50个字符")
    private String rectificationDeptName;
    /**
    * 责任人ID
    */
    @ExcelProperty("责任人ID")
    @Size(max = 64, message = "责任人ID长度不能超过64个字符")
    private String responsibleUserIds;
    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 10, message = "责任人CODE长度不能超过10个字符")
    private String responsibleUserCodes;
    /**
    * 责任人姓名
    */
    @ExcelProperty("责任人姓名")
    @Size(max = 50, message = "责任人姓名长度不能超过50个字符")
    private String responsibleUserNames;
    /**
    * 整改期限
    */

    @ExcelProperty("整改期限")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【整改期限】格式错误，正确格式为：yyyy/MM/dd")
    private String rectificationDeadline;
    /**
    * 问题状态
    */
    @ExcelProperty("问题状态")
    @Size(max = 30, message = "问题状态长度不能超过30个字符")
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
    * 整改提交时间
    */

    @ExcelProperty("整改提交时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【整改提交时间】格式错误，正确格式为：yyyy/MM/dd")
    private String submitTime;
    /**
    * 来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK
    */
    @ExcelProperty("来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK")
    @Size(max = 50, message = "来源类型;字典：INTERNAL_AUDIT;QUALITY_SUPERVISION;QUALITY_INSPECTION;QUALIFICATION_REVIEW;OTHER_CHECK长度不能超过50个字符")
    private String sourceType;
    /**
    * 来源业务ID;关联监督、检查、审核活动
    */
    @Size(max = 64, message = "来源业务ID;关联监督、检查、审核活动长度不能超过64个字符")
    private String sourceId;
    /**
    * 来源业务编号;检查编号、监督编号等
    */
    @ExcelProperty("来源业务编号;检查编号、监督编号等")
    @Size(max = 50, message = "来源业务编号;检查编号、监督编号等长度不能超过50个字符")
    private String sourceCode;
    /**
    * 来源业务名称;检查名称、审核名称等
    */
    @ExcelProperty("来源业务名称;检查名称、审核名称等")
    @Size(max = 256, message = "来源业务名称;检查名称、审核名称等长度不能超过256个字符")
    private String sourceName;
    /**
    * 问题等级
    */
    @ExcelProperty("问题等级")
    @Size(max = 50, message = "问题等级长度不能超过50个字符")
    private String problemLevel;
    /**
    * 依据条款
    */
    @ExcelProperty("依据条款")
    @Size(max = 1024, message = "依据条款长度不能超过1024个字符")
    private String baisisClause;
    /**
    * 发现时间
    */

    @ExcelProperty("发现时间")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【发现时间】格式错误，正确格式为：yyyy/MM/dd")
    private String foundTime;
    /**
    * 涉及型号
    */
    @ExcelProperty("涉及型号")
    @Size(max = 256, message = "涉及型号长度不能超过256个字符")
    private String model;
    /**
    * 发现人ID
    */
    @ExcelProperty("发现人ID")
    @Size(max = 64, message = "发现人ID长度不能超过64个字符")
    private String discovererStaffId;
    /**
    * 发现人CODE
    */
    @ExcelProperty("发现人CODE")
    @Size(max = 10, message = "发现人CODE长度不能超过10个字符")
    private String discovererStaffCode;
    /**
    * 发现人
    */
    @ExcelProperty("发现人")
    @Size(max = 50, message = "发现人长度不能超过50个字符")
    private String discovererStaffName;
    /**
    * 是否需要整改
    */
    @ExcelProperty("是否需要整改")
    @Size(max = 2, message = "是否需要整改长度不能超过2个字符")
    private String ynRectification;
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
