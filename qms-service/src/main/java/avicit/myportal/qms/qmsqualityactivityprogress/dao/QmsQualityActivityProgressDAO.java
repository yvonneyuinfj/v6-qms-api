package avicit.myportal.qms.qmsqualityactivityprogress.dao;

import avicit.myportal.qms.qmsqualityactivityprogress.dto.QmsQualityActivityProgressDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-06 15:52
 * @类说明：活动过程反馈表Dao
 * @修改记录：
 */
public interface QmsQualityActivityProgressDAO {

	/**
	 * 分页查询
	 * @param qmsQualityActivityProgressDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityActivityProgressDTO>
	 */
	public Page<QmsQualityActivityProgressDTO> searchQmsQualityActivityProgressByPage(@Param("bean") QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityActivityProgressDTO 查询对象
	 * @return List<QmsQualityActivityProgressDTO>
	 */
	public List<QmsQualityActivityProgressDTO> searchQmsQualityActivityProgress(@Param("bean") QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO);

	/**
	 * 按条件导出查询
	 * @param qmsQualityActivityProgressDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityActivityProgressDTO>
	 */
	public List<QmsQualityActivityProgressDTO> searchQmsQualityActivityProgressForExportExcel(@Param("bean") QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityActivityProgressDTO
	 */
	public QmsQualityActivityProgressDTO findQmsQualityActivityProgressById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsQualityActivityProgressDTO>
     */
    public List<QmsQualityActivityProgressDTO> findQmsQualityActivityProgressByPid(String pid);

	/**
	 * 新增
	 * @param qmsQualityActivityProgressDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityActivityProgress(QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityActivityProgressList(@Param("dtoList") List<QmsQualityActivityProgressDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityActivityProgressDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityActivityProgressSensitive(QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityActivityProgressDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityActivityProgressAll(QmsQualityActivityProgressDTO qmsQualityActivityProgressDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityActivityProgressList(@Param("dtoList") List<QmsQualityActivityProgressDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityActivityProgressById(String id);
}