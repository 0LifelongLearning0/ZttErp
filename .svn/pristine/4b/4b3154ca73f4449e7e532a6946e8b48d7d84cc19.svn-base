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
import jehc.zxmodules.model.ZxOutTime;
import jehc.zxmodules.service.ZxOutTimeService;

/**
* 外协分批到货管理 
* 2017-11-03 09:08:36  陈运芝
*/
@Controller
@RequestMapping("/zxOutTimeController")
public class ZxOutTimeController extends BaseAction{
	@Autowired
	private ZxOutTimeService zxOutTimeService;
	/**
	* 载入初始化页面
	* @param zx_out_time 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutTime(ZxOutTime zxOutTime,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-out-time/zx-out-time-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_out_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutTimeListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutTimeListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("outsource_id",request.getParameter("outsource_id"));
		List<ZxOutTime> zxOutTimeList = zxOutTimeService.getZxOutTimeListByCondition(condition);
		PageInfo<ZxOutTime> page = new PageInfo<ZxOutTime>(zxOutTimeList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutTimeById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutTimeById(String id,HttpServletRequest request){
		ZxOutTime zxOutTime = zxOutTimeService.getZxOutTimeById(id);
		return outDataStr(zxOutTime);
	}
	/**
	* 添加
	* @param zx_out_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutTime(ZxOutTime zxOutTime,HttpServletRequest request){
		int i = 0;
		if(null != zxOutTime){
			zxOutTime.setId(UUID.toUUID());
			i=zxOutTimeService.addZxOutTime(zxOutTime);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_out_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutTime(ZxOutTime zxOutTime,HttpServletRequest request){
		int i = 0;
		if(null != zxOutTime){
			i=zxOutTimeService.updateZxOutTime(zxOutTime);
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
	@RequestMapping(value="/delZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutTime(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutTimeService.delZxOutTime(condition);
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
	@RequestMapping(value="/copyZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutTime(String id,HttpServletRequest request){
		int i = 0;
		ZxOutTime zxOutTime = zxOutTimeService.getZxOutTimeById(id);
		if(null != zxOutTime){
			zxOutTime.setId(UUID.toUUID());
			i=zxOutTimeService.addZxOutTime(zxOutTime);
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
	@RequestMapping(value="/exportZxOutTime",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutTime(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
