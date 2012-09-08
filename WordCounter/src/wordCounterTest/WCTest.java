<<<<<<< HEAD
package wordCounterTest;

import junit.framework.TestCase;

public class WCTest extends TestCase {

	public void testMain() {
		fail("Not yet implemented"); // TODO
	}
	
	public void testCountWords() {
		fail("Not yet implemented"); // TODO
		
	}
	
	public void testFetch() {
		String delims = "d";
		String threshold = "30";
		WC.fetchArguments(delims, threshold);
		
		assertEquals(WC.threshold, 30);
	}

}
=======
package wordCounterTest;

import junit.framework.TestCase;

public class WCTest extends TestCase {

	public void testMain() {
		fail("Not yet implemented"); // TODO
	}
	
	public void countWordsEmptyFileTest() {
		fail("Not yet implemented"); // TODO
	}
	
	public void countWordsOneWordFileTest() {
		fail("Not yet implemented");
	}
	
	public void countWordsTenWordFileTest() {
		fail("Not yet implemented");
	}
	
	public void countWordsCustomThresholdLengthTest() {
		fail("Not yet implemented");
	}
	
	public void countWordsCustomDelimitersTest() {
		fail("Not yet implemented");
	}
	
	public void countWordsNoDelimitersTest() {
		fail("Not yet implemented");
	}

}
>>>>>>> 6889b301195b43d4b263214c087d8c5310a365bd
