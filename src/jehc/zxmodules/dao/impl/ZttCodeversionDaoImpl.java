package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttCodeversionDao;
import jehc.zxmodules.model.ZttCodeversion;

/**
* 代码版本控制 
* 2018-04-17 12:58:09  季建吉
*/
@Repository("zttCodeversionDao")
public class ZttCodeversionDaoImpl  extends BaseDaoImpl implements ZttCodeversionDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttCodeversion> getZttCodeversionListByCondition(Map<String,Object> condition){
		return (List<ZttCodeversion>)this.getList("getZttCodeversionListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttCodeversion getZttCodeversionById(String id){
		return (ZttCodeversion)this.get("getZttCodeversionById", id);
	}
	public ZttCodeversion getZttCodeversionByName(String searchname){
		return (ZttCodeversion)this.get("getZttCodeversionByName", searchname);
	}
	/**
	* 添加
	* @param ztt_codeversion 
	* @return
	*/
	public int addZttCodeversion(ZttCodeversion zttCodeversion){
		return this.add("addZttCodeversion", zttCodeversion);
	}
	/**
	* 修改
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversion(ZttCodeversion zttCodeversion){
		return this.update("updateZttCodeversion", zttCodeversion);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversionBySelective(ZttCodeversion zttCodeversion){
		return this.update("updateZttCodeversionBySelective", zttCodeversion);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttCodeversion(Map<String,Object> condition){
		return this.del("delZttCodeversion", condition);
	}
	/**
	* 批量添加
	* @param ztt_codeversionList 
	* @return
	*/
	public int addBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList){
		return this.add("addBatchZttCodeversion", zttCodeversionList);
	}
	/**
	* 批量修改
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList){
		return this.update("updateBatchZttCodeversion", zttCodeversionList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversionBySelective(List<ZttCodeversion> zttCodeversionList){
		return this.update("updateBatchZttCodeversionBySelective", zttCodeversionList);
	}
}
