package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOutsourceTimeService;
import jehc.zxmodules.dao.ZxOutsourceTimeDao;
import jehc.zxmodules.model.ZxOutsourceTime;

/**
* 外协分批到货管理 
* 2017-09-01 09:30:59  陈运芝
*/
@Service("zxOutsourceTimeService")
public class ZxOutsourceTimeServiceImpl extends BaseService implements ZxOutsourceTimeService{
	@Autowired
	private ZxOutsourceTimeDao zxOutsourceTimeDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutsourceTime> getZxOutsourceTimeListByCondition(Map<String,Object> condition){
		try{
			return zxOutsourceTimeDao.getZxOutsourceTimeListByCondition(condition);
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
	public ZxOutsourceTime getZxOutsourceTimeById(String id){
		try{
			ZxOutsourceTime zxOutsourceTime = zxOutsourceTimeDao.getZxOutsourceTimeById(id);
			return zxOutsourceTime;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_outsource_time 
	* @return
	*/
	public int addZxOutsourceTime(ZxOutsourceTime zxOutsourceTime){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.addZxOutsourceTime(zxOutsourceTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTime(ZxOutsourceTime zxOutsourceTime){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.updateZxOutsourceTime(zxOutsourceTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTimeBySelective(ZxOutsourceTime zxOutsourceTime){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.updateZxOutsourceTimeBySelective(zxOutsourceTime);
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
	public int delZxOutsourceTime(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.delZxOutsourceTime(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_outsource_timeList 
	* @return
	*/
	public int addBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.addBatchZxOutsourceTime(zxOutsourceTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.updateBatchZxOutsourceTime(zxOutsourceTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTimeBySelective(List<ZxOutsourceTime> zxOutsourceTimeList){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.updateBatchZxOutsourceTimeBySelective(zxOutsourceTimeList);
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
	public int delZxOutsourceTimeByForeignKey(String outsource_id){
		int i = 0;
		try {
			i = zxOutsourceTimeDao.delZxOutsourceTimeByForeignKey(outsource_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
