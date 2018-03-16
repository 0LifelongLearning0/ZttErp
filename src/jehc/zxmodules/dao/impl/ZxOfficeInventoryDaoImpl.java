package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOfficeInventoryDao;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxOfficeInventoryAdd;
import jehc.zxmodules.model.ZxOfficeInventoryShow;

/**
* 办公用品库存表 
* 2017-12-06 11:20:49  季建吉
*/
@Repository("zxOfficeInventoryDao")
public class ZxOfficeInventoryDaoImpl  extends BaseDaoImpl implements ZxOfficeInventoryDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryListByCondition(Map<String,Object> condition){
		return (List<ZxOfficeInventoryShow>)this.getList("getZxOfficeInventoryListByCondition",condition);
	}
	/**
	* 得到用品
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOfficeClassify> getZxOfficeInventoryClick(String id){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyByClick",id);
	}
	
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryClickById(String id){
		return (List<ZxOfficeInventoryShow>)this.getList("getZxOfficeInventoryClickById",id);
	}
	
	public List<ZxOfficeClassify> getZxOfficeselfById(String id){
		return (List<ZxOfficeClassify>)this.getList("getZxOfficeClassifyById",id);
	}
	
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryAddById(String id){
		return (List<ZxOfficeInventoryShow>)this.getList("getZxOfficeInventoryAddById",id);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOfficeInventory getZxOfficeInventoryById(String id){
		return (ZxOfficeInventory)this.get("getZxOfficeInventoryById", id);
	}
	/**
	* 添加
	* @param zx_office_inventory 
	* @return
	*/
	public int addZxOfficeInventory(ZxOfficeInventory zxOfficeInventory){
		return this.add("addZxOfficeInventory", zxOfficeInventory);
	}
	
	/**
	* 判断首次
	* @param zx_office_inventory 
	* @return
	*/
	public List<ZxOfficeInventory> judgeZxOfficeInventory(String office_id){
		return (List<ZxOfficeInventory>)this.getList("judgeZxOfficeInventoryById",office_id);
	}
	
	public int addZxOfficeInventoryAdd(ZxOfficeInventoryAdd zxOfficeInventoryAdd){
		return this.add("addZxOfficeInventoryadd", zxOfficeInventoryAdd);
	}
	/**
	* 修改
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventory(ZxOfficeInventory zxOfficeInventory){
		return this.update("updateZxOfficeInventory", zxOfficeInventory);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventoryBySelective(ZxOfficeInventory zxOfficeInventory){
		return this.update("updateZxOfficeInventoryBySelective", zxOfficeInventory);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeInventory(Map<String,Object> condition){
		return this.del("delZxOfficeInventory", condition);
	}
	/**
	* 批量添加
	* @param zx_office_inventoryList 
	* @return
	*/
	public int addBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList){
		return this.add("addBatchZxOfficeInventory", zxOfficeInventoryList);
	}
	/**
	* 批量修改
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList){
		return this.update("updateBatchZxOfficeInventory", zxOfficeInventoryList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventoryBySelective(List<ZxOfficeInventory> zxOfficeInventoryList){
		return this.update("updateBatchZxOfficeInventoryBySelective", zxOfficeInventoryList);
	}
}
