package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxRelieveContractDao;
import jehc.zxmodules.model.ZxRelieveContract;

/**
* 解除合同 
* 2018-01-11 17:48:26  owen
*/
@Repository("zxRelieveContractDao")
public class ZxRelieveContractDaoImpl  extends BaseDaoImpl implements ZxRelieveContractDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxRelieveContract> getZxRelieveContractListByCondition(Map<String,Object> condition){
		return (List<ZxRelieveContract>)this.getList("getZxRelieveContractListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxRelieveContract getZxRelieveContractById(String id){
		return (ZxRelieveContract)this.get("getZxRelieveContractById", id);
	}
	/**
	* 添加
	* @param zx_relieve_contract 
	* @return
	*/
	public int addZxRelieveContract(ZxRelieveContract zxRelieveContract){
		return this.add("addZxRelieveContract", zxRelieveContract);
	}
	/**
	* 修改
	* @param zx_relieve_contract 
	* @return
	*/
	public int updateZxRelieveContract(ZxRelieveContract zxRelieveContract){
		return this.update("updateZxRelieveContract", zxRelieveContract);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_relieve_contract 
	* @return
	*/
	public int updateZxRelieveContractBySelective(ZxRelieveContract zxRelieveContract){
		return this.update("updateZxRelieveContractBySelective", zxRelieveContract);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxRelieveContract(Map<String,Object> condition){
		return this.del("delZxRelieveContract", condition);
	}
	/**
	* 批量添加
	* @param zx_relieve_contractList 
	* @return
	*/
	public int addBatchZxRelieveContract(List<ZxRelieveContract> zxRelieveContractList){
		return this.add("addBatchZxRelieveContract", zxRelieveContractList);
	}
	/**
	* 批量修改
	* @param zx_relieve_contractList 
	* @return
	*/
	public int updateBatchZxRelieveContract(List<ZxRelieveContract> zxRelieveContractList){
		return this.update("updateBatchZxRelieveContract", zxRelieveContractList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_relieve_contractList 
	* @return
	*/
	public int updateBatchZxRelieveContractBySelective(List<ZxRelieveContract> zxRelieveContractList){
		return this.update("updateBatchZxRelieveContractBySelective", zxRelieveContractList);
	}
}
