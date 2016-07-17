package com.iframe.inframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.ChallengerDeepSkin;

import com.ipanel.ChangeSkinPanel;

public class ChangeSkinFrame extends JInternalFrame{
	class ConfirmAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			doDefaultCloseAction();
		}
		
	}
	
	class CancelAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						//默认
						SubstanceLookAndFeel.setSkin(new ChallengerDeepSkin());
						//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel");
					} catch (Exception e) {
						System.out.println("Substance Raven Graphite failed to initialize");
					}

				}
			}); 
			doDefaultCloseAction();
		}
		
	}
	private JButton button,button2;
	
	public ChangeSkinFrame(){
		super();
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("换肤");						         // 设置窗体标题－－－必须
		setBounds(100, 100, 200, 280);					// 设置窗体位置和大小－－－必须
		
		ChangeSkinPanel changeSkinPanel = new ChangeSkinPanel();
		getContentPane().add(changeSkinPanel,BorderLayout.CENTER);
		
		final JPanel jPanel= new JPanel();
		jPanel.setLayout(new GridLayout(0,2));
		button = new JButton("确认");
		button.addActionListener(new ConfirmAction());
		
		button2 = new JButton("取消");
		button2.addActionListener(new CancelAction());
		
		jPanel.add(button);
		jPanel.add(button2);
		getContentPane().add(jPanel,BorderLayout.SOUTH);
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
}
