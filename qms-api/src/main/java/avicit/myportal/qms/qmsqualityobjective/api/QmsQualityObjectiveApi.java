package avicit.myportal.qms.qmsqualityobjective.api;

import avicit.platform6.core.domain.VueNode;
import avicit.platform6.core.restclient.RestClient;
import avicit.platform6.core.restclient.RestClientUtils;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveDTO;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:10
 * @类说明：质量目标台账表Api
 * @修改记录：
 */
@Component
public class QmsQualityObjectiveApi {

	/**
	 * 服务编码
	 */
	private static final String SERVICE_CODE = "QMS";
	private static final String BASE_PATH = "/api/myportal/qms/qmsqualityobjectives";

	@Autowired
	private RestClient restClient;

	/**
     * 加载TreeGrid
     *
     * @param level 树的等级
     * @param id 父节点ID
     * @return List<QmsQualityObjectiveDTO>
     */
	public List<QmsQualityObjectiveDTO> getTreeGrid(int level, String id){
		String url = BASE_PATH+"/get-treegrid/" + level + "/" + id + "/v1";
        ResponseMsg<List<QmsQualityObjectiveDTO>> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<List<QmsQualityObjectiveDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
     * 展开至指定节点
     *
     * @param id 主键id
     * @return List<QmsQualityObjectiveDTO>
     */
	public List<QmsQualityObjectiveDTO> expandTree(int level, String id){
		String url = BASE_PATH+"/expandTree/" + id + "/v1";
        ResponseMsg<List<QmsQualityObjectiveDTO>> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<List<QmsQualityObjectiveDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
	}
	/**
     * 加载树
     *
     * @param level 树的等级
     * @param id 父节点ID
     * @return List<VueNode>
     */
	public List<VueNode> getTree(int level, String id){
		String url = BASE_PATH+"/get-tree/" + level + "/" + id + "/v1";
		ResponseMsg<List<VueNode>> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<List<VueNode>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 查询树节点
     *
     * @param queryReqBean 查询条件
     * @return List<VueNode>
     */
	public List<VueNode> searchQmsQualityObjective(QueryReqBean<QmsQualityObjectiveDTO> queryReqBean){
		String url = BASE_PATH+"/search/v1";
		ResponseMsg<List<VueNode>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<List<VueNode>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
	}
	
	/**
     * 初始化根节点 如果需要修改根节点数据通过前台页面设置
     *
     * @return String
     */
    public String insertRoot() {
        String url = BASE_PATH+"/insert-root/v1";
        ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, "", new ParameterizedTypeReference<ResponseMsg<String>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }
	
	/**
	 * 通过ID获取单条记录
     *
	 * @param id 主键id
	 * @return QmsQualityObjectiveDTO
	 */
	public QmsQualityObjectiveDTO getQmsQualityObjectiveDtoById(String id){
		String url = BASE_PATH+"/get/"+ id + "/v1" ;
		 ResponseMsg<QmsQualityObjectiveDTO> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<QmsQualityObjectiveDTO>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

	/**
     * 新增对象
     *
     * @return String
     */
	public String save(QmsQualityObjectiveDTO dto) {
		String url = BASE_PATH+"/save/v1";
		ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, dto, new ParameterizedTypeReference<ResponseMsg<String>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }
	
	/**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return Integer
     */
    public Integer deleteById(String id) {
        String url = BASE_PATH+"/delete-by-id/" + id + "/v1";
        ResponseMsg<Integer> responseMsg = restClient.doDelete(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }
}