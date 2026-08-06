package avicit.myportal.qms.qmsqualityactivityprogress.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.myportal.qms.qmsqualityactivityprogress.dto.QmsQualityActivityProgressImportDTO;
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
import avicit.myportal.qms.qmsqualityactivityprogress.dto.QmsQualityActivityProgressDTO;
import avicit.myportal.qms.qmsqualityactivityprogress.service.QmsQualityActivityProgressService;
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
 * @创建时间： 2026-08-06 15:52
 * @类说明：活动过程反馈表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityActivityProgress", description = "活动过程反馈表")
@RequestMapping("/api/myportal/qms/qmsqualityactivityprogresss")
public class QmsQualityActivityProgressRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityActivityProgressRest.class);

    @Autowired
    private QmsQualityActivityProgressService qmsQualityActivityProgressService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityActivityProgressDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsQualityActivityProgress:view")
    public ResponseMsg<QueryRespBean<QmsQualityActivityProgressDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityActivityProgressDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityActivityProgressDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityActivityProgressDTO> result = qmsQualityActivityProgressService.searchQmsQualityActivityProgressByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsQualityActivityProgressDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsQualityActivityProgressDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsQualityActivityProgressDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityActivityProgressDTO> result = qmsQualityActivityProgressService.queryQmsQualityActivityProgressByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityActivityProgressDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsQualityActivityProgress:edit")
    public ResponseMsg<QmsQualityActivityProgressDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityActivityProgressDTO> responseMsg = new ResponseMsg<>();
        QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO = qmsQualityActivityProgressService.queryQmsQualityActivityProgressByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityActivityProgressDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsQualityActivityProgressDTO 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    @RequiresPermissions(value={"qmsQualityActivityProgress:edit","qmsQualityActivityProgress:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityActivityProgressDTO") @Validated @RequestBody QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsQualityActivityProgressDTO.getId())) {
            qmsQualityActivityProgressDTO.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsQualityActivityProgressService.insertQmsQualityActivityProgress(qmsQualityActivityProgressDTO));
        } else {
            responseMsg.setResponseBody(String.valueOf(qmsQualityActivityProgressService.updateQmsQualityActivityProgress(qmsQualityActivityProgressDTO)));
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsQualityActivityProgressDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityActivityProgressDTO")  @RequestBody QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityProgressService.updateQmsQualityActivityProgressSensitive(qmsQualityActivityProgressDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsQualityActivityProgressDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsQualityActivityProgressDTO") @Validated @RequestBody QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityProgressService.updateQmsQualityActivityProgress(qmsQualityActivityProgressDTO));
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
        responseMsg.setResponseBody(qmsQualityActivityProgressService.deleteQmsQualityActivityProgressById(id));
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
    @RequiresPermissions("qmsQualityActivityProgress:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityActivityProgressService.deleteQmsQualityActivityProgressByIds(ids));
        return responseMsg;
    }
    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsQualityActivityProgressImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsQualityActivityProgress:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsQualityActivityProgressImportDTO.class);
        ExcelImportResult excelImportResult = qmsQualityActivityProgressService.importData(excelList,formData);
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
    @RequiresPermissions("qmsQualityActivityProgress:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityActivityProgressDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsQualityActivityProgressDTO> list = qmsQualityActivityProgressService.searchQmsQualityActivityProgressForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsQualityActivityProgressDTO.class,"导出数据", "sheet1" );
    }
}