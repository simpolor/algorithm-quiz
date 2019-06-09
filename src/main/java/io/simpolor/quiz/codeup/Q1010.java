package io.simpolor.quiz.codeup;

import java.util.Scanner;

public class Q1010 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 키보드로 입력한 정수값을 그대로  출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 15
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 15
     *
     */
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(input);
        in.close();

    }
}
