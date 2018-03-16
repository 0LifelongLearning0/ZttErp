package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxSignContractService;
import jehc.zxmodules.dao.ZxSignContractDao;
import jehc.zxmodules.model.ZxSignContract;

/**
* 签订合同 
* 2018-01-11 13:56:25  owen
*/
@Service("zxSignContractService")
public class ZxSignContractServiceImpl extends BaseService implements ZxSignContractService{
	@Autowired
	private ZxSignContractDao zxSignContractDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxSignContract> getZxSignContractListByCondition(Map<String,Object> condition){
		try{
			return zxSignContractDao.getZxSignContractListByCondition(condition);
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
	public ZxSignContract getZxSignContractById(String id){
		try{
			ZxSignContract zxSignContract = zxSignContractDao.getZxSignContractById(id);
			return zxSignContract;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_sign_contract 
	* @return
	*/
	public int addZxSignContract(ZxSignContract zxSignContract){
		int i = 0;
		try {
			i = zxSignContractDao.addZxSignContract(zxSignContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_sign_contract 
	* @return
	*/
	public int updateZxSignContract(ZxSignContract zxSignContract){
		int i = 0;
		try {
			i = zxSignContractDao.updateZxSignContract(zxSignContract);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_sign_contract 
	* @return
	*/
	public int updateZxSignContractBySelective(ZxSignContract zxSignContract){
		int i = 0;
		try {
			i = zxSignContractDao.updateZxSignContractBySelective(zxSignContract);
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
	public int delZxSignContract(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxSignContractDao.delZxSignContract(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_sign_contractList 
	* @return
	*/
	public int addBatchZxSignContract(List<ZxSignContract> zxSignContractList){
		int i = 0;
		try {
			i = zxSignContractDao.addBatchZxSignContract(zxSignContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_sign_contractList 
	* @return
	*/
	public int updateBatchZxSignContract(List<ZxSignContract> zxSignContractList){
		int i = 0;
		try {
			i = zxSignContractDao.updateBatchZxSignContract(zxSignContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_sign_contractList 
	* @return
	*/
	public int updateBatchZxSignContractBySelective(List<ZxSignContract> zxSignContractList){
		int i = 0;
		try {
			i = zxSignContractDao.updateBatchZxSignContractBySelective(zxSignContractList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
