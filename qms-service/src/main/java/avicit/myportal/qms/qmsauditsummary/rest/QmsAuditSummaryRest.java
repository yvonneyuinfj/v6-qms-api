package avicit.myportal.qms.qmsauditsummary.rest;

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
import avicit.myportal.qms.qmsauditsummary.dto.QmsAuditSummaryDTO;
import avicit.myportal.qms.qmsauditsummary.service.QmsAuditSummaryService;
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
 * @创建时间： 2026-08-03 19:33
 * @类说明：内审综述表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsAuditSummary", description = "内审综述表")
@RequestMapping("/api/myportal/qms/qmsauditsummarys")
	public class QmsAuditSummaryRest implements CommonRestInstanceDeleteEventListener{

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditSummaryRest.class);

	@Autowired
	private QmsAuditSummaryService qmsAuditSummaryService;

	@Autowired
	private SysUserDeptPositionClient sysUserDeptPositionClient;

	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsAuditSummaryDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsAuditSummary:view")
	public ResponseMsg<QueryRespBean<QmsAuditSummaryDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsAuditSummaryDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsAuditSummaryDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsAuditSummaryDTO> result = qmsAuditSummaryService.searchQmsAuditSummaryByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsAuditSummaryDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsAuditSummaryDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsAuditSummaryDTO> queryReqBean) {
		ResponseMsg<List<QmsAuditSummaryDTO>> responseMsg = new ResponseMsg<>();
		List<QmsAuditSummaryDTO> result = qmsAuditSummaryService.searchQmsAuditSummary(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsAuditSummaryDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsAuditSummary:edit")
	public ResponseMsg<QmsAuditSummaryDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsAuditSummaryDTO> responseMsg = new ResponseMsg<>();
		QmsAuditSummaryDTO qmsAuditSummary = qmsAuditSummaryService.queryQmsAuditSummaryByPrimaryKey(id);
		responseMsg.setResponseBody(qmsAuditSummary);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsAuditSummary 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsAuditSummary:edit","qmsAuditSummary:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsAuditSummary") @Validated @RequestBody QmsAuditSummaryDTO qmsAuditSummary) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isNotEmpty(qmsAuditSummary.getId())&&qmsAuditSummaryService.queryQmsAuditSummaryByPrimaryKey(qmsAuditSummary.getId())!= null) {
			responseMsg.setResponseBody(String.valueOf(qmsAuditSummaryService.updateQmsAuditSummary(qmsAuditSummary)));
		}else{
			qmsAuditSummary.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsAuditSummaryService.insertQmsAuditSummary(qmsAuditSummary));
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
	@RequiresPermissions(value={"qmsAuditSummary:edit","qmsAuditSummary:add"},logical= Logical.OR)
	public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsAuditSummaryDTO> processParam) {
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
		StartResultBean result = qmsAuditSummaryService.insertQmsAuditSummaryAndStartProcess(processParam.getBean(), parameter);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsAuditSummary 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsAuditSummary")  @RequestBody QmsAuditSummaryDTO qmsAuditSummary) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsAuditSummaryService.updateQmsAuditSummarySensitive(qmsAuditSummary));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsAuditSummary 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsAuditSummary") @Validated @RequestBody QmsAuditSummaryDTO qmsAuditSummary) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsAuditSummaryService.updateQmsAuditSummary(qmsAuditSummary));
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
		responseMsg.setResponseBody(qmsAuditSummaryService.deleteQmsAuditSummaryById(id));
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
	@RequiresPermissions("qmsAuditSummary:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsAuditSummaryService.deleteQmsAuditSummaryByIds(ids));
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
        qmsAuditSummaryService.deleteDataQmsAuditSummaryById(formId);
        return responseMsg;
    }

	/**
	 * 按条件导出所有
	 * @param queryReqBean 查询条件
	 * @return
	 */
	@PostMapping("/exportData/v1")
	@ApiOperation(value = "按条件导出所有")
	@RequiresPermissions("qmsAuditSummary:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsAuditSummaryDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsAuditSummaryDTO> list = qmsAuditSummaryService.searchQmsAuditSummaryForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsAuditSummaryDTO.class,"导出数据", "sheet1" );
	}
}
