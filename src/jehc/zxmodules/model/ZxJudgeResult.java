package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_judge_result 供应商验厂结果 
* 2017-09-25 16:01:29  邓纯杰
*/
public class ZxJudgeResult extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String apply_id;/**验厂申请**/
	private double score;/**总分**/
	private String grade;/**评定结果**/
	private String check_user_id;/**审核人**/
	private String status;/**状态：1-未审核;2-审核中;3-审核通过；4-审核退回**/
	private String state;/**状态：0-删除;1-正常**/
	private String check_date;/**审核日期**/
	private String create_date;/**创建日期**/
	private String judge_date_start;/**创建日期**/
	private String judge_date_end;/**创建日期**/
	private String supplier_name;/**供应商名称**/
	private double final_score;/**最终总分**/
	private String final_grade;/**最终评定结果**/
	private String remark;/**备注**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}
	public String getApply_id(){
		return apply_id;
	}
	public void setScore(double score){
		this.score=score;
	}
	public double getScore(){
		return score;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getGrade(){
		return grade;
	}
	public void setCheck_user_id(String check_user_id){
		this.check_user_id=check_user_id;
	}
	public String getCheck_user_id(){
		return check_user_id;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setCheck_date(String check_date){
		this.check_date=check_date;
	}
	public String getCheck_date(){
		return check_date;
	}
	public void setCreate_date(String create_date){
		this.create_date=create_date;
	}
	public String getCreate_date(){
		return create_date;
	}
	public String getJudge_date_start() {
		return judge_date_start;
	}
	public void setJudge_date_start(String judge_date_start) {
		this.judge_date_start = judge_date_start;
	}
	public String getJudge_date_end() {
		return judge_date_end;
	}
	public void setJudge_date_end(String judge_date_end) {
		this.judge_date_end = judge_date_end;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getFinal_grade() {
		return final_grade;
	}
	public void setFinal_grade(String final_grade) {
		this.final_grade = final_grade;
	}
	public double getFinal_score() {
		return final_score;
	}
	public void setFinal_score(double final_score) {
		this.final_score = final_score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
