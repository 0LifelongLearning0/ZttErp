package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_six_s_content 6S待办内容 
* 2017-11-02 11:14:25  邓纯杰
*/
public class ZxSixSContent extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String six_s_id;/**six_sID**/
	private String place_id;/**检查场所**/
	private String dep_id;/**责任部门**/
	private String user_id;/**责任人**/
	private String problem;/**不符合项说明**/
	private String problem_pic;/**参考照片**/
	private String end_date;/**完成期限**/
	private String measure;/**改善措施**/
	private String result_pic;/**改善结果**/
	private String status;/**状态:1-改善中，2-确认中,3-已确认**/
	private String create_date;/**创建日期**/
	private String user_realname;
	private String dep_name;
	private String place_name;
	private String problem_pic_name;
	private String result_pic_name;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setSix_s_id(String six_s_id){
		this.six_s_id=six_s_id;
	}
	public String getSix_s_id(){
		return six_s_id;
	}
	public void setPlace_id(String place_id){
		this.place_id=place_id;
	}
	public String getPlace_id(){
		return place_id;
	}
	public void setDep_id(String dep_id){
		this.dep_id=dep_id;
	}
	public String getDep_id(){
		return dep_id;
	}
	public void setUser_id(String user_id){
		this.user_id=user_id;
	}
	public String getUser_id(){
		return user_id;
	}
	public void setProblem(String problem){
		this.problem=problem;
	}
	public String getProblem(){
		return problem;
	}
	public void setProblem_pic(String problem_pic){
		this.problem_pic=problem_pic;
	}
	public String getProblem_pic(){
		return problem_pic;
	}
	public void setEnd_date(String end_date){
		this.end_date=end_date;
	}
	public String getEnd_date(){
		return end_date;
	}
	public void setMeasure(String measure){
		this.measure=measure;
	}
	public String getMeasure(){
		return measure;
	}
	public void setResult_pic(String result_pic){
		this.result_pic=result_pic;
	}
	public String getResult_pic(){
		return result_pic;
	}
	public void setCreate_date(String create_date){
		this.create_date=create_date;
	}
	public String getCreate_date(){
		return create_date;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProblem_pic_name() {
		return problem_pic_name;
	}
	public void setProblem_pic_name(String problem_pic_name) {
		this.problem_pic_name = problem_pic_name;
	}
	public String getResult_pic_name() {
		return result_pic_name;
	}
	public void setResult_pic_name(String result_pic_name) {
		this.result_pic_name = result_pic_name;
	}
}
