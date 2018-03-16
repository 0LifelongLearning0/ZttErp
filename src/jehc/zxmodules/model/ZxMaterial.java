package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_material 物料管理 
* 2017-08-31 11:00:45  邓纯杰
*/
public class ZxMaterial extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String material_id;/**物料ID**/
	private String name;/**物料名称**/
	private String short_name;/**物料名称**/
	private String num;/**物料编号**/
	private String classify_id;/**分类ID**/
	private String unit;/**度量衡，单位**/
	private String status;/**状态**/
	private String create_date;/**创建时间**/
	private double weight;/**重量(千克)**/
	private String standard;/**规格**/
	private String team;/**班组**/
	private String property;/**物料属性**/
	public void setMaterial_id(String material_id){
		this.material_id=material_id;
	}
	public String getMaterial_id(){
		return material_id;
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
	public void setClassify_id(String classify_id){
		this.classify_id=classify_id;
	}
	public String getClassify_id(){
		return classify_id;
	}
	public void setUnit(String unit){
		this.unit=unit;
	}
	public String getUnit(){
		return unit;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setCreate_date(String create_date){
		this.create_date=create_date;
	}
	public String getCreate_date(){
		return create_date;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public double getWeight(){
		return weight;
	}
	public void setStandard(String standard){
		this.standard=standard;
	}
	public String getStandard(){
		return standard;
	}
	public void setTeam(String team){
		this.team=team;
	}
	public String getTeam(){
		return team;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
}
