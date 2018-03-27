package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttOrderbyselfDao;
import jehc.zxmodules.model.ZttOrderbyself;

/**
* 自制单表 
* 2018-03-20 17:26:52  季建吉
*/
@Repository("zttOrderbyselfDao")
public class ZttOrderbyselfDaoImpl  extends BaseDaoImpl implements ZttOrderbyselfDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttOrderbyself> getZttOrderbyselfListByCondition(Map<String,Object> condition){
		return (List<ZttOrderbyself>)this.getList("getZttOrderbyselfListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrderbyself getZttOrderbyselfById(String id){
		return (ZttOrderbyself)this.get("getZttOrderbyselfById", id);
	}
	/**
	* 添加
	* @param ztt_orderbyself 
	* @return
	*/
	public int addZttOrderbyself(ZttOrderbyself zttOrderbyself){
		return this.add("addZttOrderbyself", zttOrderbyself);
	}
	/**
	* 修改
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyself(ZttOrderbyself zttOrderbyself){
		return this.update("updateZttOrderbyself", zttOrderbyself);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyselfBySelective(ZttOrderbyself zttOrderbyself){
		return this.update("updateZttOrderbyselfBySelective", zttOrderbyself);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrderbyself(Map<String,Object> condition){
		return this.del("delZttOrderbyself", condition);
	}
	/**
	* 批量添加
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int addBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList){
		return this.add("addBatchZttOrderbyself", zttOrderbyselfList);
	}
	/**
	* 批量修改
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList){
		return this.update("updateBatchZttOrderbyself", zttOrderbyselfList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyselfBySelective(List<ZttOrderbyself> zttOrderbyselfList){
		return this.update("updateBatchZttOrderbyselfBySelective", zttOrderbyselfList);
	}
}
