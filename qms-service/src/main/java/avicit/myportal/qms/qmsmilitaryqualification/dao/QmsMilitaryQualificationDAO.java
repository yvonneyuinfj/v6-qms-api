package avicit.myportal.qms.qmsmilitaryqualification.dao;

import avicit.myportal.qms.qmsmilitaryqualification.dto.QmsMilitaryQualificationDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:06
* @类说明：军工资质基本信息Dao
* @修改记录：
*/
public interface QmsMilitaryQualificationDAO {

	/**
	 * 分页查询
	 * @param qmsMilitaryQualificationDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualificationDTO>
	 */
	public Page<QmsMilitaryQualificationDTO> searchQmsMilitaryQualificationByPage(@Param("bean") QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMilitaryQualificationDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMilitaryQualificationDTO>
	 */
	public List<QmsMilitaryQualificationDTO> searchQmsMilitaryQualification(@Param("bean") QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMilitaryQualificationDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualificationDTO>
	 */
	public List<QmsMilitaryQualificationDTO> searchQmsMilitaryQualificationForExportExcel(@Param("bean") QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMilitaryQualificationDTO
	 */
	public QmsMilitaryQualificationDTO findQmsMilitaryQualificationById(String id);

	/**
	 * 新增
	 * @param qmsMilitaryQualificationDTO 保存对象
	 * @return int
	 */
	public int insertQmsMilitaryQualification(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMilitaryQualificationList(@Param("dtoList") List<QmsMilitaryQualificationDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMilitaryQualificationDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualificationSensitive(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO);

	/**
	 * 更新全部对象
	 * @param qmsMilitaryQualificationDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualificationAll(QmsMilitaryQualificationDTO qmsMilitaryQualificationDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMilitaryQualificationList(@Param("dtoList") List<QmsMilitaryQualificationDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMilitaryQualificationById(String id);
}