package eu.ase.lab4;

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		if (movie1.getYear() == movie2.getYear()) {
			return 0;
		}
		if (movie1.getYear() > movie2.getYear()) {
			return 1;
		} else {
			return -1;
		}
	}

}
