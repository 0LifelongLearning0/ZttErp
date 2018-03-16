package jehc.zxmodules.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxOutProgress;
import jehc.zxmodules.model.ZxOutTime;
import jehc.zxmodules.service.ZxOrderOutService;
import jehc.zxmodules.service.ZxOutProgressService;
import jehc.zxmodules.service.ZxOutTimeService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 外协加工进度表 
* 2017-11-03 09:08:36  陈运芝
*/
@Controller
@RequestMapping("/zxOutProgressController")
public class ZxOutProgressController extends BaseAction{
	@Autowired
	private ZxOutProgressService zxOutProgressService;
	@Autowired
	private ZxOutTimeService zxOutTimeService;
	@Autowired
	private ZxOrderOutService zxOrderOutService;
	/**
	* 载入初始化页面
	* @param zx_out_progress 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutProgress(ZxOutProgress zxOutProgress,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-out-progress/zx-out-progress-list");
	}

	/**
	* 载入订单下工件页面
	* @param zxOutProgress
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutProgressWorkpiece",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutProgressWorkpiece(ZxOutProgress zxOutProgress,HttpServletRequest request,Model model){
		model.addAttribute("zxOutProgress",zxOutProgress);
		model.addAttribute("ZxOrderOut",zxOrderOutService.getZxOrderOutById(zxOutProgress.getOrder_id()));
		return new ModelAndView("pc/zx-view/zx-order-out/zx-order-out-edit-workpiece-list");
	}
	
	/**
	* 载入初始化页面：生产
	* @param zxOutProgress 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutProgressWorking",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutProgressWorking(ZxOutProgress zxOutProgress,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-out-progress/zx-out-progress-workpiece-list");
	}

	/**
	* 载入初始化页面：仓库出入库
	* @param zxOutProgress 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutProgressWarehouse",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutProgressWarehouse(ZxOutProgress zxOutProgress,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-out-progress/zx-out-progress-warehouse-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutProgressListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutProgressListByCondition(BaseSearch baseSearch,String order_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		if(StringUtils.isNotBlank(order_id)){
			condition.put("order_id", order_id);
		}
		List<Map<String, Object>> zxOutProgressList = zxOutProgressService.getZxOutProgressListByCondition(condition);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(zxOutProgressList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutProgressById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutProgressById(String id,HttpServletRequest request){
		Map<String, Object> zxOutProgress = zxOutProgressService.getMapZxOutProgressById(id);
		return outDataStr(zxOutProgress);
	}
	/**
	* 添加
	* @param zx_out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutProgress(ZxOutProgress zxOutProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxOutProgress){
			zxOutProgress.setId(UUID.toUUID());
			i=zxOutProgressService.addZxOutProgress(zxOutProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutProgress(ZxOutProgress zxOutProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxOutProgress){
			i=zxOutProgressService.updateZxOutProgress(zxOutProgress);
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
	@RequestMapping(value="/delZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutProgress(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutProgressService.delZxOutProgress(condition);
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
	@RequestMapping(value="/copyZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutProgress(String id,HttpServletRequest request){
		int i = 0;
		ZxOutProgress zxOutProgress = zxOutProgressService.getZxOutProgressById(id);
		if(null != zxOutProgress){
			zxOutProgress.setId(UUID.toUUID());
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			List<ZxOutTime> zxOutTimeList = zxOutTimeService.getZxOutTimeListByCondition(condition);
			zxOutProgress.setZxOutTime(zxOutTimeList);
			i=zxOutProgressService.addZxOutProgress(zxOutProgress);
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
	@RequestMapping(value="/exportZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutProgress(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 入库
	* @param zx_Out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/inZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String inZxOutProgress(ZxOutProgress zxOutProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxOutProgress){
			i=zxOutProgressService.updateZxOutProgress(zxOutProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 出库
	* @param zx_Out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/outZxOutProgress",method={RequestMethod.POST,RequestMethod.GET})
	public String outZxOutProgress(ZxOutProgress zxOutProgress,HttpServletRequest request){
		int i = 0;
		if(null != zxOutProgress){
			i=zxOutProgressService.updateZxOutProgress(zxOutProgress);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
