package jehc.zxmodules.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.zxmodules.dao.ZxJudgeAgainResultDao;
import jehc.zxmodules.dao.ZxJudgeReportDao;
import jehc.zxmodules.dao.ZxJudgeResultDao;
import jehc.zxmodules.dao.ZxJudgeStandardDao;
import jehc.zxmodules.dao.ZxJudgeUserDao;
import jehc.zxmodules.model.ZxJudgeAgainResult;
import jehc.zxmodules.model.ZxJudgeReport;
import jehc.zxmodules.model.ZxJudgeResult;
import jehc.zxmodules.model.ZxJudgeStandard;
import jehc.zxmodules.model.ZxJudgeUser;
import jehc.zxmodules.service.ZxJudgeReportService;

/**
* 供应商评定详情表 
* 2017-09-22 13:18:03  g
*/
@Service("zxJudgeReportService")
public class ZxJudgeReportServiceImpl extends BaseService implements ZxJudgeReportService{
	@Autowired
	private ZxJudgeReportDao zxJudgeReportDao;
	@Autowired
	private ZxJudgeResultDao zxJudgeResultDao;
	@Autowired
	private ZxJudgeUserDao zxJudgeUserDao;
	@Autowired
	private ZxJudgeStandardDao zxJudgeStandardDao;
	@Autowired
	private ZxJudgeAgainResultDao zxJudgeAgainResultDao;
	
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeReport> getZxJudgeReportListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeReportDao.getZxJudgeReportListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeReport getZxJudgeReportById(String id){
		try{
			ZxJudgeReport zxJudgeReport = zxJudgeReportDao.getZxJudgeReportById(id);
			return zxJudgeReport;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_report 
	* @return
	*/
	public int addZxJudgeReport(ZxJudgeReport zxJudgeReport){
		int i = 0;
		try {
			i = zxJudgeReportDao.addZxJudgeReport(zxJudgeReport);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReport(ZxJudgeReport zxJudgeReport){
		int i = 0;
		try {
			i = zxJudgeReportDao.updateZxJudgeReport(zxJudgeReport);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReportBySelective(ZxJudgeReport zxJudgeReport){
		int i = 0;
		try {
			i = zxJudgeReportDao.updateZxJudgeReportBySelective(zxJudgeReport);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeReport(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeReportDao.delZxJudgeReport(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_reportList 
	* @return
	*/
	public int addBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList){
		int i = 0;
		try {
			i = zxJudgeReportDao.addBatchZxJudgeReport(zxJudgeReportList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList){
		int i = 0;
		try {
			i = zxJudgeReportDao.updateBatchZxJudgeReport(zxJudgeReportList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReportBySelective(List<ZxJudgeReport> zxJudgeReportList){
		int i = 0;
		try {
			i = zxJudgeReportDao.updateBatchZxJudgeReportBySelective(zxJudgeReportList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	public int addOrUpdateZxJudgeReport(Map<String,Object> condition){
		int i = 0;
		String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		try {
			Map<String, Object> condition1 = new HashMap<String, Object>();
			String result_id = null;
			String type = String.valueOf(condition.get("type"));
			ZxJudgeResult zxJudgeResult = null;
			ZxJudgeAgainResult zxJudgeAgainResult = null;
			if(type.equals("1")){
				condition1.put("apply_id", condition.get("apply_id"));
				List<ZxJudgeResult> results = zxJudgeResultDao.getZxJudgeResultListByCondition(condition1);
				if(results != null&&results.size() > 0){
					zxJudgeResult = results.get(0);
					result_id = zxJudgeResult.getId();
				}
			}else if(type.equals("2")){
				condition1.put("supplier_id", condition.get("supplier_id"));
				condition1.put("judge_date", condition.get("judge_date"));
				condition1.put("state", 1);
				List<ZxJudgeAgainResult> results = zxJudgeAgainResultDao.getZxJudgeAgainResultListByCondition(condition1);
				if(results != null&&results.size() > 0){
					zxJudgeAgainResult = results.get(0);
					result_id = zxJudgeAgainResult.getId();
				}
			}
			
			if(result_id  != null){
				Map<String, Object> condition4 = new HashMap<String, Object>();
				condition4.put("result_id", result_id);
				condition4.put("state", 1);
				condition4.put("type", type);
				condition4.put("is_connect", 1);
				condition4.put("dep_id",condition.get("dep_id"));
				List<ZxJudgeUser> otherUsers = zxJudgeUserDao.getZxJudgeUserListByCondition(condition4);
				if(otherUsers != null&&otherUsers.size() > 0){
					for(ZxJudgeUser bean:otherUsers){
						if(!bean.getUser_id().equals(String.valueOf(condition.get("user_id")))){
							return 4;
						}else if(bean.getStatus().equals("2")||bean.getStatus().equals("3")){
							return 5;
						}
					}
				}
				
				Map<String, Object> condition2 = new HashMap<String, Object>();
				condition2.put("result_id", result_id);
				condition2.put("user_id", condition.get("user_id"));
				condition2.put("state", 1);
				condition2.put("type", type);
				List<ZxJudgeUser> zxJudgeUsers = zxJudgeUserDao.getZxJudgeUserListByCondition(condition2);
				ZxJudgeUser zxJudgeUser = null;
				if(zxJudgeUsers != null&&zxJudgeUsers.size() > 0){
					zxJudgeUser = zxJudgeUsers.get(0);
					if(zxJudgeUser.getStatus().equals("2")||zxJudgeUser.getStatus().equals("3"))
						return Integer.valueOf(zxJudgeUser.getStatus());
					zxJudgeUser.setStatus(String.valueOf(condition.get("status")));
					zxJudgeUserDao.updateZxJudgeUser(zxJudgeUser);
					
					Map<String, Object> condition3 = new HashMap<String, Object>();
					condition3.put("judge_user_id", zxJudgeUser.getId());
					List<ZxJudgeReport> reports = zxJudgeReportDao.getZxJudgeReportListByCondition(condition3);
					List<ZxJudgeReport> reportsEdit = new ArrayList<ZxJudgeReport>();
					String[] scores = (String[]) condition.get("scores");
					
					if(scores != null&&scores.length > 0){
						for(int m = 0;m < scores.length;m++){
							if(StringUtils.isBlank(scores[m])||scores[m].equals("{}"))continue;
							JSONObject object = new JSONObject(scores[m]);
							for(int n = 0;n < reports.size();n++){
								if(reports.get(n).getId().equals(object.getString("id"))){
									ZxJudgeReport report = reports.get(n);
									report.setScore(object.getDouble("score"));
									reportsEdit.add(report);
								}
							}
						}
						zxJudgeReportDao.updateBatchZxJudgeReport(reportsEdit);
					}
				}else{
					zxJudgeUser = new ZxJudgeUser();
					String judge_user_id = UUID.toUUID();
					zxJudgeUser.setId(judge_user_id);
					zxJudgeUser.setState("1");
					zxJudgeUser.setStatus(String.valueOf(condition.get("status")));
					zxJudgeUser.setResult_id(result_id);
					zxJudgeUser.setType(type);
					zxJudgeUser.setUser_id(String.valueOf(condition.get("user_id")));
					zxJudgeUser.setCreate_date(date);
					zxJudgeUserDao.addZxJudgeUser(zxJudgeUser);
					
					List<ZxJudgeReport> reports = new ArrayList<ZxJudgeReport>();
					List<ZxJudgeStandard> standards = getStandards(type,String.valueOf(condition.get("dep_id")));
					String[] scores = (String[]) condition.get("scores");
					
					for(ZxJudgeStandard standard:standards){
						ZxJudgeReport report = new ZxJudgeReport();
						report.setId(UUID.toUUID());
						report.setJudge_user_id(judge_user_id);
						report.setStandard_id(standard.getId());
						double score = 0.0;
						if(scores != null&&scores.length > 0){
							for(int m = 0;m < scores.length;m++){
								if(StringUtils.isBlank(scores[m])||scores[m].equals("{}"))continue;
								JSONObject object = new JSONObject(scores[m]);
								if(object.getString("id").equals(standard.getId())){
									score = object.getDouble("score");
								}
							}
						}
						report.setScore(score);
						reports.add(report);
					}
					zxJudgeReportDao.addBatchZxJudgeReport(reports);
				}
				if(type.equals("1")){
					i = isSubmit(zxJudgeResult,type);
				}else if(type.equals("2")){
					i = isSubmit(zxJudgeAgainResult,type);
				}
			}
			if(i == 0)i = 1;
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	private int isSubmit(Object object,String type){
		int i = 0;
		String result_id = null;
		ZxJudgeAgainResult zxJudgeAgainResult = null;
		ZxJudgeResult zxJudgeResult = null;
		if(type.equals("1")){
			zxJudgeResult = (ZxJudgeResult) object;
			result_id = zxJudgeResult.getId();
		}else if(type.equals("2")){
			zxJudgeAgainResult = (ZxJudgeAgainResult) object;
			result_id = zxJudgeAgainResult.getId();
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("result_id", result_id);
		condition.put("state", 1);
		condition.put("type", type);
		List<ZxJudgeUser> zxJudgeUsers = zxJudgeUserDao.getZxJudgeUserListByCondition(condition);
		boolean flag = true;
		String[] ids = null;
		if(zxJudgeUsers != null&&zxJudgeUsers.size() > 0){
			ids = new String[zxJudgeUsers.size()];
			for(int m = 0;m < zxJudgeUsers.size();m++){
				if(zxJudgeUsers.get(m).getStatus().equals("1")||zxJudgeUsers.get(m).getStatus().equals("4")){
					flag = false;
				}
				ids[m] = zxJudgeUsers.get(m).getId();
			}
		}else{
			flag = false;
		}
		
		if(flag){
			Map<String, Object> condition2 = new HashMap<String, Object>();
			condition2.put("type", type);
			condition2.put("state", 1);
			List<ZxJudgeStandard> standards = zxJudgeStandardDao.getZxJudgeStandardListByCondition(condition2);
			
			List<ZxJudgeReport> list = new ArrayList<ZxJudgeReport>();
			for(String id:ids){
				Map<String, Object> condition3 = new HashMap<String, Object>();
				condition3.put("judge_user_id", id);
				condition3.put("result_type", type);
				List<ZxJudgeReport> reports = zxJudgeReportDao.getZxJudgeReportListByCondition(condition3);
				list.addAll(reports);
			}
			if(standards.size() == list.size()){
				double score = 0.0;
				for(ZxJudgeReport report:list){
					score += report.getScore();
				}
				if(type.equals("1")){
					zxJudgeResult.setScore(score);
					zxJudgeResult.setGrade(getGrade(score,"1"));
					zxJudgeResult.setStatus("2");
					zxJudgeResultDao.updateZxJudgeResult(zxJudgeResult);
				}else if(type.equals("2")){
					zxJudgeAgainResult.setScore(score);
					zxJudgeAgainResult.setGrade(getGrade(score,"2"));
					zxJudgeAgainResult.setStatus("2");
					zxJudgeAgainResultDao.updateZxJudgeAgainResult(zxJudgeAgainResult);
				}
				i = 2;
			}
		}
		return i;
	}
	
	private List<ZxJudgeStandard> getStandards(String type,String dep_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", type);
		condition.put("state", 1);
		condition.put("dep_id", dep_id);
		List<ZxJudgeStandard> standards = zxJudgeStandardDao.getZxJudgeStandardListByCondition(condition);
		return standards;
	}
	
	private String getGrade(double score,String type){
		String str = "";
		if(type.equals("1")){
			if(score >= 80.0){
				str = "1";
			}else if(score < 60.0){
				str = "3";
			}else {
				str = "2";
			}
		}else if(type.equals("2")){
			if(score >= 90.0){
				str = "1";
			}else if(score < 90.0&&score >=80.0){
				str = "2";
			}else if(score < 80.0&&score >=70.0){
				str = "3";
			}else {
				str = "4";
			}
		}
		
		return str;
	}
}
