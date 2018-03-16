package jehc.zxmodules.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseJson;
import jehc.xtmodules.xtcore.base.BaseSearch;
import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.constant.SessionConstant;
import jehc.xtmodules.xtcore.util.excel.poi.ExcelReader;
import jehc.xtmodules.xtcore.util.excel.poi.ExportExcel;
import jehc.xtmodules.xtmodel.XtDataDictionary;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxSupplierService;

/**
* 供应商管理 
* 2017-09-20 15:51:29  guqian
*/
@Controller
@RequestMapping("/zxSupplierController")
public class ZxSupplierController extends BaseAction{
	@Autowired
	private ZxSupplierService zxSupplierService;
	
	/**
	* 载入初始化页面
	* @param zx_supplier 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxSupplier(ZxSupplier zxSupplier,HttpServletRequest request){
		ModelAndView model = new ModelAndView("pc/zx-view/zx-supplier/zx-supplier-list");
		model.addObject("permission", (String)request.getSession(false).getAttribute(SessionConstant.XT_FUNCTIONINFOURL));
		model.addObject("isAdmin", isAdmin());
		return model ;
	}
	/**
	* 加载初始化列表数据并分页
	* @param zx_supplier 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSupplierListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSupplierListByCondition(BaseSearch baseSearch,HttpServletRequest request){
		Map<String, Object> condition = baseSearch.convert();
		condition.put("state", "1");
		commonHPager(condition,request);
		List<ZxSupplier> zxSupplierList = zxSupplierService.getZxSupplierListByCondition(condition);
		PageInfo<ZxSupplier> page = new PageInfo<ZxSupplier>(zxSupplierList);
		return outPageStr(page,request);
	}
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxSupplierById",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSupplierById(String id,HttpServletRequest request){
		ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(id);
		return outDataStr(zxSupplier);
	}
	/**
	* 添加
	* @param zx_supplier 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/addZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public String addZxSupplier(ZxSupplier zxSupplier,HttpServletRequest request){
		int i = 0;
		if(null != zxSupplier){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("state", 1);
			condition.put("e_name",zxSupplier.getName());
			List<ZxSupplier> list = zxSupplierService.getZxSupplierListByCondition(condition);
			if(list.isEmpty()){
				zxSupplier.setId(UUID.toUUID());
				zxSupplier.setCreate_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				zxSupplier.setState("1");
				zxSupplier.setYc_status("0");
				zxSupplier.setYc_num(0);
				zxSupplier.setIs_judge("0");
				i = zxSupplierService.addZxSupplier(zxSupplier);
			}else{
				return "{success:false,msg:'供应商重复',responseFlag:false}";
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
	* @param zx_supplier 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/updateZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public String updateZxSupplier(ZxSupplier zxSupplier,HttpServletRequest request){
		int i = 0;
		if(null != zxSupplier){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("state", 1);
			condition.put("e_name",zxSupplier.getName());
			List<ZxSupplier> list = zxSupplierService.getZxSupplierListByCondition(condition);
			if(list.isEmpty()||(list.size() == 1&&list.get(0).getId().equals(zxSupplier.getId()))){
				i=zxSupplierService.updateZxSupplier(zxSupplier);
			}else{
				return "{success:false,msg:'供应商重复',responseFlag:false}";
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
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/delZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public String delZxSupplier(String id,HttpServletRequest request){
		int i = 0;
		if(null != id && !"".equals(id)){
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id",id.split(","));
			i=zxSupplierService.delZxSupplier(condition);
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
	@RequestMapping(value="/copyZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public String copyZxSupplier(String id,HttpServletRequest request){
		int i = 0;
		ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(id);
		if(null != zxSupplier){
			zxSupplier.setId(UUID.toUUID());
			i=zxSupplierService.addZxSupplier(zxSupplier);
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
	@RequestMapping(value="/exportZxSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public void exportZxSupplier(String excleData,String excleHeader,String excleText,HttpServletRequest request,HttpServletResponse response){
		ExportExcel exportExcel = new ExportExcel();
		exportExcel.exportExcel(excleData, excleHeader,excleText,response);
	}

	/**
	 * 查找供应商集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getZxSupplierList",method={RequestMethod.POST,RequestMethod.GET})
	public String getZxSupplierList(){
		List<ZxSupplier> zxSupplierList = zxSupplierService.getZxSupplierListByCondition(null);
		return outItemsStr(zxSupplierList);
	}
	
	/**
	* 载入初始化页面
	* @param zx_supplier 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxJudgeSupplier",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadZxJudgeSupplier(ZxSupplier zxSupplier,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-supplier/zx-judge-supplier-list");
	}
	
	/**
	 * 批量供应商
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
					importSupplier(tmp);
				} catch (IOException e) {
					baseJson.setMsg("导入失败、失败原因:"+e.getMessage());
		        	baseJson.setJsonID("0");
		        	return outDataStr(baseJson);
				}  
			}
			break;
		}
		baseJson.setJsonID("1");
		baseJson.setMsg("导入成功");
		baseJson.setFileType("xls");
		return outDataStr(baseJson);
	}
	
	private void importSupplier(Map<Integer, List<String>> map){
		List<XtDataDictionary> zhiwuList = CommonUtils.getXtDataDictionaryCache("zx_zhiwu");
		
		List<String> numList = new ArrayList<String>();
		List<ZxSupplier> zxSupplierList = zxSupplierService.getZxSupplierListByCondition(new HashMap<String, Object>());
		for(ZxSupplier zxSupplier:zxSupplierList){
			numList.add(zxSupplier.getNum());
		}
		
		List<ZxSupplier> suppliers = new ArrayList<ZxSupplier>();
		String time = getSimpleDateFormat();
		
		for(int i = 3;i <= map.size();i++){
			 List<String> list = map.get(i);
			 if(list != null&&!list.isEmpty()){
				 if(StringUtils.isBlank(list.get(3))||numList.contains(list.get(3))){
					 continue;
				 }
				 ZxSupplier zxSupplier = new ZxSupplier();
				 zxSupplier.setId(UUID.toUUID());
				 zxSupplier.setClassify(StringUtils.isNotBlank(list.get(2))?StringUtils.trim(list.get(2)):"D");
				 zxSupplier.setNum(StringUtils.trim(list.get(3)));
				 zxSupplier.setName(StringUtils.trim(list.get(4)));
				 zxSupplier.setAddress(list.get(5));
				 zxSupplier.setContact_person(list.get(6));
				 zxSupplier.setFax(list.get(8));
				 zxSupplier.setPhone(list.get(9));
				 zxSupplier.setQq(list.get(10));
				 zxSupplier.setWeb(list.get(11));
				 zxSupplier.setEmail(list.get(12));
				 zxSupplier.setPay_type(list.get(13));
				 zxSupplier.setBank_id(list.get(14));
				 zxSupplier.setBank_account(list.get(15));
				 zxSupplier.setOperation_status(list.get(16));
				 zxSupplier.setYc_status("0");
				 zxSupplier.setType("1");
				 zxSupplier.setState("1");
				 zxSupplier.setCreate_date(time);
				 
				 String zw = null;
				 if(StringUtils.isNotBlank(list.get(7))){
					 for(XtDataDictionary zhiwu:zhiwuList){
						 if(zhiwu.getXt_data_dictionary_name().equals(list.get(7).trim())){
							 zw = zhiwu.getXt_data_dictionary_id();
							 break;
						 }
					 }
				 }
				 if(zw != null)zxSupplier.setTitle(zw);
				 
				 suppliers.add(zxSupplier);
			 }
		}
		if(!suppliers.isEmpty()){
			zxSupplierService.addBatchZxSupplier(suppliers);
		}
	}
	
	/**
	* 获取对象
	* @param id 
	* @param request 
	*/
	@ResponseBody
	@RequestMapping(value="/editCycle",method={RequestMethod.POST,RequestMethod.GET})
	public String editCycle(String ids,String judge_cycle,HttpServletRequest request){
		int i = 0;
		String[] idArray = ids.split(",");
		List<ZxSupplier> list = new ArrayList<ZxSupplier>();
		for(String id:idArray){
			ZxSupplier zxSupplier = zxSupplierService.getZxSupplierById(id);
			zxSupplier.setJudge_cycle(judge_cycle);
			list.add(zxSupplier);
		}
		if(!list.isEmpty()){
			i = zxSupplierService.updateBatchZxSupplier(list);
		}
		if(i>0){
			return outAudStr(true);
		}else{
			return outAudStr(false);
		}
	}
}
