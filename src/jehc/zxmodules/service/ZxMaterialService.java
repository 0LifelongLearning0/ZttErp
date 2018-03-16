package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxMaterial;

/**
* 物料管理 
* 2017-08-31 11:00:45  陈运芝
*/
public interface ZxMaterialService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMaterial> getZxMaterialListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param material_id 
	* @return
	*/
	public ZxMaterial getZxMaterialById(String material_id);
	/**
	* 添加
	* @param zx_material 
	* @return
	*/
	public int addZxMaterial(ZxMaterial zxMaterial);
	/**
	* 修改
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterial(ZxMaterial zxMaterial);
	/**
	* 修改（根据动态条件）
	* @param zx_material 
	* @return
	*/
	public int updateZxMaterialBySelective(ZxMaterial zxMaterial);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMaterial(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_materialList 
	* @return
	*/
	public int addBatchZxMaterial(List<ZxMaterial> zxMaterialList);
	/**
	* 批量修改
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterial(List<ZxMaterial> zxMaterialList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_materialList 
	* @return
	*/
	public int updateBatchZxMaterialBySelective(List<ZxMaterial> zxMaterialList);
}
