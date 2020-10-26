/*
 *PID: 6169881
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class Main
{
    private static int list[];
    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String args[])
    {
        new Main();
    }

    public Main()
    {
        Random random = new Random();
        String printToFile = "";

        //Array Will Grow Up Tp 1000000
        for(int runs = 1; runs <= 20000; runs++)
        {
            int arraySize = runs * 10; //Dynamic List Size
            SearchingAlgorithms.setList(arraySize); //Creates the arrayList
            int list[] = SearchingAlgorithms.getList();//Creates a second reference to the array for better understanding of code
            SearchingAlgorithms.fillArray(list); //Fill up the array with random values
            int searchValue = random.nextInt(); //Random value to search for

            String printLine = ""; //To formar the string that will be written to the output.csv file

            printLine = seqSearchTime(list, searchValue) + ", "; //Perform the linear search first

            SearchingAlgorithms.quicksort(); //Sort the List before executing srtSearch and binSearch methods

            printLine = arraySize + ", "
                    + binSearchTime(list, searchValue) + ", "
                    + printLine
                    + srtSearchTime(list, searchValue) + "\n";

            printToFile += printLine; //Save output in a String to avoid overwriting the output file

            //At the end the output file will have the following format
            //<value of n>, < binary search time>, <sequential search time>, < sorted search time >
        }
        printToFile(printToFile);
    }


    /**
     * Illustrates how to create textfile in Java program
     * @author Prof. A. Hernandez
     */
    private static void printToFile(String printToFile)
    {
        String outputFilename = "output.csv";

        PrintWriter output = null;
        //open output stream
        try
        {
            output = new PrintWriter(new FileWriter(outputFilename));
            output.println(printToFile);
        } catch (IOException ex)
        {
            System.exit(1);
        }

        output.close();
    }


    /*
    * This method times in nanoseconds the Sequential Search Algorithm
    * Implemented in the class SearchingArgorithms.java
    */
    private static long seqSearchTime(int list[], int searchValue)
    {
        startTime = System.nanoTime();
        SearchingAlgorithms.sequentialSearch(list, searchValue);
        endTime = System.nanoTime();
        return endTime - startTime;
    }

    /*
     * This method times in nanoseconds the Sorted Search Algorithm
     * Implemented in the class SearchingArgorithms.java
     */
    private static long srtSearchTime(int list[], int searchValue)
    {
        startTime = System.nanoTime();
        SearchingAlgorithms.sortedSearch(list, searchValue);
        endTime = System.nanoTime();
        return endTime - startTime;
    }

    /*
     * This method times in nanoseconds the Binary Search Algorithm
     * Implemented in the class SearchingArgorithms.java
     */
    private static long binSearchTime(int list[], int searchValue)
    {
        startTime = System.nanoTime();
        SearchingAlgorithms.binarySearch(list, searchValue);
        endTime = System.nanoTime();
        return endTime - startTime;
    }




}
