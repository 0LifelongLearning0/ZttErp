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
import jehc.zxmodules.model.ZxWorkpiece;
import jehc.zxmodules.service.ZxWorkpieceService;

/**
* 工件管理 
* 2017-08-31 12:54:14  陈运芝
*/
@Controller
@RequestMapping("/zxWorkpieceController")
public class ZxWorkpieceController extends BaseAction{
	@Autowired
	private ZxWorkpieceService zxWorkpieceService;
	/**
	* 载入初始化页面
	* @param zx_workpiece 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxWorkpiece(ZxWorkpiece zxWorkpiece,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-workpiece/zx-workpiece-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxWorkpieceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxWorkpieceListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxWorkpiece> zxWorkpieceList = zxWorkpieceService.getZxWorkpieceListByCondition(condition);
		PageInfo<ZxWorkpiece> page = new PageInfo<ZxWorkpiece>(zxWorkpieceList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxWorkpieceById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxWorkpieceById(String id,HttpServletRequest request){
		ZxWorkpiece zxWorkpiece = zxWorkpieceService.getZxWorkpieceById(id);
		return outDataStr(zxWorkpiece);
	}
	/**
	* 添加
	* @param zx_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxWorkpiece(ZxWorkpiece zxWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxWorkpiece){
			zxWorkpiece.setId(UUID.toUUID());
			i=zxWorkpieceService.addZxWorkpiece(zxWorkpiece);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxWorkpiece(ZxWorkpiece zxWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxWorkpiece){
			i=zxWorkpieceService.updateZxWorkpiece(zxWorkpiece);
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
	@RequestMapping(value="/delZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxWorkpieceService.delZxWorkpiece(condition);
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
	@RequestMapping(value="/copyZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		ZxWorkpiece zxWorkpiece = zxWorkpieceService.getZxWorkpieceById(id);
		if(null != zxWorkpiece){
			zxWorkpiece.setId(UUID.toUUID());
			i=zxWorkpieceService.addZxWorkpiece(zxWorkpiece);
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
	@RequestMapping(value="/exportZxWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxWorkpiece(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
