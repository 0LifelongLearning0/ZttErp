package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxBuyProgress;

/**
* 采购件进度表 
* 2017-10-28 15:56:49  陈运芝
*/
public interface ZxBuyProgressService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String,Object>> getZxBuyProgressListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyProgress getZxBuyProgressById(String id);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public Map<String,Object> getMapZxBuyProgressById(String id);
	/**
	* 添加
	* @param zx_buy_progress 
	* @return
	*/
	public int addZxBuyProgress(ZxBuyProgress zxBuyProgress);
	/**
	* 修改
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgress(ZxBuyProgress zxBuyProgress);
	/**
	* 修改（根据动态条件）
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgressBySelective(ZxBuyProgress zxBuyProgress);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyProgress(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_buy_progressList 
	* @return
	*/
	public int addBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList);
	/**
	* 批量修改
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgressBySelective(List<ZxBuyProgress> zxBuyProgressList);
}
