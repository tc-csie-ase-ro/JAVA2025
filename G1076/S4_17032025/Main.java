package eu.ase.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		
		System.out.println(intList.size());
		
		for (int i = 0; i < 10; i++) {
			intList.add((i + 1) * 10);
		}
		
		System.out.println(intList.size());

		System.out.println("------------------------");
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		System.out.println("------------------------");

		for (Integer i : intList) {
			System.out.println(i);
		}
		
		System.out.println("------------------------");
		
		for(Iterator<Integer> it = intList.iterator(); it.hasNext();) {
			Integer element = it.next();
			System.out.println(element);
		}
		
		System.out.println("------------------------");

		
		intList.add(4, 55);
		intList.set(4, 49);
		
		intList.remove(4);
		
		intList.clear();
		
		System.out.println(intList.size());
		
		System.out.println("------------------------");
		
		List<Integer> intList2 = new ArrayList<Integer>();
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			intList2.add(random.nextInt(0, 100) );
		}

		for (Integer i : intList2) {
			System.out.println(i);
		}
		
		System.out.println("------------------------");

		intList2.sort(Comparator.naturalOrder());
		
		for (Integer i : intList2) {
			System.out.println(i);
		}
		
		System.out.println("------------------------");

		intList2.sort(Comparator.reverseOrder());
		
		for (Integer i : intList2) {
			System.out.println(i);
		}
		
		System.out.println(intList2.toString());
		
		System.out.println("------------------------");

		Movie movie1 = new Movie(2021, "Dune", 8.0f);
		Movie movie2 = new Movie(2024, "Dune Part Two", 8.9f);
		Movie movie3 = new Movie(2023, "Wonka", 7.1f);
		Movie movie4 = new Movie(2023, "Barbie", 10f);

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
		
		System.out.println("------------------------");
		
		Object[] movieArray = movies.toArray();
		
		for (Object movie : movieArray) {
			System.out.println(movie.toString());
		}
		
		//movies.sort(Comparator.reverseOrder());
		
		System.out.println("------------------------");
		
		for (Object movie : movies) {
			System.out.println(movie.toString());
		}
		
		//Collections.sort(movies);
		
		System.out.println("------------------------");

		movies.sort(new YearComparator());
		
		for (Object movie : movies) {
			System.out.println(movie.toString());
		}
		
		System.out.println("------------------------");

		movies.sort(new NameComparator().reversed());
		
		for (Object movie : movies) {
			System.out.println(movie.toString());
		}
		
		System.out.println("------------------------");

		movies.sort(new RatingComparator().reversed());
		
		for (Object movie : movies) {
			System.out.println(movie.toString());
		}
		
		System.out.println("------------------------");

		
		Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
		Map<String, Movie> movieTreeMap = new TreeMap<String, Movie>();
		Map<Integer, Movie> movieLinkedHashMap = new LinkedHashMap<Integer, Movie>();
	
	
		movieMap.put(1, movie1);
		movieMap.put(6, movie2);
		movieMap.put(8, movie3);
		movieMap.put(5, movie4);
		
		for (Integer key : movieMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println(movieMap.get(key).toString());
		}
		
		Set<Integer> keySet = movieMap.keySet();
		for (Integer key: keySet) {
			System.out.println(key);
		}
		
		System.out.println("------------------------");
		
		movieTreeMap.put("Movie1", movie1);
		movieTreeMap.put("Movie2", movie2);
		movieTreeMap.put("Movie3", movie3);
		movieTreeMap.put("Movie4", movie4);
		
		for (String key : movieTreeMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println(movieTreeMap.get(key).toString());
		}
		
		movieTreeMap.put("Movie3", movie4);
		
		for (String key : movieTreeMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println(movieTreeMap.get(key).toString());
		}
		
		movieTreeMap.put("Movie5", new Movie(2001, "aaaa", 9.0f));
		
		for (String key : movieTreeMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println(movieTreeMap.get(key).toString());
		}
	}

}
