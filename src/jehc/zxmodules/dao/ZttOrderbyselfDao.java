package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttOrderbyself;

/**
* 自制单表 
* 2018-03-20 17:26:52  季建吉
*/
public interface ZttOrderbyselfDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrderbyself> getZttOrderbyselfListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrderbyself getZttOrderbyselfById(String id);
	/**
	* 添加
	* @param ztt_orderbyself 
	* @return
	*/
	public int addZttOrderbyself(ZttOrderbyself zttOrderbyself);
	/**
	* 修改
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyself(ZttOrderbyself zttOrderbyself);
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyselfBySelective(ZttOrderbyself zttOrderbyself);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrderbyself(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int addBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList);
	/**
	* 批量修改
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyselfBySelective(List<ZttOrderbyself> zttOrderbyselfList);
}
