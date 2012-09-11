package wordCounter;
/**
 * Word Counter
 * More comments later.
 */

import java.io.*;
import java.net.URL;

import wordCounterTest.WCTest;

// This is a meaningless test comment. -Kevin
// This is a second meaningless comment
//This is a third meaningless comment - Xiaofang

/**
 * The main class for Word Counter.
 */
public class WC {

	// defaults
	public static final int DEFAULT_THRESHOLD = 1;
	public static final String DEFAULT_DELIMITERS = " .,:;";
	
	// static member variables.
	public static FileReader fileInput;
	public static int iThreshold;
	public static String strDelimiters;
	public static String fileName;
	
	// exit status codes.
	public static final int ARGUMENT_ERROR = 1;
	public static final int FILE_ERROR = 2;
	public static final int IO_ERROR = 3;
	
	/**
	 * @param args
	 * @author KevinJones
	 * 
	 */
	public static void main(String[] args) {
		init();
		
		if(!fetchArguments(args)) {
			System.out.println("ERROR: ill-formed command");
			System.exit(ARGUMENT_ERROR);
		}
		
		if(!openFile()) {
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
	
	public static Boolean init(){
		iThreshold = DEFAULT_THRESHOLD;
		strDelimiters = DEFAULT_DELIMITERS;

		return true;
	}
	
	public static Boolean fetchArguments(String[] args){
		/*Initialize reuired variables*/
		int iArgsLength = args.length;
		int iMinWordCount = 1;
		String strDelimiters = new String();
		String[] astrCopyArgs =  new String[iArgsLength];
		int iCountC = 0;
		int iCountL = 0;
		
		/*Extract the command-line arguments*/
				
		for (int i = 0; i<iArgsLength; i++){
			astrCopyArgs[i] = args[i];
		}
		
		/*Extract the minimum word count or threshold and the delimiters*/
		for (int i=1; i<args.length; i++){
			if (astrCopyArgs[i].equals("-l")){
				iCountL++;
				if(iCountL == 1){
					try{
						iMinWordCount = Integer.parseInt(astrCopyArgs[i+1]);
					}
					catch(Exception e){
						return false;
					}
					i++;
				}	
				else{
					return false;
				}
			} else if (astrCopyArgs[i].equals("-c")){
				iCountC++;
				if(iCountC == 1){
					try {
						strDelimiters = astrCopyArgs[i+1];
					} catch (Exception e) {
						return false;
					}
				}
				else{
					return false;
				}
				i++;				
			} else {
				// command line argument not recognized
				return false;
			}
		}
		
		try{
			fileName = astrCopyArgs[0];
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		WC.strDelimiters = strDelimiters;
		WC.iThreshold = iMinWordCount;
		
		return true;
	}
	
	public static Boolean openFile() {
		Class<WCTest> c = WCTest.class;
		ClassLoader cl = c.getClassLoader();
		
		URL url;
		String strFullPath;
		String strReplacedPath;
		
		try {
			url = cl.getResource(fileName);
			strFullPath = url.getPath();
			strReplacedPath = strFullPath.replaceAll("%20", " ");
		} catch (NullPointerException e) {
			return false;
		}
		
		
		try {
			fileInput = new FileReader(strReplacedPath);
		} catch (FileNotFoundException e1) {
			// The file doesn't exist or we can't read it.
			return false;
		}
		
		return true;
	}
	
	/**
	 * Reads the inputFile, delimiters, and wordThreshold variables to count the
	 * number of words (sequences of non-delimiter characters between two delimiters)
	 * in the input file.
	 * @return The number of words in the file
	 * @throws IOException if an I/O operation fails or is interrupted
	 */
	public static int countWords() throws IOException{
        int iWordLength = 0;
        int iWordCount = 0;
        boolean[] abDelimiterFlags = {false, false};

        int iRead = fileInput.read();
        boolean bEndOfFile = (iRead == -1);
        char c = (char) iRead;
        while(!bEndOfFile && iWordLength < Integer.MAX_VALUE && iWordCount < Integer.MAX_VALUE){
            iWordLength++;
            boolean bCharIsDelimiter = strDelimiters.indexOf(c) != -1;
            if(bCharIsDelimiter){
                abDelimiterFlags[1] = true;
                boolean bHasDelimitersOnBothSides = (abDelimiterFlags[0] && abDelimiterFlags[1]);
                if (bHasDelimitersOnBothSides){
                    if(iWordLength - 1 >= iThreshold){
                        iWordCount++;
                    }
                }
                iWordLength = 0;
                abDelimiterFlags[0] = true;
                abDelimiterFlags[1] = false;
            }
            
            // read the next char.
            iRead = fileInput.read();
            bEndOfFile = (iRead == -1);
            c = (char) iRead;

        }

        return iWordCount;
	}

}
