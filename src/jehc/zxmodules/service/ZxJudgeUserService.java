package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxJudgeUser;

/**
* 供应商评定考核人 
* 2017-09-22 11:35:03  guqian
*/
public interface ZxJudgeUserService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeUser> getZxJudgeUserListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeUser getZxJudgeUserById(String id);
	/**
	* 添加
	* @param zx_judge_user 
	* @return
	*/
	public int addZxJudgeUser(ZxJudgeUser zxJudgeUser);
	/**
	* 修改
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUser(ZxJudgeUser zxJudgeUser);
	/**
	* 修改（根据动态条件）
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUserBySelective(ZxJudgeUser zxJudgeUser);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeUser(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_judge_userList 
	* @return
	*/
	public int addBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList);
	/**
	* 批量修改
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUserBySelective(List<ZxJudgeUser> zxJudgeUserList);
}
