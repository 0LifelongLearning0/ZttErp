package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_train_apply 员工培训申请表 
* 2017-12-15 11:34:23  邓纯杰
*/
public class ZxTrainApply extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String train_dept;/**申请部门**/
	private String train_userid;/**申请人**/
	private String create_time;/**申请时间**/
	private String approve_time;/**审批通过时间**/
	private int train_num;/**参加培训人数**/
	private String train_name;/**培训项目名称**/
	private String train_purpose;/**培训目的**/
	private String train_cato;/**培训方式**/
	private String train_address;/**培训地点**/
	private String train_agreement;/**是否签署培训协议**/
	private double train_fee;/**培训费用**/
	private String remark;/**备注**/
	private String train_plan;
	private String train_effect;
	private String status;/**状态**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setTrain_dept(String train_dept){
		this.train_dept=train_dept;
	}
	public String getTrain_dept(){
		return train_dept;
	}
	public void setTrain_userid(String train_userid){
		this.train_userid=train_userid;
	}
	public String getTrain_userid(){
		return train_userid;
	}
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}
	public String getCreate_time(){
		return create_time;
	}
	public void setApprove_time(String approve_time){
		this.approve_time=approve_time;
	}
	public String getApprove_time(){
		return approve_time;
	}
	public void setTrain_num(int train_num){
		this.train_num=train_num;
	}
	public int getTrain_num(){
		return train_num;
	}
	public void setTrain_name(String train_name){
		this.train_name=train_name;
	}
	public String getTrain_name(){
		return train_name;
	}
	public void setTrain_purpose(String train_purpose){
		this.train_purpose=train_purpose;
	}
	public String getTrain_purpose(){
		return train_purpose;
	}
	public void setTrain_cato(String train_cato){
		this.train_cato=train_cato;
	}
	public String getTrain_cato(){
		return train_cato;
	}
	public void setTrain_address(String train_address){
		this.train_address=train_address;
	}
	public String getTrain_address(){
		return train_address;
	}
	public void setTrain_agreement(String train_agreement){
		this.train_agreement=train_agreement;
	}
	public String getTrain_agreement(){
		return train_agreement;
	}
	public void setTrain_fee(double train_fee){
		this.train_fee=train_fee;
	}
	public double getTrain_fee(){
		return train_fee;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public String getTrain_plan() {
		return train_plan;
	}
	public void setTrain_plan(String train_plan) {
		this.train_plan = train_plan;
	}
	public String getTrain_effect() {
		return train_effect;
	}
	public void setTrain_effect(String train_effect) {
		this.train_effect = train_effect;
	}
	
}
