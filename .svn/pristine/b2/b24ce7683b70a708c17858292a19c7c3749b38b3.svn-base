package jehc.zxmodules.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.SysContanst;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtQuartz;
import jehc.xtmodules.xtservice.XtQuartzService;
import jehc.zxmodules.model.ZxPeriodTransaction;
import jehc.zxmodules.model.ZxScheduleDay;
import jehc.zxmodules.service.ZxPeriodTransactionService;
import jehc.zxmodules.service.ZxScheduleDayService;

/**
* 周期性事务 
* 2017-11-21 08:40:35  袁天宇
*/
@Controller
@RequestMapping("/zxPeriodTransactionController")
public class ZxPeriodTransactionController extends BaseAction{
	@Autowired
	private ZxPeriodTransactionService zxPeriodTransactionService;
	@Autowired
	private ZxScheduleDayService zxScheduleDayService;
	@Autowired
	private XtQuartzService xtQuartzService;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	/**
	* 载入初始化页面
	* @param zx_period_transaction 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-schedule/zx-period-transaction-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_period_transaction 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPeriodTransactionListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPeriodTransactionListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxPeriodTransaction> zxPeriodTransactionList = zxPeriodTransactionService.getZxPeriodTransactionListByCondition(condition);
		PageInfo<ZxPeriodTransaction> page = new PageInfo<ZxPeriodTransaction>(zxPeriodTransactionList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPeriodTransactionById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPeriodTransactionById(String id,HttpServletRequest request){
		ZxPeriodTransaction zxPeriodTransaction = zxPeriodTransactionService.getZxPeriodTransactionById(id);
		return outDataStr(zxPeriodTransaction);
	}
	/**
	* 添加
	* @param zx_period_transaction 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction,HttpServletRequest request) throws ParseException{
		int i = 0;
		ZxScheduleDay zxScheduleDay = new ZxScheduleDay();
		Date begin_date = sdf.parse(zxPeriodTransaction.getBegin_date());
		Date end_date = sdf.parse(zxPeriodTransaction.getEnd_date());
		if(null != zxPeriodTransaction && !"".equals(zxPeriodTransaction)){
			zxPeriodTransaction.setId(UUID.toUUID());
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
			i=zxPeriodTransactionService.addZxPeriodTransaction(zxPeriodTransaction);
			zxScheduleDayService.addBatchScheduleDay(begin_date,end_date,zxPeriodTransaction.getRepetition_type(),zxPeriodTransaction.getRepetition_day(),zxPeriodTransaction.getRepetition_week(),zxScheduleDay);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_period_transaction 
	* @param request 
	 * @throws ParseException 
	 * @throws SchedulerException 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxPeriodTransaction(ZxPeriodTransaction zxPeriodTransaction,HttpServletRequest request) throws ParseException, SchedulerException{
		int i = 0;
		if(null != zxPeriodTransaction && !"".equals(zxPeriodTransaction)){
			ZxPeriodTransaction old = zxPeriodTransactionService.getZxPeriodTransactionById(zxPeriodTransaction.getId());//没改前的事务数据
			zxScheduleDayService.updateScheduleDay(old, zxPeriodTransaction, zxPeriodTransaction.getTransaction_type(), zxPeriodTransaction.getRemind_day(), zxPeriodTransaction.getRepetition_week());
		}

		i=zxPeriodTransactionService.updateZxPeriodTransaction(zxPeriodTransaction);
		
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 删除
	* @param id 
	* @param request 
	 * @throws SchedulerException 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxPeriodTransaction(String id,HttpServletRequest request) throws SchedulerException{
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxPeriodTransactionService.delZxPeriodTransaction(condition);
			zxScheduleDayService.delZxScheduleDayByForeignKey(id);//删除事务id下的单日数据
		}
		Map<String, Object> condition1 = new HashMap<String, Object>();
		condition1.put("period_transaction_id", id);
		List<ZxScheduleDay> list = zxScheduleDayService.getZxScheduleDayListByCondition(condition1);//根据事务id差到的单日数据
		for(int a=0;a<list.size();a++){
			Map<String, Object> condition2 = new HashMap<String, Object>();
			condition2.put("jobId", SysContanst.ScheduleJobId+"&N" + list.get(a).getId());
			List<XtQuartz> xtQuartzList  = xtQuartzService.getXtQuartzListAllByCondition(condition2);
			if(xtQuartzList.size()>0&&!xtQuartzList.isEmpty()){//存在  则删除
				XtQuartz xtQuartz = xtQuartzList.get(0);
				Scheduler scheduler = schedulerFactoryBean.getScheduler();
				JobKey jobKey = JobKey.jobKey(xtQuartz.getJobName(), xtQuartz.getJobGroup());
				if(null != jobKey){
					scheduler.deleteJob(jobKey);//删除job
				}
				String[] ids = new String[xtQuartzList.size()];
		    	for(int b=0;b<xtQuartzList.size();b++){
		    		ids[b] = xtQuartzList.get(b).getId();
		    	}
		    	condition2.put("id",ids);
		    	xtQuartzService.delXtQuartz(condition2);//删定时任务
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 复制一行并生成记录
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/copyZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxPeriodTransaction(String id,HttpServletRequest request){
		int i = 0;
		ZxPeriodTransaction zxPeriodTransaction = zxPeriodTransactionService.getZxPeriodTransactionById(id);
		if(null != zxPeriodTransaction && !"".equals(zxPeriodTransaction)){
			zxPeriodTransaction.setId(UUID.toUUID());
			i=zxPeriodTransactionService.addZxPeriodTransaction(zxPeriodTransaction);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 导出
	* @param excleData 
	* @param excleHeader 
	* @param excleText 
	* @param request 
	* @param request 
	*/
	@RequestMapping(value="/exportZxPeriodTransaction",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxPeriodTransaction(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
}
