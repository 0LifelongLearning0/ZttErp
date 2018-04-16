package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttClientDao;
import jehc.zxmodules.model.ZttClient;

/**
* 客户管理 
* 2018-04-13 16:20:35  季建吉
*/
@Repository("zttClientDao")
public class ZttClientDaoImpl  extends BaseDaoImpl implements ZttClientDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttClient> getZttClientListByCondition(Map<String,Object> condition){
		return (List<ZttClient>)this.getList("getZttClientListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttClient getZttClientById(String id){
		return (ZttClient)this.get("getZttClientById", id);
	}
	/**
	* 添加
	* @param ztt_client 
	* @return
	*/
	public int addZttClient(ZttClient zttClient){
		return this.add("addZttClient", zttClient);
	}
	/**
	* 修改
	* @param ztt_client 
	* @return
	*/
	public int updateZttClient(ZttClient zttClient){
		return this.update("updateZttClient", zttClient);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_client 
	* @return
	*/
	public int updateZttClientBySelective(ZttClient zttClient){
		return this.update("updateZttClientBySelective", zttClient);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttClient(Map<String,Object> condition){
		return this.del("delZttClient", condition);
	}
	/**
	* 批量添加
	* @param ztt_clientList 
	* @return
	*/
	public int addBatchZttClient(List<ZttClient> zttClientList){
		return this.add("addBatchZttClient", zttClientList);
	}
	/**
	* 批量修改
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClient(List<ZttClient> zttClientList){
		return this.update("updateBatchZttClient", zttClientList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClientBySelective(List<ZttClient> zttClientList){
		return this.update("updateBatchZttClientBySelective", zttClientList);
	}
}
