package avicit.myportal.qms.qmsauditcheckrecord.dao;

import avicit.myportal.qms.qmsauditcheckrecord.dto.QmsAuditCheckRecordDTO;
import avicit.myportal.qms.qmsauditnotice.dto.QmsAuditNoticeDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:32
* @类说明：审核记录表Dao
* @修改记录：
*/
public interface QmsAuditCheckRecordDAO {

	/**
	 * 分页查询
	 * @param qmsAuditCheckRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditCheckRecordDTO>
	 */
	public Page<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecordByPage(@Param("bean") QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditCheckRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsAuditCheckRecordDTO>
	 */
	public List<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecord(@Param("bean") QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsAuditCheckRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditCheckRecordDTO>
	 */
	public List<QmsAuditCheckRecordDTO> searchQmsAuditCheckRecordForExportExcel(@Param("bean") QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditCheckRecordDTO
	 */
	public QmsAuditCheckRecordDTO findQmsAuditCheckRecordById(String id);

	/**
	 * 新增
	 * @param qmsAuditCheckRecordDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditCheckRecord(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditCheckRecordList(@Param("dtoList") List<QmsAuditCheckRecordDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditCheckRecordDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditCheckRecordSensitive(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditCheckRecordDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditCheckRecordAll(QmsAuditCheckRecordDTO qmsAuditCheckRecordDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditCheckRecordList(@Param("dtoList") List<QmsAuditCheckRecordDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditCheckRecordById(String id);

	public QmsAuditCheckRecordDTO findQmsAuditCheckRecordByPlanId(String planId);

	public int deleteQmsAuditCheckRecordByPlanId(String planId);
}