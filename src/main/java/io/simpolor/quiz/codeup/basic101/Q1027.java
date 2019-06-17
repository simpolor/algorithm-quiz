package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1027 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 년월일을 출력하는 방법은 나라마다, 형식마다 조금씩 다르다.
     *
     * 날짜를 년월일(yyyy.mm.dd)의 형태로 입력받아,
     *
     * 일월년(dd-mm-yyyy)의 형태로 출력하는 프로그램을 작성해보자.
     *
     * (단, 한 자리 일/월은 0을 붙여 두 자리로, 년도는 0을 붙여 네 자리로 출력한다.)
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 년월일이 '.'(닷)으로 구분되어 입력된다.
     *
     * 2014.07.15
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 년월일을
     *
     * 일월년으로 바꾸어 '-'(대쉬, 마이너스)로 구분해 출력한다.
     *
     * 15-07-2014
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * 출력하는 자리수를 지정하기 위해 %4d와 같은 형식을 사용할 수 있는데,
     * 빈칸을 0으로 출력하기 위해서는 %04d와 같은 형식을 사용하면 된다.
     *
     * [예시]
     * printf("%02d-%02d-%04d", d, m, y);
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