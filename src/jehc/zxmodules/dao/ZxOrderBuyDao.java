package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOrderBuy;

/**
* 采购订单 
* 2017-10-30 11:01:28  陈运芝
*/
public interface ZxOrderBuyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderBuy> getZxOrderBuyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderBuy getZxOrderBuyById(String id);
	/**
	* 添加
	* @param zx_order_buy 
	* @return
	*/
	public int addZxOrderBuy(ZxOrderBuy zxOrderBuy);
	/**
	* 修改
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuy(ZxOrderBuy zxOrderBuy);
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuyBySelective(ZxOrderBuy zxOrderBuy);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderBuy(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_order_buyList 
	* @return
	*/
	public int addBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList);
	/**
	* 批量修改
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuyBySelective(List<ZxOrderBuy> zxOrderBuyList);
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String, Object>> getZxOMListByCondition(Map<String,Object> condition);
}
