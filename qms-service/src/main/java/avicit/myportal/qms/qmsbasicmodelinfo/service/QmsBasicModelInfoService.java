package avicit.myportal.qms.qmsbasicmodelinfo.service;

import avicit.myportal.qms.qmsbasicmodelinfo.dao.QmsBasicModelInfoDAO;
import avicit.myportal.qms.qmsbasicmodelinfo.dto.QmsBasicModelInfoDTO;
import avicit.myportal.qms.qmsbasicmodelinfo.dto.QmsBasicModelInfoImportDTO;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.SysUserClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.platform6.api.sysuser.dto.SysUser;
import avicit.platform6.commons.utils.*;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.Map2Bo;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.Page;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-08 17:12
 * @类说明：QMS_BASIC_MODEL_INFOService
 * @修改记录：
 */
@Service
public class QmsBasicModelInfoService {

    private static final Logger logger = LoggerFactory.getLogger(QmsBasicModelInfoService.class);

    @Autowired
    private QmsBasicModelInfoDAO qmsBasicModelInfoDAO;


    @Autowired
    private ConvertColumnClient convertColumnClient;

    @Autowired
    private SysUserClient sysUserClient;

    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsBasicModelInfoDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsBasicModelInfoDTO> searchQmsBasicModelInfoByPage(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
        QueryRespBean<QmsBasicModelInfoDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsBasicModelInfoDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        // 文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsBasicModelInfoDTO> result = qmsBasicModelInfoDAO.searchQmsBasicModelInfoByPage(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件查询
     *
     * @param queryReqBean 查询条件
     * @return List<QmsBasicModelInfoDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfo(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
        QueryRespBean<QmsBasicModelInfoDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsBasicModelInfoDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        // 文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        List<QmsBasicModelInfoDTO> dataList = qmsBasicModelInfoDAO.searchQmsBasicModelInfo(queryReqBean.getSearchParams(), queryReqBean.getOrgIdentity(), wordSecret);
        valueConvert(dataList);
        return dataList;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @return List<QmsBasicModelInfoDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfoForExportExcel(QueryReqBean<QmsBasicModelInfoDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsBasicModelInfoDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsBasicModelInfoDTO>() {
            });
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsBasicModelInfoDTO> result = qmsBasicModelInfoDAO.searchQmsBasicModelInfoForExportExcel(queryReqBean.getSearchParams(), ThreadContextHelper.getOrgId(), ThreadContextHelper.getWordSecretList(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsBasicModelInfoDTO
     */
    @Transactional(readOnly = true)
    public QmsBasicModelInfoDTO queryQmsBasicModelInfoByPrimaryKey(String id) {
        QmsBasicModelInfoDTO qmsBasicModelInfoDTO = qmsBasicModelInfoDAO.findQmsBasicModelInfoById(id);
        // 记录日志
        if (qmsBasicModelInfoDTO != null) {
            valueConvert(Arrays.asList(qmsBasicModelInfoDTO));
            SysLogUtil.log4Query(qmsBasicModelInfoDTO);
        }
        return qmsBasicModelInfoDTO;
    }

    /**
     * 新增对象
     *
     * @param qmsBasicModelInfoDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsBasicModelInfo(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
        qmsBasicModelInfoDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsBasicModelInfoDTO, OpType.insert);
        qmsBasicModelInfoDAO.insertQmsBasicModelInfo(qmsBasicModelInfoDTO);
        // 记录日志
        SysLogUtil.log4Insert(qmsBasicModelInfoDTO);
        return qmsBasicModelInfoDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsBasicModelInfoList(List<QmsBasicModelInfoDTO> dtoList) {
        for (QmsBasicModelInfoDTO qmsBasicModelInfoDTO : dtoList) {
            qmsBasicModelInfoDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsBasicModelInfoDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsBasicModelInfoDAO.insertQmsBasicModelInfoList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsBasicModelInfoDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsBasicModelInfo(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
        return updateDto(qmsBasicModelInfoDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsBasicModelInfoDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsBasicModelInfoSensitive(QmsBasicModelInfoDTO qmsBasicModelInfoDTO) {
        return updateDto(qmsBasicModelInfoDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsBasicModelInfoList(List<QmsBasicModelInfoDTO> dtoList) {
        List<QmsBasicModelInfoDTO> updateList = new ArrayList<>();
        List<QmsBasicModelInfoDTO> oldList = new ArrayList<>();
        for (QmsBasicModelInfoDTO dto : dtoList) {
            QmsBasicModelInfoDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsBasicModelInfoDTO updateDto = (QmsBasicModelInfoDTO) old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsBasicModelInfoDAO.updateQmsBasicModelInfoList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsBasicModelInfoById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        // 记录日志
        QmsBasicModelInfoDTO qmsBasicModelInfoDTO = findById(id);
        if (qmsBasicModelInfoDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsBasicModelInfoDTO);
        // 删除业务数据
        int count = qmsBasicModelInfoDAO.deleteQmsBasicModelInfoById(id);
        return count;
    }

    /**
     * 批量删除数据
     *
     * @param ids id的数组
     * @return int
     */
    @Transactional
    public int deleteQmsBasicModelInfoByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsBasicModelInfoById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return QmsBasicModelInfoDTO
     */
    private QmsBasicModelInfoDTO findById(String id) {
        return qmsBasicModelInfoDAO.findQmsBasicModelInfoById(id);
    }

    /**
     * 内部方法，
     *
     * @param dto             修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsBasicModelInfoDTO dto, Boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsBasicModelInfoDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsBasicModelInfoDTO updateDto = (QmsBasicModelInfoDTO) old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsBasicModelInfoDAO.updateQmsBasicModelInfoAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsBasicModelInfoDAO.updateQmsBasicModelInfoSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }

    /**
     * 批量导入
     *
     * @return
     */
    @Transactional
    public ExcelImportResult importData(List<Map<String, String>> dataList, String formData) {
        List<QmsBasicModelInfoDTO> qmsBasicModelInfoSuccessList = new ArrayList<QmsBasicModelInfoDTO>();
        List<QmsBasicModelInfoImportDTO> qmsBasicModelInfoErrList = new ArrayList<QmsBasicModelInfoImportDTO>();
        Map<String, Object> formDataMap = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(formData)) {
            formDataMap = JsonUtil.parseJSON2Map(formData);
        }
        if (!CollectionUtils.isEmpty(dataList)) {
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
            for (Map<String, String> data : dataList) {
                if (StringUtils.isEmpty(data.get("errorInfo"))) {
                    // 业务校验
                    QmsBasicModelInfoDTO dto = new QmsBasicModelInfoDTO();
                    Map2Bo.map2Pojo(data, dto);
                    qmsBasicModelInfoSuccessList.add(dto);
                } else {
                    QmsBasicModelInfoImportDTO dtoImp = new QmsBasicModelInfoImportDTO();
                    Map2Bo.map2Pojo(data, dtoImp);
                    qmsBasicModelInfoErrList.add(dtoImp);
                }
            }
            this.handleImport(qmsBasicModelInfoSuccessList);
            this.revValueConvert(qmsBasicModelInfoSuccessList, convertResultData);
            this.insertQmsBasicModelInfoList(qmsBasicModelInfoSuccessList);
        }
        ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsBasicModelInfoSuccessList, qmsBasicModelInfoErrList, QmsBasicModelInfoImportDTO.class, formDataMap);
        return excelImport;
    }

    private void handleImport(List<QmsBasicModelInfoDTO> dtoList) {
        for (QmsBasicModelInfoDTO dto : dtoList) {
            if (StringUtils.isNotEmpty(dto.getMilRepCode()) && StringUtils.isEmpty(dto.getMilRepId())) {
                // 根据职工号获取用户
                String[] codes = dto.getMilRepCode().trim().split("\\s*[，,；; ]\\s*");
                dto.setMilRepId(getUserIdByCode(codes));
                dto.setMilRepName(getUserNameByCode(codes));
            }
            if (StringUtils.isNotEmpty(dto.getDeputyChiefDesignerCode()) && StringUtils.isEmpty(dto.getDeputyChiefDesignerId())) {
                String[] codes = dto.getDeputyChiefDesignerCode().trim().split("\\s*[，,；; ]\\s*");
                dto.setDeputyChiefDesignerId(getUserIdByCode(codes));
                dto.setDeputyChiefDesignerName(getUserNameByCode(codes));
            }
            if (StringUtils.isNotEmpty(dto.getRdManagerCode()) && StringUtils.isEmpty(dto.getRdManagerId())) {
                String[] codes = dto.getRdManagerCode().trim().split("\\s*[，,；; ]\\s*");
                dto.setRdManagerId(getUserIdByCode(codes));
                dto.setRdManagerName(getUserNameByCode(codes));
            }
            if (StringUtils.isNotEmpty(dto.getQaManagerCode()) && StringUtils.isEmpty(dto.getQaManagerId())) {
                String[] codes = dto.getQaManagerCode().trim().split("\\s*[，,；; ]\\s*");
                dto.setQaManagerId(getUserIdByCode(codes));
                dto.setQaManagerName(getUserNameByCode(codes));
            }
        }
    }


    private String getUserIdByCode(String[] userCodes) {
        StringBuilder milRepId = new StringBuilder();
        for (String userCode : userCodes) {
            SysUser user = sysUserClient.getSysUserByLoginName(userCode);
            if (user != null) {
                milRepId.append(user.getId()).append(";");
            }
        }
        if (milRepId.length() > 0) {
            milRepId.deleteCharAt(milRepId.length() - 1);
        }
        return milRepId.toString();
    }

    private String getUserNameByCode(String[] userCodes) {
        StringBuilder milRepName = new StringBuilder();
        for (String userCode : userCodes) {
            SysUser user = sysUserClient.getSysUserByLoginName(userCode);
            if (user != null) {
                milRepName.append(user.getName()).append(";");
            }
        }
        if (milRepName.length() > 0) {
            milRepName.deleteCharAt(milRepName.length() - 1);
        }
        return milRepName.toString();
    }


    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsBasicModelInfoDTOList
     */
    private void valueConvert(List<QmsBasicModelInfoDTO> qmsBasicModelInfoDTOList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsBasicModelInfoDTO qmsBasicModelInfo : qmsBasicModelInfoDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsBasicModelInfo.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            // 获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            // 循环设置Alias或Name的值
            for (QmsBasicModelInfoDTO qmsBasicModelInfo : qmsBasicModelInfoDTOList) {
                qmsBasicModelInfo.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsBasicModelInfo.getSecretLevel()));
            }
        }
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsBasicModelInfoDTOList
     */
    private void revValueConvert(List<QmsBasicModelInfoDTO> qmsBasicModelInfoDTOList, Map<String, Map<String, String>> convertResultData) {
        // 循环设置Alias或Name的值
        for (QmsBasicModelInfoDTO qmsBasicModelInfo : qmsBasicModelInfoDTOList) {
            qmsBasicModelInfo.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsBasicModelInfo.getSecretLevelName()));
        }
    }

    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码提前组装数据
     *
     * @param dataList
     */
    private Map<String, Map<String, String>> assembleData(List<Map<String, String>> dataList) {
        // 循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (Map<String, String> data : dataList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", data.get("secretLevelName"));
        }
        return convertColumnClient.convertCodeToId(convertFormData);
    }
}

