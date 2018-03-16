package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import jehc.xtmodules.xtmodel.XtDepartinfo;

import java.io.Serializable;
import java.util.Date;

/**
* zx_reserved_funds 公积金台账 
* 2018-01-18 08:15:15  邓纯杰
*/
public class ZxReservedFunds extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序号**/
	private String xt_departinfo_id;/**部门id**/
	private String xt_user_id;/**员工id**/
	private String annum;/**年**/
	private String month;/**月**/
	private String cardinal_num;/**新基数**/
	private String company_payment;/**单位缴存**/
	private String person_payment;/**个人缴存**/
	private String sum_payment;/**合计**/
	private String person_account;/**个人账号**/
	private String create_time;/**记录时间**/
	private String remark;/**备注**/
	private String Xt_departinfo_name;/**部门**/
	public void setId(String id){
		this.id=id;
	}

	public String getXt_departinfo_name() {
		return Xt_departinfo_name;
	}

	public void setXt_departinfo_name(String xt_departinfo_name) {
		Xt_departinfo_name = xt_departinfo_name;
	}

	public String getId(){
		return id;
	}
	public void setXt_departinfo_id(String xt_departinfo_id){
		this.xt_departinfo_id=xt_departinfo_id;
	}
	public String getXt_departinfo_id(){
		return xt_departinfo_id;
	}
	public void setXt_user_id(String xt_user_id){
		this.xt_user_id=xt_user_id;
	}
	public String getXt_user_id(){
		return xt_user_id;
	}
	public String getAnnum() {
		return annum;
	}
	public void setAnnum(String annum) {
		this.annum = annum;
	}
	public void setMonth(String month){
		this.month=month;
	}
	public String getMonth(){
		return month;
	}
	public void setCardinal_num(String cardinal_num){
		this.cardinal_num=cardinal_num;
	}
	public String getCardinal_num(){
		return cardinal_num;
	}
	public void setCompany_payment(String company_payment){
		this.company_payment=company_payment;
	}
	public String getCompany_payment(){
		return company_payment;
	}
	public void setPerson_payment(String person_payment){
		this.person_payment=person_payment;
	}
	public String getPerson_payment(){
		return person_payment;
	}
	public void setSum_payment(String sum_payment){
		this.sum_payment=sum_payment;
	}
	public String getSum_payment(){
		return sum_payment;
	}
	public void setPerson_account(String person_account){
		this.person_account=person_account;
	}
	public String getPerson_account(){
		return person_account;
	}
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}
	public String getCreate_time(){
		return create_time;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
}
