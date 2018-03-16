package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOrderOut;

/**
* 外协订单表 
* 2017-11-03 16:56:45  c
*/
public interface ZxOrderOutDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderOut> getZxOrderOutListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderOut getZxOrderOutById(String id);
	/**
	* 添加
	* @param zx_order_out 
	* @return
	*/
	public int addZxOrderOut(ZxOrderOut zxOrderOut);
	/**
	* 修改
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOut(ZxOrderOut zxOrderOut);
	/**
	* 修改（根据动态条件）
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOutBySelective(ZxOrderOut zxOrderOut);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderOut(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_order_outList 
	* @return
	*/
	public int addBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList);
	/**
	* 批量修改
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOutBySelective(List<ZxOrderOut> zxOrderOutList);
	/**
	* 获取订单下工件分页
	* @param condition 
	* @return
	*/
	public List<Map<String, Object>> getZxOWListByCondition(Map<String,Object> condition);
}
