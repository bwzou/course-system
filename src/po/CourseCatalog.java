package po;

public class CourseCatalog {
	private int cid;
	private String cname;
	private Float credit;
	private int credit_hours;
	private String tname=null;
	private String departments;
	private String teach_time;
	private String classroom;
	private int bill;
	private int cancel;
	
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
	public void setCredit(float f) {
		this.credit = f;
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
	public String getTeach_time() {
		return teach_time;
	}
	public void setTeach_time(String i) {
		this.teach_time = i;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public int getCancel() {
		return cancel;
	}
	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
	
}
