package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeResultDao;
import jehc.zxmodules.model.ZxJudgeResult;

/**
* 供应商验厂结果 
* 2017-09-22 11:04:19  guqian
*/
@Repository("zxJudgeResultDao")
public class ZxJudgeResultDaoImpl  extends BaseDaoImpl implements ZxJudgeResultDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeResult> getZxJudgeResultListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeResult>)this.getList("getZxJudgeResultListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeResult getZxJudgeResultById(String id){
		return (ZxJudgeResult)this.get("getZxJudgeResultById", id);
	}
	/**
	* 添加
	* @param zx_judge_result 
	* @return
	*/
	public int addZxJudgeResult(ZxJudgeResult zxJudgeResult){
		return this.add("addZxJudgeResult", zxJudgeResult);
	}
	/**
	* 修改
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResult(ZxJudgeResult zxJudgeResult){
		return this.update("updateZxJudgeResult", zxJudgeResult);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResultBySelective(ZxJudgeResult zxJudgeResult){
		return this.update("updateZxJudgeResultBySelective", zxJudgeResult);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeResult(Map<String,Object> condition){
		return this.del("delZxJudgeResult", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_resultList 
	* @return
	*/
	public int addBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList){
		return this.add("addBatchZxJudgeResult", zxJudgeResultList);
	}
	/**
	* 批量修改
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList){
		return this.update("updateBatchZxJudgeResult", zxJudgeResultList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResultBySelective(List<ZxJudgeResult> zxJudgeResultList){
		return this.update("updateBatchZxJudgeResultBySelective", zxJudgeResultList);
	}
}
