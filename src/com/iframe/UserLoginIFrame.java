package com.iframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.lang.model.type.NullType;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.Dao.LoginDao;
import com.global.User;
import com.util.LoadImage;
import com.util.MyDocument;


public class UserLoginIFrame extends JFrame{

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
			new UserLoginIFrame();//登录窗口
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private class UserResetAction implements ActionListener {     //重置
		public void actionPerformed(final ActionEvent e){
			username.setText("");
			password.setText("");	
		}
	}

	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JRadioButton temp=(JRadioButton)arg0.getSource();
			if(temp.isSelected()){
				User.actor=temp.getText();
			}     
		}     
	}

	class UserLoginAction implements ActionListener {      //登录
		public void actionPerformed(final ActionEvent e) {
			//			user = Dao.check(username.getText(), password.getText());

			User.username=username.getText();
			User.password=password.getText();
			
			if (User.actor==null){
				JOptionPane.showMessageDialog(null, "请选择登陆身份");
			}else{
				LoginDao loginDao  =new LoginDao();
				result=loginDao.checkUser(User.username, User.password, User.actor);
				if(result){
					try {
						if(User.actor=="学生"){
							StudentIFrame frame = new StudentIFrame();
							frame.setVisible(true);
						}else if(User.actor=="教授"){
							ProfessorIFrame frame = new ProfessorIFrame();
							frame.setVisible(true);							
						}else if(User.actor=="管理员"){
							AdminIFrame frame = new AdminIFrame();
							frame.setVisible(true);	
						}
						UserLoginIFrame.this.setVisible(false);   
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重试");
					username.setText("");
					password.setText("");
				}

			}
		}
	}

	private JPasswordField password;
	private JTextField username;
	private ButtonGroup bg;
	private JRadioButton b1,b2,b3;
	private JButton login;
	private JButton reset;
	private boolean result;

	public UserLoginIFrame() {
		super();

		final BorderLayout borderLayout = new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		setTitle("online Course Registration System Of Wylie ");
		setBounds(100, 100, 285, 294);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel);

		final JPanel pane2 = new JPanel();
		pane2.setLayout(new BorderLayout());
		pane2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(pane2);
		
		final JPanel panel_2 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setHgap(5);
		gridLayout.setVgap(20);
		panel_2.setLayout(gridLayout);
		pane2.add(panel_2,BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0, 0));
		label.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label);
		label.setText("用  户  名：");

		username = new JTextField(20);
		username.setPreferredSize(new Dimension(0, 0));
		panel_2.add(username);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		label_1.setText("密      码：");

		password = new JPasswordField(20);
		password.setDocument(new MyDocument(6));
		password.setEchoChar('*');//设置密码框的回显字符
		password.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == 10)
					login.doClick();
			}
		});
		panel_2.add(password);

		final JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(0,3));
		b1 = new JRadioButton("学生",false);
		b1.addActionListener(new RadioButtonListener());
		b2 = new JRadioButton("教授",false);
		b2.addActionListener(new RadioButtonListener());
		b3 = new JRadioButton("管理员",false);
		b3.addActionListener(new RadioButtonListener());
		bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		panel_3.add(b1);
		panel_3.add(b2);
		panel_3.add(b3);
		pane2.add(panel_3,BorderLayout.SOUTH);

		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		login=new JButton();
		login.addActionListener(new UserLoginAction());

		login.setText("登录");
		panel_1.add(login);
		reset=new JButton();
		reset.addActionListener(new UserResetAction());

		reset.setText("重置");
		panel_1.add(reset);

		final JLabel tupianLabel = new JLabel();
		ImageIcon loginIcon=LoadImage.add("login.png");
		tupianLabel.setIcon(loginIcon);
		tupianLabel.setOpaque(true);
		tupianLabel.setBackground(Color.GREEN);
		tupianLabel.setPreferredSize(new Dimension(260, 90));
		panel.add(tupianLabel, BorderLayout.NORTH);

		setVisible(true);
		setResizable(false);
	}

	
}
