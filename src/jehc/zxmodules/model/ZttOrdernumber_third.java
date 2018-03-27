package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_order 业务人员下单表 
* 2018-03-19 13:39:55  邓纯杰
*/
public class ZttOrdernumber_third extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ordernumber_third;/**序列号**/
	private String order_id;/**订单号/申请号**/
	public int getOrdernumber_third() {
		return ordernumber_third;
	}
	public void setOrdernumber_third(int ordernumber_third) {
		this.ordernumber_third = ordernumber_third;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
