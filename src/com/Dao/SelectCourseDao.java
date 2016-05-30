package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.AlreadyCourse;
import po.CourseCatalog;

import com.global.User;
import com.util.DBHelper;

public class SelectCourseDao {
	DBHelper dbHelper=new DBHelper();

	public SelectCourseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List selectCourseByCname(String cname) {
		String sql="SELECT c.`cid`,`cname`,`credit`,`credit_hours`,`pname`,`department`,`teach_time`,`classroom`,`bill`,`cancel` "
				+ "FROM `professor` as p,`courses` as c,`indicate_course`as i "
				+ "WHERE i.`cid` = c.`cid` and p.`pid`=i.`pid` and c.`cname`LIKE '%?%'";
		ResultSet rst = dbHelper.execQuery(sql,cname);
		List list=new ArrayList();
		try {
			while (rst.next()) {
				CourseCatalog catalog = new CourseCatalog();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setCredit_hours(rst.getInt("credit_hours"));
				catalog.setTname(rst.getString("pname"));
				catalog.setDepartments(rst.getString("department"));
				catalog.setTeach_time(rst.getString("teach_time"));
				catalog.setClassroom(rst.getString("classroom"));
				catalog.setBill(rst.getInt("bill"));
				catalog.setCancel(rst.getInt("cancel"));
				list.add(catalog);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}		
		return null;
	}
	
	public List selectCourseByTname(String Tname) {
		String sql="SELECT c.`cid`,`cname`,`credit`,`credit_hours`,`pname`,`department`,`teach_time`,`classroom`,`bill`,`cancel` "
				+ "FROM `professor` as p,`courses` as c,`indicate_course`as i "
				+ "WHERE i.`cid` = c.`cid` and p.`pid`=i.`pid`and p.`pname`=?";
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql,Tname);
		try {
			while (rst.next()) {
				CourseCatalog catalog = new CourseCatalog();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setCredit_hours(rst.getInt("credit_hours"));
				catalog.setTname(rst.getString("pname"));
				catalog.setDepartments(rst.getString("department"));
				catalog.setTeach_time(rst.getString("teach_time"));
				catalog.setClassroom(rst.getString("classroom"));
				catalog.setBill(rst.getInt("bill"));
				catalog.setCancel(rst.getInt("cancel"));
				list.add(catalog);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}			
		return null;
	}
	
	public List selectAllCourse(){   //先写不显示教师名称的
		String sql="SELECT * FROM `courses`";
		String sql1 = "SELECT `pname` FROM `professor`,`indicate_course` WHERE `cid` = ?"; 
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql);
		try {
			while (rst.next()) {
				CourseCatalog catalog = new CourseCatalog();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setCredit_hours(rst.getInt("credit_hours"));
				
				ResultSet rst1 = dbHelper.execQuery(sql1, rst.getInt("cid"));
				if(rst1.next()){
					catalog.setTname(rst1.getString("pname"));
					rst1.close();
				}
				catalog.setDepartments(rst.getString("department"));
				catalog.setTeach_time(rst.getString("teach_time"));
				catalog.setClassroom(rst.getString("classroom"));
				catalog.setBill(rst.getInt("bill"));
				catalog.setCancel(rst.getInt("cancel"));
				list.add(catalog);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	public List StudentSelectedCourse(){
		String sql="SELECT c.`cid`,`cname`,`credit`,`credit_hours`,`department`,`teach_time`,`classroom`,`bill`,`cancel` "
				+ "FROM `courses` as c,`choose_course` as ch "
				+ "WHERE c.`cid` = ch.`cid` and ch.`sid` = ?";
		String sql1 = "SELECT `pname` FROM `professor`,`indicate_course` WHERE `cid` = ?"; 
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql,User.username);
		try {
			while (rst.next()) {
				CourseCatalog catalog = new CourseCatalog();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setCredit_hours(rst.getInt("credit_hours"));
				
				ResultSet rst1 = dbHelper.execQuery(sql1, rst.getInt("cid"));
				if(rst1.next()){
					catalog.setTname(rst1.getString("pname"));
					rst1.close();
				}
				catalog.setDepartments(rst.getString("department"));
				catalog.setTeach_time(rst.getString("teach_time"));
				catalog.setClassroom(rst.getString("classroom"));
				catalog.setBill(rst.getInt("bill"));
				catalog.setCancel(rst.getInt("cancel"));
				list.add(catalog);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	public List HadMajorCourse(){
		String sql = "SELECT c.`cid`,`cname`,`credit`,`credit_hours`,`department`,ch.`grade` "
				+ "FROM `courses` as c,`choose_course` as ch "
				+ "WHERE c.`cid` = ch.`cid` and ch.`sid` = ? and ch.`grade` <> -1";
		String sql1 = "SELECT `pname` FROM `professor`,`indicate_course` WHERE `cid` = ?";
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql,User.username);
		try {
			while (rst.next()) {
				AlreadyCourse catalog = new AlreadyCourse();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setCredit_hours(rst.getInt("credit_hours"));
				
				ResultSet rst1 = dbHelper.execQuery(sql1, rst.getInt("cid"));
				if(rst1.next()){
					catalog.setTname(rst1.getString("pname"));
					rst1.close();
				}
				catalog.setDepartments(rst.getString("department"));
				catalog.setGrade(rst.getFloat("grade"));
				list.add(catalog);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	
}
