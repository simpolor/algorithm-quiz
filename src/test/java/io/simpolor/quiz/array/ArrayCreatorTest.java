package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayCreatorTest {

    @Test
    public void testCreator_1(){
        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("array : "+ Arrays.toString(array));
    }

    @Test
    public void testCreator_2(){
        String[] array = {"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("array : "+ Arrays.toString(array));
    }

    @Test
    public void testCreator_3(){
        String[] array = new String[4];
        array[0] = "나봉수";
        array[1] = "라봉팔";
        array[2] = "김형희";
        array[3] = "하지민";
        System.out.println("array : "+ Arrays.toString(array));
    }
}
