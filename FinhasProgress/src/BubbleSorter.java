package FinhasProgress.src;

import java.util.ArrayList;

public class BubbleSorter {
    // Field for holding the data set to be sorted.
    ArrayList<Integer> dataSet;
    
    // Variable for holding how long the sorting took.
    long time_taken;
    
    boolean swapped = true;

    public BubbleSorter(ArrayList<Integer> dataSet) {
        this.dataSet = dataSet;
    }

    void sortAscending() {

        int size = dataSet.size();
        long start_time = System.nanoTime();
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

        long end_time = System.nanoTime();
        
        // Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;
    }

}
