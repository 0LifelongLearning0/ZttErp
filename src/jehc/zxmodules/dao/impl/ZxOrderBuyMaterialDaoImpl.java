package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOrderBuyMaterialDao;
import jehc.zxmodules.model.ZxOrderBuyMaterial;

/**
* 采购订单物料表 
* 2017-10-30 11:03:07  陈运芝
*/
@Repository("zxOrderBuyMaterialDao")
public class ZxOrderBuyMaterialDaoImpl  extends BaseDaoImpl implements ZxOrderBuyMaterialDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOrderBuyMaterial> getZxOrderBuyMaterialListByCondition(Map<String,Object> condition){
		return (List<ZxOrderBuyMaterial>)this.getList("getZxOrderBuyMaterialListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderBuyMaterial getZxOrderBuyMaterialById(String id){
		return (ZxOrderBuyMaterial)this.get("getZxOrderBuyMaterialById", id);
	}
	/**
	* 添加
	* @param zx_order_buy_material 
	* @return
	*/
	public int addZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial){
		return this.add("addZxOrderBuyMaterial", zxOrderBuyMaterial);
	}
	/**
	* 修改
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial){
		return this.update("updateZxOrderBuyMaterial", zxOrderBuyMaterial);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterialBySelective(ZxOrderBuyMaterial zxOrderBuyMaterial){
		return this.update("updateZxOrderBuyMaterialBySelective", zxOrderBuyMaterial);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderBuyMaterial(Map<String,Object> condition){
		return this.del("delZxOrderBuyMaterial", condition);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOM(Map<String,Object> condition){
		return this.del("delZxOM", condition);
	}
	/**
	* 批量添加
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int addBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		return this.add("addBatchZxOrderBuyMaterial", zxOrderBuyMaterialList);
	}
	/**
	* 批量修改
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		return this.update("updateBatchZxOrderBuyMaterial", zxOrderBuyMaterialList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterialBySelective(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList){
		return this.update("updateBatchZxOrderBuyMaterialBySelective", zxOrderBuyMaterialList);
	}
}
