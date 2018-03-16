package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.zxmodules.service.ZxOrderBuyMaterialService;
import jehc.zxmodules.dao.ZxOrderBuyMaterialDao;
import jehc.zxmodules.model.ZxOrderBuyMaterial;

/**
* 采购订单物料表 
* 2017-10-30 11:03:07  陈运芝
*/
@Service("zxOrderBuyMaterialService")
public class ZxOrderBuyMaterialServiceImpl extends BaseService implements ZxOrderBuyMaterialService{
	@Autowired
	private ZxOrderBuyMaterialDao zxOrderBuyMaterialDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderBuyMaterial> getZxOrderBuyMaterialListByCondition(Map<String,Object> condition){
		try{
			return zxOrderBuyMaterialDao.getZxOrderBuyMaterialListByCondition(condition);
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
	public ZxOrderBuyMaterial getZxOrderBuyMaterialById(String id){
		try{
			ZxOrderBuyMaterial zxOrderBuyMaterial = zxOrderBuyMaterialDao.getZxOrderBuyMaterialById(id);
			return zxOrderBuyMaterial;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_order_buy_material 
	* @return
	*/
	public int addZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.addZxOrderBuyMaterial(zxOrderBuyMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.updateZxOrderBuyMaterial(zxOrderBuyMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterialBySelective(ZxOrderBuyMaterial zxOrderBuyMaterial){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.updateZxOrderBuyMaterialBySelective(zxOrderBuyMaterial);
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
	public int delZxOrderBuyMaterial(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.delZxOrderBuyMaterial(condition);
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
	public int delZxOM(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.delZxOM(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	/**
	* 批量添加
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int addBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.addBatchZxOrderBuyMaterial(zxOrderBuyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.updateBatchZxOrderBuyMaterial(zxOrderBuyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterialBySelective(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		int i = 0;
		try {
			i = zxOrderBuyMaterialDao.updateBatchZxOrderBuyMaterialBySelective(zxOrderBuyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
