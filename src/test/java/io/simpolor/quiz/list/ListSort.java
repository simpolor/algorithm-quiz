package io.simpolor.quiz.list;

import java.util.*;

public class ListSort {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);


        sort(list);
        System.out.println("after sort : "+list);


        reverseSort(list);
        System.out.println("after reverseSort : "+list);
    }

    public static void sort(List<String> list){

        list.sort(Comparator.naturalOrder());
    }

    public static void reverseSort(List<String> list){

        list.sort(Comparator.reverseOrder());
    }
}
