package jehc.zxmodules.web;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
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
import jehc.zxmodules.model.ZxProjectWoking;
import jehc.zxmodules.service.ZxProjectWokingService;

/**
* 项目节点工时记录表 
* 2017-09-07 23:52:08  陈运芝
*/
@Controller
@RequestMapping("/zxProjectWokingController")
public class ZxProjectWokingController extends BaseAction{
	@Autowired
	private ZxProjectWokingService zxProjectWokingService;
	/**
	* 载入初始化页面
	* @param zx_project_woking 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxProjectWoking(ZxProjectWoking zxProjectWoking,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-project-woking/zx-project-woking-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_project_woking 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectWokingListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectWokingListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("node_id",request.getParameter("node_id"));
		List<ZxProjectWoking> zxProjectWokingList = zxProjectWokingService.getZxProjectWokingListByCondition(condition);
		PageInfo<ZxProjectWoking> page = new PageInfo<ZxProjectWoking>(zxProjectWokingList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectWokingById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectWokingById(String id,HttpServletRequest request){
		ZxProjectWoking zxProjectWoking = zxProjectWokingService.getZxProjectWokingById(id);
		return outDataStr(zxProjectWoking);
	}
	/**
	* 添加
	* @param zx_project_woking 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxProjectWoking(ZxProjectWoking zxProjectWoking,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectWoking){
			zxProjectWoking.setId(UUID.toUUID());
			i=zxProjectWokingService.addZxProjectWoking(zxProjectWoking);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_project_woking 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxProjectWoking(ZxProjectWoking zxProjectWoking,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectWoking){
			i=zxProjectWokingService.updateZxProjectWoking(zxProjectWoking);
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
	@RequestMapping(value="/delZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxProjectWoking(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxProjectWokingService.delZxProjectWoking(condition);
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
	@RequestMapping(value="/copyZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxProjectWoking(String id,HttpServletRequest request){
		int i = 0;
		ZxProjectWoking zxProjectWoking = zxProjectWokingService.getZxProjectWokingById(id);
		if(null != zxProjectWoking){
			zxProjectWoking.setId(UUID.toUUID());
			i=zxProjectWokingService.addZxProjectWoking(zxProjectWoking);
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
	@RequestMapping(value="/exportZxProjectWoking",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxProjectWoking(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
