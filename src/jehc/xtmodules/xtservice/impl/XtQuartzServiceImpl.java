package jehc.xtmodules.xtservice.impl;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.quartz.QuartzJobFactory;
import jehc.xtmodules.xtcore.util.quartz.ScheduleJob;
import jehc.xtmodules.xtdao.XtQuartzDao;
import jehc.xtmodules.xtmodel.XtQuartz;
import jehc.xtmodules.xtservice.XtQuartzService;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
* 任务调度配置信息表 
* 2015-10-29 16:50:03  邓纯杰
*/
@Service("xtQuartzService")
public class XtQuartzServiceImpl extends BaseService implements XtQuartzService{
	@Autowired
	private XtQuartzDao xtQuartzDao;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<XtQuartz> getXtQuartzListByCondition(Map<String,Object> condition){
		try{
			return xtQuartzDao.getXtQuartzListByCondition(condition);
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
	public XtQuartz getXtQuartzById(String id){
		try{
			return xtQuartzDao.getXtQuartzById(id);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param xt_quartz 
	* @return
	*/
	public int addXtQuartz(XtQuartz xt_Quartz){
		int i = 0;
		try {
			i = xtQuartzDao.addXtQuartz(xt_Quartz);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param xt_quartz 
	* @return
	*/
	public int updateXtQuartz(XtQuartz xt_Quartz){
		int i = 0;
		try {
			i = xtQuartzDao.updateXtQuartz(xt_Quartz);
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
	public int delXtQuartz(Map<String,Object> condition){
		int i = 0;
		try {
			i = xtQuartzDao.delXtQuartz(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	 * 查找集合
	 * @param condition
	 * @return
	 */
	public List<XtQuartz> getXtQuartzListAllByCondition(Map<String,Object> condition){
		try{
			return xtQuartzDao.getXtQuartzListAllByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}

	public void addJob(XtQuartz xtQuartz){
		ScheduleJob job = new ScheduleJob();
		job.setJobId(xtQuartz.getJobId());
		job.setJobName(xtQuartz.getJobName());
		job.setJobGroup(xtQuartz.getJobGroup());
		job.setJobStatus(xtQuartz.getJobStatus());
		job.setTargetClass(xtQuartz.getTargetClass());
		job.setTargetMethod(xtQuartz.getTargetMethod());
		job.setDesc(xtQuartz.getDesc_());
		job.setCronExpression(xtQuartz.getCronExpression());
		try {
			addXtQuartzJob(job);
		} catch (IOException | SchedulerException e) {
			e.printStackTrace();
		}
	}
	public void addXtQuartzJob(ScheduleJob job) throws IOException, SchedulerException {
		try{
			//一定要紧跟Validate之后写验证结果类
			String seconds = job.getCronExpression();
			String cronExp = seconds;
			job.setCronExpression(cronExp);
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
			//获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			//不存在，创建一个
			if(null == trigger){
				JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class).withIdentity(job.getJobName(), job.getJobGroup()).build();
				jobDetail.getJobDataMap().put("scheduleJob", job);
				//表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
				//按新的cronExpression表达式构建一个新的trigger
				trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, trigger);
			}else{
				//Trigger已存在，那么更新相应的定时设置
				//表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
				//按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				//按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
