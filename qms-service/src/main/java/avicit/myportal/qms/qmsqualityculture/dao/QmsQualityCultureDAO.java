package avicit.myportal.qms.qmsqualityculture.dao;

import avicit.myportal.qms.qmsqualityculture.dto.QmsQualityCultureDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 15:53
* @类说明：质量文化Dao
* @修改记录：
*/
public interface QmsQualityCultureDAO {

	/**
	 * 分页查询
	 * @param qmsQualityCultureDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityCultureDTO>
	 */
	public Page<QmsQualityCultureDTO> searchQmsQualityCultureByPage(@Param("bean") QmsQualityCultureDTO qmsQualityCultureDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityCultureDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityCultureDTO>
	 */
	public List<QmsQualityCultureDTO> searchQmsQualityCulture(@Param("bean") QmsQualityCultureDTO qmsQualityCultureDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityCultureDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityCultureDTO>
	 */
	public List<QmsQualityCultureDTO> searchQmsQualityCultureForExportExcel(@Param("bean") QmsQualityCultureDTO qmsQualityCultureDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityCultureDTO
	 */
	public QmsQualityCultureDTO findQmsQualityCultureById(String id);

	/**
	 * 新增
	 * @param qmsQualityCultureDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityCulture(QmsQualityCultureDTO qmsQualityCultureDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityCultureList(@Param("dtoList") List<QmsQualityCultureDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityCultureDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityCultureSensitive(QmsQualityCultureDTO qmsQualityCultureDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityCultureDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityCultureAll(QmsQualityCultureDTO qmsQualityCultureDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityCultureList(@Param("dtoList") List<QmsQualityCultureDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityCultureById(String id);
}