package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxBuyProgressDao;
import jehc.zxmodules.model.ZxBuyProgress;

/**
* 采购件进度表 
* 2017-10-28 15:56:49  陈运芝
*/
@Repository("zxBuyProgressDao")
public class ZxBuyProgressDaoImpl  extends BaseDaoImpl implements ZxBuyProgressDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getZxBuyProgressListByCondition(Map<String,Object> condition){
		return (List<Map<String,Object>>)this.getList("getZxBuyProgressListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyProgress getZxBuyProgressById(String id){
		return (ZxBuyProgress)this.get("getZxBuyProgressById", id);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public Map<String,Object> getMapZxBuyProgressById(String id){
		return (Map<String,Object>)this.get("getMapZxBuyProgressById", id);
	}
	/**
	* 添加
	* @param zx_buy_progress 
	* @return
	*/
	public int addZxBuyProgress(ZxBuyProgress zxBuyProgress){
		return this.add("addZxBuyProgress", zxBuyProgress);
	}
	/**
	* 修改
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgress(ZxBuyProgress zxBuyProgress){
		return this.update("updateZxBuyProgress", zxBuyProgress);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgressBySelective(ZxBuyProgress zxBuyProgress){
		return this.update("updateZxBuyProgressBySelective", zxBuyProgress);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyProgress(Map<String,Object> condition){
		return this.del("delZxBuyProgress", condition);
	}
	/**
	* 批量添加
	* @param zx_buy_progressList 
	* @return
	*/
	public int addBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList){
		return this.add("addBatchZxBuyProgress", zxBuyProgressList);
	}
	/**
	* 批量修改
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList){
		return this.update("updateBatchZxBuyProgress", zxBuyProgressList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgressBySelective(List<ZxBuyProgress> zxBuyProgressList){
		return this.update("updateBatchZxBuyProgressBySelective", zxBuyProgressList);
	}
}
