package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.zxmodules.service.ZxOrderOutWorkpieceService;
import jehc.zxmodules.dao.ZxOrderOutWorkpieceDao;
import jehc.zxmodules.model.ZxOrderOutWorkpiece;

/**
* 外协订单工件表 
* 2017-11-03 16:58:45  陈运芝
*/
@Service("zxOrderOutWorkpieceService")
public class ZxOrderOutWorkpieceServiceImpl extends BaseService implements ZxOrderOutWorkpieceService{
	@Autowired
	private ZxOrderOutWorkpieceDao zxOrderOutWorkpieceDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderOutWorkpiece> getZxOrderOutWorkpieceListByCondition(Map<String,Object> condition){
		try{
			return zxOrderOutWorkpieceDao.getZxOrderOutWorkpieceListByCondition(condition);
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
	public ZxOrderOutWorkpiece getZxOrderOutWorkpieceById(String id){
		try{
			ZxOrderOutWorkpiece zxOrderOutWorkpiece = zxOrderOutWorkpieceDao.getZxOrderOutWorkpieceById(id);
			return zxOrderOutWorkpiece;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int addZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.addZxOrderOutWorkpiece(zxOrderOutWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.updateZxOrderOutWorkpiece(zxOrderOutWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_out_workpiece 
	* @return
	*/
	public int updateZxOrderOutWorkpieceBySelective(ZxOrderOutWorkpiece zxOrderOutWorkpiece){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.updateZxOrderOutWorkpieceBySelective(zxOrderOutWorkpiece);
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
	public int delZxOrderOutWorkpiece(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.delZxOrderOutWorkpiece(condition);
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
	public int delZxOW(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.delZxOW(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int addBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.addBatchZxOrderOutWorkpiece(zxOrderOutWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpiece(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.updateBatchZxOrderOutWorkpiece(zxOrderOutWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_out_workpieceList 
	* @return
	*/
	public int updateBatchZxOrderOutWorkpieceBySelective(List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList){
		int i = 0;
		try {
			i = zxOrderOutWorkpieceDao.updateBatchZxOrderOutWorkpieceBySelective(zxOrderOutWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
