package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderbybuy;

/**
* 外协单表 
* 2018-03-21 10:45:03  季建吉
*/
public interface ZttOrderbybuyService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrderbybuy> getZttOrderbybuyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrderbybuy getZttOrderbybuyById(String id);
	
	/**
	* 添加
	* @param ztt_orderbybuy 
	* @return
	*/
	public int addZttOrderbybuy(ZttOrderbybuy zttOrderbybuy);
	/**
	* 修改
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuy(ZttOrderbybuy zttOrderbybuy);
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuyBySelective(ZttOrderbybuy zttOrderbybuy);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrderbybuy(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int addBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList);
	/**
	* 批量修改
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuyBySelective(List<ZttOrderbybuy> zttOrderbybuyList);
}
