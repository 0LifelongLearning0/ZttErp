package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxMeetingHouse;

/**
* 会议室管理 
* 2017-11-17 15:51:33  a
*/
public interface ZxMeetingHouseDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeetingHouse> getZxMeetingHouseListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingHouse getZxMeetingHouseById(String id);
	/**
	* 添加
	* @param zx_meeting_house 
	* @return
	*/
	public int addZxMeetingHouse(ZxMeetingHouse zxMeetingHouse);
	/**
	* 修改
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouse(ZxMeetingHouse zxMeetingHouse);
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouseBySelective(ZxMeetingHouse zxMeetingHouse);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingHouse(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_meeting_houseList 
	* @return
	*/
	public int addBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList);
	/**
	* 批量修改
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouseBySelective(List<ZxMeetingHouse> zxMeetingHouseList);
}
