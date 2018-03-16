package jehc.zxmodules.web;
import java.util.List;
import java.util.ArrayList;
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
import jehc.xtmodules.xtmodel.XtDataDictionary;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxMeetingHouse;
import jehc.zxmodules.service.ZxMeetingHouseService;

/**
* 会议室管理 
* 2017-11-17 15:51:33  a
*/
@Controller
@RequestMapping("/zxMeetingHouseController")
public class ZxMeetingHouseController extends BaseAction{
	@Autowired
	private ZxMeetingHouseService zxMeetingHouseService;
	/**
	* 载入初始化页面
	* @param zx_meeting_house 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMeetingHouse(ZxMeetingHouse zxMeetingHouse,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-meeting-house/zx-meeting-house-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_meeting_house 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingHouseListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingHouseListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxMeetingHouse> zxMeetingHouseList = zxMeetingHouseService.getZxMeetingHouseListByCondition(condition);
		PageInfo<ZxMeetingHouse> page = new PageInfo<ZxMeetingHouse>(zxMeetingHouseList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingHouseById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingHouseById(String id,HttpServletRequest request){
		ZxMeetingHouse zxMeetingHouse = zxMeetingHouseService.getZxMeetingHouseById(id);
		return outDataStr(zxMeetingHouse);
	}
	/**
	* 添加
	* @param zx_meeting_house 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMeetingHouse(ZxMeetingHouse zxMeetingHouse,HttpServletRequest request){
		int i = 0;
		if(null != zxMeetingHouse && !"".equals(zxMeetingHouse)){
			zxMeetingHouse.setId(UUID.toUUID());
			i=zxMeetingHouseService.addZxMeetingHouse(zxMeetingHouse);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_meeting_house 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMeetingHouse(ZxMeetingHouse zxMeetingHouse,HttpServletRequest request){
		int i = 0;
		if(null != zxMeetingHouse && !"".equals(zxMeetingHouse)){
			i=zxMeetingHouseService.updateZxMeetingHouse(zxMeetingHouse);
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
	@RequestMapping(value="/delZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMeetingHouse(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxMeetingHouseService.delZxMeetingHouse(condition);
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
	@RequestMapping(value="/copyZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMeetingHouse(String id,HttpServletRequest request){
		int i = 0;
		ZxMeetingHouse zxMeetingHouse = zxMeetingHouseService.getZxMeetingHouseById(id);
		if(null != zxMeetingHouse && !"".equals(zxMeetingHouse)){
			zxMeetingHouse.setId(UUID.toUUID());
			i=zxMeetingHouseService.addZxMeetingHouse(zxMeetingHouse);
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
	@RequestMapping(value="/exportZxMeetingHouse",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMeetingHouse(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 加载初始化列表数据
	* @param zx_meeting_house 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMeetingHouseListAll",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMeetingHouseListAll(BaseSearch baseSearch,HttpServletRequest request){
		List<XtDataDictionary> xtDataDictionaryList = CommonUtils.getXtDataDictionaryCache("zx_meeting_house");
		String status = null;
		for(XtDataDictionary dic:xtDataDictionaryList){
			if(dic.getXt_data_dictionary_value().equals("zx_meeting_house_1")){
				status = dic.getXt_data_dictionary_id();
				break;
			}
		}
		
		List<ZxMeetingHouse> zxMeetingHouseList = new ArrayList<ZxMeetingHouse>();
		if(status != null){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("state", 1);
			condition.put("status", status);
			zxMeetingHouseList = zxMeetingHouseService.getZxMeetingHouseListByCondition(condition);
		}
		return outComboDataStr(zxMeetingHouseList);
	}
}
