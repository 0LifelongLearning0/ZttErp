package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import jehc.zxmodules.model.ZttMouldsDeivice;
import jehc.zxmodules.service.ZttMouldsDeiviceService;
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
import jehc.zxmodules.model.ZttMouldsGongxu;
import jehc.zxmodules.service.ZttMouldsGongxuService;

/**
* 模具部工序 
* 2018-05-24 16:46:19  季建吉
*/
@Controller
@RequestMapping("/zttMouldsGongxuController")
public class ZttMouldsGongxuController extends BaseAction{
	@Autowired
	private ZttMouldsGongxuService zttMouldsGongxuService;
	@Autowired
	private ZttMouldsDeiviceService zttMouldsDeiviceService;
	/**
	* 载入初始化页面
	* @param ztt_moulds_gongxu 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_moulds_gongxu 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMouldsGongxuListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMouldsGongxuListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttMouldsGongxu> zttMouldsGongxuList = zttMouldsGongxuService.getZttMouldsGongxuListByCondition(condition);
		PageInfo<ZttMouldsGongxu> page = new PageInfo<ZttMouldsGongxu>(zttMouldsGongxuList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttMouldsGongxuById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttMouldsGongxuById(String id,HttpServletRequest request){
		ZttMouldsGongxu zttMouldsGongxu = zttMouldsGongxuService.getZttMouldsGongxuById(id);
		return outDataStr(zttMouldsGongxu);
	}
	/**
	* 添加
	* @param ztt_moulds_gongxu 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu,HttpServletRequest request){
		int i = 0;
		if(null != zttMouldsGongxu && !"".equals(zttMouldsGongxu)){
			zttMouldsGongxu.setId(UUID.toUUID());
			i=zttMouldsGongxuService.addZttMouldsGongxu(zttMouldsGongxu);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_moulds_gongxu 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu,HttpServletRequest request){
		int i = 0;
		if(null != zttMouldsGongxu && !"".equals(zttMouldsGongxu)){
			i=zttMouldsGongxuService.updateZttMouldsGongxu(zttMouldsGongxu);
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
	@RequestMapping(value="/delZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttMouldsGongxu(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttMouldsGongxuService.delZttMouldsGongxu(condition);
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
	@RequestMapping(value="/copyZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttMouldsGongxu(String id,HttpServletRequest request){
		int i = 0;
		ZttMouldsGongxu zttMouldsGongxu = zttMouldsGongxuService.getZttMouldsGongxuById(id);
		if(null != zttMouldsGongxu && !"".equals(zttMouldsGongxu)){
			zttMouldsGongxu.setId(UUID.toUUID());
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			List<ZttMouldsDeivice> zttMouldsDeiviceList = zttMouldsDeiviceService.getZttMouldsDeiviceListByCondition(condition);
			zttMouldsGongxu.setZttMouldsDeivice(zttMouldsDeiviceList);
			i=zttMouldsGongxuService.addZttMouldsGongxu(zttMouldsGongxu);
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
	@RequestMapping(value="/exportZttMouldsGongxu",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttMouldsGongxu(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsGongxuAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsGongxuAdd(ZttMouldsGongxu zttMouldsGongxu,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsGongxuUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsGongxuUpdate(String id,HttpServletRequest request, Model model){
		ZttMouldsGongxu zttMouldsGongxu = zttMouldsGongxuService.getZttMouldsGongxuById(id);
		model.addAttribute("zttMouldsGongxu", zttMouldsGongxu);
		model.addAttribute("zttMouldsGongxuJSON", outItemsStr(zttMouldsGongxu));
		return new ModelAndView("pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttMouldsGongxuDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttMouldsGongxuDetail(String id,HttpServletRequest request, Model model){
		ZttMouldsGongxu zttMouldsGongxu = zttMouldsGongxuService.getZttMouldsGongxuById(id);
		model.addAttribute("zttMouldsGongxu", zttMouldsGongxu);
		model.addAttribute("zttMouldsGongxuJSON", outItemsStr(zttMouldsGongxu));
		return new ModelAndView("pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-detail");
	}
}
