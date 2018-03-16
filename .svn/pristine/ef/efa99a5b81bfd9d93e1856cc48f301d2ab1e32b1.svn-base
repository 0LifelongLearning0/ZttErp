package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOrderOutWorkpieceDao;
import jehc.zxmodules.model.ZxOrderOutWorkpiece;

/**
* 外协订单工件表 
* 2017-11-03 16:58:45  陈运芝
*/
@Repository("zxOrderOutWorkpieceDao")
public class ZxOrderOutWorkpieceDaoImpl  extends BaseDaoImpl implements ZxOrderOutWorkpieceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOrderOutWorkpiece> getZxOrderOutWorkpieceListByCondition(Map<String,Object> condition){
		return (List<ZxOrderOutWorkpiece>)this.getList("getZxOrderOutWorkpieceListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderOutWorkpiece getZxOrderOutWorkpieceById(String id){
		return (ZxOrderOutWorkpiece)this.get("getZxOrderOutWorkpieceById", id);
	}
	/**
	* 添加
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int addZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		return this.add("addZxOrderOutWorkpiece", zxOrderOutWorkpiece);
	}
	/**
	* 修改
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		return this.update("updateZxOrderOutWorkpiece", zxOrderOutWorkpiece);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpieceBySelective(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		return this.update("updateZxOrderOutWorkpieceBySelective", zxOrderOutWorkpiece);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderOutWorkpiece(Map<String,Object> condition){
		return this.del("delZxOrderOutWorkpiece", condition);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOW(Map<String,Object> condition){
		return this.del("delZxOW", condition);
	}
	/**
	* 批量添加
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int addBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		return this.add("addBatchZxOrderOutWorkpiece", zxOrderOutWorkpieceList);
	}
	/**
	* 批量修改
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		return this.update("updateBatchZxOrderOutWorkpiece", zxOrderOutWorkpieceList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpieceBySelective(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		return this.update("updateBatchZxOrderOutWorkpieceBySelective", zxOrderOutWorkpieceList);
	}
}
