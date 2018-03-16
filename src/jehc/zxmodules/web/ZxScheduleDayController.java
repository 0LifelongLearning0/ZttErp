package jehc.zxmodules.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import jehc.zxmodules.service.ZxScheduleDayService;

/**
* 单个日程 
* 2017-11-21 08:52:25  袁天宇
*/
@Controller
@RequestMapping("/zxScheduleDayController")
public class ZxScheduleDayController extends BaseAction{
	@Autowired
	private ZxScheduleDayService zxScheduleDayService;
	@Autowired
	private XtQuartzService xtQuartzService;
	
	/**
	* 载入初始化页面
	* @param zx_schedule_day 
	* @param request   
	* @return  
	* @throws ParseException 
	*/
	@RequestMapping(value="/loadZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxScheduleDay(HttpServletRequest request,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> condition = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date begin_date = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date end_date = cal.getTime();
	//	condition.put("user_id",);
		condition.put("begin_date", sdf.format(begin_date));
		condition.put("end_date", sdf.format(end_date));
		List<ZxScheduleDay> zxScheduleDaylist = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
		model.addAttribute("zxScheduleDaylist",outItemsStr(zxScheduleDaylist));
		return new ModelAndView("pc/zx-view/zx-schedule-day/zx-my-schedule");
	}
	/**
	* 上下月页面
	* @param zx_schedule_day 
	* @param request   
	* @return  
	* @throws ParseException 
	*/
	@RequestMapping(value="/toLoadZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toLoadZxScheduleDay(String year,String month,HttpServletRequest request,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> condition = new HashMap<String, Object>();
		String str = year+"-"+month+"-01";
		Date begin_date = sdf.parse(str);
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin_date);  
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        Date end_date = cal.getTime();  
	//	condition.put("user_id",);
		condition.put("begin_date", sdf.format(begin_date));
		condition.put("end_date", sdf.format(end_date));
		List<ZxScheduleDay> zxScheduleDaylist = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
		model.addAttribute("zxScheduleDaylist",outItemsStr(zxScheduleDaylist));
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		return new ModelAndView("pc/zx-view/zx-schedule-day/zx-my-schedule");
	}
	@RequestMapping(value="/loadZxScheduleDayByDateType",method={RequestMethod.POST,RequestMethod.GET})
	public String loadZxScheduleDayByDateType(HttpServletRequest request,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> condition = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		String type = request.getParameter("type");
		List<ZxScheduleDay> zxScheduleDaylist = new ArrayList<>();
			if(type.equals("2")){//按周
				cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				Date begin_date = cal.getTime();
				cal.setTime(begin_date);
				cal.add(Calendar.DAY_OF_WEEK, 7);
				Date end_date = cal.getTime();
				condition.put("begin_date", sdf.format(begin_date));
				condition.put("end_date", sdf.format(end_date));
				zxScheduleDaylist = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
				return outItemsStr(zxScheduleDaylist);
			}else if(type.equals("3")){//按日
				condition.put("date", sdf.format(cal.getTime()));
				zxScheduleDaylist = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
				return outDataStr(zxScheduleDaylist.get(0));
			}else{//按月
				cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
				cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
				Date begin_date = cal.getTime();
				cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
				Date end_date = cal.getTime();
				condition.put("begin_date", sdf.format(begin_date));
				condition.put("end_date", sdf.format(end_date));
				zxScheduleDaylist = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
				return outItemsStr(zxScheduleDaylist);
			}
	}
	/**  
	* 加载初始化列表数据并分页
	* @param zx_schedule_day 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxScheduleDayListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxScheduleDayListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxScheduleDay> zxScheduleDayList = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
		PageInfo<ZxScheduleDay> page = new PageInfo<ZxScheduleDay>(zxScheduleDayList);
		return outPageBootStr(page,request);
	}

	/**  
	* 根据时间加载列表数据
	* @param year 
	* @param month 
	* @param zx_schedule_day 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxScheduleDayLists",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxScheduleDayList(String year,String month,HttpServletRequest request) throws ParseException{
		Map<String, Object> condition = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month)-1,1,0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date begin_date = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date end_date = cal.getTime();
		condition.put("begin_date",sdf.format(begin_date));
		condition.put("end_date",sdf.format(end_date));
		List<ZxScheduleDay> zxScheduleDayList = zxScheduleDayService.getZxScheduleDayListByCondition(condition);
		return outItemsStr(zxScheduleDayList);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxScheduleDayById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxScheduleDayById(String id,HttpServletRequest request){
		ZxScheduleDay zxScheduleDay = zxScheduleDayService.getZxScheduleDayById(id);
		
		return outDataStr(zxScheduleDay);
	}
	/**
	* 添加
	* @param zx_schedule_day 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxScheduleDay(ZxScheduleDay zxScheduleDay,HttpServletRequest request){
		int i = 0;
		if(null != zxScheduleDay && !"".equals(zxScheduleDay)){
			zxScheduleDay.setUser_id(getXtUid());
			zxScheduleDay.setId(UUID.toUUID());
			i=zxScheduleDayService.addZxScheduleDay(zxScheduleDay);
		}
		if(i>0){
			if(zxScheduleDay.getTransaction_remind().equals("1")){
				zxScheduleDayService.addQuartz(zxScheduleDay);
			}
		}
		return "{success:" + (i>0?true:false) + ",msg:'"+(i>0?"操作成功":"操作失败")+"',responseFlag:true}";
	}
	/**
	* 修改
	* @param zx_schedule_day 
	* @param request 
	 * @throws SchedulerException 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxScheduleDay(ZxScheduleDay zxScheduleDay,HttpServletRequest request) throws SchedulerException{
		int i = 0;
		if(null != zxScheduleDay && !"".equals(zxScheduleDay)){
			i=zxScheduleDayService.updateZxScheduleDayBySelective(zxScheduleDay);
		}
		if(i>0){
			if(zxScheduleDay.getTransaction_remind().equals("1")){//提醒
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("jobId", SysContanst.ScheduleJobId+"&N" + zxScheduleDay.getId());
				List<XtQuartz> xtQuartzList  = xtQuartzService.getXtQuartzListAllByCondition(condition);
				if(xtQuartzList.size()>0&&!xtQuartzList.isEmpty()){//存在则修改
					zxScheduleDayService.updateQuartz(zxScheduleDay);
				}else{//不存在则添加
					zxScheduleDayService.addQuartz(zxScheduleDay);
				}
			}else{//不提醒
				zxScheduleDayService.delQuartz( zxScheduleDay.getId());
			}
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
	@RequestMapping(value="/delZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxScheduleDay(String id,HttpServletRequest request) throws SchedulerException{
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxScheduleDayService.delZxScheduleDay(condition);
		}
		if(i>0){
			zxScheduleDayService.delQuartz(id);
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
	@RequestMapping(value="/copyZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxScheduleDay(String id,HttpServletRequest request){
		int i = 0;
		ZxScheduleDay zxScheduleDay = zxScheduleDayService.getZxScheduleDayById(id);
		if(null != zxScheduleDay && !"".equals(zxScheduleDay)){
			zxScheduleDay.setId(UUID.toUUID());
			i=zxScheduleDayService.addZxScheduleDay(zxScheduleDay);
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
	@RequestMapping(value="/exportZxScheduleDay",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxScheduleDay(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxScheduleDayAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxScheduleDayAdd(ZxScheduleDay zxScheduleDay,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-schedule-day/zx-schedule-day-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxScheduleDayUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxScheduleDayUpdate(String id,HttpServletRequest request, Model model){
		ZxScheduleDay zxScheduleDay = zxScheduleDayService.getZxScheduleDayById(id);
		model.addAttribute("zxScheduleDay", zxScheduleDay);
		return new ModelAndView("pc/zx-view/zx-schedule-day/zx-schedule-day-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxScheduleDayDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxScheduleDayDetail(String id,HttpServletRequest request, Model model){
		ZxScheduleDay zxScheduleDay = zxScheduleDayService.getZxScheduleDayById(id);
		model.addAttribute("zxScheduleDay", zxScheduleDay);
		return new ModelAndView("pc/zx-view/zx-schedule-day/zx-schedule-day-detail");
	}
}
