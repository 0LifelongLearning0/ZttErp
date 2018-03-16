package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMeetingService;
import jehc.zxmodules.dao.ZxMeetingDao;
import jehc.zxmodules.model.ZxMeeting;

/**
* 会议 
* 2017-10-13 12:55:40  a
*/
@Service("zxMeetingService")
public class ZxMeetingServiceImpl extends BaseService implements ZxMeetingService{
	@Autowired
	private ZxMeetingDao zxMeetingDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeeting> getZxMeetingListByCondition(Map<String,Object> condition){
		try{
			return zxMeetingDao.getZxMeetingListByCondition(condition);
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
	public ZxMeeting getZxMeetingById(String id){
		try{
			ZxMeeting zxMeeting = zxMeetingDao.getZxMeetingById(id);
			return zxMeeting;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_meeting 
	* @return
	*/
	public int addZxMeeting(ZxMeeting zxMeeting){
		int i = 0;
		try {
			i = zxMeetingDao.addZxMeeting(zxMeeting);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeeting(ZxMeeting zxMeeting){
		int i = 0;
		try {
			i = zxMeetingDao.updateZxMeeting(zxMeeting);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeetingBySelective(ZxMeeting zxMeeting){
		int i = 0;
		try {
			i = zxMeetingDao.updateZxMeetingBySelective(zxMeeting);
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
	public int delZxMeeting(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMeetingDao.delZxMeeting(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_meetingList 
	* @return
	*/
	public int addBatchZxMeeting(List<ZxMeeting> zxMeetingList){
		int i = 0;
		try {
			i = zxMeetingDao.addBatchZxMeeting(zxMeetingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeeting(List<ZxMeeting> zxMeetingList){
		int i = 0;
		try {
			i = zxMeetingDao.updateBatchZxMeeting(zxMeetingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeetingBySelective(List<ZxMeeting> zxMeetingList){
		int i = 0;
		try {
			i = zxMeetingDao.updateBatchZxMeetingBySelective(zxMeetingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
