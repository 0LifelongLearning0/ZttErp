package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_judge_report 供应商评定详情表 
* 2017-09-22 13:18:03  邓纯杰
*/
public class ZxJudgeReport extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String judge_user_id;/**考核人**/
	private String standard_id;/**考核内容**/
	private double score;/**得分**/
	private String remark;/**备注**/
	private double total_score;/**总分**/
	private String content;/**考核内容**/
	private String status;
	private String judge_user_name;/**考核人**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setStandard_id(String standard_id){
		this.standard_id=standard_id;
	}
	public String getStandard_id(){
		return standard_id;
	}
	public void setScore(double score){
		this.score=score;
	}
	public double getScore(){
		return score;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public String getJudge_user_id() {
		return judge_user_id;
	}
	public void setJudge_user_id(String judge_user_id) {
		this.judge_user_id = judge_user_id;
	}
	public double getTotal_score() {
		return total_score;
	}
	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJudge_user_name() {
		return judge_user_name;
	}
	public void setJudge_user_name(String judge_user_name) {
		this.judge_user_name = judge_user_name;
	}
}
