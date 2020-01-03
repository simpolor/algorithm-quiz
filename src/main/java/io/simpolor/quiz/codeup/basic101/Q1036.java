package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1036 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 영문자 1개를 입력받아 아스키 코드표의 10진수 값으로 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 영문자 1개가 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 아스키코드 값을 10진수로 출력한다.
     *
     * ----------------------------
     * 참고
     * ----------------------------
     * 아스키 코드는
     * (ASCII, 미국표준코드, American Standard Code for Information Interchange)
     * 영문자, 특수 문자 등을 저장할 때 사용하는 표준 코드이다.
     *
     * 컴퓨터로 저장되는 모든 데이터는 2진 정수화되어 저장되는데,
     * 영문자와 특수기호 등을 저장하는 방법으로 아스키코드가 기본적으로 사용된다.
     *
     * 예를 들어 영문 대문자 "A"는 10진수 65를 의미하는 2진수 값으로 저장된다.
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("알파뱃을 입력해주세요 : ");
        char input = in.next().charAt(0);
        in.close();

        System.out.println((int)input);
    }
}
