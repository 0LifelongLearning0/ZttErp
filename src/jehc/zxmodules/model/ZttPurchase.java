package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* ztt_purchase 采购台账 
* 2018-04-03 12:43:49  
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
	private String apply_time;/**发起人id**/
	private double Product_id;/**采购人id**/
	private double single_price;/**单价**/
	private double sum_price;/**总价**/
	private String qualified_id;/**检验员id**/
	private String qualified_number;/**合格件数**/
	private String qualified_date;/**检验员日期**/
	private String check_attachment;/**检验文件**/
	private String personname;
	private String delivery_note;
	private String state;
	private String supply_name;
	private String erp_number;
	private String not_satisfy_reason;
	private double cost_single_price;
	private double cost_sum_price;
	private String supplier_bill_date;
	private String supplier_bill_price;
	private String end_data;
	private String attachment;
	private String send_amount;
	private String project;
	private String comment;
	private List<ZttPurchaseSon> zttPurchaseSon;/**采购子台账**/
	private String zttPurchaseSon_removed_flag;/**采购子台账移除标识**/
	public String getNot_satisfy_reason() {
		return not_satisfy_reason;
	}
	public void setNot_satisfy_reason(String not_satisfy_reason) {
		this.not_satisfy_reason = not_satisfy_reason;
	}
	
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
	public String getSend_amount() {
		return send_amount;
	}
	public void setSend_amount(String send_amount) {
		this.send_amount = send_amount;
	}
	public String getZttPurchaseSon_removed_flag() {
		return zttPurchaseSon_removed_flag;
	}
	public void setZttPurchaseSon_removed_flag(String zttPurchaseSon_removed_flag) {
		this.zttPurchaseSon_removed_flag = zttPurchaseSon_removed_flag;
	}
	public String getDelivery_note() {
		return delivery_note;
	}
	public void setDelivery_note(String delivery_note) {
		this.delivery_note = delivery_note;
	}
	public double getCost_single_price() {
		return cost_single_price;
	}
	public void setCost_single_price(double cost_single_price) {
		this.cost_single_price = cost_single_price;
	}
	public double getCost_sum_price() {
		return cost_sum_price;
	}
	public void setCost_sum_price(double cost_sum_price) {
		this.cost_sum_price = cost_sum_price;
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
	public String getEnd_data() {
		return end_data;
	}
	public void setEnd_data(String end_data) {
		this.end_data = end_data;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
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
	public String getErp_number() {
		return erp_number;
	}
	public void setErp_number(String erp_number) {
		this.erp_number = erp_number;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public void setZttPurchaseSon(List<ZttPurchaseSon> zttPurchaseSon){
		this.zttPurchaseSon=zttPurchaseSon;
	}
	public List<ZttPurchaseSon> getZttPurchaseSon(){
		return zttPurchaseSon;
	}
}
