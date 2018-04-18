package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.annotation.AuthUneedLogin;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZttCodeversion;
import jehc.zxmodules.service.ZttCodeversionService;

/**
* 代码版本控制 
* 2018-04-17 12:58:09  季建吉
*/
@Controller
@RequestMapping("/zttCodeversionController")

public class ZttCodeversionController extends BaseAction{
	@Autowired
	private ZttCodeversionService zttCodeversionService;
	/**
	* 载入初始化页面
	* @param ztt_codeversion 
	* @param request 
	* @return
	*/
	
	@RequestMapping(value="/loadZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttCodeversion(ZttCodeversion zttCodeversion,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-codeversion/ztt-codeversion-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_codeversion 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttCodeversionListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttCodeversionListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttCodeversion> zttCodeversionList = zttCodeversionService.getZttCodeversionListByCondition(condition);
		PageInfo<ZttCodeversion> page = new PageInfo<ZttCodeversion>(zttCodeversionList);
		return outPageBootStr(page,request);
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_codeversion 
	* @param request 
	*/
	@AuthUneedLogin
	@ResponseBody
	@RequestMapping(value = "/getZttCodeversion", method = RequestMethod.GET,produces="text/html; charset=UTF-8")
	public String getZttCodeversion(@RequestBody String data){
		String result = data;
		String version=result.split("=")[1];
        	
		return result;
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttCodeversionById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttCodeversionById(String id,HttpServletRequest request){
		ZttCodeversion zttCodeversion = zttCodeversionService.getZttCodeversionById(id);
		return outDataStr(zttCodeversion);
	}
	/**
	* 添加
	* @param ztt_codeversion 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttCodeversion(ZttCodeversion zttCodeversion,HttpServletRequest request){
		int i = 0;
		if(null != zttCodeversion && !"".equals(zttCodeversion)){
			zttCodeversion.setId(UUID.toUUID());
			i=zttCodeversionService.addZttCodeversion(zttCodeversion);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_codeversion 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttCodeversion(ZttCodeversion zttCodeversion,HttpServletRequest request){
		int i = 0;
		if(null != zttCodeversion && !"".equals(zttCodeversion)){
			i=zttCodeversionService.updateZttCodeversion(zttCodeversion);
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
	@RequestMapping(value="/delZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttCodeversion(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttCodeversionService.delZttCodeversion(condition);
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
	@RequestMapping(value="/copyZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttCodeversion(String id,HttpServletRequest request){
		int i = 0;
		ZttCodeversion zttCodeversion = zttCodeversionService.getZttCodeversionById(id);
		if(null != zttCodeversion && !"".equals(zttCodeversion)){
			zttCodeversion.setId(UUID.toUUID());
			i=zttCodeversionService.addZttCodeversion(zttCodeversion);
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
	@RequestMapping(value="/exportZttCodeversion",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttCodeversion(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttCodeversionAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttCodeversionAdd(ZttCodeversion zttCodeversion,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-codeversion/ztt-codeversion-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttCodeversionUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttCodeversionUpdate(String id,HttpServletRequest request, Model model){
		ZttCodeversion zttCodeversion = zttCodeversionService.getZttCodeversionById(id);
		model.addAttribute("zttCodeversion", zttCodeversion);
		return new ModelAndView("pc/zx-view/ztt-codeversion/ztt-codeversion-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttCodeversionDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttCodeversionDetail(String id,HttpServletRequest request, Model model){
		ZttCodeversion zttCodeversion = zttCodeversionService.getZttCodeversionById(id);
		model.addAttribute("zttCodeversion", zttCodeversion);
		return new ModelAndView("pc/zx-view/ztt-codeversion/ztt-codeversion-detail");
	}
}
