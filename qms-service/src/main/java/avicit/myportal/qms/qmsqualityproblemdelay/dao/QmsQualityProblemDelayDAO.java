package avicit.myportal.qms.qmsqualityproblemdelay.dao;

import avicit.myportal.qms.qmsqualityproblemdelay.dto.QmsQualityProblemDelayDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:05
* @类说明：质量问题延期Dao
* @修改记录：
*/
public interface QmsQualityProblemDelayDAO {

	/**
	 * 分页查询
	 * @param qmsQualityProblemDelayDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemDelayDTO>
	 */
	public Page<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelayByPage(@Param("bean") QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualityProblemDelayDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualityProblemDelayDTO>
	 */
	public List<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelay(@Param("bean") QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualityProblemDelayDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualityProblemDelayDTO>
	 */
	public List<QmsQualityProblemDelayDTO> searchQmsQualityProblemDelayForExportExcel(@Param("bean") QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualityProblemDelayDTO
	 */
	public QmsQualityProblemDelayDTO findQmsQualityProblemDelayById(String id);

	/**
	 * 新增
	 * @param qmsQualityProblemDelayDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualityProblemDelay(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualityProblemDelayList(@Param("dtoList") List<QmsQualityProblemDelayDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualityProblemDelayDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemDelaySensitive(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualityProblemDelayDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualityProblemDelayAll(QmsQualityProblemDelayDTO qmsQualityProblemDelayDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualityProblemDelayList(@Param("dtoList") List<QmsQualityProblemDelayDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualityProblemDelayById(String id);
}