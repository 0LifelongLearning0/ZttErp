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
