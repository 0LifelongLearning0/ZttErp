package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.dao.ZttClientDao;
import jehc.zxmodules.model.ZttClient;
import jehc.zxmodules.service.ZttClientService;

/**
* 客户管理 
* 2018-04-13 16:20:35  季建吉
*/
@Service("zttClientService")
public class ZttClientServiceImpl extends BaseService implements ZttClientService{
	@Autowired
	private ZttClientDao zttClientDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttClient> getZttClientListByCondition(Map<String,Object> condition){
		try{
			return zttClientDao.getZttClientListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttClient getZttClientById(String id){
		try{
			ZttClient zttClient = zttClientDao.getZttClientById(id);
			return zttClient;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_client 
	* @return
	*/
	public int addZttClient(ZttClient zttClient){
		int i = 0;
		try {
			i = zttClientDao.addZttClient(zttClient);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_client 
	* @return
	*/
	public int updateZttClient(ZttClient zttClient){
		int i = 0;
		try {
			i = zttClientDao.updateZttClient(zttClient);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_client 
	* @return
	*/
	public int updateZttClientBySelective(ZttClient zttClient){
		int i = 0;
		try {
			i = zttClientDao.updateZttClientBySelective(zttClient);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttClient(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttClientDao.delZttClient(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_clientList 
	* @return
	*/
	public int addBatchZttClient(List<ZttClient> zttClientList){
		int i = 0;
		try {
			i = zttClientDao.addBatchZttClient(zttClientList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClient(List<ZttClient> zttClientList){
		int i = 0;
		try {
			i = zttClientDao.updateBatchZttClient(zttClientList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_clientList 
	* @return
	*/
	public int updateBatchZttClientBySelective(List<ZttClient> zttClientList){
		int i = 0;
		try {
			i = zttClientDao.updateBatchZttClientBySelective(zttClientList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
