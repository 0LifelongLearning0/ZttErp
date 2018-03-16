package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxPurchaseApply;

/**
* 采购申领表 
* 2018-01-15 09:50:27  季建吉
*/
public interface ZxPurchaseApplyService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxPurchaseApply> getZxPurchaseApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param apply_id 
	* @return
	*/
	public ZxPurchaseApply getZxPurchaseApplyById(String apply_id);
	/**
	* 添加
	* @param zx_purchase_apply 
	* @return
	*/
	public int addZxPurchaseApply(ZxPurchaseApply zxPurchaseApply);
	/**
	* 修改
	* @param zx_purchase_apply 
	* @return
	*/
	public int updateZxPurchaseApply(ZxPurchaseApply zxPurchaseApply);
	/**
	* 修改（根据动态条件）
	* @param zx_purchase_apply 
	* @return
	*/
	public int updateZxPurchaseApplyBySelectiveByCondition(ZxPurchaseApply zxPurchaseApply);
	public int updateZxPurchaseApplyCheck(ZxPurchaseApply zxPurchaseApply);
	/**
	* 修改（根据动态条件）
	* @param zx_purchase_apply 
	* @return
	*/
	public int updateZxPurchaseApplyBySelective(ZxPurchaseApply zxPurchaseApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPurchaseApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_purchase_applyList 
	* @return
	*/
	public int addBatchZxPurchaseApply(List<ZxPurchaseApply> zxPurchaseApplyList);
	/**
	* 批量修改
	* @param zx_purchase_applyList 
	* @return
	*/
	public int updateBatchZxPurchaseApply(List<ZxPurchaseApply> zxPurchaseApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_purchase_applyList 
	* @return
	*/
	public int updateBatchZxPurchaseApplyBySelective(List<ZxPurchaseApply> zxPurchaseApplyList);
}
