package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxBuyApply;

/**
* 采购申请单 
* 2017-10-26 10:41:49  陈运芝
*/
public interface ZxBuyApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyApply> getZxBuyApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyApply getZxBuyApplyById(String id);
	/**
	* 添加
	* @param zx_buy_apply 
	* @return
	*/
	public int addZxBuyApply(ZxBuyApply zxBuyApply);
	/**
	* 修改
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApply(ZxBuyApply zxBuyApply);
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApplyBySelective(ZxBuyApply zxBuyApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_buy_applyList 
	* @return
	*/
	public int addBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList);
	/**
	* 批量修改
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApplyBySelective(List<ZxBuyApply> zxBuyApplyList);
}
