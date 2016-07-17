package com.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.action.MenuActions;
import com.util.LoadImage;

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
		setBounds(300, 100, 800, 600);
		setTitle("Welcome to Course Registration System Of Wylie");
		
		JMenuBar menuBar = createMenu(); // 调用创建菜单栏的方法
		setJMenuBar(menuBar);
		
		JToolBar toolBar = createToolBar(); // 调用创建工具栏的方法
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
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
		studentMenu.add(MenuActions.STUDENT_ADD);
		studentMenu.add(MenuActions.STUDENT_MODIFY);
		 
		JMenu courseMenu = new JMenu("课程信息维护");        // 课程信息维护
		courseMenu.add(MenuActions.COURSE_ADD);
		courseMenu.add(MenuActions.COURSE_MODIFY);
		courseMenu.addSeparator();
		courseMenu.add(MenuActions.EXIT);
		
		JMenu professorMenu = new JMenu("教授信息维护");      // 教授信息维护
		professorMenu.add(MenuActions.PROFESSOR_ADD); 
		professorMenu.add(MenuActions.PROFESSOR_MODIFY); 

		JMenu sysManageMenu = new JMenu("系统维护");        // 系统维护
		sysManageMenu.add(MenuActions.CHANGE_SKIN);
		sysManageMenu.add(MenuActions.SYS_OPEN);
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);

		menuBar.add(courseMenu);  // 添加课程数据维护菜单到菜单栏
		menuBar.add(studentMenu);   // 添加学生信息维护菜单到菜单栏
		menuBar.add(professorMenu);  // 添加教授信息维护菜单到菜单栏
		menuBar.add(sysManageMenu);    // 添加系统维护菜单到菜单栏
		return menuBar;	
	}
	/**
	 * 创建工具栏
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // 创建工具栏的方法
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JButton CourseAddButton=new JButton(MenuActions.COURSE_ADD);
		ImageIcon icon=LoadImage.add("addcourse1.png");   //添加菜单栏图标	
		CourseAddButton.setIcon(icon);
		CourseAddButton.setHideActionText(true);
		toolBar.add(CourseAddButton);
		
		//在工具栏中添加课程修改与删除图标
		JButton courseModiAndDelButton=new JButton(MenuActions.COURSE_MODIFY);
		ImageIcon coursemodiicon=LoadImage.add("modicourse1.png");//创建图标方法
		courseModiAndDelButton.setIcon(coursemodiicon);
		courseModiAndDelButton.setHideActionText(true);
		toolBar.add(courseModiAndDelButton);
		
	
		JButton studentAddButton=new JButton(MenuActions.STUDENT_ADD);
		ImageIcon studentAddicon=LoadImage.add("addstudent1.png");//创建图标方法
		studentAddButton.setIcon(studentAddicon);
		studentAddButton.setHideActionText(true);
		toolBar.add(studentAddButton);
		
		
		JButton professorAddButton=new JButton(MenuActions.PROFESSOR_ADD);
		ImageIcon professorAddicon=LoadImage.add("addprofessor1.png");//创建图标方法
		professorAddButton.setIcon(professorAddicon);
		professorAddButton.setHideActionText(true);
		toolBar.add(professorAddButton);
		
		
		JButton settingSysButton=new JButton(MenuActions.MODIFY_PASSWORD);
		ImageIcon settingicon=LoadImage.add("setting1.png");//创建图标方法
		settingSysButton.setIcon(settingicon);
		settingSysButton.setHideActionText(true);
		toolBar.add(settingSysButton);
		
		
		JButton changeSkinButton=new JButton(MenuActions.CHANGE_SKIN);
		ImageIcon changeSkinicon=LoadImage.add("changeskin.png");//创建图标方法
		changeSkinButton.setIcon(changeSkinicon);
		changeSkinButton.setHideActionText(true);
		toolBar.add(changeSkinButton);

		
		JButton helpingButton=new JButton(MenuActions.HELP);
		ImageIcon helpingicon=LoadImage.add("help1.png");//创建图标方法
		helpingButton.setIcon(helpingicon);
		helpingButton.setHideActionText(true);
		toolBar.add(helpingButton);
		
		
		JButton quit1Button=new JButton(MenuActions.EXIT);
		ImageIcon quitSysicon=LoadImage.add("quit1.png");//创建图标方法
		quit1Button.setIcon(quitSysicon);
		quit1Button.setHideActionText(true);
		toolBar.add(quit1Button);
		return toolBar;
	}
}
