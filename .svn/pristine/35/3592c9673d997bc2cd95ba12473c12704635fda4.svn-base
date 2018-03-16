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
import jehc.zxmodules.model.ZxPurchaseApplyDetail;
import jehc.zxmodules.service.ZxPurchaseApplyDetailService;

/**
* 行政采购申领详情表 
* 2018-01-15 09:50:27  季建吉
*/
@Controller
@RequestMapping("/zxPurchaseApplyDetailController")
public class ZxPurchaseApplyDetailController extends BaseAction{
	@Autowired
	private ZxPurchaseApplyDetailService zxPurchaseApplyDetailService;
	/**
	* 载入初始化页面
	* @param zx_purchase_apply_detail 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPurchaseApplyDetail(ZxPurchaseApplyDetail zxPurchaseApplyDetail,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply-detail/zx-purchase-apply-detail-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_purchase_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPurchaseApplyDetailListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPurchaseApplyDetailListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("apply_id",request.getParameter("apply_id"));
		List<ZxPurchaseApplyDetail> zxPurchaseApplyDetailList = zxPurchaseApplyDetailService.getZxPurchaseApplyDetailListByCondition(condition);
		PageInfo<ZxPurchaseApplyDetail> page = new PageInfo<ZxPurchaseApplyDetail>(zxPurchaseApplyDetailList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPurchaseApplyDetailById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPurchaseApplyDetailById(String id,HttpServletRequest request){
		ZxPurchaseApplyDetail zxPurchaseApplyDetail = zxPurchaseApplyDetailService.getZxPurchaseApplyDetailById(id);
		return outDataStr(zxPurchaseApplyDetail);
	}
	/**
	* 添加
	* @param zx_purchase_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxPurchaseApplyDetail(ZxPurchaseApplyDetail zxPurchaseApplyDetail,HttpServletRequest request){
		int i = 0;
		if(null != zxPurchaseApplyDetail && !"".equals(zxPurchaseApplyDetail)){
			zxPurchaseApplyDetail.setId(UUID.toUUID());
			i=zxPurchaseApplyDetailService.addZxPurchaseApplyDetail(zxPurchaseApplyDetail);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_purchase_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxPurchaseApplyDetail(ZxPurchaseApplyDetail zxPurchaseApplyDetail,HttpServletRequest request){
		int i = 0;
		if(null != zxPurchaseApplyDetail && !"".equals(zxPurchaseApplyDetail)){
			i=zxPurchaseApplyDetailService.updateZxPurchaseApplyDetail(zxPurchaseApplyDetail);
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
	@RequestMapping(value="/delZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxPurchaseApplyDetail(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxPurchaseApplyDetailService.delZxPurchaseApplyDetail(condition);
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
	@RequestMapping(value="/copyZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxPurchaseApplyDetail(String id,HttpServletRequest request){
		int i = 0;
		ZxPurchaseApplyDetail zxPurchaseApplyDetail = zxPurchaseApplyDetailService.getZxPurchaseApplyDetailById(id);
		if(null != zxPurchaseApplyDetail && !"".equals(zxPurchaseApplyDetail)){
			zxPurchaseApplyDetail.setId(UUID.toUUID());
			i=zxPurchaseApplyDetailService.addZxPurchaseApplyDetail(zxPurchaseApplyDetail);
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
	@RequestMapping(value="/exportZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxPurchaseApplyDetail(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyDetailAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyDetailAdd(ZxPurchaseApplyDetail zxPurchaseApplyDetail,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply-detail/zx-purchase-apply-detail-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyDetailUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyDetailUpdate(String id,HttpServletRequest request, Model model){
		ZxPurchaseApplyDetail zxPurchaseApplyDetail = zxPurchaseApplyDetailService.getZxPurchaseApplyDetailById(id);
		model.addAttribute("zxPurchaseApplyDetail", zxPurchaseApplyDetail);
		return new ModelAndView("pc/zx-view/zx-purchase-apply-detail/zx-purchase-apply-detail-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyDetailDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyDetailDetail(String id,HttpServletRequest request, Model model){
		ZxPurchaseApplyDetail zxPurchaseApplyDetail = zxPurchaseApplyDetailService.getZxPurchaseApplyDetailById(id);
		model.addAttribute("zxPurchaseApplyDetail", zxPurchaseApplyDetail);
		return new ModelAndView("pc/zx-view/zx-purchase-apply-detail/zx-purchase-apply-detail-detail");
	}
}
