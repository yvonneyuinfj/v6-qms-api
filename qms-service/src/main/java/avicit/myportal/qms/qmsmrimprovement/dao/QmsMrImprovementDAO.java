package avicit.myportal.qms.qmsmrimprovement.dao;

import avicit.myportal.qms.qmsmrimprovement.dto.QmsMrImprovementDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:45
* @类说明：管评改进项台账Dao
* @修改记录：
*/
public interface QmsMrImprovementDAO {

	/**
	 * 分页查询
	 * @param qmsMrImprovementDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMrImprovementDTO>
	 */
	public Page<QmsMrImprovementDTO> searchQmsMrImprovementByPage(@Param("bean") QmsMrImprovementDTO qmsMrImprovementDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMrImprovementDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMrImprovementDTO>
	 */
	public List<QmsMrImprovementDTO> searchQmsMrImprovement(@Param("bean") QmsMrImprovementDTO qmsMrImprovementDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMrImprovementDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMrImprovementDTO>
	 */
	public List<QmsMrImprovementDTO> searchQmsMrImprovementForExportExcel(@Param("bean") QmsMrImprovementDTO qmsMrImprovementDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMrImprovementDTO
	 */
	public QmsMrImprovementDTO findQmsMrImprovementById(String id);

	/**
	 * 新增
	 * @param qmsMrImprovementDTO 保存对象
	 * @return int
	 */
	public int insertQmsMrImprovement(QmsMrImprovementDTO qmsMrImprovementDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMrImprovementList(@Param("dtoList") List<QmsMrImprovementDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMrImprovementDTO 更新对象
	 * @return int
	 */
	public int updateQmsMrImprovementSensitive(QmsMrImprovementDTO qmsMrImprovementDTO);

	/**
	 * 更新全部对象
	 * @param qmsMrImprovementDTO 更新对象
	 * @return int
	 */
	public int updateQmsMrImprovementAll(QmsMrImprovementDTO qmsMrImprovementDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMrImprovementList(@Param("dtoList") List<QmsMrImprovementDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMrImprovementById(String id);
}