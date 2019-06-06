package io.simpolor.quiz.array;

import org.junit.Test;

public class AddInt {

    @Test
    public void testAddInt(){

        int[] problem = new int[]{1,2,3,4};

        int[] result = addInt(problem, 7);

        System.out.println("result");
        for(int i : result){
            System.out.println("> "+i);
        }
    }

    public int[] addInt(int [] series, int newInt){
        //create a new array with extra index
        int[] newSeries = new int[series.length + 1];

        //copy the integers from series to newSeries
        for (int i = 0; i < series.length; i++){
            newSeries[i] = series[i];
        }

        //add the new integer to the last index
        newSeries[newSeries.length - 1] = newInt;

        return newSeries;
    }
}
