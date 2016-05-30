package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import po.RecordGrade;

import com.Dao.ProIndicateCourseDao;
import com.global.DataTransfer;

public class RecordGradeFrame extends JFrame{
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField,textField1,textField2,textField3,textField4;
	private String Infor[]={"课程编号","课程名称","学号","姓名","成绩"};
	
	private Object[][] getStudents(List list){
		Object[][] users=new Object[list.size()][5];
		
		for(int i=0;i<list.size();i++){
			RecordGrade user=(RecordGrade)list.get(i);
			users[i][0]=user.getCid();
			users[i][1]=user.getCname();
			users[i][2]=user.getSid();
			users[i][3]=user.getSname();
			users[i][4]=user.getGrade();   //有默认值
		}
		return users;	         		
	}
	
	public RecordGradeFrame(){
		super();
		setTitle("学生成绩登记");
		setBounds(100, 100, 500, 520);
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 200));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 150));
		panel.add(scrollPane);
		
		Object[][] results=getStudents(DataTransfer.recordGrade);
		table = new JTable(results,Infor);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {			
				String cid,cname,sid,sname,grade;		// 参数名没有改过来	
				int selRow = table.getSelectedRow();
				
				cid = table.getValueAt(selRow, 0).toString().trim();
				cname = table.getValueAt(selRow, 1).toString().trim();			
				sid = table.getValueAt(selRow, 2).toString().trim();
				sname = table.getValueAt(selRow, 3).toString().trim();
				grade = table.getValueAt(selRow, 4).toString().trim();
				
				textField.setText(cid);
				textField1.setText(cname);
				textField2.setText(sid);
				textField3.setText(sname);
				Float flag = Float.parseFloat(grade);
				if(flag == -1){
					textField4.setText(null);
					textField4.setEditable(true);
				}else{
					textField4.setText(grade);
					textField4.setEditable(false);
				}				
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
		label.setText("    课程编号：");

		textField = new JTextField();
		textField.setEditable(false);
		panel2_1.add(textField);
		
		final JLabel label1 = new JLabel();
		panel2_1.add(label1);
		label1.setText("    课程名称：");

		textField1 = new JTextField();
		textField1.setEditable(false);
		panel2_1.add(textField1);

		final JLabel label2 = new JLabel();
		panel2_1.add(label2);
		label2.setText("    学      号：");
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		panel2_1.add(textField2);
		
		final JLabel label3 = new JLabel();
		panel2_1.add(label3);
		label3.setText("    姓      名：");

		textField3 = new JTextField();
		textField3.setEditable(false);
		panel2_1.add(textField3);

		final JLabel label4 = new JLabel();
		panel2_1.add(label4);
		label4.setText("    成      绩 ：");
		
		textField4 = new JTextField();
		panel2_1.add(textField4);
		
		
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setPreferredSize(new Dimension(400, 50));
		getContentPane().add(panel3,BorderLayout.SOUTH);
		
		final JButton button = new JButton();
		button.setText("确认登记");
		panel3.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				ProIndicateCourseDao proIndicateCourseDao = new ProIndicateCourseDao();
				boolean res =proIndicateCourseDao.getRecordGrade(textField.getText(),textField2.getText(),textField4.getText());  
				if(res){
					textField4.setEditable(false);
				}else{
					JOptionPane.showMessageDialog(null,
							"网络错误，请重试！");
				}
				int selRow = table.getSelectedRow();
				
				String grade = textField4.getText();
				table.setValueAt(grade, selRow, 4);
			}
		});
		
	}
}
