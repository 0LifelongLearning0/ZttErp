package jehc.zxmodules.model;

public class ztt_processproduct {
	private String id;/**序列号**/
	private String order_id;/**订单号/申请号**/
	private String Processname;/**合同号**/
	private String Processcontent;
	private String equipment;
	private String tooling;
	private double single_price;
	private double sum_price;
	private String product_person_id;
	private String product_date;
	private String qualified_number;
	private String qualified_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProcessname() {
		return Processname;
	}
	public void setProcessname(String processname) {
		Processname = processname;
	}
	public String getProcesscontent() {
		return Processcontent;
	}
	public void setProcesscontent(String processcontent) {
		Processcontent = processcontent;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getTooling() {
		return tooling;
	}
	public void setTooling(String tooling) {
		this.tooling = tooling;
	}
	public double getSingle_price() {
		return single_price;
	}
	public void setSingle_price(double single_price) {
		this.single_price = single_price;
	}
	public double getSum_price() {
		return sum_price;
	}
	public void setSum_price(double sum_price) {
		this.sum_price = sum_price;
	}
	public String getProduct_person_id() {
		return product_person_id;
	}
	public void setProduct_person_id(String product_person_id) {
		this.product_person_id = product_person_id;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public String getQualified_number() {
		return qualified_number;
	}
	public void setQualified_number(String qualified_number) {
		this.qualified_number = qualified_number;
	}
	public String getQualified_date() {
		return qualified_date;
	}
	public void setQualified_date(String qualified_date) {
		this.qualified_date = qualified_date;
	}
	
}
