package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttOrder;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
public interface ZttOrderService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrder> getZttOrderListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrder getZttOrderById(String id);
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrder(ZttOrder zttOrder);
	/**
	* 修改
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrder(ZttOrder zttOrder);
	/**
	* 修改（根据动态条件）
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrderBySelective(ZttOrder zttOrder);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrder(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_orderList 
	* @return
	*/
	public int addBatchZttOrder(List<ZttOrder> zttOrderList);
	/**
	* 批量修改
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrder(List<ZttOrder> zttOrderList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrderBySelective(List<ZttOrder> zttOrderList);
}
