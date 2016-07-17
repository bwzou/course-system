package com.action;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

import com.iframe.AdminIFrame;
import com.iframe.inframe.AddStudentFrame;
import com.iframe.inframe.ChangePwdFrame;
import com.iframe.inframe.ChangeSkinFrame;
import com.iframe.inframe.CourseAddFrame;
import com.iframe.inframe.CourseModiFrame;
import com.iframe.inframe.ModiStudentFrame;
import com.iframe.inframe.SysOpenTimeFrame;

public class MenuActions {
	private static Map<String, JInternalFrame> frames;  // 子窗体集合
	public static CourseAddAction COURSE_ADD;  // 课程信息添加窗体动作
	public static CourseModiAction COURSE_MODIFY;  // 课程信息修改窗体动作
	public static StudentAddAction STUDENT_ADD;  // 学生信息添加窗体动作
	public static StudentModiAction STUDENT_MODIFY;  // 学生信息修改窗体动作
	public static ProfessorAddAction PROFESSOR_ADD;  // 教师信息添加窗体动作
	public static ProfessorModiAction PROFESSOR_MODIFY;  // 教师信息修改窗体动作
	public static SysManageAction MODIFY_PASSWORD;   // 修改密码
	public static SysOpenTimeAction SYS_OPEN;
	public  static changeSkinAction CHANGE_SKIN;
	public static HelpingAction HELP;
	public static ExitAction EXIT; // 系统退出动作
	
	
	static {
		frames = new HashMap<String, JInternalFrame>();
		COURSE_ADD = new CourseAddAction();
		COURSE_MODIFY = new CourseModiAction();
		STUDENT_ADD = new StudentAddAction();
		STUDENT_MODIFY = new StudentModiAction();
		PROFESSOR_ADD = new ProfessorAddAction();
		PROFESSOR_MODIFY = new ProfessorModiAction();
		MODIFY_PASSWORD = new SysManageAction();
		SYS_OPEN = new SysOpenTimeAction();
		CHANGE_SKIN = new changeSkinAction();
		HELP = new HelpingAction();
		EXIT = new ExitAction();
	}
	
	
	private static class CourseModiAction extends AbstractAction {		// 课程修改与删除
		CourseModiAction() {
			super("课程信息修改", null);
			putValue(Action.LONG_DESCRIPTION, "课程信息修改和删除");
			putValue(Action.SHORT_DESCRIPTION, "课程信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("课程信息修改")||frames.get("课程信息修改").isClosed()) {
				CourseModiFrame iframe = new CourseModiFrame();
				frames.put("课程信息修改", iframe);
				AdminIFrame.addIFame(frames.get("课程信息修改"));
			}
		}
	}
	
	private static class CourseAddAction extends AbstractAction {		// 课程添加
		CourseAddAction() {
			super("课程信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "为选课系统添加新的课程信息");
			putValue(Action.SHORT_DESCRIPTION, "课程信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("课程信息添加")||frames.get("课程信息添加").isClosed()) {
				CourseAddFrame iframe = new CourseAddFrame();
				frames.put("课程信息添加", iframe);
				AdminIFrame.addIFame(frames.get("课程信息添加"));
			}
		}
	}
	
	private static class StudentAddAction extends AbstractAction {		// 学生添加
		StudentAddAction() {
			super("学生信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加学生信息到系统");
			putValue(Action.SHORT_DESCRIPTION, "添加学生");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("学生信息添加")||frames.get("学生信息添加").isClosed()) {
				AddStudentFrame iframe = new AddStudentFrame();
				frames.put("学生信息添加", iframe);
				AdminIFrame.addIFame(frames.get("学生信息添加"));
			}
		}
	}
	private static class StudentModiAction extends AbstractAction {		// 学生信息修改
		StudentModiAction() {
			super("学生信息修改", null);
			putValue(Action.LONG_DESCRIPTION, "学生信息修改和删除");
			putValue(Action.SHORT_DESCRIPTION, "学生信息修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("学生信息修改")||frames.get("学生信息修改").isClosed()) {
				ModiStudentFrame iframe = new ModiStudentFrame();
				frames.put("学生信息修改", iframe);
				AdminIFrame.addIFame(frames.get("学生信息修改"));
			}
		}
	}
	private static class ProfessorAddAction extends AbstractAction {		// 教师添加
		ProfessorAddAction() {
			super("添加教师", null);
			putValue(Action.LONG_DESCRIPTION, "添加教师信息到系统");
			putValue(Action.SHORT_DESCRIPTION, "添加教师");
		}
		public void actionPerformed(ActionEvent e) {
//			if (!frames.containsKey("课程信息添加")||frames.get("课程信息添加").isClosed()) {
//				CourseModiIFrame iframe = new CourseModiIFrame();
//				frames.put("图书信息添加", iframe);
//				AdminIFrame.addIFame(frames.get("图书信息添加"));
//			}
		}
	}
	private static class ProfessorModiAction extends AbstractAction {		// 教师信息修改
		ProfessorModiAction() {
			super("教师信息修改", null);
			putValue(Action.LONG_DESCRIPTION, "教师信息修改和删除");
			putValue(Action.SHORT_DESCRIPTION, "教师信息修改");
		}
		public void actionPerformed(ActionEvent e) {
//			if (!frames.containsKey("课程信息添加")||frames.get("课程信息添加").isClosed()) {
//				CourseModiIFrame iframe = new CourseModiIFrame();
//				frames.put("图书信息添加", iframe);
//				AdminIFrame.addIFame(frames.get("图书信息添加"));
//			}
		}
	}
	private static class SysManageAction extends AbstractAction {		// 修改密码
		SysManageAction() {
			super("修改密码", null);
			putValue(Action.LONG_DESCRIPTION, "修改登陆密码");
			putValue(Action.SHORT_DESCRIPTION, "修改密码");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("修改密码")||frames.get("修改密码").isClosed()) {
				ChangePwdFrame iframe = new ChangePwdFrame();
				frames.put("修改密码", iframe);
				AdminIFrame.addIFame(frames.get("修改密码"));
			}
		}
	}
	private static class SysOpenTimeAction extends AbstractAction {		// 修改密码
		SysOpenTimeAction() {
			super("开放时间", null);
			putValue(Action.LONG_DESCRIPTION, "选课系统开放时间");
			putValue(Action.SHORT_DESCRIPTION, "开放时间");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("开放时间")||frames.get("开放时间").isClosed()) {
				SysOpenTimeFrame iframe = new SysOpenTimeFrame();
				frames.put("开放时间", iframe);
				AdminIFrame.addIFame(frames.get("开放时间"));
			}
		}
	}
	private static class changeSkinAction extends AbstractAction {		// 修改密码
		changeSkinAction() {
			super("换肤", null);
			putValue(Action.LONG_DESCRIPTION, "改变界面风格");
			putValue(Action.SHORT_DESCRIPTION, "换肤");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("换肤")||frames.get("换肤").isClosed()) {
				ChangeSkinFrame iframe = new ChangeSkinFrame();
				frames.put("换肤", iframe);
				AdminIFrame.addIFame(frames.get("换肤"));
			}
		}
	}
	private static class HelpingAction extends AbstractAction {		// 修改密码
		HelpingAction() {
			super("帮助", null);
			putValue(Action.LONG_DESCRIPTION, "获取帮助信息");
			putValue(Action.SHORT_DESCRIPTION, "帮助");
		}
		public void actionPerformed(ActionEvent e) {
//			if (!frames.containsKey("课程信息添加")||frames.get("课程信息添加").isClosed()) {
//				CourseModiIFrame iframe = new CourseModiIFrame();
//				frames.put("图书信息添加", iframe);
//				AdminIFrame.addIFame(frames.get("图书信息添加"));
//			}
		}
	}
	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出图书馆管理系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}
}
