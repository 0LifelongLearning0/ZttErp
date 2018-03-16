package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxLoanBillService;
import jehc.zxmodules.dao.ZxLoanBillDao;
import jehc.zxmodules.model.ZxLoanBill;

/**
* 借款单 
* 2017-10-10 14:59:11  袁天宇
*/
@Service("zxLoanBillService")
public class ZxLoanBillServiceImpl extends BaseService implements ZxLoanBillService{
	@Autowired
	private ZxLoanBillDao zxLoanBillDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxLoanBill> getZxLoanBillListByCondition(Map<String,Object> condition){
		try{
			return zxLoanBillDao.getZxLoanBillListByCondition(condition);
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
	public ZxLoanBill getZxLoanBillById(String id){
		try{
			ZxLoanBill zxLoanBill = zxLoanBillDao.getZxLoanBillById(id);
			return zxLoanBill;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_loan_bill 
	* @return
	*/
	public int addZxLoanBill(ZxLoanBill zxLoanBill){
		int i = 0;
		try {
			i = zxLoanBillDao.addZxLoanBill(zxLoanBill);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBill(ZxLoanBill zxLoanBill){
		int i = 0;
		try {
			i = zxLoanBillDao.updateZxLoanBill(zxLoanBill);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_loan_bill 
	* @return
	*/
	public int updateZxLoanBillBySelective(ZxLoanBill zxLoanBill){
		int i = 0;
		try {
			i = zxLoanBillDao.updateZxLoanBillBySelective(zxLoanBill);
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
	public int delZxLoanBill(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxLoanBillDao.delZxLoanBill(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_loan_billList 
	* @return
	*/
	public int addBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList){
		int i = 0;
		try {
			i = zxLoanBillDao.addBatchZxLoanBill(zxLoanBillList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBill(List<ZxLoanBill> zxLoanBillList){
		int i = 0;
		try {
			i = zxLoanBillDao.updateBatchZxLoanBill(zxLoanBillList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_loan_billList 
	* @return
	*/
	public int updateBatchZxLoanBillBySelective(List<ZxLoanBill> zxLoanBillList){
		int i = 0;
		try {
			i = zxLoanBillDao.updateBatchZxLoanBillBySelective(zxLoanBillList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
