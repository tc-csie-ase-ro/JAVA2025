package eu.ase.lab4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //int a = 5;
        //Integer intObj = Integer.valueOf(a);
        //Integer intObj = a;
        //int b = intObj;

        List<Integer> intList = new ArrayList<>();
        //List<Float> floatList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            intList.add(i + 1);
        }

        intList.addFirst(-1);
        intList.add(3, 100);
        intList.set(4, 200);

        System.out.println("List size: " + intList.size());
        for (int i: intList) {
            System.out.println("Element with index " + intList.indexOf(i) + " has the value of " + i);
        }

        System.out.println();
        System.out.println();

        Random rand = new Random();
        List<Integer> randList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            randList.add(rand.nextInt() % 100);
        }

        System.out.println("Unsorted: ");
        for (int i: randList) {
            System.out.println(i);
        }

        //randList.sort(Comparator.naturalOrder());
        randList.sort(Comparator.reverseOrder());

        System.out.println("Sorted: ");
        for (int i: randList) {
            System.out.println(i);
        }


        List<Movie> movieLibrary = new ArrayList<>();

        movieLibrary.add(new Movie(2000, "Gladiator", 9.4f));
        movieLibrary.add(new Movie(2018, "green Book", 8.7f));
        movieLibrary.add(new Movie(2024, "Wicked", 7.5f));


        movieLibrary.sort(new YearComparator().reversed());

        for (Movie m: movieLibrary) {
            System.out.println(m);
        }

        Map<Integer, Movie> movieMap = new HashMap<>();
        movieMap.put(movieLibrary.get(0).hashCode(), movieLibrary.get(0));
        movieMap.put(movieLibrary.get(1).hashCode(), movieLibrary.get(1));
        movieMap.put(movieLibrary.get(2).hashCode(), movieLibrary.get(2));

        movieMap.put(1298969374, new Movie(1000, "aaa", 10f));

        Set<Integer> set = movieMap.keySet();
        Iterator<Integer> it = set.iterator();
        for(;it.hasNext();) {
            Integer key = it.next();
            Movie value = movieMap.get(key);
            System.out.println("Key: " + key + "; Value: " + value);
        }

    }

}
