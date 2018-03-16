package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxPurchaseApplyDetail;

/**
* 行政采购申领详情表 
* 2018-01-15 09:50:27  季建吉
*/
public interface ZxPurchaseApplyDetailDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxPurchaseApplyDetail> getZxPurchaseApplyDetailListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxPurchaseApplyDetail getZxPurchaseApplyDetailById(String id);
	
	/**
	* 添加
	* @param zx_purchase_apply_detail 
	* @return
	*/
	public int addZxPurchaseApplyDetail(ZxPurchaseApplyDetail zxPurchaseApplyDetail);
	public int updateBatchZxPurchaseApplystore(List<ZxPurchaseApplyDetail> zxPurchaseApplyDetailList);
	/**
	* 修改
	* @param zx_purchase_apply_detail 
	* @return
	*/
	public int updateZxPurchaseApplyDetail(ZxPurchaseApplyDetail zxPurchaseApplyDetail);
	/**
	* 修改（根据动态条件）
	* @param zx_purchase_apply_detail 
	* @return
	*/
	public int updateZxPurchaseApplyDetailBySelective(ZxPurchaseApplyDetail zxPurchaseApplyDetail);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxPurchaseApplyDetail(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_purchase_apply_detailList 
	* @return
	*/
	public int addBatchZxPurchaseApplyDetail(List<ZxPurchaseApplyDetail> zxPurchaseApplyDetailList);
	/**
	* 批量修改
	* @param zx_purchase_apply_detailList 
	* @return
	*/
	public int updateBatchZxPurchaseApplyDetail(List<ZxPurchaseApplyDetail> zxPurchaseApplyDetailList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_purchase_apply_detailList 
	* @return
	*/
	public int updateBatchZxPurchaseApplyDetailBySelective(List<ZxPurchaseApplyDetail> zxPurchaseApplyDetailList);
	/**
	* 根据外键删除方法
	* @param apply_id
	* @return
	*/
	public int delZxPurchaseApplyDetailByForeignKey(String apply_id);
}
