package po;

public class AlreadyCourse {
	private int cid;
	private String cname;
	private Float credit;
	private int credit_hours;
	private String tname=null;
	private String departments;
	private Float grade;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Float getCredit() {
		return credit;
	}
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	public int getCredit_hours() {
		return credit_hours;
	}
	public void setCredit_hours(int credit_hours) {
		this.credit_hours = credit_hours;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public Float getGrade() {
		return grade;
	}
	public void setGrade(Float grade) {
		this.grade = grade;
	}
	
}
