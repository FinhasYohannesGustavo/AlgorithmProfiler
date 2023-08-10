package FinhasProgress.src;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

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
        time_taken = end_time - start_time;

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
        time_taken = end_time - start_time;

    }

}