package avicit.myportal.qms.qmsqualityinspection.api;

import avicit.platform6.core.restclient.RestClient;
import avicit.platform6.core.restclient.RestClientUtils;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.core.rest.msg.ResponseMsg;
import avicit.myportal.qms.qmsqualityinspection.dto.QmsQualityInspectionDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:15
 * @类说明：质量检查表Api
 * @修改记录：
 */
@Component
public class QmsQualityInspectionApi{

    /** 服务编码  */
    private static final String SERVICE_CODE = "QMS";
    private static final String BASE_PATH = "/api/myportal/qms/qmsqualityinspections";

    @Autowired
    private RestClient restClient;

    /**
     * 按条件分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsQualityInspectionDTO>
     */
    public QueryRespBean<QmsQualityInspectionDTO> searchByPage(QueryReqBean<QmsQualityInspectionDTO> queryReqBean) {
        String url = BASE_PATH+"/search-by-page/v1";
        ResponseMsg<QueryRespBean<QmsQualityInspectionDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<QueryRespBean<QmsQualityInspectionDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 按条件不分页查询主表数据
     *
     * @param queryReqBean 查询条件
     * @return List<QmsQualityInspectionDTO>
     */
    public List<QmsQualityInspectionDTO> search(QueryReqBean<QmsQualityInspectionDTO> queryReqBean) {
        String url = BASE_PATH+"/search/v1";
        ResponseMsg<List<QmsQualityInspectionDTO>> responseMsg = restClient.doPost(SERVICE_CODE, url, queryReqBean, new ParameterizedTypeReference<ResponseMsg<List<QmsQualityInspectionDTO>>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 通过主键查询主表单条记录
     *
     * @param id 主键id
     * @return QmsQualityInspectionDTO
     */
    public QmsQualityInspectionDTO get(String id) {
        String url = BASE_PATH+"/get/" + id + "/v1";
        ResponseMsg<QmsQualityInspectionDTO> responseMsg = restClient.doGet(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<QmsQualityInspectionDTO>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 新增主表对象
     *
     * @param qmsQualityInspectionDTO 保存对象
     * @return String
     */
    public String save(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
        String url = BASE_PATH+"/save/v1";
        ResponseMsg<String> responseMsg = restClient.doPost(SERVICE_CODE, url, qmsQualityInspectionDTO, new ParameterizedTypeReference<ResponseMsg<String>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 修改主表部分对象字段
     *
     * @param qmsQualityInspectionDTO 修改对象
     * @return Integer
     */
    public Integer updateSensitive(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
        String url = BASE_PATH+"/update-sensitive/v1";
        ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsQualityInspectionDTO, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 修改主表全部对象字段
     *
     * @param qmsQualityInspectionDTO 修改对象
     * @return Integer
     */
    public Integer updateAll(QmsQualityInspectionDTO qmsQualityInspectionDTO) {
        String url = BASE_PATH+"/update-all/v1";
        ResponseMsg<Integer> responseMsg = restClient.doPut(SERVICE_CODE, url, qmsQualityInspectionDTO, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 按主表主键单条删除主表数据
     *
     * @param id 主键id
     * @return Integer
     */
    public Integer deleteById(String id) {
        String url = BASE_PATH+"/delete-by-id/"+ id +"/v1";
        ResponseMsg<Integer> responseMsg = restClient.doDelete(SERVICE_CODE, url, new ParameterizedTypeReference<ResponseMsg<Integer>>() {
        });
        return RestClientUtils.getResponseBody(responseMsg);
    }

    /**
     * 批量删除主表数据
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