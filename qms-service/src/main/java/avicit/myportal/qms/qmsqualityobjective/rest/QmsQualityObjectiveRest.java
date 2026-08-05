package avicit.myportal.qms.qmsqualityobjective.rest;

import avicit.myportal.qms.qmsmrinputitem.dto.QmsMrInputItemImportDTO;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveImportDTO;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.Logical;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveDTO;
import avicit.myportal.qms.qmsqualityobjective.service.QmsQualityObjectiveService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:10
 * @类说明：质量目标台账表Rest
 * @修改记录：
 */
@RestController
@Api(tags = "qmsQualityObjective", description = "质量目标台账表")
@RequestMapping("/api/myportal/qms/qmsqualityobjectives")
public class QmsQualityObjectiveRest {

	private static final Logger logger = LoggerFactory.getLogger(QmsQualityObjectiveRest.class);

	@Autowired
	private QmsQualityObjectiveService qmsQualityObjectiveService;

    /**
     * 加载TreeGrid
     * @param level 树的等级
     * @param id    父节点ID
     * @return ResponseMsg<List<QmsQualityObjectiveDTO>>
     */
    @GetMapping("/get-treegrid/{level}/{id}/v1")
    @ApiOperation(value = "加载TreeGrid")
    @RequiresPermissions("qmsQualityObjective:view")
    public ResponseMsg<List<QmsQualityObjectiveDTO>> getTreeGrid(@ApiParam(value = "展开的TreeGrid的层级", name = "level") @PathVariable("level") int level, @ApiParam(value = "父节点ID", name = "id") @PathVariable("id") String id) {
        ResponseMsg<List<QmsQualityObjectiveDTO>> responseMsg = new ResponseMsg<>();
        if (id == null) {
            id = "-1";
        }
        if (level == 0) {
            level = 1;
        }
        String orgIdentity = ThreadContextHelper.getOrgId();
        List<QmsQualityObjectiveDTO> list = qmsQualityObjectiveService.getQmsQualityObjectiveTreeGridByParentId(id, level, orgIdentity);
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
        responseMsg.setResponseBody(qmsQualityObjectiveService.getQmsQualityObjectiveByParentIdForTreeSelect(id, level, ThreadContextHelper.getOrgId()));
        return responseMsg;
    }

    /**
     * 展开至指定节点
     * @param id 主键id
     * @return ResponseMsg<List<QmsQualityObjectiveDTO>>
     */
    @GetMapping("/expandTree/{id}/v1")
    @ApiOperation(value = "展开至指定节点")
    public ResponseMsg<List<QmsQualityObjectiveDTO>> expandTree(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
        ResponseMsg<List<QmsQualityObjectiveDTO>> responseMsg = new ResponseMsg<>();
        String orgIdentity = ThreadContextHelper.getOrgId();
        List<QmsQualityObjectiveDTO> list = qmsQualityObjectiveService.expandTreeToNode(id, orgIdentity);
        responseMsg.setResponseBody(list);
        return responseMsg;
    }

	/**
	 * 查询TreeGrid节点
	 * @param queryReqBean 查询条件
	 * @return ResponseMsg<List<QmsQualityObjectiveDTO>>
	 */
	@PostMapping("/search-treegrid/v1")
	@ApiOperation(value = "查询TreeGrid节点")
	public ResponseMsg<List<QmsQualityObjectiveDTO>> searchQmsQualityObjectiveTreeGrid(@ApiParam(value = "查询条件", name = "queryReqBean") @RequestBody QueryReqBean<QmsQualityObjectiveDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityObjectiveDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityObjectiveDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        String orgIdentity = ThreadContextHelper.getOrgId();
		List<QmsQualityObjectiveDTO> list = qmsQualityObjectiveService.searchQmsQualityObjectiveTreeGrid(queryReqBean, orgIdentity);
        ResponseMsg<List<QmsQualityObjectiveDTO>> responseMsg = new ResponseMsg<>();
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
    public ResponseMsg<List<VueNode>> searchQmsQualityObjective(@ApiParam(value = "查询条件", name = "paramMap") @RequestBody Map<String, String> paramMap) {
        String searchText = paramMap.get("searchText");
        List<VueNode> res = qmsQualityObjectiveService.searchQmsQualityObjective(searchText, ThreadContextHelper.getOrgId());
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
		QmsQualityObjectiveDTO tree = new QmsQualityObjectiveDTO();
		tree.setParentId("-1");
		tree.setOrgIdentity(ThreadContextHelper.getOrgId());
		tree.setObjectiveName("根节点");
        tree.setSecretLevel("1");
        tree.setTreePath("-1");
        tree.setTreeSort(1L);
		responseMsg.setResponseBody(qmsQualityObjectiveService.insertQmsQualityObjectiveTree(tree));
		return responseMsg;
	}

	/**
	 * 通过主键获取单条记录
	 * @param id 主键id
	 * @return ResponseMsg<QmsQualityObjectiveDTO>
	 */
	@GetMapping("/get/{id}/v1")
	@ApiOperation(value = "通过树主键获取单条记录")
    @RequiresPermissions("qmsQualityObjective:edit")
	public ResponseMsg<QmsQualityObjectiveDTO> getQmsQualityObjectiveDtoById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) {
		ResponseMsg<QmsQualityObjectiveDTO> responseMsg = new ResponseMsg<>();
		QmsQualityObjectiveDTO dto = qmsQualityObjectiveService.getQmsQualityObjectiveDtoById(id);
        responseMsg.setResponseBody(dto);
		return responseMsg;
	}


    /**
     * 新增树对象
     * @param dto 插入对象
     * @return ResponseMsg<QmsQualityObjectiveDTO>
     */
    @PostMapping("/save/v1")
    @ApiOperation(value = "新增树对象")
    @RequiresPermissions(value={"qmsQualityObjective:edit","qmsQualityObjective:add"},logical= Logical.OR)
    public ResponseMsg<QmsQualityObjectiveDTO> save(@ApiParam(value = "插入对象", name = "dto") @RequestBody QmsQualityObjectiveDTO dto) {
        ResponseMsg<QmsQualityObjectiveDTO> responseMsg = new ResponseMsg<>();
        if (StringUtils.isEmpty(dto.getId())) {
            dto.setOrgIdentity(ThreadContextHelper.getOrgId());
            qmsQualityObjectiveService.insertQmsQualityObjectiveTree(dto);
        } else {
			qmsQualityObjectiveService.updateQmsQualityObjectiveTree(dto);
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
    @RequiresPermissions("qmsQualityObjective:del")
    public ResponseMsg<Integer> deleteById(@ApiParam(value = "主键id", name = "id") @PathVariable("id") String id) throws Exception {
        ResponseMsg<Integer> responseMsg = new ResponseMsg<>();
        responseMsg.setResponseBody(qmsQualityObjectiveService.deleteQmsQualityObjectiveTreeById(id));
        return responseMsg;
    }

    /**
     * 获取新的treeSort值
     * @param id 父节点ID
     * @return ResponseMsg<QmsQualityObjectiveDTO>
     */
    @GetMapping("/get-new-tree-sort/{id}/v1")
    @ApiOperation(value = "获取新的treeSort值")
    public ResponseMsg<Long> getNewTreeSortById(@ApiParam(value = "父节点ID", name = "id") @PathVariable String id) {
        ResponseMsg<Long> responseMsg = new ResponseMsg<>();
        Long newTreeSort = qmsQualityObjectiveService.getNewTreeSortByParentId(id);
        responseMsg.setResponseBody(newTreeSort);
        return responseMsg;
    }

    @GetMapping("/downloadTemplate/v1")
    @ApiOperation(value = "模板下载")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 输出
        ExcelUtil.downloadTemplate(response, QmsQualityObjectiveImportDTO.class,"导入模板");
    }

    /**
     * 导入数据
     * @param multipartFile 导入文件
     * @return
     */
    @PostMapping(value = "/importData/v1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "导入文件")
    public ResponseMsg<Object> importDataV2(@ApiParam(value = "Excel 文件", name = "impExcelFile") @RequestPart("impExcelFile") MultipartFile multipartFile, @RequestParam("formData") String formData) throws Exception {
        ResponseMsg<Object> responseMsg = new ResponseMsg<>();
        List<Map<String, String>> excelList = ExcelUtil.importExcel(multipartFile.getInputStream(), QmsQualityObjectiveImportDTO.class);
        ExcelImportResult excelImportResult = qmsQualityObjectiveService.importData(excelList,formData);
        responseMsg.setResponseBody(excelImportResult);
        return responseMsg;
    }

    /**
     * 获取父节点查询节点
     */
    @GetMapping("/getByPid/{parentId}/v1")
    @ApiOperation(value = "通过树parentId获取单条记录")
    public ResponseMsg<QmsQualityObjectiveDTO> getQmsQualityObjectiveDtoByParentId(@ApiParam(value = "parentId", name = "parentId") @PathVariable("parentId") String parentId) {
        ResponseMsg<QmsQualityObjectiveDTO> responseMsg = new ResponseMsg<>();
        QmsQualityObjectiveDTO dto = qmsQualityObjectiveService.getQmsQualityObjectiveDtoByParentId(parentId);
        responseMsg.setResponseBody(dto);
        return responseMsg;
    }

}
