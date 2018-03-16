package jehc.zxmodules.web;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
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
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtMessage;
import jehc.xtmodules.xtservice.XtMessageService;
import jehc.zxmodules.model.ZxJudgeAgainResult;
import jehc.zxmodules.model.ZxJudgeUser;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxJudgeAgainResultService;
import jehc.zxmodules.service.ZxJudgeUserService;
import jehc.zxmodules.service.ZxSupplierService;

/**
* 供应商再评审结果 
* 2017-09-26 17:22:17  a
*/
@Controller
@RequestMapping("/zxJudgeAgainResultController")
public class ZxJudgeAgainResultController extends BaseAction{
	@Autowired
	private ZxJudgeAgainResultService zxJudgeAgainResultService;
	@Autowired
	private ZxJudgeUserService zxJudgeUserService;
	@Autowired
	private XtMessageService xtMessageService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private ZxSupplierService zxSupplierService;
	
	/**
	* 载入初始化页面
	* @param zx_judge_again_result 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-judge-result/zx-judge-again-result-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_judge_again_result 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxJudgeAgainResultListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeAgainResultListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("is_connect", 1);
		condition.put("state", 1);
		List<ZxJudgeAgainResult> zxJudgeAgainResultList = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
		PageInfo<ZxJudgeAgainResult> page = new PageInfo<ZxJudgeAgainResult>(zxJudgeAgainResultList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxJudgeAgainResultById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeAgainResultById(String id,HttpServletRequest request){
		ZxJudgeAgainResult zxJudgeAgainResult = zxJudgeAgainResultService.getZxJudgeAgainResultById(id);
		return outDataStr(zxJudgeAgainResult);
	}
	/**
	* 添加
	* @param zx_judge_again_result 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult,HttpServletRequest request){
		int i = 0;
		if(null != zxJudgeAgainResult){
			zxJudgeAgainResult.setId(UUID.toUUID());
			i=zxJudgeAgainResultService.addZxJudgeAgainResult(zxJudgeAgainResult);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_judge_again_result 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult,HttpServletRequest request){
		int i = 0;
		if(null != zxJudgeAgainResult){
			i=zxJudgeAgainResultService.updateZxJudgeAgainResult(zxJudgeAgainResult);
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
	@RequestMapping(value="/delZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxJudgeAgainResult(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			String idArray[] = id.split(",");
			List<ZxJudgeAgainResult> list = new ArrayList<ZxJudgeAgainResult>();
			for(String s:idArray){
				ZxJudgeAgainResult bean = zxJudgeAgainResultService.getZxJudgeAgainResultById(s);
				bean.setState("0");
				list.add(bean);
			}
			if(!list.isEmpty()) i=zxJudgeAgainResultService.updateBatchZxJudgeAgainResult(list);
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
	@RequestMapping(value="/copyZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxJudgeAgainResult(String id,HttpServletRequest request){
		int i = 0;
		ZxJudgeAgainResult zxJudgeAgainResult = zxJudgeAgainResultService.getZxJudgeAgainResultById(id);
		if(null != zxJudgeAgainResult){
			zxJudgeAgainResult.setId(UUID.toUUID());
			i=zxJudgeAgainResultService.addZxJudgeAgainResult(zxJudgeAgainResult);
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
	@RequestMapping(value="/exportZxJudgeAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxJudgeAgainResult(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 申请再评审
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyJudgeAgain",method={RequestMethod.POST,RequestMethod.GET})
	public String applyJudgeAgain(String choose_year,String supplier_id,HttpServletRequest request){
		int i = 0;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id",supplier_id);
		condition.put("judge_year",choose_year);
		condition.put("state",1);
		List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
		if(results == null||results.size() < 1){
			ZxJudgeAgainResult result = new ZxJudgeAgainResult(); 
			result.setId(UUID.toUUID());
			result.setSupplier_id(supplier_id);
			result.setStatus("1");
			result.setState("1");
			i = zxJudgeAgainResultService.addZxJudgeAgainResult(result);
		}
		if(i > 0){
			return "1";
		}else{
			return "0";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getAgainOverview",method={RequestMethod.POST,RequestMethod.GET})
	public String getAgainOverview(String supplier_id,HttpServletRequest request){
		JSONObject object = new JSONObject();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id",supplier_id);
		condition.put("state",1);
		condition.put("order_by_judge_date",1);
		List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
		if(results != null&&!results.isEmpty()){
			ZxJudgeAgainResult result = results.get(0);
			object.put("score", result.getScore());
			object.put("grade", result.getGrade());
			int months = result.getJudge_date();
			object.put("months", months);
			object.put("judge_date", months%12==0?(months/12 - 1) + "-12":months/12 + "-" + (months%12 < 10?"0" + months%12:months%12));
			
			if(result.getStatus().endsWith("1"))
				object.put("status", "保存中");
			else if(result.getStatus().endsWith("2"))
				object.put("status", "审核中");
			else if(result.getStatus().endsWith("3"))
				object.put("status", "审核通过");
			else
				object.put("status", "审核退回");
		}
		return object.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/getAgainOverviewByResultId",method={RequestMethod.POST,RequestMethod.GET})
	public String getAgainOverviewByResultId(String result_id,HttpServletRequest request){
		JSONObject object = new JSONObject();
		
		ZxJudgeAgainResult result = zxJudgeAgainResultService.getZxJudgeAgainResultById(result_id);
		object.put("score", result.getScore());
		object.put("grade", result.getGrade());
		object.put("supplier_id", result.getSupplier_id());
		int months = result.getJudge_date();
		object.put("months", months);
		object.put("judge_date", months%12==0?(months/12 - 1) + "-12":months/12 + "-" + (months%12 < 10?"0" + months%12:months%12));
		
		if(result.getStatus().endsWith("1"))
			object.put("status", "保存中");
		else if(result.getStatus().endsWith("2"))
			object.put("status", "审核中");
		else if(result.getStatus().endsWith("3"))
			object.put("status", "审核通过");
		else
			object.put("status", "审核退回");
		return object.toString();
	}
	
	/**
	* 再评审审核
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/checkAgainResult",method={RequestMethod.POST,RequestMethod.GET})
	public String saveAgainReport(String task_id, String remark, String status, String result_id,String user_ids,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
			if(activitiUtil.completeTask(task_id, new Variable())){
				String date = CommonUtils.getSimpleDateFormat();
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
				lc_approval.setLc_status_id(status);
				if(status.equals("3")){
					lc_approval.setLc_status_name("审批通过");
				}else{
					lc_approval.setLc_status_name("审批不通过");
				}
						
				lc_approval.setTaskId(task_id);
				lc_approval.setXt_userinfo_id(CommonUtils.getXtUid());
				lc_ApprovalService.addLcApproval(lc_approval);
				
				
				ZxJudgeAgainResult result =  zxJudgeAgainResultService.getZxJudgeAgainResultById(result_id);
				if(result.getStatus().equals("1")||result.getStatus().equals("3")||result.getStatus().equals("4"))
					return result.getStatus();
				result.setCheck_date(date);
				result.setStatus(status);
				result.setCheck_user_id(getXtUid());
				zxJudgeAgainResultService.updateZxJudgeAgainResult(result);
				
				String[] uIds = new String[0];
				if(StringUtils.isNotBlank(user_ids))uIds = user_ids.split(",");
				List<ZxJudgeUser> userList = new ArrayList<ZxJudgeUser>();
				
				condition = new HashMap<String, Object>();
				condition.put("result_id", result_id);
				condition.put("type", 2);
				condition.put("state", 1);
				List<ZxJudgeUser> users = zxJudgeUserService.getZxJudgeUserListByCondition(condition);
				if (status.equals("3")) {
					for(ZxJudgeUser user:users){
						user.setStatus(status);
						userList.add(user);
					}
				}else if (status.equals("4")) {
					for (String uId : uIds) {
						if(StringUtils.isNotBlank(uId)){
							for(ZxJudgeUser user:users){
								if(user.getUser_id().equals(uId)){
									user.setStatus("4");
									userList.add(user);
									break;
								}
							}
						}
					}
				}
				if(!userList.isEmpty())zxJudgeUserService.updateBatchZxJudgeUser(userList);
				
				if(status.equals("3")){
					ZxSupplier supplier = zxSupplierService.getZxSupplierById(result.getSupplier_id());
					supplier.setIs_judge("0");
					supplier.setJudge_date(result.getJudge_date());
					supplier.setJudge_grade(result.getGrade());
					zxSupplierService.updateZxSupplier(supplier);
				}
				
				if(StringUtils.isNotBlank(remark)){
					List<XtMessage> messages = new ArrayList<XtMessage>();
					if(status.equals("3")){
						for (ZxJudgeUser s : users) {
							XtMessage xtMessage = new XtMessage();
							xtMessage.setXt_message_id(UUID.toUUID());
							xtMessage.setFrom_id(CommonUtils.getXtUid());
							xtMessage.setTo_id(s.getUser_id());
							xtMessage.setXt_meesage_content(remark);
							xtMessage.setIsread("0");
							xtMessage.setCtime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
							messages.add(xtMessage);
						}
					}else if(status.equals("4")){
						for (String uId : uIds) {
							if(StringUtils.isNotBlank(uId)){
								XtMessage xtMessage = new XtMessage();
								xtMessage.setXt_message_id(UUID.toUUID());
								xtMessage.setFrom_id(CommonUtils.getXtUid());
								xtMessage.setTo_id(uId);
								xtMessage.setXt_meesage_content(remark);
								xtMessage.setIsread("0");
								xtMessage.setCtime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
								messages.add(xtMessage);
							}
						}
					}
					if(!messages.isEmpty()) xtMessageService.addBatchXtMessage(messages);
				}
				i = 5;
			}
		}
		
		return String.valueOf(i);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getZxJudgeAgainResultTaskById", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZxJudgeAgainResultTaskById(String id,HttpServletRequest request) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", id);
		condition.put("is_connect", 1);
		condition.put("state", 1);
		List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
		ZxJudgeAgainResult result = results.get(0);
		Map<String,String> map = new HashMap<String,String>();
		map.put("supplier_name", result.getSupplier_name());
		map.put("score", String.valueOf(result.getScore()));
		int months = result.getJudge_date();
		map.put("judge_date", months%12==0?(months/12 - 1) + "-12":months/12 + "-" + (months%12 < 10?"0" + months%12:months%12));
		String  grade = null;
	   	if(result.getScore() >= 90.0){
	   		grade = "I级考核标准";
		}else if(result.getScore() <= 69.0){
			grade = "不合格，直接淘汰";
		}else if(result.getScore() <= 89.0 &&result.getScore() >= 80){
			grade = "Ⅱ级考核标准";
		}else if(result.getScore() <= 79.0 &&result.getScore() >= 70){
			grade = "Ⅲ级考核标准";
		}
	   	map.put("grade", grade);
		return outDataStr(map);
	}
}
