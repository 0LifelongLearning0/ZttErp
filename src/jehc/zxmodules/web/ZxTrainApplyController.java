package jehc.zxmodules.web;
import java.util.List;
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
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.model.ZxTrainApply;
import jehc.zxmodules.service.ZxTrainApplyService;

/**
* 员工培训申请表 
* 2017-12-15 09:26:46  季建吉
*/
@Controller
@RequestMapping("/zxTrainApplyController")
public class ZxTrainApplyController extends BaseAction{
	
	@Autowired
	private XtURService xtURService;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private ZxTrainApplyService zxTrainApplyService;
	@Autowired
	private XtDepartinfoService xtDepartinfoService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	/**
	* 载入初始化页面
	* @param zx_train_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxTrainApply(ZxTrainApply zxTrainApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-train-apply/zx-train-apply-list");
	}
	
	@RequestMapping(value="/loadZxTrainApprove",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxTrainApprove(ZxTrainApply zxTrainApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-train-approve/zx-train-approve-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxTrainApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxTrainApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxTrainApply> zxTrainApplyList = zxTrainApplyService.getZxTrainApplyListByCondition(condition);
		PageInfo<ZxTrainApply> page = new PageInfo<ZxTrainApply>(zxTrainApplyList);
		return outPageStr(page,request);
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxTrainApproveListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxTrainApproveListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxTrainApply> zxTrainApplyList = zxTrainApplyService.getZxTrainApproveListByCondition(condition);
		PageInfo<ZxTrainApply> page = new PageInfo<ZxTrainApply>(zxTrainApplyList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxTrainApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxTrainApplyById(String id,HttpServletRequest request){
		ZxTrainApply zxTrainApply = zxTrainApplyService.getZxTrainApplyById(id);
		if(zxTrainApply.getStatus().equals("0")){
			zxTrainApply.setStatus("面授");
		}else{
			zxTrainApply.setStatus("函授");
		}
		if(zxTrainApply.getTrain_agreement().equals("0")){
			zxTrainApply.setTrain_agreement("签署");
		}else{
			zxTrainApply.setTrain_agreement("不签署");
		}
		if(zxTrainApply.getTrain_cato().equals("0")){
			zxTrainApply.setTrain_cato("面授");
		}else{
			zxTrainApply.setTrain_cato("函授");
		}
		return outDataStr(zxTrainApply);
	}
	/**
	* 添加
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxTrainApply(ZxTrainApply zxTrainApply,HttpServletRequest request){
		int i = 0;
		if(null != zxTrainApply && !"".equals(zxTrainApply)){
			zxTrainApply.setId(UUID.toUUID());
			zxTrainApply.setTrain_userid(getXtUid());
			zxTrainApply.setStatus("0");
			zxTrainApply.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxTrainApplyService.addZxTrainApply(zxTrainApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 通过申请
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/approveZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String approveZxTrainApply(ZxTrainApply zxTrainApply,HttpServletRequest request){
		int i = 0;
		
		if(null != zxTrainApply.getId() && !"".equals(zxTrainApply.getId())){
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			conditionr.put("xt_roleinfo_id", "316A8C82ED19412AB13DA0D634717CAC");
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			if(CommonUtils.getXtU().getXt_departinfo_id().equals("52f944f2589140beb6cd476109c7ccbc")){
				
			}else{
				
			}
			
			ZxTrainApply ZxTrainApply = zxTrainApplyService.getZxTrainApplyById(zxTrainApply.getId());
			XtConstant Xt_Constant = getXtConstantCache("ZxTrainApply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","培训审批流程" );
		    variables.put("owner",ZxTrainApply.getTrain_userid());
		    lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条培训申请流程");
			lc_Apply.setLc_apply_model_biz_id(ZxTrainApply.getId());
			if(activitiUtil.addApply(lc_his_id, ZxTrainApply.getId(), variables,lc_Apply)){
				i=zxTrainApplyService.updateZxTrainApplyApply(zxTrainApply);
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
	@RequestMapping(value="/approvalTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String approval(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxTrainApply ZxTrainApply = zxTrainApplyService.getZxTrainApplyById(taskData.get("businessKey").toString());
		    String vals = task_status;
		    variables.setKeys("status");
		    variables.setTypes("S");
		    variables.setValues(vals);
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
						ZxTrainApply.setStatus("3");
						ZxTrainApply.setApprove_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zxTrainApplyService.updateZxTrainApplyBySelective(ZxTrainApply);
					}
				}else{
					lc_approval.setLc_status_name("审批不通过");
					ZxTrainApply.setStatus("4");
					zxTrainApplyService.updateZxTrainApplyBySelective(ZxTrainApply);
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
	* 通知培训
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateapproveZxTrainApprove",method={RequestMethod.POST,RequestMethod.GET})
	public String updateapproveZxTrainApprove(ZxTrainApply zxTrainApply,HttpServletRequest request){
		int i = 0;
		if(null != zxTrainApply && !"".equals(zxTrainApply)){
			zxTrainApply.setStatus("4");
			i=zxTrainApplyService.updateapproveZxTrainApprove(zxTrainApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 归档 
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateapproveZxTrainEnd",method={RequestMethod.POST,RequestMethod.GET})
	public String updateapproveZxTrainEnd(ZxTrainApply zxTrainApply,HttpServletRequest request){
		int i = 0;
		if(null != zxTrainApply && !"".equals(zxTrainApply)){
			zxTrainApply.setStatus("5");
			i=zxTrainApplyService.updateapproveZxTrainApprove(zxTrainApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_train_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxTrainApply(ZxTrainApply zxTrainApply,HttpServletRequest request){
		int i = 0;
		if(null != zxTrainApply && !"".equals(zxTrainApply)){
			i=zxTrainApplyService.updateZxTrainApply(zxTrainApply);
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
	@RequestMapping(value="/delZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxTrainApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxTrainApplyService.delZxTrainApply(condition);
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
	@RequestMapping(value="/copyZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxTrainApply(String id,HttpServletRequest request){
		int i = 0;
		ZxTrainApply zxTrainApply = zxTrainApplyService.getZxTrainApplyById(id);
		if(null != zxTrainApply && !"".equals(zxTrainApply)){
			zxTrainApply.setId(UUID.toUUID());
			i=zxTrainApplyService.addZxTrainApply(zxTrainApply);
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
	@RequestMapping(value="/exportZxTrainApply",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxTrainApply(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
