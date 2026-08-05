package avicit.myportal.qms.qmsmilitaryqualkeepcheck.api;

import avicit.platform6.core.restclient.RestClient;
import avicit.platform6.core.restclient.RestClientUtils;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.platform6.api.bpm.dto.ProcessParameter;
import avicit.platform6.bpmreform.bpmbusiness.dto.StartResultBean;
import avicit.myportal.qms.qmsmilitaryqualkeepcheck.dto.QmsMilitaryQualKeepCheckDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:09
 * @类说明：资格保持自查表Api
 * @修改记录：
 */
@Component
public class QmsMilitaryQualKeepCheckApi {

	/**
	 * 服务编码
	 */
	private static final String SERVICE_CODE = "QMS";
	private static final String BASE_PATH = "/api/myportal/qms/qmsmilitaryqualkeepchecks";

	@Autowired
	private RestClient restClient;

	/**
	 * 按条件分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return QueryRespBean<QmsMilitaryQualKeepCheckDTO>
	 */
	public QueryRespBean<QmsMilitaryQualKeepCheckDTO> searchByPage(QueryReqBean<QmsMilitaryQualKeepCheckDTO> queryReqBean) {
		String url = BASE_PATH + "/search-by-page/v1";
		ResponseMsg<QueryRespBean<QmsMilitaryQualKeepCheckDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<QueryRespBean<QmsMilitaryQualKeepCheckDTO>>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 按条件不分页查询
	 *
	 * @param queryReqBean 查询条件
	 * @return List<QmsMilitaryQualKeepCheckDTO>
	 */
	public List<QmsMilitaryQualKeepCheckDTO> search(QueryReqBean<QmsMilitaryQualKeepCheckDTO> queryReqBean) {
		String url = BASE_PATH + "/search/v1";
		ResponseMsg<List<QmsMilitaryQualKeepCheckDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<List<QmsMilitaryQualKeepCheckDTO>>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 通过主键查询单条记录
	 *
	 * @param id 主键id
	 * @return QmsMilitaryQualKeepCheckDTO
	 */
	public QmsMilitaryQualKeepCheckDTO get(String id) {
		String url = BASE_PATH + "/get/" + id + "/v1";
		ResponseMsg<QmsMilitaryQualKeepCheckDTO> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<QmsMilitaryQualKeepCheckDTO>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 新增并启动流程
	 *
	 * @param processParam 参数对象
	 * @return StartResultBean
	 */
	public StartResultBean saveAndStartProcess(ProcessParameter<QmsMilitaryQualKeepCheckDTO> processParam) {
		String url = BASE_PATH + "/save-and-start-process/v1";
		ResponseMsg<StartResultBean> responseMsg = restClient.doPost(SERVICE_CODE, url, processParam, new ParameterizedTypeReference<ResponseMsg<StartResultBean>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

    /**
	 * 修改部分对象字段
	 *
	 * @param qmsMilitaryQualKeepCheck 修改对象
	 * @return Integer
	 */
	public Integer updateSensitive(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheck) {
		String url = BASE_PATH + "/update-sensitive/v1";
		ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsMilitaryQualKeepCheck, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 修改全部对象字段
	 *
	 * @param qmsMilitaryQualKeepCheck 修改对象
	 * @return Integer
	 */
	public Integer updateAll(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheck) {
		String url = BASE_PATH + "/update-all/v1";
		ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsMilitaryQualKeepCheck, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
		});
		return RestClientUtils.getResponseBody(responseMsg);
	}

	/**
	 * 新增对象
	 *
	 * @param qmsMilitaryQualKeepCheck 保存对象
	 * @return String
	 */
	public String save(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheck) {
		String url = BASE_PATH + "/save/v1";
		ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, qmsMilitaryQualKeepCheck, new ParameterizedTypeReference<ResponseMsg<String>>() {
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