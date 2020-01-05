package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1040 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 입력된 정수의 부호를 바꿔 출력해보자.
     * 단, -2147483647 ~ +2147483647 범위의 정수가 입력된다.
     *
     * 참고
     * 단항 연산자인 -(negative)를 변수 앞에 붙이면 부호가 반대로 바뀌어 계산된다.
     *
     * 예시
     * int a;
     * scanf("%d", &a);
     * printf("%d", -a);
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 1개가 입력된다.
     *
     * -1
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 부호를 바꿔 출력한다.
     *
     * 1
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        scanner.close();

        System.out.printf("%d", -input);

    }
}
