package com.ipanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import po.CourseCatalog;

import com.Dao.ProIndicateCourseDao;
import com.Dao.SelectCourseDao;
import com.iframe.ProfessorIFrame;

public class IndicateCoursePanel extends JPanel {
	private JTextField textField;
	private JTable table1,table2;
	private JScrollPane scrollPane1, scrollPane2;
	
	String cousersearch[] = { "课程编号", "课程名称", "学分", "学时","院系",  "上课时间", "教室" ,"学费"};
	
	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][8];
		for (int i = 0; i < list.size(); i++) {
			CourseCatalog catalog = (CourseCatalog) list.get(i);		
			s[i][0] = catalog.getCid();
			s[i][1] = catalog.getCname();
			s[i][2] = catalog.getCredit();	
			s[i][3] = catalog.getCredit_hours();
			s[i][4] = catalog.getDepartments();
			s[i][5] = catalog.getTeach_time();
			s[i][6] = catalog.getClassroom();
			s[i][7] = catalog.getBill();
		}
		return s;
	}
	
	public IndicateCoursePanel() {
		super();	
		setLayout(new BorderLayout());
		
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(0, 50));
		this.add(tabbedPane);
		
		final JPanel panel_1 = new JPanel();      
		panel_1.setLayout(new BorderLayout());
		tabbedPane.addTab("选择要授课科目", null, panel_1, null);
		
		final JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "请选择课程编号", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1_1.setPreferredSize(new Dimension(0, 50));
		panel_1.add(panel_1_1, BorderLayout.NORTH);	
        
		textField = new JTextField();
		textField.setColumns(20);
		panel_1_1.add(textField);				
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "已选课程详情", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1.add(panel);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setPreferredSize(new Dimension(600, 250));
		panel.add(scrollPane1);
		
		final JButton button = new JButton();
		button.setText("选课");
		panel_1_1.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ProIndicateCourseDao proIndicateCourseDao =new ProIndicateCourseDao();
				proIndicateCourseDao.IndicateCourse(textField.getText());
				ProIndicateCourseDao proIndicateCourseDao1 =new ProIndicateCourseDao();
				Object[][] results=getselect(proIndicateCourseDao1.getIndicateCourse());
				table1 = new JTable(results,cousersearch);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.setRowHeight(25);
				scrollPane1.setViewportView(table1);
			}
        });		
		
		final JButton button1 = new JButton();
		button1.setText("退课");
		panel_1_1.add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ProIndicateCourseDao proIndicateCourseDao =new ProIndicateCourseDao();
				proIndicateCourseDao.CancelCourse(textField.getText());
				ProIndicateCourseDao proIndicateCourseDao1 =new ProIndicateCourseDao();
				Object[][] results=getselect(proIndicateCourseDao1.getIndicateCourse());
				table1 = new JTable(results,cousersearch);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.setRowHeight(25);
				scrollPane1.setViewportView(table1);
			}
        });		
			
		
		final JPanel panel_2 = new JPanel();
		tabbedPane.addTab("显示全部课程信息", null, panel_2, null);
         
		scrollPane2 = new JScrollPane();
		scrollPane2.setPreferredSize(new Dimension(600, 350));
		panel_2.add(scrollPane2);
		
		SelectCourseDao selectCourseDao = new SelectCourseDao();
		Object[][] results=getselect(selectCourseDao.selectAllCourse());
		table2 = new JTable(results,cousersearch);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setRowHeight(25);
		scrollPane2.setViewportView(table2);	
	}
}
