package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import jehc.zxmodules.model.ZttMouldsDeivice;
import java.util.List;

/**
* ztt_moulds_gongxu 模具部工序 
* 2018-05-24 16:46:19  
*/
public class ZttMouldsGongxu extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**id**/
	private String gongxu_name;/**工序名称**/
	private String number;/**编号**/
	private List<ZttMouldsDeivice> zttMouldsDeivice;/**工序设备**/
	private String zttMouldsDeivice_removed_flag;/**工序设备移除标识**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setGongxu_name(String gongxu_name){
		this.gongxu_name=gongxu_name;
	}
	public String getGongxu_name(){
		return gongxu_name;
	}
	public void setZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeivice){
		this.zttMouldsDeivice=zttMouldsDeivice;
	}
	public List<ZttMouldsDeivice> getZttMouldsDeivice(){
		return zttMouldsDeivice;
	}
	public void setZttMouldsDeivice_removed_flag(String zttMouldsDeivice_removed_flag){
		this.zttMouldsDeivice_removed_flag=zttMouldsDeivice_removed_flag;
	}
	public String getZttMouldsDeivice_removed_flag(){
		return zttMouldsDeivice_removed_flag;
	}
}
