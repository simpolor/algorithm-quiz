package io.simpolor.quiz.array;

import java.util.Arrays;

public class ArrayCreator {

    public static void main(String[] args) {

        String[] array1 = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("array1 : "+ Arrays.toString(array1));


        String[] array2 = {"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("array2 : "+ Arrays.toString(array2));


        String[] array3 = new String[4];
        array3[0] = "나봉수";
        array3[1] = "라봉팔";
        array3[2] = "김형희";
        array3[3] = "하지민";
        System.out.println("array3 : "+ Arrays.toString(array3));

    }
}
