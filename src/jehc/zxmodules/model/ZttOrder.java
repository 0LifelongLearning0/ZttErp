package jehc.zxmodules.model;

import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ztt_order 业务人员下单表 2018-03-20 16:18:05 邓纯杰
 */
public class ZttOrder extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	/** 序列号 **/
	private String order_number;
	/** 订单号/申请号 **/
	private String contract_number;
	/** 合同号 **/
	private String erp_number;
	/** erp号 **/
	private String product_order_number;
	/** 工令号 **/
	private String client;
	/** 客户 **/
	private String linkman;
	/** 联系人 **/
	private String product_name;
	/** 产品名称 **/
	private String stardard;
	/** 规格 **/
	private String attachment;
	/** 附件 **/
	private String unit;
	/** 单位 **/
	private double amount;
	/** 数量 **/
	private double single_price;
	/** 销售单价 **/
	private double sum_price;
	/** 销售总价 **/
	private String End_data;
	/** 交货日期 **/
	private String personname;
	/** 交货日期 **/
	private String zttordertime;
	/** 提交时间 **/
	private String apply_id;
	/** 申请人id **/
	private String state;
	/** 状态 **/
	private String techmanager_id;
	/** 状态 **/
	private String techmanager_produc_id;
	/** 状态 **/
	private String techmanager_update_date;
	/** 状态 **/
	private String techmanager_attachment;
	/** 状态 **/
	private String producter_selfcheck_attachment;
	private String producter_id;
	private String product_end_time;
	private String machine_part;
	/** 零件名称 **/
	private String machine_part_number;
	/** 零件图号 **/
	private String material_id;
	/** 材料牌号 **/
	private String checker_id;
	private String checker_attachment;
	private String check_end_time;
	private String dept_check_id;
	private String dept_check_attachment;
	private String dept_check_end_time;
	private String purchase_arrival_date;
	private String supplier_name;
	private double supplier_price;
	private String not_satisfy_reason;
	private String cato_type;
	private String delivery_note;
	private String send_time;
	private String supplier_bill_date;
	private String supplier_bill_price;
	private double cost_single_price;
	private double cost_sum_price;
	private double send_amount;
	private String bill_date_open;
	private String bill_price;
	private String cost_share;
	private List<ztt_processproduct> ztt_processproduct;

	/** 用品申领详细表 **/

	public void setId(String id) {
		this.id = id;
	}

	public String getDept_check_id() {
		return dept_check_id;
	}

	public String getBill_date_open() {
		return bill_date_open;
	}

	public void setBill_date_open(String bill_date_open) {
		this.bill_date_open = bill_date_open;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}


	public String getDelivery_note() {
		return delivery_note;
	}

	public void setDelivery_note(String delivery_note) {
		this.delivery_note = delivery_note;
	}

	public String getCato_type() {
		return cato_type;
	}

	public void setCato_type(String cato_type) {
		this.cato_type = cato_type;
	}

	public String getNot_satisfy_reason() {
		return not_satisfy_reason;
	}

	public void setNot_satisfy_reason(String not_satisfy_reason) {
		this.not_satisfy_reason = not_satisfy_reason;
	}

	public String getPurchase_arrival_date() {
		return purchase_arrival_date;
	}

	public void setPurchase_arrival_date(String purchase_arrival_date) {
		this.purchase_arrival_date = purchase_arrival_date;
	}

	public String getProducter_selfcheck_attachment() {
		return producter_selfcheck_attachment;
	}

	public void setProducter_selfcheck_attachment(String producter_selfcheck_attachment) {
		this.producter_selfcheck_attachment = producter_selfcheck_attachment;
	}

	public void setDept_check_id(String dept_check_id) {
		this.dept_check_id = dept_check_id;
	}

	public String getDept_check_attachment() {
		return dept_check_attachment;
	}

	public void setDept_check_attachment(String dept_check_attachment) {
		this.dept_check_attachment = dept_check_attachment;
	}

	public String getDept_check_end_time() {
		return dept_check_end_time;
	}

	public void setDept_check_end_time(String dept_check_end_time) {
		this.dept_check_end_time = dept_check_end_time;
	}

	public String getId() {
		return id;
	}

	public String getChecker_id() {
		return checker_id;
	}

	public void setChecker_id(String checker_id) {
		this.checker_id = checker_id;
	}

	public String getChecker_attachment() {
		return checker_attachment;
	}

	public void setChecker_attachment(String checker_attachment) {
		this.checker_attachment = checker_attachment;
	}

	public String getCheck_end_time() {
		return check_end_time;
	}

	public void setCheck_end_time(String check_end_time) {
		this.check_end_time = check_end_time;
	}

	public String getProduct_end_time() {
		return product_end_time;
	}

	public void setProduct_end_time(String product_end_time) {
		this.product_end_time = product_end_time;
	}

	public String getMachine_part() {
		return machine_part;
	}

	public void setMachine_part(String machine_part) {
		this.machine_part = machine_part;
	}

	public String getMachine_part_number() {
		return machine_part_number;
	}

	public void setMachine_part_number(String machine_part_number) {
		this.machine_part_number = machine_part_number;
	}

	public String getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(String material_id) {
		this.material_id = material_id;
	}

	public String getProducter_id() {
		return producter_id;
	}

	public void setProducter_id(String producter_id) {
		this.producter_id = producter_id;
	}

	public List<ztt_processproduct> getZtt_processproduct() {
		return ztt_processproduct;
	}

	public void setZtt_processproduct(List<ztt_processproduct> ztt_processproduct) {
		this.ztt_processproduct = ztt_processproduct;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getOrder_number() {
		return order_number;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}

	public String getContract_number() {
		return contract_number;
	}

	public void setErp_number(String erp_number) {
		this.erp_number = erp_number;
	}

	public String getErp_number() {
		return erp_number;
	}

	public void setProduct_order_number(String product_order_number) {
		this.product_order_number = product_order_number;
	}

	public String getProduct_order_number() {
		return product_order_number;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getClient() {
		return client;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setStardard(String stardard) {
		this.stardard = stardard;
	}

	public String getStardard() {
		return stardard;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setSingle_price(double single_price) {
		this.single_price = single_price;
	}

	public double getSingle_price() {
		return single_price;
	}

	public void setSum_price(double sum_price) {
		this.sum_price = sum_price;
	}

	public double getSum_price() {
		return sum_price;
	}

	public void setEnd_data(String End_data) {
		this.End_data = End_data;
	}

	public String getEnd_data() {
		return End_data;
	}

	public void setZttordertime(String zttordertime) {
		this.zttordertime = zttordertime;
	}

	public String getZttordertime() {
		return zttordertime;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
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

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public double getSupplier_price() {
		return supplier_price;
	}

	public void setSupplier_price(double supplier_price) {
		this.supplier_price = supplier_price;
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

	public double getSend_amount() {
		return send_amount;
	}

	public void setSend_amount(double send_amount) {
		this.send_amount = send_amount;
	}

	public String getBill_price() {
		return bill_price;
	}

	public void setBill_price(String bill_price) {
		this.bill_price = bill_price;
	}

	public String getCost_share() {
		return cost_share;
	}

	public void setCost_share(String cost_share) {
		this.cost_share = cost_share;
	}

}
