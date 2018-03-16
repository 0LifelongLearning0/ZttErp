package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxBuyApplyMaterial;

/**
* 采购申请单物料详情 
* 2017-10-26 10:46:15  陈运芝
*/
public interface ZxBuyApplyMaterialDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyApplyMaterial> getZxBuyApplyMaterialListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyApplyMaterial getZxBuyApplyMaterialById(String id);
	/**
	* 添加
	* @param zx_buy_apply_material 
	* @return
	*/
	public int addZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial);
	/**
	* 修改
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial);
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply_material 
	* @return
	*/
	public int updateZxBuyApplyMaterialBySelective(ZxBuyApplyMaterial zxBuyApplyMaterial);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyApplyMaterial(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int addBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList);
	/**
	* 批量修改
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterial(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_apply_materialList 
	* @return
	*/
	public int updateBatchZxBuyApplyMaterialBySelective(List<ZxBuyApplyMaterial> zxBuyApplyMaterialList);
}
