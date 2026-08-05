package avicit.myportal.qms.qmsmilitaryqualification.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.myportal.qms.qmsmilitaryqualification.dto.QmsMilitaryQualificationDTO;
import avicit.myportal.qms.qmsmilitaryqualification.dto.QmsMilitaryQualificationImportDTO;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import avicit.myportal.qms.qmsmilitaryqualification.service.QmsMilitaryQualificationService;
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
 * @创建时间： 2026-08-05 18:06
 * @类说明：军工资质基本信息Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsMilitaryQualification", description = "军工资质基本信息")
@RequestMapping("/api/myportal/qms/qmsmilitaryqualifications")
	public class QmsMilitaryQualificationRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualificationRest.class);

	@Autowired
	private QmsMilitaryQualificationService qmsMilitaryQualificationService;


	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsMilitaryQualificationDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsMilitaryQualification:view")
	public ResponseMsg<QueryRespBean<QmsMilitaryQualificationDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsMilitaryQualificationDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsMilitaryQualificationDTO> result = qmsMilitaryQualificationService.searchQmsMilitaryQualificationByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsMilitaryQualificationDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsMilitaryQualificationDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean) {
		ResponseMsg<List<QmsMilitaryQualificationDTO>> responseMsg = new ResponseMsg<>();
		List<QmsMilitaryQualificationDTO> result = qmsMilitaryQualificationService.searchQmsMilitaryQualification(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsMilitaryQualificationDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsMilitaryQualification:edit")
	public ResponseMsg<QmsMilitaryQualificationDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsMilitaryQualificationDTO> responseMsg = new ResponseMsg<>();
		QmsMilitaryQualificationDTO qmsMilitaryQualification = qmsMilitaryQualificationService.queryQmsMilitaryQualificationByPrimaryKey(id);
		responseMsg.setResponseBody(qmsMilitaryQualification);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsMilitaryQualification 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsMilitaryQualification:edit","qmsMilitaryQualification:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsMilitaryQualification") @Validated @RequestBody QmsMilitaryQualificationDTO qmsMilitaryQualification) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isEmpty(qmsMilitaryQualification.getId())) {
			qmsMilitaryQualification.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsMilitaryQualificationService.insertQmsMilitaryQualification(qmsMilitaryQualification));
		}else{
			responseMsg.setResponseBody(String.valueOf(qmsMilitaryQualificationService.updateQmsMilitaryQualification(qmsMilitaryQualification)));
		}
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMilitaryQualification 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsMilitaryQualification")  @RequestBody QmsMilitaryQualificationDTO qmsMilitaryQualification) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualificationService.updateQmsMilitaryQualificationSensitive(qmsMilitaryQualification));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMilitaryQualification 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsMilitaryQualification") @Validated @RequestBody QmsMilitaryQualificationDTO qmsMilitaryQualification) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualificationService.updateQmsMilitaryQualification(qmsMilitaryQualification));
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
		responseMsg.setResponseBody(qmsMilitaryQualificationService.deleteQmsMilitaryQualificationById(id));
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
	@RequiresPermissions("qmsMilitaryQualification:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualificationService.deleteQmsMilitaryQualificationByIds(ids));
		return responseMsg;
	}

    @GetMapping("/downloadTemplate/v1")
	@ApiOperation(value = "模板下载")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		// 输出
		ExcelUtil.downloadTemplate(response, QmsMilitaryQualificationImportDTO.class,"导入模板");
	}

	/**
	 * 导入数据
	 * @param multipartFile 导入文件
	 * @return
	 */
	@PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "导入文件")
	@RequiresPermissions("qmsMilitaryQualification:import")
	public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile,@RequestParam("formData") String formData) throws Exception {
		ResponseMsg<Object> responseMsg = new ResponseMsg<>();
		List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsMilitaryQualificationImportDTO.class);
		ExcelImportResult excelImportResult = qmsMilitaryQualificationService.importData(excelList,formData);
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
	@RequiresPermissions("qmsMilitaryQualification:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualificationDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsMilitaryQualificationDTO> list = qmsMilitaryQualificationService.searchQmsMilitaryQualificationForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsMilitaryQualificationDTO.class,"导出数据", "sheet1" );
	}
}
