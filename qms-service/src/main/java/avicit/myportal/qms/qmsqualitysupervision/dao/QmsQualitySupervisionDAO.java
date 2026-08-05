package avicit.myportal.qms.qmsqualitysupervision.dao;

import avicit.myportal.qms.qmsqualitysupervision.dto.QmsQualitySupervisionDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-05 18:17
* @类说明：质量监督表Dao
* @修改记录：
*/
public interface QmsQualitySupervisionDAO {

	/**
	 * 分页查询
	 * @param qmsQualitySupervisionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualitySupervisionDTO>
	 */
	public Page<QmsQualitySupervisionDTO> searchQmsQualitySupervisionByPage(@Param("bean") QmsQualitySupervisionDTO qmsQualitySupervisionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsQualitySupervisionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsQualitySupervisionDTO>
	 */
	public List<QmsQualitySupervisionDTO> searchQmsQualitySupervision(@Param("bean") QmsQualitySupervisionDTO qmsQualitySupervisionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsQualitySupervisionDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsQualitySupervisionDTO>
	 */
	public List<QmsQualitySupervisionDTO> searchQmsQualitySupervisionForExportExcel(@Param("bean") QmsQualitySupervisionDTO qmsQualitySupervisionDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsQualitySupervisionDTO
	 */
	public QmsQualitySupervisionDTO findQmsQualitySupervisionById(String id);

	/**
	 * 新增
	 * @param qmsQualitySupervisionDTO 保存对象
	 * @return int
	 */
	public int insertQmsQualitySupervision(QmsQualitySupervisionDTO qmsQualitySupervisionDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsQualitySupervisionList(@Param("dtoList") List<QmsQualitySupervisionDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsQualitySupervisionDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualitySupervisionSensitive(QmsQualitySupervisionDTO qmsQualitySupervisionDTO);

	/**
	 * 更新全部对象
	 * @param qmsQualitySupervisionDTO 更新对象
	 * @return int
	 */
	public int updateQmsQualitySupervisionAll(QmsQualitySupervisionDTO qmsQualitySupervisionDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsQualitySupervisionList(@Param("dtoList") List<QmsQualitySupervisionDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsQualitySupervisionById(String id);
}