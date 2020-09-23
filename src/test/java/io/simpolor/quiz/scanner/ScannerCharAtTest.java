package io.simpolor.quiz.scanner;

import java.util.Scanner;

public class ScannerCharAtTest {

    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        char input = in.next().charAt(0);
        in.close();

        // 출력 예
        System.out.format("%s", input);
    }
}
