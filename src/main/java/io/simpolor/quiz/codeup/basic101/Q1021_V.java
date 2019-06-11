package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1021_V {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 하나의 단어를 입력받아 그대로 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 한 단어가 입력된다.
     * (단, 단어의 길이는 50글자 이하이다.)
     * Informatics
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력받은 단어를 그대로 출력한다.
     * Informatics
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * 문자를 50개 저장하기 위해서는 "char data[51]" 로 선언하면 된다.
     * char data[51]; //최대 문자 개수를 51개로 설정
     * scanf("%s", data);
     * printf("%s", data);
     * 를 실행하면, data[51] 에 최대 50글자까지의 한 단어를 저장하고 출력할 수 있다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        // 출력 예
        System.out.format("%s", input.replace("-", ""));

    }
}
