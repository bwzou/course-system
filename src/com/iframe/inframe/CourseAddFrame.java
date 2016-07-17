package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.Dao.AdminManageDao;

public class CourseAddFrame extends JInternalFrame{
	class addBookActionListener implements ActionListener {		// 添加按钮的单击事件监听器
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
			int i=adminManageDao.addCourseInfo(cids, cnames, credits, credit_hourss, departments, teach_times, classrooms, bills);				
			if(i==1){
				JOptionPane.showMessageDialog(null, "添加成功");
				doDefaultCloseAction();
			}
		}
	}
	
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	
	class NumberListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789"+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
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
	
	
	public CourseAddFrame() {
		super();
		// TODO Auto-generated constructor stub
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("课程信息添加");						// 设置窗体标题－－－必须
		setBounds(100, 100, 400, 250);					// 设置窗体位置和大小－－－必须

		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		panel.setLayout(gridLayout);
		getContentPane().add(panel);

		final JLabel label_1 = new JLabel();
		label_1.setText("课程编号：");
		panel.add(label_1);
		cid = new JTextField();
		panel.add(cid);
		cid.addKeyListener(new NumberListener());

		final JLabel label_2 = new JLabel();
		label_2.setText("课程名称：");
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
		
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel_1.setLayout(flowLayout);

		buttonadd= new JButton();
		buttonadd.addActionListener(new addBookActionListener());
		buttonadd.setText("添加");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("关闭");
		panel_1.add(buttonclose);
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
	
}
