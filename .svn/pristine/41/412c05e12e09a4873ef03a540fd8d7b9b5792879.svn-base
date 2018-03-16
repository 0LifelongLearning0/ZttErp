package jehc.zxmodules.web ;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.allutils.AllUtils;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtDepartinfo;
import jehc.xtmodules.xtmodel.XtPost;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.model.ZxMaterial;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.service.ZxOfficeClassifyService;
import jehc.zxmodules.service .ZxOfficeService;

/**
* 办公用品管理 
* 2017-11-30 08:19:19  季建吉
*/
@Controller
@RequestMapping("/zxOfficeController")
public class ZxOfficeController extends BaseAction{
	@Autowired
	private ZxOfficeService zxOfficeService;
	@Autowired
	private ZxOfficeClassifyService zxOfficeClassifyService;
	/**
	* 载入初始化页面
	* @param zx_office 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxOffice(ZxOffice zxOffice,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-office/zx-office-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_office 
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
	 * 获取动态物料组成的树
	 * @param id
	 * @param type
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value="/getOfficeTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getOfficeTree(String id,String type,HttpServletRequest request) throws UnsupportedEncodingException{
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
			List<ZxOffice> zxOfficeList = zxOfficeService.getZxOfficeListByCondition(condition);
			//拼接字符串
			for(int i = 0; i < zxOfficeList.size(); i++){
				ZxOffice zxMaterial = zxOfficeList.get(i);
				String leaf = "true";
				if(i==(zxOfficeList.size()-1)){
					jsonStr.append("{id:'"+zxMaterial.getOffice_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getName()+"',icon:'../deng/images/icons/users.png',type:'用品',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getNum()+"',classify_id:'"+zxMaterial.getClassify_id()+"'}");  
				}else{
					jsonStr.append("{id:'"+zxMaterial.getOffice_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getName()+"',icon:'../deng/images/icons/users.png',type:'用品',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getNum()+"',classify_id:'"+zxMaterial.getClassify_id()+"'},");
				}
			}
		}
		return jsonStr.toString();
	}
	
	/**
	* 获取对象
	* @param office_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxOfficeById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeById(String office_id,HttpServletRequest request){
		ZxOffice zxOffice = zxOfficeService.getZxOfficeById(office_id);
		return outDataStr(zxOffice);
	}
	/**
	* 添加
	* @param zx_office 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxOffice(ZxOffice zxOffice,HttpServletRequest request){
		int i = 0;
		int j=0;
		if(zxOffice.getClassify_id().contains(","))
		{
			zxOffice.setClassify_id(zxOffice.getClassify_id().substring(0, zxOffice.getClassify_id().length()-1));
		}
		String classify_id=zxOffice.getClassify_id();
		String is_leaf=zxOfficeClassifyService.getZxOfficeClassifyById(classify_id).getClassify_leaf();
		if(is_leaf.equals("0")){
			j=2;
		}else{
			if(null != zxOffice && !"".equals(zxOffice)){
				if(zxOffice.getClassify_id().contains(","))
				{
					zxOffice.setClassify_id(zxOffice.getClassify_id().substring(0, zxOffice.getClassify_id().length()-1));
				}
				zxOffice.setOffice_id(UUID.toUUID());
				zxOffice.setCreate_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				i=zxOfficeService.addZxOffice(zxOffice);
			}
		}
		
		if(i>0){
			return outAudStr(true);
		}else if(j==2){
			return outAudStrDiy(j);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_office 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxOffice(ZxOffice zxOffice,HttpServletRequest request){
		int i = 0;
		int j=0;
		if(zxOffice.getClassify_id().contains(","))
		{
			zxOffice.setClassify_id(zxOffice.getClassify_id().substring(0, zxOffice.getClassify_id().length()-1));
		}
		String classify_id=zxOffice.getClassify_id();
		String is_leaf=zxOfficeClassifyService.getZxOfficeClassifyById(classify_id).getClassify_leaf();
		if(is_leaf.equals("0")){
			j=2;
		}else{
			if(null != zxOffice && !"".equals(zxOffice)){
				i=zxOfficeService.updateZxOffice(zxOffice);
			}
		}
		
		if(i>0){
			return outAudStr(true);
		}else if(j==2){
			return outAudStrDiy(j);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	 * 自定义输出添加删除修改结果JSON格式字符串
	 * @param flag
	 * @param msg
	 */
	protected String outAudStrDiy(int j){
		if(j==0){
			return "{success:true,msg:'"+CommonUtils.getCacheStr("sys_operate_sucess")+"',responseFlag:true}";
		}if(j==1){
			return "{success:false,msg:'"+CommonUtils.getCacheStr("sys_operate_error")+"',responseFlag:false}";
		}if(j==2){
			return "{success:false,msg:'只能选择子类分类',responseFlag:false}";
		}else{
			return null;
		}
		
	}
	/**
	* 删除
	* @param office_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxOffice(String office_id,HttpServletRequest request){
		int i = 0;
		if(null != office_id && !"".equals(office_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("office_id",office_id.split(","));
			i=zxOfficeService.delZxOffice(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 复制一行并生成记录
	* @param office_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/copyZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxOffice(String office_id,HttpServletRequest request){
		int i = 0;
		ZxOffice zxOffice = zxOfficeService.getZxOfficeById(office_id);
		if(null != zxOffice && !"".equals(zxOffice)){
			zxOffice.setOffice_id(UUID.toUUID());
			i=zxOfficeService.addZxOffice(zxOffice);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	
	/**
	* 加载初始化列表数据
	* @param xt_userinfo 
	* @param request 
	 * @throws UnsupportedEncodingException 
	*/
	/*@ResponseBody
	@RequestMapping(value="/getZxOfficeinfoListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxOfficeinfoListByCondition(String xt_classfy_id,String xt_post_id,String xt_userinfo_realName,HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> condition = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(xt_classfy_id)){
			String depId = URLDecoder.decode(xt_classfy_id, "UTF-8");
			Map<String, Object> conditionD = new HashMap<String, Object>();
			conditionD.put("xt_departinfo_parentId", depId);
			List<XtDepartinfo> dchild = xtDepartinfoService.getXtDepartinfoListChild(conditionD);
			String[] depIds = null;
			if(null != dchild && dchild.size() > 0){
				depIds = new String[dchild.size()+1];
				for(int i=0;i<dchild.size();i++){
					depIds[i+1] = dchild.get(i).getXt_departinfo_id();
				}
			}else{
				depIds = new String[1];
			}
			depIds[0] = depId;
			depId = queryInStr(depIds);
			condition.put("xt_departinfo_id", depId);
		}
		if(StringUtils.isNotBlank(xt_post_id)){
			String postId = URLDecoder.decode(xt_post_id, "UTF-8");
			Map<String, Object> conditionP = new HashMap<String, Object>();
			conditionP.put("xt_post_parentId", postId);
			List<XtPost> pchild = xtPostService.getXtPostListChild(conditionP);
			String[] postIds = null;
			if(null != pchild && pchild.size() > 0){
				postIds = new String[pchild.size()+1];
				for(int i=0;i<pchild.size();i++){
					postIds[i+1] = pchild.get(i).getXt_post_id();
				}
			}else{
				postIds = new String[1];
			}
			postIds[0] = postId;
			postId = queryInStr(postIds);
			condition.put("xt_post_id", postId);
		}
		if(StringUtils.isNotBlank(xt_userinfo_realName)){
			condition.put("xt_userinfo_realName", URLDecoder.decode(xt_userinfo_realName, "UTF-8"));
		}
		List<XtUserinfo>XtUserinfoList = xtUserinfoService.getXtUserinfoListByCondition(condition);
		for(XtUserinfo XtUserinfo : XtUserinfoList){
			XtUserinfo.setXt_userinfo_card(AllUtils.getPinYinHeadChar(XtUserinfo.getXt_userinfo_realName()).substring(0, 1).toUpperCase());
		}
		return outItemsStr(XtUserinfoList);
	}*/
	/**
	* 导出
	* @param excleData 
	* @param excleHeader 
	* @param excleText 
	* @param request 
	* @param request 
	*/
	@RequestMapping(value="/exportZxOffice",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxOffice(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
}
