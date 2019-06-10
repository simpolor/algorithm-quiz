package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1013 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수(integer) 두 개를 입력받아 그대로 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 두 개의 정수가 공백으로 구분되어 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력받은 두 정수를 공백으로 구분하여 그대로 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int input2 = in.nextInt();
        in.close();

        // 출력 예
        System.out.format("%d %d", input, input2);

    }
}
