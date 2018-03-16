package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;

import jehc.zxmodules.model.ZxOrderBuyMaterial;

/**
* 采购订单物料表 
* 2017-10-30 11:03:07  陈运芝
*/
public interface ZxOrderBuyMaterialService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOrderBuyMaterial> getZxOrderBuyMaterialListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOrderBuyMaterial getZxOrderBuyMaterialById(String id);
	/**
	* 添加
	* @param zx_order_buy_material 
	* @return
	*/
	public int addZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial);
	/**
	* 修改
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial);
	/**
	* 修改（根据动态条件）
	* @param zx_order_buy_material 
	* @return
	*/
	public int updateZxOrderBuyMaterialBySelective(ZxOrderBuyMaterial zxOrderBuyMaterial);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOrderBuyMaterial(Map<String,Object> condition);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOM(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int addBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList);
	/**
	* 批量修改
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterial(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_order_buy_materialList 
	* @return
	*/
	public int updateBatchZxOrderBuyMaterialBySelective(List<ZxOrderBuyMaterial> zxOrderBuyMaterialList);
}
