package wordCounter;
/**
 * Word Counter
 * More comments later.
 */

import java.io.*;

// This is a meaningless test comment. -Kevin

/**
 * The main class for Word Counter.
 */
public class WC {

	// static member variables.
	private static FileReader fileInput;
	private static int iThreshold = 1;
	private static String strDelimiters = " .,:;";
	
	// exit status codes.
	private static final int ARGUMENT_ERROR = 1;
	private static final int FILE_ERROR = 2;
	private static final int IO_ERROR = 3;
	
	/**
	 * @param args
	 * @author KevinJones
	 * modified
	 */
	public static void main(String[] args) {
		
		init();
		if(!fetchArguments())
		{
			//TODO: Print error message 1 and exit
			// System.exit(ARGUMENT_ERROR);
		}
		
		if(!openFile())
		{
			//TODO: Print error message 2 and exit
			// System.exit(FILE_ERROR);
			System.out.println("ERROR: unable to process file");
			System.exit(FILE_ERROR);
		}
		
		int wordsCounted = 0;
		try {
			wordsCounted = countWords();
		} catch (IOException e) {
			System.out.println("ERROR: File IO exception");
			System.exit(IO_ERROR);
		}
		System.out.println(wordsCounted);
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
	 * @throws IOException if an I/O operation fails or is interrupted
	 */
	private static int countWords() throws IOException
	{
        int wordLength = 0;
        int wordCount = 0;
        boolean[] delimiterFlags = {false, false};

        char c = (char) fileInput.read();
        boolean isEndOfFile = (c == -1);
        while(!isEndOfFile)
        {
            wordLength++;
            boolean charIsDelimiter = strDelimiters.indexOf(c) != -1;
            if(charIsDelimiter)
            {
                delimiterFlags[1] = true;
                boolean hasDelimitersOnBothSides = (delimiterFlags[0] && delimiterFlags[1]);
                if (hasDelimitersOnBothSides)
                {
                    if(wordLength - 1 >= iThreshold)
                    {
                        wordCount++;
                    }
                }
                wordLength = 0;
                delimiterFlags[0] = true;
                delimiterFlags[1] = false;
            }
            
            // read the next char.
            c = (char) fileInput.read();
            isEndOfFile = (c == -1);

        }

        return wordCount;
	}

}
