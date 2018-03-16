package jehc.zxmodules.web;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.lcmodules.activitiutil.ActivitiUtil;
import jehc.lcmodules.lcmodel.LcApply;
import jehc.lcmodules.lcservice.LcDeploymentHisService;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.constant.SessionConstant;
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxJudgeAgainResult;
import jehc.zxmodules.model.ZxJudgeApply;
import jehc.zxmodules.model.ZxJudgeReport;
import jehc.zxmodules.model.ZxJudgeResult;
import jehc.zxmodules.model.ZxJudgeStandard;
import jehc.zxmodules.model.ZxJudgeUser;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxJudgeAgainResultService;
import jehc.zxmodules.service.ZxJudgeApplyService;
import jehc.zxmodules.service.ZxJudgeReportService;
import jehc.zxmodules.service.ZxJudgeResultService;
import jehc.zxmodules.service.ZxJudgeStandardService;
import jehc.zxmodules.service.ZxJudgeUserService;
import jehc.zxmodules.service.ZxSupplierService;

/**
* 供应商评定详情表 
* 2017-09-22 13:18:03  g
*/
@Controller
@RequestMapping("/zxJudgeReportController")
public class ZxJudgeReportController extends BaseAction{
	@Autowired
	private ZxJudgeReportService zxJudgeReportService;
	@Autowired
	private ZxJudgeStandardService zxJudgeStandardService;
	@Autowired
	private ZxJudgeResultService zxJudgeResultService;
	@Autowired
	private ZxJudgeAgainResultService zxJudgeAgainResultService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private ZxJudgeApplyService zxJudgeApplyService;
	@Autowired
	private ZxSupplierService zxSupplierService;
	@Autowired
	private ZxJudgeUserService zxJudgeUserService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	
	/**
	* 载入初始化页面
	* @param zx_judge_report 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxJudgeReport",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxJudgeReport(ZxJudgeReport zxJudgeReport,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-judge-report/zx-judge-report-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxJudgeReportListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeReportListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxJudgeReport> zxJudgeReportList = zxJudgeReportService.getZxJudgeReportListByCondition(condition);
		PageInfo<ZxJudgeReport> page = new PageInfo<ZxJudgeReport>(zxJudgeReportList);
		return outPageStr(page,request);
	}

	/**
	* 添加
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxJudgeReport",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxJudgeReport(ZxJudgeReport zxJudgeReport,HttpServletRequest request){
		int i = 0;
		if(null != zxJudgeReport){
			zxJudgeReport.setId(UUID.toUUID());
			i=zxJudgeReportService.addZxJudgeReport(zxJudgeReport);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}

	/**
	* 添加
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getTitle",method={RequestMethod.POST,RequestMethod.GET})
	public String getTitle(String type,String step, HttpServletRequest request){
		XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
		return getTitle( type, step,  xtUserinfo.getXt_departinfo_id());
	}
	
	@ResponseBody
	@RequestMapping(value="/getAgainTitle",method={RequestMethod.POST,RequestMethod.GET})
	public String getAgainTitle(String type,String step, HttpServletRequest request){
		XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
		return getTitle( type, step,  xtUserinfo.getXt_departinfo_id());
	}
	
	public String getTitle(String type,String step, String dep_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", type);
		condition.put("state", 1);
		if(step.equals("1"))
			condition.put("dep_id", dep_id);
		List<ZxJudgeStandard> standards = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
		Set<Map<String,String>> set = new  HashSet<Map<String,String>>();
		for(ZxJudgeStandard standard:standards){
			Map<String,String> map = new HashMap<String,String>();
			map.put("xt_data_dictionary_id",standard.getDic_id());
			map.put("xt_data_dictionary_name",standard.getDic_name());
			set.add(map);
		}
		return outItemsStr(set);
	}
	

	/**
	 * 获取验厂表格
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/getZxJudgeReportTableColumnList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeReportTableColumnListByCondition(String dic_id, String apply_id,HttpServletRequest request){
		List<ZxJudgeStandard> standards = new ArrayList<ZxJudgeStandard>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("apply_id", apply_id);
		List<ZxJudgeResult> results = zxJudgeResultService.getZxJudgeResultListByCondition(condition);
		if(results != null&&results.size() > 0){
			ZxJudgeResult result = results.get(0);
			
			condition = new HashMap<String,Object>();
			condition.put("dic_id", dic_id);
			String permission = (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL);
			if(!isAdmin()){
				if(result.getStatus().equals("1")||result.getStatus().equals("4")){
					condition.put("dep_id", CommonUtils.getXtU().getXt_departinfo_id());
				}
			}
			standards = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
			
			XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
			condition = new HashMap<String, Object>();
			condition.put("result_id", result.getId());
			condition.put("is_content", 1);
			if(!(isAdmin()||permission.contains(",zxJudgeResultController/checkResult,")))
				condition.put("judge_user", xtUserinfo.getXt_userinfo_id());
			List<ZxJudgeReport> reports = zxJudgeReportService.getZxJudgeReportListByCondition(condition);
			List<ZxJudgeReport> list = new ArrayList<ZxJudgeReport>();
			if(reports != null&&reports.size() > 0){
				for(ZxJudgeReport report:reports){
					for(ZxJudgeStandard standard:standards){
						if(standard.getId().equals(report.getStandard_id())){
							ZxJudgeUser zxJudgeUser = zxJudgeUserService.getZxJudgeUserById(report.getJudge_user_id());
							XtUserinfo wUser = xtUserinfoService.getXtUserinfoById(zxJudgeUser.getUser_id());
							report.setJudge_user_name(wUser.getXt_userinfo_realName());
							list.add(report);
						}
					}
				}
				if(!list.isEmpty())return outItemsStr(list);
			}
		}
		return outItemsStr(standards);
	}
	
	/**
	 * 获取再评审表格
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/getZxJudgeAgainReportTableColumnList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeAgainReportTableColumnList(String dic_id,String supplier_id,String months, HttpServletRequest request){
		List<ZxJudgeStandard> standards = new ArrayList<ZxJudgeStandard>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("supplier_id", supplier_id);
		condition.put("judge_date", months);
		condition.put("state", 1);
		List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
		if(results != null&&results.size() > 0){
			ZxJudgeAgainResult result = results.get(0);
			
			condition = new HashMap<String, Object>();
			condition.put("dic_id", dic_id);
			String permission = (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL);
			if(!isAdmin()){
				if(result.getStatus().equals("1")||result.getStatus().equals("4")){
					condition.put("dep_id", CommonUtils.getXtU().getXt_departinfo_id());
				}
			}
			standards = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
			
			XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
			condition = new HashMap<String, Object>();
			condition.put("result_id", result.getId());
			condition.put("is_content", 1);
			if(!(isAdmin()||permission.contains(",zxJudgeAgainResultController/checkAgainResult,")))
				condition.put("judge_user", xtUserinfo.getXt_userinfo_id());
			List<ZxJudgeReport> reports = zxJudgeReportService.getZxJudgeReportListByCondition(condition);
			List<ZxJudgeReport> list = new ArrayList<ZxJudgeReport>();
			if(reports != null&&reports.size() > 0){
				for(ZxJudgeReport report:reports){
					for(ZxJudgeStandard standard:standards){
						if(standard.getId().equals(report.getStandard_id())){
							ZxJudgeUser zxJudgeUser = zxJudgeUserService.getZxJudgeUserById(report.getJudge_user_id());
							XtUserinfo wUser = xtUserinfoService.getXtUserinfoById(zxJudgeUser.getUser_id());
							report.setJudge_user_name(wUser.getXt_userinfo_realName());
							list.add(report);
						}
					}
				}
				if(!list.isEmpty())return outItemsStr(list);
			}
		}
		return outItemsStr(standards);
	}
	
	/**
	 * 验厂步骤
	 * @param supplier_id
	 * @param num
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getYCStep",method={RequestMethod.POST,RequestMethod.GET})
	public String getYCStep(String supplier_id,Integer num,HttpServletRequest request){
		String i = "0";
		String sdfURL = (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL);
		if(sdfURL.contains(",zxJudgeReportController/saveReport,")){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("supplier_id", supplier_id);
			condition.put("num", num);
			condition.put("state", "1");
			List<ZxJudgeApply> applys = zxJudgeApplyService.getZxJudgeApplyListByCondition(condition);
			if(applys != null&&!applys.isEmpty()){
				ZxJudgeApply apply = applys.get(0);
				if(apply.getStatus().equals("3")){
					condition = new HashMap<String, Object>();
					condition.put("apply_id", apply.getId());
					condition.put("num", num);
					condition.put("state", 1);
					List<ZxJudgeResult> results = zxJudgeResultService.getZxJudgeResultListByCondition(condition);
					if(results != null&&!results.isEmpty()){
						i = results.get(0).getStatus();
						if(i.equals("2")&&sdfURL.contains(",zxJudgeResultController/checkResult,")){
							i = "7";
						}
					}else{
						i = "1";
						ZxJudgeResult result = new ZxJudgeResult();
						result.setId(UUID.toUUID());
						result.setApply_id(apply.getId());
						result.setStatus("1");
						result.setState("1");
						result.setCreate_date(CommonUtils.getSimpleDateFormat());
						zxJudgeResultService.addZxJudgeResult(result);
					}
				}else{
					i = "5";
				}
			}else{
				i = "6";
			}
		}else if(sdfURL.contains(",zxJudgeResultController/checkResult,")){
			i = "7";
		}else{
			if(CommonUtils.isAdmin()){
				i = "7";
			}
		}
		return i;
	}
	
	/**
	 * 再评审步骤
	 * @param supplier_id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getAgainStep",method={RequestMethod.POST,RequestMethod.GET})
	public String getAgainStep(String supplier_id,HttpServletRequest request){
		int i = 0;
		String sdfURL = (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL);
		if(sdfURL.contains(",zxJudgeReportController/saveAgainReport,")){
			ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(supplier_id);
			if(zxSupplier.getYc_num()  < 1){
				i = 5;
			}else{
				if(zxSupplier .getIs_judge().equals("0")){
					i = 6;
				}else{
					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("supplier_id",supplier_id);
					condition.put("state",1);
					condition.put("order_by_judge_date",1);
					List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
					ZxJudgeAgainResult recentResult = null;
					i = 7;
					if(results != null&&!results.isEmpty()){
						recentResult = results.get(0);
						Calendar cal = Calendar.getInstance();
						int months = cal.get(Calendar.YEAR) * 12 + cal.get(Calendar.MONTH) + 1;
						int cycle = 1;
						if(zxSupplier.getJudge_cycle().equals("1")){
							cycle = 12;
						}else if(zxSupplier.getJudge_cycle().equals("2")){
							cycle = 4;
						}
						if(recentResult.getJudge_date() + cycle > months){
							i = Integer.valueOf(recentResult.getStatus());
							if(i == 2&&sdfURL.contains(",zxJudgeAgainResultController/checkAgainResult,")){
								i = 7;
							}
						}else if(recentResult.getStatus().equals("1")||recentResult.getStatus().equals("4")){
							i = 6;
						}
					}
				}
			}
		}else if(sdfURL.contains(",zxJudgeAgainResultController/checkAgainResult,")||CommonUtils.isAdmin()){
			i = 7;
		}
		
		return String.valueOf(i);
	}
	
	/**
	* 添加
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/saveReport",method={RequestMethod.POST,RequestMethod.GET})
	public String saveReport(String[] scores,String supplier_id,String apply_id,String status,HttpServletRequest request){
		XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id", supplier_id);
		condition.put("apply_id", apply_id);
		condition.put("status", status);
		condition.put("scores", scores);
		condition.put("user_id", xtUserinfo.getXt_userinfo_id());
		condition.put("dep_id", xtUserinfo.getXt_departinfo_id());
		condition.put("type", 1);
		int i = zxJudgeReportService.addOrUpdateZxJudgeReport(condition);
		ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(supplier_id);
		if(i == 2){
			Map<String, Object> condition1 = new HashMap<String, Object>();
			condition1.put("apply_id", apply_id);
			List<ZxJudgeResult> results = zxJudgeResultService.getZxJudgeResultListByCondition(condition1);
			if(addApplyLC(results.get(0).getId(), getSimpleDateFormat())){
				zxSupplier.setYc_status("5");
				zxSupplierService.updateZxSupplier(zxSupplier);
			}
			i = 1;
		}
		return String.valueOf(i);
	}
	
	/**
	* 添加
	* @param zx_judge_report 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/saveAgainReport",method={RequestMethod.POST,RequestMethod.GET})
	public String saveAgainReport(String[] scores,String supplier_id,String status,Integer months,HttpServletRequest request){
		XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id", supplier_id);
		condition.put("status", status);
		condition.put("months", months);
		condition.put("scores", scores);
		condition.put("user_id", xtUserinfo.getXt_userinfo_id());
		condition.put("dep_id", xtUserinfo.getXt_departinfo_id());
		condition.put("type", 2);
		int i = zxJudgeReportService.addOrUpdateZxJudgeReport(condition);
		if(i == 2){
			Map<String, Object> condition1 = new HashMap<String, Object>();
			condition1.put("supplier_id", supplier_id);
			condition1.put("judge_date", months);
			condition1.put("state", 1);
			List<ZxJudgeAgainResult> results = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition1);
			addApplyLCAgain(results.get(0).getId(), getSimpleDateFormat());
			i = 1;
		}
		return String.valueOf(i);
	}
	
	private boolean addApplyLC(String id,String date){
		//将业务与工作流流程绑定起来
		XtConstant Xt_Constant = getXtConstantCache("zx_judge_result");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
		String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
		LcApply lc_Apply = new LcApply();
		lc_Apply.setLc_apply_title(CommonUtils.getXtU().getXt_userinfo_name() + "于"+ date +"，提交了一条验厂报告审批流程");
		lc_Apply.setLc_apply_model_biz_id(id);
		Map<String, Object> variables = new HashMap<String, Object>();
	    variables.put("taskType","验厂报告审批" );
		return activitiUtil.addApplySetAssignee(lc_his_id, id, variables,lc_Apply);
	}
	
	private void addApplyLCAgain(String id,String date){
		//将业务与工作流流程绑定起来
		XtConstant Xt_Constant = getXtConstantCache("zx_judge_again_result");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
		String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
		LcApply lc_Apply = new LcApply();
		lc_Apply.setLc_apply_title(CommonUtils.getXtU().getXt_userinfo_name() + "于"+ date +"，提交了一条再评审报告审批流程");
		lc_Apply.setLc_apply_model_biz_id(id);
		Map<String, Object> variables = new HashMap<String, Object>();
	    variables.put("taskType","再评审报告审批" );
		activitiUtil.addApplySetAssignee(lc_his_id, id, variables,lc_Apply);
	}
}
