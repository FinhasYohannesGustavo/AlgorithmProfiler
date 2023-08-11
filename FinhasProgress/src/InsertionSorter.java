package FinhasProgress.src;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InsertionSorter{
    //Field for holding the data set to be sorted.
    ArrayList<Integer> dataSet;
    //Variable for holding how long the sorting took.
    long time_taken;

    public InsertionSorter(ArrayList<Integer> dataSet){
        this.dataSet = dataSet;
    }

    void sortAscending(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int size = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_min = 0;

        for(int i = 1; i<size;i++){
            
            int temp = dataSet.get(i);
            int j=i;
            while(j>0&&temp<dataSet.get(j-1)){
                dataSet.set(j,dataSet.get(j-1)); //This sorting algorithm implements shifting not swapping
                j--;

            }
            dataSet.set(j,temp);
                
                
            
        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = (end_time - start_time)/1000;//time taken will be in microseconds

    }

    void sortDescending(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int size = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_min = 0;

        for(int i = 1; i<size;i++){
            
            int temp = dataSet.get(i);
            int j=i;
            while(j>0 && temp > dataSet.get(j-1)){
                dataSet.set(j,dataSet.get(j-1)); //This sorting algorithm implements shifting not swapping
                j--;

            }
            dataSet.set(j,temp);                
                
            
        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = (end_time - start_time)/1000;//time taken will be in microseconds

    }

  public static void main (String...str){
     
        
        // Hash maps to hold the problem size vs time duration for the three cases in the insertion sort algorithm.
        HashMap<Integer, Long> insertion_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_worst = new HashMap<>();
        //===============================================================
        //CODE FOR TESTING OUT THE ALGORITHMS
        //===============================================================
        
       
        InsertionSorter insertionSorter;

        //ArrayList<Integer> dataSet;
        for(int i=1; i<41; i++){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            ArrayList<Integer> dataSet = AlgorithmProfiler_Improved.dataSetGenerator(i*1000);

           
            
            //---------------------------------------------------------------
            //Code for testing the insertion sort algorithm in InsertionSorter
            //---------------------------------------------------------------
            insertionSorter = new InsertionSorter(dataSet);
            
            //On Best case -> on an already sorted array.
            insertionSorter.sortAscending();
            ArrayList<Integer> alreadySortedInsertion = insertionSorter.dataSet;
            insertionSorter = new InsertionSorter(alreadySortedInsertion);
            insertionSorter.sortAscending();
            insertion_size_duration_map_best.put(i, insertionSorter.time_taken); 
            
            //On Average case
            insertionSorter = new InsertionSorter(dataSet);
            insertionSorter.sortAscending();
            insertion_size_duration_map_average.put(i, insertionSorter.time_taken); 

            //On Worst case
            insertionSorter.sortDescending();
            ArrayList<Integer> reversedInsertion = insertionSorter.dataSet;
            insertionSorter = new InsertionSorter(reversedInsertion);
            insertionSorter.sortAscending();
            insertion_size_duration_map_worst.put(i, insertionSorter.time_taken); 
        }

        //===============================================================
        //CODE FOR DISPLAYING RESULTS
        //===============================================================
        //---------------------------------------------------------------
       

        //---------------------------------------------------------------
        //Code for displaying the results of insertion sort algorithm
        //---------------------------------------------------------------

        {
            
            System.out.println("\n\nRESULTS ON THE Insertion SORT ALGORITHM:");
            
            //On best case
            System.out.println("\nFor best case:");
            AlgorithmProfiler_Improved.printHashMap(insertion_size_duration_map_best);
            //On average case
            System.out.println("\nFor average case:");
            AlgorithmProfiler_Improved.printHashMap(insertion_size_duration_map_average);
            //On worst case
            System.out.println("\nFor worst case:");
            AlgorithmProfiler_Improved.printHashMap(insertion_size_duration_map_worst);
        }
    }


}