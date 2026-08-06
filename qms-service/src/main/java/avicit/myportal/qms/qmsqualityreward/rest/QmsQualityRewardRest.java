package avicit.myportal.qms.qmsqualityreward.rest;

import avicit.myportal.qms.qmsqualityreward.dto.QmsQualityRewardDTO;
import avicit.myportal.qms.qmsqualityreward.service.QmsQualityRewardService;
import avicit.platform6.api.bpm.dto.ProcessParameter;
import avicit.platform6.api.bpm.eventInterface.CommonRestInstanceDeleteEventListener;
import avicit.platform6.api.system.SysUserDeptPositionClient;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.annotation.RequiresPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.annotation.Logical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-06 17:03
 * @类说明：质量奖励申请表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityReward", description = "质量奖励申请表")
@RequestMapping("/api/myportal/qms/qmsqualityrewards")
    public class QmsQualityRewardRest implements CommonRestInstanceDeleteEventListener{

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityRewardRest.class);

    @Autowired
    private QmsQualityRewardService qmsQualityRewardService;
    @Autowired
    private SysUserDeptPositionClient sysUserDeptPositionClient;


    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityRewardDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询主表数据")
    @RequiresPermissions("qmsQualityReward:view")
    public ResponseMsg<QueryRespBean<QmsQualityRewardDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityRewardDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityRewardDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityRewardDTO> result = qmsQualityRewardService.searchQmsQualityRewardByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<List<QmsQualityRewardDTO>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "按条件不分页查询主表数据")
    public ResponseMsg<List<QmsQualityRewardDTO>> search(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityRewardDTO> queryReqBean) {
        ResponseMsg<List<QmsQualityRewardDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityRewardDTO> result = qmsQualityRewardService.searchQmsQualityReward(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityRewardDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过主键查询主表单条记录")
    @RequiresPermissions("qmsQualityReward:edit")
    public ResponseMsg<QmsQualityRewardDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityRewardDTO> responseMsg = new ResponseMsg<>();
        QmsQualityRewardDTO qmsQualityReward = qmsQualityRewardService.queryQmsQualityRewardByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityReward);
        return responseMsg;
    }


    /**
     * 新增主表对象
     *
     * @param qmsQualityReward 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增主表对象")
    @RequiresPermissions(value={"qmsQualityReward:edit","qmsQualityReward:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityReward") @Validated @RequestBody QmsQualityRewardDTO qmsQualityReward) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isNotEmpty(qmsQualityReward.getId())&&qmsQualityRewardService.queryQmsQualityRewardByPrimaryKey(qmsQualityReward.getId())!= null) {
            responseMsg.setResponseBody(String.valueOf(qmsQualityRewardService.updateQmsQualityReward(qmsQualityReward)));
        }else{
          qmsQualityReward.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsQualityRewardService.insertQmsQualityReward(qmsQualityReward));
        }
        return responseMsg;
    }

    /**
     * 主表新增并启动流程
     *
     * @param processParam 参数对象
     * @return ResponseMsg<StartResultBean>
     */
    @PostMapping("/save-and-start-process/v1")
    @ApiOperation(value = "主表新增并启动流程")
    @RequiresPermissions(value={"qmsQualityReward:edit","qmsQualityReward:add"},logical= Logical.OR)
    public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsQualityRewardDTO> processParam) {
        ResponseMsg<StartResultBean> responseMsg = new ResponseMsg<>();
        String userId = ThreadContextHelper.getUserId();
        String deptId = ThreadContextHelper.getDeptId();
        if(StringUtils.isEmpty(deptId)){
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
        StartResultBean result = qmsQualityRewardService.insertQmsQualityRewardAndStartProcess(processParam.getBean(), parameter);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 修改主表部分对象字段
     *
     * @param qmsQualityReward 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-sensitive/v1")
    @ApiOperation(value = "修改主表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityReward") @RequestBody QmsQualityRewardDTO qmsQualityReward) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardService.updateQmsQualityRewardSensitive(qmsQualityReward));
        return responseMsg;
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsQualityReward 修改对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改主表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsQualityReward") @Validated @RequestBody QmsQualityRewardDTO qmsQualityReward) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardService.updateQmsQualityReward(qmsQualityReward));
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
        responseMsg.setResponseBody(qmsQualityRewardService.deleteQmsQualityRewardById(id));
        return responseMsg;
    }

    /**
     * 主表数据批量删除
     *
     * @param ids 逗号分隔的id串
     * @return ResponseMsg<Integer>
     */
    @DeleteMapping("/delete-by-ids/v1")
    @ApiOperation(value = "主表数据批量删除")
    @RequiresPermissions("qmsQualityReward:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids")  @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardService.deleteQmsQualityRewardByIds(ids));
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
        qmsQualityRewardService.deleteDataQmsQualityRewardById(formId);
        return responseMsg;
    }
}
