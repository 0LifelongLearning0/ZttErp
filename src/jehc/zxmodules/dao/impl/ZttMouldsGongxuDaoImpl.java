package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttMouldsGongxuDao;
import jehc.zxmodules.model.ZttMouldsGongxu;

/**
* 模具部工序 
* 2018-05-24 16:46:19  季建吉
*/
@Repository("zttMouldsGongxuDao")
public class ZttMouldsGongxuDaoImpl  extends BaseDaoImpl implements ZttMouldsGongxuDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttMouldsGongxu> getZttMouldsGongxuListByCondition(Map<String,Object> condition){
		return (List<ZttMouldsGongxu>)this.getList("getZttMouldsGongxuListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttMouldsGongxu getZttMouldsGongxuById(String id){
		return (ZttMouldsGongxu)this.get("getZttMouldsGongxuById", id);
	}
	/**
	* 添加
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int addZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu){
		return this.add("addZttMouldsGongxu", zttMouldsGongxu);
	}
	/**
	* 修改
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu){
		return this.update("updateZttMouldsGongxu", zttMouldsGongxu);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxuBySelective(ZttMouldsGongxu zttMouldsGongxu){
		return this.update("updateZttMouldsGongxuBySelective", zttMouldsGongxu);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMouldsGongxu(Map<String,Object> condition){
		return this.del("delZttMouldsGongxu", condition);
	}
	/**
	* 批量添加
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int addBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList){
		return this.add("addBatchZttMouldsGongxu", zttMouldsGongxuList);
	}
	/**
	* 批量修改
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList){
		return this.update("updateBatchZttMouldsGongxu", zttMouldsGongxuList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxuBySelective(List<ZttMouldsGongxu> zttMouldsGongxuList){
		return this.update("updateBatchZttMouldsGongxuBySelective", zttMouldsGongxuList);
	}
}
