import java.io.*;
import java.util.ArrayList;

public class FileDemo3 {

	public static void main(String[] args) throws Exception {
		System.out.println(args.length + " command line arguments:");
		for (String s : args) 
			System.out.println("  " + s);
		String filename = args[0];
		
		File f;
		FileReader fr;
		BufferedReader br = null;
		
		try {
			f = new File(filename);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			System.out.println("Couldn't open the file.");
			e.printStackTrace();
			throw new Exception("My weird exception object");
			// System.exit(1);  // or return
		}
		
		System.out.println("Text from " + filename + ":");
		int count = 0;
		String line;
		ArrayList<String> lines = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		
		try { 
			while ((line = br.readLine()) != null) {
				System.out.println(count + ": " + line);
				count++;
				lines.add(line);
				for (String word : line.split("[, :.'’]")) {   // matches a , or a space character
					// Rules of *regular expressions*. (method of defining what to match.)
					// Concatenation.  Means: consecutive regular expressions get matched consecutively.
					// Example: ", " matches a , followed by a space.
					// Union.  Like an "or" operator.
					// Union of characters: list them inside square brackets.  "[abcd]" is a regexp matching
					// a single character that is an a or b or c or d.
					// * operator: matches 0 or more of the preceding regexp.
					// + operator: matches 1 or more of preceding regexp.
					// various escape sequences, for instance if I want a [ character, use \[ instead.
					// search for "java regexp" if you want to read documentation
	
					word = word.toLowerCase();
					if (word.length() > 0)
						words.add(word);
				}
			}
		} catch (IOException e) {
			System.out.println("One of the readLines failed.");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("line count: " + lines.size());
		System.out.println("word count: " + words.size());
	
		for (int i=0; i<20; i++)
			System.out.println("word " + i + ": " + words.get(i));
	}

}
