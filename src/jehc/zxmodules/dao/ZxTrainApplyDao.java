package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxTrainApply;

/**
* 员工培训申请表 
* 2017-12-15 09:26:46  季建吉
*/
public interface ZxTrainApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxTrainApply> getZxTrainApplyListByCondition(Map<String,Object> condition);
	
	public List<ZxTrainApply> getZxTrainApproveListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxTrainApply getZxTrainApplyById(String id);
	/**
	* 添加
	* @param zx_train_apply 
	* @return
	*/
	public int addZxTrainApply(ZxTrainApply zxTrainApply);
	/**
	* 修改
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApply(ZxTrainApply zxTrainApply);
	public int updateZxTrainApplyApply(ZxTrainApply zxTrainApply);
	public int updateapproveZxTrainApprove(ZxTrainApply zxTrainApply);
	/**
	* 修改（根据动态条件）
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApplyBySelective(ZxTrainApply zxTrainApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxTrainApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_train_applyList 
	* @return
	*/
	public int addBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList);
	/**
	* 批量修改
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApplyBySelective(List<ZxTrainApply> zxTrainApplyList);
}
