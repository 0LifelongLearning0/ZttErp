package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxLoanBill;

/**
* 借款单 
* 2017-10-10 14:59:11  袁天宇
*/
public interface ZxLoanBillDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxLoanBill> getZxLoanBillListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxLoanBill getZxLoanBillById(String id);
	/**
	* 添加
	* @param zx_loan_bill 
	* @return
	*/
	public int addZxLoanBill(ZxLoanBill zxLoanBill);
	/**
	* 修改
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBill(ZxLoanBill zxLoanBill);
	/**
	* 修改（根据动态条件）
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBillBySelective(ZxLoanBill zxLoanBill);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxLoanBill(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_loan_billList 
	* @return
	*/
	public int addBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList);
	/**
	* 批量修改
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBillBySelective(List<ZxLoanBill> zxLoanBillList);
}
