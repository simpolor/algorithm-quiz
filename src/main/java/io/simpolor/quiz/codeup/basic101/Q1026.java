package io.simpolor.quiz.codeup.basic101;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1026 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 시간을 시:분:초 형태로 입력 받아
     *
     * 분 만 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 시간이 [시:분:초]의 형태로 입력된다.
     *
     * 17:23:57
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 분 만 출력한다. (단, 10보다 작은 경우 불필요한 0은 출력하지 않는다.)
     *
     * 23
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     *  int h, m, s;
     * scanf("%d:%d:%d", &h, &m, &s);
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        // input = in.next("^[0-9]{2}\\:[0-9]{2}\\:[0-9]{2}$");
        String input = in.next();
        in.close();

        // 출력 예
        String[] output = input.split(":");
        System.out.println(output[1]);
    }
}