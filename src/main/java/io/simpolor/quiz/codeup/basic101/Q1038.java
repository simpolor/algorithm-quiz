package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1038 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 2개를 입력받아 합을 출력하는 프로그램을 작성해보자.
     * (단, 입력되는 정수는 -1073741824 ~ 1073741824 이다.)
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 2개의 정수가 공백으로 구분되어 입력된다.
     * ** 주의 : 계산의 결과가 int 범위를 넘어가는지를 잘 생각해 보아야 한다.
     *
     * 123 -123
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 두 정수의 합을 출력한다.
     *
     * 0
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long input1 = scanner.nextLong();
        long input2 = scanner.nextLong();
        scanner.close();

        System.out.println(input1 + input2);

    }
}
