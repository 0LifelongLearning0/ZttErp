package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderCheckHistory;
import jehc.zxmodules.model.ZttOrdernumber;
import jehc.zxmodules.model.ZttOrdernumber_third;
import jehc.zxmodules.model.ztt_filerecord;
import jehc.zxmodules.model.ztt_processproduct;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
public interface ZttOrderDao{
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
	public ZttOrdernumber getZttOrdernumberbyId(String id);
	public ZttOrdernumber_third getzttordernumberthirdbyId(String order_id);
	public ZttOrdernumber_third selectmax_id(String order_id);
	public int addZttOrdnum(ZttOrdernumber_third zttOrdernumber_third);
	public int addztt_processproduct(ztt_processproduct ztt_processproduct);
	public List<ztt_processproduct> getprocessingtechnicById(String order_id);
	public int updateztt_processproductBySelective(ztt_processproduct ztt_processproduct);
	public int addZttOrderCheckHistory(ZttOrderCheckHistory zttOrderCheckHistory);
	public List<ZttOrderCheckHistory> getZttOrderhisById(Map<String,Object> condition);
	public List<ztt_filerecord> getfilerecordById(Map<String,Object> condition);
	public int addZttOrderfileRecord(ztt_filerecord ztt_filerecord);
	public int delZttOrdnum(Map<String,Object> condition);
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
