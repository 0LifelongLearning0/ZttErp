package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxScheduleDayDao;
import jehc.zxmodules.model.ZxScheduleDay;

/**
* 单个日程 
* 2017-11-21 08:52:25  袁天宇
*/
@Repository("zxScheduleDayDao")
public class ZxScheduleDayDaoImpl  extends BaseDaoImpl implements ZxScheduleDayDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxScheduleDay> getZxScheduleDayListByCondition(Map<String,Object> condition){
		return (List<ZxScheduleDay>)this.getList("getZxScheduleDayListByCondition",condition);
	}
	/**
	 * 根据周期性事务的查询
	 * @param condition 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZxScheduleDay> getZxScheduleDayListByConditionTransaction(Map<String, Object> condition) {
		return (List<ZxScheduleDay>)this.getList("getZxScheduleDayListByConditionTransaction",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxScheduleDay getZxScheduleDayById(String id){
		return (ZxScheduleDay)this.get("getZxScheduleDayById", id);
	}
	/**
	* 添加
	* @param zx_schedule_day 
	* @return
	*/
	public int addZxScheduleDay(ZxScheduleDay zxScheduleDay){
		return this.add("addZxScheduleDay", zxScheduleDay);
	}
	/**
	* 修改
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDay(ZxScheduleDay zxScheduleDay){
		return this.update("updateZxScheduleDay", zxScheduleDay);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDayBySelective(ZxScheduleDay zxScheduleDay){
		return this.update("updateZxScheduleDayBySelective", zxScheduleDay);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxScheduleDay(Map<String,Object> condition){
		return this.del("delZxScheduleDay", condition);
	}
	public int delZxScheduleDayByCondition(Map<String,Object> condition){
		return this.del("delZxScheduleDayByCondition", condition);
	}
	/**
	 * 根据事务外键删除
	 * @param condition
	 * @return
	 */
	public int delZxScheduleDayByForeignKey(String period_transaction_id){
		return this.del("delZxScheduleDayByForeignKey", period_transaction_id);
	}
	
	/**
	* 批量添加
	* @param zx_schedule_dayList 
	* @return
	*/
	public int addBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList){
		return this.add("addBatchZxScheduleDay", zxScheduleDayList);
	}
	/**
	* 批量修改
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList){
		return this.update("updateBatchZxScheduleDay", zxScheduleDayList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDayBySelective(List<ZxScheduleDay> zxScheduleDayList){
		return this.update("updateBatchZxScheduleDayBySelective", zxScheduleDayList);
	}

}
