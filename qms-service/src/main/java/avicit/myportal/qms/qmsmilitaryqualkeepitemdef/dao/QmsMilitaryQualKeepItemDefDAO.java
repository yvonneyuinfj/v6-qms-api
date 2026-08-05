package avicit.myportal.qms.qmsmilitaryqualkeepitemdef.dao;

import avicit.myportal.qms.qmsmilitaryqualkeepitemdef.dto.QmsMilitaryQualKeepItemDefDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:10
* @类说明：资格保持自查项定义表Dao
* @修改记录：
*/
public interface QmsMilitaryQualKeepItemDefDAO {

	/**
	 * 分页查询
	 * @param qmsMilitaryQualKeepItemDefDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualKeepItemDefDTO>
	 */
	public Page<QmsMilitaryQualKeepItemDefDTO> searchQmsMilitaryQualKeepItemDefByPage(@Param("bean") QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMilitaryQualKeepItemDefDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMilitaryQualKeepItemDefDTO>
	 */
	public List<QmsMilitaryQualKeepItemDefDTO> searchQmsMilitaryQualKeepItemDef(@Param("bean") QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMilitaryQualKeepItemDefDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualKeepItemDefDTO>
	 */
	public List<QmsMilitaryQualKeepItemDefDTO> searchQmsMilitaryQualKeepItemDefForExportExcel(@Param("bean") QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMilitaryQualKeepItemDefDTO
	 */
	public QmsMilitaryQualKeepItemDefDTO findQmsMilitaryQualKeepItemDefById(String id);

	/**
	 * 新增
	 * @param qmsMilitaryQualKeepItemDefDTO 保存对象
	 * @return int
	 */
	public int insertQmsMilitaryQualKeepItemDef(QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMilitaryQualKeepItemDefList(@Param("dtoList") List<QmsMilitaryQualKeepItemDefDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMilitaryQualKeepItemDefDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepItemDefSensitive(QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO);

	/**
	 * 更新全部对象
	 * @param qmsMilitaryQualKeepItemDefDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepItemDefAll(QmsMilitaryQualKeepItemDefDTO qmsMilitaryQualKeepItemDefDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepItemDefList(@Param("dtoList") List<QmsMilitaryQualKeepItemDefDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMilitaryQualKeepItemDefById(String id);
}