package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxJudgeReport;

/**
* 供应商评定详情表 
* 2017-09-22 13:18:03  g
*/
public interface ZxJudgeReportDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeReport> getZxJudgeReportListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxJudgeReport getZxJudgeReportById(String id);
	/**
	* 添加
	* @param zx_judge_report 
	* @return
	*/
	public int addZxJudgeReport(ZxJudgeReport zxJudgeReport);
	/**
	* 修改
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReport(ZxJudgeReport zxJudgeReport);
	/**
	* 修改（根据动态条件）
	* @param zx_judge_report 
	* @return
	*/
	public int updateZxJudgeReportBySelective(ZxJudgeReport zxJudgeReport);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxJudgeReport(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_judge_reportList 
	* @return
	*/
	public int addBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList);
	/**
	* 批量修改
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReport(List<ZxJudgeReport> zxJudgeReportList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_reportList 
	* @return
	*/
	public int updateBatchZxJudgeReportBySelective(List<ZxJudgeReport> zxJudgeReportList);
}
