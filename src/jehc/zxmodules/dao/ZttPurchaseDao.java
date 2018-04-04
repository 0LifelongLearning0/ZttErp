package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttPurchase;

/**
* 采购台账 
* 2018-04-03 12:43:49  季建吉
*/
public interface ZttPurchaseDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttPurchase> getZttPurchaseListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttPurchase getZttPurchaseById(String id);
	/**
	* 添加
	* @param ztt_purchase 
	* @return
	*/
	public int addZttPurchase(ZttPurchase zttPurchase);
	/**
	* 修改
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchase(ZttPurchase zttPurchase);
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchaseBySelective(ZttPurchase zttPurchase);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttPurchase(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_purchaseList 
	* @return
	*/
	public int addBatchZttPurchase(List<ZttPurchase> zttPurchaseList);
	/**
	* 批量修改
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchase(List<ZttPurchase> zttPurchaseList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchaseBySelective(List<ZttPurchase> zttPurchaseList);
}
