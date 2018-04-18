package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* ztt_codeversion 代码版本控制 
* 2018-04-17 12:58:09  邓纯杰
*/
public class ZttCodeversion extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**序列号**/
	private String name;/**项目名**/
	private String codeversion;/**版本号**/
	private String updatetime;/**修改时间**/
	private String svn;/**svn路径**/
	private String searchname;/**搜索名**/
	private String person;/**负责人**/
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
	public void setCodeversion(String codeversion){
		this.codeversion=codeversion;
	}
	public String getCodeversion(){
		return codeversion;
	}
	public void setUpdatetime(String updatetime){
		this.updatetime=updatetime;
	}
	public String getUpdatetime(){
		return updatetime;
	}
	public void setSvn(String svn){
		this.svn=svn;
	}
	public String getSvn(){
		return svn;
	}
	public void setSearchname(String searchname){
		this.searchname=searchname;
	}
	public String getSearchname(){
		return searchname;
	}
	public void setPerson(String person){
		this.person=person;
	}
	public String getPerson(){
		return person;
	}
}
