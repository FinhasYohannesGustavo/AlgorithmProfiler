import java.sql.Time;
import java.util.ArrayList;

public class SelectionSorter{
    //Field for holding the data set to be sorted.
    ArrayList<double> dataSet;
    //Variable for holding how long the sorting took.
    long time_taken;

    public SelectionSorter(ArrayList<double> dataSet){
        this.dataSet = dataSet;
    }

    void sortAscending(){
        //Variable for holding the start time.
        long start_time = System.nanoTime();
        //Variable for holding the size of the array list.
        int len = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_min = 0;
        //Variable for preserving one of the values to be switched.
        int temp;

        for (int i=0; i<len-1; i++){
            index_of_min = i;

            //Look for the index of the minimum number in the unsorted part of the data set.
            for (int j=i+1; j<len; j++){
                if(dataSet[j] < dataSet[index_of_min]){
                    index_of_min = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_min != i){
                temp = dataSet[i];
                dataSet[i] = dataSet[index_of_min];
                dataSet[index_of_min] = temp;
            }

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
        int len = dataSet.size();
        //Variable for holding the index of the current minimum portion.
        int index_of_max = 0;
        //Variable for preserving one of the values to be switched.
        int temp;

        for (int i=0; i<len-1; i++){
            index_of_max = i;

            //Look for the index of the minimum number in the unsorted part of the data set.
            for (int j=i+1; j<len; j++){
                if(dataSet[j] > dataSet[index_of_max]){
                    index_of_max = j;
                }
            }

            //Only switch if the minimum index has changed.
            if(index_of_max != i){
                temp = dataSet[i];
                dataSet[i] = dataSet[index_of_max];
                dataSet[index_of_max] = temp;
            }

        }

        //Variable for holding the end time.
        long end_time = System.nanoTime();
        //Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;

    }

}