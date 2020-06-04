package io.simpolor.quiz.loop;

import org.junit.Test;

public class LoopForSubstring {

    // 문자열을 루프로 출력
    @Test
    public void testSubstringFor(){

        String input = "boy";

        for(int i=0; i<input.length(); i++){
            int j = i+1;
            System.out.println(input.substring(i, j));
        }
    }
}
