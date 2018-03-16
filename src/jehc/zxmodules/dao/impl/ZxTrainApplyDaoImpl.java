package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxTrainApplyDao;
import jehc.zxmodules.model.ZxTrainApply;

/**
* 员工培训申请表 
* 2017-12-15 09:26:46  季建吉
*/
@Repository("zxTrainApplyDao")
public class ZxTrainApplyDaoImpl  extends BaseDaoImpl implements ZxTrainApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxTrainApply> getZxTrainApplyListByCondition(Map<String,Object> condition){
		return (List<ZxTrainApply>)this.getList("getZxTrainApplyListByCondition",condition);
	}
	
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxTrainApply> getZxTrainApproveListByCondition(Map<String,Object> condition){
		return (List<ZxTrainApply>)this.getList("getZxTrainApproveListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxTrainApply getZxTrainApplyById(String id){
		return (ZxTrainApply)this.get("getZxTrainApplyById", id);
	}
	/**
	* 添加
	* @param zx_train_apply 
	* @return
	*/
	public int addZxTrainApply(ZxTrainApply zxTrainApply){
		return this.add("addZxTrainApply", zxTrainApply);
	}
	/**
	* 修改
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApply(ZxTrainApply zxTrainApply){
		return this.update("updateZxTrainApply", zxTrainApply);
	}
	/**
	* 通过申请
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApplyApply(ZxTrainApply zxTrainApply){
		return this.update("updateZxTrainApplyApply", zxTrainApply);
	}
	/**
	* 通过培训 
	* @param zx_train_apply 
	* @return
	*/
	public int updateapproveZxTrainApprove(ZxTrainApply zxTrainApply){
		return this.update("updateapproveZxTrainApprove", zxTrainApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApplyBySelective(ZxTrainApply zxTrainApply){
		return this.update("updateZxTrainApplyBySelective", zxTrainApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxTrainApply(Map<String,Object> condition){
		return this.del("delZxTrainApply", condition);
	}
	/**
	* 批量添加
	* @param zx_train_applyList 
	* @return
	*/
	public int addBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList){
		return this.add("addBatchZxTrainApply", zxTrainApplyList);
	}
	/**
	* 批量修改
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList){
		return this.update("updateBatchZxTrainApply", zxTrainApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApplyBySelective(List<ZxTrainApply> zxTrainApplyList){
		return this.update("updateBatchZxTrainApplyBySelective", zxTrainApplyList);
	}
}
