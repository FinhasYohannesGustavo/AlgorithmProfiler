package FinhasProgress.src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmProfiler_Improved{

    public static void main (String...str){
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        //CODE FOR TESTING OUT THE ALGORITHMS
        
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        // Hash maps to hold the problem size vs time duration mapping for the three cases in the selection sort algorithm.
        HashMap<Integer, Long> selection_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> selection_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> selection_size_duration_map_worst = new HashMap<>();
        
        // Hash maps to hold the problem size vs time duration mapping for the three cases in the bubble sort algorithm.
        HashMap<Integer, Long> bubble_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> bubble_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> bubble_size_duration_map_worst = new HashMap<>();

        // Hash maps to hold the problem size vs time duration mapping for the three cases in the insertion sort algorithm.
        HashMap<Integer, Long> insertion_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_worst = new HashMap<>();
        
        // Variables for accessing the specific sorting algorithm type.
        SelectionSorter selectionSorter;
        BubbleSorter bubbleSorter;
        InsertionSorter insertionSorter;

        ArrayList<Integer> dataSet;
        for(int i=1000; i<=40000; i+=1000){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            dataSet = AlgorithmProfiler_Improved.dataSetGenerator(i);

            //---------------------------------------------------------------
            //Code for testing the selection sort algorithm in SelectionSorter
            //---------------------------------------------------------------
            {
                selectionSorter = new SelectionSorter(dataSet);
                
                //On Average case -> jumbled data set.
                selectionSorter.sortAscending();
                selection_size_duration_map_average.put(i, selectionSorter.time_taken); 
                
                //On Best case -> on an already sorted data set.
                Collections.sort(dataSet);
                selectionSorter.dataSet = dataSet;
                selectionSorter.sortAscending();
                selection_size_duration_map_best.put(i, selectionSorter.time_taken); 
    
                //On Worst case -> reverese-sorted data set.
                Collections.sort(dataSet, Collections.reverseOrder());
                selectionSorter.dataSet = dataSet;
                selectionSorter.sortAscending();
                selection_size_duration_map_worst.put(i, selectionSorter.time_taken); 
            }
            
            //---------------------------------------------------------------
            //Code for testing the bubble sort algorithm in BubbleSorter
            //---------------------------------------------------------------
            {
                bubbleSorter = new BubbleSorter(dataSet);
                
                //On Average case -> jumbled data set.
                bubbleSorter.sortAscending();
                bubble_size_duration_map_average.put(i, bubbleSorter.time_taken); 
                
                //On Best case -> on an already sorted data set.
                Collections.sort(dataSet);
                bubbleSorter.dataSet = dataSet;
                bubbleSorter.sortAscending();
                bubble_size_duration_map_best.put(i, bubbleSorter.time_taken); 
    
                //On Worst case -> reverese-sorted data set.
                Collections.sort(dataSet, Collections.reverseOrder());
                bubbleSorter.dataSet = dataSet;
                bubbleSorter.sortAscending();
                bubble_size_duration_map_worst.put(i, bubbleSorter.time_taken); 
            }
           
            //---------------------------------------------------------------
            //Code for testing the selection sort algorithm in InsertionSorter
            //---------------------------------------------------------------
            {
                insertionSorter = new InsertionSorter(dataSet);
                
                //On Average case -> jumbled data set.
                insertionSorter.sortAscending();
                insertion_size_duration_map_average.put(i, insertionSorter.time_taken); 
                
                //On Best case -> on an already sorted data set.
                Collections.sort(dataSet);
                insertionSorter.dataSet = dataSet;
                insertionSorter.sortAscending();
                insertion_size_duration_map_best.put(i, insertionSorter.time_taken); 
    
                //On Worst case -> reverese-sorted data set.
                Collections.sort(dataSet, Collections.reverseOrder());
                insertionSorter.dataSet = dataSet;
                insertionSorter.sortAscending();
                insertion_size_duration_map_worst.put(i, insertionSorter.time_taken); 
            }
        }

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        //CODE FOR DISPLAYING RESULTS
        
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //---------------------------------------------------------------
        //Code for displaying the results of selection sort algorithm
        //---------------------------------------------------------------
         {
            System.out.println("\n\nRESULTS ON THE SELECTION SORT ALGORITHM:");
            
            //On best case
            System.out.println("\nFor best case:");
            printHashMap(selection_size_duration_map_best);
            //On average case
            System.out.println("\nFor average case:");
            printHashMap(selection_size_duration_map_average);
            //On worst case
            System.out.println("\nFor worst case:");
            printHashMap(selection_size_duration_map_worst);

        } 
        //---------------------------------------------------------------
        //Code for displaying the results of bubble sort algorithm
        //---------------------------------------------------------------
        
        {
           System.out.println("\n\nRESULTS ON THE BUBBLE SORT ALGORITHM:");
           
           //On best case
           System.out.println("\nFor best case:");
           printHashMap(bubble_size_duration_map_best);
           //On average case
           System.out.println("\nFor average case:");
           printHashMap(bubble_size_duration_map_average);
           //On worst case
           System.out.println("\nFor worst case:");
           printHashMap(bubble_size_duration_map_worst);

        } 
       
        //---------------------------------------------------------------
        //Code for displaying the results of insertion sort algorithm
        //---------------------------------------------------------------
        {
           System.out.println("\n\nRESULTS ON THE INSERTION SORT ALGORITHM:");
           
           //On best case
           System.out.println("\nFor best case:");
           printHashMap(insertion_size_duration_map_best);
           //On average case
           System.out.println("\nFor average case:");
           printHashMap(insertion_size_duration_map_average);
           //On worst case
           System.out.println("\nFor worst case:");
           printHashMap(insertion_size_duration_map_worst);
 
        } 
    }

    //A function that generates as many random numbers as needed.
    public static ArrayList<Integer> dataSetGenerator(int quantity){
        //Array list that will contain all the random numbers
        ArrayList<Integer> to_be_returned = new ArrayList<Integer>();
        
        //Random number object for generating random numbers
        Random random_number = new Random();
        
        //Add as many random numbers to the list as is specified by 'quantity'
        for(int i=0; i<quantity; i++){
            to_be_returned.add(random_number.nextInt(1000,100000));
        }

        return to_be_returned;
    }

    //A function that prints a hashmap.
    public static void printHashMap(HashMap<Integer, Long> table){
        System.out.println("[Data size, Time taken in microseconds]");

        for(Map.Entry<Integer, Long> record : table.entrySet()){
            int data_size = record.getKey();
            long time_taken = record.getValue();

            System.out.printf("[%d, %d] \n", data_size, time_taken);
        }
    }

    //A function that prints an arraylist of type Integer. Used for testing purposes.
    public static String printDataSet(ArrayList<Integer> dataSet){
        String to_be_printed = "{";
        int len = dataSet.size();
        for(int i=0; i<len; i++){
            to_be_printed += String.valueOf(dataSet.get(i));
            
            if(i != len-1) to_be_printed += ", ";
        }
        to_be_printed += "}";

        return to_be_printed;
    }
}