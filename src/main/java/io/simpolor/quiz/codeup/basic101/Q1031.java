package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1031 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 10진수를 입력받아 8진수로 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 10진수가 1개 입력된다.
     * (단, 입력되는 정수는 int 범위이다.)
     *
     * 10
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력 받은 10진수를 8진수로 바뀌어 출력한다.
     *
     * 12
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * %d(10진수 형태)로 입력받고,
     *
     * %o 를 사용하여 출력하면 8진수(octal)로 출력할 수 있다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        // 출력 예
        System.out.format("%o", input);
    }
}