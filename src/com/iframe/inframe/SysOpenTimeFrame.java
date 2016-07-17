package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.Dao.AdminManageDao;
import com.ibutton.DateChooserJButton;

public class SysOpenTimeFrame extends JInternalFrame{
	class ChangeOpenTimeAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AdminManageDao adminManageDao = new AdminManageDao();
			String start = dateChooserJButton.getText().trim();
			String end = dateChooserJButton2.getText().trim();
			int rst = adminManageDao.settingOpenTime(start, end);
			if(rst == 1){
				JOptionPane.showMessageDialog(null, "修改成功");
				doDefaultCloseAction();
			}
		}
		
	}
	
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	DateChooserJButton dateChooserJButton;
	DateChooserJButton dateChooserJButton2;
	
	public SysOpenTimeFrame() {
		super();
		// TODO Auto-generated constructor stub
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("课程开放与关闭时间");						// 设置窗体标题－－－必须
		setBounds(100, 100, 300, 200);					// 设置窗体位置和大小－－－必须
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		getContentPane().add(panel,BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(0,100));
		
		JLabel label = new JLabel("起始时间：");
		panel.add(label);
		 dateChooserJButton = new DateChooserJButton();
		panel.add(dateChooserJButton);
		
		JLabel label2 = new JLabel("结束时间：");
		panel.add(label2);
		 dateChooserJButton2 = new DateChooserJButton();
		panel.add(dateChooserJButton2);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,2));
		panel2.setPreferredSize(new Dimension(0,50));
		getContentPane().add(panel2,BorderLayout.SOUTH);
		
		JButton button = new JButton("确定");
		panel2.add(button);
		button.addActionListener(new ChangeOpenTimeAction());
		
		JButton button2 = new JButton("取消");
		panel2.add(button2);
		button2.addActionListener(new CloseActionListener());
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}

	
}
