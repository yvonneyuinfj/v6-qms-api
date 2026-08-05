package avicit.myportal.qms.qmsncproduct.dao;

import avicit.myportal.qms.qmsncproduct.dto.QmsNcProductDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @金航数码科技有限责任公司
* @作者：于小耘
* @邮箱：18040011631@163.com
* @创建时间： 2026-08-04 15:06
* @类说明：QMS_NC_PRODUCTDao
* @修改记录：
*/
public interface QmsNcProductDAO {

	/**
	 * 分页查询
	 * @param qmsNcProductDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsNcProductDTO>
	 */
	public Page<QmsNcProductDTO> searchQmsNcProductByPage(@Param("bean") QmsNcProductDTO qmsNcProductDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 不分页查询
	 * @param qmsNcProductDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @return List<QmsNcProductDTO>
	 */
	public List<QmsNcProductDTO> searchQmsNcProduct(@Param("bean") QmsNcProductDTO qmsNcProductDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret);

	/**
	 * 按条件导出查询
	 * @param qmsNcProductDTO 查询对象
	 * @param orgIdentity       组织id
	 * @param wordSecret        文档密级
	 * @param orderBy           排序条件
	 * @param keyWords          查询关键字
	 * @return Page<QmsNcProductDTO>
	 */
	public List<QmsNcProductDTO> searchQmsNcProductForExportExcel(@Param("bean") QmsNcProductDTO qmsNcProductDTO, @Param("orgIdentity") String orgIdentity, @Param("wordSecret") List<String> wordSecret, @Param("orderBy") String orderBy, @Param("keyWords") String keyWords);

	/**
	 * 主键查询
	 * @param id 主键id
	 * @return QmsNcProductDTO
	 */
	public QmsNcProductDTO findQmsNcProductById(String id);

	/**
	 * 新增
	 * @param qmsNcProductDTO 保存对象
	 * @return int
	 */
	public int insertQmsNcProduct(QmsNcProductDTO qmsNcProductDTO);

	/**
	 * 批量新增
	 * @param dtoList 保存对象集合
	 * @return int
	 */
	public int insertQmsNcProductList(@Param("dtoList") List<QmsNcProductDTO> dtoList);

	/**
	 * 更新部分对象
	 * @param qmsNcProductDTO 更新对象
	 * @return int
	 */
	public int updateQmsNcProductSensitive(QmsNcProductDTO qmsNcProductDTO);

	/**
	 * 更新全部对象
	 * @param qmsNcProductDTO 更新对象
	 * @return int
	 */
	public int updateQmsNcProductAll(QmsNcProductDTO qmsNcProductDTO);

	/**
	 * 批量更新对象
	 * @param dtoList 批量更新对象集合
	 * @return int
	 */
	public int updateQmsNcProductList(@Param("dtoList") List<QmsNcProductDTO> dtoList);

	/**
	 * 按主键删除
	 * @param id 主键id
	 * @return int
	 */
	public int deleteQmsNcProductById(String id);
}