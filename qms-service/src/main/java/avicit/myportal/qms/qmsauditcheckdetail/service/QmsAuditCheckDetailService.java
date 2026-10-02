package avicit.myportal.qms.qmsauditcheckdetail.service;


import avicit.myportal.qms.qmsauditcheckrecord.dao.QmsAuditCheckRecordDAO;
import avicit.myportal.qms.qmsauditcheckrecord.dto.QmsAuditCheckRecordDTO;
import avicit.myportal.qms.qmsauditcheckrecord.service.QmsAuditCheckRecordService;
import avicit.myportal.qms.qmsauditnc.dto.QmsAuditNcDTO;
import avicit.myportal.qms.qmsauditnc.service.QmsAuditNcService;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.commons.utils.ComUtil;
import avicit.platform6.commons.utils.PojoUtil;
import avicit.platform6.commons.utils.StringUtils;
import avicit.platform6.commons.utils.BusinessUtil;
import avicit.platform6.commons.utils.JsonHelper;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsauditcheckdetail.dao.QmsAuditCheckDetailDAO;
import avicit.myportal.qms.qmsauditcheckdetail.dto.QmsAuditCheckDetailDTO;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:32
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsAuditCheckDetailService {

    private static final Logger logger = LoggerFactory.getLogger(QmsAuditCheckDetailService.class);

    @Autowired
    private QmsAuditCheckDetailDAO qmsAuditCheckDetailDAO;

    @Autowired
    private OssClient ossClient;

    @Autowired
    private QmsAuditNcService qmsAuditNcService;

    @Autowired
    private QmsAuditCheckRecordService qmsAuditCheckRecordService;

    @Autowired
    private QmsAuditCheckRecordDAO qmsAuditCheckRecordDAO;

    @Autowired
    private ConvertColumnClient convertColumnClient;

    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsAuditCheckDetailDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsAuditCheckDetailDTO> searchQmsAuditCheckDetailByPage(QueryReqBean<QmsAuditCheckDetailDTO> queryReqBean) {
        QueryRespBean<QmsAuditCheckDetailDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsAuditCheckDetailDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsAuditCheckDetailDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsAuditCheckDetailDTO>() {
            });
            searchKeyWordParam.setRecordId(queryReqBean.getSearchParams().getRecordId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getRecordId())) {
            queryReqBean.getSearchParams().setRecordId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        // 文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsAuditCheckDetailDTO> result = qmsAuditCheckDetailDAO.searchQmsAuditCheckDetailByPage(queryReqBean.getSearchParams(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @param wordSecret   文档密级
     * @param orderBy      排序
     * @return List<QmsAuditCheckDetailDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsAuditCheckDetailDTO> searchQmsAuditCheckDetailForExportExcel(QueryReqBean<QmsAuditCheckDetailDTO> queryReqBean, List<String> wordSecret, String orderBy) {
        return qmsAuditCheckDetailDAO.searchQmsAuditCheckDetailForExportExcel(queryReqBean.getSearchParams(), wordSecret, orderBy, queryReqBean.getKeyWord());
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsAuditCheckDetailDTO
     */
    @Transactional(readOnly = true)
    public QmsAuditCheckDetailDTO queryQmsAuditCheckDetailByPrimaryKey(String id) {
        QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO = qmsAuditCheckDetailDAO.findQmsAuditCheckDetailById(id);
        // 记录日志
        if (qmsAuditCheckDetailDTO != null) {
            valueConvert(Arrays.asList(qmsAuditCheckDetailDTO));
            SysLogUtil.log4Query(qmsAuditCheckDetailDTO);
        }
        return qmsAuditCheckDetailDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsAuditCheckDetailDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsAuditCheckDetailDTO> queryQmsAuditCheckDetailByPid(String pid) {
        List<QmsAuditCheckDetailDTO> dtoList = qmsAuditCheckDetailDAO.findQmsAuditCheckDetailByPid(pid);
        return dtoList;
    }

    /**
     * 新增对象
     *
     * @param qmsAuditCheckDetailDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsAuditCheckDetail(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        qmsAuditCheckDetailDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsAuditCheckDetailDTO, OpType.insert);

        if (qmsAuditCheckDetailDTO.getConformityResult().equals("10")) {
            qmsAuditCheckDetailDTO.setYnNc("Y");
            // TODO 关联新增一条不合格项
            insertRelatedAuditNc(qmsAuditCheckDetailDTO);
        }
        qmsAuditCheckDetailDAO.insertQmsAuditCheckDetail(qmsAuditCheckDetailDTO);
        // TODO 重新计算数量
        calculateCount(qmsAuditCheckDetailDTO.getRecordId());

        // 记录日志
        SysLogUtil.log4Insert(qmsAuditCheckDetailDTO);
        return qmsAuditCheckDetailDTO.getId();
    }

    /**
     * 重新计算checkRecord统计数量
     * @param recordId
     */
    private void calculateCount(String recordId) {
        if(StringUtils.isEmpty(recordId)) return;
        QmsAuditCheckRecordDTO recordDto = qmsAuditCheckRecordDAO.findQmsAuditCheckRecordById(recordId);
        if(recordDto!=null){
            // 重新计算
            int detailCount = qmsAuditCheckDetailDAO.getDetailCountByRecordId(recordId);
            int ncCount = qmsAuditCheckDetailDAO.getNcCountByRecordId(recordId);
            int adviceCount = qmsAuditCheckDetailDAO.getAdviceCountByRecordId(recordId);
            recordDto.setDetailCount(BigDecimal.valueOf(detailCount));
            recordDto.setNcDetailCount(BigDecimal.valueOf(ncCount));
            recordDto.setAdviceDetailCount(BigDecimal.valueOf(adviceCount));
            qmsAuditCheckRecordService.updateQmsAuditCheckRecord(recordDto);
        }
        
    }

    public void insertRelatedAuditNc(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        QmsAuditNcDTO dto = new QmsAuditNcDTO();
        dto.setDetailId(qmsAuditCheckDetailDTO.getId()); // 检查项ID
        dto.setRecordId(qmsAuditCheckDetailDTO.getRecordId());
        dto.setPlanId(qmsAuditCheckDetailDTO.getPlanId());
        dto.setNoticeId(qmsAuditCheckDetailDTO.getNoticeId());
        dto.setSecretLevel(qmsAuditCheckDetailDTO.getSecretLevel());
        if (StringUtils.isNotEmpty(qmsAuditCheckDetailDTO.getRecordId())) {
            QmsAuditCheckRecordDTO recordDto = qmsAuditCheckRecordService.queryQmsAuditCheckRecordByPrimaryKey(qmsAuditCheckDetailDTO.getRecordId());
            dto.setAuditeeDeptId(recordDto.getAuditeeDeptId());
            dto.setAuditeeDeptCode(recordDto.getAuditeeDeptCode());
            dto.setAuditeeDeptName(recordDto.getAuditeeDeptName());
        }
        qmsAuditNcService.insertQmsAuditNc(dto);
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsAuditCheckDetailList(List<QmsAuditCheckDetailDTO> dtoList) {
        for (QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO : dtoList) {
            qmsAuditCheckDetailDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsAuditCheckDetailDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsAuditCheckDetailDAO.insertQmsAuditCheckDetailList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsAuditCheckDetailDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsAuditCheckDetail(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        return updateDto(qmsAuditCheckDetailDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsAuditCheckDetailDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsAuditCheckDetailSensitive(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        return updateDto(qmsAuditCheckDetailDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsAuditCheckDetailList(List<QmsAuditCheckDetailDTO> dtoList) {
        List<QmsAuditCheckDetailDTO> updateList = new ArrayList<>();
        List<QmsAuditCheckDetailDTO> oldList = new ArrayList<>();
        for (QmsAuditCheckDetailDTO dto : dtoList) {
            QmsAuditCheckDetailDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsAuditCheckDetailDTO updateDto = (QmsAuditCheckDetailDTO) old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsAuditCheckDetailDAO.updateQmsAuditCheckDetailList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsAuditCheckDetailDTO
     * @return
     */
    private QmsAuditCheckDetailDTO getUpdateSubDto(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        QmsAuditCheckDetailDTO oldDTO = findById(qmsAuditCheckDetailDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getRecordId();
        // 记录日志
        SysLogUtil.log4Update(qmsAuditCheckDetailDTO, oldDTO);
        PojoUtil.setSysProperties(qmsAuditCheckDetailDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsAuditCheckDetailDTO, false);
        oldDTO.setRecordId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsAuditCheckDetailById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        // 记录日志
        QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO = findById(id);
        if (qmsAuditCheckDetailDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsAuditCheckDetailDTO);
        // 删除业务数据
        int count = qmsAuditCheckDetailDAO.deleteQmsAuditCheckDetailById(id);
        // 删除附件
        ossClient.deleteAttachByFormId(qmsAuditCheckDetailDTO.getId());
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsAuditCheckDetailDTO 对象条件
     * @return int
     */
    public int deleteQmsAuditCheckDetail(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO) {
        // 记录日志
        if (qmsAuditCheckDetailDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsAuditCheckDetailDTO);
        int i = qmsAuditCheckDetailDAO.deleteQmsAuditCheckDetailById(qmsAuditCheckDetailDTO.getId());
        // TODO 重新计算数量
        this.calculateCount(qmsAuditCheckDetailDTO.getId());
        return i;
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsAuditCheckDetailByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsAuditCheckDetailById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsAuditCheckDetailDTO
     */
    private QmsAuditCheckDetailDTO findById(String id) {
        return qmsAuditCheckDetailDAO.findQmsAuditCheckDetailById(id);
    }

    /**
     * 内部方法，
     *
     * @param dto             修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsAuditCheckDetailDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsAuditCheckDetailDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsAuditCheckDetailDTO updateDto = (QmsAuditCheckDetailDTO) old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsAuditCheckDetailDAO.updateQmsAuditCheckDetailAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsAuditCheckDetailDAO.updateQmsAuditCheckDetailSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        // TODO 重新计算数量
        this.calculateCount(dto.getRecordId());
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }

    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsAuditCheckDetailDTOList
     */
    private void valueConvert(List<QmsAuditCheckDetailDTO> qmsAuditCheckDetailDTOList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsAuditCheckDetailDTO qmsAuditCheckDetail : qmsAuditCheckDetailDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditCheckDetail.getSecretLevel());
            BusinessUtil.createConvertSet(convertFormData, "QMS_CHECK_CONFORMITY_RESULT", qmsAuditCheckDetail.getConformityResult());
        }
        if (convertFormData.size() > 0) {
            // 获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            // 循环设置Alias或Name的值
            for (QmsAuditCheckDetailDTO qmsAuditCheckDetail : qmsAuditCheckDetailDTOList) {
                qmsAuditCheckDetail.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsAuditCheckDetail.getSecretLevel()));
                qmsAuditCheckDetail.setConformityResultName(BusinessUtil.convertFormat(convertResultData, "QMS_CHECK_CONFORMITY_RESULT", qmsAuditCheckDetail.getConformityResult()));
            }

        }
    }
}

