package avicit.myportal.qms.qmsmilitaryqualkeepcheck.dao;

import avicit.myportal.qms.qmsmilitaryqualkeepcheck.dto.QmsMilitaryQualKeepCheckDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:09
* @类说明：资格保持自查表Dao
* @修改记录：
*/
public interface QmsMilitaryQualKeepCheckDAO {

	/**
	 * 分页查询
	 * @param qmsMilitaryQualKeepCheckDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualKeepCheckDTO>
	 */
	public Page<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheckByPage(@Param("bean") QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMilitaryQualKeepCheckDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMilitaryQualKeepCheckDTO>
	 */
	public List<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheck(@Param("bean") QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMilitaryQualKeepCheckDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualKeepCheckDTO>
	 */
	public List<QmsMilitaryQualKeepCheckDTO> searchQmsMilitaryQualKeepCheckForExportExcel(@Param("bean") QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMilitaryQualKeepCheckDTO
	 */
	public QmsMilitaryQualKeepCheckDTO findQmsMilitaryQualKeepCheckById(String id);

	/**
	 * 新增
	 * @param qmsMilitaryQualKeepCheckDTO 保存对象
	 * @return int
	 */
	public int insertQmsMilitaryQualKeepCheck(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMilitaryQualKeepCheckList(@Param("dtoList") List<QmsMilitaryQualKeepCheckDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMilitaryQualKeepCheckDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepCheckSensitive(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO);

	/**
	 * 更新全部对象
	 * @param qmsMilitaryQualKeepCheckDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepCheckAll(QmsMilitaryQualKeepCheckDTO qmsMilitaryQualKeepCheckDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMilitaryQualKeepCheckList(@Param("dtoList") List<QmsMilitaryQualKeepCheckDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMilitaryQualKeepCheckById(String id);
}