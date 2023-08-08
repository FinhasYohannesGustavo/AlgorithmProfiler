//Standard libraries
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

//Our own classes
import SelectionSorter;

public class AlgorithmProfiler{

    public static void main (String..str){
        // Variables to hold the size and time duration for the three sorting algorithms.
        HashMap<Integer, Double> selection_size_duration_map = new HashMap<Integer, Double>;
        HashMap<Integer, Double> bubble_size_duration_map = new HashMap<Integer, Double>;
        HashMap<Integer, Double> insertion_size_duration_map = new HashMap<Integer, Double>;

        //===============================================================
        //CODE FOR TESTING OUT THE ALGORITHMS
        //===============================================================
        
        SelectionSorter selectionSorter;
        BubbleSorter bubbleSorter;
        InsertionSorter insertionSorter;

        ArrayList<double> dataSet;
        for(int i=1; i<100; i+=5){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            dataSet = AlgorithmProfiler.dataSetGenerator(i);

            //Code for testing the selection sort algorithm in SelectionSorter
            selectionSorter = new SelectionSorter(dataSet);
            selectionSorter.sort();
            selection_size_duration_map.put(i, selectionSorter.time_taken);

            //Code for testing the selection sort algorithm in BubbleSorter
            bubbleSorter = new BubbleSorter(dataSet);
            bubbleSorter.sort();
            selection_size_duration_map.put(i, bubbleSorter.time_taken);
            
            //Code for testing the selection sort algorithm in InsertionSorter
            insertionSorter = new InsertionSorter(dataSet);
            insertionSorter.sort();
            selection_size_duration_map.put(i, insertionSorter.time_taken);
        }

        //===============================================================
        //CODE FOR DISPLAYING RESULTS
        //===============================================================
        System.out.println("\n\nResults on the selection sort algorithm:")
        printHashMap(selection_size_duration_map);
        System.out.println("\n\nResults on the bubble sort algorithm:")
        printHashMap(bubble_size_duration_map);
        System.out.println("\n\nResults on the insertion sort algorithm:")
        printHashMap(insertion_size_duration_map);

    }

    //A function that generates as many random numbers as needed.
    public static ArrayList<Double> dataSetGenerator(int quantity){
        //Array list that will contain all the random numbers
        ArrayList<Double> toBeReturned = new ArrayList<Double>();
        
        //Random number object for generating random numbers
        Random random_number = new Random();
        
        //Add as many random numbers to the list as is specified by 'quantity'
        for(int i=0; i<quantity; i++){
            toBeReturned.add(random_number.nextDouble());
        }

        return toBeReturned;
    }

    public static void printHashMap(HashMap<Integer, Double> table){
        System.out.prinln("[Data size, Time taken]")

        for(Map.Entry<Integer, Double> record : table.entrySet()){
            int data_size = record.getKey();
            long time_taken = record.getValue();

            System.out.prinf("[%d, %d] \n", data_size, time_taken);
        }
    }
}