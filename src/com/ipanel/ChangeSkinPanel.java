package com.ipanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.AutumnSkin;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;
import org.pushingpixels.substance.api.skin.BusinessBlueSteelSkin;
import org.pushingpixels.substance.api.skin.ChallengerDeepSkin;
import org.pushingpixels.substance.api.skin.EmeraldDuskSkin;
import org.pushingpixels.substance.api.skin.GraphiteGlassSkin;
import org.pushingpixels.substance.api.skin.ModerateSkin;
import org.pushingpixels.substance.api.skin.NebulaBrickWallSkin;
import org.pushingpixels.substance.api.skin.OfficeSilver2007Skin;

public class ChangeSkinPanel extends JPanel{
	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JRadioButton temp=(JRadioButton)arg0.getSource();
			if(temp.isSelected()){
				String mm=temp.getText().trim();
				if(mm=="默认"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								//默认
								SubstanceLookAndFeel.setSkin(new ChallengerDeepSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}

						}
					});   
				}else if(mm=="古典黑"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="古典蓝"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="浅蓝"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new ModerateSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="雅黄"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new NebulaBrickWallSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="浅灰"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new GraphiteGlassSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="深绿"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="古典银"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new OfficeSilver2007Skin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}else if(mm=="橙黄"){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SubstanceLookAndFeel.setSkin(new AutumnSkin());
							} catch (Exception e) {
								System.out.println("Substance Raven Graphite failed to initialize");
							}
						}
					});
				}
			}     
		}     
	}

	
	

	private ButtonGroup bg;
	private JRadioButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	

	public ChangeSkinPanel(){
		super();

		final JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(0,1));
		b1 = new JRadioButton("默认",false);
		b1.addActionListener(new RadioButtonListener());
		b2 = new JRadioButton("古典黑",false);
		b2.addActionListener(new RadioButtonListener());
		b3 = new JRadioButton("古典蓝",false);
		b3.addActionListener(new RadioButtonListener());
		b5 = new JRadioButton("浅蓝",false);
		b5.addActionListener(new RadioButtonListener());
		b4 = new JRadioButton("雅黄",false);
		b4.addActionListener(new RadioButtonListener());
		b6 = new JRadioButton("浅灰",false);
		b6.addActionListener(new RadioButtonListener());
		b7 = new JRadioButton("深绿",false);
		b7.addActionListener(new RadioButtonListener());
		b8 = new JRadioButton("古典银",false);
		b8.addActionListener(new RadioButtonListener());
		b9 = new JRadioButton("橙黄",false);
		b9.addActionListener(new RadioButtonListener());
		
		bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		bg.add(b5);
		bg.add(b6);
		bg.add(b7);
		bg.add(b8);
		bg.add(b9);
		panel_3.add(b1);
		panel_3.add(b2);
		panel_3.add(b3);
		panel_3.add(b4);
		panel_3.add(b5);
		panel_3.add(b6);
		panel_3.add(b7);
		panel_3.add(b8);
		panel_3.add(b9);
		this.add(panel_3,BorderLayout.CENTER);
		
		
	}

}
