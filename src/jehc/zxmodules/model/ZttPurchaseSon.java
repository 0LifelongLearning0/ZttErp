package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_purchase_son 采购子台账 
* 2018-04-29 10:08:25  
*/
public class ZttPurchaseSon extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String parent_id;/**父id**/
	private String name;/**名称**/
	private String purchase_stardard;/**规格**/
	private String material;/**材质**/
	private String unit;/**单位**/
	private double amount;/**数量**/
	private String attachment;/**文件地址**/
	private double single_price;/**数量**/
	private String erp_number;
	private String supplier_bill_date;
	private String supplier_bill_price;
	private String end_data;
	private String send_amount;
	private String product;
	private String Product_order_number;
	private String hope_end_data;
	private String project;
	private String comment;
	
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getHope_end_data() {
		return hope_end_data;
	}
	public void setHope_end_data(String hope_end_data) {
		this.hope_end_data = hope_end_data;
	}
	public String getProduct_order_number() {
		return Product_order_number;
	}
	public void setProduct_order_number(String product_order_number) {
		Product_order_number = product_order_number;
	}
	public String getEnd_data() {
		return end_data;
	}
	public void setEnd_data(String end_data) {
		this.end_data = end_data;
	}
	public String getSend_amount() {
		return send_amount;
	}
	public void setSend_amount(String send_amount) {
		this.send_amount = send_amount;
	}
	public String getSupplier_bill_date() {
		return supplier_bill_date;
	}
	public void setSupplier_bill_date(String supplier_bill_date) {
		this.supplier_bill_date = supplier_bill_date;
	}
	public String getSupplier_bill_price() {
		return supplier_bill_price;
	}
	public void setSupplier_bill_price(String supplier_bill_price) {
		this.supplier_bill_price = supplier_bill_price;
	}
	public void setId(String id){
		this.id=id;
	}
	public double getSingle_price() {
		return single_price;
	}
	public void setSingle_price(double single_price) {
		this.single_price = single_price;
	}
	
	public String getErp_number() {
		return erp_number;
	}
	public void setErp_number(String erp_number) {
		this.erp_number = erp_number;
	}
	public String getId(){
		return id;
	}
	public void setParent_id(String parent_id){
		this.parent_id=parent_id;
	}
	public String getParent_id(){
		return parent_id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
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
	public void setAttachment(String attachment){
		this.attachment=attachment;
	}
	public String getAttachment(){
		return attachment;
	}
}
