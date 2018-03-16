package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;

/**
* zx_judge_attach 供应商评定附件 
* 2017-09-30 16:08:00  邓纯杰
*/
public class ZxJudgeAttach extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String result_id;/**评定结果**/
	private String upload_user_id;/**上传人**/
	private String name;/**文件名**/
	private String state;/**状态:1-正常；0删除**/
	private String del_date;/**删除日期**/
	private String create_date;/**创建日期**/
	private String user_name;
	private String xt_attachment_id;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setResult_id(String result_id){
		this.result_id=result_id;
	}
	public String getResult_id(){
		return result_id;
	}
	public void setUpload_user_id(String upload_user_id){
		this.upload_user_id=upload_user_id;
	}
	public String getUpload_user_id(){
		return upload_user_id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setDel_date(String del_date){
		this.del_date=del_date;
	}
	public String getDel_date(){
		return del_date;
	}
	public void setCreate_date(String create_date){
		this.create_date=create_date;
	}
	public String getCreate_date(){
		return create_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getXt_attachment_id() {
		return xt_attachment_id;
	}
	public void setXt_attachment_id(String xt_attachment_id) {
		this.xt_attachment_id = xt_attachment_id;
	}
}
