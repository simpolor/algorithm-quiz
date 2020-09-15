package io.simpolor.quiz.list;

import org.junit.Test;

import java.util.*;

public class ListToArrayTest {

    @Test
    public void testToArray_1(){

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);

        String[] array = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }

        System.out.println("after : "+Arrays.toString(array));
    }

    @Test
    public void testToArray_2(){

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);

        String[] array = list.toArray(new String[list.size()]);
        System.out.println("after : "+Arrays.toString(array));
    }

}
