package jehc.zxmodules.web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseJson;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.excel.poi.ExcelReader;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.zxmodules.model.ZxBuyApplyMaterial;
import jehc.zxmodules.model.ZxMaterial;
import jehc.zxmodules.service.ZxBuyApplyMaterialService;
import jehc.zxmodules.service.ZxBuyApplyService;
import jehc.zxmodules.service.ZxMaterialService;
import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
* 采购申请单物料详情 
* 2017-10-26 10:46:15  陈运芝
*/
@Controller
@RequestMapping("/zxBuyApplyMaterialController")
public class ZxBuyApplyMaterialController extends BaseAction{
	@Autowired
	private ZxBuyApplyMaterialService zxBuyApplyMaterialService;
	@Autowired
	private ZxBuyApplyService zxBuyApplyService;
	@Autowired
	private ZxMaterialService zxMaterialService;
	/**
	* 载入初始化页面
	* @param zx_buy_apply_material 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial,HttpServletRequest request,Model model){
		model.addAttribute("zxBuyApplyMaterial",zxBuyApplyMaterial);
		model.addAttribute("zxBuyApply",zxBuyApplyService.getZxBuyApplyById(zxBuyApplyMaterial.getApply_id()));
		return new ModelAndView("pc/zx-view/zx-buy-apply/zx-buy-apply-material-list");
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_buy_apply_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyApplyMaterialListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyMaterialListByCondition(BaseSearch baseSearch,String apply_id,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		commonHPager(condition,request);
		condition.put("apply_id", apply_id);
		List<ZxBuyApplyMaterial> zxBuyApplyMaterialList = zxBuyApplyMaterialService.getZxBuyApplyMaterialListByCondition(condition);
		for(ZxBuyApplyMaterial zxBuyApplyMaterial:zxBuyApplyMaterialList){
			zxBuyApplyMaterial.setItem(zxMaterialService.getZxMaterialById(zxBuyApplyMaterial.getMaterial_id()));
		}
		PageInfo<ZxBuyApplyMaterial> page = new PageInfo<ZxBuyApplyMaterial>(zxBuyApplyMaterialList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxBuyApplyMaterialById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxBuyApplyMaterialById(String id,HttpServletRequest request){
		ZxBuyApplyMaterial zxBuyApplyMaterial = zxBuyApplyMaterialService.getZxBuyApplyMaterialById(id);
		String outStr = outDataStr(zxBuyApplyMaterial);
		ZxMaterial material = zxMaterialService.getZxMaterialById(zxBuyApplyMaterial.getMaterial_id());
		
		JSONArray jsonArray = JSONArray.fromObject(material); 
		String jsonStr = jsonArray.toString();
		jsonStr = jsonStr.substring(1,jsonStr.length()-1);
		
		outStr = outStr.substring(0,outStr.length()-2).concat(",\"material\":").concat(jsonStr).concat(outStr.substring(outStr.length()-2,outStr.length()));
		return outStr;
	}
	/**
	* 添加
	* @param zx_buy_apply_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyApplyMaterial){
			zxBuyApplyMaterial.setId(UUID.toUUID());
			i=zxBuyApplyMaterialService.addZxBuyApplyMaterial(zxBuyApplyMaterial);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
	/**
	* 修改
	* @param zx_buy_apply_material 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxBuyApplyMaterial(ZxBuyApplyMaterial zxBuyApplyMaterial,HttpServletRequest request){
		int i = 0;
		if(null != zxBuyApplyMaterial){
			i=zxBuyApplyMaterialService.updateZxBuyApplyMaterial(zxBuyApplyMaterial);
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
	@RequestMapping(value="/delZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxBuyApplyMaterial(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxBuyApplyMaterialService.delZxBuyApplyMaterial(condition);
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
	@RequestMapping(value="/copyZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxBuyApplyMaterial(String id,HttpServletRequest request){
		int i = 0;
		ZxBuyApplyMaterial zxBuyApplyMaterial = zxBuyApplyMaterialService.getZxBuyApplyMaterialById(id);
		if(null != zxBuyApplyMaterial){
			zxBuyApplyMaterial.setId(UUID.toUUID());
			i=zxBuyApplyMaterialService.addZxBuyApplyMaterial(zxBuyApplyMaterial);
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
	@RequestMapping(value="/exportZxBuyApplyMaterial",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxBuyApplyMaterial(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}
	
	/**
	 * 批量导入物料清单
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/import",method={RequestMethod.POST,RequestMethod.GET})
	public String importExcel(String apply_id,HttpServletRequest request){
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
					importMaterial(tmp,apply_id);
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
	
	private void importMaterial(Map<Integer, List<String>> map,String apply_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("apply_id", apply_id);
		List<ZxBuyApplyMaterial> zxBuyApplyMaterialList = zxBuyApplyMaterialService.getZxBuyApplyMaterialListByCondition(condition);
		
		List<ZxBuyApplyMaterial> addApplyMaterials = new ArrayList<ZxBuyApplyMaterial>();
		List<ZxBuyApplyMaterial> editApplyMaterials = new ArrayList<ZxBuyApplyMaterial>();
		
		//读取需求日期
		List<String> list = map.get(1);
		String need_time = null;
		if(list != null&&!list.isEmpty()){
			String dt = StringUtils.trim(list.get(6));
			SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				need_time = sdf2.format(sdf1.parse(dt));
			} catch (ParseException e) {
				e.printStackTrace();
			}  
		}
		
		//从第5行开始，读到第一列不是数字时结束
		for(int i = 4;i <= map.size();i++){
			 list = map.get(i);
			 if(list != null&&!list.isEmpty()&&isNumeric(list.get(0))){
				 if(StringUtils.isNotBlank(list.get(1))){
					 Map<String, Object> condition2 = new HashMap<String, Object>();
					 condition2.put("num", list.get(1));
					 List<ZxMaterial> zxMaterialList = zxMaterialService.getZxMaterialListByCondition(condition2);
					 for(ZxMaterial zxMaterial:zxMaterialList){
						 if(zxMaterial.getNum().equals(list.get(1))){
							 //true:修改，false新增
							 boolean flag = false; 
							 for(ZxBuyApplyMaterial e:zxBuyApplyMaterialList){
								 if(e.getMaterial_id().equals(zxMaterial.getMaterial_id())){
									 flag = true;
									 e.setNeed_time(need_time);
									 e.setBrand(list.get(4));
									 e.setSingle_amount(list.get(6));
									 e.setAmount(list.get(7));
									 e.setRemark(list.get(8));
									 editApplyMaterials.add(e);
									 break;
								 }
							 }
							 if(!flag){
								 ZxBuyApplyMaterial e = new ZxBuyApplyMaterial();
								 e.setId(UUID.toUUID());
								 e.setApply_id(apply_id);
								 e.setMaterial_id(zxMaterial.getMaterial_id());
								 e.setNeed_time(need_time);
								 e.setBrand(list.get(4));
								 e.setSingle_amount(list.get(6));
								 e.setAmount(list.get(7));
								 e.setRemark(list.get(8));
								 e.setStatus("1");
								 addApplyMaterials.add(e);
							 }
							 break;
						 }
					 }
				 }
			 }else{
				 break;
			 }
		}
		if(!editApplyMaterials.isEmpty()){
			zxBuyApplyMaterialService.updateBatchZxBuyApplyMaterial(editApplyMaterials);
		}
		if(!addApplyMaterials.isEmpty()){
			zxBuyApplyMaterialService.addBatchZxBuyApplyMaterial(addApplyMaterials);
		}
	}
	
	//判断是否为正整数数字
	public static boolean isNumeric(String Value) {
		if(StringUtils.isBlank(Value)){
			return false;
		}
		String tmpValue = StringUtils.trim(Value);
		for (int i = 0; i < tmpValue.length(); i++) {
			char OneByte = tmpValue.charAt(i);
			if ((OneByte > '9' || OneByte < '0')) {
				return false;
			}
		}
		return true;
	}
}
