package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttPurchaseDao;
import jehc.zxmodules.model.ZttPurchase;

/**
* 采购台账 
* 2018-04-03 12:43:49  季建吉
*/
@Repository("zttPurchaseDao")
public class ZttPurchaseDaoImpl  extends BaseDaoImpl implements ZttPurchaseDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttPurchase> getZttPurchaseListByCondition(Map<String,Object> condition){
		return (List<ZttPurchase>)this.getList("getZttPurchaseListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttPurchase getZttPurchaseById(String id){
		return (ZttPurchase)this.get("getZttPurchaseById", id);
	}
	/**
	* 添加
	* @param ztt_purchase 
	* @return
	*/
	public int addZttPurchase(ZttPurchase zttPurchase){
		return this.add("addZttPurchase", zttPurchase);
	}
	/**
	* 修改
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchase(ZttPurchase zttPurchase){
		return this.update("updateZttPurchase", zttPurchase);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchaseBySelective(ZttPurchase zttPurchase){
		return this.update("updateZttPurchaseBySelective", zttPurchase);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttPurchase(Map<String,Object> condition){
		return this.del("delZttPurchase", condition);
	}
	/**
	* 批量添加
	* @param ztt_purchaseList 
	* @return
	*/
	public int addBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		return this.add("addBatchZttPurchase", zttPurchaseList);
	}
	/**
	* 批量修改
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		return this.update("updateBatchZttPurchase", zttPurchaseList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchaseBySelective(List<ZttPurchase> zttPurchaseList){
		return this.update("updateBatchZttPurchaseBySelective", zttPurchaseList);
	}
}
