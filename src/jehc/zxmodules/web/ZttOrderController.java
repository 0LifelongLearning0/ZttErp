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
import jehc.lcmodules.lcmodel.LcApply;
import jehc.lcmodules.lcservice.LcDeploymentHisService;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxPurchaseApply;
import jehc.zxmodules.service.ZttOrderService;

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
	private ActivitiUtil activitiUtil;
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
		commonHPager(condition,request);
		List<ZttOrder> zttOrderList = zttOrderService.getZttOrderListByCondition(condition);
		PageInfo<ZttOrder> page = new PageInfo<ZttOrder>(zttOrderList);
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
	public ModelAndView toZttOrderDetail(String id,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/ztt-order-detail");
	}
	/**
	* 发送至上传页面
	* @param request 
	*/
	@RequestMapping(value="/uploadattachment",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView uploadattachment(String id,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/uploadattachment");
	}
	/**
	* 发送至下载页面
	* @param request 
	*/
	@RequestMapping(value="/Downloadattachment",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Downloadattachment(String id,HttpServletRequest request, Model model){
		ZttOrder zttOrder = zttOrderService.getZttOrderById(id);
		model.addAttribute("zttOrder", zttOrder);
		return new ModelAndView("pc/zx-view/ztt-order/downloadattachment");
	}
	/**
	* 上传
	* @param request 
	*/
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	public @ResponseBody String jqueryUploadFile(HttpServletResponse response,HttpServletRequest request,
            @RequestParam(value="file", required=false) MultipartFile file){
		long startTime = System.currentTimeMillis();
		String path="E:/upload/"+"date--"+new Date().getTime()+file.getOriginalFilename();
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
        }catch(Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return path;
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
		        response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("utf-8"), "ISO8859-1")); 
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
				
				i=zttOrderService.updateZttOrderBySelective(zttOrder);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
