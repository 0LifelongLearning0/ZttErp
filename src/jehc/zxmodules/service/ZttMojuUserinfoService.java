package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttMojuUserinfo;

/**
* 模具部车间员工信息表 
* 2018-05-29 13:39:52  季建吉
*/
public interface ZttMojuUserinfoService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMojuUserinfo> getZttMojuUserinfoListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param xt_userinfo_id 
	* @return
	*/
	public ZttMojuUserinfo getZttMojuUserinfoById(String xt_userinfo_id);
	/**
	* 添加
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int addZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo);
	/**
	* 修改
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo);
	/**
	* 修改（根据动态条件）
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfoBySelective(ZttMojuUserinfo zttMojuUserinfo);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMojuUserinfo(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int addBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList);
	/**
	* 批量修改
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfoBySelective(List<ZttMojuUserinfo> zttMojuUserinfoList);
}
