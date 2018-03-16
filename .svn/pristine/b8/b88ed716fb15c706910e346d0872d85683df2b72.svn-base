package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxOfficeInventoryShow;

/**
* 办公用品库存表 
* 2017-12-06 11:20:49  季建吉
*/
public interface ZxOfficeInventoryService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryListByCondition(Map<String,Object> condition);
	
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryClick(String id);
	public ZxOfficeInventoryShow getZxOfficeInventoryAddById(String id);
	
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOfficeInventory getZxOfficeInventoryById(String id);
	/**
	* 添加
	* @param zx_office_inventory 
	* @return
	*/
	public int addZxOfficeInventory(ZxOfficeInventoryShow zxOfficeInventory);
	
	public int addZxOfficeInventoryAdd(ZxOfficeInventoryShow zxOfficeInventory);
	/**
	* 修改
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventory(ZxOfficeInventory zxOfficeInventory);
	/**
	* 修改（根据动态条件）
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventoryBySelective(ZxOfficeInventory zxOfficeInventory);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeInventory(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_office_inventoryList 
	* @return
	*/
	public int addBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList);
	/**
	* 批量修改
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventoryBySelective(List<ZxOfficeInventory> zxOfficeInventoryList);
}
