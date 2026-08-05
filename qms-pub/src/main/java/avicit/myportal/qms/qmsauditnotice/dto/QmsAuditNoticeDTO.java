package avicit.myportal.qms.qmsauditnotice.dto;

import avicit.platform6.core.annotation.log.FieldRemark;
import avicit.platform6.core.annotation.log.PojoRemark;
import avicit.platform6.core.annotation.log.Id;
import avicit.platform6.core.annotation.log.LogField;
import avicit.platform6.core.domain.BeanDTO;
import avicit.platform6.core.properties.PlatformConstant;
import avicit.platform6.commons.utils.StringUtils;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.*;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:30
* @类说明：内审通知单DTO
* @修改记录：
*/
@ApiModel(value = "QmsAuditNoticeDTO", description = "内审通知单")
@PojoRemark(table="QMS_AUDIT_NOTICE", object="QmsAuditNoticeDTO", name="内审通知单")
@ExcelIgnoreUnannotated
public class QmsAuditNoticeDTO extends BeanDTO{
    private static final long serialVersionUID = 1L;


    /**
    * ID
    */
    @Id
    @Size(max = 64, message = "ID长度不能超过64个字符")
    @ApiModelProperty(value = "ID", name = "id")
    @FieldRemark(column="ID", field="id", name="ID")
    private java.lang.String id;

    /**
    * 审核计划ID
    */
    @ExcelProperty("审核计划ID")
    @Size(max = 64, message = "审核计划ID长度不能超过64个字符")
    @ApiModelProperty(value = "审核计划ID", name = "planId")
    @FieldRemark(column="PLAN_ID", field="planId", name="审核计划ID")
    private java.lang.String planId;

    /**
    * 通知单编号;系统生成
    */
    @ExcelProperty("通知单编号;系统生成")
    @Size(max = 50, message = "通知单编号;系统生成长度不能超过50个字符")
    @ApiModelProperty(value = "通知单编号;系统生成", name = "noticeCode")
    @FieldRemark(column="NOTICE_CODE", field="noticeCode", name="通知单编号;系统生成")
    private java.lang.String noticeCode;

    /**
    * 通知单名称
    */
    @ExcelProperty("通知单名称")
    @Size(max = 50, message = "通知单名称长度不能超过50个字符")
    @ApiModelProperty(value = "通知单名称", name = "noticeName")
    @FieldRemark(column="NOTICE_NAME", field="noticeName", name="通知单名称")
    private java.lang.String noticeName;

    /**
    * 审核目的;主审填写
    */
    @ExcelProperty("审核目的;主审填写")
    @Size(max = 512, message = "审核目的;主审填写长度不能超过512个字符")
    @ApiModelProperty(value = "审核目的;主审填写", name = "auditPurpose")
    @FieldRemark(column="AUDIT_PURPOSE", field="auditPurpose", name="审核目的;主审填写")
    private java.lang.String auditPurpose;

    /**
    * 审核依据的标准和文件;主审填写
    */
    @ExcelProperty("审核依据的标准和文件;主审填写")
    @Size(max = 512, message = "审核依据的标准和文件;主审填写长度不能超过512个字符")
    @ApiModelProperty(value = "审核依据的标准和文件;主审填写", name = "auditBasis")
    @FieldRemark(column="AUDIT_BASIS", field="auditBasis", name="审核依据的标准和文件;主审填写")
    private java.lang.String auditBasis;

    /**
    * 审核条款
    */
    @ExcelProperty("审核条款")
    @Size(max = 512, message = "审核条款长度不能超过512个字符")
    @ApiModelProperty(value = "审核条款", name = "auditClause")
    @FieldRemark(column="AUDIT_CLAUSE", field="auditClause", name="审核条款")
    private java.lang.String auditClause;

    /**
    * 型号/项目
    */
    @ExcelProperty("型号/项目")
    @Size(max = 512, message = "型号/项目长度不能超过512个字符")
    @ApiModelProperty(value = "型号/项目", name = "modelProject")
    @FieldRemark(column="MODEL_PROJECT", field="modelProject", name="型号/项目")
    private java.lang.String modelProject;

    /**
    * 审核范围
    */
    @ExcelProperty("审核范围")
    @Size(max = 512, message = "审核范围长度不能超过512个字符")
    @ApiModelProperty(value = "审核范围", name = "auditScope")
    @FieldRemark(column="AUDIT_SCOPE", field="auditScope", name="审核范围")
    private java.lang.String auditScope;

    /**
    * 审核覆盖产品;主审填写
    */
    @ExcelProperty("审核覆盖产品;主审填写")
    @Size(max = 512, message = "审核覆盖产品;主审填写长度不能超过512个字符")
    @ApiModelProperty(value = "审核覆盖产品;主审填写", name = "coveredProduct")
    @FieldRemark(column="COVERED_PRODUCT", field="coveredProduct", name="审核覆盖产品;主审填写")
    private java.lang.String coveredProduct;
    /**
    * 审核日期;主审填写
    */
    @ExcelProperty("审核日期;主审填写")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "审核日期;主审填写", name = "auditTime")
    @FieldRemark(column="AUDIT_TIME", field="auditTime", name="审核日期;主审填写")
    private java.util.Date auditTime;

    /**
    * 审核日期;主审填写起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date auditTimeBegin;

    /**
    * 审核日期;主审填写止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date auditTimeEnd;
    /**
    * 审核持续天数
    */
    @ExcelProperty("审核持续天数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 3, fraction = 0, message = "审核持续天数格式不正确")
    @ApiModelProperty(value = "审核持续天数", name = "durationDays")
    @FieldRemark(column="DURATION_DAYS", field="durationDays", name="审核持续天数")
    private java.math.BigDecimal durationDays;

    /**
    * 受审部门ID
    */
    @ExcelProperty("受审部门ID")
    @Size(max = 64, message = "受审部门ID长度不能超过64个字符")
    @ApiModelProperty(value = "受审部门ID", name = "auditeeDeptId")
    @FieldRemark(column="AUDITEE_DEPT_ID", field="auditeeDeptId", name="受审部门ID")
    private java.lang.String auditeeDeptId;

    /**
    * 受审部门CODE
    */
    @ExcelProperty("受审部门CODE")
    @Size(max = 10, message = "受审部门CODE长度不能超过10个字符")
    @ApiModelProperty(value = "受审部门CODE", name = "auditeeDeptCode")
    @FieldRemark(column="AUDITEE_DEPT_CODE", field="auditeeDeptCode", name="受审部门CODE")
    private java.lang.String auditeeDeptCode;

    /**
    * 受审部门
    */
    @ExcelProperty("受审部门")
    @Size(max = 50, message = "受审部门长度不能超过50个字符")
    @ApiModelProperty(value = "受审部门", name = "auditeeDeptName")
    @FieldRemark(column="AUDITEE_DEPT_NAME", field="auditeeDeptName", name="受审部门")
    private java.lang.String auditeeDeptName;

    /**
    * 单位负责人ID
    */
    @ExcelProperty("单位负责人ID")
    @Size(max = 64, message = "单位负责人ID长度不能超过64个字符")
    @ApiModelProperty(value = "单位负责人ID", name = "auditeeLeaderId")
    @FieldRemark(column="AUDITEE_LEADER_ID", field="auditeeLeaderId", name="单位负责人ID")
    private java.lang.String auditeeLeaderId;

    /**
    * 单位负责人CODE
    */
    @ExcelProperty("单位负责人CODE")
    @Size(max = 10, message = "单位负责人CODE长度不能超过10个字符")
    @ApiModelProperty(value = "单位负责人CODE", name = "auditeeLeaderCode")
    @FieldRemark(column="AUDITEE_LEADER_CODE", field="auditeeLeaderCode", name="单位负责人CODE")
    private java.lang.String auditeeLeaderCode;

    /**
    * 单位负责人
    */
    @ExcelProperty("单位负责人")
    @Size(max = 50, message = "单位负责人长度不能超过50个字符")
    @ApiModelProperty(value = "单位负责人", name = "auditeeLeaderName")
    @FieldRemark(column="AUDITEE_LEADER_NAME", field="auditeeLeaderName", name="单位负责人")
    private java.lang.String auditeeLeaderName;

    /**
    * 审核员ID;主审填写
    */
    @ExcelProperty("审核员ID;主审填写")
    @Size(max = 512, message = "审核员ID;主审填写长度不能超过512个字符")
    @ApiModelProperty(value = "审核员ID;主审填写", name = "auditorId")
    @FieldRemark(column="AUDITOR_ID", field="auditorId", name="审核员ID;主审填写")
    private java.lang.String auditorId;

    /**
    * 审核员CODE;主审填写
    */
    @ExcelProperty("审核员CODE;主审填写")
    @Size(max = 200, message = "审核员CODE;主审填写长度不能超过200个字符")
    @ApiModelProperty(value = "审核员CODE;主审填写", name = "auditorCode")
    @FieldRemark(column="AUDITOR_CODE", field="auditorCode", name="审核员CODE;主审填写")
    private java.lang.String auditorCode;

    /**
    * 审核员;主审填写
    */
    @ExcelProperty("审核员;主审填写")
    @Size(max = 200, message = "审核员;主审填写长度不能超过200个字符")
    @ApiModelProperty(value = "审核员;主审填写", name = "auditorName")
    @FieldRemark(column="AUDITOR_NAME", field="auditorName", name="审核员;主审填写")
    private java.lang.String auditorName;

    /**
    * 主审ID
    */
    @ExcelProperty("主审ID")
    @Size(max = 64, message = "主审ID长度不能超过64个字符")
    @ApiModelProperty(value = "主审ID", name = "chiefAuditorId")
    @FieldRemark(column="CHIEF_AUDITOR_ID", field="chiefAuditorId", name="主审ID")
    private java.lang.String chiefAuditorId;

    /**
    * 主审CODE
    */
    @ExcelProperty("主审CODE")
    @Size(max = 10, message = "主审CODE长度不能超过10个字符")
    @ApiModelProperty(value = "主审CODE", name = "chiefAuditorCode")
    @FieldRemark(column="CHIEF_AUDITOR_CODE", field="chiefAuditorCode", name="主审CODE")
    private java.lang.String chiefAuditorCode;

    /**
    * 主审
    */
    @ExcelProperty("主审")
    @Size(max = 50, message = "主审长度不能超过50个字符")
    @ApiModelProperty(value = "主审", name = "chiefAuditorName")
    @FieldRemark(column="CHIEF_AUDITOR_NAME", field="chiefAuditorName", name="主审")
    private java.lang.String chiefAuditorName;

    /**
    * 审核评价主管ID
    */
    @ExcelProperty("审核评价主管ID")
    @Size(max = 64, message = "审核评价主管ID长度不能超过64个字符")
    @ApiModelProperty(value = "审核评价主管ID", name = "evaluationSupervisorId")
    @FieldRemark(column="EVALUATION_SUPERVISOR_ID", field="evaluationSupervisorId", name="审核评价主管ID")
    private java.lang.String evaluationSupervisorId;

    /**
    * 审核评价主管CODE
    */
    @ExcelProperty("审核评价主管CODE")
    @Size(max = 10, message = "审核评价主管CODE长度不能超过10个字符")
    @ApiModelProperty(value = "审核评价主管CODE", name = "evaluationSupervisorCode")
    @FieldRemark(column="EVALUATION_SUPERVISOR_CODE", field="evaluationSupervisorCode", name="审核评价主管CODE")
    private java.lang.String evaluationSupervisorCode;

    /**
    * 审核评价主管NAME
    */
    @ExcelProperty("审核评价主管NAME")
    @Size(max = 50, message = "审核评价主管NAME长度不能超过50个字符")
    @ApiModelProperty(value = "审核评价主管NAME", name = "evaluationSupervisorName")
    @FieldRemark(column="EVALUATION_SUPERVISOR_NAME", field="evaluationSupervisorName", name="审核评价主管NAME")
    private java.lang.String evaluationSupervisorName;

    /**
    * 审核组长ID
    */
    @ExcelProperty("审核组长ID")
    @Size(max = 64, message = "审核组长ID长度不能超过64个字符")
    @ApiModelProperty(value = "审核组长ID", name = "auditLeaderId")
    @FieldRemark(column="AUDIT_LEADER_ID", field="auditLeaderId", name="审核组长ID")
    private java.lang.String auditLeaderId;

    /**
    * 审核组长CODE
    */
    @ExcelProperty("审核组长CODE")
    @Size(max = 10, message = "审核组长CODE长度不能超过10个字符")
    @ApiModelProperty(value = "审核组长CODE", name = "auditLeaderCode")
    @FieldRemark(column="AUDIT_LEADER_CODE", field="auditLeaderCode", name="审核组长CODE")
    private java.lang.String auditLeaderCode;

    /**
    * 审核组长
    */
    @ExcelProperty("审核组长")
    @Size(max = 50, message = "审核组长长度不能超过50个字符")
    @ApiModelProperty(value = "审核组长", name = "auditLeaderName")
    @FieldRemark(column="AUDIT_LEADER_NAME", field="auditLeaderName", name="审核组长")
    private java.lang.String auditLeaderName;

    /**
    * 受审方人员ID
    */
    @ExcelProperty("受审方人员ID")
    @Size(max = 512, message = "受审方人员ID长度不能超过512个字符")
    @ApiModelProperty(value = "受审方人员ID", name = "auditeeUserId")
    @FieldRemark(column="AUDITEE_USER_ID", field="auditeeUserId", name="受审方人员ID")
    private java.lang.String auditeeUserId;

    /**
    * 受审方人员CODE
    */
    @ExcelProperty("受审方人员CODE")
    @Size(max = 200, message = "受审方人员CODE长度不能超过200个字符")
    @ApiModelProperty(value = "受审方人员CODE", name = "auditeeUserCode")
    @FieldRemark(column="AUDITEE_USER_CODE", field="auditeeUserCode", name="受审方人员CODE")
    private java.lang.String auditeeUserCode;

    /**
    * 受审方人员
    */
    @ExcelProperty("受审方人员")
    @Size(max = 200, message = "受审方人员长度不能超过200个字符")
    @ApiModelProperty(value = "受审方人员", name = "auditeeUserName")
    @FieldRemark(column="AUDITEE_USER_NAME", field="auditeeUserName", name="受审方人员")
    private java.lang.String auditeeUserName;

    /**
    * 业务状态
    */
    @ExcelProperty("业务状态")
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
    private java.lang.String status;

    /**
    * 流程实例ID
    */
    @ExcelProperty("流程实例ID")
    @Size(max = 64, message = "流程实例ID长度不能超过64个字符")
    @ApiModelProperty(value = "流程实例ID", name = "processInstanceId")
    @FieldRemark(column="PROCESS_INSTANCE_ID", field="processInstanceId", name="流程实例ID")
    private java.lang.String processInstanceId;

    /**
    * 流程状态
    */
    @ExcelProperty("流程状态")
    @Size(max = 10, message = "流程状态长度不能超过10个字符")
    @ApiModelProperty(value = "流程状态", name = "processStatus")
    @FieldRemark(column="PROCESS_STATUS", field="processStatus", name="流程状态")
    private java.lang.String processStatus;

    /**
    * 创建时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date creationDateBegin;

    /**
    * 创建时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date creationDateEnd;

    /**
    * 最后修改时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date lastUpdateDateBegin;

    /**
    * 最后修改时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date lastUpdateDateEnd;

    /**
    * 密级
    */
    @FieldRemark(column="SECRET_LEVEL", field="secretLevel", name="密级", dataType="lookup", lookupType="PLATFORM_FILE_SECRET_LEVEL")
    private java.lang.String secretLevel;
    @ExcelProperty("密级")
    private java.lang.String secretLevelName;

    /**
    * 是否已删除
    */
    @ExcelProperty("是否已删除")
    @Size(max = 2, message = "是否已删除长度不能超过2个字符")
    @ApiModelProperty(value = "是否已删除", name = "ynDeleted")
    @FieldRemark(column="YN_DELETED", field="ynDeleted", name="是否已删除")
    private java.lang.String ynDeleted;

    /**
    * 备注
    */
    @ExcelProperty("备注")
    @Size(max = 2000, message = "备注长度不能超过2000个字符")
    @ApiModelProperty(value = "备注", name = "remark")
    @FieldRemark(column="REMARK", field="remark", name="备注")
    private java.lang.String remark;
    /**
    * 排序
    */
    @ExcelProperty("排序")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 0, message = "排序格式不正确")
    @ApiModelProperty(value = "排序", name = "orderBy")
    @FieldRemark(column="ORDER_BY", field="orderBy", name="排序")
    private java.math.BigDecimal orderBy;

    /**
    * 扩展字段_01
    */
    @Size(max = 512, message = "扩展字段_01长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_01", name = "attribute01")
    @FieldRemark(column="ATTRIBUTE_01", field="attribute01", name="扩展字段_01")
    private java.lang.String attribute01;

    /**
    * 扩展字段_02
    */
    @Size(max = 512, message = "扩展字段_02长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_02", name = "attribute02")
    @FieldRemark(column="ATTRIBUTE_02", field="attribute02", name="扩展字段_02")
    private java.lang.String attribute02;

    /**
    * 扩展字段_03
    */
    @Size(max = 512, message = "扩展字段_03长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_03", name = "attribute03")
    @FieldRemark(column="ATTRIBUTE_03", field="attribute03", name="扩展字段_03")
    private java.lang.String attribute03;

    /**
    * 扩展字段_04
    */
    @Size(max = 512, message = "扩展字段_04长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_04", name = "attribute04")
    @FieldRemark(column="ATTRIBUTE_04", field="attribute04", name="扩展字段_04")
    private java.lang.String attribute04;

    /**
    * 扩展字段_05
    */
    @Size(max = 512, message = "扩展字段_05长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_05", name = "attribute05")
    @FieldRemark(column="ATTRIBUTE_05", field="attribute05", name="扩展字段_05")
    private java.lang.String attribute05;

    /**
    * 扩展字段_06
    */
    @Size(max = 512, message = "扩展字段_06长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_06", name = "attribute06")
    @FieldRemark(column="ATTRIBUTE_06", field="attribute06", name="扩展字段_06")
    private java.lang.String attribute06;

    /**
    * 扩展字段_07
    */
    @Size(max = 512, message = "扩展字段_07长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_07", name = "attribute07")
    @FieldRemark(column="ATTRIBUTE_07", field="attribute07", name="扩展字段_07")
    private java.lang.String attribute07;

    /**
    * 扩展字段_08
    */
    @Size(max = 512, message = "扩展字段_08长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_08", name = "attribute08")
    @FieldRemark(column="ATTRIBUTE_08", field="attribute08", name="扩展字段_08")
    private java.lang.String attribute08;

    /**
    * 扩展字段_09
    */
    @Size(max = 512, message = "扩展字段_09长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_09", name = "attribute09")
    @FieldRemark(column="ATTRIBUTE_09", field="attribute09", name="扩展字段_09")
    private java.lang.String attribute09;

    /**
    * 扩展字段_10
    */
    @Size(max = 512, message = "扩展字段_10长度不能超过512个字符")
    @ApiModelProperty(value = "扩展字段_10", name = "attribute10")
    @FieldRemark(column="ATTRIBUTE_10", field="attribute10", name="扩展字段_10")
    private java.lang.String attribute10;

    /**
    * 父节点ID
    */
    @ExcelProperty("父节点ID")
    @Size(max = 64, message = "父节点ID长度不能超过64个字符")
    @ApiModelProperty(value = "父节点ID", name = "parentId")
    @FieldRemark(column="PARENT_ID", field="parentId", name="父节点ID")
    private java.lang.String parentId;

    /**
    * 全路径
    */
    @Size(max = 1000, message = "全路径长度不能超过1000个字符")
    @ApiModelProperty(value = "全路径", name = "treePath")
    @FieldRemark(column="TREE_PATH", field="treePath", name="全路径")
    private java.lang.String treePath;
    /**
    * 节点层级
    */
    @Digits(integer = 16, fraction = 0, message = "节点层级格式不正确")
    @ApiModelProperty(value = "节点层级", name = "treeLevel")
    @FieldRemark(column="TREE_LEVEL", field="treeLevel", name="节点层级")
    private java.math.BigDecimal treeLevel;
    /**
    * 本级排序
    */
    @NotNull(message = "本级排序不能为空")
    @Digits(integer = 16, fraction = 0, message = "本级排序格式不正确")
    @ApiModelProperty(value = "本级排序", name = "treeSort")
    @FieldRemark(column="TREE_SORT", field="treeSort", name="本级排序")
    private java.math.BigDecimal treeSort;

    /**
    * 全级排序
    */
    @Size(max = 1000, message = "全级排序长度不能超过1000个字符")
    @ApiModelProperty(value = "全级排序", name = "treeSorts")
    @FieldRemark(column="TREE_SORTS", field="treeSorts", name="全级排序")
    private java.lang.String treeSorts;

    /**
    * 是否叶子节点
    */
    @Size(max = 2, message = "是否叶子节点长度不能超过2个字符")
    @ApiModelProperty(value = "是否叶子节点", name = "treeLeaf")
    @FieldRemark(column="TREE_LEAF", field="treeLeaf", name="是否叶子节点")
    private java.lang.String treeLeaf;
    private String dbid_; // 流程实例ID
    @ExcelProperty("流程当前步骤")
    private String activityalias_; // 节点中文名称
    private String activityname_; // 当前节点id
    @ExcelProperty("流程状态")
    private String businessstate_; // 流程当前状态
    private String currUserId; // 当前登录人ID
    private String bpmType;
    private String bpmState;
    @ExcelProperty("当前处理人")
    private String assigneenames_;

    public java.lang.String getId(){
        return id;
    }

    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getPlanId(){
        return planId;
    }

    public void setPlanId(java.lang.String planId){
        this.planId = planId;
    }

    public java.lang.String getNoticeCode(){
        return noticeCode;
    }

    public void setNoticeCode(java.lang.String noticeCode){
        this.noticeCode = noticeCode;
    }

    public java.lang.String getNoticeName(){
        return noticeName;
    }

    public void setNoticeName(java.lang.String noticeName){
        this.noticeName = noticeName;
    }

    public java.lang.String getAuditPurpose(){
        return auditPurpose;
    }

    public void setAuditPurpose(java.lang.String auditPurpose){
        this.auditPurpose = auditPurpose;
    }

    public java.lang.String getAuditBasis(){
        return auditBasis;
    }

    public void setAuditBasis(java.lang.String auditBasis){
        this.auditBasis = auditBasis;
    }

    public java.lang.String getAuditClause(){
        return auditClause;
    }

    public void setAuditClause(java.lang.String auditClause){
        this.auditClause = auditClause;
    }

    public java.lang.String getModelProject(){
        return modelProject;
    }

    public void setModelProject(java.lang.String modelProject){
        this.modelProject = modelProject;
    }

    public java.lang.String getAuditScope(){
        return auditScope;
    }

    public void setAuditScope(java.lang.String auditScope){
        this.auditScope = auditScope;
    }

    public java.lang.String getCoveredProduct(){
        return coveredProduct;
    }

    public void setCoveredProduct(java.lang.String coveredProduct){
        this.coveredProduct = coveredProduct;
    }

    public java.util.Date getAuditTime(){
        return auditTime;
    }

    public void setAuditTime(java.util.Date auditTime){
        this.auditTime = auditTime;
        super.handleNullValue();
    }

    public java.util.Date getAuditTimeBegin(){
        return auditTimeBegin;
    }

    public void setAuditTimeBegin(java.util.Date auditTimeBegin){
        this.auditTimeBegin = auditTimeBegin;
    }

    public java.util.Date getAuditTimeEnd(){
        return auditTimeEnd;
    }

    public void setAuditTimeEnd(java.util.Date auditTimeEnd){
        this.auditTimeEnd = auditTimeEnd;
    }

    public java.math.BigDecimal getDurationDays(){
        return durationDays;
    }

    public void setDurationDays(java.math.BigDecimal durationDays){
        this.durationDays = durationDays;
        super.handleNullValue();
    }

    public java.lang.String getAuditeeDeptId(){
        return auditeeDeptId;
    }

    public void setAuditeeDeptId(java.lang.String auditeeDeptId){
        this.auditeeDeptId = auditeeDeptId;
    }

    public java.lang.String getAuditeeDeptCode(){
        return auditeeDeptCode;
    }

    public void setAuditeeDeptCode(java.lang.String auditeeDeptCode){
        this.auditeeDeptCode = auditeeDeptCode;
    }

    public java.lang.String getAuditeeDeptName(){
        return auditeeDeptName;
    }

    public void setAuditeeDeptName(java.lang.String auditeeDeptName){
        this.auditeeDeptName = auditeeDeptName;
    }

    public java.lang.String getAuditeeLeaderId(){
        return auditeeLeaderId;
    }

    public void setAuditeeLeaderId(java.lang.String auditeeLeaderId){
        this.auditeeLeaderId = auditeeLeaderId;
    }

    public java.lang.String getAuditeeLeaderCode(){
        return auditeeLeaderCode;
    }

    public void setAuditeeLeaderCode(java.lang.String auditeeLeaderCode){
        this.auditeeLeaderCode = auditeeLeaderCode;
    }

    public java.lang.String getAuditeeLeaderName(){
        return auditeeLeaderName;
    }

    public void setAuditeeLeaderName(java.lang.String auditeeLeaderName){
        this.auditeeLeaderName = auditeeLeaderName;
    }

    public java.lang.String getAuditorId(){
        return auditorId;
    }

    public void setAuditorId(java.lang.String auditorId){
        this.auditorId = auditorId;
    }

    public java.lang.String getAuditorCode(){
        return auditorCode;
    }

    public void setAuditorCode(java.lang.String auditorCode){
        this.auditorCode = auditorCode;
    }

    public java.lang.String getAuditorName(){
        return auditorName;
    }

    public void setAuditorName(java.lang.String auditorName){
        this.auditorName = auditorName;
    }

    public java.lang.String getChiefAuditorId(){
        return chiefAuditorId;
    }

    public void setChiefAuditorId(java.lang.String chiefAuditorId){
        this.chiefAuditorId = chiefAuditorId;
    }

    public java.lang.String getChiefAuditorCode(){
        return chiefAuditorCode;
    }

    public void setChiefAuditorCode(java.lang.String chiefAuditorCode){
        this.chiefAuditorCode = chiefAuditorCode;
    }

    public java.lang.String getChiefAuditorName(){
        return chiefAuditorName;
    }

    public void setChiefAuditorName(java.lang.String chiefAuditorName){
        this.chiefAuditorName = chiefAuditorName;
    }

    public java.lang.String getEvaluationSupervisorId(){
        return evaluationSupervisorId;
    }

    public void setEvaluationSupervisorId(java.lang.String evaluationSupervisorId){
        this.evaluationSupervisorId = evaluationSupervisorId;
    }

    public java.lang.String getEvaluationSupervisorCode(){
        return evaluationSupervisorCode;
    }

    public void setEvaluationSupervisorCode(java.lang.String evaluationSupervisorCode){
        this.evaluationSupervisorCode = evaluationSupervisorCode;
    }

    public java.lang.String getEvaluationSupervisorName(){
        return evaluationSupervisorName;
    }

    public void setEvaluationSupervisorName(java.lang.String evaluationSupervisorName){
        this.evaluationSupervisorName = evaluationSupervisorName;
    }

    public java.lang.String getAuditLeaderId(){
        return auditLeaderId;
    }

    public void setAuditLeaderId(java.lang.String auditLeaderId){
        this.auditLeaderId = auditLeaderId;
    }

    public java.lang.String getAuditLeaderCode(){
        return auditLeaderCode;
    }

    public void setAuditLeaderCode(java.lang.String auditLeaderCode){
        this.auditLeaderCode = auditLeaderCode;
    }

    public java.lang.String getAuditLeaderName(){
        return auditLeaderName;
    }

    public void setAuditLeaderName(java.lang.String auditLeaderName){
        this.auditLeaderName = auditLeaderName;
    }

    public java.lang.String getAuditeeUserId(){
        return auditeeUserId;
    }

    public void setAuditeeUserId(java.lang.String auditeeUserId){
        this.auditeeUserId = auditeeUserId;
    }

    public java.lang.String getAuditeeUserCode(){
        return auditeeUserCode;
    }

    public void setAuditeeUserCode(java.lang.String auditeeUserCode){
        this.auditeeUserCode = auditeeUserCode;
    }

    public java.lang.String getAuditeeUserName(){
        return auditeeUserName;
    }

    public void setAuditeeUserName(java.lang.String auditeeUserName){
        this.auditeeUserName = auditeeUserName;
    }

    public java.lang.String getStatus(){
        return status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getProcessInstanceId(){
        return processInstanceId;
    }

    public void setProcessInstanceId(java.lang.String processInstanceId){
        this.processInstanceId = processInstanceId;
    }

    public java.lang.String getProcessStatus(){
        return processStatus;
    }

    public void setProcessStatus(java.lang.String processStatus){
        this.processStatus = processStatus;
    }

    public java.util.Date getCreationDateBegin(){
        return creationDateBegin;
    }

    public void setCreationDateBegin(java.util.Date creationDateBegin){
        this.creationDateBegin = creationDateBegin;
    }

    public java.util.Date getCreationDateEnd(){
        return creationDateEnd;
    }

    public void setCreationDateEnd(java.util.Date creationDateEnd){
        this.creationDateEnd = creationDateEnd;
    }

    public java.util.Date getLastUpdateDateBegin(){
        return lastUpdateDateBegin;
    }

    public void setLastUpdateDateBegin(java.util.Date lastUpdateDateBegin){
        this.lastUpdateDateBegin = lastUpdateDateBegin;
    }

    public java.util.Date getLastUpdateDateEnd(){
        return lastUpdateDateEnd;
    }

    public void setLastUpdateDateEnd(java.util.Date lastUpdateDateEnd){
        this.lastUpdateDateEnd = lastUpdateDateEnd;
    }
    public java.lang.String getSecretLevel(){
        return secretLevel;
    }

    public void setSecretLevel(java.lang.String secretLevel){
        this.secretLevel = secretLevel;
    }

    public java.lang.String getSecretLevelName(){
        return secretLevelName;
    }

    public void setSecretLevelName(java.lang.String secretLevelName){
        this.secretLevelName = secretLevelName;
    }

    public java.lang.String getYnDeleted(){
        return ynDeleted;
    }

    public void setYnDeleted(java.lang.String ynDeleted){
        this.ynDeleted = ynDeleted;
    }

    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }

    public java.math.BigDecimal getOrderBy(){
        return orderBy;
    }

    public void setOrderBy(java.math.BigDecimal orderBy){
        this.orderBy = orderBy;
        super.handleNullValue();
    }

    public java.lang.String getAttribute01(){
        return attribute01;
    }

    public void setAttribute01(java.lang.String attribute01){
        this.attribute01 = attribute01;
    }

    public java.lang.String getAttribute02(){
        return attribute02;
    }

    public void setAttribute02(java.lang.String attribute02){
        this.attribute02 = attribute02;
    }

    public java.lang.String getAttribute03(){
        return attribute03;
    }

    public void setAttribute03(java.lang.String attribute03){
        this.attribute03 = attribute03;
    }

    public java.lang.String getAttribute04(){
        return attribute04;
    }

    public void setAttribute04(java.lang.String attribute04){
        this.attribute04 = attribute04;
    }

    public java.lang.String getAttribute05(){
        return attribute05;
    }

    public void setAttribute05(java.lang.String attribute05){
        this.attribute05 = attribute05;
    }

    public java.lang.String getAttribute06(){
        return attribute06;
    }

    public void setAttribute06(java.lang.String attribute06){
        this.attribute06 = attribute06;
    }

    public java.lang.String getAttribute07(){
        return attribute07;
    }

    public void setAttribute07(java.lang.String attribute07){
        this.attribute07 = attribute07;
    }

    public java.lang.String getAttribute08(){
        return attribute08;
    }

    public void setAttribute08(java.lang.String attribute08){
        this.attribute08 = attribute08;
    }

    public java.lang.String getAttribute09(){
        return attribute09;
    }

    public void setAttribute09(java.lang.String attribute09){
        this.attribute09 = attribute09;
    }

    public java.lang.String getAttribute10(){
        return attribute10;
    }

    public void setAttribute10(java.lang.String attribute10){
        this.attribute10 = attribute10;
    }

    public java.lang.String getParentId(){
        return parentId;
    }

    public void setParentId(java.lang.String parentId){
        this.parentId = parentId;
    }

    public java.lang.String getTreePath(){
        return treePath;
    }

    public void setTreePath(java.lang.String treePath){
        this.treePath = treePath;
    }

    public java.math.BigDecimal getTreeLevel(){
        return treeLevel;
    }

    public void setTreeLevel(java.math.BigDecimal treeLevel){
        this.treeLevel = treeLevel;
        super.handleNullValue();
    }

    public java.math.BigDecimal getTreeSort(){
        return treeSort;
    }

    public void setTreeSort(java.math.BigDecimal treeSort){
        this.treeSort = treeSort;
        super.handleNullValue();
    }

    public java.lang.String getTreeSorts(){
        return treeSorts;
    }

    public void setTreeSorts(java.lang.String treeSorts){
        this.treeSorts = treeSorts;
    }

    public java.lang.String getTreeLeaf(){
        return treeLeaf;
    }

    public void setTreeLeaf(java.lang.String treeLeaf){
        this.treeLeaf = treeLeaf;
    }

    public String getDbid_() {
        return dbid_;
    }

    public void setDbid_(String dbid_) {
        this.dbid_ = dbid_;
    }

    public String getActivityalias_() {
        return activityalias_;
    }

    public void setActivityalias_(String activityalias_) {
        this.activityalias_ = activityalias_;
    }

    public String getActivityname_() {
        return activityname_;
    }

    public void setActivityname_(String activityname_) {
        this.activityname_ = activityname_;
    }

    public String getBusinessstate_() {
        return businessstate_;
    }

    public void setBusinessstate_(String businessstate_) {
        this.businessstate_ = businessstate_;
    }

    public String getCurrUserId() {
        return currUserId;
    }

    public void setCurrUserId(String currUserId) {
        this.currUserId = currUserId;
    }

    public String getBpmType() {
        return bpmType;
    }

    public void setBpmType(String bpmType) {
        this.bpmType = bpmType;
    }

    public String getBpmState() {
        return bpmState;
    }

    public void setBpmState(String bpmState) {
        this.bpmState = bpmState;
    }
    public String getAssigneenames_() {
        return assigneenames_;
    }

    public void setAssigneenames_(String assigneenames_) {
        this.assigneenames_ = assigneenames_;
    }

    @Override
    public String getLogFormName() {
        if (StringUtils.isEmpty(super.logFormName)) {
            return "内审通知单";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "内审通知单";
        } else {
            return super.logTitle;
        }
    }

    @Override
    public PlatformConstant.LogType getLogType() {
        if (super.logType == null) {
            return PlatformConstant.LogType.module_operate;
        } else {
            return super.logType;
        }
    }
}
