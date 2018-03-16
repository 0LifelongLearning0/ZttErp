package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_outsource_time 外协分批到货管理 
* 2017-09-01 09:30:59  邓纯杰
*/
public class ZxOutsourceTime extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String outsource_id;/**外协ID**/
	private String plan_date;/**计划交货时间**/
	private String real_date;/**实际到货时间**/
	private int time_sort;/**排序**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setOutsource_id(String outsource_id){
		this.outsource_id=outsource_id;
	}
	public String getOutsource_id(){
		return outsource_id;
	}
	public void setPlan_date(String plan_date){
		this.plan_date=plan_date;
	}
	public String getPlan_date(){
		return plan_date;
	}
	public void setReal_date(String real_date){
		this.real_date=real_date;
	}
	public String getReal_date(){
		return real_date;
	}
	public void setTime_sort(int time_sort){
		this.time_sort=time_sort;
	}
	public int getTime_sort(){
		return time_sort;
	}
}
