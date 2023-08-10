package FinhasProgress.src;
import java.sql.Time;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.xml.crypto.Data;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class AlgorithmProfiler{

    

    public static double ActualProfiler(ArrayList <Integer> DataSet){
        long startTime = System.nanoTime(); //we record the start time of when the sorting algorithm starts
        int size = DataSet.size();
        //This is the insertion sort algorithm
        for(int i = 1; i<size;i++){
            
            int temp = DataSet.get(i);
            int j=i;
            while(j>0&&temp<DataSet.get(j-1)){
                DataSet.set(j,DataSet.get(j-1)); //This sorting algorithm implements shifting not swapping
                j--;

            }
            DataSet.set(j,temp);
                
                
            
        }
      /*   for(int i=0;i<size;i++){
            System.out.print(DataSet.get(i)); was simply used to test out that the dataset has actually been sorted
            System.out.print(",");
        } */
        long endTime = System.nanoTime(); //we record the system time in nano seconds after the algorithm sorts the data set
        long timeInNanoSeconds= (endTime-startTime);//We subtract the two times to get duration
        return timeInNanoSeconds/1000000;//we return the duration in milliseconds

    }
    public static void main(String [] args){
        

        Random random = new Random();
        int size_of_rand = 10;
        String[] labels = new String[100];//we will use this data array as labels on x axis
        ArrayList <Double> values = new ArrayList<Double>();//these are the values we will use for the chart
        for (int i = 0; i < 100; i++) {
            labels[i] = "d" + (i + 1);
        }
        for (int i = 1; i <= 100; i++) {
            size_of_rand+=1000;//this will increase the size of each next dat set by a 1000
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < size_of_rand; j++) {
                list.add(random.nextInt(1000,10000));//adding a random number between 1000 and 10000 to the list
            }
            double timetaken = ActualProfiler(list);
            values.add(timetaken);
            System.out.println("The time taken by data set "+ i+" is: "+ timetaken+"ms");
            System.out.println();
           
        }
        //Below we create the chart to visualize the growth rate

        XYSeries series = new XYSeries("Insertion sort");
        for (int i = 0; i < values.size(); i++) {
            series.add(i + 1, values.get(i));
        }
        

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Growth Rate of insertion sort",
                "Datasets(Each iteration with a 1000 more elements than the last)",
                "Time in ms",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);

        JFrame frame = new JFrame("Insertion Sort Algorithm growth rate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 270));
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);

      
        
        
    }

}