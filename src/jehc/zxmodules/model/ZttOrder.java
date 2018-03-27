package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* ztt_order 业务人员下单表 
* 2018-03-20 16:18:05  邓纯杰
*/
public class ZttOrder extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_number;/**订单号/申请号**/
	private String contract_number;/**合同号**/
	private String erp_number;/**erp号**/
	private String product_order_number;/**工令号**/
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
	private String personname;/**交货日期**/
	private String zttordertime;/**提交时间**/
	private String apply_id;/**申请人id**/
	private String state;/**状态**/
	private String techmanager_id;/**状态**/
	private String techmanager_produc_id;/**状态**/
	private String techmanager_update_date;/**状态**/
	private String techmanager_attachment;/**状态**/
	private String producter_id;
	private String product_end_time;
	private List<ztt_processproduct> ztt_processproduct;/**用品申领详细表**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	
	public String getProducter_id() {
		return producter_id;
	}
	public void setProducter_id(String producter_id) {
		this.producter_id = producter_id;
	}
	public String getProduct_end_time() {
		return product_end_time;
	}
	public void setProduct_end_time(String product_end_time) {
		this.product_end_time = product_end_time;
	}
	public List<ztt_processproduct> getZtt_processproduct() {
		return ztt_processproduct;
	}
	public void setZtt_processproduct(List<ztt_processproduct> ztt_processproduct) {
		this.ztt_processproduct = ztt_processproduct;
	}
	public void setOrder_number(String order_number){
		this.order_number=order_number;
	}
	public String getOrder_number(){
		return order_number;
	}
	
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public void setContract_number(String contract_number){
		this.contract_number=contract_number;
	}
	public String getContract_number(){
		return contract_number;
	}
	public void setErp_number(String erp_number){
		this.erp_number=erp_number;
	}
	public String getErp_number(){
		return erp_number;
	}
	public void setProduct_order_number(String product_order_number){
		this.product_order_number=product_order_number;
	}
	public String getProduct_order_number(){
		return product_order_number;
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
	public void setZttordertime(String zttordertime){
		this.zttordertime=zttordertime;
	}
	public String getZttordertime(){
		return zttordertime;
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
	public String getTechmanager_id() {
		return techmanager_id;
	}
	public void setTechmanager_id(String techmanager_id) {
		this.techmanager_id = techmanager_id;
	}
	public String getTechmanager_produc_id() {
		return techmanager_produc_id;
	}
	public void setTechmanager_produc_id(String techmanager_produc_id) {
		this.techmanager_produc_id = techmanager_produc_id;
	}
	public String getTechmanager_update_date() {
		return techmanager_update_date;
	}
	public void setTechmanager_update_date(String techmanager_update_date) {
		this.techmanager_update_date = techmanager_update_date;
	}
	public String getTechmanager_attachment() {
		return techmanager_attachment;
	}
	public void setTechmanager_attachment(String techmanager_attachment) {
		this.techmanager_attachment = techmanager_attachment;
	}
	
}
