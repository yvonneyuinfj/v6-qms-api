package avicit.myportal.qms.qmsproblemrectification.dao;

import avicit.myportal.qms.qmsproblemrectification.dto.QmsProblemRectificationDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @金航数码科技有限责任公司
 * @作者：于小耘
 * @邮箱：18040011631@163.com
 * @创建时间： 2026-08-05 18:14
 * @类说明：问题整改表Dao
 * @修改记录：
 */
public interface QmsProblemRectificationDAO {

	/**
	 * 分页查询
	 * @param qmsProblemRectificationDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsProblemRectificationDTO>
	 */
	public Page<QmsProblemRectificationDTO> searchQmsProblemRectificationByPage(@Param("bean") QmsProblemRectificationDTO qmsProblemRectificationDTO, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsProblemRectificationDTO 查询对象
	 * @return List<QmsProblemRectificationDTO>
	 */
	public List<QmsProblemRectificationDTO> searchQmsProblemRectification(@Param("bean") QmsProblemRectificationDTO qmsProblemRectificationDTO);

	/**
	 * 按条件导出查询
	 * @param qmsProblemRectificationDTO 查询对象
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsProblemRectificationDTO>
	 */
	public List<QmsProblemRectificationDTO> searchQmsProblemRectificationForExportExcel(@Param("bean") QmsProblemRectificationDTO qmsProblemRectificationDTO,  @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsProblemRectificationDTO
	 */
	public QmsProblemRectificationDTO findQmsProblemRectificationById(String id);

	/**
     * 根据pid查询对象
     * @param pid 父id
     * @return List<QmsProblemRectificationDTO>
     */
    public List<QmsProblemRectificationDTO> findQmsProblemRectificationByPid(String pid);

	/**
	 * 新增
	 * @param qmsProblemRectificationDTO 保存对象
	 * @return int
	 */
	public int insertQmsProblemRectification(QmsProblemRectificationDTO qmsProblemRectificationDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsProblemRectificationList(@Param("dtoList") List<QmsProblemRectificationDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsProblemRectificationDTO 更新对象
	 * @return int
	 */
	public int updateQmsProblemRectificationSensitive(QmsProblemRectificationDTO qmsProblemRectificationDTO);

	/**
	 * 更新全部对象
	 * @param qmsProblemRectificationDTO 更新对象
	 * @return int
	 */
	public int updateQmsProblemRectificationAll(QmsProblemRectificationDTO qmsProblemRectificationDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsProblemRectificationList(@Param("dtoList") List<QmsProblemRectificationDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsProblemRectificationById(String id);
}