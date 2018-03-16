package jehc.zxmodules.web;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
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
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxOfficeInventoryShow;
import jehc.zxmodules.service.ZxOfficeApplyService;
import jehc.zxmodules.service.ZxOfficeClassifyService;
import jehc.zxmodules.service.ZxOfficeInventoryService;
import jehc.zxmodules.service.ZxOfficeService;

/**
* 办公用品库存表 
* 2017-12-06 11:20:49  季建吉
*/
@Controller
@RequestMapping("/zxOfficeInventoryController")
public class ZxOfficeInventoryController extends BaseAction{
	@Autowired
	private ZxOfficeInventoryService zxOfficeInventoryService;
	@Autowired
	private ZxOfficeApplyService zxOfficeApplyService;
	@Autowired
	private ZxOfficeClassifyService zxOfficeClassifyService;
	@Autowired
	private ZxOfficeService zxOfficeService;
	/**
	* 载入初始化页面
	* @param zx_office_inventory 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOfficeInventory(ZxOfficeInventory zxOfficeInventory,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-office-inventory/zx-office-inventory-list");
	}
	/**
	* 库存用品右边目录
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeInventoryListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeInventoryListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxOfficeInventoryShow> zxOfficeInventoryList = zxOfficeInventoryService.getZxOfficeInventoryListByCondition(condition);
		PageInfo<ZxOfficeInventoryShow> page = new PageInfo<ZxOfficeInventoryShow>(zxOfficeInventoryList);
		return outPageStr(page,request);
	}
	
	/**
	* 库存管理用品树
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeInventoryListclick",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeInventoryListclick(BaseSearch baseSearch,HttpServletRequest request){
		List<ZxOfficeInventoryShow> zxOfficeInventoryList=new ArrayList<ZxOfficeInventoryShow>();
		String id=baseSearch.getSearchJson();
		Map<String, Object> condition = baseSearch.convert();
		id=id.substring(1, id.length()-1);
		if("0".equals(id)){
			zxOfficeInventoryList=zxOfficeInventoryService.getZxOfficeInventoryListByCondition(condition);
		}else{
			zxOfficeInventoryList= zxOfficeInventoryService.getZxOfficeInventoryClick(id);
		}
		PageInfo<ZxOfficeInventoryShow> page = new PageInfo<ZxOfficeInventoryShow>(zxOfficeInventoryList);
		return outPageStr(page,request);
	}
	/**
	* 根据id 补充信息
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeInventoryAddById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeInventoryAddById(String id,HttpServletRequest request){
		ZxOfficeInventoryShow zxOfficeInventoryShow = zxOfficeInventoryService.getZxOfficeInventoryAddById(id);
		return outDataStr(zxOfficeInventoryShow);
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeInventoryTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeInventoryTree(String id,String type,HttpServletRequest request)throws UnsupportedEncodingException{
		id = request.getParameter("node");
		type = URLDecoder.decode(type, "UTF-8");
		StringBuffer jsonStr = new StringBuffer("");  
		if(null != id && !"".equals(id) && "0".equals(id)){
			jsonStr.append("[");
			List<ZxOfficeClassify> zxOfficeClassifyList = (List<ZxOfficeClassify>) zxOfficeClassifyService.getZxOfficeClassifyByList();
			for(int i = 0; i < zxOfficeClassifyList.size(); i++){
				ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyList.get(i);
				if(i==(zxOfficeClassifyList.size()-1)){
					jsonStr.append("{id:'"+zxOfficeClassify.getClassify_id()+"',text:'"+zxOfficeClassify.getClassify_name()+"',num:'"+zxOfficeClassify.getClassify_num()+"',icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxOfficeClassify.getClassify_parentId()+"',type:'分类'}");  
				}else{
					jsonStr.append("{id:'"+zxOfficeClassify.getClassify_id()+"',text:'"+zxOfficeClassify.getClassify_name()+"',num:'"+zxOfficeClassify.getClassify_num()+"',icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxOfficeClassify.getClassify_parentId()+"',type:'分类'},");
				}
			}
			jsonStr.append("]");
		}else{
			//1查找分类
			jsonStr.append("[");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("classify_parentId", id);
			List<ZxOfficeClassify> zxOfficeClassifyList = zxOfficeClassifyService.getZxOfficeClassifyListAllChild(condition);
			for(int i = 0; i < zxOfficeClassifyList.size(); i++){
				ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyList.get(i);
				String leaf = "false";
				/*if(zxOfficeClassify.getClassify_leaf().equals("0")){
					leaf = "false";
				}else{
					leaf = "true";
				}*/
				if(i==(zxOfficeClassifyList.size()-1)){
					jsonStr.append("{id:'"+zxOfficeClassify.getClassify_id()+"',text:'"+zxOfficeClassify.getClassify_name()+"',num:'"+zxOfficeClassify.getClassify_num()+"',leaf:"+leaf+",icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxOfficeClassify.getClassify_parentId()+"',type:'分类'}");  
				}else{
					jsonStr.append("{id:'"+zxOfficeClassify.getClassify_id()+"',text:'"+zxOfficeClassify.getClassify_name()+"',num:'"+zxOfficeClassify.getClassify_num()+"',leaf:"+leaf+",icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxOfficeClassify.getClassify_parentId()+"',type:'分类'},");  
				}
			}
			//2查找分类下面物料
			String zxOfficeStr = zxOfficeStr(id,type);
			if(null != zxOfficeStr && !"".equals(zxOfficeStr) && !"[".equals(jsonStr.toString())){
				jsonStr.append(","+zxOfficeStr);
			}else{
				jsonStr.append(zxOfficeStr);
			}
			jsonStr.append("]");
		}
		return outStr(jsonStr.toString());
	}
	
	/**
	 * 返回物料字符串
	 * @param id
	 * @return
	 */
	public String zxOfficeStr(String id,String type){
		//如果类型:分类 则查出所有分类下物料
		StringBuffer jsonStr = new StringBuffer(); 
		Map<String, Object> condition = new HashMap<String, Object>();
		if(null != type && !"".equals(type) && "分类".equals(type)){
			condition = new HashMap<String, Object>();
			condition.put("classify_id", id);
			List<ZxOfficeInventoryShow> zxOfficeList = zxOfficeInventoryService.getZxOfficeInventoryListByCondition(condition);
			//拼接字符串
			for(int i = 0; i < zxOfficeList.size(); i++){
				ZxOfficeInventoryShow zxMaterial = zxOfficeList.get(i);
				String leaf = "true";
				if(i==(zxOfficeList.size()-1)){
					jsonStr.append("{id:'"+zxMaterial.getOffice_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getOffice_name()+"',icon:'../deng/images/icons/users.png',type:'用品',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getOffice_num()+"',amount:'"+zxMaterial.getAmount()+"',classify_id:'"+zxMaterial.getClassify_id()+"'}");  
				}else{
					jsonStr.append("{id:'"+zxMaterial.getOffice_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getOffice_name()+"',icon:'../deng/images/icons/users.png',type:'用品',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getOffice_num()+"',amount:'"+zxMaterial.getAmount()+"',classify_id:'"+zxMaterial.getClassify_id()+"'},");
				}
			}
		}
		return jsonStr.toString();
	}
	
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeInventoryById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeInventoryById(String id,HttpServletRequest request){
		ZxOfficeInventory zxOfficeInventory = zxOfficeInventoryService.getZxOfficeInventoryById(id);
		return outDataStr(zxOfficeInventory);
	}
	/**
	* 添加
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOfficeInventory(ZxOfficeInventoryShow zxOfficeInventory,HttpServletRequest request){
		int i = 0;
		if(null != zxOfficeInventory && !"".equals(zxOfficeInventory)){
			/*库存表添加*/
			zxOfficeInventory.setId(UUID.toUUID());
			i=zxOfficeInventoryService.addZxOfficeInventory(zxOfficeInventory);
			/*补充表添加*/
			
			i=zxOfficeInventoryService.addZxOfficeInventoryAdd(zxOfficeInventory);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_office_inventory 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOfficeInventory(ZxOfficeInventory zxOfficeInventory,HttpServletRequest request){
		int i = 0;
		if(null != zxOfficeInventory && !"".equals(zxOfficeInventory)){
			i=zxOfficeInventoryService.updateZxOfficeInventory(zxOfficeInventory);
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
	@RequestMapping(value="/delZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOfficeInventory(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxOfficeInventoryService.delZxOfficeInventory(condition);
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
	/*@ResponseBody
	@RequestMapping(value="/copyZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOfficeInventory(String id,HttpServletRequest request){
		int i = 0;
		ZxOfficeInventoryShow zxOfficeInventory = zxOfficeInventoryService.getZxOfficeInventoryById(id);
		if(null != zxOfficeInventory && !"".equals(zxOfficeInventory)){
			zxOfficeInventory.setId(UUID.toUUID());
			i=zxOfficeInventoryService.addZxOfficeInventory(zxOfficeInventory);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}*/
	/**
	* 导出
	* @param excleData 
	* @param excleHeader 
	* @param excleText 
	* @param request 
	* @param request 
	*/
	@RequestMapping(value="/exportZxOfficeInventory",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOfficeInventory(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
