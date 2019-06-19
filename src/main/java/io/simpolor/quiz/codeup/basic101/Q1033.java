package io.simpolor.quiz.codeup.basic101;

import java.util.*;

public class Q1033 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 10진수를 입력받아 16진수(hexadecimal)로 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 10진수 1개가 입력된다.
     *
     * 255
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력 받은 10진수를 16진수로 바꾸어 출력한다.
     *
     * FF
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * %d(10진수 형태)로 입력 받고
     * %X로 출력하면 16진수(hexadecimal) 형태로 대문자로 출력된다.
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        // 출력 예
        String[] hex = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        List<Integer> bin = new ArrayList();
        do {
            bin.add(input % 16);
            input = input / 16;
        } while (input != 0);

        for(int i=bin.size()-1; 0<=i; i--){
            System.out.print(hex[bin.get(i)]);
        }
    }
}