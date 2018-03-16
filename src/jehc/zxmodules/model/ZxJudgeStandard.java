package jehc.zxmodules.model;
import java.io.Serializable;

import jehc.xtmodules.xtcore.base.BaseEntity;

/**
* zx_judge_standard 供应商评定标准 
* 2017-09-21 13:16:25  邓纯杰
*/
public class ZxJudgeStandard extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String type;/**类型：1-验厂标准，2-再评审标准**/
	private String dic_id;/**考核项目**/
	private String content;/**考核内容**/
	private double total_score;/**最高分**/
	private String dep_id;/**评分部门**/
	private Integer sort;/**排序**/
	private String state;/**状态：1-正常，0-删除**/
	private String remark;/**备注**/
	private String dic_name;/**部门**/
	private String dep_name;/**备注**/
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return type;
	}
	public void setDic_id(String dic_id){
		this.dic_id=dic_id;
	}
	public String getDic_id(){
		return dic_id;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setTotal_score(double total_score){
		this.total_score=total_score;
	}
	public double getTotal_score(){
		return total_score;
	}
	public void setDep_id(String dep_id){
		this.dep_id=dep_id;
	}
	public String getDep_id(){
		return dep_id;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public String getDic_name() {
		return dic_name;
	}
	public void setDic_name(String dic_name) {
		this.dic_name = dic_name;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
