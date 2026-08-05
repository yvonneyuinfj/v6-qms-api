package avicit.myportal.qms.qmstrainingrecord.dao;

import avicit.myportal.qms.qmstrainingrecord.dto.QmsTrainingRecordDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-04 15:01
* @类说明：质量培训台账表Dao
* @修改记录：
*/
public interface QmsTrainingRecordDAO {

	/**
	 * 分页查询
	 * @param qmsTrainingRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsTrainingRecordDTO>
	 */
	public Page<QmsTrainingRecordDTO> searchQmsTrainingRecordByPage(@Param("bean") QmsTrainingRecordDTO qmsTrainingRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsTrainingRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsTrainingRecordDTO>
	 */
	public List<QmsTrainingRecordDTO> searchQmsTrainingRecord(@Param("bean") QmsTrainingRecordDTO qmsTrainingRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsTrainingRecordDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsTrainingRecordDTO>
	 */
	public List<QmsTrainingRecordDTO> searchQmsTrainingRecordForExportExcel(@Param("bean") QmsTrainingRecordDTO qmsTrainingRecordDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsTrainingRecordDTO
	 */
	public QmsTrainingRecordDTO findQmsTrainingRecordById(String id);

	/**
	 * 新增
	 * @param qmsTrainingRecordDTO 保存对象
	 * @return int
	 */
	public int insertQmsTrainingRecord(QmsTrainingRecordDTO qmsTrainingRecordDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsTrainingRecordList(@Param("dtoList") List<QmsTrainingRecordDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsTrainingRecordDTO 更新对象
	 * @return int
	 */
	public int updateQmsTrainingRecordSensitive(QmsTrainingRecordDTO qmsTrainingRecordDTO);

	/**
	 * 更新全部对象
	 * @param qmsTrainingRecordDTO 更新对象
	 * @return int
	 */
	public int updateQmsTrainingRecordAll(QmsTrainingRecordDTO qmsTrainingRecordDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsTrainingRecordList(@Param("dtoList") List<QmsTrainingRecordDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsTrainingRecordById(String id);
}