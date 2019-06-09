package io.simpolor.quiz.codeup;

import java.util.Scanner;

public class Q1012 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 키보드로 입력한 실수(소수점이 있는 수)를 그대로 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 소숫점이하가 6자리인 실수 한 개가 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력된 실수를 그대로 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        float input = in.nextFloat();
        in.close();

        // 출력 예
        System.out.format("%.6f%n", input);

    }
}
