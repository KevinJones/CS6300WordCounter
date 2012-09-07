package wordCounter;
/**
 * Word Counter
 * More comments later.
 */

import java.io.*;

/**
 * The main class for Word Counter.
 */
public class WC {

	// static member variables.
	private static File fileInput;
	private static int iThreshold = 1;
	private static String strDelimiters = " .,:;";
	
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
		
		if(!openFile())
		{
			//TODO: Print error message 2 and exit
		}
		
		System.out.println(countWords());
	}
	
	private static Boolean init()
	{
		//TODO: implement this method
		return false;
	}
	
	private static Boolean fetchArguments()
	{
		//TODO: implement this method
		return false;
	}
	
	private static Boolean openFile()
	{
        

		//TODO: implement this method
		return false;
	}
	
	/**
	 * Reads the inputFile, delimiters, and wordThreshold variables to count the
	 * number of words (sequences of non-delimiter characters between two delimiters)
	 * in the input file.
	 * @return The number of words in the file
	 */
	private static int countWords()
	{
        int wordLength = 0;
        int wordCount = 0;
        boolean[] delimiterFlags = {false, false};
        
        // TODO: Get the file from openFile.
        // TODO: Get the delimiter set from fetchArguments.
        String delimiters = " .,:;";
        // TODO: Get the word length threshold from fetchArguments.
        int wordThreshold = 1;

        boolean isEndOfFile = true; // TODO: collapse this boolean into the while statement, which steps through the file char by char.
        while(!isEndOfFile)
        {
            char c = ' '; // TODO: read a character from the file.
            wordLength++;
            boolean charIsDelimiter = delimiters.indexOf(c) != -1;
            if(charIsDelimiter)
            {
                delimiterFlags[1] = true;
                boolean hasDelimitersOnBothSides = (delimiterFlags[0] && delimiterFlags[1]);
                if (hasDelimitersOnBothSides)
                {
                    if(wordLength - 1 >= wordThreshold)
                    {
                        wordCount++;
                    }
                }
                wordLength = 0;
                delimiterFlags[0] = true;
                delimiterFlags[1] = false;
            }

        }

        return wordCount;
	}

}
