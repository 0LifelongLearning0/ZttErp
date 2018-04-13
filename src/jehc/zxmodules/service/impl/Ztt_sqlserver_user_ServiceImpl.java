package jehc.zxmodules.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

import jehc.zxmodules.dao.impl.getReportImpl;
import jehc.zxmodules.model.Report;
import jehc.zxmodules.model.User;
import jehc.zxmodules.service.Ztt_sqlserver_user_Service;

@Service("Ztt_sqlserver_user_Service")
public class Ztt_sqlserver_user_ServiceImpl implements Ztt_sqlserver_user_Service{
public ArrayList<Report> getsendmyReport(){
	User user=new User();
	getReportImpl a=new getReportImpl();
	String result="";
	List<Report> list=a.getMyReport(user);
	return (ArrayList<Report>) list;
	}
	
}
