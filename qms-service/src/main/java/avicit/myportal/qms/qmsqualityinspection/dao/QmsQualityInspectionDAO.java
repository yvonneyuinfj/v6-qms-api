package avicit.myportal.qms.qmsqualityinspection.dao;

import avicit.myportal.qms.qmsqualityinspection.dto.QmsQualityInspectionDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:15
* @类说明：质量检查表Dao
* @修改记录：
*/
public interface QmsQualityInspectionDAO {

	/**
	 * 分页查询
	 * @param qmsQualityInspectionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityInspectionDTO>
	 */
	public Page<QmsQualityInspectionDTO> searchQmsQualityInspectionByPage(@Param("bean") QmsQualityInspectionDTO qmsQualityInspectionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityInspectionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityInspectionDTO>
	 */
	public List<QmsQualityInspectionDTO> searchQmsQualityInspection(@Param("bean") QmsQualityInspectionDTO qmsQualityInspectionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityInspectionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityInspectionDTO>
	 */
	public List<QmsQualityInspectionDTO> searchQmsQualityInspectionForExportExcel(@Param("bean") QmsQualityInspectionDTO qmsQualityInspectionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityInspectionDTO
	 */
	public QmsQualityInspectionDTO findQmsQualityInspectionById(String id);

	/**
	 * 新增
	 * @param qmsQualityInspectionDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityInspection(QmsQualityInspectionDTO qmsQualityInspectionDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityInspectionList(@Param("dtoList") List<QmsQualityInspectionDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityInspectionDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityInspectionSensitive(QmsQualityInspectionDTO qmsQualityInspectionDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityInspectionDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityInspectionAll(QmsQualityInspectionDTO qmsQualityInspectionDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityInspectionList(@Param("dtoList") List<QmsQualityInspectionDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityInspectionById(String id);
}