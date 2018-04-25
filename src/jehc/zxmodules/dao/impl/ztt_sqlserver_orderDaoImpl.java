package jehc.zxmodules.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jehc.zxmodules.dao.getReport;
import jehc.zxmodules.dao.ztt_sqlserver_orderDao;
import jehc.zxmodules.model.Report;
import jehc.zxmodules.model.User;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.util.DB;

@Repository("ztt_sqlserver_order")
public class ztt_sqlserver_orderDaoImpl implements ztt_sqlserver_orderDao {

	
	public int addztt_order(ResultSet rs) {
		ZttOrder ZttOrder = new ZttOrder();
		Connection conn = null;
		try {
			conn = DB.getConn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "insert into ztt_order(id,采购员,[申请号/订单号]) values(?,?,?)"; 
		 
        
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql); 
    		
            pstmt.setString(1, ZttOrder.getId());  
            pstmt.setString(2, ZttOrder.getOrder_number());  
            pstmt.setString(3, ZttOrder.getOrder_number());  
            int result = pstmt.executeUpdate(); 
        	pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 1;  
		
	}

	@Override
	public int addztt_order(ZttOrder zttOrder) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
