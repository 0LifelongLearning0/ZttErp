package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxMaterialClassify;

/**
* 物料分类 
* 2017-08-30 08:30:12  陈运芝
*/
public interface ZxMaterialClassifyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMaterialClassify> getZxMaterialClassifyListByCondition(Map<String,Object> condition);
	/**
	 * 查找所有根分类
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyList();
	
	/**
	 * 查找非父菜单分类
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListAllChild(Map<String, Object> condition);
	
	/**
	 * 查找子分类
	 * @param condition
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListChild();

	/**
	 * 查询所有分类
	 * @param condition
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListAll(Map<String, Object> condition);
	/**
	* 查询对象
	* @param classify_id 
	* @return
	*/
	public ZxMaterialClassify getZxMaterialClassifyById(String classify_id);
	/**
	* 添加
	* @param zx_material_classify 
	* @return
	*/
	public int addZxMaterialClassify(ZxMaterialClassify zxMaterialClassify);
	/**
	* 修改
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassify(ZxMaterialClassify zxMaterialClassify);
	/**
	* 修改（根据动态条件）
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassifyBySelective(ZxMaterialClassify zxMaterialClassify);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMaterialClassify(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_material_classifyList 
	* @return
	*/
	public int addBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList);
	/**
	* 批量修改
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassifyBySelective(List<ZxMaterialClassify> zxMaterialClassifyList);
}
