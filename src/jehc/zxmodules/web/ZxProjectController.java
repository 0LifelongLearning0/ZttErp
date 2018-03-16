package jehc.zxmodules.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.base.BaseTreeGridEntity;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxProject;
import jehc.zxmodules.model.ZxWorkpiece;
import jehc.zxmodules.service.ZxProjectService;
import jehc.zxmodules.service.ZxWorkpieceService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 项目管理表 
* 2017-08-28 14:15:35  陈运芝
*/
@Controller
@RequestMapping("/zxProjectController")
public class ZxProjectController extends BaseAction{
	@Autowired
	private ZxProjectService zxProjectService;
	@Autowired
	private ZxWorkpieceService zxWorkpieceService;
	/**
	* 载入初始化页面
	* @param zx_project 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxProject(ZxProject zxProject,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-project/zx-project-list");
	}
	/**
	* 发送至新增页面
	* @param request 
	*/
	@RequestMapping(value="/toZxProjectAdd",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxProjectAdd(ZxProject zxProject,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-project/zx-project-add");
	}
	/**
	* 发送至编辑页面
	* @param request 
	*/
	@RequestMapping(value="/toZxProjectUpdate",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxProjectUpdate(String id,HttpServletRequest request, Model model){
		ZxProject zxProject = zxProjectService.getZxProjectById(id);
		model.addAttribute("zxProject", zxProject);
		return new ModelAndView("pc/zx-view/zx-project/zx-project-update");
	}
	/**
	* 发送至明细页面
	* @param request 
	*/
	@RequestMapping(value="/toZxProjectDetail",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toZxProjectDetail(String id,HttpServletRequest request, Model model){
		ZxProject zxProject = zxProjectService.getZxProjectById(id);
		model.addAttribute("zxProject", zxProject);
		return new ModelAndView("pc/zx-view/zx-project/zx-project-detail");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_project 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxProject> zxProjectList = zxProjectService.getZxProjectListByCondition(condition);
		PageInfo<ZxProject> page = new PageInfo<ZxProject>(zxProjectList);
		return outPageBootStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectById(String id,HttpServletRequest request){
		ZxProject zxProject = zxProjectService.getZxProjectById(id);
		return outDataStr(zxProject);
	}
	/**
	* 添加
	* @param zx_project 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxProject(ZxProject zxProject,HttpServletRequest request){
		int i = 0;
		if(null != zxProject){
			zxProject.setId(UUID.toUUID());
			i=zxProjectService.addZxProject(zxProject);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_project 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxProject(ZxProject zxProject,HttpServletRequest request){
		int i = 0;
		if(null != zxProject){
			i=zxProjectService.updateZxProject(zxProject);
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
	@RequestMapping(value="/delZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxProject(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxProjectService.delZxProject(condition);
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
	@RequestMapping(value="/copyZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxProject(String id,HttpServletRequest request){
		int i = 0;
		ZxProject zxProject = zxProjectService.getZxProjectById(id);
		if(null != zxProject){
			zxProject.setId(UUID.toUUID());
			i=zxProjectService.addZxProject(zxProject);
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
	@RequestMapping(value="/exportZxProject",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxProject(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}

	/**
	 * 查找项目集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getZxProjectList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectList(){
		List<ZxProject> zxProjectList = zxProjectService.getZxProjectListByCondition(null);
		return outItemsStr(zxProjectList);
	}
	
	/**
	 * 获取静态项目及工件组成的树
	 * @param id
	 * @param type
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getStaticProjectAndWorkpieceTreeGrid",method={RequestMethod.POST,RequestMethod.GET})
	public String getStaticProjectAndWorkpieceTreeGrid(String id,String type,HttpServletRequest request){
		Map<String, Object> condition = new HashMap<String, Object>();
		List<ZxProject> zxProjectList = new ArrayList<ZxProject>();
		if(StringUtils.isNotBlank(id) && !id.equals("0")){
			zxProjectList.add(zxProjectService.getZxProjectById(id));
		}else{
			zxProjectList = zxProjectService.getZxProjectListByCondition(null);
		}
		List<ZxWorkpiece> zxWorkpieceList = zxWorkpieceService.getZxWorkpieceListByCondition(condition);
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		for(int i = 0; i < zxProjectList.size(); i++){
			ZxProject zxProject = zxProjectList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxProject.getId());
			BaseTreeGridEntity.setPid("0");
			BaseTreeGridEntity.setText(zxProject.getName());
			BaseTreeGridEntity.setExpanded(false);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setTempObject("项目");
			BaseTreeGridEntity.setContent("");
			BaseTreeGridEntity.setIntegerappend(zxProject.getId()+"@"+zxProject.getName());
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
			for(int j = 0; j < zxWorkpieceList.size(); j++){
				ZxWorkpiece zxWorkpiece = zxWorkpieceList.get(j);
				BaseTreeGridEntity = new BaseTreeGridEntity();
				BaseTreeGridEntity.setId(zxWorkpiece.getId());
				BaseTreeGridEntity.setPid(zxWorkpiece.getProject_id());
				BaseTreeGridEntity.setText(zxWorkpiece.getName());
				BaseTreeGridEntity.setExpanded(false);
				BaseTreeGridEntity.setSingleClickExpand(true);
				BaseTreeGridEntity.setTempObject("工件");
				BaseTreeGridEntity.setIcon("../deng/images/icons/target_point.png");
				BaseTreeGridEntity.setContent(zxWorkpiece.getNum()+"_"+zxWorkpiece.getUnit());
				BaseTreeGridEntity.setIntegerappend(zxWorkpiece.getProject_id()+"@"+zxWorkpiece.getProject_name());
				list.add(BaseTreeGridEntity);
			}
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
}
