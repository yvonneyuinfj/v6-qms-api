package avicit.myportal.qms.qmsauditnc.dto;

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
* @创建时间： 2026-08-28 16:14
* @类说明：不符合项表导入DTO
* @修改记录：
*/
@ExcelIgnoreUnannotated
@Data
public class QmsAuditNcImportDTO{
private static final long serialVersionUID = 1L;
    /**
    * 不符合项编号
    */
    @ExcelProperty("不符合项编号")
    @Size(max = 50, message = "不符合项编号长度不能超过50个字符")
    private String ncCode;
    /**
    * 审核记录ID
    */
    @ExcelProperty("审核记录ID")
    @Size(max = 64, message = "审核记录ID长度不能超过64个字符")
    private String recordId;
    /**
    * 审核计划ID;关联年度计划
    */
    @ExcelProperty("审核计划ID;关联年度计划")
    @Size(max = 64, message = "审核计划ID;关联年度计划长度不能超过64个字符")
    private String planId;
    /**
    * 审核通知单ID;关联已批准通知单
    */
    @ExcelProperty("审核通知单ID;关联已批准通知单")
    @Size(max = 64, message = "审核通知单ID;关联已批准通知单长度不能超过64个字符")
    private String noticeId;
    /**
    * 检查明细ID
    */
    @ExcelProperty("检查明细ID")
    @Size(max = 64, message = "检查明细ID长度不能超过64个字符")
    private String detailId;
    /**
    * 受审部门ID;通知单带入
    */
    @ExcelProperty("受审部门ID;通知单带入")
    @Size(max = 64, message = "受审部门ID;通知单带入长度不能超过64个字符")
    private String auditeeDeptId;
    /**
    * 受审部门CODE;通知单带入
    */
    @ExcelProperty("受审部门CODE;通知单带入")
    @Size(max = 10, message = "受审部门CODE;通知单带入长度不能超过10个字符")
    private String auditeeDeptCode;
    /**
    * 受审部门;通知单带入
    */
    @ExcelProperty("受审部门;通知单带入")
    @Size(max = 50, message = "受审部门;通知单带入长度不能超过50个字符")
    private String auditeeDeptName;
    /**
    * 审核依据的标准和文件;主审填写
    */
    @ExcelProperty("审核依据的标准和文件;主审填写")
    @Size(max = 512, message = "审核依据的标准和文件;主审填写长度不能超过512个字符")
    private String auditBasis;
    /**
    * 审核时间;通知单带入
    */

    @ExcelProperty("审核时间;通知单带入")
    @DateTimeStr(format ="yyyy/MM/dd", message = "【审核时间;通知单带入】格式错误，正确格式为：yyyy/MM/dd")
    private String auditTime;
    /**
    * 受审方人员ID;通知单带入
    */
    @ExcelProperty("受审方人员ID;通知单带入")
    @Size(max = 512, message = "受审方人员ID;通知单带入长度不能超过512个字符")
    private String auditeeUserId;
    /**
    * 受审方人员CODE;通知单带入
    */
    @ExcelProperty("受审方人员CODE;通知单带入")
    @Size(max = 200, message = "受审方人员CODE;通知单带入长度不能超过200个字符")
    private String auditeeUserCode;
    /**
    * 受审方人员;通知单带入
    */
    @ExcelProperty("受审方人员;通知单带入")
    @Size(max = 200, message = "受审方人员;通知单带入长度不能超过200个字符")
    private String auditeeUserName;
    /**
    * 不符合程度;一般、严重
    */
    @ExcelProperty("不符合程度;一般、严重")
    @Size(max = 4, message = "不符合程度;一般、严重长度不能超过4个字符")
    private String ncLevel;
    /**
    * 不符合标准条款号
    */
    @ExcelProperty("不符合标准条款号")
    @Size(max = 50, message = "不符合标准条款号长度不能超过50个字符")
    private String standardClauseNo;
    /**
    * 不符合项实施描述
    */
    @ExcelProperty("不符合项实施描述")
    @Size(max = 2000, message = "不符合项实施描述长度不能超过2000个字符")
    private String ncFactDesc;
    /**
    * 整改处理人ID
    */
    @ExcelProperty("整改处理人ID")
    @Size(max = 500, message = "整改处理人ID长度不能超过500个字符")
    private String rectifyHandlerId;
    /**
    * 整改处理人CODE
    */
    @ExcelProperty("整改处理人CODE")
    @Size(max = 256, message = "整改处理人CODE长度不能超过256个字符")
    private String rectifyHandlerCode;
    /**
    * 整改处理人
    */
    @ExcelProperty("整改处理人")
    @Size(max = 256, message = "整改处理人长度不能超过256个字符")
    private String rectifyHandlerName;
    /**
    * 行动项ID
    */
    @ExcelProperty("行动项ID")
    @Size(max = 64, message = "行动项ID长度不能超过64个字符")
    private String actionId;
    /**
    * 业务状态;草稿、审批中、整改中、已关闭等
    */
    @ExcelProperty("业务状态;草稿、审批中、整改中、已关闭等")
    @Size(max = 10, message = "业务状态;草稿、审批中、整改中、已关闭等长度不能超过10个字符")
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
    /**
    * 交付物
    */
    @ExcelProperty("交付物")
    @Size(max = 128, message = "交付物长度不能超过128个字符")
    private String expectedDeliverable;

    @ColumnWidth(30)
    @ContentFontStyle(color=10)
    @ExcelProperty("错误信息")
    private String errorInfo;
}
