package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMeetingUserDao;
import jehc.zxmodules.model.ZxMeetingUser;

/**
* 会议人员 
* 2017-10-13 13:21:28  a
*/
@Repository("zxMeetingUserDao")
public class ZxMeetingUserDaoImpl  extends BaseDaoImpl implements ZxMeetingUserDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMeetingUser> getZxMeetingUserListByCondition(Map<String,Object> condition){
		return (List<ZxMeetingUser>)this.getList("getZxMeetingUserListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingUser getZxMeetingUserById(String id){
		return (ZxMeetingUser)this.get("getZxMeetingUserById", id);
	}
	/**
	* 添加
	* @param zx_meeting_user 
	* @return
	*/
	public int addZxMeetingUser(ZxMeetingUser zxMeetingUser){
		return this.add("addZxMeetingUser", zxMeetingUser);
	}
	/**
	* 修改
	* @param zx_meeting_user 
	* @return
	*/
	public int updateZxMeetingUser(ZxMeetingUser zxMeetingUser){
		return this.update("updateZxMeetingUser", zxMeetingUser);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_user 
	* @return
	*/
	public int updateZxMeetingUserBySelective(ZxMeetingUser zxMeetingUser){
		return this.update("updateZxMeetingUserBySelective", zxMeetingUser);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingUser(Map<String,Object> condition){
		return this.del("delZxMeetingUser", condition);
	}
	/**
	* 批量添加
	* @param zx_meeting_userList 
	* @return
	*/
	public int addBatchZxMeetingUser(List<ZxMeetingUser> zxMeetingUserList){
		return this.add("addBatchZxMeetingUser", zxMeetingUserList);
	}
	/**
	* 批量修改
	* @param zx_meeting_userList 
	* @return
	*/
	public int updateBatchZxMeetingUser(List<ZxMeetingUser> zxMeetingUserList){
		return this.update("updateBatchZxMeetingUser", zxMeetingUserList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_userList 
	* @return
	*/
	public int updateBatchZxMeetingUserBySelective(List<ZxMeetingUser> zxMeetingUserList){
		return this.update("updateBatchZxMeetingUserBySelective", zxMeetingUserList);
	}
}
