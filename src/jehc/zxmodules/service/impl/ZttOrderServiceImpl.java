package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.dao.ZttOrderDao;
import jehc.zxmodules.model.ZttOrder;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
@Service("zttOrderService")
public class ZttOrderServiceImpl extends BaseService implements ZttOrderService{
	@Autowired
	private ZttOrderDao zttOrderDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrder> getZttOrderListByCondition(Map<String,Object> condition){
		try{
			return zttOrderDao.getZttOrderListByCondition(condition);
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
	public ZttOrder getZttOrderById(String id){
		try{
			ZttOrder zttOrder = zttOrderDao.getZttOrderById(id);
			return zttOrder;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrder(ZttOrder zttOrder){
		int i = 0;
		try {
			double price=zttOrder.getSingle_price();
			double amount=zttOrder.getAmount();
			double sum=price*amount;
			zttOrder.setSum_price(sum);
			i = zttOrderDao.addZttOrder(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrder(ZttOrder zttOrder){
		int i = 0;
		try {
			i = zttOrderDao.updateZttOrder(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrderBySelective(ZttOrder zttOrder){
		int i = 0;
		try {
			i = zttOrderDao.updateZttOrderBySelective(zttOrder);
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
	public int delZttOrder(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttOrderDao.delZttOrder(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_orderList 
	* @return
	*/
	public int addBatchZttOrder(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.addBatchZttOrder(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrder(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.updateBatchZttOrder(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrderBySelective(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.updateBatchZttOrderBySelective(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
