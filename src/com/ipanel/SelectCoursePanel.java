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

import com.Dao.SelectCourseDao;

public class SelectCoursePanel extends JPanel {       //查询课程
	private JTextField textField;
	private JTable table1,table2;
	private JComboBox choice;
	private JScrollPane scrollPane1, scrollPane2;
	
	String cousersearch[] = { "课程编号", "课程名称", "学分", "教师", "学时","院系",  "上课时间", "教室" ,"学费"};
	
	private Object[][] getselect(List list) {
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
	
	public SelectCoursePanel() {
		super();	
		setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(0, 50));
		this.add(tabbedPane);
		
		final JPanel panel_1 = new JPanel();      
		panel_1.setLayout(new BorderLayout());
		tabbedPane.addTab("条件查询", null, panel_1, null);
		
		final JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "请选择查询项目", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1_1.setPreferredSize(new Dimension(0, 50));
		panel_1.add(panel_1_1, BorderLayout.NORTH);	
        choice=new JComboBox();
		String[] array={"课程名称","教师姓名"};
		for(int i=0;i<array.length;i++){
			choice.addItem(array[i]);		
		}
		panel_1_1.add(choice);
		textField = new JTextField();
		textField.setColumns(20);
		panel_1_1.add(textField);				
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "查询结果显示", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1.add(panel);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setPreferredSize(new Dimension(600, 250));
		panel.add(scrollPane1);
		
		final JButton button = new JButton();
		button.setText("查询");
		panel_1_1.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name=(String)choice.getSelectedItem();
				SelectCourseDao selectCourseDao=new SelectCourseDao();
				Object[][] results=null;
				if(name.equals("课程名称")){					
					results=getselect(selectCourseDao.selectCourseByCname(textField.getText()));
					
				}
				else if(name.equals("教师姓名")){
					results=getselect(selectCourseDao.selectCourseByTname(textField.getText()));
					
				}
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
