package jehc.zxmodules.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import jehc.xtmodules.xtservice.XtDepartinfoService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxCar;
import jehc.zxmodules.model.ZxCarApply;
import jehc.zxmodules.service.ZxCarApplyService;
import jehc.zxmodules.service.ZxCarService;
import net.sf.json.JSONArray;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 车辆审批表 
* 2017-09-21 13:46:34  陈运芝
*/
@Controller
@RequestMapping("/zxCarApplyController")
public class ZxCarApplyController extends BaseAction{
	@Autowired
	private ZxCarService zxCarService;
	@Autowired
	private ZxCarApplyService zxCarApplyService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private XtDepartinfoService xtDepartinfoService;
	/**
	* 载入初始化页面
	* @param zx_car_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxCarApply(ZxCarApply zxCarApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-list");
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxCarApplyAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxCarApplyAdd(ZxCarApply zxCarApply,HttpServletRequest request, Model model){
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		model.addAttribute("applyTime", simpleDateFormat.format(new Date()));
		
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxCarApplyUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxCarApplyUpdate(String id,HttpServletRequest request, Model model){
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		model.addAttribute("zxCarApply", zxCarApply);
		ZxCar applyCar = zxCarService.getZxCarById(zxCarApply.getCar_id());
		model.addAttribute("applyCar", applyCar);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxCarApply.getApply_user_id());
		model.addAttribute("applyUser", applyUser);
		XtUserinfo applyDriver = xtUserinfoService.getXtUserinfoById(zxCarApply.getDriver_id());
		model.addAttribute("applyDriver", applyDriver);
		XtUserinfo applyOutGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getOut_guard_id());
		model.addAttribute("applyOutGuard", applyOutGuard);
		XtUserinfo applyBackGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getBack_guard_id());
		model.addAttribute("applyBackGuard", applyBackGuard);
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxCarApplyDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxCarApplyDetail(String id,String fromUrl,HttpServletRequest request, Model model){
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		model.addAttribute("zxCarApply", zxCarApply);
		ZxCar applyCar = zxCarService.getZxCarById(zxCarApply.getCar_id());
		model.addAttribute("applyCar", applyCar);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxCarApply.getApply_user_id());
		model.addAttribute("applyUser", applyUser);
		XtUserinfo applyDriver = xtUserinfoService.getXtUserinfoById(zxCarApply.getDriver_id());
		model.addAttribute("applyDriver", applyDriver);
		XtUserinfo applyOutGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getOut_guard_id());
		model.addAttribute("applyOutGuard", applyOutGuard);
		XtUserinfo applyBackGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getBack_guard_id());
		model.addAttribute("applyBackGuard", applyBackGuard);
		model.addAttribute("fromUrl", fromUrl);
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-detail");
	}

	/**
	* 发送至进出登记页面
	* @param request 
	*/
	@RequestMapping(value="/toCheck",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toCheck(ZxCarApply zxCarApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-check");
	}

	/**
	* 出门登记页面
	* @param request 
	*/
	@RequestMapping(value="/toCheckOut",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toCheckOut(String id,HttpServletRequest request, Model model){
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		model.addAttribute("zxCarApply", zxCarApply);
		ZxCar applyCar = zxCarService.getZxCarById(zxCarApply.getCar_id());
		model.addAttribute("applyCar", applyCar);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxCarApply.getApply_user_id());
		model.addAttribute("applyUser", applyUser);
		XtUserinfo applyDriver = xtUserinfoService.getXtUserinfoById(zxCarApply.getDriver_id());
		model.addAttribute("applyDriver", applyDriver);
		XtUserinfo applyOutGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getOut_guard_id());
		model.addAttribute("applyOutGuard", applyOutGuard);
		XtUserinfo applyBackGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getBack_guard_id());
		model.addAttribute("applyBackGuard", applyBackGuard);
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-check-out");
	}

	/**
	* 回司登记页面
	* @param request 
	*/
	@RequestMapping(value="/toCheckBack",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toCheckBack(String id,HttpServletRequest request, Model model){
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		model.addAttribute("zxCarApply", zxCarApply);
		ZxCar applyCar = zxCarService.getZxCarById(zxCarApply.getCar_id());
		model.addAttribute("applyCar", applyCar);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxCarApply.getApply_user_id());
		model.addAttribute("applyUser", applyUser);
		XtUserinfo applyDriver = xtUserinfoService.getXtUserinfoById(zxCarApply.getDriver_id());
		model.addAttribute("applyDriver", applyDriver);
		XtUserinfo applyOutGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getOut_guard_id());
		model.addAttribute("applyOutGuard", applyOutGuard);
		XtUserinfo applyBackGuard = xtUserinfoService.getXtUserinfoById(zxCarApply.getBack_guard_id());
		model.addAttribute("applyBackGuard", applyBackGuard);
		return new ModelAndView("pc/zx-view/zx-car-apply/zx-car-apply-check-back");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_car_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxCarApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxCarApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("xt_userinfo_id", new String[]{getXtUid()});
		List<ZxCarApply> zxCarApplyList = zxCarApplyService.getZxCarApplyListByCondition(condition);
		for(ZxCarApply zxCarApply:zxCarApplyList){
			zxCarApply.setItem(zxCarService.getZxCarById(zxCarApply.getCar_id()));
		}
		PageInfo<ZxCarApply> page = new PageInfo<ZxCarApply>(zxCarApplyList);
		return outPageBootStr(page,request);
	}

	/**
	* 加载进出登记列表数据并分页
	* @param zx_car_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxCarApplyCheckListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxCarApplyCheckListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("states", new Integer[]{3,5,6});
		List<ZxCarApply> zxCarApplyList = zxCarApplyService.getZxCarApplyListByCondition(condition);
		for(ZxCarApply zxCarApply:zxCarApplyList){
			zxCarApply.setItem(zxCarService.getZxCarById(zxCarApply.getCar_id()));
		}
		PageInfo<ZxCarApply> page = new PageInfo<ZxCarApply>(zxCarApplyList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxCarApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxCarApplyById(String id,HttpServletRequest request){
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		String outData = outDataStr(zxCarApply);
		String outStr = outData.substring(0,outData.length()-2);
		ZxCar applyCar = zxCarService.getZxCarById(zxCarApply.getCar_id());
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxCarApply.getApply_user_id());
		XtUserinfo applyDriver = xtUserinfoService.getXtUserinfoById(zxCarApply.getDriver_id());
		if(null != applyCar){
			String jsonStr = JSONArray.fromObject(applyCar).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"applyCar\":").concat(jsonStr);
		}
		if(null != applyUser){
			String jsonStr = JSONArray.fromObject(applyUser).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"applyUser\":").concat(jsonStr);
		}
		if(null != applyDriver){
			String jsonStr = JSONArray.fromObject(applyDriver).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"applyDriver\":").concat(jsonStr);
		}
		outStr = outStr.concat(outData.substring(outData.length()-2,outData.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_car_apply 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxCarApply(ZxCarApply zxCarApply,HttpServletRequest request) throws ParseException{
		int i = 0;
		if(null != zxCarApply){
			Date now = new Date();
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        //获取今天的日期
	        String nowDay = DateFormatUtils.format(now, "yyyyMMdd");
	        //对比的时间
	        String day = DateFormatUtils.format(sf.parse(zxCarApply.getApply_time_begin()),"yyyyMMdd");
	        boolean istoday = day.equals(nowDay);
			if(istoday){
				zxCarApply.setApply_type("1");
			}else{
				zxCarApply.setApply_type("2");
			}
			zxCarApply.setId(UUID.toUUID());
			zxCarApply.setApply_user_id(getXtUid());
			zxCarApply.setState("1");
			zxCarApply.setApply_time(DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss"));
			i=zxCarApplyService.addZxCarApply(zxCarApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_car_apply 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxCarApply(ZxCarApply zxCarApply,HttpServletRequest request) throws ParseException{
		int i = 0;
		if(null != zxCarApply){
			Date now = new Date();
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        //获取今天的日期
	        String nowDay = DateFormatUtils.format(now, "yyyyMMdd");
	        //对比的时间
	        String day = DateFormatUtils.format(sf.parse(zxCarApply.getApply_time_begin()),"yyyyMMdd");
	        boolean istoday = day.equals(nowDay);
			if(istoday){
				zxCarApply.setApply_type("1");
			}else{
				zxCarApply.setApply_type("2");
			}
			i=zxCarApplyService.updateZxCarApplyBySelective(zxCarApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 出门登记
	* @param zx_car_apply 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxCarApplyOut",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxCarApplyOut(ZxCarApply zxCarApply,HttpServletRequest request) throws ParseException{
		int i = 0;
		if(null != zxCarApply){
			zxCarApply.setState("5");
			zxCarApply.setOut_guard_id(getXtUid());
			i=zxCarApplyService.updateZxCarApplyBySelective(zxCarApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 回司登记
	* @param zx_car_apply 
	* @param request 
	 * @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxCarApplyBack",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxCarApplyBack(ZxCarApply zxCarApply,HttpServletRequest request) throws ParseException{
		int i = 0;
		if(null != zxCarApply){
			zxCarApply.setState("6");
			zxCarApply.setBack_guard_id(getXtUid());
			i=zxCarApplyService.updateZxCarApplyBySelective(zxCarApply);
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
	@RequestMapping(value="/delZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxCarApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxCarApplyService.delZxCarApply(condition);
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
	@RequestMapping(value="/copyZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxCarApply(String id,HttpServletRequest request){
		int i = 0;
		ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
		if(null != zxCarApply){
			zxCarApply.setId(UUID.toUUID());
			i=zxCarApplyService.addZxCarApply(zxCarApply);
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
	@RequestMapping(value="/exportZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxCarApply(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 提出申请
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyZxCarApply",method={RequestMethod.POST,RequestMethod.GET})
	public String applyZxCarApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			ZxCarApply zxCarApply = zxCarApplyService.getZxCarApplyById(id);
			//将业务与工作流流程绑定起来
			XtConstant Xt_Constant = getXtConstantCache("zxCarApply_DS");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","车辆审批流程" );
		    variables.put("owner",zxCarApply.getApply_user_id());
			lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条车辆使用申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxCarApply.getId());
			if(activitiUtil.addApply(lc_his_id, zxCarApply.getId(), variables,lc_Apply)){
				//处理业务
				//将状态改为待部门负责人审核
				zxCarApply.setState("2");
				i=zxCarApplyService.updateZxCarApply(zxCarApply);
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
	@RequestMapping(value="/approval",method={RequestMethod.POST,RequestMethod.GET})
	public String approval(String task_id,String task_status,String remark,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxCarApply apply = zxCarApplyService.getZxCarApplyById(taskData.get("businessKey").toString());
		    String vals = task_status + ",";
	    	variables.setKeys("status,applyType");
		    variables.setTypes("S,S");
	    	if(apply.getApply_type().equals("2")){
	    		vals += "two";
	    	}else{
	    		vals += "now";
	    	}
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
				}else{
					lc_approval.setLc_status_name("审批不通过");
					apply.setState("4");
					zxCarApplyService.updateZxCarApply(apply);
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
	* 安环部审批
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/approvalSafe",method={RequestMethod.POST,RequestMethod.GET})
	public String approvalSafe(String task_id,String task_status,String remark,String car_id,String driver_id,String driver_age,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZxCarApply apply = zxCarApplyService.getZxCarApplyById(taskData.get("businessKey").toString());
		    variables.setKeys("owner");
		    variables.setTypes("S");
		    variables.setValues(apply.getApply_user_id());
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
					apply.setState("3");
					apply.setCar_id(car_id);
					apply.setDriver_id(driver_id);
					apply.setDriver_age(driver_age);
				}else{
					lc_approval.setLc_status_name("审批不通过");
					apply.setState("4");
				}
				lc_approval.setTaskId(task_id);
				lc_approval.setXt_userinfo_id(CommonUtils.getXtUid());
				lc_ApprovalService.addLcApproval(lc_approval);
				i=zxCarApplyService.updateZxCarApply(apply);
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
	* 门卫：出车
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/carOut",method={RequestMethod.POST,RequestMethod.GET})
	public String carOut(ZxCarApply zxCarApply,HttpServletRequest request){
		int i = 0;
		if(null != zxCarApply){
			ZxCarApply apply = zxCarApplyService.getZxCarApplyById(zxCarApply.getId());
			if(apply.getState().equals("3")){
				zxCarApply.setState("5");
				i=zxCarApplyService.updateZxCarApplyBySelective(zxCarApply);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}

	/**
	* 门卫：出车
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/carBack",method={RequestMethod.POST,RequestMethod.GET})
	public String carBack(ZxCarApply zxCarApply,HttpServletRequest request){
		int i = 0;
		if(null != zxCarApply && "5".equals(zxCarApply.getState())){
			zxCarApply.setState("6");
			i=zxCarApplyService.updateZxCarApplyBySelective(zxCarApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}

