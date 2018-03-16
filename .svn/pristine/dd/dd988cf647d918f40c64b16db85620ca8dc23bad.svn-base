package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxRelieveContractService;
import jehc.zxmodules.dao.ZxRelieveContractDao;
import jehc.zxmodules.model.ZxRelieveContract;

/**
* 解除合同 
* 2018-01-11 17:48:26  owen
*/
@Service("zxRelieveContractService")
public class ZxRelieveContractServiceImpl extends BaseService implements ZxRelieveContractService{
	@Autowired
	private ZxRelieveContractDao zxRelieveContractDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxRelieveContract> getZxRelieveContractListByCondition(Map<String,Object> condition){
		try{
			return zxRelieveContractDao.getZxRelieveContractListByCondition(condition);
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
	public ZxRelieveContract getZxRelieveContractById(String id){
		try{
			ZxRelieveContract zxRelieveContract = zxRelieveContractDao.getZxRelieveContractById(id);
			return zxRelieveContract;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_relieve_contract 
	* @return
	*/
	public int addZxRelieveContract(ZxRelieveContract zxRelieveContract){
		int i = 0;
		try {
			i = zxRelieveContractDao.addZxRelieveContract(zxRelieveContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_relieve_contract 
	* @return
	*/
	public int updateZxRelieveContract(ZxRelieveContract zxRelieveContract){
		int i = 0;
		try {
			i = zxRelieveContractDao.updateZxRelieveContract(zxRelieveContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_relieve_contract 
	* @return
	*/
	public int updateZxRelieveContractBySelective(ZxRelieveContract zxRelieveContract){
		int i = 0;
		try {
			i = zxRelieveContractDao.updateZxRelieveContractBySelective(zxRelieveContract);
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
	public int delZxRelieveContract(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxRelieveContractDao.delZxRelieveContract(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_relieve_contractList 
	* @return
	*/
	public int addBatchZxRelieveContract(List<ZxRelieveContract> zxRelieveContractList){
		int i = 0;
		try {
			i = zxRelieveContractDao.addBatchZxRelieveContract(zxRelieveContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_relieve_contractList 
	* @return
	*/
	public int updateBatchZxRelieveContract(List<ZxRelieveContract> zxRelieveContractList){
		int i = 0;
		try {
			i = zxRelieveContractDao.updateBatchZxRelieveContract(zxRelieveContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_relieve_contractList 
	* @return
	*/
	public int updateBatchZxRelieveContractBySelective(List<ZxRelieveContract> zxRelieveContractList){
		int i = 0;
		try {
			i = zxRelieveContractDao.updateBatchZxRelieveContractBySelective(zxRelieveContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
