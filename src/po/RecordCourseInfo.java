package po;

public class RecordCourseInfo {
	private int cid;
	private String cname;
	private Float credit;
	private int record_state;
	private int stu_count;
	
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
	public int getRecord_state() {
		return record_state;
	}
	public void setRecord_state(int record_state) {
		this.record_state = record_state;
	}
	public int getStu_count() {
		return stu_count;
	}
	public void setStu_count(int stu_count) {
		this.stu_count = stu_count;
	}
}
