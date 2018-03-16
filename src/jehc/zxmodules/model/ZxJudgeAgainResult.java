package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_judge_again_result 供应商再评审结果 
* 2017-09-26 17:22:17  邓纯杰
*/
public class ZxJudgeAgainResult extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String supplier_id;/**供应商**/
	private int judge_date;/**评审时间**/
	private double score;/**总分**/
	private String grade;/**评定结果**/
	private String check_user_id;/**审核人**/
	private String status;/**状态：1-未审核；2-审核通过；3-审核退回**/
	private String state;/**状态：1-正常，0-删除**/
	private String check_date;/**审核日期**/
	private String create_date;/**创建日期**/
	private String supplier_name;/**供应商**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setSupplier_id(String supplier_id){
		this.supplier_id=supplier_id;
	}
	public String getSupplier_id(){
		return supplier_id;
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
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public int getJudge_date() {
		return judge_date;
	}
	public void setJudge_date(int judge_date) {
		this.judge_date = judge_date;
	}
}
