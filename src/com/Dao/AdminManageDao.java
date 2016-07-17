package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StudentInfo;

import com.global.DataTransfer;
import com.util.DBHelper;

public class AdminManageDao {
	DBHelper dbHelper = new DBHelper();

	public AdminManageDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//添加课程
	public int addCourseInfo(String cid,String cname,String credit,String credit_hours,
			String department,String teach_time,String classroom,String bill){
		int rst = 0;
		String sql= "INSERT INTO `courses`(`cid`, `cname`, `credit`, `credit_hours`, `department`, `teach_time`, `classroom`, `bill`) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		rst = dbHelper.execOthers(sql,cid,cname,credit,credit_hours,department,teach_time,classroom,bill);
		dbHelper.closeAll();	
		return rst;
	}
	
	public int deleteCourseInfo(String cid){
		String sql="DELETE FROM `courses` WHERE `cid` = ?";
		int rst = 0;
		rst = dbHelper.execOthers(sql,cid);
		dbHelper.closeAll();	
		return rst;
	}
	
	public int changeCourseInfo(String cid,String cname,String credit,String credit_hours,
			String department,String teach_time,String classroom,String bill){
		String sql="UPDATE `courses` SET "
				+ "`cname`=?,`credit`=?,`credit_hours`=?,`department`=?,`teach_time`=?,`classroom`=?,`bill`=?"
				+ "WHERE `cid` = ?";
		int rst = 0;
		rst = dbHelper.execOthers(sql,cname,credit,credit_hours,department,teach_time,classroom,bill,cid);
		dbHelper.closeAll();	
		return rst;
	}
	
	//添加学生
	public int addStudentInfo(String cid,String cname,String credit,String credit_hours,
			String department,String teach_time){
		int rst = 0;
		String sql= "INSERT INTO `students`(`sid`, `sname`, `password`, `age`, `email`, `phone_number`) "
				+ "VALUES (?,?,?,?,?,?)";
		rst = dbHelper.execOthers(sql,cid,cname,credit,credit_hours,department,teach_time);
		dbHelper.closeAll();	
		return rst;
	}
	
	public List getStudentInfo(){
		DataTransfer.Student = new ArrayList();
		String sql="SELECT `sid`,`sname`,`email`,`phone_number`,`age` "
				+ "FROM `students`";
		ResultSet rst = dbHelper.execQuery(sql);
		List resultList = new ArrayList();
		try {
			while (rst.next()) {
				StudentInfo catalog = new StudentInfo();
				catalog.setSid(rst.getInt("sid"));
				catalog.setSname(rst.getString("sname"));
				catalog.setAge(rst.getInt("age"));
				catalog.setEmail(rst.getString("email"));
				catalog.setPhone_number(rst.getString("phone_number"));
				resultList.add(catalog);
			}
			rst.close();
			return resultList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	public int updateStudentInfo(String sid,String sname,String password,String age,String email,String phone_number){
		String sql="UPDATE `students` SET `sname`=?,`password`=?,`age`=?,`email`=?,`phone_number`=? WHERE `sid` = ?";
		int result =0;
		result = dbHelper.execOthers(sql,sname,password,age,email,phone_number,sid );
		dbHelper.closeAll();
		return result;
	}
	
	public int deleteStudentInfo(String sid){
		String sql="DELETE FROM `students` WHERE `sid` = ?";
		int result = dbHelper.execOthers(sql, sid);
		dbHelper.closeAll();
		return result;
	}
	
	public int settingOpenTime(String start,String end){
		int result  = 0;
		Date prod = new Date();
		String sql="INSERT INTO `close_time`(`start_time`, `end_time`, `prodTime`) VALUES (?,?,?)";
		result = dbHelper.execOthers(sql, start,end,prod);
		dbHelper.closeAll();
		return result;
	}
	
	public int updatePassward(String admin,String newpwd){
		int result = 0;
		String sql="UPDATE `administrator` SET `password`=? WHERE `aname`=?";
		result = dbHelper.execOthers(sql, newpwd,admin);
		dbHelper.closeAll();
		return result;
	}
}
