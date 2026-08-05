package avicit.myportal.qms.qmstop10problem.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.myportal.qms.qmstop10problem.dto.QmsTop10ProblemDTO;
import avicit.myportal.qms.qmstop10problem.dto.QmsTop10ProblemImportDTO;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import avicit.myportal.qms.qmstop10problem.service.QmsTop10ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.annotation.Logical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:11
 * @类说明：TOP10问题台账Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsTop10Problem", description = "TOP10问题台账")
@RequestMapping("/api/myportal/qms/qmstop10problems")
	public class QmsTop10ProblemRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsTop10ProblemRest.class);

	@Autowired
	private QmsTop10ProblemService qmsTop10ProblemService;


	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsTop10ProblemDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsTop10Problem:view")
	public ResponseMsg<QueryRespBean<QmsTop10ProblemDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsTop10ProblemDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsTop10ProblemDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsTop10ProblemDTO> result = qmsTop10ProblemService.searchQmsTop10ProblemByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsTop10ProblemDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsTop10ProblemDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsTop10ProblemDTO> queryReqBean) {
		ResponseMsg<List<QmsTop10ProblemDTO>> responseMsg = new ResponseMsg<>();
		List<QmsTop10ProblemDTO> result = qmsTop10ProblemService.searchQmsTop10Problem(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsTop10ProblemDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsTop10Problem:edit")
	public ResponseMsg<QmsTop10ProblemDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsTop10ProblemDTO> responseMsg = new ResponseMsg<>();
		QmsTop10ProblemDTO qmsTop10Problem = qmsTop10ProblemService.queryQmsTop10ProblemByPrimaryKey(id);
		responseMsg.setResponseBody(qmsTop10Problem);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsTop10Problem 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsTop10Problem:edit","qmsTop10Problem:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsTop10Problem") @Validated @RequestBody QmsTop10ProblemDTO qmsTop10Problem) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isEmpty(qmsTop10Problem.getId())) {
			qmsTop10Problem.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsTop10ProblemService.insertQmsTop10Problem(qmsTop10Problem));
		}else{
			responseMsg.setResponseBody(String.valueOf(qmsTop10ProblemService.updateQmsTop10Problem(qmsTop10Problem)));
		}
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsTop10Problem 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsTop10Problem")  @RequestBody QmsTop10ProblemDTO qmsTop10Problem) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsTop10ProblemService.updateQmsTop10ProblemSensitive(qmsTop10Problem));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsTop10Problem 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsTop10Problem") @Validated @RequestBody QmsTop10ProblemDTO qmsTop10Problem) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsTop10ProblemService.updateQmsTop10Problem(qmsTop10Problem));
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
		responseMsg.setResponseBody(qmsTop10ProblemService.deleteQmsTop10ProblemById(id));
		return responseMsg;
	}

	/**
	 * 批量删除
	 *
	 * @param ids 逗号分隔的id串
	 * @return ResponseMsg<Integer>
	 */
	@DeleteMapping("/delete-by-ids/v1")
	@ApiOperation(value = "批量删除")
	@RequiresPermissions("qmsTop10Problem:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsTop10ProblemService.deleteQmsTop10ProblemByIds(ids));
		return responseMsg;
	}

    @GetMapping("/downloadTemplate/v1")
	@ApiOperation(value = "模板下载")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		// 输出
		ExcelUtil.downloadTemplate(response, QmsTop10ProblemImportDTO.class,"导入模板");
	}

	/**
	 * 导入数据
	 * @param multipartFile 导入文件
	 * @return
	 */
	@PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "导入文件")
	@RequiresPermissions("qmsTop10Problem:import")
	public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
		ResponseMsg<Object> responseMsg = new ResponseMsg<>();
		List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsTop10ProblemImportDTO.class);
		ExcelImportResult excelImportResult = qmsTop10ProblemService.importData(excelList,formData);
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
	@RequiresPermissions("qmsTop10Problem:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsTop10ProblemDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsTop10ProblemDTO> list = qmsTop10ProblemService.searchQmsTop10ProblemForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsTop10ProblemDTO.class,"导出数据", "sheet1" );
	}
}
