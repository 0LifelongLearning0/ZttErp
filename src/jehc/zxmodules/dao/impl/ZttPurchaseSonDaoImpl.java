package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttPurchaseSonDao;
import jehc.zxmodules.model.ZttPurchaseSon;

/**
* 采购子台账 
* 2018-04-29 10:08:25  季建吉
*/
@Repository("zttPurchaseSonDao")
public class ZttPurchaseSonDaoImpl  extends BaseDaoImpl implements ZttPurchaseSonDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttPurchaseSon> getZttPurchaseSonListByCondition(Map<String,Object> condition){
		return (List<ZttPurchaseSon>)this.getList("getZttPurchaseSonListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttPurchaseSon getZttPurchaseSonById(String id){
		return (ZttPurchaseSon)this.get("getZttPurchaseSonById", id);
	}
	/**
	* 添加
	* @param ztt_purchase_son 
	* @return
	*/
	public int addZttPurchaseSon(ZttPurchaseSon zttPurchaseSon){
		return this.add("addZttPurchaseSon", zttPurchaseSon);
	}
	/**
	* 修改
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSon(ZttPurchaseSon zttPurchaseSon){
		return this.update("updateZttPurchaseSon", zttPurchaseSon);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSonBySelective(ZttPurchaseSon zttPurchaseSon){
		return this.update("updateZttPurchaseSonBySelective", zttPurchaseSon);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttPurchaseSon(Map<String,Object> condition){
		return this.del("delZttPurchaseSon", condition);
	}
	/**
	* 批量添加
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int addBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList){
		return this.add("addBatchZttPurchaseSon", zttPurchaseSonList);
	}
	/**
	* 批量修改
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList){
		return this.update("updateBatchZttPurchaseSon", zttPurchaseSonList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSonBySelective(List<ZttPurchaseSon> zttPurchaseSonList){
		return this.update("updateBatchZttPurchaseSonBySelective", zttPurchaseSonList);
	}
	/**
	* 根据外键删除方法
	* @param parent_id
	* @return
	*/
	public int delZttPurchaseSonByForeignKey(String parent_id){
		return this.del("delZttPurchaseSonByForeignKey", parent_id);
	}
}
