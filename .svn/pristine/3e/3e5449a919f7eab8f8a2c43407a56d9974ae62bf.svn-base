package jehc.zxmodules.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxMeetingUser;
import jehc.zxmodules.service.ZxMeetingUserService;

/**
* 会议人员 
* 2017-10-13 13:21:28  a
*/
@Controller
@RequestMapping("/zxMeetingUserController")
public class ZxMeetingUserController extends BaseAction{
	@Autowired
	private ZxMeetingUserService zxMeetingUserService;
	
	/**
	* 载入初始化页面
	* @param zx_meeting_user 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMeetingUser(ZxMeetingUser zxMeetingUser,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-meeting-user/zx-meeting-user-list");
	}
	/**
	* 加载初始化列表数据并分页(当前用户参与的会议)
	* @param zx_meeting_user 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingUserListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingUserListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("user_id", getXtU().getXt_userinfo_id());
		condition.put("is_connect", 1);
		condition.put("meeting_status", 2);
		condition.put("meeting_state", 1);
		List<ZxMeetingUser> zxMeetingUserList = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
		PageInfo<ZxMeetingUser> page = new PageInfo<ZxMeetingUser>(zxMeetingUserList);
		return outPageStr(page,request);
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_meeting_user 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingUserList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingUserList(String meeting_id,BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("is_connect", 1);
		condition.put("meeting_id", meeting_id);
		condition.put("state", 1);
		List<ZxMeetingUser> zxMeetingUserList = zxMeetingUserService.getZxMeetingUserListByCondition(condition);
		PageInfo<ZxMeetingUser> page = new PageInfo<ZxMeetingUser>(zxMeetingUserList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingUserById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingUserById(String id,HttpServletRequest request){
		ZxMeetingUser zxMeetingUser = zxMeetingUserService.getZxMeetingUserById(id);
		return outDataStr(zxMeetingUser);
	}
	/**
	* 添加
	* @param zx_meeting_user 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMeetingUser(ZxMeetingUser zxMeetingUser,HttpServletRequest request){
		int i = 0;
		if(null != zxMeetingUser){
			zxMeetingUser.setId(UUID.toUUID());
			i=zxMeetingUserService.addZxMeetingUser(zxMeetingUser);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_meeting_user 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMeetingUser(ZxMeetingUser zxMeetingUser,HttpServletRequest request){
		int i = 0;
		if(null != zxMeetingUser){
			i=zxMeetingUserService.updateZxMeetingUser(zxMeetingUser);
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
	@RequestMapping(value="/delZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMeetingUser(String id,String meeting_id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxMeetingUserService.delZxMeetingUser(condition);
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
	@RequestMapping(value="/copyZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMeetingUser(String id,HttpServletRequest request){
		int i = 0;
		ZxMeetingUser zxMeetingUser = zxMeetingUserService.getZxMeetingUserById(id);
		if(null != zxMeetingUser){
			zxMeetingUser.setId(UUID.toUUID());
			i=zxMeetingUserService.addZxMeetingUser(zxMeetingUser);
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
	@RequestMapping(value="/exportZxMeetingUser",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMeetingUser(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
