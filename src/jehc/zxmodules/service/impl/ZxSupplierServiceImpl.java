package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxSupplierDao;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxSupplierService;

/**
* 供应商管理 
* 2017-09-20 15:51:29  guqian
*/
@Service("zxSupplierService")
public class ZxSupplierServiceImpl extends BaseService implements ZxSupplierService{
	@Autowired
	private ZxSupplierDao zxSupplierDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxSupplier> getZxSupplierListByCondition(Map<String,Object> condition){
		try{
			return zxSupplierDao.getZxSupplierListByCondition(condition);
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
	public ZxSupplier getZxSupplierById(String id){
		try{
			ZxSupplier zxSupplier = zxSupplierDao.getZxSupplierById(id);
			return zxSupplier;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_supplier 
	* @return
	*/
	public int addZxSupplier(ZxSupplier zxSupplier){
		int i = 0;
		try {
			i = zxSupplierDao.addZxSupplier(zxSupplier);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplier(ZxSupplier zxSupplier){
		int i = 0;
		try {
			i = zxSupplierDao.updateZxSupplier(zxSupplier);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplierBySelective(ZxSupplier zxSupplier){
		int i = 0;
		try {
			i = zxSupplierDao.updateZxSupplierBySelective(zxSupplier);
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
	public int delZxSupplier(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxSupplierDao.delZxSupplier(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_supplierList 
	* @return
	*/
	public int addBatchZxSupplier(List<ZxSupplier> zxSupplierList){
		int i = 0;
		try {
			i = zxSupplierDao.addBatchZxSupplier(zxSupplierList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplier(List<ZxSupplier> zxSupplierList){
		int i = 0;
		try {
			i = zxSupplierDao.updateBatchZxSupplier(zxSupplierList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplierBySelective(List<ZxSupplier> zxSupplierList){
		int i = 0;
		try {
			i = zxSupplierDao.updateBatchZxSupplierBySelective(zxSupplierList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
