package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMeetingAttachService;
import jehc.zxmodules.dao.ZxMeetingAttachDao;
import jehc.zxmodules.model.ZxMeetingAttach;

/**
* 会议附件 
* 2017-10-13 13:42:12  a
*/
@Service("zxMeetingAttachService")
public class ZxMeetingAttachServiceImpl extends BaseService implements ZxMeetingAttachService{
	@Autowired
	private ZxMeetingAttachDao zxMeetingAttachDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeetingAttach> getZxMeetingAttachListByCondition(Map<String,Object> condition){
		try{
			return zxMeetingAttachDao.getZxMeetingAttachListByCondition(condition);
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
	public ZxMeetingAttach getZxMeetingAttachById(String id){
		try{
			ZxMeetingAttach zxMeetingAttach = zxMeetingAttachDao.getZxMeetingAttachById(id);
			return zxMeetingAttach;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_meeting_attach 
	* @return
	*/
	public int addZxMeetingAttach(ZxMeetingAttach zxMeetingAttach){
		int i = 0;
		try {
			i = zxMeetingAttachDao.addZxMeetingAttach(zxMeetingAttach);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttach(ZxMeetingAttach zxMeetingAttach){
		int i = 0;
		try {
			i = zxMeetingAttachDao.updateZxMeetingAttach(zxMeetingAttach);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_attach 
	* @return
	*/
	public int updateZxMeetingAttachBySelective(ZxMeetingAttach zxMeetingAttach){
		int i = 0;
		try {
			i = zxMeetingAttachDao.updateZxMeetingAttachBySelective(zxMeetingAttach);
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
	public int delZxMeetingAttach(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMeetingAttachDao.delZxMeetingAttach(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_meeting_attachList 
	* @return
	*/
	public int addBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList){
		int i = 0;
		try {
			i = zxMeetingAttachDao.addBatchZxMeetingAttach(zxMeetingAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttach(List<ZxMeetingAttach> zxMeetingAttachList){
		int i = 0;
		try {
			i = zxMeetingAttachDao.updateBatchZxMeetingAttach(zxMeetingAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_attachList 
	* @return
	*/
	public int updateBatchZxMeetingAttachBySelective(List<ZxMeetingAttach> zxMeetingAttachList){
		int i = 0;
		try {
			i = zxMeetingAttachDao.updateBatchZxMeetingAttachBySelective(zxMeetingAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
