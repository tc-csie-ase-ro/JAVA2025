package eu.ase.lab2;

import java.util.Arrays;

public class Student implements Cloneable {
	
	private int studentId;
	private String name;
	private float[] grades;

	public Student(int studentId, String name, float[] grades) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.grades = grades;
	}

	public Student() {
		this.studentId = 0;
		this.name = "";
		this.grades = null;
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

	public float[] getGrades() {
		return grades;
	}

	public void setGrades(float[] grades) {
		this.grades = grades;
	}
	
	public float avgGrade() {
		float avg = 0;
		for (float grade : this.getGrades()) {
			avg += grade;
		}
		
		avg = avg / this.getGrades().length;
		
		return avg;
	}

	@Override
	public String toString() {
		
		String student = "Student " + this.getStudentId()
			+ "\n\tName: " + this.getName()
			+ "\n\tGrades: " + Arrays.toString(this.getGrades());
				
		return student;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Student newStudent = new Student();
		newStudent.setStudentId(this.getStudentId());
		newStudent.setName(this.getName());
		
		float[] newStudentGrades = new float[this.getGrades().length];
		System.arraycopy(this.getGrades(), 0, newStudentGrades, 0, this.getGrades().length);
		newStudent.setGrades(newStudentGrades);
		
		return newStudent;
	}
	
	
	
}
