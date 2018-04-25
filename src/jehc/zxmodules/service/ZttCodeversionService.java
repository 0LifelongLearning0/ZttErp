package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttCodeversion;

/**
* 代码版本控制 
* 2018-04-17 12:58:09  季建吉
*/
public interface ZttCodeversionService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttCodeversion> getZttCodeversionListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttCodeversion getZttCodeversionById(String id);
	/**
	* 添加
	* @param ztt_codeversion 
	* @return
	*/
	public int addZttCodeversion(ZttCodeversion zttCodeversion);
	public ZttCodeversion getZttCodeversionByName(String searchname);
	/**
	* 修改
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversion(ZttCodeversion zttCodeversion);
	/**
	* 修改（根据动态条件）
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversionBySelective(ZttCodeversion zttCodeversion);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttCodeversion(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_codeversionList 
	* @return
	*/
	public int addBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList);
	/**
	* 批量修改
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversionBySelective(List<ZttCodeversion> zttCodeversionList);
}
