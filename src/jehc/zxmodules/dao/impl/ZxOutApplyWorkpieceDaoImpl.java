package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutApplyWorkpieceDao;
import jehc.zxmodules.model.ZxOutApplyWorkpiece;

/**
* 外协申请工件详情单 
* 2017-11-01 16:34:19  陈运芝
*/
@Repository("zxOutApplyWorkpieceDao")
public class ZxOutApplyWorkpieceDaoImpl  extends BaseDaoImpl implements ZxOutApplyWorkpieceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOutApplyWorkpiece> getZxOutApplyWorkpieceListByCondition(Map<String,Object> condition){
		return (List<ZxOutApplyWorkpiece>)this.getList("getZxOutApplyWorkpieceListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutApplyWorkpiece getZxOutApplyWorkpieceById(String id){
		return (ZxOutApplyWorkpiece)this.get("getZxOutApplyWorkpieceById", id);
	}
	/**
	* 添加
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int addZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		return this.add("addZxOutApplyWorkpiece", zxOutApplyWorkpiece);
	}
	/**
	* 修改
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		return this.update("updateZxOutApplyWorkpiece", zxOutApplyWorkpiece);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpieceBySelective(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		return this.update("updateZxOutApplyWorkpieceBySelective", zxOutApplyWorkpiece);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutApplyWorkpiece(Map<String,Object> condition){
		return this.del("delZxOutApplyWorkpiece", condition);
	}
	/**
	* 批量添加
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int addBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		return this.add("addBatchZxOutApplyWorkpiece", zxOutApplyWorkpieceList);
	}
	/**
	* 批量修改
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		return this.update("updateBatchZxOutApplyWorkpiece", zxOutApplyWorkpieceList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpieceBySelective(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		return this.update("updateBatchZxOutApplyWorkpieceBySelective", zxOutApplyWorkpieceList);
	}
}
