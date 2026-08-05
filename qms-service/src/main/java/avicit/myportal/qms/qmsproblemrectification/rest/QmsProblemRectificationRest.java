package avicit.myportal.qms.qmsproblemrectification.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationImportDTO;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationDTO;
import avicit.myportal.qms.qmsproblemrectification.service.QmsProblemRectificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.annotation.Logical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:14
 * @类说明：问题整改表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsProblemRectification", description = "问题整改表")
@RequestMapping("/api/myportal/qms/qmsproblemrectifications")
public class QmsProblemRectificationRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsProblemRectificationRest.class);

    @Autowired
    private QmsProblemRectificationService qmsProblemRectificationService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsProblemRectificationDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsProblemRectification:view")
    public ResponseMsg<QueryRespBean<QmsProblemRectificationDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsProblemRectificationDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsProblemRectificationDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsProblemRectificationDTO> result = qmsProblemRectificationService.searchQmsProblemRectificationByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsProblemRectificationDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsProblemRectificationDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsProblemRectificationDTO>> responseMsg = new ResponseMsg<>();
        List<QmsProblemRectificationDTO> result = qmsProblemRectificationService.queryQmsProblemRectificationByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsProblemRectificationDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsProblemRectification:edit")
    public ResponseMsg<QmsProblemRectificationDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsProblemRectificationDTO> responseMsg = new ResponseMsg<>();
        QmsProblemRectificationDTO qmsProblemRectificationDTO = qmsProblemRectificationService.queryQmsProblemRectificationByPrimaryKey(id);
        responseMsg.setResponseBody(qmsProblemRectificationDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsProblemRectificationDTO 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    @RequiresPermissions(value={"qmsProblemRectification:edit","qmsProblemRectification:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsProblemRectificationDTO") @Validated @RequestBody QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsProblemRectificationDTO.getId())) {
            qmsProblemRectificationDTO.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsProblemRectificationService.insertQmsProblemRectification(qmsProblemRectificationDTO));
        } else {
            responseMsg.setResponseBody(String.valueOf(qmsProblemRectificationService.updateQmsProblemRectification(qmsProblemRectificationDTO)));
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsProblemRectificationDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsProblemRectificationDTO")  @RequestBody QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsProblemRectificationService.updateQmsProblemRectificationSensitive(qmsProblemRectificationDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsProblemRectificationDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsProblemRectificationDTO") @Validated @RequestBody QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsProblemRectificationService.updateQmsProblemRectification(qmsProblemRectificationDTO));
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
        responseMsg.setResponseBody(qmsProblemRectificationService.deleteQmsProblemRectificationById(id));
        return responseMsg;
    }

    /**
     * 子表数据批量删除
     *
     * @param ids 主键id串
     * @return ResponseMsg<Integer>
     */
    @DeleteMapping("/delete-by-ids/v1")
    @ApiOperation(value = "子表数据批量删除")
    @RequiresPermissions("qmsProblemRectification:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsProblemRectificationService.deleteQmsProblemRectificationByIds(ids));
        return responseMsg;
    }
    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsProblemRectificationImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsProblemRectification:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsProblemRectificationImportDTO.class);
        ExcelImportResult excelImportResult = qmsProblemRectificationService.importData(excelList,formData);
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
    @RequiresPermissions("qmsProblemRectification:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsProblemRectificationDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsProblemRectificationDTO> list = qmsProblemRectificationService.searchQmsProblemRectificationForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsProblemRectificationDTO.class,"导出数据", "sheet1" );
    }
}