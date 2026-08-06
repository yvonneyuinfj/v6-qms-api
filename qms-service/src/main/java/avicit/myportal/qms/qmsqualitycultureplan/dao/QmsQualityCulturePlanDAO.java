package avicit.myportal.qms.qmsqualitycultureplan.dao;

import avicit.myportal.qms.qmsqualitycultureplan.dto.QmsQualityCulturePlanDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-06 15:53
 * @类说明：文化活动计划表Dao
 * @修改记录：
 */
public interface QmsQualityCulturePlanDAO {

	/**
	 * 分页查询
	 * @param qmsQualityCulturePlanDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityCulturePlanDTO>
	 */
	public Page<QmsQualityCulturePlanDTO> searchQmsQualityCulturePlanByPage(@Param("bean") QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityCulturePlanDTO 查询对象
	 * @return List<QmsQualityCulturePlanDTO>
	 */
	public List<QmsQualityCulturePlanDTO> searchQmsQualityCulturePlan(@Param("bean") QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO);

	/**
	 * 按条件导出查询
	 * @param qmsQualityCulturePlanDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityCulturePlanDTO>
	 */
	public List<QmsQualityCulturePlanDTO> searchQmsQualityCulturePlanForExportExcel(@Param("bean") QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityCulturePlanDTO
	 */
	public QmsQualityCulturePlanDTO findQmsQualityCulturePlanById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsQualityCulturePlanDTO>
     */
    public List<QmsQualityCulturePlanDTO> findQmsQualityCulturePlanByPid(String pid);

	/**
	 * 新增
	 * @param qmsQualityCulturePlanDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityCulturePlan(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityCulturePlanList(@Param("dtoList") List<QmsQualityCulturePlanDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityCulturePlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityCulturePlanSensitive(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityCulturePlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityCulturePlanAll(QmsQualityCulturePlanDTO qmsQualityCulturePlanDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityCulturePlanList(@Param("dtoList") List<QmsQualityCulturePlanDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityCulturePlanById(String id);
}