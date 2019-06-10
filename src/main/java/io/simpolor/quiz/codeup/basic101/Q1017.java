package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1017 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수(integer) 한 개를 입력받아 3번 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수(integer) 한 개를 입력받아 3번 출력해보자.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력받은 정수를 공백으로 구분해 세 번 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        // 출력 예
        System.out.format("%d %d %d", input, input, input);

    }
}
