package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.CourseCatalog;
import po.RecordCourseInfo;
import po.RecordGrade;
import po.StudentInfo;

import com.global.DataTransfer;
import com.global.User;
import com.util.DBHelper;

public class ProIndicateCourseDao {
	DBHelper dbHelper = new DBHelper();
	
	public boolean IndicateCourse(String cid){
		String sql="INSERT INTO `indicate_course`(`pid`, `cid`) VALUES (?,?)";
		Date date = new Date();
		int rst = dbHelper.execOthers(sql, User.username, cid);
		boolean result= false;
		if(rst>0){
			result = true ;
		}
		dbHelper.closeAll();
		return result;
	}
	
	public boolean CancelCourse(String cid){
		String sql="DELETE FROM `indicate_course` WHERE `pid`=? and `cid` = ? ";
		int rst = dbHelper.execOthers(sql, User.username, cid);
		boolean result= false;
		if(rst>0){
			result = true ;
		}
		dbHelper.closeAll();
		return result;
	}
	
	public List getIndicateCourse(){    // 暂时用不到
		String sql="SELECT c.`cid`,`cname`,`credit`,`credit_hours`,`pname`,`department`,`teach_time`,`classroom`,`bill`,`cancel` "
				+ "FROM `professor` as p,`courses` as c,`indicate_course`as i "
				+ "WHERE i.`cid` = c.`cid` and p.`pid`=i.`pid`and p.`pid`=?";
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql,User.username);
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
	
	public List getRecordCourseInfo(){
		String sql="SELECT c.`cid`,`cname`,`credit`,i.`record_state`,count(ch.`sid`)"
				+ "FROM `courses` as c,`choose_course` as ch,`indicate_course`as i "
				+ "WHERE ch.`cid` = c.`cid` and c.`cid` in"
				+ "( SELECT i.`cid` "
				+ "FROM `professor` as p "
				+ "WHERE i.`pid`= p.`pid` and p.`pid` = ? )";
		List list=new ArrayList();
		ResultSet rst = dbHelper.execQuery(sql,User.username);
		try {
			while (rst.next()) {
				RecordCourseInfo catalog = new RecordCourseInfo();
				catalog.setCid(rst.getInt("cid"));
				catalog.setCname(rst.getString("cname"));
				catalog.setCredit(rst.getFloat("credit"));
				catalog.setRecord_state(rst.getInt("record_state"));
				catalog.setStu_count(rst.getInt(4));
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
	
	public List getStudentInfo(String cname){
		DataTransfer.Student = new ArrayList();
		String sql="SELECT s.`sid`,`sname`,`email`,`phone_number`,`age` "
				+ "FROM `students` as s,`choose_course` AS c "
				+ "WHERE c.`sid` = s.`sid` AND c.`cid` = ?";
		ResultSet rst = dbHelper.execQuery(sql,cname);
		try {
			while (rst.next()) {
				StudentInfo catalog = new StudentInfo();
				catalog.setSid(rst.getInt("sid"));
				catalog.setSname(rst.getString("sname"));
				catalog.setAge(rst.getInt("age"));
				catalog.setEmail(rst.getString("email"));
				catalog.setPhone_number(rst.getString("phone_number"));
				DataTransfer.Student.add(catalog);
			}
			rst.close();
			return DataTransfer.Student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	public List getCourseStudent(String cid,String cname){
		DataTransfer.recordGrade = new ArrayList();
		String sql="SELECT s.`sid`,`sname`,`grade` "
				+ "FROM `students` as s,`choose_course` AS ch "
				+ "WHERE ch.`sid` = s.`sid` AND ch.`cid`=?";
		
		ResultSet rst = dbHelper.execQuery(sql,cid);
		try {
			while (rst.next()) {
				RecordGrade catalog = new RecordGrade();
				catalog.setSid(rst.getInt("sid"));
				catalog.setSname(rst.getString("sname"));
				catalog.setGrade(rst.getFloat("grade"));
				catalog.setCid(Integer.parseInt(cid));
				catalog.setCname(cname);
				DataTransfer.recordGrade.add(catalog);
			}
			rst.close();
			return DataTransfer.recordGrade;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}				
		return null;
	}
	
	public boolean getRecordGrade(String cid, String sid,String grade){
		String sql="Update `choose_course` set `grade`= ? WHERE `sid`=? and `cid`= ? ";
		int rst = dbHelper.execOthers(sql, grade, sid,cid);
		boolean result= false;
		if(rst>0){
			result = true ;
		}
		dbHelper.closeAll();
		return result;
	}
}
