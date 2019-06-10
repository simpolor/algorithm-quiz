package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1018 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 시간이 특정 형식에 맞추어 입력될 때 그대로 출력하는 프로그램을 작성 해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 시(hour)와 분(minute)이 ":"(콜론)으로 구분되어 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력받은 시간을 "시:분"으로 출력한다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] split = input.split(":");
        in.close();

        // 출력 예
        System.out.format("%s:%s", split[0], split[1]);

    }
}
