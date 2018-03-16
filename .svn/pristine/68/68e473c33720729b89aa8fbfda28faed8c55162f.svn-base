package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxChangeContractService;
import jehc.zxmodules.dao.ZxChangeContractDao;
import jehc.zxmodules.model.ZxChangeContract;

/**
* 变更合同 
* 2018-01-17 14:05:05  owen
*/
@Service("zxChangeContractService")
public class ZxChangeContractServiceImpl extends BaseService implements ZxChangeContractService{
	@Autowired
	private ZxChangeContractDao zxChangeContractDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxChangeContract> getZxChangeContractListByCondition(Map<String,Object> condition){
		try{
			return zxChangeContractDao.getZxChangeContractListByCondition(condition);
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
	public ZxChangeContract getZxChangeContractById(String id){
		try{
			ZxChangeContract zxChangeContract = zxChangeContractDao.getZxChangeContractById(id);
			return zxChangeContract;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_change_contract 
	* @return
	*/
	public int addZxChangeContract(ZxChangeContract zxChangeContract){
		int i = 0;
		try {
			i = zxChangeContractDao.addZxChangeContract(zxChangeContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContract(ZxChangeContract zxChangeContract){
		int i = 0;
		try {
			i = zxChangeContractDao.updateZxChangeContract(zxChangeContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContractBySelective(ZxChangeContract zxChangeContract){
		int i = 0;
		try {
			i = zxChangeContractDao.updateZxChangeContractBySelective(zxChangeContract);
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
	public int delZxChangeContract(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxChangeContractDao.delZxChangeContract(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_change_contractList 
	* @return
	*/
	public int addBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList){
		int i = 0;
		try {
			i = zxChangeContractDao.addBatchZxChangeContract(zxChangeContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList){
		int i = 0;
		try {
			i = zxChangeContractDao.updateBatchZxChangeContract(zxChangeContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContractBySelective(List<ZxChangeContract> zxChangeContractList){
		int i = 0;
		try {
			i = zxChangeContractDao.updateBatchZxChangeContractBySelective(zxChangeContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
