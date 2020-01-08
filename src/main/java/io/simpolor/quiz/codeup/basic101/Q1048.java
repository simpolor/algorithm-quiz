package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1048 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 2개(a, b)를 입력받아 a를 2b배 곱한 값으로 출력해보자.
     * 0 <= a <= 10, 0 <= b <= 10
     *
     *
     * 참고
     * 예를 들어 1 3 이 입력되면 1을 23(8)배 하여 출력한다.
     *
     * 예시
     * int a=1, b=10;
     * printf("%d", a << b); //210 = 1024 가 출력된다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 2개가 공백을 두고 입력된다.
     * 0 <= a, b <= 10
     *
     * 1 3
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * a 를 2b배 만큼 곱한 값을 출력한다.
     *
     * 8
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        scanner.close();

        int result = input1<<input2;

        System.out.println(result);
    }
}
