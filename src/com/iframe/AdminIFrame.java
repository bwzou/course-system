package com.iframe;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

import com.action.MenuActions;

public class AdminIFrame extends JFrame{
	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();   //使用内部窗口
	
	public static void addIFame(JInternalFrame iframe) {    // 添加子窗体的方法
		DESKTOP_PANE.add(iframe);
	}

	public AdminIFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(800, 600);
		setTitle("Welcome to Course Registration System Of Wylie");
		
		JMenuBar menuBar = createMenu(); // 调用创建菜单栏的方法
		setJMenuBar(menuBar);
		
		final JLabel label = new JLabel();
		label.setBounds(0, 0, 0, 0);
		label.setIcon(null); // 窗体背景
		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				label.setSize(e.getComponent().getSize());
				label.setText("<html><img width=" + size.width + " height="      //label还能显示静态网页
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");  
			}
		});
		
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));
		getContentPane().add(DESKTOP_PANE);
	}
	
	/**
	 * 创建菜单栏
	 */
	private JMenuBar createMenu() {    // 创建菜单栏的方法
		JMenuBar menuBar = new JMenuBar();

		JMenu studentMenu = new JMenu("学生信息维护");    // 学生信息维护
//		bookOrderMenu.setIcon(CreatecdIcon.add("xsdgcd.jpg"));
		studentMenu.add(MenuActions.STUDENT_ADD);
		studentMenu.add(MenuActions.STUDENT_MODIFY);
		 
		JMenu courseMenu = new JMenu("课程信息维护");        // 课程信息维护
//		baseMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg"));
		courseMenu.add(MenuActions.COURSE_ADD);
		courseMenu.add(MenuActions.COURSE_MODIFY);
		courseMenu.addSeparator();
		courseMenu.add(MenuActions.EXIT);
		
		JMenu professorMenu = new JMenu("教授信息维护");      // 教授信息维护
//		borrowManageMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));
		professorMenu.add(MenuActions.PROFESSOR_ADD); 
		professorMenu.add(MenuActions.PROFESSOR_MODIFY); 

		JMenu sysManageMenu = new JMenu("系统维护");        // 系统维护
//		sysManageMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));		
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);

		menuBar.add(courseMenu);  // 添加课程数据维护菜单到菜单栏
		menuBar.add(studentMenu);   // 添加学生信息维护菜单到菜单栏
		menuBar.add(professorMenu);  // 添加教授信息维护菜单到菜单栏
		menuBar.add(sysManageMenu);    // 添加系统维护菜单到菜单栏
		return menuBar;	
	}
	
}
