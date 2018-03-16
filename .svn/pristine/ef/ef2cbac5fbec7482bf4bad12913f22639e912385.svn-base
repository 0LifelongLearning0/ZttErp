package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxBuyApplyDao;
import jehc.zxmodules.model.ZxBuyApply;

/**
* 采购申请单 
* 2017-10-26 10:41:49  陈运芝
*/
@Repository("zxBuyApplyDao")
public class ZxBuyApplyDaoImpl  extends BaseDaoImpl implements ZxBuyApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxBuyApply> getZxBuyApplyListByCondition(Map<String,Object> condition){
		return (List<ZxBuyApply>)this.getList("getZxBuyApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyApply getZxBuyApplyById(String id){
		return (ZxBuyApply)this.get("getZxBuyApplyById", id);
	}
	/**
	* 添加
	* @param zx_buy_apply 
	* @return
	*/
	public int addZxBuyApply(ZxBuyApply zxBuyApply){
		return this.add("addZxBuyApply", zxBuyApply);
	}
	/**
	* 修改
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApply(ZxBuyApply zxBuyApply){
		return this.update("updateZxBuyApply", zxBuyApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApplyBySelective(ZxBuyApply zxBuyApply){
		return this.update("updateZxBuyApplyBySelective", zxBuyApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyApply(Map<String,Object> condition){
		return this.del("delZxBuyApply", condition);
	}
	/**
	* 批量添加
	* @param zx_buy_applyList 
	* @return
	*/
	public int addBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList){
		return this.add("addBatchZxBuyApply", zxBuyApplyList);
	}
	/**
	* 批量修改
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList){
		return this.update("updateBatchZxBuyApply", zxBuyApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApplyBySelective(List<ZxBuyApply> zxBuyApplyList){
		return this.update("updateBatchZxBuyApplyBySelective", zxBuyApplyList);
	}
}
