package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxPeriodTransaction;

/**
* 周期性事务 
* 2017-11-16 09:50:45  袁天宇
*/
public interface ZxPeriodTransactionDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxPeriodTransaction> getZxPeriodTransactionListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxPeriodTransaction getZxPeriodTransactionById(String id);
	/**
	* 添加
	* @param zx_period_transaction 
	* @return
	*/
	public int addZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction);
	/**
	* 修改
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction);
	/**
	* 修改（根据动态条件）
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransactionBySelective(ZxPeriodTransaction zxPeriodTransaction);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPeriodTransaction(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_period_transactionList 
	* @return
	*/
	public int addBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList);
	/**
	* 批量修改
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransactionBySelective(List<ZxPeriodTransaction> zxPeriodTransactionList);
}
