package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.Dao.AdminManageDao;
import com.ipanel.MatainStuInfoPanel;

public class AddStudentFrame extends JInternalFrame{
	class addStudentActionListener implements ActionListener {		// 添加按钮的单击事件监听器
		public void actionPerformed(final ActionEvent e) {
			if(matainStuInfoPanel.sid.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学生学号不可以为空");
				return;
			}
			if(matainStuInfoPanel.sname.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学生姓名不能为空");
				return;
			}
			if(matainStuInfoPanel.password.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学生密码不能为空");
				return;
			}
			if(matainStuInfoPanel.age.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学生年龄不可以为空");
				return;
			}
			if(matainStuInfoPanel.email.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学生邮箱不可以为空");
				return;
			}
			if(matainStuInfoPanel.phone_number.getText().length()==0){
				JOptionPane.showMessageDialog(null, "电话号码不可以为空");
				return;
			}

			String sids=matainStuInfoPanel.sid.getText().trim();			
			String snames=matainStuInfoPanel.sname.getText().trim();
			String passwords=matainStuInfoPanel.password.getText().trim();
			String ages=matainStuInfoPanel.age.getText().trim();
			String emails=matainStuInfoPanel.email.getText().trim();
			String phone_numbers=matainStuInfoPanel.phone_number.getText().trim();
			
			AdminManageDao adminManageDao = new AdminManageDao();
			int i=adminManageDao.addStudentInfo(sids, snames,passwords,ages, emails,phone_numbers);				
			if(i==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				doDefaultCloseAction();
			}
		}
	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	
	private MatainStuInfoPanel matainStuInfoPanel;
	
	 
	 
	public AddStudentFrame() {
		super();
		// TODO Auto-generated constructor stub
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("学生信息添加");						// 设置窗体标题－－－必须
		setBounds(100, 100, 500, 200);					// 设置窗体位置和大小－－－必须

		
		matainStuInfoPanel = new MatainStuInfoPanel();
		getContentPane().add(matainStuInfoPanel,BorderLayout.CENTER);
		
		matainStuInfoPanel.buttonadd.addActionListener(new addStudentActionListener());
		matainStuInfoPanel.buttonclose.addActionListener(new CloseActionListener());
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
	
}
