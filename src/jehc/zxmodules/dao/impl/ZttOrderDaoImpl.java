package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttOrderDao;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderCheckHistory;
import jehc.zxmodules.model.ZttOrdernumber;
import jehc.zxmodules.model.ZttOrdernumber_third;
import jehc.zxmodules.model.ZxGoodsApplyDetail;
import jehc.zxmodules.model.ztt_filerecord;
import jehc.zxmodules.model.ztt_processproduct;

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
	public ZttOrdernumber getZttOrdernumberbyId(String id){
		return (ZttOrdernumber)this.get("getZttOrdernumberbyId", id);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrdernumber_third getzttordernumberthirdbyId(String order_id){
		return (ZttOrdernumber_third)this.get("getzttordernumberthirdbyId", order_id);
	}
	/**
	* 得到最大id
	* @param id 
	* @return
	*/
	public ZttOrdernumber_third selectmax_id(String order_id){
		return (ZttOrdernumber_third)this.get("ZttOrdernumber_selectmaxid", order_id);
	}
	/**
	* 得到最大id
	* @param id 
	* @return
	*/
	public String ZttOrdernumber_max(String order_id){
		return (String) this.get("ZttOrdernumber_max", order_id);
	}
	/**
	* 得到最大id
	* @param id 
	* @return
	*/
	public String ZttOrdernumber_max_purchase(String order_id){
		return (String) this.get("ZttOrdernumber_max_purchase", order_id);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public List<ztt_processproduct> getprocessingtechnicById(String order_id){
		return (List<ztt_processproduct>)this.getList("getprocessingtechnicById",order_id);
	}
	/**
	* 查询机械加工对象
	* @param id 
	* @return
	*/
	public ZttOrder getZttOrderById(String id){
		return (ZttOrder)this.get("getZttOrderById", id);
	}
	public List<ZttOrderCheckHistory> getZttOrderhisById(Map<String,Object> condition){
		return (List<ZttOrderCheckHistory>)this.getList("getprocessinghisById", condition);
	}
	public List<ZttOrderCheckHistory> getZttOrderNotApply(Map<String,Object> condition){
		return (List<ZttOrderCheckHistory>)this.getList("getZttOrderNotApply", condition);
	}
	
	public List<ztt_filerecord> getfilerecordById(Map<String,Object> condition){
		return (List<ztt_filerecord>)this.getList("getfilerecordById", condition);
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrdnum(ZttOrdernumber_third zttOrdernumber_third){
		return this.add("addZttOrdnum", zttOrdernumber_third);
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrder(ZttOrder zttOrder){
		return this.add("addZttOrder", zttOrder);
	}
	public int addZttOrderfileRecord(ztt_filerecord ztt_filerecord){
		return this.add("addZttOrderfileRecord", ztt_filerecord);
	}
	public int addZttOrderCheckHistory(ZttOrderCheckHistory zttOrderCheckHistory){
		return this.add("addZttOrderCheckHistory", zttOrderCheckHistory);
	}
	/**
	* 添加机械加工工艺
	* @param ztt_order 
	* @return
	*/
	public int addztt_processproduct(ztt_processproduct ztt_processproduct){
		return this.add("addztt_processproduct", ztt_processproduct);
	}
	/**
	* 修改合同号
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrder(ZttOrder zttOrder){
		return this.update("updatecontraact_number", zttOrder);
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
	* 修改（根据动态条件）
	* @param ztt_order 
	* @return
	*/
	public int updateztt_processproductBySelective(ztt_processproduct ztt_processproduct){
		return this.update("updateztt_processproductBySelective", ztt_processproduct);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrder(Map<String,Object> condition){
		return this.del("delZttOrder", condition);
	}
	public int delZttOrdnum(Map<String,Object> condition){
		return this.del("delZttOrdnum", condition);
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
