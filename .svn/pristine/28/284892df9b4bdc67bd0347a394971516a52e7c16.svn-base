package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMeetingDao;
import jehc.zxmodules.model.ZxMeeting;

/**
* 会议 
* 2017-10-13 12:55:40  a
*/
@Repository("zxMeetingDao")
public class ZxMeetingDaoImpl  extends BaseDaoImpl implements ZxMeetingDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMeeting> getZxMeetingListByCondition(Map<String,Object> condition){
		return (List<ZxMeeting>)this.getList("getZxMeetingListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeeting getZxMeetingById(String id){
		return (ZxMeeting)this.get("getZxMeetingById", id);
	}
	/**
	* 添加
	* @param zx_meeting 
	* @return
	*/
	public int addZxMeeting(ZxMeeting zxMeeting){
		return this.add("addZxMeeting", zxMeeting);
	}
	/**
	* 修改
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeeting(ZxMeeting zxMeeting){
		return this.update("updateZxMeeting", zxMeeting);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeetingBySelective(ZxMeeting zxMeeting){
		return this.update("updateZxMeetingBySelective", zxMeeting);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeeting(Map<String,Object> condition){
		return this.del("delZxMeeting", condition);
	}
	/**
	* 批量添加
	* @param zx_meetingList 
	* @return
	*/
	public int addBatchZxMeeting(List<ZxMeeting> zxMeetingList){
		return this.add("addBatchZxMeeting", zxMeetingList);
	}
	/**
	* 批量修改
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeeting(List<ZxMeeting> zxMeetingList){
		return this.update("updateBatchZxMeeting", zxMeetingList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeetingBySelective(List<ZxMeeting> zxMeetingList){
		return this.update("updateBatchZxMeetingBySelective", zxMeetingList);
	}
}
