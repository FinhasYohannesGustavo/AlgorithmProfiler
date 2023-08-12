package FinhasProgress.src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.LinkedHashMap;
import java.util.Map;

public class AlgorithmProfilerTwo{

    //A class that holds all the algorithm types.
    //It has to be static to avoid creating an instance of AlgorithmProfiler to access its functions.
    static class DataSorter {
        //Field for holding the data set to be sorted.
        ArrayList<Integer> dataSet;
    
        //Variable for holding how long the sorting took.
        long time_taken;

        public DataSorter(ArrayList<Integer> dataSet){
            this.dataSet = new ArrayList<>(dataSet);
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

            int size = dataSet.size();
            
            for (int i = 0; i < size - 1; i++) {
                boolean swapped = false;

                for (int j = 0; j < size - 1 -i; j++) {
                    
                    if (dataSet.get(j) > dataSet.get(j + 1)) {
                        Collections.swap(dataSet, j, j+1);
                        swapped = true;
                    }

                }

                if(!swapped)
                    break;
            }
            
            System.out.println(AlgorithmProfiler.printDataSet(dataSet));
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

    public static void main (String...str){
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        //CODE FOR TESTING OUT THE ALGORITHMS
        
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        // Hash maps to hold the problem size vs time duration mapping for the three cases in the selection sort algorithm.
        LinkedHashMap<Integer, Long> selection_size_duration_map_best = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> selection_size_duration_map_average = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> selection_size_duration_map_worst = new LinkedHashMap<>();
        
        // Hash maps to hold the problem size vs time duration mapping for the three cases in the bubble sort algorithm.
        LinkedHashMap<Integer, Long> bubble_size_duration_map_best = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> bubble_size_duration_map_average = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> bubble_size_duration_map_worst = new LinkedHashMap<>();

        // Hash maps to hold the problem size vs time duration mapping for the three cases in the insertion sort algorithm.
        LinkedHashMap<Integer, Long> insertion_size_duration_map_best = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> insertion_size_duration_map_average = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> insertion_size_duration_map_worst = new LinkedHashMap<>();
        
        // Object for accessing all the sorting algorithms.
        DataSorter dataSorter;

        // Array list for holding the data set.
        ArrayList<Integer> dataSet;

        for(int i=1000; i<=40000; i+=1000){

            //Array list for holding the current randomly generated data set
            //to compare the three algorithms with the same data set.
            dataSet = AlgorithmProfilerTwo.dataSetGenerator(i);

            //---------------------------------------------------------------
            // Code for testing the all three algorithms in | AVERAGE | case.
            // Jumpled data set.
            //---------------------------------------------------------------
            {
                dataSorter = new DataSorter(dataSet);

                //For selection sort.
                dataSorter.selectionSort();
                selection_size_duration_map_average.put(i, dataSorter.time_taken); 
                
                //Reset to the jumpled version of the data set.
                dataSorter = new DataSorter(dataSet);
                
                // For bubble sort.
                dataSorter.bubbleSort();
                bubble_size_duration_map_average.put(i, dataSorter.time_taken); 
                
                //Reset to the jumpled version of the data set.
                dataSorter = new DataSorter(dataSet);
                
                //For insertion sort.
                dataSorter.insertionSort();
                insertion_size_duration_map_average.put(i, dataSorter.time_taken); 
            }
            //---------------------------------------------------------------
            // Code for testing the all three algorithms in | BEST | case.
            // Already sorted data set.
            //---------------------------------------------------------------
            {
                Collections.sort(dataSet);
                dataSorter = new DataSorter(dataSet);
                
                //For selection sort.
                dataSorter.selectionSort();
                selection_size_duration_map_best.put(i, dataSorter.time_taken); 
                
                // For bubble sort.
                dataSorter.bubbleSort();
                bubble_size_duration_map_best.put(i, dataSorter.time_taken); 
                
                //For insertion sort.
                dataSorter.insertionSort();
                insertion_size_duration_map_best.put(i, dataSorter.time_taken); 
            }
            
            //---------------------------------------------------------------
            // Code for testing the all three algorithms in | WORST | case.
            // Reverse-sorted data set.
            //---------------------------------------------------------------
            {
                //Reverse-sort the data set.
                Collections.sort(dataSet, Collections.reverseOrder());
                dataSorter = new DataSorter(dataSet);
                
                //For selection sort.
                dataSorter.selectionSort();
                selection_size_duration_map_worst.put(i, dataSorter.time_taken); 
                
                //Reset to the reverse-sorted version of the data set.
                dataSorter = new DataSorter(dataSet);
                
                //For bubble sort.
                dataSorter.bubbleSort();
                bubble_size_duration_map_worst.put(i, dataSorter.time_taken); 
                
                //Reset to the reverse-sorted version of the data set.
                dataSorter = new DataSorter(dataSet);
                
                //For insertion sort.
                dataSorter.insertionSort();
                insertion_size_duration_map_worst.put(i, dataSorter.time_taken); 

            }
        }

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        //CODE FOR DISPLAYING RESULTS
        
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //---------------------------------------------------------------
        //Code for displaying the results of selection sort algorithm
        //---------------------------------------------------------------
         {
            System.out.println("\n\nRESULTS ON THE SELECTION SORT ALGORITHM:");
            
            //On best case
            System.out.println("\nFor best case:");
            printLinkedHashMap(selection_size_duration_map_best);
            //On average case
            System.out.println("\nFor average case:");
            printLinkedHashMap(selection_size_duration_map_average);
            //On worst case
            System.out.println("\nFor worst case:");
            printLinkedHashMap(selection_size_duration_map_worst);

        } 
        //---------------------------------------------------------------
        //Code for displaying the results of bubble sort algorithm
        //---------------------------------------------------------------
        
        {
           System.out.println("\n\nRESULTS ON THE BUBBLE SORT ALGORITHM:");
           
           //On best case
           System.out.println("\nFor best case:");
           printLinkedHashMap(bubble_size_duration_map_best);
           //On average case
           System.out.println("\nFor average case:");
           printLinkedHashMap(bubble_size_duration_map_average);
           //On worst case
           System.out.println("\nFor worst case:");
           printLinkedHashMap(bubble_size_duration_map_worst);

        } 
       
        //---------------------------------------------------------------
        //Code for displaying the results of insertion sort algorithm
        //---------------------------------------------------------------
        {
           System.out.println("\n\nRESULTS ON THE INSERTION SORT ALGORITHM:");
           
           //On best case
           System.out.println("\nFor best case:");
           printLinkedHashMap(insertion_size_duration_map_best);
           //On average case
           System.out.println("\nFor average case:");
           printLinkedHashMap(insertion_size_duration_map_average);
           //On worst case
           System.out.println("\nFor worst case:");
           printLinkedHashMap(insertion_size_duration_map_worst);
 
        } 
    }

    //A function that generates as many random numbers as needed.
    public static ArrayList<Integer> dataSetGenerator(int quantity){
        //Array list that will contain all the random numbers
        ArrayList<Integer> to_be_returned = new ArrayList<Integer>();
        
        //Random number object for generating random numbers
        Random random_number = new Random();
        
        //Add as many random numbers to the list as is specified by 'quantity'
        for(int i=0; i<quantity; i++){
            to_be_returned.add(random_number.nextInt(1000,100000));
        }

        return to_be_returned;
    }

    //A function that prints a Linkedhashmap.
    public static void printLinkedHashMap(LinkedHashMap<Integer, Long> table){
        System.out.println("[Data size, Time taken in microseconds]");

        for(Map.Entry<Integer, Long> record : table.entrySet()){
            int data_size = record.getKey();
            long time_taken = record.getValue();

            // System.out.printf("[%d, %d]\n", data_size, time_taken);
            System.out.println(time_taken);
        }
    }

    //A function that prints an arraylist of type Integer. Used for testing purposes.
    public static String printDataSet(ArrayList<Integer> dataSet){
        String to_be_printed = "{";
        int len = dataSet.size();
        for(int i=0; i<len; i++){
            to_be_printed += String.valueOf(dataSet.get(i));
            
            if(i != len-1) to_be_printed += ", ";
        }
        to_be_printed += "}";

        return to_be_printed;
    }
}