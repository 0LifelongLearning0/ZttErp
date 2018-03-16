package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxBuyTimeService;
import jehc.zxmodules.dao.ZxBuyTimeDao;
import jehc.zxmodules.model.ZxBuyTime;

/**
* 采购分批到货 
* 2017-11-01 11:15:47  陈运芝
*/
@Service("zxBuyTimeService")
public class ZxBuyTimeServiceImpl extends BaseService implements ZxBuyTimeService{
	@Autowired
	private ZxBuyTimeDao zxBuyTimeDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyTime> getZxBuyTimeListByCondition(Map<String,Object> condition){
		try{
			return zxBuyTimeDao.getZxBuyTimeListByCondition(condition);
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
	public ZxBuyTime getZxBuyTimeById(String id){
		try{
			ZxBuyTime zxBuyTime = zxBuyTimeDao.getZxBuyTimeById(id);
			return zxBuyTime;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_buy_time 
	* @return
	*/
	public int addZxBuyTime(ZxBuyTime zxBuyTime){
		int i = 0;
		try {
			i = zxBuyTimeDao.addZxBuyTime(zxBuyTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTime(ZxBuyTime zxBuyTime){
		int i = 0;
		try {
			i = zxBuyTimeDao.updateZxBuyTime(zxBuyTime);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTimeBySelective(ZxBuyTime zxBuyTime){
		int i = 0;
		try {
			i = zxBuyTimeDao.updateZxBuyTimeBySelective(zxBuyTime);
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
	public int delZxBuyTime(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxBuyTimeDao.delZxBuyTime(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_buy_timeList 
	* @return
	*/
	public int addBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList){
		int i = 0;
		try {
			i = zxBuyTimeDao.addBatchZxBuyTime(zxBuyTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList){
		int i = 0;
		try {
			i = zxBuyTimeDao.updateBatchZxBuyTime(zxBuyTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTimeBySelective(List<ZxBuyTime> zxBuyTimeList){
		int i = 0;
		try {
			i = zxBuyTimeDao.updateBatchZxBuyTimeBySelective(zxBuyTimeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param buy_id
	* @return
	*/
	public int delZxBuyTimeByForeignKey(String buy_id){
		int i = 0;
		try {
			i = zxBuyTimeDao.delZxBuyTimeByForeignKey(buy_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
