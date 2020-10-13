package io.simpolor.quiz.string;

import org.junit.Test;

public class StringMethodTest {

    @Test
    public void testStartWith(){

        String a = "1234567";
        String b = "12";

        // b 문자열이 a 문자열의 시작점에 포함되는지 여부
        System.out.println("result : "+a.startsWith(b));

        String c = "34";

        // c 문자열이 a 문자열의 시작점에 포함되는지 여부
        System.out.println("result : "+a.startsWith(c));

    }
}
