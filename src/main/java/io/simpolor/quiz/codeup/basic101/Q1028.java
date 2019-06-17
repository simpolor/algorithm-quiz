package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1028 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수 한 개를 입력받아 그대로 출력해보자.
     * (단, 입력되는 정수의 범위는 0 ~ 4,294,967,295 이다.)
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 한 개가 입력된다.
     * (단, 입력되는 정수의 범위는 0 ~ 4294967295 이다.)
     *
     * 2147483648
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력된 정수가 그대로 출력된다.
     *
     * 2147483648
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * -2147483648 ~ +2147483647 범위의 정수를 저장하고 처리하기 위해서는 int 데이터형을 사용해 변수를 선언하면된다.
     * (int 로 선언하고 %d나 %i 로 입력 받거나 출력하면 된다.)
     *
     * 하지만 이 범위를 넘어가는 정수를 저장하기 위해서는 보다 큰 범위를 저장할 수 있는 다른 데이터형을 사용해야 정상적으로 저장시킬 수 있다.
     *
     * unsigned int 데이터형을 사용하면 0 ~ 4294967295 범위의 정수를 저장할 수 있다.
     *
     * [예시]
     *
     * unsigned int n;
     * scanf("%u", &n);
     * printf("%u", n);
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();

        // 출력 예
        String[] strings = input.split("\\.");
        int[] output = new int[strings.length];
        for(int i=0; i<strings.length; i++){
            output[i] = Integer.parseInt(strings[i]);
        }
        System.out.format("%02d-%02d-%04d", output[2], output[1], output[0]);
    }
}