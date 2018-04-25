package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttProcessproductParent;

/**
* 机械加工工艺过程母表 
* 2018-04-24 14:27:01  季建吉
*/
public interface ZttProcessproductParentDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttProcessproductParent> getZttProcessproductParentListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttProcessproductParent getZttProcessproductParentById(String id);
	/**
	* 添加
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int addZttProcessproductParent(ZttProcessproductParent zttProcessproductParent);
	/**
	* 修改
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParent(ZttProcessproductParent zttProcessproductParent);
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParentBySelective(ZttProcessproductParent zttProcessproductParent);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttProcessproductParent(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int addBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList);
	/**
	* 批量修改
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParentBySelective(List<ZttProcessproductParent> zttProcessproductParentList);
}
