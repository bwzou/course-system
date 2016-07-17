package com.util;
import java.net.URL;

import javax.swing.ImageIcon;

import com.iframe.UserLoginIFrame;

public class LoadImage {
	public static ImageIcon add(String ImageName){
		URL IconUrl = UserLoginIFrame.class.getResource("/"+ImageName);   //获取资源路径(图片需要在bin文件夹下)，使用相对路径
		ImageIcon icon=new ImageIcon(IconUrl);
		return icon;
	}
}
