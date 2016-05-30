package com.ipanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.Dao.SelectCourseDao;

import po.AlreadyCourse;
import po.CourseCatalog;

public class ViewGradePanel extends JPanel{
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField,textField2; 
	private Float score  = (float) 0;
	private Float points = (float) 0;
	
	String cousersearch[] = { "课程编号", "课程名称", "学分", "教师", "学时","院系","成绩"};
	private Object[][] getselect(List list) {                 // 考虑做成静态的函数
		Object[][] s = new Object[list.size()][9];                
		for (int i = 0; i < list.size(); i++) {
			AlreadyCourse catalog = (AlreadyCourse) list.get(i);		
			s[i][0] = catalog.getCid();
			s[i][1] = catalog.getCname();
			s[i][2] = catalog.getCredit();
			score+=catalog.getCredit();                      //统计学分
			if(catalog.getTname()==null){
				s[i][3]="无";
			}else{
				s[i][3] = catalog.getTname();
			}		
			s[i][4] = catalog.getCredit_hours();
			s[i][5] = catalog.getDepartments();
			s[i][6] = catalog.getGrade();                   //统计学分积
			points += catalog.getCredit() * catalog.getGrade();
		}
		return s;
	}
	
	public ViewGradePanel() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		
		final JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "已修课程详情", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel1,BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(600,400));
		panel1.add(scrollPane);
		SelectCourseDao selectCourseDao = new SelectCourseDao();
		Object[][] results=getselect(selectCourseDao.HadMajorCourse());
		table = new JTable(results,cousersearch);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		
		final JPanel panel2 = new JPanel();	
		panel2.setBorder(new TitledBorder(null, "已修课程统计", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel2,BorderLayout.CENTER);
		
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,4));
		panel3.setPreferredSize(new Dimension(400,50));
		panel2.add(panel3,BorderLayout.NORTH);
		
		final JLabel label1 = new JLabel();
		label1.setText("已修学分");
		label1.setPreferredSize(new Dimension(0, 15));
		label1.setHorizontalAlignment(SwingConstants.CENTER);	
		panel3.add(label1);
		
		
		textField = new JTextField();
		textField.setText(score+"");
		textField.setPreferredSize(new Dimension(0, 15));
		panel3.add(textField);
		
		final JLabel label2 = new JLabel();
		label2.setText("学分积");
		label2.setPreferredSize(new Dimension(0, 15));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(label2);
		
		textField2 = new JTextField();
		textField2.setText(points/score + "");
		textField2.setPreferredSize(new Dimension(0, 15));
		panel3.add(textField2);
		
	}
	
}
