package jehc.zxmodules.web;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtMessage;
import jehc.xtmodules.xtservice.XtMessageService;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxSixS;
import jehc.zxmodules.model.ZxSixSContent;
import jehc.zxmodules.service.ZxSixSContentService;
import jehc.zxmodules.service.ZxSixSService;

/**
* 6S待办事项 
* 2017-11-01 10:30:02  a
*/
@Controller
@RequestMapping("/zxSixSController")
public class ZxSixSController extends BaseAction{
	@Autowired
	private ZxSixSService zxSixSService;
	@Autowired
	private ZxSixSContentService zxSixSContentService;
	@Autowired
	private XtMessageService xtMessageService;
	/**
	* 载入初始化页面
	* @param zx_six_s 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxSixS(ZxSixS zxSixS,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-six-s/zx-six-s-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_six_s 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSixSListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSixSListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("is_connect", 1);
		condition.put("state", 1);
		List<ZxSixS> zxSixSList = zxSixSService.getZxSixSListByCondition(condition);
		PageInfo<ZxSixS> page = new PageInfo<ZxSixS>(zxSixSList);
		return outPageStr(page,request);
	}
	/**
	* 载入当前用户初始化页面
	* @param zx_six_s 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxSixSView",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxSixSView(ZxSixS zxSixS,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-six-s/zx-six-s-list-view");
	}
	/**
	* 加载当前用户初始化列表数据并分页
	* @param zx_six_s 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSixSListViewByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSixSListViewByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("is_connect", 1);
		condition.put("state", 1);
		condition.put("is_join_content", 1);
		condition.put("zeren_user_id", CommonUtils.getXtUid());
		List<ZxSixS> zxSixSList = zxSixSService.getZxSixSListByCondition(condition);
		PageInfo<ZxSixS> page = new PageInfo<ZxSixS>(zxSixSList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSixSById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSixSById(String id,HttpServletRequest request){
		ZxSixS zxSixS = zxSixSService.getZxSixSById(id);
		if(StringUtils.isNotBlank(zxSixS.getCheck_date())){
			zxSixS.setCheck_date(zxSixS.getCheck_date().substring(0,10));
		}
		return outDataStr(zxSixS);
	}
	/**
	* 添加
	* @param zx_six_s 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxSixS(ZxSixS zxSixS,HttpServletRequest request){
		int i = 0;
		String id=null;
		if(null != zxSixS){
			id = UUID.toUUID();
			zxSixS.setId(id);
			zxSixS.setCreate_date(getSimpleDateFormat());
			zxSixS.setUser_id(getXtUid());
			zxSixS.setState("1");
			zxSixS.setStatus("1");
			i=zxSixSService.addZxSixS(zxSixS);
		}
		if(i>0){
			return "{success:true,msg:'"+CommonUtils.getCacheStr("sys_operate_sucess")+"',id:'"+ id +"',responseFlag:true}";
		}else{
			return "{success:false,msg:'"+CommonUtils.getCacheStr("sys_operate_error")+"',responseFlag:false}";
		}
	}
	/**
	* 修改
	* @param zx_six_s 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxSixS(ZxSixS zxSixS,HttpServletRequest request){
		int i = 0;
		if(null != zxSixS){
			i=zxSixSService.updateZxSixS(zxSixS);
			if(zxSixS.getStatus().equals("2")){
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("six_s_id", zxSixS.getId());
				List<ZxSixSContent> scs = zxSixSContentService.getZxSixSContentListByCondition(condition);
				Set<String> set = new HashSet<String>();
				List<XtMessage> messages = new ArrayList<XtMessage>();
				for(ZxSixSContent zxSixSContent:scs){
					if(!set.contains(zxSixSContent.getUser_id())){
						XtMessage xtMessage = new XtMessage();
						xtMessage.setXt_message_id(UUID.toUUID());
						xtMessage.setFrom_id(zxSixS.getUser_id());
						xtMessage.setTo_id(zxSixSContent.getUser_id());
						xtMessage.setXt_meesage_content("您有新的6S检查通知【" + zxSixS.getTitle() + "】，请查看！");
						xtMessage.setIsread("0");
						xtMessage.setCtime(getSimpleDateFormat());
						messages.add(xtMessage);
						set.add(zxSixSContent.getUser_id());
					}
				}
				if(!messages.isEmpty()){
					xtMessageService.addBatchXtMessage(messages);
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
	@RequestMapping(value="/delZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxSixS(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			String[] ids = id.split(",");
			List<ZxSixS> list = new ArrayList<ZxSixS>();
			for(String sid:ids){
				ZxSixS bean = zxSixSService.getZxSixSById(sid);
				bean.setState("0");
				list.add(bean);
			}
			if(!list.isEmpty())
				i = zxSixSService.updateBatchZxSixS(list);
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
	@RequestMapping(value="/copyZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxSixS(String id,HttpServletRequest request){
		int i = 0;
		ZxSixS zxSixS = zxSixSService.getZxSixSById(id);
		if(null != zxSixS){
			zxSixS.setId(UUID.toUUID());
			i=zxSixSService.addZxSixS(zxSixS);
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
	@RequestMapping(value="/exportZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxSixS(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	@ResponseBody
	@RequestMapping(value="/fabuZxSixS",method={RequestMethod.POST,RequestMethod.GET})
	public String fabuZxSixS(String id,String status,HttpServletRequest request){
		ZxSixS zxSixS = zxSixSService.getZxSixSById(id);
		if(null != zxSixS&&zxSixS.getState().equals("1")&&zxSixS.getStatus().equals("1")){
			zxSixS.setStatus(status);
			return updateZxSixS(zxSixS,request);
		}
		return outAudStr(false);
	}
}
