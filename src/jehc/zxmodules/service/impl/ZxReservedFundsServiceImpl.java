package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxReservedFundsService;
import jehc.zxmodules.dao.ZxReservedFundsDao;
import jehc.zxmodules.model.ZxReservedFunds;

/**
* 公积金台账 
* 2018-01-18 08:15:15  owen
*/
@Service("zxReservedFundsService")
public class ZxReservedFundsServiceImpl extends BaseService implements ZxReservedFundsService{
	@Autowired
	private ZxReservedFundsDao zxReservedFundsDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxReservedFunds> getZxReservedFundsListByCondition(Map<String,Object> condition){
		try{
			return zxReservedFundsDao.getZxReservedFundsListByCondition(condition);
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
	public ZxReservedFunds getZxReservedFundsById(String id){
		try{
			ZxReservedFunds zxReservedFunds = zxReservedFundsDao.getZxReservedFundsById(id);
			return zxReservedFunds;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_reserved_funds 
	* @return
	*/
	public int addZxReservedFunds(ZxReservedFunds zxReservedFunds){
		int i = 0;
		try {
			i = zxReservedFundsDao.addZxReservedFunds(zxReservedFunds);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFunds(ZxReservedFunds zxReservedFunds){
		int i = 0;
		try {
			i = zxReservedFundsDao.updateZxReservedFunds(zxReservedFunds);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFundsBySelective(ZxReservedFunds zxReservedFunds){
		int i = 0;
		try {
			i = zxReservedFundsDao.updateZxReservedFundsBySelective(zxReservedFunds);
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
	public int delZxReservedFunds(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxReservedFundsDao.delZxReservedFunds(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int addBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList){
		int i = 0;
		try {
			i = zxReservedFundsDao.addBatchZxReservedFunds(zxReservedFundsList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList){
		int i = 0;
		try {
			i = zxReservedFundsDao.updateBatchZxReservedFunds(zxReservedFundsList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFundsBySelective(List<ZxReservedFunds> zxReservedFundsList){
		int i = 0;
		try {
			i = zxReservedFundsDao.updateBatchZxReservedFundsBySelective(zxReservedFundsList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
