package io.simpolor.quiz.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void testStartWith(){

        String a = "12";
        String b = "1234567";

        System.out.println(a.startsWith(b));
        System.out.println(b.startsWith(a));

        // 결과를 보면 B 문자열이 A 문자열로 시작하는지 여부 확인 메소드
    }
}
