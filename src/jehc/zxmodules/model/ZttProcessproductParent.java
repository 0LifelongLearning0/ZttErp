package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import jehc.zxmodules.model.ZttProcessproduct;
import java.util.List;

/**
* ztt_processproduct_parent 机械加工工艺过程母表 
* 2018-04-24 14:27:01  邓纯杰
*/
public class ZttProcessproductParent extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String order_id;/**订单号id**/
	private String date;/**下单时间**/
	private String product_person_id;/**操作者**/
	private String machine_part;/**零件名称**/
	private String machine_part_number;/**零件图号**/
	private String material_id;/**材料牌号**/
	private List<ZttProcessproduct> zttProcessproduct;/**机械加工工艺过程表**/
	private String zttProcessproduct_removed_flag;/**机械加工工艺过程表移除标识**/
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
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	public void setProduct_person_id(String product_person_id){
		this.product_person_id=product_person_id;
	}
	public String getProduct_person_id(){
		return product_person_id;
	}
	public void setMachine_part(String machine_part){
		this.machine_part=machine_part;
	}
	public String getMachine_part(){
		return machine_part;
	}
	public void setMachine_part_number(String machine_part_number){
		this.machine_part_number=machine_part_number;
	}
	public String getMachine_part_number(){
		return machine_part_number;
	}
	public void setMaterial_id(String material_id){
		this.material_id=material_id;
	}
	public String getMaterial_id(){
		return material_id;
	}
	public void setZttProcessproduct(List<ZttProcessproduct> zttProcessproduct){
		this.zttProcessproduct=zttProcessproduct;
	}
	public List<ZttProcessproduct> getZttProcessproduct(){
		return zttProcessproduct;
	}
	public void setZttProcessproduct_removed_flag(String zttProcessproduct_removed_flag){
		this.zttProcessproduct_removed_flag=zttProcessproduct_removed_flag;
	}
	public String getZttProcessproduct_removed_flag(){
		return zttProcessproduct_removed_flag;
	}
}
