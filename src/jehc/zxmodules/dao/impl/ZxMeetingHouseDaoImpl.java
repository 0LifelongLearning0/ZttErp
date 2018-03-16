package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMeetingHouseDao;
import jehc.zxmodules.model.ZxMeetingHouse;

/**
* 会议室管理 
* 2017-11-17 15:51:33  a
*/
@Repository("zxMeetingHouseDao")
public class ZxMeetingHouseDaoImpl  extends BaseDaoImpl implements ZxMeetingHouseDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMeetingHouse> getZxMeetingHouseListByCondition(Map<String,Object> condition){
		return (List<ZxMeetingHouse>)this.getList("getZxMeetingHouseListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingHouse getZxMeetingHouseById(String id){
		return (ZxMeetingHouse)this.get("getZxMeetingHouseById", id);
	}
	/**
	* 添加
	* @param zx_meeting_house 
	* @return
	*/
	public int addZxMeetingHouse(ZxMeetingHouse zxMeetingHouse){
		return this.add("addZxMeetingHouse", zxMeetingHouse);
	}
	/**
	* 修改
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouse(ZxMeetingHouse zxMeetingHouse){
		return this.update("updateZxMeetingHouse", zxMeetingHouse);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouseBySelective(ZxMeetingHouse zxMeetingHouse){
		return this.update("updateZxMeetingHouseBySelective", zxMeetingHouse);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingHouse(Map<String,Object> condition){
		return this.del("delZxMeetingHouse", condition);
	}
	/**
	* 批量添加
	* @param zx_meeting_houseList 
	* @return
	*/
	public int addBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList){
		return this.add("addBatchZxMeetingHouse", zxMeetingHouseList);
	}
	/**
	* 批量修改
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList){
		return this.update("updateBatchZxMeetingHouse", zxMeetingHouseList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouseBySelective(List<ZxMeetingHouse> zxMeetingHouseList){
		return this.update("updateBatchZxMeetingHouseBySelective", zxMeetingHouseList);
	}
}
