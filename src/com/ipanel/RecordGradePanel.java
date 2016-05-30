package com.ipanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import po.RecordCourseInfo;

import com.Dao.ProIndicateCourseDao;
import com.iframe.ProfessorIFrame;
import com.iframe.inframe.RecordGradeFrame;
import com.iframe.inframe.ViewStuInfoFrame;

public class RecordGradePanel extends JPanel{
	private JTable table1;
	private JScrollPane scrollPane1;
	private JTextField textField,textField1,textField2,textField3,textField4;
	
	private Map<String, JInternalFrame> frames;           // 子窗体集合 
	 
	String cousersearch[] = { "课程编号", "课程名称", "学分", "登记状态","学生人数"};
	
	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][8];
		for (int i = 0; i < list.size(); i++) {
			RecordCourseInfo catalog = (RecordCourseInfo) list.get(i);		
			s[i][0] = catalog.getCid();
			s[i][1] = catalog.getCname();
			s[i][2] = catalog.getCredit();	
			s[i][3] = catalog.getRecord_state();
			s[i][4] = catalog.getStu_count();
		}
		return s;
	}
		
	public RecordGradePanel(){
		super();
		setLayout(new BorderLayout());
		
		final JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "已选课程详情", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel1,BorderLayout.NORTH);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setPreferredSize(new Dimension(600, 200));
		panel1.add(scrollPane1);
		
		ProIndicateCourseDao proIndicateCourseDao =new ProIndicateCourseDao();
		Object[][] results=getselect(proIndicateCourseDao.getRecordCourseInfo());
		table1 = new JTable(results,cousersearch);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.setRowHeight(25);
		scrollPane1.setViewportView(table1);
		
		table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String cid,cname,credit,record_state,num;			
				int selRow = table1.getSelectedRow();
				
				cid = table1.getValueAt(selRow, 0).toString().trim();
				cname = table1.getValueAt(selRow, 1).toString().trim();			
				credit = table1.getValueAt(selRow, 2).toString().trim();
				record_state = table1.getValueAt(selRow, 3).toString().trim();
				num = table1.getValueAt(selRow, 4).toString().trim();
				
				textField.setText(cid);
				textField1.setText(cname);
				textField2.setText(credit);
				textField3.setText(record_state);
				textField4.setText(num);				
			}
		});
		
		
		final JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "课程详情", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(2);
		flowLayout.setVgap(9);
		panel2.setLayout(flowLayout);
		this.add(panel2,BorderLayout.CENTER);
		panel2.setPreferredSize(new Dimension(300, 110));
		
		final JPanel panel2_1 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setVgap(8);
		panel2_1.setLayout(gridLayout);
		panel2_1.setPreferredSize(new Dimension(400, 160));
		panel2.add(panel2_1);
		
		final JLabel label = new JLabel();
		panel2_1.add(label);
		label.setText("    课程编号：");

		textField = new JTextField();
		panel2_1.add(textField);
		
		final JLabel label1 = new JLabel();
		panel2_1.add(label1);
		label1.setText("    课程名称：");

		textField1 = new JTextField();
		panel2_1.add(textField1);

		final JLabel label2 = new JLabel();
		panel2_1.add(label2);
		label2.setText("    学    分 ：");
		
		textField2 = new JTextField();
		panel2_1.add(textField2);
		
		final JLabel label3 = new JLabel();
		panel2_1.add(label3);
		label3.setText("    登记成绩：");

		textField3 = new JTextField();
		panel2_1.add(textField3);

		final JLabel label4 = new JLabel();
		panel2_1.add(label4);
		label4.setText("    选课人数 ：");
		
		textField4 = new JTextField();
		panel2_1.add(textField4);
		
		
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setPreferredSize(new Dimension(400, 50));
		this.add(panel3,BorderLayout.SOUTH);
		
		final JButton button = new JButton();
		button.setText("查看学生信息");
		panel3.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				ProIndicateCourseDao proIndicateCourseDao = new ProIndicateCourseDao();
				proIndicateCourseDao.getStudentInfo(textField.getText());  //这里有bug,textField可能为空
				ViewStuInfoFrame frame = new ViewStuInfoFrame();
				frame.setVisible(true);
			}
		});
		
		final JButton button2 = new JButton();
		button2.setText("登记学生成绩");
		panel3.add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				ProIndicateCourseDao proIndicateCourseDao = new ProIndicateCourseDao();
				proIndicateCourseDao.getCourseStudent(textField.getText(),textField1.getText());  //这里有bug,textField可能为空
				RecordGradeFrame frame = new RecordGradeFrame();
				frame.setVisible(true);
			}
		});
		
	}
}
