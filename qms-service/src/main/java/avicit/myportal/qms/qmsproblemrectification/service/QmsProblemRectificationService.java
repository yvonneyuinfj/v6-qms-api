package avicit.myportal.qms.qmsproblemrectification.service;

import avicit.platform6.core.exception.BusinessException;
import avicit.platform6.core.context.ThreadContextHelper;
import avicit.platform6.core.excel.ExcelUtil;
import avicit.platform6.core.excel.Map2Bo;
import avicit.platform6.core.excel.imp.entity.ExcelImportResult;
import avicit.platform6.modules.system.syslog.service.SysLogUtil;
import avicit.platform6.core.mybatis.pagehelper.PageHelper;
import avicit.platform6.core.properties.PlatformConstant.OpType;
import avicit.platform6.core.rest.msg.QueryReqBean;
import avicit.platform6.core.rest.msg.QueryRespBean;
import avicit.platform6.commons.utils.*;
import avicit.platform6.api.system.OssClient;
import avicit.platform6.api.system.ConvertColumnClient;
import avicit.platform6.api.system.impl.SystemConstant;
import avicit.myportal.qms.qmsproblemrectification.dao.QmsProblemRectificationDAO;
import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationDTO;
import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationImportDTO;
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
 * @创建时间： 2026-08-05 18:14
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsProblemRectificationService  {

	 private static final Logger logger = LoggerFactory.getLogger(QmsProblemRectificationService.class);

    @Autowired
    private QmsProblemRectificationDAO qmsProblemRectificationDAO;
    @Autowired
    private OssClient ossClient;


    @Autowired
    private ConvertColumnClient convertColumnClient;
    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsProblemRectificationDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsProblemRectificationDTO> searchQmsProblemRectificationByPage(QueryReqBean<QmsProblemRectificationDTO> queryReqBean) {
        QueryRespBean<QmsProblemRectificationDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsProblemRectificationDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsProblemRectificationDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsProblemRectificationDTO>() {
            });
            searchKeyWordParam.setCheckProblemId(queryReqBean.getSearchParams().getCheckProblemId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getCheckProblemId())) {
            queryReqBean.getSearchParams().setCheckProblemId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsProblemRectificationDTO> result = qmsProblemRectificationDAO.searchQmsProblemRectificationByPage(queryReqBean.getSearchParams(),  wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @return List<QmsProblemRectificationDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsProblemRectificationDTO> searchQmsProblemRectificationForExportExcel(QueryReqBean<QmsProblemRectificationDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsProblemRectificationDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsProblemRectificationDTO>() {
            });
            searchKeyWordParam.setCheckProblemId(queryReqBean.getSearchParams().getCheckProblemId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsProblemRectificationDTO> result=qmsProblemRectificationDAO.searchQmsProblemRectificationForExportExcel(queryReqBean.getSearchParams(),  new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsProblemRectificationDTO
     */
    @Transactional(readOnly = true)
    public QmsProblemRectificationDTO queryQmsProblemRectificationByPrimaryKey(String id) {
        QmsProblemRectificationDTO qmsProblemRectificationDTO = qmsProblemRectificationDAO.findQmsProblemRectificationById(id);
        //记录日志
        if (qmsProblemRectificationDTO != null) {
            valueConvert(Arrays.asList(qmsProblemRectificationDTO));
            SysLogUtil.log4Query(qmsProblemRectificationDTO);
        }
        return qmsProblemRectificationDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsProblemRectificationDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsProblemRectificationDTO> queryQmsProblemRectificationByPid(String pid) {
        List<QmsProblemRectificationDTO> dtoList = qmsProblemRectificationDAO.findQmsProblemRectificationByPid(pid);
        return dtoList;
    }
    /**
     * 新增对象
     *
     * @param qmsProblemRectificationDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsProblemRectification(QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        qmsProblemRectificationDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsProblemRectificationDTO, OpType.insert);
        qmsProblemRectificationDAO.insertQmsProblemRectification(qmsProblemRectificationDTO);
        //记录日志
        SysLogUtil.log4Insert(qmsProblemRectificationDTO);
        return qmsProblemRectificationDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsProblemRectificationList(List<QmsProblemRectificationDTO> dtoList) {
        for (QmsProblemRectificationDTO qmsProblemRectificationDTO : dtoList) {
            qmsProblemRectificationDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsProblemRectificationDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsProblemRectificationDAO.insertQmsProblemRectificationList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsProblemRectificationDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsProblemRectification(QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        return updateDto(qmsProblemRectificationDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsProblemRectificationDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsProblemRectificationSensitive(QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        return updateDto(qmsProblemRectificationDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsProblemRectificationList(List<QmsProblemRectificationDTO> dtoList) {
        List<QmsProblemRectificationDTO> updateList = new ArrayList<>();
        List<QmsProblemRectificationDTO> oldList = new ArrayList<>();
        for (QmsProblemRectificationDTO dto : dtoList) {
            QmsProblemRectificationDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsProblemRectificationDTO updateDto = (QmsProblemRectificationDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsProblemRectificationDAO.updateQmsProblemRectificationList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsProblemRectificationDTO
     * @return
     */
    private QmsProblemRectificationDTO getUpdateSubDto(QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        QmsProblemRectificationDTO oldDTO = findById(qmsProblemRectificationDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getCheckProblemId();
        //记录日志
        SysLogUtil.log4Update(qmsProblemRectificationDTO, oldDTO);
        PojoUtil.setSysProperties(qmsProblemRectificationDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsProblemRectificationDTO, false);
        oldDTO.setCheckProblemId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsProblemRectificationById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        //记录日志
        QmsProblemRectificationDTO qmsProblemRectificationDTO = findById(id);
        if (qmsProblemRectificationDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsProblemRectificationDTO);
        //删除业务数据
        int count = qmsProblemRectificationDAO.deleteQmsProblemRectificationById(id);
        //删除附件
        ossClient.deleteAttachByFormId(qmsProblemRectificationDTO.getId());
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsProblemRectificationDTO 对象条件
     * @return int
     */
    public int deleteQmsProblemRectification(QmsProblemRectificationDTO qmsProblemRectificationDTO) {
        //记录日志
        if (qmsProblemRectificationDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsProblemRectificationDTO);
        return qmsProblemRectificationDAO.deleteQmsProblemRectificationById(qmsProblemRectificationDTO.getId());
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsProblemRectificationByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsProblemRectificationById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsProblemRectificationDTO
     */
    private QmsProblemRectificationDTO findById(String id) {
        return qmsProblemRectificationDAO.findQmsProblemRectificationById(id);
    }
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsProblemRectificationDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsProblemRectificationDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsProblemRectificationDTO updateDto = (QmsProblemRectificationDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsProblemRectificationDAO.updateQmsProblemRectificationAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsProblemRectificationDAO.updateQmsProblemRectificationSensitive(dto);
        }
        if (ret == 0) {
            throw new BusinessException("数据失效，请重新更新");
        }
        SysLogUtil.log4Update(updateDto, old);
        return ret;
    }
    /**
	 * 批量导入
	 * @return
	 */
	@Transactional
	public ExcelImportResult importData(List<Map<String, String>> dataList, String formData) {
		List<QmsProblemRectificationDTO> qmsProblemRectificationSuccessList = new ArrayList<QmsProblemRectificationDTO>();
		List<QmsProblemRectificationImportDTO> qmsProblemRectificationErrList = new ArrayList<QmsProblemRectificationImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsProblemRectificationDTO dto = new QmsProblemRectificationDTO();
					Map2Bo.map2Pojo(data,dto);
					dto.setCheckProblemId(formDataMap.get("checkProblemId").toString());
					qmsProblemRectificationSuccessList.add(dto);
				} else {
					QmsProblemRectificationImportDTO dtoImp = new QmsProblemRectificationImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsProblemRectificationErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsProblemRectificationSuccessList, convertResultData);
			this.insertQmsProblemRectificationList(qmsProblemRectificationSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsProblemRectificationSuccessList,qmsProblemRectificationErrList,QmsProblemRectificationImportDTO.class,formDataMap);
		return excelImport;
	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsProblemRectificationDTOList
     */
    private void valueConvert(List<QmsProblemRectificationDTO> qmsProblemRectificationDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsProblemRectificationDTO qmsProblemRectification : qmsProblemRectificationDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsProblemRectification.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsProblemRectificationDTO qmsProblemRectification : qmsProblemRectificationDTOList) {
                qmsProblemRectification.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsProblemRectification.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsProblemRectificationDTOList
     */
    private void revValueConvert(List<QmsProblemRectificationDTO> qmsProblemRectificationDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsProblemRectificationDTO qmsProblemRectification : qmsProblemRectificationDTOList) {
            qmsProblemRectification.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsProblemRectification.getSecretLevelName()));
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码提前组装数据
     *
     * @param dataList
     */
    private  Map<String, Map<String, String>> assembleData(List<Map<String, String>> dataList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (Map<String, String> data : dataList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", data.get("secretLevelName"));
        }
        return  convertColumnClient.convertCodeToId(convertFormData);
    }
}

