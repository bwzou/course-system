package com.Dao;

import com.util.DBHelper;

public class AdminManageDao {
	DBHelper dbHelper = new DBHelper();

	public AdminManageDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int addCourseInfo(String cid,String cname,String credit,String credit_hours,
			String department,String teach_time,String classroom,String bill){
		int rst = 0;
		String sql= "INSERT INTO `courses`(`cid`, `cname`, `credit`, `credit_hours`, `department`, `teach_time`, `classroom`, `bill`) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		rst = dbHelper.execOthers(sql,cid,cname,credit,credit_hours,department,teach_time,classroom,bill);
		dbHelper.closeAll();	
		return rst;
	}
	
	public int deleteCourseInfo(){
		return 0;
	}
	
	public int changeCourseInfo(){
		return 0;
	}
	
}
