package avicit.myportal.qms.qmscommonactionfeedback.rest;

import avicit.platform6.api.bpm.dto.ProcessParameter;
import avicit.platform6.api.bpm.eventInterface.CommonRestInstanceDeleteEventListener;
import avicit.platform6.api.system.SysUserDeptPositionClient;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.myportal.qms.qmscommonactionfeedback.dto.QmsCommonActionFeedbackDTO;
import avicit.myportal.qms.qmscommonactionfeedback.service.QmsCommonActionFeedbackService;
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
 * @创建时间： 2026-08-20 14:10
 * @类说明：通用执行反馈表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsCommonActionFeedback", description = "通用执行反馈表")
@RequestMapping("/api/myportal/qms/qmscommonactionfeedbacks")
public class QmsCommonActionFeedbackRest implements CommonRestInstanceDeleteEventListener {

    private static final Logger logger = LoggerFactory.getLogger(QmsCommonActionFeedbackRest.class);

    @Autowired
    private QmsCommonActionFeedbackService qmsCommonActionFeedbackService;

    @Autowired
    private SysUserDeptPositionClient sysUserDeptPositionClient;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsCommonActionFeedbackDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsCommonActionFeedback:view")
    public ResponseMsg<QueryRespBean<QmsCommonActionFeedbackDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsCommonActionFeedbackDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsCommonActionFeedbackDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsCommonActionFeedbackDTO> result = qmsCommonActionFeedbackService.searchQmsCommonActionFeedbackByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsCommonActionFeedbackDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsCommonActionFeedbackDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsCommonActionFeedbackDTO>> responseMsg = new ResponseMsg<>();
        List<QmsCommonActionFeedbackDTO> result = qmsCommonActionFeedbackService.queryQmsCommonActionFeedbackByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsCommonActionFeedbackDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsCommonActionFeedback:edit")
    public ResponseMsg<QmsCommonActionFeedbackDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsCommonActionFeedbackDTO> responseMsg = new ResponseMsg<>();
        QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO = qmsCommonActionFeedbackService.queryQmsCommonActionFeedbackByPrimaryKey(id);
        responseMsg.setResponseBody(qmsCommonActionFeedbackDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsCommonActionFeedbackDTOList 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsCommonActionFeedbackDTO") @Validated @RequestBody ValidationList<QmsCommonActionFeedbackDTO> qmsCommonActionFeedbackDTOList) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        for(QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTODTO : qmsCommonActionFeedbackDTOList){
            if (StringUtils.isEmpty(qmsCommonActionFeedbackDTODTO.getId())) {
                qmsCommonActionFeedbackDTODTO.setOrgIdentity(ThreadContextHelper.getOrgId());
                responseMsg.setResponseBody(qmsCommonActionFeedbackService.insertQmsCommonActionFeedback(qmsCommonActionFeedbackDTODTO));
            } else {
                responseMsg.setResponseBody(String.valueOf(qmsCommonActionFeedbackService.updateQmsCommonActionFeedback(qmsCommonActionFeedbackDTODTO)));
            }
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
    @RequiresPermissions(value={"qmsCommonActionFeedback:edit","qmsCommonActionFeedback:add"},logical= Logical.OR)
    public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsCommonActionFeedbackDTO> processParam) {
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
        StartResultBean result = qmsCommonActionFeedbackService.insertQmsCommonActionFeedbackAndStartProcess(processParam.getBean(), parameter);
        responseMsg.setResponseBody(result);
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
        qmsCommonActionFeedbackService.deleteDataQmsCommonActionFeedbackById(formId);
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsCommonActionFeedbackDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsCommonActionFeedbackDTO")  @RequestBody QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCommonActionFeedbackService.updateQmsCommonActionFeedbackSensitive(qmsCommonActionFeedbackDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsCommonActionFeedbackDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsCommonActionFeedbackDTO") @Validated @RequestBody QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCommonActionFeedbackService.updateQmsCommonActionFeedback(qmsCommonActionFeedbackDTO));
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
        responseMsg.setResponseBody(qmsCommonActionFeedbackService.deleteQmsCommonActionFeedbackById(id));
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
    @RequiresPermissions("qmsCommonActionFeedback:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsCommonActionFeedbackService.deleteQmsCommonActionFeedbackByIds(ids));
        return responseMsg;
    }
}