package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxBuyApplyMaterialDao;
import jehc.zxmodules.model.ZxBuyApplyMaterial;

/**
* 采购申请单物料详情 
* 2017-10-26 10:46:15  陈运芝
*/
@Repository("zxBuyApplyMaterialDao")
public class ZxBuyApplyMaterialDaoImpl  extends BaseDaoImpl implements ZxBuyApplyMaterialDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxBuyApplyMaterial> getZxBuyApplyMaterialListByCondition(Map<String,Object> condition){
		return (List<ZxBuyApplyMaterial>)this.getList("getZxBuyApplyMaterialListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyApplyMaterial getZxBuyApplyMaterialById(String id){
		return (ZxBuyApplyMaterial)this.get("getZxBuyApplyMaterialById", id);
	}
	/**
	* 添加
	* @param zx_buy_apply_material 
	* @return
	*/
	public int addZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial){
		return this.add("addZxBuyApplyMaterial", zxBuyApplyMaterial);
	}
	/**
	* 修改
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial){
		return this.update("updateZxBuyApplyMaterial", zxBuyApplyMaterial);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterialBySelective(ZxBuyApplyMaterial zxBuyApplyMaterial){
		return this.update("updateZxBuyApplyMaterialBySelective", zxBuyApplyMaterial);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyApplyMaterial(Map<String,Object> condition){
		return this.del("delZxBuyApplyMaterial", condition);
	}
	/**
	* 批量添加
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int addBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		return this.add("addBatchZxBuyApplyMaterial", zxBuyApplyMaterialList);
	}
	/**
	* 批量修改
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		return this.update("updateBatchZxBuyApplyMaterial", zxBuyApplyMaterialList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterialBySelective(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList){
		return this.update("updateBatchZxBuyApplyMaterialBySelective", zxBuyApplyMaterialList);
	}
}
