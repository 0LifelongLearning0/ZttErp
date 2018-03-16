package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxLoanBillDao;
import jehc.zxmodules.model.ZxLoanBill;

/**
* 借款单 
* 2017-10-10 14:59:11  袁天宇
*/
@Repository("zxLoanBillDao")
public class ZxLoanBillDaoImpl  extends BaseDaoImpl implements ZxLoanBillDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxLoanBill> getZxLoanBillListByCondition(Map<String,Object> condition){
		return (List<ZxLoanBill>)this.getList("getZxLoanBillListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxLoanBill getZxLoanBillById(String id){
		return (ZxLoanBill)this.get("getZxLoanBillById", id);
	}
	/**
	* 添加
	* @param zx_loan_bill 
	* @return
	*/
	public int addZxLoanBill(ZxLoanBill zxLoanBill){
		return this.add("addZxLoanBill", zxLoanBill);
	}
	/**
	* 修改
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBill(ZxLoanBill zxLoanBill){
		return this.update("updateZxLoanBill", zxLoanBill);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBillBySelective(ZxLoanBill zxLoanBill){
		return this.update("updateZxLoanBillBySelective", zxLoanBill);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxLoanBill(Map<String,Object> condition){
		return this.del("delZxLoanBill", condition);
	}
	/**
	* 批量添加
	* @param zx_loan_billList 
	* @return
	*/
	public int addBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList){
		return this.add("addBatchZxLoanBill", zxLoanBillList);
	}
	/**
	* 批量修改
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList){
		return this.update("updateBatchZxLoanBill", zxLoanBillList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBillBySelective(List<ZxLoanBill> zxLoanBillList){
		return this.update("updateBatchZxLoanBillBySelective", zxLoanBillList);
	}
}
