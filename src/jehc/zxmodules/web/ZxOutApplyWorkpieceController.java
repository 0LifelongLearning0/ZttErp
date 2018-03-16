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
import jehc.zxmodules.model.ZxOutApplyWorkpiece;
import jehc.zxmodules.model.ZxWorkpiece;
import jehc.zxmodules.service.ZxOutApplyService;
import jehc.zxmodules.service.ZxOutApplyWorkpieceService;
import jehc.zxmodules.service.ZxWorkpieceService;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 外协申请工件详情单 
* 2017-11-01 16:34:19  陈运芝
*/
@Controller
@RequestMapping("/zxOutApplyWorkpieceController")
public class ZxOutApplyWorkpieceController extends BaseAction{
	@Autowired
	private ZxOutApplyWorkpieceService zxOutApplyWorkpieceService;
	@Autowired
	private ZxOutApplyService zxOutApplyService;
	@Autowired
	private ZxWorkpieceService zxWorkpieceService;
	/**
	* 载入初始化页面
	* @param zx_out_apply_workpiece 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece,HttpServletRequest request,Model model){
		model.addAttribute("zxOutApplyWorkpiece",zxOutApplyWorkpiece);
		model.addAttribute("zxOutApply",zxOutApplyService.getZxOutApplyById(zxOutApplyWorkpiece.getApply_id()));
		return new ModelAndView("pc/zx-view/zx-out-apply/zx-out-apply-workpiece-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_out_apply_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutApplyWorkpieceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutApplyWorkpieceListByCondition(BaseSearch baseSearch,String apply_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("apply_id", apply_id);
		List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList = zxOutApplyWorkpieceService.getZxOutApplyWorkpieceListByCondition(condition);
		for(ZxOutApplyWorkpiece workpiece : zxOutApplyWorkpieceList){
			workpiece.setItem(zxWorkpieceService.getZxWorkpieceById(workpiece.getWorkpiece_id()));
		}
		PageInfo<ZxOutApplyWorkpiece> page = new PageInfo<ZxOutApplyWorkpiece>(zxOutApplyWorkpieceList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutApplyWorkpieceById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutApplyWorkpieceById(String id,HttpServletRequest request){
		ZxOutApplyWorkpiece zxOutApplyWorkpiece = zxOutApplyWorkpieceService.getZxOutApplyWorkpieceById(id);
		String outStr = outDataStr(zxOutApplyWorkpiece);
		ZxWorkpiece workpiece = zxWorkpieceService.getZxWorkpieceById(zxOutApplyWorkpiece.getWorkpiece_id());
		JSONArray jsonArray = JSONArray.fromObject(workpiece); 
		String jsonStr = jsonArray.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"workpiece\":").concat(jsonStr).concat(outStr.substring(outStr.length()-2,outStr.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_out_apply_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxOutApplyWorkpiece){
			zxOutApplyWorkpiece.setId(UUID.toUUID());
			i=zxOutApplyWorkpieceService.addZxOutApplyWorkpiece(zxOutApplyWorkpiece);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_out_apply_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxOutApplyWorkpiece){
			i=zxOutApplyWorkpieceService.updateZxOutApplyWorkpiece(zxOutApplyWorkpiece);
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
	@RequestMapping(value="/delZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutApplyWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutApplyWorkpieceService.delZxOutApplyWorkpiece(condition);
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
	@RequestMapping(value="/copyZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutApplyWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		ZxOutApplyWorkpiece zxOutApplyWorkpiece = zxOutApplyWorkpieceService.getZxOutApplyWorkpieceById(id);
		if(null != zxOutApplyWorkpiece){
			zxOutApplyWorkpiece.setId(UUID.toUUID());
			i=zxOutApplyWorkpieceService.addZxOutApplyWorkpiece(zxOutApplyWorkpiece);
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
	@RequestMapping(value="/exportZxOutApplyWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutApplyWorkpiece(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
