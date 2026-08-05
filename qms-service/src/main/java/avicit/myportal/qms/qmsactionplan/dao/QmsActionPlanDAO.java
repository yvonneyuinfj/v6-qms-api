package avicit.myportal.qms.qmsactionplan.dao;

import avicit.myportal.qms.qmsactionplan.dto.QmsActionPlanDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-04 15:12
* @类说明：通用实施计划表Dao
* @修改记录：
*/
public interface QmsActionPlanDAO {

	/**
	 * 分页查询
	 * @param qmsActionPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsActionPlanDTO>
	 */
	public Page<QmsActionPlanDTO> searchQmsActionPlanByPage(@Param("bean") QmsActionPlanDTO qmsActionPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsActionPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsActionPlanDTO>
	 */
	public List<QmsActionPlanDTO> searchQmsActionPlan(@Param("bean") QmsActionPlanDTO qmsActionPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsActionPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsActionPlanDTO>
	 */
	public List<QmsActionPlanDTO> searchQmsActionPlanForExportExcel(@Param("bean") QmsActionPlanDTO qmsActionPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsActionPlanDTO
	 */
	public QmsActionPlanDTO findQmsActionPlanById(String id);

	/**
	 * 新增
	 * @param qmsActionPlanDTO 保存对象
	 * @return int
	 */
	public int insertQmsActionPlan(QmsActionPlanDTO qmsActionPlanDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsActionPlanList(@Param("dtoList") List<QmsActionPlanDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsActionPlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsActionPlanSensitive(QmsActionPlanDTO qmsActionPlanDTO);

	/**
	 * 更新全部对象
	 * @param qmsActionPlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsActionPlanAll(QmsActionPlanDTO qmsActionPlanDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsActionPlanList(@Param("dtoList") List<QmsActionPlanDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsActionPlanById(String id);
}