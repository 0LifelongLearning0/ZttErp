package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxPeriodTransactionService;
import jehc.zxmodules.dao.ZxPeriodTransactionDao;
import jehc.zxmodules.model.ZxPeriodTransaction;

/**
* 周期性事务 
* 2017-11-16 09:50:45  袁天宇
*/
@Service("zxPeriodTransactionService")
public class ZxPeriodTransactionServiceImpl extends BaseService implements ZxPeriodTransactionService{
	@Autowired
	private ZxPeriodTransactionDao zxPeriodTransactionDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxPeriodTransaction> getZxPeriodTransactionListByCondition(Map<String,Object> condition){
		try{
			return zxPeriodTransactionDao.getZxPeriodTransactionListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxPeriodTransaction getZxPeriodTransactionById(String id){
		try{
			ZxPeriodTransaction zxPeriodTransaction = zxPeriodTransactionDao.getZxPeriodTransactionById(id);
			return zxPeriodTransaction;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_period_transaction 
	* @return
	*/
	public int addZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.addZxPeriodTransaction(zxPeriodTransaction);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.updateZxPeriodTransaction(zxPeriodTransaction);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransactionBySelective(ZxPeriodTransaction zxPeriodTransaction){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.updateZxPeriodTransactionBySelective(zxPeriodTransaction);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPeriodTransaction(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.delZxPeriodTransaction(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_period_transactionList 
	* @return
	*/
	public int addBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.addBatchZxPeriodTransaction(zxPeriodTransactionList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.updateBatchZxPeriodTransaction(zxPeriodTransactionList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransactionBySelective(List<ZxPeriodTransaction> zxPeriodTransactionList){
		int i = 0;
		try {
			i = zxPeriodTransactionDao.updateBatchZxPeriodTransactionBySelective(zxPeriodTransactionList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
