package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1023 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 실수 한 개를 입력받는다.
     *
     * 입력 받은 실수를 정수 부분과 실수 부분으로 나누어 따로 출력한다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 실수 한 개가 입력된다.
     * (단, 입력 값은 절댓값이 정수부가 100,000을 넘지 않으며, 소수점 이하는 0으로 시작하지 않으며, 6자리이하이다.)
     *
     * 1.414213
     * 1232.78976
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 첫 번째 줄에 정수 부분을,
     *
     * 두 번째 줄에 실수 부분을 입력된 자릿수만큼 그대로 출력한다.
     *
     * 1
     * 414213
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * int a, b;
     * scanf("%d.%d", &a, &b);
     * 의 방법도 사용할 수 있다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        double input = in.nextDouble();
        in.close();

        // 출력 예
        String toString = Double.toString(input);
        String[] strings = toString.split("\\.");
        for(String s : strings){
            System.out.println(s);
        }
    }
}
