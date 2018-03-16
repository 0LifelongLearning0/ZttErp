package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxWorkpieceDao;
import jehc.zxmodules.model.ZxWorkpiece;

/**
* 工件管理 
* 2017-08-31 12:54:14  陈运芝
*/
@Repository("zxWorkpieceDao")
public class ZxWorkpieceDaoImpl  extends BaseDaoImpl implements ZxWorkpieceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxWorkpiece> getZxWorkpieceListByCondition(Map<String,Object> condition){
		return (List<ZxWorkpiece>)this.getList("getZxWorkpieceListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxWorkpiece getZxWorkpieceById(String id){
		return (ZxWorkpiece)this.get("getZxWorkpieceById", id);
	}
	/**
	* 添加
	* @param zx_workpiece 
	* @return
	*/
	public int addZxWorkpiece(ZxWorkpiece zxWorkpiece){
		return this.add("addZxWorkpiece", zxWorkpiece);
	}
	/**
	* 修改
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpiece(ZxWorkpiece zxWorkpiece){
		return this.update("updateZxWorkpiece", zxWorkpiece);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpieceBySelective(ZxWorkpiece zxWorkpiece){
		return this.update("updateZxWorkpieceBySelective", zxWorkpiece);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxWorkpiece(Map<String,Object> condition){
		return this.del("delZxWorkpiece", condition);
	}
	/**
	* 批量添加
	* @param zx_workpieceList 
	* @return
	*/
	public int addBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList){
		return this.add("addBatchZxWorkpiece", zxWorkpieceList);
	}
	/**
	* 批量修改
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList){
		return this.update("updateBatchZxWorkpiece", zxWorkpieceList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpieceBySelective(List<ZxWorkpiece> zxWorkpieceList){
		return this.update("updateBatchZxWorkpieceBySelective", zxWorkpieceList);
	}
}
