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
import jehc.zxmodules.model.ZxMachine;
import jehc.zxmodules.service.ZxMachineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 加工单位 
* 2017-08-28 17:21:04  陈运芝
*/
@Controller
@RequestMapping("/zxMachineController")
public class ZxMachineController extends BaseAction{
	@Autowired
	private ZxMachineService zxMachineService;
	/**
	* 载入初始化页面
	* @param zx_machine 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMachine(ZxMachine zxMachine,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-machine/zx-machine-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_machine 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMachineListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMachineListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxMachine> zxMachineList = zxMachineService.getZxMachineListByCondition(condition);
		PageInfo<ZxMachine> page = new PageInfo<ZxMachine>(zxMachineList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMachineById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMachineById(String id,HttpServletRequest request){
		ZxMachine zxMachine = zxMachineService.getZxMachineById(id);
		return outDataStr(zxMachine);
	}
	/**
	* 添加
	* @param zx_machine 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMachine(ZxMachine zxMachine,HttpServletRequest request){
		int i = 0;
		if(null != zxMachine){
			zxMachine.setId(UUID.toUUID());
			i=zxMachineService.addZxMachine(zxMachine);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_machine 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMachine(ZxMachine zxMachine,HttpServletRequest request){
		int i = 0;
		if(null != zxMachine){
			i=zxMachineService.updateZxMachine(zxMachine);
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
	@RequestMapping(value="/delZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMachine(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxMachineService.delZxMachine(condition);
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
	@RequestMapping(value="/copyZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMachine(String id,HttpServletRequest request){
		int i = 0;
		ZxMachine zxMachine = zxMachineService.getZxMachineById(id);
		if(null != zxMachine){
			zxMachine.setId(UUID.toUUID());
			i=zxMachineService.addZxMachine(zxMachine);
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
	@RequestMapping(value="/exportZxMachine",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMachine(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}

	/**
	 * 获取静态加工单位组成的树
	 * @param id
	 * @param type
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getStaticMachineTreeGrid",method={RequestMethod.POST,RequestMethod.GET})
	public String getStaticMachineTreeGrid(String id,String type,HttpServletRequest request){
		List<ZxMachine> zxMachineList = zxMachineService.getZxMachineListByCondition(null);
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		for(int i = 0; i < zxMachineList.size(); i++){
			ZxMachine zxMachine = zxMachineList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxMachine.getId());
			BaseTreeGridEntity.setPid("0");
			BaseTreeGridEntity.setText(zxMachine.getName());
			BaseTreeGridEntity.setExpanded(false);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setTempObject("");
			BaseTreeGridEntity.setContent("");
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
}
