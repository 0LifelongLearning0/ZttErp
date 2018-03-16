package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOrderBuyDao;
import jehc.zxmodules.model.ZxOrderBuy;

import org.springframework.stereotype.Repository;

/**
* 采购订单 
* 2017-10-30 11:01:28  陈运芝
*/
@Repository("zxOrderBuyDao")
public class ZxOrderBuyDaoImpl  extends BaseDaoImpl implements ZxOrderBuyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOrderBuy> getZxOrderBuyListByCondition(Map<String,Object> condition){
		return (List<ZxOrderBuy>)this.getList("getZxOrderBuyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderBuy getZxOrderBuyById(String id){
		return (ZxOrderBuy)this.get("getZxOrderBuyById", id);
	}
	/**
	* 添加
	* @param zx_order_buy 
	* @return
	*/
	public int addZxOrderBuy(ZxOrderBuy zxOrderBuy){
		return this.add("addZxOrderBuy", zxOrderBuy);
	}
	/**
	* 修改
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuy(ZxOrderBuy zxOrderBuy){
		return this.update("updateZxOrderBuy", zxOrderBuy);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuyBySelective(ZxOrderBuy zxOrderBuy){
		return this.update("updateZxOrderBuyBySelective", zxOrderBuy);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderBuy(Map<String,Object> condition){
		return this.del("delZxOrderBuy", condition);
	}
	/**
	* 批量添加
	* @param zx_order_buyList 
	* @return
	*/
	public int addBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList){
		return this.add("addBatchZxOrderBuy", zxOrderBuyList);
	}
	/**
	* 批量修改
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList){
		return this.update("updateBatchZxOrderBuy", zxOrderBuyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuyBySelective(List<ZxOrderBuy> zxOrderBuyList){
		return this.update("updateBatchZxOrderBuyBySelective", zxOrderBuyList);
	}
	/**
	* 获取订单下物料分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getZxOMListByCondition(Map<String,Object> condition){
		return (List<Map<String, Object>>)this.getList("getZxOMListByCondition",condition);
	}
}
