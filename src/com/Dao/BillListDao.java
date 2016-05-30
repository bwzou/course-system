package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.BillList;

import com.global.User;
import com.util.DBHelper;

public class BillListDao {
	DBHelper dbHelper = new DBHelper();
	
	public List getBillList(){
		String sql="SELECT c.`cid`,`cname`,`credit`,`bill` "
				+ "FROM `choose_course` as ch,`courses` as c "
				+ "WHERE ch.`cid` = c.`cid` and ch.`sid` = ?";
		ResultSet rst = dbHelper.execQuery(sql, User.username);
		List list = new ArrayList();
		try{
			while(rst.next()){
				BillList billList = new BillList();
				billList.setCid(rst.getInt("cid"));
				billList.setCname(rst.getString("cname"));
				billList.setCredit(rst.getFloat("credit"));
				billList.setBill(rst.getInt("bill"));
				list.add(billList);
			}
			rst.close();
			return list;
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbHelper.closeAll();
		}
		return null;
	}
	
	public boolean sendToBillSystem(int cost){     //有bug
		String sql="INSERT INTO `bill`(`sid`, `cost`) VALUES (?,?)";
		int result = dbHelper.execOthers(sql, User.username, cost);
		boolean flag = false;
		if(result>0){
			flag = true;
		}
		dbHelper.closeAll();
		return flag;
	}
	
	public int getBillState(){
		String sql="SELECT `bill_state` FROM `bill` WHERE `sid` = ?";
		ResultSet rst= dbHelper.execQuery(sql, User.username);
		int flag=-1;
		try{
			if(rst.next()){
				flag = rst.getInt("bill_state");
			}
			rst.close();
			return flag;
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbHelper.closeAll();
		}
		return flag;
	}
	
	public boolean setBillState(){
		String sql = "UPDATE `bill` SET `bill_state`=1 WHERE `sid`=?"; 
		int rst = dbHelper.execOthers(sql, User.username);
		boolean flag = false;
		if(rst>0){
			flag = true;
		}
		dbHelper.closeAll();
		return flag;
	}
}
