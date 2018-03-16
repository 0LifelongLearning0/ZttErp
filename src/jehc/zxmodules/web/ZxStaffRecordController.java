package jehc.zxmodules.web;
import java.util.List;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtDepartinfo;
import jehc.xtmodules.xtmodel.XtPost;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtDepartinfoService;
import jehc.xtmodules.xtservice.XtPostService;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxStaffRecord;
import jehc.zxmodules.service.ZxStaffRecordService;
import net.sf.json.JSONArray;

/**
* 员工档案 
* 2018-01-04 15:58:11  owen
*/
@Controller
@RequestMapping("/zxStaffRecordController")
public class ZxStaffRecordController extends BaseAction{
	@Autowired
	private ZxStaffRecordService zxStaffRecordService;
	@Autowired
	private XtDepartinfoService xtDepartinfoService;
	@Autowired
	private XtPostService xtPostService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	/**
	* 载入初始化页面
	* @param zx_staff_record 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxStaffRecord(ZxStaffRecord zxStaffRecord,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-staff-record/zx-staff-record-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_staff_record 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxStaffRecordListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxStaffRecordListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxStaffRecord> zxStaffRecordList = zxStaffRecordService.getZxStaffRecordListByCondition(condition);
		PageInfo<ZxStaffRecord> page = new PageInfo<ZxStaffRecord>(zxStaffRecordList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxStaffRecordById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxStaffRecordById(String id,HttpServletRequest request){
		ZxStaffRecord zxStaffRecord = zxStaffRecordService.getZxStaffRecordById(id);
		String outData = outDataStr(zxStaffRecord);
		String outStr = outData.substring(0,outData.length()-2);
		XtDepartinfo xtDepartinfo = xtDepartinfoService.getXtDepartinfoById(zxStaffRecord.getXt_departinfo_id());
		XtPost xtPost = xtPostService.getXtPostById(zxStaffRecord.getXt_post_id());
		if(null != xtDepartinfo){
			String jsonStr = JSONArray.fromObject(xtDepartinfo).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"xtDepartinfo\":").concat(jsonStr);
		}
		if(null != xtPost){
			String jsonStr = JSONArray.fromObject(xtPost).toString(); 
			jsonStr = jsonStr.substring(1,jsonStr.length()-1);
			outStr = outStr.concat(",\"xtPost\":").concat(jsonStr);
		}
		outStr = outStr.concat(outData.substring(outData.length()-2,outData.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_staff_record 
	* @param request 
	* @throws ParseException 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxStaffRecord(ZxStaffRecord zxStaffRecord,HttpServletRequest request) throws ParseException{
		int i = 0;
		if(null != zxStaffRecord && !"".equals(zxStaffRecord)){
			zxStaffRecord.setId(UUID.toUUID());
			String file_num = zxStaffRecord.getFile_num();
			String user_num = zxStaffRecord.getUser_num();
			Map<String, Object> condition = new HashMap<String,Object>();
			condition.put("file_num", file_num);
			condition.put("user_num", user_num);
			List<ZxStaffRecord> zxStaffRecordList = zxStaffRecordService.getZxStaffRecordListByCondition(condition);
			if(zxStaffRecordList.size()<1){
				if(zxStaffRecord.getXt_user_id() == null && "".equals(zxStaffRecord.getXt_user_id())){
					zxStaffRecord.setXt_user_id(UUID.toUUID());
				}
				i=zxStaffRecordService.addZxStaffRecord(zxStaffRecord);
			}else{
				return "{success:false,msg:'员工编号或档案编号有误',responseFlag:false}";
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
	* @param zx_staff_record 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxStaffRecord(ZxStaffRecord zxStaffRecord,HttpServletRequest request){
		int i = 0;
		if(null != zxStaffRecord && !"".equals(zxStaffRecord)){
			i=zxStaffRecordService.updateZxStaffRecordBySelective(zxStaffRecord);
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
	@RequestMapping(value="/delZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxStaffRecord(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxStaffRecordService.delZxStaffRecord(condition);
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
	@RequestMapping(value="/copyZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxStaffRecord(String id,HttpServletRequest request){
		int i = 0;
		ZxStaffRecord zxStaffRecord = zxStaffRecordService.getZxStaffRecordById(id);
		if(null != zxStaffRecord && !"".equals(zxStaffRecord)){
			zxStaffRecord.setId(UUID.toUUID());
			i=zxStaffRecordService.addZxStaffRecord(zxStaffRecord);
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
	@RequestMapping(value="/exportZxStaffRecord",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxStaffRecord(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxStaffRecordAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxStaffRecordAdd(String xt_user_id,HttpServletRequest request,Model model){
		if(xt_user_id!=null){
			XtUserinfo xtUserinfo = xtUserinfoService.getXtUserinfoById(xt_user_id);
			model.addAttribute("xt_user_id",xt_user_id);
			model.addAttribute("user_name", xtUserinfo.getXt_userinfo_realName());
		}
		return new ModelAndView("pc/zx-view/zx-staff-record/zx-staff-record-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxStaffRecordUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxStaffRecordUpdate(String id,HttpServletRequest request, Model model){
		ZxStaffRecord zxStaffRecord = zxStaffRecordService.getZxStaffRecordById(id);
		model.addAttribute("zxStaffRecord", zxStaffRecord);
		return new ModelAndView("pc/zx-view/zx-staff-record/zx-staff-record-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxStaffRecordDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxCarDetail(String id,HttpServletRequest request, Model model){
		ZxStaffRecord zxStaffRecord = zxStaffRecordService.getZxStaffRecordById(id);
		model.addAttribute("zxStaffRecord", zxStaffRecord);
		return new ModelAndView("pc/zx-view/zx-staff-record/zx-staff-record-detail");
	}
	/**
	* 发送至选择员工页面
	* @param request 
	*/
	@RequestMapping(value="/toZxStaffRecordUserChoose",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxStaffRecordUserChoose(XtUserinfo xtUserinfo,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-staff-record/zx-staff-record-user-choose");
	}
}
