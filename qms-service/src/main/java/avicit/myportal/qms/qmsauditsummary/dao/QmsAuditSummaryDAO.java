package avicit.myportal.qms.qmsauditsummary.dao;

import avicit.myportal.qms.qmsauditsummary.dto.QmsAuditSummaryDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:33
* @类说明：内审综述表Dao
* @修改记录：
*/
public interface QmsAuditSummaryDAO {

	/**
	 * 分页查询
	 * @param qmsAuditSummaryDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditSummaryDTO>
	 */
	public Page<QmsAuditSummaryDTO> searchQmsAuditSummaryByPage(@Param("bean") QmsAuditSummaryDTO qmsAuditSummaryDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditSummaryDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsAuditSummaryDTO>
	 */
	public List<QmsAuditSummaryDTO> searchQmsAuditSummary(@Param("bean") QmsAuditSummaryDTO qmsAuditSummaryDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsAuditSummaryDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditSummaryDTO>
	 */
	public List<QmsAuditSummaryDTO> searchQmsAuditSummaryForExportExcel(@Param("bean") QmsAuditSummaryDTO qmsAuditSummaryDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditSummaryDTO
	 */
	public QmsAuditSummaryDTO findQmsAuditSummaryById(String id);

	/**
	 * 新增
	 * @param qmsAuditSummaryDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditSummary(QmsAuditSummaryDTO qmsAuditSummaryDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditSummaryList(@Param("dtoList") List<QmsAuditSummaryDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditSummaryDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditSummarySensitive(QmsAuditSummaryDTO qmsAuditSummaryDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditSummaryDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditSummaryAll(QmsAuditSummaryDTO qmsAuditSummaryDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditSummaryList(@Param("dtoList") List<QmsAuditSummaryDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditSummaryById(String id);

	public QmsAuditSummaryDTO findQmsAuditSummaryByPlanId(String planId);

	public int deleteQmsAuditSummaryByPlanId(String planId);
}