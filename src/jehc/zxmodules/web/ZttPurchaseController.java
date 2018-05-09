package jehc.zxmodules.web;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import jehc.xtmodules.xtservice.XtPostService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderCheckHistory;
import jehc.zxmodules.model.ZttPurchase;
import jehc.zxmodules.model.ztt_filerecord;
import jehc.zxmodules.model.ztt_processproduct;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.service.ZttOrderbybuyService;
import jehc.zxmodules.service.ZttOrderbyselfService;
import jehc.zxmodules.service.ZttPurchaseService;

/**
 * 采购台账 2018-04-03 12:43:49 季建吉
 */
@Controller
@RequestMapping("/zttPurchaseController")
public class ZttPurchaseController extends BaseAction {
	@Autowired
	private ZttPurchaseService zttPurchaseService;
	@Autowired
	private ZttOrderService zttOrderService;
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
	private XtPostService XtPostService;
	@Autowired
	private ZttOrderbyselfService zttOrderbyselfService;
	@Autowired
	private ZttOrderbybuyService zttOrderbybuyService;

	/**
	 * 载入初始化页面
	 * 
	 * @param ztt_purchase
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loadZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loadZttPurchase(ZttPurchase zttPurchase, HttpServletRequest request) {
		return new ModelAndView("pc/zx-view/ztt-purchase/ztt-purchase-list");
	}

	/**
	 * 加载初始化列表数据并分页
	 * 
	 * @param ztt_purchase
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/getZttPurchaseListByCondition", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZttPurchaseListByCondition(BaseSearch baseSearch, HttpServletRequest request) {
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition, request);
		List<ZttPurchase> zttPurchaseList = zttPurchaseService.getZttPurchaseListByCondition(condition);
		PageInfo<ZttPurchase> page = new PageInfo<ZttPurchase>(zttPurchaseList);
		return outPageBootStr(page, request);
	}

	/**
	 * 获取对象
	 * 
	 * @param id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/getZttPurchaseById", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZttPurchaseById(String id, String isnewerp,HttpServletRequest request) {
		ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(id);
		if(isnewerp!=null){
			if(isnewerp.equals("1")){
				zttPurchase.setErp_number(zttOrderService.getmaxerp(id));
			}
		}
		
		return outDataStr(zttPurchase);
	}

	/**
	 * 添加
	 * 
	 * @param ztt_purchase
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/addZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public String addZttPurchase(ZttPurchase zttPurchase, HttpServletRequest request) {
		int i = 0;
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		if (null != zttPurchase && !"".equals(zttPurchase)) {
			zttPurchase.setId(UUID.toUUID());
			zttPurchase.setState("0");
			zttPurchase.setApply_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zttPurchase.setApply_id(applyUser.getXt_userinfo_id());
			i = zttPurchaseService.addZttPurchase(zttPurchase);
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 修改
	 * 
	 * @param ztt_purchase
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/updateZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateZttPurchase(ZttPurchase zttPurchase, HttpServletRequest request) {
		int i = 0;
		if (null != zttPurchase && !"".equals(zttPurchase)) {
			i = zttPurchaseService.updateZttPurchaseBySelective(zttPurchase);
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/delZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public String delZttPurchase(String id, HttpServletRequest request) {
		int i = 0;
		if (null != id && !"".equals(id)) {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id.split(","));
			i = zttPurchaseService.delZttPurchase(condition);
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 复制一行并生成记录
	 * 
	 * @param id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/copyZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public String copyZttPurchase(String id, HttpServletRequest request) {
		int i = 0;
		ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(id);
		if (null != zttPurchase && !"".equals(zttPurchase)) {
			zttPurchase.setId(UUID.toUUID());
			i = zttPurchaseService.addZttPurchase(zttPurchase);
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 导出
	 * 
	 * @param excleData
	 * @param excleHeader
	 * @param excleText
	 * @param request
	 * @param request
	 */
	@RequestMapping(value = "/exportZttPurchase", method = { RequestMethod.POST, RequestMethod.GET })
	public void exportZttPurchase(String excleData, String excleHeader, String excleText, HttpServletRequest request,
			HttpServletResponse response) {
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader, excleText, response);
	}

	/**
	 * 发送至新增页面
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/toZttPurchaseAdd", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toZttPurchaseAdd(ZttPurchase zttPurchase, HttpServletRequest request) {
		return new ModelAndView("pc/zx-view/ztt-purchase/ztt-purchase-add");
	}

	/**
	 * 发送至编辑页面
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/toZttPurchaseUpdate", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toZttPurchaseUpdate(String id, HttpServletRequest request, Model model) {
		ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(id.split(",")[0]);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		model.addAttribute("zttPurchase", zttPurchase);
		return new ModelAndView("pc/zx-view/ztt-purchase/ztt-purchase-update");
	}

	/**
	 * 发送至明细页面
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/toZttPurchaseDetail", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toZttPurchaseDetail(String id, HttpServletRequest request, Model model) {
		ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(id.split(",")[0]);
		model.addAttribute("zttPurchase", zttPurchase);
		return new ModelAndView("pc/zx-view/ztt-purchase/ztt-purchase-detail");
	}

	/**
	 * 发送至生产部或者质检明细页面
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/toZttpurchasecheck_history", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toZttpurchasecheck_history(String id, String state, HttpServletRequest request, Model model) {
		String path = null;
		if (state.equals("8")) {
			ztt_processproduct ztt_processproduct = new ztt_processproduct();
			ztt_processproduct.setOrder_id(id);
			model.addAttribute("ztt_processproduct", ztt_processproduct);
			path = "pc/zx-view/ztt-purchase/zttpurchase_filehistory";
		} else if (state.equals("7")) {
			ZttOrderCheckHistory zttOrderCheckHistory = new ZttOrderCheckHistory();
			zttOrderCheckHistory.setOrder_id(id);
			model.addAttribute("zttOrderCheckHistory", zttOrderCheckHistory);
			path = "pc/zx-view/ztt-purchase/zttpurchase_checkhistory";
		}

		return new ModelAndView(path);
	}

	/**
	 * 申请
	 * 
	 * @param zx_goods_apply
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/toApply", method = { RequestMethod.POST, RequestMethod.GET })
	public String toApply(String apply_id, HttpServletRequest request, Model model) {
		int i = 0;
		if (null != apply_id && !"".equals(apply_id)) {
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(apply_id);
			XtConstant Xt_Constant = getXtConstantCache("ztt_purchase");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("taskType", "采购流程");
			variables.put("owner", zttPurchase.getApply_id());
			variables.put("taskkind", "ztt_purchase");
			lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName() + "于" + getSimpleDateFormat() + "，提交了一条采购流程");
			lc_Apply.setLc_apply_model_biz_id(zttPurchase.getId());
			if (activitiUtil.addApply(lc_his_id, zttPurchase.getId(), variables, lc_Apply)) {
				zttPurchase.setState("1");
				i = zttPurchaseService.updateZttPurchaseBySelective(zttPurchase);

			}
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 质检申请
	 * 
	 * @param zx_goods_apply
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/toApplycheck", method = { RequestMethod.POST, RequestMethod.GET })
	public String toApplycheck(String apply_id, HttpServletRequest request, Model model) {
		int i = 0;
		if (null != apply_id && !"".equals(apply_id)) {
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(apply_id);
			XtConstant Xt_Constant = getXtConstantCache("ztt_quality_check");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("taskType", "质检流程");
			variables.put("owner", zttPurchase.getApply_id());
			variables.put("taskkind", "ztt_purchase");
			lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName() + "于" + getSimpleDateFormat() + "，提交了一条质检流程");
			lc_Apply.setLc_apply_model_biz_id(zttPurchase.getId());
			if (activitiUtil.addApply(lc_his_id, zttPurchase.getId(), variables, lc_Apply)) {
				zttPurchase.setState("50");
				i = zttPurchaseService.updateZttPurchaseBySelective1(zttPurchase);

			}
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

	/**
	 * 采购审批
	 * 
	 * @param id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/approvalOrderpurchaseApply", method = { RequestMethod.POST, RequestMethod.GET })
	public String approvalOrderpurchaseApply(String task_id, String task_status, String remark, String path,
			String supply_name, String single_price, String end_date, String not_satisfy_reason,
			String contract_attachment,String delivery_note, HttpServletRequest request) {
		int i = 0;
		if (task_status == null) {
			task_status = "";
		}
		if (null != task_id && !"".equals(task_id)) {
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
			Variable variables = new Variable();
			ZttPurchase zttPurchase = zttPurchaseService.getZttPurchaseById(taskData.get("businessKey").toString());
			String vals = task_status + "," + zttPurchase.getApply_id();
			variables.setKeys("status,owner");
			variables.setTypes("S,S");
			variables.setValues(vals);
			ztt_filerecord ztt_filerecord = new ztt_filerecord();
			ztt_filerecord.setOrder_id(zttPurchase.getId());
			ztt_filerecord.setId(UUID.toUUID());
			ztt_filerecord.setApproval_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			String s = remark;
			Map<String, Object> taskData1 = (Map<String, Object>) activitiUtil.getTask(task_id).get("taskVariables");
			taskData1.get("owner");
			/*
			 * TaskDefinition t=activitiUtil.getNextTaskDefinition(task_id,s);
			 */
			if (activitiUtil.completeTask(task_id, variables)) {
				LcApproval lc_approval = new LcApproval();
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("processInstance_id", ((Task) taskData.get("task")).getProcessInstanceId());
				List<LcApply> list = lcApplyService.getLcApplyListByCondition(condition);
				if (!list.isEmpty()) {
					lc_approval.setLc_apply_id(list.get(0).getLc_apply_id());
				}
				lc_approval.setLc_approval_id(UUID.toUUID());
				lc_approval.setLc_approval_remark(remark);
				lc_approval.setLc_approval_time(CommonUtils.getDate());
				lc_approval.setLc_status_id(task_status);
				if (task_status.equals("yes")) {
					if (remark.equals("buydata")) {
						lc_approval.setLc_status_name("交货时间能满足");
						zttPurchase.setHope_end_data(end_date);
						zttPurchase.setState("4");
					} else if (remark.equals("updatedate")) {
						zttPurchase.setHope_end_data(end_date);
					} else if (remark.equals("arrival")) {
						lc_approval.setLc_status_name("流程结束");
						zttPurchase.setState("5");
						ztt_filerecord.setStatus_name("确认到货,进入质检");
						zttPurchase.setDelivery_note(delivery_note);
						zttOrderService.addZttOrderfileRecord(ztt_filerecord);
					} else if (remark.equals("manager")) {
						lc_approval.setLc_status_name("主管同意");
						zttPurchase.setState("11");
						ztt_filerecord.setProduct_check_comment("主管同意");
						ztt_filerecord.setStatus_name("主管同意");
						zttOrderService.addZttOrderfileRecord(ztt_filerecord);
					}else if (remark.equals("erpnumber")) {
						lc_approval.setLc_status_name("数据分析师通过");
						zttPurchase.setState("13");
						zttPurchase.setErp_number(path);
						ztt_filerecord.setProduct_check_comment("数据分析师通过");
						ztt_filerecord.setStatus_name("数据分析师通过");
						zttOrderService.addZttOrderfileRecord(ztt_filerecord);
					}else if (remark.equals("begin_purchase")) {
						lc_approval.setLc_status_name("开始采购,等待到货");
						zttPurchase.setState("14");
						zttPurchase.setSupply_name(supply_name);
						zttPurchase.setErp_number(path);
						ztt_filerecord.setProduct_check_comment("开始采购,等待到货");
						ztt_filerecord.setStatus_name("开始采购,等待到货");
						zttOrderService.addZttOrderfileRecord(ztt_filerecord);
					}
					zttPurchaseService.updateZttPurchaseBySelective(zttPurchase);
				} else if (task_status.equals("no")) {
					lc_approval.setLc_status_name("审批不通过");
					if (remark.equals("buydata")) {
						lc_approval.setLc_status_name("交货日期不能满足");
						zttPurchase.setHope_end_data(end_date);
						zttPurchase.setState("3");
						zttPurchase.setNot_satisfy_reason(not_satisfy_reason);
					}else if (remark.equals("manager")) {
						lc_approval.setLc_status_name("主管驳回");
						zttPurchase.setState("12");
						ztt_filerecord.setProduct_check_comment("主管驳回");
						ztt_filerecord.setStatus_name("主管驳回");
						zttOrderService.addZttOrderfileRecord(ztt_filerecord);
					}
					zttPurchaseService.updateZttPurchaseBySelective(zttPurchase);
				}
				lc_approval.setTaskId(task_id);
				lc_approval.setXt_userinfo_id(CommonUtils.getXtUid());
				lc_ApprovalService.addLcApproval(lc_approval);
				i = 1;
			} else {
				i = 0;
			}
			;
		}
		if (i > 0) {
			return outAudStr(true);
		} else {
			return outAudStr(false);
		}
	}

}
