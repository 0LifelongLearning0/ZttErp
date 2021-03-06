package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeInventoryShow;

/**
* 办公用品管理 
* 2018-01-11 13:16:08  季建吉
*/
public interface ZxOfficeService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOffice> getZxOfficeListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param office_id 
	* @return
	*/
	public ZxOffice getZxOfficeById(String office_id);
	/**
	* 添加
	* @param zx_office 
	* @return
	*/
	public int addZxOffice(ZxOffice zxOffice);
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryClick(String id);
	public List<String> getZxOfficeClassfyById(String id);
	/**
	* 修改
	* @param zx_office 
	* @return
	*/
	public int updateZxOffice(ZxOffice zxOffice);
	/**
	* 修改（根据动态条件）
	* @param zx_office 
	* @return
	*/
	public int updateZxOfficeBySelective(ZxOffice zxOffice);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOffice(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_officeList 
	* @return
	*/
	public int addBatchZxOffice(List<ZxOffice> zxOfficeList);
	/**
	* 批量修改
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOffice(List<ZxOffice> zxOfficeList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOfficeBySelective(List<ZxOffice> zxOfficeList);
}
