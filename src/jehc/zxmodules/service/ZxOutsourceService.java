package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOutsource;

/**
* 外协加工进度表 
* 2017-09-01 09:30:59  陈运芝
*/
public interface ZxOutsourceService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutsource> getZxOutsourceListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutsource getZxOutsourceById(String id);
	/**
	* 添加
	* @param zx_outsource 
	* @return
	*/
	public int addZxOutsource(ZxOutsource zxOutsource);
	/**
	* 修改
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsource(ZxOutsource zxOutsource);
	/**
	* 修改（根据动态条件）
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsourceBySelective(ZxOutsource zxOutsource);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutsource(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_outsourceList 
	* @return
	*/
	public int addBatchZxOutsource(List<ZxOutsource> zxOutsourceList);
	/**
	* 批量修改
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsource(List<ZxOutsource> zxOutsourceList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsourceBySelective(List<ZxOutsource> zxOutsourceList);
}
