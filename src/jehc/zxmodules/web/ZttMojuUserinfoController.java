package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
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
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZttMojuUserinfo;
import jehc.zxmodules.service.ZttMojuUserinfoService;

/**
* 模具部车间员工信息表 
* 2018-05-29 13:39:52  季建吉
*/
@Controller
@RequestMapping("/zttMojuUserinfoController")
public class ZttMojuUserinfoController extends BaseAction{
	@Autowired
	private ZttMojuUserinfoService zttMojuUserinfoService;
	/**
	* 载入初始化页面
	* @param ztt_moju_userinfo 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moju-userinfo/ztt-moju-userinfo-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_moju_userinfo 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMojuUserinfoListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMojuUserinfoListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttMojuUserinfo> zttMojuUserinfoList = zttMojuUserinfoService.getZttMojuUserinfoListByCondition(condition);
		PageInfo<ZttMojuUserinfo> page = new PageInfo<ZttMojuUserinfo>(zttMojuUserinfoList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param xt_userinfo_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMojuUserinfoById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMojuUserinfoById(String xt_userinfo_id,HttpServletRequest request){
		ZttMojuUserinfo zttMojuUserinfo = zttMojuUserinfoService.getZttMojuUserinfoById(xt_userinfo_id);
		return outDataStr(zttMojuUserinfo);
	}
	/**
	* 添加
	* @param ztt_moju_userinfo 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo,HttpServletRequest request){
		int i = 0;
		if(null != zttMojuUserinfo && !"".equals(zttMojuUserinfo)){
			zttMojuUserinfo.setXt_userinfo_id(UUID.toUUID());
			i=zttMojuUserinfoService.addZttMojuUserinfo(zttMojuUserinfo);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_moju_userinfo 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo,HttpServletRequest request){
		int i = 0;
		if(null != zttMojuUserinfo && !"".equals(zttMojuUserinfo)){
			i=zttMojuUserinfoService.updateZttMojuUserinfo(zttMojuUserinfo);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 删除
	* @param xt_userinfo_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttMojuUserinfo(String xt_userinfo_id,HttpServletRequest request){
		int i = 0;
		if(null != xt_userinfo_id && !"".equals(xt_userinfo_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_userinfo_id",xt_userinfo_id.split(","));
			i=zttMojuUserinfoService.delZttMojuUserinfo(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 复制一行并生成记录
	* @param xt_userinfo_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/copyZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttMojuUserinfo(String xt_userinfo_id,HttpServletRequest request){
		int i = 0;
		ZttMojuUserinfo zttMojuUserinfo = zttMojuUserinfoService.getZttMojuUserinfoById(xt_userinfo_id);
		if(null != zttMojuUserinfo && !"".equals(zttMojuUserinfo)){
			zttMojuUserinfo.setXt_userinfo_id(UUID.toUUID());
			i=zttMojuUserinfoService.addZttMojuUserinfo(zttMojuUserinfo);
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
	@RequestMapping(value="/exportZttMojuUserinfo",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttMojuUserinfo(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMojuUserinfoAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMojuUserinfoAdd(ZttMojuUserinfo zttMojuUserinfo,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moju-userinfo/ztt-moju-userinfo-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMojuUserinfoUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMojuUserinfoUpdate(String xt_userinfo_id,HttpServletRequest request, Model model){
		ZttMojuUserinfo zttMojuUserinfo = zttMojuUserinfoService.getZttMojuUserinfoById(xt_userinfo_id);
		model.addAttribute("zttMojuUserinfo", zttMojuUserinfo);
		return new ModelAndView("pc/zx-view/ztt-moju-userinfo/ztt-moju-userinfo-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMojuUserinfoDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMojuUserinfoDetail(String xt_userinfo_id,HttpServletRequest request, Model model){
		ZttMojuUserinfo zttMojuUserinfo = zttMojuUserinfoService.getZttMojuUserinfoById(xt_userinfo_id);
		model.addAttribute("zttMojuUserinfo", zttMojuUserinfo);
		return new ModelAndView("pc/zx-view/ztt-moju-userinfo/ztt-moju-userinfo-detail");
	}
}
