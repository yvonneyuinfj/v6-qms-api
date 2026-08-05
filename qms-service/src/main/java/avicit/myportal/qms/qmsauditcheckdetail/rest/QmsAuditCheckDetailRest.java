package avicit.myportal.qms.qmsauditcheckdetail.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.myportal.qms.qmsauditcheckdetail.dto.QmsAuditCheckDetailDTO;
import avicit.myportal.qms.qmsauditcheckdetail.service.QmsAuditCheckDetailService;
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
 * @创建时间： 2026-08-03 19:32
 * @类说明：审核检查明细表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsAuditCheckDetail", description = "审核检查明细表")
@RequestMapping("/api/myportal/qms/qmsauditcheckdetails")
public class QmsAuditCheckDetailRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsAuditCheckDetailRest.class);

    @Autowired
    private QmsAuditCheckDetailService qmsAuditCheckDetailService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsAuditCheckDetailDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsAuditCheckDetail:view")
    public ResponseMsg<QueryRespBean<QmsAuditCheckDetailDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsAuditCheckDetailDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsAuditCheckDetailDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsAuditCheckDetailDTO> result = qmsAuditCheckDetailService.searchQmsAuditCheckDetailByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsAuditCheckDetailDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsAuditCheckDetailDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsAuditCheckDetailDTO>> responseMsg = new ResponseMsg<>();
        List<QmsAuditCheckDetailDTO> result = qmsAuditCheckDetailService.queryQmsAuditCheckDetailByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsAuditCheckDetailDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsAuditCheckDetail:edit")
    public ResponseMsg<QmsAuditCheckDetailDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsAuditCheckDetailDTO> responseMsg = new ResponseMsg<>();
        QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO = qmsAuditCheckDetailService.queryQmsAuditCheckDetailByPrimaryKey(id);
        responseMsg.setResponseBody(qmsAuditCheckDetailDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsAuditCheckDetailDTOList 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsAuditCheckDetailDTO") @Validated @RequestBody ValidationList<QmsAuditCheckDetailDTO> qmsAuditCheckDetailDTOList) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        for(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTODTO : qmsAuditCheckDetailDTOList){
            if (StringUtils.isEmpty(qmsAuditCheckDetailDTODTO.getId())) {
                qmsAuditCheckDetailDTODTO.setOrgIdentity(ThreadContextHelper.getOrgId());
                responseMsg.setResponseBody(qmsAuditCheckDetailService.insertQmsAuditCheckDetail(qmsAuditCheckDetailDTODTO));
            } else {
                responseMsg.setResponseBody(String.valueOf(qmsAuditCheckDetailService.updateQmsAuditCheckDetail(qmsAuditCheckDetailDTODTO)));
            }
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsAuditCheckDetailDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsAuditCheckDetailDTO")  @RequestBody QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsAuditCheckDetailService.updateQmsAuditCheckDetailSensitive(qmsAuditCheckDetailDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsAuditCheckDetailDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsAuditCheckDetailDTO") @Validated @RequestBody QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsAuditCheckDetailService.updateQmsAuditCheckDetail(qmsAuditCheckDetailDTO));
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
        responseMsg.setResponseBody(qmsAuditCheckDetailService.deleteQmsAuditCheckDetailById(id));
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
    @RequiresPermissions("qmsAuditCheckDetail:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsAuditCheckDetailService.deleteQmsAuditCheckDetailByIds(ids));
        return responseMsg;
    }
}