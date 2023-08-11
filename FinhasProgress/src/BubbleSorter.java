package FinhasProgress.src;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import FinhasProgress.src.BubbleSorter;

public class BubbleSorter {
    boolean swapped = true;
    ArrayList<Integer> dataSet;
    // Variable for holding how long the sorting took.
    long time_taken;
    int num_of_instructions = 0;

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
                    num_of_instructions++;
                }
            }
        }
        // System.out.println("Data: " + dataSet);
        long end_time = System.nanoTime();
        // Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;
    }

    void sortDescending() {
        long start_time = System.nanoTime();
        // Variable for holding the size of the array list.
        int size = dataSet.size();
        int temp = 0;
        for (int i = 0; i < size - 1 && swapped; i++) {
            for (int j = size - 1; j > i; j--) {
                swapped = false;
                if (dataSet.get(j) > dataSet.get(j - 1)) {
                    // temp = dataSet.get(j);
                    // dataSet.set(j, dataSet.get(j-1));
                    // dataSet.set(j-1, temp );
                    Collections.swap(dataSet, j - 1, j);
                    swapped = true;
                    num_of_instructions++;
                }
            }
        }
        // Variable for holding the end time.
        long end_time = System.nanoTime();
        // Calculate the duration and set it to time_taken.
        time_taken = end_time - start_time;

        time_taken = time_taken / 1000000;

        // System.out.println("Data: " + dataSet);
    }

    public static void main(String... str) {
        ArrayList<Integer> dataSet = AlgorithmProfiler_Improved.dataSetGenerator(100);
        BubbleSorter bubbleSorter = new BubbleSorter(dataSet);

        // On Average case
        System.out.println("==============================");
        System.out.println("| AVERAGE CASE SCENARIO TEST |");
        System.out.println("==============================");
        //System.out.println("Data before: " + AlgorithmProfiler_Improved.printDataSet(bubbleSorter.dataSet));
        bubbleSorter.sortAscending();
        System.out.println("Number of instructions: " + bubbleSorter.num_of_instructions);
        System.out.println("Run Time: " + bubbleSorter.time_taken);
        System.out.println("Data: " + AlgorithmProfiler_Improved.printDataSet(bubbleSorter.dataSet));

        // On Best case -> on an already sorted array.

        ArrayList<Integer> alreadySorted = bubbleSorter.dataSet;
        bubbleSorter = new BubbleSorter(alreadySorted);
        System.out.println("===========================");
        System.out.println("| BEST CASE SCENARIO TEST |");
        System.out.println("===========================");
        bubbleSorter.sortAscending();
        System.out.println("Number of instructions: " + bubbleSorter.num_of_instructions);
        System.out.println("Run Time: " + bubbleSorter.time_taken);
        System.out.println("Data: " + AlgorithmProfiler_Improved.printDataSet(bubbleSorter.dataSet));

        // On Worst case

        System.out.println("============================");
        System.out.println("| WORST CASE SCENARIO TEST |");
        System.out.println("============================");
        // bubbleSorter.sortDescending();
        ArrayList<Integer> reversed = bubbleSorter.dataSet;
        Collections.sort(reversed, Collections.reverseOrder());
        bubbleSorter = new BubbleSorter(reversed);
        bubbleSorter.sortAscending();
        System.out.println("Number of instructions: " + bubbleSorter.num_of_instructions);
        System.out.println("Run Time: " + bubbleSorter.time_taken);
        System.out.println("Data: " + AlgorithmProfiler_Improved.printDataSet(bubbleSorter.dataSet));

    }
}
