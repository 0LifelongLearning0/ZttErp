package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_material_classify 物料分类 
* 2017-08-30 08:30:12  邓纯杰
*/
public class ZxMaterialClassify extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String classify_id;/**序列号**/
	private String classify_parentId;/**物料父ID**/
	private String classify_name;/**物料分类名称**/
	private String classify_short_name;/**物料分类简称**/
	private String classify_num;/**物料分类编号**/
	private String classify_leaf;/**是否存在子叶**/
	private String classify_isdelete;/**状态**/
	private String classify_time;/**立成时间**/
	private int classify_sort;/**排序
**/
	public void setClassify_id(String classify_id){
		this.classify_id=classify_id;
	}
	public String getClassify_id(){
		return classify_id;
	}
	public void setClassify_parentId(String classify_parentId){
		this.classify_parentId=classify_parentId;
	}
	public String getClassify_parentId(){
		return classify_parentId;
	}
	public void setClassify_name(String classify_name){
		this.classify_name=classify_name;
	}
	public String getClassify_name(){
		return classify_name;
	}
	public void setClassify_num(String classify_num){
		this.classify_num=classify_num;
	}
	public String getClassify_num(){
		return classify_num;
	}
	public void setClassify_leaf(String classify_leaf){
		this.classify_leaf=classify_leaf;
	}
	public String getClassify_leaf(){
		return classify_leaf;
	}
	public void setClassify_isdelete(String classify_isdelete){
		this.classify_isdelete=classify_isdelete;
	}
	public String getClassify_isdelete(){
		return classify_isdelete;
	}
	public void setClassify_time(String classify_time){
		this.classify_time=classify_time;
	}
	public String getClassify_time(){
		return classify_time;
	}
	public void setClassify_sort(int classify_sort){
		this.classify_sort=classify_sort;
	}
	public int getClassify_sort(){
		return classify_sort;
	}
	public String getClassify_short_name() {
		return classify_short_name;
	}
	public void setClassify_short_name(String classify_short_name) {
		this.classify_short_name = classify_short_name;
	}
}
