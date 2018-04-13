package jehc.zxmodules.dao;

import java.util.List;

import jehc.zxmodules.model.Report;
import jehc.zxmodules.model.User;


public interface getReport {
	public List<Report>  getMyReport(User user);
	public List<Report>  getSendMyReport(User user);
}
