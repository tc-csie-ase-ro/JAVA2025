package eu.ase.lab6;

import java.io.Serializable;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 559755855128493173L;
	private int yearOfPublishing;
	private String title;
	private Author author;

	public Book(int yearOfPublishing, String title, Author author) {
		super();
		this.yearOfPublishing = yearOfPublishing;
		this.title = title;
		this.author = author;
	}
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}
	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return String.format("%s by %s from %d", this.getTitle(), this.getAuthor().getName(), this.getYearOfPublishing());
	}
	
//	public void saveToFile(FileOutputStream fos) {
//		
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
//		DataOutputStream dos = new DataOutputStream(bos);
//		
//		try {
//			dos.writeInt(this.getYearOfPublishing());
//			dos.writeUTF(this.getTitle());
//			dos.writeUTF(this.getAuthor());
//			dos.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public Book readFromFile(FileInputStream fis) {
//		
//		BufferedInputStream bis = new BufferedInputStream(fis);
//		DataInputStream dis = new DataInputStream(bis);
//		
//
//		try {
//			return new Book(dis.readInt(), dis.readUTF(), dis.readUTF());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return new Book();
//		} finally {
//			try {
//				dis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}		
//	}
}
