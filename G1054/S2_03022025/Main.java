package eu.ase.lab2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = new int[5];
		
		for (int element : arr1) {
			System.out.println(element);
		}
		
		System.out.println("-----------------------------------");
		
		double[] arr2 = new double[] {3.45, 6.77, 8.43};
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("-----------------------------------");
		
		int[][] matrix = new int[][] {{1, 2, 3},{4, 5, 6}};
		
		System.out.println("Matrix lenght: " + matrix.length);
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Matrix[" + i + "] length: " + matrix[i].length);
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}
		
		System.out.println("-----------------------------------");
		
		System.out.println(matrix[1][2]);
		matrix[1][2] = 5;
		System.out.println(matrix[1][2]);
		
		System.out.println("-----------------------------------");

		Student[] students = new Student[2];
		
		students[0] = new Student(1, "John", new float[] {7.6f, 8.9f});
		students[1] = new Student(2, "Mark", new float[] {9.6f, 5.9f});
		
		for (Student student : students) {
			System.out.println(student.toString());
			System.out.println("\tAverage: " + student.avgGrade());
		}
		
//		Student[] students2 = new Student[3];
//		
//		System.out.println("-----------------------------------");
//		
//		System.arraycopy(students, 0, students2, 0, students.length);
//		
//		students2[2] = new Student(3, "Luke", new float[] {5.6f, 8.9f});
//		
//		for (Student student : students2) {
//			System.out.println(student.toString());
//			System.out.println("\tAverage: " + student.avgGrade());
//		}
		
		System.out.println("-----------------------------------");
		
		students = Arrays.copyOf(students, 3);
		
		students[2] = new Student(3, "Luke", new float[] {5.6f, 8.9f});
		
		for (Student student : students) {
			System.out.println(student.toString());
			System.out.println("\tAverage: " + student.avgGrade());
		}
		
	}

}
