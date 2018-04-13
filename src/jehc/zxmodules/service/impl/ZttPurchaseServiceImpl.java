package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttPurchaseService;
import jehc.zxmodules.dao.ZttPurchaseDao;
import jehc.zxmodules.model.ZttPurchase;

/**
* 采购台账 
* 2018-04-03 12:43:49  季建吉
*/
@Service("zttPurchaseService")
public class ZttPurchaseServiceImpl extends BaseService implements ZttPurchaseService{
	@Autowired
	private ZttPurchaseDao zttPurchaseDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttPurchase> getZttPurchaseListByCondition(Map<String,Object> condition){
		try{
			return zttPurchaseDao.getZttPurchaseListByCondition(condition);
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
	public ZttPurchase getZttPurchaseById(String id){
		try{
			ZttPurchase zttPurchase = zttPurchaseDao.getZttPurchaseById(id);
			return zttPurchase;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_purchase 
	* @return
	*/
	public int addZttPurchase(ZttPurchase zttPurchase){
		int i = 0;
		try {
			i = zttPurchaseDao.addZttPurchase(zttPurchase);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchase(ZttPurchase zttPurchase){
		int i = 0;
		try {
			i = zttPurchaseDao.updateZttPurchase(zttPurchase);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchaseBySelective(ZttPurchase zttPurchase){
		int i = 0;
		try {
			double cost_single_price=zttPurchase.getCost_single_price();
			double amount=zttPurchase.getAmount();
			zttPurchase.setCost_sum_price(cost_single_price*amount);
			i = zttPurchaseDao.updateZttPurchaseBySelective(zttPurchase);
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
	public int delZttPurchase(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttPurchaseDao.delZttPurchase(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_purchaseList 
	* @return
	*/
	public int addBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.addBatchZttPurchase(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.updateBatchZttPurchase(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchaseBySelective(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.updateBatchZttPurchaseBySelective(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
