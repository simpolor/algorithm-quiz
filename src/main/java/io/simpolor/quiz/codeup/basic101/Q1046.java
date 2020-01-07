package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1046 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 3개를 입력받아 합과 평균을 출력해보자.
     * 단, -2147483648 ~ +2147483647
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 3개가 공백을 두고 입력된다.
     * 단, -2147483648 ~ +2147483647
     *
     * 1 2 3
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 합과 평균을 줄을 바꿔 출력한다.
     * 평균은 소수점 이하 둘째 자리에서 반올림해서 소수점 이하 첫째 자리까지 출력한다.
     *
     * 6
     * 2.0
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        int input3 = scanner.nextInt();
        scanner.close();

        int sum = input1 + input2 + input3;
        float avg = (float)sum / (float)3;

        System.out.println(sum);
        System.out.printf("%.1f", avg);
    }
}
