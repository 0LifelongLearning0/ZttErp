package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;

import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttProcessproduct;
import jehc.zxmodules.service.ZttProcessproductService;
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
import jehc.zxmodules.model.ZttProcessproductParent;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.service.ZttProcessproductParentService;

/**
* 机械加工工艺过程母表 
* 2018-04-24 08:34:08  季建吉
*/
@Controller
@RequestMapping("/zttProcessproductParentController")
public class ZttProcessproductParentController extends BaseAction{
	@Autowired
	private ZttProcessproductParentService zttProcessproductParentService;
	@Autowired
	private ZttProcessproductService zttProcessproductService;
	@Autowired
	private ZttOrderService zttOrderService;
	/**
	* 载入初始化页面
	* @param ztt_processproduct_parent 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttProcessproductParent",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttProcessproductParent(ZttProcessproductParent zttProcessproductParent,HttpServletRequest request,Model model){
		String flag=request.getParameter("flag");
		String order_id=request.getParameter("order_id");
		ZttOrder zttOrder = zttOrderService.getZttOrderById(order_id);
		model.addAttribute("order_id", order_id);
		model.addAttribute("product_order_number", zttOrder.getProduct_order_number());
		model.addAttribute("product_name", zttOrder.getProduct_name());
		model.addAttribute("stardard", zttOrder.getStardard());
			return new ModelAndView("pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-list");
		
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_processproduct_parent 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttProcessproductParentListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttProcessproductParentListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttProcessproductParent> zttProcessproductParentList = zttProcessproductParentService.getZttProcessproductParentListByCondition(condition);
		PageInfo<ZttProcessproductParent> page = new PageInfo<ZttProcessproductParent>(zttProcessproductParentList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttProcessproductParentById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttProcessproductParentById(String id,HttpServletRequest request){
		ZttProcessproductParent zttProcessproductParent = zttProcessproductParentService.getZttProcessproductParentById(id);
		return outDataStr(zttProcessproductParent);
	}
	/**
	* 添加
	* @param ztt_processproduct_parent 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttProcessproductParent",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttProcessproductParent(ZttProcessproductParent zttProcessproductParent,HttpServletRequest request){
		int i = 0;
		if(null != zttProcessproductParent && !"".equals(zttProcessproductParent)){
			zttProcessproductParent.setId(UUID.toUUID());
			i=zttProcessproductParentService.addZttProcessproductParent(zttProcessproductParent);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_processproduct_parent 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttProcessproductParent",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttProcessproductParent(ZttProcessproductParent zttProcessproductParent,HttpServletRequest request){
		int i = 0;
		if(null != zttProcessproductParent && !"".equals(zttProcessproductParent)){
			i=zttProcessproductParentService.updateZttProcessproductParent(zttProcessproductParent);
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
	@RequestMapping(value="/delZttProcessproductParent",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttProcessproductParent(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttProcessproductParentService.delZttProcessproductParent(condition);
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
	@RequestMapping(value="/exportZttProcessproductParent",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttProcessproductParent(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductParentAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductParentAdd(ZttProcessproductParent zttProcessproductParent,String order_id,HttpServletRequest request,Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(order_id);
		model.addAttribute("order_id", order_id);
		model.addAttribute("zttOrder", zttOrder);
	
		return new ModelAndView("pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-add");
	}
	/**
	* 发送至工艺卡添加页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductdetailAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductdetailAdd(ZttProcessproductParent zttProcessproductParent,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-processproduct-parent/ztt-processproduct-detail-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductParentUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductParentUpdate(String id,HttpServletRequest request, Model model){
		ZttProcessproductParent zttProcessproductParent = zttProcessproductParentService.getZttProcessproductParentById(id);
		model.addAttribute("zttProcessproductParent", zttProcessproductParent);
		model.addAttribute("zttProcessproductParentJSON", outItemsStr(zttProcessproductParent));
		return new ModelAndView("pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductParentDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductParentDetail(String id,HttpServletRequest request, Model model){
		ZttProcessproductParent zttProcessproductParent = zttProcessproductParentService.getZttProcessproductParentById(id);
		model.addAttribute("zttProcessproductParent", zttProcessproductParent);
		ZttOrder zttOrder = zttOrderService.getZttOrderById(zttProcessproductParent.getOrder_id());
		model.addAttribute("zttOrder", zttOrder);
		model.addAttribute("size", zttProcessproductParent.getZttProcessproduct().size());
		model.addAttribute("zttProcessproductParentJSON", outItemsStr(zttProcessproductParent));
		return new ModelAndView("pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-detail");
	}
}
