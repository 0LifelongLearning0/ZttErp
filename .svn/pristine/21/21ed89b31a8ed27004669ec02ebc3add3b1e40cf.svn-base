package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxBuyTime;

/**
* 采购分批到货 
* 2017-11-01 11:15:47  陈运芝
*/
public interface ZxBuyTimeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyTime> getZxBuyTimeListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyTime getZxBuyTimeById(String id);
	/**
	* 添加
	* @param zx_buy_time 
	* @return
	*/
	public int addZxBuyTime(ZxBuyTime zxBuyTime);
	/**
	* 修改
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTime(ZxBuyTime zxBuyTime);
	/**
	* 修改（根据动态条件）
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTimeBySelective(ZxBuyTime zxBuyTime);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyTime(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_buy_timeList 
	* @return
	*/
	public int addBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList);
	/**
	* 批量修改
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTimeBySelective(List<ZxBuyTime> zxBuyTimeList);
	/**
	* 根据外键删除方法
	* @param buy_id
	* @return
	*/
	public int delZxBuyTimeByForeignKey(String buy_id);
}
