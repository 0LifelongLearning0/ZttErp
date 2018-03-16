package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxBuyApplyMaterialService;
import jehc.zxmodules.dao.ZxBuyApplyMaterialDao;
import jehc.zxmodules.model.ZxBuyApplyMaterial;

/**
* 采购申请单物料详情 
* 2017-10-26 10:46:15  陈运芝
*/
@Service("zxBuyApplyMaterialService")
public class ZxBuyApplyMaterialServiceImpl extends BaseService implements ZxBuyApplyMaterialService{
	@Autowired
	private ZxBuyApplyMaterialDao zxBuyApplyMaterialDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyApplyMaterial> getZxBuyApplyMaterialListByCondition(Map<String,Object> condition){
		try{
			return zxBuyApplyMaterialDao.getZxBuyApplyMaterialListByCondition(condition);
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
	public ZxBuyApplyMaterial getZxBuyApplyMaterialById(String id){
		try{
			ZxBuyApplyMaterial zxBuyApplyMaterial = zxBuyApplyMaterialDao.getZxBuyApplyMaterialById(id);
			return zxBuyApplyMaterial;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_buy_apply_material 
	* @return
	*/
	public int addZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.addZxBuyApplyMaterial(zxBuyApplyMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.updateZxBuyApplyMaterial(zxBuyApplyMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterialBySelective(ZxBuyApplyMaterial zxBuyApplyMaterial){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.updateZxBuyApplyMaterialBySelective(zxBuyApplyMaterial);
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
	public int delZxBuyApplyMaterial(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.delZxBuyApplyMaterial(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int addBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.addBatchZxBuyApplyMaterial(zxBuyApplyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.updateBatchZxBuyApplyMaterial(zxBuyApplyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterialBySelective(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		int i = 0;
		try {
			i = zxBuyApplyMaterialDao.updateBatchZxBuyApplyMaterialBySelective(zxBuyApplyMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
