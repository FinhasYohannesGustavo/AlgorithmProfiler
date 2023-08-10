package FinhasProgress.src;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;


public class SelectionSorter{
    //Field for holding the data set to be sorted.
    ArrayList<Integer> dataSet;
    //Variable for holding how long the sorting took.
    long time_taken;

    //Variable for holding the number of swaps performed.
    int num_of_swaps=0;
    //Variable for holding the number of checks performed.
    int num_of_checks=0;
    
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
                // System.out.println("Before swap: " + AlgorithmProfiler_Improved.printDataSet(dataSet));
                
                Collections.swap(dataSet, i, index_of_min);
                num_of_swaps++;
                
                // System.out.println("After swap: " + AlgorithmProfiler_Improved.printDataSet(dataSet));
                // System.out.println();
            }
                

        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = (end_time - start_time)/1000;

        // System.out.println("Number of swaps: " + num_of_swaps);
        // System.out.println("Number of checks: " + num_of_checks);
        // System.out.println("Time taken: " + time_taken);

    }

    void sortDescending(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int len = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_max = 0;

        for (int i=0; i<len-1; i++){
            index_of_max = i;

            //Look for the index of the minimum number in the unsorted part of the data set.
            for (int j=i+1; j<len; j++){
                if(dataSet.get(j) > dataSet.get(index_of_max)){
                    index_of_max = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_max != i)
                Collections.swap(dataSet, i, index_of_max);

        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;

        time_taken = time_taken / 1000000;

    }

    public static void main(String...str) {
        ArrayList<Integer> dataSet = AlgorithmProfiler_Improved.dataSetGenerator(100000);
        SelectionSorter selectionSorter = new SelectionSorter(dataSet);

        // dataSet = AlgorithmProfiler_Improved.dataSetGenerator(10);

        //---------------------------------------------------------------
        //Code for testing the selection sort algorithm in SelectionSorter
        //---------------------------------------------------------------
        selectionSorter = new SelectionSorter(dataSet);
        
        System.out.println("==============================");
        System.out.println("| AVERAGE CASE SCENARIO TEST |");
        System.out.println("==============================");
        //On Average case
        selectionSorter.sortAscending();
        
        //On Best case -> on an already sorted array.
        // selectionSorter.sortAscending();
        ArrayList<Integer> alreadySorted = selectionSorter.dataSet;
        selectionSorter = new SelectionSorter(alreadySorted);
        System.out.println("===========================");
        System.out.println("| BEST CASE SCENARIO TEST |");
        System.out.println("===========================");
        selectionSorter.sortAscending();
        
        //On Worst case
        selectionSorter.sortDescending();
        ArrayList<Integer> reversed = selectionSorter.dataSet;
        selectionSorter = new SelectionSorter(reversed);
        System.out.println("============================");
        System.out.println("| WORST CASE SCENARIO TEST |");
        System.out.println("============================");
        selectionSorter.sortAscending();
        
    }


}