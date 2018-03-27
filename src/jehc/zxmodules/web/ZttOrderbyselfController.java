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
import jehc.zxmodules.model.ZttOrderbyself;
import jehc.zxmodules.service.ZttOrderbyselfService;

/**
* 自制单表 
* 2018-03-20 17:26:52  季建吉
*/
@Controller
@RequestMapping("/zttOrderbyselfController")
public class ZttOrderbyselfController extends BaseAction{
	@Autowired
	private ZttOrderbyselfService zttOrderbyselfService;
	/**
	* 载入初始化页面
	* @param ztt_orderbyself 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttOrderbyself(ZttOrderbyself zttOrderbyself,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-orderbyself/ztt-orderbyself-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_orderbyself 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderbyselfListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderbyselfListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttOrderbyself> zttOrderbyselfList = zttOrderbyselfService.getZttOrderbyselfListByCondition(condition);
		PageInfo<ZttOrderbyself> page = new PageInfo<ZttOrderbyself>(zttOrderbyselfList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderbyselfById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderbyselfById(String id,HttpServletRequest request){
		ZttOrderbyself zttOrderbyself = zttOrderbyselfService.getZttOrderbyselfById(id);
		return outDataStr(zttOrderbyself);
	}
	/**
	* 添加
	* @param ztt_orderbyself 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttOrderbyself(ZttOrderbyself zttOrderbyself,HttpServletRequest request){
		int i = 0;
		if(null != zttOrderbyself && !"".equals(zttOrderbyself)){
			zttOrderbyself.setId(UUID.toUUID());
			i=zttOrderbyselfService.addZttOrderbyself(zttOrderbyself);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_orderbyself 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttOrderbyself(ZttOrderbyself zttOrderbyself,HttpServletRequest request){
		int i = 0;
		if(null != zttOrderbyself && !"".equals(zttOrderbyself)){
			i=zttOrderbyselfService.updateZttOrderbyself(zttOrderbyself);
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
	@RequestMapping(value="/delZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttOrderbyself(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttOrderbyselfService.delZttOrderbyself(condition);
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
	@RequestMapping(value="/copyZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttOrderbyself(String id,HttpServletRequest request){
		int i = 0;
		ZttOrderbyself zttOrderbyself = zttOrderbyselfService.getZttOrderbyselfById(id);
		if(null != zttOrderbyself && !"".equals(zttOrderbyself)){
			zttOrderbyself.setId(UUID.toUUID());
			i=zttOrderbyselfService.addZttOrderbyself(zttOrderbyself);
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
	@RequestMapping(value="/exportZttOrderbyself",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttOrderbyself(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbyselfAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbyselfAdd(ZttOrderbyself zttOrderbyself,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-orderbyself/ztt-orderbyself-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbyselfUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbyselfUpdate(String id,HttpServletRequest request, Model model){
		ZttOrderbyself zttOrderbyself = zttOrderbyselfService.getZttOrderbyselfById(id);
		model.addAttribute("zttOrderbyself", zttOrderbyself);
		return new ModelAndView("pc/zx-view/ztt-orderbyself/ztt-orderbyself-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbyselfDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbyselfDetail(String id,HttpServletRequest request, Model model){
		ZttOrderbyself zttOrderbyself = zttOrderbyselfService.getZttOrderbyselfById(id);
		model.addAttribute("zttOrderbyself", zttOrderbyself);
		return new ModelAndView("pc/zx-view/ztt-orderbyself/ztt-orderbyself-detail");
	}
}
