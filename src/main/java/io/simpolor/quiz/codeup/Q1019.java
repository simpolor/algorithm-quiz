package io.simpolor.quiz.codeup;

import java.util.Scanner;

public class Q1019 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 년, 월, 일을 입력받아 형식에 맞게 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 년, 월, 일이 ".(닷)"으로 구분되어 입력된다.
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력받은 년, 월, 일을 출력한다. 단, 자릿수는 yyyy.mm.dd형태로 출력한다.
     * (입출력 예시 참고, %02d를 사용하면 2칸을 사용해 출력하는데, 1자리 수인 경우 앞에 0이 붙어 출력된다.)
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        // 출력 예
        System.out.format("%s", input);

    }
}
