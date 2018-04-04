package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_purchase 采购台账 
* 2018-04-03 12:43:49  邓纯杰
*/
public class ZttPurchase extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String Product_order_number;/**工令号**/
	private String purchase_name;/**名称**/
	private String purchase_stardard;/**规格**/
	private String material;/**材质**/
	private String unit;/**单位**/
	private double amount;/**数量**/
	private String hope_end_data;/**交期**/
	private String apply_id;/**发起人id**/
	private double Product_id;/**采购人id**/
	private double single_price;/**单价**/
	private double sum_price;/**总价**/
	private String qualified_id;/**检验员id**/
	private String qualified_number;/**合格件数**/
	private String qualified_date;/**检验员日期**/
	private String check_attachment;/**检验文件**/
	private String state;
	private String supply_name;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	public String getSupply_name() {
		return supply_name;
	}
	public void setSupply_name(String supply_name) {
		this.supply_name = supply_name;
	}
	public void setProduct_order_number(String Product_order_number){
		this.Product_order_number=Product_order_number;
	}
	public String getProduct_order_number(){
		return Product_order_number;
	}
	public void setPurchase_name(String purchase_name){
		this.purchase_name=purchase_name;
	}
	public String getPurchase_name(){
		return purchase_name;
	}
	public void setPurchase_stardard(String purchase_stardard){
		this.purchase_stardard=purchase_stardard;
	}
	public String getPurchase_stardard(){
		return purchase_stardard;
	}
	public void setMaterial(String material){
		this.material=material;
	}
	public String getMaterial(){
		return material;
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
	public void setHope_end_data(String hope_end_data){
		this.hope_end_data=hope_end_data;
	}
	public String getHope_end_data(){
		return hope_end_data;
	}
	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}
	public String getApply_id(){
		return apply_id;
	}
	public void setProduct_id(double Product_id){
		this.Product_id=Product_id;
	}
	public double getProduct_id(){
		return Product_id;
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
	public void setQualified_id(String qualified_id){
		this.qualified_id=qualified_id;
	}
	public String getQualified_id(){
		return qualified_id;
	}
	public void setQualified_number(String qualified_number){
		this.qualified_number=qualified_number;
	}
	public String getQualified_number(){
		return qualified_number;
	}
	public void setQualified_date(String qualified_date){
		this.qualified_date=qualified_date;
	}
	public String getQualified_date(){
		return qualified_date;
	}
	public void setCheck_attachment(String check_attachment){
		this.check_attachment=check_attachment;
	}
	public String getCheck_attachment(){
		return check_attachment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
