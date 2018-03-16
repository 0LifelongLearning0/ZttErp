package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxUserAndDepartment;

/**
* 办公用品主表 
* 2018-01-08 13:18:13  季建吉
*/
public interface ZxGoodsApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxGoodsApply> getZxGoodsApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param apply_id 
	* @return
	*/
	public ZxGoodsApply getZxGoodsApplyById(String apply_id);
	/**
	* 添加
	* @param zx_goods_apply 
	* @return
	*/
	
	public ZxUserAndDepartment getUserAndDepartment(String id);
	public int addZxGoodsApply(ZxGoodsApply zxGoodsApply);
	/**
	* 修改
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApply(ZxGoodsApply zxGoodsApply);
	/**
	* 修改（根据动态条件）
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApplyBySelective(ZxGoodsApply zxGoodsApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxGoodsApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_goods_applyList 
	* @return
	*/
	public int addBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList);
	/**
	* 批量修改
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApplyBySelective(List<ZxGoodsApply> zxGoodsApplyList);
}
