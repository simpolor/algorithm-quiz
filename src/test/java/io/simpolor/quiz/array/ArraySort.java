package io.simpolor.quiz.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

    public static void main(String[] args) {

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));


        sort(array);
        System.out.println("after sort : "+Arrays.toString(array));


        reverseSort(array);
        System.out.println("after reverseSort : "+Arrays.toString(array));
    }

    public static void sort(String[] array){
        Arrays.sort(array);
    }

    public static void reverseSort(String[] array){
        Arrays.sort(array, Comparator.reverseOrder());
    }
}
