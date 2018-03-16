package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMeetingAttachDao;
import jehc.zxmodules.model.ZxMeetingAttach;

/**
* 会议附件 
* 2017-10-13 13:42:12  a
*/
@Repository("zxMeetingAttachDao")
public class ZxMeetingAttachDaoImpl  extends BaseDaoImpl implements ZxMeetingAttachDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMeetingAttach> getZxMeetingAttachListByCondition(Map<String,Object> condition){
		return (List<ZxMeetingAttach>)this.getList("getZxMeetingAttachListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMeetingAttach getZxMeetingAttachById(String id){
		return (ZxMeetingAttach)this.get("getZxMeetingAttachById", id);
	}
	/**
	* 添加
	* @param zx_meeting_attach 
	* @return
	*/
	public int addZxMeetingAttach(ZxMeetingAttach zxMeetingAttach){
		return this.add("addZxMeetingAttach", zxMeetingAttach);
	}
	/**
	* 修改
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttach(ZxMeetingAttach zxMeetingAttach){
		return this.update("updateZxMeetingAttach", zxMeetingAttach);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttachBySelective(ZxMeetingAttach zxMeetingAttach){
		return this.update("updateZxMeetingAttachBySelective", zxMeetingAttach);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMeetingAttach(Map<String,Object> condition){
		return this.del("delZxMeetingAttach", condition);
	}
	/**
	* 批量添加
	* @param zx_meeting_attachList 
	* @return
	*/
	public int addBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList){
		return this.add("addBatchZxMeetingAttach", zxMeetingAttachList);
	}
	/**
	* 批量修改
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList){
		return this.update("updateBatchZxMeetingAttach", zxMeetingAttachList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttachBySelective(List<ZxMeetingAttach> zxMeetingAttachList){
		return this.update("updateBatchZxMeetingAttachBySelective", zxMeetingAttachList);
	}
}
