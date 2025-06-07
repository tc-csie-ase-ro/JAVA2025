package eu.ase.net.tcp.javaobj;

import java.io.Serializable;

public class Book implements Serializable {
    private int publishingYear;
    private String title;
    private String author;

    public Book(int publishingYear, String title, String author) {
        this.publishingYear = publishingYear;
        this.title = title;
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publishingYear=" + publishingYear +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
