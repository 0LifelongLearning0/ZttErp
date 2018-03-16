package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxUserAndDepartment;

/**
* 办公用品申请表 
* 2017-12-05 15:17:15  季建吉
*/
public interface ZxOfficeApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeApplyShow> getZxOfficeApplyListByCondition(Map<String,Object> condition);
	
	public List<ZxOfficeApplyShow> getZxOfficeOutListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxUserAndDepartment getUserAndDepartment(String id);
	
	/**
	* 查询部门和人员
	* @param id 
	* @return
	*/
	public ZxOfficeApplyShow getZxOfficeApplyById(String id);
	/**
	* 添加
	* @param zx_office_apply 
	* @return
	*/
	public int addZxOfficeApply(ZxOfficeApply zxOfficeApply);
	/**
	* 修改
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApply(ZxOfficeApply zxOfficeApply);
	public int updateZxOfficeOutInventory(ZxOfficeInventory zxOfficeInventory);
	
	public int updateZxOfficeOut(ZxOfficeApply zxOfficeApply);
	public int updateZxOfficeApplyProof(String id);
	/**
	* 修改（根据动态条件）
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApplyBySelective(ZxOfficeApply zxOfficeApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_office_applyList 
	* @return
	*/
	public int addBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList);
	/**
	* 批量修改
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApplyBySelective(List<ZxOfficeApply> zxOfficeApplyList);
}
