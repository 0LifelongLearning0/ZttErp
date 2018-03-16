package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxSupplierDao;
import jehc.zxmodules.model.ZxSupplier;

/**
* 供应商管理 
* 2017-09-20 15:51:29  guqian
*/
@Repository("zxSupplierDao")
public class ZxSupplierDaoImpl  extends BaseDaoImpl implements ZxSupplierDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxSupplier> getZxSupplierListByCondition(Map<String,Object> condition){
		return (List<ZxSupplier>)this.getList("getZxSupplierListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxSupplier getZxSupplierById(String id){
		return (ZxSupplier)this.get("getZxSupplierById", id);
	}
	/**
	* 添加
	* @param zx_supplier 
	* @return
	*/
	public int addZxSupplier(ZxSupplier zxSupplier){
		return this.add("addZxSupplier", zxSupplier);
	}
	/**
	* 修改
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplier(ZxSupplier zxSupplier){
		return this.update("updateZxSupplier", zxSupplier);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplierBySelective(ZxSupplier zxSupplier){
		return this.update("updateZxSupplierBySelective", zxSupplier);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxSupplier(Map<String,Object> condition){
		return this.del("delZxSupplier", condition);
	}
	/**
	* 批量添加
	* @param zx_supplierList 
	* @return
	*/
	public int addBatchZxSupplier(List<ZxSupplier> zxSupplierList){
		return this.add("addBatchZxSupplier", zxSupplierList);
	}
	/**
	* 批量修改
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplier(List<ZxSupplier> zxSupplierList){
		return this.update("updateBatchZxSupplier", zxSupplierList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplierBySelective(List<ZxSupplier> zxSupplierList){
		return this.update("updateBatchZxSupplierBySelective", zxSupplierList);
	}
}
