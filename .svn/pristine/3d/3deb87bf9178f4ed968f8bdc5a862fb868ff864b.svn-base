package jehc.zxmodules.web;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import jehc.xtmodules.xtmodel.XtDepartinfo;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtDepartinfoService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxOutApply;
import jehc.zxmodules.model.ZxOutApplyWorkpiece;
import jehc.zxmodules.model.ZxOutProgress;
import jehc.zxmodules.model.ZxProject;
import jehc.zxmodules.service.ZxOutApplyService;
import jehc.zxmodules.service.ZxOutApplyWorkpieceService;
import jehc.zxmodules.service.ZxOutProgressService;
import jehc.zxmodules.service.ZxProjectService;
import net.sf.json.JSONArray;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 外协加工申请表 
* 2017-11-01 16:31:32  陈运芝
*/
@Controller
@RequestMapping("/zxOutApplyController")
public class ZxOutApplyController extends BaseAction{
	@Autowired
	private ZxOutApplyService zxOutApplyService;
	@Autowired
	private ZxOutApplyWorkpieceService zxOutApplyWorkpieceService;
	@Autowired
	private ZxOutProgressService zxOutProgressService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private ZxProjectService zxProjectService;
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
	* @param zx_out_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOutApply(ZxOutApply zxOutApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-out-apply/zx-out-apply-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_out_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOutApply> zxOutApplyList = zxOutApplyService.getZxOutApplyListByCondition(condition);
		for(ZxOutApply zxOutApply:zxOutApplyList){
			String items = "";
			XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxOutApply.getApply_user_id());
			XtUserinfo makeUser = xtUserinfoService.getXtUserinfoById(zxOutApply.getMake_user_id());
			ZxProject project = zxProjectService.getZxProjectById(zxOutApply.getProject_id());
			items += applyUser.getXt_userinfo_realName()+",";
			items += makeUser.getXt_userinfo_realName()+",";
			items += project.getNum();
			zxOutApply.setItem(items);
		}
		PageInfo<ZxOutApply> page = new PageInfo<ZxOutApply>(zxOutApplyList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOutApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOutApplyById(String id,HttpServletRequest request){
		ZxOutApply zxOutApply = zxOutApplyService.getZxOutApplyById(id);
		String outStr = outDataStr(zxOutApply);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxOutApply.getApply_user_id());
		XtUserinfo makeUser = xtUserinfoService.getXtUserinfoById(zxOutApply.getMake_user_id());
		ZxProject project = zxProjectService.getZxProjectById(zxOutApply.getProject_id());
		
		JSONArray jsonArray = JSONArray.fromObject(project); 
		String jsonStr = jsonArray.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		
		JSONArray jsonArrayA = JSONArray.fromObject(applyUser); 
		String jsonStrA = jsonArrayA.toString();
		jsonStrA = jsonStrA.substring(1,jsonStrA.length()-1);

		JSONArray jsonArrayB = JSONArray.fromObject(makeUser); 
		String jsonStrB = jsonArrayB.toString();
		jsonStrB = jsonStrB.substring(1,jsonStrB.length()-1);
		
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"project\":").concat(jsonStr).concat(",\"applyUser\":").concat(jsonStrA)
				.concat(",\"makeUser\":").concat(jsonStrB).concat(outStr.substring(outStr.length()-2,outStr.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_out_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOutApply(ZxOutApply zxOutApply,HttpServletRequest request){
		int i = 0;
		if(null != zxOutApply){
			zxOutApply.setId(UUID.toUUID());
			zxOutApply.setStatus("1");
			zxOutApply.setMake_user_id(getXtUid());
			zxOutApply.setApply_user_id(getXtUid());
			i=zxOutApplyService.addZxOutApply(zxOutApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_out_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOutApply(ZxOutApply zxOutApply,HttpServletRequest request){
		int i = 0;
		if(null != zxOutApply){
			i=zxOutApplyService.updateZxOutApply(zxOutApply);
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
	@RequestMapping(value="/delZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOutApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOutApplyService.delZxOutApply(condition);
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
	@RequestMapping(value="/copyZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOutApply(String id,HttpServletRequest request){
		int i = 0;
		ZxOutApply zxOutApply = zxOutApplyService.getZxOutApplyById(id);
		if(null != zxOutApply){
			zxOutApply.setId(UUID.toUUID());
			i=zxOutApplyService.addZxOutApply(zxOutApply);
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
	@RequestMapping(value="/exportZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOutApply(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	
	/**
	* 提出申请
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyZxOutApply",method={RequestMethod.POST,RequestMethod.GET})
	public String applyZxBuyApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			conditionr.put("xt_roleinfo_id", "316A8C82ED19412AB13DA0D634717CAC");
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			for(XtUserinfo user : xtUserinfoList){
				if(user.getXt_departinfo_id().equals(CommonUtils.getXtU().getXt_departinfo_id())){
					dep_user_id = user.getXt_userinfo_id();
					break;
				}else{
					XtDepartinfo depart = xtDepartinfoService.getXtDepartinfoById(CommonUtils.getXtU().getXt_departinfo_id());
					if(user.getXt_departinfo_id().equals(depart.getXt_departinfo_parentId())){
						dep_user_id = user.getXt_userinfo_id();
						break;
					}
				}
			}
			ZxOutApply zxOutApply = zxOutApplyService.getZxOutApplyById(id);
			//将业务与工作流流程绑定起来
			XtConstant Xt_Constant = getXtConstantCache("zxOutApply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","申请外协审批流程" );
		    variables.put("assignee",dep_user_id);
		    variables.put("owner",zxOutApply.getApply_user_id());
			lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条外协申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxOutApply.getId());
			if(activitiUtil.addApplySetAssignee(lc_his_id, zxOutApply.getId(), variables,lc_Apply)){
				//处理业务
				//将状态改为待部门负责人审核
				zxOutApply.setStatus("2");;
				i=zxOutApplyService.updateZxOutApply(zxOutApply);
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
		    ZxOutApply zxOutApply = zxOutApplyService.getZxOutApplyById(taskData.get("businessKey").toString());
		    String vals = task_status + "," + zxOutApply.getApply_user_id() + ",";
	    	variables.setKeys("status,owner");
		    variables.setTypes("S,S");
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
					zxOutApply.setStatus("3");
					addProgress(zxOutApply);
				}else{
					lc_approval.setLc_status_name("审批不通过");
					zxOutApply.setStatus("4");
				}
				zxOutApplyService.updateZxOutApply(zxOutApply);
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
	
	public void addProgress(ZxOutApply zxOutApply){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("apply_id", zxOutApply.getId());
		List<ZxOutApplyWorkpiece> workpieces = zxOutApplyWorkpieceService.getZxOutApplyWorkpieceListByCondition(condition);
		List<ZxOutProgress> progresss = new ArrayList<ZxOutProgress>();
		for(ZxOutApplyWorkpiece workpiece:workpieces){
			ZxOutProgress progress = new ZxOutProgress();
			progress.setApply_amount(Double.parseDouble(workpiece.getAmount()));
			progress.setApply_id(workpiece.getId());
			progress.setApply_time(zxOutApply.getApply_time());
			progress.setApply_user_id(zxOutApply.getApply_user_id());
			progress.setType(workpiece.getType());
			progress.setProperties(workpiece.getProperties());
			progress.setDraw_num(zxOutApply.getDraw_num());
			progress.setId(UUID.toUUID());
			progress.setWorkpiece_id(workpiece.getWorkpiece_id());
			progress.setNeed_time(zxOutApply.getNeed_time());
			progress.setProject_id(zxOutApply.getProject_id());
			progress.setWorkpiece_remark(workpiece.getRemark());
			progress.setSend_draw_time(zxOutApply.getSend_draw_time());
			progress.setStatus("1");
			progresss.add(progress);
		}
		zxOutProgressService.addBatchZxOutProgress(progresss);
	}
	
	/**
	 * 申请外协单树列表
	 * @param id
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value="/getZxOutApplyTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyTree(HttpServletRequest request) throws UnsupportedEncodingException{
		StringBuffer jsonStr = new StringBuffer("");  
		jsonStr.append("[");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("status", 3);
		condition.put("orderby", 1);
		List<ZxOutApply> zxOutApplyList = zxOutApplyService.getZxOutApplyListByCondition(condition);
		for(int i = 0; i < zxOutApplyList.size(); i++){
			ZxOutApply zxOutApply = zxOutApplyList.get(i);
			if(i==(zxOutApplyList.size()-1)){
				jsonStr.append("{id:'"+zxOutApply.getId()+"',leaf:true,text:'"+zxOutApply.getApply_num()+"',icon:'../deng/images/icons/list_bullets.png',parentId:'0',remark:'"+zxOutApply.getRemark()+"'}");  
			}else{
				jsonStr.append("{id:'"+zxOutApply.getId()+"',leaf:true,text:'"+zxOutApply.getApply_num()+"',icon:'../deng/images/icons/list_bullets.png',parentId:'0',remark:'"+zxOutApply.getRemark()+"'},");
			}
		}
		jsonStr.append("]");
		return outStr(jsonStr.toString());
	}
}
