package avicit.myportal.qms.qmsqualityreward.dao;

import avicit.myportal.qms.qmsqualityreward.dto.QmsQualityRewardDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-06 17:03
* @类说明：质量奖励申请表Dao
* @修改记录：
*/
public interface QmsQualityRewardDAO {

	/**
	 * 分页查询
	 * @param qmsQualityRewardDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityRewardDTO>
	 */
	public Page<QmsQualityRewardDTO> searchQmsQualityRewardByPage(@Param("bean") QmsQualityRewardDTO qmsQualityRewardDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityRewardDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityRewardDTO>
	 */
	public List<QmsQualityRewardDTO> searchQmsQualityReward(@Param("bean") QmsQualityRewardDTO qmsQualityRewardDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityRewardDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityRewardDTO>
	 */
	public List<QmsQualityRewardDTO> searchQmsQualityRewardForExportExcel(@Param("bean") QmsQualityRewardDTO qmsQualityRewardDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityRewardDTO
	 */
	public QmsQualityRewardDTO findQmsQualityRewardById(String id);

	/**
	 * 新增
	 * @param qmsQualityRewardDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityReward(QmsQualityRewardDTO qmsQualityRewardDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityRewardList(@Param("dtoList") List<QmsQualityRewardDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityRewardDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityRewardSensitive(QmsQualityRewardDTO qmsQualityRewardDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityRewardDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityRewardAll(QmsQualityRewardDTO qmsQualityRewardDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityRewardList(@Param("dtoList") List<QmsQualityRewardDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityRewardById(String id);
}