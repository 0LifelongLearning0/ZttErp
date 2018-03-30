package jehc.zxmodules.web;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
import jehc.xtmodules.xtmodel.XtPost;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtservice.XtPostService;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderFileDownload;
import jehc.zxmodules.model.ZttOrderbybuy;
import jehc.zxmodules.model.ZttOrderbyself;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxPurchaseApply;
import jehc.zxmodules.model.ztt_processproduct;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.service.ZttOrderbybuyService;
import jehc.zxmodules.service.ZttOrderbyselfService;
import net.sf.json.JSONObject;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
@Controller
@RequestMapping("/zttOrderController")
public class ZttOrderController extends BaseAction{
	@Autowired
	private ZttOrderService zttOrderService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private  ActivitiUtil activitiUtil;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private XtPostService XtPostService;
	@Autowired
	private ZttOrderbyselfService zttOrderbyselfService;
	@Autowired
	private ZttOrderbybuyService zttOrderbybuyService;
	
	/**
	* 载入初始化页面
	* @param ztt_order 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZttOrder(ZttOrder zttOrder,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/ztt-order/ztt-order-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_order 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		condition.put("apply_id", getXtU().getXt_userinfo_id());
		condition.put("xt_post_id", getXtU().getXt_post_id());
		List<XtPost> xtpost=XtPostService.getXtPostListByCondition(condition);
		if(xtpost.get(0).getXt_post_grade()>0){
			condition.clear();
		}
		
		commonHPager(condition,request);
		List<ZttOrder> zttOrderList = zttOrderService.getZttOrderListByCondition(condition);
		PageInfo<ZttOrder> page = new PageInfo<ZttOrder>(zttOrderList);
		return outPageBootStr(page,request);
	}
	/**
	* 加载初始化列表数据并分页
	* @param ztt_order 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderfiledownListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderfiledownListByCondition(String id,BaseSearch baseSearch,HttpServletRequest request){
		List<ZttOrderFileDownload> zttOrderList = null;
		ZttOrderFileDownload l=new ZttOrderFileDownload();
		l.setId("1");
		l.setFilename("aa");
		l.setFilelink("bb");
		zttOrderList.add(l);
		PageInfo<ZttOrderFileDownload> page = new PageInfo<ZttOrderFileDownload>(zttOrderList);
		return outPageBootStr(page,request);
	}
	
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZttOrderById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZttOrderById(String id,HttpServletRequest request){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		return outDataStr(zttOrder);
	}
	/**
	* 添加
	* @param ztt_order 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public String addZttOrder(ZttOrder zttOrder,HttpServletRequest request){
		int i = 0;
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		if(null != zttOrder && !"".equals(zttOrder)){
			zttOrder.setId(UUID.toUUID());
			zttOrder.setZttordertime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));;
			zttOrder.setState("0");
			zttOrder.setApply_id(applyUser.getXt_userinfo_id());
			i=zttOrderService.addZttOrder(zttOrder);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param ztt_order 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZttOrder(ZttOrder zttOrder,HttpServletRequest request){
		int i = 0;
		if(null != zttOrder && !"".equals(zttOrder)){
			i=zttOrderService.updateZttOrder(zttOrder);
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
	@RequestMapping(value="/delZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public String delZttOrder(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zttOrderService.delZttOrder(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 加工工艺过程添加
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/processingtechnicAdd",method={RequestMethod.POST,RequestMethod.GET})
	public String processingtechnicAdd(ZttOrder zttOrder,HttpServletRequest request){
		int i = 0;
		i=zttOrderService.addztt_processproduct(zttOrder);
		/*XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		if(null != ztt_processproduct && !"".equals(ztt_processproduct)){
			i=zttOrderService.addztt_processproduct(ztt_processproduct);
		}*/
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 加工工艺过程修改
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/processingtechnicUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public String processingtechnicUpdate(ZttOrder zttOrder,HttpServletRequest request){
		int i = 0;
		i=zttOrderService.updateztt_processproduct(zttOrder);
		/*XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		if(null != ztt_processproduct && !"".equals(ztt_processproduct)){
			i=zttOrderService.addztt_processproduct(ztt_processproduct);
		}*/
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
	@RequestMapping(value="/copyZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZttOrder(String id,HttpServletRequest request){
		int i = 0;
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		if(null != zttOrder && !"".equals(zttOrder)){
			zttOrder.setId(UUID.toUUID());
			i=zttOrderService.addZttOrder(zttOrder);
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
	@RequestMapping(value="/exportZttOrder",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZttOrder(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderAdd(ZttOrder zttOrder,HttpServletRequest request,Model model){
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(getXtUid());
		model.addAttribute("applyUser", applyUser);
		return new ModelAndView("pc/zx-view/ztt-order/ztt-order-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderUpdate(String id,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/ztt-order-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttOrderDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttOrderDetail(String id,String state,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zttOrder.getApply_id());
		String path="";
		if(state.equals("11")){
			path="pc/zx-view/ztt-order/ztt-order-detail_erp";
		}else if(state.equals("5")||state.equals("6")){
			path="pc/zx-view/ztt-order/ztt-order-detail_product";
		}else if(state.equals("7")||state.equals("8")){
			path="pc/zx-view/ztt-order/ztt-order-detail_check";
		}else if(state.equals("9")||state.equals("12")){
			path="pc/zx-view/ztt-order/ztt-order-detail_check_dept";
		}else{
			path="pc/zx-view/ztt-order/ztt-order-detail";
		}
		model.addAttribute("applyUser", applyUser);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView(path);
	}
	/**
	* 发送至生产部或者质检明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZttprocessingtechnicDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZttprocessingtechnicDetail(String id,String state,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getprocessingtechnicById(id);
		XtUserinfo producter=null;
		if(zttOrder.getProducter_id()!=null){
			producter = xtUserinfoService.getXtUserinfoById(zttOrder.getProducter_id());
		}
		XtUserinfo applyUser = xtUserinfoService.getXtUserinfoById(zttOrder.getApply_id());
		model.addAttribute("zttOrder", zttOrder);
		model.addAttribute("size", zttOrder.getZtt_processproduct().size());
		model.addAttribute("producter", producter);
		String path;
		if(state.equals("7")){
			model.addAttribute("message", "not_show");
			path="pc/zx-view/ztt-order/processingtechniccheck";
			XtUserinfo techmanager = xtUserinfoService.getXtUserinfoById(zttOrder.getTechmanager_id());
			model.addAttribute("techmanager", techmanager);
		}else if(state.equals("8")){
			path="pc/zx-view/ztt-order/processingtechnicproductret";
		}else{
			path="pc/zx-view/ztt-order/processingtechnicproduct";
		}
		
		model.addAttribute("applyUser", applyUser);
		
		return new ModelAndView(path);
	}
	/**
	* 发送至上传页面
	* @param request 
	*/
	@RequestMapping(value="/uploadattachment",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView uploadattachment(String id,String upid,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("upid", upid);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/uploadattachment");
	}
	/**
	* 发送至加工工艺过程页面
	* @param request 
	*/
	@RequestMapping(value="/processingtechnic",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView processingtechnic(String id,String index,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("zttOrder", zttOrder);
		model.addAttribute("index", index);
		return new ModelAndView("pc/zx-view/ztt-order/processingtechnic");
	}
	/**
	* 发送至下载页面
	* @param request 
	*/
	@RequestMapping(value="/Downloadattachment",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Downloadattachment(String id,String upid,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("upid", upid);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/downloadattachmenttech");
	}
	/**
	* 上传
	* @param request 
	*/
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	public @ResponseBody String jqueryUploadFile(HttpServletResponse response,HttpServletRequest request,
            @RequestParam(value="file", required=false) MultipartFile file){
		long startTime = System.currentTimeMillis();
		String path="E:/upload/"+"date--"+new Date().getTime()+"-----"+file.getOriginalFilename();
		Map<String,String> result = new HashMap<String,String>();
        try{
            //获取输出流
            OutputStream os = new FileOutputStream(path);
            //获取输入流CommonsMultipartFile中可以直接得到文件的流
            InputStream is = file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1)){
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
            result.put("path",path);
            result.put("flag", "true");
        }catch(Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        JSONObject jsonObject = JSONObject.fromObject(result);
        return jsonObject.toString();
	}
	/**
	* 下载
	* @param request 
	*/
	@RequestMapping(value="/downloadfile",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public void jqueryDownloadFile(String fileName, HttpServletRequest request, HttpServletResponse response){
		    BufferedInputStream bis = null;  
		    BufferedOutputStream bos = null;  
		    try{
		        //获取输入流
		        bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
		        //获取输出流
		        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/octet-stream");  
		        String name=fileName.split("-----")[1];
		        response.setHeader("Content-disposition", "attachment; filename="+ new String(name.getBytes("utf-8"), "ISO8859-1")); 
		        bos = new BufferedOutputStream(response.getOutputStream()); 

		        //定义缓冲池大小，开始读写
		        byte[] buff = new byte[2048];  
		        int bytesRead;  
		        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
		          bos.write(buff, 0, bytesRead);  
		        }

		        //刷新缓冲，写出
		        bos.flush();

		    }catch(Exception e){
		    }finally{
		        //关闭流
		        if(bis != null){
		            try {
		                bis.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }  
		        }
		        if(bis != null){
		            try {
		                bos.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
	}
	
	/**
	* 申请
	* @param zx_goods_apply 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/toApply",method={RequestMethod.POST,RequestMethod.GET})
	public String toApply(String apply_id,HttpServletRequest request,Model model){
		int i = 0;
		if(null != apply_id && !"".equals(apply_id)){
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZttOrder zttOrder = zttOrderService.getZttOrderById(apply_id);
			String order_number=zttOrderService.add_ordernumber(zttOrder);
			XtConstant Xt_Constant = getXtConstantCache("ZttOrderApply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("taskType","业务人员下单流程" );
		    variables.put("owner",zttOrder.getApply_id());
		    lc_Apply.setLc_apply_title(getXtU().getXt_userinfo_realName()+"于"+getSimpleDateFormat()+"，提交了一条部门申请申请流程");
			lc_Apply.setLc_apply_model_biz_id(zttOrder.getId());
			if(activitiUtil.addApply(lc_his_id, zttOrder.getId(), variables,lc_Apply)){
				zttOrder.setState("1");
				zttOrder.setProduct_order_number(order_number);
				i=zttOrderService.updateZttOrderBySelective(zttOrder);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
/*	public static void main(String[] args) {
		Variable variables = new Variable();
		ActivitiUtil a=new ActivitiUtil();
		variables.setTypes("S");
		variables.setKeys("status");
		variables.setValues("no");
		activitiUtil.completeTask("167506", variables);
	}*/
	/**
	* 审批
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/approvalOrderApply",method={RequestMethod.POST,RequestMethod.GET})
	public String approvalOrderApply(String task_id,String task_status,String remark,String path,HttpServletRequest request){
		int i = 0;
		if(null != task_id && !"".equals(task_id)){
			Map<String, Object> taskData = activitiUtil.getTask(task_id);
		    Variable variables = new Variable();
		    ZttOrder zttOrder = zttOrderService.getZttOrderById(taskData.get("businessKey").toString());
		    String vals = task_status + "," + zttOrder.getApply_id() + ",";
		    variables.setKeys("status,owner,applyType");
		    variables.setTypes("S,S,S");
		    if(remark.equals("warehouse")||remark.equals("PD")||remark.equals("others")){
		    	vals +="others";
		    }else{
		    	vals +=remark;
		    }
		    
		    variables.setValues(vals);
		    String s=remark;
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
					lc_approval.setLc_status_name("主管审批通过");
					if(remark.equals("outside")){
						String erpnumber=remark;
						lc_approval.setLc_status_name("外协单,带数据分析师通过");
						zttOrder.setErp_number(erpnumber);
						zttOrder.setState("2");
					}else if(remark.equals("madebyself")){
						lc_approval.setLc_status_name("自制单,待工艺设计");
						zttOrder.setState("4");
					}else if(remark.equals("others")){
						lc_approval.setLc_status_name("流程结束");
						zttOrder.setState("11");
					}else if(remark.equals("checkself")){
						lc_approval.setLc_status_name("质检合格,待质检部检验");
						zttOrder.setChecker_attachment(path);
						zttOrder.setChecker_id(getXtUid());
						zttOrder.setCheck_end_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zttOrder.setState("7");
					}else if(remark.equals("deptcheckself")){
						lc_approval.setLc_status_name("质检部检验合格");
						zttOrder.setChecker_attachment(path);
						zttOrder.setChecker_id(getXtUid());
						zttOrder.setCheck_end_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zttOrder.setState("9");
					}else if(remark.equals("warehouse")){
						lc_approval.setLc_status_name("仓库");
						zttOrder.setState("13");
					}else if(remark.equals("PD")){
						lc_approval.setLc_status_name("生产部");
						zttOrder.setState("14");
					}else if(remark.equals("others")){
						lc_approval.setLc_status_name("其他");
						zttOrder.setState("15");
					}
					zttOrderService.updateZttOrderBySelective(zttOrder);
				}else if(task_status.equals("no")){
					lc_approval.setLc_status_name("审批不通过");
					if(remark.equals("checkself")){
						lc_approval.setLc_status_name("自制单,质检不通过,返回生产");
						zttOrder.setChecker_attachment(path);
						zttOrder.setChecker_id(getXtUid());
						zttOrder.setCheck_end_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zttOrder.setState("8");
					}else if(remark.equals("deptcheckself")){
						lc_approval.setLc_status_name("质检部检验不合格");
						zttOrder.setDept_check_attachment(path);
						zttOrder.setDept_check_id(getXtUid());
						zttOrder.setDept_check_end_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						zttOrder.setState("12");
					}else{
						zttOrder.setState("10");
					}
					zttOrderService.updateZttOrderBySelective(zttOrder);
				}else if(task_status.equals("erp")){
						zttOrder.setState("3");
						zttOrder.setErp_number(remark);
					zttOrderService.updateZttOrderBySelective(zttOrder);
				}else if(task_status.equals("selftech")){
					
					lc_approval.setLc_status_name("自制单,待生产");
					zttOrder.setTechmanager_attachment(remark);
					zttOrder.setTechmanager_id(getXtUid());
					zttOrder.setTechmanager_update_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
					zttOrder.setState("5");
					zttOrderService.updateZttOrderBySelective(zttOrder);
					
				}else if(task_status.equals("selfwaitcheck")){
					
					lc_approval.setLc_status_name("自制单生产完成,待质检");
					zttOrder.setProducter_id(getXtUid());
					zttOrder.setProduct_end_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
					zttOrder.setState("6");
					zttOrderService.updateZttOrderBySelective(zttOrder);
					
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
