package avicit.myportal.qms.qmsncproduct.dto;

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
* @创建时间： 2026-08-04 15:06
* @类说明：QMS_NC_PRODUCTDTO
* @修改记录：
*/
@ApiModel(value = "QmsNcProductDTO", description = "QMS_NC_PRODUCT")
@PojoRemark(table="QMS_NC_PRODUCT", object="QmsNcProductDTO", name="QMS_NC_PRODUCT")
@ExcelIgnoreUnannotated
public class QmsNcProductDTO extends BeanDTO{
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
    * 审理单编号
    */
    @ExcelProperty("审理单编号")
    @Size(max = 256, message = "审理单编号长度不能超过256个字符")
    @ApiModelProperty(value = "审理单编号", name = "reviewCode")
    @FieldRemark(column="REVIEW_CODE", field="reviewCode", name="审理单编号")
    private java.lang.String reviewCode;

    /**
    * 审理单密级
    */
    @ExcelProperty("审理单密级")
    @Size(max = 10, message = "审理单密级长度不能超过10个字符")
    @ApiModelProperty(value = "审理单密级", name = "reviewSecretLevel")
    @FieldRemark(column="REVIEW_SECRET_LEVEL", field="reviewSecretLevel", name="审理单密级")
    private java.lang.String reviewSecretLevel;
    /**
    * 日期
    */
    @ExcelProperty("日期")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "日期", name = "reportTime")
    @FieldRemark(column="REPORT_TIME", field="reportTime", name="日期")
    private java.util.Date reportTime;

    /**
    * 日期起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date reportTimeBegin;

    /**
    * 日期止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date reportTimeEnd;

    /**
    * 型号
    */
    @ExcelProperty("型号")
    @Size(max = 128, message = "型号长度不能超过128个字符")
    @ApiModelProperty(value = "型号", name = "model")
    @FieldRemark(column="MODEL", field="model", name="型号")
    private java.lang.String model;

    /**
    * 零件名称
    */
    @ExcelProperty("零件名称")
    @Size(max = 128, message = "零件名称长度不能超过128个字符")
    @ApiModelProperty(value = "零件名称", name = "partName")
    @FieldRemark(column="PART_NAME", field="partName", name="零件名称")
    private java.lang.String partName;

    /**
    * 零件图号
    */
    @ExcelProperty("零件图号")
    @Size(max = 128, message = "零件图号长度不能超过128个字符")
    @ApiModelProperty(value = "零件图号", name = "partDrawingNo")
    @FieldRemark(column="PART_DRAWING_NO", field="partDrawingNo", name="零件图号")
    private java.lang.String partDrawingNo;

    /**
    * 组件名称
    */
    @ExcelProperty("组件名称")
    @Size(max = 128, message = "组件名称长度不能超过128个字符")
    @ApiModelProperty(value = "组件名称", name = "assemblyName")
    @FieldRemark(column="ASSEMBLY_NAME", field="assemblyName", name="组件名称")
    private java.lang.String assemblyName;

    /**
    * 组件图号
    */
    @ExcelProperty("组件图号")
    @Size(max = 128, message = "组件图号长度不能超过128个字符")
    @ApiModelProperty(value = "组件图号", name = "assemblyDrawingNo")
    @FieldRemark(column="ASSEMBLY_DRAWING_NO", field="assemblyDrawingNo", name="组件图号")
    private java.lang.String assemblyDrawingNo;

    /**
    * 流水卡号
    */
    @ExcelProperty("流水卡号")
    @Size(max = 128, message = "流水卡号长度不能超过128个字符")
    @ApiModelProperty(value = "流水卡号", name = "routingCardNo")
    @FieldRemark(column="ROUTING_CARD_NO", field="routingCardNo", name="流水卡号")
    private java.lang.String routingCardNo;

    /**
    * 批次号
    */
    @ExcelProperty("批次号")
    @Size(max = 128, message = "批次号长度不能超过128个字符")
    @ApiModelProperty(value = "批次号", name = "batchNo")
    @FieldRemark(column="BATCH_NO", field="batchNo", name="批次号")
    private java.lang.String batchNo;

    /**
    * 零组件序号
    */
    @ExcelProperty("零组件序号")
    @Size(max = 128, message = "零组件序号长度不能超过128个字符")
    @ApiModelProperty(value = "零组件序号", name = "componentSerialNo")
    @FieldRemark(column="COMPONENT_SERIAL_NO", field="componentSerialNo", name="零组件序号")
    private java.lang.String componentSerialNo;

    /**
    * 工序号
    */
    @ExcelProperty("工序号")
    @Size(max = 128, message = "工序号长度不能超过128个字符")
    @ApiModelProperty(value = "工序号", name = "processNo")
    @FieldRemark(column="PROCESS_NO", field="processNo", name="工序号")
    private java.lang.String processNo;

    /**
    * 炉批号
    */
    @ExcelProperty("炉批号")
    @Size(max = 128, message = "炉批号长度不能超过128个字符")
    @ApiModelProperty(value = "炉批号", name = "heatBatchNo")
    @FieldRemark(column="HEAT_BATCH_NO", field="heatBatchNo", name="炉批号")
    private java.lang.String heatBatchNo;

    /**
    * 类别
    */
    @ExcelProperty("类别")
    @Size(max = 10, message = "类别长度不能超过10个字符")
    @ApiModelProperty(value = "类别", name = "ncCategory")
    @FieldRemark(column="NC_CATEGORY", field="ncCategory", name="类别")
    private java.lang.String ncCategory;
    /**
    * 数量
    */
    @ExcelProperty("数量")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 16, fraction = 2, message = "数量格式不正确")
    @ApiModelProperty(value = "数量", name = "quantity")
    @FieldRemark(column="QUANTITY", field="quantity", name="数量")
    private java.math.BigDecimal quantity;
    /**
    * 总页数
    */
    @ExcelProperty("总页数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 10, fraction = 0, message = "总页数格式不正确")
    @ApiModelProperty(value = "总页数", name = "totalPageCount")
    @FieldRemark(column="TOTAL_PAGE_COUNT", field="totalPageCount", name="总页数")
    private java.math.BigDecimal totalPageCount;
    /**
    * 问题页数
    */
    @ExcelProperty("问题页数")
    @ColumnWidth(15)
    @NumberFormat("0.00")
    @Digits(integer = 10, fraction = 0, message = "问题页数格式不正确")
    @ApiModelProperty(value = "问题页数", name = "issuePageCount")
    @FieldRemark(column="ISSUE_PAGE_COUNT", field="issuePageCount", name="问题页数")
    private java.math.BigDecimal issuePageCount;

    /**
    * 图纸及技术条件要求;图纸、文件中的具体要求，如要求XX尺寸/间隙不大于XXXX
    */
    @ExcelProperty("图纸及技术条件要求;图纸、文件中的具体要求，如要求XX尺寸/间隙不大于XXXX")
    @Size(max = 512, message = "图纸及技术条件要求;图纸、文件中的具体要求，如要求XX尺寸/间隙不大于XXXX长度不能超过512个字符")
    @ApiModelProperty(value = "图纸及技术条件要求;图纸、文件中的具体要求，如要求XX尺寸/间隙不大于XXXX", name = "techSpecReq")
    @FieldRemark(column="TECH_SPEC_REQ", field="techSpecReq", name="图纸及技术条件要求;图纸、文件中的具体要求，如要求XX尺寸/间隙不大于XXXX")
    private java.lang.String techSpecReq;

    /**
    * 不合格情况描述;准确描述不合格特性，如实测XX尺寸/间隙不大于XXXX）（可附页）
    */
    @ExcelProperty("不合格情况描述;准确描述不合格特性，如实测XX尺寸/间隙不大于XXXX）（可附页）")
    @Size(max = 512, message = "不合格情况描述;准确描述不合格特性，如实测XX尺寸/间隙不大于XXXX）（可附页）长度不能超过512个字符")
    @ApiModelProperty(value = "不合格情况描述;准确描述不合格特性，如实测XX尺寸/间隙不大于XXXX）（可附页）", name = "ncDescreption")
    @FieldRemark(column="NC_DESCREPTION", field="ncDescreption", name="不合格情况描述;准确描述不合格特性，如实测XX尺寸/间隙不大于XXXX）（可附页）")
    private java.lang.String ncDescreption;
    /**
    * 检验员ID
    */
    @Size(max = 64, message = "检验员ID长度不能超过64个字符")
    @ApiModelProperty(value = "检验员ID", name = "inspectorId")
    @FieldRemark(column="INSPECTOR_ID", field="inspectorId", name="检验员ID", dataType="user")
    private java.lang.String inspectorId;

    /**
    * 检验员ID显示字段
    */
    @ExcelProperty("检验员ID")
    private java.lang.String inspectorIdAlias;

    /**
    * 检验员CODE
    */
    @ExcelProperty("检验员CODE")
    @Size(max = 10, message = "检验员CODE长度不能超过10个字符")
    @ApiModelProperty(value = "检验员CODE", name = "inspectorCode")
    @FieldRemark(column="INSPECTOR_CODE", field="inspectorCode", name="检验员CODE")
    private java.lang.String inspectorCode;

    /**
    * 检验员NAME
    */
    @ExcelProperty("检验员NAME")
    @Size(max = 20, message = "检验员NAME长度不能超过20个字符")
    @ApiModelProperty(value = "检验员NAME", name = "inspectorName")
    @FieldRemark(column="INSPECTOR_NAME", field="inspectorName", name="检验员NAME")
    private java.lang.String inspectorName;
    /**
    * 检验中心领导
    */
    @Size(max = 64, message = "检验中心领导长度不能超过64个字符")
    @ApiModelProperty(value = "检验中心领导", name = "inspectionDeptLeaderId")
    @FieldRemark(column="INSPECTION_DEPT_LEADER_ID", field="inspectionDeptLeaderId", name="检验中心领导", dataType="user")
    private java.lang.String inspectionDeptLeaderId;

    /**
    * 检验中心领导显示字段
    */
    @ExcelProperty("检验中心领导")
    private java.lang.String inspectionDeptLeaderIdAlias;

    /**
    * 检验中心领导CODE
    */
    @ExcelProperty("检验中心领导CODE")
    @Size(max = 10, message = "检验中心领导CODE长度不能超过10个字符")
    @ApiModelProperty(value = "检验中心领导CODE", name = "inspectionDeptLeaderCode")
    @FieldRemark(column="INSPECTION_DEPT_LEADER_CODE", field="inspectionDeptLeaderCode", name="检验中心领导CODE")
    private java.lang.String inspectionDeptLeaderCode;

    /**
    * 检验中心领导姓名
    */
    @ExcelProperty("检验中心领导姓名")
    @Size(max = 20, message = "检验中心领导姓名长度不能超过20个字符")
    @ApiModelProperty(value = "检验中心领导姓名", name = "inspectionDeptLeaderName")
    @FieldRemark(column="INSPECTION_DEPT_LEADER_NAME", field="inspectionDeptLeaderName", name="检验中心领导姓名")
    private java.lang.String inspectionDeptLeaderName;

    /**
    * 不合格原因分类;人、机、料、法、环、测、设计、其他
    */
    @ExcelProperty("不合格原因分类;人、机、料、法、环、测、设计、其他")
    @Size(max = 10, message = "不合格原因分类;人、机、料、法、环、测、设计、其他长度不能超过10个字符")
    @ApiModelProperty(value = "不合格原因分类;人、机、料、法、环、测、设计、其他", name = "causeCategory")
    @FieldRemark(column="CAUSE_CATEGORY", field="causeCategory", name="不合格原因分类;人、机、料、法、环、测、设计、其他")
    private java.lang.String causeCategory;

    /**
    * 不合格产生原因;针对不合格特性，从人、机、料、法、环、测等方面明确不合格原因，并勾选原因分类
    */
    @ExcelProperty("不合格产生原因;针对不合格特性，从人、机、料、法、环、测等方面明确不合格原因，并勾选原因分类")
    @Size(max = 2000, message = "不合格产生原因;针对不合格特性，从人、机、料、法、环、测等方面明确不合格原因，并勾选原因分类长度不能超过2000个字符")
    @ApiModelProperty(value = "不合格产生原因;针对不合格特性，从人、机、料、法、环、测等方面明确不合格原因，并勾选原因分类", name = "causeAnalysis")
    @FieldRemark(column="CAUSE_ANALYSIS", field="causeAnalysis", name="不合格产生原因;针对不合格特性，从人、机、料、法、环、测等方面明确不合格原因，并勾选原因分类")
    private java.lang.String causeAnalysis;

    /**
    * 纠正措施;针对上述不合格品原因采取的系统性纠正措施，以避免后续不再因同类原因导致不合格，不能只是对单件不合格品的纠正
    */
    @ExcelProperty("纠正措施;针对上述不合格品原因采取的系统性纠正措施，以避免后续不再因同类原因导致不合格，不能只是对单件不合格品的纠正")
    @Size(max = 2000, message = "纠正措施;针对上述不合格品原因采取的系统性纠正措施，以避免后续不再因同类原因导致不合格，不能只是对单件不合格品的纠正长度不能超过2000个字符")
    @ApiModelProperty(value = "纠正措施;针对上述不合格品原因采取的系统性纠正措施，以避免后续不再因同类原因导致不合格，不能只是对单件不合格品的纠正", name = "correctiveMeasure")
    @FieldRemark(column="CORRECTIVE_MEASURE", field="correctiveMeasure", name="纠正措施;针对上述不合格品原因采取的系统性纠正措施，以避免后续不再因同类原因导致不合格，不能只是对单件不合格品的纠正")
    private java.lang.String correctiveMeasure;

    /**
    * 责任单位ID
    */
    @Size(max = 256, message = "责任单位ID长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位ID", name = "responsibleDeptId")
    @FieldRemark(column="RESPONSIBLE_DEPT_ID", field="responsibleDeptId", name="责任单位ID", dataType="dept")
    private java.lang.String responsibleDeptId;

    /**
    * 责任单位ID显示字段
    */
    @ExcelProperty("责任单位ID")
    private java.lang.String responsibleDeptIdAlias;

    /**
    * 责任单位CODE
    */
    @ExcelProperty("责任单位CODE")
    @Size(max = 256, message = "责任单位CODE长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位CODE", name = "responsibleDeptCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_CODE", field="responsibleDeptCode", name="责任单位CODE")
    private java.lang.String responsibleDeptCode;

    /**
    * 责任单位NAME
    */
    @ExcelProperty("责任单位NAME")
    @Size(max = 256, message = "责任单位NAME长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位NAME", name = "responsibleDeptName")
    @FieldRemark(column="RESPONSIBLE_DEPT_NAME", field="responsibleDeptName", name="责任单位NAME")
    private java.lang.String responsibleDeptName;
    /**
    * 责任单位领导
    */
    @Size(max = 256, message = "责任单位领导长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位领导", name = "responsibleDeptLeaderId")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_ID", field="responsibleDeptLeaderId", name="责任单位领导", dataType="user")
    private java.lang.String responsibleDeptLeaderId;

    /**
    * 责任单位领导显示字段
    */
    @ExcelProperty("责任单位领导")
    private java.lang.String responsibleDeptLeaderIdAlias;

    /**
    * 责任单位领导CODE
    */
    @ExcelProperty("责任单位领导CODE")
    @Size(max = 256, message = "责任单位领导CODE长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位领导CODE", name = "responsibleDeptLeaderCode")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_CODE", field="responsibleDeptLeaderCode", name="责任单位领导CODE")
    private java.lang.String responsibleDeptLeaderCode;

    /**
    * 责任单位领导NAME
    */
    @ExcelProperty("责任单位领导NAME")
    @Size(max = 256, message = "责任单位领导NAME长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位领导NAME", name = "responsibleDeptLeaderName")
    @FieldRemark(column="RESPONSIBLE_DEPT_LEADER_NAME", field="responsibleDeptLeaderName", name="责任单位领导NAME")
    private java.lang.String responsibleDeptLeaderName;
    /**
    * 责任单位主管
    */
    @Size(max = 256, message = "责任单位主管长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位主管", name = "responsibleSupervisorId")
    @FieldRemark(column="RESPONSIBLE_SUPERVISOR_ID", field="responsibleSupervisorId", name="责任单位主管", dataType="user")
    private java.lang.String responsibleSupervisorId;

    /**
    * 责任单位主管显示字段
    */
    @ExcelProperty("责任单位主管")
    private java.lang.String responsibleSupervisorIdAlias;

    /**
    * 责任单位主管CODE
    */
    @ExcelProperty("责任单位主管CODE")
    @Size(max = 256, message = "责任单位主管CODE长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位主管CODE", name = "responsibleSupervisorCode")
    @FieldRemark(column="RESPONSIBLE_SUPERVISOR_CODE", field="responsibleSupervisorCode", name="责任单位主管CODE")
    private java.lang.String responsibleSupervisorCode;

    /**
    * 责任单位主管NAME
    */
    @ExcelProperty("责任单位主管NAME")
    @Size(max = 256, message = "责任单位主管NAME长度不能超过256个字符")
    @ApiModelProperty(value = "责任单位主管NAME", name = "responsibleSupervisorName")
    @FieldRemark(column="RESPONSIBLE_SUPERVISOR_NAME", field="responsibleSupervisorName", name="责任单位主管NAME")
    private java.lang.String responsibleSupervisorName;
    /**
    * 责任人
    */
    @Size(max = 256, message = "责任人长度不能超过256个字符")
    @ApiModelProperty(value = "责任人", name = "responsibleUserId")
    @FieldRemark(column="RESPONSIBLE_USER_ID", field="responsibleUserId", name="责任人", dataType="user")
    private java.lang.String responsibleUserId;

    /**
    * 责任人显示字段
    */
    @ExcelProperty("责任人")
    private java.lang.String responsibleUserIdAlias;

    /**
    * 责任人CODE
    */
    @ExcelProperty("责任人CODE")
    @Size(max = 256, message = "责任人CODE长度不能超过256个字符")
    @ApiModelProperty(value = "责任人CODE", name = "responsibleUserCode")
    @FieldRemark(column="RESPONSIBLE_USER_CODE", field="responsibleUserCode", name="责任人CODE")
    private java.lang.String responsibleUserCode;

    /**
    * 责任人NAME
    */
    @ExcelProperty("责任人NAME")
    @Size(max = 256, message = "责任人NAME长度不能超过256个字符")
    @ApiModelProperty(value = "责任人NAME", name = "responsibleUserName")
    @FieldRemark(column="RESPONSIBLE_USER_NAME", field="responsibleUserName", name="责任人NAME")
    private java.lang.String responsibleUserName;

    /**
    * 影响分析
    */
    @ExcelProperty("影响分析")
    @Size(max = 2000, message = "影响分析长度不能超过2000个字符")
    @ApiModelProperty(value = "影响分析", name = "impactAnalysis")
    @FieldRemark(column="IMPACT_ANALYSIS", field="impactAnalysis", name="影响分析")
    private java.lang.String impactAnalysis;

    /**
    * 审理人员（小组）意见
    */
    @ExcelProperty("审理人员（小组）意见")
    @Size(max = 256, message = "审理人员（小组）意见长度不能超过256个字符")
    @ApiModelProperty(value = "审理人员（小组）意见", name = "groupReviewOpinion")
    @FieldRemark(column="GROUP_REVIEW_OPINION", field="groupReviewOpinion", name="审理人员（小组）意见")
    private java.lang.String groupReviewOpinion;

    /**
    * 建议处置方式;返工;返修;报废;让步接收; 降级使用;退回供方
    */
    @ExcelProperty("建议处置方式;返工;返修;报废;让步接收; 降级使用;退回供方")
    @Size(max = 50, message = "建议处置方式;返工;返修;报废;让步接收; 降级使用;退回供方长度不能超过50个字符")
    @ApiModelProperty(value = "建议处置方式;返工;返修;报废;让步接收; 降级使用;退回供方", name = "groupDesposition")
    @FieldRemark(column="GROUP_DESPOSITION", field="groupDesposition", name="建议处置方式;返工;返修;报废;让步接收; 降级使用;退回供方")
    private java.lang.String groupDesposition;

    /**
    * 处置说明
    */
    @ExcelProperty("处置说明")
    @Size(max = 2000, message = "处置说明长度不能超过2000个字符")
    @ApiModelProperty(value = "处置说明", name = "groupDespositionDesc")
    @FieldRemark(column="GROUP_DESPOSITION_DESC", field="groupDespositionDesc", name="处置说明")
    private java.lang.String groupDespositionDesc;

    /**
    * 审理单位ID
    */
    @Size(max = 512, message = "审理单位ID长度不能超过512个字符")
    @ApiModelProperty(value = "审理单位ID", name = "reviewDeptId")
    @FieldRemark(column="REVIEW_DEPT_ID", field="reviewDeptId", name="审理单位ID", dataType="dept")
    private java.lang.String reviewDeptId;

    /**
    * 审理单位ID显示字段
    */
    @ExcelProperty("审理单位ID")
    private java.lang.String reviewDeptIdAlias;

    /**
    * 审理单位CODE
    */
    @ExcelProperty("审理单位CODE")
    @Size(max = 50, message = "审理单位CODE长度不能超过50个字符")
    @ApiModelProperty(value = "审理单位CODE", name = "reviewDeptCode")
    @FieldRemark(column="REVIEW_DEPT_CODE", field="reviewDeptCode", name="审理单位CODE")
    private java.lang.String reviewDeptCode;

    /**
    * 审理单位
    */
    @ExcelProperty("审理单位")
    @Size(max = 256, message = "审理单位长度不能超过256个字符")
    @ApiModelProperty(value = "审理单位", name = "reviewDeptName")
    @FieldRemark(column="REVIEW_DEPT_NAME", field="reviewDeptName", name="审理单位")
    private java.lang.String reviewDeptName;
    /**
    * 审理人员ID
    */
    @Size(max = 512, message = "审理人员ID长度不能超过512个字符")
    @ApiModelProperty(value = "审理人员ID", name = "reviewUserId")
    @FieldRemark(column="REVIEW_USER_ID", field="reviewUserId", name="审理人员ID", dataType="user")
    private java.lang.String reviewUserId;

    /**
    * 审理人员ID显示字段
    */
    @ExcelProperty("审理人员ID")
    private java.lang.String reviewUserIdAlias;

    /**
    * 审理人员CODE
    */
    @ExcelProperty("审理人员CODE")
    @Size(max = 50, message = "审理人员CODE长度不能超过50个字符")
    @ApiModelProperty(value = "审理人员CODE", name = "reviewUserCode")
    @FieldRemark(column="REVIEW_USER_CODE", field="reviewUserCode", name="审理人员CODE")
    private java.lang.String reviewUserCode;

    /**
    * 小组审理人员
    */
    @ExcelProperty("小组审理人员")
    @Size(max = 128, message = "小组审理人员长度不能超过128个字符")
    @ApiModelProperty(value = "小组审理人员", name = "reviewUserName")
    @FieldRemark(column="REVIEW_USER_NAME", field="reviewUserName", name="小组审理人员")
    private java.lang.String reviewUserName;
    /**
    * 小组审理时间
    */
    @ExcelProperty("小组审理时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "小组审理时间", name = "reviewTime")
    @FieldRemark(column="REVIEW_TIME", field="reviewTime", name="小组审理时间")
    private java.util.Date reviewTime;

    /**
    * 小组审理时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date reviewTimeBegin;

    /**
    * 小组审理时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date reviewTimeEnd;

    /**
    * 是否提交委员会
    */
    @ExcelProperty("是否提交委员会")
    @Size(max = 2, message = "是否提交委员会长度不能超过2个字符")
    @ApiModelProperty(value = "是否提交委员会", name = "ynNeedCommitee")
    @FieldRemark(column="YN_NEED_COMMITEE", field="ynNeedCommitee", name="是否提交委员会")
    private java.lang.String ynNeedCommitee;

    /**
    * 审理委员会意见
    */
    @ExcelProperty("审理委员会意见")
    @Size(max = 512, message = "审理委员会意见长度不能超过512个字符")
    @ApiModelProperty(value = "审理委员会意见", name = "commiteeOpinion")
    @FieldRemark(column="COMMITEE_OPINION", field="commiteeOpinion", name="审理委员会意见")
    private java.lang.String commiteeOpinion;
    /**
    * 委员会审批人ID
    */
    @Size(max = 64, message = "委员会审批人ID长度不能超过64个字符")
    @ApiModelProperty(value = "委员会审批人ID", name = "commiteeMemberId")
    @FieldRemark(column="COMMITEE_MEMBER_ID", field="commiteeMemberId", name="委员会审批人ID", dataType="user")
    private java.lang.String commiteeMemberId;

    /**
    * 委员会审批人ID显示字段
    */
    @ExcelProperty("委员会审批人ID")
    private java.lang.String commiteeMemberIdAlias;

    /**
    * 委员会审批人USER
    */
    @ExcelProperty("委员会审批人USER")
    @Size(max = 10, message = "委员会审批人USER长度不能超过10个字符")
    @ApiModelProperty(value = "委员会审批人USER", name = "commiteeMemberCode")
    @FieldRemark(column="COMMITEE_MEMBER_CODE", field="commiteeMemberCode", name="委员会审批人USER")
    private java.lang.String commiteeMemberCode;

    /**
    * 委员会审批人姓名
    */
    @ExcelProperty("委员会审批人姓名")
    @Size(max = 20, message = "委员会审批人姓名长度不能超过20个字符")
    @ApiModelProperty(value = "委员会审批人姓名", name = "commiteeMemberName")
    @FieldRemark(column="COMMITEE_MEMBER_NAME", field="commiteeMemberName", name="委员会审批人姓名")
    private java.lang.String commiteeMemberName;
    /**
    * 委员会审批时间
    */
    @ExcelProperty("委员会审批时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "委员会审批时间", name = "commiteeApprovalTime")
    @FieldRemark(column="COMMITEE_APPROVAL_TIME", field="commiteeApprovalTime", name="委员会审批时间")
    private java.util.Date commiteeApprovalTime;

    /**
    * 委员会审批时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date commiteeApprovalTimeBegin;

    /**
    * 委员会审批时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date commiteeApprovalTimeEnd;

    /**
    * 质量部门意见
    */
    @ExcelProperty("质量部门意见")
    @Size(max = 512, message = "质量部门意见长度不能超过512个字符")
    @ApiModelProperty(value = "质量部门意见", name = "qualityDeptOpinion")
    @FieldRemark(column="QUALITY_DEPT_OPINION", field="qualityDeptOpinion", name="质量部门意见")
    private java.lang.String qualityDeptOpinion;
    /**
    * 质量部型号主管ID
    */
    @Size(max = 64, message = "质量部型号主管ID长度不能超过64个字符")
    @ApiModelProperty(value = "质量部型号主管ID", name = "modelQualitySupervisorId")
    @FieldRemark(column="MODEL_QUALITY_SUPERVISOR_ID", field="modelQualitySupervisorId", name="质量部型号主管ID", dataType="user")
    private java.lang.String modelQualitySupervisorId;

    /**
    * 质量部型号主管ID显示字段
    */
    @ExcelProperty("质量部型号主管ID")
    private java.lang.String modelQualitySupervisorIdAlias;

    /**
    * 质量部型号主管CODE
    */
    @ExcelProperty("质量部型号主管CODE")
    @Size(max = 10, message = "质量部型号主管CODE长度不能超过10个字符")
    @ApiModelProperty(value = "质量部型号主管CODE", name = "modelQualitySupervisorCode")
    @FieldRemark(column="MODEL_QUALITY_SUPERVISOR_CODE", field="modelQualitySupervisorCode", name="质量部型号主管CODE")
    private java.lang.String modelQualitySupervisorCode;

    /**
    * 质量部型号主管
    */
    @ExcelProperty("质量部型号主管")
    @Size(max = 20, message = "质量部型号主管长度不能超过20个字符")
    @ApiModelProperty(value = "质量部型号主管", name = "modelQualitySupervisorName")
    @FieldRemark(column="MODEL_QUALITY_SUPERVISOR_NAME", field="modelQualitySupervisorName", name="质量部型号主管")
    private java.lang.String modelQualitySupervisorName;
    /**
    * 质量部确认时间
    */
    @ExcelProperty("质量部确认时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "质量部确认时间", name = "qualityConfirmTime")
    @FieldRemark(column="QUALITY_CONFIRM_TIME", field="qualityConfirmTime", name="质量部确认时间")
    private java.util.Date qualityConfirmTime;

    /**
    * 质量部确认时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date qualityConfirmTimeBegin;

    /**
    * 质量部确认时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date qualityConfirmTimeEnd;

    /**
    * 是否需要军代表审批
    */
    @ExcelProperty("是否需要军代表审批")
    @Size(max = 2, message = "是否需要军代表审批长度不能超过2个字符")
    @ApiModelProperty(value = "是否需要军代表审批", name = "ynMilRep")
    @FieldRemark(column="YN_MIL_REP", field="ynMilRep", name="是否需要军代表审批")
    private java.lang.String ynMilRep;
    /**
    * 军代表ID
    */
    @Size(max = 64, message = "军代表ID长度不能超过64个字符")
    @ApiModelProperty(value = "军代表ID", name = "milRepId")
    @FieldRemark(column="MIL_REP_ID", field="milRepId", name="军代表ID", dataType="user")
    private java.lang.String milRepId;

    /**
    * 军代表ID显示字段
    */
    @ExcelProperty("军代表ID")
    private java.lang.String milRepIdAlias;

    /**
    * 军代表CODE
    */
    @ExcelProperty("军代表CODE")
    @Size(max = 10, message = "军代表CODE长度不能超过10个字符")
    @ApiModelProperty(value = "军代表CODE", name = "milRepCode")
    @FieldRemark(column="MIL_REP_CODE", field="milRepCode", name="军代表CODE")
    private java.lang.String milRepCode;

    /**
    * 军代表姓名
    */
    @ExcelProperty("军代表姓名")
    @Size(max = 20, message = "军代表姓名长度不能超过20个字符")
    @ApiModelProperty(value = "军代表姓名", name = "milRepName")
    @FieldRemark(column="MIL_REP_NAME", field="milRepName", name="军代表姓名")
    private java.lang.String milRepName;

    /**
    * 军代表意见
    */
    @ExcelProperty("军代表意见")
    @Size(max = 512, message = "军代表意见长度不能超过512个字符")
    @ApiModelProperty(value = "军代表意见", name = "milRepOpinion")
    @FieldRemark(column="MIL_REP_OPINION", field="milRepOpinion", name="军代表意见")
    private java.lang.String milRepOpinion;
    /**
    * 军代表审批时间
    */
    @ExcelProperty("军代表审批时间")
    @DateTimeFormat("yyyy/MM/dd")
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value = "军代表审批时间", name = "milRepApprovalTime")
    @FieldRemark(column="MIL_REP_APPROVAL_TIME", field="milRepApprovalTime", name="军代表审批时间")
    private java.util.Date milRepApprovalTime;

    /**
    * 军代表审批时间起
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date milRepApprovalTimeBegin;

    /**
    * 军代表审批时间止
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private java.util.Date milRepApprovalTimeEnd;

    /**
    * 最终处置方式
    */
    @ExcelProperty("最终处置方式")
    @Size(max = 50, message = "最终处置方式长度不能超过50个字符")
    @ApiModelProperty(value = "最终处置方式", name = "finalDisposition")
    @FieldRemark(column="FINAL_DISPOSITION", field="finalDisposition", name="最终处置方式")
    private java.lang.String finalDisposition;

    /**
    * 处置方式说明
    */
    @ExcelProperty("处置方式说明")
    @Size(max = 2000, message = "处置方式说明长度不能超过2000个字符")
    @ApiModelProperty(value = "处置方式说明", name = "finalDispositionDesc")
    @FieldRemark(column="FINAL_DISPOSITION_DESC", field="finalDispositionDesc", name="处置方式说明")
    private java.lang.String finalDispositionDesc;

    /**
    * 业务状态
    */
    @Size(max = 10, message = "业务状态长度不能超过10个字符")
    @ApiModelProperty(value = "业务状态", name = "status")
    @FieldRemark(column="STATUS", field="status", name="业务状态")
    private java.lang.String status;

    /**
    * 流程实例ID
    */
    @Size(max = 64, message = "流程实例ID长度不能超过64个字符")
    @ApiModelProperty(value = "流程实例ID", name = "processInstanceId")
    @FieldRemark(column="PROCESS_INSTANCE_ID", field="processInstanceId", name="流程实例ID")
    private java.lang.String processInstanceId;

    /**
    * 流程状态
    */
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

    public java.lang.String getReviewCode(){
        return reviewCode;
    }

    public void setReviewCode(java.lang.String reviewCode){
        this.reviewCode = reviewCode;
    }

    public java.lang.String getReviewSecretLevel(){
        return reviewSecretLevel;
    }

    public void setReviewSecretLevel(java.lang.String reviewSecretLevel){
        this.reviewSecretLevel = reviewSecretLevel;
    }

    public java.util.Date getReportTime(){
        return reportTime;
    }

    public void setReportTime(java.util.Date reportTime){
        this.reportTime = reportTime;
        super.handleNullValue();
    }

    public java.util.Date getReportTimeBegin(){
        return reportTimeBegin;
    }

    public void setReportTimeBegin(java.util.Date reportTimeBegin){
        this.reportTimeBegin = reportTimeBegin;
    }

    public java.util.Date getReportTimeEnd(){
        return reportTimeEnd;
    }

    public void setReportTimeEnd(java.util.Date reportTimeEnd){
        this.reportTimeEnd = reportTimeEnd;
    }

    public java.lang.String getModel(){
        return model;
    }

    public void setModel(java.lang.String model){
        this.model = model;
    }

    public java.lang.String getPartName(){
        return partName;
    }

    public void setPartName(java.lang.String partName){
        this.partName = partName;
    }

    public java.lang.String getPartDrawingNo(){
        return partDrawingNo;
    }

    public void setPartDrawingNo(java.lang.String partDrawingNo){
        this.partDrawingNo = partDrawingNo;
    }

    public java.lang.String getAssemblyName(){
        return assemblyName;
    }

    public void setAssemblyName(java.lang.String assemblyName){
        this.assemblyName = assemblyName;
    }

    public java.lang.String getAssemblyDrawingNo(){
        return assemblyDrawingNo;
    }

    public void setAssemblyDrawingNo(java.lang.String assemblyDrawingNo){
        this.assemblyDrawingNo = assemblyDrawingNo;
    }

    public java.lang.String getRoutingCardNo(){
        return routingCardNo;
    }

    public void setRoutingCardNo(java.lang.String routingCardNo){
        this.routingCardNo = routingCardNo;
    }

    public java.lang.String getBatchNo(){
        return batchNo;
    }

    public void setBatchNo(java.lang.String batchNo){
        this.batchNo = batchNo;
    }

    public java.lang.String getComponentSerialNo(){
        return componentSerialNo;
    }

    public void setComponentSerialNo(java.lang.String componentSerialNo){
        this.componentSerialNo = componentSerialNo;
    }

    public java.lang.String getProcessNo(){
        return processNo;
    }

    public void setProcessNo(java.lang.String processNo){
        this.processNo = processNo;
    }

    public java.lang.String getHeatBatchNo(){
        return heatBatchNo;
    }

    public void setHeatBatchNo(java.lang.String heatBatchNo){
        this.heatBatchNo = heatBatchNo;
    }

    public java.lang.String getNcCategory(){
        return ncCategory;
    }

    public void setNcCategory(java.lang.String ncCategory){
        this.ncCategory = ncCategory;
    }

    public java.math.BigDecimal getQuantity(){
        return quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity){
        this.quantity = quantity;
        super.handleNullValue();
    }

    public java.math.BigDecimal getTotalPageCount(){
        return totalPageCount;
    }

    public void setTotalPageCount(java.math.BigDecimal totalPageCount){
        this.totalPageCount = totalPageCount;
        super.handleNullValue();
    }

    public java.math.BigDecimal getIssuePageCount(){
        return issuePageCount;
    }

    public void setIssuePageCount(java.math.BigDecimal issuePageCount){
        this.issuePageCount = issuePageCount;
        super.handleNullValue();
    }

    public java.lang.String getTechSpecReq(){
        return techSpecReq;
    }

    public void setTechSpecReq(java.lang.String techSpecReq){
        this.techSpecReq = techSpecReq;
    }

    public java.lang.String getNcDescreption(){
        return ncDescreption;
    }

    public void setNcDescreption(java.lang.String ncDescreption){
        this.ncDescreption = ncDescreption;
    }

    public java.lang.String getInspectorId(){
        return inspectorId;
    }

    public void setInspectorId(java.lang.String inspectorId){
        this.inspectorId = inspectorId;
    }

    public java.lang.String getInspectorIdAlias(){
        return inspectorIdAlias;
    }

    public void setInspectorIdAlias(java.lang.String inspectorIdAlias){
        this.inspectorIdAlias = inspectorIdAlias;
    }

    public java.lang.String getInspectorCode(){
        return inspectorCode;
    }

    public void setInspectorCode(java.lang.String inspectorCode){
        this.inspectorCode = inspectorCode;
    }

    public java.lang.String getInspectorName(){
        return inspectorName;
    }

    public void setInspectorName(java.lang.String inspectorName){
        this.inspectorName = inspectorName;
    }

    public java.lang.String getInspectionDeptLeaderId(){
        return inspectionDeptLeaderId;
    }

    public void setInspectionDeptLeaderId(java.lang.String inspectionDeptLeaderId){
        this.inspectionDeptLeaderId = inspectionDeptLeaderId;
    }

    public java.lang.String getInspectionDeptLeaderIdAlias(){
        return inspectionDeptLeaderIdAlias;
    }

    public void setInspectionDeptLeaderIdAlias(java.lang.String inspectionDeptLeaderIdAlias){
        this.inspectionDeptLeaderIdAlias = inspectionDeptLeaderIdAlias;
    }

    public java.lang.String getInspectionDeptLeaderCode(){
        return inspectionDeptLeaderCode;
    }

    public void setInspectionDeptLeaderCode(java.lang.String inspectionDeptLeaderCode){
        this.inspectionDeptLeaderCode = inspectionDeptLeaderCode;
    }

    public java.lang.String getInspectionDeptLeaderName(){
        return inspectionDeptLeaderName;
    }

    public void setInspectionDeptLeaderName(java.lang.String inspectionDeptLeaderName){
        this.inspectionDeptLeaderName = inspectionDeptLeaderName;
    }

    public java.lang.String getCauseCategory(){
        return causeCategory;
    }

    public void setCauseCategory(java.lang.String causeCategory){
        this.causeCategory = causeCategory;
    }

    public java.lang.String getCauseAnalysis(){
        return causeAnalysis;
    }

    public void setCauseAnalysis(java.lang.String causeAnalysis){
        this.causeAnalysis = causeAnalysis;
    }

    public java.lang.String getCorrectiveMeasure(){
        return correctiveMeasure;
    }

    public void setCorrectiveMeasure(java.lang.String correctiveMeasure){
        this.correctiveMeasure = correctiveMeasure;
    }

    public java.lang.String getResponsibleDeptId(){
        return responsibleDeptId;
    }

    public void setResponsibleDeptId(java.lang.String responsibleDeptId){
        this.responsibleDeptId = responsibleDeptId;
    }

    public java.lang.String getResponsibleDeptIdAlias(){
        return responsibleDeptIdAlias;
    }

    public void setResponsibleDeptIdAlias(java.lang.String responsibleDeptIdAlias){
        this.responsibleDeptIdAlias = responsibleDeptIdAlias;
    }

    public java.lang.String getResponsibleDeptCode(){
        return responsibleDeptCode;
    }

    public void setResponsibleDeptCode(java.lang.String responsibleDeptCode){
        this.responsibleDeptCode = responsibleDeptCode;
    }

    public java.lang.String getResponsibleDeptName(){
        return responsibleDeptName;
    }

    public void setResponsibleDeptName(java.lang.String responsibleDeptName){
        this.responsibleDeptName = responsibleDeptName;
    }

    public java.lang.String getResponsibleDeptLeaderId(){
        return responsibleDeptLeaderId;
    }

    public void setResponsibleDeptLeaderId(java.lang.String responsibleDeptLeaderId){
        this.responsibleDeptLeaderId = responsibleDeptLeaderId;
    }

    public java.lang.String getResponsibleDeptLeaderIdAlias(){
        return responsibleDeptLeaderIdAlias;
    }

    public void setResponsibleDeptLeaderIdAlias(java.lang.String responsibleDeptLeaderIdAlias){
        this.responsibleDeptLeaderIdAlias = responsibleDeptLeaderIdAlias;
    }

    public java.lang.String getResponsibleDeptLeaderCode(){
        return responsibleDeptLeaderCode;
    }

    public void setResponsibleDeptLeaderCode(java.lang.String responsibleDeptLeaderCode){
        this.responsibleDeptLeaderCode = responsibleDeptLeaderCode;
    }

    public java.lang.String getResponsibleDeptLeaderName(){
        return responsibleDeptLeaderName;
    }

    public void setResponsibleDeptLeaderName(java.lang.String responsibleDeptLeaderName){
        this.responsibleDeptLeaderName = responsibleDeptLeaderName;
    }

    public java.lang.String getResponsibleSupervisorId(){
        return responsibleSupervisorId;
    }

    public void setResponsibleSupervisorId(java.lang.String responsibleSupervisorId){
        this.responsibleSupervisorId = responsibleSupervisorId;
    }

    public java.lang.String getResponsibleSupervisorIdAlias(){
        return responsibleSupervisorIdAlias;
    }

    public void setResponsibleSupervisorIdAlias(java.lang.String responsibleSupervisorIdAlias){
        this.responsibleSupervisorIdAlias = responsibleSupervisorIdAlias;
    }

    public java.lang.String getResponsibleSupervisorCode(){
        return responsibleSupervisorCode;
    }

    public void setResponsibleSupervisorCode(java.lang.String responsibleSupervisorCode){
        this.responsibleSupervisorCode = responsibleSupervisorCode;
    }

    public java.lang.String getResponsibleSupervisorName(){
        return responsibleSupervisorName;
    }

    public void setResponsibleSupervisorName(java.lang.String responsibleSupervisorName){
        this.responsibleSupervisorName = responsibleSupervisorName;
    }

    public java.lang.String getResponsibleUserId(){
        return responsibleUserId;
    }

    public void setResponsibleUserId(java.lang.String responsibleUserId){
        this.responsibleUserId = responsibleUserId;
    }

    public java.lang.String getResponsibleUserIdAlias(){
        return responsibleUserIdAlias;
    }

    public void setResponsibleUserIdAlias(java.lang.String responsibleUserIdAlias){
        this.responsibleUserIdAlias = responsibleUserIdAlias;
    }

    public java.lang.String getResponsibleUserCode(){
        return responsibleUserCode;
    }

    public void setResponsibleUserCode(java.lang.String responsibleUserCode){
        this.responsibleUserCode = responsibleUserCode;
    }

    public java.lang.String getResponsibleUserName(){
        return responsibleUserName;
    }

    public void setResponsibleUserName(java.lang.String responsibleUserName){
        this.responsibleUserName = responsibleUserName;
    }

    public java.lang.String getImpactAnalysis(){
        return impactAnalysis;
    }

    public void setImpactAnalysis(java.lang.String impactAnalysis){
        this.impactAnalysis = impactAnalysis;
    }

    public java.lang.String getGroupReviewOpinion(){
        return groupReviewOpinion;
    }

    public void setGroupReviewOpinion(java.lang.String groupReviewOpinion){
        this.groupReviewOpinion = groupReviewOpinion;
    }

    public java.lang.String getGroupDesposition(){
        return groupDesposition;
    }

    public void setGroupDesposition(java.lang.String groupDesposition){
        this.groupDesposition = groupDesposition;
    }

    public java.lang.String getGroupDespositionDesc(){
        return groupDespositionDesc;
    }

    public void setGroupDespositionDesc(java.lang.String groupDespositionDesc){
        this.groupDespositionDesc = groupDespositionDesc;
    }

    public java.lang.String getReviewDeptId(){
        return reviewDeptId;
    }

    public void setReviewDeptId(java.lang.String reviewDeptId){
        this.reviewDeptId = reviewDeptId;
    }

    public java.lang.String getReviewDeptIdAlias(){
        return reviewDeptIdAlias;
    }

    public void setReviewDeptIdAlias(java.lang.String reviewDeptIdAlias){
        this.reviewDeptIdAlias = reviewDeptIdAlias;
    }

    public java.lang.String getReviewDeptCode(){
        return reviewDeptCode;
    }

    public void setReviewDeptCode(java.lang.String reviewDeptCode){
        this.reviewDeptCode = reviewDeptCode;
    }

    public java.lang.String getReviewDeptName(){
        return reviewDeptName;
    }

    public void setReviewDeptName(java.lang.String reviewDeptName){
        this.reviewDeptName = reviewDeptName;
    }

    public java.lang.String getReviewUserId(){
        return reviewUserId;
    }

    public void setReviewUserId(java.lang.String reviewUserId){
        this.reviewUserId = reviewUserId;
    }

    public java.lang.String getReviewUserIdAlias(){
        return reviewUserIdAlias;
    }

    public void setReviewUserIdAlias(java.lang.String reviewUserIdAlias){
        this.reviewUserIdAlias = reviewUserIdAlias;
    }

    public java.lang.String getReviewUserCode(){
        return reviewUserCode;
    }

    public void setReviewUserCode(java.lang.String reviewUserCode){
        this.reviewUserCode = reviewUserCode;
    }

    public java.lang.String getReviewUserName(){
        return reviewUserName;
    }

    public void setReviewUserName(java.lang.String reviewUserName){
        this.reviewUserName = reviewUserName;
    }

    public java.util.Date getReviewTime(){
        return reviewTime;
    }

    public void setReviewTime(java.util.Date reviewTime){
        this.reviewTime = reviewTime;
        super.handleNullValue();
    }

    public java.util.Date getReviewTimeBegin(){
        return reviewTimeBegin;
    }

    public void setReviewTimeBegin(java.util.Date reviewTimeBegin){
        this.reviewTimeBegin = reviewTimeBegin;
    }

    public java.util.Date getReviewTimeEnd(){
        return reviewTimeEnd;
    }

    public void setReviewTimeEnd(java.util.Date reviewTimeEnd){
        this.reviewTimeEnd = reviewTimeEnd;
    }

    public java.lang.String getYnNeedCommitee(){
        return ynNeedCommitee;
    }

    public void setYnNeedCommitee(java.lang.String ynNeedCommitee){
        this.ynNeedCommitee = ynNeedCommitee;
    }

    public java.lang.String getCommiteeOpinion(){
        return commiteeOpinion;
    }

    public void setCommiteeOpinion(java.lang.String commiteeOpinion){
        this.commiteeOpinion = commiteeOpinion;
    }

    public java.lang.String getCommiteeMemberId(){
        return commiteeMemberId;
    }

    public void setCommiteeMemberId(java.lang.String commiteeMemberId){
        this.commiteeMemberId = commiteeMemberId;
    }

    public java.lang.String getCommiteeMemberIdAlias(){
        return commiteeMemberIdAlias;
    }

    public void setCommiteeMemberIdAlias(java.lang.String commiteeMemberIdAlias){
        this.commiteeMemberIdAlias = commiteeMemberIdAlias;
    }

    public java.lang.String getCommiteeMemberCode(){
        return commiteeMemberCode;
    }

    public void setCommiteeMemberCode(java.lang.String commiteeMemberCode){
        this.commiteeMemberCode = commiteeMemberCode;
    }

    public java.lang.String getCommiteeMemberName(){
        return commiteeMemberName;
    }

    public void setCommiteeMemberName(java.lang.String commiteeMemberName){
        this.commiteeMemberName = commiteeMemberName;
    }

    public java.util.Date getCommiteeApprovalTime(){
        return commiteeApprovalTime;
    }

    public void setCommiteeApprovalTime(java.util.Date commiteeApprovalTime){
        this.commiteeApprovalTime = commiteeApprovalTime;
        super.handleNullValue();
    }

    public java.util.Date getCommiteeApprovalTimeBegin(){
        return commiteeApprovalTimeBegin;
    }

    public void setCommiteeApprovalTimeBegin(java.util.Date commiteeApprovalTimeBegin){
        this.commiteeApprovalTimeBegin = commiteeApprovalTimeBegin;
    }

    public java.util.Date getCommiteeApprovalTimeEnd(){
        return commiteeApprovalTimeEnd;
    }

    public void setCommiteeApprovalTimeEnd(java.util.Date commiteeApprovalTimeEnd){
        this.commiteeApprovalTimeEnd = commiteeApprovalTimeEnd;
    }

    public java.lang.String getQualityDeptOpinion(){
        return qualityDeptOpinion;
    }

    public void setQualityDeptOpinion(java.lang.String qualityDeptOpinion){
        this.qualityDeptOpinion = qualityDeptOpinion;
    }

    public java.lang.String getModelQualitySupervisorId(){
        return modelQualitySupervisorId;
    }

    public void setModelQualitySupervisorId(java.lang.String modelQualitySupervisorId){
        this.modelQualitySupervisorId = modelQualitySupervisorId;
    }

    public java.lang.String getModelQualitySupervisorIdAlias(){
        return modelQualitySupervisorIdAlias;
    }

    public void setModelQualitySupervisorIdAlias(java.lang.String modelQualitySupervisorIdAlias){
        this.modelQualitySupervisorIdAlias = modelQualitySupervisorIdAlias;
    }

    public java.lang.String getModelQualitySupervisorCode(){
        return modelQualitySupervisorCode;
    }

    public void setModelQualitySupervisorCode(java.lang.String modelQualitySupervisorCode){
        this.modelQualitySupervisorCode = modelQualitySupervisorCode;
    }

    public java.lang.String getModelQualitySupervisorName(){
        return modelQualitySupervisorName;
    }

    public void setModelQualitySupervisorName(java.lang.String modelQualitySupervisorName){
        this.modelQualitySupervisorName = modelQualitySupervisorName;
    }

    public java.util.Date getQualityConfirmTime(){
        return qualityConfirmTime;
    }

    public void setQualityConfirmTime(java.util.Date qualityConfirmTime){
        this.qualityConfirmTime = qualityConfirmTime;
        super.handleNullValue();
    }

    public java.util.Date getQualityConfirmTimeBegin(){
        return qualityConfirmTimeBegin;
    }

    public void setQualityConfirmTimeBegin(java.util.Date qualityConfirmTimeBegin){
        this.qualityConfirmTimeBegin = qualityConfirmTimeBegin;
    }

    public java.util.Date getQualityConfirmTimeEnd(){
        return qualityConfirmTimeEnd;
    }

    public void setQualityConfirmTimeEnd(java.util.Date qualityConfirmTimeEnd){
        this.qualityConfirmTimeEnd = qualityConfirmTimeEnd;
    }

    public java.lang.String getYnMilRep(){
        return ynMilRep;
    }

    public void setYnMilRep(java.lang.String ynMilRep){
        this.ynMilRep = ynMilRep;
    }

    public java.lang.String getMilRepId(){
        return milRepId;
    }

    public void setMilRepId(java.lang.String milRepId){
        this.milRepId = milRepId;
    }

    public java.lang.String getMilRepIdAlias(){
        return milRepIdAlias;
    }

    public void setMilRepIdAlias(java.lang.String milRepIdAlias){
        this.milRepIdAlias = milRepIdAlias;
    }

    public java.lang.String getMilRepCode(){
        return milRepCode;
    }

    public void setMilRepCode(java.lang.String milRepCode){
        this.milRepCode = milRepCode;
    }

    public java.lang.String getMilRepName(){
        return milRepName;
    }

    public void setMilRepName(java.lang.String milRepName){
        this.milRepName = milRepName;
    }

    public java.lang.String getMilRepOpinion(){
        return milRepOpinion;
    }

    public void setMilRepOpinion(java.lang.String milRepOpinion){
        this.milRepOpinion = milRepOpinion;
    }

    public java.util.Date getMilRepApprovalTime(){
        return milRepApprovalTime;
    }

    public void setMilRepApprovalTime(java.util.Date milRepApprovalTime){
        this.milRepApprovalTime = milRepApprovalTime;
        super.handleNullValue();
    }

    public java.util.Date getMilRepApprovalTimeBegin(){
        return milRepApprovalTimeBegin;
    }

    public void setMilRepApprovalTimeBegin(java.util.Date milRepApprovalTimeBegin){
        this.milRepApprovalTimeBegin = milRepApprovalTimeBegin;
    }

    public java.util.Date getMilRepApprovalTimeEnd(){
        return milRepApprovalTimeEnd;
    }

    public void setMilRepApprovalTimeEnd(java.util.Date milRepApprovalTimeEnd){
        this.milRepApprovalTimeEnd = milRepApprovalTimeEnd;
    }

    public java.lang.String getFinalDisposition(){
        return finalDisposition;
    }

    public void setFinalDisposition(java.lang.String finalDisposition){
        this.finalDisposition = finalDisposition;
    }

    public java.lang.String getFinalDispositionDesc(){
        return finalDispositionDesc;
    }

    public void setFinalDispositionDesc(java.lang.String finalDispositionDesc){
        this.finalDispositionDesc = finalDispositionDesc;
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
            return "QMS_NC_PRODUCT";
        } else {
            return super.logFormName;
        }
    }

    @Override
    public String getLogTitle() {
        if (StringUtils.isEmpty(super.logTitle)) {
            return "QMS_NC_PRODUCT";
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
