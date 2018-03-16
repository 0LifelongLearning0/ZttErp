package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* zx_purchase_apply_detail 行政采购申领详情表 
* 2018-01-15 09:50:27  邓纯杰
*/
public class ZxPurchaseApplyDetail extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String apply_id;/**申请人**/
	private String create_time;/**申请时间**/
	private String goods_id;/**用品id**/
	private String name;/**用品id**/
	private String standard;/**用品id**/
	private double amount;/**申请数量**/
	private double amount_store;/**已到货数量**/
	private double estimated_price;/**估计价格**/
	private String reason;/**备注**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}
	public String getApply_id(){
		return apply_id;
	}
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}
	public String getCreate_time(){
		return create_time;
	}
	public void setGoods_id(String goods_id){
		this.goods_id=goods_id;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
	public double getAmount(){
		return amount;
	}
	public void setAmount_store(double amount_store){
		this.amount_store=amount_store;
	}
	public double getAmount_store(){
		return amount_store;
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public String getReason(){
		return reason;
	}
	public double getEstimated_price() {
		return estimated_price;
	}
	public void setEstimated_price(double estimated_price) {
		this.estimated_price = estimated_price;
	}
	
}
