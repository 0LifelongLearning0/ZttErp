package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttOrderDao;
import jehc.zxmodules.model.ZttOrder;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
@Repository("zttOrderDao")
public class ZttOrderDaoImpl  extends BaseDaoImpl implements ZttOrderDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttOrder> getZttOrderListByCondition(Map<String,Object> condition){
		return (List<ZttOrder>)this.getList("getZttOrderListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrder getZttOrderById(String id){
		return (ZttOrder)this.get("getZttOrderById", id);
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrder(ZttOrder zttOrder){
		return this.add("addZttOrder", zttOrder);
	}
	/**
	* 修改
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrder(ZttOrder zttOrder){
		return this.update("updateZttOrder", zttOrder);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrderBySelective(ZttOrder zttOrder){
		return this.update("updateZttOrderBySelective", zttOrder);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrder(Map<String,Object> condition){
		return this.del("delZttOrder", condition);
	}
	/**
	* 批量添加
	* @param ztt_orderList 
	* @return
	*/
	public int addBatchZttOrder(List<ZttOrder> zttOrderList){
		return this.add("addBatchZttOrder", zttOrderList);
	}
	/**
	* 批量修改
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrder(List<ZttOrder> zttOrderList){
		return this.update("updateBatchZttOrder", zttOrderList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrderBySelective(List<ZttOrder> zttOrderList){
		return this.update("updateBatchZttOrderBySelective", zttOrderList);
	}
}
