package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxExpressdeliveryDao;
import jehc.zxmodules.model.ZxExpressdelivery;

/**
* 快递邮寄 
* 2017-11-24 13:10:10  陈运芝
*/
@Repository("zxExpressdeliveryDao")
public class ZxExpressdeliveryDaoImpl  extends BaseDaoImpl implements ZxExpressdeliveryDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxExpressdelivery> getZxExpressdeliveryListByCondition(Map<String,Object> condition){
		return (List<ZxExpressdelivery>)this.getList("getZxExpressdeliveryListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxExpressdelivery getZxExpressdeliveryById(String id){
		return (ZxExpressdelivery)this.get("getZxExpressdeliveryById", id);
	}
	/**
	* 添加
	* @param zx_expressdelivery 
	* @return
	*/
	public int addZxExpressdelivery(ZxExpressdelivery zxExpressdelivery){
		return this.add("addZxExpressdelivery", zxExpressdelivery);
	}
	/**
	* 修改
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdelivery(ZxExpressdelivery zxExpressdelivery){
		return this.update("updateZxExpressdelivery", zxExpressdelivery);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdeliveryBySelective(ZxExpressdelivery zxExpressdelivery){
		return this.update("updateZxExpressdeliveryBySelective", zxExpressdelivery);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxExpressdelivery(Map<String,Object> condition){
		return this.del("delZxExpressdelivery", condition);
	}
	/**
	* 批量添加
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int addBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList){
		return this.add("addBatchZxExpressdelivery", zxExpressdeliveryList);
	}
	/**
	* 批量修改
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList){
		return this.update("updateBatchZxExpressdelivery", zxExpressdeliveryList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdeliveryBySelective(List<ZxExpressdelivery> zxExpressdeliveryList){
		return this.update("updateBatchZxExpressdeliveryBySelective", zxExpressdeliveryList);
	}
}
