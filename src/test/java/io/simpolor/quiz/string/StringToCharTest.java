package io.simpolor.quiz.string;

import org.junit.Test;

import java.util.Arrays;

public class StringToCharTest {

    @Test
    public void testToCharArray(){

        String input = "boy";
        char[] output = input.toCharArray();

        System.out.println("result : "+ Arrays.toString(output));
    }

    @Test
    public void testCharAt(){

        String input = "boy";
        char[] output = new char[input.length()];

        for(int i=0; i<input.length(); i++){
            output[i] = input.charAt(i);
        }

        System.out.println("result : "+Arrays.toString(output));
    }
}
