package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_order 业务人员下单表 
* 2018-03-19 13:39:55  邓纯杰
*/
public class ZttOrdernumber extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String ordernumber_first;/**订单号/申请号**/
	private String ordernumber_second;/**合同号**/
	private String ordernumber_third;/**工令号**/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrdernumber_first() {
		return ordernumber_first;
	}
	public void setOrdernumber_first(String ordernumber_first) {
		this.ordernumber_first = ordernumber_first;
	}
	public String getOrdernumber_second() {
		return ordernumber_second;
	}
	public void setOrdernumber_second(String ordernumber_second) {
		this.ordernumber_second = ordernumber_second;
	}
	public String getOrdernumber_third() {
		return ordernumber_third;
	}
	public void setOrdernumber_third(String ordernumber_third) {
		this.ordernumber_third = ordernumber_third;
	}
	
}
