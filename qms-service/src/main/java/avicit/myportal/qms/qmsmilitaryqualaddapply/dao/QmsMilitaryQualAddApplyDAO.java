package avicit.myportal.qms.qmsmilitaryqualaddapply.dao;

import avicit.myportal.qms.qmsmilitaryqualaddapply.dto.QmsMilitaryQualAddApplyDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:07
* @类说明：军工资质增项申请Dao
* @修改记录：
*/
public interface QmsMilitaryQualAddApplyDAO {

	/**
	 * 分页查询
	 * @param qmsMilitaryQualAddApplyDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualAddApplyDTO>
	 */
	public Page<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApplyByPage(@Param("bean") QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMilitaryQualAddApplyDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMilitaryQualAddApplyDTO>
	 */
	public List<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApply(@Param("bean") QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMilitaryQualAddApplyDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMilitaryQualAddApplyDTO>
	 */
	public List<QmsMilitaryQualAddApplyDTO> searchQmsMilitaryQualAddApplyForExportExcel(@Param("bean") QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMilitaryQualAddApplyDTO
	 */
	public QmsMilitaryQualAddApplyDTO findQmsMilitaryQualAddApplyById(String id);

	/**
	 * 新增
	 * @param qmsMilitaryQualAddApplyDTO 保存对象
	 * @return int
	 */
	public int insertQmsMilitaryQualAddApply(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMilitaryQualAddApplyList(@Param("dtoList") List<QmsMilitaryQualAddApplyDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMilitaryQualAddApplyDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualAddApplySensitive(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO);

	/**
	 * 更新全部对象
	 * @param qmsMilitaryQualAddApplyDTO 更新对象
	 * @return int
	 */
	public int updateQmsMilitaryQualAddApplyAll(QmsMilitaryQualAddApplyDTO qmsMilitaryQualAddApplyDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMilitaryQualAddApplyList(@Param("dtoList") List<QmsMilitaryQualAddApplyDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMilitaryQualAddApplyById(String id);
}