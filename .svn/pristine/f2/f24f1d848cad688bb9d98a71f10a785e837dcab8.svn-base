package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxMeeting;

/**
* 会议 
* 2017-10-13 12:55:40  a
*/
public interface ZxMeetingService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeeting> getZxMeetingListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeeting getZxMeetingById(String id);
	/**
	* 添加
	* @param zx_meeting 
	* @return
	*/
	public int addZxMeeting(ZxMeeting zxMeeting);
	/**
	* 修改
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeeting(ZxMeeting zxMeeting);
	/**
	* 修改（根据动态条件）
	* @param zx_meeting 
	* @return
	*/
	public int updateZxMeetingBySelective(ZxMeeting zxMeeting);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeeting(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_meetingList 
	* @return
	*/
	public int addBatchZxMeeting(List<ZxMeeting> zxMeetingList);
	/**
	* 批量修改
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeeting(List<ZxMeeting> zxMeetingList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_meetingList 
	* @return
	*/
	public int updateBatchZxMeetingBySelective(List<ZxMeeting> zxMeetingList);
}
