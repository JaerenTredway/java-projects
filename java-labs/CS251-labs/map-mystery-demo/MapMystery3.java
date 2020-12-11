import java.util.*;

public class MapMystery3 {
	
	private static class BiGram {
		String[ ] words;
		public BiGram(String[ ] words) {
			assert words.length==2;
			this.words = words;
		}
		public String toString( ) {
			return "B(" + words[0] + "," + words[1] + ")";
		}
	}
	
	private static class BiGramList {
		List<BiGram> biGrams = new ArrayList<BiGram>();
		public void add(BiGram b) {
			biGrams.add(b);
		}
		public String toString( ) {
			String rv = "L[";
			for (BiGram b : biGrams) {
				rv += b.toString() + ",";
			}
			rv += "]";
			return rv;
		}
		public BiGram get(int i) {
			return biGrams.get(i);
		}
		public int size( ) {
			return biGrams.size();
		}
	}
	
	public static void main( String[] args ) {

		// Note: silly to hard-code this stuff in, when we know how to read from a file.
		// Exercise: replace this with code that reads words from a file, then uses a loop to build up the biGrams.
		String[ ] corpusWords = {"time", "flies", "like", "an", "arrow", "fruit", "flies", "like", "a", "banana"};

		String[ ][ ] biGramsRaw = { {"time", "flies"}, {"flies", "like"}, {"like", "an"}, {"an", "arrpw"}, {"arrow","fruit"},
								 {"fruit","flies"}, {"flies", "like"}, {"like", "a"}, {"a", "banana"}};
		
//		BiGram[ ] biGrams = new BiGram[ biGramsRaw.length ];
//		for (int i=0; i<biGramsRaw.length; i++) {
//			biGrams[i] = new BiGram( biGramsRaw[i] );
//		}
		BiGramList biGrams = new BiGramList( );
		for (int i=0; i<biGramsRaw.length; i++) {
			biGrams.add(new BiGram( biGramsRaw[i] ));
		}

		HashMap< BiGram , BiGramList > m = new HashMap<>();

		for (int i=0; i<biGrams.size()-1; i++) {
			BiGram key = biGrams.get(i);
			BiGram target = biGrams.get(i+1);
			BiGramList value = m.get(key);
			if (value == null) {
				value = new BiGramList();
				m.put(key, value);
			}
			value.add(target);
		}
		
		System.out.println(corpusWords);
		System.out.println(biGrams);
		System.out.println(m);
		
	}

}
	

