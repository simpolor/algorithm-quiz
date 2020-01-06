package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1043 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 2개(a, b) 를 입력받아 a를 b로 나눈 나머지를 출력해보자.
     * 단, 0 <= a, b <= +2147483647, b는 0이 아니다.
     *
     * 참고
     * C언어에서 정수%정수 연산의 결과는 나눈 나머지로 계산된다.
     *
     * % 연산자(modulus, mod 연산) 수학자 가우스가 생각해낸 연산으로,
     * 어떤 정수를 다른 정수로 나누고 난 후 남는 나머지를 계산하는 연산이다.
     *
     * 단, 음(-)이 아닌 정수에 대해서만 연산된다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 2개(a, b)가 공백을 두고 입력된다.
     * 단, 0 <= a, b <= +2147483647, b는 0이 아니다.
     *
     * 10 3
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * a 를 b로 나눈 나머지를 출력한다.
     *
     * 1
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        scanner.close();

        int result = input1 % input2;
        System.out.println(result);

    }
}
