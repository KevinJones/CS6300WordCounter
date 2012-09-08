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
