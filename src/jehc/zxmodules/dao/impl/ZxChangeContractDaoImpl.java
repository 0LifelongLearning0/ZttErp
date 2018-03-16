package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxChangeContractDao;
import jehc.zxmodules.model.ZxChangeContract;

/**
* 变更合同 
* 2018-01-17 14:05:05  owen
*/
@Repository("zxChangeContractDao")
public class ZxChangeContractDaoImpl  extends BaseDaoImpl implements ZxChangeContractDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxChangeContract> getZxChangeContractListByCondition(Map<String,Object> condition){
		return (List<ZxChangeContract>)this.getList("getZxChangeContractListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxChangeContract getZxChangeContractById(String id){
		return (ZxChangeContract)this.get("getZxChangeContractById", id);
	}
	/**
	* 添加
	* @param zx_change_contract 
	* @return
	*/
	public int addZxChangeContract(ZxChangeContract zxChangeContract){
		return this.add("addZxChangeContract", zxChangeContract);
	}
	/**
	* 修改
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContract(ZxChangeContract zxChangeContract){
		return this.update("updateZxChangeContract", zxChangeContract);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContractBySelective(ZxChangeContract zxChangeContract){
		return this.update("updateZxChangeContractBySelective", zxChangeContract);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxChangeContract(Map<String,Object> condition){
		return this.del("delZxChangeContract", condition);
	}
	/**
	* 批量添加
	* @param zx_change_contractList 
	* @return
	*/
	public int addBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList){
		return this.add("addBatchZxChangeContract", zxChangeContractList);
	}
	/**
	* 批量修改
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList){
		return this.update("updateBatchZxChangeContract", zxChangeContractList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContractBySelective(List<ZxChangeContract> zxChangeContractList){
		return this.update("updateBatchZxChangeContractBySelective", zxChangeContractList);
	}
}
