package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1034 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 8진수로 입력된 한 개의 정수를 10진수로 바꾸어 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 8진수 한 개가 입력된다.
     *
     * 13
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력 받은 8진수를 10진수로 바꾸어 출력한다.
     *
     * 11
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     *      * int n;
     *      * scanf("%o", &n);
     *      * printf("%d", n);
     *      *
     * (한편, C언어에서 소스 코드 작성시 0으로 시작하는 수는 8진수로 인식된다.)
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner scan = new Scanner(System.in);
        // Integer input = Integer.parseInt(scan.next(), 8);
        int input = scan.nextInt(8);
        scan.close();

        // 출력 예
        System.out.println(input);
    }

}