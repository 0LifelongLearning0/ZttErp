package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_processproduct 机械加工工艺过程表 
* 2018-04-24 14:27:01  邓纯杰
*/
public class ZttProcessproduct extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_id;/**订单号id**/
	private String parentId;/**父id**/
	private String Processname;/**工序名称**/
	private String Processcontent;/**工序内容**/
	private String equipment;/**设备**/
	private String tooling;/**工艺装备**/
	private double single_price;/**单价**/
	private double sum_price;/**总价**/
	private String product_person_id;/**操作者**/
	private String product_date;/**操作者日期**/
	private String qualified_number;/**合格件数**/
	private String qualified_date;/**检验员日期**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setOrder_id(String order_id){
		this.order_id=order_id;
	}
	public String getOrder_id(){
		return order_id;
	}
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	public String getParentId(){
		return parentId;
	}
	public void setProcessname(String Processname){
		this.Processname=Processname;
	}
	public String getProcessname(){
		return Processname;
	}
	public void setProcesscontent(String Processcontent){
		this.Processcontent=Processcontent;
	}
	public String getProcesscontent(){
		return Processcontent;
	}
	public void setEquipment(String equipment){
		this.equipment=equipment;
	}
	public String getEquipment(){
		return equipment;
	}
	public void setTooling(String tooling){
		this.tooling=tooling;
	}
	public String getTooling(){
		return tooling;
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
	public void setProduct_person_id(String product_person_id){
		this.product_person_id=product_person_id;
	}
	public String getProduct_person_id(){
		return product_person_id;
	}
	public void setProduct_date(String product_date){
		this.product_date=product_date;
	}
	public String getProduct_date(){
		return product_date;
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
}
