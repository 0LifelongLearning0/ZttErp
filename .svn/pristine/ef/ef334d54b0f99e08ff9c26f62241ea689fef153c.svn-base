package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxJudgeReportDao;
import jehc.zxmodules.model.ZxJudgeReport;

/**
* 供应商评定详情表 
* 2017-09-22 13:18:03  g
*/
@Repository("zxJudgeReportDao")
public class ZxJudgeReportDaoImpl  extends BaseDaoImpl implements ZxJudgeReportDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxJudgeReport> getZxJudgeReportListByCondition(Map<String,Object> condition){
		return (List<ZxJudgeReport>)this.getList("getZxJudgeReportListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeReport getZxJudgeReportById(String id){
		return (ZxJudgeReport)this.get("getZxJudgeReportById", id);
	}
	/**
	* 添加
	* @param zx_judge_report 
	* @return
	*/
	public int addZxJudgeReport(ZxJudgeReport zxJudgeReport){
		return this.add("addZxJudgeReport", zxJudgeReport);
	}
	/**
	* 修改
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReport(ZxJudgeReport zxJudgeReport){
		return this.update("updateZxJudgeReport", zxJudgeReport);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReportBySelective(ZxJudgeReport zxJudgeReport){
		return this.update("updateZxJudgeReportBySelective", zxJudgeReport);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeReport(Map<String,Object> condition){
		return this.del("delZxJudgeReport", condition);
	}
	/**
	* 批量添加
	* @param zx_judge_reportList 
	* @return
	*/
	public int addBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList){
		return this.add("addBatchZxJudgeReport", zxJudgeReportList);
	}
	/**
	* 批量修改
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList){
		return this.update("updateBatchZxJudgeReport", zxJudgeReportList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReportBySelective(List<ZxJudgeReport> zxJudgeReportList){
		return this.update("updateBatchZxJudgeReportBySelective", zxJudgeReportList);
	}
}
