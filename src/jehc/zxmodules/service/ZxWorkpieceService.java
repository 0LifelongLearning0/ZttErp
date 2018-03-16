package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxWorkpiece;

/**
* 工件管理 
* 2017-08-31 12:54:14  陈运芝
*/
public interface ZxWorkpieceService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxWorkpiece> getZxWorkpieceListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxWorkpiece getZxWorkpieceById(String id);
	/**
	* 添加
	* @param zx_workpiece 
	* @return
	*/
	public int addZxWorkpiece(ZxWorkpiece zxWorkpiece);
	/**
	* 修改
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpiece(ZxWorkpiece zxWorkpiece);
	/**
	* 修改（根据动态条件）
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpieceBySelective(ZxWorkpiece zxWorkpiece);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxWorkpiece(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_workpieceList 
	* @return
	*/
	public int addBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList);
	/**
	* 批量修改
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpieceBySelective(List<ZxWorkpiece> zxWorkpieceList);
}
