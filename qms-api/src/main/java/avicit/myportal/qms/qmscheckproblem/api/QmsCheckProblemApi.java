package avicit.myportal.qms.qmscheckproblem.api;

import avicit.platform6.core.restclient.RestClient;
import avicit.platform6.core.restclient.RestClientUtils;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:17
 * @类说明：检查问题表Api
 * @修改记录：
 */
@Component
public class QmsCheckProblemApi{

    /** 服务编码  */
    private static final String SERVICE_CODE = "QMS";
    private static final String BASE_PATH = "/api/myportal/qms/qmscheckproblems";

    @Autowired
    private RestClient restClient;

    /**
     * 按条件分页查询子表数据
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsCheckProblemDTO>
     */
    public QueryRespBean<QmsCheckProblemDTO> searchByPage(QueryReqBean<QmsCheckProblemDTO> queryReqBean) {
        String url = BASE_PATH+"/search-by-page/v1";
        ResponseMsg<QueryRespBean<QmsCheckProblemDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<QueryRespBean<QmsCheckProblemDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 通过子表主键查询单条记录
     *
     * @param id 主键id
     * @return QmsCheckProblemDTO
     */
    public QmsCheckProblemDTO get(String id) {
        String url = BASE_PATH+"/get/" + id + "/v1";
        ResponseMsg<QmsCheckProblemDTO> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<QmsCheckProblemDTO>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 通过pid查询数据
     *
     * @param pid 父id
     * @return List<QmsCheckProblemDTO>
     */
    public List<QmsCheckProblemDTO> getByPid(String pid) {
        String url = BASE_PATH+"/get-by-pid/"+ pid + "/v1";
        ResponseMsg<List<QmsCheckProblemDTO>> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<List<QmsCheckProblemDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 保存对象
     *
     * @param qmsCheckProblemDTO 保存对象
     * @return String
     */
    public String save(QmsCheckProblemDTO qmsCheckProblemDTO) {
        String url = BASE_PATH+"/save/v1";
        ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, qmsCheckProblemDTO, new ParameterizedTypeReference<ResponseMsg<String>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 修改子表部分对象字段
     *
     * @param qmsCheckProblemDTO 更新对象
     * @return Integer
     */
    public Integer updateSensitive(QmsCheckProblemDTO qmsCheckProblemDTO) {
        String url = BASE_PATH+"/update/v1";
        ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsCheckProblemDTO, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 修改子表全部对象字段
     *
     * @param qmsCheckProblemDTO 更新对象
     * @return Integer
     */
    public Integer updateAll(QmsCheckProblemDTO qmsCheckProblemDTO) {
        String url = BASE_PATH+"/update-all/v1";
        ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsCheckProblemDTO, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
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

    /**
     * 批量删除
     *
     * @param ids 逗号分隔的id串
     * @return Integer
     */
    public Integer deleteByIds(String[] ids) {
        String url = BASE_PATH+"/delete-by-ids/v1";
        ResponseMsg<Integer> responseMsg = restClient.doDelete(SERVICE_CODE, url, ids, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }
}