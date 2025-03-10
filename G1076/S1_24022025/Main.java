package eu.ase.lab1;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student student1 = new Student(1, "John", new Subject("Java", (float)9.5));
		Student student2 = new Student(2, "Mark", new Subject("Data Structures", (float)8.7));
		
		System.out.println("Student " + student1.getStudentId() 
		+ "\n\tName: " + student1.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student1.getSubject().getName()
		+ "\n\t\tGrade: " + student1.getSubject().getGrade());
		
		System.out.println("Student " + student2.getStudentId() 
		+ "\n\tName: " + student2.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student2.getSubject().getName()
		+ "\n\t\tGrade: " + student2.getSubject().getGrade());
		
		System.out.println("-------------------------------------------------------");
		
		Student student3;
		
		student3 = (Student) student1.clone();
		
		System.out.println("Student " + student1.getStudentId() 
		+ "\n\tName: " + student1.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student1.getSubject().getName()
		+ "\n\t\tGrade: " + student1.getSubject().getGrade());
		
		System.out.println("Student " + student3.getStudentId() 
		+ "\n\tName: " + student3.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student3.getSubject().getName()
		+ "\n\t\tGrade: " + student3.getSubject().getGrade());
		
		System.out.println("-------------------------------------------------------");

		student3.setStudentId(3);
		student3.setName("Luke");
		student3.getSubject().setName("C#");
		student3.getSubject().setGrade((float)9.9);
		
		System.out.println("Student " + student1.getStudentId() 
		+ "\n\tName: " + student1.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student1.getSubject().getName()
		+ "\n\t\tGrade: " + student1.getSubject().getGrade());
		
		System.out.println("Student " + student3.getStudentId() 
		+ "\n\tName: " + student3.getName() 
		+ "\n\tSubject:"
		+ "\n\t\tName: " + student3.getSubject().getName()
		+ "\n\t\tGrade: " + student3.getSubject().getGrade());
		
		System.out.println("-------------------------------------------------------");
	}

}
