package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOrderOutWorkpiece;

/**
* 外协订单工件表 
* 2017-11-03 16:58:45  陈运芝
*/
public interface ZxOrderOutWorkpieceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderOutWorkpiece> getZxOrderOutWorkpieceListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderOutWorkpiece getZxOrderOutWorkpieceById(String id);
	/**
	* 添加
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int addZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece);
	/**
	* 修改
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece);
	/**
	* 修改（根据动态条件）
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpieceBySelective(ZxOrderOutWorkpiece zxOrderOutWorkpiece);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderOutWorkpiece(Map<String,Object> condition);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOW(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int addBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList);
	/**
	* 批量修改
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpieceBySelective(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList);
}
