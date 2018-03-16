package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeUserDao;
import jehc.zxmodules.model.ZxJudgeUser;

/**
* 供应商评定考核人 
* 2017-09-22 11:35:03  guqian
*/
@Repository("zxJudgeUserDao")
public class ZxJudgeUserDaoImpl  extends BaseDaoImpl implements ZxJudgeUserDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeUser> getZxJudgeUserListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeUser>)this.getList("getZxJudgeUserListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeUser getZxJudgeUserById(String id){
		return (ZxJudgeUser)this.get("getZxJudgeUserById", id);
	}
	/**
	* 添加
	* @param zx_judge_user 
	* @return
	*/
	public int addZxJudgeUser(ZxJudgeUser zxJudgeUser){
		return this.add("addZxJudgeUser", zxJudgeUser);
	}
	/**
	* 修改
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUser(ZxJudgeUser zxJudgeUser){
		return this.update("updateZxJudgeUser", zxJudgeUser);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUserBySelective(ZxJudgeUser zxJudgeUser){
		return this.update("updateZxJudgeUserBySelective", zxJudgeUser);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeUser(Map<String,Object> condition){
		return this.del("delZxJudgeUser", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_userList 
	* @return
	*/
	public int addBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList){
		return this.add("addBatchZxJudgeUser", zxJudgeUserList);
	}
	/**
	* 批量修改
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList){
		return this.update("updateBatchZxJudgeUser", zxJudgeUserList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUserBySelective(List<ZxJudgeUser> zxJudgeUserList){
		return this.update("updateBatchZxJudgeUserBySelective", zxJudgeUserList);
	}
}
