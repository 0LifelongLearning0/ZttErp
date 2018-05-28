package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_moulds_deivice 工序设备 
* 2018-05-24 16:46:19  
*/
public class ZttMouldsDeivice extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String gongxu_id;/**工序id**/
	private String device_name;/**设备名称**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setGongxu_id(String gongxu_id){
		this.gongxu_id=gongxu_id;
	}
	public String getGongxu_id(){
		return gongxu_id;
	}
	public void setDevice_name(String device_name){
		this.device_name=device_name;
	}
	public String getDevice_name(){
		return device_name;
	}
}
