package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.Arrays;

public class ArraySortTest {

    @Test
    public void testNewString(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};

        // Array 배열에서는 사용이 가능하나, Collection, List에서는 사용할 수 없음
        Arrays.sort(array);

        for(String s : array){
            System.out.println(s);
        }
    }
}
