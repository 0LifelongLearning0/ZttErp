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
import jehc.zxmodules.model.ZxProcess;
import jehc.zxmodules.service.ZxProcessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 工序管理 
* 2017-09-07 22:43:21  陈运芝
*/
@Controller
@RequestMapping("/zxProcessController")
public class ZxProcessController extends BaseAction{
	@Autowired
	private ZxProcessService zxProcessService;
	/**
	* 载入初始化页面
	* @param zx_process 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxProcess(ZxProcess zxProcess,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-process/zx-process-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_process 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProcessListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProcessListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxProcess> zxProcessList = zxProcessService.getZxProcessListByCondition(condition);
		PageInfo<ZxProcess> page = new PageInfo<ZxProcess>(zxProcessList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProcessById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProcessById(String id,HttpServletRequest request){
		ZxProcess zxProcess = zxProcessService.getZxProcessById(id);
		return outDataStr(zxProcess);
	}
	/**
	* 添加
	* @param zx_process 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxProcess(ZxProcess zxProcess,HttpServletRequest request){
		int i = 0;
		if(null != zxProcess){
			zxProcess.setId(UUID.toUUID());
			i=zxProcessService.addZxProcess(zxProcess);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_process 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxProcess(ZxProcess zxProcess,HttpServletRequest request){
		int i = 0;
		if(null != zxProcess){
			i=zxProcessService.updateZxProcess(zxProcess);
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
	@RequestMapping(value="/delZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxProcess(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxProcessService.delZxProcess(condition);
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
	@RequestMapping(value="/copyZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxProcess(String id,HttpServletRequest request){
		int i = 0;
		ZxProcess zxProcess = zxProcessService.getZxProcessById(id);
		if(null != zxProcess){
			zxProcess.setId(UUID.toUUID());
			i=zxProcessService.addZxProcess(zxProcess);
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
	@RequestMapping(value="/exportZxProcess",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxProcess(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	

	/**
	 * 获取静态工序组成的树
	 * @param id
	 * @param type
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getStaticProcessTreeGrid",method={RequestMethod.POST,RequestMethod.GET})
	public String getStaticProcessTreeGrid(HttpServletRequest request){
		List<ZxProcess> zxProcessList = zxProcessService.getZxProcessListByCondition(null);
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		for(int i = 0; i < zxProcessList.size(); i++){
			ZxProcess zxProcess = zxProcessList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxProcess.getId());
			BaseTreeGridEntity.setPid("0");
			BaseTreeGridEntity.setText(zxProcess.getName());
			BaseTreeGridEntity.setExpanded(false);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setTempObject("工序");
			BaseTreeGridEntity.setIntegerappend(zxProcess.getId()+"@"+zxProcess.getName());
			list.add(BaseTreeGridEntity);
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
}
