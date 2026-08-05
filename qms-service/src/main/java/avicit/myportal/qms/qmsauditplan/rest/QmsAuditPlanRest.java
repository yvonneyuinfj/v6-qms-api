package avicit.myportal.qms.qmsauditplan.rest;

import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.core.domain.VueNode;
import avicit.platform6.commons.utils.JsonHelper;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.core.annotation.RequiresPermissions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.Logical;
import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanDTO;
import avicit.myportal.qms.qmsauditplan.service.QmsAuditPlanService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:28
 * @类说明：年度内审计划及执行主表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsAuditPlan", description = "年度内审计划及执行主表")
@RequestMapping("/api/myportal/qms/qmsauditplans")
public class QmsAuditPlanRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsAuditPlanRest.class);

	@Autowired
	private QmsAuditPlanService qmsAuditPlanService;

    /**
     * 加载TreeGrid
     * @param level 树的等级
     * @param id    父节点ID
     * @return ResponseMsg<List<QmsAuditPlanDTO>>
     */
    @GetMapping("/get-treegrid/{level}/{id}/v1")
    @ApiOperation(value = "加载TreeGrid")
    @RequiresPermissions("qmsAuditPlan:view")
    public ResponseMsg<List<QmsAuditPlanDTO>> getTreeGrid(@ApiParam(value = "展开的TreeGrid的层级", name = "level") @PathVariable("level") int level, @ApiParam(value = "父节点ID", name = "id") @PathVariable("id") String id) {
        ResponseMsg<List<QmsAuditPlanDTO>> responseMsg = new ResponseMsg<>();
        if (id == null) {
            id = "-1";
        }
        if (level == 0) {
            level = 1;
        }
        String orgIdentity = ThreadContextHelper.getOrgId();
        List<QmsAuditPlanDTO> list = qmsAuditPlanService.getQmsAuditPlanTreeGridByParentId(id, level, orgIdentity);
        responseMsg.setResponseBody(list);
        return responseMsg;
    }

    /**
     * 加载树
     * @param level 树的等级
     * @param id    父节点ID
     * @return ResponseMsg<List<VueNode>>
     */
    @GetMapping("/get-tree/{level}/{id}/v1")
    @ApiOperation(value = "加载树")
    public ResponseMsg<List<VueNode>> getTree(@ApiParam(value = "展开的树的层级", name = "level") @PathVariable("level") int level, @ApiParam(value = "父节点ID", name = "id") @PathVariable("id") String id) {
        ResponseMsg<List<VueNode>> responseMsg = new ResponseMsg<>();
        if (id == null) {
            id = "-1";
        }
        if (level == 0) {
            level = 1;
        }
        responseMsg.setResponseBody(qmsAuditPlanService.getQmsAuditPlanByParentIdForTreeSelect(id, level, ThreadContextHelper.getOrgId()));
        return responseMsg;
    }

    /**
     * 展开至指定节点
     * @param id 主键id
     * @return ResponseMsg<List<QmsAuditPlanDTO>>
     */
    @GetMapping("/expandTree/{id}/v1")
    @ApiOperation(value = "展开至指定节点")
    public ResponseMsg<List<QmsAuditPlanDTO>> expandTree(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<List<QmsAuditPlanDTO>> responseMsg = new ResponseMsg<>();
        String orgIdentity = ThreadContextHelper.getOrgId();
        List<QmsAuditPlanDTO> list = qmsAuditPlanService.expandTreeToNode(id, orgIdentity);
        responseMsg.setResponseBody(list);
        return responseMsg;
    }

	/**
	 * 查询TreeGrid节点
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsAuditPlanDTO>>
	 */
	@PostMapping("/search-treegrid/v1")
	@ApiOperation(value = "查询TreeGrid节点")
	public ResponseMsg<List<QmsAuditPlanDTO>> searchQmsAuditPlanTreeGrid(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsAuditPlanDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditPlanDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditPlanDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        String orgIdentity = ThreadContextHelper.getOrgId();
		List<QmsAuditPlanDTO> list = qmsAuditPlanService.searchQmsAuditPlanTreeGrid(queryReqBean, orgIdentity);
        ResponseMsg<List<QmsAuditPlanDTO>> responseMsg = new ResponseMsg<>();
		responseMsg.setResponseBody(list);
		return responseMsg;
	}

    /**
     * 查询树节点
     * @param paramMap 查询条件
     * @return ResponseMsg<List<VueNode>>
     */
    @PostMapping("/search/v1")
    @ApiOperation(value = "查询树节点")
    public ResponseMsg<List<VueNode>> searchQmsAuditPlan(@ApiParam(value = "查询条件", name = "paramMap") @RequestBody Map<String, String> paramMap) {
        String searchText = paramMap.get("searchText");
        List<VueNode> res = qmsAuditPlanService.searchQmsAuditPlan(searchText, ThreadContextHelper.getOrgId());
        ResponseMsg<List<VueNode>> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(res);
        return responseMsg;
    }

    /**
     * 初始化根节点  如果需要修改根节点数据通过前台页面设置
     * @return ResponseMsg<String>
     */
    @PostMapping("/insert-root/v1")
    @ApiOperation(value = "初始化根节点  如果需要修改根节点数据通过前台页面设置")
	public ResponseMsg<String> insertRoot() {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		QmsAuditPlanDTO tree = new QmsAuditPlanDTO();
		tree.setParentId("-1");
		tree.setOrgIdentity(ThreadContextHelper.getOrgId());
		tree.setPlanName("根节点");
        tree.setSecretLevel("1");
        tree.setTreePath("-1");
        tree.setTreeSort(1L);
		responseMsg.setResponseBody(qmsAuditPlanService.insertQmsAuditPlanTree(tree));
		return responseMsg;
	}

	/**
	 * 通过主键获取单条记录
	 * @param id 主键id
	 * @return ResponseMsg<QmsAuditPlanDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过树主键获取单条记录")
    @RequiresPermissions("qmsAuditPlan:edit")
	public ResponseMsg<QmsAuditPlanDTO> getQmsAuditPlanDtoById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsAuditPlanDTO> responseMsg = new ResponseMsg<>();
		QmsAuditPlanDTO dto = qmsAuditPlanService.getQmsAuditPlanDtoById(id);
        responseMsg.setResponseBody(dto);
		return responseMsg;
	}


    /**
     * 新增树对象
     * @param dto 插入对象
     * @return ResponseMsg<QmsAuditPlanDTO>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增树对象")
    @RequiresPermissions(value={"qmsAuditPlan:edit","qmsAuditPlan:add"},logical= Logical.OR)
    public ResponseMsg<QmsAuditPlanDTO> save(@ApiParam(value = "插入对象", name = "dto") @RequestBody QmsAuditPlanDTO dto) {
        ResponseMsg<QmsAuditPlanDTO> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(dto.getId())) {
            dto.setOrgIdentity(ThreadContextHelper.getOrgId());
            qmsAuditPlanService.insertQmsAuditPlanTree(dto);
        } else {
			qmsAuditPlanService.updateQmsAuditPlanTree(dto);
        }
        responseMsg.setResponseBody(dto);
        return responseMsg;
    }

    /**
     * 按树主键单条删除
     * @param id 主键id
     * @return ResponseMsg<Integer>
     */
    @DeleteMapping("/delete-by-id/{id}/v1")
    @ApiOperation(value = "按树主键单条删除")
    @RequiresPermissions("qmsAuditPlan:del")
    public ResponseMsg<Integer> deleteById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) throws Exception {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsAuditPlanService.deleteQmsAuditPlanTreeById(id));
        return responseMsg;
    }

    /**
     * 获取新的treeSort值
     * @param id 父节点ID
     * @return ResponseMsg<QmsAuditPlanDTO>
     */
    @GetMapping("/get-new-tree-sort/{id}/v1")
    @ApiOperation(value = "获取新的treeSort值")
    public ResponseMsg<Long> getNewTreeSortById(@ApiParam(value = "父节点ID", name = "id") @PathVariable String id) {
        ResponseMsg<Long> responseMsg = new ResponseMsg<>();
        Long newTreeSort = qmsAuditPlanService.getNewTreeSortByParentId(id);
        responseMsg.setResponseBody(newTreeSort);
        return responseMsg;
    }
}
