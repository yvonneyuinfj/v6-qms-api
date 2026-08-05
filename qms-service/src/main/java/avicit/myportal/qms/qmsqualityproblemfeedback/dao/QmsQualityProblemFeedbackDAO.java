package avicit.myportal.qms.qmsqualityproblemfeedback.dao;

import avicit.myportal.qms.qmsqualityproblemfeedback.dto.QmsQualityProblemFeedbackDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:12
* @类说明：归零反哺表Dao
* @修改记录：
*/
public interface QmsQualityProblemFeedbackDAO {

	/**
	 * 分页查询
	 * @param qmsQualityProblemFeedbackDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemFeedbackDTO>
	 */
	public Page<QmsQualityProblemFeedbackDTO> searchQmsQualityProblemFeedbackByPage(@Param("bean") QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityProblemFeedbackDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityProblemFeedbackDTO>
	 */
	public List<QmsQualityProblemFeedbackDTO> searchQmsQualityProblemFeedback(@Param("bean") QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityProblemFeedbackDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemFeedbackDTO>
	 */
	public List<QmsQualityProblemFeedbackDTO> searchQmsQualityProblemFeedbackForExportExcel(@Param("bean") QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityProblemFeedbackDTO
	 */
	public QmsQualityProblemFeedbackDTO findQmsQualityProblemFeedbackById(String id);

	/**
	 * 新增
	 * @param qmsQualityProblemFeedbackDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityProblemFeedback(QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityProblemFeedbackList(@Param("dtoList") List<QmsQualityProblemFeedbackDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityProblemFeedbackDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemFeedbackSensitive(QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityProblemFeedbackDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemFeedbackAll(QmsQualityProblemFeedbackDTO qmsQualityProblemFeedbackDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityProblemFeedbackList(@Param("dtoList") List<QmsQualityProblemFeedbackDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityProblemFeedbackById(String id);
}