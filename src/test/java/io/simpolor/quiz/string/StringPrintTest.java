package io.simpolor.quiz.string;

import org.junit.Test;

public class StringPrintTest {

    /***
     * 문자열을 루프로 출력
     */
    @Test
    public void testStringPrintBySubstring(){

        String input = "boy";

        for(int i=0; i<input.length(); i++){
            int j = i+1;
            System.out.println(input.substring(i, j));
        }
    }
}
