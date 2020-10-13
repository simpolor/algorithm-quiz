package io.simpolor.quiz.scanner;

import java.util.Scanner;

public class ScannerCharAtTest {

    public static void main(String[] args) {

        // 입력 예
        Scanner scanner = new Scanner(System.in);

        // 문자열 중 첫번째 문자를 가져옴
        char input = scanner.next().charAt(0);

        scanner.close();

        // 출력 예
        System.out.println("입력한 값 : "+input);
    }
}
