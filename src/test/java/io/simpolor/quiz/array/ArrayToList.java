package io.simpolor.quiz.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToList {

    public static void main(String[] args) {

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));


        List<String> list1 = toList1(array);
        System.out.println("after1 : "+list1);


        List<String> list2 = toList2(array);
        System.out.println("after2 : "+list2);


        List<String> list3 = toList3(array);
        System.out.println("after3 : "+list3);
    }

    public static List<String> toList1(String[] array){

        return Arrays.asList(array);
    }

    public static List<String> toList2(String[] array){

        return new ArrayList<>(Arrays.asList(array));
    }

    public static List<String> toList3(String[] array){

        return new ArrayList<>(Arrays.stream(array).collect(Collectors.toList()));
    }

}
