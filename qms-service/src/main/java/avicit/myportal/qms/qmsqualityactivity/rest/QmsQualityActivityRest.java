package avicit.myportal.qms.qmsqualityactivity.rest;

import avicit.platform6.core.exception.BusinessException;
import avicit.myportal.qms.qmsqualityactivity.dto.QmsQualityActivityImportDTO;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import avicit.myportal.qms.qmsqualityactivity.dto.QmsQualityActivityDTO;
import avicit.myportal.qms.qmsqualityactivity.service.QmsQualityActivityService;
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
 * @创建时间： 2026-08-06 15:52
 * @类说明：质量活动台账表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityActivity", description = "质量活动台账表")
@RequestMapping("/api/myportal/qms/qmsqualityactivitys")
    public class QmsQualityActivityRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityActivityRest.class);

    @Autowired
    private QmsQualityActivityService qmsQualityActivityService;


    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityActivityDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询主表数据")
    @RequiresPermissions("qmsQualityActivity:view")
    public ResponseMsg<QueryRespBean<QmsQualityActivityDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityActivityDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityActivityDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityActivityDTO> result = qmsQualityActivityService.searchQmsQualityActivityByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<List<QmsQualityActivityDTO>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "按条件不分页查询主表数据")
    public ResponseMsg<List<QmsQualityActivityDTO>> search(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityActivityDTO> queryReqBean) {
        ResponseMsg<List<QmsQualityActivityDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityActivityDTO> result = qmsQualityActivityService.searchQmsQualityActivity(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityActivityDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过主键查询主表单条记录")
    @RequiresPermissions("qmsQualityActivity:edit")
    public ResponseMsg<QmsQualityActivityDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityActivityDTO> responseMsg = new ResponseMsg<>();
        QmsQualityActivityDTO qmsQualityActivity = qmsQualityActivityService.queryQmsQualityActivityByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityActivity);
        return responseMsg;
    }


    /**
     * 新增主表对象
     *
     * @param qmsQualityActivity 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增主表对象")
    @RequiresPermissions(value={"qmsQualityActivity:edit","qmsQualityActivity:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityActivity") @Validated @RequestBody QmsQualityActivityDTO qmsQualityActivity) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsQualityActivity.getId())) {
            qmsQualityActivity.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsQualityActivityService.insertQmsQualityActivity(qmsQualityActivity));
        }else{
            responseMsg.setResponseBody(String.valueOf(qmsQualityActivityService.updateQmsQualityActivity(qmsQualityActivity)));
        }
        return responseMsg;
    }


    /**
     * 修改主表部分对象字段
     *
     * @param qmsQualityActivity 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-sensitive/v1")
    @ApiOperation(value = "修改主表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityActivity") @RequestBody QmsQualityActivityDTO qmsQualityActivity) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityService.updateQmsQualityActivitySensitive(qmsQualityActivity));
        return responseMsg;
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsQualityActivity 修改对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改主表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsQualityActivity") @Validated @RequestBody QmsQualityActivityDTO qmsQualityActivity) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityService.updateQmsQualityActivity(qmsQualityActivity));
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
        responseMsg.setResponseBody(qmsQualityActivityService.deleteQmsQualityActivityById(id));
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
    @RequiresPermissions("qmsQualityActivity:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids")  @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityService.deleteQmsQualityActivityByIds(ids));
        return responseMsg;
    }

    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsQualityActivityImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsQualityActivity:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsQualityActivityImportDTO.class);
        ExcelImportResult excelImportResult = qmsQualityActivityService.importData(excelList,formData);
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
    @RequiresPermissions("qmsQualityActivity:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityActivityDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsQualityActivityDTO> list = qmsQualityActivityService.searchQmsQualityActivityForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsQualityActivityDTO.class,"导出数据", "sheet1" );
    }
}
