package avicit.myportal.qms.qmsbasicmodelinfo.dao;

import avicit.myportal.qms.qmsbasicmodelinfo.dto.QmsBasicModelInfoDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-08 17:12
* @类说明：QMS_BASIC_MODEL_INFODao
* @修改记录：
*/
public interface QmsBasicModelInfoDAO {

	/**
	 * 分页查询
	 * @param qmsBasicModelInfoDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsBasicModelInfoDTO>
	 */
	public Page<QmsBasicModelInfoDTO> searchQmsBasicModelInfoByPage(@Param("bean") QmsBasicModelInfoDTO qmsBasicModelInfoDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsBasicModelInfoDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsBasicModelInfoDTO>
	 */
	public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfo(@Param("bean") QmsBasicModelInfoDTO qmsBasicModelInfoDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsBasicModelInfoDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsBasicModelInfoDTO>
	 */
	public List<QmsBasicModelInfoDTO> searchQmsBasicModelInfoForExportExcel(@Param("bean") QmsBasicModelInfoDTO qmsBasicModelInfoDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsBasicModelInfoDTO
	 */
	public QmsBasicModelInfoDTO findQmsBasicModelInfoById(String id);

	/**
	 * 新增
	 * @param qmsBasicModelInfoDTO 保存对象
	 * @return int
	 */
	public int insertQmsBasicModelInfo(QmsBasicModelInfoDTO qmsBasicModelInfoDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsBasicModelInfoList(@Param("dtoList") List<QmsBasicModelInfoDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsBasicModelInfoDTO 更新对象
	 * @return int
	 */
	public int updateQmsBasicModelInfoSensitive(QmsBasicModelInfoDTO qmsBasicModelInfoDTO);

	/**
	 * 更新全部对象
	 * @param qmsBasicModelInfoDTO 更新对象
	 * @return int
	 */
	public int updateQmsBasicModelInfoAll(QmsBasicModelInfoDTO qmsBasicModelInfoDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsBasicModelInfoList(@Param("dtoList") List<QmsBasicModelInfoDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsBasicModelInfoById(String id);
}