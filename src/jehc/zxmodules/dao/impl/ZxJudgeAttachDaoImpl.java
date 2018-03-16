package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeAttachDao;
import jehc.zxmodules.model.ZxJudgeAttach;

/**
* 供应商评定附件 
* 2017-09-30 16:08:00  a
*/
@Repository("zxJudgeAttachDao")
public class ZxJudgeAttachDaoImpl  extends BaseDaoImpl implements ZxJudgeAttachDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeAttach> getZxJudgeAttachListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeAttach>)this.getList("getZxJudgeAttachListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeAttach getZxJudgeAttachById(String id){
		return (ZxJudgeAttach)this.get("getZxJudgeAttachById", id);
	}
	/**
	* 添加
	* @param zx_judge_attach 
	* @return
	*/
	public int addZxJudgeAttach(ZxJudgeAttach zxJudgeAttach){
		return this.add("addZxJudgeAttach", zxJudgeAttach);
	}
	/**
	* 修改
	* @param zx_judge_attach 
	* @return
	*/
	public int updateZxJudgeAttach(ZxJudgeAttach zxJudgeAttach){
		return this.update("updateZxJudgeAttach", zxJudgeAttach);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_attach 
	* @return
	*/
	public int updateZxJudgeAttachBySelective(ZxJudgeAttach zxJudgeAttach){
		return this.update("updateZxJudgeAttachBySelective", zxJudgeAttach);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeAttach(Map<String,Object> condition){
		return this.del("delZxJudgeAttach", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_attachList 
	* @return
	*/
	public int addBatchZxJudgeAttach(List<ZxJudgeAttach> zxJudgeAttachList){
		return this.add("addBatchZxJudgeAttach", zxJudgeAttachList);
	}
	/**
	* 批量修改
	* @param zx_judge_attachList 
	* @return
	*/
	public int updateBatchZxJudgeAttach(List<ZxJudgeAttach> zxJudgeAttachList){
		return this.update("updateBatchZxJudgeAttach", zxJudgeAttachList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_attachList 
	* @return
	*/
	public int updateBatchZxJudgeAttachBySelective(List<ZxJudgeAttach> zxJudgeAttachList){
		return this.update("updateBatchZxJudgeAttachBySelective", zxJudgeAttachList);
	}
}
