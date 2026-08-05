package avicit.myportal.qms.qmsmrinputitem.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.myportal.qms.qmsmrinputitem.dto.QmsMrInputItemDTO;
import avicit.myportal.qms.qmsmrinputitem.dto.QmsMrInputItemImportDTO;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import avicit.myportal.qms.qmsmrinputitem.service.QmsMrInputItemService;
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
 * @创建时间： 2026-08-03 19:43
 * @类说明：管评输入材料分工台账Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsMrInputItem", description = "管评输入材料分工台账")
@RequestMapping("/api/myportal/qms/qmsmrinputitems")
	public class QmsMrInputItemRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsMrInputItemRest.class);

	@Autowired
	private QmsMrInputItemService qmsMrInputItemService;


	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsMrInputItemDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsMrInputItem:view")
	public ResponseMsg<QueryRespBean<QmsMrInputItemDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrInputItemDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsMrInputItemDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsMrInputItemDTO> result = qmsMrInputItemService.searchQmsMrInputItemByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsMrInputItemDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsMrInputItemDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrInputItemDTO> queryReqBean) {
		ResponseMsg<List<QmsMrInputItemDTO>> responseMsg = new ResponseMsg<>();
		List<QmsMrInputItemDTO> result = qmsMrInputItemService.searchQmsMrInputItem(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsMrInputItemDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsMrInputItem:edit")
	public ResponseMsg<QmsMrInputItemDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsMrInputItemDTO> responseMsg = new ResponseMsg<>();
		QmsMrInputItemDTO qmsMrInputItem = qmsMrInputItemService.queryQmsMrInputItemByPrimaryKey(id);
		responseMsg.setResponseBody(qmsMrInputItem);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsMrInputItem 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsMrInputItem:edit","qmsMrInputItem:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsMrInputItem") @Validated @RequestBody QmsMrInputItemDTO qmsMrInputItem) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isEmpty(qmsMrInputItem.getId())) {
			qmsMrInputItem.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsMrInputItemService.insertQmsMrInputItem(qmsMrInputItem));
		}else{
			responseMsg.setResponseBody(String.valueOf(qmsMrInputItemService.updateQmsMrInputItem(qmsMrInputItem)));
		}
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMrInputItem 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsMrInputItem")  @RequestBody QmsMrInputItemDTO qmsMrInputItem) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrInputItemService.updateQmsMrInputItemSensitive(qmsMrInputItem));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMrInputItem 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsMrInputItem") @Validated @RequestBody QmsMrInputItemDTO qmsMrInputItem) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrInputItemService.updateQmsMrInputItem(qmsMrInputItem));
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
		responseMsg.setResponseBody(qmsMrInputItemService.deleteQmsMrInputItemById(id));
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
	@RequiresPermissions("qmsMrInputItem:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMrInputItemService.deleteQmsMrInputItemByIds(ids));
		return responseMsg;
	}

    @GetMapping("/downloadTemplate/v1")
	@ApiOperation(value = "模板下载")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		// 输出
		ExcelUtil.downloadTemplate(response, QmsMrInputItemImportDTO.class,"导入模板");
	}

	/**
	 * 导入数据
	 * @param multipartFile 导入文件
	 * @return
	 */
	@PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "导入文件")
	@RequiresPermissions("qmsMrInputItem:import")
	public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
		ResponseMsg<Object> responseMsg = new ResponseMsg<>();
		List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsMrInputItemImportDTO.class);
		ExcelImportResult excelImportResult = qmsMrInputItemService.importData(excelList,formData);
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
	@RequiresPermissions("qmsMrInputItem:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMrInputItemDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsMrInputItemDTO> list = qmsMrInputItemService.searchQmsMrInputItemForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsMrInputItemDTO.class,"导出数据", "sheet1" );
	}
}
