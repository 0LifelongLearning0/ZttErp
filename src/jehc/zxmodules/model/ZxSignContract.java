package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* zx_sign_contract 签订合同 
* 2018-01-11 13:56:25  
*/
public class ZxSignContract extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序号**/
	private String contract_num;/**合同编号**/
	private String create_time;/**登记日期**/
	private String sign_time;/**签署日期**/
	private String begin_time;/**开始日期**/
	private String end_time;/**结束日期**/
	private String xt_user_id;/**用户id**/
	private String xt_user_name;/**用户姓名**/
	private String remark;/**备注**/
	
	public void setId(String id){
		this.id=id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getXt_user_name() {
		return xt_user_name;
	}
	public void setXt_user_name(String xt_user_name) {
		this.xt_user_name = xt_user_name;
	}
	public String getId(){
		return id;
	}
	public void setContract_num(String contract_num){
		this.contract_num=contract_num;
	}
	public String getContract_num(){
		return contract_num;
	}
	public void setXt_user_id(String xt_user_id){
		this.xt_user_id=xt_user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getSign_time() {
		return sign_time;
	}
	public void setSign_time(String sign_time) {
		this.sign_time = sign_time;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getXt_user_id(){
		return xt_user_id;
	}
}
