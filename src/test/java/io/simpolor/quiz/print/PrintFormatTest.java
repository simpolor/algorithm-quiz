package io.simpolor.quiz.print;

import org.junit.Test;

public class PrintFormatTest {

    @Test
    public void testPrintFormatByInterger(){

        int input = 10;

        System.out.format("%d%n", input); // 정수 출력
        System.out.format("%o%n", input); // 8진수 출력
        System.out.format("%x%n", input); // 16진수 출력

        System.out.format("%s%n", Integer.toBinaryString(input)); // 2진수 출력
        System.out.format("%s%n", Integer.toOctalString(input)); // 8진수 출력
        System.out.format("%s%n", Integer.toHexString(input)); // 16진수 출력
    }

    @Test
    public void testPrintFormatByString(){

        String input = "simpolor";

        System.out.format("%s%n", input);
    }

}
