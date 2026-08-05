package avicit.myportal.qms.qmscheckproblem.dao;

import avicit.myportal.qms.qmscheckproblem.dto.QmsCheckProblemDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:17
 * @类说明：检查问题表Dao
 * @修改记录：
 */
public interface QmsCheckProblemDAO {

	/**
	 * 分页查询
	 * @param qmsCheckProblemDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsCheckProblemDTO>
	 */
	public Page<QmsCheckProblemDTO> searchQmsCheckProblemByPage(@Param("bean") QmsCheckProblemDTO qmsCheckProblemDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsCheckProblemDTO 查询对象
	 * @return List<QmsCheckProblemDTO>
	 */
	public List<QmsCheckProblemDTO> searchQmsCheckProblem(@Param("bean") QmsCheckProblemDTO qmsCheckProblemDTO);

	/**
	 * 按条件导出查询
	 * @param qmsCheckProblemDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsCheckProblemDTO>
	 */
	public List<QmsCheckProblemDTO> searchQmsCheckProblemForExportExcel(@Param("bean") QmsCheckProblemDTO qmsCheckProblemDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsCheckProblemDTO
	 */
	public QmsCheckProblemDTO findQmsCheckProblemById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsCheckProblemDTO>
     */
    public List<QmsCheckProblemDTO> findQmsCheckProblemByPid(String pid);

	/**
	 * 新增
	 * @param qmsCheckProblemDTO 保存对象
	 * @return int
	 */
	public int insertQmsCheckProblem(QmsCheckProblemDTO qmsCheckProblemDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsCheckProblemList(@Param("dtoList") List<QmsCheckProblemDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsCheckProblemDTO 更新对象
	 * @return int
	 */
	public int updateQmsCheckProblemSensitive(QmsCheckProblemDTO qmsCheckProblemDTO);

	/**
	 * 更新全部对象
	 * @param qmsCheckProblemDTO 更新对象
	 * @return int
	 */
	public int updateQmsCheckProblemAll(QmsCheckProblemDTO qmsCheckProblemDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsCheckProblemList(@Param("dtoList") List<QmsCheckProblemDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsCheckProblemById(String id);
}