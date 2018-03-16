package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOutProgress;

/**
* 外协加工进度表 
* 2017-11-03 09:08:36  陈运芝
*/
public interface ZxOutProgressService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String,Object>> getZxOutProgressListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutProgress getZxOutProgressById(String id);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public Map<String,Object> getMapZxOutProgressById(String id);
	/**
	* 添加
	* @param zx_out_progress 
	* @return
	*/
	public int addZxOutProgress(ZxOutProgress zxOutProgress);
	/**
	* 修改
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgress(ZxOutProgress zxOutProgress);
	/**
	* 修改（根据动态条件）
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgressBySelective(ZxOutProgress zxOutProgress);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutProgress(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_out_progressList 
	* @return
	*/
	public int addBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList);
	/**
	* 批量修改
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgressBySelective(List<ZxOutProgress> zxOutProgressList);
}
