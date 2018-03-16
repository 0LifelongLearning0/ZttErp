package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_office_inventory 办公用品库存表 
* 2017-12-06 11:20:49  邓纯杰
*/
public class ZxOfficeInventoryAdd extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String user_id;/**申请人**/
	private String create_time;/**申请时间**/
	private String office_id;/**用品id**/
	private double amount;/**补充数量**/
	private String reason;/**备注**/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getOffice_id() {
		return office_id;
	}
	public void setOffice_id(String office_id) {
		this.office_id = office_id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
