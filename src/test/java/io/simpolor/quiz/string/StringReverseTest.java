package io.simpolor.quiz.string;

import org.junit.Test;

public class StringReverseTest {

    @Test
    public void testStringReverse(){

        String input = "simpolor";
        char[] array = input.toCharArray();
        System.out.println("before : " + input);

        StringBuilder output = new StringBuilder();
        for(int i=array.length-1; 0<=i; i--){
            output.append(array[i]);
        }
        System.out.println("after : " + output.toString());
    }
}
