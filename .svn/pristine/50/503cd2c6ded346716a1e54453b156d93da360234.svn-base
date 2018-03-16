package jehc.zxmodules.web;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jehc.xtmodules.xtcore.allutils.AllUtils;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtmodel.XtDepartinfo;
import jehc.xtmodules.xtmodel.XtPost;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtDepartinfoService;
import jehc.xtmodules.xtservice.XtPostService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
* 员工信息表; InnoDB free: 6144 kB 
* 2017-09-14 21:41:20  陈运芝
*/
@Controller
@RequestMapping("/zxUserinfoController")
@Scope("prototype")
public class ZxUserinfoController extends BaseAction{
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private XtDepartinfoService xtDepartinfoService;
	@Autowired
	private XtPostService xtPostService;
	
	/**
	* 通讯录页面
	* @param xt_userinfo 
	* @param request 
	* @return
	*/
	@RequestMapping(value="/loadZxUserinfoContacts",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loadXtUserinfoContacts(XtUserinfo xt_Userinfo,HttpServletRequest request){
		return new ModelAndView("pc/zx-view/zx-userinfo/zx-userinfo-contacts");
	}

	/**
	* 加载初始化列表数据
	* @param xt_userinfo 
	* @param request 
	 * @throws UnsupportedEncodingException 
	*/
	@ResponseBody
	@RequestMapping(value="/getZxUserinfoListByCondition",method={RequestMethod.POST,RequestMethod.GET})
	public String getXtUserinfoListByCondition(String xt_departinfo_id,String xt_post_id,String xt_userinfo_realName,HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> condition = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(xt_departinfo_id)){
			String depId = URLDecoder.decode(xt_departinfo_id, "UTF-8");
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
	}
    private static String queryInStr(String[] queryStrs) {
        if (null == queryStrs || 0 == queryStrs.length) return null;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < queryStrs.length; i++) {
            if (i != 0) buf.append(",");
            buf.append("'").append(queryStrs[i]).append("'");
        }
        return buf.toString();
    }
}
