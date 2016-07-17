package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.Dao.AdminManageDao;
import com.ipanel.SelectCoursePanel;

public class CourseModiFrame extends JInternalFrame{
	class ChangeActionListener implements ActionListener {		// 添加按钮的单击事件监听器
		public void actionPerformed(final ActionEvent e) {
			if(cid.getText().length()==0){
				JOptionPane.showMessageDialog(null, "课程编号不可以为空");
				return;
			}
			if(cname.getText().length()==0){
				JOptionPane.showMessageDialog(null, "课程名称不能为空");
				return;
			}
			if(credit.getText().length()==0){
				JOptionPane.showMessageDialog(null, "课程学分不能为空");
				return;
			}
			if(credit_hours.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学时不可以为空");
				return;
			}
			if(department.getText().length()==0){
				JOptionPane.showMessageDialog(null, "开课院系不可以为空");
				return;
			}
			if(teach_time.getText().length()==0){
				JOptionPane.showMessageDialog(null, "上课时间不可以为空");
				return;
			}
			if(classroom.getText().length()==0){
				JOptionPane.showMessageDialog(null, "上课教室不可以为空");
				return;
			}
			if(bill.getText().length()==0){
				JOptionPane.showMessageDialog(null, "学费不可以为空");
				return;
			}

			String cids=cid.getText().trim();			
			String cnames=cname.getText().trim();
			String credits=credit.getText().trim();
			String credit_hourss=credit_hours.getText().trim();
			String departments=department.getText().trim();
			String teach_times=teach_time.getText().trim();
			String classrooms=classroom.getText().trim();
			String bills=bill.getText().trim();
			
			AdminManageDao adminManageDao = new AdminManageDao();
			int i=adminManageDao.changeCourseInfo(cids, cnames, credits, credit_hourss, departments, teach_times, classrooms, bills);				
			if(i==1){
				JOptionPane.showMessageDialog(null, "添加成功");
				doDefaultCloseAction();
			}
		}
	}
	
	class DeleteActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(cid.getText().length()==0){
				JOptionPane.showMessageDialog(null, "课程编号不可以为空");
				return;
			}
			
			AdminManageDao adminManageDao = new AdminManageDao();
			int n = adminManageDao.deleteCourseInfo(cid.getText().trim());
			if(n==1){
				JOptionPane.showMessageDialog(null, "删除成功");
				doDefaultCloseAction();
			}
		}
		
	}

	
	private JTextField cid;
	private JTextField cname;
	private JTextField credit;
	private JTextField credit_hours;
	private JTextField department;
	private JTextField teach_time;
	private JTextField classroom;
	private JTextField bill;
	private JButton buttonadd;
	private JButton buttonclose;
	private SelectCoursePanel selectCoursePanel;
	
	
	public CourseModiFrame() {
		super();
		// TODO Auto-generated constructor stub
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("课程信息修改");						// 设置窗体标题－－－必须
		setBounds(50, 50, 600, 500);					// 设置窗体位置和大小－－－必须
	
		selectCoursePanel = new SelectCoursePanel();
		getContentPane().add(selectCoursePanel,BorderLayout.CENTER);
		
		selectCoursePanel.table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String cids,cnames,credits,credit_hourss,departments,teach_times,classrooms,bills;			
				int selRow = selectCoursePanel.table1.getSelectedRow();
				
				cids = selectCoursePanel.table1.getValueAt(selRow, 0).toString().trim();
				cnames = selectCoursePanel.table1.getValueAt(selRow, 1).toString().trim();			
				credits = selectCoursePanel.table1.getValueAt(selRow, 2).toString().trim();
				credit_hourss = selectCoursePanel.table1.getValueAt(selRow, 4).toString().trim();
				departments = selectCoursePanel.table1.getValueAt(selRow, 5).toString().trim();
				teach_times = selectCoursePanel.table1.getValueAt(selRow, 6).toString().trim();
				classrooms = selectCoursePanel.table1.getValueAt(selRow, 7).toString().trim();
				bills = selectCoursePanel.table1.getValueAt(selRow, 8).toString().trim();
				
				
				cid.setText(cids);
				cname.setText(cnames);
				credit.setText(credits);
				credit_hours.setText(credit_hourss);
				department.setText(departments);
				teach_time.setText(teach_times);
				classroom.setText(classrooms);
				bill.setText(bills);
			}
		});
		selectCoursePanel.table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String cids,cnames,credits,credit_hourss,departments,teach_times,classrooms,bills;			
				int selRow = selectCoursePanel.table2.getSelectedRow();
				
				cids = selectCoursePanel.table2.getValueAt(selRow, 0).toString().trim();
				cnames = selectCoursePanel.table2.getValueAt(selRow, 1).toString().trim();			
				credits = selectCoursePanel.table2.getValueAt(selRow, 2).toString().trim();
				credit_hourss = selectCoursePanel.table2.getValueAt(selRow, 4).toString().trim();
				departments = selectCoursePanel.table2.getValueAt(selRow, 5).toString().trim();
				teach_times = selectCoursePanel.table2.getValueAt(selRow, 6).toString().trim();
				classrooms = selectCoursePanel.table2.getValueAt(selRow, 7).toString().trim();
				bills = selectCoursePanel.table2.getValueAt(selRow, 8).toString().trim();
				
				cid.setText(cids);
				cname.setText(cnames);
				credit.setText(credits);
				credit_hours.setText(credit_hourss);
				department.setText(departments);
				teach_time.setText(teach_times);
				classroom.setText(classrooms);
				bill.setText(bills);
			}
		});
		

		final JPanel panel = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(4);
		gridLayout.setHgap(4);
		panel.setLayout(gridLayout);
		getContentPane().add(panel,BorderLayout.SOUTH);
		panel.setBorder(new TitledBorder(null, "修改课程", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		
		final JLabel label_1 = new JLabel();
		label_1.setText("课程编号：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		cid = new JTextField();
		panel.add(cid);
//		ISBN.addKeyListener(new ISBNkeyListener());
//		ISBN.addFocusListener(new ISBNFocusListener());
		
		final JLabel label_2 = new JLabel();
		label_2.setText("课程名称：");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_2);
		cname = new JTextField();
		panel.add(cname);

		final JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setText("学     分：");
		panel.add(label_3);
		credit = new JTextField();
		panel.add(credit);

		final JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("学     时：");
		panel.add(label_4);
		credit_hours = new JTextField();
		panel.add(credit_hours);

		final JLabel label_5 = new JLabel();
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setText("开课院系：");
		panel.add(label_5);
		department = new JTextField();
		panel.add(department);
		
		final JLabel label_6 = new JLabel();
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setText("上课时间：");
		panel.add(label_6);
		teach_time = new JTextField();
		panel.add(teach_time);
		
		final JLabel label_7 = new JLabel();
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setText("上课教室：");
		panel.add(label_7);
		classroom = new JTextField();
		panel.add(classroom);
		
		final JLabel label_8 = new JLabel();
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setText("学    费：");
		panel.add(label_8);
		bill = new JTextField();
		panel.add(bill);
		
		
		final JLabel label_9 = new JLabel();
		panel.add(label_9);
		
		buttonadd= new JButton();
		buttonadd.addActionListener(new ChangeActionListener());
		buttonadd.setText("修改");
		panel.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.addActionListener(new DeleteActionListener());
		buttonclose.setText("删除");
		panel.add(buttonclose);

		final JLabel label_10 = new JLabel();
		panel.add(label_10);
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
	
}
