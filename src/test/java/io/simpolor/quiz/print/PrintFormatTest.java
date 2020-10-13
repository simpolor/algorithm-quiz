package io.simpolor.quiz.print;

import org.junit.Test;

public class PrintFormatTest {

    @Test
    public void testPrintFormatByInterger(){

        int input = 10;

        System.out.format("정수출력 :  %d%n", input); // 정수 출력
        System.out.format("8진수 출력 : %o%n", input); // 8진수 출력
        System.out.format("16진수 출력 : %x%n", input); // 16진수 출력

        System.out.format("2진수 출력 : %s%n", Integer.toBinaryString(input)); // 2진수 출력
        System.out.format("8진수 출력 : %s%n", Integer.toOctalString(input)); // 8진수 출력
        System.out.format("16진수 출력 : %s%n", Integer.toHexString(input)); // 16진수 출력
    }

    @Test
    public void testPrintFormatByString(){

        String input = "simpolor";

        System.out.format("%s%n", input);
    }

}
