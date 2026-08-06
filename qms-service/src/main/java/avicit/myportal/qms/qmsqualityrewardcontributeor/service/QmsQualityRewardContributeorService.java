package avicit.myportal.qms.qmsqualityrewardcontributeor.service;


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
import avicit.myportal.qms.qmsqualityrewardcontributeor.dao.QmsQualityRewardContributeorDAO;
import avicit.myportal.qms.qmsqualityrewardcontributeor.dto.QmsQualityRewardContributeorDTO;
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
 * @创建时间： 2026-08-06 17:03
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsQualityRewardContributeorService  {

	 private static final Logger logger = LoggerFactory.getLogger(QmsQualityRewardContributeorService.class);

    @Autowired
    private QmsQualityRewardContributeorDAO qmsQualityRewardContributeorDAO;


    @Autowired
    private ConvertColumnClient convertColumnClient;
    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsQualityRewardContributeorDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsQualityRewardContributeorDTO> searchQmsQualityRewardContributeorByPage(QueryReqBean<QmsQualityRewardContributeorDTO> queryReqBean) {
        QueryRespBean<QmsQualityRewardContributeorDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsQualityRewardContributeorDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsQualityRewardContributeorDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsQualityRewardContributeorDTO>() {
            });
            searchKeyWordParam.setRewardId(queryReqBean.getSearchParams().getRewardId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getRewardId())) {
            queryReqBean.getSearchParams().setRewardId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsQualityRewardContributeorDTO> result = qmsQualityRewardContributeorDAO.searchQmsQualityRewardContributeorByPage(queryReqBean.getSearchParams(),  wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
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
     * @return List<QmsQualityRewardContributeorDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityRewardContributeorDTO> searchQmsQualityRewardContributeorForExportExcel(QueryReqBean<QmsQualityRewardContributeorDTO> queryReqBean, List<String> wordSecret, String orderBy) {
        return qmsQualityRewardContributeorDAO.searchQmsQualityRewardContributeorForExportExcel(queryReqBean.getSearchParams(), wordSecret, orderBy, queryReqBean.getKeyWord());
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsQualityRewardContributeorDTO
     */
    @Transactional(readOnly = true)
    public QmsQualityRewardContributeorDTO queryQmsQualityRewardContributeorByPrimaryKey(String id) {
        QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO = qmsQualityRewardContributeorDAO.findQmsQualityRewardContributeorById(id);
        //记录日志
        if (qmsQualityRewardContributeorDTO != null) {
            valueConvert(Arrays.asList(qmsQualityRewardContributeorDTO));
            SysLogUtil.log4Query(qmsQualityRewardContributeorDTO);
        }
        return qmsQualityRewardContributeorDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsQualityRewardContributeorDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsQualityRewardContributeorDTO> queryQmsQualityRewardContributeorByPid(String pid) {
        List<QmsQualityRewardContributeorDTO> dtoList = qmsQualityRewardContributeorDAO.findQmsQualityRewardContributeorByPid(pid);
        return dtoList;
    }
    /**
     * 新增对象
     *
     * @param qmsQualityRewardContributeorDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsQualityRewardContributeor(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        qmsQualityRewardContributeorDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsQualityRewardContributeorDTO, OpType.insert);
        qmsQualityRewardContributeorDAO.insertQmsQualityRewardContributeor(qmsQualityRewardContributeorDTO);
        //记录日志
        SysLogUtil.log4Insert(qmsQualityRewardContributeorDTO);
        return qmsQualityRewardContributeorDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsQualityRewardContributeorList(List<QmsQualityRewardContributeorDTO> dtoList) {
        for (QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO : dtoList) {
            qmsQualityRewardContributeorDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsQualityRewardContributeorDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsQualityRewardContributeorDAO.insertQmsQualityRewardContributeorList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsQualityRewardContributeorDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityRewardContributeor(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        return updateDto(qmsQualityRewardContributeorDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsQualityRewardContributeorDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsQualityRewardContributeorSensitive(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        return updateDto(qmsQualityRewardContributeorDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsQualityRewardContributeorList(List<QmsQualityRewardContributeorDTO> dtoList) {
        List<QmsQualityRewardContributeorDTO> updateList = new ArrayList<>();
        List<QmsQualityRewardContributeorDTO> oldList = new ArrayList<>();
        for (QmsQualityRewardContributeorDTO dto : dtoList) {
            QmsQualityRewardContributeorDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsQualityRewardContributeorDTO updateDto = (QmsQualityRewardContributeorDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsQualityRewardContributeorDAO.updateQmsQualityRewardContributeorList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsQualityRewardContributeorDTO
     * @return
     */
    private QmsQualityRewardContributeorDTO getUpdateSubDto(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        QmsQualityRewardContributeorDTO oldDTO = findById(qmsQualityRewardContributeorDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getRewardId();
        //记录日志
        SysLogUtil.log4Update(qmsQualityRewardContributeorDTO, oldDTO);
        PojoUtil.setSysProperties(qmsQualityRewardContributeorDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsQualityRewardContributeorDTO, false);
        oldDTO.setRewardId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsQualityRewardContributeorById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        //记录日志
        QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO = findById(id);
        if (qmsQualityRewardContributeorDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityRewardContributeorDTO);
        //删除业务数据
        int count = qmsQualityRewardContributeorDAO.deleteQmsQualityRewardContributeorById(id);
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsQualityRewardContributeorDTO 对象条件
     * @return int
     */
    public int deleteQmsQualityRewardContributeor(QmsQualityRewardContributeorDTO qmsQualityRewardContributeorDTO) {
        //记录日志
        if (qmsQualityRewardContributeorDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsQualityRewardContributeorDTO);
        return qmsQualityRewardContributeorDAO.deleteQmsQualityRewardContributeorById(qmsQualityRewardContributeorDTO.getId());
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsQualityRewardContributeorByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsQualityRewardContributeorById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsQualityRewardContributeorDTO
     */
    private QmsQualityRewardContributeorDTO findById(String id) {
        return qmsQualityRewardContributeorDAO.findQmsQualityRewardContributeorById(id);
    }
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsQualityRewardContributeorDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsQualityRewardContributeorDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsQualityRewardContributeorDTO updateDto = (QmsQualityRewardContributeorDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsQualityRewardContributeorDAO.updateQmsQualityRewardContributeorAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsQualityRewardContributeorDAO.updateQmsQualityRewardContributeorSensitive(dto);
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
     * @param qmsQualityRewardContributeorDTOList
     */
    private void valueConvert(List<QmsQualityRewardContributeorDTO> qmsQualityRewardContributeorDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsQualityRewardContributeorDTO qmsQualityRewardContributeor : qmsQualityRewardContributeorDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityRewardContributeor.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsQualityRewardContributeorDTO qmsQualityRewardContributeor : qmsQualityRewardContributeorDTOList) {
                qmsQualityRewardContributeor.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsQualityRewardContributeor.getSecretLevel()));
            }
        }
    }
}

