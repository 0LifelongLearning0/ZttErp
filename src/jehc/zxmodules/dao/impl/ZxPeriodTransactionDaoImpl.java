package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxPeriodTransactionDao;
import jehc.zxmodules.model.ZxPeriodTransaction;

/**
* 周期性事务 
* 2017-11-16 09:50:45  袁天宇
*/
@Repository("zxPeriodTransactionDao")
public class ZxPeriodTransactionDaoImpl  extends BaseDaoImpl implements ZxPeriodTransactionDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxPeriodTransaction> getZxPeriodTransactionListByCondition(Map<String,Object> condition){
		return (List<ZxPeriodTransaction>)this.getList("getZxPeriodTransactionListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxPeriodTransaction getZxPeriodTransactionById(String id){
		return (ZxPeriodTransaction)this.get("getZxPeriodTransactionById", id);
	}
	/**
	* 添加
	* @param zx_period_transaction 
	* @return
	*/
	public int addZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction){
		return this.add("addZxPeriodTransaction", zxPeriodTransaction);
	}
	/**
	* 修改
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction){
		return this.update("updateZxPeriodTransaction", zxPeriodTransaction);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_period_transaction 
	* @return
	*/
	public int updateZxPeriodTransactionBySelective(ZxPeriodTransaction zxPeriodTransaction){
		return this.update("updateZxPeriodTransactionBySelective", zxPeriodTransaction);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPeriodTransaction(Map<String,Object> condition){
		return this.del("delZxPeriodTransaction", condition);
	}
	/**
	* 批量添加
	* @param zx_period_transactionList 
	* @return
	*/
	public int addBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList){
		return this.add("addBatchZxPeriodTransaction", zxPeriodTransactionList);
	}
	/**
	* 批量修改
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransaction(List<ZxPeriodTransaction> zxPeriodTransactionList){
		return this.update("updateBatchZxPeriodTransaction", zxPeriodTransactionList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_period_transactionList 
	* @return
	*/
	public int updateBatchZxPeriodTransactionBySelective(List<ZxPeriodTransaction> zxPeriodTransactionList){
		return this.update("updateBatchZxPeriodTransactionBySelective", zxPeriodTransactionList);
	}
}
