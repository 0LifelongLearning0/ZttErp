package jehc.zxmodules.web;
import java.io.IOException;
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

import jehc.xtmodules.xtcore.allutils.file.FileUtil;
import jehc.xtmodules.xtcore.annotation.AuthUneedLogin;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.quartz.QuartzJobFactory;
import jehc.xtmodules.xtcore.util.quartz.ScheduleJob;
import jehc.xtmodules.xtmodel.XtAttachment;
import jehc.xtmodules.xtmodel.XtMessage;
import jehc.xtmodules.xtmodel.XtQuartz;
import jehc.xtmodules.xtservice.XtAttachmentService;
import jehc.xtmodules.xtservice.XtMessageService;
import jehc.xtmodules.xtservice.XtQuartzService;
import jehc.zxmodules.model.ZxMeeting;
import jehc.zxmodules.model.ZxMeetingAttach;
import jehc.zxmodules.model.ZxMeetingHouse;
import jehc.zxmodules.model.ZxMeetingUser;
import jehc.zxmodules.service.ZxMeetingAttachService;
import jehc.zxmodules.service.ZxMeetingHouseService;
import jehc.zxmodules.service.ZxMeetingService;
import jehc.zxmodules.service.ZxMeetingUserService;
import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 会议 
* 2017-10-13 12:55:40  a
*/
@Controller
@RequestMapping("/zxMeetingController")
public class ZxMeetingController extends BaseAction{
	@Autowired
	private ZxMeetingService zxMeetingService;
	@Autowired
	private XtAttachmentService xtAttachmentService;
	@Autowired
	private ZxMeetingAttachService zxMeetingAttachService;
	@Autowired
	private XtMessageService xtMessageService;
	@Autowired
	private ZxMeetingUserService zxMeetingUserService;
	@Autowired
	private XtQuartzService xtQuartzService;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	private ZxMeetingHouseService zxMeetingHouseService;
	
	/**
	* 载入初始化页面
	* @param zx_meeting 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMeeting(ZxMeeting zxMeeting,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-meeting/zx-meeting-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_meeting 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("is_connect", 1);
		List<ZxMeeting> zxMeetingList = zxMeetingService.getZxMeetingListByCondition(condition);
		PageInfo<ZxMeeting> page = new PageInfo<ZxMeeting>(zxMeetingList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingById(String id,HttpServletRequest request){
		ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(id);
		if(zxMeeting != null){
			if(null != zxMeeting.getTime_start())zxMeeting.setTime_start(zxMeeting.getTime_start().replace(":00", ""));
			if(null != zxMeeting.getTime_end())zxMeeting.setTime_end(zxMeeting.getTime_end().replace(":00", ""));
		}
		return outDataStr(zxMeeting);
	}
	
	/**
	* 获取用户&附件
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getUserAndAttach",method={RequestMethod.POST,RequestMethod.GET})
	public String getUserAndAttach(String meeting_id, HttpServletRequest request){
		String user_name_t = "",user_ids_t = "",user_name_o = "",user_ids_o = "";
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("meeting_id", meeting_id);
		condition.put("is_connect", 1);
		List<ZxMeetingUser> users = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
		for(ZxMeetingUser user:users){
			if(user.getType().equals("1")){
				user_name_t += user.getUser_realname() + ",";
				user_ids_t += user.getUser_id() + ",";
			}else{
				user_name_o += user.getUser_realname() + ",";
				user_ids_o += user.getUser_id() + ",";
			}
		}
		
		List<ZxMeetingAttach> zxAttachs = zxMeetingAttachService.getZxMeetingAttachListByCondition(condition);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("zxAttachs", zxAttachs);
		jsonObject.put("user_name_t", user_name_t!=""?user_name_t.substring(0, user_name_t.length() - 1):"");
		jsonObject.put("user_ids_t", user_ids_t!=""?user_ids_t.substring(0, user_ids_t.length() - 1):"");
		jsonObject.put("user_name_o", user_name_o!=""?user_name_o.substring(0, user_name_o.length() - 1):"");
		jsonObject.put("user_ids_o", user_ids_o!=""?user_ids_o.substring(0, user_ids_o.length() - 1):"");
		return jsonObject.toString();
	}
	/**
	* 添加
	* @param zx_meeting 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMeeting(ZxMeeting zxMeeting,String[] zx_meeting_pic,String user_ids_t,String user_ids_o, HttpServletRequest request){
		int i = 0;
		String meeting_id = null;
		String time = getSimpleDateFormat();
		if(null != zxMeeting&&zxMeeting.getTime_start().compareTo(zxMeeting.getTime_end())<0){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("house_id", zxMeeting.getHouse_id());
			condition.put("state", 1);
			List<ZxMeeting> meetings = zxMeetingService.getZxMeetingListByCondition(condition);
			for(ZxMeeting bean:meetings){
				if(!(bean.getTime_end().compareTo(zxMeeting.getTime_start()) <= 0||bean.getTime_start().compareTo(zxMeeting.getTime_end()) > 0)){
					return "{success:" + false + ",msg:'会议时间冲突',responseFlag:true}";
				}
			}
			
			meeting_id = UUID.toUUID();
			zxMeeting.setId(meeting_id);
			zxMeeting.setCreate_date(time);
			zxMeeting.setState("1");
			zxMeeting.setIs_record("0");
			zxMeeting.setUser_id(CommonUtils.getXtUid());
			i=zxMeetingService.addZxMeeting(zxMeeting);
			if(i > 0){
				if(zx_meeting_pic != null){
					List<ZxMeetingAttach> attachs = new ArrayList<ZxMeetingAttach>();
					for(String tid:zx_meeting_pic){
						if(StringUtils.isNotBlank(tid)){
							ZxMeetingAttach attach = new ZxMeetingAttach();
							attach.setId(UUID.toUUID());
							attach.setMeeting_id(meeting_id);
							attach.setType("1");
							attach.setXt_attachment_id(tid);
							attachs.add(attach);
						}
					}
					if(!attachs.isEmpty()){
						 i = zxMeetingAttachService.addBatchZxMeetingAttach(attachs);
					}
				}
				
				List<ZxMeetingUser> users = new ArrayList<ZxMeetingUser>();
				if(i > 0&&StringUtils.isNotBlank(user_ids_t)){
					String[] ids = user_ids_t.split(",");
					for(String user_id:ids){
						ZxMeetingUser user = new ZxMeetingUser();
						user.setId(UUID.toUUID());
						user.setMeeting_id(meeting_id);
						user.setUser_id(user_id);
						user.setType("1");
						user.setCreate_date(time);
						users.add(user);
					}
				}
				if(i > 0&&StringUtils.isNotBlank(user_ids_o)){
					String[] ids = user_ids_o.split(",");
					for(String user_id:ids){
						ZxMeetingUser user = new ZxMeetingUser();
						user.setId(UUID.toUUID());
						user.setMeeting_id(meeting_id);
						user.setUser_id(user_id);
						user.setType("0");
						user.setCreate_date(time);
						users.add(user);
					}
				}
				if(!users.isEmpty()){
					 i = zxMeetingUserService.addBatchZxMeetingUser(users);
				}
				if(i > 0){
					ZxMeetingHouse zxMeetingHouse = zxMeetingHouseService.getZxMeetingHouseById(zxMeeting.getHouse_id());
					String msg = "会议【"+ zxMeeting.getTitle() +"】，将于"+ zxMeeting.getTime_start() +"开始,会议地点【"+ zxMeetingHouse.getHouse_name() +"】。";
					sendMessage(zxMeeting,users,msg);
					addTaskJob(zxMeeting);
				}
			}
		}
		return "{success:" + (i>0?true:false) + ",msg:'"+(i>0?"操作成功":"操作失败")+"',responseFlag:true}";
	}
	/**
	* 判断能否修改
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/canEdit",method={RequestMethod.POST,RequestMethod.GET})
	public String canEdit(String id,HttpServletRequest request){
		JSONObject object = new JSONObject();
		
		String time = getSimpleDateFormat();
		ZxMeeting zxMeeting =zxMeetingService.getZxMeetingById(id);
		if(zxMeeting.getState().equals("1")&&time.compareTo(zxMeeting.getTime_start()) < 0&&(zxMeeting.getUser_id().equals(getXtUid())||isAdmin())){
			object.put("success",true);
		}else{
			object.put("success",false);
			object.put("msg","不能修改");
		}
		return object.toString();
	}
	/**
	* 修改
	* @param zx_meeting 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMeeting(ZxMeeting zxMeeting,String[] zx_meeting_pic,String user_ids_t,String user_ids_o,HttpServletRequest request){
		int i = 0;
		String time = getSimpleDateFormat();
		if(null != zxMeeting && !"".equals(zxMeeting)
				&&zxMeeting.getTime_start().compareTo(zxMeeting.getTime_end()) < 0
				&&time.compareTo(zxMeeting.getTime_start()) < 0
				&&(zxMeeting.getUser_id().equals(getXtUid())||isAdmin())){
			//判断会议时间地点是否冲突
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("house_id", zxMeeting.getHouse_id());
			condition.put("status", 2);
			condition.put("state", 1);
			List<ZxMeeting> meetings = zxMeetingService.getZxMeetingListByCondition(condition);
			for(ZxMeeting bean:meetings){
				if(!(bean.getTime_end().compareTo(zxMeeting.getTime_start()) <= 0||bean.getTime_start().compareTo(zxMeeting.getTime_end()) > 0)){
					return "{success:" + false + ",msg:'会议时间冲突',responseFlag:true}";
				}
			}
			
			i=zxMeetingService.updateZxMeeting(zxMeeting);
			if(i > 0){
				//删除原来人员
				condition = new HashMap<String, Object>();
				condition.put("meeting_id", zxMeeting.getId());
				List<ZxMeetingUser> oldUsers = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
				if(!oldUsers.isEmpty()){
					String ids[] = new String[oldUsers.size()];
					for(int m = 0;m < oldUsers.size();m++){
						ids[m] = oldUsers.get(m).getId();
					}
					condition = new HashMap<String, Object>();
					condition.put("id", ids);
					i = zxMeetingUserService.delZxMeetingUser(condition);
				}
				
				List<ZxMeetingUser> users = new ArrayList<ZxMeetingUser>();
				//会议人员
				if(i > 0&&StringUtils.isNotBlank(user_ids_t)){
					String[] ids = user_ids_t.split(",");
					for(String user_id:ids){
						ZxMeetingUser user = new ZxMeetingUser();
						user.setId(UUID.toUUID());
						user.setMeeting_id(zxMeeting.getId());
						user.setUser_id(user_id);
						user.setType("1");
						user.setCreate_date(time);
						users.add(user);
					}
				}
				
				//邀请人员
				if(i > 0&&StringUtils.isNotBlank(user_ids_o)){
					String[] ids = user_ids_o.split(",");
					for(String user_id:ids){
						ZxMeetingUser user = new ZxMeetingUser();
						user.setId(UUID.toUUID());
						user.setMeeting_id(zxMeeting.getId());
						user.setUser_id(user_id);
						user.setType("0");
						user.setCreate_date(time);
						users.add(user);
					}
				}
				if(!users.isEmpty()){
					 i = zxMeetingUserService.addBatchZxMeetingUser(users);
				}
				
				if(i > 0){
					String msg = "会议【"+ zxMeeting.getTitle() +"】，将于"+ zxMeeting.getTime_start() +"开始,会议地点【"+ zxMeeting.getHouse_name() +"】。";
					sendMessage(zxMeeting,users,msg);
					addTaskJob(zxMeeting);
				}
			}
		}
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
	*/
	@ResponseBody
	@RequestMapping(value="/delZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMeeting(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			List<ZxMeeting> meetings = new ArrayList<ZxMeeting>();
			
			String[] ids = id.split(",");
			for(String mid:ids){
				ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(mid);
				if(zxMeeting.getState().equals("1")&&(zxMeeting.getUser_id().equals(getXtUid())||isAdmin())){
					zxMeeting.setState("0");
					meetings.add(zxMeeting);
					
					if(zxMeeting.getTime_start().compareTo(getSimpleDateFormat()) > 0){
						Map<String, Object> condition = new HashMap<String, Object>();
						condition.put("meeting_id", mid);
						List<ZxMeetingUser> users = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
						String msg = "会议【" + zxMeeting.getTitle() + "】，已经取消！";
						sendMessage(zxMeeting, users, msg);
					}
				}
			}
					
			if(!meetings.isEmpty())i=zxMeetingService.updateBatchZxMeeting(meetings);
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
	@RequestMapping(value="/copyZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMeeting(String id,HttpServletRequest request){
		int i = 0;
		ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(id);
		if(null != zxMeeting){
			zxMeeting.setId(UUID.toUUID());
			i=zxMeetingService.addZxMeeting(zxMeeting);
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
	@RequestMapping(value="/exportZxMeeting",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMeeting(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	 * 上传
	 * 
	 * @param validateparameter
	 *            校验类型
	 * @param validateSize
	 *            校验大小
	 * @param xt_path_absolutek
	 *            绝对路径键（自定义）
	 * @param xt_path_relativek相对路径键（自定义）
	 * @param xt_path_urlk
	 *            基础路径URL（自定义）
	 * @param request
	 * @param response
	 * @return
	 */
	@AuthUneedLogin
	@ResponseBody
	@RequestMapping(value = "/upload", method = { RequestMethod.POST, RequestMethod.GET })
	public String upload(String meeting_id, String type, String validateparameter, String validateSize, String xt_path_absolutek,
			String xt_path_relativek, String xt_path_urlk, HttpServletRequest request, HttpServletResponse response) {
		//BaseJson baseJson = new BaseJson();
		JSONArray jsonArray = new JSONArray();
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			// 默认绝对路径
			String path = CommonUtils.getXtPathCache("xt_sources_default_path").get(0).getXt_path();
			// 相对路径
			String relative_path = CommonUtils.getXtPathCache("xt_sources_default_relative_path").get(0).getXt_path();
			// 校验xt_path_absolutek
			if (!StringUtils.isEmpty(xt_path_absolutek)) {
				if (!StringUtils.isEmpty(CommonUtils.getXtPathCache(xt_path_absolutek).get(0).getXt_path())) {
					path = CommonUtils.getXtPathCache(xt_path_absolutek).get(0).getXt_path();
				}
			}
			// 校验xt_path_relativek
			if (!StringUtils.isEmpty(xt_path_relativek)) {
				if (!StringUtils.isEmpty(CommonUtils.getXtPathCache(xt_path_relativek).get(0).getXt_path())) {
					relative_path = CommonUtils.getXtPathCache(xt_path_relativek).get(0).getXt_path();
				}
			}
			FileUtil.initPath(request, path);
			List<XtAttachment> xtAttachmentList = CommonUtils.upLoad(request, path, relative_path, validateparameter,
					validateSize, xt_path_absolutek, xt_path_relativek, xt_path_urlk);
			XtAttachment xtAttachment = xtAttachmentList.get(0);
			int i = xtAttachmentService.addXtAttachment(xtAttachment);
			
			if(StringUtils.isNotBlank(meeting_id)){
				ZxMeetingAttach zxMeetingAttach = new ZxMeetingAttach();
				zxMeetingAttach.setId(UUID.toUUID());
				zxMeetingAttach.setMeeting_id(meeting_id);
				zxMeetingAttach.setType(type);
				zxMeetingAttach.setXt_attachment_id(xtAttachment.getXt_attachment_id());
				zxMeetingAttachService.addZxMeetingAttach(zxMeetingAttach);
			}
			map.put("filename", xtAttachment.getXt_attachmentTitle());
			if (i > 0) {
				map.put("jsonID", xtAttachmentList.get(0).getXt_attachment_id());
				map.put("msg", "上传成功");
				map.put("fileType", xtAttachmentList.get(0).getXt_attachmentType());
				if (null != xtAttachmentList.get(0).getXt_attachmentType()
						&& !"".equals(xtAttachmentList.get(0).getXt_attachmentType())) {
					if ("image/jpeg".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/png".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/gif".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/bmp".equals(xtAttachmentList.get(0).getXt_attachmentType())) {
						// 校验是否为自定义路径
						if (!StringUtils.isEmpty(xt_path_urlk)) {
							map.put("jsonValue", CommonUtils.getXtPathCache(xt_path_urlk).get(0).getXt_path()
									+ xtAttachmentList.get(0).getXt_attachmentPath());
						} else {
							map.put("jsonValue", CommonUtils.getXtPathCache("hssources_base_url").get(0).getXt_path()
									+ xtAttachmentList.get(0).getXt_attachmentPath());
						}
						
					} else {
						// 非图片格式让其显示成功图标即可
						map.put("jsonValue",CommonUtils.getXtPathCache("hs_upload_sucess").get(0).getXt_path());
					}
				} else {
					map.put("jsonValue",CommonUtils.getXtPathCache("hs_upload_fail").get(0).getXt_path());
				}
				//发送消息提示，会议记录
				if(type.equals("2")&&StringUtils.isNotBlank(meeting_id)){
					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("meeting_id", meeting_id);
					List<ZxMeetingUser> users = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
					ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(meeting_id);
					String msg = "会议主题：【" + zxMeeting.getTitle() + "】，已经更新，请注意查看！";
					sendMessage(zxMeeting, users, msg);
					zxMeeting.setIs_record("1");
					zxMeetingService.updateZxMeeting(zxMeeting);
				}
			} else {
				map.put("jsonValue",CommonUtils.getXtPathCache("hs_upload_fail").get(0).getXt_path());
				map.put("msg","上传失败");
			}
			jsonArray.add(map);
			return outDataStr(jsonArray);
		} catch (Exception e) {
			map.put("msg","上传失败、失败原因:" + e.getMessage());
			map.put("jsonID","0");
			jsonArray.add(map);
			return outDataStr(jsonArray);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/delAttach", method = { RequestMethod.POST, RequestMethod.GET })
	public String delAttach(String xt_attachment_id,String meeting_id,HttpServletRequest request) {
		int i = 0;
		if(StringUtils.isNotBlank(xt_attachment_id)&&StringUtils.isNotBlank(meeting_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("meeting_id", meeting_id);
			condition.put("xt_attachment_id", xt_attachment_id);
			List<ZxMeetingAttach> attachs = zxMeetingAttachService.getZxMeetingAttachListByCondition(condition);
			if(!attachs.isEmpty()){
				String[] ids = new String[attachs.size()];
				for(int m = 0;m < attachs.size();m++){
					ids[m] = attachs.get(m).getId();
				}
				condition = new HashMap<String, Object>();
				condition.put("id", ids);
				i = zxMeetingAttachService.delZxMeetingAttach(condition);
			}
		}
		return String.valueOf(i);
	}
	
	@ResponseBody
	@RequestMapping(value = "/canAddRecord", method = { RequestMethod.POST, RequestMethod.GET })
	public String canAddRecord(String id,HttpServletRequest request) {
		int i = 0;
		if(StringUtils.isNotBlank(id)){
			ZxMeeting zxMeeting = zxMeetingService.getZxMeetingById(id);
			if(zxMeeting != null&&zxMeeting.getState().equals("1")&&zxMeeting.getTime_end().compareTo(getSimpleDateFormat()) <= 0){
				i = 1;
			}
		}
		return String.valueOf(i);
	}
	
	public void sendMessage(ZxMeeting zxMeeting,List<ZxMeetingUser> users,String msg){
		if(users!=null&&!users.isEmpty()){
			List<XtMessage> messages = new ArrayList<XtMessage>();
			String date = CommonUtils.getSimpleDateFormat();
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
			
			if(!messages.isEmpty())
				xtMessageService.addBatchXtMessage(messages);
		}
	}
	
	public void addTaskJob(ZxMeeting zxMeeting){
		try {
			String msg = "会议【"+ zxMeeting.getTitle() +"】，将于"+ zxMeeting.getTime_start() +"开始,会议地点【"+ zxMeeting.getHouse_name() +"】。";
			
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("jobId", "Xt_Message_Tishi_Task");
			List<XtQuartz> xtQuartzList = xtQuartzService.getXtQuartzListAllByCondition(condition);
			if(!xtQuartzList.isEmpty()){
				XtQuartz xtQuartz = xtQuartzList.get(0);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d = sdf.parse(zxMeeting.getTime_start() + ":01");
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(d.getTime() - 300000);
				
				ScheduleJob job = new ScheduleJob();
				job.setJobId("Xt_Message_Tishi_Task@N" + zxMeeting.getId());
				job.setJobName(xtQuartz.getJobName() + "@N" + zxMeeting.getId());
				job.setJobGroup("meeting_msg");
				job.setJobStatus("NORMAL");
				job.setTargetClass(xtQuartz.getTargetClass());
				job.setTargetMethod(xtQuartz.getTargetMethod());
				job.setDesc(msg);
				int minute = c.get(Calendar.MINUTE);
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int day = c.get(Calendar.DAY_OF_MONTH);
				int month = c.get(Calendar.MONTH)+1;
				int year = c.get(Calendar.YEAR);
				job.setCronExpression("0 " + minute + " " + hour + " " + day + " " + month + " ? " + year);
				addXtQuartz(job);
			}
		} catch (ParseException| IOException | SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public String addXtQuartz(ScheduleJob job) throws IOException, SchedulerException {
		try{
			//一定要紧跟Validate之后写验证结果类
			String seconds = job.getCronExpression();
//			String cronExp = "0/" + seconds + " * * * * ?";
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
			return outAudStr(true);
		}catch(Exception e){
			return outAudStr(false);
		}
	}
	/**
	* 获取当前系统时间
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getNowTime",method={RequestMethod.POST,RequestMethod.GET})
	public String getNowTime(HttpServletRequest request){
		return getSimpleDateFormat();
	}
}
