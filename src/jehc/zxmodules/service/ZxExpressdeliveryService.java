package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxExpressdelivery;

/**
* 快递邮寄 
* 2017-11-24 13:10:10  陈运芝
*/
public interface ZxExpressdeliveryService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxExpressdelivery> getZxExpressdeliveryListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxExpressdelivery getZxExpressdeliveryById(String id);
	/**
	* 添加
	* @param zx_expressdelivery 
	* @return
	*/
	public int addZxExpressdelivery(ZxExpressdelivery zxExpressdelivery);
	/**
	* 修改
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdelivery(ZxExpressdelivery zxExpressdelivery);
	/**
	* 修改（根据动态条件）
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdeliveryBySelective(ZxExpressdelivery zxExpressdelivery);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxExpressdelivery(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int addBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList);
	/**
	* 批量修改
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdeliveryBySelective(List<ZxExpressdelivery> zxExpressdeliveryList);
}
