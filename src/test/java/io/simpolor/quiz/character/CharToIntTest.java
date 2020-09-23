package io.simpolor.quiz.character;

import org.junit.Test;

public class CharToIntTest {

    @Test
    public void testCharToInt(){

        char input = 'a';
        char input2 = 'A';

        int num = Character.getNumericValue(input); // char를 int로 바꾸는 방법 첫 번째
        int num2 = (int)input; // char를 int로 바꾸는 방법 두 번째
        int num3 = (int)input2; // 대소문자 구분

        System.out.println("> num : "+num);
        System.out.println("> num2 : "+num2);
        System.out.println("> num3 : "+num3);
    }

    /***
     * ASCII CODE TABLE
     * 0~9 : 48~57
     * A~Z : 65~90
     * a~z : 97~122
     */
}
