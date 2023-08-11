package FinhasProgress.src;

import java.util.ArrayList;
import java.util.Collections;

public class DataSorter {
    //Field for holding the data set to be sorted.
    ArrayList<Integer> dataSet;

    //Variable for holding how long the sorting took.
    long time_taken;
    
    public DataSorter(ArrayList<Integer> dataSet){
        this.dataSet = dataSet;
    }

    public void selectionSort(){
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
                if(dataSet.get(j) < dataSet.get(index_of_min)){
                    index_of_min = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_min != i){
                Collections.swap(dataSet, i, index_of_min);
            }
                
        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken in microseconds.
        time_taken = (end_time - start_time)/1000;
    }

    public void bubbleSort(){
        long start_time = System.nanoTime();
        boolean swapped = true;
        int size = dataSet.size();
        int temp = 0;

        for (int i = 0; i < size - 1 && swapped; i++) {
            for (int j = size - 1; j > i; j--) {
                swapped = false;
                
                if (dataSet.get(j) < dataSet.get(j - 1)) {
                    temp = dataSet.get(j);
                    // dataSet.set(j, temp );
                    dataSet.set(j, dataSet.get(j - 1));
                    dataSet.set(j - 1, temp);
                    swapped = true;
                }
            }
        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        
        // Calculate the duration and set it to time_taken.
        time_taken = (end_time - start_time)/1000;
    }

    public void insertionSort(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int size = dataSet.size();
    
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
}
