package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxGoodsApplyDao;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxUserAndDepartment;

/**
* 办公用品主表 
* 2018-01-08 13:18:13  季建吉
*/
@Repository("zxGoodsApplyDao")
public class ZxGoodsApplyDaoImpl  extends BaseDaoImpl implements ZxGoodsApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxGoodsApply> getZxGoodsApplyListByCondition(Map<String,Object> condition){
		return (List<ZxGoodsApply>)this.getList("getZxGoodsApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param apply_id 
	* @return
	*/
	public ZxGoodsApply getZxGoodsApplyById(String apply_id){
		return (ZxGoodsApply)this.get("getZxGoodsApplyById", apply_id);
	}
	
	public ZxUserAndDepartment getUserAndDepartment(String id){
		return (ZxUserAndDepartment)this.get("getUserAndDepartment", id);
	}
	/**
	* 添加
	* @param zx_goods_apply 
	* @return
	*/
	public int addZxGoodsApply(ZxGoodsApply zxGoodsApply){
		return this.add("addZxGoodsApply", zxGoodsApply);
	}
	/**
	* 修改
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApply(ZxGoodsApply zxGoodsApply){
		return this.update("updateZxGoodsApply", zxGoodsApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApplyBySelective(ZxGoodsApply zxGoodsApply){
		return this.update("updateZxGoodsApplyBySelective", zxGoodsApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxGoodsApply(Map<String,Object> condition){
		return this.del("delZxGoodsApply", condition);
	}
	/**
	* 批量添加
	* @param zx_goods_applyList 
	* @return
	*/
	public int addBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList){
		return this.add("addBatchZxGoodsApply", zxGoodsApplyList);
	}
	/**
	* 批量修改
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList){
		return this.update("updateBatchZxGoodsApply", zxGoodsApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApplyBySelective(List<ZxGoodsApply> zxGoodsApplyList){
		return this.update("updateBatchZxGoodsApplyBySelective", zxGoodsApplyList);
	}
}
