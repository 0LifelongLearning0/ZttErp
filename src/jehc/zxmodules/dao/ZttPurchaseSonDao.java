package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttPurchaseSon;

/**
* 采购子台账 
* 2018-04-29 10:08:25  季建吉
*/
public interface ZttPurchaseSonDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttPurchaseSon> getZttPurchaseSonListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttPurchaseSon getZttPurchaseSonById(String id);
	/**
	* 添加
	* @param ztt_purchase_son 
	* @return
	*/
	public int addZttPurchaseSon(ZttPurchaseSon zttPurchaseSon);
	/**
	* 修改
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSon(ZttPurchaseSon zttPurchaseSon);
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSonBySelective(ZttPurchaseSon zttPurchaseSon);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttPurchaseSon(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int addBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList);
	/**
	* 批量修改
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSonBySelective(List<ZttPurchaseSon> zttPurchaseSonList);
	/**
	* 根据外键删除方法
	* @param parent_id
	* @return
	*/
	public int delZttPurchaseSonByForeignKey(String parent_id);
}
