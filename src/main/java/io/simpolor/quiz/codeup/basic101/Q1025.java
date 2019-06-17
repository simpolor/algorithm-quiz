package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1025 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 다섯 자리의 정수 한 개를 입력받아 각 자리별로 구분해 출력한다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 다섯자리로 이루어진 한 개의 정수를 입력받는다.
     * (단, 10,000 <= 입력받는 수 <= 99,999 )
     *
     * 75254
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 각 자리의 수를 분리해
     * 한 줄에 하나씩 [ ]속에 넣어 출력한다.
     *
     * [70000]
     * [5000]
     * [200]
     * [50]
     * [4]
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * scanf("%1d%1d%1d%1d%1d", &a, &b, &c, &d, &e);
     * 를 사용하면 입력 받는 숫자를 1개씩 잘라 a, b, c, d, e, 변수에 저장할 수 있다.
     *
     * [예시]
     * 읽어들인 값을 형태를 바꿔 출력하기 위해
     *
     * printf("[%d]\n", a*10000);
     *
     * 과 같은 방법을 사용할 수 있다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        // 출력 예
        int tenThousand = input / 10000 * 10000;
        int thousand = input % 10000 / 1000 * 1000;
        int hundred = input % 1000 / 100 * 100;
        int ten =  input % 100 / 10 * 10;
        int one =  input % 10;

        System.out.println("[" + tenThousand + "]");
        System.out.println("[" + thousand + "]");
        System.out.println("[" + hundred + "]");
        System.out.println("[" + ten + "]");
        System.out.println("[" + one + "]");
    }
}
