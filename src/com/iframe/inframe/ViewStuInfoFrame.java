package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import po.StudentInfo;

import com.global.DataTransfer;

public class ViewStuInfoFrame extends JFrame{
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField,textField1,textField2,textField3,textField4;
	private String Infor[]={"学号","学生姓名","年龄","email","电话号码"};
	
	private Object[][] getStudents(List list){
		Object[][] users=new Object[list.size()][5];
		
		for(int i=0;i<list.size();i++){
			StudentInfo user=(StudentInfo)list.get(i);
			users[i][0]=user.getSid();
			users[i][1]=user.getSname();
			users[i][2]=user.getAge();
			users[i][3]=user.getEmail();
			users[i][4]=user.getPhone_number();
		}
		return users;	         		
	}
	
	public ViewStuInfoFrame(){
		super();
		setTitle("学生信息显示");
		setBounds(100, 100, 500, 450);
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 200));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 150));
		panel.add(scrollPane);
		
		Object[][] results=getStudents(DataTransfer.Student);
		table = new JTable(results,Infor);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String sid,sname,age,email,phone_number;			
				int selRow = table.getSelectedRow();
				
				sid = table.getValueAt(selRow, 0).toString().trim();
				sname = table.getValueAt(selRow, 1).toString().trim();			
				age = table.getValueAt(selRow, 2).toString().trim();
				email = table.getValueAt(selRow, 3).toString().trim();
				phone_number = table.getValueAt(selRow, 4).toString().trim();
				
				textField.setText(sid);
				textField1.setText(sname);
				textField2.setText(age);
				textField3.setText(email);
				textField4.setText(phone_number);				
			}
		});
		
		
		final JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "学生详情", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(2);
		flowLayout.setVgap(9);
		panel2.setLayout(flowLayout);
		getContentPane().add(panel2,BorderLayout.CENTER);
		panel2.setPreferredSize(new Dimension(300, 110));
		
		
		final JPanel panel2_1 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setVgap(5);
		panel2_1.setLayout(gridLayout);
		panel2_1.setPreferredSize(new Dimension(400, 160));
		panel2.add(panel2_1);
		
		final JLabel label = new JLabel();
		panel2_1.add(label);
		label.setText("    学     号：");

		textField = new JTextField();
		panel2_1.add(textField);
		
		final JLabel label1 = new JLabel();
		panel2_1.add(label1);
		label1.setText("    姓     名：");

		textField1 = new JTextField();
		panel2_1.add(textField1);

		final JLabel label2 = new JLabel();
		panel2_1.add(label2);
		label2.setText("    年    龄 ：");
		
		textField2 = new JTextField();
		panel2_1.add(textField2);
		
		final JLabel label3 = new JLabel();
		panel2_1.add(label3);
		label3.setText("    电子邮箱：");

		textField3 = new JTextField();
		panel2_1.add(textField3);

		final JLabel label4 = new JLabel();
		panel2_1.add(label4);
		label4.setText("    手机号码 ：");
		
		textField4 = new JTextField();
		panel2_1.add(textField4);
	}
}
