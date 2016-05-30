package com.ipanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import po.BillList;

import com.Dao.BillListDao;

public class BillSemesterPanel extends JPanel{
	private JTable table;
	private JScrollPane scrollPane;
	String couserbill[] = { "课程编号", "课程名称", "学分","学费"};
	private int cost;
	
	private Object [][] getselect(List list) {                 // 考虑做成静态的函数
		Object[][] s = new Object[list.size()][4];                
		for (int i = 0; i < list.size(); i++) {
			BillList catalog = (BillList) list.get(i);		
			s[i][0] = catalog.getCid();
			s[i][1] = catalog.getCname();
			s[i][2] = catalog.getCredit();
			s[i][3] = catalog.getBill();
			cost += catalog.getBill();                    //统计缴费金额
		}
		return s;
	} 
	
	public BillSemesterPanel() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		final JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "本学期学费清单", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel1,BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(600,400));
		panel1.add(scrollPane);
		
		BillListDao billListDao= new BillListDao();
		Object[][] results=getselect(billListDao.getBillList());
		table = new JTable(results,couserbill);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		panel2.setBorder(new TitledBorder(null, "确认并缴费", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		this.add(panel2);
		
		final JLabel label1 = new JLabel();
		label1.setText("缴费金额：" + cost);
		label1.setPreferredSize(new Dimension(0, 15));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label1);
		
		BillListDao billListDao2 = new BillListDao();
		final int rst = billListDao2.getBillState();    // 为了在内部类中使用
		
		final JLabel label2 = new JLabel();
		if (rst == 1){
			label2.setText("缴费状态：已缴费");
		}else{
			label2.setText("缴费状态：未缴费");
		}
		label2.setPreferredSize(new Dimension(0, 15));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label2);
		
		final JButton button1 = new JButton();
		button1.setText("缴费");
		panel2.add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if (rst == 1){
					JOptionPane.showMessageDialog(null, "你已经成功缴费了");
				}else{
					BillListDao billListDao= new BillListDao();
					billListDao.setBillState();
					JOptionPane.showMessageDialog(null, "恭喜你完成缴费");
				}
			}
        });		
		
		final JButton button2 = new JButton();
		button2.setText("取消");
		panel2.add(button2);
	}
	
}
