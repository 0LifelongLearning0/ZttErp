package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxReservedFundsDao;
import jehc.zxmodules.model.ZxReservedFunds;

/**
* 公积金台账 
* 2018-01-18 08:15:15  owen
*/
@Repository("zxReservedFundsDao")
public class ZxReservedFundsDaoImpl  extends BaseDaoImpl implements ZxReservedFundsDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxReservedFunds> getZxReservedFundsListByCondition(Map<String,Object> condition){
		return (List<ZxReservedFunds>)this.getList("getZxReservedFundsListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxReservedFunds getZxReservedFundsById(String id){
		return (ZxReservedFunds)this.get("getZxReservedFundsById", id);
	}
	/**
	* 添加
	* @param zx_reserved_funds 
	* @return
	*/
	public int addZxReservedFunds(ZxReservedFunds zxReservedFunds){
		return this.add("addZxReservedFunds", zxReservedFunds);
	}
	/**
	* 修改
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFunds(ZxReservedFunds zxReservedFunds){
		return this.update("updateZxReservedFunds", zxReservedFunds);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_reserved_funds 
	* @return
	*/
	public int updateZxReservedFundsBySelective(ZxReservedFunds zxReservedFunds){
		return this.update("updateZxReservedFundsBySelective", zxReservedFunds);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxReservedFunds(Map<String,Object> condition){
		return this.del("delZxReservedFunds", condition);
	}
	/**
	* 批量添加
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int addBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList){
		return this.add("addBatchZxReservedFunds", zxReservedFundsList);
	}
	/**
	* 批量修改
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFunds(List<ZxReservedFunds> zxReservedFundsList){
		return this.update("updateBatchZxReservedFunds", zxReservedFundsList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_reserved_fundsList 
	* @return
	*/
	public int updateBatchZxReservedFundsBySelective(List<ZxReservedFunds> zxReservedFundsList){
		return this.update("updateBatchZxReservedFundsBySelective", zxReservedFundsList);
	}
}
