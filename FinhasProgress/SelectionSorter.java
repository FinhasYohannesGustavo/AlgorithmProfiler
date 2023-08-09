package FinhasProgress;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

public class SelectionSorter{
    //Field for holding the data set to be sorted.
    ArrayList<Double> dataSet;
    //Variable for holding how long the sorting took.
    long time_taken;

    //Variable for holding the number of instructions executed.
    int num_of_instructions=0;

    public SelectionSorter(ArrayList<Double> dataSet){
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
            // num_of_instructions+=;

            //Look for the index of the minimum number in the unsorted part of the data set.
            for (int j=i+1; j<len; j++){
                if(dataSet.get(j) < dataSet.get(index_of_min)){
                    index_of_min = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_min != i){
                // System.out.println("Before swap: " + AlgorithmProfiler_Improved.printDataSet(dataSet));
                
                Collections.swap(dataSet, i, index_of_min);
                num_of_instructions++;
                
                // System.out.println("After swap: " + AlgorithmProfiler_Improved.printDataSet(dataSet));
                // System.out.println();
            }
                

        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;

        System.out.println("Number of instructions: " + num_of_instructions);

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
        ArrayList<Double> dataSetX = AlgorithmProfiler_Improved.dataSetGenerator(10);
        SelectionSorter selectionSorter = new SelectionSorter(dataSetX);

        dataSetX = AlgorithmProfiler_Improved.dataSetGenerator(100);

        //---------------------------------------------------------------
        //Code for testing the selection sort algorithm in SelectionSorter
        //---------------------------------------------------------------
        selectionSorter = new SelectionSorter(dataSetX);
        
        System.out.println("==============================");
        System.out.println("| AVERAGE CASE SCENARIO TEST |");
        System.out.println("==============================");
        //On Average case
        selectionSorter = new SelectionSorter(dataSetX);
        selectionSorter.sortAscending();
        
        //On Best case -> on an already sorted array.
        selectionSorter.sortAscending();
        ArrayList<Double> alreadySorted = selectionSorter.dataSet;
        selectionSorter = new SelectionSorter(alreadySorted);
        System.out.println("===========================");
        System.out.println("| BEST CASE SCENARIO TEST |");
        System.out.println("===========================");
        selectionSorter.sortAscending();
        
        //On Worst case
        selectionSorter.sortDescending();
        ArrayList<Double> reversed = selectionSorter.dataSet;
        selectionSorter = new SelectionSorter(reversed);
        System.out.println("============================");
        System.out.println("| WORST CASE SCENARIO TEST |");
        System.out.println("============================");
        selectionSorter.sortAscending();
        
    }


}