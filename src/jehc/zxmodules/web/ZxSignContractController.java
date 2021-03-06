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
import jehc.zxmodules.model.ZxSignContract;
import jehc.zxmodules.service.ZxSignContractService;

/**
* 签订合同 
* 2018-01-11 13:56:25  owen
*/
@Controller
@RequestMapping("/zxSignContractController")
public class ZxSignContractController extends BaseAction{
	@Autowired
	private ZxSignContractService zxSignContractService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	/**
	* 载入初始化页面
	* @param zx_sign_contract 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxSignContract(ZxSignContract zxSignContract,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-sign-contract/zx-sign-contract-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_sign_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSignContractListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSignContractListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxSignContract> zxSignContractList = zxSignContractService.getZxSignContractListByCondition(condition);
		for (ZxSignContract zxSignContract : zxSignContractList) {
			zxSignContract.setXt_user_name(zxSignContract.getXt_userinfo_realName());
		}
		PageInfo<ZxSignContract> page = new PageInfo<ZxSignContract>(zxSignContractList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSignContractById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSignContractById(String id,HttpServletRequest request){
		ZxSignContract zxSignContract = zxSignContractService.getZxSignContractById(id);
		XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(zxSignContract.getXt_user_id());
		zxSignContract.setXt_user_name(xtUserinfo.getXt_userinfo_realName());
		return outDataStr(zxSignContract);
	}
	/**
	* 添加
	* @param zx_sign_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxSignContract(ZxSignContract zxSignContract,HttpServletRequest request){
		int i = 0;
		if(null != zxSignContract && !"".equals(zxSignContract)){
			String contract_num = zxSignContract.getContract_num();
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("contract_num", contract_num);
			List<ZxSignContract> zxSignContractList = zxSignContractService.getZxSignContractListByCondition(condition);
			if(zxSignContractList.size()<1){
				zxSignContract.setId(UUID.toUUID());
				i=zxSignContractService.addZxSignContract(zxSignContract);
			}else{
				return "{success:false,msg:'合同编号有误',responseFlag:false}";
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_sign_contract 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxSignContract(ZxSignContract zxSignContract,HttpServletRequest request){
		int i = 0;
		if(null != zxSignContract && !"".equals(zxSignContract)){
			i=zxSignContractService.updateZxSignContract(zxSignContract);
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
	@RequestMapping(value="/delZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxSignContract(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxSignContractService.delZxSignContract(condition);
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
	@RequestMapping(value="/copyZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxSignContract(String id,HttpServletRequest request){
		int i = 0;
		ZxSignContract zxSignContract = zxSignContractService.getZxSignContractById(id);
		if(null != zxSignContract && !"".equals(zxSignContract)){
			zxSignContract.setId(UUID.toUUID());
			i=zxSignContractService.addZxSignContract(zxSignContract);
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
	@RequestMapping(value="/exportZxSignContract",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxSignContract(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxSignContractAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxSignContractAdd(String xt_user_id,HttpServletRequest request,Model model){
		if(xt_user_id!=null){
			XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(xt_user_id);
			model.addAttribute("xt_user_id",xt_user_id);
			model.addAttribute("user_name", xtUserinfo.getXt_userinfo_realName());
		}
		return new ModelAndView("pc/zx-view/zx-sign-contract/zx-sign-contract-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxSignContractUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxSignContractUpdate(String id,HttpServletRequest request, Model model){
		ZxSignContract zxSignContract = zxSignContractService.getZxSignContractById(id);
		XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(zxSignContract.getXt_user_id());
		zxSignContract.setXt_user_name(xtUserinfo.getXt_userinfo_realName());
		model.addAttribute("zxSignContract", zxSignContract);
		return new ModelAndView("pc/zx-view/zx-sign-contract/zx-sign-contract-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxSignContractDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxSignContractDetail(String id,HttpServletRequest request, Model model){
		ZxSignContract zxSignContract = zxSignContractService.getZxSignContractById(id);
		XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(zxSignContract.getXt_user_id());
		zxSignContract.setXt_user_name(xtUserinfo.getXt_userinfo_realName());
		model.addAttribute("zxSignContract", zxSignContract);
		return new ModelAndView("pc/zx-view/zx-sign-contract/zx-sign-contract-detail");
	}
	/**
	* 发送至选择员工界面
	* @param request 
	*/
	@RequestMapping(value="/toZxSignContractUserChoose",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxSignContractUserChoose(ZxSignContract zxSignContract,HttpServletRequest request, Model model){
		return new ModelAndView("pc/zx-view/zx-sign-contract/zx-sign-contract-user-choose");
	}
}
