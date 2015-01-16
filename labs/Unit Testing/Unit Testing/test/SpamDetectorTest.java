import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class SpamDetectorTest {

	@Test
	public void testSpamDetector() throws IOException {
		InputStream is = new FileInputStream("antispam-table.txt");
		SpamDetector testDetector = new SpamDetector(is);
		is.close();
		
		assertNotNull(testDetector);
	}

	@Test
	public void testIsSpam() throws IOException {
		Email spam = new Email("To: jcummings@neumont.edu", "From: spam@neumont.edu", 
				"specializing graciously bringing", "ybglzbgvqqgdzbm");
		
		InputStream is = new FileInputStream("email.txt");
		Email notSpam = new Email(is);
		is.close();
		
		is = new FileInputStream("antispam-table.txt");
		SpamDetector testDetector = new SpamDetector(is);
		is.close();
		
		assertTrue(testDetector.isSpam(spam));
		assertFalse(testDetector.isSpam(notSpam));
	}

}
