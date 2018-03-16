package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import jehc.zxmodules.model.ZxOutsourceTime;
import java.util.List;

/**
* zx_outsource 外协加工进度表 
* 2017-09-01 09:30:59  邓纯杰
*/
public class ZxOutsource extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String workpiece_id;/****/
	private double amount;/**总数量**/
	private String need_date;/**需求日期**/
	private String plan_date;/**计划交货时间**/
	private String real_date;/**实际到货时间**/
	private String machine_id;/**加工单位**/
	private String status;/**状态**/
	private String remark;/**备注**/
	private String create_date;/**创建时间**/
	private String concordat_id;/**合同ID**/
	private String concordat_num;/**合同编号**/
	private String buy_id;/**采购订单ID**/
	private String buy_num;/**采购订单号**/
	private List<ZxOutsourceTime> zxOutsourceTime;/**外协分批到货管理**/
	private String zxOutsourceTime_removed_flag;/**外协分批到货管理移除标识**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setWorkpiece_id(String workpiece_id){
		this.workpiece_id=workpiece_id;
	}
	public String getWorkpiece_id(){
		return workpiece_id;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
	public double getAmount(){
		return amount;
	}
	public void setNeed_date(String need_date){
		this.need_date=need_date;
	}
	public String getNeed_date(){
		return need_date;
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
	public void setMachine_id(String machine_id){
		this.machine_id=machine_id;
	}
	public String getMachine_id(){
		return machine_id;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setCreate_date(String create_date){
		this.create_date=create_date;
	}
	public String getCreate_date(){
		return create_date;
	}
	public void setConcordat_id(String concordat_id){
		this.concordat_id=concordat_id;
	}
	public String getConcordat_id(){
		return concordat_id;
	}
	public void setConcordat_num(String concordat_num){
		this.concordat_num=concordat_num;
	}
	public String getConcordat_num(){
		return concordat_num;
	}
	public void setBuy_id(String buy_id){
		this.buy_id=buy_id;
	}
	public String getBuy_id(){
		return buy_id;
	}
	public void setBuy_num(String buy_num){
		this.buy_num=buy_num;
	}
	public String getBuy_num(){
		return buy_num;
	}
	public void setZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTime){
		this.zxOutsourceTime=zxOutsourceTime;
	}
	public List<ZxOutsourceTime> getZxOutsourceTime(){
		return zxOutsourceTime;
	}
	public void setZxOutsourceTime_removed_flag(String zxOutsourceTime_removed_flag){
		this.zxOutsourceTime_removed_flag=zxOutsourceTime_removed_flag;
	}
	public String getZxOutsourceTime_removed_flag(){
		return zxOutsourceTime_removed_flag;
	}
}
