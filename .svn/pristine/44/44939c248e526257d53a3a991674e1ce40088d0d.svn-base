package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxGoodsApplyDetail;

/**
* 用品申领详细表 
* 2018-01-08 13:18:13  季建吉
*/
public interface ZxGoodsApplyDetailService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxGoodsApplyDetail> getZxGoodsApplyDetailListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxGoodsApplyDetail getZxGoodsApplyDetailById(String id);
	/**
	* 添加
	* @param zx_goods_apply_detail 
	* @return
	*/
	public int addZxGoodsApplyDetail(ZxGoodsApplyDetail zxGoodsApplyDetail);
	/**
	* 修改
	* @param zx_goods_apply_detail 
	* @return
	*/
	public int updateZxGoodsApplyDetail(ZxGoodsApplyDetail zxGoodsApplyDetail);
	public int delZxGoodsApplyDetailById(Map<String,Object> condition);
	/**
	* 修改（根据动态条件）
	* @param zx_goods_apply_detail 
	* @return
	*/
	public int updateZxGoodsApplyDetailBySelective(ZxGoodsApplyDetail zxGoodsApplyDetail);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxGoodsApplyDetail(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_goods_apply_detailList 
	* @return
	*/
	public int addBatchZxGoodsApplyDetail(List<ZxGoodsApplyDetail> zxGoodsApplyDetailList);
	/**
	* 批量修改
	* @param zx_goods_apply_detailList 
	* @return
	*/
	public int updateBatchZxGoodsApplyDetail(List<ZxGoodsApplyDetail> zxGoodsApplyDetailList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_goods_apply_detailList 
	* @return
	*/
	public int updateBatchZxGoodsApplyDetailBySelective(List<ZxGoodsApplyDetail> zxGoodsApplyDetailList);
	/**
	* 根据外键删除
	* @param apply_id
	* @return
	*/
	public int delZxGoodsApplyDetailByForeignKey(String apply_id);
}
