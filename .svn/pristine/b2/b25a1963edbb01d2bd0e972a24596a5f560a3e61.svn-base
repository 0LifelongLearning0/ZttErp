package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxBuyTimeDao;
import jehc.zxmodules.model.ZxBuyTime;

/**
* 采购分批到货 
* 2017-11-01 11:15:47  陈运芝
*/
@Repository("zxBuyTimeDao")
public class ZxBuyTimeDaoImpl  extends BaseDaoImpl implements ZxBuyTimeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxBuyTime> getZxBuyTimeListByCondition(Map<String,Object> condition){
		return (List<ZxBuyTime>)this.getList("getZxBuyTimeListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxBuyTime getZxBuyTimeById(String id){
		return (ZxBuyTime)this.get("getZxBuyTimeById", id);
	}
	/**
	* 添加
	* @param zx_buy_time 
	* @return
	*/
	public int addZxBuyTime(ZxBuyTime zxBuyTime){
		return this.add("addZxBuyTime", zxBuyTime);
	}
	/**
	* 修改
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTime(ZxBuyTime zxBuyTime){
		return this.update("updateZxBuyTime", zxBuyTime);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_time 
	* @return
	*/
	public int updateZxBuyTimeBySelective(ZxBuyTime zxBuyTime){
		return this.update("updateZxBuyTimeBySelective", zxBuyTime);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxBuyTime(Map<String,Object> condition){
		return this.del("delZxBuyTime", condition);
	}
	/**
	* 批量添加
	* @param zx_buy_timeList 
	* @return
	*/
	public int addBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList){
		return this.add("addBatchZxBuyTime", zxBuyTimeList);
	}
	/**
	* 批量修改
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTime(List<ZxBuyTime> zxBuyTimeList){
		return this.update("updateBatchZxBuyTime", zxBuyTimeList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_timeList 
	* @return
	*/
	public int updateBatchZxBuyTimeBySelective(List<ZxBuyTime> zxBuyTimeList){
		return this.update("updateBatchZxBuyTimeBySelective", zxBuyTimeList);
	}
	/**
	* 根据外键删除方法
	* @param buy_id
	* @return
	*/
	public int delZxBuyTimeByForeignKey(String buy_id){
		return this.del("delZxBuyTimeByForeignKey", buy_id);
	}
}
