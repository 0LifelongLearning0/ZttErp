package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxPurchaseApplyDao;
import jehc.zxmodules.model.ZxPurchaseApply;

/**
* 采购申领表 
* 2018-01-15 09:50:27  季建吉
*/
@Repository("zxPurchaseApplyDao")
public class ZxPurchaseApplyDaoImpl  extends BaseDaoImpl implements ZxPurchaseApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxPurchaseApply> getZxPurchaseApplyListByCondition(Map<String,Object> condition){
		return (List<ZxPurchaseApply>)this.getList("getZxPurchaseApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param apply_id 
	* @return
	*/
	public ZxPurchaseApply getZxPurchaseApplyById(String apply_id){
		return (ZxPurchaseApply)this.get("getZxPurchaseApplyById", apply_id);
	}
	/**
	* 添加
	* @param zx_purchase_apply 
	* @return
	*/
	public int addZxPurchaseApply(ZxPurchaseApply zxPurchaseApply){
		return this.add("addZxPurchaseApply", zxPurchaseApply);
	}
	/**
	* 修改
	* @param zx_purchase_apply 
	* @return
	*/
	public int updateZxPurchaseApply(ZxPurchaseApply zxPurchaseApply){
		return this.update("updateZxPurchaseApply", zxPurchaseApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_purchase_apply 
	* @return
	*/
	public int updateZxPurchaseApplyBySelective(ZxPurchaseApply zxPurchaseApply){
		return this.update("updateZxPurchaseApplyBySelective", zxPurchaseApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPurchaseApply(Map<String,Object> condition){
		return this.del("delZxPurchaseApply", condition);
	}
	/**
	* 批量添加
	* @param zx_purchase_applyList 
	* @return
	*/
	public int addBatchZxPurchaseApply(List<ZxPurchaseApply> zxPurchaseApplyList){
		return this.add("addBatchZxPurchaseApply", zxPurchaseApplyList);
	}
	/**
	* 批量修改
	* @param zx_purchase_applyList 
	* @return
	*/
	public int updateBatchZxPurchaseApply(List<ZxPurchaseApply> zxPurchaseApplyList){
		return this.update("updateBatchZxPurchaseApply", zxPurchaseApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_purchase_applyList 
	* @return
	*/
	public int updateBatchZxPurchaseApplyBySelective(List<ZxPurchaseApply> zxPurchaseApplyList){
		return this.update("updateBatchZxPurchaseApplyBySelective", zxPurchaseApplyList);
	}
}
