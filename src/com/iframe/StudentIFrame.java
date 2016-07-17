package com.iframe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.action.MenuActions;
import com.global.User;
import com.ipanel.BillSemesterPanel;
import com.ipanel.ChooseCoursePanel;
import com.ipanel.SelectCoursePanel;
import com.ipanel.ViewGradePanel;
import com.util.LoadImage;

public class StudentIFrame extends JFrame{
	class CardLayoutAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//用户单击b0按钮时执行的语句
			if(arg0.getSource()==query_course){
				//通过show()方法中的卡片名称，显示容器中的组件。
				card.show(cardPanel,cardName[0]);     
			}
			else if(arg0.getSource()==choose_course){
				card.show(cardPanel,cardName[1]);     
			}

			else if(arg0.getSource()==view_grade){
				card.show(cardPanel,cardName[2]);     
			}
			else if(arg0.getSource()==pay_bill){
				card.show(cardPanel,cardName[3]);     
			}
		}
	}

	class ChangeSkinAction extends AbstractAction {     // 退出系统动作(继承最初的抽象类)
		public ChangeSkinAction() {
			super("换肤", null);
		}
		public void actionPerformed(final ActionEvent e) {
			new ChangeSkinIFrame();
		}
	} 
	
	class ExitAction extends AbstractAction {     // 退出系统动作(继承最初的抽象类)
		public ExitAction() {
			super("退出系统", null);
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	} 
	
	JButton query_course,choose_course,view_grade,pay_bill;
	String cardName[]={"0","1","2","3"};
	final JPanel titlePanel;
	final JPanel cardPanel;
	final JPanel controlpaPanel;	
	final CardLayout card;
	
	

	public StudentIFrame() {
		// TODO Auto-generated constructor stub
		super();

		final BorderLayout borderLayout = new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		setTitle("Welcome to Course Registration System Of Wylie ");
		setSize(800, 600);
		setBounds(300, 100, 800, 600);
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		final JLabel label_1 = new JLabel(); 
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText("身份："+User.actor);
		titlePanel.add(label_1,borderLayout.WEST);
		
		final JLabel label_2 = new JLabel(); 
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setText("用户："+User.username);
		titlePanel.add(label_2,borderLayout.CENTER);
		
		final JButton changeskinButton = new JButton(new ChangeSkinAction());    //直接注册事件
		ImageIcon changeskinicon=LoadImage.add("changeskin.png");
		changeskinButton.setIcon(changeskinicon);
		changeskinButton.setHideActionText(true);    //让控件上的文字不显示
		
		final JButton exitButton = new JButton(new ExitAction());    //直接注册事件
		ImageIcon Exiticon=LoadImage.add("quit1.png");
		exitButton.setIcon(Exiticon);
		exitButton.setHideActionText(true);    
		final JPanel panel0 = new JPanel();
		panel0.setLayout(new FlowLayout());
		panel0.add(changeskinButton);
		panel0.add(exitButton);
		
		titlePanel.add(panel0,borderLayout.EAST);
		getContentPane().add(titlePanel,BorderLayout.NORTH);
		
		
		cardPanel=new JPanel();
		controlpaPanel=new JPanel();	
		card=new CardLayout();
		
		//设置cardPanel面板对象为卡片布局
		cardPanel.setLayout(card);    
		
		//循环，在cardPanel面板对象中添加4个按钮
		//因为cardPanel面板对象为卡片布局，因此初始时显示最先添加的组件
		for (int i = 0; i< 4; i++) {
			//面板中添加的每个按钮对应设置一个卡片名
			if(i==0){
				cardPanel.add(cardName[i],new SelectCoursePanel());
			}else if(i==1){
				cardPanel.add(cardName[i],new ChooseCoursePanel());
			}else if(i==2){
				cardPanel.add(cardName[i],new ViewGradePanel());
			}else{
				cardPanel.add(cardName[i],new BillSemesterPanel());
			}
		}
		getContentPane().add(cardPanel,BorderLayout.CENTER);
		
		
		//实例化按钮对象
		query_course=new JButton();
        final JPanel pane_b0 = new JPanel();
        ImageIcon query_courseDelicon=LoadImage.add("select_course.png");   //创建图标方法
        query_course.setIcon(query_courseDelicon);
        pane_b0.add(query_course);
        
        choose_course=new JButton();
        final JPanel pane_b1 = new JPanel();
        ImageIcon choose_courserDelicon=LoadImage.add("choose_course.png");   
        choose_course.setIcon(choose_courserDelicon);
        pane_b1.add(choose_course);
        
        view_grade=new JButton();
        final JPanel pane_b2 = new JPanel();
        ImageIcon view_gradeDelicon=LoadImage.add("view_grade.png");   
        view_grade.setIcon(view_gradeDelicon);
        pane_b2.add(view_grade);
        
        pay_bill=new JButton();
        final JPanel pane_b3 = new JPanel();
        ImageIcon pay_billDelicon=LoadImage.add("pay_bill.png");   
        pay_bill.setIcon(pay_billDelicon);
        pane_b3.add(pay_bill);
        
        query_course.addActionListener(new CardLayoutAction());
        choose_course.addActionListener(new CardLayoutAction());
        view_grade.addActionListener(new CardLayoutAction());
        pay_bill.addActionListener(new CardLayoutAction());

        controlpaPanel.setLayout(new GridLayout(4,1));
        controlpaPanel.add(pane_b0);
        controlpaPanel.add(pane_b1);
        controlpaPanel.add(pane_b2);
        controlpaPanel.add(pane_b3);        
        getContentPane().add(controlpaPanel,BorderLayout.WEST);    
        
	}


}
