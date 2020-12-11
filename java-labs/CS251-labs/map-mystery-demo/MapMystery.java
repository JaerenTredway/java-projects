import java.util.*;

public class MapMystery {
	
	
	public static void main( String[] args ) {

		// Note: silly to hard-code this stuff in, when we know how to read from a file.
		// Exercise: replace this with code that reads words from a file, then uses a loop to build up the biGrams.
		String[ ] corpusWords = {"time", "flies", "like", "an", "arrow", "fruit", "flies", "like", "a", "banana"};

		String[ ][ ] biGrams = { {"time", "flies"}, {"flies", "like"}, {"like", "an"}, {"an", "arrpw"}, {"arrow","fruit"},
								 {"fruit","flies"}, {"flies", "like"}, {"like", "a"}, {"a", "banana"}};


		HashMap<String[ ], List<String[ ]>> m = new HashMap<>();

		for (int i=0; i<biGrams.length-1; i++) {
			String[ ] key = biGrams[i];
			String[ ] target = biGrams[i+1];
			List<String[ ]> value = m.get(key);
			if (value == null) {
				value = new ArrayList<>();
				m.put(key, value);
			}
			value.add(target);
		}
		
		System.out.println(corpusWords);
		System.out.println(biGrams);
		System.out.println(m);
		
	}

}
	

