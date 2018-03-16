package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_order_out_workpiece 外协订单工件表 
* 2017-11-03 16:58:45  邓纯杰
*/
public class ZxOrderOutWorkpiece extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**标识**/
	private String order_id;/**订单标识**/
	private String apply_workpiece_id;/**申请单工件标识**/
	private String workpiece_id;/**工件标识**/
	private String agree_time;/**承诺到货时间**/
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
	public void setApply_workpiece_id(String apply_workpiece_id){
		this.apply_workpiece_id=apply_workpiece_id;
	}
	public String getApply_workpiece_id(){
		return apply_workpiece_id;
	}
	public void setWorkpiece_id(String workpiece_id){
		this.workpiece_id=workpiece_id;
	}
	public String getWorkpiece_id(){
		return workpiece_id;
	}
	public void setAgree_time(String agree_time){
		this.agree_time=agree_time;
	}
	public String getAgree_time(){
		return agree_time;
	}
}
