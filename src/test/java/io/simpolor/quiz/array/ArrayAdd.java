package io.simpolor.quiz.array;

import java.util.Arrays;

public class ArrayAdd {

    public static void main(String[] args) {

        String str = "배지민";
        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));


        String[] result = add(array, str);
        System.out.println("after : "+Arrays.toString(result));
    }

    public static String[] add(String[] array, String num){

        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = num;

        return newArray;
    }
}
