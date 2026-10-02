package avicit.myportal.qms.qmsauditnc.dao;

import avicit.myportal.qms.qmsauditnc.dto.QmsAuditNcDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-28 16:14
* @类说明：不符合项表Dao
* @修改记录：
*/
public interface QmsAuditNcDAO {

	/**
	 * 分页查询
	 * @param qmsAuditNcDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditNcDTO>
	 */
	public Page<QmsAuditNcDTO> searchQmsAuditNcByPage(@Param("bean") QmsAuditNcDTO qmsAuditNcDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsAuditNcDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsAuditNcDTO>
	 */
	public List<QmsAuditNcDTO> searchQmsAuditNc(@Param("bean") QmsAuditNcDTO qmsAuditNcDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsAuditNcDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsAuditNcDTO>
	 */
	public List<QmsAuditNcDTO> searchQmsAuditNcForExportExcel(@Param("bean") QmsAuditNcDTO qmsAuditNcDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsAuditNcDTO
	 */
	public QmsAuditNcDTO findQmsAuditNcById(String id);

	/**
	 * 新增
	 * @param qmsAuditNcDTO 保存对象
	 * @return int
	 */
	public int insertQmsAuditNc(QmsAuditNcDTO qmsAuditNcDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsAuditNcList(@Param("dtoList") List<QmsAuditNcDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsAuditNcDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditNcSensitive(QmsAuditNcDTO qmsAuditNcDTO);

	/**
	 * 更新全部对象
	 * @param qmsAuditNcDTO 更新对象
	 * @return int
	 */
	public int updateQmsAuditNcAll(QmsAuditNcDTO qmsAuditNcDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsAuditNcList(@Param("dtoList") List<QmsAuditNcDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsAuditNcById(String id);
}