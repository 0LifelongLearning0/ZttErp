package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOutTimeService;
import jehc.zxmodules.dao.ZxOutTimeDao;
import jehc.zxmodules.model.ZxOutTime;

/**
* 外协分批到货管理 
* 2017-11-03 09:08:36  陈运芝
*/
@Service("zxOutTimeService")
public class ZxOutTimeServiceImpl extends BaseService implements ZxOutTimeService{
	@Autowired
	private ZxOutTimeDao zxOutTimeDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutTime> getZxOutTimeListByCondition(Map<String,Object> condition){
		try{
			return zxOutTimeDao.getZxOutTimeListByCondition(condition);
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
	public ZxOutTime getZxOutTimeById(String id){
		try{
			ZxOutTime zxOutTime = zxOutTimeDao.getZxOutTimeById(id);
			return zxOutTime;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_out_time 
	* @return
	*/
	public int addZxOutTime(ZxOutTime zxOutTime){
		int i = 0;
		try {
			i = zxOutTimeDao.addZxOutTime(zxOutTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTime(ZxOutTime zxOutTime){
		int i = 0;
		try {
			i = zxOutTimeDao.updateZxOutTime(zxOutTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTimeBySelective(ZxOutTime zxOutTime){
		int i = 0;
		try {
			i = zxOutTimeDao.updateZxOutTimeBySelective(zxOutTime);
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
	public int delZxOutTime(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutTimeDao.delZxOutTime(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_out_timeList 
	* @return
	*/
	public int addBatchZxOutTime(List<ZxOutTime> zxOutTimeList){
		int i = 0;
		try {
			i = zxOutTimeDao.addBatchZxOutTime(zxOutTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTime(List<ZxOutTime> zxOutTimeList){
		int i = 0;
		try {
			i = zxOutTimeDao.updateBatchZxOutTime(zxOutTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTimeBySelective(List<ZxOutTime> zxOutTimeList){
		int i = 0;
		try {
			i = zxOutTimeDao.updateBatchZxOutTimeBySelective(zxOutTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param outsource_id
	* @return
	*/
	public int delZxOutTimeByForeignKey(String outsource_id){
		int i = 0;
		try {
			i = zxOutTimeDao.delZxOutTimeByForeignKey(outsource_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
