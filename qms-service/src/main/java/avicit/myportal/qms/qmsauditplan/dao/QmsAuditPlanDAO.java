package avicit.myportal.qms.qmsauditplan.dao;

import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:28
 * @类说明：年度内审计划及执行主表Dao
 * @修改记录：
 */
public interface QmsAuditPlanDAO {

	/**
	 * 按主键查询
	 * @param id 主键id
	 * @return QmsAuditPlanDTO
	 */
	public QmsAuditPlanDTO findQmsAuditPlanById(String id);

	/**
	 * 按照父id查询子节点
	 * @param id 父id
	 * @param orgIdentity 组织id
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> findChildrenQmsAuditPlanById(@Param("id") String id, @Param("orgIdentity") String orgIdentity);

    /**
     * 树层级查询
     * @param treeLevel
     * @return List<QmsAuditPlanDTO>
     */
    public List<QmsAuditPlanDTO> findQmsAuditPlanTreeGridByTreeLevel(@Param("treeLevel") int treeLevel, @Param("orgIdentity") String orgIdentity);

	/**
	 * 按treePath查询
	 * @param treePath
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> findQmsAuditPlanByTreePath(@Param("treePath") String treePath);

	/**
	 * 根据ids获取所有的节点
	 * @param idsList ids
	 * @return List<QmsAuditPlanDTO>
	 */
	List<QmsAuditPlanDTO> searchQmsAuditPlanByIds(@Param("ids")List<List<String>> idsList);

	/**
	 * 根据条件查询节点
	 * @param qmsAuditPlanDTO 查询条件
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> searchQmsAuditPlan(@Param("bean") QmsAuditPlanDTO qmsAuditPlanDTO, @Param("keyWords") String keyWords, @Param("orgIdentity") String orgIdentity);

	/**
	 * 新增
	 * @param tree 保存对象
	 * @return int
	 */
	public int insertQmsAuditPlan(QmsAuditPlanDTO tree);

	/**
	 * 更新对象
	 * @param tree 更新对象
	 * @return int
	 */
	public int updateQmsAuditPlanSensitive(QmsAuditPlanDTO tree);

	/**
	* 更新对象
	* @param tree 更新对象
	* @return int
	*/
	public int updateQmsAuditPlanAll(QmsAuditPlanDTO tree);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditPlanList(@Param("dtoList") List<QmsAuditPlanDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditPlanById(String id);

	/**
	 *  查询当前父节点下，子节点中最大的treeSort值
	 * @param parentId
	 * @return
	 */
	public Long findMaxTreeSortByParentId(String parentId);
}