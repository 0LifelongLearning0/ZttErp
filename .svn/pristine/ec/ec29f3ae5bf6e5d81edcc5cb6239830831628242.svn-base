package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMaterialDao;
import jehc.zxmodules.model.ZxMaterial;

/**
* 物料管理 
* 2017-08-31 11:00:45  陈运芝
*/
@Repository("zxMaterialDao")
public class ZxMaterialDaoImpl  extends BaseDaoImpl implements ZxMaterialDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMaterial> getZxMaterialListByCondition(Map<String,Object> condition){
		return (List<ZxMaterial>)this.getList("getZxMaterialListByCondition",condition);
	}
	/**
	* 查询对象
	* @param material_id 
	* @return
	*/
	public ZxMaterial getZxMaterialById(String material_id){
		return (ZxMaterial)this.get("getZxMaterialById", material_id);
	}
	/**
	* 添加
	* @param zx_material 
	* @return
	*/
	public int addZxMaterial(ZxMaterial zxMaterial){
		return this.add("addZxMaterial", zxMaterial);
	}
	/**
	* 修改
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterial(ZxMaterial zxMaterial){
		return this.update("updateZxMaterial", zxMaterial);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterialBySelective(ZxMaterial zxMaterial){
		return this.update("updateZxMaterialBySelective", zxMaterial);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMaterial(Map<String,Object> condition){
		return this.del("delZxMaterial", condition);
	}
	/**
	* 批量添加
	* @param zx_materialList 
	* @return
	*/
	public int addBatchZxMaterial(List<ZxMaterial> zxMaterialList){
		return this.add("addBatchZxMaterial", zxMaterialList);
	}
	/**
	* 批量修改
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterial(List<ZxMaterial> zxMaterialList){
		return this.update("updateBatchZxMaterial", zxMaterialList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterialBySelective(List<ZxMaterial> zxMaterialList){
		return this.update("updateBatchZxMaterialBySelective", zxMaterialList);
	}
}
