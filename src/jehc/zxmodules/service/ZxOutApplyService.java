package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOutApply;

/**
* 外协加工申请表 
* 2017-11-01 16:31:32  陈运芝
*/
public interface ZxOutApplyService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutApply> getZxOutApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutApply getZxOutApplyById(String id);
	/**
	* 添加
	* @param zx_out_apply 
	* @return
	*/
	public int addZxOutApply(ZxOutApply zxOutApply);
	/**
	* 修改
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApply(ZxOutApply zxOutApply);
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApplyBySelective(ZxOutApply zxOutApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_out_applyList 
	* @return
	*/
	public int addBatchZxOutApply(List<ZxOutApply> zxOutApplyList);
	/**
	* 批量修改
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApply(List<ZxOutApply> zxOutApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApplyBySelective(List<ZxOutApply> zxOutApplyList);
}
