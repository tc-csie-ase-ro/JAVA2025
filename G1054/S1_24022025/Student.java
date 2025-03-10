package eu.ase.lab1;

public class Student implements Cloneable {
	
	private int studentId;
	private String name;
	private Subject subject;
	
	public Student() {
		this.studentId = 0;
		this.name = "";
		this.subject = null;
	}
	
	public Student(int studentId, String name, Subject subject) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.subject = subject;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Student newStudent = new Student();
		newStudent.setStudentId(this.getStudentId());
		newStudent.setName(this.getName());
		newStudent.setSubject(new Subject(this.subject.getName(), this.subject.getGrade()));
		
		return newStudent;
	}
	
}
