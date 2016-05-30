package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import po.CourseCatalog;

import com.global.User;
import com.util.DBHelper;

public class StudentSelectCourseDao {
	DBHelper dbHelper = new DBHelper();

	public StudentSelectCourseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean SelectCourse(String cid,int type){
		String sql="INSERT INTO `choose_course`(`sid`, `cid`, `type`, `select_time`) VALUES (?,?,?,?)";
		Date date = new Date();
		int rst = dbHelper.execOthers(sql, User.username, cid, type, date);
		boolean result= false;
		if(rst>0){
			result = true ;
		}
		dbHelper.closeAll();
		return result;
	}
	
	public boolean CancelCourse(String cid,int type){
		String sql="DELETE FROM `choose_course` WHERE `sid`= ? and `cid` = ?";
		int rst = dbHelper.execOthers(sql, User.username, cid);
		boolean result= false;
		if(rst>0){
			result = true ;
		}
		dbHelper.closeAll();
		return result;
	}
	
}
