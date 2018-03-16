package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.zxmodules.service.ZxOrderOutService;
import jehc.zxmodules.dao.ZxOrderOutDao;
import jehc.zxmodules.model.ZxOrderOut;

/**
* 外协订单表 
* 2017-11-03 16:56:45  c
*/
@Service("zxOrderOutService")
public class ZxOrderOutServiceImpl extends BaseService implements ZxOrderOutService{
	@Autowired
	private ZxOrderOutDao zxOrderOutDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderOut> getZxOrderOutListByCondition(Map<String,Object> condition){
		try{
			return zxOrderOutDao.getZxOrderOutListByCondition(condition);
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
	public ZxOrderOut getZxOrderOutById(String id){
		try{
			ZxOrderOut zxOrderOut = zxOrderOutDao.getZxOrderOutById(id);
			return zxOrderOut;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_order_out 
	* @return
	*/
	public int addZxOrderOut(ZxOrderOut zxOrderOut){
		int i = 0;
		try {
			i = zxOrderOutDao.addZxOrderOut(zxOrderOut);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOut(ZxOrderOut zxOrderOut){
		int i = 0;
		try {
			i = zxOrderOutDao.updateZxOrderOut(zxOrderOut);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_out 
	* @return
	*/
	public int updateZxOrderOutBySelective(ZxOrderOut zxOrderOut){
		int i = 0;
		try {
			i = zxOrderOutDao.updateZxOrderOutBySelective(zxOrderOut);
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
	public int delZxOrderOut(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderOutDao.delZxOrderOut(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_order_outList 
	* @return
	*/
	public int addBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList){
		int i = 0;
		try {
			i = zxOrderOutDao.addBatchZxOrderOut(zxOrderOutList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOut(List<ZxOrderOut> zxOrderOutList){
		int i = 0;
		try {
			i = zxOrderOutDao.updateBatchZxOrderOut(zxOrderOutList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_outList 
	* @return
	*/
	public int updateBatchZxOrderOutBySelective(List<ZxOrderOut> zxOrderOutList){
		int i = 0;
		try {
			i = zxOrderOutDao.updateBatchZxOrderOutBySelective(zxOrderOutList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 获取订单下工件分页
	* @param condition 
	* @return
	*/
	public List<Map<String, Object>> getZxOWListByCondition(Map<String,Object> condition){
		try{
			return zxOrderOutDao.getZxOWListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
}
