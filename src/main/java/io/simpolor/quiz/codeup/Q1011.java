package io.simpolor.quiz.codeup;

import java.util.Scanner;

public class Q1011 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 키보드로 입력한 문자를 그대로 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 문자 한 개가 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력된 문자를 그대로 출력한다.
     *
     */
    public static void main(String[] args){

        // 입력 예
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // 출력 예
        System.out.println(input);

    }
}
