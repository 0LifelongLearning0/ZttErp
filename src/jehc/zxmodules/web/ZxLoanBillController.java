package jehc.zxmodules.web;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.lcmodules.activitiutil.ActivitiUtil;
import jehc.lcmodules.activitiutil.util.Variable;
import jehc.lcmodules.lcmodel.LcApply;
import jehc.lcmodules.lcmodel.LcApproval;
import jehc.lcmodules.lcservice.LcApplyService;
import jehc.lcmodules.lcservice.LcApprovalService;
import jehc.lcmodules.lcservice.LcDeploymentHisService;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxLoanBill;
import jehc.zxmodules.service.ZxLoanBillService;
import net.sf.json.JSONArray;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 借款单 
* 2017-10-10 14:59:11  袁天宇
*/
@Controller
@RequestMapping("/zxLoanBillController")
public class ZxLoanBillController extends BaseAction{
	@Autowired
	private ZxLoanBillService zxLoanBillService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	/**
	* 载入初始化页面
	* @param zx_loan_bill 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxLoanBill(ZxLoanBill zxLoanBill,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-loan-bill/zx-loan-bill-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_loan_bill 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxLoanBillListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxLoanBillListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxLoanBill> zxLoanBillList = zxLoanBillService.getZxLoanBillListByCondition(condition);
		for(ZxLoanBill loan :zxLoanBillList){
			XtUserinfo borrower = xtUserinfoService.getXtUserinfoById(loan.getUser_id());
			loan.setXt_userinfo_realName(borrower.getXt_userinfo_realName());
		}
		PageInfo<ZxLoanBill> page = new PageInfo<ZxLoanBill>(zxLoanBillList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxLoanBillById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxLoanBillById(String id,HttpServletRequest request){
		ZxLoanBill zxLoanBill = zxLoanBillService.getZxLoanBillById(id);
		String outData = outDataStr(zxLoanBill);
		String outStr = outData.substring(0,outData.length()-2);
		XtUserinfo borrower = xtUserinfoService.getXtUserinfoById(zxLoanBill.getUser_id());
		if(null != borrower){
			String jsonStr = JSONArray.fromObject(borrower).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"borrower\":").concat(jsonStr);
		}
		outStr = outStr.concat(outData.substring(outData.length()-2,outData.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_loan_bill 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxLoanBill(ZxLoanBill zxLoanBill,HttpServletRequest request){
		int i = 0;
		if(null != zxLoanBill){
			zxLoanBill.setId(UUID.toUUID());
			zxLoanBill.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxLoanBillService.addZxLoanBill(zxLoanBill);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_loan_bill 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxLoanBill(ZxLoanBill zxLoanBill,HttpServletRequest request){
		int i = 0;
		if(null != zxLoanBill){
			zxLoanBill.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxLoanBillService.updateZxLoanBill(zxLoanBill);
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
	@RequestMapping(value="/delZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxLoanBill(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxLoanBillService.delZxLoanBill(condition);
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
	@RequestMapping(value="/copyZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxLoanBill(String id,HttpServletRequest request){
		int i = 0;
		ZxLoanBill zxLoanBill = zxLoanBillService.getZxLoanBillById(id);
		if(null != zxLoanBill){
			zxLoanBill.setId(UUID.toUUID());
			i=zxLoanBillService.addZxLoanBill(zxLoanBill);
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
	@RequestMapping(value="/exportZxLoanBill",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxLoanBill(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 提出申请
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyZxLoanApply",method={RequestMethod.POST,RequestMethod.GET})
	public String applyZxLoanApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			ZxLoanBill zxLoanBill = zxLoanBillService.getZxLoanBillById(id);
			//将业务与工作流流程绑定起来
			XtConstant Xt_Constant = getXtConstantCache("zxLoan");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","借款审批流程" );
			lc_Apply.setLc_apply_title(CommonUtils.getXtU().getXt_userinfo_name()+"于"+getSimpleDateFormat()+"，提交了借款申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxLoanBill.getId());
			if(activitiUtil.addApply(lc_his_id, zxLoanBill.getId(), variables,lc_Apply)){
				//处理业务：将状态改为待部门负责人审核
				zxLoanBill.setStatus("2");
				i=zxLoanBillService.updateZxLoanBill(zxLoanBill);
			}else{
				i = 0;
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
	@RequestMapping(value="/approvalLoan",method={RequestMethod.POST,RequestMethod.GET})
	public String approval(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxLoanBill zxLoanBill = zxLoanBillService.getZxLoanBillById(taskData.get("businessKey").toString());
		    String vals = task_status;
	    	variables.setKeys("status");
		    variables.setTypes("S");
		    variables.setValues(vals);
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
						zxLoanBill.setStatus("3");
						zxLoanBill.setApprove_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zxLoanBillService.updateZxLoanBill(zxLoanBill);
					}
				}else{
					lc_approval.setLc_status_name("审批不通过");
					zxLoanBill.setStatus("4");
					zxLoanBillService.updateZxLoanBill(zxLoanBill);
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
}
