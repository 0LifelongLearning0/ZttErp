package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_workpiece 工件管理 
* 2017-08-31 12:54:14  陈运芝
*/
public class ZxWorkpiece extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**工件ID**/
	private String project_id;/**项目ID**/
	private String project_name;/**项目名称**/
	private String num;/**工件编号**/
	private String name;/**工件名称**/
	private String unit;/**单位**/
	private String zubie;/**单位**/
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
	public void setProject_name(String project_name){
		this.project_name=project_name;
	}
	public String getProject_name(){
		return project_name;
	}
	public void setNum(String num){
		this.num=num;
	}
	public String getNum(){
		return num;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setUnit(String unit){
		this.unit=unit;
	}
	public String getUnit(){
		return unit;
	}
	public void setZubie(String zubie){
		this.zubie=zubie;
	}
	public String getZubie(){
		return zubie;
	}
}
