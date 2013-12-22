package pasta.salad;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

/**
 * Translates a sentence into pig latin.
 */
public class Translator {

	public static void main(String[] args) throws IOException {

		System.out.print("Enter sentence: ");
		String english = getString( new BufferedReader(new InputStreamReader(System.in) ) );
		
			english = StringUtils.capitaliseAllWords( english );
			
			String latin = toPigLatin(english);
			System.out.println(latin);
	}

	
	// USE SPLIT TO FIX THIS OLD CRAPPY IMPLEMENTATION!!!
	public static String toPigLatin(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			while (i < s.length() && !Character.isAlphabetic(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}

			if (i >= s.length()) {
				break;
			}

			int begin = i;
			while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
				i++;
			}

			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	public static String pigWord(String word) {
		String[] parts = word.split("[aeiouAEIOU]");
		return word.substring(parts[0].length()) + "-" + parts[0] + "ay";
	}

	public static String getString( BufferedReader in ) throws IOException {
		return in.readLine();
	}
}