package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxCarService;
import jehc.zxmodules.dao.ZxCarDao;
import jehc.zxmodules.model.ZxCar;

/**
* 车辆管理 
* 2017-09-14 10:21:06  陆建
*/
@Service("zxCarService")
public class ZxCarServiceImpl extends BaseService implements ZxCarService{
	@Autowired
	private ZxCarDao zxCarDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxCar> getZxCarListByCondition(Map<String,Object> condition){
		try{
			return zxCarDao.getZxCarListByCondition(condition);
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
	public ZxCar getZxCarById(String id){
		try{
			ZxCar zxCar = zxCarDao.getZxCarById(id);
			return zxCar;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_car 
	* @return
	*/
	public int addZxCar(ZxCar zxCar){
		int i = 0;
		try {
			i = zxCarDao.addZxCar(zxCar);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_car 
	* @return
	*/
	public int updateZxCar(ZxCar zxCar){
		int i = 0;
		try {
			i = zxCarDao.updateZxCar(zxCar);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_car 
	* @return
	*/
	public int updateZxCarBySelective(ZxCar zxCar){
		int i = 0;
		try {
			i = zxCarDao.updateZxCarBySelective(zxCar);
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
	public int delZxCar(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxCarDao.delZxCar(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_carList 
	* @return
	*/
	public int addBatchZxCar(List<ZxCar> zxCarList){
		int i = 0;
		try {
			i = zxCarDao.addBatchZxCar(zxCarList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCar(List<ZxCar> zxCarList){
		int i = 0;
		try {
			i = zxCarDao.updateBatchZxCar(zxCarList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCarBySelective(List<ZxCar> zxCarList){
		int i = 0;
		try {
			i = zxCarDao.updateBatchZxCarBySelective(zxCarList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
