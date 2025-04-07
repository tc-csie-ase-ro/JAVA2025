package eu.ase.lab6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveToFileMain {

	public static void main(String[] args) {
		
		Author a1 = new Author(1821, "Fyodor Dostoevsky", "Russia");
		Author a2 = new Author(1883, "Franz Kafka", "Czechia");
		
		Book b1 = new Book(1866, "Crime and Punishment", a1);
		Book b2 = new Book(1879, "The Karamazov Brothers", a1);
		
		Book b3 = new Book(1925, "The Trial", a2);
		Book b4 = new Book(1926, "The Castle", a2);

		
		
		
		try {
			FileOutputStream fos = new FileOutputStream("books.bin");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			System.out.println("Writing objects to file...");
			oos.writeObject(b1);
			oos.writeObject(b2);
			oos.writeObject(a1);
			oos.close();
			boolean stmt = (b1.getAuthor() == b2.getAuthor()) && (b1.getAuthor() == a1);
			System.out.println(stmt);
			System.out.println("Objects are written");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
