package FinhasProgress;
//Standard libraries
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmProfiler_Improved{

    public static void main (String...str){
        // Hash maps to hold the problem size vs time duration for the three cases in the selection sort algorithm.
        HashMap<Integer, Long> selection_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> selection_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> selection_size_duration_map_worst = new HashMap<>();
        
        // Hash maps to hold the problem size vs time duration for the three cases in the bubble sort algorithm.

        // Hash maps to hold the problem size vs time duration for the three cases in the insertion sort algorithm.

        //===============================================================
        //CODE FOR TESTING OUT THE ALGORITHMS
        //===============================================================
        
        SelectionSorter selectionSorter;
        //BubbleSorter bubbleSorter;
        //InsertionSorter insertionSorter;

        ArrayList<Double> dataSet;
        for(int i=1; i<1000; i+=50){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            dataSet = AlgorithmProfiler_Improved.dataSetGenerator(i);

            //---------------------------------------------------------------
            //Code for testing the selection sort algorithm in SelectionSorter
            //---------------------------------------------------------------
            selectionSorter = new SelectionSorter(dataSet);
            
            //On Best case -> on an already sorted array.
            selectionSorter.sortAscending();
            ArrayList<Double> alreadySorted = selectionSorter.dataSet;
            selectionSorter = new SelectionSorter(alreadySorted);
            selectionSorter.sortAscending();
            selection_size_duration_map_best.put(i, selectionSorter.time_taken);
            
            //On Average case
            selectionSorter = new SelectionSorter(dataSet);
            selectionSorter.sortAscending();
            selection_size_duration_map_average.put(i, selectionSorter.time_taken);

            //On Worst case
            selectionSorter.sortDescending();
            ArrayList<Double> reversed = selectionSorter.dataSet;
            selectionSorter = new SelectionSorter(reversed);
            selectionSorter.sortAscending();
            selection_size_duration_map_worst.put(i, selectionSorter.time_taken);

            //---------------------------------------------------------------
            //Code for testing the selection sort algorithm in BubbleSorter
            //---------------------------------------------------------------
           
            
            //---------------------------------------------------------------
            //Code for testing the selection sort algorithm in InsertionSorter
            //---------------------------------------------------------------
            
        }

        //===============================================================
        //CODE FOR DISPLAYING RESULTS
        //===============================================================
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
        

        //---------------------------------------------------------------
        //Code for displaying the results of insertion sort algorithm
        //---------------------------------------------------------------
    }

    //A function that generates as many random numbers as needed.
    public static ArrayList<Double> dataSetGenerator(int quantity){
        //Array list that will contain all the random numbers
        ArrayList<Double> to_be_returned = new ArrayList<Double>();
        
        //Random number object for generating random numbers
        Random random_number = new Random();
        
        //Add as many random numbers to the list as is specified by 'quantity'
        for(int i=0; i<quantity; i++){
            
            to_be_returned.add(random_number.nextInt(1000)+0.0);
            //to_be_returned.add(random_number.nextDouble(1000));
        }

        return to_be_returned;
    }

    public static void printHashMap(HashMap<Integer, Long> table){
        System.out.println("[Data size, Time taken]");

        for(Map.Entry<Integer, Long> record : table.entrySet()){
            int data_size = record.getKey();
            long time_taken = record.getValue();

            System.out.printf("[%d, %d] \n", data_size, time_taken);
        }
    }

    public static String printDataSet(ArrayList<Double> dataSet){
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