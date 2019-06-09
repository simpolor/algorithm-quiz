package io.simpolor.quiz.codeup;

import java.util.Scanner;

public class Q1014 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 두 개의 문자를 입력받은 후 순서를 바꿔 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 두 개의 문자가 공백으로 구분되어 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력한 두 문자의 순서를 바꿔 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String input2 = in.next();
        in.close();

        // %s: 문자,  %d: 정수, %f: 실수
        // 출력 예
        System.out.format("%s %s", input2, input);

    }
}
