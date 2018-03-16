package jehc.zxmodules.model;
import jehc.xtmodules.xtcore.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
* zx_schedule_day 单个日程 
* 2017-11-23 12:41:18  邓纯杰
*/
public class ZxScheduleDay extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;/**ID**/
	private String user_id;/**用户id**/
	private String date;/**日期**/
	private String transaction_type;/**日程类别**/
	private String begin_time;/**开始时间**/
	private String end_time;/**结束时间**/
	private String transaction_content;/**内容**/
	private String remark;/**备注**/
	private String transaction_remind;/**是否提醒**/
	private String remind_day;/**提前多少天提醒**/
	private String remind_hour;/**提前几小时提醒**/
	private String remind_minute;/**提前多少分钟提醒**/
	private String period_transaction_id;/**周期性事务id**/
	private Date begin_date;
	private Date end_date;
	
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setUser_id(String user_id){
		this.user_id=user_id;
	}
	public String getUser_id(){
		return user_id;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	public void setTransaction_type(String transaction_type){
		this.transaction_type=transaction_type;
	}
	public String getTransaction_type(){
		return transaction_type;
	}
	public void setBegin_time(String begin_time){
		this.begin_time=begin_time;
	}
	public String getBegin_time(){
		return begin_time;
	}
	public void setEnd_time(String end_time){
		this.end_time=end_time;
	}
	public String getEnd_time(){
		return end_time;
	}
	public void setTransaction_content(String transaction_content){
		this.transaction_content=transaction_content;
	}
	public String getTransaction_content(){
		return transaction_content;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setTransaction_remind(String transaction_remind){
		this.transaction_remind=transaction_remind;
	}
	public String getTransaction_remind(){
		return transaction_remind;
	}
	public void setRemind_day(String remind_day){
		this.remind_day=remind_day;
	}
	public String getRemind_day(){
		return remind_day;
	}
	public void setRemind_hour(String remind_hour){
		this.remind_hour=remind_hour;
	}
	public String getRemind_hour(){
		return remind_hour;
	}
	public void setRemind_minute(String remind_minute){
		this.remind_minute=remind_minute;
	}
	public String getRemind_minute(){
		return remind_minute;
	}
	public void setPeriod_transaction_id(String period_transaction_id){
		this.period_transaction_id=period_transaction_id;
	}
	public String getPeriod_transaction_id(){
		return period_transaction_id;
	}
}
