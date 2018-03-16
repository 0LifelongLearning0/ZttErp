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
import jehc.zxmodules.model.ZxBuyApply;
import jehc.zxmodules.model.ZxBuyApplyMaterial;
import jehc.zxmodules.model.ZxBuyProgress;
import jehc.zxmodules.model.ZxProject;
import jehc.zxmodules.service.ZxBuyApplyMaterialService;
import jehc.zxmodules.service.ZxBuyApplyService;
import jehc.zxmodules.service.ZxBuyProgressService;
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
* 采购申请单 
* 2017-10-26 10:41:49  陈运芝
*/
@Controller
@RequestMapping("/zxBuyApplyController")
public class ZxBuyApplyController extends BaseAction{
	@Autowired
	private ZxBuyApplyService zxBuyApplyService;
	@Autowired
	private ZxBuyApplyMaterialService zxBuyApplyMaterialService;
	@Autowired
	private ZxBuyProgressService zxBuyProgressService;
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
	* @param zx_buy_apply 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyApply(ZxBuyApply zxBuyApply,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-buy-apply/zx-buy-apply-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_buy_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyApplyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxBuyApply> zxBuyApplyList = zxBuyApplyService.getZxBuyApplyListByCondition(condition);
		for(ZxBuyApply zxBuyApply:zxBuyApplyList){
			String items = "";
			XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxBuyApply.getApply_user_id());
			XtUserinfo makeUser = xtUserinfoService.getXtUserinfoById(zxBuyApply.getMake_user_id());
			ZxProject project = zxProjectService.getZxProjectById(zxBuyApply.getProject_id());
			items += applyUser.getXt_userinfo_realName()+",";
			items += makeUser.getXt_userinfo_realName()+",";
			items += project.getNum();
			zxBuyApply.setItem(items);
		}
		PageInfo<ZxBuyApply> page = new PageInfo<ZxBuyApply>(zxBuyApplyList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyApplyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyById(String id,HttpServletRequest request){
		ZxBuyApply zxBuyApply = zxBuyApplyService.getZxBuyApplyById(id);
		String outStr = outDataStr(zxBuyApply);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zxBuyApply.getApply_user_id());
		XtUserinfo makeUser = xtUserinfoService.getXtUserinfoById(zxBuyApply.getMake_user_id());
		ZxProject project = zxProjectService.getZxProjectById(zxBuyApply.getProject_id());
		
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
	* @param zx_buy_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxBuyApply(ZxBuyApply zxBuyApply,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyApply){
			zxBuyApply.setId(UUID.toUUID());
			zxBuyApply.setStatus("1");
			zxBuyApply.setMake_user_id(getXtUid());
			zxBuyApply.setApply_user_id(getXtUid());
			i=zxBuyApplyService.addZxBuyApply(zxBuyApply);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_buy_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxBuyApply(ZxBuyApply zxBuyApply,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyApply){
			i=zxBuyApplyService.updateZxBuyApply(zxBuyApply);
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
	@RequestMapping(value="/delZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxBuyApply(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxBuyApplyService.delZxBuyApply(condition);
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
	@RequestMapping(value="/copyZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxBuyApply(String id,HttpServletRequest request){
		int i = 0;
		ZxBuyApply zxBuyApply = zxBuyApplyService.getZxBuyApplyById(id);
		if(null != zxBuyApply){
			zxBuyApply.setId(UUID.toUUID());
			i=zxBuyApplyService.addZxBuyApply(zxBuyApply);
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
	@RequestMapping(value="/exportZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxBuyApply(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 提出申请
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/applyZxBuyApply",method={RequestMethod.POST,RequestMethod.GET})
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
			ZxBuyApply zxBuyApply = zxBuyApplyService.getZxBuyApplyById(id);
			//将业务与工作流流程绑定起来
			XtConstant Xt_Constant = getXtConstantCache("zxBuyApply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","申请采购审批流程" );
		    variables.put("assignee",dep_user_id);
		    variables.put("owner",zxBuyApply.getApply_user_id());
			lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条采购申请流程");
			lc_Apply.setLc_apply_model_biz_id(zxBuyApply.getId());
			if(activitiUtil.addApplySetAssignee(lc_his_id, zxBuyApply.getId(), variables,lc_Apply)){
				//处理业务
				//将状态改为待部门负责人审核
				zxBuyApply.setStatus("2");;
				i=zxBuyApplyService.updateZxBuyApply(zxBuyApply);
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
		    ZxBuyApply zxBuyApply = zxBuyApplyService.getZxBuyApplyById(taskData.get("businessKey").toString());
		    String vals = task_status + "," + zxBuyApply.getApply_user_id() + ",";
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
					zxBuyApply.setStatus("3");
					addProgress(zxBuyApply);
				}else{
					lc_approval.setLc_status_name("审批不通过");
					zxBuyApply.setStatus("4");
				}
				zxBuyApplyService.updateZxBuyApply(zxBuyApply);
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
	
	public void addProgress(ZxBuyApply zxBuyApply){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("apply_id", zxBuyApply.getId());
		List<ZxBuyApplyMaterial> materials = zxBuyApplyMaterialService.getZxBuyApplyMaterialListByCondition(condition);
		List<ZxBuyProgress> progresss = new ArrayList<ZxBuyProgress>();
		for(ZxBuyApplyMaterial material:materials){
			ZxBuyProgress progress = new ZxBuyProgress();
			progress.setApply_amount(Double.parseDouble(material.getAmount()));
			progress.setApply_id(material.getId());
			progress.setApply_time(zxBuyApply.getApply_time());
			progress.setApply_user_id(zxBuyApply.getApply_user_id());
			progress.setBrand(material.getBrand());
			progress.setCaizhi(material.getCaizhi());
			progress.setDraw_num(zxBuyApply.getDraw_num());
			progress.setId(UUID.toUUID());
			progress.setMaterial_id(material.getMaterial_id());
			progress.setNeed_time(zxBuyApply.getNeed_time());
			progress.setProject_id(zxBuyApply.getProject_id());
			progress.setMaterial_remark(material.getRemark());
			progress.setSend_draw_time(zxBuyApply.getSend_draw_time());
			progress.setStatus("1");
			progresss.add(progress);
		}
		zxBuyProgressService.addBatchZxBuyProgress(progresss);
	}
	
	/**
	 * 申请采购单树列表
	 * @param id
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value="/getZxBuyApplyTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyTree(HttpServletRequest request) throws UnsupportedEncodingException{
		StringBuffer jsonStr = new StringBuffer("");  
		jsonStr.append("[");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("status", 3);
		condition.put("orderby", 1);
		List<ZxBuyApply> zxBuyApplyList = zxBuyApplyService.getZxBuyApplyListByCondition(condition);
		for(int i = 0; i < zxBuyApplyList.size(); i++){
			ZxBuyApply zxBuyApply = zxBuyApplyList.get(i);
			if(i==(zxBuyApplyList.size()-1)){
				jsonStr.append("{id:'"+zxBuyApply.getId()+"',leaf:true,text:'"+zxBuyApply.getApply_num()+"',icon:'../deng/images/icons/list_bullets.png',parentId:'0',remark:'"+zxBuyApply.getRemark()+"'}");  
			}else{
				jsonStr.append("{id:'"+zxBuyApply.getId()+"',leaf:true,text:'"+zxBuyApply.getApply_num()+"',icon:'../deng/images/icons/list_bullets.png',parentId:'0',remark:'"+zxBuyApply.getRemark()+"'},");
			}
		}
		jsonStr.append("]");
		return outStr(jsonStr.toString());
	}
}
