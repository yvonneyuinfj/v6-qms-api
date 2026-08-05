package avicit.myportal.qms.qmsactionplan.rest;

import avicit.platform6.core.exception.BusinessException;
import avicit.myportal.qms.qmsactionplan.dto.QmsActionPlanImportDTO;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import avicit.myportal.qms.qmsactionplan.dto.QmsActionPlanDTO;
import avicit.myportal.qms.qmsactionplan.service.QmsActionPlanService;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.annotation.Logical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:12
 * @类说明：通用实施计划表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsActionPlan", description = "通用实施计划表")
@RequestMapping("/api/myportal/qms/qmsactionplans")
    public class QmsActionPlanRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsActionPlanRest.class);

    @Autowired
    private QmsActionPlanService qmsActionPlanService;


    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsActionPlanDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询主表数据")
    @RequiresPermissions("qmsActionPlan:view")
    public ResponseMsg<QueryRespBean<QmsActionPlanDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsActionPlanDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsActionPlanDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsActionPlanDTO> result = qmsActionPlanService.searchQmsActionPlanByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<List<QmsActionPlanDTO>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "按条件不分页查询主表数据")
    public ResponseMsg<List<QmsActionPlanDTO>> search(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsActionPlanDTO> queryReqBean) {
        ResponseMsg<List<QmsActionPlanDTO>> responseMsg = new ResponseMsg<>();
        List<QmsActionPlanDTO> result = qmsActionPlanService.searchQmsActionPlan(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return ResponseMsg<QmsActionPlanDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过主键查询主表单条记录")
    @RequiresPermissions("qmsActionPlan:edit")
    public ResponseMsg<QmsActionPlanDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsActionPlanDTO> responseMsg = new ResponseMsg<>();
        QmsActionPlanDTO qmsActionPlan = qmsActionPlanService.queryQmsActionPlanByPrimaryKey(id);
        responseMsg.setResponseBody(qmsActionPlan);
        return responseMsg;
    }


    /**
     * 新增主表对象
     *
     * @param qmsActionPlan 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增主表对象")
    @RequiresPermissions(value={"qmsActionPlan:edit","qmsActionPlan:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsActionPlan") @Validated @RequestBody QmsActionPlanDTO qmsActionPlan) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsActionPlan.getId())) {
            qmsActionPlan.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsActionPlanService.insertQmsActionPlan(qmsActionPlan));
        }else{
            responseMsg.setResponseBody(String.valueOf(qmsActionPlanService.updateQmsActionPlan(qmsActionPlan)));
        }
        return responseMsg;
    }


    /**
     * 修改主表部分对象字段
     *
     * @param qmsActionPlan 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-sensitive/v1")
    @ApiOperation(value = "修改主表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsActionPlan") @RequestBody QmsActionPlanDTO qmsActionPlan) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsActionPlanService.updateQmsActionPlanSensitive(qmsActionPlan));
        return responseMsg;
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsActionPlan 修改对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改主表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsActionPlan") @Validated @RequestBody QmsActionPlanDTO qmsActionPlan) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsActionPlanService.updateQmsActionPlan(qmsActionPlan));
        return responseMsg;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return ResponseMsg<Integer>
     */
    @DeleteMapping("/delete-by-id/{id}/v1")
    @ApiOperation(value = "按主键单条删除")
    public ResponseMsg<Integer> deleteById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsActionPlanService.deleteQmsActionPlanById(id));
        return responseMsg;
    }

    /**
     * 主表数据批量删除
     *
     * @param ids 逗号分隔的id串
     * @return ResponseMsg<Integer>
     */
    @DeleteMapping("/delete-by-ids/v1")
    @ApiOperation(value = "主表数据批量删除")
    @RequiresPermissions("qmsActionPlan:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids")  @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsActionPlanService.deleteQmsActionPlanByIds(ids));
        return responseMsg;
    }

    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsActionPlanImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsActionPlan:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsActionPlanImportDTO.class);
        ExcelImportResult excelImportResult = qmsActionPlanService.importData(excelList,formData);
        responseMsg.setResponseBody(excelImportResult);
        return responseMsg;
    }

    /**
     * 按条件导出所有
     * @param queryReqBean 查询条件
     * @return
     */
    @PostMapping("/exportData/v1")
    @ApiOperation(value = "按条件导出所有")
    @RequiresPermissions("qmsActionPlan:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsActionPlanDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsActionPlanDTO> list = qmsActionPlanService.searchQmsActionPlanForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsActionPlanDTO.class,"导出数据", "sheet1" );
    }
}
