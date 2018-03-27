package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_orderbyself 自制单表 
* 2018-03-20 17:26:52  邓纯杰
*/
public class ZttOrderbyself extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_id;/**订单号id**/
	private String techmanager_id;/**技术主管id**/
	private String attachment;/**工艺资料**/
	private String update_date;/**提交日期**/
	private String product_dispatch_id;/**生产调度人员id**/
	private String product_update_date;/**生产调度提交日期**/
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
	public void setTechmanager_id(String techmanager_id){
		this.techmanager_id=techmanager_id;
	}
	public String getTechmanager_id(){
		return techmanager_id;
	}
	public void setAttachment(String attachment){
		this.attachment=attachment;
	}
	public String getAttachment(){
		return attachment;
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
	public void setProduct_update_date(String product_update_date){
		this.product_update_date=product_update_date;
	}
	public String getProduct_update_date(){
		return product_update_date;
	}
}
