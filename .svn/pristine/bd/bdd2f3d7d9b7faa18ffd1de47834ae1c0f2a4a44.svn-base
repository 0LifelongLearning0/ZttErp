package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutProgressDao;
import jehc.zxmodules.model.ZxOutProgress;

/**
* 外协加工进度表 
* 2017-11-03 09:08:36  陈运芝
*/
@Repository("zxOutProgressDao")
public class ZxOutProgressDaoImpl  extends BaseDaoImpl implements ZxOutProgressDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getZxOutProgressListByCondition(Map<String,Object> condition){
		return (List<Map<String,Object>>)this.getList("getZxOutProgressListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutProgress getZxOutProgressById(String id){
		return (ZxOutProgress)this.get("getZxOutProgressById", id);
	}

	/**
	* 查询对象
	* @param id 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public Map<String,Object> getMapZxOutProgressById(String id){
		return (Map<String,Object>)this.get("getMapZxOutProgressById", id);
	}
	/**
	* 添加
	* @param zx_out_progress 
	* @return
	*/
	public int addZxOutProgress(ZxOutProgress zxOutProgress){
		return this.add("addZxOutProgress", zxOutProgress);
	}
	/**
	* 修改
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgress(ZxOutProgress zxOutProgress){
		return this.update("updateZxOutProgress", zxOutProgress);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgressBySelective(ZxOutProgress zxOutProgress){
		return this.update("updateZxOutProgressBySelective", zxOutProgress);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutProgress(Map<String,Object> condition){
		return this.del("delZxOutProgress", condition);
	}
	/**
	* 批量添加
	* @param zx_out_progressList 
	* @return
	*/
	public int addBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList){
		return this.add("addBatchZxOutProgress", zxOutProgressList);
	}
	/**
	* 批量修改
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList){
		return this.update("updateBatchZxOutProgress", zxOutProgressList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgressBySelective(List<ZxOutProgress> zxOutProgressList){
		return this.update("updateBatchZxOutProgressBySelective", zxOutProgressList);
	}
}
