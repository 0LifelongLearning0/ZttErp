package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttPurchaseSonService;
import jehc.zxmodules.dao.ZttPurchaseSonDao;
import jehc.zxmodules.model.ZttPurchaseSon;

/**
* 采购子台账 
* 2018-04-29 10:08:25  季建吉
*/
@Service("zttPurchaseSonService")
public class ZttPurchaseSonServiceImpl extends BaseService implements ZttPurchaseSonService{
	@Autowired
	private ZttPurchaseSonDao zttPurchaseSonDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttPurchaseSon> getZttPurchaseSonListByCondition(Map<String,Object> condition){
		try{
			return zttPurchaseSonDao.getZttPurchaseSonListByCondition(condition);
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
	public ZttPurchaseSon getZttPurchaseSonById(String id){
		try{
			ZttPurchaseSon zttPurchaseSon = zttPurchaseSonDao.getZttPurchaseSonById(id);
			return zttPurchaseSon;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_purchase_son 
	* @return
	*/
	public int addZttPurchaseSon(ZttPurchaseSon zttPurchaseSon){
		int i = 0;
		try {
			i = zttPurchaseSonDao.addZttPurchaseSon(zttPurchaseSon);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSon(ZttPurchaseSon zttPurchaseSon){
		int i = 0;
		try {
			i = zttPurchaseSonDao.updateZttPurchaseSon(zttPurchaseSon);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase_son 
	* @return
	*/
	public int updateZttPurchaseSonBySelective(ZttPurchaseSon zttPurchaseSon){
		int i = 0;
		try {
			i = zttPurchaseSonDao.updateZttPurchaseSonBySelective(zttPurchaseSon);
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
	public int delZttPurchaseSon(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttPurchaseSonDao.delZttPurchaseSon(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int addBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList){
		int i = 0;
		try {
			i = zttPurchaseSonDao.addBatchZttPurchaseSon(zttPurchaseSonList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSonList){
		int i = 0;
		try {
			i = zttPurchaseSonDao.updateBatchZttPurchaseSon(zttPurchaseSonList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchase_sonList 
	* @return
	*/
	public int updateBatchZttPurchaseSonBySelective(List<ZttPurchaseSon> zttPurchaseSonList){
		int i = 0;
		try {
			i = zttPurchaseSonDao.updateBatchZttPurchaseSonBySelective(zttPurchaseSonList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param parent_id
	* @return
	*/
	public int delZttPurchaseSonByForeignKey(String parent_id){
		int i = 0;
		try {
			i = zttPurchaseSonDao.delZttPurchaseSonByForeignKey(parent_id);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
