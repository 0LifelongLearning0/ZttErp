package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttProcessproduct;

/**
* 机械加工工艺过程表 
* 2018-04-24 14:27:01  季建吉
*/
public interface ZttProcessproductService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttProcessproduct> getZttProcessproductListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttProcessproduct getZttProcessproductById(String id);
	/**
	* 添加
	* @param ztt_processproduct 
	* @return
	*/
	public int addZttProcessproduct(ZttProcessproduct zttProcessproduct);
	/**
	* 修改
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproduct(ZttProcessproduct zttProcessproduct);
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproductBySelective(ZttProcessproduct zttProcessproduct);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttProcessproduct(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_processproductList 
	* @return
	*/
	public int addBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList);
	/**
	* 批量修改
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproductBySelective(List<ZttProcessproduct> zttProcessproductList);
	/**
	* 根据外键删除
	* @param parentId
	* @return
	*/
	public int delZttProcessproductByForeignKey(String parentId);
}
