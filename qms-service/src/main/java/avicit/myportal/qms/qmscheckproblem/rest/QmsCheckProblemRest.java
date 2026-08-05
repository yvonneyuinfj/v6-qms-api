package avicit.myportal.qms.qmscheckproblem.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemImportDTO;
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
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemDTO;
import avicit.myportal.qms.qmscheckproblem.service.QmsCheckProblemService;
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
 * @创建时间： 2026-08-05 18:17
 * @类说明：检查问题表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsCheckProblem", description = "检查问题表")
@RequestMapping("/api/myportal/qms/qmscheckproblems")
public class QmsCheckProblemRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsCheckProblemRest.class);

    @Autowired
    private QmsCheckProblemService qmsCheckProblemService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsCheckProblemDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsCheckProblem:view")
    public ResponseMsg<QueryRespBean<QmsCheckProblemDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsCheckProblemDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsCheckProblemDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsCheckProblemDTO> result = qmsCheckProblemService.searchQmsCheckProblemByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsCheckProblemDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsCheckProblemDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsCheckProblemDTO>> responseMsg = new ResponseMsg<>();
        List<QmsCheckProblemDTO> result = qmsCheckProblemService.queryQmsCheckProblemByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsCheckProblemDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsCheckProblem:edit")
    public ResponseMsg<QmsCheckProblemDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsCheckProblemDTO> responseMsg = new ResponseMsg<>();
        QmsCheckProblemDTO qmsCheckProblemDTO = qmsCheckProblemService.queryQmsCheckProblemByPrimaryKey(id);
        responseMsg.setResponseBody(qmsCheckProblemDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsCheckProblemDTO 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    @RequiresPermissions(value={"qmsCheckProblem:edit","qmsCheckProblem:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsCheckProblemDTO") @Validated @RequestBody QmsCheckProblemDTO qmsCheckProblemDTO) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(qmsCheckProblemDTO.getId())) {
            qmsCheckProblemDTO.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsCheckProblemService.insertQmsCheckProblem(qmsCheckProblemDTO));
        } else {
            responseMsg.setResponseBody(String.valueOf(qmsCheckProblemService.updateQmsCheckProblem(qmsCheckProblemDTO)));
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsCheckProblemDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsCheckProblemDTO")  @RequestBody QmsCheckProblemDTO qmsCheckProblemDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCheckProblemService.updateQmsCheckProblemSensitive(qmsCheckProblemDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsCheckProblemDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsCheckProblemDTO") @Validated @RequestBody QmsCheckProblemDTO qmsCheckProblemDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCheckProblemService.updateQmsCheckProblem(qmsCheckProblemDTO));
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
        responseMsg.setResponseBody(qmsCheckProblemService.deleteQmsCheckProblemById(id));
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
    @RequiresPermissions("qmsCheckProblem:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCheckProblemService.deleteQmsCheckProblemByIds(ids));
        return responseMsg;
    }
    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsCheckProblemImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    @RequiresPermissions("qmsCheckProblem:import")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsCheckProblemImportDTO.class);
        ExcelImportResult excelImportResult = qmsCheckProblemService.importData(excelList,formData);
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
    @RequiresPermissions("qmsCheckProblem:export")
    public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsCheckProblemDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsCheckProblemDTO> list = qmsCheckProblemService.searchQmsCheckProblemForExportExcel(queryReqBean);
        // 输出
        ExcelUtil.exportExcel(response, list, QmsCheckProblemDTO.class,"导出数据", "sheet1" );
    }
}