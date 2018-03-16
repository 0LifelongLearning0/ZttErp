package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMeetingUserService;
import jehc.zxmodules.dao.ZxMeetingUserDao;
import jehc.zxmodules.model.ZxMeetingUser;

/**
* 会议人员 
* 2017-10-13 13:21:28  a
*/
@Service("zxMeetingUserService")
public class ZxMeetingUserServiceImpl extends BaseService implements ZxMeetingUserService{
	@Autowired
	private ZxMeetingUserDao zxMeetingUserDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeetingUser> getZxMeetingUserListByCondition(Map<String,Object> condition){
		try{
			return zxMeetingUserDao.getZxMeetingUserListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingUser getZxMeetingUserById(String id){
		try{
			ZxMeetingUser zxMeetingUser = zxMeetingUserDao.getZxMeetingUserById(id);
			return zxMeetingUser;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_meeting_user 
	* @return
	*/
	public int addZxMeetingUser(ZxMeetingUser zxMeetingUser){
		int i = 0;
		try {
			i = zxMeetingUserDao.addZxMeetingUser(zxMeetingUser);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_meeting_user 
	* @return
	*/
	public int updateZxMeetingUser(ZxMeetingUser zxMeetingUser){
		int i = 0;
		try {
			i = zxMeetingUserDao.updateZxMeetingUser(zxMeetingUser);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_user 
	* @return
	*/
	public int updateZxMeetingUserBySelective(ZxMeetingUser zxMeetingUser){
		int i = 0;
		try {
			i = zxMeetingUserDao.updateZxMeetingUserBySelective(zxMeetingUser);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingUser(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMeetingUserDao.delZxMeetingUser(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_meeting_userList 
	* @return
	*/
	public int addBatchZxMeetingUser(List<ZxMeetingUser> zxMeetingUserList){
		int i = 0;
		try {
			i = zxMeetingUserDao.addBatchZxMeetingUser(zxMeetingUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_meeting_userList 
	* @return
	*/
	public int updateBatchZxMeetingUser(List<ZxMeetingUser> zxMeetingUserList){
		int i = 0;
		try {
			i = zxMeetingUserDao.updateBatchZxMeetingUser(zxMeetingUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_userList 
	* @return
	*/
	public int updateBatchZxMeetingUserBySelective(List<ZxMeetingUser> zxMeetingUserList){
		int i = 0;
		try {
			i = zxMeetingUserDao.updateBatchZxMeetingUserBySelective(zxMeetingUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
