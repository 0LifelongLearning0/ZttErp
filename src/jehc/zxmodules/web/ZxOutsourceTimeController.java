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
import jehc.zxmodules.model.ZxOutsourceTime;
import jehc.zxmodules.service.ZxOutsourceTimeService;

/**
* 外协分批到货管理 
* 2017-09-01 09:30:59  陈运芝
*/
@Controller
@RequestMapping("/zxOutsourceTimeController")
public class ZxOutsourceTimeController extends BaseAction{
	@Autowired
	private ZxOutsourceTimeService zxOutsourceTimeService;
	/**
	* 载入初始化页面
	* @param zx_outsource_time 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutsourceTime(ZxOutsourceTime zxOutsourceTime,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-outsource-time/zx-outsource-time-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_outsource_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutsourceTimeListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutsourceTimeListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("outsource_id",request.getParameter("outsource_id"));
		List<ZxOutsourceTime> zxOutsourceTimeList = zxOutsourceTimeService.getZxOutsourceTimeListByCondition(condition);
		PageInfo<ZxOutsourceTime> page = new PageInfo<ZxOutsourceTime>(zxOutsourceTimeList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutsourceTimeById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutsourceTimeById(String id,HttpServletRequest request){
		ZxOutsourceTime zxOutsourceTime = zxOutsourceTimeService.getZxOutsourceTimeById(id);
		return outDataStr(zxOutsourceTime);
	}
	/**
	* 添加
	* @param zx_outsource_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutsourceTime(ZxOutsourceTime zxOutsourceTime,HttpServletRequest request){
		int i = 0;
		if(null != zxOutsourceTime){
			zxOutsourceTime.setId(UUID.toUUID());
			i=zxOutsourceTimeService.addZxOutsourceTime(zxOutsourceTime);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_outsource_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutsourceTime(ZxOutsourceTime zxOutsourceTime,HttpServletRequest request){
		int i = 0;
		if(null != zxOutsourceTime){
			i=zxOutsourceTimeService.updateZxOutsourceTime(zxOutsourceTime);
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
	@RequestMapping(value="/delZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutsourceTime(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutsourceTimeService.delZxOutsourceTime(condition);
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
	@RequestMapping(value="/copyZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutsourceTime(String id,HttpServletRequest request){
		int i = 0;
		ZxOutsourceTime zxOutsourceTime = zxOutsourceTimeService.getZxOutsourceTimeById(id);
		if(null != zxOutsourceTime){
			zxOutsourceTime.setId(UUID.toUUID());
			i=zxOutsourceTimeService.addZxOutsourceTime(zxOutsourceTime);
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
	@RequestMapping(value="/exportZxOutsourceTime",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutsourceTime(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
