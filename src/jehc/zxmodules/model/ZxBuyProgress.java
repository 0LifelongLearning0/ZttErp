package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
* zx_buy_progress 采购件进度表 
* 2017-10-28 15:56:49  邓纯杰
*/
public class ZxBuyProgress extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String apply_id;/**申请单ID**/
	private String order_id;/**订单ID**/
	private String project_id;/**项目ID**/
	private String material_id;/**物料ID**/
	private String brand;/**材质品牌**/
	private String caizhi;/**材质**/
	private double apply_amount;/**申购数量**/
	private double buy_amount;/**采购数量**/
	private double real_amount;/**已到数量**/
	private String need_time;/**需求日期**/
	private String suppier_id;/**供应商**/
	private String send_draw_time;/**清单与图纸下发时间**/
	private String draw_num;/**图号**/
	private String apply_user_id;/**申购人**/
	private String buy_user_id;/**采购人**/
	private String buy_time;/**采购时间**/
	private String plan_time;/**计划到货时间**/
	private String real_time;/**实际到货时间**/
	private String apply_time;/**申请时间**/
	private String xt_userinfo_realName;/**创建人**/
	private String status;/**状态**/
	private String material_remark;/**物料备注**/
	private String remark;/**备注**/
	private double out_warehouse_amount;/**出库数量**/
	private String out_warehouse_date;/**出库时间**/
	private String in_warehouse_date;/**到货时间**/
	private double in_warehouse_amount;/**入库数量**/
	private List<ZxBuyTime> zxBuyTime;/**采购分批到货**/
	private String zxBuyTime_removed_flag;/**采购分批到货移除标识**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}
	public String getApply_id(){
		return apply_id;
	}
	public void setOrder_id(String order_id){
		this.order_id=order_id;
	}
	public String getOrder_id(){
		return order_id;
	}
	public void setProject_id(String project_id){
		this.project_id=project_id;
	}
	public String getProject_id(){
		return project_id;
	}
	public void setMaterial_id(String material_id){
		this.material_id=material_id;
	}
	public String getMaterial_id(){
		return material_id;
	}
	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getBrand(){
		return brand;
	}
	public void setCaizhi(String caizhi){
		this.caizhi=caizhi;
	}
	public String getCaizhi(){
		return caizhi;
	}
	public void setApply_amount(double apply_amount){
		this.apply_amount=apply_amount;
	}
	public double getApply_amount(){
		return apply_amount;
	}
	public void setBuy_amount(double buy_amount){
		this.buy_amount=buy_amount;
	}
	public double getBuy_amount(){
		return buy_amount;
	}
	public void setReal_amount(double real_amount){
		this.real_amount=real_amount;
	}
	public double getReal_amount(){
		return real_amount;
	}
	public void setNeed_time(String need_time){
		this.need_time=need_time;
	}
	public String getNeed_time(){
		return need_time;
	}
	public void setSuppier_id(String suppier_id){
		this.suppier_id=suppier_id;
	}
	public String getSuppier_id(){
		return suppier_id;
	}
	public void setSend_draw_time(String send_draw_time){
		this.send_draw_time=send_draw_time;
	}
	public String getSend_draw_time(){
		return send_draw_time;
	}
	public void setDraw_num(String draw_num){
		this.draw_num=draw_num;
	}
	public String getDraw_num(){
		return draw_num;
	}
	public void setApply_user_id(String apply_user_id){
		this.apply_user_id=apply_user_id;
	}
	public String getApply_user_id(){
		return apply_user_id;
	}
	public void setBuy_user_id(String buy_user_id){
		this.buy_user_id=buy_user_id;
	}
	public String getBuy_user_id(){
		return buy_user_id;
	}
	public void setBuy_time(String buy_time){
		this.buy_time=buy_time;
	}
	public String getBuy_time(){
		return buy_time;
	}
	public void setPlan_time(String plan_time){
		this.plan_time=plan_time;
	}
	public String getPlan_time(){
		return plan_time;
	}
	public void setReal_time(String real_time){
		this.real_time=real_time;
	}
	public String getReal_time(){
		return real_time;
	}
	public void setApply_time(String apply_time){
		this.apply_time=apply_time;
	}
	public String getApply_time(){
		return apply_time;
	}
	public void setXt_userinfo_realName(String xt_userinfo_realName){
		this.xt_userinfo_realName=xt_userinfo_realName;
	}
	public String getXt_userinfo_realName(){
		return xt_userinfo_realName;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setMaterial_remark(String material_remark){
		this.material_remark=material_remark;
	}
	public String getMaterial_remark(){
		return material_remark;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setOut_warehouse_amount(double out_warehouse_amount){
		this.out_warehouse_amount=out_warehouse_amount;
	}
	public double getOut_warehouse_amount(){
		return out_warehouse_amount;
	}
	public void setOut_warehouse_date(String out_warehouse_date){
		this.out_warehouse_date=out_warehouse_date;
	}
	public String getOut_warehouse_date(){
		return out_warehouse_date;
	}
	public void setIn_warehouse_date(String in_warehouse_date){
		this.in_warehouse_date=in_warehouse_date;
	}
	public String getIn_warehouse_date(){
		return in_warehouse_date;
	}
	public void setIn_warehouse_amount(double in_warehouse_amount){
		this.in_warehouse_amount=in_warehouse_amount;
	}
	public double getIn_warehouse_amount(){
		return in_warehouse_amount;
	}
	public void setZxBuyTime(List<ZxBuyTime> zxBuyTime){
		this.zxBuyTime=zxBuyTime;
	}
	public List<ZxBuyTime> getZxBuyTime(){
		return zxBuyTime;
	}
	public void setZxBuyTime_removed_flag(String zxBuyTime_removed_flag){
		this.zxBuyTime_removed_flag=zxBuyTime_removed_flag;
	}
	public String getZxBuyTime_removed_flag(){
		return zxBuyTime_removed_flag;
	}
}
