package avicit.myportal.qms.qmsmilitaryqualkeepitemdef.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.myportal.qms.qmsmilitaryqualkeepitemdef.dto.QmsMilitaryQualKeepItemDefDTO;
import avicit.myportal.qms.qmsmilitaryqualkeepitemdef.dto.QmsMilitaryQualKeepItemDefImportDTO;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import avicit.myportal.qms.qmsmilitaryqualkeepitemdef.service.QmsMilitaryQualKeepItemDefService;
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
 * @创建时间： 2026-08-05 18:10
 * @类说明：资格保持自查项定义表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsMilitaryQualKeepItemDef", description = "资格保持自查项定义表")
@RequestMapping("/api/myportal/qms/qmsmilitaryqualkeepitemdefs")
	public class QmsMilitaryQualKeepItemDefRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualKeepItemDefRest.class);

	@Autowired
	private QmsMilitaryQualKeepItemDefService qmsMilitaryQualKeepItemDefService;


	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsMilitaryQualKeepItemDefDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsMilitaryQualKeepItemDef:view")
	public ResponseMsg<QueryRespBean<QmsMilitaryQualKeepItemDefDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualKeepItemDefDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsMilitaryQualKeepItemDefDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsMilitaryQualKeepItemDefDTO> result = qmsMilitaryQualKeepItemDefService.searchQmsMilitaryQualKeepItemDefByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsMilitaryQualKeepItemDefDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsMilitaryQualKeepItemDefDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualKeepItemDefDTO> queryReqBean) {
		ResponseMsg<List<QmsMilitaryQualKeepItemDefDTO>> responseMsg = new ResponseMsg<>();
		List<QmsMilitaryQualKeepItemDefDTO> result = qmsMilitaryQualKeepItemDefService.searchQmsMilitaryQualKeepItemDef(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsMilitaryQualKeepItemDefDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsMilitaryQualKeepItemDef:edit")
	public ResponseMsg<QmsMilitaryQualKeepItemDefDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsMilitaryQualKeepItemDefDTO> responseMsg = new ResponseMsg<>();
		QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDef = qmsMilitaryQualKeepItemDefService.queryQmsMilitaryQualKeepItemDefByPrimaryKey(id);
		responseMsg.setResponseBody(qmsMilitaryQualKeepItemDef);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsMilitaryQualKeepItemDef 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsMilitaryQualKeepItemDef:edit","qmsMilitaryQualKeepItemDef:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsMilitaryQualKeepItemDef") @Validated @RequestBody QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDef) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isEmpty(qmsMilitaryQualKeepItemDef.getId())) {
			qmsMilitaryQualKeepItemDef.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsMilitaryQualKeepItemDefService.insertQmsMilitaryQualKeepItemDef(qmsMilitaryQualKeepItemDef));
		}else{
			responseMsg.setResponseBody(String.valueOf(qmsMilitaryQualKeepItemDefService.updateQmsMilitaryQualKeepItemDef(qmsMilitaryQualKeepItemDef)));
		}
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMilitaryQualKeepItemDef 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsMilitaryQualKeepItemDef")  @RequestBody QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDef) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualKeepItemDefService.updateQmsMilitaryQualKeepItemDefSensitive(qmsMilitaryQualKeepItemDef));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMilitaryQualKeepItemDef 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsMilitaryQualKeepItemDef") @Validated @RequestBody QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDef) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualKeepItemDefService.updateQmsMilitaryQualKeepItemDef(qmsMilitaryQualKeepItemDef));
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
		responseMsg.setResponseBody(qmsMilitaryQualKeepItemDefService.deleteQmsMilitaryQualKeepItemDefById(id));
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
	@RequiresPermissions("qmsMilitaryQualKeepItemDef:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualKeepItemDefService.deleteQmsMilitaryQualKeepItemDefByIds(ids));
		return responseMsg;
	}

    @GetMapping("/downloadTemplate/v1")
	@ApiOperation(value = "模板下载")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		// 输出
		ExcelUtil.downloadTemplate(response, QmsMilitaryQualKeepItemDefImportDTO.class,"导入模板");
	}

	/**
	 * 导入数据
	 * @param multipartFile 导入文件
	 * @return
	 */
	@PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "导入文件")
	@RequiresPermissions("qmsMilitaryQualKeepItemDef:import")
	public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
		ResponseMsg<Object> responseMsg = new ResponseMsg<>();
		List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsMilitaryQualKeepItemDefImportDTO.class);
		ExcelImportResult excelImportResult = qmsMilitaryQualKeepItemDefService.importData(excelList,formData);
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
	@RequiresPermissions("qmsMilitaryQualKeepItemDef:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualKeepItemDefDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsMilitaryQualKeepItemDefDTO> list = qmsMilitaryQualKeepItemDefService.searchQmsMilitaryQualKeepItemDefForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsMilitaryQualKeepItemDefDTO.class,"导出数据", "sheet1" );
	}
}
