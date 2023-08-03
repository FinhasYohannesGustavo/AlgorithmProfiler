package FinhasProgress;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.crypto.Data;



public class AlgorithmProfiler{

    

    public static double ActualProfiler(ArrayList <Integer> DataSet){
        long startTime = System.nanoTime();
        int size = DataSet.size();
        //This is the insertion sort algorithm
        for(int i = 1; i<size;i++){
            
            int temp = DataSet.get(i);
            int j=i;
            while(j>0&&temp<DataSet.get(j-1)){
                DataSet.set(j,DataSet.get(j-1));
                j--;

            }
            DataSet.set(j,temp);
                
                
            
        }
      /*   for(int i=0;i<size;i++){
            System.out.print(DataSet.get(i));
            System.out.print(",");
        } */
        long endTime = System.nanoTime();
        long timeInNanoSeconds= (endTime-startTime);
        return timeInNanoSeconds;

    }
    public static void main(String [] args){
        
        ArrayList<Integer> d1 = new ArrayList<>(Arrays.asList(254));
        ArrayList<Integer> d2 = new ArrayList<>(Arrays.asList(816, 387, 573, 913, 178, 346, 495, 672, 254, 725));
        ArrayList<Integer> d3 = new ArrayList<>(Arrays.asList(768, 352, 573, 178, 495, 913, 725, 672, 346, 816, 387, 254, 633, 972, 123, 897, 451, 657, 714, 254));
        ArrayList<Integer> d4 = new ArrayList<>(Arrays.asList(387, 768, 633, 495, 657, 816, 346, 897, 725, 352, 254, 714, 178, 913, 451, 972, 572, 123, 573, 672, 987, 254, 657, 865, 387, 346, 816, 714, 572, 633, 495, 897, 913, 123, 352, 451, 178, 725, 972, 573, 672, 865, 816, 387, 657, 254, 714));
        ArrayList<Integer> d5 = new ArrayList<>(Arrays.asList(572, 387, 913, 865, 178, 633, 352, 572, 816, 495, 714, 633, 913, 657, 254, 387, 178, 865, 495, 352, 725, 972, 123, 572, 714, 816, 451, 987, 633, 387, 897, 352, 123, 865, 633, 816, 572, 254, 497, 714, 178, 972, 657, 725, 451, 913, 495, 572, 387, 865, 633, 816, 352, 123, 897, 714, 254, 451, 497, 972, 657, 725, 178, 387, 913, 572, 633, 816, 495, 352, 123, 714, 865, 254, 897, 451));
        ArrayList<Integer> d6 = new ArrayList<>(Arrays.asList(913, 387, 352, 572, 865, 633, 816, 572, 254, 714, 497, 123, 633, 865, 178, 725, 572, 387, 913, 495, 352, 123, 816, 633, 714, 497, 865, 972, 451, 387, 572, 257, 123, 865, 633, 816, 572, 254, 714, 497, 123, 972, 657, 725, 178, 387, 913, 572, 633, 816, 352, 123, 714, 497, 254, 451, 257, 865, 657, 725, 178, 387, 913, 572, 633, 816, 352, 123, 714, 497, 254, 451, 257, 865, 657, 725, 178, 387, 913, 572, 633));
        ArrayList<ArrayList<Integer>> datasets= new ArrayList<>(Arrays.asList(d1,d2,d3,d4,d5,d6));
        int size =datasets.size();
        for (int i =0; i<size;i++){
            ArrayList<Integer> CurrentDataSet = datasets.get(i);
            double timetaken = ActualProfiler(CurrentDataSet);
            System.out.println("The time taken by "+CurrentDataSet+" is: "+ timetaken);
            System.out.println();
           

        }
        
        
    }

}