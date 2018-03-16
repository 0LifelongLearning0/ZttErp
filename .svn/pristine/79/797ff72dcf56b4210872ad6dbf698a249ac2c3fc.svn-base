package jehc.zxmodules.web;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxProcess;
import jehc.zxmodules.model.ZxProjectNode;
import jehc.zxmodules.model.ZxProjectWoking;
import jehc.zxmodules.model.ZxWorkpiece;
import jehc.zxmodules.service.ZxProcessService;
import jehc.zxmodules.service.ZxProjectNodeService;
import jehc.zxmodules.service.ZxProjectWokingService;
import jehc.zxmodules.service.ZxWorkpieceService;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 项目节点控制表 
* 2017-09-07 23:52:08  陈运芝
*/
@Controller
@RequestMapping("/zxProjectNodeController")
public class ZxProjectNodeController extends BaseAction{
	@Autowired
	private ZxWorkpieceService zxWorkpieceService;
	@Autowired
	private ZxProjectNodeService zxProjectNodeService;
	@Autowired
	private ZxProcessService zxProcessService;
	@Autowired
	private ZxProjectWokingService zxProjectWokingService;
	/**
	* 载入初始化页面
	* @param zx_project_node 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxProjectNode(ZxProjectNode zxProjectNode,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-project-node/zx-project-node-list");
	}

	/**
	* 载入初始化页面:仓库
	* @param zx_project_node 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxProjectNodeWarehouse",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxProjectNodeWarehouse(ZxProjectNode zxProjectNode,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-project-node/zx-project-node-warehouse-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_project_node 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectNodeListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectNodeListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxProjectNode> zxProjectNodeList = zxProjectNodeService.getZxProjectNodeListByCondition(condition);
		for(ZxProjectNode zxProjectNode:zxProjectNodeList){
			zxProjectNode.setItem(zxWorkpieceService.getZxWorkpieceById(zxProjectNode.getWorkpiece_id()));
			Map<String, Object> qcondition = new HashMap<String, Object>();
			qcondition.put("node_id", zxProjectNode.getId());
			List<ZxProjectWoking> zxProjectWoking = zxProjectWokingService.getZxProjectWokingListByCondition(qcondition);
			for(ZxProjectWoking woking : zxProjectWoking){
				woking.setItem(zxProcessService.getZxProcessById(woking.getProcess_id()));
			}
			zxProjectNode.setZxProjectWoking(zxProjectWoking);
		}
		PageInfo<ZxProjectNode> page = new PageInfo<ZxProjectNode>(zxProjectNodeList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxProjectNodeById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxProjectNodeById(String id,HttpServletRequest request){
		ZxProjectNode zxProjectNode = zxProjectNodeService.getZxProjectNodeById(id);
		String outStr = outDataStr(zxProjectNode);
		ZxWorkpiece workpiece = zxWorkpieceService.getZxWorkpieceById(zxProjectNode.getWorkpiece_id());
		JSONArray jsonArray = JSONArray.fromObject(workpiece); 
		String jsonStr = jsonArray.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"workpiece\":").concat(jsonStr)
				.concat(outStr.substring(outStr.length()-2,outStr.length()));
		StringBuffer stringBuffer = new StringBuffer(outStr);
		for(ZxProjectWoking node:zxProjectNode.getZxProjectWoking()){
			ZxProcess process = zxProcessService.getZxProcessById(node.getProcess_id());
			outStr = stringBuffer.insert(outStr.indexOf(process.getId()+"\"")+33, ",\"process_text\":\""+process.getName()+"\"").toString();
		}
		return outStr;
	}
	/**
	* 添加
	* @param zx_project_node 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxProjectNode(ZxProjectNode zxProjectNode,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectNode){
			zxProjectNode.setId(UUID.toUUID());
			i=zxProjectNodeService.addZxProjectNode(zxProjectNode);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_project_node 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxProjectNode(ZxProjectNode zxProjectNode,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectNode){
			i=zxProjectNodeService.updateZxProjectNode(zxProjectNode);
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
	@RequestMapping(value="/delZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxProjectNode(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxProjectNodeService.delZxProjectNode(condition);
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
	@RequestMapping(value="/copyZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxProjectNode(String id,HttpServletRequest request){
		int i = 0;
		ZxProjectNode zxProjectNode = zxProjectNodeService.getZxProjectNodeById(id);
		if(null != zxProjectNode){
			zxProjectNode.setId(UUID.toUUID());
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			List<ZxProjectWoking> zxProjectWokingList = zxProjectWokingService.getZxProjectWokingListByCondition(condition);
			zxProjectNode.setZxProjectWoking(zxProjectWokingList);
			i=zxProjectNodeService.addZxProjectNode(zxProjectNode);
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
	@RequestMapping(value="/exportZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxProjectNode(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}

	/**
	* 入库
	* @param zx_Out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/inZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String inZxProjectNode(ZxProjectNode zxProjectNode,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectNode){
			i=zxProjectNodeService.updateZxProjectNode(zxProjectNode);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 出库
	* @param zx_Out_progress 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/outZxProjectNode",method={RequestMethod.POST,RequestMethod.GET})
	public String outZxProjectNode(ZxProjectNode zxProjectNode,HttpServletRequest request){
		int i = 0;
		if(null != zxProjectNode){
			ZxProjectNode projectNode = zxProjectNodeService.getZxProjectNodeById(zxProjectNode.getId());
			BigDecimal outAmount = new BigDecimal(zxProjectNode.getOut_warehuse_amount());
			if(outAmount.compareTo(new BigDecimal(projectNode.getSingle_amount() * projectNode.getAll_amount())) == 0){
				zxProjectNode.setStatus("4");
			}
			i=zxProjectNodeService.updateZxProjectNode(zxProjectNode);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
