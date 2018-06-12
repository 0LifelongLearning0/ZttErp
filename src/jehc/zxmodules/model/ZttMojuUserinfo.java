package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_moju_userinfo 模具部车间员工信息表 
* 2018-05-29 13:39:52  
*/
public class ZttMojuUserinfo extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String xt_userinfo_id;/**用户ID**/
	private String xt_device_id;/**所属设备id**/
	private String xt_userinfo_name;/**用户名**/
	private String xt_userinfo_passWord;/**密码**/
	private int xt_userinfo_isDelete;/**0-未删除，1-删除**/
	private String xt_userinfo_realName;/**真实姓名**/
	private String xt_userinfo_sex;/**性别:数据字典**/
	private String xt_userinfo_mobile;/**移动电话**/
	private String xt_userinfo_ortherTel;/**其他电话**/
	private String isonjob;/**是否离职**/
	private String xt_userinfo_intime;/**入职时间**/
	private String xt_userinfo_outTime;/**离职时间**/
	private String xt_userinfo_qq;/**qq号码**/
	private String device_name;
	private String gongxu_name;
	
	
	public String getGongxu_name() {
		return gongxu_name;
	}
	public void setGongxu_name(String gongxu_name) {
		this.gongxu_name = gongxu_name;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public void setXt_userinfo_id(String xt_userinfo_id){
		this.xt_userinfo_id=xt_userinfo_id;
	}
	public String getXt_userinfo_id(){
		return xt_userinfo_id;
	}
	public void setXt_device_id(String xt_device_id){
		this.xt_device_id=xt_device_id;
	}
	public String getXt_device_id(){
		return xt_device_id;
	}
	public void setXt_userinfo_name(String xt_userinfo_name){
		this.xt_userinfo_name=xt_userinfo_name;
	}
	public String getXt_userinfo_name(){
		return xt_userinfo_name;
	}
	public void setXt_userinfo_passWord(String xt_userinfo_passWord){
		this.xt_userinfo_passWord=xt_userinfo_passWord;
	}
	public String getXt_userinfo_passWord(){
		return xt_userinfo_passWord;
	}
	public void setXt_userinfo_isDelete(int xt_userinfo_isDelete){
		this.xt_userinfo_isDelete=xt_userinfo_isDelete;
	}
	public int getXt_userinfo_isDelete(){
		return xt_userinfo_isDelete;
	}
	public void setXt_userinfo_realName(String xt_userinfo_realName){
		this.xt_userinfo_realName=xt_userinfo_realName;
	}
	public String getXt_userinfo_realName(){
		return xt_userinfo_realName;
	}
	public void setXt_userinfo_sex(String xt_userinfo_sex){
		this.xt_userinfo_sex=xt_userinfo_sex;
	}
	public String getXt_userinfo_sex(){
		return xt_userinfo_sex;
	}
	public void setXt_userinfo_mobile(String xt_userinfo_mobile){
		this.xt_userinfo_mobile=xt_userinfo_mobile;
	}
	public String getXt_userinfo_mobile(){
		return xt_userinfo_mobile;
	}
	public void setXt_userinfo_ortherTel(String xt_userinfo_ortherTel){
		this.xt_userinfo_ortherTel=xt_userinfo_ortherTel;
	}
	public String getXt_userinfo_ortherTel(){
		return xt_userinfo_ortherTel;
	}
	public void setIsonjob(String isonjob){
		this.isonjob=isonjob;
	}
	public String getIsonjob(){
		return isonjob;
	}
	public void setXt_userinfo_intime(String xt_userinfo_intime){
		this.xt_userinfo_intime=xt_userinfo_intime;
	}
	public String getXt_userinfo_intime(){
		return xt_userinfo_intime;
	}
	public void setXt_userinfo_outTime(String xt_userinfo_outTime){
		this.xt_userinfo_outTime=xt_userinfo_outTime;
	}
	public String getXt_userinfo_outTime(){
		return xt_userinfo_outTime;
	}
	public void setXt_userinfo_qq(String xt_userinfo_qq){
		this.xt_userinfo_qq=xt_userinfo_qq;
	}
	public String getXt_userinfo_qq(){
		return xt_userinfo_qq;
	}
}
