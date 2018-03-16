package jehc.zxmodules.service;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;

import jehc.zxmodules.model.ZxPeriodTransaction;
import jehc.zxmodules.model.ZxScheduleDay;

/**
* 单个日程 
* 2017-11-21 08:52:25  袁天宇
*/
public interface ZxScheduleDayService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxScheduleDay> getZxScheduleDayListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxScheduleDay getZxScheduleDayById(String id);
	/**
	 * 根据周期性事务的查询
	 * @param condition
	 * @return
	 */
	public List<ZxScheduleDay> getZxScheduleDayListByConditionTransaction(Map<String,Object> condition);
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
	* 修改
	* @param zx_schedule_day    事务id
	* @return
	*/
	public int updateZxScheduleDayByPeriodTransactionId(ZxScheduleDay zxScheduleDay);
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
	/**
	 * 根据事务外键删除
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
	/**
	 * 批量添加单日日程
	 */
	public void addBatchScheduleDay(Date begin_date,Date end_date,String type,String day,String week,ZxScheduleDay zsd);
	/**
	 * 批量修改单日日程
	 * @throws ParseException 
	 * @throws SchedulerException 
	 */
	public void updateScheduleDay(ZxPeriodTransaction oldPeriod,ZxPeriodTransaction newPeriod,String type,String day,String week) throws SchedulerException, ParseException ;

	/**
	 * 添加定时提醒
	 */
	public void addQuartz(ZxScheduleDay zxScheduleDay);

	/**
	 * 修改定时提醒
	 */
	public void updateQuartz(ZxScheduleDay zxScheduleDay);
	
	/**
	 * 删除定时提醒
	 * @param dayId
	 * @throws SchedulerException
	 */
	public void delQuartz(String dayId) throws SchedulerException;
}
