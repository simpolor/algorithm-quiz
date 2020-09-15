package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {

    @Test
    public void testSort(){
        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("after : "+Arrays.toString(array));
    }

    @Test
    public void testReverseSort(){
        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println("after : "+Arrays.toString(array));
    }
}
