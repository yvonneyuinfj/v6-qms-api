package avicit.myportal.qms.qmsauditnotice.dao;

import avicit.myportal.qms.qmsauditnotice.dto.QmsAuditNoticeDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:30
* @类说明：内审通知单Dao
* @修改记录：
*/
public interface QmsAuditNoticeDAO {

	/**
	 * 分页查询
	 * @param qmsAuditNoticeDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditNoticeDTO>
	 */
	public Page<QmsAuditNoticeDTO> searchQmsAuditNoticeByPage(@Param("bean") QmsAuditNoticeDTO qmsAuditNoticeDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditNoticeDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsAuditNoticeDTO>
	 */
	public List<QmsAuditNoticeDTO> searchQmsAuditNotice(@Param("bean") QmsAuditNoticeDTO qmsAuditNoticeDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsAuditNoticeDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditNoticeDTO>
	 */
	public List<QmsAuditNoticeDTO> searchQmsAuditNoticeForExportExcel(@Param("bean") QmsAuditNoticeDTO qmsAuditNoticeDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditNoticeDTO
	 */
	public QmsAuditNoticeDTO findQmsAuditNoticeById(String id);

	/**
	 * 新增
	 * @param qmsAuditNoticeDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditNotice(QmsAuditNoticeDTO qmsAuditNoticeDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditNoticeList(@Param("dtoList") List<QmsAuditNoticeDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditNoticeDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditNoticeSensitive(QmsAuditNoticeDTO qmsAuditNoticeDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditNoticeDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditNoticeAll(QmsAuditNoticeDTO qmsAuditNoticeDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditNoticeList(@Param("dtoList") List<QmsAuditNoticeDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditNoticeById(String id);


	public int deleteQmsAuditNoticeByPlanId(String planId);

	public QmsAuditNoticeDTO findQmsAuditNoticeByPlanId(String planId);
}