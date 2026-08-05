package avicit.myportal.qms.qmstop10problem.dao;

import avicit.myportal.qms.qmstop10problem.dto.QmsTop10ProblemDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:11
* @类说明：TOP10问题台账Dao
* @修改记录：
*/
public interface QmsTop10ProblemDAO {

	/**
	 * 分页查询
	 * @param qmsTop10ProblemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsTop10ProblemDTO>
	 */
	public Page<QmsTop10ProblemDTO> searchQmsTop10ProblemByPage(@Param("bean") QmsTop10ProblemDTO qmsTop10ProblemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsTop10ProblemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsTop10ProblemDTO>
	 */
	public List<QmsTop10ProblemDTO> searchQmsTop10Problem(@Param("bean") QmsTop10ProblemDTO qmsTop10ProblemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsTop10ProblemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsTop10ProblemDTO>
	 */
	public List<QmsTop10ProblemDTO> searchQmsTop10ProblemForExportExcel(@Param("bean") QmsTop10ProblemDTO qmsTop10ProblemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsTop10ProblemDTO
	 */
	public QmsTop10ProblemDTO findQmsTop10ProblemById(String id);

	/**
	 * 新增
	 * @param qmsTop10ProblemDTO 保存对象
	 * @return int
	 */
	public int insertQmsTop10Problem(QmsTop10ProblemDTO qmsTop10ProblemDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsTop10ProblemList(@Param("dtoList") List<QmsTop10ProblemDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsTop10ProblemDTO 更新对象
	 * @return int
	 */
	public int updateQmsTop10ProblemSensitive(QmsTop10ProblemDTO qmsTop10ProblemDTO);

	/**
	 * 更新全部对象
	 * @param qmsTop10ProblemDTO 更新对象
	 * @return int
	 */
	public int updateQmsTop10ProblemAll(QmsTop10ProblemDTO qmsTop10ProblemDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsTop10ProblemList(@Param("dtoList") List<QmsTop10ProblemDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsTop10ProblemById(String id);
}