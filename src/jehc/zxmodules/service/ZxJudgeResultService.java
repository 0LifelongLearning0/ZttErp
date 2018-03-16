package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxJudgeResult;

/**
* 供应商验厂结果 
* 2017-09-22 11:04:19  guqian
*/
public interface ZxJudgeResultService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeResult> getZxJudgeResultListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeResult getZxJudgeResultById(String id);
	/**
	* 添加
	* @param zx_judge_result 
	* @return
	*/
	public int addZxJudgeResult(ZxJudgeResult zxJudgeResult);
	/**
	* 修改
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResult(ZxJudgeResult zxJudgeResult);
	/**
	* 修改（根据动态条件）
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResultBySelective(ZxJudgeResult zxJudgeResult);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeResult(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_judge_resultList 
	* @return
	*/
	public int addBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList);
	/**
	* 批量修改
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResultBySelective(List<ZxJudgeResult> zxJudgeResultList);
}
