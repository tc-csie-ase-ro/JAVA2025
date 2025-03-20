package eu.deic.ase.c04_jcf;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listInt.add(i + 1);
        }

        listInt.add(7, 100);

        for (Integer i: listInt) {
            System.out.println("Element at index " + listInt.indexOf(i) + " is " + i);
        }

        List<Integer> listInt2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listInt2.add(i + 101);
        }

        listInt.addAll(listInt2);


        listInt.remove(Integer.valueOf(110));
        listInt.remove(12);

        System.out.println();
        for (Integer i: listInt) {
            System.out.println("Element at index " + listInt.indexOf(i) + " is " + i);
        }


        Random rand = new Random();

        List<Integer> listRand = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listRand.add(rand.nextInt() % 100);
        }

        for (Integer i: listRand) {
            System.out.println(i);
        }

        listRand.sort(Comparator.reverseOrder());

        System.out.println();
        for (Integer i: listRand) {
            System.out.println(i);
        }


        List<Movie> movieLibrary = new ArrayList<>();

        movieLibrary.add(new Movie(2025, "Anora", 7.6f));
        movieLibrary.add(new Movie(2024, "Oppenheimer", 8.2f));
        movieLibrary.add(new Movie(2023, "Everything Everywhere All at Once", 9f));

        for (Movie m: movieLibrary) {
            System.out.println(m);
        }

        movieLibrary.sort(new TitleComparator());

        System.out.println();
        for (Movie m: movieLibrary) {
            System.out.println(m);
        }

        Cinema c1 = new Cinema(1, "c1");
        Cinema c2 = new Cinema(2, "c2");

        TreeMap<Movie, Cinema> treeMapMovie =  new TreeMap<>();
        treeMapMovie.put(movieLibrary.get(0), c1);
        treeMapMovie.put(movieLibrary.get(1), c2);
        treeMapMovie.put(movieLibrary.get(2), c1);

        Set<Movie> keySet = treeMapMovie.keySet();
        Iterator<Movie> itm = keySet.iterator();

        for(;itm.hasNext();){
            Movie m = itm.next();
            System.out.println(m + ": " + treeMapMovie.get(m));
        }


    }
}
package eu.deic.ase.c04_jcf;

import java.util.Objects;

public class Movie implements Comparable<Movie> {

    private int year;
    private String title;
    private float rating;

    public Movie(int year, String title, float rating) {
        this.year = year;
        this.title = title;
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%s from %d has %5.2f", this.title, this.year, this.rating);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Float.compare(rating, movie.rating) == 0 && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, rating);
    }


    @Override
    public int compareTo(Movie o) {
        if (this.rating == o.rating) {
            return 0;
        }
        if (this.rating > o.rating) {
            return 1;
        } else {
            return -1;
        }
    }
}
package eu.deic.ase.c04_jcf;

import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
package eu.deic.ase.c04_jcf;

public class Cinema {

    private int id;
    private String name;

    public Cinema(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + ". Cinema " + name;
    }
}
