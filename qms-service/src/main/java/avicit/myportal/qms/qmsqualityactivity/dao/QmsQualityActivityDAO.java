package avicit.myportal.qms.qmsqualityactivity.dao;

import avicit.myportal.qms.qmsqualityactivity.dto.QmsQualityActivityDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 15:52
* @类说明：质量活动台账表Dao
* @修改记录：
*/
public interface QmsQualityActivityDAO {

	/**
	 * 分页查询
	 * @param qmsQualityActivityDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityActivityDTO>
	 */
	public Page<QmsQualityActivityDTO> searchQmsQualityActivityByPage(@Param("bean") QmsQualityActivityDTO qmsQualityActivityDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityActivityDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityActivityDTO>
	 */
	public List<QmsQualityActivityDTO> searchQmsQualityActivity(@Param("bean") QmsQualityActivityDTO qmsQualityActivityDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityActivityDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityActivityDTO>
	 */
	public List<QmsQualityActivityDTO> searchQmsQualityActivityForExportExcel(@Param("bean") QmsQualityActivityDTO qmsQualityActivityDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityActivityDTO
	 */
	public QmsQualityActivityDTO findQmsQualityActivityById(String id);

	/**
	 * 新增
	 * @param qmsQualityActivityDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityActivity(QmsQualityActivityDTO qmsQualityActivityDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityActivityList(@Param("dtoList") List<QmsQualityActivityDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityActivityDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityActivitySensitive(QmsQualityActivityDTO qmsQualityActivityDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityActivityDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityActivityAll(QmsQualityActivityDTO qmsQualityActivityDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityActivityList(@Param("dtoList") List<QmsQualityActivityDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityActivityById(String id);
}