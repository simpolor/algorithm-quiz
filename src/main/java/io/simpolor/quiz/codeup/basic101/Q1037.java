package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1037 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 10진 정수 1개를 입력받아 아스키 문자로 출력해보자.
     * 단, 0 ~ 255 범위의 정수만 입력된다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 10진 정수 1개(0 ~ 255 범위)가 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 아스키코드 값을 문자로 출력한다.
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("값을 입력하세요 : ");
        int input = scanner.nextInt();
        scanner.close();

        System.out.println((char)input);

    }
}
