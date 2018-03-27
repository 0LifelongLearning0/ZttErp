package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttOrderbybuyDao;
import jehc.zxmodules.model.ZttOrderbybuy;

/**
* 外协单表 
* 2018-03-21 10:45:03  季建吉
*/
@Repository("zttOrderbybuyDao")
public class ZttOrderbybuyDaoImpl  extends BaseDaoImpl implements ZttOrderbybuyDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttOrderbybuy> getZttOrderbybuyListByCondition(Map<String,Object> condition){
		return (List<ZttOrderbybuy>)this.getList("getZttOrderbybuyListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrderbybuy getZttOrderbybuyById(String id){
		return (ZttOrderbybuy)this.get("getZttOrderbybuyById", id);
	}
	/**
	* 添加
	* @param ztt_orderbybuy 
	* @return
	*/
	public int addZttOrderbybuy(ZttOrderbybuy zttOrderbybuy){
		return this.add("addZttOrderbybuy", zttOrderbybuy);
	}
	/**
	* 修改
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuy(ZttOrderbybuy zttOrderbybuy){
		return this.update("updateZttOrderbybuy", zttOrderbybuy);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuyBySelective(ZttOrderbybuy zttOrderbybuy){
		return this.update("updateZttOrderbybuyBySelective", zttOrderbybuy);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrderbybuy(Map<String,Object> condition){
		return this.del("delZttOrderbybuy", condition);
	}
	/**
	* 批量添加
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int addBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList){
		return this.add("addBatchZttOrderbybuy", zttOrderbybuyList);
	}
	/**
	* 批量修改
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList){
		return this.update("updateBatchZttOrderbybuy", zttOrderbybuyList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuyBySelective(List<ZttOrderbybuy> zttOrderbybuyList){
		return this.update("updateBatchZttOrderbybuyBySelective", zttOrderbybuyList);
	}
}
