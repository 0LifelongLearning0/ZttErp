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
import jehc.zxmodules.model.ZxBuyTime;
import jehc.zxmodules.service.ZxBuyTimeService;

/**
* 采购分批到货 
* 2017-09-08 15:08:43  陈运芝
*/
@Controller
@RequestMapping("/zxBuyTimeController")
public class ZxBuyTimeController extends BaseAction{
	@Autowired
	private ZxBuyTimeService zxBuyTimeService;
	/**
	* 载入初始化页面
	* @param zx_buy_time 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyTime(ZxBuyTime zxBuyTime,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-buy-time/zx-buy-time-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_buy_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyTimeListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyTimeListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("buy_id",request.getParameter("buy_id"));
		List<ZxBuyTime> zxBuyTimeList = zxBuyTimeService.getZxBuyTimeListByCondition(condition);
		PageInfo<ZxBuyTime> page = new PageInfo<ZxBuyTime>(zxBuyTimeList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyTimeById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyTimeById(String id,HttpServletRequest request){
		ZxBuyTime zxBuyTime = zxBuyTimeService.getZxBuyTimeById(id);
		return outDataStr(zxBuyTime);
	}
	/**
	* 添加
	* @param zx_buy_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxBuyTime(ZxBuyTime zxBuyTime,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyTime){
			zxBuyTime.setId(UUID.toUUID());
			i=zxBuyTimeService.addZxBuyTime(zxBuyTime);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_buy_time 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxBuyTime(ZxBuyTime zxBuyTime,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyTime){
			i=zxBuyTimeService.updateZxBuyTime(zxBuyTime);
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
	@RequestMapping(value="/delZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxBuyTime(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxBuyTimeService.delZxBuyTime(condition);
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
	@RequestMapping(value="/copyZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxBuyTime(String id,HttpServletRequest request){
		int i = 0;
		ZxBuyTime zxBuyTime = zxBuyTimeService.getZxBuyTimeById(id);
		if(null != zxBuyTime){
			zxBuyTime.setId(UUID.toUUID());
			i=zxBuyTimeService.addZxBuyTime(zxBuyTime);
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
	@RequestMapping(value="/exportZxBuyTime",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxBuyTime(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
