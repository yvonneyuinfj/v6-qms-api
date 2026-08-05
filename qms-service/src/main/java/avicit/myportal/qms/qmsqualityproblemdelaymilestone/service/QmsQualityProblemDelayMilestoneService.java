package avicit.myportal.qms.qmsqualityproblemdelaymilestone.service;


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
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dao.QmsQualityProblemDelayMilestoneDAO;
import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dto.QmsQualityProblemDelayMilestoneDTO;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:05
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsQualityProblemDelayMilestoneService  {

	 private static final Logger logger = LoggerFactory.getLogger(QmsQualityProblemDelayMilestoneService.class);

    @Autowired
    private QmsQualityProblemDelayMilestoneDAO qmsQualityProblemDelayMilestoneDAO;


    @Autowired
    private ConvertColumnClient convertColumnClient;
    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsQualityProblemDelayMilestoneDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsQualityProblemDelayMilestoneDTO> searchQmsQualityProblemDelayMilestoneByPage(QueryReqBean<QmsQualityProblemDelayMilestoneDTO> queryReqBean) {
        QueryRespBean<QmsQualityProblemDelayMilestoneDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityProblemDelayMilestoneDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityProblemDelayMilestoneDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityProblemDelayMilestoneDTO>() {
            });
            searchKeyWordParam.setDelayId(queryReqBean.getSearchParams().getDelayId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getDelayId())) {
            queryReqBean.getSearchParams().setDelayId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityProblemDelayMilestoneDTO> result = qmsQualityProblemDelayMilestoneDAO.searchQmsQualityProblemDelayMilestoneByPage(queryReqBean.getSearchParams(),  wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
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
     * @return List<QmsQualityProblemDelayMilestoneDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityProblemDelayMilestoneDTO> searchQmsQualityProblemDelayMilestoneForExportExcel(QueryReqBean<QmsQualityProblemDelayMilestoneDTO> queryReqBean, List<String> wordSecret, String orderBy) {
        return qmsQualityProblemDelayMilestoneDAO.searchQmsQualityProblemDelayMilestoneForExportExcel(queryReqBean.getSearchParams(), wordSecret, orderBy, queryReqBean.getKeyWord());
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsQualityProblemDelayMilestoneDTO
     */
    @Transactional(readOnly = true)
    public QmsQualityProblemDelayMilestoneDTO queryQmsQualityProblemDelayMilestoneByPrimaryKey(String id) {
        QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO = qmsQualityProblemDelayMilestoneDAO.findQmsQualityProblemDelayMilestoneById(id);
        //记录日志
        if (qmsQualityProblemDelayMilestoneDTO != null) {
            valueConvert(Arrays.asList(qmsQualityProblemDelayMilestoneDTO));
            SysLogUtil.log4Query(qmsQualityProblemDelayMilestoneDTO);
        }
        return qmsQualityProblemDelayMilestoneDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsQualityProblemDelayMilestoneDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityProblemDelayMilestoneDTO> queryQmsQualityProblemDelayMilestoneByPid(String pid) {
        List<QmsQualityProblemDelayMilestoneDTO> dtoList = qmsQualityProblemDelayMilestoneDAO.findQmsQualityProblemDelayMilestoneByPid(pid);
        return dtoList;
    }
    /**
     * 新增对象
     *
     * @param qmsQualityProblemDelayMilestoneDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsQualityProblemDelayMilestone(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        qmsQualityProblemDelayMilestoneDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsQualityProblemDelayMilestoneDTO, OpType.insert);
        qmsQualityProblemDelayMilestoneDAO.insertQmsQualityProblemDelayMilestone(qmsQualityProblemDelayMilestoneDTO);
        //记录日志
        SysLogUtil.log4Insert(qmsQualityProblemDelayMilestoneDTO);
        return qmsQualityProblemDelayMilestoneDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsQualityProblemDelayMilestoneList(List<QmsQualityProblemDelayMilestoneDTO> dtoList) {
        for (QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO : dtoList) {
            qmsQualityProblemDelayMilestoneDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityProblemDelayMilestoneDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityProblemDelayMilestoneDAO.insertQmsQualityProblemDelayMilestoneList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsQualityProblemDelayMilestoneDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityProblemDelayMilestone(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        return updateDto(qmsQualityProblemDelayMilestoneDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsQualityProblemDelayMilestoneDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityProblemDelayMilestoneSensitive(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        return updateDto(qmsQualityProblemDelayMilestoneDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsQualityProblemDelayMilestoneList(List<QmsQualityProblemDelayMilestoneDTO> dtoList) {
        List<QmsQualityProblemDelayMilestoneDTO> updateList = new ArrayList<>();
        List<QmsQualityProblemDelayMilestoneDTO> oldList = new ArrayList<>();
        for (QmsQualityProblemDelayMilestoneDTO dto : dtoList) {
            QmsQualityProblemDelayMilestoneDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityProblemDelayMilestoneDTO updateDto = (QmsQualityProblemDelayMilestoneDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityProblemDelayMilestoneDAO.updateQmsQualityProblemDelayMilestoneList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsQualityProblemDelayMilestoneDTO
     * @return
     */
    private QmsQualityProblemDelayMilestoneDTO getUpdateSubDto(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        QmsQualityProblemDelayMilestoneDTO oldDTO = findById(qmsQualityProblemDelayMilestoneDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getDelayId();
        //记录日志
        SysLogUtil.log4Update(qmsQualityProblemDelayMilestoneDTO, oldDTO);
        PojoUtil.setSysProperties(qmsQualityProblemDelayMilestoneDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsQualityProblemDelayMilestoneDTO, false);
        oldDTO.setDelayId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsQualityProblemDelayMilestoneById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        //记录日志
        QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO = findById(id);
        if (qmsQualityProblemDelayMilestoneDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityProblemDelayMilestoneDTO);
        //删除业务数据
        int count = qmsQualityProblemDelayMilestoneDAO.deleteQmsQualityProblemDelayMilestoneById(id);
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsQualityProblemDelayMilestoneDTO 对象条件
     * @return int
     */
    public int deleteQmsQualityProblemDelayMilestone(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO) {
        //记录日志
        if (qmsQualityProblemDelayMilestoneDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityProblemDelayMilestoneDTO);
        return qmsQualityProblemDelayMilestoneDAO.deleteQmsQualityProblemDelayMilestoneById(qmsQualityProblemDelayMilestoneDTO.getId());
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsQualityProblemDelayMilestoneByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsQualityProblemDelayMilestoneById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsQualityProblemDelayMilestoneDTO
     */
    private QmsQualityProblemDelayMilestoneDTO findById(String id) {
        return qmsQualityProblemDelayMilestoneDAO.findQmsQualityProblemDelayMilestoneById(id);
    }
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityProblemDelayMilestoneDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityProblemDelayMilestoneDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityProblemDelayMilestoneDTO updateDto = (QmsQualityProblemDelayMilestoneDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityProblemDelayMilestoneDAO.updateQmsQualityProblemDelayMilestoneAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityProblemDelayMilestoneDAO.updateQmsQualityProblemDelayMilestoneSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }

    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsQualityProblemDelayMilestoneDTOList
     */
    private void valueConvert(List<QmsQualityProblemDelayMilestoneDTO> qmsQualityProblemDelayMilestoneDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestone : qmsQualityProblemDelayMilestoneDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityProblemDelayMilestone.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestone : qmsQualityProblemDelayMilestoneDTOList) {
                qmsQualityProblemDelayMilestone.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityProblemDelayMilestone.getSecretLevel()));
            }
        }
    }
}

