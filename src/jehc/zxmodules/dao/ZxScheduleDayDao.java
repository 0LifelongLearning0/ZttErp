package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxScheduleDay;

/**
* 单个日程 
* 2017-11-21 08:52:25  袁天宇
*/
public interface ZxScheduleDayDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxScheduleDay> getZxScheduleDayListByCondition(Map<String,Object> condition);
	/**
	 * 根据周期性事务的查询
	 * @param condition
	 * @return
	 */
	public List<ZxScheduleDay> getZxScheduleDayListByConditionTransaction(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxScheduleDay getZxScheduleDayById(String id);
	/**
	* 添加
	* @param zx_schedule_day 
	* @return
	*/
	public int addZxScheduleDay(ZxScheduleDay zxScheduleDay);
	/**
	* 修改
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDay(ZxScheduleDay zxScheduleDay);
	/**
	* 修改（根据动态条件）
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDayBySelective(ZxScheduleDay zxScheduleDay);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	
	public int delZxScheduleDay(Map<String,Object> condition);
	
	public int delZxScheduleDayByCondition(Map<String,Object> condition);
	/**
	 * 根据事务id删除
	 * @param condition
	 * @return
	 */
	public int delZxScheduleDayByForeignKey(String period_transaction_id);
	/**
	* 批量添加
	* @param zx_schedule_dayList 
	* @return
	*/
	public int addBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList);
	/**
	* 批量修改
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDayBySelective(List<ZxScheduleDay> zxScheduleDayList);
}
