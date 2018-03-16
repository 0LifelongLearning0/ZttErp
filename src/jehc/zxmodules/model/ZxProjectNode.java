package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import jehc.zxmodules.model.ZxProjectWoking;
import java.util.List;

/**
* zx_project_node 项目节点控制表 
* 2017-09-07 23:52:08  邓纯杰
*/
public class ZxProjectNode extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String project_id;/**项目ID**/
	private String workpiece_id;/**工件ID**/
	private String propties;/**加工属性**/
	private String stuff;/**材质**/
	private String library;/**库位**/
	private double single_amount;/**单台数量**/
	private double all_amount;/****/
	private String plan_date;/**计划入库时间**/
	private String in_warehouse_date;/**入库时间**/
	private double in_warehuse_amount;/**入库数量**/
	private String out_warehouse_date;/**出库时间**/
	private double out_warehuse_amount;/**出库数量**/
	private String status;/**状态**/
	private List<ZxProjectWoking> zxProjectWoking;/**项目节点工时记录表**/
	private String zxProjectWoking_removed_flag;/**项目节点工时记录表移除标识**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setProject_id(String project_id){
		this.project_id=project_id;
	}
	public String getProject_id(){
		return project_id;
	}
	public void setWorkpiece_id(String workpiece_id){
		this.workpiece_id=workpiece_id;
	}
	public String getWorkpiece_id(){
		return workpiece_id;
	}
	public void setPropties(String propties){
		this.propties=propties;
	}
	public String getPropties(){
		return propties;
	}
	public void setStuff(String stuff){
		this.stuff=stuff;
	}
	public String getStuff(){
		return stuff;
	}
	public void setLibrary(String library){
		this.library=library;
	}
	public String getLibrary(){
		return library;
	}
	public void setSingle_amount(double single_amount){
		this.single_amount=single_amount;
	}
	public double getSingle_amount(){
		return single_amount;
	}
	public void setAll_amount(double all_amount){
		this.all_amount=all_amount;
	}
	public double getAll_amount(){
		return all_amount;
	}
	public void setPlan_date(String plan_date){
		this.plan_date=plan_date;
	}
	public String getPlan_date(){
		return plan_date;
	}
	public void setIn_warehouse_date(String in_warehouse_date){
		this.in_warehouse_date=in_warehouse_date;
	}
	public String getIn_warehouse_date(){
		return in_warehouse_date;
	}
	public void setIn_warehuse_amount(double in_warehuse_amount){
		this.in_warehuse_amount=in_warehuse_amount;
	}
	public double getIn_warehuse_amount(){
		return in_warehuse_amount;
	}
	public void setOut_warehouse_date(String out_warehouse_date){
		this.out_warehouse_date=out_warehouse_date;
	}
	public String getOut_warehouse_date(){
		return out_warehouse_date;
	}
	public void setOut_warehuse_amount(double out_warehuse_amount){
		this.out_warehuse_amount=out_warehuse_amount;
	}
	public double getOut_warehuse_amount(){
		return out_warehuse_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setZxProjectWoking(List<ZxProjectWoking> zxProjectWoking){
		this.zxProjectWoking=zxProjectWoking;
	}
	public List<ZxProjectWoking> getZxProjectWoking(){
		return zxProjectWoking;
	}
	public void setZxProjectWoking_removed_flag(String zxProjectWoking_removed_flag){
		this.zxProjectWoking_removed_flag=zxProjectWoking_removed_flag;
	}
	public String getZxProjectWoking_removed_flag(){
		return zxProjectWoking_removed_flag;
	}
}
