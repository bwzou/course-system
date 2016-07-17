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

import com.global.User;
import com.iframe.StudentIFrame.ChangeSkinAction;
import com.ipanel.IndicateCoursePanel;
import com.ipanel.RecordGradePanel;
import com.util.LoadImage;

public class ProfessorIFrame extends JFrame{
	class CardLayoutAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//用户单击b0按钮时执行的语句
			if(arg0.getSource()==indicate_course){
				//通过show()方法中的卡片名称，显示容器中的组件。
				card.show(cardPanel,cardName[0]);     
			}
			else if(arg0.getSource()==record_grade){
				card.show(cardPanel,cardName[1]);     
			}

			else if(arg0.getSource()==person_infor){
				card.show(cardPanel,cardName[2]);     
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

	JButton indicate_course,record_grade,person_infor;
	String cardName[]={"0","1","2"};
	final JPanel titlePanel;
	final JPanel cardPanel;
	final JPanel controlpaPanel;	
	final CardLayout card;
//	private static JDesktopPane desktopPane = new JDesktopPane();
//	public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
//		desktopPane.add(iframe);
//	}

	public ProfessorIFrame(){
		// TODO Auto-generated constructor stub
		super();
//		getContentPane().add(desktopPane,BorderLayout.CENTER);
		
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
		exitButton.setHideActionText(true);    //让控件上的文字不显示
		
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

		//因为cardPanel面板对象为卡片布局，因此初始时显示最先添加的组件
		for (int i = 0; i< 3; i++) {
			//面板中添加的每个按钮对应设置一个卡片名
			if(i==0){
				cardPanel.add(cardName[i],new IndicateCoursePanel());
			}else if(i==1){
				cardPanel.add(cardName[i],new RecordGradePanel());
			}else if(i==2){
				cardPanel.add(cardName[i],new JButton("你好"));
			}
		}
		getContentPane().add(cardPanel,BorderLayout.CENTER);

		//实例化按钮对象
		indicate_course=new JButton();
		final JPanel pane_b0 = new JPanel();
		ImageIcon query_courseDelicon=LoadImage.add("indicate_course.png");   //创建图标方法
		indicate_course.setIcon(query_courseDelicon);
		pane_b0.add(indicate_course);

		record_grade=new JButton();
		final JPanel pane_b1 = new JPanel();
		ImageIcon choose_courserDelicon=LoadImage.add("record_grades.png");   
		record_grade.setIcon(choose_courserDelicon);
		pane_b1.add(record_grade);

		person_infor=new JButton();
		final JPanel pane_b2 = new JPanel();
		ImageIcon view_gradeDelicon=LoadImage.add("person_info.png");   
		person_infor.setIcon(view_gradeDelicon);
		pane_b2.add(person_infor);

		indicate_course.addActionListener(new CardLayoutAction());
		record_grade.addActionListener(new CardLayoutAction());
		person_infor.addActionListener(new CardLayoutAction());

		controlpaPanel.setLayout(new GridLayout(4,1));
		controlpaPanel.add(pane_b0);
		controlpaPanel.add(pane_b1);
		controlpaPanel.add(pane_b2);
		getContentPane().add(controlpaPanel,BorderLayout.WEST);   
	}
}
