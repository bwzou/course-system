package com.ipanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.Dao.AdminManageDao;

public class MatainStuInfoPanel extends JPanel{	
	class NumberListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789"+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}

	public JTextField sid;    // 方便重用
	public JTextField sname;
	public JTextField password;
	public JTextField age;
	public JTextField email;
	public JTextField phone_number;
	public JButton buttonadd;
	public JButton buttonclose;
	
	public MatainStuInfoPanel() {
		super();
		// TODO Auto-generated constructor stub
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		panel.setLayout(gridLayout);
		this.add(panel,BorderLayout.CENTER);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText("学生学号：");
		panel.add(label_1);
		sid = new JTextField();
		panel.add(sid);
		sid.addKeyListener(new NumberListener());

		final JLabel label_2 = new JLabel();
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setText("学生姓名：");
		panel.add(label_2);
		sname = new JTextField();
		panel.add(sname);

		final JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setText("学生密码：");
		panel.add(label_3);
		password = new JTextField();
		panel.add(password);

		final JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("学生年龄：");
		panel.add(label_4);
		age = new JTextField();
		panel.add(age);

		final JLabel label_5 = new JLabel();
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setText("学生邮箱：");
		panel.add(label_5);
		email = new JTextField();
		panel.add(email);
		
		final JLabel label_6 = new JLabel();
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setText("电话号码：");
		panel.add(label_6);
		phone_number = new JTextField();
		panel.add(phone_number);
		
		
		final JPanel panel_1 = new JPanel();
		this.add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel_1.setLayout(flowLayout);

		buttonadd= new JButton();
		buttonadd.setText("添加");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.setText("关闭");
		panel_1.add(buttonclose);
	
	}
	
}
