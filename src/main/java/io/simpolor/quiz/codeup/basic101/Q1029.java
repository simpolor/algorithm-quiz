package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1029 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 실수 한 개를 입력받아 그대로 출력해보자.
     * (단, 입력되는 실수의 범위는 +- 1.7*10^-308 ~ 1.7*10^308 이다.)
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 소수점 이하 자리수가 11개 이하인 실수 한 개가 입력된다.
     * (단, 입력되는 실수의 범위는 +- 1.7*10^-308 ~ 1.7*10^308 이다.)
     *
     * 3.14159265359
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력된 실수를 소수점 이하 11번째 자리까지 출력한다.
     *
     * 3.14159265359
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * float 데이터형을 사용하면 3.4*10^-38 ~ 3.4*10^38 범위의 실수를 저장할 수 있다.
     * (float 로 선언하고 %f로 입력 받거나 출력하면 된다.)
     *
     * 하지만 이 범위를 넘는(더 작거나 더 큰) 실수를 저장하기 위해서는
     * 보다 큰 범위를 저장할 수 있는 다른 데이터형을 사용해야 정상적으로 저장시킬 수 있다.
     *
     * 쉽게 생각하면, float 를 사용하는 것보다 double 을 사용하는 것이 좀더 정확하게 저장할 수 있다.
     * 단, 실수 1개를 저장하기 위해 필요한 기억 공간이 2배로 늘어난다.
     *
     * double 데이터형을 사용하면 1.7*10^-308 ~ 1.7*10^308 범위의 실수를 저장할 수 있다.
     *
     * [예시]
     *
     * double d;
     * scanf("%lf", &d);
     * printf("%lf", d);
     *
     * %.11lf 를 사용하면 소수점 이하 11자리까지 출력해준다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        double input = in.nextDouble();
        in.close();

        // 출력 예
        System.out.println(input);
    }
}