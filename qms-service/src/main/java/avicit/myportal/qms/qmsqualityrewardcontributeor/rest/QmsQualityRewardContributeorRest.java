package avicit.myportal.qms.qmsqualityrewardcontributeor.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.domain.ValidationList;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;
import avicit.myportal.qms.qmsqualityrewardcontributeor.dto.QmsQualityRewardContributeorDTO;
import avicit.myportal.qms.qmsqualityrewardcontributeor.service.QmsQualityRewardContributeorService;
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
 * @创建时间： 2026-08-06 17:03
 * @类说明：参与人员贡献表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityRewardContributeor", description = "参与人员贡献表")
@RequestMapping("/api/myportal/qms/qmsqualityrewardcontributeors")
public class QmsQualityRewardContributeorRest {

    private static final Logger logger = LoggerFactory.getLogger(QmsQualityRewardContributeorRest.class);

    @Autowired
    private QmsQualityRewardContributeorService qmsQualityRewardContributeorService;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return ResponseMsg<QueryRespBean<QmsQualityRewardContributeorDTO>>
     */
    @PostMapping("/search-by-page/v1")
    @ApiOperation(value = "按条件分页查询子表数据")
    @RequiresPermissions("qmsQualityRewardContributeor:view")
    public ResponseMsg<QueryRespBean<QmsQualityRewardContributeorDTO>> searchByPage(@ApiParam(value = "分页", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityRewardContributeorDTO> queryReqBean) {
        ResponseMsg<QueryRespBean<QmsQualityRewardContributeorDTO>> responseMsg = new ResponseMsg<>();
        QueryRespBean<QmsQualityRewardContributeorDTO> result = qmsQualityRewardContributeorService.searchQmsQualityRewardContributeorByPage(queryReqBean);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过主表主键查询子表数据
     *
     * @param pid 父id
     * @return ResponseMsg<List<QmsQualityRewardContributeorDTO>>
     */
    @GetMapping("/get-by-pid/{pid}/v1")
    @ApiOperation(value = "通过主表主键查询子表数据")
    public ResponseMsg<List<QmsQualityRewardContributeorDTO>> getByPid(@ApiParam(value = "父id", name = "pid") @PathVariable("pid") String pid) {
        ResponseMsg<List<QmsQualityRewardContributeorDTO>> responseMsg = new ResponseMsg<>();
        List<QmsQualityRewardContributeorDTO> result = qmsQualityRewardContributeorService.queryQmsQualityRewardContributeorByPid(pid);
        responseMsg.setResponseBody(result);
        return responseMsg;
    }

    /**
     * 通过子表主键查询数据
     *
     * @param id 主键id
     * @return ResponseMsg<QmsQualityRewardContributeorDTO>
     */
    @GetMapping("/get/{id}/v1")
    @ApiOperation(value = "通过子表主键查询数据")
    @RequiresPermissions("qmsQualityRewardContributeor:edit")
    public ResponseMsg<QmsQualityRewardContributeorDTO> getById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<QmsQualityRewardContributeorDTO> responseMsg = new ResponseMsg<>();
        QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO = qmsQualityRewardContributeorService.queryQmsQualityRewardContributeorByPrimaryKey(id);
        responseMsg.setResponseBody(qmsQualityRewardContributeorDTO);
        return responseMsg;
    }

    /**
     * 新增/编辑子表对象
     *
     * @param qmsQualityRewardContributeorDTOList 保存对象
     * @return ResponseMsg<String>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增/编辑子表对象")
    public ResponseMsg<String> save(@ApiParam(value = "保存对象", name = "qmsQualityRewardContributeorDTO") @Validated @RequestBody ValidationList<QmsQualityRewardContributeorDTO> qmsQualityRewardContributeorDTOList) {
        ResponseMsg<String> responseMsg = new ResponseMsg<>();
        for(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTODTO : qmsQualityRewardContributeorDTOList){
            if (StringUtils.isEmpty(qmsQualityRewardContributeorDTODTO.getId())) {
                qmsQualityRewardContributeorDTODTO.setOrgIdentity(ThreadContextHelper.getOrgId());
                responseMsg.setResponseBody(qmsQualityRewardContributeorService.insertQmsQualityRewardContributeor(qmsQualityRewardContributeorDTODTO));
            } else {
                responseMsg.setResponseBody(String.valueOf(qmsQualityRewardContributeorService.updateQmsQualityRewardContributeor(qmsQualityRewardContributeorDTODTO)));
            }
        }
        return responseMsg;
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsQualityRewardContributeorDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update/v1")
    @ApiOperation(value = "修改子表部分对象字段")
    public ResponseMsg<Integer> updateSensitive(@ApiParam(value = "更新对象", name = "qmsQualityRewardContributeorDTO")  @RequestBody QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardContributeorService.updateQmsQualityRewardContributeorSensitive(qmsQualityRewardContributeorDTO));
        return responseMsg;
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsQualityRewardContributeorDTO 更新对象
     * @return ResponseMsg<Integer>
     */
    @PutMapping("/update-all/v1")
    @ApiOperation(value = "修改子表全部对象字段")
    public ResponseMsg<Integer> updateAll(@ApiParam(value = "更新对象", name = "qmsQualityRewardContributeorDTO") @Validated @RequestBody QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardContributeorService.updateQmsQualityRewardContributeor(qmsQualityRewardContributeorDTO));
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
        responseMsg.setResponseBody(qmsQualityRewardContributeorService.deleteQmsQualityRewardContributeorById(id));
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
    @RequiresPermissions("qmsQualityRewardContributeor:del")
    public ResponseMsg<Integer> deleteByIds(@ApiParam(value = "id数组", name = "ids") @RequestBody String[] ids) {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityRewardContributeorService.deleteQmsQualityRewardContributeorByIds(ids));
        return responseMsg;
    }
}