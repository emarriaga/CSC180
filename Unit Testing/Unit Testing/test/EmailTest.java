import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;


public class EmailTest {

	@Test
	public void testEmailStringStringStringString() {
		Email test = new Email("testTo", "testFrom", "testSubject", "testContent");
		
		assertNotNull(test);
		assertEquals("testTo", test.getTo());
		assertEquals("testFrom", test.getFrom());
		assertEquals("testSubject", test.getSubject());
		assertEquals("testContent", test.getContent());
	}

	@Test
	public void testEmailInputStream() throws IOException {
		InputStream is = new FileInputStream("email.txt");
		Email test = new Email(is);
		is.close();
		
		assertNotNull(test);
		assertEquals("jcummings@neumont", test.getTo());
		assertEquals("bob@neumont", test.getFrom());
		assertEquals("Howdy", test.getSubject());
		assertEquals("What do you think of this new email system?", test.getContent());
		
		
	}
	
	@Test
	public void testFindPropertyException() throws IOException {
		String mismatchEmail = "From: Bob \nTo: me@neumont.edu \nSubject: subject \nthe content";
		InputStream mismatchStream = new ByteArrayInputStream(mismatchEmail.getBytes());
		
		try {
			Email fromMismatch = new Email(mismatchStream);
			fail("IllegalArgumentException not made when expected");
			fromMismatch.getTo(); //Unreachable; made to suppress "variable fromMismatch not being used" warning
		} catch (IllegalArgumentException e) {
			
		}
		mismatchStream.close();
	}

	@Test
	public void testGetTo() {
		Email test = new Email("testTo", "testFrom", "testSubject", "testContent");
		assertEquals("testTo", test.getTo());
	}

	@Test
	public void testGetFrom() {
		Email test = new Email("testTo", "testFrom", "testSubject", "testContent");
		assertEquals("testFrom", test.getFrom());
	}

	@Test
	public void testGetSubject() {
		Email test = new Email("testTo", "testFrom", "testSubject", "testContent");
		assertEquals("testSubject", test.getSubject());
	}

	@Test
	public void testGetContent() {
		Email test = new Email("testTo", "testFrom", "testSubject", "testContent");
		assertEquals("testContent", test.getContent());
	}

}
