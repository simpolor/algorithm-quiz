package io.simpolor.quiz.array;

import org.junit.Test;

public class AddInt {

    @Test
    public void testAddInt(){

        int[] arr = new int[]{1,2,3,4};

        int newInt = 5;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = newInt;

        for(int i : newArr){
            System.out.println(i);
        }
    }
}
