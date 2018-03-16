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
import jehc.zxmodules.model.ZxConcordat;
import jehc.zxmodules.service.ZxConcordatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 合同管理 
* 2017-08-31 17:21:48  陈运芝
*/
@Controller
@RequestMapping("/zxConcordatController")
public class ZxConcordatController extends BaseAction{
	@Autowired
	private ZxConcordatService zxConcordatService;
	/**
	* 载入初始化页面
	* @param zx_concordat 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxConcordat(ZxConcordat zxConcordat,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-concordat/zx-concordat-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_concordat 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxConcordatListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxConcordatListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxConcordat> zxConcordatList = zxConcordatService.getZxConcordatListByCondition(condition);
		PageInfo<ZxConcordat> page = new PageInfo<ZxConcordat>(zxConcordatList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxConcordatById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxConcordatById(String id,HttpServletRequest request){
		ZxConcordat zxConcordat = zxConcordatService.getZxConcordatById(id);
		return outDataStr(zxConcordat);
	}
	/**
	* 添加
	* @param zx_concordat 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxConcordat(ZxConcordat zxConcordat,HttpServletRequest request){
		int i = 0;
		if(null != zxConcordat){
			zxConcordat.setId(UUID.toUUID());
			i=zxConcordatService.addZxConcordat(zxConcordat);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_concordat 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxConcordat(ZxConcordat zxConcordat,HttpServletRequest request){
		int i = 0;
		if(null != zxConcordat){
			i=zxConcordatService.updateZxConcordat(zxConcordat);
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
	@RequestMapping(value="/delZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxConcordat(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxConcordatService.delZxConcordat(condition);
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
	@RequestMapping(value="/copyZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxConcordat(String id,HttpServletRequest request){
		int i = 0;
		ZxConcordat zxConcordat = zxConcordatService.getZxConcordatById(id);
		if(null != zxConcordat){
			zxConcordat.setId(UUID.toUUID());
			i=zxConcordatService.addZxConcordat(zxConcordat);
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
	@RequestMapping(value="/exportZxConcordat",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxConcordat(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	

	/**
	 * 获取静态合同组成的树
	 * @param id
	 * @param type
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getStaticConcordatTreeGrid",method={RequestMethod.POST,RequestMethod.GET})
	public String getStaticConcordatTreeGrid(HttpServletRequest request){
		List<ZxConcordat> zxConcordatList = zxConcordatService.getZxConcordatListByCondition(null);
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		for(int i = 0; i < zxConcordatList.size(); i++){
			ZxConcordat zxConcordat = zxConcordatList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxConcordat.getId());
			BaseTreeGridEntity.setPid("0");
			BaseTreeGridEntity.setText(zxConcordat.getNum());
			BaseTreeGridEntity.setExpanded(false);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setTempObject(zxConcordat.getName());
			BaseTreeGridEntity.setContent(zxConcordat.getDescriptiom());
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
}
