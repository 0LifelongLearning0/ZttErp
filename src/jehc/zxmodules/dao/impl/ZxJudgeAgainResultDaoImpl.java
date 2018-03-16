package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeAgainResultDao;
import jehc.zxmodules.model.ZxJudgeAgainResult;

/**
* 供应商再评审结果 
* 2017-09-26 17:22:17  a
*/
@Repository("zxJudgeAgainResultDao")
public class ZxJudgeAgainResultDaoImpl  extends BaseDaoImpl implements ZxJudgeAgainResultDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeAgainResult> getZxJudgeAgainResultListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeAgainResult>)this.getList("getZxJudgeAgainResultListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeAgainResult getZxJudgeAgainResultById(String id){
		return (ZxJudgeAgainResult)this.get("getZxJudgeAgainResultById", id);
	}
	/**
	* 添加
	* @param zx_judge_again_result 
	* @return
	*/
	public int addZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult){
		return this.add("addZxJudgeAgainResult", zxJudgeAgainResult);
	}
	/**
	* 修改
	* @param zx_judge_again_result 
	* @return
	*/
	public int updateZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult){
		return this.update("updateZxJudgeAgainResult", zxJudgeAgainResult);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_again_result 
	* @return
	*/
	public int updateZxJudgeAgainResultBySelective(ZxJudgeAgainResult zxJudgeAgainResult){
		return this.update("updateZxJudgeAgainResultBySelective", zxJudgeAgainResult);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeAgainResult(Map<String,Object> condition){
		return this.del("delZxJudgeAgainResult", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int addBatchZxJudgeAgainResult(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		return this.add("addBatchZxJudgeAgainResult", zxJudgeAgainResultList);
	}
	/**
	* 批量修改
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int updateBatchZxJudgeAgainResult(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		return this.update("updateBatchZxJudgeAgainResult", zxJudgeAgainResultList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int updateBatchZxJudgeAgainResultBySelective(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		return this.update("updateBatchZxJudgeAgainResultBySelective", zxJudgeAgainResultList);
	}
}
