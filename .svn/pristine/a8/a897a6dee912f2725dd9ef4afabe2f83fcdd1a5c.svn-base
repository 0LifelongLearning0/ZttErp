package jehc.zxmodules.web;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import jehc.xtmodules.xtmodel.XtDepartinfo;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtDepartinfoService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxCarApply;
import jehc.zxmodules.model.ZxLoanBill;
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.service.ZxOfficeApplyService;

/**
* 办公用品申请表 
* 2017-12-05 15:17:15  季建吉
*/
@Controller
@RequestMapping("/zxOfficeApplyController")
public class ZxOfficeApplyController extends BaseAction{
	@Autowired
	private ZxOfficeApplyService zxOfficeApplyService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private XtDepartinfoService xtDepartinfoService;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	/**
	* 载入初始化页面
	* @param zx_office_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOfficeApply(ZxOfficeApply zxOfficeApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-office-apply/zx-office-apply-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_office_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOfficeApplyShow> zxOfficeApplyList = zxOfficeApplyService.getZxOfficeApplyListByCondition(condition);
		PageInfo<ZxOfficeApplyShow> page = new PageInfo<ZxOfficeApplyShow>(zxOfficeApplyList);
		return outPageStr(page,request);
	}
	
	
	
	/**
	* 根据id获取对象-编辑页面
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeApplyById(String id,HttpServletRequest request){
		ZxOfficeApplyShow ZxOfficeApplyShow = zxOfficeApplyService.getZxOfficeApplyById(id);
		return outDataStr(ZxOfficeApplyShow);
	}
	/**
	* 申领
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/setZxOfficeApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String setZxOfficeApplyById(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZxOfficeApplyShow zxOfficeApplyShow = zxOfficeApplyService.getZxOfficeApplyById(id);
			XtConstant Xt_Constant = getXtConstantCache("zx-office");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","办公用品审批流程" );
		    variables.put("owner",zxOfficeApplyShow.getUser_id());
		    lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条办公用品使用申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxOfficeApplyShow.getId());
			if(activitiUtil.addApply(lc_his_id, zxOfficeApplyShow.getId(), variables,lc_Apply)){
				i=zxOfficeApplyService.updateZxOfficeApplyProof(id);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 添加
	* @param zx_office_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOfficeApply(ZxOfficeApply zxOfficeApply,HttpServletRequest request){
		int i = 0;
		if(null != zxOfficeApply && !"".equals(zxOfficeApply)){
			if(zxOfficeApply.getOffice_id().contains(","))
			{
				zxOfficeApply.setOffice_id(zxOfficeApply.getOffice_id().substring(0, zxOfficeApply.getOffice_id().length()-1));
			}
			zxOfficeApply.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxOfficeApply.setUser_id(getXtUid());
			zxOfficeApply.setId(UUID.toUUID());
			zxOfficeApply.setStatus("0");
			i=zxOfficeApplyService.addZxOfficeApply(zxOfficeApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_office_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOfficeApply(ZxOfficeApply zxOfficeApply,HttpServletRequest request){
		int i = 0;
		if(null != zxOfficeApply && !"".equals(zxOfficeApply)){
			if(zxOfficeApply.getOffice_id().contains(","))
			{
				zxOfficeApply.setOffice_id(zxOfficeApply.getOffice_id().substring(0, zxOfficeApply.getOffice_id().length()-1));
			}
			i=zxOfficeApplyService.updateZxOfficeApply(zxOfficeApply);
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
	@RequestMapping(value="/delZxOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOfficeApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOfficeApplyService.delZxOfficeApply(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	@RequestMapping(value="/exportZxOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOfficeApply(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 审批
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/approvalOfficeApply",method={RequestMethod.POST,RequestMethod.GET})
	public String approval(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxOfficeApplyShow zxOfficeApplyShow = zxOfficeApplyService.getZxOfficeApplyById(taskData.get("businessKey").toString());
		    String vals = task_status + "," + zxOfficeApplyShow.getUser_id() + ",";
		    variables.setKeys("status,owner,applyType");
		    variables.setTypes("S,S,S");
		    vals +=3;
		    variables.setValues(vals);
		    ZxOfficeApply zxOfficeApply=new ZxOfficeApply();
		    zxOfficeApply.setId(zxOfficeApplyShow.getId());
		  /*  ArrayList list=new ArrayList();
		    Map<String, Object> map;
		    Map<String, Object> condition = new HashMap<String, Object>();
		    commonPager(condition, request);
		    map = activitiUtil.getTaskList(condition);
		    List<Task> list1 = (List<Task>)map.get("TaskList");
		    for(int j = 0; j < list1.size(); j++){
				Task task = list1.get(j);
				if(task.getId().equals("217510")){
					
				}
				else{
					activitiUtil.completeTask(task.getId(), variables);
				}
				
		    }*/
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
						zxOfficeApply.setStatus("3");
						zxOfficeApply.setApprove_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zxOfficeApplyService.updateZxOfficeApply(zxOfficeApply);
					}
				}else{
					lc_approval.setLc_status_name("审批不通过");
					zxOfficeApply.setStatus("4");
					zxOfficeApplyService.updateZxOfficeApply(zxOfficeApply);
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
