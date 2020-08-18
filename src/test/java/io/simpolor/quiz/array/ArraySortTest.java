package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {

    @Test
    public void testArraySort(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};

        // Arrays 는 배열에서는 사용이 가능하나, List는 사용할 수 없음, Collection을 사용해야함
        Arrays.sort(array);

        for(String s : array){
            System.out.println(s);
        }
    }

    @Test
    public void testReverseArraySort(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};

        // Arrays 는 배열에서는 사용이 가능하나, List는 사용할 수 없음, Collection을 사용해야함
        Arrays.sort(array, Comparator.reverseOrder());

        for(String s : array){
            System.out.println(s);
        }
    }
}
