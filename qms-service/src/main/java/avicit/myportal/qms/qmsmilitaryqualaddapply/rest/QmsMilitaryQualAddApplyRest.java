package avicit.myportal.qms.qmsmilitaryqualaddapply.rest;

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
import avicit.myportal.qms.qmsmilitaryqualaddapply.dto.QmsMilitaryQualAddApplyDTO;
import avicit.myportal.qms.qmsmilitaryqualaddapply.service.QmsMilitaryQualAddApplyService;
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
 * @创建时间： 2026-08-05 18:07
 * @类说明：军工资质增项申请Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsMilitaryQualAddApply", description = "军工资质增项申请")
@RequestMapping("/api/myportal/qms/qmsmilitaryqualaddapplys")
	public class QmsMilitaryQualAddApplyRest implements CommonRestInstanceDeleteEventListener{

	private static final Logger logger = LoggerFactory.getLogger(QmsMilitaryQualAddApplyRest.class);

	@Autowired
	private QmsMilitaryQualAddApplyService qmsMilitaryQualAddApplyService;

	@Autowired
	private SysUserDeptPositionClient sysUserDeptPositionClient;

	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<QueryRespBean<QmsMilitaryQualAddApplyDTO>>
	 */
	@PostMapping("/search-by-page/v1")
	@ApiOperation(value = "按条件分页查询")
	@RequiresPermissions("qmsMilitaryQualAddApply:view")
	public ResponseMsg<QueryRespBean<QmsMilitaryQualAddApplyDTO>> searchByPage(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean) {
		ResponseMsg<QueryRespBean<QmsMilitaryQualAddApplyDTO>> responseMsg = new ResponseMsg<>();
		QueryRespBean<QmsMilitaryQualAddApplyDTO> result = qmsMilitaryQualAddApplyService.searchQmsMilitaryQualAddApplyByPage(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsMilitaryQualAddApplyDTO>>
	 */
	@PostMapping("/search/v1")
	@ApiOperation(value = "按条件不分页查询")
	public ResponseMsg<List<QmsMilitaryQualAddApplyDTO>> search(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean) {
		ResponseMsg<List<QmsMilitaryQualAddApplyDTO>> responseMsg = new ResponseMsg<>();
		List<QmsMilitaryQualAddApplyDTO> result = qmsMilitaryQualAddApplyService.searchQmsMilitaryQualAddApply(queryReqBean);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return ResponseMsg<QmsMilitaryQualAddApplyDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过主键查询单条记录")
	@RequiresPermissions("qmsMilitaryQualAddApply:edit")
	public ResponseMsg<QmsMilitaryQualAddApplyDTO> get(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsMilitaryQualAddApplyDTO> responseMsg = new ResponseMsg<>();
		QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply = qmsMilitaryQualAddApplyService.queryQmsMilitaryQualAddApplyByPrimaryKey(id);
		responseMsg.setResponseBody(qmsMilitaryQualAddApply);
		return responseMsg;
	}

	/**
	 * 保存对象
	 *
	 * @param qmsMilitaryQualAddApply 保存对象
	 * @return ResponseMsg<String>
	 */
	@PostMapping("/save/v1")
	@ApiOperation(value = "新增对象")
	@RequiresPermissions(value={"qmsMilitaryQualAddApply:edit","qmsMilitaryQualAddApply:add"},logical= Logical.OR)
	public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsMilitaryQualAddApply") @Validated @RequestBody QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		if (StringUtils.isNotEmpty(qmsMilitaryQualAddApply.getId())&&qmsMilitaryQualAddApplyService.queryQmsMilitaryQualAddApplyByPrimaryKey(qmsMilitaryQualAddApply.getId())!= null) {
			responseMsg.setResponseBody(String.valueOf(qmsMilitaryQualAddApplyService.updateQmsMilitaryQualAddApply(qmsMilitaryQualAddApply)));
		}else{
			qmsMilitaryQualAddApply.setOrgIdentity(ThreadContextHelper.getOrgId());
			responseMsg.setResponseBody(qmsMilitaryQualAddApplyService.insertQmsMilitaryQualAddApply(qmsMilitaryQualAddApply));
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
	@RequiresPermissions(value={"qmsMilitaryQualAddApply:edit","qmsMilitaryQualAddApply:add"},logical= Logical.OR)
	public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsMilitaryQualAddApplyDTO> processParam) {
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
		StartResultBean result = qmsMilitaryQualAddApplyService.insertQmsMilitaryQualAddApplyAndStartProcess(processParam.getBean(), parameter);
		responseMsg.setResponseBody(result);
		return responseMsg;
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMilitaryQualAddApply 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-sensitive/v1")
	@ApiOperation(value = "修改部分对象字段")
	public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "修改对象", name = "qmsMilitaryQualAddApply")  @RequestBody QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualAddApplyService.updateQmsMilitaryQualAddApplySensitive(qmsMilitaryQualAddApply));
		return responseMsg;
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMilitaryQualAddApply 修改对象
	 * @return ResponseMsg<Integer>
	 */
	@PutMapping("/update-all/v1")
	@ApiOperation(value = "修改全部对象字段")
	public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsMilitaryQualAddApply") @Validated @RequestBody QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApply) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualAddApplyService.updateQmsMilitaryQualAddApply(qmsMilitaryQualAddApply));
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
		responseMsg.setResponseBody(qmsMilitaryQualAddApplyService.deleteQmsMilitaryQualAddApplyById(id));
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
	@RequiresPermissions("qmsMilitaryQualAddApply:del")
	public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
		ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(qmsMilitaryQualAddApplyService.deleteQmsMilitaryQualAddApplyByIds(ids));
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
        qmsMilitaryQualAddApplyService.deleteDataQmsMilitaryQualAddApplyById(formId);
        return responseMsg;
    }

	/**
	 * 按条件导出所有
	 * @param queryReqBean 查询条件
	 * @return
	 */
	@PostMapping("/exportData/v1")
	@ApiOperation(value = "按条件导出所有")
	@RequiresPermissions("qmsMilitaryQualAddApply:export")
	public void exportData(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsMilitaryQualAddApplyDTO> queryReqBean, HttpServletResponse response) throws IOException {
        List<QmsMilitaryQualAddApplyDTO> list = qmsMilitaryQualAddApplyService.searchQmsMilitaryQualAddApplyForExportExcel(queryReqBean);
		// 输出
		ExcelUtil.exportExcel(response, list, QmsMilitaryQualAddApplyDTO.class,"导出数据", "sheet1" );
	}
}
