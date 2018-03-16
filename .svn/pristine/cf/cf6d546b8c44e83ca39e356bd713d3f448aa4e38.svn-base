package jehc.zxmodules.web;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxOutsource;
import jehc.zxmodules.model.ZxOutsourceTime;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.model.ZxWorkpiece;
import jehc.zxmodules.service.ZxConcordatService;
import jehc.zxmodules.service.ZxOrderBuyService;
import jehc.zxmodules.service.ZxOutsourceService;
import jehc.zxmodules.service.ZxOutsourceTimeService;
import jehc.zxmodules.service.ZxSupplierService;
import jehc.zxmodules.service.ZxWorkpieceService;
import net.sf.json.JSONArray;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 外协加工进度表 
* 2017-09-01 09:30:59  陈运芝
*/
@Controller
@RequestMapping("/zxOutsourceController")
public class ZxOutsourceController extends BaseAction{
	@Autowired
	private ZxWorkpieceService zxWorkpieceService;
	@Autowired
	private ZxOrderBuyService zxOrderBuyService;
	@Autowired
	private ZxConcordatService zxConcordatService;
	@Autowired
	private ZxSupplierService zxSupplierService;
	@Autowired
	private ZxOutsourceService zxOutsourceService;
	@Autowired
	private ZxOutsourceTimeService zxOutsourceTimeService;
	/**
	* 载入初始化页面
	* @param zx_outsource 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutsource(ZxOutsource zxOutsource,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-outsource/zx-outsource-list");
	}
	/**
	* 载入初始化页面:生产
	* @param zx_outsource 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutsourceWorking",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutsourceWorking(ZxOutsource zxOutsource,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-outsource/zx-outsource-working-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_outsource 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutsourceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutsourceListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		if(null != condition.get("workpiece_id")){
			Map<String, Object> conditionWork = new HashMap<>();
			conditionWork.put("num", condition.get("workpiece_id"));
			List<ZxWorkpiece> work = zxWorkpieceService.getZxWorkpieceListByCondition(conditionWork);
			if(null != work && work.size() > 0){
				condition.put("workpiece_id", work.get(0).getId());
			}
		}
		List<ZxOutsource> zxOutsourceList = zxOutsourceService.getZxOutsourceListByCondition(condition);
		for(ZxOutsource zxOutsource:zxOutsourceList){
			zxOutsource.setItem(zxWorkpieceService.getZxWorkpieceById(zxOutsource.getWorkpiece_id()));
		}
		PageInfo<ZxOutsource> page = new PageInfo<ZxOutsource>(zxOutsourceList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutsourceById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutsourceById(String id,HttpServletRequest request){
		ZxOutsource zxOutsource = zxOutsourceService.getZxOutsourceById(id);
		String outStr = outDataStr(zxOutsource);
		ZxWorkpiece workpiece = zxWorkpieceService.getZxWorkpieceById(zxOutsource.getWorkpiece_id());
		ZxSupplier machine = zxSupplierService.getZxSupplierById(zxOutsource.getMachine_id());
		JSONArray jsonArray = JSONArray.fromObject(workpiece); 
		String jsonStr = jsonArray.toString();
		JSONArray jsonArrayb = JSONArray.fromObject(machine); 
		String jsonStrb = jsonArrayb.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		jsonStrb = jsonStrb.substring(1,jsonStrb.length()-1);
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"workpiece\":").concat(jsonStr).concat(",\"machine\":").concat(jsonStrb)
				.concat(outStr.substring(outStr.length()-2,outStr.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_outsource 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutsource(ZxOutsource zxOutsource,HttpServletRequest request){
		int i = 0;
		if(null != zxOutsource){
			zxOutsource.setId(UUID.toUUID());
			zxOutsource.setCreate_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxOutsourceService.addZxOutsource(zxOutsource);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_outsource 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutsource(ZxOutsource zxOutsource,HttpServletRequest request){
		int i = 0;
		if(null != zxOutsource){
			i=zxOutsourceService.updateZxOutsource(zxOutsource);
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
	@RequestMapping(value="/delZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutsource(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutsourceService.delZxOutsource(condition);
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
	@RequestMapping(value="/copyZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutsource(String id,HttpServletRequest request){
		int i = 0;
		ZxOutsource zxOutsource = zxOutsourceService.getZxOutsourceById(id);
		if(null != zxOutsource){
			zxOutsource.setId(UUID.toUUID());
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			List<ZxOutsourceTime> zxOutsourceTimeList = zxOutsourceTimeService.getZxOutsourceTimeListByCondition(condition);
			zxOutsource.setZxOutsourceTime(zxOutsourceTimeList);
			i=zxOutsourceService.addZxOutsource(zxOutsource);
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
	@RequestMapping(value="/exportZxOutsource",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutsource(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
