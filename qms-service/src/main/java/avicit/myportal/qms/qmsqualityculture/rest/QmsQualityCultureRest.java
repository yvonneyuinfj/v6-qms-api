package avicit.myportal.qms.qmsqualityculture.rest;

import avicit.platform6.core.exception.BusinessException;
import avicit.myportal.qms.qmsqualityculture.dto.QmsQualityCultureImportDTO;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import avicit.myportal.qms.qmsqualityculture.dto.QmsQualityCultureDTO;
import avicit.myportal.qms.qmsqualityculture.service.QmsQualityCultureService;
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
 * @创建时间： 2026-08-06 15:53
 * @类说明：质量文化Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityCulture", description = "质量文化")
@RequestMapping("/api/myportal/qms/qmsqualitycultures")
    public class QmsQualityCultureRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityCultureRest.class);

    @Autowired
    private QmsQualityCultureService qmsQualityCultureService;


    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityCultureDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询主表数据")
    @RequiresPermissions("qmsQualityCulture:view")
    public ResponseMsg<QueryRespBean<QmsQualityCultureDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityCultureDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityCultureDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityCultureDTO> result = qmsQualityCultureService.searchQmsQualityCultureByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<List<QmsQualityCultureDTO>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "按条件不分页查询主表数据")
    public ResponseMsg<List<QmsQualityCultureDTO>> search(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityCultureDTO> queryReqBean) {
        ResponseMsg<List<QmsQualityCultureDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityCultureDTO> result = qmsQualityCultureService.searchQmsQualityCulture(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityCultureDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过主键查询主表单条记录")
    @RequiresPermissions("qmsQualityCulture:edit")
    public ResponseMsg<QmsQualityCultureDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityCultureDTO> responseMsg = new ResponseMsg<>();
        QmsQualityCultureDTO qmsQualityCulture = qmsQualityCultureService.queryQmsQualityCultureByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityCulture);
        return responseMsg;
    }


    /**
     * 新增主表对象
     *
     * @param qmsQualityCulture 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增主表对象")
    @RequiresPermissions(value={"qmsQualityCulture:edit","qmsQualityCulture:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityCulture") @Validated @RequestBody QmsQualityCultureDTO qmsQualityCulture) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsQualityCulture.getId())) {
            qmsQualityCulture.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsQualityCultureService.insertQmsQualityCulture(qmsQualityCulture));
        }else{
            responseMsg.setResponseBody(String.valueOf(qmsQualityCultureService.updateQmsQualityCulture(qmsQualityCulture)));
        }
        return responseMsg;
    }


    /**
     * 修改主表部分对象字段
     *
     * @param qmsQualityCulture 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-sensitive/v1")
    @ApiOperation(value = "修改主表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityCulture") @RequestBody QmsQualityCultureDTO qmsQualityCulture) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityCultureService.updateQmsQualityCultureSensitive(qmsQualityCulture));
        return responseMsg;
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsQualityCulture 修改对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改主表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsQualityCulture") @Validated @RequestBody QmsQualityCultureDTO qmsQualityCulture) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityCultureService.updateQmsQualityCulture(qmsQualityCulture));
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
        responseMsg.setResponseBody(qmsQualityCultureService.deleteQmsQualityCultureById(id));
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
    @RequiresPermissions("qmsQualityCulture:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids")  @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityCultureService.deleteQmsQualityCultureByIds(ids));
        return responseMsg;
    }

    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsQualityCultureImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsQualityCulture:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsQualityCultureImportDTO.class);
        ExcelImportResult excelImportResult = qmsQualityCultureService.importData(excelList,formData);
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
    @RequiresPermissions("qmsQualityCulture:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityCultureDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsQualityCultureDTO> list = qmsQualityCultureService.searchQmsQualityCultureForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsQualityCultureDTO.class,"导出数据", "sheet1" );
    }
}
