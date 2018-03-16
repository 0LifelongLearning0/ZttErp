package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxReservedFunds;

/**
* 公积金台账 
* 2018-01-18 08:15:15  owen
*/
public interface ZxReservedFundsService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxReservedFunds> getZxReservedFundsListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxReservedFunds getZxReservedFundsById(String id);
	/**
	* 添加
	* @param zx_reserved_funds 
	* @return
	*/
	public int addZxReservedFunds(ZxReservedFunds zxReservedFunds);
	/**
	* 修改
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFunds(ZxReservedFunds zxReservedFunds);
	/**
	* 修改（根据动态条件）
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFundsBySelective(ZxReservedFunds zxReservedFunds);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxReservedFunds(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int addBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList);
	/**
	* 批量修改
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFundsBySelective(List<ZxReservedFunds> zxReservedFundsList);
}
