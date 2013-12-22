package pasta.salad;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.Test;

public class TranslatorTest {

	@Test
	public void testGetString() throws Exception {
		Translator t = new Translator();
		String input = "Who let the dogs out?";
		BufferedReader in = new BufferedReader( new StringReader( input ) );
		
		String s = t.getString( in );
		assertEquals( "System input should match", input, s );
		
		String latin = t.toPigLatin(s);
		assertEquals( "Translated text should match", "o-Whay et-lay e-thay ogs-day out-ay?", latin );
	}

}
