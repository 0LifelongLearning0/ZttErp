package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* ztt_order 业务人员下单表 
* 2018-03-20 16:18:05  
*/
public class ZttOrderCheckHistory extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_id;/**订单号/申请号**/
	private String bussinessid;/**订单号/申请号**/
	private String product_check_self_attachment;
	private String product_check_self_time;
	private String product_check_attachment;
	private String product_check_comment;	
	private String product_check_time;	
	private String product_check_dep_attachment;	
	private String product_check_dep_comment;	
	private String product_check_dep_time;	
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBussinessid() {
		return bussinessid;
	}
	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_check_self_attachment() {
		return product_check_self_attachment;
	}
	public void setProduct_check_self_attachment(String product_check_self_attachment) {
		this.product_check_self_attachment = product_check_self_attachment;
	}
	public String getProduct_check_self_time() {
		return product_check_self_time;
	}
	public void setProduct_check_self_time(String product_check_self_time) {
		this.product_check_self_time = product_check_self_time;
	}
	public String getProduct_check_attachment() {
		return product_check_attachment;
	}
	public void setProduct_check_attachment(String product_check_attachment) {
		this.product_check_attachment = product_check_attachment;
	}
	public String getProduct_check_comment() {
		return product_check_comment;
	}
	public void setProduct_check_comment(String product_check_comment) {
		this.product_check_comment = product_check_comment;
	}
	public String getProduct_check_time() {
		return product_check_time;
	}
	public void setProduct_check_time(String product_check_time) {
		this.product_check_time = product_check_time;
	}
	public String getProduct_check_dep_attachment() {
		return product_check_dep_attachment;
	}
	public void setProduct_check_dep_attachment(String product_check_dep_attachment) {
		this.product_check_dep_attachment = product_check_dep_attachment;
	}
	public String getProduct_check_dep_comment() {
		return product_check_dep_comment;
	}
	public void setProduct_check_dep_comment(String product_check_dep_comment) {
		this.product_check_dep_comment = product_check_dep_comment;
	}
	public String getProduct_check_dep_time() {
		return product_check_dep_time;
	}
	public void setProduct_check_dep_time(String product_check_dep_time) {
		this.product_check_dep_time = product_check_dep_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	


}
