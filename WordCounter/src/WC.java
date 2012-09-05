/**
 * Word Counter
 * More comments later.
 */

/**
 * The main class for Word Counter.
 */
public class WC {

	/**
	 * @param args
	 * @author KevinJones
	 */
	public static void main(String[] args) {
		
		init();
		if(!fetchArguments())
		{
			//TODO: Print error message 1 and exit
		}
		// TODO: Open file
		System.out.println(countWords());
	}
	
	private static Boolean init()
	{
		//TODO: implement this method
		return true;
	}
	
	private static Boolean fetchArguments()
	{
		//TODO: implement this method
		return true;
	}
	
	private static int countWords()
	{
		//TODO: implement this method
		return 0;
	}

}
