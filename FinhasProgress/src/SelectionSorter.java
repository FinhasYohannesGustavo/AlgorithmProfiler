package FinhasProgress.src;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SelectionSorter{
    //Field for holding the data set to be sorted.
    ArrayList<Integer> dataSet;

    //Variable for holding how long the sorting took.
    long time_taken;
    
    public SelectionSorter(ArrayList<Integer> dataSet){
        this.dataSet = dataSet;
    }
    
    void sortAscending(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int len = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_min = 0;

        //Variable for holding the number of swaps performed.
        int num_of_swaps=0;
        //Variable for holding the number of checks performed.
        int num_of_checks=0;

        for (int i=0; i<len-1; i++){
            index_of_min = i;

            //Look for the index of the minimum number in the unsorted part of the data set.
            for (int j=i+1; j<len; j++){
                num_of_checks++;
                if(dataSet.get(j) < dataSet.get(index_of_min)){
                    index_of_min = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_min != i){
                Collections.swap(dataSet, i, index_of_min);
                num_of_swaps++;
            }
                
        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken in microseconds.
        time_taken = (end_time - start_time)/1000;

        // System.out.println("Number of swaps: " + num_of_swaps);
        // System.out.println("Number of checks: " + num_of_checks);
        // System.out.println("Time taken: " + time_taken);

    }
    
    public static void main(String...str) {
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //CODE FOR TESTING OUT A SINGLE DATA SET.
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        /*
        ArrayList<Integer> dataSet = AlgorithmProfiler_Improved.dataSetGenerator(10);
        SelectionSorter selectionSorter = new SelectionSorter(dataSet);
        
        //On Average case -> on a randomly organized data set.
        System.out.println("==============================");
        System.out.println("| AVERAGE CASE SCENARIO TEST |");
        System.out.println("==============================");
        selectionSorter.sortAscending();
        // System.out.println("Data after average sort: " + AlgorithmProfiler_Improved.printDataSet(selectionSorter.dataSet));
        
        //On Best case -> on an already sorted data set.
        System.out.println("===========================");
        System.out.println("| BEST CASE SCENARIO TEST |");
        System.out.println("===========================");
        //Sort the data set in ascending order with a built in class in java.util.Collections.
        Collections.sort(dataSet);
        selectionSorter.dataSet = dataSet;
        // System.out.println("Data after sorting: " + AlgorithmProfiler_Improved.printDataSet(selectionSorter.dataSet));
        selectionSorter.sortAscending();
        
        //On Worst case -> on a reverse-sorted data set.
        System.out.println("============================");
        System.out.println("| WORST CASE SCENARIO TEST |");
        System.out.println("============================");
        //Sort the data set in descending order with a built in class in java.util.Collections.
        Collections.sort(dataSet, Collections.reverseOrder());
        selectionSorter.dataSet = dataSet;
        // System.out.println("Data after reverse-sorting: " + AlgorithmProfiler_Improved.printDataSet(selectionSorter.dataSet));
        selectionSorter.sortAscending();
        */

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //CODE FOR TESTING OUT MANY DATA SETS.
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        // Hash maps to hold the problem size vs time duration for the three cases in the insertion sort algorithm.
        HashMap<Integer, Long> insertion_size_duration_map_best = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_average = new HashMap<>();
        HashMap<Integer, Long> insertion_size_duration_map_worst = new HashMap<>();
       
        SelectionSorter selectionSorter;

        //ArrayList<Integer> dataSet;
        for(int i=1000; i<41; i+=1000){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            ArrayList<Integer> dataSet = AlgorithmProfiler_Improved.dataSetGenerator(i);
            
            selectionSorter = new SelectionSorter(dataSet);
            
            //On Average case
            selectionSorter.sortAscending();
            insertion_size_duration_map_average.put(i, selectionSorter.time_taken); 
            
            //On Best case -> on an already sorted array.
            Collections.sort(dataSet);
            selectionSorter.dataSet = dataSet;
            selectionSorter.sortAscending();
            insertion_size_duration_map_best.put(i, selectionSorter.time_taken); 

            //On Worst case
            Collections.sort(dataSet, Collections.reverseOrder());
            selectionSorter.dataSet = dataSet;
            selectionSorter.sortAscending();
            insertion_size_duration_map_worst.put(i, selectionSorter.time_taken); 
        }

        //===============================================================
        //CODE FOR DISPLAYING RESULTS
        //===============================================================
       
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