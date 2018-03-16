package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_order 业务人员下单表 
* 2018-03-14 09:36:22  邓纯杰
*/
public class ZttOrder extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_number;/**订单号/申请号**/
	private String contract_number;/**合同号**/
	private String client;/**客户**/
	private String linkman;/**联系人**/
	private String product_name;/**产品名称**/
	private String stardard;/**规格**/
	private String attachment;/**附件**/
	private String unit;/**单位**/
	private double amount;/**数量**/
	private double single_price;/**销售单价**/
	private double sum_price;/**销售总价**/
	private String End_data;/**交货日期**/
	private String zttordertime;/**提交时间**/
	private String apply_id;/**申请人id**/
	private String state;/**状态**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setOrder_number(String order_number){
		this.order_number=order_number;
	}
	public String getOrder_number(){
		return order_number;
	}
	public void setContract_number(String contract_number){
		this.contract_number=contract_number;
	}
	public String getContract_number(){
		return contract_number;
	}
	public void setClient(String client){
		this.client=client;
	}
	public String getClient(){
		return client;
	}
	public void setLinkman(String linkman){
		this.linkman=linkman;
	}
	public String getLinkman(){
		return linkman;
	}
	public void setProduct_name(String product_name){
		this.product_name=product_name;
	}
	public String getProduct_name(){
		return product_name;
	}
	public void setStardard(String stardard){
		this.stardard=stardard;
	}
	public String getStardard(){
		return stardard;
	}
	public void setAttachment(String attachment){
		this.attachment=attachment;
	}
	public String getAttachment(){
		return attachment;
	}
	public void setUnit(String unit){
		this.unit=unit;
	}
	public String getUnit(){
		return unit;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
	public double getAmount(){
		return amount;
	}
	public void setSingle_price(double single_price){
		this.single_price=single_price;
	}
	public double getSingle_price(){
		return single_price;
	}
	public void setSum_price(double sum_price){
		this.sum_price=sum_price;
	}
	public double getSum_price(){
		return sum_price;
	}
	public void setEnd_data(String End_data){
		this.End_data=End_data;
	}
	public String getEnd_data(){
		return End_data;
	}

	public String getZttordertime() {
		return zttordertime;
	}
	public void setZttordertime(String zttordertime) {
		this.zttordertime = zttordertime;
	}
	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}
	public String getApply_id(){
		return apply_id;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return state;
	}
}
