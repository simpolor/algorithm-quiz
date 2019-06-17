package io.simpolor.quiz.replace;

import org.junit.Test;

public class StringToChar {


    @Test
    public void testToCharArray(){

        String input = "boy";

        char[] ouput = input.toCharArray();
        for(char c : ouput){
            System.out.format("'%s'%n", c);
        }
    }

    @Test
    public void testCharAt(){

        String input = "boy";

        char[] output = new char[input.length()];
        for(int i=0; i<input.length(); i++){
            output[i] = input.charAt(i);
        }

        for(int i=0; i<input.length(); i++){
            output[i] = input.charAt(i);
        }
    }
}
