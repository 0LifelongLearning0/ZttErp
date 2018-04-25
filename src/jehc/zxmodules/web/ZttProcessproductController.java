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
import jehc.zxmodules.model.ZttProcessproduct;
import jehc.zxmodules.service.ZttProcessproductService;

/**
* 机械加工工艺过程表 
* 2018-04-24 08:34:08  季建吉
*/
@Controller
@RequestMapping("/zttProcessproductController")
public class ZttProcessproductController extends BaseAction{
	@Autowired
	private ZttProcessproductService zttProcessproductService;
	/**
	* 载入初始化页面
	* @param ztt_processproduct 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttProcessproduct(ZttProcessproduct zttProcessproduct,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-processproduct/ztt-processproduct-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_processproduct 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttProcessproductListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttProcessproductListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("parentId",request.getParameter("parentId"));
		List<ZttProcessproduct> zttProcessproductList = zttProcessproductService.getZttProcessproductListByCondition(condition);
		PageInfo<ZttProcessproduct> page = new PageInfo<ZttProcessproduct>(zttProcessproductList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttProcessproductById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttProcessproductById(String id,HttpServletRequest request){
		ZttProcessproduct zttProcessproduct = zttProcessproductService.getZttProcessproductById(id);
		return outDataStr(zttProcessproduct);
	}
	/**
	* 添加
	* @param ztt_processproduct 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttProcessproduct(ZttProcessproduct zttProcessproduct,HttpServletRequest request){
		int i = 0;
		if(null != zttProcessproduct && !"".equals(zttProcessproduct)){
			zttProcessproduct.setId(UUID.toUUID());
			i=zttProcessproductService.addZttProcessproduct(zttProcessproduct);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_processproduct 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttProcessproduct(ZttProcessproduct zttProcessproduct,HttpServletRequest request){
		int i = 0;
		if(null != zttProcessproduct && !"".equals(zttProcessproduct)){
			i=zttProcessproductService.updateZttProcessproduct(zttProcessproduct);
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
	@RequestMapping(value="/delZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttProcessproduct(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttProcessproductService.delZttProcessproduct(condition);
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
	@RequestMapping(value="/copyZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttProcessproduct(String id,HttpServletRequest request){
		int i = 0;
		ZttProcessproduct zttProcessproduct = zttProcessproductService.getZttProcessproductById(id);
		if(null != zttProcessproduct && !"".equals(zttProcessproduct)){
			zttProcessproduct.setId(UUID.toUUID());
			i=zttProcessproductService.addZttProcessproduct(zttProcessproduct);
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
	@RequestMapping(value="/exportZttProcessproduct",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttProcessproduct(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductAdd(ZttProcessproduct zttProcessproduct,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-processproduct/ztt-processproduct-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductUpdate(String id,HttpServletRequest request, Model model){
		ZttProcessproduct zttProcessproduct = zttProcessproductService.getZttProcessproductById(id);
		model.addAttribute("zttProcessproduct", zttProcessproduct);
		return new ModelAndView("pc/zx-view/ztt-processproduct/ztt-processproduct-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttProcessproductDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttProcessproductDetail(String id,HttpServletRequest request, Model model){
		ZttProcessproduct zttProcessproduct = zttProcessproductService.getZttProcessproductById(id);
		model.addAttribute("zttProcessproduct", zttProcessproduct);
		return new ModelAndView("pc/zx-view/ztt-processproduct/ztt-processproduct-detail");
	}
}
