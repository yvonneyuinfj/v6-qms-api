package avicit.myportal.qms.qmsmrimprovement.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.myportal.qms.qmsmrimprovement.dto.QmsMrImprovementDTO;
import avicit.myportal.qms.qmsmrimprovement.dto.QmsMrImprovementImportDTO;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import avicit.myportal.qms.qmsmrimprovement.service.QmsMrImprovementService;
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
 * @创建时间： 2026-08-03 19:45
 * @类说明：管评改进项台账Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsMrImprovement", description = "管评改进项台账")
@RequestMapping("/api/myportal/qms/qmsmrimprovements")
	public class QmsMrImprovementRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsMrImprovementRest.class);

	@Autowired
	private QmsMrImprovementService qmsMrImprovementService;


	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsMrImprovementDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsMrImprovement:view")
	public ResponseMsg<QueryRespBean<QmsMrImprovementDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrImprovementDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsMrImprovementDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsMrImprovementDTO> result = qmsMrImprovementService.searchQmsMrImprovementByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsMrImprovementDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsMrImprovementDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrImprovementDTO> queryReqBean) {
		ResponseMsg<List<QmsMrImprovementDTO>> responseMsg = new ResponseMsg<>();
		List<QmsMrImprovementDTO> result = qmsMrImprovementService.searchQmsMrImprovement(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsMrImprovementDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsMrImprovement:edit")
	public ResponseMsg<QmsMrImprovementDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsMrImprovementDTO> responseMsg = new ResponseMsg<>();
		QmsMrImprovementDTO qmsMrImprovement = qmsMrImprovementService.queryQmsMrImprovementByPrimaryKey(id);
		responseMsg.setResponseBody(qmsMrImprovement);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsMrImprovement 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsMrImprovement:edit","qmsMrImprovement:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsMrImprovement") @Validated @RequestBody QmsMrImprovementDTO qmsMrImprovement) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isEmpty(qmsMrImprovement.getId())) {
			qmsMrImprovement.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsMrImprovementService.insertQmsMrImprovement(qmsMrImprovement));
		}else{
			responseMsg.setResponseBody(String.valueOf(qmsMrImprovementService.updateQmsMrImprovement(qmsMrImprovement)));
		}
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMrImprovement 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsMrImprovement")  @RequestBody QmsMrImprovementDTO qmsMrImprovement) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrImprovementService.updateQmsMrImprovementSensitive(qmsMrImprovement));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMrImprovement 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsMrImprovement") @Validated @RequestBody QmsMrImprovementDTO qmsMrImprovement) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrImprovementService.updateQmsMrImprovement(qmsMrImprovement));
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
		responseMsg.setResponseBody(qmsMrImprovementService.deleteQmsMrImprovementById(id));
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
	@RequiresPermissions("qmsMrImprovement:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrImprovementService.deleteQmsMrImprovementByIds(ids));
		return responseMsg;
	}

    @GetMapping("/downloadTemplate/v1")
	@ApiOperation(value = "模板下载")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		// 输出
		ExcelUtil.downloadTemplate(response, QmsMrImprovementImportDTO.class,"导入模板");
	}

	/**
	 * 导入数据
	 * @param multipartFile 导入文件
	 * @return
	 */
	@PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "导入文件")
	@RequiresPermissions("qmsMrImprovement:import")
	public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
		ResponseMsg<Object> responseMsg = new ResponseMsg<>();
		List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsMrImprovementImportDTO.class);
		ExcelImportResult excelImportResult = qmsMrImprovementService.importData(excelList,formData);
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
	@RequiresPermissions("qmsMrImprovement:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrImprovementDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsMrImprovementDTO> list = qmsMrImprovementService.searchQmsMrImprovementForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsMrImprovementDTO.class,"导出数据", "sheet1" );
	}
}
