package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxExpressdeliveryService;
import jehc.zxmodules.dao.ZxExpressdeliveryDao;
import jehc.zxmodules.model.ZxExpressdelivery;

/**
* 快递邮寄 
* 2017-11-24 13:10:10  陈运芝
*/
@Service("zxExpressdeliveryService")
public class ZxExpressdeliveryServiceImpl extends BaseService implements ZxExpressdeliveryService{
	@Autowired
	private ZxExpressdeliveryDao zxExpressdeliveryDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxExpressdelivery> getZxExpressdeliveryListByCondition(Map<String,Object> condition){
		try{
			return zxExpressdeliveryDao.getZxExpressdeliveryListByCondition(condition);
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
	public ZxExpressdelivery getZxExpressdeliveryById(String id){
		try{
			ZxExpressdelivery zxExpressdelivery = zxExpressdeliveryDao.getZxExpressdeliveryById(id);
			return zxExpressdelivery;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_expressdelivery 
	* @return
	*/
	public int addZxExpressdelivery(ZxExpressdelivery zxExpressdelivery){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.addZxExpressdelivery(zxExpressdelivery);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdelivery(ZxExpressdelivery zxExpressdelivery){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.updateZxExpressdelivery(zxExpressdelivery);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_expressdelivery 
	* @return
	*/
	public int updateZxExpressdeliveryBySelective(ZxExpressdelivery zxExpressdelivery){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.updateZxExpressdeliveryBySelective(zxExpressdelivery);
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
	public int delZxExpressdelivery(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.delZxExpressdelivery(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int addBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.addBatchZxExpressdelivery(zxExpressdeliveryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdelivery(List<ZxExpressdelivery> zxExpressdeliveryList){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.updateBatchZxExpressdelivery(zxExpressdeliveryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_expressdeliveryList 
	* @return
	*/
	public int updateBatchZxExpressdeliveryBySelective(List<ZxExpressdelivery> zxExpressdeliveryList){
		int i = 0;
		try {
			i = zxExpressdeliveryDao.updateBatchZxExpressdeliveryBySelective(zxExpressdeliveryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
