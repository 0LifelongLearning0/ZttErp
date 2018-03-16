package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxOrderBuyMaterial;
import jehc.zxmodules.service.ZxOrderBuyMaterialService;
import jehc.zxmodules.service.ZxOrderBuyService;

/**
* 采购订单物料表 
* 2017-10-30 11:03:07  陈运芝
*/
@Controller
@RequestMapping("/zxOrderBuyMaterialController")
public class ZxOrderBuyMaterialController extends BaseAction{
	@Autowired
	private ZxOrderBuyMaterialService zxOrderBuyMaterialService;
	@Autowired
	private ZxOrderBuyService zxOrderBuyService;
	/**
	* 载入初始化页面
	* @param zx_order_buy_material 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial,HttpServletRequest request,Model model){
		model.addAttribute("zxOrderBuyMaterial",zxOrderBuyMaterial);
		model.addAttribute("zxBuyOrder",zxOrderBuyService.getZxOrderBuyById(zxOrderBuyMaterial.getOrder_id()));
		return new ModelAndView("pc/zx-view/zx-order-buy/zx-order-buy-material-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_order_buy_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderBuyMaterialListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderBuyMaterialListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOrderBuyMaterial> zxOrderBuyMaterialList = zxOrderBuyMaterialService.getZxOrderBuyMaterialListByCondition(condition);
		PageInfo<ZxOrderBuyMaterial> page = new PageInfo<ZxOrderBuyMaterial>(zxOrderBuyMaterialList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderBuyMaterialById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderBuyMaterialById(String id,HttpServletRequest request){
		ZxOrderBuyMaterial zxOrderBuyMaterial = zxOrderBuyMaterialService.getZxOrderBuyMaterialById(id);
		return outDataStr(zxOrderBuyMaterial);
	}
	/**
	* 添加
	* @param zx_order_buy_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderBuyMaterial){
			zxOrderBuyMaterial.setId(UUID.toUUID());
			i=zxOrderBuyMaterialService.addZxOrderBuyMaterial(zxOrderBuyMaterial);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_order_buy_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOrderBuyMaterial(ZxOrderBuyMaterial zxOrderBuyMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderBuyMaterial){
			i=zxOrderBuyMaterialService.updateZxOrderBuyMaterial(zxOrderBuyMaterial);
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
	@RequestMapping(value="/delZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOrderBuyMaterial(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOrderBuyMaterialService.delZxOrderBuyMaterial(condition);
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
	@RequestMapping(value="/copyZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOrderBuyMaterial(String id,HttpServletRequest request){
		int i = 0;
		ZxOrderBuyMaterial zxOrderBuyMaterial = zxOrderBuyMaterialService.getZxOrderBuyMaterialById(id);
		if(null != zxOrderBuyMaterial){
			zxOrderBuyMaterial.setId(UUID.toUUID());
			i=zxOrderBuyMaterialService.addZxOrderBuyMaterial(zxOrderBuyMaterial);
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
	@RequestMapping(value="/exportZxOrderBuyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOrderBuyMaterial(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
