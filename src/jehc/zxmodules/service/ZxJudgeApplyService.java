package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxJudgeApply;

/**
* 供应商验厂申请单 
* 2017-09-25 09:27:09  g
*/
public interface ZxJudgeApplyService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeApply> getZxJudgeApplyListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeApply getZxJudgeApplyById(String id);
	/**
	* 添加
	* @param zx_judge_apply 
	* @return
	*/
	public int addZxJudgeApply(ZxJudgeApply zxJudgeApply);
	/**
	* 修改
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApply(ZxJudgeApply zxJudgeApply);
	/**
	* 修改（根据动态条件）
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApplyBySelective(ZxJudgeApply zxJudgeApply);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeApply(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_judge_applyList 
	* @return
	*/
	public int addBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList);
	/**
	* 批量修改
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApplyBySelective(List<ZxJudgeApply> zxJudgeApplyList);
}
