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
import jehc.zxmodules.model.ZxGoodsApplyDetail;
import jehc.zxmodules.service.ZxGoodsApplyDetailService;

/**
* 用品申领详细表 
* 2018-01-08 13:18:13  季建吉
*/
@Controller
@RequestMapping("/zxGoodsApplyDetailController")
public class ZxGoodsApplyDetailController extends BaseAction{
	@Autowired
	private ZxGoodsApplyDetailService zxGoodsApplyDetailService;
	/**
	* 载入初始化页面
	* @param zx_goods_apply_detail 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxGoodsApplyDetail(ZxGoodsApplyDetail zxGoodsApplyDetail,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-goods-apply-detail/zx-goods-apply-detail-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_goods_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxGoodsApplyDetailListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxGoodsApplyDetailListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("apply_id",request.getParameter("apply_id"));
		List<ZxGoodsApplyDetail> zxGoodsApplyDetailList = zxGoodsApplyDetailService.getZxGoodsApplyDetailListByCondition(condition);
		PageInfo<ZxGoodsApplyDetail> page = new PageInfo<ZxGoodsApplyDetail>(zxGoodsApplyDetailList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxGoodsApplyDetailById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxGoodsApplyDetailById(String id,HttpServletRequest request){
		ZxGoodsApplyDetail zxGoodsApplyDetail = zxGoodsApplyDetailService.getZxGoodsApplyDetailById(id);
		return outDataStr(zxGoodsApplyDetail);
	}
	/**
	* 添加
	* @param zx_goods_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxGoodsApplyDetail(ZxGoodsApplyDetail zxGoodsApplyDetail,HttpServletRequest request){
		int i = 0;
		if(null != zxGoodsApplyDetail && !"".equals(zxGoodsApplyDetail)){
			zxGoodsApplyDetail.setId(UUID.toUUID());
			i=zxGoodsApplyDetailService.addZxGoodsApplyDetail(zxGoodsApplyDetail);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_goods_apply_detail 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxGoodsApplyDetail(ZxGoodsApplyDetail zxGoodsApplyDetail,HttpServletRequest request){
		int i = 0;
		if(null != zxGoodsApplyDetail && !"".equals(zxGoodsApplyDetail)){
			i=zxGoodsApplyDetailService.updateZxGoodsApplyDetail(zxGoodsApplyDetail);
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
	@RequestMapping(value="/delZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxGoodsApplyDetail(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxGoodsApplyDetailService.delZxGoodsApplyDetail(condition);
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
	@RequestMapping(value="/copyZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxGoodsApplyDetail(String id,HttpServletRequest request){
		int i = 0;
		ZxGoodsApplyDetail zxGoodsApplyDetail = zxGoodsApplyDetailService.getZxGoodsApplyDetailById(id);
		if(null != zxGoodsApplyDetail && !"".equals(zxGoodsApplyDetail)){
			zxGoodsApplyDetail.setId(UUID.toUUID());
			i=zxGoodsApplyDetailService.addZxGoodsApplyDetail(zxGoodsApplyDetail);
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
	@RequestMapping(value="/exportZxGoodsApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxGoodsApplyDetail(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxGoodsApplyDetailAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxGoodsApplyDetailAdd(ZxGoodsApplyDetail zxGoodsApplyDetail,HttpServletRequest request){
		return new ModelAndView("pc/view.pc.zx-view/zx-goods-apply-detail/zx-goods-apply-detail-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxGoodsApplyDetailUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxGoodsApplyDetailUpdate(String id,HttpServletRequest request, Model model){
		ZxGoodsApplyDetail zxGoodsApplyDetail = zxGoodsApplyDetailService.getZxGoodsApplyDetailById(id);
		model.addAttribute("zxGoodsApplyDetail", zxGoodsApplyDetail);
		return new ModelAndView("pc/view.pc.zx-view/zx-goods-apply-detail/zx-goods-apply-detail-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxGoodsApplyDetailDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxGoodsApplyDetailDetail(String id,HttpServletRequest request, Model model){
		ZxGoodsApplyDetail zxGoodsApplyDetail = zxGoodsApplyDetailService.getZxGoodsApplyDetailById(id);
		model.addAttribute("zxGoodsApplyDetail", zxGoodsApplyDetail);
		return new ModelAndView("pc/view.pc.zx-view/zx-goods-apply-detail/zx-goods-apply-detail-detail");
	}
}
