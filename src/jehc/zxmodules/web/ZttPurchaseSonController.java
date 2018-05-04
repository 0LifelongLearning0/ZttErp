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
import jehc.zxmodules.model.ZttPurchaseSon;
import jehc.zxmodules.service.ZttPurchaseSonService;

/**
* 采购子台账 
* 2018-04-29 10:08:25  季建吉
*/
@Controller
@RequestMapping("/zttPurchaseSonController")
public class ZttPurchaseSonController extends BaseAction{
	@Autowired
	private ZttPurchaseSonService zttPurchaseSonService;
	/**
	* 载入初始化页面
	* @param ztt_purchase_son 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttPurchaseSon(ZttPurchaseSon zttPurchaseSon,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-purchase-son/ztt-purchase-son-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_purchase_son 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttPurchaseSonListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttPurchaseSonListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("parent_id",request.getParameter("parent_id"));
		List<ZttPurchaseSon> zttPurchaseSonList = zttPurchaseSonService.getZttPurchaseSonListByCondition(condition);
		PageInfo<ZttPurchaseSon> page = new PageInfo<ZttPurchaseSon>(zttPurchaseSonList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttPurchaseSonById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttPurchaseSonById(String id,HttpServletRequest request){
		ZttPurchaseSon zttPurchaseSon = zttPurchaseSonService.getZttPurchaseSonById(id);
		return outDataStr(zttPurchaseSon);
	}
	/**
	* 添加
	* @param ztt_purchase_son 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttPurchaseSon(ZttPurchaseSon zttPurchaseSon,HttpServletRequest request){
		int i = 0;
		if(null != zttPurchaseSon && !"".equals(zttPurchaseSon)){
			zttPurchaseSon.setId(UUID.toUUID());
			i=zttPurchaseSonService.addZttPurchaseSon(zttPurchaseSon);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_purchase_son 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttPurchaseSon(ZttPurchaseSon zttPurchaseSon,HttpServletRequest request){
		int i = 0;
		if(null != zttPurchaseSon && !"".equals(zttPurchaseSon)){
			i=zttPurchaseSonService.updateZttPurchaseSon(zttPurchaseSon);
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
	@RequestMapping(value="/delZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttPurchaseSon(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttPurchaseSonService.delZttPurchaseSon(condition);
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
	@RequestMapping(value="/copyZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttPurchaseSon(String id,HttpServletRequest request){
		int i = 0;
		ZttPurchaseSon zttPurchaseSon = zttPurchaseSonService.getZttPurchaseSonById(id);
		if(null != zttPurchaseSon && !"".equals(zttPurchaseSon)){
			zttPurchaseSon.setId(UUID.toUUID());
			i=zttPurchaseSonService.addZttPurchaseSon(zttPurchaseSon);
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
	@RequestMapping(value="/exportZttPurchaseSon",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttPurchaseSon(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttPurchaseSonAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttPurchaseSonAdd(ZttPurchaseSon zttPurchaseSon,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-purchase-son/ztt-purchase-son-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttPurchaseSonUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttPurchaseSonUpdate(String id,HttpServletRequest request, Model model){
		ZttPurchaseSon zttPurchaseSon = zttPurchaseSonService.getZttPurchaseSonById(id);
		model.addAttribute("zttPurchaseSon", zttPurchaseSon);
		return new ModelAndView("pc/zx-view/ztt-purchase-son/ztt-purchase-son-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttPurchaseSonDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttPurchaseSonDetail(String id,HttpServletRequest request, Model model){
		ZttPurchaseSon zttPurchaseSon = zttPurchaseSonService.getZttPurchaseSonById(id);
		model.addAttribute("zttPurchaseSon", zttPurchaseSon);
		return new ModelAndView("pc/zx-view/ztt-purchase-son/ztt-purchase-son-detail");
	}
}
