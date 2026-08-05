package avicit.myportal.qms.qmsncproduct.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.api.bpm.dto.ProcessParameter;
import avicit.platform6.api.system.SysUserDeptPositionClient;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.api.bpm.eventInterface.CommonRestInstanceDeleteEventListener;
import avicit.myportal.qms.qmsncproduct.dto.QmsNcProductDTO;
import avicit.myportal.qms.qmsncproduct.service.QmsNcProductService;
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
 * @创建时间： 2026-08-04 15:06
 * @类说明：QMS_NC_PRODUCTRest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsNcProduct", description = "QMS_NC_PRODUCT")
@RequestMapping("/api/myportal/qms/qmsncproducts")
	public class QmsNcProductRest implements CommonRestInstanceDeleteEventListener{

	private static final Logger logger = LoggerFactory.getLogger(QmsNcProductRest.class);

	@Autowired
	private QmsNcProductService qmsNcProductService;

	@Autowired
	private SysUserDeptPositionClient sysUserDeptPositionClient;

	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsNcProductDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsNcProduct:view")
	public ResponseMsg<QueryRespBean<QmsNcProductDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsNcProductDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsNcProductDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsNcProductDTO> result = qmsNcProductService.searchQmsNcProductByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsNcProductDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsNcProductDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsNcProductDTO> queryReqBean) {
		ResponseMsg<List<QmsNcProductDTO>> responseMsg = new ResponseMsg<>();
		List<QmsNcProductDTO> result = qmsNcProductService.searchQmsNcProduct(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsNcProductDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsNcProduct:edit")
	public ResponseMsg<QmsNcProductDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsNcProductDTO> responseMsg = new ResponseMsg<>();
		QmsNcProductDTO qmsNcProduct = qmsNcProductService.queryQmsNcProductByPrimaryKey(id);
		responseMsg.setResponseBody(qmsNcProduct);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsNcProduct 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsNcProduct:edit","qmsNcProduct:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsNcProduct") @Validated @RequestBody QmsNcProductDTO qmsNcProduct) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isNotEmpty(qmsNcProduct.getId())&&qmsNcProductService.queryQmsNcProductByPrimaryKey(qmsNcProduct.getId())!= null) {
			responseMsg.setResponseBody(String.valueOf(qmsNcProductService.updateQmsNcProduct(qmsNcProduct)));
		}else{
			qmsNcProduct.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsNcProductService.insertQmsNcProduct(qmsNcProduct));
		}
		return responseMsg;
	}

	/**
	 * 新增并启动流程
	 *
	 * @param processParam 参数对象
	 * @return ResponseMsg<StartResultBean>
	 */
	@PostMapping("/save-and-start-process/v1")
	@ApiOperation(value = "新增并启动流程")
	@RequiresPermissions(value={"qmsNcProduct:edit","qmsNcProduct:add"},logical= Logical.OR)
	public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsNcProductDTO> processParam) {
		ResponseMsg<StartResultBean> responseMsg = new ResponseMsg<>();
		String userId = ThreadContextHelper.getUserId();
		String deptId = ThreadContextHelper.getDeptId();
		if (StringUtils.isEmpty(deptId)) {
			deptId = sysUserDeptPositionClient.getChiefDeptIdBySysUserId(ThreadContextHelper.getUserId());
		}
		/* 设置启动流程所需要的参数 */
		Map<String, String> parameter = new HashMap<>();
		parameter.put("processDefId", processParam.getProcessDefId());
		parameter.put("formCode", processParam.getFormCode());
		parameter.put("jsonString", processParam.getJsonString());
		parameter.put("userId", userId);
		parameter.put("deptId", deptId);
		processParam.getBean().setOrgIdentity(ThreadContextHelper.getOrgId());
		StartResultBean result = qmsNcProductService.insertQmsNcProductAndStartProcess(processParam.getBean(), parameter);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsNcProduct 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsNcProduct")  @RequestBody QmsNcProductDTO qmsNcProduct) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsNcProductService.updateQmsNcProductSensitive(qmsNcProduct));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsNcProduct 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsNcProduct") @Validated @RequestBody QmsNcProductDTO qmsNcProduct) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsNcProductService.updateQmsNcProduct(qmsNcProduct));
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
		responseMsg.setResponseBody(qmsNcProductService.deleteQmsNcProductById(id));
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
	@RequiresPermissions("qmsNcProduct:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsNcProductService.deleteQmsNcProductByIds(ids));
		return responseMsg;
	}

    /**
     * 流程实例删除回调方法（按主键单条删除业务数据）
     *
     * @param arg 流程变量集合
     * @return ResponseMsg<Void>
     */
    @Override
    @PostMapping("/notify/v1")
    @ApiOperation(value = "流程实例删除回调方法（按主键单条删除业务数据）")
    public ResponseMsg<Void> notify(@ApiParam(value = "流程变量集合", name = "arg") @RequestBody Map<String, String> arg) {
        ResponseMsg<Void> responseMsg = new ResponseMsg();
        String formId = arg.get("formId");
        qmsNcProductService.deleteDataQmsNcProductById(formId);
        return responseMsg;
    }

	/**
	 * 按条件导出所有
	 * @param queryReqBean 查询条件
	 * @return
	 */
	@PostMapping("/exportData/v1")
	@ApiOperation(value = "按条件导出所有")
	@RequiresPermissions("qmsNcProduct:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsNcProductDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsNcProductDTO> list = qmsNcProductService.searchQmsNcProductForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsNcProductDTO.class,"导出数据", "sheet1" );
	}
}
