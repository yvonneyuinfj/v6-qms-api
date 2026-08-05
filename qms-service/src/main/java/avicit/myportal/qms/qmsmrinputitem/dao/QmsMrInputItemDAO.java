package avicit.myportal.qms.qmsmrinputitem.dao;

import avicit.myportal.qms.qmsmrinputitem.dto.QmsMrInputItemDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-03 19:43
* @类说明：管评输入材料分工台账Dao
* @修改记录：
*/
public interface QmsMrInputItemDAO {

	/**
	 * 分页查询
	 * @param qmsMrInputItemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMrInputItemDTO>
	 */
	public Page<QmsMrInputItemDTO> searchQmsMrInputItemByPage(@Param("bean") QmsMrInputItemDTO qmsMrInputItemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsMrInputItemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsMrInputItemDTO>
	 */
	public List<QmsMrInputItemDTO> searchQmsMrInputItem(@Param("bean") QmsMrInputItemDTO qmsMrInputItemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsMrInputItemDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsMrInputItemDTO>
	 */
	public List<QmsMrInputItemDTO> searchQmsMrInputItemForExportExcel(@Param("bean") QmsMrInputItemDTO qmsMrInputItemDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsMrInputItemDTO
	 */
	public QmsMrInputItemDTO findQmsMrInputItemById(String id);

	/**
	 * 新增
	 * @param qmsMrInputItemDTO 保存对象
	 * @return int
	 */
	public int insertQmsMrInputItem(QmsMrInputItemDTO qmsMrInputItemDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsMrInputItemList(@Param("dtoList") List<QmsMrInputItemDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsMrInputItemDTO 更新对象
	 * @return int
	 */
	public int updateQmsMrInputItemSensitive(QmsMrInputItemDTO qmsMrInputItemDTO);

	/**
	 * 更新全部对象
	 * @param qmsMrInputItemDTO 更新对象
	 * @return int
	 */
	public int updateQmsMrInputItemAll(QmsMrInputItemDTO qmsMrInputItemDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsMrInputItemList(@Param("dtoList") List<QmsMrInputItemDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsMrInputItemById(String id);
}