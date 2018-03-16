package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutApplyDao;
import jehc.zxmodules.model.ZxOutApply;

/**
* 外协加工申请表 
* 2017-11-01 16:31:32  陈运芝
*/
@Repository("zxOutApplyDao")
public class ZxOutApplyDaoImpl  extends BaseDaoImpl implements ZxOutApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOutApply> getZxOutApplyListByCondition(Map<String,Object> condition){
		return (List<ZxOutApply>)this.getList("getZxOutApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutApply getZxOutApplyById(String id){
		return (ZxOutApply)this.get("getZxOutApplyById", id);
	}
	/**
	* 添加
	* @param zx_out_apply 
	* @return
	*/
	public int addZxOutApply(ZxOutApply zxOutApply){
		return this.add("addZxOutApply", zxOutApply);
	}
	/**
	* 修改
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApply(ZxOutApply zxOutApply){
		return this.update("updateZxOutApply", zxOutApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApplyBySelective(ZxOutApply zxOutApply){
		return this.update("updateZxOutApplyBySelective", zxOutApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutApply(Map<String,Object> condition){
		return this.del("delZxOutApply", condition);
	}
	/**
	* 批量添加
	* @param zx_out_applyList 
	* @return
	*/
	public int addBatchZxOutApply(List<ZxOutApply> zxOutApplyList){
		return this.add("addBatchZxOutApply", zxOutApplyList);
	}
	/**
	* 批量修改
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApply(List<ZxOutApply> zxOutApplyList){
		return this.update("updateBatchZxOutApply", zxOutApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApplyBySelective(List<ZxOutApply> zxOutApplyList){
		return this.update("updateBatchZxOutApplyBySelective", zxOutApplyList);
	}
}
