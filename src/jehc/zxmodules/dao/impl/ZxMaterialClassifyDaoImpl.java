package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMaterialClassifyDao;
import jehc.zxmodules.model.ZxMaterialClassify;

import org.springframework.stereotype.Repository;

/**
* 物料分类 
* 2017-08-30 08:30:12  陈运芝
*/
@Repository("zxMaterialClassifyDao")
public class ZxMaterialClassifyDaoImpl  extends BaseDaoImpl implements ZxMaterialClassifyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMaterialClassify> getZxMaterialClassifyListByCondition(Map<String,Object> condition){
		return (List<ZxMaterialClassify>)this.getList("getZxMaterialClassifyListByCondition",condition);
	}
	/**
	 * 查找所有根分类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxMaterialClassify> getZxMaterialClassifyList(){
		return (List<ZxMaterialClassify>)this.getList("getZxMaterialClassifyList", null);
	}
	
	/**
	 * 查找非父菜单分类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxMaterialClassify> getZxMaterialClassifyListAllChild(Map<String, Object> condition){
		return (List<ZxMaterialClassify>)this.getList("getZxMaterialClassifyListChild", condition);
	}
	
	/**
	 * 查找子分类
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxMaterialClassify> getZxMaterialClassifyListChild(){
		return (List<ZxMaterialClassify>)this.getList("getZxMaterialClassifyListAll", null); 
	}

	/**
	 * 查询所有分类
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxMaterialClassify> getZxMaterialClassifyListAll(Map<String, Object> condition){
		return (List<ZxMaterialClassify>)this.getList("getZxMaterialClassifyListAll", condition);
	}
	/**
	* 查询对象
	* @param classify_id 
	* @return
	*/
	public ZxMaterialClassify getZxMaterialClassifyById(String classify_id){
		return (ZxMaterialClassify)this.get("getZxMaterialClassifyById", classify_id);
	}
	/**
	* 添加
	* @param zx_material_classify 
	* @return
	*/
	public int addZxMaterialClassify(ZxMaterialClassify zxMaterialClassify){
		return this.add("addZxMaterialClassify", zxMaterialClassify);
	}
	/**
	* 修改
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassify(ZxMaterialClassify zxMaterialClassify){
		return this.update("updateZxMaterialClassify", zxMaterialClassify);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassifyBySelective(ZxMaterialClassify zxMaterialClassify){
		return this.update("updateZxMaterialClassifyBySelective", zxMaterialClassify);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMaterialClassify(Map<String,Object> condition){
		return this.del("delZxMaterialClassify", condition);
	}
	/**
	* 批量添加
	* @param zx_material_classifyList 
	* @return
	*/
	public int addBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList){
		return this.add("addBatchZxMaterialClassify", zxMaterialClassifyList);
	}
	/**
	* 批量修改
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList){
		return this.update("updateBatchZxMaterialClassify", zxMaterialClassifyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassifyBySelective(List<ZxMaterialClassify> zxMaterialClassifyList){
		return this.update("updateBatchZxMaterialClassifyBySelective", zxMaterialClassifyList);
	}
}
