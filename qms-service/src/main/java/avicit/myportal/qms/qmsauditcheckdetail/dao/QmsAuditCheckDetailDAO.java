package avicit.myportal.qms.qmsauditcheckdetail.dao;

import avicit.myportal.qms.qmsauditcheckdetail.dto.QmsAuditCheckDetailDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-03 19:32
 * @类说明：审核检查明细表Dao
 * @修改记录：
 */
public interface QmsAuditCheckDetailDAO {

	/**
	 * 分页查询
	 * @param qmsAuditCheckDetailDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditCheckDetailDTO>
	 */
	public Page<QmsAuditCheckDetailDTO> searchQmsAuditCheckDetailByPage(@Param("bean") QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditCheckDetailDTO 查询对象
	 * @return List<QmsAuditCheckDetailDTO>
	 */
	public List<QmsAuditCheckDetailDTO> searchQmsAuditCheckDetail(@Param("bean") QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO);

	/**
	 * 按条件导出查询
	 * @param qmsAuditCheckDetailDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditCheckDetailDTO>
	 */
	public List<QmsAuditCheckDetailDTO> searchQmsAuditCheckDetailForExportExcel(@Param("bean") QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditCheckDetailDTO
	 */
	public QmsAuditCheckDetailDTO findQmsAuditCheckDetailById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsAuditCheckDetailDTO>
     */
    public List<QmsAuditCheckDetailDTO> findQmsAuditCheckDetailByPid(String pid);

	/**
	 * 新增
	 * @param qmsAuditCheckDetailDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditCheckDetail(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditCheckDetailList(@Param("dtoList") List<QmsAuditCheckDetailDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditCheckDetailDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditCheckDetailSensitive(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditCheckDetailDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditCheckDetailAll(QmsAuditCheckDetailDTO qmsAuditCheckDetailDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditCheckDetailList(@Param("dtoList") List<QmsAuditCheckDetailDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditCheckDetailById(String id);

	public int getDetailCountByRecordId(String recordId);

	public int getNcCountByRecordId(String recordId);

	public int getAdviceCountByRecordId(String recordId);
}