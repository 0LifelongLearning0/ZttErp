package jehc.zxmodules.web;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.base.BaseTreeGridEntity;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxMaterial;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.service.ZxMaterialService;
import jehc.zxmodules.service.ZxOfficeClassifyService;
import jehc.zxmodules.service.ZxOfficeService;

/**
* 办公用品分类 
* 2017-11-30 08:41:46  季建吉
*/
@Controller
@RequestMapping("/zxOfficeClassifyController")
public class ZxOfficeClassifyController extends BaseAction{
	@Autowired
	private ZxOfficeService zxOfficeService;
	@Autowired
	private ZxOfficeClassifyService zxOfficeClassifyService;
	/**
	* 载入初始化页面
	* @param zx_office_classify 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOfficeClassify(ZxOfficeClassify zxOfficeClassify,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-office-classify/zx-office-classify-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_office_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeClassifyListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeClassifyListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOfficeClassify> zxOfficeClassifyList = zxOfficeClassifyService.getZxOfficeClassifyListByCondition(condition);
		PageInfo<ZxOfficeClassify> page = new PageInfo<ZxOfficeClassify>(zxOfficeClassifyList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param classify_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeClassifyById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeClassifyById(String classify_id,HttpServletRequest request){
		ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyService.getZxOfficeClassifyById(classify_id);
		return outDataStr(zxOfficeClassify);
	}
	
	/**
	* 加载初始化列表数据并分页
	* @param zx_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOffice> zxOfficeList = zxOfficeService.getZxOfficeListByCondition(condition);
		PageInfo<ZxOffice> page = new PageInfo<ZxOffice>(zxOfficeList);
		return outPageStr(page,request);
	}
	
	/**
	 * 读取分类树
	 * @param xt_departinfo_id
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getZxOfficeClassifyTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeClassifyTree(String id,HttpServletRequest request){
		Map<String, Object> condition = new HashMap<String, Object>();
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		List<ZxOfficeClassify> zxOfficeClassifyList = zxOfficeClassifyService.getZxOfficeClassifyListAll(condition);
		for(int i = 0; i < zxOfficeClassifyList.size(); i++){
			ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxOfficeClassify.getClassify_id());
			BaseTreeGridEntity.setPid(zxOfficeClassify.getClassify_parentId());
			BaseTreeGridEntity.setTempObject(zxOfficeClassify.getClassify_num());
			BaseTreeGridEntity.setText(zxOfficeClassify.getClassify_name());
			BaseTreeGridEntity.setExpanded(true);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
		}
		System.out.println(BaseTreeGridEntity.buildTree(list,false));
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
	/**
	 * 读取所有分类列表
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/getZxOfficeClassifyList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeClassifyList(HttpServletRequest request, HttpServletResponse response){
		//1获取所有菜单
		Map<String, Object> condition = new HashMap<String, Object>();
		String expanded = request.getParameter("expanded");
		String singleClickExpand = request.getParameter("singleClickExpand");
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		
		List<ZxOfficeClassify> zxOfficeClassifyList = zxOfficeClassifyService.getZxOfficeClassifyListAll(condition);
		//zxOfficeClassifyService.test();
		for(int j = 0; j < zxOfficeClassifyList.size(); j++){
			ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyList.get(j);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxOfficeClassify.getClassify_id());
			BaseTreeGridEntity.setPid(zxOfficeClassify.getClassify_parentId());
			BaseTreeGridEntity.setText(zxOfficeClassify.getClassify_name());
			BaseTreeGridEntity.setContent(zxOfficeClassify.getClassify_isdelete());
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			BaseTreeGridEntity.setTempObject(zxOfficeClassify.getClassify_name()+","+zxOfficeClassify.getClassify_num());
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
	* 添加
	* @param zx_office_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOfficeClassify(ZxOfficeClassify zxOfficeClassify,HttpServletRequest request){
		int i = 0;
		int j=0;
		//读取分类
		if(zxOfficeClassifyService.getZxOfficeClassifyByParent(zxOfficeClassify)){
			if(null != zxOfficeClassify && !"".equals(zxOfficeClassify)){
				zxOfficeClassify.setClassify_id(UUID.toUUID());
				zxOfficeClassify.setClassify_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				zxOfficeClassify.setClassify_leaf("1");
				i=zxOfficeClassifyService.addZxOfficeClassify(zxOfficeClassify);
				if(!"0".equals(zxOfficeClassify.getClassify_parentId())){
					//子页修改为0
					j=zxOfficeClassifyService.updateZxOfficeClassifyLeaf(zxOfficeClassify);
				}
				else{
					j=1;
				}
				
			}
		}else{
			j=4;
		}
		
		if(i>0&&j==1){
			return outAudStr(true);
		}else if(j==4){
			return "{success:false,msg:'分类不能同名',responseFlag:false}";
		}else{
			return outAudStr(false);
		}
		
	}
	
	/**
	* 修改
	* @param zx_office_classify 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOfficeClassify(ZxOfficeClassify zxOfficeClassify,HttpServletRequest request){
		int i = 0;
		if(null != zxOfficeClassify && !"".equals(zxOfficeClassify)){
			i=zxOfficeClassifyService.updateZxOfficeClassify(zxOfficeClassify);
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
	@RequestMapping(value="/delZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOfficeClassify(String classify_id,HttpServletRequest request){
		int i = 0;
		if(null != classify_id && !"".equals(classify_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("classify_id",classify_id.split(","));
			i=zxOfficeClassifyService.delZxOfficeClassify(condition);
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
	@RequestMapping(value="/copyZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOfficeClassify(String classify_id,HttpServletRequest request){
		int i = 0;
		ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyService.getZxOfficeClassifyById(classify_id);
		if(null != zxOfficeClassify && !"".equals(zxOfficeClassify)){
			zxOfficeClassify.setClassify_id(UUID.toUUID());
			i=zxOfficeClassifyService.addZxOfficeClassify(zxOfficeClassify);
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
	@RequestMapping(value="/exportZxOfficeClassify",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOfficeClassify(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
