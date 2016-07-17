package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.Dao.AdminManageDao;
import com.global.User;
import com.util.MyDocument;

public class ChangePwdFrame extends JInternalFrame{
	
	class PwdChangeAction implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			if(oldpwd.getText().length()==0){
				JOptionPane.showMessageDialog(null, "原密码不可以为空");
				return;
			}
			if(newpwd.getText().length()==0){
				JOptionPane.showMessageDialog(null, "新密码不能为空");
				return;
			}
			if(newpwd2.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请再次确认输入密码");
				return;
			}
			
			String oldStr=oldpwd.getText().trim();
			String newStr = newpwd.getText().trim();
			String newStr1 = newpwd2.getText().trim();
			System.out.println(oldStr);
			System.out.println(User.password);
			
			if(!oldStr.equals(User.password)){   //User.password是静态变量，内存地址跟oldStr不一样
				JOptionPane.showMessageDialog(null, "原密码输入错误");
				return;
			}else{
				if(oldStr.equals(newStr)){
					JOptionPane.showMessageDialog(null, "新密码跟原密码一样");
					return;
				}
				if(!newStr.equals(newStr1)){
					JOptionPane.showMessageDialog(null, "两次密码输入不一样");
					return;
				}
				
				AdminManageDao adminManageDao = new AdminManageDao();
				int ans = adminManageDao.updatePassward(User.username,newStr1);
				if(ans == 1){
					JOptionPane.showMessageDialog(null, "密码修改成功");
				}
			}
			
		}
	}
	
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	
	private JPasswordField oldpwd,newpwd,newpwd2;
	final JButton button,button1;
	
	public ChangePwdFrame(){
		super();
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("换肤");						         // 设置窗体标题－－－必须
		setBounds(100, 100, 400, 280);					// 设置窗体位置和大小－－－必须
		
		final JPanel pane = new JPanel();
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 40, 20, 40));
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		panel.setLayout(gridLayout);
		getContentPane().add(panel,BorderLayout.CENTER);
		
		final JLabel label = new JLabel("原密码：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		oldpwd = new JPasswordField(20);
		oldpwd.setDocument(new MyDocument(6));
		oldpwd.setEchoChar('*');//设置密码框的回显字符
		panel.add(oldpwd);
		
		final JLabel label2 = new JLabel("新密码：");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label2);
		newpwd = new JPasswordField(20);
		newpwd.setDocument(new MyDocument(6));
		newpwd.setEchoChar('*');//设置密码框的回显字符
		panel.add(newpwd);
		
		final JLabel label3 = new JLabel("请确认：");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label3);
		newpwd2 = new JPasswordField(20);
		newpwd2.setDocument(new MyDocument(6));
		newpwd2.setEchoChar('*');//设置密码框的回显字符
		newpwd2.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == 10)
					button.doClick();
			}
		});
		panel.add(newpwd2);
		
		
		final JPanel panel2 = new JPanel();
		getContentPane().add(panel2,BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel2.setLayout(flowLayout);
		
		button = new JButton("确认");
		button.addActionListener(new PwdChangeAction());
		panel2.add(button);
		
		button1 = new JButton("取消");
		button1.addActionListener(new CloseActionListener());
		panel2.add(button1);

		
		setVisible(true);    //必须要加
	}
}
