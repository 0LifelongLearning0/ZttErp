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
import jehc.zxmodules.model.ZttClient;
import jehc.zxmodules.service.ZttClientService;

/**
* 客户管理 
* 2018-04-13 16:20:35  季建吉
*/
@Controller
@RequestMapping("/zttClientController")
public class ZttClientController extends BaseAction{
	@Autowired
	private ZttClientService zttClientService;
	/**
	* 载入初始化页面
	* @param ztt_client 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttClient(ZttClient zttClient,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-client/ztt-client-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_client 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttClientListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttClientListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZttClient> zttClientList = zttClientService.getZttClientListByCondition(condition);
		PageInfo<ZttClient> page = new PageInfo<ZttClient>(zttClientList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttClientById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttClientById(String id,HttpServletRequest request){
		ZttClient zttClient = zttClientService.getZttClientById(id);
		return outDataStr(zttClient);
	}
	/**
	* 添加
	* @param ztt_client 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttClient(ZttClient zttClient,HttpServletRequest request){
		int i = 0;
		if(null != zttClient && !"".equals(zttClient)){
			zttClient.setId(UUID.toUUID());
			i=zttClientService.addZttClient(zttClient);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_client 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttClient(ZttClient zttClient,HttpServletRequest request){
		int i = 0;
		if(null != zttClient && !"".equals(zttClient)){
			i=zttClientService.updateZttClient(zttClient);
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
	@RequestMapping(value="/delZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttClient(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttClientService.delZttClient(condition);
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
	@RequestMapping(value="/copyZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttClient(String id,HttpServletRequest request){
		int i = 0;
		ZttClient zttClient = zttClientService.getZttClientById(id);
		if(null != zttClient && !"".equals(zttClient)){
			zttClient.setId(UUID.toUUID());
			i=zttClientService.addZttClient(zttClient);
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
	@RequestMapping(value="/exportZttClient",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttClient(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttClientAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttClientAdd(ZttClient zttClient,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-client/ztt-client-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttClientUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttClientUpdate(String id,HttpServletRequest request, Model model){
		ZttClient zttClient = zttClientService.getZttClientById(id);
		model.addAttribute("zttClient", zttClient);
		return new ModelAndView("pc/zx-view/ztt-client/ztt-client-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttClientDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttClientDetail(String id,HttpServletRequest request, Model model){
		ZttClient zttClient = zttClientService.getZttClientById(id);
		model.addAttribute("zttClient", zttClient);
		return new ModelAndView("pc/zx-view/ztt-client/ztt-client-detail");
	}
}
