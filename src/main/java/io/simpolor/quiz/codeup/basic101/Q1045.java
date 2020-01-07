package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1045 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 2개(a, b)를 입력받아 합, 차, 곱, 몫, 나머지, 나눈 값을 자동으로 계산해보자.
     * 단 0 <= a, b <= 2147483647, b는 0이 아니다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 2개가 공백을 두고 입력된다.
     *
     * 10 3
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 첫 줄에 합
     * 둘째 줄에 차,
     * 셋째 줄에 곱,
     * 넷째 줄에 몫,
     * 다섯째 줄에 나머지,
     * 여섯째 줄에 나눈 값을 순서대로 출력한다.
     * (실수, 소수점 이하 셋째 자리에서 반올림해 둘째 자리까지 출력)
     *
     * 13
     * 7
     * 30
     * 3
     * 1
     * 3.33
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        scanner.close();

        System.out.println(input1 + input2);
        System.out.println(input1 - input2);
        System.out.println(input1 * input2);
        System.out.println(input1 / input2);
        System.out.println(input1 % input2);

        float result = (float)input1 / (float)input2;
        System.out.printf("%.2f", result);

    }
}
