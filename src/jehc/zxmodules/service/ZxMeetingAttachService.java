package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxMeetingAttach;

/**
* 会议附件 
* 2017-10-13 13:42:12  a
*/
public interface ZxMeetingAttachService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeetingAttach> getZxMeetingAttachListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingAttach getZxMeetingAttachById(String id);
	/**
	* 添加
	* @param zx_meeting_attach 
	* @return
	*/
	public int addZxMeetingAttach(ZxMeetingAttach zxMeetingAttach);
	/**
	* 修改
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttach(ZxMeetingAttach zxMeetingAttach);
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttachBySelective(ZxMeetingAttach zxMeetingAttach);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingAttach(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_meeting_attachList 
	* @return
	*/
	public int addBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList);
	/**
	* 批量修改
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttachBySelective(List<ZxMeetingAttach> zxMeetingAttachList);
}
