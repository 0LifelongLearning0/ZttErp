package jehc.zxmodules.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxBuyProgress;
import jehc.zxmodules.service.ZxBuyProgressService;
import jehc.zxmodules.service.ZxBuyTimeService;
import jehc.zxmodules.service.ZxMaterialService;
import jehc.zxmodules.service.ZxOrderBuyService;
import jehc.zxmodules.service.ZxProjectService;
import jehc.zxmodules.service.ZxSupplierService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 采购件进度表 
* 2017-10-28 15:56:49  陈运芝
*/
@Controller
@RequestMapping("/zxBuyProgressController")
public class ZxBuyProgressController extends BaseAction{
	@Autowired
	private ZxBuyProgressService zxBuyProgressService;
	@Autowired
	private ZxOrderBuyService zxOrderBuyService;
	@Autowired
	private ZxBuyTimeService zxBuyTimeService;
	@Autowired
	private ZxMaterialService zxMaterialService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private ZxSupplierService zxSupplierService;
	@Autowired
	private ZxProjectService zxProjectService;
	/**
	* 载入初始化页面
	* @param zx_buy_progress 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyProgress(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-buy-progress/zx-buy-progress-list");
	}

	/**
	* 载入订单下物料页面
	* @param zx_order_buy 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyProgressMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyProgressMaterial(ZxBuyProgress zxBuyProgress,HttpServletRequest request,Model model){
		model.addAttribute("zxBuyProgress",zxBuyProgress);
		model.addAttribute("ZxOrderBuy",zxOrderBuyService.getZxOrderBuyById(zxBuyProgress.getOrder_id()));
		return new ModelAndView("pc/zx-view/zx-order-buy/zx-order-buy-edit-material-list");
	}

	/**
	* 载入初始化页面：仓库出入库
	* @param zx_buy_progress 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyProgressWarehouse",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyProgressWarehouse(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-buy-progress/zx-buy-progress-warehouse-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_buy_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyProgressListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyProgressListByCondition(BaseSearch baseSearch,String order_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		if(StringUtils.isNotBlank(order_id)){
			condition.put("order_id", order_id);
		}
		List<Map<String,Object>> zxBuyProgressList = zxBuyProgressService.getZxBuyProgressListByCondition(condition);
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(zxBuyProgressList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyProgressById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyProgressById(String id,HttpServletRequest request){
		Map<String, Object> zxBuyProgress = zxBuyProgressService.getMapZxBuyProgressById(id);
		return outDataStr(zxBuyProgress);
	}
	/**
	* 添加
	* @param zx_buy_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxBuyProgress(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyProgress){
			zxBuyProgress.setId(UUID.toUUID());
			i=zxBuyProgressService.addZxBuyProgress(zxBuyProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_buy_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxBuyProgress(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyProgress){
			i=zxBuyProgressService.updateZxBuyProgress(zxBuyProgress);
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
	@RequestMapping(value="/delZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxBuyProgress(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxBuyProgressService.delZxBuyProgress(condition);
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
	@RequestMapping(value="/copyZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxBuyProgress(String id,HttpServletRequest request){
		int i = 0;
		ZxBuyProgress zxBuyProgress = zxBuyProgressService.getZxBuyProgressById(id);
		if(null != zxBuyProgress){
			zxBuyProgress.setId(UUID.toUUID());
			i=zxBuyProgressService.addZxBuyProgress(zxBuyProgress);
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
	@RequestMapping(value="/exportZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxBuyProgress(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 入库
	* @param zx_buy_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/inZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String inZxBuyProgress(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyProgress){
			i=zxBuyProgressService.updateZxBuyProgress(zxBuyProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 出库
	* @param zx_buy_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/outZxBuyProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String outZxBuyProgress(ZxBuyProgress zxBuyProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyProgress){
			i=zxBuyProgressService.updateZxBuyProgress(zxBuyProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
