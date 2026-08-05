package avicit.myportal.qms.qmsqualityproblemdelaymilestone.dao;

import avicit.myportal.qms.qmsqualityproblemdelaymilestone.dto.QmsQualityProblemDelayMilestoneDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:05
 * @类说明：里程碑明细表Dao
 * @修改记录：
 */
public interface QmsQualityProblemDelayMilestoneDAO {

	/**
	 * 分页查询
	 * @param qmsQualityProblemDelayMilestoneDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemDelayMilestoneDTO>
	 */
	public Page<QmsQualityProblemDelayMilestoneDTO> searchQmsQualityProblemDelayMilestoneByPage(@Param("bean") QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityProblemDelayMilestoneDTO 查询对象
	 * @return List<QmsQualityProblemDelayMilestoneDTO>
	 */
	public List<QmsQualityProblemDelayMilestoneDTO> searchQmsQualityProblemDelayMilestone(@Param("bean") QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO);

	/**
	 * 按条件导出查询
	 * @param qmsQualityProblemDelayMilestoneDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemDelayMilestoneDTO>
	 */
	public List<QmsQualityProblemDelayMilestoneDTO> searchQmsQualityProblemDelayMilestoneForExportExcel(@Param("bean") QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityProblemDelayMilestoneDTO
	 */
	public QmsQualityProblemDelayMilestoneDTO findQmsQualityProblemDelayMilestoneById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsQualityProblemDelayMilestoneDTO>
     */
    public List<QmsQualityProblemDelayMilestoneDTO> findQmsQualityProblemDelayMilestoneByPid(String pid);

	/**
	 * 新增
	 * @param qmsQualityProblemDelayMilestoneDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityProblemDelayMilestone(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityProblemDelayMilestoneList(@Param("dtoList") List<QmsQualityProblemDelayMilestoneDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityProblemDelayMilestoneDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemDelayMilestoneSensitive(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityProblemDelayMilestoneDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemDelayMilestoneAll(QmsQualityProblemDelayMilestoneDTO qmsQualityProblemDelayMilestoneDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityProblemDelayMilestoneList(@Param("dtoList") List<QmsQualityProblemDelayMilestoneDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityProblemDelayMilestoneById(String id);
}