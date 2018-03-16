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
import jehc.zxmodules.model.ZxRelieveContract;
import jehc.zxmodules.service.ZxRelieveContractService;

/**
* 解除合同 
* 2018-01-11 17:48:26  owen
*/
@Controller
@RequestMapping("/zxRelieveContractController")
public class ZxRelieveContractController extends BaseAction{
	@Autowired
	private ZxRelieveContractService zxRelieveContractService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	/**
	* 载入初始化页面
	* @param zx_relieve_contract 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxRelieveContract(ZxRelieveContract zxRelieveContract,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-relieve-contract/zx-relieve-contract-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_relieve_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxRelieveContractListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxRelieveContractListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxRelieveContract> zxRelieveContractList = zxRelieveContractService.getZxRelieveContractListByCondition(condition);
		for (ZxRelieveContract zxRelieveContract : zxRelieveContractList) {
			zxRelieveContract.setUser_name(zxRelieveContract.getXt_userinfo_realName());
		}
		PageInfo<ZxRelieveContract> page = new PageInfo<ZxRelieveContract>(zxRelieveContractList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxRelieveContractById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxRelieveContractById(String id,HttpServletRequest request){
		ZxRelieveContract zxRelieveContract = zxRelieveContractService.getZxRelieveContractById(id);
		return outDataStr(zxRelieveContract);
	}
	/**
	* 添加
	* @param zx_relieve_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxRelieveContract(ZxRelieveContract zxRelieveContract,HttpServletRequest request){
		int i = 0;
		if(null != zxRelieveContract && !"".equals(zxRelieveContract)){
			zxRelieveContract.setId(UUID.toUUID());
			i=zxRelieveContractService.addZxRelieveContract(zxRelieveContract);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_relieve_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxRelieveContract(ZxRelieveContract zxRelieveContract,HttpServletRequest request){
		int i = 0;
		if(null != zxRelieveContract && !"".equals(zxRelieveContract)){
			i=zxRelieveContractService.updateZxRelieveContract(zxRelieveContract);
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
	@RequestMapping(value="/delZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxRelieveContract(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxRelieveContractService.delZxRelieveContract(condition);
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
	@RequestMapping(value="/copyZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxRelieveContract(String id,HttpServletRequest request){
		int i = 0;
		ZxRelieveContract zxRelieveContract = zxRelieveContractService.getZxRelieveContractById(id);
		if(null != zxRelieveContract && !"".equals(zxRelieveContract)){
			zxRelieveContract.setId(UUID.toUUID());
			i=zxRelieveContractService.addZxRelieveContract(zxRelieveContract);
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
	@RequestMapping(value="/exportZxRelieveContract",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxRelieveContract(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxRelieveContractAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxRelieveContractAdd(String xt_user_id,HttpServletRequest request,Model model){
		if(xt_user_id!=null){
			XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(xt_user_id);
			model.addAttribute("xt_user_id",xt_user_id);
			model.addAttribute("user_name", xtUserinfo.getXt_userinfo_realName());
		}
		return new ModelAndView("pc/zx-view/zx-relieve-contract/zx-relieve-contract-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxRelieveContractUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxRelieveContractUpdate(String id,HttpServletRequest request, Model model){
		ZxRelieveContract zxRelieveContract = zxRelieveContractService.getZxRelieveContractById(id);
		XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(zxRelieveContract.getXt_user_id());
		zxRelieveContract.setUser_name(xtUserinfo.getXt_userinfo_realName());
		model.addAttribute("zxRelieveContract", zxRelieveContract);
		return new ModelAndView("pc/zx-view/zx-relieve-contract/zx-relieve-contract-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxRelieveContractDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxRelieveContractDetail(String id,HttpServletRequest request, Model model){
		ZxRelieveContract zxRelieveContract = zxRelieveContractService.getZxRelieveContractById(id);
		model.addAttribute("zxRelieveContract", zxRelieveContract);
		return new ModelAndView("pc/zx-view/zx-relieve-contract/zx-relieve-contract-detail");
	}
	/**
	* 发送至选择员工页面
	* @param request 
	*/
	@RequestMapping(value="/toZxRelieveContractUserChoose",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxRelieveContractUserChoose(String id,HttpServletRequest request, Model model){
		return new ModelAndView("pc/zx-view/zx-relieve-contract/zx-relieve-contract-user-choose");
	}
}
