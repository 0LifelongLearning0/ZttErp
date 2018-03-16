package jehc.zxmodules.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtservice.XtUserinfoService;
import jehc.zxmodules.model.ZxSixS;
import jehc.zxmodules.model.ZxSixSContent;
import jehc.zxmodules.service.ZxSixSContentService;
import jehc.zxmodules.service.ZxSixSService;

/**
* 6S待办内容 
* 2017-11-01 10:20:06  a
*/
@Controller
@RequestMapping("/zxSixSContentController")
public class ZxSixSContentController extends BaseAction{
	@Autowired
	private ZxSixSContentService zxSixSContentService;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private ZxSixSService zxSixSService;
	/**
	* 载入初始化页面
	* @param zx_six_s_content 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxSixSContent(ZxSixSContent zxSixSContent,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-six-s-content/zx-six-s-content-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_six_s_content 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSixSContentListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSixSContentListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("six_s_id", request.getParameter("six_s_id"));
		List<ZxSixSContent> zxSixSContentList = zxSixSContentService.getZxSixSContentListByCondition(condition);
		PageInfo<ZxSixSContent> page = new PageInfo<ZxSixSContent>(zxSixSContentList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSixSContentById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSixSContentById(String id,HttpServletRequest request){
		ZxSixSContent zxSixSContent = zxSixSContentService.getZxSixSContentById(id);
		if(zxSixSContent.getEnd_date() != null)zxSixSContent.setEnd_date(zxSixSContent.getEnd_date().substring(0, 10));
		if(zxSixSContent.getUser_id() != null)zxSixSContent.setUser_realname(xtUserinfoService.getXtUserinfoById(zxSixSContent.getUser_id()).getXt_userinfo_realName());
		return outDataStr(zxSixSContent);
	}
	/**
	* 添加
	* @param zx_six_s_content 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxSixSContent(ZxSixSContent zxSixSContent,HttpServletRequest request){
		int i = 0;
		if(null != zxSixSContent){
			zxSixSContent.setId(UUID.toUUID());
			zxSixSContent.setCreate_date(getSimpleDateFormat());
			zxSixSContent.setStatus("1");
			i=zxSixSContentService.addZxSixSContent(zxSixSContent);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_six_s_content 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxSixSContent(ZxSixSContent zxSixSContent,HttpServletRequest request){
		int i = 0;
		if(null != zxSixSContent){
			i=zxSixSContentService.updateZxSixSContent(zxSixSContent);
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
	@RequestMapping(value="/delZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxSixSContent(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxSixSContentService.delZxSixSContent(condition);
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
	@RequestMapping(value="/copyZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxSixSContent(String id,HttpServletRequest request){
		int i = 0;
		ZxSixSContent zxSixSContent = zxSixSContentService.getZxSixSContentById(id);
		if(null != zxSixSContent){
			zxSixSContent.setId(UUID.toUUID());
			i=zxSixSContentService.addZxSixSContent(zxSixSContent);
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
	@RequestMapping(value="/exportZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxSixSContent(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	/**
	* 改善
	* @param zx_six_s_content 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/correctZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String correctZxSixSContent(String id,String status,String result_pic,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			ZxSixSContent zxSixSContent = zxSixSContentService.getZxSixSContentById(id);
			if(zxSixSContent.getUser_id().equals(getXtUid())||isAdmin()
				&&(zxSixSContent.getStatus().equals("1")||zxSixSContent.getStatus().equals("2"))){
				zxSixSContent.setStatus(status);
				zxSixSContent.setResult_pic(result_pic);
				i=zxSixSContentService.updateZxSixSContent(zxSixSContent);
				if(status.equals("2")){
					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("six_s_id",zxSixSContent.getSix_s_id());
					List<ZxSixSContent> list = zxSixSContentService.getZxSixSContentListByCondition(condition);
					boolean flag = true;
					for(ZxSixSContent bean:list){
						if(!bean.getStatus().equals("2")){
							flag = false;
							break;
						}
					}
					if(flag){
						ZxSixS zxSixS = zxSixSService.getZxSixSById(zxSixSContent.getSix_s_id());
						zxSixS.setStatus("3");
						i = zxSixSService.updateZxSixS(zxSixS);
					}
				}
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	 * 确认
	 * @param ids
	 * @param six_s_id
	 * @param status
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkZxSixSContent",method={RequestMethod.POST,RequestMethod.GET})
	public String checkZxSixSContent(String ids,String six_s_id,String status,HttpServletRequest request){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("six_s_id",six_s_id);
		List<ZxSixSContent> contents = zxSixSContentService.getZxSixSContentListByCondition(condition);
		
		List<ZxSixSContent> list = new ArrayList<ZxSixSContent>();
		String[] idArray = ids.split(",");
		for(String id:idArray){
			for(ZxSixSContent bean:contents){
				if(id.equals(bean.getId())){
					bean.setStatus(status);
					list.add(bean);
					break;
				}
			}
		}
		
		
		int i = 0;
		if(!list.isEmpty()){
			i = zxSixSContentService.updateBatchZxSixSContent(list);
			if(status.equals("3")){
				condition = new HashMap<String, Object>();
				condition.put("six_s_id",six_s_id);
				condition.put("status",3);
				List<ZxSixSContent> newcontents = zxSixSContentService.getZxSixSContentListByCondition(condition);
				
				if(newcontents.size() == contents.size()){
					ZxSixS zxSixS = zxSixSService.getZxSixSById(six_s_id);
					zxSixS.setStatus("4");
					i = zxSixSService.updateZxSixS(zxSixS);
				}
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
