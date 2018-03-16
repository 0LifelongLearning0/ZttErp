package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxSupplier;

/**
* 供应商管理 
* 2017-09-20 15:51:29  guqian
*/
public interface ZxSupplierDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxSupplier> getZxSupplierListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxSupplier getZxSupplierById(String id);
	/**
	* 添加
	* @param zx_supplier 
	* @return
	*/
	public int addZxSupplier(ZxSupplier zxSupplier);
	/**
	* 修改
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplier(ZxSupplier zxSupplier);
	/**
	* 修改（根据动态条件）
	* @param zx_supplier 
	* @return
	*/
	public int updateZxSupplierBySelective(ZxSupplier zxSupplier);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxSupplier(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_supplierList 
	* @return
	*/
	public int addBatchZxSupplier(List<ZxSupplier> zxSupplierList);
	/**
	* 批量修改
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplier(List<ZxSupplier> zxSupplierList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_supplierList 
	* @return
	*/
	public int updateBatchZxSupplierBySelective(List<ZxSupplier> zxSupplierList);
}
