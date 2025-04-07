package eu.ase.lab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RestoreFromFileMain {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("books.bin");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Book b1 = (Book) ois.readObject();
			System.out.println(b1);
			
			Book b2 = (Book) ois.readObject();
			System.out.println(b2);
			
			Author a1 = (Author) ois.readObject();
			System.out.println(a1);
			
			boolean stmt = (b1.getAuthor() == b2.getAuthor()) && (b1.getAuthor() == a1);
			System.out.println(stmt);
			
			ois.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
