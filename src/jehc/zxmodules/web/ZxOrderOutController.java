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
import jehc.zxmodules.model.ZxOrderOut;
import jehc.zxmodules.model.ZxOrderOutWorkpiece;
import jehc.zxmodules.model.ZxOutApplyWorkpiece;
import jehc.zxmodules.model.ZxOutProgress;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxBuyApplyService;
import jehc.zxmodules.service.ZxMaterialService;
import jehc.zxmodules.service.ZxOrderOutService;
import jehc.zxmodules.service.ZxOrderOutWorkpieceService;
import jehc.zxmodules.service.ZxOutApplyWorkpieceService;
import jehc.zxmodules.service.ZxOutProgressService;
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
* 外协订单表 
* 2017-11-03 16:56:45  c
*/
@Controller
@RequestMapping("/zxOrderOutController")
public class ZxOrderOutController extends BaseAction{
	@Autowired
	private ZxOrderOutService zxOrderOutService;
	@Autowired
	private ZxOrderOutWorkpieceService zxOrderOutWorkpieceService;
	@Autowired
	private ZxOutApplyWorkpieceService zxOutApplyWorkpieceService;
	@Autowired
	private ZxOutProgressService zxOutProgressService;
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
	* @param zx_order_out 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderOut(ZxOrderOut zxOrderOut,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-order-out/zx-order-out-list");
	}
	/**
	* 载入采购员跟单页面
	* @param zx_order_buy 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderOutEdit",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderOutEdit(ZxOrderOut zxOrderOut,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-order-out/zx-order-out-edit");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_order_out 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderOutListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderOutListByCondition(BaseSearch baseSearch,String buy_user_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("orderby", "1");
		if(StringUtils.isNotBlank(buy_user_id)){
			condition.put("buy_user_id", "buy_user_id");
		}
		List<ZxOrderOut> zxOrderOutList = zxOrderOutService.getZxOrderOutListByCondition(condition);
		for(ZxOrderOut zxOrderOut:zxOrderOutList){
			String items = "";
			XtUserinfo buyUser = xtUserinfoService.getXtUserinfoById(zxOrderOut.getBuy_user_id());
			ZxSupplier supplier = zxSupplierService.getZxSupplierById(zxOrderOut.getSuppier_id());
			items += buyUser.getXt_userinfo_realName()+",";
			items += supplier.getName()+",";
			zxOrderOut.setItem(items);
		}
		PageInfo<ZxOrderOut> page = new PageInfo<ZxOrderOut>(zxOrderOutList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderOutById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderOutById(String id,HttpServletRequest request){
		ZxOrderOut zxOrderOut = zxOrderOutService.getZxOrderOutById(id);
		String outStr = outDataStr(zxOrderOut);
		XtUserinfo buyUser = xtUserinfoService.getXtUserinfoById(zxOrderOut.getBuy_user_id());
		ZxSupplier supplier = zxSupplierService.getZxSupplierById(zxOrderOut.getSuppier_id());
		
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
	* @param zx_order_out 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOrderOut(ZxOrderOut zxOrderOut,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderOut){
			zxOrderOut.setId(UUID.toUUID());
			zxOrderOut.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxOrderOut.setCreate_user_id(getXtUid());
			i=zxOrderOutService.addZxOrderOut(zxOrderOut);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_order_out 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOrderOut(ZxOrderOut zxOrderOut,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderOut){
			i=zxOrderOutService.updateZxOrderOut(zxOrderOut);
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
	@RequestMapping(value="/delZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOrderOut(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOrderOutService.delZxOrderOut(condition);
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
	@RequestMapping(value="/copyZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOrderOut(String id,HttpServletRequest request){
		int i = 0;
		ZxOrderOut zxOrderOut = zxOrderOutService.getZxOrderOutById(id);
		if(null != zxOrderOut){
			zxOrderOut.setId(UUID.toUUID());
			i=zxOrderOutService.addZxOrderOut(zxOrderOut);
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
	@RequestMapping(value="/exportZxOrderOut",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOrderOut(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
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
	@RequestMapping(value="/getWorkpieceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getUserinfoListByCondition(String flag,String order_id,String apply_id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> condition = new HashMap<String, Object>();
		commonHPager(condition,request);
		condition.put("flag", flag);
		condition.put("order_id", order_id);
		if(null != apply_id && !"0".equals(apply_id)){
			condition.put("apply_id", apply_id);
		}
		List<Map<String, Object>> zxBuyApplyMaterialList = zxOrderOutService.getZxOWListByCondition(condition);
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
	public String addZxOM(String apply_workpiece_id,String workpiece_id, String order_id,HttpServletRequest request){
		List<ZxOrderOutWorkpiece> zx_O_MList = new ArrayList<ZxOrderOutWorkpiece>();
		if(null != apply_workpiece_id && !"".equals(apply_workpiece_id)){
			ZxOrderOut order = zxOrderOutService.getZxOrderOutById(order_id);
			String[] idList = apply_workpiece_id.split(",");
			String[] midList = workpiece_id.split(",");
			for(int j = 0; j < idList.length; j++){
				String uuid = UUID.toUUID();
				ZxOrderOutWorkpiece zx_O_M = new ZxOrderOutWorkpiece();
				zx_O_M.setApply_workpiece_id(idList[j]);
				zx_O_M.setId(uuid);
				zx_O_M.setWorkpiece_id(midList[j]);
				zx_O_M.setOrder_id(order_id);
				zx_O_M.setAgree_time(order.getAgree_time());
				zx_O_MList.add(zx_O_M);
			}
			editProgress(idList,order, 1);
		}
		int i=zxOrderOutWorkpieceService.addBatchZxOrderOutWorkpiece(zx_O_MList);
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
	public String delZxOM(String apply_workpiece_id, String order_id,HttpServletRequest request){
		ZxOrderOut order = zxOrderOutService.getZxOrderOutById(order_id);
		Map<String, Object> condition = new HashMap<String, Object>();
		String[] idList = apply_workpiece_id.split(",");
		condition.put("apply_workpiece_id", idList);
		condition.put("order_id", order_id);
		int i=zxOrderOutWorkpieceService.delZxOW(condition);
		if(i>0){
			editProgress(idList,order, 2);
			return outAudStr(true, CommonUtils.getCacheStr("sys_remove_material_sucess"));
		}else{
			return outAudStr(false, CommonUtils.getCacheStr("sys_remove_material_error"));
		}
	}
	
	public void editProgress(String[] idList,ZxOrderOut order,int type){
		List<ZxOutProgress> updateProgress = new ArrayList<ZxOutProgress>();
		for(String id : idList){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("apply_id", id);
			if(type == 2){
				condition.put("order_id", order.getId());
			}
			List<Map<String,Object>> progresss = zxOutProgressService.getZxOutProgressListByCondition(condition);
			if(null != progresss && progresss.size() > 0){
				ZxOutApplyWorkpiece ow = zxOutApplyWorkpieceService.getZxOutApplyWorkpieceById(id);
				ZxOutProgress progress = zxOutProgressService.getZxOutProgressById(progresss.get(0).get("id").toString());
				if(type == 1){//添加进度信息
					progress.setBuy_time(order.getBuy_time());
					progress.setOut_amount(Double.parseDouble(ow.getAmount()));
					progress.setBuy_user_id(order.getBuy_user_id());
					progress.setOrder_id(order.getId());
					progress.setStatus("2");
					progress.setSupplier_id(order.getSuppier_id());
				}else if(type == 2){//去除进度信息
					progress.setBuy_time(null);
					progress.setOut_amount(Double.parseDouble(ow.getAmount()));
					progress.setBuy_user_id(null);
					progress.setOrder_id(null);
					progress.setStatus("1");
					progress.setSupplier_id(null);
				}
				updateProgress.add(progress);
			}
		}
		if(updateProgress.size() > 0){
			zxOutProgressService.updateBatchZxOutProgress(updateProgress);
		}
	}
	
}
