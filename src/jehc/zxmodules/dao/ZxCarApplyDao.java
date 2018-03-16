package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxCarApply;

/**
* 车辆审批表 
* 2017-09-21 13:46:34  陈运芝
*/
public interface ZxCarApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxCarApply> getZxCarApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxCarApply getZxCarApplyById(String id);
	/**
	* 添加
	* @param zx_car_apply 
	* @return
	*/
	public int addZxCarApply(ZxCarApply zxCarApply);
	/**
	* 修改
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApply(ZxCarApply zxCarApply);
	/**
	* 修改（根据动态条件）
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApplyBySelective(ZxCarApply zxCarApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxCarApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_car_applyList 
	* @return
	*/
	public int addBatchZxCarApply(List<ZxCarApply> zxCarApplyList);
	/**
	* 批量修改
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApply(List<ZxCarApply> zxCarApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApplyBySelective(List<ZxCarApply> zxCarApplyList);
}
