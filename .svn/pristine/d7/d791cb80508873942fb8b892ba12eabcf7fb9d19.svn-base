package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMaterialService;
import jehc.zxmodules.dao.ZxMaterialDao;
import jehc.zxmodules.model.ZxMaterial;

/**
* 物料管理 
* 2017-08-31 11:00:45  陈运芝
*/
@Service("zxMaterialService")
public class ZxMaterialServiceImpl extends BaseService implements ZxMaterialService{
	@Autowired
	private ZxMaterialDao zxMaterialDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMaterial> getZxMaterialListByCondition(Map<String,Object> condition){
		try{
			return zxMaterialDao.getZxMaterialListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param material_id 
	* @return
	*/
	public ZxMaterial getZxMaterialById(String material_id){
		try{
			ZxMaterial zxMaterial = zxMaterialDao.getZxMaterialById(material_id);
			return zxMaterial;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_material 
	* @return
	*/
	public int addZxMaterial(ZxMaterial zxMaterial){
		int i = 0;
		try {
			i = zxMaterialDao.addZxMaterial(zxMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterial(ZxMaterial zxMaterial){
		int i = 0;
		try {
			i = zxMaterialDao.updateZxMaterial(zxMaterial);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterialBySelective(ZxMaterial zxMaterial){
		int i = 0;
		try {
			i = zxMaterialDao.updateZxMaterialBySelective(zxMaterial);
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
	public int delZxMaterial(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMaterialDao.delZxMaterial(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_materialList 
	* @return
	*/
	public int addBatchZxMaterial(List<ZxMaterial> zxMaterialList){
		int i = 0;
		try {
			i = zxMaterialDao.addBatchZxMaterial(zxMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterial(List<ZxMaterial> zxMaterialList){
		int i = 0;
		try {
			i = zxMaterialDao.updateBatchZxMaterial(zxMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterialBySelective(List<ZxMaterial> zxMaterialList){
		int i = 0;
		try {
			i = zxMaterialDao.updateBatchZxMaterialBySelective(zxMaterialList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
