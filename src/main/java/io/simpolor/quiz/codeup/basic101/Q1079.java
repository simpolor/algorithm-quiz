package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1079 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 'q'가 입력될 때까지 입력한 문자를 계속 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 문자들이 1개씩 계속해서 입력된다.
     *
     * x b k d l q g a c
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 'q'가 입력될 때까지 입력된 문자를 줄을 바꿔 한 줄씩 출력한다.
     *
     * x
     * b
     * k
     * d
     * l
     * q
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char input;
        while(true){
            input = scanner.next().charAt(0);
            System.out.println(input);
            if(input == 'q'){
                break;
            }
        }
        scanner.close();
    }
}
