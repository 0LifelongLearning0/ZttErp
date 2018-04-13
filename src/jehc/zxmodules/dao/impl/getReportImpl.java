package jehc.zxmodules.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jehc.zxmodules.dao.getReport;
import jehc.zxmodules.model.Report;
import jehc.zxmodules.model.User;
import jehc.zxmodules.util.DB;

public class getReportImpl implements getReport {

	@Override
	public List<Report>  getMyReport(User user) {
		// TODO Auto-generated method stub
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			conn = DB.getConn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql=null;
		sql = "select id from tb_wenjian" ;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				Report r = this.getreportFromRs(rs);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}
	
	private Report getreportFromRs(ResultSet rs) {
		Report r = new Report();
		try {
			r.setId(rs.getString("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	/*@Override
	public List<Report>  getSendMyReport(User user) {
		// TODO Auto-generated method stub
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			conn = DB.getConn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql=null;
		sql = "select id,��������,Ա������,�ύʱ��,Ա����ע,����,�������,�ļ����� from tb_wenjian where ������ like '%" +user.get�û���() + "%' order by �ύʱ�� desc" ;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				Report r = this.getsendmyreportFromRs(rs);
				if(r.get�ļ�����()!=null){
					list.add(r);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}
	public List<ReportDownload>  getMyReportById(String id) {
		// TODO Auto-generated method stub
		List<ReportDownload> list = new ArrayList<ReportDownload>();
		Connection conn = null;
		try {
			conn = DB.getConn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql=null;
		sql = "select �ļ�,�ļ����� from tb_wenjian where id='" +id + "'" ;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				ReportDownload r = this.getreportByIdFromRs(rs);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}
	private ReportDownload getreportByIdFromRs(ResultSet rs) {
		ReportDownload r = new ReportDownload();
		try {
			r.set�ļ�(rs.getString("�ļ�"));
			r.set�ļ�����(rs.getString("�ļ�����"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	private Report getreportFromRs(ResultSet rs) {
		Report r = new Report();
		try {
			r.setId(rs.getString("id"));
			r.setԱ����ע(rs.getString("Ա����ע"));
			r.set����(rs.getString("����"));
			r.set�������(rs.getString("�������"));
			r.set��������(rs.getString("��������"));
			r.set�ύʱ��(rs.getString("�ύʱ��"));
			r.set�ļ�����(rs.getString("�ļ�����"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	private Report getsendmyreportFromRs(ResultSet rs) {
		Report r = new Report();
		try {
			r.setId(rs.getString("id"));
			r.setԱ������(rs.getString("Ա������"));
			r.setԱ����ע(rs.getString("Ա����ע"));
			r.set����(rs.getString("����"));
			r.set�������(rs.getString("�������"));
			r.set��������(rs.getString("��������"));
			r.set�ύʱ��(rs.getString("�ύʱ��"));
			r.set�ļ�����(rs.getString("�ļ�����"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}*/

	@Override
	public List<Report> getSendMyReport(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
