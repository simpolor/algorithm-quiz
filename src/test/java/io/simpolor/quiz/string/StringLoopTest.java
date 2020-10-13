package io.simpolor.quiz.string;

import org.junit.Test;

public class StringLoopTest {

    @Test
    public void testLoop(){

        String input = "boy";

        for(int i=0; i<input.length(); i++){
            System.out.println(input.substring(i, i+1));
        }
    }

}
