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
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxChangeContract;
import jehc.zxmodules.service.ZxChangeContractService;

/**
* 变更合同 
* 2018-01-17 14:05:05  owen
*/
@Controller
@RequestMapping("/zxChangeContractController")
public class ZxChangeContractController extends BaseAction{
	@Autowired
	private ZxChangeContractService zxChangeContractService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	/**
	* 载入初始化页面
	* @param zx_change_contract 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxChangeContract(ZxChangeContract zxChangeContract,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-change-contract/zx-change-contract-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_change_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxChangeContractListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxChangeContractListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxChangeContract> zxChangeContractList = zxChangeContractService.getZxChangeContractListByCondition(condition);
		PageInfo<ZxChangeContract> page = new PageInfo<ZxChangeContract>(zxChangeContractList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxChangeContractById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxChangeContractById(String id,HttpServletRequest request){
		ZxChangeContract zxChangeContract = zxChangeContractService.getZxChangeContractById(id);
		return outDataStr(zxChangeContract);
	}
	/**
	* 添加
	* @param zx_change_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxChangeContract(ZxChangeContract zxChangeContract,HttpServletRequest request){
		int i = 0;
		if(null != zxChangeContract && !"".equals(zxChangeContract)){
			zxChangeContract.setId(UUID.toUUID());
			i=zxChangeContractService.addZxChangeContract(zxChangeContract);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_change_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxChangeContract(ZxChangeContract zxChangeContract,HttpServletRequest request){
		int i = 0;
		if(null != zxChangeContract && !"".equals(zxChangeContract)){
			i=zxChangeContractService.updateZxChangeContract(zxChangeContract);
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
	@RequestMapping(value="/delZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxChangeContract(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxChangeContractService.delZxChangeContract(condition);
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
	@RequestMapping(value="/copyZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxChangeContract(String id,HttpServletRequest request){
		int i = 0;
		ZxChangeContract zxChangeContract = zxChangeContractService.getZxChangeContractById(id);
		if(null != zxChangeContract && !"".equals(zxChangeContract)){
			zxChangeContract.setId(UUID.toUUID());
			i=zxChangeContractService.addZxChangeContract(zxChangeContract);
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
	@RequestMapping(value="/exportZxChangeContract",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxChangeContract(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxChangeContractAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxChangeContractAdd(String xt_user_id,HttpServletRequest request,Model model){
		if(xt_user_id!=null){
			XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(xt_user_id);
			model.addAttribute("xt_user_id",xt_user_id);
			model.addAttribute("xt_userinfo_realName", xtUserinfo.getXt_userinfo_realName());
		}
		return new ModelAndView("pc/zx-view/zx-change-contract/zx-change-contract-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxChangeContractUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxChangeContractUpdate(String id,HttpServletRequest request, Model model){
		ZxChangeContract zxChangeContract = zxChangeContractService.getZxChangeContractById(id);
		model.addAttribute("zxChangeContract", zxChangeContract);
		return new ModelAndView("pc/zx-view/zx-change-contract/zx-change-contract-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxChangeContractDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxChangeContractDetail(String id,HttpServletRequest request, Model model){
		ZxChangeContract zxChangeContract = zxChangeContractService.getZxChangeContractById(id);
		model.addAttribute("zxChangeContract", zxChangeContract);
		return new ModelAndView("pc/zx-view/zx-change-contract/zx-change-contract-detail");
	}
	/**
	* 发送至员工选择页面
	* @param request 
	*/
	@RequestMapping(value="/toZxChangeContractUserChoose",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxChangeContractUserChoose(ZxChangeContract zxChangeContract,HttpServletRequest request, Model model){
		return new ModelAndView("pc/zx-view/zx-change-contract/zx-change-contract-user-choose");
	}
}
