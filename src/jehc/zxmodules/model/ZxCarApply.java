package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_car_apply 车辆审批表 
* 2017-09-21 13:46:34  邓纯杰
*/
public class ZxCarApply extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**Id**/
	private String state;/**状态**/
	private String apply_type;/**申请类型**/
	private String apply_user_id;/**申请人标识**/
	private String apply_time;/**申请时间**/
	private String driver_age;/**司机驾龄**/
	private String driver_id;/**司机标识**/
	private String car_id;/**车辆Id**/
	private String apply_time_begin;/**申请用车时间始**/
	private String apply_time_end;/**申请用车时间末**/
	private String apply_car_address;/**申请用车地点**/
	private String user_car_reason;/**用车理由**/
	private String user_car_person;/**外车人员**/
	private double out_mileage;/**出车里程**/
	private String usecar_outtime;/**开始使用时间**/
	private String out_guard_id;/**出车门卫**/
	private double back_mileage;/**回公司里程**/
	private String usercar_backtime;/**结束时间**/
	private String back_guard_id;/**回司门卫**/
	private String comment;/**车辆是否损坏备注**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setApply_type(String apply_type){
		this.apply_type=apply_type;
	}
	public String getApply_type(){
		return apply_type;
	}
	public void setApply_user_id(String apply_user_id){
		this.apply_user_id=apply_user_id;
	}
	public String getApply_user_id(){
		return apply_user_id;
	}
	public void setApply_time(String apply_time){
		this.apply_time=apply_time;
	}
	public String getApply_time(){
		return apply_time;
	}
	public void setDriver_age(String driver_age){
		this.driver_age=driver_age;
	}
	public String getDriver_age(){
		return driver_age;
	}
	public void setDriver_id(String driver_id){
		this.driver_id=driver_id;
	}
	public String getDriver_id(){
		return driver_id;
	}
	public void setCar_id(String car_id){
		this.car_id=car_id;
	}
	public String getCar_id(){
		return car_id;
	}
	public void setApply_time_begin(String apply_time_begin){
		this.apply_time_begin=apply_time_begin;
	}
	public String getApply_time_begin(){
		return apply_time_begin;
	}
	public void setApply_time_end(String apply_time_end){
		this.apply_time_end=apply_time_end;
	}
	public String getApply_time_end(){
		return apply_time_end;
	}
	public void setApply_car_address(String apply_car_address){
		this.apply_car_address=apply_car_address;
	}
	public String getApply_car_address(){
		return apply_car_address;
	}
	public void setUser_car_reason(String user_car_reason){
		this.user_car_reason=user_car_reason;
	}
	public String getUser_car_reason(){
		return user_car_reason;
	}
	public void setUser_car_person(String user_car_person){
		this.user_car_person=user_car_person;
	}
	public String getUser_car_person(){
		return user_car_person;
	}
	public void setOut_mileage(double out_mileage){
		this.out_mileage=out_mileage;
	}
	public double getOut_mileage(){
		return out_mileage;
	}
	public void setUsecar_outtime(String usecar_outtime){
		this.usecar_outtime=usecar_outtime;
	}
	public String getUsecar_outtime(){
		return usecar_outtime;
	}
	public void setOut_guard_id(String out_guard_id){
		this.out_guard_id=out_guard_id;
	}
	public String getOut_guard_id(){
		return out_guard_id;
	}
	public void setBack_mileage(double back_mileage){
		this.back_mileage=back_mileage;
	}
	public double getBack_mileage(){
		return back_mileage;
	}
	public void setUsercar_backtime(String usercar_backtime){
		this.usercar_backtime=usercar_backtime;
	}
	public String getUsercar_backtime(){
		return usercar_backtime;
	}
	public void setBack_guard_id(String back_guard_id){
		this.back_guard_id=back_guard_id;
	}
	public String getBack_guard_id(){
		return back_guard_id;
	}
	public void setComment(String comment){
		this.comment=comment;
	}
	public String getComment(){
		return comment;
	}
}
