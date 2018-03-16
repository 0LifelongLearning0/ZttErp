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
import jehc.zxmodules.model.ZxOrderOutWorkpiece;
import jehc.zxmodules.service.ZxOrderOutWorkpieceService;

/**
* 外协订单工件表 
* 2017-11-03 16:58:45  陈运芝
*/
@Controller
@RequestMapping("/zxOrderOutWorkpieceController")
public class ZxOrderOutWorkpieceController extends BaseAction{
	@Autowired
	private ZxOrderOutWorkpieceService zxOrderOutWorkpieceService;
	/**
	* 载入初始化页面
	* @param zx_order_out_workpiece 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-order-out-workpiece/zx-order-out-workpiece-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_order_out_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderOutWorkpieceListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderOutWorkpieceListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOrderOutWorkpiece> zxOrderOutWorkpieceList = zxOrderOutWorkpieceService.getZxOrderOutWorkpieceListByCondition(condition);
		PageInfo<ZxOrderOutWorkpiece> page = new PageInfo<ZxOrderOutWorkpiece>(zxOrderOutWorkpieceList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOrderOutWorkpieceById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOrderOutWorkpieceById(String id,HttpServletRequest request){
		ZxOrderOutWorkpiece zxOrderOutWorkpiece = zxOrderOutWorkpieceService.getZxOrderOutWorkpieceById(id);
		return outDataStr(zxOrderOutWorkpiece);
	}
	/**
	* 添加
	* @param zx_order_out_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderOutWorkpiece){
			zxOrderOutWorkpiece.setId(UUID.toUUID());
			i=zxOrderOutWorkpieceService.addZxOrderOutWorkpiece(zxOrderOutWorkpiece);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_order_out_workpiece 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOrderOutWorkpiece(ZxOrderOutWorkpiece zxOrderOutWorkpiece,HttpServletRequest request){
		int i = 0;
		if(null != zxOrderOutWorkpiece){
			i=zxOrderOutWorkpieceService.updateZxOrderOutWorkpiece(zxOrderOutWorkpiece);
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
	@RequestMapping(value="/delZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOrderOutWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOrderOutWorkpieceService.delZxOrderOutWorkpiece(condition);
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
	@RequestMapping(value="/copyZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOrderOutWorkpiece(String id,HttpServletRequest request){
		int i = 0;
		ZxOrderOutWorkpiece zxOrderOutWorkpiece = zxOrderOutWorkpieceService.getZxOrderOutWorkpieceById(id);
		if(null != zxOrderOutWorkpiece){
			zxOrderOutWorkpiece.setId(UUID.toUUID());
			i=zxOrderOutWorkpieceService.addZxOrderOutWorkpiece(zxOrderOutWorkpiece);
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
	@RequestMapping(value="/exportZxOrderOutWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOrderOutWorkpiece(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
