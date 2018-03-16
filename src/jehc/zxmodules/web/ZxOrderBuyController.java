package jehc.zxmodules.web;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxBuyApplyMaterial;
import jehc.zxmodules.model.ZxBuyProgress;
import jehc.zxmodules.model.ZxOrderBuy;
import jehc.zxmodules.model.ZxOrderBuyMaterial;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxBuyApplyMaterialService;
import jehc.zxmodules.service.ZxBuyApplyService;
import jehc.zxmodules.service.ZxBuyProgressService;
import jehc.zxmodules.service.ZxMaterialService;
import jehc.zxmodules.service.ZxOrderBuyMaterialService;
import jehc.zxmodules.service.ZxOrderBuyService;
import jehc.zxmodules.service.ZxSupplierService;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 采购订单 
* 2017-10-30 11:01:28  陈运芝
*/
@Controller
@RequestMapping("/zxOrderBuyController")
public class ZxOrderBuyController extends BaseAction{
	@Autowired
	private ZxOrderBuyService zxOrderBuyService;
	@Autowired
	private ZxOrderBuyMaterialService zxOrderBuyMaterialService;
	@Autowired
	private ZxBuyApplyMaterialService zxBuyApplyMaterialService;
	@Autowired
	private ZxBuyProgressService zxBuyProgressService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private ZxSupplierService zxSupplierService;
	@Autowired
	private ZxBuyApplyService zxBuyApplyService;
	@Autowired
	private ZxMaterialService zxMaterialService;
	/**
	* 载入初始化页面
	* @param zx_order_buy 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderBuy(ZxOrderBuy zxOrderBuy,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-order-buy/zx-order-buy-list");
	}
	/**
	* 载入采购员跟单页面
	* @param zx_order_buy 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderBuyEdit",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderBuyEdit(ZxOrderBuy zxOrderBuy,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-order-buy/zx-order-buy-edit");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_order_buy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderBuyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderBuyListByCondition(BaseSearch baseSearch,String buy_user_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("orderby", "1");
		if(StringUtils.isNotBlank(buy_user_id)){
			condition.put("buy_user_id", "buy_user_id");
		}
		List<ZxOrderBuy> zxOrderBuyList = zxOrderBuyService.getZxOrderBuyListByCondition(condition);
		for(ZxOrderBuy zxOrderBuy:zxOrderBuyList){
			String items = "";
			XtUserinfo buyUser = xtUserinfoService.getXtUserinfoById(zxOrderBuy.getBuy_user_id());
			ZxSupplier supplier = zxSupplierService.getZxSupplierById(zxOrderBuy.getSuppier_id());
			items += buyUser.getXt_userinfo_realName()+",";
			items += supplier.getName()+",";
			zxOrderBuy.setItem(items);
		}
		PageInfo<ZxOrderBuy> page = new PageInfo<ZxOrderBuy>(zxOrderBuyList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderBuyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderBuyById(String id,HttpServletRequest request){
		ZxOrderBuy zxOrderBuy = zxOrderBuyService.getZxOrderBuyById(id);
		String outStr = outDataStr(zxOrderBuy);
		XtUserinfo buyUser = xtUserinfoService.getXtUserinfoById(zxOrderBuy.getBuy_user_id());
		ZxSupplier supplier = zxSupplierService.getZxSupplierById(zxOrderBuy.getSuppier_id());
		
		JSONArray jsonArray = JSONArray.fromObject(buyUser); 
		String jsonStr = jsonArray.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		
		JSONArray jsonArrayA = JSONArray.fromObject(supplier); 
		String jsonStrA = jsonArrayA.toString();
		jsonStrA = jsonStrA.substring(1,jsonStrA.length()-1);
		
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"buyUser\":").concat(jsonStr).concat(",\"supplier\":").concat(jsonStrA)
				.concat(outStr.substring(outStr.length()-2,outStr.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_order_buy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOrderBuy(ZxOrderBuy zxOrderBuy,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderBuy){
			zxOrderBuy.setId(UUID.toUUID());
			zxOrderBuy.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxOrderBuy.setCreate_user_id(getXtUid());
			i=zxOrderBuyService.addZxOrderBuy(zxOrderBuy);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_order_buy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOrderBuy(ZxOrderBuy zxOrderBuy,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderBuy){
			i=zxOrderBuyService.updateZxOrderBuy(zxOrderBuy);
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
	@RequestMapping(value="/delZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOrderBuy(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOrderBuyService.delZxOrderBuy(condition);
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
	@RequestMapping(value="/copyZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOrderBuy(String id,HttpServletRequest request){
		int i = 0;
		ZxOrderBuy zxOrderBuy = zxOrderBuyService.getZxOrderBuyById(id);
		if(null != zxOrderBuy){
			zxOrderBuy.setId(UUID.toUUID());
			i=zxOrderBuyService.addZxOrderBuy(zxOrderBuy);
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
	@RequestMapping(value="/exportZxOrderBuy",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOrderBuy(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	

	/**
	 * 读取物料订单列表【申请物料对订单】
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value="/getMaterialListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getUserinfoListByCondition(String flag,String order_id,String apply_id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> condition = new HashMap<String, Object>();
		commonHPager(condition,request);
		condition.put("flag", flag);
		condition.put("order_id", order_id);
		if(null != apply_id && !"0".equals(apply_id)){
			condition.put("apply_id", apply_id);
		}
		List<Map<String, Object>> zxBuyApplyMaterialList = zxOrderBuyService.getZxOMListByCondition(condition);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(zxBuyApplyMaterialList);
		return outPageStr(page,request);
	}
	/**
	* 导入物料信息
	* @param zx_o_m 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOM",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOM(String apply_material_id,String material_id, String order_id,HttpServletRequest request){
		List<ZxOrderBuyMaterial> zx_O_MList = new ArrayList<ZxOrderBuyMaterial>();
		if(null != apply_material_id && !"".equals(apply_material_id)){
			ZxOrderBuy order = zxOrderBuyService.getZxOrderBuyById(order_id);
			String[] idList = apply_material_id.split(",");
			String[] midList = material_id.split(",");
			for(int j = 0; j < idList.length; j++){
				String uuid = UUID.toUUID();
				ZxOrderBuyMaterial zx_O_M = new ZxOrderBuyMaterial();
				zx_O_M.setApply_material_id(idList[j]);
				zx_O_M.setId(uuid);
				zx_O_M.setMaterial_id(midList[j]);
				zx_O_M.setOrder_id(order_id);
				zx_O_M.setAgree_time(order.getAgree_time());
				zx_O_MList.add(zx_O_M);
			}
			editProgress(idList,order, 1);
		}
		int i=zxOrderBuyMaterialService.addBatchZxOrderBuyMaterial(zx_O_MList);
		if(i>0){
			return outAudStr(true, CommonUtils.getCacheStr("sys_import_material_sucess"));
		}else{
			return outAudStr(false, CommonUtils.getCacheStr("sys_import_material_error"));
		}
	}
	
	/**
	 * 移除物料信息
	 * @param xt_userinfo_id
	 * @param xt_role_id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/delZxOM",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOM(String apply_material_id, String order_id,HttpServletRequest request){
		ZxOrderBuy order = zxOrderBuyService.getZxOrderBuyById(order_id);
		Map<String, Object> condition = new HashMap<String, Object>();
		String[] idList = apply_material_id.split(",");
		condition.put("apply_material_id", idList);
		condition.put("order_id", order_id);
		int i=zxOrderBuyMaterialService.delZxOM(condition);
		if(i>0){
			editProgress(idList,order, 2);
			return outAudStr(true, CommonUtils.getCacheStr("sys_remove_material_sucess"));
		}else{
			return outAudStr(false, CommonUtils.getCacheStr("sys_remove_material_error"));
		}
	}
	
	public void editProgress(String[] idList,ZxOrderBuy order,int type){
		List<ZxBuyProgress> updateProgress = new ArrayList<ZxBuyProgress>();
		for(String id : idList){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("apply_id", id);
			if(type == 2){
				condition.put("order_id", order.getId());
			}
			List<Map<String,Object>> progresss = zxBuyProgressService.getZxBuyProgressListByCondition(condition);
			if(null != progresss && progresss.size() > 0){
				ZxBuyApplyMaterial om = zxBuyApplyMaterialService.getZxBuyApplyMaterialById(id);
				ZxBuyProgress progress = zxBuyProgressService.getZxBuyProgressById(progresss.get(0).get("id").toString());
				if(type == 1){//添加进度信息
					progress.setBuy_time(order.getBuy_time());
					progress.setBuy_amount(Double.parseDouble(om.getAmount()));
					progress.setBuy_user_id(order.getBuy_user_id());
					progress.setOrder_id(order.getId());
					progress.setStatus("2");
					progress.setSuppier_id(order.getSuppier_id());
				}else if(type == 2){//去除进度信息
					progress.setBuy_time(null);
					progress.setBuy_amount(Double.parseDouble(om.getAmount()));
					progress.setBuy_user_id(null);
					progress.setOrder_id(null);
					progress.setStatus("1");
					progress.setSuppier_id(null);
				}
				updateProgress.add(progress);
			}
		}
		if(updateProgress.size() > 0){
			zxBuyProgressService.updateBatchZxBuyProgress(updateProgress);
		}
	}
}
