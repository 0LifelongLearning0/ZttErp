package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOfficeClassifyDao;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.model.ZxOfficeClassify;

/**
* 办公用品分类 
* 2017-11-30 08:41:46  季建吉
*/
@Repository("zxOfficeClassifyDao")
public class ZxOfficeClassifyDaoImpl  extends BaseDaoImpl implements ZxOfficeClassifyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeClassifyListByCondition(Map<String,Object> condition){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyListByCondition",condition);
	}
	/**
	 * 查找所有根分类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZxOfficeClassify getZxOfficeClassifyByClassifyList(){
		return (ZxOfficeClassify)this.get("getZxOfficeClassifyList", null);
	}
	/**
	 * 查找非父菜单分类
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeClassifyListAllChild(Map<String, Object> condition){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyListChild", condition);
	}
	
	/**
	 * 查找子分类
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeClassifyListChild(){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyListAll", null); 
	}
	
	/**
	 * 查找父分类下的子分类
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeClassifyByParent(String id){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyByClick", id); 
	}
	
	
	public int addZxOfficeClassify(ZxOfficeClassify zxOfficeClassify){
		return this.add("addZxOfficeClassify", zxOfficeClassify);
	}
	/**
	* 修改子页
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassifyLeaf(String id){
		return this.update("updateZxOfficeClassifyLeaf", id);
	}
	/**
	* 修改
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassify(ZxOfficeClassify zxOfficeClassify){
		return this.update("updateZxOfficeClassify", zxOfficeClassify);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassifyBySelective(ZxOfficeClassify zxOfficeClassify){
		return this.update("updateZxOfficeClassifyBySelective", zxOfficeClassify);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeClassify(Map<String,Object> condition){
		return this.del("delZxOfficeClassify", condition);
	}
	/**
	* 批量添加
	* @param zx_office_classifyList 
	* @return
	*/
	public int addBatchZxOfficeClassify(List<ZxOfficeClassify> zxOfficeClassifyList){
		return this.add("addBatchZxOfficeClassify", zxOfficeClassifyList);
	}
	/**
	* 批量修改
	* @param zx_office_classifyList 
	* @return
	*/
	public int updateBatchZxOfficeClassify(List<ZxOfficeClassify> zxOfficeClassifyList){
		return this.update("updateBatchZxOfficeClassify", zxOfficeClassifyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_classifyList 
	* @return
	*/
	public int updateBatchZxOfficeClassifyBySelective(List<ZxOfficeClassify> zxOfficeClassifyList){
		return this.update("updateBatchZxOfficeClassifyBySelective", zxOfficeClassifyList);
	}
	/**
	 * 查找所有根分类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeClassifyList() {
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyList", null);
	}
	
	public ZxOfficeClassify getZxOfficeClassifyById(String classify_id) {
		return (ZxOfficeClassify)this.get("getZxOfficeClassifyById", classify_id);
	}
	@Override
	public List<ZxOfficeClassify> getZxOfficeClassifyListAll(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		List<ZxOfficeClassify> l=(List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyListAll", condition);
		System.out.println(l.size());
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyListAll", condition);
	}
}
