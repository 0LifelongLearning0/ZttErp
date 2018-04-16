package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttClient;

/**
* 客户管理 
* 2018-04-13 16:20:35  季建吉
*/
public interface ZttClientDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttClient> getZttClientListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttClient getZttClientById(String id);
	/**
	* 添加
	* @param ztt_client 
	* @return
	*/
	public int addZttClient(ZttClient zttClient);
	/**
	* 修改
	* @param ztt_client 
	* @return
	*/
	public int updateZttClient(ZttClient zttClient);
	/**
	* 修改（根据动态条件）
	* @param ztt_client 
	* @return
	*/
	public int updateZttClientBySelective(ZttClient zttClient);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttClient(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_clientList 
	* @return
	*/
	public int addBatchZttClient(List<ZttClient> zttClientList);
	/**
	* 批量修改
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClient(List<ZttClient> zttClientList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClientBySelective(List<ZttClient> zttClientList);
}
