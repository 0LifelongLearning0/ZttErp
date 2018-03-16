package jehc.zxmodules.web;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxExpressdelivery;
import jehc.zxmodules.service.ZxExpressdeliveryService;
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
* 快递邮寄 
* 2017-11-24 13:10:10  陈运芝
*/
@Controller
@RequestMapping("/zxExpressdeliveryController")
public class ZxExpressdeliveryController extends BaseAction{
	@Autowired
	private ZxExpressdeliveryService zxExpressdeliveryService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	/**
	* 载入初始化页面
	* @param zx_expressdelivery 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxExpressdelivery",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxExpressdelivery(ZxExpressdelivery zxExpressdelivery,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-expressdelivery/zx-expressdelivery-list");
	}
	/**
	* 载入初始化页面（登记）
	* @param zx_expressdelivery 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxExpressdeliveryRegister",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxExpressdeliveryRegister(ZxExpressdelivery zxExpressdelivery,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-expressdelivery/zx-expressdelivery-register");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_expressdelivery 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxExpressdeliveryListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxExpressdeliveryListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxExpressdelivery> zxExpressdeliveryList = zxExpressdeliveryService.getZxExpressdeliveryListByCondition(condition);
		PageInfo<ZxExpressdelivery> page = new PageInfo<ZxExpressdelivery>(zxExpressdeliveryList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxExpressdeliveryById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxExpressdeliveryById(String id,HttpServletRequest request){
		ZxExpressdelivery zxExpressdelivery = zxExpressdeliveryService.getZxExpressdeliveryById(id);
		String outData = outDataStr(zxExpressdelivery);
		String outStr = outData.substring(0,outData.length()-2);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxExpressdelivery.getApply_user_id());
		if(null != applyUser){
			String jsonStr = JSONArray.fromObject(applyUser).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"applyUser\":").concat(jsonStr);
		}
		outStr = outStr.concat(outData.substring(outData.length()-2,outData.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_expressdelivery 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxExpressdelivery",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxExpressdelivery(ZxExpressdelivery zxExpressdelivery,HttpServletRequest request){
		int i = 0;
		if(null != zxExpressdelivery && !"".equals(zxExpressdelivery)){
			zxExpressdelivery.setId(UUID.toUUID());
			zxExpressdelivery.setApply_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxExpressdelivery.setStatus("1");
			i=zxExpressdeliveryService.addZxExpressdelivery(zxExpressdelivery);
			if(i > 0 ){
				//开启审批流程:将业务与工作流流程绑定起来
				XtConstant Xt_Constant = getXtConstantCache("zxExpressdelivery");
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
				String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
				LcApply lc_Apply = new LcApply();
				Map<String, Object> variables = new HashMap<String, Object>();
			    variables.put("taskType","快递审批流程" );
				lc_Apply.setLc_apply_title(CommonUtils.getXtU().getXt_userinfo_name()+"于"+getSimpleDateFormat()+"，提交了快递邮寄申请流程");
				lc_Apply.setLc_apply_model_biz_id(zxExpressdelivery.getId());
				activitiUtil.addApply(lc_his_id, zxExpressdelivery.getId(), variables,lc_Apply);
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
	* @param zx_expressdelivery 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxExpressdelivery",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxExpressdelivery(ZxExpressdelivery zxExpressdelivery,HttpServletRequest request){
		int i = 0;
		if(null != zxExpressdelivery && !"".equals(zxExpressdelivery)){
			i=zxExpressdeliveryService.updateZxExpressdelivery(zxExpressdelivery);
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
	@RequestMapping(value="/approval",method={RequestMethod.POST,RequestMethod.GET})
	public String approvalExpressdelivery(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxExpressdelivery zxExpressdelivery = zxExpressdeliveryService.getZxExpressdeliveryById(taskData.get("businessKey").toString());
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
						zxExpressdelivery.setStatus("2");
						zxExpressdeliveryService.updateZxExpressdelivery(zxExpressdelivery);
					}
				}else{
					lc_approval.setLc_status_name("审批不通过");
					zxExpressdelivery.setStatus("3");
					zxExpressdeliveryService.updateZxExpressdelivery(zxExpressdelivery);
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
