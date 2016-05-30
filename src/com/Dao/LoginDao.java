package com.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBHelper;

public class LoginDao {
	DBHelper dbHelper=new DBHelper();
	
	public LoginDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkUser(String username,String password,String actor){
		boolean result=false;
		String sql;
		if(actor=="学生"){
			sql = "select * from students where sid=? and password=?";
		}else if(actor=="教授"){
			sql = "select * from professor where pid=? and password=?";
		}else if(actor=="管理员"){
			sql = "select * from administrator where aname=? and password=?";
		}else{
			return false;
		}
		ResultSet rst = dbHelper.execQuery(sql,username,password);
		try {
			if (rst.next()) {
				result=true;
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		
		return result;
	}
	
}
