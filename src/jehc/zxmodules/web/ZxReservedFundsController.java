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
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxReservedFunds;
import jehc.zxmodules.service.ZxReservedFundsService;

/**
* 公积金台账 
* 2018-01-18 08:15:15  owen
*/
@Controller
@RequestMapping("/zxReservedFundsController")
public class ZxReservedFundsController extends BaseAction{
	@Autowired
	private ZxReservedFundsService zxReservedFundsService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	/**
	* 载入初始化页面
	* @param zx_reserved_funds 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxReservedFunds(ZxReservedFunds zxReservedFunds,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-reserved-funds/zx-reserved-funds-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_reserved_funds 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxReservedFundsListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxReservedFundsListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxReservedFunds> zxReservedFundsList = zxReservedFundsService.getZxReservedFundsListByCondition(condition);
		PageInfo<ZxReservedFunds> page = new PageInfo<ZxReservedFunds>(zxReservedFundsList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxReservedFundsById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxReservedFundsById(String id,HttpServletRequest request){
		ZxReservedFunds zxReservedFunds = zxReservedFundsService.getZxReservedFundsById(id);
		return outDataStr(zxReservedFunds);
	}
	/**
	* 添加
	* @param zx_reserved_funds 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxReservedFunds(ZxReservedFunds zxReservedFunds,HttpServletRequest request){
		int i = 0;
		if(null != zxReservedFunds && !"".equals(zxReservedFunds)){
			zxReservedFunds.setId(UUID.toUUID());
			zxReservedFunds.setCreate_time(getSimpleDateFormat());
			i=zxReservedFundsService.addZxReservedFunds(zxReservedFunds);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_reserved_funds 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxReservedFunds(ZxReservedFunds zxReservedFunds,HttpServletRequest request){
		int i = 0;
		if(null != zxReservedFunds && !"".equals(zxReservedFunds)){
			zxReservedFunds.setCreate_time(getSimpleDateFormat());
			i=zxReservedFundsService.updateZxReservedFunds(zxReservedFunds);
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
	@RequestMapping(value="/delZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxReservedFunds(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxReservedFundsService.delZxReservedFunds(condition);
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
	@RequestMapping(value="/copyZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxReservedFunds(String id,HttpServletRequest request){
		int i = 0;
		ZxReservedFunds zxReservedFunds = zxReservedFundsService.getZxReservedFundsById(id);
		if(null != zxReservedFunds && !"".equals(zxReservedFunds)){
			zxReservedFunds.setId(UUID.toUUID());
			i=zxReservedFundsService.addZxReservedFunds(zxReservedFunds);
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
	@RequestMapping(value="/exportZxReservedFunds",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxReservedFunds(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxReservedFundsAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxReservedFundsAdd(String xt_user_id,HttpServletRequest request,Model model){
		if(xt_user_id!=null){
			XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(xt_user_id);
			model.addAttribute("xt_user_id",xt_user_id);
			model.addAttribute("xt_userinfo_realName", xtUserinfo.getXt_userinfo_realName());
		}
		return new ModelAndView("pc/zx-view/zx-reserved-funds/zx-reserved-funds-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxReservedFundsUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxReservedFundsUpdate(String id,HttpServletRequest request, Model model){
		ZxReservedFunds zxReservedFunds = zxReservedFundsService.getZxReservedFundsById(id);
		model.addAttribute("zxReservedFunds", zxReservedFunds);
		return new ModelAndView("pc/zx-view/zx-reserved-funds/zx-reserved-funds-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxReservedFundsDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxReservedFundsDetail(String id,HttpServletRequest request, Model model){
		ZxReservedFunds zxReservedFunds = zxReservedFundsService.getZxReservedFundsById(id);
		model.addAttribute("zxReservedFunds", zxReservedFunds);
		return new ModelAndView("pc/zx-view/zx-reserved-funds/zx-reserved-funds-detail");
	}
	/**
	* 发送至选择员工页面
	* @param request 
	*/
	@RequestMapping(value="/toZxReservedFundsUserChoose",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxReservedFundsUserChoose(XtUserinfo xtUserinfo,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-reserved-funds/zx-reserved-funds-user-choose");
	}
}
