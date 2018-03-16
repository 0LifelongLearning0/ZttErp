package jehc.zxmodules.web;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import jehc.zxmodules.model.ZxPurchaseApplyDetail;
import jehc.zxmodules.service.ZxOfficeApplyService;
import jehc.zxmodules.service.ZxOfficeInventoryService;
import jehc.zxmodules.service.ZxPurchaseApplyDetailService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;

import jehc.lcmodules.activitiutil.ActivitiUtil;
import jehc.lcmodules.activitiutil.util.Variable;
import jehc.lcmodules.lcmodel.LcApply;
import jehc.lcmodules.lcmodel.LcApproval;
import jehc.lcmodules.lcservice.LcApplyService;
import jehc.lcmodules.lcservice.LcApprovalService;
import jehc.lcmodules.lcservice.LcDeploymentHisService;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxPurchaseApply;
import jehc.zxmodules.service.ZxPurchaseApplyService;

/**
* 采购申领表 
* 2018-01-15 09:50:27  季建吉
*/
@Controller
@RequestMapping("/zxPurchaseApplyController")
public class ZxPurchaseApplyController extends BaseAction{
	@Autowired
	private ZxPurchaseApplyService zxPurchaseApplyService;
	@Autowired
	private ZxPurchaseApplyDetailService zxPurchaseApplyDetailService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private ZxOfficeApplyService zxOfficeApplyService;
	@Autowired
	private ZxOfficeInventoryService zxOfficeInventoryService;
	
	/**
	* 载入初始化页面
	* @param zx_purchase_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPurchaseApply(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-list");
	}
	
	/**
	* 载入新建初始化页面
	* @param zx_purchase_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPurchaseApplyAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPurchaseApplyAdd(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-list-add");
	}
	/**
	* 载入树
	* @param zx_purchase_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPurchaseApplyTree",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPurchaseApplyTree(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-list-tree");
	}
	/**
	* 载入初始化清点页面
	* @param zx_purchase_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxPurchaseCheckApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxPurchaseCheckApply(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-check-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPurchaseApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPurchaseApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxPurchaseApply> zxPurchaseApplyList = zxPurchaseApplyService.getZxPurchaseApplyListByCondition(condition);
		PageInfo<ZxPurchaseApply> page = new PageInfo<ZxPurchaseApply>(zxPurchaseApplyList);
		return outPageBootStr(page,request);
	}
	/**
	* 加载初始化列表清点数据并分页
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPurchaseApplyCheckListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPurchaseApplyCheckListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		condition.put("status","3");
		commonHPager(condition,request);
		List<ZxPurchaseApply> zxPurchaseApplyList = zxPurchaseApplyService.getZxPurchaseApplyListByCondition(condition);
		PageInfo<ZxPurchaseApply> page = new PageInfo<ZxPurchaseApply>(zxPurchaseApplyList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param apply_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxPurchaseApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxPurchaseApplyById(String apply_id,HttpServletRequest request){
		ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
		return outDataStr(zxPurchaseApply);
	}
	/**
	* 添加
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxPurchaseApply(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		int i = 0;
		if(null != zxPurchaseApply && !"".equals(zxPurchaseApply)){
			XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
			zxPurchaseApply.setApply_id(UUID.toUUID());
			zxPurchaseApply.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxPurchaseApply.setStatus("0");
			zxPurchaseApply.setUser_id(applyUser.getXt_userinfo_id());
			i=zxPurchaseApplyService.addZxPurchaseApply(zxPurchaseApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxPurchaseApply(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		int i = 0;
		if(null != zxPurchaseApply && !"".equals(zxPurchaseApply)){
			i=zxPurchaseApplyService.updateZxPurchaseApply(zxPurchaseApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 批量入库
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxPurchaseApplyCheck",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxPurchaseApplyCheck(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		int i = 0;
		double beforechage=0;
		double afterchange=0;
		Map<String, Object> condition = new HashMap<String, Object>();
		ZxOfficeInventory zxOfficeInventory=new ZxOfficeInventory();
		condition.put("apply_id",zxPurchaseApply.getApply_id());
		if(null != zxPurchaseApply && !"".equals(zxPurchaseApply)){
			List<ZxPurchaseApplyDetail> list=zxPurchaseApply.getZxPurchaseApplyDetail();
			for(int j=0;j<list.size();j++){
				afterchange=list.get(j).getAmount_store();
				beforechage=zxPurchaseApplyDetailService.getZxPurchaseApplyDetailById(list.get(j).getId()).getAmount_store();
				zxOfficeInventoryService.updateOfficeInventoryByOfficeId(list.get(j).getGoods_id(),afterchange-beforechage);
			}
			i=zxPurchaseApplyService.updateZxPurchaseApplyCheck(zxPurchaseApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 清点
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/checkZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String checkZxPurchaseApply(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request){
		int i = 0;
		if(null != zxPurchaseApply && !"".equals(zxPurchaseApply)){
			i=zxPurchaseApplyService.updateZxPurchaseApply(zxPurchaseApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 申请
	* @param zx_purchase_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String applyZxPurchaseApply(String apply_id,HttpServletRequest request,Model model){
		int i = 0;
		if(null != apply_id && !"".equals(apply_id)){
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
			XtConstant Xt_Constant = getXtConstantCache("zx_purchase_apply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","用品审批流程" );
		    variables.put("owner",zxPurchaseApply.getUser_id());
		    lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条用品使用申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxPurchaseApply.getApply_id());
			if(activitiUtil.addApply(lc_his_id, zxPurchaseApply.getApply_id(), variables,lc_Apply)){
				zxPurchaseApply.setStatus("1");
				i=zxPurchaseApplyService.updateZxPurchaseApplyBySelectiveByCondition(zxPurchaseApply);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 审批
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/approvalZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String approvalZxPurchaseApply(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(taskData.get("businessKey").toString());
		    String vals = task_status + "," + zxPurchaseApply.getUser_id() + ",";
		    variables.setKeys("status,owner,applyType");
		    variables.setTypes("S,S,S");
		    vals +=3;
		    variables.setValues(vals);
		    ZxPurchaseApply ZxPurchaseApply=new ZxPurchaseApply();
		    ZxPurchaseApply.setApply_id(zxPurchaseApply.getApply_id());
		    String s="aa";
		    Map<String, Object> taskData1= (Map<String, Object>) activitiUtil.getTask(task_id).get("taskVariables");
		    taskData1.get("owner");
		    TaskDefinition t=activitiUtil.getNextTaskDefinition(task_id,s);
			if(activitiUtil.completeTask(task_id, variables)){
				LcApproval lc_approval = new LcApproval();
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("processInstance_id", ((Task) taskData.get("task")).getProcessInstanceId());
				List<LcApply> list = lcApplyService.getLcApplyListByCondition(condition);
				if(!list.isEmpty()){
					lc_approval.setLc_apply_id(list.get(0).getLc_apply_id());
				}
				lc_approval.setLc_approval_id(UUID.toUUID());
				lc_approval.setLc_approval_remark(remark);
				lc_approval.setLc_approval_time(CommonUtils.getDate());
				lc_approval.setLc_status_id(task_status);
				if(task_status.equals("yes")){
					lc_approval.setLc_status_name("审批通过");
					boolean isEnd = activitiUtil.isEnded(((Task) taskData.get("task")).getProcessInstanceId());
					if(isEnd){
						ZxPurchaseApply.setStatus("3");
						zxPurchaseApplyService.updateZxPurchaseApplyBySelectiveByCondition(ZxPurchaseApply);
					}
				}else{
					lc_approval.setLc_status_name("审批不通过");
					ZxPurchaseApply.setStatus("2");
					zxPurchaseApplyService.updateZxPurchaseApplyBySelectiveByCondition(ZxPurchaseApply);
				}
				lc_approval.setTaskId(task_id);
				lc_approval.setXt_userinfo_id(CommonUtils.getXtUid());
				lc_ApprovalService.addLcApproval(lc_approval);
				i = 1;
			}else{
				i = 0;
			};
		}
		if(i>0){ 
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
}
	/**
	* 删除
	* @param apply_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxPurchaseApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxPurchaseApply(String apply_id,HttpServletRequest request){
		int i = 0;
		if(null != apply_id && !"".equals(apply_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("apply_id",apply_id.split(","));
			i=zxPurchaseApplyService.delZxPurchaseApply(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 得到详情
	* @param apply_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getdetail",method={RequestMethod.POST,RequestMethod.GET})
	public String getdetail(String apply_id,HttpServletRequest request){
		ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
		return outItemsStr(zxPurchaseApply);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyAdd(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request, Model model){
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-add");
	}
	/**
	* 发送至发放页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyOut",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyOut(ZxPurchaseApply zxPurchaseApply,HttpServletRequest request, Model model){
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-out");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyUpdate(String apply_id,HttpServletRequest request, Model model){
		ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
		model.addAttribute("zxPurchaseApply", zxPurchaseApply);
		model.addAttribute("size", zxPurchaseApply.getZxPurchaseApplyDetail().size());
		model.addAttribute("zxPurchaseApplyJSON", outItemsStr(zxPurchaseApply));
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyDetail(String apply_id,HttpServletRequest request, Model model){
		ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
		model.addAttribute("zxPurchaseApply", zxPurchaseApply);
		model.addAttribute("size", zxPurchaseApply.getZxPurchaseApplyDetail().size());
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		model.addAttribute("zxPurchaseApplyJSON", outItemsStr(zxPurchaseApply));
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-detail");
	}
	/**
	* 发送至清点页面
	* @param request 
	*/
	@RequestMapping(value="/toZxPurchaseApplyCheck",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxPurchaseApplyCheck(String apply_id,HttpServletRequest request, Model model){
		ZxPurchaseApply zxPurchaseApply = zxPurchaseApplyService.getZxPurchaseApplyById(apply_id);
		model.addAttribute("zxPurchaseApply", zxPurchaseApply);
		model.addAttribute("size", zxPurchaseApply.getZxPurchaseApplyDetail().size());
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		model.addAttribute("zxPurchaseApplyJSON", outItemsStr(zxPurchaseApply));
		return new ModelAndView("pc/zx-view/zx-purchase-apply/zx-purchase-apply-out");
	}
	
}
