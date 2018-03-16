package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOfficeApplyDao;
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxUserAndDepartment;

/**
* 办公用品申请表 
* 2017-12-05 15:17:15  季建吉
*/
@Repository("zxOfficeApplyDao")
public class ZxOfficeApplyDaoImpl  extends BaseDaoImpl implements ZxOfficeApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOfficeApplyShow> getZxOfficeApplyListByCondition(Map<String,Object> condition){
		return (List<ZxOfficeApplyShow>)this.getList("getZxOfficeApplyListByCondition",condition);
	}
	
	/**
	* 发放分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOfficeApplyShow> getZxOfficeOutListByCondition(Map<String,Object> condition){
		return (List<ZxOfficeApplyShow>)this.getList("getZxOfficeOutListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOfficeApplyShow getZxOfficeApplyById(String id){
		return (ZxOfficeApplyShow)this.get("getZxOfficeApplyById", id);
	}
	
	public ZxUserAndDepartment getUserAndDepartment(String id){
		return (ZxUserAndDepartment)this.get("getUserAndDepartment", id);
	}
	/**
	* 添加
	* @param zx_office_apply 
	* @return
	*/
	public int addZxOfficeApply(ZxOfficeApply zxOfficeApply){
		return this.add("addZxOfficeApply", zxOfficeApply);
	}
	/**
	* 修改申领表状态
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApply(ZxOfficeApply zxOfficeApply){
		return this.update("updateZxOfficeApplyBySelective", zxOfficeApply);
	}
	
	
	public int updateZxOfficeOutInventory(ZxOfficeInventory zxOfficeInventory){
		return this.update("updateZxOfficeOutInventory", zxOfficeInventory);
	}
	
	/**
	* 修改
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeOut(ZxOfficeApply zxOfficeApply){
		return this.update("updateZxOfficeOut", zxOfficeApply);
	}
	
	/**
	* 修改
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApplyProof(String id){
		return this.update("updateZxOfficeApplyProof", id);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApplyBySelective(ZxOfficeApply zxOfficeApply){
		return this.update("updateZxOfficeApplyBySelective", zxOfficeApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeApply(Map<String,Object> condition){
		return this.del("delZxOfficeApply", condition);
	}
	/**
	* 批量添加
	* @param zx_office_applyList 
	* @return
	*/
	public int addBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList){
		return this.add("addBatchZxOfficeApply", zxOfficeApplyList);
	}
	/**
	* 批量修改
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList){
		return this.update("updateBatchZxOfficeApply", zxOfficeApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApplyBySelective(List<ZxOfficeApply> zxOfficeApplyList){
		return this.update("updateBatchZxOfficeApplyBySelective", zxOfficeApplyList);
	}
}
