package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import po.StudentInfo;

import com.Dao.AdminManageDao;
import com.Dao.ProIndicateCourseDao;
import com.global.DataTransfer;
import com.ipanel.MatainStuInfoPanel;

public class ModiStudentFrame extends JInternalFrame{
	class modifyStudentActionListener implements ActionListener {		// 添加按钮的单击事件监听器
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
			int i=adminManageDao.updateStudentInfo(sids, snames,passwords,ages, emails,phone_numbers);	
			if(i==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				doDefaultCloseAction();
			}
		}
	}
	
	class DeleteActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			String sids = matainStuInfoPanel.sid.getText().trim();
			AdminManageDao adminManageDao = new AdminManageDao();
			int i=adminManageDao.deleteStudentInfo(sids);
			if(i==1){
				JOptionPane.showMessageDialog(null, "删除成功");
				doDefaultCloseAction();
			}
		}
	}
	
	private JTable table;       // 先查找学生并且在table显示
	private JScrollPane scrollPane;
	private MatainStuInfoPanel matainStuInfoPanel;
	private String Infor[]={"学号","学生姓名","年龄","email","电话号码"};
	
	private Object[][] getStudents(List list){
		Object[][] users=new Object[list.size()][5];
		
		for(int i=0;i<list.size();i++){
			StudentInfo user=(StudentInfo)list.get(i);
			users[i][0]=user.getSid();
			users[i][1]=user.getSname();
			users[i][2]=user.getAge();
			users[i][3]=user.getEmail();
			users[i][4]=user.getPhone_number();      //即使是管理员，也不应该看到密码
		}
		return users;	         		
	}

	public ModiStudentFrame() {
		super();
		// TODO Auto-generated constructor stub		
		
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("学生信息修改");						// 设置窗体标题－－－必须
		setBounds(100, 100, 500, 400);					// 设置窗体位置和大小－－－必须
		
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 200));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 150));
		panel.add(scrollPane);
		
		AdminManageDao adminManageDao = new AdminManageDao();
		List result = adminManageDao.getStudentInfo();
		Object[][] results=getStudents(result);
		table = new JTable(results,Infor);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		matainStuInfoPanel = new MatainStuInfoPanel();
		getContentPane().add(matainStuInfoPanel,BorderLayout.CENTER);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String sid,sname,age,email,phone_number;			
				int selRow = table.getSelectedRow();
				
				sid = table.getValueAt(selRow, 0).toString().trim();
				sname = table.getValueAt(selRow, 1).toString().trim();			
				age = table.getValueAt(selRow, 2).toString().trim();
				email = table.getValueAt(selRow, 3).toString().trim();
				phone_number = table.getValueAt(selRow, 4).toString().trim();
				
				matainStuInfoPanel.sid.setText(sid);
				matainStuInfoPanel.sname.setText(sname);
				matainStuInfoPanel.age.setText(age);
				matainStuInfoPanel.email.setText(email);
				matainStuInfoPanel.phone_number.setText(phone_number);				
			}
		});
		
		matainStuInfoPanel.buttonadd.addActionListener(new modifyStudentActionListener());
		matainStuInfoPanel.buttonclose.addActionListener(new DeleteActionListener());
		
		setVisible(true);
	}

}
