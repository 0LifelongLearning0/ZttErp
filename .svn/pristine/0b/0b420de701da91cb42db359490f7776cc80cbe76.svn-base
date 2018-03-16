package jehc.zxmodules.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.SysContanst;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtmodel.XtQuartz;
import jehc.xtmodules.xtservice.XtQuartzService;
import jehc.zxmodules.dao.ZxScheduleDayDao;
import jehc.zxmodules.model.ZxPeriodTransaction;
import jehc.zxmodules.model.ZxScheduleDay;
import jehc.zxmodules.service.ZxScheduleDayService;

/**
* 单个日程 
* 2017-11-21 08:52:25  袁天宇
*/
@Service("zxScheduleDayService")
public class ZxScheduleDayServiceImpl extends BaseService implements ZxScheduleDayService{
	@Autowired
	private ZxScheduleDayDao zxScheduleDayDao;
	@Autowired
	private XtQuartzService xtQuartzService;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxScheduleDay> getZxScheduleDayListByCondition(Map<String,Object> condition){
		try{
			return zxScheduleDayDao.getZxScheduleDayListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxScheduleDay getZxScheduleDayById(String id){
		try{
			ZxScheduleDay zxScheduleDay = zxScheduleDayDao.getZxScheduleDayById(id);
			return zxScheduleDay;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_schedule_day 
	* @return
	*/
	public int addZxScheduleDay(ZxScheduleDay zxScheduleDay){
		int i = 0;
		try {
			i = zxScheduleDayDao.addZxScheduleDay(zxScheduleDay);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDay(ZxScheduleDay zxScheduleDay){
		int i = 0;
		try {
			i = zxScheduleDayDao.updateZxScheduleDay(zxScheduleDay);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDayByPeriodTransactionId(ZxScheduleDay zxScheduleDay){
		int i = 0;
		try {
			i = zxScheduleDayDao.updateZxScheduleDay(zxScheduleDay);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_schedule_day 
	* @return
	*/
	public int updateZxScheduleDayBySelective(ZxScheduleDay zxScheduleDay){
		int i = 0;
		try {
			i = zxScheduleDayDao.updateZxScheduleDayBySelective(zxScheduleDay);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxScheduleDay(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxScheduleDayDao.delZxScheduleDay(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_schedule_dayList 
	* @return
	*/
	public int addBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList){
		int i = 0;
		try {
			i = zxScheduleDayDao.addBatchZxScheduleDay(zxScheduleDayList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDay(List<ZxScheduleDay> zxScheduleDayList){
		int i = 0;
		try {
			i = zxScheduleDayDao.updateBatchZxScheduleDay(zxScheduleDayList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_schedule_dayList 
	* @return
	*/
	public int updateBatchZxScheduleDayBySelective(List<ZxScheduleDay> zxScheduleDayList){
		int i = 0;
		try {
			i = zxScheduleDayDao.updateBatchZxScheduleDayBySelective(zxScheduleDayList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	@Override
	public List<ZxScheduleDay> getZxScheduleDayListByConditionTransaction(Map<String, Object> condition) {
		try{
			return zxScheduleDayDao.getZxScheduleDayListByConditionTransaction(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	 * 根据事务外键删除
	 * @param condition
	 * @return
	 */
	public int delZxScheduleDayByForeignKey(String period_transaction_id){
		int i = 0;
		try {
			i = zxScheduleDayDao.delZxScheduleDayByForeignKey(period_transaction_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}

	/**
	 * 批量添加单日日程
	 */
	public void addBatchScheduleDay(Date begin_date,Date end_date,String type,String day,String week,ZxScheduleDay zsd){
		if(begin_date.compareTo(end_date)>0){
			return ;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin_date);
		boolean result = false;
		if(type.equals("1")){//按天
			result =true;
		}else if(type.equals("2")){//按周
			if(cal.get(Calendar.DAY_OF_WEEK)==Integer.parseInt(week)){
				result =true;
			}
		}else if(type.equals("3")){//按月
			if(cal.get(Calendar.DAY_OF_MONTH)==Integer.parseInt(day)){
				result =true;
			}
		}else{//按工作日
			if(cal.get(Calendar.DAY_OF_WEEK)!=1&&cal.get(Calendar.DAY_OF_WEEK)!=7){
				result =true;
			}
		}
		if(result){
			zsd.setDate(sdf.format(begin_date));
			zsd.setId(UUID.toUUID());
			addZxScheduleDay(zsd);
			if(zsd.getTransaction_remind().equals("1")){
				addQuartz(zsd);
			}
		}
		cal.add(Calendar.DAY_OF_MONTH, 1);// +1天
		begin_date = cal.getTime();
		addBatchScheduleDay(begin_date, end_date, type, day, week,zsd);
	}
	
	/**
	 * 批量修改单日日程
	 * @param list
	 * @throws SchedulerException 
	 * @throws ParseException 
	 */
	public void updateScheduleDay(ZxPeriodTransaction oldPeriod,ZxPeriodTransaction newPeriod,String type,String day,String week) throws SchedulerException, ParseException{
		// 四个时间
		Date oldBegin = sdf.parse(oldPeriod.getBegin_date());
		Date oldEnd = sdf.parse(oldPeriod.getEnd_date());
		Date newBegin = sdf.parse(newPeriod.getBegin_date());
		Date newEnd = sdf.parse(newPeriod.getEnd_date());
		ZxScheduleDay zxScheduleDay = getScheduleDay(newPeriod);
		Calendar cal = Calendar.getInstance();
		// 修改
		if(newBegin.compareTo(oldBegin)<0&&newEnd.compareTo(oldEnd)>0){//外包含
			cal.setTime(oldBegin);
			addBatchScheduleDay(newBegin, oldBegin, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(),zxScheduleDay);
			updateBatchScheduleDay(oldBegin, oldEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(), zxScheduleDay);
			cal.setTime(oldEnd);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			oldEnd = cal.getTime();
			addBatchScheduleDay(oldEnd, newEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(),zxScheduleDay);
		}else if(newBegin.compareTo(oldBegin)<0&&newEnd.compareTo(oldBegin)>0&&newEnd.compareTo(oldEnd)<=0){//左交叉
			cal.setTime(oldBegin);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			oldBegin = cal.getTime();
			addBatchScheduleDay(newBegin, oldBegin, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(),zxScheduleDay);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			oldBegin = cal.getTime();
			updateBatchScheduleDay(oldBegin, newEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(), zxScheduleDay);
			cal.setTime(newEnd);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			newEnd = cal.getTime();
			delScheduleDay(newPeriod, newEnd, oldEnd);
		}else if(newBegin.compareTo(oldBegin)>=0&&newBegin.compareTo(oldEnd)<0&&newEnd.compareTo(oldEnd)>0){//右交叉
			cal.setTime(newBegin);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			newBegin = cal.getTime();
			delScheduleDay(newPeriod, oldBegin, newBegin);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			newBegin = cal.getTime();
			updateBatchScheduleDay(newBegin, oldEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(), zxScheduleDay);
			cal.setTime(oldEnd);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			oldEnd = cal.getTime();
			addBatchScheduleDay(oldEnd, newEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(),zxScheduleDay);
		}else if(newBegin.compareTo(oldBegin)>=0&&newEnd.compareTo(oldEnd)<=0){//内包含
			cal.setTime(newBegin);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			newBegin = cal.getTime();
			delScheduleDay(newPeriod, oldBegin, newBegin);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			newBegin = cal.getTime();
			updateBatchScheduleDay(newBegin, newEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(), zxScheduleDay);
			cal.setTime(newEnd);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			newEnd = cal.getTime();
			delScheduleDay(newPeriod, newEnd, oldEnd);
		}else{//外边
			delScheduleDay(newPeriod, oldBegin, oldEnd);
			
			addBatchScheduleDay(newBegin, newEnd, newPeriod.getRepetition_type(),newPeriod.getRemind_day(),newPeriod.getRepetition_week(),zxScheduleDay);
		}
	}
	/**
	 * 修改周期性事务下的单日任务
	 * @param list
	 * @throws SchedulerException 
	 */
	public void updateBatchScheduleDay(Date begin_date,Date end_date,String type,String day,String week,ZxScheduleDay zsd){
		if(begin_date.compareTo(end_date)>0){
			return ;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin_date);
		boolean result = false;
		if(type.equals("1")){//按天
			result =true;
		}else if(type.equals("2")){//按周
			if(cal.get(Calendar.DAY_OF_WEEK)==Integer.parseInt(week)){
				result =true;
			}
		}else if(type.equals("3")){//按月
			if(cal.get(Calendar.DAY_OF_MONTH)==Integer.parseInt(day)){
				result =true;
			}
		}else{//按工作日
			if(cal.get(Calendar.DAY_OF_WEEK)!=1&&cal.get(Calendar.DAY_OF_WEEK)!=7){
				result =true;
			}
		}
		if(result){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("period_transaction_id",zsd.getPeriod_transaction_id());
			condition.put("date", sdf.format(begin_date));
			List<ZxScheduleDay> list = getZxScheduleDayListByConditionTransaction(condition);//一个事务下的根据条件查的单日数据    
			zsd.setDate(sdf.format(begin_date));
			if(null != list && list.size() > 0){
				zsd.setId(list.get(0).getId());
				updateZxScheduleDay(zsd);
			}else{
				zsd.setId(UUID.toUUID());
				addZxScheduleDay(zsd);
			}
			if(zsd.getTransaction_remind().equals("1")){
				updateQuartz(zsd);
			}
		}
		cal.add(Calendar.DAY_OF_MONTH, 1);// +1天
		begin_date = cal.getTime();
		updateBatchScheduleDay(begin_date, end_date, type, day, week,zsd);
	}
	/**
	 * 删除
	 * @throws SchedulerException 
	 */
	public void delScheduleDay(ZxPeriodTransaction zxPeriodTransaction,Date begin_date,Date end_date) throws SchedulerException{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("period_transaction_id",zxPeriodTransaction.getId());
		condition.put("begin_date", sdf.format(begin_date));
		condition.put("end_date", sdf.format(end_date));
		List<ZxScheduleDay> list = getZxScheduleDayListByConditionTransaction(condition);//
		if(null != list && list.size() > 0){
			Map<String, Object> condition1 = new HashMap<String, Object>();
			String[] days = new String[list.size()];
			for(int i=0;i<list.size();i++){
				days[i] =  list.get(i).getId();
			}
			condition1.put("id",days);
			delZxScheduleDay(condition1);
		}
		for(int a=0;a<list.size();a++){
			delQuartz(list.get(a).getId());
		}
	}
	/**
	 * 添加定时提醒
	 */
	public void addQuartz(ZxScheduleDay zxScheduleDay){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = zxScheduleDay.getDate()+" "+zxScheduleDay.getBegin_time();
			Date d = sdf.parse(str);
			Calendar c = Calendar.getInstance();
			long remind_day = Long.parseLong(zxScheduleDay.getRemind_day())*24*60*60*1000;
			long remind_hour = Long.parseLong(zxScheduleDay.getRemind_hour())*60*60*1000; 
			long remind_minute = Long.parseLong(zxScheduleDay.getRemind_minute())*60*1000;
			long num = remind_day+remind_hour+remind_minute;
			c.setTimeInMillis(d.getTime()-num);
			int minute = c.get(Calendar.MINUTE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH)+1;
			int year = c.get(Calendar.YEAR);
			XtQuartz xtQuartz =new XtQuartz();
			xtQuartz.setId(UUID.toUUID());
			xtQuartz.setJobId(SysContanst.ScheduleJobId+"&N" + zxScheduleDay.getId());
			xtQuartz.setJobName(SysContanst.ScheduleJobName + "@N" + zxScheduleDay.getId());
			xtQuartz.setJobGroup(SysContanst.ScheduleJobGroup);
			xtQuartz.setJobStatus("NORMAL");
			xtQuartz.setTargetClass(SysContanst.ScheduleJobClass);
			xtQuartz.setTargetMethod(SysContanst.ScheduleJobMethed);
			xtQuartz.setDesc_("日程提醒");
			xtQuartz.setCronExpression("0 " + minute + " " + hour + " " + day + " " + month + " ? " + year);
			xtQuartzService.addXtQuartz(xtQuartz);
			xtQuartzService.addJob(xtQuartz);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改定时提醒
	 */
	public void updateQuartz(ZxScheduleDay zxScheduleDay){
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("jobId", SysContanst.ScheduleJobId+"&N"+zxScheduleDay.getId());
			List<XtQuartz> xtQuartzList = xtQuartzService.getXtQuartzListAllByCondition(condition);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = zxScheduleDay.getDate()+" "+zxScheduleDay.getBegin_time();
			Date d = sdf.parse(str);
			Calendar c = Calendar.getInstance();
			long remind_day = Long.parseLong(zxScheduleDay.getRemind_day())*24*60*60*1000;
			long remind_hour = Long.parseLong(zxScheduleDay.getRemind_hour())*60*60*1000; 
			long remind_minute = Long.parseLong(zxScheduleDay.getRemind_minute())*60*1000;
			long num = remind_day+remind_hour+remind_minute;
			c.setTimeInMillis(d.getTime()-num);
			int minute = c.get(Calendar.MINUTE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH)+1;
			int year = c.get(Calendar.YEAR);
			XtQuartz xtQuartz =null;
			if(null != xtQuartzList && xtQuartzList.size() > 0){//修改定时任务
					xtQuartz = xtQuartzList.get(0);
					xtQuartz.setCronExpression("0 " + minute + " " + hour + " " + day + " " + month + " ? " + year);
					xtQuartzService.updateXtQuartz(xtQuartz);
					//先删除JOB，再添加新的JOB
					Scheduler scheduler = schedulerFactoryBean.getScheduler();
					JobKey jobKey = JobKey.jobKey(xtQuartz.getJobName(), xtQuartz.getJobGroup());
					if(null != jobKey){
						scheduler.deleteJob(jobKey);
					}
			}else{//新增定时任务
				xtQuartz = new XtQuartz();
				xtQuartz.setCronExpression("0 " + minute + " " + hour + " " + day + " " + month + " ? " + year);
				xtQuartz.setId(UUID.toUUID());
				xtQuartz.setJobId(SysContanst.ScheduleJobId+"&N" + zxScheduleDay.getId());
				xtQuartz.setJobGroup(SysContanst.ScheduleJobGroup);
				xtQuartz.setJobStatus("NORMAL");
				xtQuartz.setJobName(SysContanst.ScheduleJobName  + "@N" + zxScheduleDay.getId());
				xtQuartz.setTargetClass(SysContanst.ScheduleJobClass);
				xtQuartz.setTargetMethod(SysContanst.ScheduleJobMethed);
				xtQuartz.setDesc_("日程提醒");
				xtQuartzService.addXtQuartz(xtQuartz);
			}
			xtQuartzService.addJob(xtQuartz);
		} catch (SchedulerException | ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除定时提醒
	 * @param dayId
	 * @throws SchedulerException
	 */
	public void delQuartz(String dayId) throws SchedulerException{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("jobId", SysContanst.ScheduleJobId+"&N" + dayId);
		List<XtQuartz> xtQuartzList  = xtQuartzService.getXtQuartzListAllByCondition(condition);
		if(xtQuartzList.size()>0&&!xtQuartzList.isEmpty()){//存在  则删除
			XtQuartz xtQuartz = xtQuartzList.get(0);
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(xtQuartz.getJobName(), xtQuartz.getJobGroup());
			if(null != jobKey){
				scheduler.deleteJob(jobKey);//删除job
			}
			String[] ids = new String[xtQuartzList.size()];
	    	for(int a=0;a<xtQuartzList.size();a++){
	    		ids[a] = xtQuartzList.get(a).getId();
	    	}
	    	condition.put("id",ids);
	    	xtQuartzService.delXtQuartz(condition);//删定时任务
		}
	}

	/**
	 * 获取scheduleDay对象
	 */
	public ZxScheduleDay getScheduleDay(ZxPeriodTransaction zxPeriodTransaction){
		ZxScheduleDay zxScheduleDay = new ZxScheduleDay();
		zxScheduleDay.setBegin_time(zxPeriodTransaction.getBegin_time());
		zxScheduleDay.setEnd_time(zxPeriodTransaction.getEnd_time());
		zxScheduleDay.setRemark(zxPeriodTransaction.getRemark());
		zxScheduleDay.setTransaction_content(zxPeriodTransaction.getTransaction_content());
		zxScheduleDay.setRemind_day(zxPeriodTransaction.getRemind_day());
		zxScheduleDay.setRemind_hour(zxPeriodTransaction.getRemind_hour());
		zxScheduleDay.setRemind_minute(zxPeriodTransaction.getRemind_minute());
		zxScheduleDay.setTransaction_remind(zxPeriodTransaction.getTransaction_remind());
		zxScheduleDay.setTransaction_type(zxPeriodTransaction.getTransaction_type());
		zxScheduleDay.setUser_id(zxPeriodTransaction.getUser_id());
		zxScheduleDay.setPeriod_transaction_id(zxPeriodTransaction.getId());
		return zxScheduleDay;
	}
}
