package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayAddTest {

    @Test
    public void testArrayAdd(){

        String str = "배지민";
        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;

        System.out.println("after : "+Arrays.toString(newArray));
    }
}
