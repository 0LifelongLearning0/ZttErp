package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_project 项目管理表 
* 2017-08-28 14:15:35  邓纯杰
*/
public class ZxProject extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**项目ID**/
	private String name;/**项目名称**/
	private String num;/**项目号**/
	private String ship_date;/**项目发货时间**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setNum(String num){
		this.num=num;
	}
	public String getNum(){
		return num;
	}
	public void setShip_date(String ship_date){
		this.ship_date=ship_date;
	}
	public String getShip_date(){
		return ship_date;
	}
}
