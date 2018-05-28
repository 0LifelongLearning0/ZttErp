package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttMouldsDeivice;

/**
* 工序设备 
* 2018-05-24 16:46:19  季建吉
*/
public interface ZttMouldsDeiviceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMouldsDeivice> getZttMouldsDeiviceListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttMouldsDeivice getZttMouldsDeiviceById(String id);
	/**
	* 添加
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int addZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice);
	/**
	* 修改
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice);
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeiviceBySelective(ZttMouldsDeivice zttMouldsDeivice);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMouldsDeivice(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int addBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList);
	/**
	* 批量修改
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeiviceBySelective(List<ZttMouldsDeivice> zttMouldsDeiviceList);
	/**
	* 根据外键删除方法
	* @param gongxu_id
	* @return
	*/
	public int delZttMouldsDeiviceByForeignKey(String gongxu_id);
}
