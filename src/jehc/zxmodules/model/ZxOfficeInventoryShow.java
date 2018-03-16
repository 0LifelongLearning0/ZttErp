package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_office_inventory 办公用品库存表 
* 2017-12-06 11:20:49  邓纯杰
*/
public class ZxOfficeInventoryShow extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String user_id;/**申请人**/
	private String create_time;/**申请时间**/
	private String approve_time;/**审批通过时间**/
	private String office_id;/**用品id**/
	private String office_name;/**用品名称**/
	private String office_num;/**用品编号**/
	private String classify_id;/**用品父id**/
	private String office_unit;/**用品单位**/
	private String standard;/**用品规格型号**/
	private double add_amount;/**补充数量**/
	private double amount;/**库存数量**/
	private String reason;/**备注**/
	private String status;/**状态**/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getAdd_amount() {
		return add_amount;
	}
	public void setAdd_amount(double add_amount) {
		this.add_amount = add_amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getApprove_time() {
		return approve_time;
	}
	public void setApprove_time(String approve_time) {
		this.approve_time = approve_time;
	}
	public String getOffice_id() {
		return office_id;
	}
	public void setOffice_id(String office_id) {
		this.office_id = office_id;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_num() {
		return office_num;
	}
	public void setOffice_num(String office_num) {
		this.office_num = office_num;
	}
	public String getClassify_id() {
		return classify_id;
	}
	public void setClassify_id(String classify_id) {
		this.classify_id = classify_id;
	}
	public String getOffice_unit() {
		return office_unit;
	}
	public void setOffice_unit(String office_unit) {
		this.office_unit = office_unit;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
