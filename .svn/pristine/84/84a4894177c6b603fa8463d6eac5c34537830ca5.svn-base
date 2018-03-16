package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutTimeDao;
import jehc.zxmodules.model.ZxOutTime;

/**
* 外协分批到货管理 
* 2017-11-03 09:08:36  陈运芝
*/
@Repository("zxOutTimeDao")
public class ZxOutTimeDaoImpl  extends BaseDaoImpl implements ZxOutTimeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOutTime> getZxOutTimeListByCondition(Map<String,Object> condition){
		return (List<ZxOutTime>)this.getList("getZxOutTimeListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutTime getZxOutTimeById(String id){
		return (ZxOutTime)this.get("getZxOutTimeById", id);
	}
	/**
	* 添加
	* @param zx_out_time 
	* @return
	*/
	public int addZxOutTime(ZxOutTime zxOutTime){
		return this.add("addZxOutTime", zxOutTime);
	}
	/**
	* 修改
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTime(ZxOutTime zxOutTime){
		return this.update("updateZxOutTime", zxOutTime);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTimeBySelective(ZxOutTime zxOutTime){
		return this.update("updateZxOutTimeBySelective", zxOutTime);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutTime(Map<String,Object> condition){
		return this.del("delZxOutTime", condition);
	}
	/**
	* 批量添加
	* @param zx_out_timeList 
	* @return
	*/
	public int addBatchZxOutTime(List<ZxOutTime> zxOutTimeList){
		return this.add("addBatchZxOutTime", zxOutTimeList);
	}
	/**
	* 批量修改
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTime(List<ZxOutTime> zxOutTimeList){
		return this.update("updateBatchZxOutTime", zxOutTimeList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTimeBySelective(List<ZxOutTime> zxOutTimeList){
		return this.update("updateBatchZxOutTimeBySelective", zxOutTimeList);
	}
	/**
	* 根据外键删除方法
	* @param outsource_id
	* @return
	*/
	public int delZxOutTimeByForeignKey(String outsource_id){
		return this.del("delZxOutTimeByForeignKey", outsource_id);
	}
}
