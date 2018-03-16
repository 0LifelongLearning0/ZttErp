package jehc.zxmodules.web;

import java.io.IOException;
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
import jehc.xtmodules.xtcore.allutils.file.FileUtil;
import jehc.xtmodules.xtcore.annotation.AuthUneedLogin;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseJson;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.constant.SessionConstant;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtAttachment;
import jehc.xtmodules.xtmodel.XtMessage;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtAttachmentService;
import jehc.xtmodules.xtservice.XtMessageService;
import jehc.zxmodules.model.ZxJudgeApply;
import jehc.zxmodules.model.ZxJudgeAttach;
import jehc.zxmodules.model.ZxJudgeResult;
import jehc.zxmodules.model.ZxJudgeUser;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxJudgeApplyService;
import jehc.zxmodules.service.ZxJudgeAttachService;
import jehc.zxmodules.service.ZxJudgeResultService;
import jehc.zxmodules.service.ZxJudgeUserService;
import jehc.zxmodules.service.ZxSupplierService;

/**
 * 供应商验厂结果 2017-09-22 11:04:19 guqian
 */
@Controller
@RequestMapping("/zxJudgeResultController")
public class ZxJudgeResultController extends BaseAction {
	@Autowired
	private ZxJudgeResultService zxJudgeResultService;
	@Autowired
	private ZxJudgeApplyService zxJudgeApplyService;
	@Autowired
	private XtMessageService xtMessageService;
	@Autowired
	private ZxJudgeUserService zxJudgeUserService;
	@Autowired
	private ZxJudgeAttachService zxJudgeAttachService;
	@Autowired
	private XtAttachmentService xtAttachmentService;
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
	 * 
	 * @param zx_judge_result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loadZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loadZxJudgeResult(ZxJudgeResult zxJudgeResult, HttpServletRequest request) {
		return new ModelAndView("pc/zx-view/zx-judge-result/zx-judge-result-list");
	}

	/**
	 * 加载初始化列表数据并分页
	 * 
	 * @param zx_judge_result
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/getZxJudgeResultListByCondition", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZxJudgeResultListByCondition(BaseSearch baseSearch, HttpServletRequest request) {
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition, request);
		condition.put("is_connect", 1);
		List<ZxJudgeResult> zxJudgeResultList = zxJudgeResultService.getZxJudgeResultListByCondition(condition);
		PageInfo<ZxJudgeResult> page = new PageInfo<ZxJudgeResult>(zxJudgeResultList);
		return outPageStr(page, request);
	}

	/**
	 * 获取对象
	 * 
	 * @param id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/getZxJudgeResultById", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZxJudgeResultById(String id, HttpServletRequest request) {
		ZxJudgeResult zxJudgeResult = zxJudgeResultService.getZxJudgeResultById(id);
		return outDataStr(zxJudgeResult);
	}

	/**
	 * 添加
	 * 
	 * @param zx_judge_result
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/addZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String addZxJudgeResult(ZxJudgeResult zxJudgeResult, HttpServletRequest request) {
		int i = 0;
		if (null != zxJudgeResult) {
			zxJudgeResult.setId(UUID.toUUID());
			i = zxJudgeResultService.addZxJudgeResult(zxJudgeResult);
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
	 * @param zx_judge_result
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/updateZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateZxJudgeResult(ZxJudgeResult zxJudgeResult, HttpServletRequest request) {
		int i = 0;
		if (null != zxJudgeResult) {
			i = zxJudgeResultService.updateZxJudgeResult(zxJudgeResult);
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
	@RequestMapping(value = "/delZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String delZxJudgeResult(String id, HttpServletRequest request) {
		int i = 0;
		if (null != id && !"".equals(id)) {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id.split(","));
			i = zxJudgeResultService.delZxJudgeResult(condition);
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
	@RequestMapping(value = "/copyZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String copyZxJudgeResult(String id, HttpServletRequest request) {
		int i = 0;
		ZxJudgeResult zxJudgeResult = zxJudgeResultService.getZxJudgeResultById(id);
		if (null != zxJudgeResult) {
			zxJudgeResult.setId(UUID.toUUID());
			i = zxJudgeResultService.addZxJudgeResult(zxJudgeResult);
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
	@RequestMapping(value = "/exportZxJudgeResult", method = { RequestMethod.POST, RequestMethod.GET })
	public void exportZxJudgeResult(String excleData, String excleHeader, String excleText, HttpServletRequest request,
			HttpServletResponse response) {
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader, excleText, response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String getResult(String supplier_id, HttpServletRequest request) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id", supplier_id);
		List<ZxJudgeResult> list = zxJudgeResultService.getZxJudgeResultListByCondition(condition);

		if (list != null && list.size() > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 审批验厂
	 * 
	 * @param zx_judge_supplier_result
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/checkResult", method = { RequestMethod.POST, RequestMethod.GET })
	public String checkResult(String task_id, String status, String result_id,Double final_score,String final_grade,String remark, Integer commAble,String user_ids,HttpServletRequest request) {
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
				lc_approval.setXt_userinfo_id(getXtUid());
				lc_ApprovalService.addLcApproval(lc_approval);
				
				ZxJudgeResult zxJudgeResult = zxJudgeResultService.getZxJudgeResultById(result_id);
				if(zxJudgeResult.getStatus().equals("1")||zxJudgeResult.getStatus().equals("3")||zxJudgeResult.getStatus().equals("4"))
					return zxJudgeResult.getStatus();
				zxJudgeResult.setCheck_date(date);
				zxJudgeResult.setStatus(status);
				zxJudgeResult.setCheck_user_id(getXtUid());
				if(status.equals("3")) {
					if(commAble == 1){
						zxJudgeResult.setFinal_score(final_score);
						zxJudgeResult.setFinal_grade(final_grade);
					}else{
						zxJudgeResult.setFinal_score(zxJudgeResult.getScore());
						zxJudgeResult.setFinal_grade(zxJudgeResult.getGrade());
					}
					zxJudgeResult.setRemark(remark);
				}
				zxJudgeResultService.updateZxJudgeResult(zxJudgeResult);
				
				String[] uIds = new String[0];
				if(StringUtils.isNotBlank(user_ids))uIds = user_ids.split(",");
				List<ZxJudgeUser> userList = new ArrayList<ZxJudgeUser>();
				condition = new HashMap<String, Object>();
				condition.put("result_id", result_id);
				condition.put("type", 1);
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
			
				ZxJudgeApply apply = zxJudgeApplyService.getZxJudgeApplyById(zxJudgeResult.getApply_id());
				ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(apply.getSupplier_id());
				if (status.equals("4")) {
					zxSupplier.setYc_status("6");
				}else if(status.equals("3")){
					zxSupplier.setYc_num(zxSupplier.getYc_num() + 1);
					zxSupplier.setYc_status("7");
					zxSupplier.setYc_grade(zxJudgeResult.getFinal_grade());
				}
				zxSupplierService.updateZxSupplier(zxSupplier);
				
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
			}else{
				i = 0;
			};
		}
		
		return String.valueOf(i);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOverview", method = { RequestMethod.POST, RequestMethod.GET })
	public String getAgainOverview(String supplier_id, HttpServletRequest request) {
		JSONObject object = new JSONObject();

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("supplier_id", supplier_id);
		condition.put("state", 1);
		List<ZxJudgeApply> applys = zxJudgeApplyService.getZxJudgeApplyListByCondition(condition);
		if (applys != null && !applys.isEmpty()) {
			ZxJudgeApply apply = applys.get(0);
			object.put("judge_date_start", apply.getJudge_date_start());
			object.put("judge_date_end", apply.getJudge_date_end());
			object.put("apply_id", apply.getId());

			Map<String, Object> condition2 = new HashMap<String, Object>();
			condition2.put("apply_id", apply.getId());
			condition2.put("state", 1);
			List<ZxJudgeResult> results = zxJudgeResultService.getZxJudgeResultListByCondition(condition2);
			if (results != null && !results.isEmpty()) {
				ZxJudgeResult result = results.get(0);
				object.put("score", result.getScore());
				object.put("grade", result.getGrade());
				object.put("result_id", result.getId());
				if(result.getStatus().endsWith("1"))
					object.put("status", "保存中");
				else if(result.getStatus().endsWith("2"))
					object.put("status", "审核中");
				else if(result.getStatus().endsWith("3"))
					object.put("status", "审核通过");
				else
					object.put("status", "审核退回");
			}
		}

		return object.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/getOverviewByResultId", method = { RequestMethod.POST, RequestMethod.GET })
	public String getOverviewByResultId(String result_id, HttpServletRequest request) {
		JSONObject object = new JSONObject();

		ZxJudgeResult result = zxJudgeResultService.getZxJudgeResultById(result_id);
		object.put("score", result.getScore());
		object.put("grade", result.getGrade());
		object.put("result_id", result.getId());
		if(result.getStatus().endsWith("1"))
			object.put("status", "保存中");
		else if(result.getStatus().endsWith("2"))
			object.put("status", "审核中");
		else if(result.getStatus().endsWith("3"))
			object.put("status", "审核通过");
		else
			object.put("status", "审核退回");
		
		ZxJudgeApply apply = zxJudgeApplyService.getZxJudgeApplyById(result.getApply_id());
		object.put("judge_date_start", apply.getJudge_date_start());
		object.put("judge_date_end", apply.getJudge_date_end());
		object.put("apply_id", apply.getId());
		return object.toString();
	}
	
	/**
	 * 上传
	 * 
	 * @param validateparameter
	 *            校验类型
	 * @param validateSize
	 *            校验大小
	 * @param xt_path_absolutek
	 *            绝对路径键（自定义）
	 * @param xt_path_relativek相对路径键（自定义）
	 * @param xt_path_urlk
	 *            基础路径URL（自定义）
	 * @param request
	 * @param response
	 * @return
	 */
	@AuthUneedLogin
	@ResponseBody
	@RequestMapping(value = "/upload", method = { RequestMethod.POST, RequestMethod.GET })
	public String upload(String result_id, String validateparameter, String validateSize, String xt_path_absolutek,
			String xt_path_relativek, String xt_path_urlk, HttpServletRequest request, HttpServletResponse response) {
		BaseJson baseJson = new BaseJson();
		
		ZxJudgeResult result = zxJudgeResultService.getZxJudgeResultById(result_id);
		if(result.getStatus().equals("2")||result.getStatus().equals("3")){
			baseJson.setMsg("上传失败、失败原因:审核中或审核通过");
			baseJson.setJsonID("0");
			return outDataStr(baseJson);
		}
		String sdfURL = (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL);
		if(sdfURL.indexOf(",zxJudgeReportController/saveReport,") < 0&&!CommonUtils.isAdmin()){
			baseJson.setMsg("上传失败、失败原因:没有权限");
			baseJson.setJsonID("0");
			return outDataStr(baseJson);
		}
		try {
			// 默认绝对路径
			String path = CommonUtils.getXtPathCache("xt_sources_default_path").get(0).getXt_path();
			// 相对路径
			String relative_path = CommonUtils.getXtPathCache("xt_sources_default_relative_path").get(0).getXt_path();
			// 校验xt_path_absolutek
			if (!StringUtils.isEmpty(xt_path_absolutek)) {
				if (!StringUtils.isEmpty(CommonUtils.getXtPathCache(xt_path_absolutek).get(0).getXt_path())) {
					path = CommonUtils.getXtPathCache(xt_path_absolutek).get(0).getXt_path();
				}
			}
			// 校验xt_path_relativek
			if (!StringUtils.isEmpty(xt_path_relativek)) {
				if (!StringUtils.isEmpty(CommonUtils.getXtPathCache(xt_path_relativek).get(0).getXt_path())) {
					relative_path = CommonUtils.getXtPathCache(xt_path_relativek).get(0).getXt_path();
				}
			}
			FileUtil.initPath(request, path);
			List<XtAttachment> xtAttachmentList = CommonUtils.upLoad(request, path, relative_path, validateparameter,
					validateSize, xt_path_absolutek, xt_path_relativek, xt_path_urlk);
			XtAttachment xtAttachment = xtAttachmentList.get(0);
			int i = xtAttachmentService.addXtAttachment(xtAttachment);
			
			XtUserinfo xtUserinfo = (XtUserinfo) request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
			ZxJudgeAttach zxJudgeAttach = new ZxJudgeAttach();
			zxJudgeAttach.setId(UUID.toUUID());
			zxJudgeAttach.setResult_id(result_id);
			zxJudgeAttach.setUpload_user_id(xtUserinfo.getXt_userinfo_id());
			zxJudgeAttach.setState("1");
			zxJudgeAttach.setXt_attachment_id(xtAttachment.getXt_attachment_id());
			zxJudgeAttach.setCreate_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxJudgeAttachService.addZxJudgeAttach(zxJudgeAttach);
			if (i > 0) {
				baseJson.setJsonID(xtAttachmentList.get(0).getXt_attachment_id());
				baseJson.setMsg("上传成功");
				baseJson.setFileType(xtAttachmentList.get(0).getXt_attachmentType());
				if (null != xtAttachmentList.get(0).getXt_attachmentType()
						&& !"".equals(xtAttachmentList.get(0).getXt_attachmentType())) {
					if ("image/jpeg".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/png".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/gif".equals(xtAttachmentList.get(0).getXt_attachmentType())
							|| "image/bmp".equals(xtAttachmentList.get(0).getXt_attachmentType())) {
						// 校验是否为自定义路径
						if (!StringUtils.isEmpty(xt_path_urlk)) {
							baseJson.setJsonValue(CommonUtils.getXtPathCache(xt_path_urlk).get(0).getXt_path()
									+ xtAttachmentList.get(0).getXt_attachmentPath());
						} else {
							baseJson.setJsonValue(CommonUtils.getXtPathCache("hssources_base_url").get(0).getXt_path()
									+ xtAttachmentList.get(0).getXt_attachmentPath());
						}
					} else {
						// 非图片格式让其显示成功图标即可
						baseJson.setJsonValue(CommonUtils.getXtPathCache("hs_upload_sucess").get(0).getXt_path());
					}
				} else {
					baseJson.setJsonValue(CommonUtils.getXtPathCache("hs_upload_fail").get(0).getXt_path());
				}
			} else {
				baseJson.setJsonValue(CommonUtils.getXtPathCache("hs_upload_fail").get(0).getXt_path());
				baseJson.setMsg("上传失败");
			}
			return outDataStr(baseJson);
		} catch (Exception e) {
			baseJson.setMsg("上传失败、失败原因:" + e.getMessage());
			baseJson.setJsonID("0");
			return outDataStr(baseJson);
		}
	}

	/**
	 * 下载文件
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/downFile",method={RequestMethod.POST,RequestMethod.GET})
	public String downFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		ZxJudgeAttach zxJudgeAttach = zxJudgeAttachService.getZxJudgeAttachById(id);
		String xt_attachment_id = zxJudgeAttach.getXt_attachment_id();
		return xt_attachment_id;
	}
	
	@ResponseBody
	@RequestMapping(value = "/refreshAttach", method = { RequestMethod.POST, RequestMethod.GET })
	public String refreshAttach(String result_id,HttpServletRequest request) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("result_id", result_id);
		condition.put("is_connect", 1);
		condition.put("state", 1);
		commonHPager(condition, request);
		List<ZxJudgeAttach> zxJudgeAttachs = zxJudgeAttachService.getZxJudgeAttachListByCondition(condition);
		PageInfo<ZxJudgeAttach> page = new PageInfo<ZxJudgeAttach>(zxJudgeAttachs);
		return outPageStr(page, request);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delAttach", method = { RequestMethod.POST, RequestMethod.GET })
	public String delAttach(String id,String result_id,HttpServletRequest request) {
		int i = 0;
		ZxJudgeResult result = zxJudgeResultService.getZxJudgeResultById(result_id);
		if(result.getStatus().equals("2")||result.getStatus().equals("3")){
			i = 1;
		}else{
			ZxJudgeAttach attach = zxJudgeAttachService.getZxJudgeAttachById(id);
			XtUserinfo xtUserinfo = (XtUserinfo) request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
			if(attach.getUpload_user_id().equals(xtUserinfo.getXt_userinfo_id())){
				attach.setState("0");
				attach.setDel_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				int m = zxJudgeAttachService.updateZxJudgeAttach(attach);
				if(m > 0){
					i = 2;
				}else{
					i = 3;
				}
			}else{
				i = 4;
			}
		}
		
		return String.valueOf(i);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getZxJudgeResultTaskById", method = { RequestMethod.POST, RequestMethod.GET })
	public String getZxJudgeResultTaskById(String id,HttpServletRequest request) {
		ZxJudgeResult result = zxJudgeResultService.getZxJudgeResultById(id);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", result.getApply_id());
		condition.put("is_connect", 1);
		List<ZxJudgeApply> applys = zxJudgeApplyService.getZxJudgeApplyListByCondition(condition);
		Map<String,String> map = new HashMap<String,String>();
		map.put("supplier_name", applys.get(0).getSupplier_name());
		map.put("judge_date_start", applys.get(0).getJudge_date_start());
		map.put("judge_date_end", applys.get(0).getJudge_date_end());
		map.put("score", String.valueOf(result.getScore()));
		String  grade = null;
	   	if(result.getScore() >= 80.0){
	   		grade = "合格供应商";
		}else if(result.getScore() < 60.0){
			grade = "不合格供应商";
		}else {
			grade = "必须限期整改";
		}
	   	map.put("grade", grade);
		return outDataStr(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUserList", method = { RequestMethod.POST, RequestMethod.GET })
	public String getUserList(String result_id,String type, HttpServletRequest request) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("result_id", result_id);
		condition.put("type", type);
		condition.put("state", 1);
		condition.put("is_connect", 1);
		List<ZxJudgeUser> users = zxJudgeUserService.getZxJudgeUserListByCondition(condition);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(ZxJudgeUser e:users){
			boolean f = true; 
			for(Map<String,String> map:list){
				if(map.get("user_id").equals(e.getUser_id())){
					f = false;
					break;
				}
			}
			if(f){
				Map<String,String> map = new HashMap<String,String>();
				map.put("user_id", e.getUser_id());
				map.put("user_name", e.getUser_realName());
				list.add(map);
			}
		}
		JSONObject ob = new JSONObject();
		ob.put("list", list);
		return ob.toString();
	}
}
