package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOrderOutDao;
import jehc.zxmodules.model.ZxOrderOut;

/**
* 外协订单表 
* 2017-11-03 16:56:45  c
*/
@Repository("zxOrderOutDao")
public class ZxOrderOutDaoImpl  extends BaseDaoImpl implements ZxOrderOutDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOrderOut> getZxOrderOutListByCondition(Map<String,Object> condition){
		return (List<ZxOrderOut>)this.getList("getZxOrderOutListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderOut getZxOrderOutById(String id){
		return (ZxOrderOut)this.get("getZxOrderOutById", id);
	}
	/**
	* 添加
	* @param zx_order_out 
	* @return
	*/
	public int addZxOrderOut(ZxOrderOut zxOrderOut){
		return this.add("addZxOrderOut", zxOrderOut);
	}
	/**
	* 修改
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOut(ZxOrderOut zxOrderOut){
		return this.update("updateZxOrderOut", zxOrderOut);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOutBySelective(ZxOrderOut zxOrderOut){
		return this.update("updateZxOrderOutBySelective", zxOrderOut);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderOut(Map<String,Object> condition){
		return this.del("delZxOrderOut", condition);
	}
	/**
	* 批量添加
	* @param zx_order_outList 
	* @return
	*/
	public int addBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList){
		return this.add("addBatchZxOrderOut", zxOrderOutList);
	}
	/**
	* 批量修改
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList){
		return this.update("updateBatchZxOrderOut", zxOrderOutList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOutBySelective(List<ZxOrderOut> zxOrderOutList){
		return this.update("updateBatchZxOrderOutBySelective", zxOrderOutList);
	}
	/**
	* 获取订单下工件分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getZxOWListByCondition(Map<String,Object> condition){
		return (List<Map<String, Object>>)this.getList("getZxOWListByCondition",condition);
	}
}
