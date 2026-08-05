package avicit.myportal.qms.qmscommonactionfeedback.dao;

import avicit.myportal.qms.qmscommonactionfeedback.dto.QmsCommonActionFeedbackDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-04 15:12
 * @类说明：通用执行反馈表Dao
 * @修改记录：
 */
public interface QmsCommonActionFeedbackDAO {

	/**
	 * 分页查询
	 * @param qmsCommonActionFeedbackDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsCommonActionFeedbackDTO>
	 */
	public Page<QmsCommonActionFeedbackDTO> searchQmsCommonActionFeedbackByPage(@Param("bean") QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsCommonActionFeedbackDTO 查询对象
	 * @return List<QmsCommonActionFeedbackDTO>
	 */
	public List<QmsCommonActionFeedbackDTO> searchQmsCommonActionFeedback(@Param("bean") QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO);

	/**
	 * 按条件导出查询
	 * @param qmsCommonActionFeedbackDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsCommonActionFeedbackDTO>
	 */
	public List<QmsCommonActionFeedbackDTO> searchQmsCommonActionFeedbackForExportExcel(@Param("bean") QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsCommonActionFeedbackDTO
	 */
	public QmsCommonActionFeedbackDTO findQmsCommonActionFeedbackById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsCommonActionFeedbackDTO>
     */
    public List<QmsCommonActionFeedbackDTO> findQmsCommonActionFeedbackByPid(String pid);

	/**
	 * 新增
	 * @param qmsCommonActionFeedbackDTO 保存对象
	 * @return int
	 */
	public int insertQmsCommonActionFeedback(QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsCommonActionFeedbackList(@Param("dtoList") List<QmsCommonActionFeedbackDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsCommonActionFeedbackDTO 更新对象
	 * @return int
	 */
	public int updateQmsCommonActionFeedbackSensitive(QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO);

	/**
	 * 更新全部对象
	 * @param qmsCommonActionFeedbackDTO 更新对象
	 * @return int
	 */
	public int updateQmsCommonActionFeedbackAll(QmsCommonActionFeedbackDTO qmsCommonActionFeedbackDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsCommonActionFeedbackList(@Param("dtoList") List<QmsCommonActionFeedbackDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsCommonActionFeedbackById(String id);
}