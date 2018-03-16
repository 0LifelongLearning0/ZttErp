package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMeetingHouseService;
import jehc.zxmodules.dao.ZxMeetingHouseDao;
import jehc.zxmodules.model.ZxMeetingHouse;

/**
* 会议室管理 
* 2017-11-17 15:51:33  a
*/
@Service("zxMeetingHouseService")
public class ZxMeetingHouseServiceImpl extends BaseService implements ZxMeetingHouseService{
	@Autowired
	private ZxMeetingHouseDao zxMeetingHouseDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMeetingHouse> getZxMeetingHouseListByCondition(Map<String,Object> condition){
		try{
			return zxMeetingHouseDao.getZxMeetingHouseListByCondition(condition);
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
	public ZxMeetingHouse getZxMeetingHouseById(String id){
		try{
			ZxMeetingHouse zxMeetingHouse = zxMeetingHouseDao.getZxMeetingHouseById(id);
			return zxMeetingHouse;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_meeting_house 
	* @return
	*/
	public int addZxMeetingHouse(ZxMeetingHouse zxMeetingHouse){
		int i = 0;
		try {
			i = zxMeetingHouseDao.addZxMeetingHouse(zxMeetingHouse);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouse(ZxMeetingHouse zxMeetingHouse){
		int i = 0;
		try {
			i = zxMeetingHouseDao.updateZxMeetingHouse(zxMeetingHouse);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_meeting_house 
	* @return
	*/
	public int updateZxMeetingHouseBySelective(ZxMeetingHouse zxMeetingHouse){
		int i = 0;
		try {
			i = zxMeetingHouseDao.updateZxMeetingHouseBySelective(zxMeetingHouse);
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
	public int delZxMeetingHouse(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMeetingHouseDao.delZxMeetingHouse(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_meeting_houseList 
	* @return
	*/
	public int addBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList){
		int i = 0;
		try {
			i = zxMeetingHouseDao.addBatchZxMeetingHouse(zxMeetingHouseList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouse(List<ZxMeetingHouse> zxMeetingHouseList){
		int i = 0;
		try {
			i = zxMeetingHouseDao.updateBatchZxMeetingHouse(zxMeetingHouseList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_meeting_houseList 
	* @return
	*/
	public int updateBatchZxMeetingHouseBySelective(List<ZxMeetingHouse> zxMeetingHouseList){
		int i = 0;
		try {
			i = zxMeetingHouseDao.updateBatchZxMeetingHouseBySelective(zxMeetingHouseList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
