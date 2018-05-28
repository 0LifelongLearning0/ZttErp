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
import jehc.zxmodules.model.ZttMouldsDeivice;
import jehc.zxmodules.service.ZttMouldsDeiviceService;

/**
* 工序设备 
* 2018-05-24 16:46:19  季建吉
*/
@Controller
@RequestMapping("/zttMouldsDeiviceController")
public class ZttMouldsDeiviceController extends BaseAction{
	@Autowired
	private ZttMouldsDeiviceService zttMouldsDeiviceService;
	/**
	* 载入初始化页面
	* @param ztt_moulds_deivice 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moulds-deivice/ztt-moulds-deivice-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_moulds_deivice 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMouldsDeiviceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMouldsDeiviceListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("gongxu_id",request.getParameter("gongxu_id"));
		List<ZttMouldsDeivice> zttMouldsDeiviceList = zttMouldsDeiviceService.getZttMouldsDeiviceListByCondition(condition);
		PageInfo<ZttMouldsDeivice> page = new PageInfo<ZttMouldsDeivice>(zttMouldsDeiviceList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMouldsDeiviceById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMouldsDeiviceById(String id,HttpServletRequest request){
		ZttMouldsDeivice zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceById(id);
		return outDataStr(zttMouldsDeivice);
	}
	/**
	* 添加
	* @param ztt_moulds_deivice 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice,HttpServletRequest request){
		int i = 0;
		if(null != zttMouldsDeivice && !"".equals(zttMouldsDeivice)){
			zttMouldsDeivice.setId(UUID.toUUID());
			i=zttMouldsDeiviceService.addZttMouldsDeivice(zttMouldsDeivice);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_moulds_deivice 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice,HttpServletRequest request){
		int i = 0;
		if(null != zttMouldsDeivice && !"".equals(zttMouldsDeivice)){
			i=zttMouldsDeiviceService.updateZttMouldsDeivice(zttMouldsDeivice);
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
	@RequestMapping(value="/delZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttMouldsDeivice(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttMouldsDeiviceService.delZttMouldsDeivice(condition);
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
	@RequestMapping(value="/copyZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttMouldsDeivice(String id,HttpServletRequest request){
		int i = 0;
		ZttMouldsDeivice zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceById(id);
		if(null != zttMouldsDeivice && !"".equals(zttMouldsDeivice)){
			zttMouldsDeivice.setId(UUID.toUUID());
			i=zttMouldsDeiviceService.addZttMouldsDeivice(zttMouldsDeivice);
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
	@RequestMapping(value="/exportZttMouldsDeivice",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttMouldsDeivice(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsDeiviceAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsDeiviceAdd(ZttMouldsDeivice zttMouldsDeivice,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moulds-deivice/ztt-moulds-deivice-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsDeiviceUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsDeiviceUpdate(String id,HttpServletRequest request, Model model){
		ZttMouldsDeivice zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceById(id);
		model.addAttribute("zttMouldsDeivice", zttMouldsDeivice);
		return new ModelAndView("pc/zx-view/ztt-moulds-deivice/ztt-moulds-deivice-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsDeiviceDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsDeiviceDetail(String id,HttpServletRequest request, Model model){
		ZttMouldsDeivice zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceById(id);
		model.addAttribute("zttMouldsDeivice", zttMouldsDeivice);
		return new ModelAndView("pc/zx-view/ztt-moulds-deivice/ztt-moulds-deivice-detail");
	}
}
