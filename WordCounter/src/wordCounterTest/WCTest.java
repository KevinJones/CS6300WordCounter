package wordCounterTest;

import wordCounter.WC;
import junit.framework.TestCase;
import java.io.*;

public class WCTest extends TestCase {

	public void testCountWordsEmptyFile() {
		
		final String TEST_FILENAME = "testFileEmpty.txt";
        
		String dir = null;
		File currentDirectory = new File(".");
		try {
			currentDirectory.getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			WC.fileInput = new FileReader(dir + TEST_FILENAME);
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
		
		assertEquals(result, 0);
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
		String delims = "d";
		String threshold = "30";
		WC.fetchArguments(delims, threshold);
		
		assertEquals(WC.threshold, 30);
	}

}
