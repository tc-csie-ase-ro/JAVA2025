package eu.ase.lab5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Integer a = new Integer(5); // Autoboxing
		int b = a.intValue(); // Unboxing
		
		Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
		
		Movie m1 = new Movie(2021, "Dune", 8.0f);
		Movie m2 = new Movie(2021, "Dune", 8.0f);

		Movie m3 = new Movie(2023, "Barbie", 10f);
		
		System.out.println(m1.equals(m2));
		
		System.out.println("M1 hash: " + m1.hashCode() + " M2 hash: " + m2.hashCode() + " M3 has: " + m3.hashCode());
		
		movieMap.put(m1.hashCode(), m1);
		movieMap.put(m2.hashCode(), m2);
		movieMap.put(m3.hashCode(), m3);

		System.out.println("Movie map");
		System.out.println("{");
		
//		Set<Integer> keySet = movieMap.keySet();
//		Iterator<Integer> it = keySet.iterator();
		
		for (Integer key : movieMap.keySet()) {
			System.out.println("\t" + key + ": " + movieMap.get(key));
		}
		System.out.println("}");

		
	}

}
