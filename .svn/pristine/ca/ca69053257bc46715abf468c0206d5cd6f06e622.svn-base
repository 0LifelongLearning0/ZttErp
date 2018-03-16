package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxCarApplyDao;
import jehc.zxmodules.model.ZxCarApply;

/**
* 车辆审批表 
* 2017-09-21 13:46:34  陈运芝
*/
@Repository("zxCarApplyDao")
public class ZxCarApplyDaoImpl  extends BaseDaoImpl implements ZxCarApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxCarApply> getZxCarApplyListByCondition(Map<String,Object> condition){
		return (List<ZxCarApply>)this.getList("getZxCarApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxCarApply getZxCarApplyById(String id){
		return (ZxCarApply)this.get("getZxCarApplyById", id);
	}
	/**
	* 添加
	* @param zx_car_apply 
	* @return
	*/
	public int addZxCarApply(ZxCarApply zxCarApply){
		return this.add("addZxCarApply", zxCarApply);
	}
	/**
	* 修改
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApply(ZxCarApply zxCarApply){
		return this.update("updateZxCarApply", zxCarApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApplyBySelective(ZxCarApply zxCarApply){
		return this.update("updateZxCarApplyBySelective", zxCarApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxCarApply(Map<String,Object> condition){
		return this.del("delZxCarApply", condition);
	}
	/**
	* 批量添加
	* @param zx_car_applyList 
	* @return
	*/
	public int addBatchZxCarApply(List<ZxCarApply> zxCarApplyList){
		return this.add("addBatchZxCarApply", zxCarApplyList);
	}
	/**
	* 批量修改
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApply(List<ZxCarApply> zxCarApplyList){
		return this.update("updateBatchZxCarApply", zxCarApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApplyBySelective(List<ZxCarApply> zxCarApplyList){
		return this.update("updateBatchZxCarApplyBySelective", zxCarApplyList);
	}
}
