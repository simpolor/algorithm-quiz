package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1015 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 실수(float) 한 개를 입력받아 소수점 이하 3째 자리에서 반올림 하여 2째 자리까지 출력하시오.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 실수 한 개가 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력한 실수를 소수점 이하 3째 자리에서 반올림 하여 2째 자리까지 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        float input = in.nextFloat();
        in.close();

        // 출력 예
        System.out.format("%.2f%n", input);

    }
}
