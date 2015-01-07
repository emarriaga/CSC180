import static org.junit.Assert.*;

import org.junit.Test;


public class WordFeatureTest {

	@Test
	public void testWordFeature() {
		WordFeature test = new WordFeature("word", 2, 3);
		
		assertNotNull(test);
		assertEquals(3, test.getSpamCount(), 0);
		assertEquals(2, test.getHamCount(), 0);
		assertEquals("word", test.getWord());
	}

	@Test
	public void testGetSpamCount() {
		WordFeature test = new WordFeature("word", 2, 3);
		assertEquals(3, test.getSpamCount(), 0);
	}

	@Test
	public void testGetHamCount() {
		WordFeature test = new WordFeature("word", 2, 3);
		assertEquals(2, test.getHamCount(), 0);
	}

	@Test
	public void testGetWord() {
		WordFeature test = new WordFeature("word", 2, 3);
		assertEquals("word", test.getWord());
	}

}
