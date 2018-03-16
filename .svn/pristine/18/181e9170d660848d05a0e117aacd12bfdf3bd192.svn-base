package jehc.zxmodules.web;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.constant.SessionConstant;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.zxmodules.model.ZxJudgeStandard;
import jehc.zxmodules.service.ZxJudgeStandardService;

/**
* 供应商评定标准 
* 2017-09-21 13:16:25  guqian
*/
@Controller
@RequestMapping("/zxJudgeStandardController")
public class ZxJudgeStandardController extends BaseAction{
	@Autowired
	private ZxJudgeStandardService zxJudgeStandardService;
	
	/**
	* 载入初始化页面
	* @param zx_judge_standard 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxJudgeStandard(ZxJudgeStandard zxJudgeStandard,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-judge-standard/zx-judge-standard-list");
	}
	
	@RequestMapping(value="/loadZxJudgeAgainStandard",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxJudgeAgainStandard(ZxJudgeStandard zxJudgeStandard,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-judge-standard/zx-judge-again-standard-list");
	}
	
	/**
	* 加载初始化列表数据并分页
	* @param zx_judge_standard 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxJudgeStandardListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeStandardListByCondition(String type,BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		condition.put("type", type);
		condition.put("state", 1);
		commonHPager(condition,request);
		List<ZxJudgeStandard> zxJudgeStandardList = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
		PageInfo<ZxJudgeStandard> page = new PageInfo<ZxJudgeStandard>(zxJudgeStandardList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxJudgeStandardById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxJudgeStandardById(String id,HttpServletRequest request){
		ZxJudgeStandard zxJudgeStandard = zxJudgeStandardService.getZxJudgeStandardById(id);
		return outDataStr(zxJudgeStandard);
	}
	/**
	* 添加
	* @param zx_judge_standard 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxJudgeStandard(String type,ZxJudgeStandard zxJudgeStandard,HttpServletRequest request){
		int i = 0;
		if(null != zxJudgeStandard){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("state",1);
			condition.put("type",type);
			condition.put("dic_id",zxJudgeStandard.getDic_id());
			condition.put("content",zxJudgeStandard.getContent());
			List<ZxJudgeStandard> list = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
			if(list.isEmpty()){
				zxJudgeStandard.setId(UUID.toUUID());
				zxJudgeStandard.setType(type);
				zxJudgeStandard.setState("1");
				i=zxJudgeStandardService.addZxJudgeStandard(zxJudgeStandard);
			}else{
				return "{success:false,msg:'内容重复',responseFlag:false}";
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
	* @param zx_judge_standard 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxJudgeStandard(ZxJudgeStandard zxJudgeStandard,HttpServletRequest request){
		int i = 0;
		if(null != zxJudgeStandard){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("state",1);
			condition.put("type",zxJudgeStandard.getType());
			condition.put("dic_id",zxJudgeStandard.getDic_id());
			condition.put("content",zxJudgeStandard.getContent());
			List<ZxJudgeStandard> list = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
			if(list.isEmpty()||(list.size() == 1&&list.get(0).getId().equals(zxJudgeStandard.getId()))){
				i=zxJudgeStandardService.updateZxJudgeStandard(zxJudgeStandard);
			}else{
				return "{success:false,msg:'内容重复',responseFlag:false}";
			}
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
	@RequestMapping(value="/delZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxJudgeStandard(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxJudgeStandardService.delZxJudgeStandard(condition);
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
	@RequestMapping(value="/copyZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxJudgeStandard(String id,HttpServletRequest request){
		int i = 0;
		ZxJudgeStandard zxJudgeStandard = zxJudgeStandardService.getZxJudgeStandardById(id);
		if(null != zxJudgeStandard){
			zxJudgeStandard.setId(UUID.toUUID());
			i=zxJudgeStandardService.addZxJudgeStandard(zxJudgeStandard);
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
	@RequestMapping(value="/exportZxJudgeStandard",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxJudgeStandard(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	* 初始化
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/initStandard",method={RequestMethod.POST,RequestMethod.GET})
	public String initStandard(String type,HttpServletRequest request){	
		XtUserinfo xtUserinfo = (XtUserinfo)request.getSession(false).getAttribute(SessionConstant.XTUSERINFO);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("dep_id",xtUserinfo.getXt_departinfo_id());
		condition.put("type",type);
		condition.put("state",1);
		List<ZxJudgeStandard> list = zxJudgeStandardService.getZxJudgeStandardListByCondition(condition);
		Set<ZxJudgeStandard> sets = new HashSet<ZxJudgeStandard>();
		for(ZxJudgeStandard bean:list)
			sets.add(bean);
		return outItemsStr(sets);
	}
	
	/**
	* 获取部门
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getDep",method={RequestMethod.POST,RequestMethod.GET})
	public String getDep(String type,HttpServletRequest request){	
		List<Map<String,String>> list = zxJudgeStandardService.getDepListByCondition(new HashMap<String, Object>());
		return outItemsStr(list);
	}
}
