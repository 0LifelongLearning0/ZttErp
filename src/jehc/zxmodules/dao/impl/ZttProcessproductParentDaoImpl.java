package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttProcessproductParentDao;
import jehc.zxmodules.model.ZttProcessproductParent;

/**
* 机械加工工艺过程母表 
* 2018-04-24 14:27:01  季建吉
*/
@Repository("zttProcessproductParentDao")
public class ZttProcessproductParentDaoImpl  extends BaseDaoImpl implements ZttProcessproductParentDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttProcessproductParent> getZttProcessproductParentListByCondition(Map<String,Object> condition){
		return (List<ZttProcessproductParent>)this.getList("getZttProcessproductParentListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttProcessproductParent getZttProcessproductParentById(String id){
		return (ZttProcessproductParent)this.get("getZttProcessproductParentById", id);
	}
	/**
	* 添加
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int addZttProcessproductParent(ZttProcessproductParent zttProcessproductParent){
		return this.add("addZttProcessproductParent", zttProcessproductParent);
	}
	/**
	* 修改
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParent(ZttProcessproductParent zttProcessproductParent){
		return this.update("updateZttProcessproductParent", zttProcessproductParent);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParentBySelective(ZttProcessproductParent zttProcessproductParent){
		return this.update("updateZttProcessproductParentBySelective", zttProcessproductParent);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttProcessproductParent(Map<String,Object> condition){
		return this.del("delZttProcessproductParent", condition);
	}
	/**
	* 批量添加
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int addBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList){
		return this.add("addBatchZttProcessproductParent", zttProcessproductParentList);
	}
	/**
	* 批量修改
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList){
		return this.update("updateBatchZttProcessproductParent", zttProcessproductParentList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParentBySelective(List<ZttProcessproductParent> zttProcessproductParentList){
		return this.update("updateBatchZttProcessproductParentBySelective", zttProcessproductParentList);
	}
}
