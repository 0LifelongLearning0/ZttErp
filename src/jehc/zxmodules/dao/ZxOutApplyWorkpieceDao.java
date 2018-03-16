package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOutApplyWorkpiece;

/**
* 外协申请工件详情单 
* 2017-11-01 16:34:19  陈运芝
*/
public interface ZxOutApplyWorkpieceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutApplyWorkpiece> getZxOutApplyWorkpieceListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutApplyWorkpiece getZxOutApplyWorkpieceById(String id);
	/**
	* 添加
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int addZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece);
	/**
	* 修改
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece);
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpieceBySelective(ZxOutApplyWorkpiece zxOutApplyWorkpiece);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutApplyWorkpiece(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int addBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList);
	/**
	* 批量修改
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpieceBySelective(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList);
}
