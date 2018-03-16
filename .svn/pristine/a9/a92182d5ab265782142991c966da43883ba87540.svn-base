package jehc.zxmodules.web;
import java.util.ArrayList;
import java.util.Date;
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
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.service.ZxMaterialClassifyService;
import jehc.zxmodules.service.ZxOfficeClassifyService;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 物料分类 
* 2017-08-30 08:30:12  陈运芝
*/
@Controller
@RequestMapping("/zxMaterialClassifyController")
public class ZxMaterialClassifyController extends BaseAction{
	@Autowired
	private ZxMaterialClassifyService zxMaterialClassifyService;
	@Autowired
	private ZxOfficeClassifyService zxOfficeClassifyService;
	/**
	* 载入初始化页面
	* @param zx_material_classify 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMaterialClassify(ZxMaterialClassify zxMaterialClassify,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-material-classify/zx-material-classify-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_material_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMaterialClassifyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMaterialClassifyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyListByCondition(condition);
		PageInfo<ZxMaterialClassify> page = new PageInfo<ZxMaterialClassify>(zxMaterialClassifyList);
		return outPageStr(page,request);
	}

	/**
	 * 读取分类树
	 * @param xt_departinfo_id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getZxMaterialClassifyTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getXtDepartinfoTree(String id,HttpServletRequest request){
		Map<String, Object> condition = new HashMap<String, Object>();
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyListAll(condition);
		for(int i = 0; i < zxMaterialClassifyList.size(); i++){
			ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxMaterialClassify.getClassify_id());
			BaseTreeGridEntity.setPid(zxMaterialClassify.getClassify_parentId());
			BaseTreeGridEntity.setText(zxMaterialClassify.getClassify_short_name());
			BaseTreeGridEntity.setTempObject(zxMaterialClassify.getClassify_num());
			BaseTreeGridEntity.setExpanded(true);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
	
	/**
	 * 读取所有分类列表
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/getZxMaterialClassifyList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMaterialClassifyList(HttpServletRequest request, HttpServletResponse response){
		//1获取所有菜单
		Map<String, Object> condition = new HashMap<String, Object>();
		String expanded = request.getParameter("expanded");
		String singleClickExpand = request.getParameter("singleClickExpand");
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyListAll(condition);
		zxOfficeClassifyService.test();
		for(int j = 0; j < zxMaterialClassifyList.size(); j++){
			ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyList.get(j);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxMaterialClassify.getClassify_id());
			BaseTreeGridEntity.setPid(zxMaterialClassify.getClassify_parentId());
			BaseTreeGridEntity.setText(zxMaterialClassify.getClassify_short_name());
			BaseTreeGridEntity.setContent(zxMaterialClassify.getClassify_isdelete());
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			BaseTreeGridEntity.setTempObject(zxMaterialClassify.getClassify_name()+","+zxMaterialClassify.getClassify_num());
			if(("true").equals(expanded)){
				BaseTreeGridEntity.setExpanded(true);
			}else{
				BaseTreeGridEntity.setExpanded(false);
			}
			if("true".equals(singleClickExpand)){
				BaseTreeGridEntity.setSingleClickExpand(true);
			}else{
				BaseTreeGridEntity.setSingleClickExpand(false);
			}
			list.add(BaseTreeGridEntity);
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
	
	/**
	* 获取对象
	* @param classify_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMaterialClassifyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMaterialClassifyById(String classify_id,HttpServletRequest request){
		ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyService.getZxMaterialClassifyById(classify_id);
		return outDataStr(zxMaterialClassify);
	}
	/**
	* 添加
	* @param zx_material_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMaterialClassify(ZxMaterialClassify zxMaterialClassify,HttpServletRequest request){
		int i = 0;
		if(null != zxMaterialClassify){
			zxMaterialClassify.setClassify_id(UUID.toUUID());
			zxMaterialClassify.setClassify_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxMaterialClassifyService.addZxMaterialClassify(zxMaterialClassify);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_material_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMaterialClassify(ZxMaterialClassify zxMaterialClassify,HttpServletRequest request){
		int i = 0;
		if(null != zxMaterialClassify){
			zxMaterialClassify.setClassify_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			i=zxMaterialClassifyService.updateZxMaterialClassify(zxMaterialClassify);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 删除
	* @param classify_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMaterialClassify(String classify_id,HttpServletRequest request){
		int i = 0;
		if(null != classify_id && !"".equals(classify_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("classify_id",classify_id.split(","));
			i=zxMaterialClassifyService.delZxMaterialClassify(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 复制一行并生成记录
	* @param classify_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/copyZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMaterialClassify(String classify_id,HttpServletRequest request){
		int i = 0;
		ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyService.getZxMaterialClassifyById(classify_id);
		if(null != zxMaterialClassify){
			zxMaterialClassify.setClassify_id(UUID.toUUID());
			i=zxMaterialClassifyService.addZxMaterialClassify(zxMaterialClassify);
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
	@RequestMapping(value="/exportZxMaterialClassify",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMaterialClassify(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
