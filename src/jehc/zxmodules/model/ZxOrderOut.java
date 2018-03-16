package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_order_out 外协订单表 
* 2017-11-03 16:56:45  邓纯杰
*/
public class ZxOrderOut extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String order_num;/**订单编号**/
	private String order_name;/**订单标题**/
	private String description;/**订单描述**/
	private String create_time;/**创建时间**/
	private String create_user_id;/**创建人**/
	private String buy_user_id;/**采购人**/
	private String buy_time;/**采购时间**/
	private String suppier_id;/**供应商**/
	private String agree_time;/**承诺到货时间**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setOrder_num(String order_num){
		this.order_num=order_num;
	}
	public String getOrder_num(){
		return order_num;
	}
	public void setOrder_name(String order_name){
		this.order_name=order_name;
	}
	public String getOrder_name(){
		return order_name;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}
	public String getCreate_time(){
		return create_time;
	}
	public void setCreate_user_id(String create_user_id){
		this.create_user_id=create_user_id;
	}
	public String getCreate_user_id(){
		return create_user_id;
	}
	public void setBuy_user_id(String buy_user_id){
		this.buy_user_id=buy_user_id;
	}
	public String getBuy_user_id(){
		return buy_user_id;
	}
	public void setBuy_time(String buy_time){
		this.buy_time=buy_time;
	}
	public String getBuy_time(){
		return buy_time;
	}
	public void setSuppier_id(String suppier_id){
		this.suppier_id=suppier_id;
	}
	public String getSuppier_id(){
		return suppier_id;
	}
	public void setAgree_time(String agree_time){
		this.agree_time=agree_time;
	}
	public String getAgree_time(){
		return agree_time;
	}
}
