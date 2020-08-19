package io.simpolor.quiz.list;

import java.util.*;

public class ListToArray {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);


        String[] array1 = toArray1(list);
        System.out.println("after1 : "+Arrays.toString(array1));


        String[] array2 = toArray2(list);
        System.out.println("after2 : "+Arrays.toString(array2));
    }

    public static String[] toArray1(List<String> list){

        String[] array = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }

        return array;
    }

    public static String[] toArray2(List<String> list){

        return list.toArray(new String[list.size()]);
    }

}
