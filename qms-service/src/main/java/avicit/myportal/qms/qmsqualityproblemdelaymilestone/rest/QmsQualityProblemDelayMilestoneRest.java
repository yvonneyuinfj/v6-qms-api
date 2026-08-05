package avicit.myportal.qms.qmsqualityproblemdelaymilestone.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dto.QmsQualityProblemDelayMilestoneDTO;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.service.QmsQualityProblemDelayMilestoneService;
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
 * @创建时间： 2026-08-05 18:05
 * @类说明：里程碑明细表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityProblemDelayMilestone", description = "里程碑明细表")
@RequestMapping("/api/myportal/qms/qmsqualityproblemdelaymilestones")
public class QmsQualityProblemDelayMilestoneRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityProblemDelayMilestoneRest.class);

    @Autowired
    private QmsQualityProblemDelayMilestoneService qmsQualityProblemDelayMilestoneService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityProblemDelayMilestoneDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsQualityProblemDelayMilestone:view")
    public ResponseMsg<QueryRespBean<QmsQualityProblemDelayMilestoneDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityProblemDelayMilestoneDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityProblemDelayMilestoneDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityProblemDelayMilestoneDTO> result = qmsQualityProblemDelayMilestoneService.searchQmsQualityProblemDelayMilestoneByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsQualityProblemDelayMilestoneDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsQualityProblemDelayMilestoneDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsQualityProblemDelayMilestoneDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityProblemDelayMilestoneDTO> result = qmsQualityProblemDelayMilestoneService.queryQmsQualityProblemDelayMilestoneByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityProblemDelayMilestoneDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsQualityProblemDelayMilestone:edit")
    public ResponseMsg<QmsQualityProblemDelayMilestoneDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityProblemDelayMilestoneDTO> responseMsg = new ResponseMsg<>();
        QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO = qmsQualityProblemDelayMilestoneService.queryQmsQualityProblemDelayMilestoneByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsQualityProblemDelayMilestoneDTOList 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityProblemDelayMilestoneDTO") @Validated @RequestBody ValidationList<QmsQualityProblemDelayMilestoneDTO> qmsQualityProblemDelayMilestoneDTOList) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        for(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTODTO : qmsQualityProblemDelayMilestoneDTOList){
            if (StringUtils.isEmpty(qmsQualityProblemDelayMilestoneDTODTO.getId())) {
                qmsQualityProblemDelayMilestoneDTODTO.setOrgIdentity(ThreadContextHelper.getOrgId());
                responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneService.insertQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTODTO));
            } else {
                responseMsg.setResponseBody(String.valueOf(qmsQualityProblemDelayMilestoneService.updateQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTODTO)));
            }
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsQualityProblemDelayMilestoneDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityProblemDelayMilestoneDTO")  @RequestBody QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneService.updateQmsQualityProblemDelayMilestoneSensitive(qmsQualityProblemDelayMilestoneDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsQualityProblemDelayMilestoneDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsQualityProblemDelayMilestoneDTO") @Validated @RequestBody QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneService.updateQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTO));
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
        responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneService.deleteQmsQualityProblemDelayMilestoneById(id));
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
    @RequiresPermissions("qmsQualityProblemDelayMilestone:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityProblemDelayMilestoneService.deleteQmsQualityProblemDelayMilestoneByIds(ids));
        return responseMsg;
    }
}