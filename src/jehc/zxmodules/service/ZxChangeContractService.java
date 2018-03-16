package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxChangeContract;

/**
* 变更合同 
* 2018-01-17 14:05:05  owen
*/
public interface ZxChangeContractService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxChangeContract> getZxChangeContractListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxChangeContract getZxChangeContractById(String id);
	/**
	* 添加
	* @param zx_change_contract 
	* @return
	*/
	public int addZxChangeContract(ZxChangeContract zxChangeContract);
	/**
	* 修改
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContract(ZxChangeContract zxChangeContract);
	/**
	* 修改（根据动态条件）
	* @param zx_change_contract 
	* @return
	*/
	public int updateZxChangeContractBySelective(ZxChangeContract zxChangeContract);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxChangeContract(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_change_contractList 
	* @return
	*/
	public int addBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList);
	/**
	* 批量修改
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContract(List<ZxChangeContract> zxChangeContractList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_change_contractList 
	* @return
	*/
	public int updateBatchZxChangeContractBySelective(List<ZxChangeContract> zxChangeContractList);
}
