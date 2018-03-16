package jehc.xtmodules.xtcore.util.quartz.task;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.springutil.SpringUtil;
import jehc.xtmodules.xtmodel.XtMessage;
import jehc.xtmodules.xtservice.XtMessageService;
import jehc.zxmodules.model.ZxMeeting;
import jehc.zxmodules.model.ZxMeetingHouse;
import jehc.zxmodules.model.ZxMeetingUser;
import jehc.zxmodules.service.ZxMeetingHouseService;
import jehc.zxmodules.service.ZxMeetingService;
import jehc.zxmodules.service.ZxMeetingUserService;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
/**
 * 添加系统消息
 * @author Administrator
 *
 */
public class Xt_Message_Tishi_Task extends Thread{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String meeting_id = null;
	private String jobGroup = null;
	private String jobName = null;
	
	public Xt_Message_Tishi_Task() {
	}
	
	public Xt_Message_Tishi_Task(String jobId,String jobName,String jobGroup) {
		this.meeting_id = jobId;
		this.jobGroup = jobGroup;
		this.jobName = jobName;
	}
	/**
	 * 业务逻辑处理
	 */
	public void service(String jobId,String jobName,String jobGroup) {
		String[] ids = jobId.split("&N");
		if(null != ids&&ids.length > 1){
			this.meeting_id = ids[1];
			this.jobGroup = jobGroup;
			this.jobName = jobName;
			new Xt_Message_Tishi_Task(ids[1], jobName, jobGroup).start();
		}
	}
	
	public void run(){
		try {
			excute();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void excute() throws ParseException, SchedulerException{
		logger.info("----------开始检查是否有消息--------------");
		addMessage();
	}
	
	private void addMessage() throws ParseException, SchedulerException{
		String date = CommonUtils.getSimpleDateFormat();
		List<XtMessage> messages = new ArrayList<XtMessage>();

		ZxMeetingService zxMeetingService = (ZxMeetingService)SpringUtil.getBean("zxMeetingService");
		ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(this.meeting_id);
		if(zxMeeting.getState().equals("1")){
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("meeting_id", meeting_id);
			ZxMeetingUserService zxMeetingUserService = (ZxMeetingUserService)SpringUtil.getBean("zxMeetingUserService");
			List<ZxMeetingUser> users = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
			
			if(!users.isEmpty()){
				ZxMeetingHouseService zxMeetingHouseService = (ZxMeetingHouseService)SpringUtil.getBean("zxMeetingHouseService");
				ZxMeetingHouse zxMeetingHouse = zxMeetingHouseService.getZxMeetingHouseById(zxMeeting.getHouse_id());
				String msg = "会议【"+ zxMeeting.getTitle() +"】，将于"+ zxMeeting.getTime_start() +"开始,会议地点【"+ zxMeetingHouse.getHouse_name() +"】。";
				for(ZxMeetingUser user:users){
					XtMessage xtMessage = new XtMessage();
					xtMessage.setXt_message_id(UUID.toUUID());
					xtMessage.setFrom_id(zxMeeting.getUser_id());
					xtMessage.setTo_id(user.getUser_id());
					xtMessage.setXt_meesage_content(msg);
					xtMessage.setIsread("0");
					xtMessage.setCtime(date);
					messages.add(xtMessage);
				}
			}

			if(!messages.isEmpty()){
				XtMessageService xtMessageService = (XtMessageService)SpringUtil.getBean("xtMessageService");
				xtMessageService.addBatchXtMessage(messages);
			}
		}
		
		SchedulerFactoryBean schedulerFactoryBean = (SchedulerFactoryBean)SpringUtil.getBean("schedulerFactoryBean");
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(this.jobName, this.jobGroup);
	    scheduler.deleteJob(jobKey);
	}
}
