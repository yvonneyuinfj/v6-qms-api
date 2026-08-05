package avicit.myportal.qms.qmsqualityobjective.dao;

import avicit.myportal.qms.qmsqualityobjective.dto.QmsQualityObjectiveDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:10
 * @类说明：质量目标台账表Dao
 * @修改记录：
 */
public interface QmsQualityObjectiveDAO {

	/**
	 * 按主键查询
	 * @param id 主键id
	 * @return QmsQualityObjectiveDTO
	 */
	public QmsQualityObjectiveDTO findQmsQualityObjectiveById(String id);

	/**
	 * 按parentId查询
	 * @param parentId
	 * @return
	 */
	public QmsQualityObjectiveDTO findQmsQualityObjectiveByParentId(String parentId);

	/**
	 * 按照父id查询子节点
	 * @param id 父id
	 * @param orgIdentity 组织id
	 * @return List<QmsQualityObjectiveDTO>
	 */
	public List<QmsQualityObjectiveDTO> findChildrenQmsQualityObjectiveById(@Param("id") String id, @Param("orgIdentity") String orgIdentity);

    /**
     * 树层级查询
     * @param treeLevel
     * @return List<QmsQualityObjectiveDTO>
     */
    public List<QmsQualityObjectiveDTO> findQmsQualityObjectiveTreeGridByTreeLevel(@Param("treeLevel") int treeLevel, @Param("orgIdentity") String orgIdentity);

	/**
	 * 按treePath查询
	 * @param treePath
	 * @return List<QmsQualityObjectiveDTO>
	 */
	public List<QmsQualityObjectiveDTO> findQmsQualityObjectiveByTreePath(@Param("treePath") String treePath);

	/**
	 * 根据ids获取所有的节点
	 * @param idsList ids
	 * @return List<QmsQualityObjectiveDTO>
	 */
	List<QmsQualityObjectiveDTO> searchQmsQualityObjectiveByIds(@Param("ids")List<List<String>> idsList);

	/**
	 * 根据条件查询节点
	 * @param qmsQualityObjectiveDTO 查询条件
	 * @return List<QmsQualityObjectiveDTO>
	 */
	public List<QmsQualityObjectiveDTO> searchQmsQualityObjective(@Param("bean") QmsQualityObjectiveDTO qmsQualityObjectiveDTO, @Param("keyWords") String keyWords, @Param("orgIdentity") String orgIdentity);

	/**
	 * 新增
	 * @param tree 保存对象
	 * @return int
	 */
	public int insertQmsQualityObjective(QmsQualityObjectiveDTO tree);

	/**
	 * 更新对象
	 * @param tree 更新对象
	 * @return int
	 */
	public int updateQmsQualityObjectiveSensitive(QmsQualityObjectiveDTO tree);

	/**
	* 更新对象
	* @param tree 更新对象
	* @return int
	*/
	public int updateQmsQualityObjectiveAll(QmsQualityObjectiveDTO tree);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityObjectiveList(@Param("dtoList") List<QmsQualityObjectiveDTO> dtoList);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityObjectiveList(@Param("dtoList") List<QmsQualityObjectiveDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityObjectiveById(String id);

	/**
	 *  查询当前父节点下，子节点中最大的treeSort值
	 * @param parentId
	 * @return
	 */
	public Long findMaxTreeSortByParentId(String parentId);
}