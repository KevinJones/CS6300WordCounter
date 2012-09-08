package wordCounterTest;

import wordCounter.WC;
import junit.framework.TestCase;
import java.io.*;
import java.net.URL;

public class WCTest extends TestCase {

	public void testCountWordsEmptyFile() throws IOException {
		
		final String TEST_FILENAME = "res/testFileEmpty.txt";		
		
		try {			
			Class<WCTest> c = WCTest.class;
			ClassLoader cl = c.getClassLoader();
			URL url = cl.getResource(TEST_FILENAME);
			String fullPath = url.getPath();
			String replacedPath = fullPath.replaceAll("%20", " ");
			
			FileReader r = new FileReader(replacedPath);
			WC.fileInput = r;
		} catch (FileNotFoundException e){
			fail("Test file " + TEST_FILENAME + " not found.");
		}		
		
		int result = -1;
		try {
			result = WC.countWords();
		} catch (Exception e)
		{
			fail("Wc.countWords() hit an exception.");
		}
		
		assertEquals("Counted " + result + "words instead of 0", result, 0);
	}
	
	public void testMain() {
		fail("Not yet implemented"); // TODO
	}
    
    public void testCountWordsOneWordFile() {
		fail("Not yet implemented");
	}
	
	public void testCountWordsTenWordFile() {
		fail("Not yet implemented");
	}
	
	public void testCountWordsCustomThresholdLength() {
		fail("Not yet implemented");
	}
	
	public void testCountWordsCustomDelimiters() {
		fail("Not yet implemented");
	}
	
	public void testCountWordsNoDelimitersTest() {
		fail("Not yet implemented");
	}

	public void testFetch() {
//		String delims = "d";
//		String threshold = "30";
//		WC.fetchArguments(delims, threshold);
//		
//		assertEquals(WC.threshold, 30);
		
		fail("Not yet implemented");
	}

}
