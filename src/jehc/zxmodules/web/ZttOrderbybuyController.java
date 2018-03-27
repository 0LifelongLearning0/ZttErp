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
import jehc.zxmodules.model.ZttOrderbybuy;
import jehc.zxmodules.service.ZttOrderbybuyService;

/**
* 外协单表 
* 2018-03-21 10:45:03  季建吉
*/
@Controller
@RequestMapping("/zttOrderbybuyController")
public class ZttOrderbybuyController extends BaseAction{
	@Autowired
	private ZttOrderbybuyService zttOrderbybuyService;
	/**
	* 载入初始化页面
	* @param ztt_orderbybuy 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttOrderbybuy(ZttOrderbybuy zttOrderbybuy,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_orderbybuy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderbybuyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderbybuyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttOrderbybuy> zttOrderbybuyList = zttOrderbybuyService.getZttOrderbybuyListByCondition(condition);
		PageInfo<ZttOrderbybuy> page = new PageInfo<ZttOrderbybuy>(zttOrderbybuyList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderbybuyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderbybuyById(String id,HttpServletRequest request){
		ZttOrderbybuy zttOrderbybuy = zttOrderbybuyService.getZttOrderbybuyById(id);
		return outDataStr(zttOrderbybuy);
	}
	/**
	* 添加
	* @param ztt_orderbybuy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttOrderbybuy(ZttOrderbybuy zttOrderbybuy,HttpServletRequest request){
		int i = 0;
		if(null != zttOrderbybuy && !"".equals(zttOrderbybuy)){
			zttOrderbybuy.setId(UUID.toUUID());
			i=zttOrderbybuyService.addZttOrderbybuy(zttOrderbybuy);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_orderbybuy 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttOrderbybuy(ZttOrderbybuy zttOrderbybuy,HttpServletRequest request){
		int i = 0;
		if(null != zttOrderbybuy && !"".equals(zttOrderbybuy)){
			i=zttOrderbybuyService.updateZttOrderbybuy(zttOrderbybuy);
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
	@RequestMapping(value="/delZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttOrderbybuy(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttOrderbybuyService.delZttOrderbybuy(condition);
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
	@RequestMapping(value="/copyZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttOrderbybuy(String id,HttpServletRequest request){
		int i = 0;
		ZttOrderbybuy zttOrderbybuy = zttOrderbybuyService.getZttOrderbybuyById(id);
		if(null != zttOrderbybuy && !"".equals(zttOrderbybuy)){
			zttOrderbybuy.setId(UUID.toUUID());
			i=zttOrderbybuyService.addZttOrderbybuy(zttOrderbybuy);
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
	@RequestMapping(value="/exportZttOrderbybuy",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttOrderbybuy(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbybuyAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbybuyAdd(ZttOrderbybuy zttOrderbybuy,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbybuyUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbybuyUpdate(String id,HttpServletRequest request, Model model){
		ZttOrderbybuy zttOrderbybuy = zttOrderbybuyService.getZttOrderbybuyById(id);
		model.addAttribute("zttOrderbybuy", zttOrderbybuy);
		return new ModelAndView("pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderbybuyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderbybuyDetail(String id,HttpServletRequest request, Model model){
		ZttOrderbybuy zttOrderbybuy = zttOrderbybuyService.getZttOrderbybuyById(id);
		model.addAttribute("zttOrderbybuy", zttOrderbybuy);
		return new ModelAndView("pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-detail");
	}
}
