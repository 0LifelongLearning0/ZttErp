package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_orderbybuy 外协单表 
* 2018-03-21 10:45:03  
*/
public class ZttOrderbybuy extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_id;/**订单号id**/
	private String buymanager_id;/**采购人员id**/
	private String buy_end_data;/**确认交货日期**/
	private String update_date;/**提交日期**/
	private String product_dispatch_id;/**检验人员id**/
	private String product_dispatch_attachment;/**检验报告**/
	private String product_is_qualified;/**是否合格**/
	private String product_update_date;/**检验人员提交日期**/
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
	public void setBuymanager_id(String buymanager_id){
		this.buymanager_id=buymanager_id;
	}
	public String getBuymanager_id(){
		return buymanager_id;
	}
	public void setBuy_end_data(String buy_end_data){
		this.buy_end_data=buy_end_data;
	}
	public String getBuy_end_data(){
		return buy_end_data;
	}
	public void setUpdate_date(String update_date){
		this.update_date=update_date;
	}
	public String getUpdate_date(){
		return update_date;
	}
	public void setProduct_dispatch_id(String product_dispatch_id){
		this.product_dispatch_id=product_dispatch_id;
	}
	public String getProduct_dispatch_id(){
		return product_dispatch_id;
	}
	public void setProduct_dispatch_attachment(String product_dispatch_attachment){
		this.product_dispatch_attachment=product_dispatch_attachment;
	}
	public String getProduct_dispatch_attachment(){
		return product_dispatch_attachment;
	}
	public void setProduct_is_qualified(String product_is_qualified){
		this.product_is_qualified=product_is_qualified;
	}
	public String getProduct_is_qualified(){
		return product_is_qualified;
	}
	public void setProduct_update_date(String product_update_date){
		this.product_update_date=product_update_date;
	}
	public String getProduct_update_date(){
		return product_update_date;
	}
}
