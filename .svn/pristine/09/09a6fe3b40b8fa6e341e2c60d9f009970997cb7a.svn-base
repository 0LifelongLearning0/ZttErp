package jehc.zxmodules.web;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseJson;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.base.BaseTreeGridEntity;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExcelReader;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtDataDictionary;
import jehc.zxmodules.model.ZxMaterial;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.service.ZxMaterialClassifyService;
import jehc.zxmodules.service.ZxMaterialService;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 物料管理 
* 2017-08-31 11:00:45  陈运芝
*/
@Controller
@RequestMapping("/zxMaterialController")
public class ZxMaterialController extends BaseAction{
	@Autowired
	private ZxMaterialService zxMaterialService;
	@Autowired
	private ZxMaterialClassifyService zxMaterialClassifyService;
	/**
	* 载入初始化页面
	* @param zx_material 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxMaterial(ZxMaterial zxMaterial,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-material/zx-material-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMaterialListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMaterialListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		List<ZxMaterial> zxMaterialList = zxMaterialService.getZxMaterialListByCondition(condition);
		PageInfo<ZxMaterial> page = new PageInfo<ZxMaterial>(zxMaterialList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param material_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxMaterialById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxMaterialById(String material_id,HttpServletRequest request){
		ZxMaterial zxMaterial = zxMaterialService.getZxMaterialById(material_id);
		return outDataStr(zxMaterial);
	}
	/**
	* 添加
	* @param zx_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxMaterial(ZxMaterial zxMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxMaterial){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("num", zxMaterial.getNum());
			List<ZxMaterial> list = zxMaterialService.getZxMaterialListByCondition(condition);
			if(null == list || list.size() == 0){
				zxMaterial.setMaterial_id(UUID.toUUID());
				zxMaterial.setCreate_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				i=zxMaterialService.addZxMaterial(zxMaterial);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxMaterial(ZxMaterial zxMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxMaterial){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("num", zxMaterial.getNum());
			List<ZxMaterial> list = zxMaterialService.getZxMaterialListByCondition(condition);
			if(null != list && list.size() > 0 && list.get(0).getMaterial_id().equals(zxMaterial.getMaterial_id())){
				i=zxMaterialService.updateZxMaterialBySelective(zxMaterial);
			}
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 删除
	* @param material_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxMaterial(String material_id,HttpServletRequest request){
		int i = 0;
		if(null != material_id && !"".equals(material_id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("material_id",material_id.split(","));
			i=zxMaterialService.delZxMaterial(condition);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 复制一行并生成记录
	* @param material_id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/copyZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxMaterial(String material_id,HttpServletRequest request){
		int i = 0;
		ZxMaterial zxMaterial = zxMaterialService.getZxMaterialById(material_id);
		if(null != zxMaterial){
			zxMaterial.setMaterial_id(UUID.toUUID());
			i=zxMaterialService.addZxMaterial(zxMaterial);
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
	@RequestMapping(value="/exportZxMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxMaterial(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	

	/**
	 * 获取班组数据字典
	 * @param zx_material_nation
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/getZxmaterialTeamList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxmaterialTeamList(HttpServletRequest request,HttpServletResponse response){
		List<XtDataDictionary> xtDataDictionaryList = CommonUtils.getXtDataDictionaryCache("zx_material_team");
		return outComboDataStr(xtDataDictionaryList);
	}
	

	/**
	 * 获取静态物料组成的树
	 * @param id
	 * @param type
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="/getStaticMaterialTreeGrid",method={RequestMethod.POST,RequestMethod.GET})
	public String getStaticMaterialTreeGrid(HttpServletRequest request){
		Map<String, Object> condition = new HashMap<String, Object>();
		List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyListByCondition(null);
		List<ZxMaterial> zxMaterialList = zxMaterialService.getZxMaterialListByCondition(condition);
		List<BaseTreeGridEntity> list = new ArrayList<BaseTreeGridEntity>();
		for(int i = 0; i < zxMaterialClassifyList.size(); i++){
			ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyList.get(i);
			BaseTreeGridEntity BaseTreeGridEntity = new BaseTreeGridEntity();
			BaseTreeGridEntity.setId(zxMaterialClassify.getClassify_id());
			BaseTreeGridEntity.setPid(zxMaterialClassify.getClassify_parentId());
			BaseTreeGridEntity.setText(zxMaterialClassify.getClassify_name());
			BaseTreeGridEntity.setExpanded(false);
			BaseTreeGridEntity.setSingleClickExpand(true);
			BaseTreeGridEntity.setTempObject("分类");
			BaseTreeGridEntity.setContent(zxMaterialClassify.getClassify_num());
			BaseTreeGridEntity.setIntegerappend(zxMaterialClassify.getClassify_id()+"@"+zxMaterialClassify.getClassify_name());
			BaseTreeGridEntity.setIcon("../deng/images/icons/target.png");
			list.add(BaseTreeGridEntity);
			for(int j = 0; j < zxMaterialList.size(); j++){
				ZxMaterial zxMaterial = zxMaterialList.get(j);
				BaseTreeGridEntity = new BaseTreeGridEntity();
				BaseTreeGridEntity.setId(zxMaterial.getMaterial_id());
				BaseTreeGridEntity.setPid(zxMaterial.getClassify_id());
				BaseTreeGridEntity.setText(zxMaterial.getName());
				BaseTreeGridEntity.setExpanded(false);
				BaseTreeGridEntity.setSingleClickExpand(true);
				BaseTreeGridEntity.setTempObject("物料");
				BaseTreeGridEntity.setIcon("../deng/images/icons/target_point.png");
				BaseTreeGridEntity.setContent(zxMaterial.getNum()+"_"+zxMaterial.getStandard());
				BaseTreeGridEntity.setIntegerappend(zxMaterial.getClassify_id()+"@"+zxMaterial.getName());
				list.add(BaseTreeGridEntity);
			}
		}
		return outStr(BaseTreeGridEntity.buildTree(list,false));
	}
	
	/**
	 * 获取动态物料组成的树
	 * @param id
	 * @param type
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value="/getMaterialTree",method={RequestMethod.POST,RequestMethod.GET})
	public String getMaterialTree(String id,String type,HttpServletRequest request) throws UnsupportedEncodingException{
		id = request.getParameter("node");
		type = URLDecoder.decode(type, "UTF-8");
		StringBuffer jsonStr = new StringBuffer("");  
		if(null != id && !"".equals(id) && "0".equals(id)){
			jsonStr.append("[");
			List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyList();
			for(int i = 0; i < zxMaterialClassifyList.size(); i++){
				ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyList.get(i);
				if(i==(zxMaterialClassifyList.size()-1)){
					jsonStr.append("{id:'"+zxMaterialClassify.getClassify_id()+"',text:'"+zxMaterialClassify.getClassify_short_name()+"',num:'"+zxMaterialClassify.getClassify_num()+"',icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxMaterialClassify.getClassify_parentId()+"',type:'分类'}");  
				}else{
					jsonStr.append("{id:'"+zxMaterialClassify.getClassify_id()+"',text:'"+zxMaterialClassify.getClassify_short_name()+"',num:'"+zxMaterialClassify.getClassify_num()+"',icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxMaterialClassify.getClassify_parentId()+"',type:'分类'},");
				}
			}
			jsonStr.append("]");
		}else{
			//1查找分类
			jsonStr.append("[");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("classify_parentId", id);
			List<ZxMaterialClassify> zxMaterialClassifyList = zxMaterialClassifyService.getZxMaterialClassifyListAllChild(condition);
			for(int i = 0; i < zxMaterialClassifyList.size(); i++){
				ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyList.get(i);
				String leaf = "false";
				if(zxMaterialClassify.getClassify_leaf().equals("0")){
					leaf = "false";
				}else{
					leaf = "true";
				}
				if(i==(zxMaterialClassifyList.size()-1)){
					jsonStr.append("{id:'"+zxMaterialClassify.getClassify_id()+"',text:'"+zxMaterialClassify.getClassify_short_name()+"',num:'"+zxMaterialClassify.getClassify_num()+"',leaf:"+leaf+",icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxMaterialClassify.getClassify_parentId()+"',type:'分类'}");  
				}else{
					jsonStr.append("{id:'"+zxMaterialClassify.getClassify_id()+"',text:'"+zxMaterialClassify.getClassify_short_name()+"',num:'"+zxMaterialClassify.getClassify_num()+"',leaf:"+leaf+",icon:'../deng/images/icons/depart.png',classify_parentId:'"+zxMaterialClassify.getClassify_parentId()+"',type:'分类'},");  
				}
			}
			//2查找分类下面物料
			String zxMaterialStr = zxMaterialStr(id,type);
			if(null != zxMaterialStr && !"".equals(zxMaterialStr) && !"[".equals(jsonStr.toString())){
				jsonStr.append(","+zxMaterialStr);
			}else{
				jsonStr.append(zxMaterialStr);
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
	public String zxMaterialStr(String id,String type){
		//如果类型:分类 则查出所有分类下物料
		StringBuffer jsonStr = new StringBuffer(); 
		Map<String, Object> condition = new HashMap<String, Object>();
		if(null != type && !"".equals(type) && "分类".equals(type)){
			condition = new HashMap<String, Object>();
			condition.put("classify_id", id);
			List<ZxMaterial> zxMaterialList = zxMaterialService.getZxMaterialListByCondition(condition);
			//拼接字符串
			for(int i = 0; i < zxMaterialList.size(); i++){
				ZxMaterial zxMaterial = zxMaterialList.get(i);
				String leaf = "true";
				if(i==(zxMaterialList.size()-1)){
					jsonStr.append("{id:'"+zxMaterial.getMaterial_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getShort_name()+"',icon:'../deng/images/icons/users.png',type:'物料',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getNum()+"',classify_id:'"+zxMaterial.getClassify_id()+"'}");  
				}else{
					jsonStr.append("{id:'"+zxMaterial.getMaterial_id()+"',leaf:"+leaf+",text:'"+zxMaterial.getShort_name()+"',icon:'../deng/images/icons/users.png',type:'物料',standard:'"+zxMaterial.getStandard()+"',num:'"+zxMaterial.getNum()+"',classify_id:'"+zxMaterial.getClassify_id()+"'},");
				}
			}
		}
		return jsonStr.toString();
	}
	
	/**
	 * 批量导入物料、分类
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/import",method={RequestMethod.POST,RequestMethod.GET})
	public String importExcel(HttpServletRequest request){
		BaseJson baseJson = new BaseJson();
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		Iterator iter = multiRequest.getFileNames();
		while(iter.hasNext()){
			MultipartFile mulfile = multiRequest.getFile((String) iter.next());
			if(mulfile != null){
		        ExcelReader excelReader = new ExcelReader();
				Map<Integer, List<String>> tmp;
				try {
					tmp = excelReader.readExcelContent(mulfile.getInputStream());
					importClassify(tmp);
					importMaterial(tmp);
				} catch (IOException e) {
					baseJson.setMsg("上传失败、失败原因:"+e.getMessage());
		        	baseJson.setJsonID("0");
		        	return outDataStr(baseJson);
				}  
			}
			break;
		}
		baseJson.setJsonID("1");
		baseJson.setMsg("上传成功");
		baseJson.setFileType("xls");
		return outDataStr(baseJson);
	}
	
	private void importClassify(Map<Integer, List<String>> map){
		List<ZxMaterialClassify> dataList = zxMaterialClassifyService.getZxMaterialClassifyListAll(new HashMap<String,Object>());
		Map<String,String> olds = new HashMap<String,String>();
		for(ZxMaterialClassify classify:dataList){
			olds.put(classify.getClassify_num(), classify.getClassify_id());
		}
		
		List<ZxMaterialClassify> classifys = new ArrayList<ZxMaterialClassify>();
		String time = getSimpleDateFormat();
		for(int i = 1;i <= map.size();i++){
			 List<String> list = map.get(i);
			 if(list != null&&!list.isEmpty()){
				 String code = list.get(0);
				 String[] splits = new String[]{code};
				 if(code.contains("."))
					 splits = code.split("\\.");
				 boolean flag = true;
				 StringBuffer parent_num = new StringBuffer();
				 for(int j = 0;j < splits.length;j++){
					 if(splits[j].length() > 2)flag = false;
					 if(j < splits.length - 2)parent_num.append(splits[j] + ".");
					 else if(j < splits.length - 1)parent_num.append(splits[j]);
				 }
				 if(flag&&!olds.containsKey(list.get(0))){
					 ZxMaterialClassify materialClassify = new ZxMaterialClassify();
					 String id = UUID.toUUID();
					 materialClassify.setClassify_id(id);
					 materialClassify.setClassify_short_name(list.get(1));
					 materialClassify.setClassify_name(list.get(2));
					 materialClassify.setClassify_num(list.get(0));
					 materialClassify.setClassify_leaf("0");
					 materialClassify.setClassify_isdelete("0");
					 materialClassify.setClassify_time(time);
					 materialClassify.setClassify_sort(Integer.valueOf(splits[splits.length - 1]));
					 if(olds.containsKey(parent_num.toString())){
						 materialClassify.setClassify_parentId(olds.get(parent_num.toString()));
					 }else{
						 materialClassify.setClassify_parentId("0");
					 }
					 olds.put(list.get(0), id);
					 classifys.add(materialClassify);
				 } 
			 }
		}
		if(!classifys.isEmpty()){
			zxMaterialClassifyService.addBatchZxMaterialClassify(classifys);
		}
	}
	
	private void importMaterial(Map<Integer, List<String>> map){
		List<ZxMaterialClassify> classifyDataList = zxMaterialClassifyService.getZxMaterialClassifyListAll(new HashMap<String,Object>());
		Map<String,String> classifyMap = new HashMap<String,String>();
		for(ZxMaterialClassify classify:classifyDataList){
			classifyMap.put(classify.getClassify_num(), classify.getClassify_id());
		}
		List<ZxMaterial> materialDataList = zxMaterialService.getZxMaterialListByCondition(new HashMap<String,Object>());
		Map<String,String> olds = new HashMap<String,String>();
		for(ZxMaterial material:materialDataList){
			olds.put(material.getNum(), material.getMaterial_id());
		}
		List<ZxMaterial> materials = new ArrayList<ZxMaterial>();
		String time = getSimpleDateFormat();
		
		for(int i = 1;i <= map.size();i++){
			 List<String> list = map.get(i);
			 if(list != null&&!list.isEmpty()){
				 String code = list.get(0);
				 String[] splits = new String[]{code};
				 if(code.contains("."))
					 splits = code.split("\\.");
				 boolean flag = false;
				 StringBuffer classify_num = new StringBuffer();
				 for(int j = 0;j < splits.length;j++){
					 if(splits[j].length() > 2)flag = true;
					 if(j < splits.length - 2)classify_num.append(splits[j] + ".");
					 else if(j < splits.length - 1)classify_num.append(splits[j]);
				 }
				 if(flag&&!olds.containsKey(list.get(0))){
					 ZxMaterial material = new ZxMaterial();
					 String id = UUID.toUUID();
					 material.setMaterial_id(id);
					 material.setClassify_id(classifyMap.get(classify_num.toString()));
					 material.setShort_name(list.get(1));
					 material.setName(list.get(2));
					 material.setNum(list.get(0));
					 material.setStatus("0");
					 material.setUnit(list.get(6));
					 material.setCreate_date(time);
					 material.setWeight(0.0);
					 material.setStandard(list.get(3));
					 material.setTeam("2");
					 if(list.get(5).equals("自制")){
						 material.setProperty("1"); 
					 }else if(list.get(5).equals("外购")){
						 material.setProperty("2"); 
					 }else{
						 material.setProperty("0"); 
					 }
					 olds.put(list.get(0), id);
					 materials.add(material);
				 }
			 }
		}
		if(!materials.isEmpty()){
			zxMaterialService.addBatchZxMaterial(materials);
		}
	}
}
