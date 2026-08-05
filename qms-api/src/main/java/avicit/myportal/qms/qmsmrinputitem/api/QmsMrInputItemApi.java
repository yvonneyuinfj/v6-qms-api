package avicit.myportal.qms.qmsmrinputitem.api;

import avicit.platform6.core.restclient.RestClient;
import avicit.platform6.core.restclient.RestClientUtils;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.myportal.qms.qmsmrinputitem.dto.QmsMrInputItemDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:43
 * @类说明：管评输入材料分工台账Api
 * @修改记录：
 */
@Component
public class QmsMrInputItemApi {

	/**
	 * 服务编码
	 */
	private static final String SERVICE_CODE = "QMS";
	private static final String BASE_PATH = "/api/myportal/qms/qmsmrinputitems";

	@Autowired
	private RestClient restClient;

	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return QueryRespBean<QmsMrInputItemDTO>
	 */
	public QueryRespBean<QmsMrInputItemDTO> searchByPage(QueryReqBean<QmsMrInputItemDTO> queryReqBean) {
		String url = BASE_PATH + "/search-by-page/v1";
		ResponseMsg<QueryRespBean<QmsMrInputItemDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<QueryRespBean<QmsMrInputItemDTO>>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return List<QmsMrInputItemDTO>
	 */
	public List<QmsMrInputItemDTO> search(QueryReqBean<QmsMrInputItemDTO> queryReqBean) {
		String url = BASE_PATH + "/search/v1";
		ResponseMsg<List<QmsMrInputItemDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<List<QmsMrInputItemDTO>>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return QmsMrInputItemDTO
	 */
	public QmsMrInputItemDTO get(String id) {
		String url = BASE_PATH + "/get/" + id + "/v1";
		ResponseMsg<QmsMrInputItemDTO> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<QmsMrInputItemDTO>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMrInputItem 修改对象
	 * @return Integer
	 */
	public Integer updateSensitive(QmsMrInputItemDTO qmsMrInputItem) {
		String url = BASE_PATH + "/update-sensitive/v1";
		ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsMrInputItem, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMrInputItem 修改对象
	 * @return Integer
	 */
	public Integer updateAll(QmsMrInputItemDTO qmsMrInputItem) {
		String url = BASE_PATH + "/update-all/v1";
		ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsMrInputItem, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 新增对象
	 *
	 * @param qmsMrInputItem 保存对象
	 * @return String
	 */
	public String save(QmsMrInputItemDTO qmsMrInputItem) {
		String url = BASE_PATH + "/save/v1";
		ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, qmsMrInputItem, new ParameterizedTypeReference<ResponseMsg<String>>() {
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
		String url = BASE_PATH + "/delete-by-id/" + id + "/v1";
		ResponseMsg<Integer> responseMsg = restClient.doDelete(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 批量删除
	 *
	 * @param ids 逗号分隔的id串
	 * @return Integer
	 */
	public Integer deleteByIds(String[] ids) {
		String url = BASE_PATH + "/delete-by-ids/v1";
		ResponseMsg<Integer> responseMsg = restClient.doDelete(SERVICE_CODE, url, ids, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}
}