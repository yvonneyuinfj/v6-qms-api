package avicit.myportal.qms.qmscheckproblem.service;

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
import avicit.myportal.qms.qmscheckproblem.dao.QmsCheckProblemDAO;
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemDTO;
import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemImportDTO;
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
 * @创建时间： 2026-08-05 18:17
 * @类说明：
 * @修改记录：
 */
@Service
public class QmsCheckProblemService  {

	 private static final Logger logger = LoggerFactory.getLogger(QmsCheckProblemService.class);

    @Autowired
    private QmsCheckProblemDAO qmsCheckProblemDAO;
    @Autowired
    private OssClient ossClient;


    @Autowired
    private ConvertColumnClient convertColumnClient;
    /**
     * 按条件分页查询
     *
     * @param queryReqBean 查询条件
     * @return QueryRespBean<QmsCheckProblemDTO>
     */
    @Transactional(readOnly = true)
    public QueryRespBean<QmsCheckProblemDTO> searchQmsCheckProblemByPage(QueryReqBean<QmsCheckProblemDTO> queryReqBean) {
        QueryRespBean<QmsCheckProblemDTO> queryRespBean = new QueryRespBean<>();
        if (StringUtils.isNotEmpty(queryReqBean.getSidx()) && StringUtils.isNotEmpty(queryReqBean.getSord())) {
            String sordExp = BusinessUtil.getSortExpColumnName(queryReqBean.getSidx(), queryReqBean.getSord(), QmsCheckProblemDTO.class);
            if (StringUtils.isNotEmpty(sordExp)) {
                queryReqBean.setSortExp(sordExp);
            }
        }
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsCheckProblemDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsCheckProblemDTO>() {
            });
            searchKeyWordParam.setSourceId(queryReqBean.getSearchParams().getSourceId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        if (queryReqBean.getSearchParams() != null && StringUtils.isEmpty(queryReqBean.getSearchParams().getSourceId())) {
            queryReqBean.getSearchParams().setSourceId("-1");
        }
        PageHelper.startPage(queryReqBean.getPageParameter());
        //文档密级
        List<String> wordSecret = ThreadContextHelper.getWordSecretList();

        Page<QmsCheckProblemDTO> result = qmsCheckProblemDAO.searchQmsCheckProblemByPage(queryReqBean.getSearchParams(),  wordSecret, queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result.getResult());
        queryRespBean.setResult(result);
        return queryRespBean;
    }

    /**
     * 按条件导出
     *
     * @param queryReqBean 查询条件
     * @return List<QmsCheckProblemDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsCheckProblemDTO> searchQmsCheckProblemForExportExcel(QueryReqBean<QmsCheckProblemDTO> queryReqBean) {
        if (StringUtils.isNotEmpty(queryReqBean.getKeyWord())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            QmsCheckProblemDTO searchKeyWordParam = JsonHelper.getInstance().readValue(queryReqBean.getKeyWord(), dateFormat, new TypeReference<QmsCheckProblemDTO>() {
            });
            searchKeyWordParam.setSourceId(queryReqBean.getSearchParams().getSourceId());
            queryReqBean.setSearchParams(searchKeyWordParam);
        }
        List<QmsCheckProblemDTO> result=qmsCheckProblemDAO.searchQmsCheckProblemForExportExcel(queryReqBean.getSearchParams(),  new ArrayList<String>(), queryReqBean.getSortExp(), queryReqBean.getKeyWord());
        valueConvert(result);
        return result;
    }

    /**
     * 通过主键查询单条记录
     *
     * @param id 主键id
     * @return QmsCheckProblemDTO
     */
    @Transactional(readOnly = true)
    public QmsCheckProblemDTO queryQmsCheckProblemByPrimaryKey(String id) {
        QmsCheckProblemDTO qmsCheckProblemDTO = qmsCheckProblemDAO.findQmsCheckProblemById(id);
        //记录日志
        if (qmsCheckProblemDTO != null) {
            valueConvert(Arrays.asList(qmsCheckProblemDTO));
            SysLogUtil.log4Query(qmsCheckProblemDTO);
        }
        return qmsCheckProblemDTO;
    }

    /**
     * 通过父键查询单条记录
     *
     * @param pid 父id
     * @return List<QmsCheckProblemDTO>
     */
    @Transactional(readOnly = true)
    public List<QmsCheckProblemDTO> queryQmsCheckProblemByPid(String pid) {
        List<QmsCheckProblemDTO> dtoList = qmsCheckProblemDAO.findQmsCheckProblemByPid(pid);
        return dtoList;
    }
    /**
     * 新增对象
     *
     * @param qmsCheckProblemDTO 保存对象
     * @return String
     */
    @Transactional
    public String insertQmsCheckProblem(QmsCheckProblemDTO qmsCheckProblemDTO) {
        qmsCheckProblemDTO.setId(ComUtil.getId());
        PojoUtil.setSysProperties(qmsCheckProblemDTO, OpType.insert);
        qmsCheckProblemDAO.insertQmsCheckProblem(qmsCheckProblemDTO);
        //记录日志
        SysLogUtil.log4Insert(qmsCheckProblemDTO);
        return qmsCheckProblemDTO.getId();
    }

    /**
     * 批量新增对象
     *
     * @param dtoList 保存对象集合
     * @return int
     */
    @Transactional
    public int insertQmsCheckProblemList(List<QmsCheckProblemDTO> dtoList) {
        for (QmsCheckProblemDTO qmsCheckProblemDTO : dtoList) {
            qmsCheckProblemDTO.setId(ComUtil.getId());
            PojoUtil.setSysProperties(qmsCheckProblemDTO, OpType.insert);
        }
        ListUtils.partition(dtoList, 50).forEach(subList -> {
            qmsCheckProblemDAO.insertQmsCheckProblemList(subList);
        });
        // 记录日志
        SysLogUtil.log4Insert(dtoList);
        return dtoList.size();
    }

    /**
     * 修改对象全部字段
     *
     * @param qmsCheckProblemDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsCheckProblem(QmsCheckProblemDTO qmsCheckProblemDTO) {
        return updateDto(qmsCheckProblemDTO, true);
    }

    /**
     * 修改对象部分字段
     *
     * @param qmsCheckProblemDTO 修改对象
     * @return int
     */
    @Transactional
    public int updateQmsCheckProblemSensitive(QmsCheckProblemDTO qmsCheckProblemDTO) {
        return updateDto(qmsCheckProblemDTO, false);
    }

    /**
     * 批量更新对象
     *
     * @param dtoList 修改对象集合
     * @return int
     */
    @Transactional
    public int updateQmsCheckProblemList(List<QmsCheckProblemDTO> dtoList) {
        List<QmsCheckProblemDTO> updateList = new ArrayList<>();
        List<QmsCheckProblemDTO> oldList = new ArrayList<>();
        for (QmsCheckProblemDTO dto : dtoList) {
            QmsCheckProblemDTO old = findById(dto.getId());
            if (old == null) {
                throw new BusinessException("修改对象不存在!");
            }
            QmsCheckProblemDTO updateDto = (QmsCheckProblemDTO)old.clone();
            PojoUtil.setSysProperties(dto, OpType.update);
            PojoUtil.copyProperties(updateDto, dto, false);
            updateList.add(updateDto);
            oldList.add(old);
        }
        ListUtils.partition(updateList, 50).forEach(subList -> {
            qmsCheckProblemDAO.updateQmsCheckProblemList(subList);
        });
        // 记录日志
        SysLogUtil.log4Update(updateList, oldList);
        return updateList.size();
    }

    /**
     * 内部方法，获取修改的dto对象
     *
     * @param qmsCheckProblemDTO
     * @return
     */
    private QmsCheckProblemDTO getUpdateSubDto(QmsCheckProblemDTO qmsCheckProblemDTO) {
        QmsCheckProblemDTO oldDTO = findById(qmsCheckProblemDTO.getId());
        if (oldDTO == null) {
            throw new BusinessException("数据不存在");
        }
        String cid = oldDTO.getSourceId();
        //记录日志
        SysLogUtil.log4Update(qmsCheckProblemDTO, oldDTO);
        PojoUtil.setSysProperties(qmsCheckProblemDTO, OpType.update);
        PojoUtil.copyProperties(oldDTO, qmsCheckProblemDTO, false);
        oldDTO.setSourceId(cid);
        return oldDTO;
    }

    /**
     * 按主键单条删除
     *
     * @param id 主键id
     * @return int
     */
    @Transactional
    public int deleteQmsCheckProblemById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("删除失败！传入的参数主键为null");
        }
        //记录日志
        QmsCheckProblemDTO qmsCheckProblemDTO = findById(id);
        if (qmsCheckProblemDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsCheckProblemDTO);
        //删除业务数据
        int count = qmsCheckProblemDAO.deleteQmsCheckProblemById(id);
        //删除附件
        ossClient.deleteAttachByFormId(qmsCheckProblemDTO.getId());
        return count;
    }

    /**
     * 按条件删除数据
     *
     * @param qmsCheckProblemDTO 对象条件
     * @return int
     */
    public int deleteQmsCheckProblem(QmsCheckProblemDTO qmsCheckProblemDTO) {
        //记录日志
        if (qmsCheckProblemDTO == null) {
            throw new BusinessException("删除失败！对象不存在");
        }
        SysLogUtil.log4Delete(qmsCheckProblemDTO);
        return qmsCheckProblemDAO.deleteQmsCheckProblemById(qmsCheckProblemDTO.getId());
    }

    /**
     * 批量删除数据
     *
     * @param ids 逗号分隔的id串
     * @return int
     */
    @Transactional
    public int deleteQmsCheckProblemByIds(String[] ids) {
        int result = 0;
        for (String id : ids) {
            deleteQmsCheckProblemById(id);
            result++;
        }
        return result;
    }

    /**
     * 日志专用，内部方法，不再记录日志
     *
     * @param id 主键id
     * @return qmsCheckProblemDTO
     */
    private QmsCheckProblemDTO findById(String id) {
        return qmsCheckProblemDAO.findQmsCheckProblemById(id);
    }
    /**
     * 内部方法，
     *
     * @param dto 修改对象
     * @param isUpdateAllProp 更新全部字段是为true，更新部分字段为false
     * @return
     */
    private int updateDto(QmsCheckProblemDTO dto, boolean isUpdateAllProp) {
        if (dto == null) {
            throw new BusinessException("修改对象不能为空！");
        }
        if (StringUtils.isEmpty(dto.getId())) {
            throw new BusinessException("修改对象的id不能为空！");
        }
        QmsCheckProblemDTO old = findById(dto.getId());
        if (old == null) {
            throw new BusinessException("修改对象不存在！");
        }
        QmsCheckProblemDTO updateDto = (QmsCheckProblemDTO)old.clone();
        PojoUtil.setSysProperties(dto, OpType.update);
        int ret = 0;
        if (isUpdateAllProp) {
            PojoUtil.copyProperties(updateDto, dto, false);
            ret = qmsCheckProblemDAO.updateQmsCheckProblemAll(updateDto);
        } else {
            PojoUtil.copyProperties(updateDto, dto, true);
            ret = qmsCheckProblemDAO.updateQmsCheckProblemSensitive(dto);
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
		List<QmsCheckProblemDTO> qmsCheckProblemSuccessList = new ArrayList<QmsCheckProblemDTO>();
		List<QmsCheckProblemImportDTO> qmsCheckProblemErrList = new ArrayList<QmsCheckProblemImportDTO>();
		Map<String, Object> formDataMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(formData)){
			formDataMap = JsonUtil.parseJSON2Map(formData);
		}
		if(!CollectionUtils.isEmpty(dataList)){
            Map<String, Map<String, String>> convertResultData = this.assembleData(dataList);
			for (Map<String, String> data:dataList) {
				if(StringUtils.isEmpty(data.get("errorInfo"))){
					//业务校验
					QmsCheckProblemDTO dto = new QmsCheckProblemDTO();
					Map2Bo.map2Pojo(data,dto);
					dto.setSourceId(formDataMap.get("sourceId").toString());
					qmsCheckProblemSuccessList.add(dto);
				} else {
					QmsCheckProblemImportDTO dtoImp = new QmsCheckProblemImportDTO();
					Map2Bo.map2Pojo(data,dtoImp);
					qmsCheckProblemErrList.add(dtoImp);
				}
			}
            this.revValueConvert(qmsCheckProblemSuccessList, convertResultData);
			this.insertQmsCheckProblemList(qmsCheckProblemSuccessList);
		}
		ExcelImportResult excelImport = ExcelUtil.createUploadHis(qmsCheckProblemSuccessList,qmsCheckProblemErrList,QmsCheckProblemImportDTO.class,formDataMap);
		return excelImport;
	}
    /**
     * 通过平台API将字段值转换为名称，包括通用选择组件、通用代码
     *
     * @param qmsCheckProblemDTOList
     */
    private void valueConvert(List<QmsCheckProblemDTO> qmsCheckProblemDTOList) {
        //循环组装请求数据
        Map<String, Set<String>> convertFormData = new HashMap<>();
        for (QmsCheckProblemDTO qmsCheckProblem : qmsCheckProblemDTOList) {
            BusinessUtil.createConvertSet(convertFormData, "PLATFORM_FILE_SECRET_LEVEL", qmsCheckProblem.getSecretLevel());
        }
        if (convertFormData.size() > 0) {
            //获取请求结果
            Map<String, Map<String, String>> convertResultData = convertColumnClient.replace(convertFormData);
            //循环设置Alias或Name的值
            for (QmsCheckProblemDTO qmsCheckProblem : qmsCheckProblemDTOList) {
                qmsCheckProblem.setSecretLevelName(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsCheckProblem.getSecretLevel()));
            }
        }
    }
    /**
     * 通过平台API将字段名称转换为值，包括通用选择组件、通用代码
     * 基础数据中用户默认使用用户编号转换，部门、岗位、角色默认使用编码进行转换，群组使用名称进行转换
     *
     * @param qmsCheckProblemDTOList
     */
    private void revValueConvert(List<QmsCheckProblemDTO> qmsCheckProblemDTOList, Map<String, Map<String, String>> convertResultData) {
        //循环设置Alias或Name的值
        for (QmsCheckProblemDTO qmsCheckProblem : qmsCheckProblemDTOList) {
            qmsCheckProblem.setSecretLevel(BusinessUtil.convertFormat(convertResultData, "PLATFORM_FILE_SECRET_LEVEL", qmsCheckProblem.getSecretLevelName()));
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

