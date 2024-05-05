package Ch02;
public class Student {
	private String studentID; //학번
	private String name;  //이름
	private String major;  //전공
	private String telNumber;  //전화번호
	private boolean sex;  //성별 True = 남, False = 여
	private int grade = 1;  //학년
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public boolean isSex() {
		return sex;
	}
	
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}	
}