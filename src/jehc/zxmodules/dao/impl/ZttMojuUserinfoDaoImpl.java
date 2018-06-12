package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttMojuUserinfoDao;
import jehc.zxmodules.model.ZttMojuUserinfo;

/**
* 模具部车间员工信息表 
* 2018-05-29 13:39:52  季建吉
*/
@Repository("zttMojuUserinfoDao")
public class ZttMojuUserinfoDaoImpl  extends BaseDaoImpl implements ZttMojuUserinfoDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttMojuUserinfo> getZttMojuUserinfoListByCondition(Map<String,Object> condition){
		return (List<ZttMojuUserinfo>)this.getList("getZttMojuUserinfoListByCondition",condition);
	}
	/**
	* 查询对象
	* @param xt_userinfo_id 
	* @return
	*/
	public ZttMojuUserinfo getZttMojuUserinfoById(String xt_userinfo_id){
		return (ZttMojuUserinfo)this.get("getZttMojuUserinfoById", xt_userinfo_id);
	}
	/**
	* 添加
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int addZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo){
		return this.add("addZttMojuUserinfo", zttMojuUserinfo);
	}
	/**
	* 修改
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo){
		return this.update("updateZttMojuUserinfo", zttMojuUserinfo);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfoBySelective(ZttMojuUserinfo zttMojuUserinfo){
		return this.update("updateZttMojuUserinfoBySelective", zttMojuUserinfo);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMojuUserinfo(Map<String,Object> condition){
		return this.del("delZttMojuUserinfo", condition);
	}
	/**
	* 批量添加
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int addBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList){
		return this.add("addBatchZttMojuUserinfo", zttMojuUserinfoList);
	}
	/**
	* 批量修改
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList){
		return this.update("updateBatchZttMojuUserinfo", zttMojuUserinfoList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfoBySelective(List<ZttMojuUserinfo> zttMojuUserinfoList){
		return this.update("updateBatchZttMojuUserinfoBySelective", zttMojuUserinfoList);
	}
}
