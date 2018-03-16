package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeApplyDao;
import jehc.zxmodules.model.ZxJudgeApply;

/**
* 供应商验厂申请单 
* 2017-09-25 09:27:09  g
*/
@Repository("zxJudgeApplyDao")
public class ZxJudgeApplyDaoImpl  extends BaseDaoImpl implements ZxJudgeApplyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeApply> getZxJudgeApplyListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeApply>)this.getList("getZxJudgeApplyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeApply getZxJudgeApplyById(String id){
		return (ZxJudgeApply)this.get("getZxJudgeApplyById", id);
	}
	/**
	* 添加
	* @param zx_judge_apply 
	* @return
	*/
	public int addZxJudgeApply(ZxJudgeApply zxJudgeApply){
		return this.add("addZxJudgeApply", zxJudgeApply);
	}
	/**
	* 修改
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApply(ZxJudgeApply zxJudgeApply){
		return this.update("updateZxJudgeApply", zxJudgeApply);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApplyBySelective(ZxJudgeApply zxJudgeApply){
		return this.update("updateZxJudgeApplyBySelective", zxJudgeApply);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeApply(Map<String,Object> condition){
		return this.del("delZxJudgeApply", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_applyList 
	* @return
	*/
	public int addBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList){
		return this.add("addBatchZxJudgeApply", zxJudgeApplyList);
	}
	/**
	* 批量修改
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList){
		return this.update("updateBatchZxJudgeApply", zxJudgeApplyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApplyBySelective(List<ZxJudgeApply> zxJudgeApplyList){
		return this.update("updateBatchZxJudgeApplyBySelective", zxJudgeApplyList);
	}
}
