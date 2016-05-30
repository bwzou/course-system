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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import po.CourseCatalog;

import com.Dao.SelectCourseDao;
import com.Dao.StudentSelectCourseDao;

public class ChooseCoursePanel extends JPanel{				//选课退课
	private JTextField textField;
	private JScrollPane scrollPane;
	private JComboBox choice;
	private JTable table1;
	
	String cousersearch[] = { "课程编号", "课程名称", "学分", "教师", "学时","院系",  "上课时间", "教室" ,"学费"};
	private Object[][] getselect(List list) {                 // 考虑做成静态的函数
		Object[][] s = new Object[list.size()][9];                
		for (int i = 0; i < list.size(); i++) {
			CourseCatalog catalog = (CourseCatalog) list.get(i);		
			s[i][0] = catalog.getCid();
			s[i][1] = catalog.getCname();
			s[i][2] = catalog.getCredit();
			if(catalog.getTname()==null){
				s[i][3]="无";
			}else{
				s[i][3] = catalog.getTname();
			}		
			s[i][4] = catalog.getCredit_hours();
			s[i][5] = catalog.getDepartments();
			s[i][6] = catalog.getTeach_time();
			s[i][7] = catalog.getClassroom();
			s[i][8] = catalog.getBill();
		}
		return s;
	}
	
	public ChooseCoursePanel(){
		super();
		this.setLayout(new BorderLayout());
		
		final JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "请输入选课序号", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1_1.setPreferredSize(new Dimension(0, 50));
		this.add(panel_1_1, BorderLayout.NORTH);
		
		choice=new JComboBox();
		String[] array={"正选","备选"};
		for(int i=0;i<array.length;i++){
			choice.addItem(array[i]);		
		}
		panel_1_1.add(choice);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_1_1.add(textField);	
		
		final JButton selectButton = new JButton();
		selectButton.setText("选课");
		panel_1_1.add(selectButton);
		
		final JButton cancelButton = new JButton();
		cancelButton.setText("退课");
		panel_1_1.add(cancelButton);
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "选课退课", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(600, 250));
		panel.add(scrollPane);
		
		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				String name=(String)choice.getSelectedItem();
				StudentSelectCourseDao studentSelectCourseDao = new StudentSelectCourseDao();
				SelectCourseDao selectCourseDao = new SelectCourseDao();
				if(name.equals("正选")){					
					studentSelectCourseDao.SelectCourse(textField.getText(), 0);
				}
				else if(name.equals("备选")){
					studentSelectCourseDao.SelectCourse(textField.getText(), 1);
				}
				Object[][] results=getselect(selectCourseDao.StudentSelectedCourse());
				table1 = new JTable(results,cousersearch);
				scrollPane.setViewportView(table1);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.setRowHeight(25);
			}
        });		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				String name=(String)choice.getSelectedItem();
				StudentSelectCourseDao studentSelectCourseDao = new StudentSelectCourseDao();
				SelectCourseDao selectCourseDao = new SelectCourseDao();
				if(name.equals("正选")){	
					studentSelectCourseDao.CancelCourse(textField.getText(),0);
				}
				else if(name.equals("备选")){
					studentSelectCourseDao.CancelCourse(textField.getText(),1);
				}
				Object[][] results=getselect(selectCourseDao.StudentSelectedCourse());
				table1 = new JTable(results,cousersearch);
				scrollPane.setViewportView(table1);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.setRowHeight(25);
			}
        });		
	}
}
