package avicit.myportal.qms.qmsauditplan.dao;

import avicit.myportal.qms.qmsauditplan.dto.QmsAuditPlanDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 18:41
* @类说明：年度内审计划及执行主表Dao
* @修改记录：
*/
public interface QmsAuditPlanDAO {

	/**
	 * 分页查询
	 * @param qmsAuditPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditPlanDTO>
	 */
	public Page<QmsAuditPlanDTO> searchQmsAuditPlanByPage(@Param("bean") QmsAuditPlanDTO qmsAuditPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> searchQmsAuditPlan(@Param("bean") QmsAuditPlanDTO qmsAuditPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsAuditPlanDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditPlanDTO>
	 */
	public List<QmsAuditPlanDTO> searchQmsAuditPlanForExportExcel(@Param("bean") QmsAuditPlanDTO qmsAuditPlanDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditPlanDTO
	 */
	public QmsAuditPlanDTO findQmsAuditPlanById(String id);

	/**
	 * 新增
	 * @param qmsAuditPlanDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditPlan(QmsAuditPlanDTO qmsAuditPlanDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditPlanList(@Param("dtoList") List<QmsAuditPlanDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditPlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditPlanSensitive(QmsAuditPlanDTO qmsAuditPlanDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditPlanDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditPlanAll(QmsAuditPlanDTO qmsAuditPlanDTO);

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
}