package avicit.myportal.qms.qmsqualityproblemdelay.rest;

import avicit.myportal.qms.qmsqualityproblemdelay.dto.QmsQualityProblemDelayDTO;
import avicit.myportal.qms.qmsqualityproblemdelay.service.QmsQualityProblemDelayService;
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
 * @创建时间： 2026-08-05 18:05
 * @类说明：质量问题延期Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityProblemDelay", description = "质量问题延期")
@RequestMapping("/api/myportal/qms/qmsqualityproblemdelays")
    public class QmsQualityProblemDelayRest implements CommonRestInstanceDeleteEventListener{

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityProblemDelayRest.class);

    @Autowired
    private QmsQualityProblemDelayService qmsQualityProblemDelayService;
    @Autowired
    private SysUserDeptPositionClient sysUserDeptPositionClient;


    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityProblemDelayDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询主表数据")
    @RequiresPermissions("qmsQualityProblemDelay:view")
    public ResponseMsg<QueryRespBean<QmsQualityProblemDelayDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityProblemDelayDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityProblemDelayDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityProblemDelayDTO> result = qmsQualityProblemDelayService.searchQmsQualityProblemDelayByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<List<QmsQualityProblemDelayDTO>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "按条件不分页查询主表数据")
    public ResponseMsg<List<QmsQualityProblemDelayDTO>> search(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityProblemDelayDTO> queryReqBean) {
        ResponseMsg<List<QmsQualityProblemDelayDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityProblemDelayDTO> result = qmsQualityProblemDelayService.searchQmsQualityProblemDelay(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityProblemDelayDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过主键查询主表单条记录")
    @RequiresPermissions("qmsQualityProblemDelay:edit")
    public ResponseMsg<QmsQualityProblemDelayDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityProblemDelayDTO> responseMsg = new ResponseMsg<>();
        QmsQualityProblemDelayDTO qmsQualityProblemDelay = qmsQualityProblemDelayService.queryQmsQualityProblemDelayByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityProblemDelay);
        return responseMsg;
    }


    /**
     * 新增主表对象
     *
     * @param qmsQualityProblemDelay 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增主表对象")
    @RequiresPermissions(value={"qmsQualityProblemDelay:edit","qmsQualityProblemDelay:add"},logical= Logical.OR)
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityProblemDelay") @Validated @RequestBody QmsQualityProblemDelayDTO qmsQualityProblemDelay) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        if (StringUtils.isNotEmpty(qmsQualityProblemDelay.getId())&&qmsQualityProblemDelayService.queryQmsQualityProblemDelayByPrimaryKey(qmsQualityProblemDelay.getId())!= null) {
            responseMsg.setResponseBody(String.valueOf(qmsQualityProblemDelayService.updateQmsQualityProblemDelay(qmsQualityProblemDelay)));
        }else{
          qmsQualityProblemDelay.setOrgIdentity(ThreadContextHelper.getOrgId());
            responseMsg.setResponseBody(qmsQualityProblemDelayService.insertQmsQualityProblemDelay(qmsQualityProblemDelay));
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
    @RequiresPermissions(value={"qmsQualityProblemDelay:edit","qmsQualityProblemDelay:add"},logical= Logical.OR)
    public ResponseMsg<StartResultBean> saveAndStartProcess(@ApiParam(value = "参数对象", name = "processParam") @RequestBody ProcessParameter<QmsQualityProblemDelayDTO> processParam) {
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
        StartResultBean result = qmsQualityProblemDelayService.insertQmsQualityProblemDelayAndStartProcess(processParam.getBean(), parameter);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 修改主表部分对象字段
     *
     * @param qmsQualityProblemDelay 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-sensitive/v1")
    @ApiOperation(value = "修改主表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityProblemDelay") @RequestBody QmsQualityProblemDelayDTO qmsQualityProblemDelay) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayService.updateQmsQualityProblemDelaySensitive(qmsQualityProblemDelay));
        return responseMsg;
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsQualityProblemDelay 修改对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改主表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "修改对象", name = "qmsQualityProblemDelay") @Validated @RequestBody QmsQualityProblemDelayDTO qmsQualityProblemDelay) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayService.updateQmsQualityProblemDelay(qmsQualityProblemDelay));
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
        responseMsg.setResponseBody(qmsQualityProblemDelayService.deleteQmsQualityProblemDelayById(id));
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
    @RequiresPermissions("qmsQualityProblemDelay:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids")  @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayService.deleteQmsQualityProblemDelayByIds(ids));
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
        qmsQualityProblemDelayService.deleteDataQmsQualityProblemDelayById(formId);
        return responseMsg;
    }
}
