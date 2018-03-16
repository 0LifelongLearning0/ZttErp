package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxOrderBuyDao;
import jehc.zxmodules.model.ZxOrderBuy;
import jehc.zxmodules.service.ZxOrderBuyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 采购订单 
* 2017-10-30 11:01:28  陈运芝
*/
@Service("zxOrderBuyService")
public class ZxOrderBuyServiceImpl extends BaseService implements ZxOrderBuyService{
	@Autowired
	private ZxOrderBuyDao zxOrderBuyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderBuy> getZxOrderBuyListByCondition(Map<String,Object> condition){
		try{
			return zxOrderBuyDao.getZxOrderBuyListByCondition(condition);
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
	public ZxOrderBuy getZxOrderBuyById(String id){
		try{
			ZxOrderBuy zxOrderBuy = zxOrderBuyDao.getZxOrderBuyById(id);
			return zxOrderBuy;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_order_buy 
	* @return
	*/
	public int addZxOrderBuy(ZxOrderBuy zxOrderBuy){
		int i = 0;
		try {
			i = zxOrderBuyDao.addZxOrderBuy(zxOrderBuy);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuy(ZxOrderBuy zxOrderBuy){
		int i = 0;
		try {
			i = zxOrderBuyDao.updateZxOrderBuy(zxOrderBuy);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy 
	* @return
	*/
	public int updateZxOrderBuyBySelective(ZxOrderBuy zxOrderBuy){
		int i = 0;
		try {
			i = zxOrderBuyDao.updateZxOrderBuyBySelective(zxOrderBuy);
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
	public int delZxOrderBuy(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderBuyDao.delZxOrderBuy(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_order_buyList 
	* @return
	*/
	public int addBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList){
		int i = 0;
		try {
			i = zxOrderBuyDao.addBatchZxOrderBuy(zxOrderBuyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuy(List<ZxOrderBuy> zxOrderBuyList){
		int i = 0;
		try {
			i = zxOrderBuyDao.updateBatchZxOrderBuy(zxOrderBuyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buyList 
	* @return
	*/
	public int updateBatchZxOrderBuyBySelective(List<ZxOrderBuy> zxOrderBuyList){
		int i = 0;
		try {
			i = zxOrderBuyDao.updateBatchZxOrderBuyBySelective(zxOrderBuyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String, Object>> getZxOMListByCondition(Map<String,Object> condition){
		try{
			return zxOrderBuyDao.getZxOMListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
}
