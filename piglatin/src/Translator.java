import java.io.*;

/**
 * Translates a sentence into pig latin.
 */
public class Translator {

	private static BufferedReader in = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		System.out.print("Enter sentence: ");
		String english = getString();

		String latin = toPigLatin(english);
		System.out.println(latin);
	}

	private static String toPigLatin(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			while (i < s.length() && !isLetter(s.charAt(i))) {
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

	private static boolean isLetter(char c) {
		return Character.isAlphabetic(c);
	}

	private static String pigWord(String word) {
		String[] parts = word.split("[aeiouAEIOU]");
		return word.substring(parts[0].length()) + "-" + parts[0] + "ay";
	}

	private static String getString() throws IOException {
		return in.readLine();
	}
}