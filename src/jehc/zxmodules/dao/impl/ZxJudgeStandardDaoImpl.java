package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeStandardDao;
import jehc.zxmodules.model.ZxJudgeStandard;

/**
* 供应商评定标准 
* 2017-09-21 13:16:25  guqian
*/
@Repository("zxJudgeStandardDao")
public class ZxJudgeStandardDaoImpl  extends BaseDaoImpl implements ZxJudgeStandardDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeStandard> getZxJudgeStandardListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeStandard>)this.getList("getZxJudgeStandardListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeStandard getZxJudgeStandardById(String id){
		return (ZxJudgeStandard)this.get("getZxJudgeStandardById", id);
	}
	/**
	* 添加
	* @param zx_judge_standard 
	* @return
	*/
	public int addZxJudgeStandard(ZxJudgeStandard zxJudgeStandard){
		return this.add("addZxJudgeStandard", zxJudgeStandard);
	}
	/**
	* 修改
	* @param zx_judge_standard 
	* @return
	*/
	public int updateZxJudgeStandard(ZxJudgeStandard zxJudgeStandard){
		return this.update("updateZxJudgeStandard", zxJudgeStandard);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_standard 
	* @return
	*/
	public int updateZxJudgeStandardBySelective(ZxJudgeStandard zxJudgeStandard){
		return this.update("updateZxJudgeStandardBySelective", zxJudgeStandard);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeStandard(Map<String,Object> condition){
		return this.del("delZxJudgeStandard", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_standardList 
	* @return
	*/
	public int addBatchZxJudgeStandard(List<ZxJudgeStandard> zxJudgeStandardList){
		return this.add("addBatchZxJudgeStandard", zxJudgeStandardList);
	}
	/**
	* 批量修改
	* @param zx_judge_standardList 
	* @return
	*/
	public int updateBatchZxJudgeStandard(List<ZxJudgeStandard> zxJudgeStandardList){
		return this.update("updateBatchZxJudgeStandard", zxJudgeStandardList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_standardList 
	* @return
	*/
	public int updateBatchZxJudgeStandardBySelective(List<ZxJudgeStandard> zxJudgeStandardList){
		return this.update("updateBatchZxJudgeStandardBySelective", zxJudgeStandardList);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> getDepListByCondition(Map<String,Object> condition){
		return (List<Map<String,String>>)this.getList("getDepListByCondition",condition);
	}
}
